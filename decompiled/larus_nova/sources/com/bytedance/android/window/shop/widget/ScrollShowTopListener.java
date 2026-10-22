package com.bytedance.android.window.shop.widget;

import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/window/shop/widget/ScrollShowTopListener;", "Landroidx/recyclerview/widget/RecyclerView;", "R", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class ScrollShowTopListener<R extends RecyclerView> extends RecyclerView.OnScrollListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f189860a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<Integer, Unit> f189861b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1<Boolean, Unit> f189862c;

    public final void j(int r100) {
        int r101 = this.f189860a;
        if (r101 > 0) goto L5;
        return;
    L5:
        if (r100 < r101) goto L7;
        boolean r102 = true;
    L8:
        this.f189862c.invoke(Boolean.valueOf(r102));
        return;
    L7:
        r102 = false;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ScrollShowTopListener(Function1<? super Integer, Unit> r100, Function1<? super Boolean, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "onStateChanged");
        Intrinsics.checkNotNullParameter(r101, "onUpdated");
        this.f189861b = r100;
        this.f189862c = r101;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public final void onScrollStateChanged(RecyclerView r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        super.onScrollStateChanged(r100, r101);
        this.f189861b.invoke(Integer.valueOf(r101));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public final void onScrolled(RecyclerView r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        int r103 = ((ECShopRecyclerView) r100).t();
        if (r100 == null) goto L13;
        int r104 = ((ECShopRecyclerView) r100).r();
        if (this.f189860a > 0) goto L10;
        int r105 = (r103 - r104) + 1;
        if (r105 <= 1) goto L10;
        this.f189860a = r105;
    L10:
        j(r104);
        return;
    L13:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.window.shop.widget.ECShopRecyclerView");
    }
}
