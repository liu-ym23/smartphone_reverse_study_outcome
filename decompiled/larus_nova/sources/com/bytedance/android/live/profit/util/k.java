package com.bytedance.android.live.profit.util;

import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class k {
    public static h a(Function0 r100, Function0 r101, boolean r102, int r103) {
        if ((r103 & 1) == 0) goto L6;
        r100 = ProfitUtilsKt$createFrescoPlayOnceControllerListener$1.INSTANCE;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = ProfitUtilsKt$createFrescoPlayOnceControllerListener$2.INSTANCE;
    L9:
        if ((r103 & 4) == 0) goto L11;
        boolean r104 = true;
    L13:
        if ((r103 & 8) == 0) goto L15;
        r102 = false;
    L15:
        Intrinsics.checkNotNullParameter(r100, WidgetCostModule.TYPE_ON_START);
        Intrinsics.checkNotNullParameter(r101, "onEnd");
        return new h(r100, r101, r102, r104);
    L11:
        r104 = false;
        goto L13
    }
}
