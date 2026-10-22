package com.bytedance.safetyguard.lxc.internal.service;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.ParcelFileDescriptor;
import com.bytedance.safetyguard.lxc.api.OutboundPolicyEvaluator;
import com.bytedance.safetyguard.lxc.api.SidecarAuthHandler;
import com.bytedance.safetyguard.lxc.api.sidecar.SafetyGuardSidecar;
import com.bytedance.safetyguard.lxc.internal.ipc.IProxyClientCallback;
import com.bytedance.safetyguard.lxc.internal.ipc.ProxyAttachRequestParcel;
import com.bytedance.safetyguard.lxc.internal.ipc.ProxyServiceConfigParcel;
import com.bytedance.safetyguard.lxc.internal.ipc.ProxySessionResultParcel;
import com.volcengine.zeus.service.PluginService;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SafetyGuardProxyService.kt */
/* JADX INFO: loaded from: classes.dex */
public final class SafetyGuardProxyService extends PluginService {
    private static final a Companion = null;

    @Deprecated
    public static final String SERVICE_SKELETON_MESSAGE = "Proxy service backend is not initialized";
    private static final ad UnavailableProxySessionFactory = null;
    private g clients;
    private final d.f defaultProxySessionFactory$delegate;
    private t proxyFdKeyResolver;
    private ad proxySessionFactory;
    private x proxySessions;
    private final SafetyGuardProxyService$serviceBinder$1 serviceBinder;
    private final d.f serviceLogger$delegate;
    private ag sidecarFactory;
    private ai sidecarHost;
    private final Object sidecarHostLock;

    /* JADX INFO: compiled from: SafetyGuardProxyService.kt */
    private static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: SafetyGuardProxyService.kt */
    public static final class b implements ac {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ af f10922a;

        @Override // com.bytedance.safetyguard.lxc.internal.service.ac
        public void b() {
        }

        b(af r3) {
            this.f10922a = (af) ZeusTransformUtils.wrapperContextForParams(r3, af.class, "com.obric.aiagent.plugin");
        }

        @Override // com.bytedance.safetyguard.lxc.internal.service.ac
        public void a() {
            this.f10922a.a(new ProxySessionResultParcel(0, "internal", 7, 11, SafetyGuardProxyService.SERVICE_SKELETON_MESSAGE, 0, 0, 0, 0, null, null, 2017, null));
        }
    }

    /* JADX INFO: compiled from: SafetyGuardProxyService.kt */
    static final class c extends d.h.b.p implements d.h.a.a<com.bytedance.safetyguard.lxc.internal.service.c> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ SafetyGuardProxyService f10923a;

        /* JADX INFO: renamed from: com.bytedance.safetyguard.lxc.internal.service.SafetyGuardProxyService$c$1, reason: invalid class name */
        /* JADX INFO: compiled from: SafetyGuardProxyService.kt */
        static final class AnonymousClass1 extends d.h.b.p implements d.h.a.a<SidecarAuthHandler> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ SafetyGuardProxyService f10924a;

            AnonymousClass1(SafetyGuardProxyService r3) {
                this.f10924a = (SafetyGuardProxyService) ZeusTransformUtils.wrapperContextForParams(r3, SafetyGuardProxyService.class, "com.obric.aiagent.plugin");
                super(0);
            }

            public final SidecarAuthHandler a() {
                return SafetyGuardProxyService.access$getOrCreateSidecarHost(this.f10924a).a();
            }

