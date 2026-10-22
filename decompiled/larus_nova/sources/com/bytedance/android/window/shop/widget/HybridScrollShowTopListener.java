package com.bytedance.android.window.shop.widget;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/window/shop/widget/HybridScrollShowTopListener;", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class HybridScrollShowTopListener extends RecyclerView.OnScrollListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f189854a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<Integer, Unit> f189855b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1<Boolean, Unit> f189856c;

    /* JADX WARN: Multi-variable type inference failed */
    public HybridScrollShowTopListener(Function1<? super Integer, Unit> r100, Function1<? super Boolean, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "onStateChanged");
        Intrinsics.checkNotNullParameter(r101, "onUpdated");
        this.f189855b = r100;
        this.f189856c = r101;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public final void onScrollStateChanged(RecyclerView r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        super.onScrollStateChanged(r100, r101);
        this.f189855b.invoke(Integer.valueOf(r101));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public final void onScrolled(RecyclerView r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        RecyclerView.LayoutManager r103 = r100.getLayoutManager();
        RecyclerView.LayoutManager r104 = null;
        if ((r103 instanceof LinearLayoutManager) == true) goto L5;
        r103 = null;
    L5:
        LinearLayoutManager r105 = (LinearLayoutManager) r103;
        boolean r106 = false;
        if (r105 == null) goto L8;
        int r107 = r105.findLastVisibleItemPosition();
    L9:
        RecyclerView.LayoutManager r108 = r100.getLayoutManager();
        if ((r108 instanceof LinearLayoutManager) == false) goto L13;
        r104 = r108;
    L13:
        LinearLayoutManager r109 = (LinearLayoutManager) r104;
        if (r109 == null) goto L16;
        int r110 = r109.findFirstCompletelyVisibleItemPosition();
    L18:
        if (this.f189854a > 0) goto L23;
        int r111 = (r107 - r110) + 1;
        if (r111 <= 1) goto L23;
        this.f189854a = r111;
    L23:
        int r112 = this.f189854a;
        if (r112 <= 0) goto L30;
        if (r110 < r112) goto L28;
        r106 = true;
    L28:
        this.f189856c.invoke(Boolean.valueOf(r106));
        return;
    L30:
        return;
    L16:
        r110 = 0;
        goto L18
    L8:
        r107 = 0;
        goto L9
    }
}
