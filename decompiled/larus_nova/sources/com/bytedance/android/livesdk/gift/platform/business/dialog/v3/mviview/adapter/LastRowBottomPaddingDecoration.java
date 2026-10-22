package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview.adapter;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/mviview/adapter/LastRowBottomPaddingDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LastRowBottomPaddingDecoration extends RecyclerView.ItemDecoration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<Boolean> f127797a;

    public LastRowBottomPaddingDecoration(Function0<Boolean> r100) {
        Intrinsics.checkNotNullParameter(r100, "canShowDecoration");
        this.f127797a = r100;
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
        if (r105 != null) goto L8;
        return;
    L8:
        int r106 = r102.getChildAdapterPosition(r101);
        if (r105.getSpanSizeLookup().getSpanSize(0) != r105.getSpanCount()) goto L11;
        boolean r107 = true;
    L12:
        int r108 = r105.getSpanSizeLookup().getSpanGroupIndex(r106, r105.getSpanCount());
        RecyclerView.Adapter r109 = r102.getAdapter();
        if (r109 == null) goto L25;
        int r110 = r109.getItemCount();
        if (r107 == true) goto L17;
        int r111 = (r110 - 1) / 4;
    L18:
        if (r108 != r111) goto L23;
        if (r111 <= 1) goto L23;
        if (this.f127797a.invoke().booleanValue() == false) goto L23;
        r100.bottom = com.bytedance.android.live.revenue.common.i.b(58);
        return;
    L23:
        r100.bottom = 0;
        return;
    L17:
        r111 = ((r110 - 2) / 4) + 1;
        goto L18
    L25:
        return;
    L11:
        r107 = false;
        goto L12
    }
}
