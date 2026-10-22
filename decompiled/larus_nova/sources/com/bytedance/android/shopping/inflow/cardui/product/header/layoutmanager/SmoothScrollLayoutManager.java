package com.bytedance.android.shopping.inflow.cardui.product.header.layoutmanager;

import android.content.Context;
import android.content.res.Resources;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/bytedance/android/shopping/inflow/cardui/product/header/layoutmanager/SmoothScrollLayoutManager;", "Landroidx/recyclerview/widget/LinearLayoutManager;", "Landroid/content/Context;", "b", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SmoothScrollLayoutManager extends LinearLayoutManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f176248a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f176249b;

    public final Context getContext() {
        return this.f176249b;
    }

    public SmoothScrollLayoutManager(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, 0, false);
        this.f176249b = r100;
        this.f176248a = 25.0f;
        Resources r101 = r100.getResources();
        this.f176248a = WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()).density * 0.2f;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void smoothScrollToPosition(RecyclerView r100, RecyclerView.State r101, int r102) {
        if (r100 != null) goto L4;
        return;
    L4:
        SlowScrollLinearSmoothScroller r103 = new SlowScrollLinearSmoothScroller(r100.getContext(), this.f176248a);
        r103.setTargetPosition(r102);
        startSmoothScroll(r103);
    }
}
