package com.bytedance.android.live.broadcastgame.openplatform.feature_panel.view.in_live.v3;

import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\n\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"com/bytedance/android/live/broadcastgame/openplatform/feature_panel/view/in_live/v3/LiveOpenFeatureChooseListFragmentV3$initRecyclerScrollListener$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveOpenFeatureChooseListFragmentV3$initRecyclerScrollListener$1 extends RecyclerView.OnScrollListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function0 f61552a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function0 f61553b;

    public LiveOpenFeatureChooseListFragmentV3$initRecyclerScrollListener$1(Function0 r100, Function0 r101) {
        this.f61552a = r100;
        this.f61553b = r101;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public final void onScrollStateChanged(RecyclerView r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        super.onScrollStateChanged(r100, r101);
        if (r101 != 0) goto L6;
        this.f61552a.invoke();
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public final void onScrolled(RecyclerView r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        super.onScrolled(r100, r101, r102);
        if (r101 != 0) goto L7;
        if (r102 != 0) goto L8;
        this.f61553b.invoke();
        return;
    L8:
        return;
    }
}
