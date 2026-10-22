package com.bytedance.ai.applet.app.foundation.performance;

import com.bytedance.lynx.service.monitor.LynxMonitorService;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes43.dex */
public abstract class l extends k {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final com.bytedance.ai.applet.base.log.d f34345h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final i f34346i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f34347j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public o f34348k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Long f34349l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Long f34350m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Long f34351n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Long f34352o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f34353p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Long f34354q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Long f34355r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Long f34356s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public Long f34357t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public Long f34358u;

    public static final class a {
    }

    static {
    }

    public abstract void p(long r100);

    public final boolean j() {
        long r100 = System.currentTimeMillis();
        Object r101 = this.f34342d;
        monitor-enter(r101);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (a(r100) == true) goto L7;
    L11:
        boolean r102 = false;
    L12:
        monitor-exit(r101);
        return r102;
    L7:
        if (this.f34351n != null) goto L11;
        this.f34351n = Long.valueOf(r100);     // Catch: Throwable -> L14
        r102 = true;
        goto L12
    }

    public final boolean k() {
        long r100 = System.currentTimeMillis();
        Object r101 = this.f34342d;
        monitor-enter(r101);
        Long r102 = this.f34356s;     // Catch: Throwable -> L17
        if (a(r100) == false) goto L14;
        if (r102 == null) goto L14;
        if (r100 < r102.longValue()) goto L14;
        if (this.f34357t != null) goto L14;
        this.f34357t = Long.valueOf(r100);     // Catch: Throwable -> L17
        boolean r103 = true;
    L15:
        monitor-exit(r101);
        return r103;
    L14:
        r103 = false;
    L17:
        th = move-exception;
        throw th;
    }

    public final boolean l() {
        long r100 = System.currentTimeMillis();
        Object r101 = this.f34342d;
        monitor-enter(r101);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (a(r100) == true) goto L7;
    L11:
        boolean r102 = false;
    L12:
        monitor-exit(r101);
        return r102;
    L7:
        if (this.f34356s != null) goto L11;
        this.f34356s = Long.valueOf(r100);     // Catch: Throwable -> L14
        r102 = true;
        goto L12
    }

    public final boolean m() {
        long r100 = System.currentTimeMillis();
        Object r101 = this.f34342d;
        monitor-enter(r101);
        Long r102 = this.f34354q;     // Catch: Throwable -> L17
        if (a(r100) == false) goto L14;
        if (r102 == null) goto L14;
        if (r100 < r102.longValue()) goto L14;
        if (this.f34355r != null) goto L14;
        this.f34355r = Long.valueOf(r100);     // Catch: Throwable -> L17
        boolean r103 = true;
    L15:
        monitor-exit(r101);
        return r103;
    L14:
        r103 = false;
    L17:
        th = move-exception;
        throw th;
    }

    public final boolean n() {
        long r100 = System.currentTimeMillis();
        Object r101 = this.f34342d;
        monitor-enter(r101);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (a(r100) == true) goto L7;
    L11:
        boolean r102 = false;
    L12:
        monitor-exit(r101);
        return r102;
    L7:
        if (this.f34354q != null) goto L11;
        this.f34354q = Long.valueOf(r100);     // Catch: Throwable -> L14
        r102 = true;
        goto L12
    }

    public long f() {
        return this.f34340b;
    }

    public final void g(long r100) {
        Object r101 = this.f34342d;
        monitor-enter(r101);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (a(r100) == true) goto L7;
    L11:
        f.d r102 = null;
    L12:
        monitor-exit(r101);
        q("markFirstContentfulPaint", r102);
        return;
    L7:
        if (this.f34350m != null) goto L11;
        this.f34350m = Long.valueOf(r100);     // Catch: Throwable -> L15
        r102 = new f.d(r100, this.f34346i);     // Catch: Throwable -> L15
        goto L12
    }

