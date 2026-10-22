package com.google.common.base;

import com.android.contacts.common.list.DefaultContactListAdapter;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class Preconditions {
    private Preconditions() {
    }

    public static void checkArgument(boolean r0) {
        if (r0 == false) goto L5;
        return;
    L5:
        throw new IllegalArgumentException();
    }

    public static void checkArgument(boolean r0, @Nullable Object r1) {
        if (r0 == false) goto L5;
        return;
    L5:
        throw new IllegalArgumentException(String.valueOf(r1));
    }

    public static void checkArgument(boolean r0, @Nullable String r1, @Nullable Object... r2) {
        if (r0 == false) goto L5;
        return;
    L5:
        throw new IllegalArgumentException(format(r1, r2));
    }

    public static void checkState(boolean r0) {
        if (r0 == false) goto L5;
        return;
    L5:
        throw new IllegalStateException();
    }

    public static void checkState(boolean r0, @Nullable Object r1) {
        if (r0 == false) goto L5;
        return;
    L5:
        throw new IllegalStateException(String.valueOf(r1));
    }

    public static void checkState(boolean r0, @Nullable String r1, @Nullable Object... r2) {
        if (r0 == false) goto L5;
        return;
    L5:
        throw new IllegalStateException(format(r1, r2));
    }

    public static <T> T checkNotNull(T r0) {
        r0.getClass();
        return r0;
    }

    public static <T> T checkNotNull(T r0, @Nullable Object r1) {
        if (r0 == null) goto L5;
        return r0;
    L5:
        throw new NullPointerException(String.valueOf(r1));
    }

    public static <T> T checkNotNull(T r0, @Nullable String r1, @Nullable Object... r2) {
        if (r0 == null) goto L5;
        return r0;
    L5:
        throw new NullPointerException(format(r1, r2));
    }

    public static int checkElementIndex(int r1, int r2) {
        return checkElementIndex(r1, r2, "index");
    }

    public static int checkElementIndex(int r1, int r2, @Nullable String r3) {
        if (r1 < 0) goto L6;
        if (r1 >= r2) goto L6;
        return r1;
    L6:
        throw new IndexOutOfBoundsException(badElementIndex(r1, r2, r3));
    }

    private static String badElementIndex(int r4, int r5, String r6) {
        if (r4 < 0) goto L5;
        if (r5 < 0) goto L10;
        return format("%s (%s) must be less than size (%s)", new Object[]{r6, Integer.valueOf(r4), Integer.valueOf(r5)});
    L10:
        throw new IllegalArgumentException("negative size: " + r5);
    L5:
        return format("%s (%s) must not be negative", new Object[]{r6, Integer.valueOf(r4)});
    }

    public static int checkPositionIndex(int r1, int r2) {
        return checkPositionIndex(r1, r2, "index");
    }

    public static int checkPositionIndex(int r1, int r2, @Nullable String r3) {
        if (r1 < 0) goto L6;
        if (r1 > r2) goto L6;
        return r1;
    L6:
        throw new IndexOutOfBoundsException(badPositionIndex(r1, r2, r3));
    }

    private static String badPositionIndex(int r4, int r5, String r6) {
        if (r4 < 0) goto L5;
        if (r5 < 0) goto L10;
        return format("%s (%s) must not be greater than size (%s)", new Object[]{r6, Integer.valueOf(r4), Integer.valueOf(r5)});
    L10:
        throw new IllegalArgumentException("negative size: " + r5);
    L5:
        return format("%s (%s) must not be negative", new Object[]{r6, Integer.valueOf(r4)});
    }

    public static void checkPositionIndexes(int r1, int r2, int r3) {
        if (r1 < 0) goto L7;
        if (r2 < r1) goto L7;
        if (r2 > r3) goto L7;
        return;
    L7:
        throw new IndexOutOfBoundsException(badPositionIndexes(r1, r2, r3));
    }

    private static String badPositionIndexes(int r1, int r2, int r3) {
        if (r1 < 0) goto L13;
        if (r1 > r3) goto L13;
        if (r2 < 0) goto L11;
        if (r2 > r3) goto L11;
        return format("end index (%s) must not be less than start index (%s)", new Object[]{Integer.valueOf(r2), Integer.valueOf(r1)});
    L11:
        return badPositionIndex(r2, r3, "end index");
    L13:
        return badPositionIndex(r1, r3, "start index");
    }

    static String format(String r6, @Nullable Object... r7) {
        String r8 = String.valueOf(r6);
        StringBuilder r0 = new StringBuilder(r8.length() + (r7.length * 16));
        int r1 = 0;
        int r2 = 0;
    L4:
        if (r1 >= r7.length) goto L9;
        int r3 = r8.indexOf("%s", r2);
        if (r3 == (-1)) goto L9;
        r0.append(r8.substring(r2, r3));
        r0.append(r7[r1]);
        r2 = r3 + 2;
        r1 = r1 + 1;
    L9:
        r0.append(r8.substring(r2));
        if (r1 >= r7.length) goto L17;
        r0.append(" [");
        int r9 = r1 + 1;
        r0.append(r7[r1]);
    L13:
        if (r9 >= r7.length) goto L15;
        r0.append(", ");
        r0.append(r7[r9]);
        r9 = r9 + 1;
        goto L13
    L15:
        r0.append(DefaultContactListAdapter.SNIPPET_END_MATCH);
    L17:
        return r0.toString();
    }
}
