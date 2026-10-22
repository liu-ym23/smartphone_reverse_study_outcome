package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.util.Comparator;
import java.util.SortedSet;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible
final class SortedIterables {
    private SortedIterables() {
    }

    public static <E> Comparator<? super E> comparator(SortedSet<E> r10) {
        Comparator<? super E> r11 = r10.comparator();
        if (r11 == null) goto L5;
        return r11;
    L5:
        return Ordering.natural();
    }

    public static boolean hasSameComparator(Comparator<?> r10, Iterable<?> r11) {
        Preconditions.checkNotNull(r10);
        Preconditions.checkNotNull(r11);
        if ((r11 instanceof SortedSet) == false) goto L6;
        Comparator r12 = comparator((SortedSet) r11);
    L9:
        return r10.equals(r12);
    L6:
        if ((r11 instanceof SortedIterable) == false) goto L10;
        r12 = ((SortedIterable) r11).comparator();
        goto L9
    L10:
        return false;
    }
}
