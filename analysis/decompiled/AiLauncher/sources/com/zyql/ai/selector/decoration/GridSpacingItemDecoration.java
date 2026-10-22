package com.zyql.ai.selector.decoration;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes4.dex */
public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {
    private boolean includeEdge;
    private int spacing;
    private int spanCount;

    public GridSpacingItemDecoration(int i10, int i11, boolean z10) {
        this.spanCount = i10;
        this.spacing = i11;
        this.includeEdge = z10;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        int i10 = this.spanCount;
        int i11 = childAdapterPosition % i10;
        if (this.includeEdge) {
            int i12 = this.spacing;
            rect.left = i12 - ((i11 * i12) / i10);
            rect.right = ((i11 + 1) * i12) / i10;
            if (childAdapterPosition < i10) {
                rect.top = i12;
            }
            rect.bottom = i12;
            return;
        }
        int i13 = this.spacing;
        rect.left = (i11 * i13) / i10;
        rect.right = i13 - (((i11 + 1) * i13) / i10);
        if (childAdapterPosition < i10) {
            rect.top = i13;
        }
        rect.bottom = i13;
    }
}
