package com.bytedance.android.live.profit.lottery;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class c1 {
    public static final boolean a(t r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$isLifeLottery");
        c r101 = r100.f88204k;
        if (r101 == null) goto L7;
        b r102 = r101.a();
        if (r102 == null) goto L7;
        Boolean r103 = r102.a();
    L9:
        return Intrinsics.areEqual(r103, Boolean.TRUE);
    L7:
        r103 = null;
        goto L9
    }
}
