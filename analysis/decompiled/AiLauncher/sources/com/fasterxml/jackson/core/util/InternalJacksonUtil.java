package com.fasterxml.jackson.core.util;

/* loaded from: classes.dex */
public abstract class InternalJacksonUtil {
    public static int addOverflowSafe(int i10, int i11) {
        int i12 = i10 + i11;
        if (i12 < 0) {
            return Integer.MAX_VALUE;
        }
        return i12;
    }
}
