package com.bytedance.android.gamecp.business.comment;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/gamecp/business/comment/CommentLabelItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommentLabelItemDecoration extends RecyclerView.ItemDecoration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f51828a;

    public CommentLabelItemDecoration(int r100) {
        this.f51828a = r100;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void getItemOffsets(Rect r100, View r101, RecyclerView r102, RecyclerView.State r103) {
        Intrinsics.checkNotNullParameter(r100, "outRect");
        Intrinsics.checkNotNullParameter(r101, "view");
        Intrinsics.checkNotNullParameter(r102, "parent");
        Intrinsics.checkNotNullParameter(r103, "state");
        super.getItemOffsets(r100, r101, r102, r103);
        RecyclerView.LayoutManager r104 = r102.getLayoutManager();
        if (r104 != null) goto L6;
        return;
    L6:
        if (r102.getChildAdapterPosition(r101) == (r104.getItemCount() - 1)) goto L9;
        r100.right = this.f51828a;
        return;
    }
}
