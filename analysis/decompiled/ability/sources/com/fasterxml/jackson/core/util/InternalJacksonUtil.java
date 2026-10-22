package com.fasterxml.jackson.core.util;

/* loaded from: classes2.dex */
public abstract class InternalJacksonUtil {
    public static int addOverflowSafe(int i, int i6) {
        int i10 = i + i6;
        if (i10 < 0) {
            return Integer.MAX_VALUE;
        }
        return i10;
    }
}
