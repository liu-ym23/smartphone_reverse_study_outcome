package com.ttreader.tttext.lite;

/* JADX INFO: loaded from: classes4.dex */
public class TTTextUtils {
    public static float density_ = 1.0f;

    static {
    }

    public static float Dp2Px(float r0, float r1) {
        return (r0 * r1) / 160.0f;
    }

    public static float Px2Dp(float r1, float r2) {
        return (r1 * 160.0f) / r2;
    }

    public TTTextUtils() {
    }

    public static void SetDpi(float r2) {
        monitor-enter(TTTextUtils.class);
        density_ = r2 / 160.0f;     // Catch: Throwable -> L8
        monitor-exit(TTTextUtils.class);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public static float Dp2Px(float r1) {
        return r1 * density_;
    }

    public static float Px2Dp(float r1) {
        return r1 / density_;
    }
}