            @Override // d.h.a.a
            public /* synthetic */ SidecarAuthHandler invoke() {
                return a();
            }
        }

        c(SafetyGuardProxyService r3) {
            this.f10923a = (SafetyGuardProxyService) ZeusTransformUtils.wrapperContextForParams(r3, SafetyGuardProxyService.class, "com.obric.aiagent.plugin");
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ com.bytedance.safetyguard.lxc.internal.service.c invoke() {
            return a();
        }

        public final com.bytedance.safetyguard.lxc.internal.service.c a() {
            return new com.bytedance.safetyguard.lxc.internal.service.c((d.h.a.a) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.f10923a), d.h.a.a.class, "com.obric.aiagent.plugin"), (com.bytedance.safetyguard.lxc.internal.d.s) ZeusTransformUtils.preCheckCast(new com.bytedance.safetyguard.lxc.internal.d.ad((com.bytedance.safetyguard.lxc.internal.a.e) ZeusTransformUtils.preCheckCast(SafetyGuardProxyService.access$getServiceLogger(this.f10923a), com.bytedance.safetyguard.lxc.internal.a.e.class, "com.obric.aiagent.plugin")), com.bytedance.safetyguard.lxc.internal.d.s.class, "com.obric.aiagent.plugin"), null, null, null, 28, null);
        }
    }

    /* JADX INFO: compiled from: SafetyGuardProxyService.kt */
    static final class d extends d.h.b.p implements d.h.a.a<com.bytedance.safetyguard.lxc.internal.a.a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ SafetyGuardProxyService f10925a;

        d(SafetyGuardProxyService r3) {
            this.f10925a = (SafetyGuardProxyService) ZeusTransformUtils.wrapperContextForParams(r3, SafetyGuardProxyService.class, "com.obric.aiagent.plugin");
            super(0);
        }

        public final com.bytedance.safetyguard.lxc.internal.a.a a() {
            com.bytedance.safetyguard.lxc.internal.a.a.C0222a r0 = com.bytedance.safetyguard.lxc.internal.a.a.f9703a;
            Context r3 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f10925a.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
            d.h.b.o.c(r3, "getApplicationContext(...)");
            return r0.a(r3);
        }

        @Override // d.h.a.a
        public /* synthetic */ com.bytedance.safetyguard.lxc.internal.a.a invoke() {
            return a();
        }
    }

    public static /* synthetic */ ac lambda$WS_MCM6e4ojRC7rrs53SZk2dBOw(SafetyGuardProxyService r0, ParcelFileDescriptor r1, ProxyServiceConfigParcel r2, OutboundPolicyEvaluator r3, com.bytedance.safetyguard.lxc.internal.d.a r4, af r5) {
        return onCreate$lambda$0(r0, r1, r2, r3, r4, r5);
    }

    public static /* synthetic */ ac lambda$hHJZD5HB8Vbge4rI3b0hObgVNro(ParcelFileDescriptor r0, ProxyServiceConfigParcel r1, OutboundPolicyEvaluator r2, com.bytedance.safetyguard.lxc.internal.d.a r3, af r4) {
        return UnavailableProxySessionFactory$lambda$6(r0, r1, r2, r3, r4);
    }

    /* JADX WARN: Type inference failed for: r0v15, types: [com.bytedance.safetyguard.lxc.internal.service.SafetyGuardProxyService$serviceBinder$1] */
    public SafetyGuardProxyService() {
        this.proxyFdKeyResolver = (t) ZeusTransformUtils.preCheckCast(n.f11039a, t.class, "com.obric.aiagent.plugin");
        this.sidecarFactory = (ag) ZeusTransformUtils.preCheckCast(j.f11033a, ag.class, "com.obric.aiagent.plugin");
        this.sidecarHostLock = new Object();
        this.serviceLogger$delegate = d.g.a((d.h.a.a) ZeusTransformUtils.preCheckCast(new d(this), d.h.a.a.class, "com.obric.aiagent.plugin"));
        this.defaultProxySessionFactory$delegate = d.g.a((d.h.a.a) ZeusTransformUtils.preCheckCast(new c(this), d.h.a.a.class, "com.obric.aiagent.plugin"));
        this.serviceBinder = new SafetyGuardProxyService$serviceBinder$1(this);
    }

    public static final /* synthetic */ g access$getClients$p(SafetyGuardProxyService r2) {
        return ((SafetyGuardProxyService) ZeusTransformUtils.wrapperContextForParams(r2, SafetyGuardProxyService.class, "com.obric.aiagent.plugin")).clients;
    }

    public static final /* synthetic */ ai access$getOrCreateSidecarHost(SafetyGuardProxyService r2) {
        return ((SafetyGuardProxyService) ZeusTransformUtils.wrapperContextForParams(r2, SafetyGuardProxyService.class, "com.obric.aiagent.plugin")).getOrCreateSidecarHost();
    }

    public static final /* synthetic */ x access$getProxySessions$p(SafetyGuardProxyService r2) {
        return ((SafetyGuardProxyService) ZeusTransformUtils.wrapperContextForParams(r2, SafetyGuardProxyService.class, "com.obric.aiagent.plugin")).proxySessions;
    }

    public static final /* synthetic */ com.bytedance.safetyguard.lxc.internal.a.a access$getServiceLogger(SafetyGuardProxyService r2) {
        return ((SafetyGuardProxyService) ZeusTransformUtils.wrapperContextForParams(r2, SafetyGuardProxyService.class, "com.obric.aiagent.plugin")).getServiceLogger();
    }

    public static final /* synthetic */ ai access$getSidecarHost$p(SafetyGuardProxyService r2) {
        return ((SafetyGuardProxyService) ZeusTransformUtils.wrapperContextForParams(r2, SafetyGuardProxyService.class, "com.obric.aiagent.plugin")).sidecarHost;
    }

    public static final /* synthetic */ Object access$getSidecarHostLock$p(SafetyGuardProxyService r2) {
        return ((SafetyGuardProxyService) ZeusTransformUtils.wrapperContextForParams(r2, SafetyGuardProxyService.class, "com.obric.aiagent.plugin")).sidecarHostLock;
    }

    public static final /* synthetic */ ad access$getUnavailableProxySessionFactory$cp() {
        return UnavailableProxySessionFactory;
    }

    public static final /* synthetic */ void access$notifyAttachRejected(SafetyGuardProxyService r2, ProxyAttachRequestParcel r3, IProxyClientCallback r4, int r5, String r6) {
        ((SafetyGuardProxyService) ZeusTransformUtils.wrapperContextForParams(r2, SafetyGuardProxyService.class, "com.obric.aiagent.plugin")).notifyAttachRejected(r3, (IProxyClientCallback) ZeusTransformUtils.wrapperContextForParams(r4, IProxyClientCallback.class, "com.obric.aiagent.plugin"), r5, r6);
    }

    public final ad getProxySessionFactory$safetyguard_runtime_release() {
        return this.proxySessionFactory;
    }

    public final void setProxySessionFactory$safetyguard_runtime_release(ad r3) {
        this.proxySessionFactory = (ad) ZeusTransformUtils.wrapperContextForParams(r3, ad.class, "com.obric.aiagent.plugin");
    }

    public final t getProxyFdKeyResolver$safetyguard_runtime_release() {
        return this.proxyFdKeyResolver;
    }

    public final void setProxyFdKeyResolver$safetyguard_runtime_release(t r3) {
        t r4 = (t) ZeusTransformUtils.wrapperContextForParams(r3, t.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "<set-?>");
        this.proxyFdKeyResolver = r4;
    }

    public final ag getSidecarFactory$safetyguard_runtime_release() {
        return this.sidecarFactory;
    }

    public final void setSidecarFactory$safetyguard_runtime_release(ag r3) {
        ag r4 = (ag) ZeusTransformUtils.wrapperContextForParams(r3, ag.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "<set-?>");
        this.sidecarFactory = r4;
    }

    private final com.bytedance.safetyguard.lxc.internal.a.a getServiceLogger() {
        return (com.bytedance.safetyguard.lxc.internal.a.a) ZeusTransformUtils.preCheckCast(this.serviceLogger$delegate.b(), com.bytedance.safetyguard.lxc.internal.a.a.class, "com.obric.aiagent.plugin");
    }

    private final ad getDefaultProxySessionFactory() {
        return (ad) ZeusTransformUtils.preCheckCast(this.defaultProxySessionFactory$delegate.b(), ad.class, "com.obric.aiagent.plugin");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onCreate() {
        super/*android.app.Service*/.onCreate();
        com.bytedance.safetyguard.lxc.internal.d.p r2 = null;
        this.proxySessions = new x(new $$Lambda$SafetyGuardProxyService$WS_MCM6e4ojRC7rrs53SZk2dBOw(this), r2, (com.bytedance.safetyguard.lxc.internal.a.e) ZeusTransformUtils.preCheckCast(getServiceLogger(), com.bytedance.safetyguard.lxc.internal.a.e.class, "com.obric.aiagent.plugin"), 2, null);
        x r1 = this.proxySessions;
        if (r1 != null) goto L5;
        d.h.b.o.c("proxySessions");
        r1 = null;
    L5:
        this.clients = new g(r1, (com.bytedance.safetyguard.lxc.internal.a.e) ZeusTransformUtils.preCheckCast(getServiceLogger(), com.bytedance.safetyguard.lxc.internal.a.e.class, "com.obric.aiagent.plugin"));
    }

    private static final ac onCreate$lambda$0(SafetyGuardProxyService r8, ParcelFileDescriptor r9, ProxyServiceConfigParcel r10, OutboundPolicyEvaluator r11, com.bytedance.safetyguard.lxc.internal.d.a r12, af r13) {
        SafetyGuardProxyService r14 = (SafetyGuardProxyService) ZeusTransformUtils.wrapperContextForParams(r8, SafetyGuardProxyService.class, "com.obric.aiagent.plugin");
        OutboundPolicyEvaluator r5 = (OutboundPolicyEvaluator) ZeusTransformUtils.wrapperContextForParams(r11, OutboundPolicyEvaluator.class, "com.obric.aiagent.plugin");
        af r7 = (af) ZeusTransformUtils.wrapperContextForParams(r13, af.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r14, "this$0");
        d.h.b.o.e(r9, "sessionFd");
        d.h.b.o.e(r10, "config");
        d.h.b.o.e(r5, "businessPolicy");
        d.h.b.o.e(r12, "actionController");
        d.h.b.o.e(r7, "listener");
        ad r15 = r14.proxySessionFactory;
        if (r15 != null) goto L5;
        ad r2 = r14.getDefaultProxySessionFactory();
    L7:
        return r2.create(r9, r10, r5, r12, r7);
    L5:
        r2 = r15;
        goto L7
    }

    public IBinder onBind(Intent r2) {
        return (IBinder) ZeusTransformUtils.preCheckCast(this.serviceBinder, IBinder.class, "com.obric.aiagent.plugin");
    }

    public int onStartCommand(Intent r1, int r2, int r3) {
        stopSelf(r3);
        return 2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onDestroy() {
        g r0 = this.clients;
        x r1 = null;
        if (r0 == null) goto L7;
        if (r0 != null) goto L6;
        d.h.b.o.c("clients");
        r0 = null;
    L6:
        r0.close();
    L7:
        Object r2 = this.sidecarHostLock;
        monitor-enter(r2);
        ai r3 = this.sidecarHost;     // Catch: Throwable -> L21
        this.sidecarHost = null;     // Catch: Throwable -> L21
        monitor-exit(r2);
        if (r3 == null) goto L13;
        r3.close();
    L13:
        x r4 = this.proxySessions;
        if (r4 == null) goto L19;
        if (r4 != null) goto L17;
        d.h.b.o.c("proxySessions");
    L18:
        r1.close();
        goto L19
    L17:
        r1 = r4;
    L19:
        super/*android.app.Service*/.onDestroy();
        return;
    L21:
        th = move-exception;
        throw th;
    }

    private final ai getOrCreateSidecarHost() {
        Object r0 = this.sidecarHostLock;
        monitor-enter(r0);
        ai r1 = this.sidecarHost;     // Catch: Throwable -> L12
        if (r1 != null) goto L10;
        ag r2 = this.sidecarFactory;     // Catch: Throwable -> L12
        Context r3 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L12
        d.h.b.o.c(r3, "getApplicationContext(...)");     // Catch: Throwable -> L12
        SafetyGuardSidecar r4 = r2.a(r3);     // Catch: Throwable -> L12
        g r5 = this.clients;     // Catch: Throwable -> L12
        if (r5 != null) goto L9;
        d.h.b.o.c("clients");     // Catch: Throwable -> L12
        r5 = null;
    L9:
        r1 = new ai(r4, r5, null, null, 12, null);     // Catch: Throwable -> L12
        this.sidecarHost = r1;     // Catch: Throwable -> L12
    L10:
        monitor-exit(r0);
        return r1;
    L12:
        th = move-exception;
        throw th;
    }

    private final void notifyAttachRejected(ProxyAttachRequestParcel r21, IProxyClientCallback r22, int r23, String r24) {
        IProxyClientCallback r0 = (IProxyClientCallback) ZeusTransformUtils.wrapperContextForParams(r22, IProxyClientCallback.class, "com.obric.aiagent.plugin");
        d.n.a r2 = d.n.f38560a;     // Catch: Throwable -> L5
        SafetyGuardProxyService r1 = (SafetyGuardProxyService) ZeusTransformUtils.preCheckCast(this, SafetyGuardProxyService.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L5
        r0.onTerminal(r21.getAttachmentId(), new ProxySessionResultParcel(0, r21.getSessionId(), 7, r23, r24, 0, 0, 0, 0, null, null, 2017, null));     // Catch: Throwable -> L5
        d.n.f(d.x.f38692a);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        d.n.a r3 = d.n.f38560a;
        d.n.f(d.o.a(th));
    }

    static {
        Companion = new a(null);
        UnavailableProxySessionFactory = $$Lambda$SafetyGuardProxyService$hHJZD5HB8Vbge4rI3b0hObgVNro.INSTANCE;
    }

    private static final ac UnavailableProxySessionFactory$lambda$6(ParcelFileDescriptor r2, ProxyServiceConfigParcel r3, OutboundPolicyEvaluator r4, com.bytedance.safetyguard.lxc.internal.d.a r5, af r6) {
        OutboundPolicyEvaluator r7 = (OutboundPolicyEvaluator) ZeusTransformUtils.wrapperContextForParams(r4, OutboundPolicyEvaluator.class, "com.obric.aiagent.plugin");
        af r8 = (af) ZeusTransformUtils.wrapperContextForParams(r6, af.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r2, "<anonymous parameter 0>");
        d.h.b.o.e(r3, "<anonymous parameter 1>");
        d.h.b.o.e(r7, "<anonymous parameter 2>");
        d.h.b.o.e(r5, "<anonymous parameter 3>");
        d.h.b.o.e(r8, "listener");
        return (ac) ZeusTransformUtils.preCheckCast(new b(r8), ac.class, "com.obric.aiagent.plugin");
    }
}
