package com.bytedance.android.window.shop.innerflow.holder.element.presenter;

import android.content.res.Resources;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.bytedance.android.ec.window.base.utils.playable.WindowPlayAbleType;
import com.bytedance.android.window.shop.innerflow.holder.element.barrage.BarrageListAdapter;
import com.bytedance.android.window.shop.innerflow.holder.element.barrage.BarrageRecycleView;
import com.bytedance.android.window.shop.innerflow.widget.ControllerState;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QLiveData;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class ECWindowInnerFlowBarrageElementPresenter extends d<wp3.a> implements tp.c {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final /* synthetic */ int f189066q = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f189067g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f189068h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final BarrageListAdapter f189069i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f189070j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f189071k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public wp3.a f189072l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public tp.b f189073m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Disposable f189074n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final vp.c f189075o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final boolean f189076p;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/window/shop/innerflow/holder/element/presenter/ECWindowInnerFlowBarrageElementPresenter$SpacesItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public final class SpacesItemDecoration extends RecyclerView.ItemDecoration {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f189077a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f189078b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f189079c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f189080d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ ECWindowInnerFlowBarrageElementPresenter f189081e;

        public SpacesItemDecoration(ECWindowInnerFlowBarrageElementPresenter r100, int r101, int r102) {
            this.f189081e = r100;
            this.f189077a = r101;
            this.f189078b = r102;
            this.f189079c = 0;
            this.f189080d = 0;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public final void getItemOffsets(Rect r100, View r101, RecyclerView r102, RecyclerView.State r103) {
            Intrinsics.checkNotNullParameter(r100, "outRect");
            Intrinsics.checkNotNullParameter(r101, "view");
            Intrinsics.checkNotNullParameter(r102, "parent");
            Intrinsics.checkNotNullParameter(r103, "state");
            r100.left = this.f189077a;
            r100.right = this.f189079c;
            r100.bottom = this.f189080d;
            r100.top = this.f189078b;
            ViewGroup.LayoutParams r104 = r101.getLayoutParams();
            if (r104 == null) goto L13;
            int r105 = ((RecyclerView.LayoutParams) r104).getViewLayoutPosition();
            if (r105 != 0) goto L7;
            r100.left = this.f189081e.f189071k;
            return;
        L7:
            if (r105 == 1) goto L9;
            r100.left = this.f189077a;
            return;
        L9:
            r100.left = this.f189081e.f189071k + com.bytedance.android.shopping.extensions.b.b(60);
            return;
        L13:
            throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
        }
    }

    public static final class a {
    }

    static {
    }

    @Override // tp.c
    public final boolean D3() {
        return true;
    }

    @Override // com.bytedance.android.window.shop.innerflow.holder.element.presenter.d
    public final void E() {
        this.f189072l = null;
        BarrageListAdapter r100 = this.f189069i;
        ((ArrayList) r100.f189057a).clear();
        r100.notifyDataSetChanged();
    }

    public final BarrageRecycleView F() {
        return (BarrageRecycleView) this.f189070j.getValue();
    }

    @Override // tp.c
    public final Rect r() {
        return null;
    }

    public final void G() {
        wp3.a r100 = this.f189072l;
        if (r100 == null) goto L9;
        RecyclerView.Adapter r101 = F().getAdapter();
        if (r101 == null) goto L8;
        BarrageListAdapter r102 = (BarrageListAdapter) r101;
        Intrinsics.checkNotNullParameter(r100, "vo");
        ((ArrayList) r102.f189057a).clear();
        r102.notifyDataSetChanged();
        List<wp3.a.C8143a> r103 = r102.f189057a;
        ArrayList r104 = (ArrayList) r103;
        r104.addAll(r100.f560566a);
        r102.notifyItemRangeInserted(0, r100.f560566a.size());
        return;
    L8:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.window.shop.innerflow.holder.element.barrage.BarrageListAdapter");
    }

    public final void I() {
        Disposable r100 = this.f189074n;
        if (r100 == null) goto L5;
        r100.dispose();
    L5:
        this.f189074n = com.bytedance.android.ec.core.rxjava.a.a(0, 2000, TimeUnit.MILLISECONDS).subscribeOn(Schedulers.computation()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.bytedance.android.window.shop.innerflow.holder.element.presenter.a(this), b.f189142a, c.f189143a);
    }

    @Override // tp.c
    public final void R() {
        if (((ControllerState) ((QLiveData) this.f189068h.getValue()).a()) != ControllerState.DISABLED) goto L5;
        return;
    L5:
        G();
        F().setVisibility(0);
        I();
    }

    @Override // tp.c
    public final boolean isPlaying() {
        Disposable r100 = this.f189074n;
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r100.isDisposed() == true) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // tp.c
    public final void v() {
        Disposable r100 = this.f189074n;
        if (r100 == null) goto L5;
        r100.dispose();
    L5:
        this.f189074n = null;
    }

    @Override // tp.c
    public final void B() {
        F().setVisibility(8);
        Disposable r100 = this.f189074n;
        if (r100 == null) goto L5;
        r100.dispose();
    L5:
        this.f189074n = null;
    }

    @Override // tp.c
    public final boolean g0() {
        I();
        return true;
    }

    @Override // tp.c
    public final void pausePlay() {
        v();
        M();
    }

    @Override // tp.c
    public final boolean resumePlay() {
        g0();
        U0();
        return true;
    }

    @Override // tp.c
    public final void startPlay() {
        R();
        x();
    }

    @Override // tp.c
    public final void stopPlay() {
        B();
        z();
    }

    @Override // tp.c
    public final void M() {
        tp.c.a.a(this);
    }

    @Override // tp.c
    public final WindowPlayAbleType P() {
        return WindowPlayAbleType.OTHER;
    }

    @Override // tp.c
    public final void U0() {
        tp.c.a.b(this);
    }

    @Override // tp.c
    public final tp.b m() {
        return this.f189073m;
    }

    @Override // tp.c
    public final void x() {
        tp.c.a.c(this);
    }

    @Override // tp.c
    public final void z() {
        tp.c.a.d(this);
    }

    @Override // com.bytedance.android.window.shop.innerflow.holder.element.presenter.d
    public final void D(wp3.a r100) {
        wp3.a r101 = r100;
        if (F().getAdapter() != null) goto L5;
        F().setAdapter(this.f189069i);
        F().setLayoutManager(new StaggeredGridLayoutManager(2, 0));
        SpacesItemDecoration r102 = new SpacesItemDecoration(this, com.bytedance.android.shopping.extensions.b.b(42), com.bytedance.android.shopping.extensions.b.b(11));
        F().addItemDecoration(r102);
    L8:
        this.f189072l = r101;
        Resources r103 = u().c().getResources();
        this.f189071k = WindowDisplayMetricsOverride.apply(r103, r103.getDisplayMetrics()).widthPixels;
        this.f189075o.f556543a = this;
        G();
        return;
    L5:
        RecyclerView.Adapter r104 = F().getAdapter();
        if (r104 == null) goto L11;
        BarrageListAdapter r105 = (BarrageListAdapter) r104;
        ((ArrayList) r105.f189057a).clear();
        r105.notifyDataSetChanged();
        goto L8
    L11:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.window.shop.innerflow.holder.element.barrage.BarrageListAdapter");
    }

    @Override // tp.c
    public final List<tp.c> L(Rect r100) {
        Intrinsics.checkNotNullParameter(r100, "visibleArea");
        if (this.f189076p == false) goto L6;
        return CollectionsKt.listOf(this);
    L6:
        return CollectionsKt.emptyList();
    }

    @Override // tp.c
    public final void o2(tp.b r100) {
        this.f189073m = r100;
    }

    public ECWindowInnerFlowBarrageElementPresenter(vp.c r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "barrageElementPlayerProxy");
        super(yp3.a.f568699a);
        this.f189075o = r100;
        this.f189076p = r101;
        this.f189067g = LazyKt.lazy(new ECWindowInnerFlowBarrageElementPresenter$viewModel$2(this));
        this.f189068h = LazyKt.lazy(new ECWindowInnerFlowBarrageElementPresenter$barrageState$2(this));
        this.f189069i = new BarrageListAdapter();
        this.f189070j = LazyKt.lazy(new ECWindowInnerFlowBarrageElementPresenter$recyclerView$2(this));
    }
}
