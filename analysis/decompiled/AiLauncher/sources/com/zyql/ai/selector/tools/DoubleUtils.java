package com.zyql.ai.selector.tools;

/* loaded from: classes4.dex */
public class DoubleUtils {
    private static final long TIME = 800;
    private static long lastClickTime;

    public static boolean isFastDoubleClick() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - lastClickTime < 800) {
            return true;
        }
        lastClickTime = jCurrentTimeMillis;
        return false;
    }
}
