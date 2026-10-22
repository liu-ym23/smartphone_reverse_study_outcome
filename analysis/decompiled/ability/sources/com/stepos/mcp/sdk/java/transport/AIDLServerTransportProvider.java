package com.stepos.mcp.sdk.java.transport;

import android.os.IBinder;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import com.stepos.mcp.sdk.IMCPBinderCallback;
import com.stepos.mcp.sdk.java.KLog;
import com.stepos.mcp.sdk.java.ZyMcpJson;
import io.modelcontextprotocol.json.McpJsonMapper;
import io.modelcontextprotocol.json.TypeRef;
import io.modelcontextprotocol.spec.McpSchema;
import io.modelcontextprotocol.spec.McpServerSession;
import io.modelcontextprotocol.spec.McpServerTransport;
import io.modelcontextprotocol.spec.McpServerTransportProvider;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Sinks;

/* loaded from: classes3.dex */
public class AIDLServerTransportProvider implements McpServerTransportProvider {
    private static final String TAG = "AIDLServerTransportProvider";
    private McpServerSession.Factory sessionFactory;
    private final Map<String, McpServerSession> sessions = new ConcurrentHashMap();
    private final AtomicBoolean isClosing = new AtomicBoolean(false);
    private final McpJsonMapper jsonMapper = ZyMcpJson.jsonMapper;
    private final Map<String, IMCPBinderCallback> pendingRequest = new ConcurrentHashMap();
    private final ConcurrentHashMap<String, IMCPBinderCallback> callbackMap = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, IBinder.DeathRecipient> deathRecipientMap = new ConcurrentHashMap<>();
    private final Sinks.One<Void> inboundReady = Sinks.one();

    public class Transport implements McpServerTransport {
        private final String sessionId;
        private IMCPBinderCallback writer;

        public Transport(String str, IMCPBinderCallback iMCPBinderCallback) {
            this.sessionId = str;
            this.writer = iMCPBinderCallback;
            KLog.d(AIDLServerTransportProvider.TAG, "Session transport initialized with aidl writer " + str);
        }

