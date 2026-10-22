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
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/gamecp/business/gamedetail/view/CommentRecyclerViewDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommentRecyclerViewDecoration extends RecyclerView.ItemDecoration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f55647a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f55648b;

    public CommentRecyclerViewDecoration() {
        this(0);
    }

    public CommentRecyclerViewDecoration(int r100) {
        this.f55648b = com.bytedance.android.gamecp.business.gamedetail.h.a();
        Paint r101 = new Paint();
        this.f55647a = r101;
        r101.setAntiAlias(true);
        r101.setColor(y0.c(R.color.gamecp_game_F8F8F8));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void onDraw(Canvas r100, RecyclerView r101, RecyclerView.State r102) {
        Intrinsics.checkNotNullParameter(r100, "c");
        Intrinsics.checkNotNullParameter(r101, "parent");
        Intrinsics.checkNotNullParameter(r102, "state");
        if (this.f55648b == false) goto L6;
        return;
    L6:
        if (r101.getChildCount() <= 0) goto L9;
        View r103 = r101.getChildAt(0);
        r100.drawRect(new Rect(0, r103.getTop() - y0.b(8.0f), y0.g(), r103.getTop()), this.f55647a);
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void getItemOffsets(Rect r100, View r101, RecyclerView r102, RecyclerView.State r103) {
        Intrinsics.checkNotNullParameter(r100, "outRect");
        Intrinsics.checkNotNullParameter(r101, "view");
        Intrinsics.checkNotNullParameter(r102, "parent");
        Intrinsics.checkNotNullParameter(r103, "state");
        if (r102.getChildAdapterPosition(r101) == 0) goto L5;
        r100.top = y0.b(0.0f);
        return;
    L5:
        r100.top = y0.b(8.0f);
    }
}
