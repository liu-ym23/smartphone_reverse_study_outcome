package com.google.common.collect;

import java.io.Serializable;
import java.util.Iterator;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
final class LexicographicalOrdering<T> extends Ordering<Iterable<T>> implements Serializable {
    private static final long serialVersionUID = 0;
    final Ordering<? super T> elementOrder;

    @Override // com.google.common.collect.Ordering, java.util.Comparator
    public /* bridge */ /* synthetic */ int compare(Object r1, Object r2) {
        return compare((Iterable) r1, (Iterable) r2);
    }

    LexicographicalOrdering(Ordering<? super T> r1) {
        this.elementOrder = r1;
    }

    public int compare(Iterable<T> r4, Iterable<T> r5) {
        Iterator<T> r6 = r4.iterator();
        Iterator<T> r7 = r5.iterator();
    L4:
        if (r6.hasNext() == false) goto L13;
        if (r7.hasNext() == false) goto L7;
        int r0 = this.elementOrder.compare(r6.next(), r7.next());
        if (r0 == 0) goto L4;
        return r0;
    L7:
        return 1;
    L13:
        if (r7.hasNext() == false) goto L16;
        return -1;
    L16:
        return 0;
    }

    @Override // java.util.Comparator
    public boolean equals(@Nullable Object r2) {
        if (r2 != this) goto L6;
        return true;
    L6:
        if ((r2 instanceof LexicographicalOrdering) == true) goto L8;
        return false;
    L8:
        return this.elementOrder.equals(((LexicographicalOrdering) r2).elementOrder);
    }

    public int hashCode() {
        return this.elementOrder.hashCode() ^ 2075626741;
    }

    public String toString() {
        return this.elementOrder + ".lexicographical()";
    }
}
