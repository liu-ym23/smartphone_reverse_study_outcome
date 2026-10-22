package com.bytedance.android.gamecp.business.imagechoose;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/gamecp/business/imagechoose/GridSpacingItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f56004a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f56005b;

    public GridSpacingItemDecoration(int r100, int r101) {
        this.f56004a = r100;
        this.f56005b = r101;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void getItemOffsets(Rect r100, View r101, RecyclerView r102, RecyclerView.State r103) {
        Intrinsics.checkNotNullParameter(r100, "outRect");
        Intrinsics.checkNotNullParameter(r101, "view");
        Intrinsics.checkNotNullParameter(r102, "parent");
        Intrinsics.checkNotNullParameter(r103, "state");
        int r104 = r102.getChildAdapterPosition(r101);
        int r105 = this.f56004a;
        int r106 = r104 % r105;
        if (r104 < r105) goto L5;
        r100.top = this.f56005b;
    L5:
        int r107 = this.f56005b;
        r100.left = (r106 * r107) / r105;
        r100.right = r107 - (((r106 + 1) * r107) / r105);
    }
}
