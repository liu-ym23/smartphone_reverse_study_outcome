package com.bytedance.android.livesdk.livecommerce.iron.category;

import android.content.Context;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/iron/category/CategoryLineaLayoutManager;", "Landroidx/recyclerview/widget/LinearLayoutManager;", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CategoryLineaLayoutManager extends LinearLayoutManager {
    public CategoryLineaLayoutManager(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void smoothScrollToPosition(RecyclerView r100, RecyclerView.State r101, int r102) {
        if (r100 == null) goto L7;
        Context r103 = r100.getContext();
        if (r103 == null) goto L8;
        CenterSmoothScroller r104 = new CenterSmoothScroller(r103);
        r104.setTargetPosition(r102);
        startSmoothScroll(r104);
        return;
    L8:
        return;
    }
}
