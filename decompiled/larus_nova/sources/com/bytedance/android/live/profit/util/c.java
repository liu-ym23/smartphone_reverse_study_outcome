package com.bytedance.android.live.profit.util;

import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class c {
    public static b a() {
        FrescoAnimUtilsKt$profitFrescoPlayOnceControllerListener$1 r100 = FrescoAnimUtilsKt$profitFrescoPlayOnceControllerListener$1.INSTANCE;
        FrescoAnimUtilsKt$profitFrescoPlayOnceControllerListener$2 r101 = FrescoAnimUtilsKt$profitFrescoPlayOnceControllerListener$2.INSTANCE;
        Intrinsics.checkNotNullParameter(r100, WidgetCostModule.TYPE_ON_START);
        Intrinsics.checkNotNullParameter(r101, "onEnd");
        return new b(r100, r101, true, true);
    }
}
