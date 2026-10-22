package com.google.common.base;

import java.io.Serializable;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public abstract class Equivalence<T> {

    /* JADX INFO: renamed from: com.google.common.base.Equivalence$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    static final class Equals extends Equivalence<Object> implements Serializable {
        static final Equals INSTANCE = null;
        private static final long serialVersionUID = 1;

        Equals() {
        }

        static {
            INSTANCE = new Equals();
        }

        @Override // com.google.common.base.Equivalence
        protected boolean doEquivalent(Object r1, Object r2) {
            return r1.equals(r2);
        }

        @Override // com.google.common.base.Equivalence
        protected int doHash(Object r1) {
            return r1.hashCode();
        }

        private Object readResolve() {
            return INSTANCE;
        }
    }

    private static final class EquivalentToPredicate<T> implements Predicate<T>, Serializable {
        private static final long serialVersionUID = 0;
        private final Equivalence<T> equivalence;

        @Nullable
        private final T target;

        EquivalentToPredicate(Equivalence<T> r1, @Nullable T r2) {
            this.equivalence = (Equivalence) Preconditions.checkNotNull(r1);
            this.target = r2;
        }

        @Override // com.google.common.base.Predicate
        public boolean apply(@Nullable T r2) {
            return this.equivalence.equivalent(r2, this.target);
        }

        @Override // com.google.common.base.Predicate
        public boolean equals(@Nullable Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof EquivalentToPredicate) == false) goto L14;
            EquivalentToPredicate r6 = (EquivalentToPredicate) r5;
            if (this.equivalence.equals(r6.equivalence) == false) goto L13;
            if (Objects.equal(this.target, r6.target) == false) goto L13;
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

    static final class Identity extends Equivalence<Object> implements Serializable {
        static final Identity INSTANCE = null;
        private static final long serialVersionUID = 1;

        @Override // com.google.common.base.Equivalence
        protected boolean doEquivalent(Object r1, Object r2) {
            return false;
        }

        Identity() {
        }

        static {
            INSTANCE = new Identity();
        }

        @Override // com.google.common.base.Equivalence
        protected int doHash(Object r1) {
            return System.identityHashCode(r1);
        }

        private Object readResolve() {
            return INSTANCE;
        }
    }

    public static final class Wrapper<T> implements Serializable {
        private static final long serialVersionUID = 0;
        private final Equivalence<? super T> equivalence;

        @Nullable
        private final T reference;

        /* synthetic */ Wrapper(Equivalence r1, Object r2, AnonymousClass1 r3) {
            this(r1, r2);
        }

        private Wrapper(Equivalence<? super T> r1, @Nullable T r2) {
            this.equivalence = (Equivalence) Preconditions.checkNotNull(r1);
            this.reference = r2;
        }

        @Nullable
        public T get() {
            return this.reference;
        }

        public boolean equals(@Nullable Object r3) {
            if (r3 != this) goto L6;
            return true;
        L6:
            if ((r3 instanceof Wrapper) == false) goto L11;
            Wrapper r4 = (Wrapper) r3;
            if (this.equivalence.equals(r4.equivalence) == true) goto L10;
            return false;
        L10:
            return this.equivalence.equivalent(this.reference, r4.reference);
        L11:
            return false;
        }

        public int hashCode() {
            return this.equivalence.hash(this.reference);
        }

        public String toString() {
            return this.equivalence + ".wrap(" + this.reference + ")";
        }
    }

    protected abstract boolean doEquivalent(T r1, T r2);

    protected abstract int doHash(T r1);

    protected Equivalence() {
    }

    public final boolean equivalent(@Nullable T r1, @Nullable T r2) {
        if (r1 != r2) goto L5;
        return true;
    L5:
        if (r1 == null) goto L10;
        if (r2 != null) goto L9;
        return false;
    L9:
        return doEquivalent(r1, r2);
    L10:
        return false;
    }

    public final int hash(@Nullable T r1) {
        if (r1 != null) goto L6;
        return 0;
    L6:
        return doHash(r1);
    }

    public final <F> Equivalence<F> onResultOf(Function<F, ? extends T> r2) {
        return new FunctionalEquivalence(r2, this);
    }

    public final <S extends T> Wrapper<S> wrap(@Nullable S r3) {
        return new Wrapper(this, r3, null);
    }

    public final <S extends T> Equivalence<Iterable<S>> pairwise() {
        return new PairwiseEquivalence(this);
    }

    public final Predicate<T> equivalentTo(@Nullable T r2) {
        return new EquivalentToPredicate(this, r2);
    }

    public static Equivalence<Object> equals() {
        return Equals.INSTANCE;
    }

    public static Equivalence<Object> identity() {
        return Identity.INSTANCE;
    }
}
