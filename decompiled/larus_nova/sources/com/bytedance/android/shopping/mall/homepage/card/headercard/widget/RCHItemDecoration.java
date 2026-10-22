package com.bytedance.android.shopping.mall.homepage.card.headercard.widget;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/shopping/mall/homepage/card/headercard/widget/RCHItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RCHItemDecoration extends RecyclerView.ItemDecoration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f177934a;

    public RCHItemDecoration(int r100) {
        this.f177934a = r100;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void getItemOffsets(Rect r100, View r101, RecyclerView r102, RecyclerView.State r103) {
        Intrinsics.checkNotNullParameter(r100, "outRect");
        Intrinsics.checkNotNullParameter(r101, "view");
        Intrinsics.checkNotNullParameter(r102, "parent");
        Intrinsics.checkNotNullParameter(r103, "state");
        int r104 = r102.getChildAdapterPosition(r101);
        RecyclerView.Adapter r105 = r102.getAdapter();
        if (r105 != null) goto L5;
        return;
    L5:
        if (r104 >= (r105.getItemCount() - 1)) goto L9;
        r100.right = this.f177934a;
        return;
    }
}
