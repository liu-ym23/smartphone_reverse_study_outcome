package com.stepos.mcp.sdk.java.transport;

import android.os.IBinder;
import android.os.RemoteException;
import com.stepos.mcp.sdk.IMCPBinderCallback;
import com.stepos.mcp.sdk.IMCPBinderService;
import com.stepos.mcp.sdk.java.KLog;
import com.stepos.mcp.sdk.java.ZyMcpJson;
import com.stepos.mcp.sdk.java.transport.ServerTransportProvider;
import io.modelcontextprotocol.json.McpJsonMapper;
import io.modelcontextprotocol.json.TypeRef;
import io.modelcontextprotocol.spec.McpError;
import io.modelcontextprotocol.spec.McpSchema;
import io.modelcontextprotocol.spec.McpServerSession;
import io.modelcontextprotocol.spec.McpServerTransport;
import io.modelcontextprotocol.spec.McpServerTransportProvider;
import io.modelcontextprotocol.spec.ProtocolVersions;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Consumer;
import org.json.HTTP;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Sinks;
import reactor.core.publisher.SynchronousSink;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

/* loaded from: classes3.dex */
public class ServerTransportProvider implements McpServerTransportProvider {
    private static final String TAG = "ServerTransportProvider";
    private McpServerSession session;
    private final AtomicBoolean isClosing = new AtomicBoolean(false);
    private final Sinks.One<Void> inboundReady = Sinks.one();
    private ServerSessionTransport transport = new ServerSessionTransport();
    private final McpJsonMapper jsonMapper = ZyMcpJson.jsonMapper;

    public class ServerSessionTransport implements McpServerTransport {
        private final AtomicBoolean isStarted = new AtomicBoolean(false);
        private final Sinks.One<Void> outboundReady = Sinks.one();
        private ConcurrentHashMap<Object, IMCPBinderCallback> callbackMap = new ConcurrentHashMap<>();
        private ConcurrentHashMap<Object, IBinder.DeathRecipient> deathRecipientMap = new ConcurrentHashMap<>();
        public IBinder binder = new IMCPBinderService.Stub() { // from class: com.stepos.mcp.sdk.java.transport.ServerTransportProvider.ServerSessionTransport.1
            @Override // com.stepos.mcp.sdk.IMCPBinderService
            public void register(String str, IMCPBinderCallback iMCPBinderCallback) {
            }

            @Override // com.stepos.mcp.sdk.IMCPBinderService
            public void request(String str, String str2) {
            }

            @Override // com.stepos.mcp.sdk.IMCPBinderService
            public void unregister(String str) {
            }
        };
        private final Sinks.Many<McpSchema.JSONRPCMessage> inboundSink = Sinks.many().unicast().onBackpressureBuffer();
        private final Sinks.Many<McpSchema.JSONRPCMessage> outboundSink = Sinks.many().unicast().onBackpressureBuffer();
        private Scheduler inboundScheduler = Schedulers.fromExecutorService(Executors.newSingleThreadExecutor(), "server-inbound");
        private Scheduler outboundScheduler = Schedulers.fromExecutorService(Executors.newSingleThreadExecutor(), "server-outbound");

        public ServerSessionTransport() {
        }

