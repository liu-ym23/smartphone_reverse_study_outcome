package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.io.Serializable;
import java.util.Comparator;
import java.util.Iterator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible(serializable = true)
final class LexicographicalOrdering<T> extends Ordering<Iterable<T>> implements Serializable {
    private static final long serialVersionUID = 0;
    final Comparator<? super T> elementOrder;

    public LexicographicalOrdering(Comparator<? super T> r10) {
        this.elementOrder = r10;
    }

    @Override // com.google.common.collect.Ordering, java.util.Comparator
    public /* bridge */ /* synthetic */ int compare(Object r10, Object r11) {
        return compare((Iterable) r10, (Iterable) r11);
    }

    @Override // java.util.Comparator
    public boolean equals(@NullableDecl Object r10) {
        if (r10 != this) goto L6;
        return true;
    L6:
        if ((r10 instanceof LexicographicalOrdering) == true) goto L8;
        return false;
    L8:
        return this.elementOrder.equals(((LexicographicalOrdering) r10).elementOrder);
    }

    public int hashCode() {
        return this.elementOrder.hashCode() ^ 2075626741;
    }

    public String toString() {
        return this.elementOrder + ".lexicographical()";
    }

    public int compare(Iterable<T> r10, Iterable<T> r11) {
        Iterator<T> r12 = r10.iterator();
        Iterator<T> r13 = r11.iterator();
    L4:
        if (r12.hasNext() == false) goto L13;
        if (r13.hasNext() == false) goto L7;
        int r14 = this.elementOrder.compare(r12.next(), r13.next());
        if (r14 == 0) goto L4;
        return r14;
    L7:
        return 1;
    L13:
        if (r13.hasNext() == false) goto L16;
        return -1;
    L16:
        return 0;
    }
}
