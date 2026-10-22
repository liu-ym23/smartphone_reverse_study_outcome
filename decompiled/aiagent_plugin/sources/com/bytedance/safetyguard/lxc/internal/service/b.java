package com.bytedance.safetyguard.lxc.internal.service;

import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.safetyguard.lxc.internal.ipc.ProxyReadyParcel;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: AppGatewayServiceProxySession.kt */
/* JADX INFO: loaded from: classes.dex */
final class b implements ac {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final a f10996a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.bytedance.safetyguard.lxc.internal.d.e f10997b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final af f10998c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.bytedance.safetyguard.lxc.internal.d.s f10999d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Object f11000e;
    private boolean f;
    private boolean g;
    private Thread h;

    /* JADX INFO: compiled from: AppGatewayServiceProxySession.kt */
    private static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: renamed from: com.bytedance.safetyguard.lxc.internal.service.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AppGatewayServiceProxySession.kt */
    static final class C0250b extends d.h.b.p implements d.h.a.b<com.bytedance.safetyguard.lxc.internal.d.d, d.x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f11001a;

        C0250b(b r1) {
            this.f11001a = r1;
            super(1);
        }

        @Override // d.h.a.b
        public /* synthetic */ d.x invoke(com.bytedance.safetyguard.lxc.internal.d.d r3) {
            a((com.bytedance.safetyguard.lxc.internal.d.d) ZeusTransformUtils.preCheckCast(r3, com.bytedance.safetyguard.lxc.internal.d.d.class, "com.obric.aiagent.plugin"));
            return d.x.f38692a;
        }

