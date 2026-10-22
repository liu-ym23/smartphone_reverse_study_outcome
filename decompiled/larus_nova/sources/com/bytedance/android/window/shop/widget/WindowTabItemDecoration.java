package com.bytedance.android.window.shop.widget;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.window.shop.holder.ShopWindowItemHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/window/shop/widget/WindowTabItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "<init>", "()V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WindowTabItemDecoration extends RecyclerView.ItemDecoration {
    public WindowTabItemDecoration() {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void getItemOffsets(Rect r100, View r101, RecyclerView r102, RecyclerView.State r103) {
        Intrinsics.checkNotNullParameter(r100, "outRect");
        Intrinsics.checkNotNullParameter(r101, "view");
        Intrinsics.checkNotNullParameter(r102, "parent");
        Intrinsics.checkNotNullParameter(r103, "state");
        int r104 = r102.getChildAdapterPosition(r101);
        RecyclerView.ViewHolder r105 = r102.findContainingViewHolder(r101);
        if ((r105 instanceof ShopWindowItemHolder) == true) goto L5;
        r105 = null;
    L5:
        ShopWindowItemHolder r106 = (ShopWindowItemHolder) r105;
        if (r106 != null) goto L9;
        super.getItemOffsets(r100, r101, r102, r103);
        return;
    L9:
        Rect r107 = r106.r4(r104);
        r100.top = r107.top;
        r100.left = r107.left;
        r100.right = r107.right;
        r100.bottom = r107.bottom;
    }
}
