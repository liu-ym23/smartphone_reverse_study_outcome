package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.anya.MVIState;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview.adapter.GiftGridLayoutManager;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftAction;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftPanelState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftSearchViewState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftTopVisibleChanged;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ItemListData;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.OnGiftSearchItemVisibleChanged;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.nova.R;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: classes9.dex */
public final class GiftMVISearchView extends com.bytedance.android.anya.e<GiftPanelState, GiftSearchViewState, GiftAction> {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public zy0.b f127584k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Disposable f127585l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f127586m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Lazy f127587n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public RecyclerView f127588o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final com.bytedance.android.livesdk.gift.configmodel.j1 f127589p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final int f127590q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final int f127591r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f127592s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public IntRange f127593t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Collection<com.bytedance.android.anya.z<GiftSearchViewState, ?, ?>> f127594u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Context f127595v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final ViewGroup f127596w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final ViewGroup f127597x;

    @Override // com.bytedance.android.anya.BaseMVIView
    public final void g() {
        RecyclerView r100 = (RecyclerView) ((View) this.f127586m.getValue()).findViewById(R.id.recycler_view);
        this.f127588o = r100;
        if (r100 == null) goto L9;
        int r101 = this.f127590q;
        if (r101 <= 0) goto L7;
        r100.setItemViewCacheSize(r101);
    L7:
        r100.setLayoutManager(new GiftGridLayoutManager(r100.getContext(), GiftMVISearchView$onAttach$1$1.INSTANCE));
        r100.setItemAnimator(null);
        r100.setClipChildren(false);
        r100.setClipToPadding(false);
        r100.addItemDecoration(new BottomDecoration());
        r100.addOnScrollListener(new GiftMVISearchView$onAttach$$inlined$apply$lambda$1(r100, this));
        return;
    }

    @Override // com.bytedance.android.anya.BaseMVIView
    public final void i() {
        Disposable r100 = this.f127585l;
        if (r100 == null) goto L5;
        r100.dispose();
    L5:
        this.f127585l = null;
        s();
    }

    public final void s() {
        zy0.b r100 = this.f127584k;
        if (r100 == null) goto L5;
        r100.dispose();
    L5:
        FrameLayout r101 = (FrameLayout) this.f127587n.getValue();
        if (r101 == null) goto L8;
        r101.removeAllViews();
    L8:
        this.f127584k = null;
    }

    public final void t() {
        RecyclerView r100 = this.f127588o;
        RecyclerView.LayoutManager r101 = null;
        if (r100 == null) goto L5;
        RecyclerView.LayoutManager r102 = r100.getLayoutManager();
    L7:
        if ((r102 instanceof LinearLayoutManager) == false) goto L10;
        r101 = r102;
    L10:
        LinearLayoutManager r103 = (LinearLayoutManager) r101;
        if (r103 == null) goto L15;
        RecyclerView r104 = this.f127588o;
        if (r104 == null) goto L15;
        IntRange r105 = new IntRange(m02.e.a(r103, r104, 50, true), m02.e.c(r103, r104, 50, true));
    L17:
        if ((true ^ Intrinsics.areEqual(r105, this.f127593t)) == false) goto L20;
        this.f127593t = r105;
        o(new OnGiftSearchItemVisibleChanged(r105));
        return;
    L20:
        return;
    L15:
        r105 = new IntRange(-1, -1);
        goto L17
    L5:
        r102 = null;
        goto L7
    }

    @Override // com.bytedance.android.anya.BaseMVIComposableView
    public final Collection<com.bytedance.android.anya.z<GiftSearchViewState, ?, ?>> p() {
        return this.f127594u;
    }

    @Override // com.bytedance.android.anya.z
    public final void a(com.bytedance.android.anya.dsl.f<GiftPanelState> r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$bindToParent");
        GiftMVISearchView$bindToParent$1 r101 = GiftMVISearchView$bindToParent$1.INSTANCE;
        Collection r102 = r100.f41595a;
        ArrayList r103 = (ArrayList) r102;
        r103.add(new com.bytedance.android.anya.dsl.j(this, r101));
    }

    @Override // com.bytedance.android.anya.BaseMVIView
    public final void k(com.bytedance.android.anya.dsl.a<GiftSearchViewState, GiftAction> r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$registerListAdapters");
        RecyclerView r101 = this.f127588o;
        if (r101 == null) goto L6;
        com.bytedance.android.anya.dsl.a.b(r100, this, GiftMVISearchView$registerListAdapters$1$1.INSTANCE, GiftMVISearchView$registerListAdapters$1$2.INSTANCE, r101);
        return;
    }

    @Override // com.bytedance.android.anya.BaseMVIComposableView
    public final boolean r(com.bytedance.android.anya.a0 r110, Function1<? super com.bytedance.android.anya.a0, Boolean> r111) {
        Intrinsics.checkNotNullParameter(r110, "e");
        Intrinsics.checkNotNullParameter(r111, "dispatchEffect");
        if ((r110 instanceof GiftTopVisibleChanged) == false) goto L17;
        GiftTopVisibleChanged r100 = (GiftTopVisibleChanged) r110;
        if (r100.isSearch() == false) goto L17;
        if (r100.getVisible() == false) goto L12;
        if (this.f127592s == true) goto L12;
        this.f127592s = true;
        ObjectAnimator r101 = ObjectAnimator.ofFloat(this.f127588o, LiveDegradeFpsAnimator.TRANSLATION_Y, new float[]{0.0f, com.bytedance.android.live.revenue.common.i.a(58)});
        r101.setDuration(350);
        r101.setInterpolator(new com.bytedance.android.live.core.widget.h());
        r101.start();
    L12:
        if (r100.getVisible() == true) goto L17;
        if (this.f127592s == false) goto L17;
        this.f127592s = false;
        ObjectAnimator r102 = ObjectAnimator.ofFloat(this.f127588o, LiveDegradeFpsAnimator.TRANSLATION_Y, new float[]{com.bytedance.android.live.revenue.common.i.a(58), 0.0f});
        r102.setDuration(350);
        r102.setInterpolator(new com.bytedance.android.live.core.widget.h());
        r102.start();
    L17:
        return super.r(r110, r111);
    }

