package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview.adapter;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class l extends RecyclerView.ItemDecoration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f127857a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f127858b;

    public l(int r100) {
        this.f127857a = r100;
        this.f127858b = 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void getItemOffsets(Rect r100, View r101, RecyclerView r102, RecyclerView.State r103) {
        Intrinsics.checkNotNullParameter(r100, "outRect");
        Intrinsics.checkNotNullParameter(r101, "view");
        Intrinsics.checkNotNullParameter(r102, "parent");
        Intrinsics.checkNotNullParameter(r103, "state");
        super.getItemOffsets(r100, r101, r102, r103);
        RecyclerView.LayoutManager r104 = r102.getLayoutManager();
        if ((r104 instanceof GridLayoutManager) == true) goto L5;
        r104 = null;
    L5:
        GridLayoutManager r105 = (GridLayoutManager) r104;
        int r106 = r102.getChildAdapterPosition(r101);
        if (r105 == null) goto L18;
        int r107 = r105.getSpanSizeLookup().getSpanGroupIndex(r106, r105.getSpanCount());
        if (r107 != 0) goto L10;
        r100.top = this.f127857a;
    L11:
        RecyclerView.Adapter r108 = r102.getAdapter();
        if (r108 == null) goto L19;
        int r109 = (r108.getItemCount() - 1) / 4;
        if (r107 != r109) goto L20;
        if (r109 <= 1) goto L21;
        r100.bottom = com.bytedance.android.live.revenue.common.i.b(58);
        return;
    L21:
        return;
    L20:
        return;
    L19:
        return;
    L10:
        r100.top = -this.f127858b;
        goto L11
    }
}
