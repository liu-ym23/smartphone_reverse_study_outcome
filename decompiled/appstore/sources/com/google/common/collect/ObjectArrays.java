package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible(emulated = true)
public final class ObjectArrays {
    private ObjectArrays() {
    }

    @CanIgnoreReturnValue
    public static Object checkElementNotNull(Object r10, int r11) {
        if (r10 == null) goto L5;
        return r10;
    L5:
        throw new NullPointerException("at index " + r11);
    }

    @CanIgnoreReturnValue
    public static Object[] checkElementsNotNull(Object... r10) {
        return checkElementsNotNull(r10, r10.length);
    }

    @GwtIncompatible
    public static <T> T[] concat(T[] r10, T[] r11, Class<T> r12) {
        T[] r13 = (T[]) newArray(r12, r10.length + r11.length);
        System.arraycopy(r10, 0, r13, 0, r10.length);
        System.arraycopy(r11, 0, r13, r10.length, r11.length);
        return r13;
    }

    public static Object[] copyAsObjectArray(Object[] r10, int r11, int r12) {
        Preconditions.checkPositionIndexes(r11, r11 + r12, r10.length);
        if (r12 == 0) goto L5;
        Object[] r13 = new Object[r12];
        System.arraycopy(r10, r11, r13, 0, r12);
        return r13;
    L5:
        return new Object[0];
    }

    @CanIgnoreReturnValue
    private static Object[] fillArray(Iterable<?> r10, Object[] r11) {
        Iterator<?> r12 = r10.iterator();
        int r13 = 0;
    L4:
        if (r12.hasNext() == false) goto L6;
        r11[r13] = r12.next();
        r13 = r13 + 1;
        goto L4
    L6:
        return r11;
    }

    @GwtIncompatible
    public static <T> T[] newArray(Class<T> r10, int r11) {
        return (T[]) ((Object[]) Array.newInstance(r10, r11));
    }

    public static void swap(Object[] r10, int r11, int r12) {
        Object r13 = r10[r11];
        r10[r11] = r10[r12];
        r10[r12] = r13;
    }

    public static <T> T[] toArrayImpl(Collection<?> r10, T[] r11) {
        int r12 = r10.size();
        if (r11.length >= r12) goto L5;
        r11 = (T[]) newArray(r11, r12);
    L5:
        fillArray(r10, r11);
        if (r11.length <= r12) goto L8;
        r11[r12] = null;
    L8:
        return r11;
    }

    @CanIgnoreReturnValue
    public static Object[] checkElementsNotNull(Object[] r10, int r11) {
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        checkElementNotNull(r10[r12], r12);
        r12 = r12 + 1;
        goto L3
    L5:
        return r10;
    }

    public static <T> T[] newArray(T[] r10, int r11) {
        return (T[]) Platform.newArray(r10, r11);
    }

    public static <T> T[] concat(@NullableDecl T r10, T[] r11) {
        T[] r12 = (T[]) newArray(r11, r11.length + 1);
        r12[0] = r10;
        System.arraycopy(r11, 0, r12, 1, r11.length);
        return r12;
    }

    public static <T> T[] concat(T[] r10, @NullableDecl T r11) {
        T[] r12 = (T[]) Arrays.copyOf(r10, r10.length + 1);
        r12[r10.length] = r11;
        return r12;
    }

    public static <T> T[] toArrayImpl(Object[] r10, int r11, int r12, T[] r13) {
        Preconditions.checkPositionIndexes(r11, r11 + r12, r10.length);
        if (r13.length >= r12) goto L6;
        r13 = (T[]) newArray(r13, r12);
    L8:
        System.arraycopy(r10, r11, r13, 0, r12);
        return r13;
    L6:
        if (r13.length <= r12) goto L8;
        r13[r12] = null;
        goto L8
    }

    public static Object[] toArrayImpl(Collection<?> r10) {
        return fillArray(r10, new Object[r10.size()]);
    }
}
