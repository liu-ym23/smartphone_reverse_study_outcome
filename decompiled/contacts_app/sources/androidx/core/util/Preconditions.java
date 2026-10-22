package androidx.core.util;

import android.text.TextUtils;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class Preconditions {
    public static void checkArgument(boolean r0) {
        if (r0 == false) goto L5;
        return;
    L5:
        throw new IllegalArgumentException();
    }

    public static void checkArgument(boolean r0, Object r1) {
        if (r0 == false) goto L5;
        return;
    L5:
        throw new IllegalArgumentException(String.valueOf(r1));
    }

    public static void checkArgument(boolean r0, String r1, Object... r2) {
        if (r0 == false) goto L5;
        return;
    L5:
        throw new IllegalArgumentException(String.format(r1, r2));
    }

    public static <T extends CharSequence> T checkStringNotEmpty(T r1) {
        if (TextUtils.isEmpty(r1) == true) goto L6;
        return r1;
    L6:
        throw new IllegalArgumentException();
    }

    public static <T extends CharSequence> T checkStringNotEmpty(T r1, Object r2) {
        if (TextUtils.isEmpty(r1) == true) goto L6;
        return r1;
    L6:
        throw new IllegalArgumentException(String.valueOf(r2));
    }

    public static <T extends CharSequence> T checkStringNotEmpty(T r1, String r2, Object... r3) {
        if (TextUtils.isEmpty(r1) == true) goto L6;
        return r1;
    L6:
        throw new IllegalArgumentException(String.format(r2, r3));
    }

    public static <T> T checkNotNull(T r0) {
        r0.getClass();
        return r0;
    }

    public static <T> T checkNotNull(T r0, Object r1) {
        if (r0 == null) goto L5;
        return r0;
    L5:
        throw new NullPointerException(String.valueOf(r1));
    }

    public static void checkState(boolean r0, String r1) {
        if (r0 == false) goto L5;
        return;
    L5:
        throw new IllegalStateException(r1);
    }

    public static void checkState(boolean r1) {
        checkState(r1, null);
    }

    public static int checkFlagsArgument(int r3, int r4) {
        if ((r3 & r4) != r3) goto L6;
        return r3;
    L6:
        throw new IllegalArgumentException("Requested flags 0x" + Integer.toHexString(r3) + ", but only 0x" + Integer.toHexString(r4) + " are allowed");
    }

    public static int checkArgumentNonnegative(int r0, String r1) {
        if (r0 < 0) goto L5;
        return r0;
    L5:
        throw new IllegalArgumentException(r1);
    }

    public static int checkArgumentNonnegative(int r0) {
        if (r0 < 0) goto L5;
        return r0;
    L5:
        throw new IllegalArgumentException();
    }

    public static int checkArgumentInRange(int r5, int r6, int r7, String r8) {
        if (r5 < r6) goto L9;
        if (r5 > r7) goto L7;
        return r5;
    L7:
        throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%d, %d] (too high)", new Object[]{r8, Integer.valueOf(r6), Integer.valueOf(r7)}));
    L9:
        throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%d, %d] (too low)", new Object[]{r8, Integer.valueOf(r6), Integer.valueOf(r7)}));
    }

    public static long checkArgumentInRange(long r5, long r7, long r9, String r11) {
        if (r5 < r7) goto L10;
        if (r5 > r9) goto L8;
        return r5;
    L8:
        throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%d, %d] (too high)", new Object[]{r11, Long.valueOf(r7), Long.valueOf(r9)}));
    L10:
        throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%d, %d] (too low)", new Object[]{r11, Long.valueOf(r7), Long.valueOf(r9)}));
    }

    public static float checkArgumentInRange(float r5, float r6, float r7, String r8) {
        if (r5 < r6) goto L10;
        if (r5 > r7) goto L8;
        return r5;
    L8:
        throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%f, %f] (too high)", new Object[]{r8, Float.valueOf(r6), Float.valueOf(r7)}));
    L10:
        throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%f, %f] (too low)", new Object[]{r8, Float.valueOf(r6), Float.valueOf(r7)}));
    }

    public static double checkArgumentInRange(double r5, double r7, double r9, String r11) {
        if (r5 < r7) goto L10;
        if (r5 > r9) goto L8;
        return r5;
    L8:
        throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%f, %f] (too high)", new Object[]{r11, Double.valueOf(r7), Double.valueOf(r9)}));
    L10:
        throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%f, %f] (too low)", new Object[]{r11, Double.valueOf(r7), Double.valueOf(r9)}));
    }

    public static float checkArgumentFinite(float r1, String r2) {
        if (Float.isNaN(r1) == true) goto L10;
        if (Float.isInfinite(r1) == true) goto L8;
        return r1;
    L8:
        throw new IllegalArgumentException(r2 + " must not be infinite");
    L10:
        throw new IllegalArgumentException(r2 + " must not be NaN");
    }

    private Preconditions() {
    }
}
