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
import java.time.Duration;
import java.util.UUID;
import java.util.concurrent.Executors;
import java.util.function.Function;
import java.util.function.Supplier;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Sinks;
import reactor.core.publisher.SynchronousSink;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

/* loaded from: classes3.dex */
public class AndroidClientTransport implements McpClientTransport {
    private static final Scheduler SHARED_OUTBOUND_SCHEDULER = Schedulers.fromExecutorService(Executors.newCachedThreadPool(new i()), "mcp-outbound-shared");
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
            } catch (RemoteException e) {
                e.printStackTrace();
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
            StringBuilder sb = new StringBuilder("received error response, session=");
            sb.append(AndroidClientTransport.this.sessionId);
            sb.append(", len=");
            sb.append(str == null ? -1 : str.length());
            KLog.d(AndroidClientTransport.TAG, sb.toString());
        }

        @Override // com.stepos.mcp.sdk.IMCPBinderCallback
        public void onSuccess(String str) {
            StringBuilder sb = new StringBuilder("received success response, session=");
            sb.append(AndroidClientTransport.this.sessionId);
            sb.append(", len=");
            sb.append(str == null ? -1 : str.length());
            KLog.d(AndroidClientTransport.TAG, sb.toString());
            try {
                McpSchema.JSONRPCMessage jSONRPCMessageDeserializeJsonRpcMessage = McpSchema.deserializeJsonRpcMessage(AndroidClientTransport.this.jsonMapper, str);
                if (AndroidClientTransport.this.inboundSink.tryEmitNext(jSONRPCMessageDeserializeJsonRpcMessage).isSuccess() || AndroidClientTransport.this.isClosing) {
                    return;
                }
                KLog.d(AndroidClientTransport.TAG, "failed to enqueue inbound message, session=" + AndroidClientTransport.this.sessionId + ", type=" + jSONRPCMessageDeserializeJsonRpcMessage.getClass().getSimpleName());
            } catch (Exception e) {
                if (AndroidClientTransport.this.isClosing) {
                    return;
                }
                KLog.d(AndroidClientTransport.TAG, "error processing inbound message, session=" + AndroidClientTransport.this.sessionId + ", err=" + e.getClass().getSimpleName());
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
        this.inboundSink.asFlux().flatMap(new b(1, this, function)).subscribe();
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
                    } catch (IllegalArgumentException e) {
                        KLog.d(TAG, "Service was not bound: " + e.getMessage());
                    } catch (Exception e6) {
                        KLog.e(TAG, "Error unbinding service " + e6);
                    }
                }
                this.remoteService = null;
                ToolHelper.getInstance(this.context).releaseClient(this.packageName);
                KLog.d(TAG, "Graceful shutdown completed");
            } catch (Exception e9) {
                KLog.e(TAG, "Error during graceful shutdown " + e9);
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
            } catch (RemoteException e) {
                e.printStackTrace();
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
    public /* synthetic */ Z9.c lambda$handleIncomingMessages$3(Function function, McpSchema.JSONRPCMessage jSONRPCMessage) {
        KLog.i(TAG, "handle incoming message, session=" + this.sessionId + ", type=" + jSONRPCMessage.getClass().getSimpleName());
        return Mono.just(jSONRPCMessage).transform(function).contextWrite(new o(2));
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
            KLog.i(TAG, "sending message, session=" + this.sessionId + ", len=" + strWriteValueAsString.length());
            StringBuilder sb = new StringBuilder("sending message: ");
            sb.append(this.remoteService);
            KLog.i(TAG, sb.toString());
            IMCPBinderService iMCPBinderService = this.remoteService;
            if (iMCPBinderService != null) {
                iMCPBinderService.request(this.sessionId, strWriteValueAsString);
            }
            synchronousSink.next(jSONRPCMessage);
        } catch (Exception e) {
            synchronousSink.error(new RuntimeException(e));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Flux lambda$startOutboundProcessing$6(Flux flux) {
        return flux.publishOn(this.outboundScheduler).handle(new n(this, 2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Thread lambda$static$0(Runnable runnable) {
        Thread thread = new Thread(runnable, "mcp-outbound");
        thread.setDaemon(true);
        return thread;
    }

    private void startOutboundProcessing() {
        handleOutbound(new l(this, 1));
    }

    @Override // io.modelcontextprotocol.spec.McpTransport
    public Mono<Void> closeGracefully() {
        if (this.isClosing) {
            return Mono.empty();
        }
        this.isClosing = true;
        KLog.i(TAG, "Initiating graceful shutdown");
        return Mono.defer(new Supplier() { // from class: com.stepos.mcp.sdk.java.transport.h
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.f3839a.lambda$closeGracefully$9();
            }
        }).then(Mono.fromRunnable(new g(this, 1))).then().subscribeOn(Schedulers.boundedElastic());
    }

    @Override // io.modelcontextprotocol.spec.McpClientTransport
    public Mono<Void> connect(Function<Mono<McpSchema.JSONRPCMessage>, Mono<McpSchema.JSONRPCMessage>> function) {
        bindService();
        if (this.connectServiceResult) {
            return Mono.fromRunnable(new f(this, function, 1));
        }
        McpError mcpErrorBuild = McpError.builder(10001).message("Failed to bind service: " + this.packageName).build();
        KLog.e(TAG, "bind server failed when connect: " + mcpErrorBuild.toString());
        return Mono.error(mcpErrorBuild);
    }

    public void handleOutbound(Function<Flux<McpSchema.JSONRPCMessage>, Flux<McpSchema.JSONRPCMessage>> function) {
        function.apply(this.outboundSink.asFlux()).doOnComplete(new g(this, 0)).doOnError(new d(this, 1)).subscribe();
    }

    @Override // io.modelcontextprotocol.spec.McpTransport
    public Mono<Void> sendMessage(McpSchema.JSONRPCMessage jSONRPCMessage) {
        KLog.i(TAG, "enter send message: " + this.remoteService);
        if (!this.connectServiceResult) {
            bindService();
        }
        if (this.connectServiceResult) {
            return this.outboundReady.asMono().then(Mono.defer(new k(this, jSONRPCMessage, 1)));
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
