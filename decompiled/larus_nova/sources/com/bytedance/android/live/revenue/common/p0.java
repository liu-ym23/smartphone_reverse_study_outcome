package com.bytedance.android.live.revenue.common;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class p0 {
    public static void a(long r100, boolean r101, boolean r102, Function0 r103, int r104) {
        if ((r104 & 1) == 0) goto L6;
        r100 = 0;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = false;
    L9:
        if ((r104 & 4) == 0) goto L11;
        r102 = false;
    L11:
        Intrinsics.checkNotNullParameter(r103, "action");
        com.bytedance.live.kmp.util.d.a(r100, r101, r102, r103);
    }
}
