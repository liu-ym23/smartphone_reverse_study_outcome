package com.bytedance.android.window.shop.widget;

import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/window/shop/widget/ScrollLoadMoreListener;", "Landroidx/recyclerview/widget/RecyclerView;", "R", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class ScrollLoadMoreListener<R extends RecyclerView> extends RecyclerView.OnScrollListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f189857a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f189858b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f189859c;

    public abstract int j(R r100);

    public abstract void k();

    public abstract void l();

    public ScrollLoadMoreListener() {
        this.f189857a = RangesKt.coerceAtLeast(10, 1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public final void onScrolled(RecyclerView r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        if (this.f189858b == false) goto L5;
        return;
    L5:
        if (this.f189859c == true) goto L24;
        int r103 = j(r100);
        RecyclerView.LayoutManager r104 = r100.getLayoutManager();
        if (r104 != null) goto L11;
        return;
    L11:
        if (r103 < (r104.getItemCount() - this.f189857a)) goto L23;
        this.f189858b = true;
        k();
        if (this.f189859c == true) goto L25;
        if (r101 != 0) goto L20;
        if (r102 != 0) goto L20;
        if (r100.getScrollState() != 0) goto L20;
        return;
    L20:
        l();
        return;
    L25:
        return;
    L23:
        return;
    }
}
