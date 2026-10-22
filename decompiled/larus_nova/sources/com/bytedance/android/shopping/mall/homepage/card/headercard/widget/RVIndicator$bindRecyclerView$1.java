package com.bytedance.android.shopping.mall.homepage.card.headercard.widget;

import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\n\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"com/bytedance/android/shopping/mall/homepage/card/headercard/widget/RVIndicator$bindRecyclerView$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RVIndicator$bindRecyclerView$1 extends RecyclerView.OnScrollListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RVIndicator f177945a;

    public RVIndicator$bindRecyclerView$1(RVIndicator r100) {
        this.f177945a = r100;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public final void onScrolled(RecyclerView r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        long r103 = System.currentTimeMillis();
        RVIndicator r104 = this.f177945a;
        if ((r103 - r104.f177942h) >= r104.f177941g) goto L5;
        return;
    L5:
        r104.f177942h = System.currentTimeMillis();
        this.f177945a.setProgress((r100.computeHorizontalScrollOffset() * 1.0f) / (r100.computeHorizontalScrollRange() - r100.computeHorizontalScrollExtent()));
    }
}
