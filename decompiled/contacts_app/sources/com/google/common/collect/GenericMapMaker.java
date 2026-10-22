package com.google.common.collect;

import com.google.common.base.Equivalence;
import com.google.common.base.Function;
import com.google.common.base.MoreObjects;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
abstract class GenericMapMaker<K0, V0> {
    MapMaker.RemovalListener<K0, V0> removalListener;

    static final enum NullListener extends Enum<NullListener> implements MapMaker.RemovalListener<Object, Object> {
        private static final /* synthetic */ NullListener[] $VALUES = null;
        public static final NullListener INSTANCE = null;

        @Override // com.google.common.collect.MapMaker.RemovalListener
        public void onRemoval(MapMaker.RemovalNotification<Object, Object> r1) {
        }

        public static NullListener valueOf(String r1) {
            return (NullListener) Enum.valueOf(NullListener.class, r1);
        }

        public static NullListener[] values() {
            return (NullListener[]) $VALUES.clone();
        }

        private NullListener(String r1, int r2) {
            super(r1, r2);
        }

        static {
            NullListener r0 = new NullListener("INSTANCE", 0);
            INSTANCE = r0;
            $VALUES = new NullListener[]{r0};
        }
    }

    public abstract GenericMapMaker<K0, V0> concurrencyLevel(int r1);

    abstract GenericMapMaker<K0, V0> expireAfterAccess(long r1, TimeUnit r3);

    abstract GenericMapMaker<K0, V0> expireAfterWrite(long r1, TimeUnit r3);

    public abstract GenericMapMaker<K0, V0> initialCapacity(int r1);

    abstract GenericMapMaker<K0, V0> keyEquivalence(Equivalence<Object> r1);

    @Deprecated
    abstract <K extends K0, V extends V0> ConcurrentMap<K, V> makeComputingMap(Function<? super K, ? extends V> r1);

    abstract <K, V> MapMakerInternalMap<K, V> makeCustomMap();

    public abstract <K extends K0, V extends V0> ConcurrentMap<K, V> makeMap();

    abstract GenericMapMaker<K0, V0> maximumSize(int r1);

    @Deprecated
    public abstract GenericMapMaker<K0, V0> softValues();

    public abstract GenericMapMaker<K0, V0> weakKeys();

    public abstract GenericMapMaker<K0, V0> weakValues();

    GenericMapMaker() {
    }

    <K extends K0, V extends V0> MapMaker.RemovalListener<K, V> getRemovalListener() {
        return (MapMaker.RemovalListener) MoreObjects.firstNonNull(this.removalListener, NullListener.INSTANCE);
    }
}
