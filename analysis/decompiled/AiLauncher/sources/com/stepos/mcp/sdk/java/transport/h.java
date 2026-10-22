package com.stepos.mcp.sdk.java.transport;

import android.os.IBinder;
import android.os.RemoteException;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.mcp.sdk.IMCPBinderCallback;
import io.modelcontextprotocol.json.McpJsonMapper;
import io.modelcontextprotocol.json.TypeRef;
import io.modelcontextprotocol.spec.McpSchema;
import io.modelcontextprotocol.spec.McpServerSession;
import io.modelcontextprotocol.spec.McpServerTransport;
import io.modelcontextprotocol.spec.McpServerTransportProvider;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import q7.C5157a;
import q7.C5159c;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Sinks;

/* loaded from: classes.dex */
public class h implements McpServerTransportProvider {

    /* renamed from: c, reason: collision with root package name */
    public McpServerSession.Factory f30207c;

    /* renamed from: a, reason: collision with root package name */
    public final Map<String, McpServerSession> f30205a = new ConcurrentHashMap();

    /* renamed from: b, reason: collision with root package name */
    public final AtomicBoolean f30206b = new AtomicBoolean(false);

    /* renamed from: d, reason: collision with root package name */
    public final McpJsonMapper f30208d = C5159c.f38612a;

    /* renamed from: e, reason: collision with root package name */
    public final Map<String, IMCPBinderCallback> f30209e = new ConcurrentHashMap();

    /* renamed from: f, reason: collision with root package name */
    public final ConcurrentHashMap<String, IMCPBinderCallback> f30210f = new ConcurrentHashMap<>();

    /* renamed from: g, reason: collision with root package name */
    public final ConcurrentHashMap<String, IBinder.DeathRecipient> f30211g = new ConcurrentHashMap<>();

    /* renamed from: h, reason: collision with root package name */
    public final Sinks.One<Void> f30212h = Sinks.one();

    public class a implements IBinder.DeathRecipient {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f30213a;

        public a(String str) {
            this.f30213a = str;
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            C5157a.d("AIDLServerTransportProvider", "Client died for sessionId: " + this.f30213a);
            h.this.r(this.f30213a);
            h.this.f30211g.remove(this.f30213a);
        }
    }

    public class b implements McpServerTransport {

        /* renamed from: a, reason: collision with root package name */
        public final String f30215a;

        /* renamed from: b, reason: collision with root package name */
        public IMCPBinderCallback f30216b;

        public b(String str, IMCPBinderCallback iMCPBinderCallback) {
            this.f30215a = str;
            this.f30216b = iMCPBinderCallback;
            C5157a.a("AIDLServerTransportProvider", "Session transport initialized with aidl writer " + str);
        }

        public final void c() {
            try {
                this.f30216b = null;
                if (((McpServerSession) h.this.f30205a.remove(this.f30215a)) != null) {
                    h.this.r(this.f30215a);
                }
                C5157a.a("AIDLServerTransportProvider", "do close for session " + this.f30215a);
            } catch (Exception e10) {
                C5157a.b("AIDLServerTransportProvider", "Failed to do close for session " + e10);
            }
        }

        @Override // io.modelcontextprotocol.spec.McpTransport
        public void close() {
            C5157a.a("AIDLServerTransportProvider", "close session transport: " + this.f30215a);
            c();
        }

        @Override // io.modelcontextprotocol.spec.McpTransport
        public Mono<Void> closeGracefully() {
            return Mono.fromRunnable(new Runnable() { // from class: com.stepos.mcp.sdk.java.transport.i
                @Override // java.lang.Runnable
                public final void run() {
                    this.f30218a.d();
                }
            });
        }

        public final /* synthetic */ void d() {
            C5157a.a("AIDLServerTransportProvider", "closeGracefully session transport: " + this.f30215a);
            c();
        }

