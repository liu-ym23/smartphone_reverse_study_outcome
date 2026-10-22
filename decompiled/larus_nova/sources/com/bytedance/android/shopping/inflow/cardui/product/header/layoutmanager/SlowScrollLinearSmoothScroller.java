package com.bytedance.android.shopping.inflow.cardui.product.header.layoutmanager;

import android.content.Context;
import android.util.DisplayMetrics;
import androidx.recyclerview.widget.LinearSmoothScroller;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/shopping/inflow/cardui/product/header/layoutmanager/SlowScrollLinearSmoothScroller;", "Landroidx/recyclerview/widget/LinearSmoothScroller;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SlowScrollLinearSmoothScroller extends LinearSmoothScroller {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f176247a;

    @Override // androidx.recyclerview.widget.LinearSmoothScroller
    public final float calculateSpeedPerPixel(DisplayMetrics r100) {
        Intrinsics.checkNotNullParameter(r100, "displayMetrics");
        return this.f176247a / r100.density;
    }

    public SlowScrollLinearSmoothScroller(Context r100, float r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f176247a = r101;
    }
}
