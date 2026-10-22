package com.bytedance.android.live.revlink.impl.pk.utils;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes47.dex */
public final class FixedForAppBarLayoutManager extends LinearLayoutManager {
    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public final int findLastCompletelyVisibleItemPosition() {
        int r100 = getChildCount() - 1;
        if ((-1) <= r100) goto L5;
        int r101 = 1;
    L6:
        if (r100 == (-1)) goto L22;
        View r102 = getChildAt(r100);
        int[] r103 = new int[2];
        r102.getLocationOnScreen(r103);
        Rect r104 = new Rect();
        r102.getGlobalVisibleRect(r104);
        boolean r105 = false;
        if ((r104.bottom - r104.top) != r102.getHeight()) goto L10;
        boolean r106 = true;
    L11:
        View r107 = (View) r102.getParent();
        Rect r108 = new Rect();
        r107.getGlobalVisibleRect(r108);
        if (getOrientation() != 0) goto L18;
        int r109 = r103[0];
        int r110 = r102.getWidth() + r109;
        if (r109 >= r108.left) goto L16;
    L19:
        if (r105 == true) goto L23;
        r100 = r100 + r101;
    L23:
        if (r102 != null) goto L26;
        return -1;
    L26:
        return getPosition(r102);
    L16:
        if (r110 > r108.right) goto L19;
        r105 = true;
        goto L19
    L18:
        r102.getHeight();
        r105 = r106;
        goto L19
    L10:
        r106 = false;
        goto L11
    L22:
        r102 = null;
        goto L23
    L5:
        r101 = -1;
        goto L6
    }

    public FixedForAppBarLayoutManager(Context r100) {
        super(r100);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onLayoutChildren(RecyclerView.Recycler r100, RecyclerView.State r101) {
        super.onLayoutChildren(r100, r101);     // Catch: Exception -> L4
        return;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final int scrollHorizontallyBy(int r100, RecyclerView.Recycler r101, RecyclerView.State r102) {
        return super.scrollHorizontallyBy(r100, r101, r102);
    L4:
        return 0;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final int scrollVerticallyBy(int r100, RecyclerView.Recycler r101, RecyclerView.State r102) {
        return super.scrollVerticallyBy(r100, r101, r102);
    L4:
        return 0;
    }
}
