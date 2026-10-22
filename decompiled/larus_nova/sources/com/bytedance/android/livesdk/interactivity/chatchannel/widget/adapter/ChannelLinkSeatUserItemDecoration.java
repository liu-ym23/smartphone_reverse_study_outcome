package com.bytedance.android.livesdk.interactivity.chatchannel.widget.adapter;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/chatchannel/widget/adapter/ChannelLinkSeatUserItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ChannelLinkSeatUserItemDecoration extends RecyclerView.ItemDecoration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f134551a;

    public ChannelLinkSeatUserItemDecoration(int r100) {
        this.f134551a = r100;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void getItemOffsets(Rect r100, View r101, RecyclerView r102, RecyclerView.State r103) {
        Intrinsics.checkNotNullParameter(r100, "outRect");
        Intrinsics.checkNotNullParameter(r101, "view");
        Intrinsics.checkNotNullParameter(r102, "parent");
        Intrinsics.checkNotNullParameter(r103, "state");
        r100.set(0, 0, this.f134551a, 0);
    }
}
