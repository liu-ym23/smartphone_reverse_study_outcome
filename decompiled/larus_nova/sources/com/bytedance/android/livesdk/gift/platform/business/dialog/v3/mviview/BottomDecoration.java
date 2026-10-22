package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/mviview/BottomDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "<init>", "()V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BottomDecoration extends RecyclerView.ItemDecoration {
    public BottomDecoration() {
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
        if (r105 == null) goto L14;
        int r107 = r105.getSpanSizeLookup().getSpanGroupIndex(r106, r105.getSpanCount());
        RecyclerView.Adapter r108 = r102.getAdapter();
        if (r108 == null) goto L15;
        int r109 = (r108.getItemCount() - 1) / 4;
        if (r107 != r109) goto L16;
        if (r109 <= 1) goto L17;
        r100.bottom = com.bytedance.android.live.revenue.common.i.b(58);
        return;
    L17:
        return;
    L16:
        return;
    L15:
        return;
    }
}
