package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Equivalence;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;

/* JADX INFO: loaded from: classes3.dex */
@Beta
@GwtIncompatible
public final class Interners {

    /* JADX INFO: renamed from: com.google.common.collect.Interners$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class InternerBuilder {
        private final MapMaker mapMaker;
        private boolean strong;

        public /* synthetic */ InternerBuilder(AnonymousClass1 r10) {
            this();
        }

        public <E> Interner<E> build() {
            if (this.strong == true) goto L6;
            this.mapMaker.weakKeys();
        L6:
            return new InternerImpl(this.mapMaker, null);
        }

        public InternerBuilder concurrencyLevel(int r10) {
            this.mapMaker.concurrencyLevel(r10);
            return this;
        }

        public InternerBuilder strong() {
            this.strong = true;
            return this;
        }

        @GwtIncompatible("java.lang.ref.WeakReference")
        public InternerBuilder weak() {
            this.strong = false;
            return this;
        }

        private InternerBuilder() {
            this.mapMaker = new MapMaker();
            this.strong = true;
        }
    }

    public static class InternerFunction<E> implements Function<E, E> {
        private final Interner<E> interner;

        public InternerFunction(Interner<E> r10) {
            this.interner = r10;
        }

        @Override // com.google.common.base.Function
        public E apply(E r10) {
            return this.interner.intern(r10);
        }

        @Override // com.google.common.base.Function
        public boolean equals(Object r10) {
            if ((r10 instanceof InternerFunction) == true) goto L5;
            return false;
        L5:
            return this.interner.equals(((InternerFunction) r10).interner);
        }

        public int hashCode() {
            return this.interner.hashCode();
        }
    }

    @VisibleForTesting
    public static final class InternerImpl<E> implements Interner<E> {

        @VisibleForTesting
        final MapMakerInternalMap<E, MapMaker.Dummy, ?, ?> map;

        public /* synthetic */ InternerImpl(MapMaker r10, AnonymousClass1 r11) {
            this(r10);
        }

        @Override // com.google.common.collect.Interner
        public E intern(E r10) {
        L2:
            MapMakerInternalMap.InternalEntry r11 = this.map.getEntry(r10);
            if (r11 == null) goto L8;
            E r12 = (E) r11.getKey();
            if (r12 == null) goto L8;
            return r12;
        L8:
            if (this.map.putIfAbsent(r10, MapMaker.Dummy.VALUE) != null) goto L2;
            return r10;
        }

        private InternerImpl(MapMaker r10) {
            this.map = MapMakerInternalMap.createWithDummyValues(r10.keyEquivalence(Equivalence.equals()));
        }
    }

    private Interners() {
    }

    public static <E> Function<E, E> asFunction(Interner<E> r10) {
        return new InternerFunction((Interner) Preconditions.checkNotNull(r10));
    }

    public static InternerBuilder newBuilder() {
        return new InternerBuilder(null);
    }

    public static <E> Interner<E> newStrongInterner() {
        return newBuilder().strong().build();
    }

    @GwtIncompatible("java.lang.ref.WeakReference")
    public static <E> Interner<E> newWeakInterner() {
        return newBuilder().weak().build();
    }
}
