package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.util.Comparator;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
@Beta
@GwtCompatible
public final class Comparators {
    private Comparators() {
    }

    public static <T> boolean isInOrder(Iterable<? extends T> r10, Comparator<T> r11) {
        Preconditions.checkNotNull(r11);
        Iterator<? extends T> r12 = r10.iterator();
        if (r12.hasNext() == false) goto L12;
        T r13 = r12.next();
    L6:
        if (r12.hasNext() == false) goto L16;
        T r14 = r12.next();
        if (r11.compare(r13, r14) > 0) goto L9;
        r13 = r14;
        goto L6
    L9:
        return false;
    L16:
        return true;
    L12:
        return true;
    }

    public static <T> boolean isInStrictOrder(Iterable<? extends T> r10, Comparator<T> r11) {
        Preconditions.checkNotNull(r11);
        Iterator<? extends T> r12 = r10.iterator();
        if (r12.hasNext() == false) goto L12;
        T r13 = r12.next();
    L6:
        if (r12.hasNext() == false) goto L16;
        T r14 = r12.next();
        if (r11.compare(r13, r14) >= 0) goto L9;
        r13 = r14;
        goto L6
    L9:
        return false;
    L16:
        return true;
    L12:
        return true;
    }

    public static <T, S extends T> Comparator<Iterable<S>> lexicographical(Comparator<T> r10) {
        return new LexicographicalOrdering((Comparator) Preconditions.checkNotNull(r10));
    }
}