    public GiftMVISearchView(Context r100, ViewGroup r101, ViewGroup r102) {
        Intrinsics.checkNotNullParameter(r100, "currentContext");
        Intrinsics.checkNotNullParameter(r101, "containerView");
        Intrinsics.checkNotNullParameter(r102, "parentView");
        this.f127595v = r100;
        this.f127596w = r101;
        this.f127597x = r102;
        this.f127586m = LazyKt.lazy(new GiftMVISearchView$contentView$2(this));
        this.f127587n = LazyKt.lazy(new GiftMVISearchView$searchContainerView$2(this));
        com.bytedance.android.livesdk.gift.configmodel.j1 r103 = com.bytedance.android.livesdk.gift.platform.core.a0.e();
        this.f127589p = r103;
        this.f127590q = r103.C4();
        this.f127591r = r103.y8();
        this.f127593t = new IntRange(-1, -1);
        this.f127594u = CollectionsKt.listOf(new GiftMVISearchComboView(r100, r102));
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // com.bytedance.android.anya.BaseMVIComposableView
    public final void q(com.bytedance.android.anya.k r100, MVIState r101, Function1 r102) {
        GiftSearchViewState r103 = (GiftSearchViewState) r101;
        Intrinsics.checkNotNullParameter(r100, "$this$handleDiff");
        Intrinsics.checkNotNullParameter(r103, "state");
        Intrinsics.checkNotNullParameter(r102, "dispatchDiff");
        com.bytedance.android.anya.r0<GiftSearchViewState, Boolean> r104 = r103.getShow();
        Object r105 = r100.f41740c.a(r104);
        RecyclerView.LayoutManager r106 = null;
        if (r105 == null) goto L34;
        r100.f41739b.f41563a.invoke(r104);
        if (((Boolean) r105).booleanValue() == false) goto L27;
        RecyclerView r107 = this.f127588o;
        if (r107 == null) goto L9;
        r107.setTranslationY(0.0f);
    L9:
        Disposable r108 = this.f127585l;
        if (r108 == null) goto L12;
        r108.dispose();
    L12:
        this.f127585l = null;
        if (this.f127584k == null) goto L15;
        s();
    L15:
        String r109 = nz1.a.i().d();
        if (nz1.a.i().b() == false) goto L18;
        zy0.b r110 = ((vy0.c) com.bytedance.android.live.revenue.core.util.f.a(vy0.c.class)).q8(this.f127595v, UriProtector.parse(r109), null);
    L19:
        this.f127584k = r110;
        if (r110 == null) goto L34;
        FrameLayout r111 = (FrameLayout) this.f127587n.getValue();
        if (r111 == null) goto L24;
        r111.addView(r110.c());
    L24:
        LinkedHashMap r112 = new LinkedHashMap();
        xy0.a<?> r113 = r110.g();
        if (r113 == null) goto L34;
        r113.load(null, r112);
        goto L34
    L18:
        r110 = ((vy0.c) com.bytedance.android.live.revenue.core.util.f.a(vy0.c.class)).J8(this.f127595v, UriProtector.parse(r109), null);
        goto L19
    L27:
        Disposable r114 = this.f127585l;
        if (r114 == null) goto L30;
        r114.dispose();
    L30:
        this.f127585l = Observable.timer(300, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new r0(this));
        RecyclerView r115 = this.f127588o;
        if (r115 == null) goto L33;
        r115.setTranslationY(0.0f);
    L33:
        this.f127592s = false;
    L34:
        com.bytedance.android.anya.t0<GiftSearchViewState, ItemListData> r116 = r103.getSearchItemDataList();
        Object r117 = r100.f41740c.a(r116);
        if (r117 == null) goto L54;
        r100.f41739b.f41563a.invoke(r116);
        this.f127593t = new IntRange(-1, -1);
        if (((com.bytedance.android.anya.s0) r117).isEmpty() == false) goto L47;
        RecyclerView r118 = this.f127588o;
        if (r118 == null) goto L42;
        r106 = r118.getLayoutManager();
    L42:
        if ((r106 instanceof LinearLayoutManager) == false) goto L44;
        r106.scrollToPosition(0);
    L44:
        RecyclerView r119 = this.f127588o;
        if (r119 == null) goto L54;
        r119.setVisibility(8);
        goto L54
    L47:
        RecyclerView r120 = this.f127588o;
        if (r120 != null) goto L50;
    L51:
        t();
        RecyclerView r121 = this.f127588o;
        if (r121 == null) goto L54;
        r121.setVisibility(0);
        goto L54
    L50:
        if (r120.getVisibility() != 0) goto L51;
    L54:
        r102.invoke(r100);
    }
}
