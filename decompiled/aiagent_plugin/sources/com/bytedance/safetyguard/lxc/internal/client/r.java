package com.bytedance.safetyguard.lxc.internal.client;

import com.bytedance.safetyguard.lxc.api.ActionContextToken;
import com.bytedance.safetyguard.lxc.api.ActionEgressResult;
import com.bytedance.safetyguard.lxc.api.ProxyReady;
import com.bytedance.safetyguard.lxc.api.ProxyReadyException;
import com.bytedance.safetyguard.lxc.api.ProxySession;
import com.bytedance.safetyguard.lxc.api.ProxySessionCloseReason;
import com.bytedance.safetyguard.lxc.api.ProxySessionErrorCode;
import com.bytedance.safetyguard.lxc.api.ProxySessionResult;
import com.bytedance.safetyguard.lxc.internal.d.aa;
import com.bytedance.safetyguard.lxc.internal.ipc.ProxyDiagnosticParcel;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.x;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlinx.coroutines.y;

/* JADX INFO: compiled from: RemoteProxySessionAttachment.kt */
/* JADX INFO: loaded from: classes.dex */
public final class r implements ProxySession, aa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f10013a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f10014b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ProxyServiceConnector f10015c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final i f10016d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final d.h.a.b<r, x> f10017e;
    private final Object f;
    private final Object g;
    private final CountDownLatch h;
    private final kotlinx.coroutines.w<ProxyReady> i;
    private final kotlinx.coroutines.w<ProxySessionResult> j;
    private final AtomicBoolean k;
    private final AtomicBoolean l;
    private a m;
    private ProxySessionResult n;
    private boolean o;
    private w p;
    private boolean q;

    /* JADX INFO: compiled from: RemoteProxySessionAttachment.kt */
    private static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f10018a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f10019b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f10020c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final /* synthetic */ a[] f10021d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final /* synthetic */ d.d.a f10022e = null;

        private static final /* synthetic */ a[] a() {
            return new a[]{f10018a, f10019b, f10020c};
        }

        public static a valueOf(String r2) {
            return (a) ZeusTransformUtils.preCheckCast(Enum.valueOf(a.class, r2), a.class, "com.obric.aiagent.plugin");
        }

        public static a[] values() {
            return (a[]) ZeusTransformUtils.preCheckCast(f10021d.clone(), a[].class, "com.obric.aiagent.plugin");
        }

        private a(String r1, int r2) {
            super(r1, r2);
        }

        static {
            f10018a = new a("NOT_PUBLISHED", 0);
            f10019b = new a("PUBLISHING", 1);
            f10020c = new a("PUBLISHED", 2);
            a[] r0 = a();
            f10021d = r0;
            f10022e = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
        }
    }

    public r(String r3, String r4, ProxyServiceConnector r5, i r6, d.h.a.b<? super r, x> r7) {
        d.h.a.b<r, x> r8 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r7, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, ObricMemoryConstants.KEY_SESSION_ID);
        d.h.b.o.e(r4, "attachmentId");
        d.h.b.o.e(r5, "connector");
        d.h.b.o.e(r6, "eventDispatcher");
        d.h.b.o.e(r8, "releasedCallback");
        this.f10013a = r3;
        this.f10014b = r4;
        this.f10015c = r5;
        this.f10016d = r6;
        this.f10017e = r8;
        this.f = new Object();
        this.g = new Object();
        this.h = new CountDownLatch(1);
        this.i = y.a(null, 1, null);
        this.j = y.a(null, 1, null);
        this.k = new AtomicBoolean(false);
        this.l = new AtomicBoolean(false);
        this.m = a.f10018a;
    }

    @Override // com.bytedance.safetyguard.lxc.api.ProxySession
    public String getSessionId() {
        return this.f10013a;
    }

    @Override // com.bytedance.safetyguard.lxc.internal.d.aa
    public Object a(d.c.d<? super ProxyReady> r3) {
        d.c.d<? super ProxyReady> r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
        return this.i.a(r4);
    }

    @Override // com.bytedance.safetyguard.lxc.api.ProxySession
    public Object await(d.c.d<? super ProxySessionResult> r3) {
        d.c.d<? super ProxySessionResult> r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
        return this.j.a(r4);
    }

    @Override // com.bytedance.safetyguard.lxc.api.ProxySession
    /* JADX INFO: renamed from: activateAction-IoAF18A */
    public Object mo31activateActionIoAF18A(String r2) {
        d.h.b.o.e(r2, "outboundSensitiveDataJson");
        if (this.k.get() == false) goto L7;
        d.n.a r1 = d.n.f38560a;
        return d.n.f(d.o.a((Throwable) ZeusTransformUtils.preCheckCast(new IllegalStateException("SESSION_CLOSED"), Throwable.class, "com.obric.aiagent.plugin")));
    L7:
        return this.f10015c.a(this.f10014b, r2);
    }

    @Override // com.bytedance.safetyguard.lxc.api.ProxySession
    /* JADX INFO: renamed from: finishAction-IoAF18A */
    public Object mo33finishActionIoAF18A(ActionContextToken r6) {
        d.h.b.o.e(r6, "token");
        if (this.k.get() == false) goto L6;
        d.n.a r5 = d.n.f38560a;
        return d.n.f(d.o.a((Throwable) ZeusTransformUtils.preCheckCast(new IllegalStateException("SESSION_CLOSED"), Throwable.class, "com.obric.aiagent.plugin")));
    L6:
        d.n<ActionEgressResult> r0 = a(r6);
        if (r0 != null) goto L9;
        Object r1 = this.f10015c.a(this.f10014b, r6);
        if (d.n.a(r1) == false) goto L13;
    L21:
        return r1;
    L13:
        if (a(r1) == false) goto L21;
        this.h.await(500, TimeUnit.MILLISECONDS);     // Catch: InterruptedException -> L20
        d.n<ActionEgressResult> r7 = a(r6);
        if (r7 != null) goto L19;
        return r1;
    L19:
        return r7.a();
    L20:
        Thread.currentThread().interrupt();
        goto L21
    L9:
        return r0.a();
    }

    @Override // com.bytedance.safetyguard.lxc.api.ProxySession
    /* JADX INFO: renamed from: close-d1pmJ48 */
    public Object mo32closed1pmJ48() {
        d.n.a r0 = d.n.f38560a;     // Catch: Throwable -> L15
        r r1 = (r) ZeusTransformUtils.preCheckCast(this, r.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L15
        if (r1.k.compareAndSet(false, true) == false) goto L21;
        Object r2 = r1.g;     // Catch: Throwable -> L15
        monitor-enter(r2);     // Catch: Throwable -> L15
        r1.p = null;     // Catch: Throwable -> L10
        r1.q = false;     // Catch: Throwable -> L10
        x r3 = x.f38692a;     // Catch: Throwable -> L10
        monitor-exit(r2);     // Catch: Throwable -> L15
        ProxySessionResult r4 = new ProxySessionResult(r1.getSessionId(), ProxySessionCloseReason.HOST_CLOSED, null, null, 0, 0, 0, 0, 252, null);     // Catch: Throwable -> L15
        r1.a(ProxySessionErrorCode.SERVICE_UNAVAILABLE, "Proxy attachment closed before becoming ready");     // Catch: Throwable -> L15
        a(r1, r4, null, 2, null);     // Catch: Throwable -> L15
        r1.f10015c.a(r1.f10014b);     // Catch: Throwable -> L15
        goto L21
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L15
    L21:
        return d.n.f(x.f38692a);
    L15:
        th = move-exception;
        d.n.a r5 = d.n.f38560a;
        return d.n.f(d.o.a(th));
    }

    public final boolean a() {
        return this.k.get();
    }

    public final void b() {
        Object r0 = this.f;
        monitor-enter(r0);
    L35:
        th = move-exception;
        throw th;
    L5:
        if (this.m == a.f10018a) goto L7;
        boolean r1 = false;
    L9:
        monitor-exit(r0);
        if (r1 == true) goto L40;
        return;
    L40:
        this.f10016d.a(getSessionId());     // Catch: Throwable -> L24
        Object r2 = this.f;
        monitor-enter(r2);
        this.m = a.f10020c;     // Catch: Throwable -> L21
        ProxySessionResult r3 = this.n;     // Catch: Throwable -> L21
        this.n = null;     // Catch: Throwable -> L21
        monitor-exit(r2);
        if (r3 == null) goto L46;
        this.f10016d.a(r3);
        return;
    L46:
        return;
    L21:
        th = move-exception;
        throw th;
    L24:
        th = move-exception;
        monitor-enter(this.f);
        this.m = a.f10020c;     // Catch: Throwable -> L32
        ProxySessionResult r4 = this.n;     // Catch: Throwable -> L32
        this.n = null;     // Catch: Throwable -> L32
        if (r4 == null) goto L31;
        this.f10016d.a(r4);
    L31:
        throw th;
    L32:
        th = move-exception;
        throw th;
    L7:
        this.m = a.f10019b;     // Catch: Throwable -> L35
        r1 = true;
        goto L9
    }

    public final void a(ProxyReady r15) {
        d.h.b.o.e(r15, "value");
        if (d.h.b.o.a(r15.getSessionId(), getSessionId()) == true) goto L7;
        a(this, new ProxySessionResult(getSessionId(), ProxySessionCloseReason.INTERNAL_ERROR, ProxySessionErrorCode.SERVICE_PROTOCOL_MISMATCH, "Proxy ready session id mismatch", 0, 0, 0, 0, 240, null), null, 2, null);
        return;
    L7:
        if (this.i.a(r15) == false) goto L10;
        this.f10016d.a(r15);
        return;
    }

    public static /* synthetic */ void a(r r0, ProxySessionResult r1, w r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        r0.a(r1, r2);
    }

    public final void a(ProxySessionResult r5, w r6) {
        d.h.b.o.e(r5, "result");
        Object r0 = this.g;
        monitor-enter(r0);
        boolean r2 = false;
        if (this.o == false) goto L7;
        boolean r7 = false;
    L9:
        monitor-exit(r0);
        this.h.countDown();
        if (r7 == true) goto L14;
        return;
    L14:
        if (this.i.i() == true) goto L23;
        ProxySessionErrorCode r8 = r5.getErrorCode();
        if (r8 != null) goto L18;
        r8 = ProxySessionErrorCode.SERVICE_UNAVAILABLE;
    L18:
        String r1 = r5.getMessage();
        if (r1 != null) goto L21;
        r1 = "Proxy attachment terminated before becoming ready";
    L21:
        a(r8, r1);
    L23:
        if (this.j.a(r5) == false) goto L36;
        Object r9 = this.f;
        monitor-enter(r9);
    L33:
        th = move-exception;
        throw th;
    L27:
        if (this.m != a.f10020c) goto L29;
        r2 = true;
    L30:
        monitor-exit(r9);
        if (r2 == false) goto L44;
        this.f10016d.a(r5);
        return;
    L44:
        return;
    L29:
        this.n = r5;     // Catch: Throwable -> L33
        goto L30
    L36:
        return;
    L7:
        this.o = true;     // Catch: Throwable -> L37
        this.p = r6;     // Catch: Throwable -> L37
        this.q = false;     // Catch: Throwable -> L37
        r7 = true;
    L37:
        th = move-exception;
        throw th;
    }

    private final d.n<ActionEgressResult> a(ActionContextToken r5) {
        Object r0 = this.g;
        monitor-enter(r0);
        w r1 = this.p;     // Catch: Throwable -> L15
        d.n<ActionEgressResult> r2 = null;
        if (r1 != null) goto L10;
        if (this.q == false) goto L13;
        d.n.a r4 = d.n.f38560a;     // Catch: Throwable -> L15
        r2 = d.n.g(d.n.f(d.o.a((Throwable) ZeusTransformUtils.preCheckCast(new com.bytedance.safetyguard.lxc.internal.client.a(6, "No active Action"), Throwable.class, "com.obric.aiagent.plugin"))));     // Catch: Throwable -> L15
    L13:
        monitor-exit(r0);
        return r2;
    L10:
        if (a(r5, r1.a()) == true) goto L12;
        d.n.a r6 = d.n.f38560a;     // Catch: Throwable -> L15
        r2 = d.n.g(d.n.f(d.o.a((Throwable) ZeusTransformUtils.preCheckCast(new com.bytedance.safetyguard.lxc.internal.client.a(7, "Action token is invalid"), Throwable.class, "com.obric.aiagent.plugin"))));     // Catch: Throwable -> L15
        goto L13
    L12:
        this.p = null;     // Catch: Throwable -> L15
        this.q = true;     // Catch: Throwable -> L15
        d.n.a r7 = d.n.f38560a;     // Catch: Throwable -> L15
        r2 = d.n.g(d.n.f(r1.b()));     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    }

    private final boolean a(Object r3) {
        Throwable r2 = d.n.c(r3);
        Integer r0 = null;
        if (ZeusTransformUtils.instanceOf(r2, com.bytedance.safetyguard.lxc.internal.client.a.class) == false) goto L5;
        com.bytedance.safetyguard.lxc.internal.client.a r4 = (com.bytedance.safetyguard.lxc.internal.client.a) ZeusTransformUtils.preCheckCast(r2, com.bytedance.safetyguard.lxc.internal.client.a.class, "com.obric.aiagent.plugin");
    L6:
        if (r4 == null) goto L9;
        r0 = Integer.valueOf(r4.a());
    L9:
        if (r0 == null) goto L14;
        if (r0.intValue() != 3) goto L14;
    L20:
        return true;
    L14:
        if (r0 != null) goto L17;
    L19:
        return false;
    L17:
        if (r0.intValue() != 4) goto L19;
    L5:
        r4 = null;
        goto L6
    }

    private final boolean a(ActionContextToken r3, ActionContextToken r4) {
        if (d.h.b.o.a(r3.getSessionInstanceId$safetyguard_runtime_release(), r4.getSessionInstanceId$safetyguard_runtime_release()) == true) goto L5;
    L7:
        return false;
    L5:
        if (r3.getActivationSequence$safetyguard_runtime_release() != r4.getActivationSequence$safetyguard_runtime_release()) goto L7;
        return true;
    }

    public final void a(ProxyDiagnosticParcel r2) {
        d.h.b.o.e(r2, "diagnostic");
        if (this.j.i() == true) goto L6;
        this.f10016d.a(getSessionId(), r2);
        return;
    }

    public final void c() {
        if (this.l.compareAndSet(false, true) == false) goto L6;
        this.f10017e.invoke(this);
        return;
    }

    private final void a(ProxySessionErrorCode r10, String r11) {
        this.i.a((Throwable) ZeusTransformUtils.preCheckCast(new ProxyReadyException(getSessionId(), r10, r11, null, 8, null), Throwable.class, "com.obric.aiagent.plugin"));
    }
}
