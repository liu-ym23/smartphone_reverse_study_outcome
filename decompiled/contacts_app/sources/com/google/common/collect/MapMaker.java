package com.google.common.collect;

import com.bytedance.librarian.LibrarianImpl;
import com.google.common.base.Ascii;
import com.google.common.base.Equivalence;
import com.google.common.base.Function;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.base.Throwables;
import com.google.common.base.Ticker;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class MapMaker extends GenericMapMaker<Object, Object> {
    private static final int DEFAULT_CONCURRENCY_LEVEL = 4;
    private static final int DEFAULT_EXPIRATION_NANOS = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;
    static final int UNSET_INT = -1;
    int concurrencyLevel;
    long expireAfterAccessNanos;
    long expireAfterWriteNanos;
    int initialCapacity;
    Equivalence<Object> keyEquivalence;
    MapMakerInternalMap.Strength keyStrength;
    int maximumSize;
    RemovalCause nullRemovalCause;
    Ticker ticker;
    boolean useCustomMap;
    MapMakerInternalMap.Strength valueStrength;

    /* JADX INFO: renamed from: com.google.common.collect.MapMaker$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    static final class ComputingMapAdapter<K, V> extends ComputingConcurrentHashMap<K, V> implements Serializable {
        private static final long serialVersionUID = 0;

        ComputingMapAdapter(MapMaker r1, Function<? super K, ? extends V> r2) {
            super(r1, r2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.MapMakerInternalMap, java.util.AbstractMap, java.util.Map
        public V get(Object r3) {
            V r0 = getOrCompute(r3);     // Catch: ExecutionException -> L7
            if (r0 == null) goto L6;
            return r0;
        L6:
            throw new NullPointerException(this.computingFunction + " returned null for key " + r3 + LibrarianImpl.Constants.DOT);
        L7:
            e = move-exception;
            Throwable r2 = e.getCause();
            Throwables.propagateIfInstanceOf(r2, ComputationException.class);
            throw new ComputationException(r2);
        }
    }

    static final class NullComputingConcurrentMap<K, V> extends NullConcurrentMap<K, V> {
        private static final long serialVersionUID = 0;
        final Function<? super K, ? extends V> computingFunction;

        NullComputingConcurrentMap(MapMaker r1, Function<? super K, ? extends V> r2) {
            super(r1);
            this.computingFunction = (Function) Preconditions.checkNotNull(r2);
        }

        @Override // com.google.common.collect.MapMaker.NullConcurrentMap, java.util.AbstractMap, java.util.Map
        public V get(Object r5) {
            V r0 = compute(r5);
            Preconditions.checkNotNull(r0, "%s returned null for key %s.", new Object[]{this.computingFunction, r5});
            notifyRemoval(r5, r0);
            return r0;
        }

        private V compute(K r1) {
            Preconditions.checkNotNull(r1);
            return this.computingFunction.apply(r1);
        L8:
            e = move-exception;
            throw e;
        L5:
            th = move-exception;
            throw new ComputationException(th);
        }
    }

    static class NullConcurrentMap<K, V> extends AbstractMap<K, V> implements ConcurrentMap<K, V>, Serializable {
        private static final long serialVersionUID = 0;
        private final RemovalCause removalCause;
        private final RemovalListener<K, V> removalListener;

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(@Nullable Object r1) {
            return false;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsValue(@Nullable Object r1) {
            return false;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V get(@Nullable Object r1) {
            return null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V remove(@Nullable Object r1) {
            return null;
        }

        @Override // java.util.Map, java.util.concurrent.ConcurrentMap
        public boolean remove(@Nullable Object r1, @Nullable Object r2) {
            return false;
        }

        NullConcurrentMap(MapMaker r2) {
            this.removalListener = r2.getRemovalListener();
            this.removalCause = r2.nullRemovalCause;
        }

        void notifyRemoval(K r3, V r4) {
            RemovalNotification<K, V> r0 = new RemovalNotification(r3, r4, this.removalCause);
            this.removalListener.onRemoval(r0);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V put(K r1, V r2) {
            Preconditions.checkNotNull(r1);
            Preconditions.checkNotNull(r2);
            notifyRemoval(r1, r2);
            return null;
        }

        @Override // java.util.Map, java.util.concurrent.ConcurrentMap
        public V putIfAbsent(K r1, V r2) {
            return put(r1, r2);
        }

        @Override // java.util.Map, java.util.concurrent.ConcurrentMap
        public V replace(K r1, V r2) {
            Preconditions.checkNotNull(r1);
            Preconditions.checkNotNull(r2);
            return null;
        }

        @Override // java.util.Map, java.util.concurrent.ConcurrentMap
        public boolean replace(K r1, @Nullable V r2, V r3) {
            Preconditions.checkNotNull(r1);
            Preconditions.checkNotNull(r3);
            return false;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<Map.Entry<K, V>> entrySet() {
            return Collections.emptySet();
        }
    }

    static abstract enum RemovalCause extends Enum<RemovalCause> {
        private static final /* synthetic */ RemovalCause[] $VALUES = null;
        public static final RemovalCause COLLECTED = null;
        public static final RemovalCause EXPIRED = null;
        public static final RemovalCause EXPLICIT = null;
        public static final RemovalCause REPLACED = null;
        public static final RemovalCause SIZE = null;

        abstract boolean wasEvicted();

        private RemovalCause(String r1, int r2) {
            super(r1, r2);
        }

        /* synthetic */ RemovalCause(String r1, int r2, AnonymousClass1 r3) {
            this(r1, r2);
        }

        public static RemovalCause valueOf(String r1) {
            return (RemovalCause) Enum.valueOf(RemovalCause.class, r1);
        }

        public static RemovalCause[] values() {
            return (RemovalCause[]) $VALUES.clone();
        }

        static {
            final String r1 = "EXPLICIT";
            final int r2 = 0;
            RemovalCause r0 = new AnonymousClass1(r1, r2);
            EXPLICIT = r0;
            final String r3 = "REPLACED";
            final int r4 = 1;
            RemovalCause r5 = new AnonymousClass2(r3, r4);
            REPLACED = r5;
            final String r6 = "COLLECTED";
            final int r7 = 2;
            RemovalCause r8 = new AnonymousClass3(r6, r7);
            COLLECTED = r8;
            final String r9 = "EXPIRED";
            final int r10 = 3;
            RemovalCause r11 = new AnonymousClass4(r9, r10);
            EXPIRED = r11;
            final String r12 = "SIZE";
            final int r13 = 4;
            RemovalCause r14 = new AnonymousClass5(r12, r13);
            SIZE = r14;
            $VALUES = new RemovalCause[]{r0, r5, r8, r11, r14};
        }
    }

    interface RemovalListener<K, V> {
        void onRemoval(RemovalNotification<K, V> r1);
    }

    static final class RemovalNotification<K, V> extends ImmutableEntry<K, V> {
        private static final long serialVersionUID = 0;
        private final RemovalCause cause;

        RemovalNotification(@Nullable K r1, @Nullable V r2, RemovalCause r3) {
            super(r1, r2);
            this.cause = r3;
        }

        public RemovalCause getCause() {
            return this.cause;
        }

        public boolean wasEvicted() {
            return this.cause.wasEvicted();
        }
    }

    @Override // com.google.common.collect.GenericMapMaker
    public /* bridge */ /* synthetic */ GenericMapMaker<Object, Object> concurrencyLevel(int r1) {
        return concurrencyLevel2(r1);
    }

    @Override // com.google.common.collect.GenericMapMaker
    @Deprecated
    /* bridge */ /* synthetic */ GenericMapMaker<Object, Object> expireAfterAccess(long r1, TimeUnit r3) {
        return expireAfterAccess2(r1, r3);
    }

    @Override // com.google.common.collect.GenericMapMaker
    @Deprecated
    /* bridge */ /* synthetic */ GenericMapMaker<Object, Object> expireAfterWrite(long r1, TimeUnit r3) {
        return expireAfterWrite2(r1, r3);
    }

    @Override // com.google.common.collect.GenericMapMaker
    public /* bridge */ /* synthetic */ GenericMapMaker<Object, Object> initialCapacity(int r1) {
        return initialCapacity2(r1);
    }

    @Override // com.google.common.collect.GenericMapMaker
    /* bridge */ /* synthetic */ GenericMapMaker<Object, Object> keyEquivalence(Equivalence r1) {
        return keyEquivalence2(r1);
    }

    @Override // com.google.common.collect.GenericMapMaker
    @Deprecated
    /* bridge */ /* synthetic */ GenericMapMaker<Object, Object> maximumSize(int r1) {
        return maximumSize2(r1);
    }

    @Override // com.google.common.collect.GenericMapMaker
    @Deprecated
    public /* bridge */ /* synthetic */ GenericMapMaker<Object, Object> softValues() {
        return softValues2();
    }

    @Override // com.google.common.collect.GenericMapMaker
    public /* bridge */ /* synthetic */ GenericMapMaker<Object, Object> weakKeys() {
        return weakKeys2();
    }

    @Override // com.google.common.collect.GenericMapMaker
    public /* bridge */ /* synthetic */ GenericMapMaker<Object, Object> weakValues() {
        return weakValues2();
    }

    public MapMaker() {
        this.initialCapacity = -1;
        this.concurrencyLevel = -1;
        this.maximumSize = -1;
        this.expireAfterWriteNanos = -1;
        this.expireAfterAccessNanos = -1;
    }

    @Override // com.google.common.collect.GenericMapMaker
    /* JADX INFO: renamed from: keyEquivalence, reason: avoid collision after fix types in other method */
    GenericMapMaker<Object, Object> keyEquivalence2(Equivalence<Object> r6) {
        Equivalence<Object> r0 = this.keyEquivalence;
        if (r0 != null) goto L5;
        boolean r3 = true;
    L6:
        Preconditions.checkState(r3, "key equivalence was already set to %s", new Object[]{r0});
        this.keyEquivalence = (Equivalence) Preconditions.checkNotNull(r6);
        this.useCustomMap = true;
        return this;
    L5:
        r3 = false;
        goto L6
    }

    Equivalence<Object> getKeyEquivalence() {
        return (Equivalence) MoreObjects.firstNonNull(this.keyEquivalence, getKeyStrength().defaultEquivalence());
    }

    @Override // com.google.common.collect.GenericMapMaker
    /* JADX INFO: renamed from: initialCapacity, reason: avoid collision after fix types in other method */
    public GenericMapMaker<Object, Object> initialCapacity2(int r6) {
        int r0 = this.initialCapacity;
        boolean r2 = true;
        if (r0 != (-1)) goto L5;
        boolean r1 = true;
    L6:
        Preconditions.checkState(r1, "initial capacity was already set to %s", new Object[]{Integer.valueOf(r0)});
        if (r6 >= 0) goto L10;
        r2 = false;
    L10:
        Preconditions.checkArgument(r2);
        this.initialCapacity = r6;
        return this;
    L5:
        r1 = false;
        goto L6
    }

    int getInitialCapacity() {
        int r1 = this.initialCapacity;
        if (r1 != (-1)) goto L6;
        return 16;
    L6:
        return r1;
    }

    @Override // com.google.common.collect.GenericMapMaker
    @Deprecated
    /* JADX INFO: renamed from: maximumSize, reason: avoid collision after fix types in other method */
    GenericMapMaker<Object, Object> maximumSize2(int r6) {
        int r0 = this.maximumSize;
        boolean r2 = false;
        if (r0 != (-1)) goto L5;
        boolean r1 = true;
    L6:
        Preconditions.checkState(r1, "maximum size was already set to %s", new Object[]{Integer.valueOf(r0)});
        if (r6 < 0) goto L9;
        r2 = true;
    L9:
        Preconditions.checkArgument(r2, "maximum size must not be negative");
        this.maximumSize = r6;
        this.useCustomMap = true;
        if (r6 != 0) goto L12;
        this.nullRemovalCause = RemovalCause.SIZE;
    L12:
        return this;
    L5:
        r1 = false;
        goto L6
    }

    @Override // com.google.common.collect.GenericMapMaker
    /* JADX INFO: renamed from: concurrencyLevel, reason: avoid collision after fix types in other method */
    public GenericMapMaker<Object, Object> concurrencyLevel2(int r6) {
        int r0 = this.concurrencyLevel;
        boolean r2 = true;
        if (r0 != (-1)) goto L5;
        boolean r1 = true;
    L6:
        Preconditions.checkState(r1, "concurrency level was already set to %s", new Object[]{Integer.valueOf(r0)});
        if (r6 > 0) goto L10;
        r2 = false;
    L10:
        Preconditions.checkArgument(r2);
        this.concurrencyLevel = r6;
        return this;
    L5:
        r1 = false;
        goto L6
    }

    int getConcurrencyLevel() {
        int r1 = this.concurrencyLevel;
        if (r1 != (-1)) goto L6;
        return 4;
    L6:
        return r1;
    }

    @Override // com.google.common.collect.GenericMapMaker
    /* JADX INFO: renamed from: weakKeys, reason: avoid collision after fix types in other method */
    public GenericMapMaker<Object, Object> weakKeys2() {
        return setKeyStrength(MapMakerInternalMap.Strength.WEAK);
    }

    MapMaker setKeyStrength(MapMakerInternalMap.Strength r6) {
        MapMakerInternalMap.Strength r0 = this.keyStrength;
        boolean r1 = false;
        if (r0 != null) goto L5;
        boolean r3 = true;
    L6:
        Preconditions.checkState(r3, "Key strength was already set to %s", new Object[]{r0});
        MapMakerInternalMap.Strength r2 = (MapMakerInternalMap.Strength) Preconditions.checkNotNull(r6);
        this.keyStrength = r2;
        if (r2 == MapMakerInternalMap.Strength.SOFT) goto L9;
        r1 = true;
    L9:
        Preconditions.checkArgument(r1, "Soft keys are not supported");
        if (r6 == MapMakerInternalMap.Strength.STRONG) goto L12;
        this.useCustomMap = true;
    L12:
        return this;
    L5:
        r3 = false;
        goto L6
    }

    MapMakerInternalMap.Strength getKeyStrength() {
        return (MapMakerInternalMap.Strength) MoreObjects.firstNonNull(this.keyStrength, MapMakerInternalMap.Strength.STRONG);
    }

    @Override // com.google.common.collect.GenericMapMaker
    /* JADX INFO: renamed from: weakValues, reason: avoid collision after fix types in other method */
    public GenericMapMaker<Object, Object> weakValues2() {
        return setValueStrength(MapMakerInternalMap.Strength.WEAK);
    }

    @Override // com.google.common.collect.GenericMapMaker
    @Deprecated
    /* JADX INFO: renamed from: softValues, reason: avoid collision after fix types in other method */
    public GenericMapMaker<Object, Object> softValues2() {
        return setValueStrength(MapMakerInternalMap.Strength.SOFT);
    }

    MapMaker setValueStrength(MapMakerInternalMap.Strength r6) {
        MapMakerInternalMap.Strength r0 = this.valueStrength;
        if (r0 != null) goto L5;
        boolean r3 = true;
    L6:
        Preconditions.checkState(r3, "Value strength was already set to %s", new Object[]{r0});
        this.valueStrength = (MapMakerInternalMap.Strength) Preconditions.checkNotNull(r6);
        if (r6 == MapMakerInternalMap.Strength.STRONG) goto L9;
        this.useCustomMap = true;
    L9:
        return this;
    L5:
        r3 = false;
        goto L6
    }

    MapMakerInternalMap.Strength getValueStrength() {
        return (MapMakerInternalMap.Strength) MoreObjects.firstNonNull(this.valueStrength, MapMakerInternalMap.Strength.STRONG);
    }

    @Override // com.google.common.collect.GenericMapMaker
    @Deprecated
    /* JADX INFO: renamed from: expireAfterWrite, reason: avoid collision after fix types in other method */
    GenericMapMaker<Object, Object> expireAfterWrite2(long r3, TimeUnit r5) {
        checkExpiration(r3, r5);
        this.expireAfterWriteNanos = r5.toNanos(r3);
        if (r3 == 0) goto L5;
    L7:
        this.useCustomMap = true;
        return this;
    L5:
        if (this.nullRemovalCause != null) goto L7;
        this.nullRemovalCause = RemovalCause.EXPIRED;
        goto L7
    }

    private void checkExpiration(long r9, TimeUnit r11) {
        long r0 = this.expireAfterWriteNanos;
        if (r0 != (-1)) goto L5;
        boolean r4 = true;
    L6:
        Preconditions.checkState(r4, "expireAfterWrite was already set to %s ns", new Object[]{Long.valueOf(r0)});
        long r1 = this.expireAfterAccessNanos;
        if (r1 != (-1)) goto L9;
        boolean r8 = true;
    L10:
        Preconditions.checkState(r8, "expireAfterAccess was already set to %s ns", new Object[]{Long.valueOf(r1)});
        if (r9 < 0) goto L13;
        boolean r10 = true;
    L14:
        Preconditions.checkArgument(r10, "duration cannot be negative: %s %s", new Object[]{Long.valueOf(r9), r11});
        return;
    L13:
        r10 = false;
        goto L14
    L9:
        r8 = false;
        goto L10
    L5:
        r4 = false;
        goto L6
    }

    long getExpireAfterWriteNanos() {
        long r0 = this.expireAfterWriteNanos;
        if (r0 != (-1)) goto L6;
        return 0;
    L6:
        return r0;
    }

    @Override // com.google.common.collect.GenericMapMaker
    @Deprecated
    /* JADX INFO: renamed from: expireAfterAccess, reason: avoid collision after fix types in other method */
    GenericMapMaker<Object, Object> expireAfterAccess2(long r3, TimeUnit r5) {
        checkExpiration(r3, r5);
        this.expireAfterAccessNanos = r5.toNanos(r3);
        if (r3 == 0) goto L5;
    L7:
        this.useCustomMap = true;
        return this;
    L5:
        if (this.nullRemovalCause != null) goto L7;
        this.nullRemovalCause = RemovalCause.EXPIRED;
        goto L7
    }

    long getExpireAfterAccessNanos() {
        long r0 = this.expireAfterAccessNanos;
        if (r0 != (-1)) goto L6;
        return 0;
    L6:
        return r0;
    }

    Ticker getTicker() {
        return (Ticker) MoreObjects.firstNonNull(this.ticker, Ticker.systemTicker());
    }

    @Deprecated
    <K, V> GenericMapMaker<K, V> removalListener(RemovalListener<K, V> r3) {
        if (this.removalListener != null) goto L5;
        boolean r0 = true;
    L6:
        Preconditions.checkState(r0);
        this.removalListener = (RemovalListener) Preconditions.checkNotNull(r3);
        this.useCustomMap = true;
        return this;
    L5:
        r0 = false;
        goto L6
    }

    @Override // com.google.common.collect.GenericMapMaker
    public <K, V> ConcurrentMap<K, V> makeMap() {
        if (this.useCustomMap == true) goto L7;
        return new ConcurrentHashMap(getInitialCapacity(), 0.75f, getConcurrencyLevel());
    L7:
        if (this.nullRemovalCause != null) goto L9;
        ConcurrentMap<K, V> r0 = new MapMakerInternalMap(this);
    L11:
        return r0;
    L9:
        r0 = new NullConcurrentMap(this);
        goto L11
    }

    @Override // com.google.common.collect.GenericMapMaker
    <K, V> MapMakerInternalMap<K, V> makeCustomMap() {
        return new MapMakerInternalMap(this);
    }

    @Override // com.google.common.collect.GenericMapMaker
    @Deprecated
    <K, V> ConcurrentMap<K, V> makeComputingMap(Function<? super K, ? extends V> r2) {
        if (this.nullRemovalCause != null) goto L5;
        ConcurrentMap<K, V> r0 = new ComputingMapAdapter(this, r2);
    L7:
        return r0;
    L5:
        r0 = new NullComputingConcurrentMap(this, r2);
        goto L7
    }

    public String toString() {
        MoreObjects.ToStringHelper r0 = MoreObjects.toStringHelper(this);
        int r1 = this.initialCapacity;
        if (r1 == (-1)) goto L5;
        r0.add("initialCapacity", r1);
    L5:
        int r2 = this.concurrencyLevel;
        if (r2 == (-1)) goto L8;
        r0.add("concurrencyLevel", r2);
    L8:
        int r3 = this.maximumSize;
        if (r3 == (-1)) goto L12;
        r0.add("maximumSize", r3);
    L12:
        if (this.expireAfterWriteNanos == (-1)) goto L15;
        r0.add("expireAfterWrite", this.expireAfterWriteNanos + "ns");
    L15:
        if (this.expireAfterAccessNanos == (-1)) goto L17;
        r0.add("expireAfterAccess", this.expireAfterAccessNanos + "ns");
    L17:
        MapMakerInternalMap.Strength r4 = this.keyStrength;
        if (r4 == null) goto L20;
        r0.add("keyStrength", Ascii.toLowerCase(r4.toString()));
    L20:
        MapMakerInternalMap.Strength r5 = this.valueStrength;
        if (r5 == null) goto L24;
        r0.add("valueStrength", Ascii.toLowerCase(r5.toString()));
    L24:
        if (this.keyEquivalence == null) goto L27;
        r0.addValue("keyEquivalence");
    L27:
        if (this.removalListener == null) goto L30;
        r0.addValue("removalListener");
    L30:
        return r0.toString();
    }
}
