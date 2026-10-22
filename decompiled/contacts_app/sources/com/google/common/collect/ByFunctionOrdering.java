package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
final class ByFunctionOrdering<F, T> extends Ordering<F> implements Serializable {
    private static final long serialVersionUID = 0;
    final Function<F, ? extends T> function;
    final Ordering<T> ordering;

    ByFunctionOrdering(Function<F, ? extends T> r1, Ordering<T> r2) {
        this.function = (Function) Preconditions.checkNotNull(r1);
        this.ordering = (Ordering) Preconditions.checkNotNull(r2);
    }

    @Override // com.google.common.collect.Ordering, java.util.Comparator
    public int compare(F r3, F r4) {
        return this.ordering.compare(this.function.apply(r3), this.function.apply(r4));
    }

    @Override // java.util.Comparator
    public boolean equals(@Nullable Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof ByFunctionOrdering) == false) goto L14;
        ByFunctionOrdering r6 = (ByFunctionOrdering) r5;
        if (this.function.equals(r6.function) == false) goto L13;
        if (this.ordering.equals(r6.ordering) == false) goto L13;
        return true;
    L13:
        return false;
    L14:
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{this.function, this.ordering});
    }

    public String toString() {
        return this.ordering + ".onResultOf(" + this.function + ")";
    }
}
