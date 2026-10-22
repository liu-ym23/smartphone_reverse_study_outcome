package com.android.server.permission.jarjar.kotlin.ranges;

/* JADX INFO: compiled from: _Ranges.kt */
/* JADX INFO: loaded from: classes2.dex */
class RangesKt___RangesKt extends RangesKt__RangesKt {
    public static int coerceAtMost(int $this$coerceAtMost, int maximumValue) {
        if ($this$coerceAtMost <= maximumValue) goto L5;
        return maximumValue;
    L5:
        return $this$coerceAtMost;
    }

    public static long coerceAtMost(long $this$coerceAtMost, long maximumValue) {
        if ($this$coerceAtMost <= maximumValue) goto L6;
        return maximumValue;
    L6:
        return $this$coerceAtMost;
    }
}
