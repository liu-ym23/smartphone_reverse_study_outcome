package com.android.server.permission.jarjar.kotlin.collections;

import com.android.server.permission.jarjar.kotlin.jvm.functions.Function1;
import com.android.server.permission.jarjar.kotlin.jvm.internal.Intrinsics;
import com.android.server.permission.jarjar.kotlin.text.StringsKt;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: _Arrays.kt */
/* JADX INFO: loaded from: classes2.dex */
class ArraysKt___ArraysKt extends ArraysKt___ArraysJvmKt {
    public static <T> boolean contains(T[] r1, T r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (indexOf(r1, r2) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static <T> T first(T[] r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        if (r2.length != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L10;
        return r2[0];
    L10:
        throw new NoSuchElementException("Array is empty.");
    L5:
        r0 = false;
        goto L6
    }

    public static final <T> int indexOf(T[] r3, T r4) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        if (r4 != null) goto L10;
        int index = 0;
        int r1 = r3.length;
    L5:
        if (index >= r1) goto L16;
        if (r3[index] == null) goto L8;
        index = index + 1;
        goto L5
    L8:
        return index;
    L16:
        return -1;
    L10:
        int index2 = 0;
        int r2 = r3.length;
    L11:
        if (index2 >= r2) goto L22;
        if (Intrinsics.areEqual(r4, r3[index2]) == true) goto L14;
        index2 = index2 + 1;
        goto L11
    L14:
        return index2;
    L22:
        return -1;
    }

    public static <T> T singleOrNull(T[] r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        if (r2.length == 1) goto L7;
        return null;
    L7:
        return r2[0];
    }

    public static /* synthetic */ Appendable joinTo$default(Object[] r6, Appendable r7, CharSequence r8, CharSequence r9, CharSequence r10, int r11, CharSequence r12, Function1 r13, int r14, Object r15) {
        if ((r14 & 2) == 0) goto L5;
        CharSequence r0 = ", ";
    L6:
        CharSequence r2 = "";
        if ((r14 & 4) == 0) goto L9;
        CharSequence r1 = "";
    L11:
        if ((r14 & 8) != 0) goto L15;
        r2 = r10;
    L15:
        if ((r14 & 16) == 0) goto L17;
        int r3 = -1;
    L19:
        if ((r14 & 32) == 0) goto L21;
        CharSequence r4 = "...";
    L23:
        if ((r14 & 64) == 0) goto L25;
        Function1 r5 = null;
    L27:
        return joinTo(r6, r7, r0, r1, r2, r3, r4, r5);
    L25:
        r5 = r13;
        goto L27
    L21:
        r4 = r12;
        goto L23
    L17:
        r3 = r11;
        goto L19
    L9:
        r1 = r9;
        goto L11
    L5:
        r0 = r8;
        goto L6
    }

    public static final <T, A extends Appendable> A joinTo(T[] r5, A r6, CharSequence separator, CharSequence prefix, CharSequence postfix, int limit, CharSequence truncated, Function1<? super T, ? extends CharSequence> r12) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r6, "buffer");
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(postfix, "postfix");
        Intrinsics.checkNotNullParameter(truncated, "truncated");
        r6.append(prefix);
        int count = 0;
        int r1 = r5.length;
        int r2 = 0;
    L4:
        if (r2 >= r1) goto L13;
        T r3 = r5[r2];
        count = count + 1;
        if (count <= 1) goto L8;
        r6.append(separator);
    L8:
        if (limit < 0) goto L12;
        if (count > limit) goto L13;
    L12:
        StringsKt.appendElement(r6, r3, r12);
        r2 = r2 + 1;
    L13:
        if (limit < 0) goto L16;
        if (count <= limit) goto L16;
        r6.append(truncated);
    L16:
        r6.append(postfix);
        return r6;
    }
}
