package com.bytedance.android.shopping.searchsimilar.view;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/searchsimilar/view/ProductCardDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "<init>", "()V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ProductCardDecoration extends RecyclerView.ItemDecoration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f182508a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f182509b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f182510c;

    public ProductCardDecoration() {
        this.f182508a = com.bytedance.android.shopping.extensions.b.b(Double.valueOf(2.5d));
        this.f182509b = com.bytedance.android.shopping.extensions.b.b(9);
        this.f182510c = com.bytedance.android.shopping.extensions.b.b(5);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void getItemOffsets(Rect r100, View r101, RecyclerView r102, RecyclerView.State r103) {
        Intrinsics.checkNotNullParameter(r100, "outRect");
        Intrinsics.checkNotNullParameter(r101, "view");
        Intrinsics.checkNotNullParameter(r102, "parent");
        Intrinsics.checkNotNullParameter(r103, "state");
        ViewGroup.LayoutParams r104 = r101.getLayoutParams();
        if (r104 == null) goto L11;
        if ((((StaggeredGridLayoutManager.LayoutParams) r104).getSpanIndex() % 2) != 0) goto L7;
        r100.left = this.f182509b;
        r100.right = this.f182508a;
    L8:
        r100.top = this.f182510c;
        return;
    L7:
        r100.left = this.f182508a;
        r100.right = this.f182509b;
        goto L8
    L11:
        throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams");
    }
}
