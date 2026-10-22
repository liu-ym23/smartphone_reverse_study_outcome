package com.android.server.permission.jarjar.kotlin.jvm.internal;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: compiled from: CollectionToArray.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class CollectionToArray {
    private static final Object[] EMPTY = null;

    static {
        EMPTY = new Object[0];
    }

    public static final Object[] toArray(Collection<?> r10) {
        Intrinsics.checkNotNullParameter(r10, "collection");
        int size$iv = r10.size();
        if (size$iv == 0) goto L35;
        Iterator<?> r2 = r10.iterator();
        if (r2.hasNext() == false) goto L36;
        Object[] result$iv = new Object[size$iv];
        int i$iv = 0;
    L9:
        i$iv = i$iv + 1;
        result$iv[i$iv] = r2.next();
        if (i$iv >= result$iv.length) goto L12;
        if (r2.hasNext() == true) goto L9;
        Object[] result = result$iv;
        Object[] r8 = Arrays.copyOf(result, i$iv);
        Intrinsics.checkNotNullExpressionValue(r8, "copyOf(...)");
        return r8;
    L12:
        if (r2.hasNext() == false) goto L37;
        int newSize$iv = ((i$iv * 3) + 1) >>> 1;
        if (newSize$iv <= i$iv) goto L17;
    L21:
        result$iv = Arrays.copyOf(result$iv, newSize$iv);
        goto L9
    L17:
        if (i$iv >= 2147483645) goto L20;
        newSize$iv = 2147483645;
        goto L21
    L20:
        throw new OutOfMemoryError();
    L37:
        return result$iv;
    L36:
        return EMPTY;
    L35:
        return EMPTY;
    }

    public static final Object[] toArray(Collection<?> r10, Object[] a) {
        Intrinsics.checkNotNullParameter(r10, "collection");
        if (a == null) goto L45;
        int size$iv = r10.size();
        if (size$iv == 0) goto L7;
        Iterator<?> r4 = r10.iterator();
        if (r4.hasNext() == true) goto L18;
        if (a.length <= 0) goto L54;
        a[0] = null;
    L54:
        return a;
    L18:
        if (size$iv > a.length) goto L20;
        Object[] result$iv = a;
    L21:
        int i$iv = 0;
    L22:
        i$iv = i$iv + 1;
        result$iv[i$iv] = r4.next();
        if (i$iv >= result$iv.length) goto L25;
        if (r4.hasNext() == true) goto L22;
        Object[] result = result$iv;
        if (result != a) goto L40;
        a[i$iv] = null;
        Object[] r3 = a;
    L41:
        Object[] result$iv2 = r3;
        return result$iv2;
    L40:
        r3 = Arrays.copyOf(result, i$iv);
        Intrinsics.checkNotNullExpressionValue(r3, "copyOf(...)");
        goto L41
    L25:
        if (r4.hasNext() == false) goto L55;
        int newSize$iv = ((i$iv * 3) + 1) >>> 1;
        if (newSize$iv <= i$iv) goto L30;
    L34:
        result$iv = Arrays.copyOf(result$iv, newSize$iv);
        goto L22
    L30:
        if (i$iv >= 2147483645) goto L33;
        newSize$iv = 2147483645;
        goto L34
    L33:
        throw new OutOfMemoryError();
    L55:
        return result$iv;
    L20:
        Object r6 = Array.newInstance(a.getClass().getComponentType(), size$iv);
        Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        result$iv = (Object[]) r6;
        goto L21
    L7:
        if (a.length <= 0) goto L54;
        a[0] = null;
        goto L54
    L45:
        throw new NullPointerException();
    }
}
