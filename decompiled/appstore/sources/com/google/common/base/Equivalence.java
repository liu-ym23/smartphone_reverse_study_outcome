package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.ForOverride;
import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible
public abstract class Equivalence<T> {

    /* JADX INFO: renamed from: com.google.common.base.Equivalence$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static final class Equals extends Equivalence<Object> implements Serializable {
        static final Equals INSTANCE = null;
        private static final long serialVersionUID = 1;

        static {
            INSTANCE = new Equals();
        }

        public Equals() {
        }

        private Object readResolve() {
            return INSTANCE;
        }

        @Override // com.google.common.base.Equivalence
        public boolean doEquivalent(Object r10, Object r11) {
            return r10.equals(r11);
        }

        @Override // com.google.common.base.Equivalence
        public int doHash(Object r10) {
            return r10.hashCode();
        }
    }

    public static final class EquivalentToPredicate<T> implements Predicate<T>, Serializable {
        private static final long serialVersionUID = 0;
        private final Equivalence<T> equivalence;

        @NullableDecl
        private final T target;

        public EquivalentToPredicate(Equivalence<T> r10, @NullableDecl T r11) {
            this.equivalence = (Equivalence) Preconditions.checkNotNull(r10);
            this.target = r11;
        }

        @Override // com.google.common.base.Predicate
        public boolean apply(@NullableDecl T r10) {
            return this.equivalence.equivalent(r10, this.target);
        }

        @Override // com.google.common.base.Predicate
        public boolean equals(@NullableDecl Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof EquivalentToPredicate) == false) goto L14;
            EquivalentToPredicate r11 = (EquivalentToPredicate) r10;
            if (this.equivalence.equals(r11.equivalence) == false) goto L13;
            if (Objects.equal(this.target, r11.target) == false) goto L13;
            return true;
        L13:
            return false;
        L14:
            return false;
        }

        public int hashCode() {
            return Objects.hashCode(new Object[]{this.equivalence, this.target});
        }

        public String toString() {
            return this.equivalence + ".equivalentTo(" + this.target + ")";
        }
    }

    public static final class Identity extends Equivalence<Object> implements Serializable {
        static final Identity INSTANCE = null;
        private static final long serialVersionUID = 1;

        static {
            INSTANCE = new Identity();
        }

        public Identity() {
        }

        private Object readResolve() {
            return INSTANCE;
        }

        @Override // com.google.common.base.Equivalence
        public boolean doEquivalent(Object r10, Object r11) {
            return false;
        }

        @Override // com.google.common.base.Equivalence
        public int doHash(Object r10) {
            return System.identityHashCode(r10);
        }
    }

    public static final class Wrapper<T> implements Serializable {
        private static final long serialVersionUID = 0;
        private final Equivalence<? super T> equivalence;

        @NullableDecl
        private final T reference;

        public /* synthetic */ Wrapper(Equivalence r10, Object r11, AnonymousClass1 r12) {
            this(r10, r11);
        }

        public boolean equals(@NullableDecl Object r10) {
            if (r10 != this) goto L6;
            return true;
        L6:
            if ((r10 instanceof Wrapper) == false) goto L11;
            Wrapper r11 = (Wrapper) r10;
            if (this.equivalence.equals(r11.equivalence) == true) goto L10;
            return false;
        L10:
            return this.equivalence.equivalent(this.reference, r11.reference);
        L11:
            return false;
        }

        @NullableDecl
        public T get() {
            return this.reference;
        }

        public int hashCode() {
            return this.equivalence.hash(this.reference);
        }

        public String toString() {
            return this.equivalence + ".wrap(" + this.reference + ")";
        }

        private Wrapper(Equivalence<? super T> r10, @NullableDecl T r11) {
            this.equivalence = (Equivalence) Preconditions.checkNotNull(r10);
            this.reference = r11;
        }
    }

    public Equivalence() {
    }

    public static Equivalence<Object> equals() {
        return Equals.INSTANCE;
    }

    public static Equivalence<Object> identity() {
        return Identity.INSTANCE;
    }

    @ForOverride
    public abstract boolean doEquivalent(T r10, T r11);

    @ForOverride
    public abstract int doHash(T r10);

    public final boolean equivalent(@NullableDecl T r10, @NullableDecl T r11) {
        if (r10 != r11) goto L5;
        return true;
    L5:
        if (r10 == null) goto L10;
        if (r11 != null) goto L9;
        return false;
    L9:
        return doEquivalent(r10, r11);
    L10:
        return false;
    }

    public final Predicate<T> equivalentTo(@NullableDecl T r10) {
        return new EquivalentToPredicate(this, r10);
    }

    public final int hash(@NullableDecl T r10) {
        if (r10 != null) goto L6;
        return 0;
    L6:
        return doHash(r10);
    }

    public final <F> Equivalence<F> onResultOf(Function<F, ? extends T> r10) {
        return new FunctionalEquivalence(r10, this);
    }

    @GwtCompatible(serializable = true)
    public final <S extends T> Equivalence<Iterable<S>> pairwise() {
        return new PairwiseEquivalence(this);
    }

    public final <S extends T> Wrapper<S> wrap(@NullableDecl S r10) {
        return new Wrapper(this, r10, null);
    }
}
