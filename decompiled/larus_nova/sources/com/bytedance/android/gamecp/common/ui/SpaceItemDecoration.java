package com.bytedance.android.gamecp.common.ui;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes44.dex */
public class SpaceItemDecoration extends RecyclerView.ItemDecoration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f56954a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f56955b;

    public SpaceItemDecoration(int r100) {
        this.f56955b = 0;
        this.f56954a = r100;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void getItemOffsets(Rect r100, View r101, RecyclerView r102, RecyclerView.State r103) {
        int r104 = r102.getChildPosition(r101);
        int r105 = this.f56955b;
        if (r105 != 0) goto L7;
        if (r104 == 0) goto L10;
        r100.left = this.f56954a;
        return;
    L10:
        return;
    L7:
        if (1 != r105) goto L12;
        r100.top = this.f56954a;
        return;
    }
}
