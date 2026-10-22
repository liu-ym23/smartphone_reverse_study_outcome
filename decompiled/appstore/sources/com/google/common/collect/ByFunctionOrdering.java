package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible(serializable = true)
final class ByFunctionOrdering<F, T> extends Ordering<F> implements Serializable {
    private static final long serialVersionUID = 0;
    final Function<F, ? extends T> function;
    final Ordering<T> ordering;

    public ByFunctionOrdering(Function<F, ? extends T> r10, Ordering<T> r11) {
        this.function = (Function) Preconditions.checkNotNull(r10);
        this.ordering = (Ordering) Preconditions.checkNotNull(r11);
    }

    @Override // com.google.common.collect.Ordering, java.util.Comparator
    public int compare(F r10, F r11) {
        return this.ordering.compare(this.function.apply(r10), this.function.apply(r11));
    }

    @Override // java.util.Comparator
    public boolean equals(@NullableDecl Object r10) {
        if (r10 != this) goto L6;
        return true;
    L6:
        if ((r10 instanceof ByFunctionOrdering) == false) goto L14;
        ByFunctionOrdering r11 = (ByFunctionOrdering) r10;
        if (this.function.equals(r11.function) == false) goto L13;
        if (this.ordering.equals(r11.ordering) == false) goto L13;
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
