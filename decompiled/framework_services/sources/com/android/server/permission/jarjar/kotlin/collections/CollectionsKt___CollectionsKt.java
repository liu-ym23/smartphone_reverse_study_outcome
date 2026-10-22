package com.android.server.permission.jarjar.kotlin.collections;

import com.android.server.permission.jarjar.kotlin.jvm.functions.Function1;
import com.android.server.permission.jarjar.kotlin.jvm.internal.Intrinsics;
import com.android.server.permission.jarjar.kotlin.text.StringsKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: _Collections.kt */
/* JADX INFO: loaded from: classes2.dex */
class CollectionsKt___CollectionsKt extends CollectionsKt___CollectionsJvmKt {
    public static /* synthetic */ Object $r8$lambda$1rbo7n3iLaQpc3EKJifht_xcWyc(int r0, int r1) {
        return elementAt$lambda$0$CollectionsKt___CollectionsKt(r0, r1);
    }

    public static <T> T elementAt(Iterable<? extends T> r1, final int r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if ((r1 instanceof List) == false) goto L7;
        return (T) ((List) r1).get(r2);
    L7:
        return (T) elementAtOrElse(r1, r2, new CollectionsKt___CollectionsKt$$ExternalSyntheticLambda0(r2));
    }

    private static final Object elementAt$lambda$0$CollectionsKt___CollectionsKt(int $index, int it) {
        throw new IndexOutOfBoundsException("Collection doesn't contain element at index " + $index + '.');
    }

    public static final <T> T elementAtOrElse(Iterable<? extends T> r4, int r5, Function1<? super Integer, ? extends T> r6) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r6, "defaultValue");
        if ((r4 instanceof List) == false) goto L13;
        List r0 = (List) r4;
        boolean r1 = false;
        if (r5 >= 0) goto L7;
    L9:
        if (r1 == false) goto L12;
        return (T) r0.get(r5);
    L12:
        return r6.invoke(Integer.valueOf(r5));
    L7:
        if (r5 >= r0.size()) goto L9;
        r1 = true;
        goto L9
    L13:
        if (r5 < 0) goto L15;
        Iterator<? extends T> r2 = r4.iterator();
        int r3 = 0;
    L18:
        if (r2.hasNext() == false) goto L24;
        T r7 = r2.next();
        int r8 = r3 + 1;
        if (r5 == r3) goto L21;
        r3 = r8;
        goto L18
    L21:
        return r7;
    L24:
        return r6.invoke(Integer.valueOf(r5));
    L15:
        return r6.invoke(Integer.valueOf(r5));
    }

    public static final <T, C extends Collection<? super T>> C toCollection(Iterable<? extends T> r2, C r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "destination");
        Iterator<? extends T> r0 = r2.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r3.add(r0.next());
        goto L4
    L6:
        return r3;
    }

    public static <T> List<T> toList(Iterable<? extends T> r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        if ((r2 instanceof Collection) == false) goto L15;
        switch(((Collection) r2).size()) {
            case 0: goto L13;
            case 1: goto L8;
            default: goto L16;
        };
    L16:
        return toMutableList((Collection) r2);
    L8:
        if ((r2 instanceof List) == false) goto L10;
        Object r0 = ((List) r2).get(0);
    L17:
        return CollectionsKt__CollectionsJVMKt.listOf(r0);
    L10:
        r0 = ((Collection) r2).iterator().next();
        goto L17
    L13:
        return CollectionsKt.emptyList();
    L15:
        return CollectionsKt__CollectionsKt.optimizeReadOnlyList(toMutableList(r2));
    }

    public static final <T> List<T> toMutableList(Iterable<? extends T> r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if ((r1 instanceof Collection) == false) goto L7;
        return toMutableList((Collection) r1);
    L7:
        return (List) toCollection(r1, new ArrayList());
    }

    public static final <T> List<T> toMutableList(Collection<? extends T> r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return new ArrayList(r1);
    }

    public static final <T, A extends Appendable> A joinTo(Iterable<? extends T> r4, A r5, CharSequence separator, CharSequence prefix, CharSequence postfix, int limit, CharSequence truncated, Function1<? super T, ? extends CharSequence> r11) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r5, "buffer");
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(postfix, "postfix");
        Intrinsics.checkNotNullParameter(truncated, "truncated");
        r5.append(prefix);
        int count = 0;
        Iterator<? extends T> r1 = r4.iterator();
    L4:
        if (r1.hasNext() == false) goto L13;
        Object element = r1.next();
        count = count + 1;
        if (count <= 1) goto L8;
        r5.append(separator);
    L8:
        if (limit < 0) goto L12;
        if (count > limit) goto L13;
    L12:
        StringsKt.appendElement(r5, element, r11);
    L13:
        if (limit < 0) goto L16;
        if (count <= limit) goto L16;
        r5.append(truncated);
    L16:
        r5.append(postfix);
        return r5;
    }

    public static /* synthetic */ String joinToString$default(Iterable r1, CharSequence r2, CharSequence r3, CharSequence r4, int r5, CharSequence r6, Function1 r7, int r8, Object r9) {
        if ((r8 & 1) == 0) goto L6;
        r2 = ", ";
    L6:
        if ((r8 & 2) == 0) goto L9;
        r3 = "";
    L9:
        if ((r8 & 4) == 0) goto L12;
        r4 = "";
    L12:
        if ((r8 & 8) == 0) goto L15;
        r5 = -1;
    L15:
        if ((r8 & 16) == 0) goto L18;
        r6 = "...";
    L18:
        if ((r8 & 32) == 0) goto L20;
        r7 = null;
    L20:
        Function1 r10 = r7;
        int r11 = r5;
        CharSequence r12 = r6;
        CharSequence r13 = r4;
        CharSequence r14 = r2;
        return joinToString(r1, r14, r3, r13, r11, r12, r10);
    }

    public static final <T> String joinToString(Iterable<? extends T> r9, CharSequence separator, CharSequence prefix, CharSequence postfix, int limit, CharSequence truncated, Function1<? super T, ? extends CharSequence> r15) {
        Intrinsics.checkNotNullParameter(r9, "<this>");
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(postfix, "postfix");
        Intrinsics.checkNotNullParameter(truncated, "truncated");
        return ((StringBuilder) joinTo(r9, new StringBuilder(), separator, prefix, postfix, limit, truncated, r15)).toString();
    }
}
