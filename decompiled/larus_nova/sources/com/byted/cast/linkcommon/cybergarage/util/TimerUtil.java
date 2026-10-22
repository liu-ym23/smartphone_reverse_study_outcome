package com.byted.cast.linkcommon.cybergarage.util;

/* JADX INFO: loaded from: classes28.dex */
public final class TimerUtil {
    public TimerUtil() {
    }

    public static final void wait(int r100) {
        Thread.sleep(r100);     // Catch: Exception -> L5
        return;
    }

    public static final void waitRandom(int r100) {
        Thread.sleep((int) (Math.random() * ((double) r100)));     // Catch: Exception -> L5
        return;
    }

    public static final void waitTime(int r100) {
        Thread.sleep(r100);     // Catch: Exception -> L5
        return;
    }
}
