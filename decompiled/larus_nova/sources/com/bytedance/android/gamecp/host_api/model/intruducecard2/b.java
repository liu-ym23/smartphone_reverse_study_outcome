package com.bytedance.android.gamecp.host_api.model.intruducecard2;

import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes44.dex */
public final class b {
    public static final Pair<Integer, Integer> a(a r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$getDelayAndRetry");
        Integer r101 = r100.minRandom;
        if (r101 == null) goto L5;
        int r102 = r101.intValue();
    L6:
        Integer r103 = r100.maxRandom;
        if (r103 == null) goto L9;
        int r104 = r103.intValue();
    L10:
        Integer r105 = r100.maxRetryTimes;
        if (r105 == null) goto L13;
        int r106 = r105.intValue();
    L14:
        Integer r107 = r100.strategyType;
        int r108 = DispatchStrategyType.NORMAL.getType();
        if (r107 != null) goto L18;
    L20:
        int r109 = DispatchStrategyType.RANDOM.getType();
        if (r107 == null) goto L27;
        if (r107.intValue() != r109) goto L27;
        return new Pair(Integer.valueOf(RangesKt.random(new IntRange(r102, r104), Random.Default)), Integer.valueOf(r106));
    L27:
        return new Pair(0, 0);
    L18:
        if (r107.intValue() != r108) goto L20;
        return new Pair(0, 0);
    L13:
        r106 = 0;
        goto L14
    L9:
        r104 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }
}