        public final /* synthetic */ void e(McpSchema.JSONRPCMessage jSONRPCMessage) {
            try {
                h.this.s(this.f30216b, h.this.f30208d.writeValueAsString(jSONRPCMessage));
                C5157a.a("AIDLServerTransportProvider", "Message sent to session " + this.f30215a);
            } catch (Exception e10) {
                C5157a.b("AIDLServerTransportProvider", "Failed to send message to session " + e10);
                close();
            }
        }

        @Override // io.modelcontextprotocol.spec.McpTransport
        public Mono<Void> sendMessage(final McpSchema.JSONRPCMessage jSONRPCMessage) {
            return Mono.fromRunnable(new Runnable() { // from class: com.stepos.mcp.sdk.java.transport.j
                @Override // java.lang.Runnable
                public final void run() {
                    this.f30219a.e(jSONRPCMessage);
                }
            });
        }

        @Override // io.modelcontextprotocol.spec.McpTransport
        public <T> T unmarshalFrom(Object obj, TypeRef<T> typeRef) {
            return (T) h.this.f30208d.convertValue(obj, typeRef);
        }
    }

    @Override // io.modelcontextprotocol.spec.McpServerTransportProviderBase
    public Mono<Void> closeGracefully() {
        this.f30206b.set(true);
        C5157a.a("AIDLServerTransportProvider", "Initiating graceful shutdown with active sessions " + this.f30205a.size());
        this.f30210f.forEach(new BiConsumer() { // from class: com.stepos.mcp.sdk.java.transport.c
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                this.f30200a.u((String) obj, (IMCPBinderCallback) obj2);
            }
        });
        this.f30210f.clear();
        this.f30211g.clear();
        return Flux.fromIterable(this.f30205a.values()).flatMap(new d()).then().doOnSuccess(new Consumer() { // from class: com.stepos.mcp.sdk.java.transport.e
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f30201a.l((Void) obj);
            }
        });
    }

    public final void k(String str, IMCPBinderCallback iMCPBinderCallback) throws RemoteException {
        this.f30205a.put(str, this.f30207c.create(new b(str, iMCPBinderCallback)));
        this.f30210f.put(str, iMCPBinderCallback);
        q(str, iMCPBinderCallback);
    }

    public final /* synthetic */ void l(Void r12) {
        this.f30205a.clear();
        C5157a.a("AIDLServerTransportProvider", "Graceful shutdown completed");
    }

    public final /* synthetic */ Mono m(String str, String str2) {
        C5157a.c("AIDLServerTransportProvider", "onRequest  inboundReady");
        McpServerSession mcpServerSession = this.f30205a.get(str);
        if (mcpServerSession == null) {
            C5157a.b("AIDLServerTransportProvider", "session null!!!please check!!!");
        }
        try {
            return mcpServerSession.handle(McpSchema.deserializeJsonRpcMessage(this.f30208d, str2));
        } catch (Exception e10) {
            e10.printStackTrace();
            return Mono.empty();
        }
    }

    public void n(String str, IMCPBinderCallback iMCPBinderCallback) throws RemoteException {
        C5157a.a("AIDLServerTransportProvider", "receive new session request: " + str);
        if (this.f30207c == null) {
            this.f30209e.put(str, iMCPBinderCallback);
        } else {
            k(str, iMCPBinderCallback);
        }
    }

    @Override // io.modelcontextprotocol.spec.McpServerTransportProviderBase
    public Mono<Void> notifyClients(final String str, final Object obj) {
        if (this.f30205a.isEmpty()) {
            C5157a.b("AIDLServerTransportProvider", "No active sessions to broadcast message to");
            return Mono.empty();
        }
        C5157a.a("AIDLServerTransportProvider", "Attempting to broadcast message to active sessions " + this.f30205a.size());
        return Flux.fromIterable(this.f30205a.values()).flatMap(new Function() { // from class: com.stepos.mcp.sdk.java.transport.a
            @Override // java.util.function.Function
            public final Object apply(Object obj2) {
                return ((McpServerSession) obj2).sendNotification(str, obj).doOnError(new Consumer() { // from class: com.stepos.mcp.sdk.java.transport.g
                    @Override // java.util.function.Consumer
                    public final void accept(Object obj3) {
                        C5157a.b("AIDLServerTransportProvider", "Failed to send message to session" + ((Throwable) obj3));
                    }
                }).onErrorComplete();
            }
        }).then();
    }

    public void o(final String str, final String str2) {
        C5157a.c("AIDLServerTransportProvider", "onRequest: " + str + Const.STR_MART_COMMA + str2);
        this.f30212h.asMono().then(Mono.defer(new Supplier() { // from class: com.stepos.mcp.sdk.java.transport.f
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.f30202a.m(str, str2);
            }
        })).subscribe();
    }

    public final void p() {
        C5157a.c("AIDLServerTransportProvider", "processPendingRequest");
        if (this.f30207c == null || this.f30209e.isEmpty()) {
            return;
        }
        C5157a.c("AIDLServerTransportProvider", "pendingRequest size:" + this.f30209e.size());
        this.f30209e.forEach(new BiConsumer() { // from class: com.stepos.mcp.sdk.java.transport.b
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) throws RemoteException {
                this.f30199a.k((String) obj, (IMCPBinderCallback) obj2);
            }
        });
        this.f30209e.clear();
    }

    public final void q(String str, IMCPBinderCallback iMCPBinderCallback) throws RemoteException {
        IBinder iBinderAsBinder = iMCPBinderCallback.asBinder();
        a aVar = new a(str);
        try {
            iBinderAsBinder.linkToDeath(aVar, 0);
            this.f30211g.put(str, aVar);
            C5157a.a("AIDLServerTransportProvider", "Registered death recipient for sessionId: " + str);
        } catch (Exception e10) {
            C5157a.b("AIDLServerTransportProvider", "Failed to linkToDeath for sessionId: " + e10);
        }
    }

    public void r(String str) {
        McpServerSession mcpServerSessionRemove = this.f30205a.remove(str);
        C5157a.a("AIDLServerTransportProvider", "removeSession: " + str + ", " + mcpServerSessionRemove);
        if (mcpServerSessionRemove != null) {
            mcpServerSessionRemove.close();
        }
        t(str);
    }

    public final void s(IMCPBinderCallback iMCPBinderCallback, String str) {
        if (iMCPBinderCallback == null || str == null) {
            return;
        }
        try {
            iMCPBinderCallback.onSuccess(str);
        } catch (Exception e10) {
            C5157a.b("AIDLServerTransportProvider", "sendEvent error: " + e10);
        }
    }

    @Override // io.modelcontextprotocol.spec.McpServerTransportProvider
    public void setSessionFactory(McpServerSession.Factory factory) {
        C5157a.c("AIDLServerTransportProvider", "into setSessionFactory");
        this.f30207c = factory;
        p();
        C5157a.c("AIDLServerTransportProvider", "set inbound ready");
        this.f30212h.tryEmitValue(null);
    }

    public final void t(String str) {
        u(str, this.f30210f.remove(str));
    }

    public final void u(String str, IMCPBinderCallback iMCPBinderCallback) {
        IBinder.DeathRecipient deathRecipientRemove = this.f30211g.remove(str);
        if (deathRecipientRemove == null || iMCPBinderCallback == null) {
            return;
        }
        try {
            iMCPBinderCallback.asBinder().unlinkToDeath(deathRecipientRemove, 0);
            C5157a.a("AIDLServerTransportProvider", "Unregistered death recipient for sessionId:" + str);
        } catch (Exception e10) {
            C5157a.a("AIDLServerTransportProvider", "Failed to unlinkToDeath (client might be already dead): " + e10);
        }
    }
}
