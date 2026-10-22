package com.android.internal.chooser.widget;

/* compiled from: Switch.java */
/* loaded from: classes.dex */
final class MathUtils {
    private MathUtils() {
    }

    public static float abs(float v) {
        return v > 0.0f ? v : -v;
    }

    public static float constrain(float amount, float low, float high) {
        return amount < low ? low : amount > high ? high : amount;
    }

    public static float log(float a) {
        return (float) Math.log(a);
    }

    public static float max(float a, float b) {
        return a > b ? a : b;
    }

    public static float max(int a, int b) {
        return a > b ? a : b;
    }

    public static float max(float a, float b, float c) {
        if (a > b) {
            if (a > c) {
                return a;
            }
        } else if (b > c) {
            return b;
        }
        return c;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x000a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static float max(int r1, int r2, int r3) {
        /*
            if (r1 <= r2) goto L6
            if (r1 <= r3) goto La
            r0 = r1
            goto Lb
        L6:
            if (r2 <= r3) goto La
            r0 = r2
            goto Lb
        La:
            r0 = r3
        Lb:
            float r0 = (float) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.internal.chooser.widget.MathUtils.max(int, int, int):float");
    }

    public static float min(float a, float b) {
        return a < b ? a : b;
    }

    public static float min(int a, int b) {
        return a < b ? a : b;
    }

    public static float min(float a, float b, float c) {
        if (a < b) {
            if (a < c) {
                return a;
            }
        } else if (b < c) {
            return b;
        }
        return c;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x000a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static float min(int r1, int r2, int r3) {
        /*
            if (r1 >= r2) goto L6
            if (r1 >= r3) goto La
            r0 = r1
            goto Lb
        L6:
            if (r2 >= r3) goto La
            r0 = r2
            goto Lb
        La:
            r0 = r3
        Lb:
            float r0 = (float) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.internal.chooser.widget.MathUtils.min(int, int, int):float");
    }
}
