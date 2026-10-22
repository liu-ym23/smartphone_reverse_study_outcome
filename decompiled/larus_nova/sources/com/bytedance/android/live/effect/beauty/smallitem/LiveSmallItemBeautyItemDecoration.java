package com.bytedance.android.live.effect.beauty.smallitem;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.s1;

/* JADX INFO: loaded from: classes45.dex */
public class LiveSmallItemBeautyItemDecoration extends RecyclerView.ItemDecoration {
    public LiveSmallItemBeautyItemDecoration() {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void getItemOffsets(Rect r100, View r101, RecyclerView r102, RecyclerView.State r103) {
        super.getItemOffsets(r100, r101, r102, r103);
        int r104 = r102.getChildAdapterPosition(r101);
        if (r104 != 0) goto L6;
        r100.set(s1.f(10.0f), 0, 0, 0);
        return;
    L6:
        if (r104 != (r102.getAdapter().getItemCount() - 1)) goto L10;
        r100.set(0, 0, s1.f(10.0f), 0);
        return;
    }
}
