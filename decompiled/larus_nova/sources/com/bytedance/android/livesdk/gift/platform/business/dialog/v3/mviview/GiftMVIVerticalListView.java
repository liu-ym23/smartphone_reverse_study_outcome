package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.MVIViewPagerAdapter;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview.adapter.GiftViewPager;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview.adapter.LazyMVIViewPagerAdapter;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ChangeViewPagerPositionEffect;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftAction;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftListViewState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftVerticalState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.PagerListData;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ViewPagerPositionChanged;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class GiftMVIVerticalListView extends com.bytedance.android.anya.e<GiftListViewState, GiftVerticalState, GiftAction> {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final /* synthetic */ int f127651w = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f127652k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final GiftViewPager f127653l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f127654m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Lazy f127655n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Lazy f127656o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public LazyMVIViewPagerAdapter<PagerListData, GiftAction> f127657p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f127658q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final View f127659r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final View f127660s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Collection<com.bytedance.android.anya.z<GiftVerticalState, ?, ?>> f127661t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Context f127662u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Function0<Boolean> f127663v;

    public static final class a {
    }

    static {
    }

    public final View t() {
        return (View) this.f127652k.getValue();
    }

    public final boolean u() {
        return ((Boolean) this.f127654m.getValue()).booleanValue();
    }

    @Override // com.bytedance.android.anya.BaseMVIView
    public final void g() {
        this.f127659r.setVisibility(8);
        this.f127660s.setVisibility(8);
        if (u() == true) goto L5;
        return;
    L5:
        if (this.f127658q == true) goto L15;
        ViewTreeObserver r100 = t().getViewTreeObserver();
        if (r100 != null) goto L10;
    L12:
        this.f127658q = true;
        r100.addOnGlobalLayoutListener(new g1(this));
        return;
    L10:
        if (r100.isAlive() == true) goto L12;
        return;
    }

    @Override // com.bytedance.android.anya.BaseMVIView
    public final void i() {
        if (u() == false) goto L16;
        LazyMVIViewPagerAdapter<PagerListData, GiftAction> r100 = this.f127657p;
        if (r100 == null) goto L17;
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L11
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview.adapter.b0 r102 = r100.f127805k;     // Catch: Throwable -> L11
        if (r102 == null) goto L9;
        r100.f127806l.removeCallbacks(r102);     // Catch: Throwable -> L11
    L9:
        r100.f127805k = null;     // Catch: Throwable -> L11
        ((LinkedHashMap) r100.f127801g).clear();     // Catch: Throwable -> L11
        ((LinkedHashMap) r100.f127802h).clear();     // Catch: Throwable -> L11
        r100.f127804j.clear();     // Catch: Throwable -> L11
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        return;
    L17:
        return;
    }

    public final Context getContext() {
        return this.f127662u;
    }

    @Override // com.bytedance.android.anya.BaseMVIComposableView
    public final Collection<com.bytedance.android.anya.z<GiftVerticalState, ?, ?>> p() {
        return this.f127661t;
    }

    public static final /* synthetic */ LazyMVIViewPagerAdapter s(GiftMVIVerticalListView r100) {
        LazyMVIViewPagerAdapter<PagerListData, GiftAction> r101 = r100.f127657p;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("lazyPagerAdapter");
    L5:
        return r101;
    }

    @Override // com.bytedance.android.anya.z
    public final void a(com.bytedance.android.anya.dsl.f<GiftListViewState> r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$bindToParent");
        GiftMVIVerticalListView$bindToParent$1 r101 = GiftMVIVerticalListView$bindToParent$1.INSTANCE;
        Collection r102 = r100.f41595a;
        ArrayList r103 = (ArrayList) r102;
        r103.add(new com.bytedance.android.anya.dsl.j(this, r101));
    }

    @Override // com.bytedance.android.anya.BaseMVIView
    public final void l(com.bytedance.android.anya.dsl.c<GiftVerticalState, GiftAction> r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$registerPagerAdapters");
        GiftMVIVerticalListView$registerPagerAdapters$1 r101 = GiftMVIVerticalListView$registerPagerAdapters$1.INSTANCE;
        Function3<ViewGroup, Integer, Integer, com.bytedance.android.anya.c<PagerListData, GiftAction>> r102 = new GiftMVIVerticalListView$registerPagerAdapters$2(this);
        GiftViewPager r103 = this.f127653l;
        Function1<Function3<? super ViewGroup, ? super Integer, ? super Integer, ? extends com.bytedance.android.anya.c<PagerListData, GiftAction>>, MVIViewPagerAdapter<PagerListData, GiftAction>> r104 = new GiftMVIVerticalListView$registerPagerAdapters$3(this);
        Collection r105 = r100.f41590a;
        ArrayList r106 = (ArrayList) r105;
        r106.add(new com.bytedance.android.anya.dsl.d(r101, r102, r103, r104));
    }

    @Override // com.bytedance.android.anya.BaseMVIComposableView
    public final boolean r(com.bytedance.android.anya.a0 r100, Function1<? super com.bytedance.android.anya.a0, Boolean> r101) {
        Intrinsics.checkNotNullParameter(r100, "e");
        Intrinsics.checkNotNullParameter(r101, "dispatchEffect");
        if ((r100 instanceof ChangeViewPagerPositionEffect) == false) goto L6;
        ChangeViewPagerPositionEffect r102 = (ChangeViewPagerPositionEffect) r100;
        this.f127653l.setCurrentItem(r102.getPagerPosition());
        o(new ViewPagerPositionChanged(r102.getPagerPosition()));
        return true;
    L6:
        r101.invoke(r100);
        return false;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // com.bytedance.android.anya.BaseMVIComposableView
    public final void q(com.bytedance.android.anya.k r100, MVIState r101, Function1 r102) {
        GiftVerticalState r103 = (GiftVerticalState) r101;
        Intrinsics.checkNotNullParameter(r100, "$this$handleDiff");
        Intrinsics.checkNotNullParameter(r103, "state");
        Intrinsics.checkNotNullParameter(r102, "dispatchDiff");
        com.bytedance.android.anya.r0<GiftVerticalState, Integer> r104 = r103.getCurrentPagePosition();
        Object r105 = r100.f41740c.a(r104);
        if (r105 == null) goto L5;
        r100.f41739b.f41563a.invoke(r104);
        int r106 = ((Number) r105).intValue();
        this.f127653l.setCurrentItem(r106);
    L5:
        r102.invoke(r100);
    }

    public GiftMVIVerticalListView(Context r100, final ViewGroup r101, ViewGroup r102, Function0<Boolean> r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "containerView");
        Intrinsics.checkNotNullParameter(r102, "parentView");
        Intrinsics.checkNotNullParameter(r103, "animationFun");
        this.f127662u = r100;
        this.f127663v = r103;
        this.f127652k = LazyKt.lazy(new GiftMVIVerticalListView$contentView$2(this, r101));
        final GiftViewPager r104 = (GiftViewPager) t().findViewById(R.id.gift_view_pager);
        r104.addOnPageChangeListener(new GiftMVIVerticalListView$addManualOnPageChangeListener$1(this, r104));
        Unit r105 = Unit.INSTANCE;
        this.f127653l = r104;
        this.f127654m = LazyKt.lazy(GiftMVIVerticalListView$lazyViewPagerOpt$2.INSTANCE);
        this.f127655n = LazyKt.lazy(GiftMVIVerticalListView$checkUpdateCorrect$2.INSTANCE);
        this.f127656o = LazyKt.lazy(GiftMVIVerticalListView$checkUpdateDelay$2.INSTANCE);
        this.f127659r = t().findViewById(R.id.mask_view);
        this.f127660s = t().findViewById(R.id.mask_view_bottom);
        this.f127661t = CollectionsKt.listOf(new GiftMVIComboView(r100, r102));
    }
}
