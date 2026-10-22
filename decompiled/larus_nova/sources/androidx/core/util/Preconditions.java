package androidx.core.util;

import android.text.TextUtils;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public final class Preconditions {
    private Preconditions() {
    }

    public static void checkArgument(boolean r100) {
        if (r100 == false) goto L5;
        return;
    L5:
        throw new IllegalArgumentException();
    }

    public static int checkArgumentNonnegative(int r100) {
        if (r100 < 0) goto L5;
        return r100;
    L5:
        throw new IllegalArgumentException();
    }

    public static <T> T checkNotNull(T r100) {
        if (r100 == null) goto L5;
        return r100;
    L5:
        throw null;
    }

    public static void checkState(boolean r100) {
        checkState(r100, null);
    }

    public static <T extends CharSequence> T checkStringNotEmpty(T r100) {
        if (TextUtils.isEmpty(r100) == true) goto L6;
        return r100;
    L6:
        throw new IllegalArgumentException();
    }

    public static void checkArgument(boolean r100, Object r101) {
        if (r100 == false) goto L5;
        return;
    L5:
        throw new IllegalArgumentException(String.valueOf(r101));
    }

    public static float checkArgumentFinite(float r100, String r101) {
        if (Float.isNaN(r100) == true) goto L10;
        if (Float.isInfinite(r100) == true) goto L8;
        return r100;
    L8:
        throw new IllegalArgumentException(r101 + " must not be infinite");
    L10:
        throw new IllegalArgumentException(r101 + " must not be NaN");
    }

    public static int checkArgumentNonnegative(int r100, String r101) {
        if (r100 < 0) goto L5;
        return r100;
    L5:
        throw new IllegalArgumentException(r101);
    }

    public static int checkFlagsArgument(int r100, int r101) {
        if ((r100 & r101) != r100) goto L6;
        return r100;
    L6:
        throw new IllegalArgumentException("Requested flags 0x" + Integer.toHexString(r100) + ", but only 0x" + Integer.toHexString(r101) + " are allowed");
    }

    public static <T> T checkNotNull(T r100, Object r101) {
        if (r100 == null) goto L5;
        return r100;
    L5:
        throw new NullPointerException(String.valueOf(r101));
    }

    public static void checkState(boolean r100, String r101) {
        if (r100 == false) goto L5;
        return;
    L5:
        throw new IllegalStateException(r101);
    }

    public static <T extends CharSequence> T checkStringNotEmpty(T r100, Object r101) {
        if (TextUtils.isEmpty(r100) == true) goto L6;
        return r100;
    L6:
        throw new IllegalArgumentException(String.valueOf(r101));
    }

    public static void checkArgument(boolean r100, String r101, Object... r102) {
        if (r100 == false) goto L5;
        return;
    L5:
        throw new IllegalArgumentException(String.format(r101, r102));
    }

    public static <T extends CharSequence> T checkStringNotEmpty(T r100, String r101, Object... r102) {
        if (TextUtils.isEmpty(r100) == true) goto L6;
        return r100;
    L6:
        throw new IllegalArgumentException(String.format(r101, r102));
    }

    public static double checkArgumentInRange(double r100, double r101, double r102, String r110) {
        if (r100 < r101) goto L10;
        if (r100 > r102) goto L8;
        return r100;
    L8:
        throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%f, %f] (too high)", new Object[]{r110, Double.valueOf(r101), Double.valueOf(r102)}));
    L10:
        throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%f, %f] (too low)", new Object[]{r110, Double.valueOf(r101), Double.valueOf(r102)}));
    }

    public static float checkArgumentInRange(float r100, float r101, float r102, String r103) {
        if (r100 < r101) goto L10;
        if (r100 > r102) goto L8;
        return r100;
    L8:
        throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%f, %f] (too high)", new Object[]{r103, Float.valueOf(r101), Float.valueOf(r102)}));
    L10:
        throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%f, %f] (too low)", new Object[]{r103, Float.valueOf(r101), Float.valueOf(r102)}));
    }

    public static long checkArgumentInRange(long r100, long r101, long r102, String r110) {
        if (r100 < r101) goto L10;
        if (r100 > r102) goto L8;
        return r100;
    L8:
        throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%d, %d] (too high)", new Object[]{r110, Long.valueOf(r101), Long.valueOf(r102)}));
    L10:
        throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%d, %d] (too low)", new Object[]{r110, Long.valueOf(r101), Long.valueOf(r102)}));
    }

    public static int checkArgumentInRange(int r100, int r101, int r102, String r103) {
        if (r100 < r101) goto L9;
        if (r100 > r102) goto L7;
        return r100;
    L7:
        throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%d, %d] (too high)", new Object[]{r103, Integer.valueOf(r101), Integer.valueOf(r102)}));
    L9:
        throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%d, %d] (too low)", new Object[]{r103, Integer.valueOf(r101), Integer.valueOf(r102)}));
    }
}
