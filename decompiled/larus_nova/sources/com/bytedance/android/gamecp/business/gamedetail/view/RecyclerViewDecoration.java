package com.bytedance.android.gamecp.business.gamedetail.view;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.gamecp.common.utils.y0;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/gamecp/business/gamedetail/view/RecyclerViewDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RecyclerViewDecoration extends RecyclerView.ItemDecoration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f55729a;

    public RecyclerViewDecoration() {
        boolean r100 = false;
        this(r100, 3);
    }

    public RecyclerViewDecoration(int r100) {
        Paint r101 = new Paint();
        this.f55729a = r101;
        r101.setAntiAlias(true);
        r101.setColor(r100);
    }

    public /* synthetic */ RecyclerViewDecoration(boolean r100, int r101) {
        if ((r101 & 1) == 0) goto L6;
        com.bytedance.android.gamecp.business.gamedetail.h.a();
    L6:
        if ((r101 & 2) == 0) goto L8;
        int r102 = y0.c(R.color.gamecp_game_F8F8F8);
    L9:
        this(r102);
        return;
    L8:
        r102 = 0;
        goto L9
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void onDraw(Canvas r100, RecyclerView r101, RecyclerView.State r102) {
        Intrinsics.checkNotNullParameter(r100, "c");
        Intrinsics.checkNotNullParameter(r101, "parent");
        Intrinsics.checkNotNullParameter(r102, "state");
        int r103 = r101.getChildCount();
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L11;
        View r105 = r101.getChildAt(r104);
        int r106 = r101.getChildAdapterPosition(r105);
        if (r106 == 0) goto L10;
        if (r106 == 1) goto L9;
        r100.drawRect(new Rect(0, r105.getTop() - y0.b(8.0f), y0.g(), r105.getTop()), this.f55729a);
        goto L10
    L9:
        r100.drawRect(new Rect(0, r105.getTop() - y0.b(20.0f), y0.g(), r105.getTop()), this.f55729a);
    L10:
        r104 = r104 + 1;
        goto L3
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void getItemOffsets(Rect r100, View r101, RecyclerView r102, RecyclerView.State r103) {
        Intrinsics.checkNotNullParameter(r100, "outRect");
        Intrinsics.checkNotNullParameter(r101, "view");
        Intrinsics.checkNotNullParameter(r102, "parent");
        Intrinsics.checkNotNullParameter(r103, "state");
        int r104 = r102.getChildAdapterPosition(r101);
        if (r104 != 0) goto L5;
        r100.top = y0.b(0.0f);
        return;
    L5:
        if (r104 == 1) goto L7;
        r100.top = y0.b(8.0f);
        return;
    L7:
        r100.top = y0.b(16.0f);
    }
}
