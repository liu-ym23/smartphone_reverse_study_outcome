package com.bytedance.android.livesdk.widget;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/widget/TwoColumnGridSpaceItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "liveui_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TwoColumnGridSpaceItemDecoration extends RecyclerView.ItemDecoration {
    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void getItemOffsets(Rect r100, View r101, RecyclerView r102, RecyclerView.State r103) {
        Intrinsics.checkNotNullParameter(r100, "outRect");
        Intrinsics.checkNotNullParameter(r101, "view");
        Intrinsics.checkNotNullParameter(r102, "parent");
        Intrinsics.checkNotNullParameter(r103, "state");
        int r104 = r102.getChildAdapterPosition(r101);
        if ((r104 % 2) != 0) goto L5;
        r100.right = 0;
    L6:
        RecyclerView.Adapter r105 = r102.getAdapter();
        if (r105 == null) goto L9;
        int r106 = r105.getItemCount();
    L11:
        if (r104 < ((r106 + (r106 % 2)) - 2)) goto L13;
        boolean r107 = true;
    L14:
        if (r107 == true) goto L17;
        r100.bottom = 0;
        return;
    L17:
        return;
    L13:
        r107 = false;
        goto L14
    L9:
        r106 = 0;
        goto L11
    L5:
        r100.left = 0;
        goto L6
    }
}
