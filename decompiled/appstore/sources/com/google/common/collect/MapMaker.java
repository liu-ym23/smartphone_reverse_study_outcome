package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Ascii;
import com.google.common.base.Equivalence;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible(emulated = true)
public final class MapMaker {
    private static final int DEFAULT_CONCURRENCY_LEVEL = 4;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;
    static final int UNSET_INT = -1;
    int concurrencyLevel;
    int initialCapacity;

    @MonotonicNonNullDecl
    Equivalence<Object> keyEquivalence;

    @MonotonicNonNullDecl
    MapMakerInternalMap.Strength keyStrength;
    boolean useCustomMap;

    @MonotonicNonNullDecl
    MapMakerInternalMap.Strength valueStrength;

    public static final enum Dummy extends Enum<Dummy> {
        private static final /* synthetic */ Dummy[] $VALUES = null;
        public static final Dummy VALUE = null;

        static {
            Dummy r10 = new Dummy("VALUE", 0);
            VALUE = r10;
            $VALUES = new Dummy[]{r10};
        }

        private Dummy(String r10, int r11) {
            super(r10, r11);
        }

        public static Dummy valueOf(String r10) {
            return (Dummy) Enum.valueOf(Dummy.class, r10);
        }

        public static Dummy[] values() {
            return (Dummy[]) $VALUES.clone();
        }
    }

    public MapMaker() {
        this.initialCapacity = -1;
        this.concurrencyLevel = -1;
    }

    @CanIgnoreReturnValue
    public MapMaker concurrencyLevel(int r10) {
        int r11 = this.concurrencyLevel;
        boolean r12 = false;
        if (r11 != (-1)) goto L5;
        boolean r13 = true;
    L6:
        Preconditions.checkState(r13, "concurrency level was already set to %s", r11);
        if (r10 <= 0) goto L9;
        r12 = true;
    L9:
        Preconditions.checkArgument(r12);
        this.concurrencyLevel = r10;
        return this;
    L5:
        r13 = false;
        goto L6
    }

    public int getConcurrencyLevel() {
        int r10 = this.concurrencyLevel;
        if (r10 != (-1)) goto L6;
        return 4;
    L6:
        return r10;
    }

    public int getInitialCapacity() {
        int r10 = this.initialCapacity;
        if (r10 != (-1)) goto L6;
        return 16;
    L6:
        return r10;
    }

    public Equivalence<Object> getKeyEquivalence() {
        return (Equivalence) MoreObjects.firstNonNull(this.keyEquivalence, getKeyStrength().defaultEquivalence());
    }

    public MapMakerInternalMap.Strength getKeyStrength() {
        return (MapMakerInternalMap.Strength) MoreObjects.firstNonNull(this.keyStrength, MapMakerInternalMap.Strength.STRONG);
    }

    public MapMakerInternalMap.Strength getValueStrength() {
        return (MapMakerInternalMap.Strength) MoreObjects.firstNonNull(this.valueStrength, MapMakerInternalMap.Strength.STRONG);
    }

    @CanIgnoreReturnValue
    public MapMaker initialCapacity(int r10) {
        int r11 = this.initialCapacity;
        boolean r12 = false;
        if (r11 != (-1)) goto L5;
        boolean r13 = true;
    L6:
        Preconditions.checkState(r13, "initial capacity was already set to %s", r11);
        if (r10 < 0) goto L9;
        r12 = true;
    L9:
        Preconditions.checkArgument(r12);
        this.initialCapacity = r10;
        return this;
    L5:
        r13 = false;
        goto L6
    }

    @CanIgnoreReturnValue
    @GwtIncompatible
    public MapMaker keyEquivalence(Equivalence<Object> r10) {
        Equivalence<Object> r11 = this.keyEquivalence;
        if (r11 != null) goto L5;
        boolean r12 = true;
    L6:
        Preconditions.checkState(r12, "key equivalence was already set to %s", r11);
        this.keyEquivalence = (Equivalence) Preconditions.checkNotNull(r10);
        this.useCustomMap = true;
        return this;
    L5:
        r12 = false;
        goto L6
    }

    public <K, V> ConcurrentMap<K, V> makeMap() {
        if (this.useCustomMap == true) goto L7;
        return new ConcurrentHashMap(getInitialCapacity(), 0.75f, getConcurrencyLevel());
    L7:
        return MapMakerInternalMap.create(this);
    }

    public MapMaker setKeyStrength(MapMakerInternalMap.Strength r10) {
        MapMakerInternalMap.Strength r11 = this.keyStrength;
        if (r11 != null) goto L5;
        boolean r12 = true;
    L6:
        Preconditions.checkState(r12, "Key strength was already set to %s", r11);
        this.keyStrength = (MapMakerInternalMap.Strength) Preconditions.checkNotNull(r10);
        if (r10 == MapMakerInternalMap.Strength.STRONG) goto L9;
        this.useCustomMap = true;
    L9:
        return this;
    L5:
        r12 = false;
        goto L6
    }

    public MapMaker setValueStrength(MapMakerInternalMap.Strength r10) {
        MapMakerInternalMap.Strength r11 = this.valueStrength;
        if (r11 != null) goto L5;
        boolean r12 = true;
    L6:
        Preconditions.checkState(r12, "Value strength was already set to %s", r11);
        this.valueStrength = (MapMakerInternalMap.Strength) Preconditions.checkNotNull(r10);
        if (r10 == MapMakerInternalMap.Strength.STRONG) goto L9;
        this.useCustomMap = true;
    L9:
        return this;
    L5:
        r12 = false;
        goto L6
    }

    public String toString() {
        MoreObjects.ToStringHelper r10 = MoreObjects.toStringHelper(this);
        int r11 = this.initialCapacity;
        if (r11 == (-1)) goto L5;
        r10.add("initialCapacity", r11);
    L5:
        int r12 = this.concurrencyLevel;
        if (r12 == (-1)) goto L8;
        r10.add("concurrencyLevel", r12);
    L8:
        MapMakerInternalMap.Strength r13 = this.keyStrength;
        if (r13 == null) goto L11;
        r10.add("keyStrength", Ascii.toLowerCase(r13.toString()));
    L11:
        MapMakerInternalMap.Strength r14 = this.valueStrength;
        if (r14 == null) goto L15;
        r10.add("valueStrength", Ascii.toLowerCase(r14.toString()));
    L15:
        if (this.keyEquivalence == null) goto L18;
        r10.addValue("keyEquivalence");
    L18:
        return r10.toString();
    }

    @CanIgnoreReturnValue
    @GwtIncompatible
    public MapMaker weakKeys() {
        return setKeyStrength(MapMakerInternalMap.Strength.WEAK);
    }

    @CanIgnoreReturnValue
    @GwtIncompatible
    public MapMaker weakValues() {
        return setValueStrength(MapMakerInternalMap.Strength.WEAK);
    }
}
