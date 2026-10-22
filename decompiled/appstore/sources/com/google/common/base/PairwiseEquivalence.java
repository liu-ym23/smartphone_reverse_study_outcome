package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import java.io.Serializable;
import java.util.Iterator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible(serializable = true)
final class PairwiseEquivalence<T> extends Equivalence<Iterable<T>> implements Serializable {
    private static final long serialVersionUID = 1;
    final Equivalence<? super T> elementEquivalence;

    public PairwiseEquivalence(Equivalence<? super T> r10) {
        this.elementEquivalence = (Equivalence) Preconditions.checkNotNull(r10);
    }

    @Override // com.google.common.base.Equivalence
    public /* bridge */ /* synthetic */ boolean doEquivalent(Object r10, Object r11) {
        return doEquivalent((Iterable) r10, (Iterable) r11);
    }

    @Override // com.google.common.base.Equivalence
    public /* bridge */ /* synthetic */ int doHash(Object r10) {
        return doHash((Iterable) r10);
    }

    public boolean equals(@NullableDecl Object r10) {
        if ((r10 instanceof PairwiseEquivalence) == true) goto L5;
        return false;
    L5:
        return this.elementEquivalence.equals(((PairwiseEquivalence) r10).elementEquivalence);
    }

    public int hashCode() {
        return this.elementEquivalence.hashCode() ^ 1185147655;
    }

    public String toString() {
        return this.elementEquivalence + ".pairwise()";
    }

    public boolean doEquivalent(Iterable<T> r10, Iterable<T> r11) {
        Iterator<T> r12 = r10.iterator();
        Iterator<T> r13 = r11.iterator();
    L4:
        if (r12.hasNext() == false) goto L11;
        if (r13.hasNext() == false) goto L11;
        if (this.elementEquivalence.equivalent(r12.next(), r13.next()) == true) goto L4;
        return false;
    L11:
        if (r12.hasNext() == false) goto L13;
        return false;
    L13:
        if (r13.hasNext() == true) goto L21;
        return true;
    L21:
        return false;
    }

    public int doHash(Iterable<T> r10) {
        Iterator<T> r11 = r10.iterator();
        int r12 = 78721;
    L4:
        if (r11.hasNext() == false) goto L6;
        T r13 = r11.next();
        r12 = (r12 * 24943) + this.elementEquivalence.hash(r13);
        goto L4
    L6:
        return r12;
    }
}
