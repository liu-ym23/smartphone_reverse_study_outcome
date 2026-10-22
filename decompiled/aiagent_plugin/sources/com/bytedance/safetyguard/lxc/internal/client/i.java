package com.bytedance.safetyguard.lxc.internal.client;

import com.bytedance.safetyguard.lxc.api.ProxyReady;
import com.bytedance.safetyguard.lxc.api.ProxySessionResult;
import com.bytedance.safetyguard.lxc.api.SafetyGuardEvent;
import com.bytedance.safetyguard.lxc.api.SafetyGuardEventObserver;
import com.bytedance.safetyguard.lxc.api.SafetyGuardEventsKt;
import com.bytedance.safetyguard.lxc.internal.ipc.ProxyDiagnosticParcel;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: LocalProxyEventDispatcher.kt */
/* JADX INFO: loaded from: classes.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SafetyGuardEventObserver f9989a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.bytedance.safetyguard.lxc.internal.a.e f9990b;

    /* JADX INFO: compiled from: LocalProxyEventDispatcher.kt */
    static final class a extends d.h.b.p implements d.h.a.a<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f9991a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ i f9992b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f9993c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f9994d;

        a(String r1, i r2, String r3, String r4) {
            this.f9991a = r1;
            this.f9992b = r2;
            this.f9993c = r3;
            this.f9994d = r4;
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ String invoke() {
            return a();
        }

        public final String a() {
            return "component=proxy_event event=diagnostic outcome=observed code=" + this.f9991a + " sessionRef=" + i.a(this.f9992b).a(this.f9993c) + " message=" + this.f9994d;
        }
    }

    /* JADX INFO: compiled from: LocalProxyEventDispatcher.kt */
    static final class b extends d.h.b.p implements d.h.a.a<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ SafetyGuardEvent f9995a;

        b(SafetyGuardEvent r3) {
            this.f9995a = (SafetyGuardEvent) ZeusTransformUtils.wrapperContextForParams(r3, SafetyGuardEvent.class, "com.obric.aiagent.plugin");
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ String invoke() {
            return a();
        }

        public final String a() {
            return "component=proxy_event event=observer_failed outcome=ignored eventType=" + this.f9995a.getClass().getSimpleName();
        }
    }

    /* JADX INFO: compiled from: LocalProxyEventDispatcher.kt */
    static final class c extends d.h.b.p implements d.h.a.a<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ i f9996a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ProxyReady f9997b;

        c(i r1, ProxyReady r2) {
            this.f9996a = r1;
            this.f9997b = r2;
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ String invoke() {
            return a();
        }

        public final String a() {
            return "component=proxy_event event=ready outcome=success sessionRef=" + i.a(this.f9996a).a(this.f9997b.getSessionId()) + " reused=" + this.f9997b.getReused();
        }
    }

    /* JADX INFO: compiled from: LocalProxyEventDispatcher.kt */
    static final class d extends d.h.b.p implements d.h.a.a<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ i f9998a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f9999b;

        d(i r1, String r2) {
            this.f9998a = r1;
            this.f9999b = r2;
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ String invoke() {
            return a();
        }

        public final String a() {
            return "component=proxy_event event=started outcome=pending sessionRef=" + i.a(this.f9998a).a(this.f9999b);
        }
    }

    /* JADX INFO: compiled from: LocalProxyEventDispatcher.kt */
    static final class e extends d.h.b.p implements d.h.a.a<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ProxySessionResult f10000a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ i f10001b;

        e(ProxySessionResult r1, i r2) {
            this.f10000a = r1;
            this.f10001b = r2;
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ String invoke() {
            return a();
        }

        public final String a() {
            return "component=proxy_event event=terminal outcome=" + this.f10000a.getCloseReason() + " sessionRef=" + i.a(this.f10001b).a(this.f10000a.getSessionId()) + " errorCode=" + this.f10000a.getErrorCode();
        }
    }

    public i(SafetyGuardEventObserver r3, com.bytedance.safetyguard.lxc.internal.a.e r4) {
        SafetyGuardEventObserver r5 = (SafetyGuardEventObserver) ZeusTransformUtils.wrapperContextForParams(r3, SafetyGuardEventObserver.class, "com.obric.aiagent.plugin");
        com.bytedance.safetyguard.lxc.internal.a.e r6 = (com.bytedance.safetyguard.lxc.internal.a.e) ZeusTransformUtils.wrapperContextForParams(r4, com.bytedance.safetyguard.lxc.internal.a.e.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "observer");
        d.h.b.o.e(r6, "logger");
        this.f9989a = r5;
        this.f9990b = r6;
    }

    public static final /* synthetic */ com.bytedance.safetyguard.lxc.internal.a.e a(i r0) {
        return r0.f9990b;
    }

    public final void a(String r5) {
        d.h.b.o.e(r5, ObricMemoryConstants.KEY_SESSION_ID);
        this.f9990b.a("ProxyEvents", (d.h.a.a) ZeusTransformUtils.preCheckCast(new d(this, r5), d.h.a.a.class, "com.obric.aiagent.plugin"));
        a((SafetyGuardEvent) ZeusTransformUtils.preCheckCast(new SafetyGuardEvent.ProxySessionStarted(r5), SafetyGuardEvent.class, "com.obric.aiagent.plugin"));
    }

    public final void a(ProxyReady r5) {
        d.h.b.o.e(r5, "ready");
        this.f9990b.b("ProxyEvents", (d.h.a.a) ZeusTransformUtils.preCheckCast(new c(this, r5), d.h.a.a.class, "com.obric.aiagent.plugin"));
        a((SafetyGuardEvent) ZeusTransformUtils.preCheckCast(new SafetyGuardEvent.ProxySessionReady(r5), SafetyGuardEvent.class, "com.obric.aiagent.plugin"));
    }

    public final void a(ProxySessionResult r5) {
        d.h.b.o.e(r5, "result");
        this.f9990b.b("ProxyEvents", (d.h.a.a) ZeusTransformUtils.preCheckCast(new e(r5, this), d.h.a.a.class, "com.obric.aiagent.plugin"));
        a((SafetyGuardEvent) ZeusTransformUtils.preCheckCast(new SafetyGuardEvent.ProxySessionClosed(r5), SafetyGuardEvent.class, "com.obric.aiagent.plugin"));
    }

    public final void a(String r11, ProxyDiagnosticParcel r12) {
        d.h.b.o.e(r11, ObricMemoryConstants.KEY_SESSION_ID);
        d.h.b.o.e(r12, "diagnostic");
        String r0 = com.bytedance.safetyguard.lxc.internal.a.c.a(r12.getCode());
        String r1 = com.bytedance.safetyguard.lxc.internal.a.c.a(r12.getMessage());
        d.h.a.a<String> r7 = (d.h.a.a) ZeusTransformUtils.preCheckCast(new a(r0, this, r11, r1), d.h.a.a.class, "com.obric.aiagent.plugin");
        int r13 = r12.getSeverity();
        if (r13 != 0) goto L5;
        this.f9990b.b("ProxyEvents", r7);
    L12:
        a((SafetyGuardEvent) ZeusTransformUtils.preCheckCast(new SafetyGuardEvent.ProxySessionError(r11, r1), SafetyGuardEvent.class, "com.obric.aiagent.plugin"));
        return;
    L5:
        if (r13 != 1) goto L7;
        com.bytedance.safetyguard.lxc.internal.a.e.a.a(this.f9990b, "ProxyEvents", null, r7, 2, null);
        goto L12
    L7:
        if (r13 != 2) goto L12;
        com.bytedance.safetyguard.lxc.internal.a.e.a.b(this.f9990b, "ProxyEvents", null, r7, 2, null);
        goto L12
    }

    private final void a(SafetyGuardEvent r4) {
        SafetyGuardEvent r5 = (SafetyGuardEvent) ZeusTransformUtils.wrapperContextForParams(r4, SafetyGuardEvent.class, "com.obric.aiagent.plugin");
        if (SafetyGuardEventsKt.isNoopObserver(this.f9989a) == false) goto L10;
        return;
    L10:
        this.f9989a.emit(r5);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        com.bytedance.safetyguard.lxc.internal.a.c.a(th);
        this.f9990b.a("ProxyEvents", th, (d.h.a.a) ZeusTransformUtils.preCheckCast(new b(r5), d.h.a.a.class, "com.obric.aiagent.plugin"));
    }
}
