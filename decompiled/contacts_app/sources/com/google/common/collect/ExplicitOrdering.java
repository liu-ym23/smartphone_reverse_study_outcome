package com.google.common.collect;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
final class ExplicitOrdering<T> extends Ordering<T> implements Serializable {
    private static final long serialVersionUID = 0;
    final ImmutableMap<T, Integer> rankMap;

    ExplicitOrdering(List<T> r1) {
        this(buildRankMap(r1));
    }

    ExplicitOrdering(ImmutableMap<T, Integer> r1) {
        this.rankMap = r1;
    }

    @Override // com.google.common.collect.Ordering, java.util.Comparator
    public int compare(T r1, T r2) {
        return rank(r1) - rank(r2);
    }

    private int rank(T r1) {
        Integer r0 = this.rankMap.get(r1);
        if (r0 == null) goto L7;
        return r0.intValue();
    L7:
        throw new Ordering.IncomparableValueException(r1);
    }

    private static <T> ImmutableMap<T, Integer> buildRankMap(List<T> r4) {
        ImmutableMap.Builder r0 = ImmutableMap.builder();
        Iterator<T> r5 = r4.iterator();
        int r1 = 0;
    L4:
        if (r5.hasNext() == false) goto L7;
        int r3 = r1 + 1;
        r0.put(r5.next(), Integer.valueOf(r1));
        r1 = r3;
        goto L4
    L7:
        return r0.build();
    }

    @Override // java.util.Comparator
    public boolean equals(@Nullable Object r2) {
        if ((r2 instanceof ExplicitOrdering) == true) goto L5;
        return false;
    L5:
        return this.rankMap.equals(((ExplicitOrdering) r2).rankMap);
    }

    public int hashCode() {
        return this.rankMap.hashCode();
    }

    public String toString() {
        return "Ordering.explicit(" + this.rankMap.keySet() + ")";
    }
}
