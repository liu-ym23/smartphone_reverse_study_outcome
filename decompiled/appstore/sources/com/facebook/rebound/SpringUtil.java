package com.facebook.rebound;

/* JADX INFO: loaded from: classes2.dex */
public class SpringUtil {
    public SpringUtil() {
    }

    public static double clamp(double r10, double r11, double r12) {
        return Math.min(Math.max(r10, r11), r12);
    }

    public static double mapValueFromRangeToRange(double r10, double r11, double r12, double r13, double r14) {
        double r15 = r10 - r11;
        double r16 = r15 / (r12 - r11);
        return r13 + (r16 * (r14 - r13));
    }
}
