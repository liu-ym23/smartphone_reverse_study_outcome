package com.android.internal.util.jobs;

import android.text.TextUtils;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class Preconditions {
    public Preconditions() {
    }

    public static void checkArgument(boolean expression) {
        if (expression == false) goto L5;
        return;
    L5:
        throw new IllegalArgumentException();
    }

    public static void checkArgument(boolean expression, Object errorMessage) {
        if (expression == false) goto L5;
        return;
    L5:
        throw new IllegalArgumentException(String.valueOf(errorMessage));
    }

    public static void checkArgument(boolean expression, String messageTemplate, Object... messageArgs) {
        if (expression == false) goto L5;
        return;
    L5:
        throw new IllegalArgumentException(String.format(messageTemplate, messageArgs));
    }

    public static <T extends CharSequence> T checkStringNotEmpty(T string) {
        if (TextUtils.isEmpty(string) == true) goto L6;
        return string;
    L6:
        throw new IllegalArgumentException();
    }

    public static <T extends CharSequence> T checkStringNotEmpty(T string, Object errorMessage) {
        if (TextUtils.isEmpty(string) == true) goto L6;
        return string;
    L6:
        throw new IllegalArgumentException(String.valueOf(errorMessage));
    }

    public static <T extends CharSequence> T checkStringNotEmpty(T string, String messageTemplate, Object... messageArgs) {
        if (TextUtils.isEmpty(string) == true) goto L6;
        return string;
    L6:
        throw new IllegalArgumentException(String.format(messageTemplate, messageArgs));
    }

    @Deprecated
    public static <T> T checkNotNull(T reference) {
        if (reference == null) goto L5;
        return reference;
    L5:
        throw new NullPointerException();
    }

    @Deprecated
    public static <T> T checkNotNull(T reference, Object errorMessage) {
        if (reference == null) goto L5;
        return reference;
    L5:
        throw new NullPointerException(String.valueOf(errorMessage));
    }

    public static <T> T checkNotNull(T reference, String messageTemplate, Object... messageArgs) {
        if (reference == null) goto L5;
        return reference;
    L5:
        throw new NullPointerException(String.format(messageTemplate, messageArgs));
    }

    public static void checkState(boolean expression) {
        checkState(expression, null);
    }

    public static void checkState(boolean expression, String errorMessage) {
        if (expression == false) goto L5;
        return;
    L5:
        throw new IllegalStateException(errorMessage);
    }

    public static void checkState(boolean expression, String messageTemplate, Object... messageArgs) {
        if (expression == false) goto L5;
        return;
    L5:
        throw new IllegalStateException(String.format(messageTemplate, messageArgs));
    }

    public static void checkCallAuthorization(boolean expression) {
        if (expression == false) goto L5;
        return;
    L5:
        throw new SecurityException("Calling identity is not authorized");
    }

    public static void checkCallAuthorization(boolean expression, String message) {
        if (expression == false) goto L5;
        return;
    L5:
        throw new SecurityException(message);
    }

    public static void checkCallAuthorization(boolean expression, String messageTemplate, Object... messageArgs) {
        if (expression == false) goto L5;
        return;
    L5:
        throw new SecurityException(String.format(messageTemplate, messageArgs));
    }

    public static void checkCallingUser(boolean expression) {
        if (expression == false) goto L5;
        return;
    L5:
        throw new SecurityException("Calling user is not authorized");
    }

    public static int checkFlagsArgument(int requestedFlags, int allowedFlags) {
        if ((requestedFlags & allowedFlags) != requestedFlags) goto L6;
        return requestedFlags;
    L6:
        throw new IllegalArgumentException("Requested flags 0x" + Integer.toHexString(requestedFlags) + ", but only 0x" + Integer.toHexString(allowedFlags) + " are allowed");
    }

    public static int checkArgumentNonnegative(int value, String errorMessage) {
        if (value < 0) goto L5;
        return value;
    L5:
        throw new IllegalArgumentException(errorMessage);
    }

    public static int checkArgumentNonnegative(int value) {
        if (value < 0) goto L5;
        return value;
    L5:
        throw new IllegalArgumentException();
    }

    public static long checkArgumentNonnegative(long value) {
        if (value < 0) goto L6;
        return value;
    L6:
        throw new IllegalArgumentException();
    }

    public static long checkArgumentNonnegative(long value, String errorMessage) {
        if (value < 0) goto L6;
        return value;
    L6:
        throw new IllegalArgumentException(errorMessage);
    }

    public static int checkArgumentPositive(int value, String errorMessage) {
        if (value <= 0) goto L5;
        return value;
    L5:
        throw new IllegalArgumentException(errorMessage);
    }

    public static float checkArgumentNonNegative(float value, String errorMessage) {
        if (value < 0.0f) goto L6;
        return value;
    L6:
        throw new IllegalArgumentException(errorMessage);
    }

    public static float checkArgumentPositive(float value, String errorMessage) {
        if (value <= 0.0f) goto L6;
        return value;
    L6:
        throw new IllegalArgumentException(errorMessage);
    }

    public static float checkArgumentFinite(float value, String valueName) {
        if (Float.isNaN(value) == true) goto L10;
        if (Float.isInfinite(value) == true) goto L8;
        return value;
    L8:
        throw new IllegalArgumentException(valueName + " must not be infinite");
    L10:
        throw new IllegalArgumentException(valueName + " must not be NaN");
    }

    public static float checkArgumentInRange(float value, float lower, float upper, String valueName) {
        if (Float.isNaN(value) == true) goto L14;
        if (value < lower) goto L12;
        if (value > upper) goto L10;
        return value;
    L10:
        throw new IllegalArgumentException(String.format("%s is out of range of [%f, %f] (too high)", new Object[]{valueName, Float.valueOf(lower), Float.valueOf(upper)}));
    L12:
        throw new IllegalArgumentException(String.format("%s is out of range of [%f, %f] (too low)", new Object[]{valueName, Float.valueOf(lower), Float.valueOf(upper)}));
    L14:
        throw new IllegalArgumentException(valueName + " must not be NaN");
    }

    public static double checkArgumentInRange(double value, double lower, double upper, String valueName) {
        if (Double.isNaN(value) == true) goto L14;
        if (value < lower) goto L12;
        if (value > upper) goto L10;
        return value;
    L10:
        throw new IllegalArgumentException(String.format("%s is out of range of [%f, %f] (too high)", new Object[]{valueName, Double.valueOf(lower), Double.valueOf(upper)}));
    L12:
        throw new IllegalArgumentException(String.format("%s is out of range of [%f, %f] (too low)", new Object[]{valueName, Double.valueOf(lower), Double.valueOf(upper)}));
    L14:
        throw new IllegalArgumentException(valueName + " must not be NaN");
    }

    public static int checkArgumentInRange(int value, int lower, int upper, String valueName) {
        if (value < lower) goto L8;
        if (value > upper) goto L6;
        return value;
    L6:
        throw new IllegalArgumentException(String.format("%s is out of range of [%d, %d] (too high)", new Object[]{valueName, Integer.valueOf(lower), Integer.valueOf(upper)}));
    L8:
        throw new IllegalArgumentException(String.format("%s is out of range of [%d, %d] (too low)", new Object[]{valueName, Integer.valueOf(lower), Integer.valueOf(upper)}));
    }

    public static long checkArgumentInRange(long value, long lower, long upper, String valueName) {
        if (value < lower) goto L10;
        if (value > upper) goto L8;
        return value;
    L8:
        throw new IllegalArgumentException(String.format("%s is out of range of [%d, %d] (too high)", new Object[]{valueName, Long.valueOf(lower), Long.valueOf(upper)}));
    L10:
        throw new IllegalArgumentException(String.format("%s is out of range of [%d, %d] (too low)", new Object[]{valueName, Long.valueOf(lower), Long.valueOf(upper)}));
    }

    public static <T> T[] checkArrayElementsNotNull(T[] value, String valueName) {
        if (value == null) goto L14;
        int i = 0;
    L5:
        if (i >= value.length) goto L12;
        if (value[i] == null) goto L10;
        i = i + 1;
        goto L5
    L10:
        throw new NullPointerException(String.format("%s[%d] must not be null", new Object[]{valueName, Integer.valueOf(i)}));
    L12:
        return value;
    L14:
        throw new NullPointerException(valueName + " must not be null");
    }

    public static <C extends Collection<T>, T> C checkCollectionElementsNotNull(C value, String valueName) {
        if (value == null) goto L13;
        long ctr = 0;
        Iterator r2 = value.iterator();
    L5:
        if (r2.hasNext() == false) goto L11;
        if (r2.next() == null) goto L10;
        ctr = ctr + 1;
        goto L5
    L10:
        throw new NullPointerException(String.format("%s[%d] must not be null", new Object[]{valueName, Long.valueOf(ctr)}));
    L11:
        return value;
    L13:
        throw new NullPointerException(valueName + " must not be null");
    }

    public static <T> Collection<T> checkCollectionNotEmpty(Collection<T> value, String valueName) {
        if (value == null) goto L9;
        if (value.isEmpty() == true) goto L7;
        return value;
    L7:
        throw new IllegalArgumentException(valueName + " is empty");
    L9:
        throw new NullPointerException(valueName + " must not be null");
    }

    public static byte[] checkByteArrayNotEmpty(byte[] value, String valueName) {
        if (value == null) goto L9;
        if (value.length == 0) goto L7;
        return value;
    L7:
        throw new IllegalArgumentException(valueName + " is empty");
    L9:
        throw new NullPointerException(valueName + " must not be null");
    }

    public static String checkArgumentIsSupported(String[] supportedValues, String value) {
        checkNotNull(value);
        checkNotNull(supportedValues);
        if (contains(supportedValues, value) == false) goto L6;
        return value;
    L6:
        throw new IllegalArgumentException(value + "is not supported " + Arrays.toString(supportedValues));
    }

    private static boolean contains(String[] values, String value) {
        if (values != null) goto L5;
        return false;
    L5:
        int i = 0;
    L7:
        if (i >= values.length) goto L14;
        if (Objects.equals(value, values[i]) == true) goto L10;
        i = i + 1;
        goto L7
    L10:
        return true;
    L14:
        return false;
    }

    public static float[] checkArrayElementsInRange(float[] value, float lower, float upper, String valueName) {
        checkNotNull(value, "%s must not be null", new Object[]{valueName});
        int i = 0;
    L4:
        if (i >= value.length) goto L19;
        float v = value[i];
        if (Float.isNaN(v) == true) goto L17;
        if (v < lower) goto L15;
        if (v > upper) goto L13;
        i = i + 1;
        goto L4
    L13:
        throw new IllegalArgumentException(String.format("%s[%d]: %f is out of range of [%f, %f] (too high)", new Object[]{valueName, Integer.valueOf(i), Float.valueOf(v), Float.valueOf(lower), Float.valueOf(upper)}));
    L15:
        throw new IllegalArgumentException(String.format("%s[%d]: %f is out of range of [%f, %f] (too low)", new Object[]{valueName, Integer.valueOf(i), Float.valueOf(v), Float.valueOf(lower), Float.valueOf(upper)}));
    L17:
        throw new IllegalArgumentException(valueName + "[" + i + "] must not be NaN");
    L19:
        return value;
    }

    public static int[] checkArrayElementsInRange(int[] value, int lower, int upper, String valueName) {
        checkNotNull(value, "%s must not be null", new Object[]{valueName});
        int i = 0;
    L4:
        if (i >= value.length) goto L14;
        int v = value[i];
        if (v < lower) goto L12;
        if (v > upper) goto L10;
        i = i + 1;
        goto L4
    L10:
        throw new IllegalArgumentException(String.format("%s[%d]: %d is out of range of [%d, %d] (too high)", new Object[]{valueName, Integer.valueOf(v), Integer.valueOf(i), Integer.valueOf(lower), Integer.valueOf(upper)}));
    L12:
        throw new IllegalArgumentException(String.format("%s[%d]: %d is out of range of [%d, %d] (too low)", new Object[]{valueName, Integer.valueOf(v), Integer.valueOf(i), Integer.valueOf(lower), Integer.valueOf(upper)}));
    L14:
        return value;
    }

    public static <T> T requireNonNullViaRavenwoodRule(T t) {
        if (t == null) goto L5;
        return t;
    L5:
        throw new IllegalStateException("This operation requires that a RavenwoodRule be configured to accurately define the expected test environment");
    }
}
