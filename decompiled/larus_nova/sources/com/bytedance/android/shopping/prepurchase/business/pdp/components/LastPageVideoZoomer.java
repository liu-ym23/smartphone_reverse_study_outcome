package com.bytedance.android.shopping.prepurchase.business.pdp.components;

import android.animation.ValueAnimator;
import android.view.View;
import com.bytedance.android.shopping.anchorv3.compat.CompatFrameLayout;
import com.bytedance.android.shopping.prepurchase.business.pdp.repository.PdpDataStore;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes13.dex */
public final class LastPageVideoZoomer {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f181041k = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f181042a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ValueAnimator f181043b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f181044c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f181045d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f181046e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ValueAnimator f181047f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final com.bytedance.android.shopping.prepurchase.arch.container.c<com.bytedance.android.shopping.prepurchase.business.pdp.e, PdpDataStore> f181048g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final com.bytedance.android.shopping.prepurchase.arch.container.component.j f181049h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final n83.m f181050i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final CompatFrameLayout f181051j;

    public static final class a {
    }

    static {
    }

    public final cf.p c() {
        return (cf.p) this.f181045d.getValue();
    }

    public final com.bytedance.android.shopping.prepurchase.business.pdp.e d() {
        return (com.bytedance.android.shopping.prepurchase.business.pdp.e) com.bytedance.android.shopping.prepurchase.arch.container.e.a(this.f181048g);
    }

    public static final String a(LastPageVideoZoomer r100) {
        String r101 = r100.d().f181848a.getNativeParams().getFractionListenerId();
        if (r101 != null) goto L5;
    L7:
        return null;
    L5:
        if (com.bytedance.android.shopping.extensions.k.c(r101) == false) goto L7;
        return r101;
    }

    public final void e(CompatFrameLayout r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        ValueAnimator r101 = this.f181047f;
        if (r101 == null) goto L7;
        if (r101.isRunning() != true) goto L7;
        return;
    L7:
        if (this.f181046e == true) goto L11;
        ValueAnimator r102 = ValueAnimator.ofFloat(new float[]{this.f181044c, -1.0f});
        r102.setDuration(150);
        r102.addUpdateListener(new h(this, r100));
        Unit r103 = Unit.INSTANCE;
        this.f181047f = r102;
        r102.start();
        return;
    }

    public static final void b(LastPageVideoZoomer r100, float r101, View r102) {
        int r103 = r100.d().f181849b.f181036b;
        RangesKt.coerceAtMost(r101, 0.0f);
        n83.m r104 = r100.f181050i;
        if (r104 == null) goto L6;
        r104.a();
    L6:
        if (r101 > 0) goto L8;
        int r105 = (int) (r103 * (1 + r101));
    L10:
        if (r100.f181046e == true) goto L15;
        cf.p r106 = r100.c();
        if (r106 == null) goto L16;
        r106.d(r105, r103, r101);
        return;
    L16:
        return;
    L15:
        return;
    L8:
        r105 = (int) (r103 + ((r102.getHeight() - r103) * r101));
        goto L10
    }

    public LastPageVideoZoomer(com.bytedance.android.shopping.prepurchase.arch.container.c<com.bytedance.android.shopping.prepurchase.business.pdp.e, PdpDataStore> r100, com.bytedance.android.shopping.prepurchase.arch.container.component.j r101, n83.m r102, CompatFrameLayout r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "serviceRegistry");
        Intrinsics.checkNotNullParameter(r103, "rootView");
        this.f181048g = r100;
        this.f181049h = r101;
        this.f181050i = r102;
        this.f181051j = r103;
        this.f181045d = LazyKt.lazy(new LastPageVideoZoomer$listener$2(this));
        this.f181046e = d().f181848a.getNativeParams().getFullMode();
    }
}
