package com.bytedance.android.live.effect.sticker.ui;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/effect/sticker/ui/PixelLoopLayoutManager;", "Landroidx/recyclerview/widget/LinearLayoutManager;", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PixelLoopLayoutManager extends LinearLayoutManager {
    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void setMeasuredDimension(Rect r100, int r101, int r102) {
        super.setMeasuredDimension(r100, View.MeasureSpec.makeMeasureSpec(0, Integer.MIN_VALUE), r102);
    }
}
