package com.google.common.base;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@Beta
@GwtCompatible
final class FunctionalEquivalence<F, T> extends Equivalence<F> implements Serializable {
    private static final long serialVersionUID = 0;
    private final Function<F, ? extends T> function;
    private final Equivalence<T> resultEquivalence;

    public FunctionalEquivalence(Function<F, ? extends T> r10, Equivalence<T> r11) {
        this.function = (Function) Preconditions.checkNotNull(r10);
        this.resultEquivalence = (Equivalence) Preconditions.checkNotNull(r11);
    }

    @Override // com.google.common.base.Equivalence
    public boolean doEquivalent(F r10, F r11) {
        return this.resultEquivalence.equivalent(this.function.apply(r10), this.function.apply(r11));
    }

    @Override // com.google.common.base.Equivalence
    public int doHash(F r10) {
        return this.resultEquivalence.hash(this.function.apply(r10));
    }

    public boolean equals(@NullableDecl Object r10) {
        if (r10 != this) goto L6;
        return true;
    L6:
        if ((r10 instanceof FunctionalEquivalence) == false) goto L14;
        FunctionalEquivalence r11 = (FunctionalEquivalence) r10;
        if (this.function.equals(r11.function) == false) goto L13;
        if (this.resultEquivalence.equals(r11.resultEquivalence) == false) goto L13;
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
