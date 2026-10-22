package com.facebook.rebound;

/* JADX INFO: loaded from: classes2.dex */
public class OrigamiValueConverter {
    public OrigamiValueConverter() {
    }

    public static double frictionFromOrigamiValue(double r10) {
        if (r10 != 0.0d) goto L6;
        return 0.0d;
    L6:
        return 25.0d + ((r10 - 8.0d) * 3.0d);
    }

    public static double origamiValueFromFriction(double r10) {
        if (r10 != 0.0d) goto L6;
        return 0.0d;
    L6:
        return 8.0d + ((r10 - 25.0d) / 3.0d);
    }

    public static double origamiValueFromTension(double r10) {
        if (r10 != 0.0d) goto L6;
        return 0.0d;
    L6:
        return 30.0d + ((r10 - 194.0d) / 3.62d);
    }

    public static double tensionFromOrigamiValue(double r10) {
        if (r10 != 0.0d) goto L6;
        return 0.0d;
    L6:
        return 194.0d + ((r10 - 30.0d) * 3.62d);
    }
}
