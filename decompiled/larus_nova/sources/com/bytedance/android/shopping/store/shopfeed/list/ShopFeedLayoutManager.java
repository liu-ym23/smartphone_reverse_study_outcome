package com.bytedance.android.shopping.store.shopfeed.list;

import android.content.Context;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.core.utils.k1;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/shopping/store/shopfeed/list/ShopFeedLayoutManager;", "Landroidx/recyclerview/widget/LinearLayoutManager;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShopFeedLayoutManager extends LinearLayoutManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f186198a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f186199b;

    public ShopFeedLayoutManager(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, 1, false);
        this.f186198a = k1.j(r100);
        this.f186199b = 100.0f;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public final int getExtraLayoutSpace(RecyclerView.State r100) {
        return this.f186198a * 2;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void smoothScrollToPosition(RecyclerView r100, RecyclerView.State r101, int r102) {
        Intrinsics.checkNotNull(r100);
        final Context r103 = r100.getContext();
        LinearSmoothScroller r104 = new ShopFeedLayoutManager$smoothScrollToPosition$smoothScroller$1(this, r103);
        r104.setTargetPosition(r102);
        startSmoothScroll(r104);
    }
}
