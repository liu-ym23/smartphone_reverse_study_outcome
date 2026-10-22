package com.bytedance.android.shopping.searchsimilar.view;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/searchsimilar/view/ProductFrameDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "<init>", "()V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ProductFrameDecoration extends RecyclerView.ItemDecoration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f182511a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f182512b;

    public ProductFrameDecoration() {
        this.f182511a = com.bytedance.android.shopping.extensions.b.b(12);
        this.f182512b = com.bytedance.android.shopping.extensions.b.b(16);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void getItemOffsets(Rect r100, View r101, RecyclerView r102, RecyclerView.State r103) {
        Intrinsics.checkNotNullParameter(r100, "outRect");
        Intrinsics.checkNotNullParameter(r101, "view");
        Intrinsics.checkNotNullParameter(r102, "parent");
        Intrinsics.checkNotNullParameter(r103, "state");
        RecyclerView.Adapter r104 = r102.getAdapter();
        if (r104 == null) goto L5;
        int r105 = r104.getItemCount();
    L6:
        if (r105 != 0) goto L8;
        return;
    L8:
        if (r102.getChildAdapterPosition(r101) != 0) goto L10;
        r100.left = this.f182512b;
        return;
    L10:
        r100.left = this.f182511a;
        if (r102.getChildAdapterPosition(r101) != (r105 - 1)) goto L16;
        r100.right = this.f182512b;
        return;
    L16:
        return;
    L5:
        r105 = 0;
        goto L6
    }
}
