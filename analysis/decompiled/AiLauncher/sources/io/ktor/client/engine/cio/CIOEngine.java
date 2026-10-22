package io.ktor.client.engine.cio;

import Ua.C1056g;
import Ua.C1073o0;
import Ua.InterfaceC1089x;
import Ua.M;
import Y8.t;
import Z8.Y;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import io.ktor.client.engine.HttpClientEngineBase;
import io.ktor.client.engine.HttpClientEngineCapability;
import io.ktor.client.engine.ProxyConfigJvmKt;
import io.ktor.client.engine.ProxyType;
import io.ktor.client.plugins.HttpTimeoutCapability;
import io.ktor.client.plugins.sse.SSECapability;
import io.ktor.client.plugins.websocket.WebSocketCapability;
import io.ktor.client.plugins.websocket.WebSocketExtensionsCapability;
import io.ktor.client.request.UnixSocketCapability;
import io.ktor.client.request.UnixSocketSettings;
import io.ktor.http.URLProtocol;
import io.ktor.http.URLProtocolKt;
import io.ktor.http.Url;
import io.ktor.network.selector.SelectorManager;
import io.ktor.network.selector.SelectorManagerKt;
import io.ktor.util.CoroutinesUtilsKt;
import io.ktor.util.collections.ConcurrentMap;
import io.ktor.util.network.NetworkAddressJvmKt;
import java.net.Proxy;
import java.net.SocketAddress;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.d;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.g;
import p9.InterfaceC5063a;
import p9.p;

