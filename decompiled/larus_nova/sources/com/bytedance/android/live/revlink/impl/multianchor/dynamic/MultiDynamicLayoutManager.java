package com.bytedance.android.live.revlink.impl.multianchor.dynamic;

import io.reactivex.disposables.CompositeDisposable;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class MultiDynamicLayoutManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompositeDisposable f93852a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public i f93853b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final MultiDynamicLayoutManager$windowStatusObserver$1 f93854c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final x51.a f93855d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.d f93856e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function0<Unit> f93857f;

    public static final class a {
    }

    static {
    }

    public final void a(com.bytedance.android.live.revlink.impl.lynxcontainer.b r110, zy0.b r111) {
        Intrinsics.checkNotNullParameter(r110, "lynxViewParams");
        i r100 = this.f93853b;
        if (r100 != null) goto L6;
        return;
    L6:
        if (r110.q() <= 0) goto L8;
        int r101 = com.bytedance.android.live.revenue.common.i.b(r110.q());
    L9:
        int r102 = r101;
        if (r110.a() <= 0) goto L12;
        int r103 = com.bytedance.android.live.revenue.common.i.b(r110.a());
    L13:
        int r104 = r103;
        if (r110.h() <= 0) goto L16;
        int r105 = com.bytedance.android.live.revenue.common.i.b(r110.h());
    L18:
        if (r110.l() <= 0) goto L20;
        int r106 = com.bytedance.android.live.revenue.common.i.b(r110.l());
    L22:
        if (r110.j() <= 0) goto L24;
        int r107 = com.bytedance.android.live.revenue.common.i.b(r110.j());
    L26:
        if (r110.f() <= 0) goto L28;
        int r108 = com.bytedance.android.live.revenue.common.i.b(r110.f());
    L29:
        int r109 = r100.f94084c;
        int r112 = r100.f94082a + r109;
        int r113 = r110.c();
        if (r113 == 2) goto L34;
        if (r113 == 3) goto L33;
        int r114 = r109 + r105;
    L35:
        int r115 = r114;
    L36:
        int r116 = r100.f94085d;
        int r117 = r100.f94083b + r116;
        int r118 = r110.p();
        if (r118 == 2) goto L41;
        if (r118 == 3) goto L40;
        int r119 = r116 + r106;
    L42:
        int r120 = r119;
    L43:
        i r121 = new i(r102, r104, r115, r120, r110.s());
        jy0.b.d("MultiDynamicLayoutManager", "updateLynxViewLayout lynxViewParams " + r110);
        jy0.b.d("MultiDynamicLayoutManager", "updateLynxViewLayout " + r121 + ", anchorLayout: " + r100);
        this.f93855d.b(r121, r111, r110.o());
        return;
    L40:
        r120 = (r117 - r108) - r104;
        goto L43
    L41:
        r119 = r116 + (((r117 - r116) - r104) / 2);
        goto L42
    L33:
        r115 = (r112 - r107) - r102;
        goto L36
    L34:
        r114 = r109 + (((r112 - r109) - r102) / 2);
        goto L35
    L28:
        r108 = (int) (r110.g() * r100.f94083b);
        goto L29
    L24:
        r107 = (int) (r110.k() * r100.f94082a);
        goto L26
    L20:
        r106 = (int) (r110.m() * r100.f94083b);
        goto L22
    L16:
        r105 = (int) (r110.i() * r100.f94082a);
        goto L18
    L12:
        r103 = (int) (r110.b() * r100.f94083b);
        goto L13
    L8:
        r101 = (int) (r110.r() * r100.f94082a);
        goto L9
    }

    public MultiDynamicLayoutManager(x51.a r100, com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.d r101, Function0<Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, "linkLynxCentralService");
        Intrinsics.checkNotNullParameter(r102, "notifyLayoutUpdate");
        this.f93855d = r100;
        this.f93856e = r101;
        this.f93857f = r102;
        this.f93852a = new CompositeDisposable();
        this.f93854c = new MultiDynamicLayoutManager$windowStatusObserver$1(this);
    }
}
