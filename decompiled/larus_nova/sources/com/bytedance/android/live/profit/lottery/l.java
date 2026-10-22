package com.bytedance.android.live.profit.lottery;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class l {
    public static final t a(LotteryState r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$info");
        if ((r100 instanceof LotteryState.g) == false) goto L6;
        return ((LotteryState.g) r100).f88032a;
    L6:
        if ((r100 instanceof LotteryState.a) == false) goto L9;
        return ((LotteryState.a) r100).f88023a;
    L9:
        if ((r100 instanceof LotteryState.b) == false) goto L12;
        return ((LotteryState.b) r100).f88024a;
    L12:
        if ((r100 instanceof LotteryState.e) == false) goto L15;
        return ((LotteryState.e) r100).f88030b;
    L15:
        if ((r100 instanceof LotteryState.d) == true) goto L23;
        return null;
    L23:
        return ((LotteryState.d) r100).f88027a;
    }

    public static final boolean b(LotteryState r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$isTerminalState");
        if ((r100 instanceof LotteryState.b) == false) goto L5;
    L10:
        return true;
    L5:
        if ((r100 instanceof LotteryState.e) == true) goto L10;
        if ((r100 instanceof LotteryState.c) == true) goto L10;
        return false;
    }
}
