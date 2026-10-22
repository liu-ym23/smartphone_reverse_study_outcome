package com.bytedance.android.livesdk.interactivity.publicscreen.ui;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.livesdk.chatroom.ui.SmoothLinearLayoutManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/publicscreen/ui/TextMessageLayoutManager;", "Lcom/bytedance/android/livesdk/chatroom/ui/SmoothLinearLayoutManager;", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TextMessageLayoutManager extends SmoothLinearLayoutManager {
    public TextMessageLayoutManager(Context r100) {
        super(r100);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onLayoutCompleted(RecyclerView.State r100) {
        super.onLayoutCompleted(r100);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onDetachedFromWindow(RecyclerView r100, RecyclerView.Recycler r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "recycler");
        if (getRecycleChildrenOnDetach() == false) goto L5;
        int r102 = (r100.getRecycledViewPool().getRecycledViewCount(0) + getChildCount()) + 2;
        r100.getRecycledViewPool().setMaxRecycledViews(0, r102);
    L5:
        super.onDetachedFromWindow(r100, r101);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onMeasure(RecyclerView.Recycler r100, RecyclerView.State r101, int r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, "recycler");
        Intrinsics.checkNotNullParameter(r101, "state");
        super.onMeasure(r100, r101, r102, r103);
    }
}
