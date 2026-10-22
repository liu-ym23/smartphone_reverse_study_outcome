package com.bytedance.android.livesdk.livecommerce.iron.category;

import android.content.Context;
import androidx.recyclerview.widget.LinearSmoothScroller;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/iron/category/CenterSmoothScroller;", "Landroidx/recyclerview/widget/LinearSmoothScroller;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CenterSmoothScroller extends LinearSmoothScroller {

    public static final class a {
    }

    static {
    }

    @Override // androidx.recyclerview.widget.LinearSmoothScroller
    public final int calculateTimeForScrolling(int r100) {
        return 200;
    }

    public CenterSmoothScroller(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
    }

    @Override // androidx.recyclerview.widget.LinearSmoothScroller
    public final int calculateDtToFit(int r100, int r101, int r102, int r103, int r104) {
        return (r102 + ((r103 - r102) / 2)) - (r100 + ((r101 - r100) / 2));
    }
}
