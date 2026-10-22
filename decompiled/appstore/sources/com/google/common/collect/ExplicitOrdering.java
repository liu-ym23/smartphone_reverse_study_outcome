package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.io.Serializable;
import java.util.List;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible(serializable = true)
final class ExplicitOrdering<T> extends Ordering<T> implements Serializable {
    private static final long serialVersionUID = 0;
    final ImmutableMap<T, Integer> rankMap;

    public ExplicitOrdering(List<T> r10) {
        this(Maps.indexMap(r10));
    }

    private int rank(T r10) {
        Integer r11 = this.rankMap.get(r10);
        if (r11 == null) goto L7;
        return r11.intValue();
    L7:
        throw new Ordering.IncomparableValueException(r10);
    }

    @Override // com.google.common.collect.Ordering, java.util.Comparator
    public int compare(T r10, T r11) {
        return rank(r10) - rank(r11);
    }

    @Override // java.util.Comparator
    public boolean equals(@NullableDecl Object r10) {
        if ((r10 instanceof ExplicitOrdering) == true) goto L5;
        return false;
    L5:
        return this.rankMap.equals(((ExplicitOrdering) r10).rankMap);
    }

    public int hashCode() {
        return this.rankMap.hashCode();
    }

    public String toString() {
        return "Ordering.explicit(" + this.rankMap.keySet() + ")";
    }

    public ExplicitOrdering(ImmutableMap<T, Integer> r10) {
        this.rankMap = r10;
    }
}
