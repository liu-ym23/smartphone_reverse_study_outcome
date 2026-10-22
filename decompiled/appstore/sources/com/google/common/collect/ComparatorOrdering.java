package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.Comparator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible(serializable = true)
final class ComparatorOrdering<T> extends Ordering<T> implements Serializable {
    private static final long serialVersionUID = 0;
    final Comparator<T> comparator;

    public ComparatorOrdering(Comparator<T> r10) {
        this.comparator = (Comparator) Preconditions.checkNotNull(r10);
    }

    @Override // com.google.common.collect.Ordering, java.util.Comparator
    public int compare(T r10, T r11) {
        return this.comparator.compare(r10, r11);
    }

    @Override // java.util.Comparator
    public boolean equals(@NullableDecl Object r10) {
        if (r10 != this) goto L6;
        return true;
    L6:
        if ((r10 instanceof ComparatorOrdering) == true) goto L8;
        return false;
    L8:
        return this.comparator.equals(((ComparatorOrdering) r10).comparator);
    }

    public int hashCode() {
        return this.comparator.hashCode();
    }

    public String toString() {
        return this.comparator.toString();
    }
}
