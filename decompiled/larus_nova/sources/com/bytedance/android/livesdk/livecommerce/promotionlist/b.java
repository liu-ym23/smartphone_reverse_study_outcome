package com.bytedance.android.livesdk.livecommerce.promotionlist;

import android.view.ViewGroup;
import com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.LivePromotionListViewModel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f150870a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f150871b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final i f150872c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final j f150873d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final d f150874e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final c f150875f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final LivePromotionListSubscriberDelegate$clickBuyOrItemJsEventSubscriber$1 f150876g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final h f150877h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final e f150878i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final f f150879j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final k f150880k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final g f150881l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f150882m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final com.bytedance.android.livesdk.livecommerce.promotionlist.a f150883n;

    public static final class a {
    }

    static {
    }

    public b(LivePromotionListFragment.d r100) {
        Intrinsics.checkNotNullParameter(r100, "argument");
        this.f150883n = r100;
        this.f150870a = LazyKt.lazy(new LivePromotionListSubscriberDelegate$freshPromotionListJsEventSubscriber$2(this));
        this.f150871b = LazyKt.lazy(new LivePromotionListSubscriberDelegate$addressUpdateBackJsEventSubscriber$2(this));
        this.f150872c = new i(this);
        this.f150873d = new j(this);
        this.f150874e = new d(this);
        this.f150875f = new c(this);
        this.f150876g = new LivePromotionListSubscriberDelegate$clickBuyOrItemJsEventSubscriber$1(this);
        this.f150877h = new h(this);
        this.f150878i = new e(this);
        this.f150879j = new f(this);
        this.f150880k = new k(this);
        this.f150881l = new g(this);
        this.f150882m = LazyKt.lazy(new LivePromotionListSubscriberDelegate$orientationListener$2(this));
    }

    public static final void a(b r100, boolean r101) {
        LivePromotionListViewModel r102 = r100.f150883n.f();
        if (r102 != null) goto L5;
    L7:
        ViewGroup r103 = r100.f150883n.getRootView();
        if (r103 != null) goto L10;
        return;
    L10:
        if (r101 == false) goto L12;
        r103.animate().translationY(0.0f).setDuration(300).start();
        return;
    L12:
        r103.animate().translationY(r103.getMeasuredHeight()).setDuration(300).start();
        return;
    L5:
        if (r102.isInSplitScreen() != true) goto L7;
    }
}
