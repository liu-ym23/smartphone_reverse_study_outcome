package com.bytedance.android.live.effect.sticker.ui;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.s1;

/* JADX INFO: loaded from: classes45.dex */
public class LiveGestureListItemDecoration extends RecyclerView.ItemDecoration {
    public LiveGestureListItemDecoration() {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void getItemOffsets(Rect r100, View r101, RecyclerView r102, RecyclerView.State r103) {
        super.getItemOffsets(r100, r101, r102, r103);
        if (r102.getChildAdapterPosition(r101) != 0) goto L5;
        r100.set(0, 0, s1.f(8.0f), 0);
        return;
    L5:
        r100.set(s1.f(8.0f), 0, s1.f(8.0f), 0);
    }
}
