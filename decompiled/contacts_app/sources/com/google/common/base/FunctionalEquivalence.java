package com.google.common.base;

import java.io.Serializable;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
final class FunctionalEquivalence<F, T> extends Equivalence<F> implements Serializable {
    private static final long serialVersionUID = 0;
    private final Function<F, ? extends T> function;
    private final Equivalence<T> resultEquivalence;

    FunctionalEquivalence(Function<F, ? extends T> r1, Equivalence<T> r2) {
        this.function = (Function) Preconditions.checkNotNull(r1);
        this.resultEquivalence = (Equivalence) Preconditions.checkNotNull(r2);
    }

    @Override // com.google.common.base.Equivalence
    protected boolean doEquivalent(F r3, F r4) {
        return this.resultEquivalence.equivalent(this.function.apply(r3), this.function.apply(r4));
    }

    @Override // com.google.common.base.Equivalence
    protected int doHash(F r2) {
        return this.resultEquivalence.hash(this.function.apply(r2));
    }

    public boolean equals(@Nullable Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof FunctionalEquivalence) == false) goto L14;
        FunctionalEquivalence r6 = (FunctionalEquivalence) r5;
        if (this.function.equals(r6.function) == false) goto L13;
        if (this.resultEquivalence.equals(r6.resultEquivalence) == false) goto L13;
        return true;
    L13:
        return false;
    L14:
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{this.function, this.resultEquivalence});
    }

    public String toString() {
        return this.resultEquivalence + ".onResultOf(" + this.function + ")";
    }
}
