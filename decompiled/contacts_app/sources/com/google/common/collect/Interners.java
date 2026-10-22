package com.google.common.collect;

import com.android.vcard.VCardConstants;
import com.google.common.base.Equivalence;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: loaded from: classes2.dex */
public final class Interners {

    private static class InternerFunction<E> implements Function<E, E> {
        private final Interner<E> interner;

        public InternerFunction(Interner<E> r1) {
            this.interner = r1;
        }

        @Override // com.google.common.base.Function
        public E apply(E r1) {
            return this.interner.intern(r1);
        }

        public int hashCode() {
            return this.interner.hashCode();
        }

        @Override // com.google.common.base.Function
        public boolean equals(Object r2) {
            if ((r2 instanceof InternerFunction) == true) goto L5;
            return false;
        L5:
            return this.interner.equals(((InternerFunction) r2).interner);
        }
    }

    private static class WeakInterner<E> implements Interner<E> {
        private final MapMakerInternalMap<E, Dummy> map;

        private static final enum Dummy extends Enum<Dummy> {
            private static final /* synthetic */ Dummy[] $VALUES = null;
            public static final Dummy VALUE = null;

            static {
                Dummy r0 = new Dummy(VCardConstants.PARAM_VALUE, 0);
                VALUE = r0;
                $VALUES = new Dummy[]{r0};
            }

            private Dummy(String r1, int r2) {
                super(r1, r2);
            }

            public static Dummy valueOf(String r1) {
                return (Dummy) Enum.valueOf(Dummy.class, r1);
            }

            public static Dummy[] values() {
                return (Dummy[]) $VALUES.clone();
            }
        }

        private WeakInterner() {
            this.map = (MapMakerInternalMap<E, Dummy>) new MapMaker().weakKeys2().keyEquivalence2(Equivalence.equals()).makeCustomMap();
        }

        /* synthetic */ WeakInterner(AnonymousClass1 r1) {
            this();
        }

        @Override // com.google.common.collect.Interner
        public E intern(E r3) {
        L2:
            MapMakerInternalMap.ReferenceEntry<E, Dummy> r0 = this.map.getEntry(r3);
            if (r0 == null) goto L8;
            E r1 = r0.getKey();
            if (r1 == null) goto L8;
            return r1;
        L8:
            if (this.map.putIfAbsent(r3, Dummy.VALUE) != null) goto L2;
            return r3;
        }
    }

    private Interners() {
    }

    public static <E> Interner<E> newStrongInterner() {
        final ConcurrentMap r0 = new MapMaker().makeMap();
        return new AnonymousClass1(r0);
    }

    public static <E> Interner<E> newWeakInterner() {
        return new WeakInterner(null);
    }

    public static <E> Function<E, E> asFunction(Interner<E> r1) {
        return new InternerFunction((Interner) Preconditions.checkNotNull(r1));
    }
}
