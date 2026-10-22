package com.bytedance.android.livesdk.config;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class u61 {
    public static final boolean a(t61 r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$enableLinkedPanelOpt");
        if (r100.getTotalSwitch() == true) goto L5;
    L7:
        return false;
    L5:
        if (r100.m5() == false) goto L7;
        return true;
    }

    public static final boolean b(t61 r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$enableOrderSongPanelOpt");
        if (r100.getTotalSwitch() == true) goto L5;
    L7:
        return false;
    L5:
        if (r100.z6() == false) goto L7;
        return true;
    }

    public static final boolean c(t61 r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$linkedPanelMemoryLeakFix");
        if (r100.getTotalSwitch() == true) goto L5;
    L7:
        return false;
    L5:
        if (r100.O3() == false) goto L7;
        return true;
    }
}
