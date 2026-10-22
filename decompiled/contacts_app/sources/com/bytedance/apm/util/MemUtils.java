package com.bytedance.apm.util;

/* JADX INFO: loaded from: classes2.dex */
public class MemUtils {
    public MemUtils() {
    }

    public static long getJavaUsedMemBytes() {
        return Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
    }
}