        private void handleIncomingMessages() {
            this.inboundSink.asFlux().flatMap(new l(this, 0)).doOnTerminate(new j(this, 1)).subscribe();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void initProcessing() {
            handleIncomingMessages();
            startInboundProcessing();
            startOutboundProcessing();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$closeGracefully$1() {
            ServerTransportProvider.this.isClosing.set(true);
            KLog.i(ServerTransportProvider.TAG, "Session transport closing gracefully");
            this.inboundSink.tryEmitComplete();
            this.callbackMap.forEach(new n(this, 1));
            this.callbackMap.clear();
            this.deathRecipientMap.clear();
            KLog.i(ServerTransportProvider.TAG, "BinderServerTransport closed successfully");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Z9.c lambda$handleIncomingMessages$2(McpSchema.JSONRPCMessage jSONRPCMessage) {
            return ServerTransportProvider.this.session.handle(jSONRPCMessage);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$handleIncomingMessages$3() {
            this.outboundSink.tryEmitComplete();
            this.inboundScheduler.dispose();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Mono lambda$sendMessage$0(McpSchema.JSONRPCMessage jSONRPCMessage) {
            return this.outboundSink.tryEmitNext(jSONRPCMessage).isSuccess() ? Mono.empty() : Mono.error(new RuntimeException("Failed to enqueue message"));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$startOutboundProcessing$4(Z9.e eVar) {
            this.outboundReady.tryEmitValue(null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$startOutboundProcessing$5(McpSchema.JSONRPCMessage jSONRPCMessage, SynchronousSink synchronousSink) {
            if (jSONRPCMessage == null || ServerTransportProvider.this.isClosing.get()) {
                if (ServerTransportProvider.this.isClosing.get()) {
                    synchronousSink.complete();
                    return;
                }
                return;
            }
            try {
                String strReplace = ServerTransportProvider.this.jsonMapper.writeValueAsString(jSONRPCMessage).replace(HTTP.CRLF, "\\n").replace("\n", "\\n").replace("\r", "\\n");
                KLog.d(ServerTransportProvider.TAG, "Sending response: " + strReplace);
                Object messageId = ServerTransportProvider.this.getMessageId(jSONRPCMessage);
                KLog.d(ServerTransportProvider.TAG, "Sending response for id: " + messageId);
                if (messageId != null) {
                    IMCPBinderCallback iMCPBinderCallbackRemove = this.callbackMap.remove(messageId);
                    KLog.d(ServerTransportProvider.TAG, "Sending response with callback: " + iMCPBinderCallbackRemove);
                    if (iMCPBinderCallbackRemove != null) {
                        iMCPBinderCallbackRemove.onSuccess(strReplace);
                        unregisterDeathRecipient(messageId, iMCPBinderCallbackRemove);
                    }
                } else {
                    KLog.w(ServerTransportProvider.TAG, "Sending response fail because id is null");
                }
                synchronousSink.next(jSONRPCMessage);
            } catch (Exception e) {
                if (ServerTransportProvider.this.isClosing.get()) {
                    KLog.e(ServerTransportProvider.TAG, "Stream closed during shutdown " + e);
                } else {
                    KLog.e(ServerTransportProvider.TAG, "Error writing message " + e);
                    synchronousSink.error(new RuntimeException(e));
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$startOutboundProcessing$6() {
            ServerTransportProvider.this.isClosing.set(true);
            this.outboundScheduler.dispose();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$startOutboundProcessing$7(Throwable th) {
            if (ServerTransportProvider.this.isClosing.get()) {
                return;
            }
            KLog.e(ServerTransportProvider.TAG, "Error in outbound processing " + th);
            ServerTransportProvider.this.isClosing.set(true);
            this.outboundScheduler.dispose();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ McpSchema.JSONRPCMessage lambda$startOutboundProcessing$8(Object obj) {
            return (McpSchema.JSONRPCMessage) obj;
        }

        private /* synthetic */ Flux lambda$startOutboundProcessing$9(Flux flux) {
            final int i = 0;
            Flux fluxDoOnComplete = flux.doOnSubscribe(new Consumer(this) { // from class: com.stepos.mcp.sdk.java.transport.m
                public final /* synthetic */ ServerTransportProvider.ServerSessionTransport b;

                {
                    this.b = this;
                }

                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    int i6 = i;
                    ServerTransportProvider.ServerSessionTransport serverSessionTransport = this.b;
                    switch (i6) {
                        case 0:
                            serverSessionTransport.lambda$startOutboundProcessing$4((Z9.e) obj);
                            break;
                        default:
                            serverSessionTransport.lambda$startOutboundProcessing$7((Throwable) obj);
                            break;
                    }
                }
            }).publishOn(this.outboundScheduler).handle(new n(this, i)).doOnComplete(new j(this, 2));
            final int i6 = 1;
            return fluxDoOnComplete.doOnError(new Consumer(this) { // from class: com.stepos.mcp.sdk.java.transport.m
                public final /* synthetic */ ServerTransportProvider.ServerSessionTransport b;

                {
                    this.b = this;
                }

                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    int i62 = i6;
                    ServerTransportProvider.ServerSessionTransport serverSessionTransport = this.b;
                    switch (i62) {
                        case 0:
                            serverSessionTransport.lambda$startOutboundProcessing$4((Z9.e) obj);
                            break;
                        default:
                            serverSessionTransport.lambda$startOutboundProcessing$7((Throwable) obj);
                            break;
                    }
                }
            }).map(new o(0));
        }

        private void logIfNotClosing(String str, Exception exc) {
            if (ServerTransportProvider.this.isClosing.get()) {
                return;
            }
            KLog.e(ServerTransportProvider.TAG, str + "," + exc);
        }

        private void registerDeathRecipient(final Object obj, IMCPBinderCallback iMCPBinderCallback) throws RemoteException {
            IBinder iBinderAsBinder = iMCPBinderCallback.asBinder();
            IBinder.DeathRecipient deathRecipient = new IBinder.DeathRecipient() { // from class: com.stepos.mcp.sdk.java.transport.ServerTransportProvider.ServerSessionTransport.2
                @Override // android.os.IBinder.DeathRecipient
                public void binderDied() {
                    KLog.w(ServerTransportProvider.TAG, "Client died for request ID: " + obj);
                    ServerSessionTransport.this.callbackMap.remove(obj);
                    ServerSessionTransport.this.deathRecipientMap.remove(obj);
                }
            };
            try {
                iBinderAsBinder.linkToDeath(deathRecipient, 0);
                this.deathRecipientMap.put(obj, deathRecipient);
                KLog.d(ServerTransportProvider.TAG, "Registered death recipient for request: " + obj);
            } catch (Exception e) {
                KLog.e(ServerTransportProvider.TAG, "Failed to linkToDeath for requestId: " + e);
            }
        }

        private void startInboundProcessing() {
        }

        private void startOutboundProcessing() {
            lambda$startOutboundProcessing$9(this.outboundSink.asFlux()).subscribe();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void unregisterDeathRecipient(Object obj, IMCPBinderCallback iMCPBinderCallback) {
            IBinder.DeathRecipient deathRecipientRemove = this.deathRecipientMap.remove(obj);
            if (deathRecipientRemove != null) {
                try {
                    iMCPBinderCallback.asBinder().unlinkToDeath(deathRecipientRemove, 0);
                    KLog.d(ServerTransportProvider.TAG, "Unregistered death recipient for request:" + obj);
                } catch (Exception e) {
                    KLog.d(ServerTransportProvider.TAG, "Failed to unlinkToDeath (client might be already dead): " + e);
                }
            }
        }

        @Override // io.modelcontextprotocol.spec.McpTransport
        /* renamed from: close */
        public void lambda$closeGracefully$1() {
            ServerTransportProvider.this.isClosing.set(true);
            KLog.i(ServerTransportProvider.TAG, "Session transport closed");
        }

        @Override // io.modelcontextprotocol.spec.McpTransport
        public Mono<Void> closeGracefully() {
            return Mono.fromRunnable(new j(this, 0));
        }

        @Override // io.modelcontextprotocol.spec.McpTransport
        public Mono<Void> sendMessage(McpSchema.JSONRPCMessage jSONRPCMessage) {
            return this.outboundReady.asMono().then(Mono.defer(new k(this, jSONRPCMessage, 0)));
        }

        @Override // io.modelcontextprotocol.spec.McpTransport
        public <T> T unmarshalFrom(Object obj, TypeRef<T> typeRef) {
            return (T) ServerTransportProvider.this.jsonMapper.convertValue(obj, typeRef);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object getMessageId(McpSchema.JSONRPCMessage jSONRPCMessage) {
        if (jSONRPCMessage != null) {
            return jSONRPCMessage instanceof McpSchema.JSONRPCResponse ? ((McpSchema.JSONRPCResponse) jSONRPCMessage).id() : jSONRPCMessage instanceof McpSchema.JSONRPCRequest ? ((McpSchema.JSONRPCRequest) jSONRPCMessage).id() : null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$notifyClients$0(Throwable th) {
        KLog.e(TAG, "Failed to send notification: " + th);
    }

    @Override // io.modelcontextprotocol.spec.McpServerTransportProviderBase
    public Mono<Void> closeGracefully() {
        McpServerSession mcpServerSession = this.session;
        return mcpServerSession == null ? Mono.empty() : mcpServerSession.closeGracefully();
    }

    public IBinder getBinder() {
        ServerSessionTransport serverSessionTransport = this.transport;
        if (serverSessionTransport != null) {
            return serverSessionTransport.binder;
        }
        return null;
    }

    @Override // io.modelcontextprotocol.spec.McpServerTransportProviderBase
    public Mono<Void> notifyClients(String str, Object obj) {
        McpServerSession mcpServerSession = this.session;
        return mcpServerSession == null ? Mono.error(new McpError("No session to close")) : mcpServerSession.sendNotification(str, obj).doOnError(new a(1));
    }

    @Override // io.modelcontextprotocol.spec.McpServerTransportProviderBase
    public List<String> protocolVersions() {
        return List.of(ProtocolVersions.MCP_2024_11_05);
    }

    public void serviceReady() {
        this.inboundReady.tryEmitValue(null);
    }

    @Override // io.modelcontextprotocol.spec.McpServerTransportProvider
    public void setSessionFactory(McpServerSession.Factory factory) {
        KLog.i(TAG, "setSessionFactory call");
        this.session = factory.create(this.transport);
        this.transport.initProcessing();
    }
}