@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J1\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u00062\u000e\u0010\n\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0018\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0010H\u0096@¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR(\u0010\u001e\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u001d0\u001c0\u001b8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R \u0010$\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\r0\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010'\u001a\u00020&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010*\u001a\u00020)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0014\u0010-\u001a\u00020,8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u001a\u0010/\u001a\u00020,8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b/\u0010.\u001a\u0004\b0\u00101R\u001c\u0010\n\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u00102¨\u00063"}, d2 = {"Lio/ktor/client/engine/cio/CIOEngine;", "Lio/ktor/client/engine/HttpClientEngineBase;", "Lio/ktor/client/engine/cio/CIOEngineConfig;", "config", "<init>", "(Lio/ktor/client/engine/cio/CIOEngineConfig;)V", "Lio/ktor/http/Url;", "url", "Ljava/net/Proxy;", "Lio/ktor/client/engine/ProxyConfig;", "proxy", "Lio/ktor/client/request/UnixSocketSettings;", "unixSocket", "Lio/ktor/client/engine/cio/Endpoint;", "selectEndpoint", "(Lio/ktor/http/Url;Ljava/net/Proxy;Lio/ktor/client/request/UnixSocketSettings;)Lio/ktor/client/engine/cio/Endpoint;", "Lio/ktor/client/request/HttpRequestData;", "data", "Lio/ktor/client/request/HttpResponseData;", "execute", "(Lio/ktor/client/request/HttpRequestData;Le9/c;)Ljava/lang/Object;", "LY8/t;", "close", "()V", "Lio/ktor/client/engine/cio/CIOEngineConfig;", "getConfig", "()Lio/ktor/client/engine/cio/CIOEngineConfig;", "", "Lio/ktor/client/engine/HttpClientEngineCapability;", "", "supportedCapabilities", "Ljava/util/Set;", "getSupportedCapabilities", "()Ljava/util/Set;", "Lio/ktor/util/collections/ConcurrentMap;", "", "endpoints", "Lio/ktor/util/collections/ConcurrentMap;", "Lio/ktor/network/selector/SelectorManager;", "selectorManager", "Lio/ktor/network/selector/SelectorManager;", "Lio/ktor/client/engine/cio/ConnectionFactory;", "connectionFactory", "Lio/ktor/client/engine/cio/ConnectionFactory;", "Lkotlin/coroutines/d;", "requestsJob", "Lkotlin/coroutines/d;", "coroutineContext", "getCoroutineContext", "()Lkotlin/coroutines/d;", "Ljava/net/Proxy;", "ktor-client-cio"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CIOEngine extends HttpClientEngineBase {
    private final CIOEngineConfig config;
    private final ConnectionFactory connectionFactory;
    private final kotlin.coroutines.d coroutineContext;
    private final ConcurrentMap<String, Endpoint> endpoints;
    private final Proxy proxy;
    private final kotlin.coroutines.d requestsJob;
    private final SelectorManager selectorManager;
    private final Set<HttpClientEngineCapability<? extends Object>> supportedCapabilities;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "io.ktor.client.engine.cio.CIOEngine$1", f = "CIOEngine.kt", l = {71}, m = "invokeSuspend")
    /* renamed from: io.ktor.client.engine.cio.CIOEngine$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {
        final /* synthetic */ kotlinx.coroutines.g $requestJob;
        final /* synthetic */ SelectorManager $selector;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(kotlinx.coroutines.g gVar, SelectorManager selectorManager, InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$requestJob = gVar;
            this.$selector = selectorManager;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return new AnonymousClass1(this.$requestJob, this.$selector, interfaceC4014c);
        }

        @Override // p9.p
        public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
            return ((AnonymousClass1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r3v4, types: [Y8.t, java.lang.Object] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objG = C4063a.g();
            int i10 = this.label;
            try {
                if (i10 == 0) {
                    C4849c.b(obj);
                    kotlinx.coroutines.g gVar = this.$requestJob;
                    this.label = 1;
                    if (gVar.T0(this) == objG) {
                        return objG;
                    }
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    C4849c.b(obj);
                }
                this.$selector.close();
                this = t.f7040a;
                return this;
            } catch (Throwable th) {
                this.$selector.close();
                throw th;
            }
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ProxyType.values().length];
            try {
                iArr[ProxyType.SOCKS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ProxyType.HTTP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @InterfaceC4112d(c = "io.ktor.client.engine.cio.CIOEngine", f = "CIOEngine.kt", l = {79, 86}, m = "execute")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.ktor.client.engine.cio.CIOEngine$execute$1, reason: invalid class name and case insensitive filesystem */
    public static final class C42011 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        public C42011(InterfaceC4014c<? super C42011> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CIOEngine.this.execute(null, this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CIOEngine(CIOEngineConfig config) {
        Proxy proxy;
        super("ktor-cio");
        kotlin.jvm.internal.p.i(config, "config");
        this.config = config;
        this.supportedCapabilities = Y.j(HttpTimeoutCapability.INSTANCE, WebSocketCapability.INSTANCE, WebSocketExtensionsCapability.INSTANCE, SSECapability.INSTANCE, UnixSocketCapability.INSTANCE);
        this.endpoints = new ConcurrentMap<>(0, 1, null);
        SelectorManager SelectorManager = SelectorManagerKt.SelectorManager(getDispatcher());
        this.selectorManager = SelectorManager;
        this.connectionFactory = new ConnectionFactory(SelectorManager, getConfig().getMaxConnectionsCount(), getConfig().getEndpoint().getMaxConnectionsPerRoute());
        Proxy proxy2 = getConfig().getProxy();
        ProxyType type = proxy2 != null ? ProxyConfigJvmKt.getType(proxy2) : null;
        int i10 = type == null ? -1 : WhenMappings.$EnumSwitchMapping$0[type.ordinal()];
        if (i10 == -1 || i10 == 1) {
            proxy = null;
        } else {
            if (i10 != 2) {
                throw new IllegalStateException("CIO engine does not currently support " + type + " proxies.");
            }
            proxy = getConfig().getProxy();
        }
        this.proxy = proxy;
        kotlin.coroutines.d coroutineContext = super.getCoroutineContext();
        g.Companion companion = kotlinx.coroutines.g.INSTANCE;
        d.b bVar = coroutineContext.get(companion);
        kotlin.jvm.internal.p.f(bVar);
        kotlin.coroutines.d dVarSilentSupervisor = CoroutinesUtilsKt.SilentSupervisor((kotlinx.coroutines.g) bVar);
        this.requestsJob = dVarSilentSupervisor;
        this.coroutineContext = coroutineContext.plus(dVarSilentSupervisor);
        d.b bVar2 = dVarSilentSupervisor.get(companion);
        kotlin.jvm.internal.p.f(bVar2);
        C1056g.c(C1073o0.f6391a, coroutineContext, CoroutineStart.ATOMIC, new AnonymousClass1((kotlinx.coroutines.g) bVar2, SelectorManager, null));
    }

    private final Endpoint selectEndpoint(Url url, Proxy proxy, final UnixSocketSettings unixSocket) {
        String host;
        int port;
        final URLProtocol protocol = url.getProtocol();
        if (proxy == null) {
            proxy = Proxy_jvmKt.lookupGlobalProxy(url);
        }
        final Proxy proxy2 = proxy;
        if (proxy2 != null) {
            SocketAddress socketAddressResolveAddress = ProxyConfigJvmKt.resolveAddress(proxy2);
            host = NetworkAddressJvmKt.getHostname(socketAddressResolveAddress);
            port = NetworkAddressJvmKt.getPort(socketAddressResolveAddress);
        } else {
            host = url.getHost();
            port = url.getPort();
        }
        final int i10 = port;
        final String str = host;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append(':');
        sb2.append(i10);
        sb2.append(':');
        sb2.append(protocol);
        sb2.append(':');
        sb2.append(unixSocket != null ? unixSocket.getPath() : null);
        final String string = sb2.toString();
        return this.endpoints.computeIfAbsent((ConcurrentMap<String, Endpoint>) string, new InterfaceC5063a() { // from class: io.ktor.client.engine.cio.b
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return CIOEngine.selectEndpoint$lambda$2(protocol, str, i10, proxy2, this, unixSocket, string);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Endpoint selectEndpoint$lambda$2(URLProtocol uRLProtocol, String str, int i10, Proxy proxy, final CIOEngine cIOEngine, UnixSocketSettings unixSocketSettings, final String str2) {
        return new Endpoint(str, i10, proxy, URLProtocolKt.isSecure(uRLProtocol), cIOEngine.getConfig(), cIOEngine.connectionFactory, cIOEngine.getCoroutineContext(), new InterfaceC5063a() { // from class: io.ktor.client.engine.cio.a
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return CIOEngine.selectEndpoint$lambda$2$lambda$1(this.f33154a, str2);
            }
        }, unixSocketSettings);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final t selectEndpoint$lambda$2$lambda$1(CIOEngine cIOEngine, String str) {
        cIOEngine.endpoints.remove(str);
        return t.f7040a;
    }

    @Override // io.ktor.client.engine.HttpClientEngineBase, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        super.close();
        Iterator<Map.Entry<String, Endpoint>> it = this.endpoints.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().close();
        }
        d.b bVar = this.requestsJob.get(kotlinx.coroutines.g.INSTANCE);
        kotlin.jvm.internal.p.g(bVar, "null cannot be cast to non-null type kotlinx.coroutines.CompletableJob");
        ((InterfaceC1089x) bVar).complete();
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:37:0x00a8
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1178)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    /* JADX WARN: Removed duplicated region for block: B:33:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // io.ktor.client.engine.HttpClientEngine
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object execute(io.ktor.client.request.HttpRequestData r9, e9.InterfaceC4014c<? super io.ktor.client.request.HttpResponseData> r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof io.ktor.client.engine.cio.CIOEngine.C42011
            if (r0 == 0) goto L13
            r0 = r10
            io.ktor.client.engine.cio.CIOEngine$execute$1 r0 = (io.ktor.client.engine.cio.CIOEngine.C42011) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.ktor.client.engine.cio.CIOEngine$execute$1 r0 = new io.ktor.client.engine.cio.CIOEngine$execute$1
            r0.<init>(r10)
        L18:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L4f
            if (r2 == r4) goto L47
            if (r2 != r3) goto L3f
            java.lang.Object r9 = r0.L$3
            io.ktor.client.engine.cio.Endpoint r9 = (io.ktor.client.engine.cio.Endpoint) r9
            java.lang.Object r2 = r0.L$2
            io.ktor.client.request.UnixSocketSettings r2 = (io.ktor.client.request.UnixSocketSettings) r2
            java.lang.Object r2 = r0.L$1
            kotlin.coroutines.d r2 = (kotlin.coroutines.d) r2
            java.lang.Object r5 = r0.L$0
            io.ktor.client.request.HttpRequestData r5 = (io.ktor.client.request.HttpRequestData) r5
            kotlin.C4849c.b(r10)     // Catch: java.lang.Throwable -> L3c kotlinx.coroutines.channels.ClosedSendChannelException -> Lb8
            goto L95
        L3c:
            r10 = move-exception
            goto Laa
        L3f:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L47:
            java.lang.Object r9 = r0.L$0
            io.ktor.client.request.HttpRequestData r9 = (io.ktor.client.request.HttpRequestData) r9
            kotlin.C4849c.b(r10)
            goto L5d
        L4f:
            kotlin.C4849c.b(r10)
            r0.L$0 = r9
            r0.label = r4
            java.lang.Object r10 = io.ktor.client.engine.UtilsKt.callContext(r0)
            if (r10 != r1) goto L5d
            goto L91
        L5d:
            kotlin.coroutines.d r10 = (kotlin.coroutines.d) r10
            r5 = r9
            r2 = r10
        L61:
            kotlin.coroutines.d r9 = r8.getCoroutineContext()
            boolean r9 = Ua.C1086v0.r(r9)
            if (r9 == 0) goto Lc6
            io.ktor.client.request.UnixSocketCapability r9 = io.ktor.client.request.UnixSocketCapability.INSTANCE
            java.lang.Object r9 = r5.getCapabilityOrNull(r9)
            io.ktor.client.request.UnixSocketSettings r9 = (io.ktor.client.request.UnixSocketSettings) r9
            io.ktor.http.Url r10 = r5.getUrl()
            java.net.Proxy r6 = r8.proxy
            io.ktor.client.engine.cio.Endpoint r10 = r8.selectEndpoint(r10, r6, r9)
            r0.L$0 = r5     // Catch: java.lang.Throwable -> La3 kotlinx.coroutines.channels.ClosedSendChannelException -> La8
            r0.L$1 = r2     // Catch: java.lang.Throwable -> La3 kotlinx.coroutines.channels.ClosedSendChannelException -> La8
            java.lang.Object r9 = g9.h.a(r9)     // Catch: java.lang.Throwable -> La3 kotlinx.coroutines.channels.ClosedSendChannelException -> La8
            r0.L$2 = r9     // Catch: java.lang.Throwable -> La3 kotlinx.coroutines.channels.ClosedSendChannelException -> La8
            r0.L$3 = r10     // Catch: java.lang.Throwable -> La3 kotlinx.coroutines.channels.ClosedSendChannelException -> La8
            r0.label = r3     // Catch: java.lang.Throwable -> La3 kotlinx.coroutines.channels.ClosedSendChannelException -> La8
            java.lang.Object r9 = r10.execute(r5, r2, r0)     // Catch: java.lang.Throwable -> La3 kotlinx.coroutines.channels.ClosedSendChannelException -> La8
            if (r9 != r1) goto L92
        L91:
            return r1
        L92:
            r7 = r10
            r10 = r9
            r9 = r7
        L95:
            kotlin.coroutines.d r8 = r8.getCoroutineContext()
            boolean r8 = Ua.C1086v0.r(r8)
            if (r8 != 0) goto La2
            r9.close()
        La2:
            return r10
        La3:
            r9 = move-exception
            r7 = r10
            r10 = r9
            r9 = r7
            goto Laa
        La8:
            r9 = r10
            goto Lb8
        Laa:
            kotlin.coroutines.d r8 = r8.getCoroutineContext()
            boolean r8 = Ua.C1086v0.r(r8)
            if (r8 != 0) goto Lb7
            r9.close()
        Lb7:
            throw r10
        Lb8:
            kotlin.coroutines.d r10 = r8.getCoroutineContext()
            boolean r10 = Ua.C1086v0.r(r10)
            if (r10 != 0) goto L61
            r9.close()
            goto L61
        Lc6:
            io.ktor.client.engine.ClientEngineClosedException r8 = new io.ktor.client.engine.ClientEngineClosedException
            r9 = 0
            r8.<init>(r9, r4, r9)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.engine.cio.CIOEngine.execute(io.ktor.client.request.HttpRequestData, e9.c):java.lang.Object");
    }

    @Override // io.ktor.client.engine.HttpClientEngineBase, io.ktor.client.engine.HttpClientEngine, Ua.M
    public kotlin.coroutines.d getCoroutineContext() {
        return this.coroutineContext;
    }

    @Override // io.ktor.client.engine.HttpClientEngineBase, io.ktor.client.engine.HttpClientEngine
    public Set<HttpClientEngineCapability<? extends Object>> getSupportedCapabilities() {
        return this.supportedCapabilities;
    }

    @Override // io.ktor.client.engine.HttpClientEngine
    public CIOEngineConfig getConfig() {
        return this.config;
    }
}
