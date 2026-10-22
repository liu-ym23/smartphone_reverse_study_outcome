package com.stepos.mcp.sdk.java.transport;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.stepos.mcp.sdk.IMCPBinderCallback;
import com.stepos.mcp.sdk.IMCPBinderService;
import com.stepos.mcp.sdk.java.KLog;
import com.stepos.mcp.sdk.java.ZyMcpJson;
import com.stepos.mcp.sdk.java.client.ToolHelper;
import com.stepos.mcp.sdk.java.service.AbsMCPService;
import io.modelcontextprotocol.json.McpJsonMapper;
import io.modelcontextprotocol.json.TypeRef;
import io.modelcontextprotocol.spec.McpClientTransport;
import io.modelcontextprotocol.spec.McpError;
import io.modelcontextprotocol.spec.McpSchema;
import io.modelcontextprotocol.util.Assert;
import java.lang.invoke.VarHandle;
import java.time.Duration;
import java.util.UUID;
import java.util.concurrent.Executors;
import java.util.function.Function;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Sinks;
import reactor.core.publisher.SynchronousSink;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class AndroidClientTransport implements McpClientTransport {
    private static final Scheduler SHARED_OUTBOUND_SCHEDULER = Schedulers.fromExecutorService(Executors.newCachedThreadPool(new j()), "mcp-outbound-shared");
    private static final String TAG = "AndroidClientTransport";
    private Context context;
    private final Sinks.Many<McpSchema.JSONRPCMessage> inboundSink;
    private McpJsonMapper jsonMapper;
    private Scheduler outboundScheduler;
    private final Sinks.Many<McpSchema.JSONRPCMessage> outboundSink;
    private final String packageName;
    private IMCPBinderService remoteService;
    private final String sessionId;
    private volatile boolean isClosing = false;
    private volatile boolean connectServiceResult = true;
    private final Sinks.One<IMCPBinderService> outboundReady = Sinks.one();
    private final ServiceConnection serviceConnection = new ServiceConnection() { // from class: com.stepos.mcp.sdk.java.transport.AndroidClientTransport.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            KLog.d(AndroidClientTransport.TAG, "on Service connected: " + componentName);
            try {
                AndroidClientTransport.this.remoteService = IMCPBinderService.Stub.asInterface(iBinder);
                AndroidClientTransport androidClientTransport = AndroidClientTransport.this;
                androidClientTransport.remoteService.register(androidClientTransport.sessionId, androidClientTransport.binderCallback);
                AndroidClientTransport androidClientTransport2 = AndroidClientTransport.this;
                androidClientTransport2.outboundReady.tryEmitValue(androidClientTransport2.remoteService);
            } catch (RemoteException e10) {
                e10.printStackTrace();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            KLog.d(AndroidClientTransport.TAG, "on Service disconnected: " + componentName);
            AndroidClientTransport androidClientTransport = AndroidClientTransport.this;
            androidClientTransport.remoteService = null;
            androidClientTransport.lambda$closeGracefully$1();
        }
    };
    private final IMCPBinderCallback binderCallback = new IMCPBinderCallback.Stub() { // from class: com.stepos.mcp.sdk.java.transport.AndroidClientTransport.2
        @Override // com.stepos.mcp.sdk.IMCPBinderCallback
        public void onFailure(String str) {
            KLog.d(AndroidClientTransport.TAG, "Received error response: " + str);
        }

        @Override // com.stepos.mcp.sdk.IMCPBinderCallback
        public void onSuccess(String str) {
            KLog.d(AndroidClientTransport.TAG, "Received success response: " + str);
            try {
                McpSchema.JSONRPCMessage jSONRPCMessageDeserializeJsonRpcMessage = McpSchema.deserializeJsonRpcMessage(AndroidClientTransport.this.jsonMapper, str);
                if (AndroidClientTransport.this.inboundSink.tryEmitNext(jSONRPCMessageDeserializeJsonRpcMessage).isSuccess() || AndroidClientTransport.this.isClosing) {
                    return;
                }
                KLog.d(AndroidClientTransport.TAG, "Failed to enqueue inbound message: " + jSONRPCMessageDeserializeJsonRpcMessage);
            } catch (Exception e10) {
                if (AndroidClientTransport.this.isClosing) {
                    return;
                }
                KLog.d(AndroidClientTransport.TAG, "Error processing inbound message for line: " + str);
                KLog.d(AndroidClientTransport.TAG, "Error processing inbound message for line: " + e10);
            }
        }
    };

    public AndroidClientTransport(Context context, String str) {
        Assert.notNull(context, "The context can not be null");
        Assert.notNull(str, "The packageName can not be null");
        this.inboundSink = Sinks.many().unicast().onBackpressureBuffer();
        this.outboundSink = Sinks.many().unicast().onBackpressureBuffer();
        this.context = context;
        this.packageName = str;
        this.jsonMapper = ZyMcpJson.jsonMapper;
        this.outboundScheduler = SHARED_OUTBOUND_SCHEDULER;
        this.sessionId = UUID.randomUUID().toString();
    }

    private boolean bindService() {
        KLog.i(TAG, "trying bind to service: " + this.packageName);
        Intent intent = new Intent(AbsMCPService.MCP_SERVICE_ACTION).setPackage(this.packageName);
        Context context = this.context;
        if (context == null) {
            this.connectServiceResult = false;
        } else {
            this.connectServiceResult = context.bindService(intent, this.serviceConnection, 1);
        }
        KLog.i(TAG, "trying bind to service result: " + this.connectServiceResult);
        return this.connectServiceResult;
    }

    private void handleIncomingMessages(Function<Mono<McpSchema.JSONRPCMessage>, Mono<McpSchema.JSONRPCMessage>> function) {
        Flux<McpSchema.JSONRPCMessage> fluxAsFlux = this.inboundSink.asFlux();
        g gVar = new g(1);
        gVar.f2748b = function;
        VarHandle.storeStoreFence();
        fluxAsFlux.flatMap(gVar).subscribe();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$closeGracefully$10() {
        try {
            try {
                Context context = this.context;
                if (context != null) {
                    try {
                        context.unbindService(this.serviceConnection);
                        KLog.d(TAG, "Service unbound successfully");
                    } catch (IllegalArgumentException e10) {
                        KLog.d(TAG, "Service was not bound: " + e10.getMessage());
                    } catch (Exception e11) {
                        KLog.e(TAG, "Error unbinding service " + e11);
                    }
                }
                this.remoteService = null;
                ToolHelper.getInstance(this.context).releaseClient(this.packageName);
                KLog.d(TAG, "Graceful shutdown completed");
            } catch (Exception e12) {
                KLog.e(TAG, "Error during graceful shutdown " + e12);
            }
        } finally {
            this.context = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$closeGracefully$9() {
        this.inboundSink.tryEmitComplete();
        this.outboundSink.tryEmitComplete();
        IMCPBinderService iMCPBinderService = this.remoteService;
        if (iMCPBinderService != null) {
            try {
                iMCPBinderService.unregister(this.sessionId);
            } catch (RemoteException e10) {
                e10.printStackTrace();
            }
        }
        return Mono.delay(Duration.ofMillis(100L)).then();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$connect$1(Function function) {
        KLog.i(TAG, "try connect to MCP server.");
        handleIncomingMessages(function);
        startOutboundProcessing();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ reactor.util.context.Context lambda$handleIncomingMessages$2(reactor.util.context.Context context) {
        return context.put("observation", "myObservation");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ qd.c lambda$handleIncomingMessages$3(Function function, McpSchema.JSONRPCMessage jSONRPCMessage) {
        KLog.i(TAG, "handle Incoming Messages: " + jSONRPCMessage);
        return Mono.just(jSONRPCMessage).transform(function).contextWrite(new p(2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleOutbound$7() {
        this.isClosing = true;
        this.outboundSink.tryEmitComplete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleOutbound$8(Throwable th) {
        if (this.isClosing) {
            return;
        }
        KLog.e(TAG, "Error in outbound processing " + th);
        this.isClosing = true;
        this.outboundSink.tryEmitComplete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$sendMessage$4(McpSchema.JSONRPCMessage jSONRPCMessage) {
        KLog.i(TAG, "outbound ready, try emit.");
        return this.outboundSink.tryEmitNext(jSONRPCMessage).isSuccess() ? Mono.empty() : Mono.error(new RuntimeException("Failed to enqueue message"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startOutboundProcessing$5(McpSchema.JSONRPCMessage jSONRPCMessage, SynchronousSink synchronousSink) {
        if (jSONRPCMessage == null || this.isClosing) {
            return;
        }
        try {
            String strWriteValueAsString = this.jsonMapper.writeValueAsString(jSONRPCMessage);
            KLog.i(TAG, "sending message: " + strWriteValueAsString);
            KLog.i(TAG, "sending message: " + this.remoteService);
            IMCPBinderService iMCPBinderService = this.remoteService;
            if (iMCPBinderService != null) {
                iMCPBinderService.request(this.sessionId, strWriteValueAsString);
            }
            synchronousSink.next(jSONRPCMessage);
        } catch (Exception e10) {
            synchronousSink.error(new RuntimeException(e10));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Flux lambda$startOutboundProcessing$6(Flux flux) {
        Flux fluxPublishOn = flux.publishOn(this.outboundScheduler);
        l lVar = new l(2);
        lVar.f2755f = this;
        VarHandle.storeStoreFence();
        return fluxPublishOn.handle(lVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Thread lambda$static$0(Runnable runnable) {
        Thread thread = new Thread(runnable, "mcp-outbound");
        thread.setDaemon(true);
        return thread;
    }

    private void startOutboundProcessing() {
        g gVar = new g(0);
        gVar.f2748b = this;
        VarHandle.storeStoreFence();
        handleOutbound(gVar);
    }

    @Override // io.modelcontextprotocol.spec.McpTransport
    public Mono<Void> closeGracefully() {
        if (this.isClosing) {
            return Mono.empty();
        }
        this.isClosing = true;
        KLog.i(TAG, "Initiating graceful shutdown");
        i iVar = new i();
        iVar.f2751c = this;
        VarHandle.storeStoreFence();
        Mono monoDefer = Mono.defer(iVar);
        h hVar = new h(1);
        hVar.f2750f = this;
        VarHandle.storeStoreFence();
        return monoDefer.then(Mono.fromRunnable(hVar)).then().subscribeOn(Schedulers.boundedElastic());
    }

    @Override // io.modelcontextprotocol.spec.McpClientTransport
    public Mono<Void> connect(Function<Mono<McpSchema.JSONRPCMessage>, Mono<McpSchema.JSONRPCMessage>> function) {
        bindService();
        if (this.connectServiceResult) {
            f fVar = new f(1);
            fVar.f2745f = this;
            fVar.f2746g = function;
            VarHandle.storeStoreFence();
            return Mono.fromRunnable(fVar);
        }
        McpError mcpErrorBuild = McpError.builder(10001).message("Failed to bind service: " + this.packageName).build();
        KLog.e(TAG, "bind server failed when connect: " + mcpErrorBuild.toString());
        return Mono.error(mcpErrorBuild);
    }

    public void handleOutbound(Function<Flux<McpSchema.JSONRPCMessage>, Flux<McpSchema.JSONRPCMessage>> function) {
        Flux<McpSchema.JSONRPCMessage> fluxApply = function.apply(this.outboundSink.asFlux());
        h hVar = new h(0);
        hVar.f2750f = this;
        VarHandle.storeStoreFence();
        Flux<McpSchema.JSONRPCMessage> fluxDoOnComplete = fluxApply.doOnComplete(hVar);
        d dVar = new d(1);
        dVar.f2739f = this;
        VarHandle.storeStoreFence();
        fluxDoOnComplete.doOnError(dVar).subscribe();
    }

    @Override // io.modelcontextprotocol.spec.McpTransport
    public Mono<Void> sendMessage(McpSchema.JSONRPCMessage jSONRPCMessage) {
        KLog.i(TAG, "enter send message: " + this.remoteService);
        if (!this.connectServiceResult) {
            bindService();
        }
        if (this.connectServiceResult) {
            Mono<IMCPBinderService> monoAsMono = this.outboundReady.asMono();
            m mVar = new m(1);
            mVar.f2758g = this;
            mVar.f2757f = jSONRPCMessage;
            VarHandle.storeStoreFence();
            return monoAsMono.then(Mono.defer(mVar));
        }
        McpError mcpErrorBuild = McpError.builder(10001).message("Failed to bind service: " + this.packageName).build();
        KLog.e(TAG, "bind server failed when connect: " + mcpErrorBuild.toString());
        return Mono.error(mcpErrorBuild);
    }

    @Override // io.modelcontextprotocol.spec.McpTransport
    public <T> T unmarshalFrom(Object obj, TypeRef<T> typeRef) {
        return (T) this.jsonMapper.convertValue(obj, typeRef);
    }
}
