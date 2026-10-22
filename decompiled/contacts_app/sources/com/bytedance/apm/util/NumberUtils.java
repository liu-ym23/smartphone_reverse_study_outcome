package com.bytedance.apm.util;

import java.util.Random;

/* JADX INFO: loaded from: classes2.dex */
public class NumberUtils {
    private static Random sRandom;

    public NumberUtils() {
    }

    public static long safeUnbox(Long r2) {
        if (r2 != null) goto L5;
        return 0;
    L5:
        return r2.longValue();
    }

    public static String uuid() {
        if (sRandom != null) goto L6;
        sRandom = new Random(System.currentTimeMillis());
    L6:
        return Long.toHexString(sRandom.nextLong());
    }
}
