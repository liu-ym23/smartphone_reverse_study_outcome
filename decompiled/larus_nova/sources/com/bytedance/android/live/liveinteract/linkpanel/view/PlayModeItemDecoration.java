package com.bytedance.android.live.liveinteract.linkpanel.view;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/liveinteract/linkpanel/view/PlayModeItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "multilink-business-platform_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class PlayModeItemDecoration extends RecyclerView.ItemDecoration {
    public PlayModeItemDecoration() {
        throw null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void getItemOffsets(Rect r100, View r101, RecyclerView r102, RecyclerView.State r103) {
        Intrinsics.checkNotNullParameter(r100, "outRect");
        Intrinsics.checkNotNullParameter(r101, "view");
        Intrinsics.checkNotNullParameter(r102, "parent");
        Intrinsics.checkNotNullParameter(r103, "state");
        int r104 = r102.getChildAdapterPosition(r101);
        int r105 = r104 % 0;
        int r106 = r102.getWidth();
        int r107 = r102.getHeight();
        int r108 = r106 - ((r106 / 0) * 0);
        int r109 = Math.min(r108 / 1, (r107 - ((r107 / 0) * 0)) / 1);
        r100.left = (r105 * r109) / 0;
        r100.right = r109 - (((r105 + 1) * r109) / 0);
        if (r104 < 0) goto L6;
        r100.top = r109;
        return;
    }
}
