package com.bytedance.android.livesdk.interactivity.enteranim.utils;

import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.bytedance.android.live.base.model.message.h3;
import com.bytedance.android.live.base.model.message.u0;
import com.bytedance.android.livesdk.interactivity.common.enterAnim.BaseWindScreenAnimEnterTrayView;
import com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.animplayer.z;
import com.bytedance.android.livesdk.utils.AnAnimator;
import com.bytedance.android.livesdk.utils.q4;
import java.util.LinkedList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AccelerateDecelerateInterpolator f136773a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f136774b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f136775c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final d f136776d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final e f136777e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f136778f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f136779g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final c f136780h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final View f136781i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final BaseWindScreenAnimEnterTrayView f136782j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final i f136783k;

    public static final class a {
    }

    static {
    }

    public abstract Function1<AnAnimator, Unit> b();

    public abstract Function1<AnAnimator, Unit> c();

    public abstract Function1<AnAnimator, Unit> d();

    public static final void a(b r100) {
        com.bytedance.android.live.base.model.message.e r101 = r100.f136782j.getComboInfo();
        if (r101 != null) goto L5;
        ((q4.b) r100.f136779g.getValue()).c();
        return;
    L5:
        z r102 = (z) r100.f136783k;
        r102.f136731b.o1();
        com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.animplayer.a r103 = r102.f136730a;
        long r104 = r101.b().longValue();
        v72.f r105 = ((v72.c.a) r103).f553444a.f553422e;
        com.bytedance.android.live.base.model.message.d r106 = null;
        if (r105 == null) goto L13;
        LinkedList<k32.d> r107 = r105.f553457a.get(Long.valueOf(r104));
        if (r107 == null) goto L13;
        if (r107.isEmpty() == false) goto L12;
        r105.f553457a.remove(Long.valueOf(r104));
        goto L13
    L12:
        k32.d r108 = r107.removeFirst();
    L14:
        if (r108 != null) goto L16;
    L20:
        u0 r109 = ((z) r100.f136783k).f136732c;
        if (r109 == null) goto L23;
        long r110 = r109.a();
    L24:
        if (r106 != null) goto L26;
    L28:
        ((q4.b) r100.f136779g.getValue()).c();
        return;
    L26:
        if (r100.f136774b >= r110) goto L28;
        r100.f136782j.S5(r106, r100.f136776d);
        return;
    L23:
        r110 = 0;
        goto L24
    L16:
        if (r108.a() == false) goto L20;
        h3 r111 = r108.f501712t;
        if (r111 == null) goto L20;
        r106 = r111.I0();
    L13:
        r108 = null;
        goto L14
    }

    public b(BaseWindScreenAnimEnterTrayView r100, BaseWindScreenAnimEnterTrayView r101, z r102) {
        Intrinsics.checkNotNullParameter(r100, "animView");
        Intrinsics.checkNotNullParameter(r101, "comboView");
        Intrinsics.checkNotNullParameter(r102, "comboAnimBridge");
        this.f136781i = r100;
        this.f136782j = r101;
        this.f136783k = r102;
        this.f136773a = new AccelerateDecelerateInterpolator();
        this.f136775c = LazyKt.lazy(new ComboEnterAnimHelper$enterAnim$2(this));
        this.f136776d = new d(this);
        this.f136777e = new e(this);
        this.f136778f = LazyKt.lazy(new ComboEnterAnimHelper$stayAnim$2(this));
        this.f136779g = LazyKt.lazy(new ComboEnterAnimHelper$exitAnim$2(this));
        this.f136780h = new c(this);
    }
}
