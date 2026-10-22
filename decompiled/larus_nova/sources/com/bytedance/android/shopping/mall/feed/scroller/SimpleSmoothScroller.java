package com.bytedance.android.shopping.mall.feed.scroller;

import android.content.Context;
import android.util.DisplayMetrics;
import androidx.recyclerview.widget.LinearSmoothScroller;
import com.bytedance.common.utility.Logger;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/shopping/mall/feed/scroller/SimpleSmoothScroller;", "Landroidx/recyclerview/widget/LinearSmoothScroller;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SimpleSmoothScroller extends LinearSmoothScroller {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f177202a = null;

    public static final class a {
    }

    @Override // androidx.recyclerview.widget.LinearSmoothScroller
    public final int getVerticalSnapPreference() {
        return -1;
    }

    static {
        f177202a = LazyKt.lazy(SimpleSmoothScroller$Companion$customMillisecondsPerInch$2.INSTANCE);
    }

    @Override // androidx.recyclerview.widget.LinearSmoothScroller, androidx.recyclerview.widget.RecyclerView.SmoothScroller
    public final void onStop() {
        super.onStop();
        Logger.d("EaseInOutSmoothScroller", "onStop");
    }

    public SimpleSmoothScroller(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
    }

    @Override // androidx.recyclerview.widget.LinearSmoothScroller
    public final float calculateSpeedPerPixel(DisplayMetrics r100) {
        Intrinsics.checkNotNullParameter(r100, "displayMetrics");
        return ((Number) f177202a.getValue()).floatValue() / r100.densityDpi;
    }
}