    public final void h(long r100) {
        Object r101 = this.f34342d;
        monitor-enter(r101);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (a(r100) == true) goto L7;
    L11:
        f.e r102 = null;
    L12:
        monitor-exit(r101);
        q("markFirstPaint", r102);
        return;
    L7:
        if (this.f34349l != null) goto L11;
        this.f34349l = Long.valueOf(r100);     // Catch: Throwable -> L15
        r102 = new f.e(r100, this.f34346i);     // Catch: Throwable -> L15
        goto L12
    }

    public final boolean i(boolean r100) {
        long r101 = System.currentTimeMillis();
        Object r102 = this.f34342d;
        monitor-enter(r102);
        Long r103 = this.f34351n;     // Catch: Throwable -> L17
        if (a(r101) == false) goto L14;
        if (r103 == null) goto L14;
        if (r101 < r103.longValue()) goto L14;
        if (this.f34352o != null) goto L14;
        this.f34352o = Long.valueOf(r101);     // Catch: Throwable -> L17
        this.f34353p = r100;     // Catch: Throwable -> L17
        boolean r104 = true;
    L15:
        monitor-exit(r102);
        return r104;
    L14:
        r104 = false;
    L17:
        th = move-exception;
        throw th;
    }

    public final void o(Map<String, ? extends Object> r110) {
        Intrinsics.checkNotNullParameter(r110, "timingInfo");
        Object r111 = r110.get(LynxMonitorService.KEY_SETUP_TIMING);
        if ((r111 instanceof Map) == false) goto L5;
        Map r112 = (Map) r111;
    L6:
        if (r112 != null) goto L9;
        com.bytedance.ai.applet.base.log.d r100 = this.f34345h;
        AtomicInteger r101 = com.bytedance.ai.applet.base.log.d.f34519d;
        r100.a("onLynxRenderCompleted: setup_timing is missing or invalid", null);
        c(AppletPerformanceErrorCode.INVALID_RENDER_TIMING, "setup_timing is missing or invalid");
        return;
    L9:
        Long r102 = m.a(r112, "draw_end");
        if (r102 == null) goto L41;
        long r113 = r102.longValue();
        r(new o(f(), r113, m.a(r112, "lepus_excute_end"), m.a(r112, "create_vdom_start"), m.a(r112, "load_template_end")));
        h(r113);
        g(r113);
        Long r103 = m.a(r112, "load_app_start");
        if (r103 != null) goto L14;
        com.bytedance.ai.applet.base.log.d r104 = this.f34345h;
        AtomicInteger r105 = com.bytedance.ai.applet.base.log.d.f34519d;
        r104.a("onLynxRenderCompleted: load_app_start is missing or invalid", null);
    L14:
        Long r114 = m.a(r112, "load_app_end");
        if (r114 != null) goto L17;
        com.bytedance.ai.applet.base.log.d r106 = this.f34345h;
        AtomicInteger r107 = com.bytedance.ai.applet.base.log.d.f34519d;
        r106.a("onLynxRenderCompleted: load_app_end is missing or invalid", null);
    L17:
        if (r103 == null) goto L34;
        if (r114 == null) goto L34;
        Object r108 = this.f34342d;
        monitor-enter(r108);
    L31:
        th = move-exception;
        throw th;
    L22:
        if (this.f34343e == false) goto L24;
    L28:
        Unit r109 = Unit.INSTANCE;     // Catch: Throwable -> L31
        monitor-exit(r108);
        goto L34
    L24:
        if (r114.longValue() < r103.longValue()) goto L28;
        if (this.f34358u != null) goto L28;
        this.f34358u = Long.valueOf(r114.longValue() - r103.longValue());     // Catch: Throwable -> L31
    L34:
        String r115 = this.f34347j;
        if (r103 == null) goto L39;
        if (r114 == null) goto L39;
        if (r115 == null) goto L39;
        s(new u(r103.longValue(), r114.longValue(), r115));
    L39:
        p(r113);
        return;
    L41:
        com.bytedance.ai.applet.base.log.d r116 = this.f34345h;
        AtomicInteger r117 = com.bytedance.ai.applet.base.log.d.f34519d;
        r116.a("onLynxRenderCompleted: draw_end is missing or invalid", null);
        c(AppletPerformanceErrorCode.INVALID_RENDER_TIMING, "draw_end is missing or invalid");
        return;
    L5:
        r112 = null;
        goto L6
    }

