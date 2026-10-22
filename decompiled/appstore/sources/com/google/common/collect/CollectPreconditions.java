package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible
final class CollectPreconditions {
    public CollectPreconditions() {
    }

    public static void checkEntryNotNull(Object r10, Object r11) {
        if (r10 == null) goto L8;
        if (r11 == null) goto L6;
        return;
    L6:
        throw new NullPointerException("null value in entry: " + r10 + "=null");
    L8:
        throw new NullPointerException("null key in entry: null=" + r11);
    }

    @CanIgnoreReturnValue
    public static int checkNonnegative(int r10, String r11) {
        if (r10 < 0) goto L5;
        return r10;
    L5:
        throw new IllegalArgumentException(r11 + " cannot be negative but was: " + r10);
    }

    public static void checkPositive(int r10, String r11) {
        if (r10 <= 0) goto L5;
        return;
    L5:
        throw new IllegalArgumentException(r11 + " must be positive but was: " + r10);
    }

    public static void checkRemove(boolean r10) {
        Preconditions.checkState(r10, "no calls to next() since the last call to remove()");
    }

    @CanIgnoreReturnValue
    public static long checkNonnegative(long r10, String r11) {
        if (r10 < 0) goto L6;
        return r10;
    L6:
        throw new IllegalArgumentException(r11 + " cannot be negative but was: " + r10);
    }
}