        public final void a(com.bytedance.safetyguard.lxc.internal.d.d r15) {
            com.bytedance.safetyguard.lxc.internal.d.d r16 = (com.bytedance.safetyguard.lxc.internal.d.d) ZeusTransformUtils.wrapperContextForParams(r15, com.bytedance.safetyguard.lxc.internal.d.d.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r16, "handshake");
            if (ZeusTransformUtils.instanceOf(r16, com.bytedance.safetyguard.lxc.internal.d.d.b.class) == false) goto L15;
            b r0 = this.f11001a;
            d.n.a r2 = d.n.f38560a;     // Catch: Throwable -> L7
            b.a(r0).a(new ProxyReadyParcel(0, ((com.bytedance.safetyguard.lxc.internal.d.d.b) ZeusTransformUtils.preCheckCast(r16, com.bytedance.safetyguard.lxc.internal.d.d.b.class, "com.obric.aiagent.plugin")).a(), false, ((com.bytedance.safetyguard.lxc.internal.d.d.b) ZeusTransformUtils.preCheckCast(r16, com.bytedance.safetyguard.lxc.internal.d.d.b.class, "com.obric.aiagent.plugin")).b(), ((com.bytedance.safetyguard.lxc.internal.d.d.b) ZeusTransformUtils.preCheckCast(r16, com.bytedance.safetyguard.lxc.internal.d.d.b.class, "com.obric.aiagent.plugin")).c(), ((com.bytedance.safetyguard.lxc.internal.d.d.b) ZeusTransformUtils.preCheckCast(r16, com.bytedance.safetyguard.lxc.internal.d.d.b.class, "com.obric.aiagent.plugin")).d(), ((com.bytedance.safetyguard.lxc.internal.d.d.b) ZeusTransformUtils.preCheckCast(r16, com.bytedance.safetyguard.lxc.internal.d.d.b.class, "com.obric.aiagent.plugin")).e(), 1, null));     // Catch: Throwable -> L7
            Object r17 = d.n.f(d.x.f38692a);     // Catch: Throwable -> L7
        L9:
            b r14 = this.f11001a;
            Throwable r18 = d.n.c(r17);
            if (r18 == null) goto L16;
            b.b(r14).b("AppGatewayServiceProxySession", "component=proxy_service_session event=ready_dispatched outcome=failed", r18);
            return;
        L16:
            return;
        L7:
            th = move-exception;
            d.n.a r1 = d.n.f38560a;
            r17 = d.n.f(d.o.a(th));
            goto L9
        }
    }

    static {
        f10996a = new a(null);
    }

    public static /* synthetic */ void lambda$oNRYFfhPF9VNHOX19XesNRUCHZw(b r0) {
        r0.c();
    }

    public b(com.bytedance.safetyguard.lxc.internal.d.e r3, af r4, com.bytedance.safetyguard.lxc.internal.d.s r5) {
        af r6 = (af) ZeusTransformUtils.wrapperContextForParams(r4, af.class, "com.obric.aiagent.plugin");
        com.bytedance.safetyguard.lxc.internal.d.s r7 = (com.bytedance.safetyguard.lxc.internal.d.s) ZeusTransformUtils.wrapperContextForParams(r5, com.bytedance.safetyguard.lxc.internal.d.s.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "gatewaySession");
        d.h.b.o.e(r6, "listener");
        d.h.b.o.e(r7, "logger");
        this.f10997b = r3;
        this.f10998c = r6;
        this.f10999d = r7;
        this.f11000e = new Object();
    }

    public static final /* synthetic */ af a(b r0) {
        return r0.f10998c;
    }

    public static final /* synthetic */ com.bytedance.safetyguard.lxc.internal.d.s b(b r0) {
        return r0.f10999d;
    }

    @Override // com.bytedance.safetyguard.lxc.internal.service.ac
    public void a() {
        Object r0 = this.f11000e;
        monitor-enter(r0);
    L16:
        th = move-exception;
        throw th;
    L5:
        if ((!this.f) == false) goto L15;
        if (this.g == false) goto L10;
        monitor-exit(r0);
        return;
    L10:
        this.f = true;     // Catch: Throwable -> L16
        Thread r1 = new Thread(new $$Lambda$b$oNRYFfhPF9VNHOX19XesNRUCHZw(this), "SafetyGuardServiceProxySession");     // Catch: Throwable -> L16
        r1.setDaemon(true);     // Catch: Throwable -> L16
        r1.start();     // Catch: Throwable -> L16
        this.h = r1;     // Catch: Throwable -> L16
        d.x r2 = d.x.f38692a;     // Catch: Throwable -> L16
        monitor-exit(r0);
        this.f10999d.a("AppGatewayServiceProxySession", "component=proxy_service_session event=session_started outcome=pending");
        return;
    L15:
        throw new IllegalStateException("Service proxy session already started".toString());     // Catch: Throwable -> L16
    }

    @Override // com.bytedance.safetyguard.lxc.internal.service.ac
    public void b() {
        Object r0 = this.f11000e;
        monitor-enter(r0);
    L17:
        th = move-exception;
        throw th;
    L5:
        if (this.g == false) goto L9;
        monitor-exit(r0);
        return;
    L9:
        this.g = true;     // Catch: Throwable -> L17
        Thread r1 = this.h;     // Catch: Throwable -> L17
        monitor-exit(r0);
        this.f10997b.close();
        if (r1 != null) goto L14;
        return;
    L14:
        if (r1 == Thread.currentThread()) goto L23;
        r1.join(WsConstants.EXIT_DELAY_TIME);
        this.f10997b.a(WsConstants.EXIT_DELAY_TIME);
        return;
    }

    private final void c() {
        com.bytedance.safetyguard.lxc.internal.d.f r0 = this.f10997b.a((d.h.a.b) ZeusTransformUtils.preCheckCast(new C0250b(this), d.h.a.b.class, "com.obric.aiagent.plugin"));
        d.n.a r1 = d.n.f38560a;     // Catch: Throwable -> L5
        ((b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.aiagent.plugin")).f10998c.a(d.a(r0));     // Catch: Throwable -> L5
        Object r2 = d.n.f(d.x.f38692a);     // Catch: Throwable -> L5
    L8:
        if (d.n.a(r2) == false) goto L10;
        d.x r3 = (d.x) ZeusTransformUtils.preCheckCast(r2, d.x.class, "com.obric.aiagent.plugin");
        this.f10999d.b("AppGatewayServiceProxySession", "component=proxy_service_session event=terminal_dispatched outcome=success closeReason=" + r0.a() + " errorCode=" + r0.b());
    L10:
        Throwable r4 = d.n.c(r2);
        if (r4 == null) goto L16;
        this.f10999d.b("AppGatewayServiceProxySession", "component=proxy_service_session event=terminal_dispatched outcome=failed closeReason=" + r0.a() + " errorCode=" + r0.b(), r4);
        return;
    L16:
        return;
    L5:
        th = move-exception;
        d.n.a r5 = d.n.f38560a;
        r2 = d.n.f(d.o.a(th));
        goto L8
    }
}