    public final void r(o r110) {
        Intrinsics.checkNotNullParameter(r110, "timing");
        Object r100 = this.f34342d;
        monitor-enter(r100);
    L17:
        th = move-exception;
        throw th;
    L5:
        if (this.f34343e == false) goto L7;
    L13:
        f.C0680f r101 = null;
    L14:
        monitor-exit(r100);
        q("recordFirstRender", r101);
        return;
    L7:
        if (this.f34348k != null) goto L13;
        if (r110.a(this.f34340b) == false) goto L13;
        this.f34348k = r110;     // Catch: Throwable -> L17
        long r102 = r110.f34361a;     // Catch: Throwable -> L17
        r101 = new f.C0680f(r102, r110.f34362b - r102, this.f34346i, r110.f34363c, r110.f34364d, r110.f34365e);     // Catch: Throwable -> L17
        goto L14
    }

    public final void s(u r110) {
        Intrinsics.checkNotNullParameter(r110, "timing");
        Object r100 = this.f34342d;
        monitor-enter(r100);
    L22:
        th = move-exception;
        throw th;
    L5:
        if (this.f34343e == true) goto L18;
        long r101 = this.f34340b;     // Catch: Throwable -> L22
        long r102 = r110.f34381a;     // Catch: Throwable -> L22
        if (r102 >= r101) goto L9;
    L13:
        boolean r103 = false;
    L14:
        if (r103 == false) goto L18;
        long r104 = r110.f34381a;     // Catch: Throwable -> L22
        f.c r111 = new f.c(r104, r110.f34382b - r104, this.f34346i, r110.f34383c);     // Catch: Throwable -> L22
    L19:
        monitor-exit(r100);
        q("recordScriptEvaluation", r111);
        return;
    L9:
        if (r110.f34382b < r102) goto L13;
        r103 = true;
        if ((!StringsKt.isBlank(r110.f34383c)) == false) goto L13;
    L18:
        r111 = null;
        goto L19
    }

    public static Long e(Long r100, Long r101) {
        if (r100 == null) goto L7;
        if (r101 == null) goto L7;
        if (r101.longValue() < r100.longValue()) goto L7;
        return Long.valueOf(r101.longValue() - r100.longValue());
    L7:
        return null;
    }

    public final boolean q(String r100, f r101) {
        if (r101 != null) goto L5;
        c r102 = this.f34339a;
        String r103 = "invalid, duplicate, or closed trace: " + this.f34341c;
        r102.getClass();
        c.k(r100, r103);
        return false;
    L5:
        this.f34339a.j(r101);
        return true;
    }

    public l(c r100, long r101, Function1<? super Long, ? extends i> r102) {
        Intrinsics.checkNotNullParameter(r100, "owner");
        Intrinsics.checkNotNullParameter(r102, "sourceFactory");
        super(r100, r101);
        this.f34345h = new com.bytedance.ai.applet.base.log.d("BaseRenderPerformanceTracker", String.valueOf(this.f34341c));
        i r103 = r102.invoke(Long.valueOf(this.f34341c));
        this.f34346i = r103;
        String r104 = null;
        if ((r103 instanceof g.a) == false) goto L5;
        g.a r105 = (g.a) r103;
    L6:
        if (r105 == null) goto L8;
        r104 = r105.f34328b;
    L8:
        this.f34347j = r104;
        return;
    L5:
        r105 = null;
        goto L6
    }
}
