package com.stepos.mcp.sdk.java.transport;

import android.os.IBinder;
import android.os.RemoteException;
import com.stepos.mcp.sdk.IMCPBinderCallback;
import com.stepos.mcp.sdk.IMCPBinderService;
import com.stepos.mcp.sdk.java.KLog;
import com.stepos.mcp.sdk.java.ZyMcpJson;
import io.modelcontextprotocol.json.McpJsonMapper;
import io.modelcontextprotocol.json.TypeRef;
import io.modelcontextprotocol.spec.McpError;
import io.modelcontextprotocol.spec.McpSchema;
import io.modelcontextprotocol.spec.McpServerSession;
import io.modelcontextprotocol.spec.McpServerTransport;
import io.modelcontextprotocol.spec.McpServerTransportProvider;
import io.modelcontextprotocol.spec.ProtocolVersions;
import java.lang.invoke.VarHandle;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Sinks;
import reactor.core.publisher.SynchronousSink;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class ServerTransportProvider implements McpServerTransportProvider {
    private static final String TAG = "ServerTransportProvider";
    private McpServerSession session;
    private final AtomicBoolean isClosing = new AtomicBoolean(false);
    private final Sinks.One<Void> inboundReady = Sinks.one();
    private ServerSessionTransport transport = new ServerSessionTransport();
    private final McpJsonMapper jsonMapper = ZyMcpJson.jsonMapper;

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

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public class ServerSessionTransport implements McpServerTransport {
        private final AtomicBoolean isStarted = new AtomicBoolean(false);
        private final Sinks.One<Void> outboundReady = Sinks.one();
        private ConcurrentHashMap<Object, IMCPBinderCallback> callbackMap = new ConcurrentHashMap<>();
        private ConcurrentHashMap<Object, IBinder.DeathRecipient> deathRecipientMap = new ConcurrentHashMap<>();
        public IBinder binder = new IMCPBinderService.Stub() { // from class: com.stepos.mcp.sdk.java.transport.ServerTransportProvider.ServerSessionTransport.1
            @Override // com.stepos.mcp.sdk.IMCPBinderService
            public void unregister(String str) {
            }

            @Override // com.stepos.mcp.sdk.IMCPBinderService
            public void register(String str, IMCPBinderCallback iMCPBinderCallback) {
            }

            @Override // com.stepos.mcp.sdk.IMCPBinderService
            public void request(String str, String str2) {
            }
        };
        private final Sinks.Many<McpSchema.JSONRPCMessage> inboundSink = Sinks.many().unicast().onBackpressureBuffer();
        private final Sinks.Many<McpSchema.JSONRPCMessage> outboundSink = Sinks.many().unicast().onBackpressureBuffer();
        private Scheduler inboundScheduler = Schedulers.fromExecutorService(Executors.newSingleThreadExecutor(), "server-inbound");
        private Scheduler outboundScheduler = Schedulers.fromExecutorService(Executors.newSingleThreadExecutor(), "server-outbound");

        public ServerSessionTransport() {
        }

        private void handleIncomingMessages() {
            Flux<McpSchema.JSONRPCMessage> fluxAsFlux = this.inboundSink.asFlux();
            n nVar = new n(0);
            nVar.f2760b = this;
            VarHandle.storeStoreFence();
            Flux<R> fluxFlatMap = fluxAsFlux.flatMap(nVar);
            k kVar = new k(1);
            kVar.f2753f = this;
            VarHandle.storeStoreFence();
            fluxFlatMap.doOnTerminate(kVar).subscribe();
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
            ConcurrentHashMap<Object, IMCPBinderCallback> concurrentHashMap = this.callbackMap;
            l lVar = new l(0);
            lVar.f2755f = this;
            VarHandle.storeStoreFence();
            concurrentHashMap.forEach(lVar);
            this.callbackMap.clear();
            this.deathRecipientMap.clear();
            KLog.i(ServerTransportProvider.TAG, "BinderServerTransport closed successfully");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ qd.c lambda$handleIncomingMessages$2(McpSchema.JSONRPCMessage jSONRPCMessage) {
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
        public /* synthetic */ void lambda$startOutboundProcessing$4(qd.e eVar) {
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
                String strReplace = ServerTransportProvider.this.jsonMapper.writeValueAsString(jSONRPCMessage).replace("\r\n", "\\n").replace("\n", "\\n").replace("\r", "\\n");
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
            } catch (Exception e10) {
                if (ServerTransportProvider.this.isClosing.get()) {
                    KLog.e(ServerTransportProvider.TAG, "Stream closed during shutdown " + e10);
                } else {
                    KLog.e(ServerTransportProvider.TAG, "Error writing message " + e10);
                    synchronousSink.error(new RuntimeException(e10));
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

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Flux lambda$startOutboundProcessing$9(Flux flux) {
            int i = 0;
            o oVar = new o(i);
            oVar.f2762f = this;
            VarHandle.storeStoreFence();
            Flux fluxPublishOn = flux.doOnSubscribe(oVar).publishOn(this.outboundScheduler);
            int i3 = 1;
            l lVar = new l(i3);
            lVar.f2755f = this;
            VarHandle.storeStoreFence();
            Flux fluxHandle = fluxPublishOn.handle(lVar);
            k kVar = new k(2);
            kVar.f2753f = this;
            VarHandle.storeStoreFence();
            Flux fluxDoOnComplete = fluxHandle.doOnComplete(kVar);
            o oVar2 = new o(i3);
            oVar2.f2762f = this;
            VarHandle.storeStoreFence();
            return fluxDoOnComplete.doOnError(oVar2).map(new p(i));
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
            } catch (Exception e10) {
                KLog.e(ServerTransportProvider.TAG, "Failed to linkToDeath for requestId: " + e10);
            }
        }

        private void startOutboundProcessing() {
            n nVar = new n(1);
            nVar.f2760b = this;
            VarHandle.storeStoreFence();
            ((Flux) nVar.apply(this.outboundSink.asFlux())).subscribe();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void unregisterDeathRecipient(Object obj, IMCPBinderCallback iMCPBinderCallback) {
            IBinder.DeathRecipient deathRecipientRemove = this.deathRecipientMap.remove(obj);
            if (deathRecipientRemove != null) {
                try {
                    iMCPBinderCallback.asBinder().unlinkToDeath(deathRecipientRemove, 0);
                    KLog.d(ServerTransportProvider.TAG, "Unregistered death recipient for request:" + obj);
                } catch (Exception e10) {
                    KLog.d(ServerTransportProvider.TAG, "Failed to unlinkToDeath (client might be already dead): " + e10);
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
            k kVar = new k(0);
            kVar.f2753f = this;
            VarHandle.storeStoreFence();
            return Mono.fromRunnable(kVar);
        }

        @Override // io.modelcontextprotocol.spec.McpTransport
        public Mono<Void> sendMessage(McpSchema.JSONRPCMessage jSONRPCMessage) {
            Mono<Void> monoAsMono = this.outboundReady.asMono();
            m mVar = new m(0);
            mVar.f2758g = this;
            mVar.f2757f = jSONRPCMessage;
            VarHandle.storeStoreFence();
            return monoAsMono.then(Mono.defer(mVar));
        }

        @Override // io.modelcontextprotocol.spec.McpTransport
        public <T> T unmarshalFrom(Object obj, TypeRef<T> typeRef) {
            return (T) ServerTransportProvider.this.jsonMapper.convertValue(obj, typeRef);
        }

        private void startInboundProcessing() {
        }
    }
}
