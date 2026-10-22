package com.bytedance.android.shopping.mall.homepage.card.headercard.channel;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/shopping/mall/homepage/card/headercard/channel/GridItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GridItemDecoration extends RecyclerView.ItemDecoration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f177585a;

    public GridItemDecoration(int r100) {
        this.f177585a = r100;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void getItemOffsets(Rect r110, View r111, RecyclerView r112, RecyclerView.State r113) {
        Intrinsics.checkNotNullParameter(r110, "outRect");
        Intrinsics.checkNotNullParameter(r111, "view");
        Intrinsics.checkNotNullParameter(r112, "parent");
        Intrinsics.checkNotNullParameter(r113, "state");
        int r114 = r112.getChildAdapterPosition(r111);
        RecyclerView.LayoutManager r115 = r112.getLayoutManager();
        if ((r115 instanceof GridLayoutManager) == true) goto L5;
        r115 = null;
    L5:
        GridLayoutManager r116 = (GridLayoutManager) r115;
        if (r116 == null) goto L45;
        int r117 = r116.getSpanCount();
        RecyclerView.Adapter r100 = r112.getAdapter();
        if (r100 == null) goto L46;
        int r101 = r100.getItemCount();
        int r102 = 0;
        int r103 = 0;
        int r104 = 0;
        int r105 = 0;
        int r106 = 0;
    L10:
        if (r103 >= r101) goto L25;
        RecyclerView.LayoutManager r107 = r112.getLayoutManager();
        if ((r107 instanceof GridLayoutManager) == true) goto L14;
        r107 = null;
    L14:
        GridLayoutManager r108 = (GridLayoutManager) r107;
        if (r108 == null) goto L19;
        GridLayoutManager.SpanSizeLookup r109 = r108.getSpanSizeLookup();
        if (r109 == null) goto L19;
        int r118 = r109.getSpanSize(r103);
    L20:
        if (r103 > r114) goto L22;
        r105 = r105 + r118;
    L22:
        if (r103 >= r114) goto L24;
        r106 = r106 + r118;
    L24:
        r104 = r104 + r118;
        r103 = r103 + 1;
    L19:
        r118 = 0;
        goto L20
    L25:
        int r119 = this.f177585a;
        if ((r104 - r105) >= r117) goto L28;
        int r120 = 0;
    L30:
        if ((r105 % r117) != 0) goto L32;
        int r121 = 0;
    L33:
        if (r105 > r117) goto L35;
        int r122 = 0;
    L37:
        if ((r106 % r117) == 0) goto L40;
        r102 = r119;
    L40:
        r110.set(r102, r122, r121, r120);
        return;
    L35:
        r122 = r119;
        goto L37
    L32:
        r121 = r119;
        goto L33
    L28:
        r120 = r119;
        goto L30
    L46:
        return;
    }
}