        private void doClose() {
            try {
                this.writer = null;
                if (((McpServerSession) AIDLServerTransportProvider.this.sessions.remove(this.sessionId)) != null) {
                    AIDLServerTransportProvider.this.removeSession(this.sessionId);
                }
                KLog.d(AIDLServerTransportProvider.TAG, "do close for session " + this.sessionId);
            } catch (Exception e) {
                KLog.e(AIDLServerTransportProvider.TAG, "Failed to do close for session " + e);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$closeGracefully$1() {
            KLog.d(AIDLServerTransportProvider.TAG, "closeGracefully session transport: " + this.sessionId);
            doClose();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$sendMessage$0(McpSchema.JSONRPCMessage jSONRPCMessage) {
            try {
                AIDLServerTransportProvider.this.sendEvent(this.writer, AIDLServerTransportProvider.this.jsonMapper.writeValueAsString(jSONRPCMessage));
                KLog.d(AIDLServerTransportProvider.TAG, "Message sent to session " + this.sessionId);
            } catch (Exception e) {
                KLog.e(AIDLServerTransportProvider.TAG, "Failed to send message to session " + e);
                lambda$closeGracefully$1();
            }
        }

        @Override // io.modelcontextprotocol.spec.McpTransport
        /* renamed from: close */
        public void lambda$closeGracefully$1() {
            KLog.d(AIDLServerTransportProvider.TAG, "close session transport: " + this.sessionId);
            doClose();
        }

        @Override // io.modelcontextprotocol.spec.McpTransport
        public Mono<Void> closeGracefully() {
            return Mono.fromRunnable(new g(this, 2));
        }

        @Override // io.modelcontextprotocol.spec.McpTransport
        public Mono<Void> sendMessage(McpSchema.JSONRPCMessage jSONRPCMessage) {
            return Mono.fromRunnable(new f(this, jSONRPCMessage, 0));
        }

        @Override // io.modelcontextprotocol.spec.McpTransport
        public <T> T unmarshalFrom(Object obj, TypeRef<T> typeRef) {
            return (T) AIDLServerTransportProvider.this.jsonMapper.convertValue(obj, typeRef);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void createSession(@NonNull String str, @NonNull IMCPBinderCallback iMCPBinderCallback) throws RemoteException {
        this.sessions.put(str, this.sessionFactory.create(new Transport(str, iMCPBinderCallback)));
        this.callbackMap.put(str, iMCPBinderCallback);
        registerDeathRecipient(str, iMCPBinderCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$closeGracefully$3(Void r1) {
        this.sessions.clear();
        KLog.d(TAG, "Graceful shutdown completed");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$notifyClients$0(Throwable th) {
        KLog.e(TAG, "Failed to send message to session" + th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Z9.c lambda$notifyClients$1(String str, Object obj, McpServerSession mcpServerSession) {
        return mcpServerSession.sendNotification(str, obj).doOnError(new a(0)).onErrorComplete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$onRequest$2(String str, String str2) {
        KLog.i(TAG, "onRequest  inboundReady");
        McpServerSession mcpServerSession = this.sessions.get(str);
        if (mcpServerSession == null) {
            KLog.e(TAG, "session null!!!please check!!!");
        }
        try {
            return mcpServerSession.handle(McpSchema.deserializeJsonRpcMessage(this.jsonMapper, str2));
        } catch (Exception e) {
            e.printStackTrace();
            return Mono.empty();
        }
    }

    private void processPendingRequest() {
        KLog.i(TAG, "processPendingRequest");
        if (this.sessionFactory == null || this.pendingRequest.isEmpty()) {
            return;
        }
        KLog.i(TAG, "pendingRequest size:" + this.pendingRequest.size());
        this.pendingRequest.forEach(new c(this, 0));
        this.pendingRequest.clear();
    }

    private void registerDeathRecipient(final String str, IMCPBinderCallback iMCPBinderCallback) throws RemoteException {
        IBinder iBinderAsBinder = iMCPBinderCallback.asBinder();
        IBinder.DeathRecipient deathRecipient = new IBinder.DeathRecipient() { // from class: com.stepos.mcp.sdk.java.transport.AIDLServerTransportProvider.1
            @Override // android.os.IBinder.DeathRecipient
            public void binderDied() {
                KLog.w(AIDLServerTransportProvider.TAG, "Client died for sessionId: " + str);
                AIDLServerTransportProvider.this.removeSession(str);
                AIDLServerTransportProvider.this.deathRecipientMap.remove(str);
            }
        };
        try {
            iBinderAsBinder.linkToDeath(deathRecipient, 0);
            this.deathRecipientMap.put(str, deathRecipient);
            KLog.d(TAG, "Registered death recipient for sessionId: " + str);
        } catch (Exception e) {
            KLog.e(TAG, "Failed to linkToDeath for sessionId: " + e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendEvent(IMCPBinderCallback iMCPBinderCallback, String str) {
        if (iMCPBinderCallback == null || str == null) {
            return;
        }
        try {
            iMCPBinderCallback.onSuccess(str);
        } catch (Exception e) {
            KLog.e(TAG, "sendEvent error: " + e);
        }
    }

    private void unregisterDeathRecipient(String str) {
        unregisterDeathRecipient(str, this.callbackMap.remove(str));
    }

    @Override // io.modelcontextprotocol.spec.McpServerTransportProviderBase
    public Mono<Void> closeGracefully() {
        this.isClosing.set(true);
        KLog.d(TAG, "Initiating graceful shutdown with active sessions " + this.sessions.size());
        int i = 1;
        this.callbackMap.forEach(new c(this, i));
        this.callbackMap.clear();
        this.deathRecipientMap.clear();
        return Flux.fromIterable(this.sessions.values()).flatMap(new o(i)).then().doOnSuccess(new d(this, 0));
    }

    public void newSession(@NonNull String str, @NonNull IMCPBinderCallback iMCPBinderCallback) throws RemoteException {
        KLog.d(TAG, "receive new session request: " + str);
        if (this.sessionFactory == null) {
            this.pendingRequest.put(str, iMCPBinderCallback);
        } else {
            createSession(str, iMCPBinderCallback);
        }
    }

    @Override // io.modelcontextprotocol.spec.McpServerTransportProviderBase
    public Mono<Void> notifyClients(String str, Object obj) {
        if (this.sessions.isEmpty()) {
            KLog.e(TAG, "No active sessions to broadcast message to");
            return Mono.empty();
        }
        KLog.d(TAG, "Attempting to broadcast message to active sessions " + this.sessions.size());
        return Flux.fromIterable(this.sessions.values()).flatMap(new b(0, str, obj)).then();
    }

    public void onRequest(String str, String str2) {
        KLog.i(TAG, "onRequest: " + str + "," + str2);
        this.inboundReady.asMono().then(Mono.defer(new e(this, str, str2, 0))).subscribe();
    }

    public void removeSession(@NonNull String str) {
        McpServerSession mcpServerSessionRemove = this.sessions.remove(str);
        KLog.d(TAG, "removeSession: " + str + ", " + mcpServerSessionRemove);
        if (mcpServerSessionRemove != null) {
            mcpServerSessionRemove.close();
        }
        unregisterDeathRecipient(str);
    }

    @Override // io.modelcontextprotocol.spec.McpServerTransportProvider
    public void setSessionFactory(McpServerSession.Factory factory) {
        KLog.i(TAG, "into setSessionFactory");
        this.sessionFactory = factory;
        processPendingRequest();
        KLog.i(TAG, "set inbound ready");
        this.inboundReady.tryEmitValue(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void unregisterDeathRecipient(String str, IMCPBinderCallback iMCPBinderCallback) {
        IBinder.DeathRecipient deathRecipientRemove = this.deathRecipientMap.remove(str);
        if (deathRecipientRemove == null || iMCPBinderCallback == null) {
            return;
        }
        try {
            iMCPBinderCallback.asBinder().unlinkToDeath(deathRecipientRemove, 0);
            KLog.d(TAG, "Unregistered death recipient for sessionId:" + str);
        } catch (Exception e) {
            KLog.d(TAG, "Failed to unlinkToDeath (client might be already dead): " + e);
        }
    }
}
