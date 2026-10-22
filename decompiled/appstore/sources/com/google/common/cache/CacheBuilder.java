package com.google.common.cache;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Ascii;
import com.google.common.base.Equivalence;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import com.google.common.base.Ticker;
import com.google.errorprone.annotations.CheckReturnValue;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible(emulated = true)
public final class CacheBuilder<K, V> {
    static final Supplier<AbstractCache.StatsCounter> CACHE_STATS_COUNTER = null;
    private static final int DEFAULT_CONCURRENCY_LEVEL = 4;
    private static final int DEFAULT_EXPIRATION_NANOS = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;
    private static final int DEFAULT_REFRESH_NANOS = 0;
    static final CacheStats EMPTY_STATS = null;
    static final Supplier<? extends AbstractCache.StatsCounter> NULL_STATS_COUNTER = null;
    static final Ticker NULL_TICKER = null;
    static final int UNSET_INT = -1;
    private static final Logger logger = null;
    int concurrencyLevel;
    long expireAfterAccessNanos;
    long expireAfterWriteNanos;
    int initialCapacity;

    @MonotonicNonNullDecl
    Equivalence<Object> keyEquivalence;

    @MonotonicNonNullDecl
    LocalCache.Strength keyStrength;
    long maximumSize;
    long maximumWeight;
    long refreshNanos;

    @MonotonicNonNullDecl
    RemovalListener<? super K, ? super V> removalListener;
    Supplier<? extends AbstractCache.StatsCounter> statsCounterSupplier;
    boolean strictParsing;

    @MonotonicNonNullDecl
    Ticker ticker;

    @MonotonicNonNullDecl
    Equivalence<Object> valueEquivalence;

    @MonotonicNonNullDecl
    LocalCache.Strength valueStrength;

    @MonotonicNonNullDecl
    Weigher<? super K, ? super V> weigher;

    public static final enum NullListener extends Enum<NullListener> implements RemovalListener<Object, Object> {
        private static final /* synthetic */ NullListener[] $VALUES = null;
        public static final NullListener INSTANCE = null;

        static {
            NullListener r10 = new NullListener("INSTANCE", 0);
            INSTANCE = r10;
            $VALUES = new NullListener[]{r10};
        }

        private NullListener(String r10, int r11) {
            super(r10, r11);
        }

        public static NullListener valueOf(String r10) {
            return (NullListener) Enum.valueOf(NullListener.class, r10);
        }

        public static NullListener[] values() {
            return (NullListener[]) $VALUES.clone();
        }

        @Override // com.google.common.cache.RemovalListener
        public void onRemoval(RemovalNotification<Object, Object> r10) {
        }
    }

    public static final enum OneWeigher extends Enum<OneWeigher> implements Weigher<Object, Object> {
        private static final /* synthetic */ OneWeigher[] $VALUES = null;
        public static final OneWeigher INSTANCE = null;

        static {
            OneWeigher r10 = new OneWeigher("INSTANCE", 0);
            INSTANCE = r10;
            $VALUES = new OneWeigher[]{r10};
        }

        private OneWeigher(String r10, int r11) {
            super(r10, r11);
        }

        public static OneWeigher valueOf(String r10) {
            return (OneWeigher) Enum.valueOf(OneWeigher.class, r10);
        }

        public static OneWeigher[] values() {
            return (OneWeigher[]) $VALUES.clone();
        }

        @Override // com.google.common.cache.Weigher
        public int weigh(Object r10, Object r11) {
            return 1;
        }
    }

    static {
        NULL_STATS_COUNTER = Suppliers.ofInstance(new AnonymousClass1());
        EMPTY_STATS = new CacheStats(0, 0, 0, 0, 0, 0);
        CACHE_STATS_COUNTER = new AnonymousClass2();
        NULL_TICKER = new AnonymousClass3();
        logger = Logger.getLogger(CacheBuilder.class.getName());
    }

    private CacheBuilder() {
        this.strictParsing = true;
        this.initialCapacity = -1;
        this.concurrencyLevel = -1;
        this.maximumSize = -1;
        this.maximumWeight = -1;
        this.expireAfterWriteNanos = -1;
        this.expireAfterAccessNanos = -1;
        this.refreshNanos = -1;
        this.statsCounterSupplier = NULL_STATS_COUNTER;
    }

    private void checkNonLoadingCache() {
        if (this.refreshNanos != (-1)) goto L5;
        boolean r10 = true;
    L6:
        Preconditions.checkState(r10, "refreshAfterWrite requires a LoadingCache");
        return;
    L5:
        r10 = false;
        goto L6
    }

    private void checkWeightWithWeigher() {
        boolean r10 = false;
        if (this.weigher != null) goto L9;
        if (this.maximumWeight != (-1)) goto L7;
        r10 = true;
    L7:
        Preconditions.checkState(r10, "maximumWeight requires weigher");
        return;
    L9:
        if (this.strictParsing == false) goto L15;
        if (this.maximumWeight == (-1)) goto L13;
        r10 = true;
    L13:
        Preconditions.checkState(r10, "weigher requires maximumWeight");
        return;
    L15:
        if (this.maximumWeight != (-1)) goto L20;
        logger.log(Level.WARNING, "ignoring weigher specified without maximumWeight");
        return;
    }

    @GwtIncompatible
    public static CacheBuilder<Object, Object> from(CacheBuilderSpec r10) {
        return r10.toCacheBuilder().lenientParsing();
    }

    public static CacheBuilder<Object, Object> newBuilder() {
        return new CacheBuilder();
    }

    public <K1 extends K, V1 extends V> LoadingCache<K1, V1> build(CacheLoader<? super K1, V1> r10) {
        checkWeightWithWeigher();
        return new LocalCache.LocalLoadingCache(this, r10);
    }

    public CacheBuilder<K, V> concurrencyLevel(int r10) {
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

    public CacheBuilder<K, V> expireAfterAccess(long r10, TimeUnit r11) {
        long r12 = this.expireAfterAccessNanos;
        boolean r13 = false;
        if (r12 != (-1)) goto L5;
        boolean r14 = true;
    L6:
        Preconditions.checkState(r14, "expireAfterAccess was already set to %s ns", r12);
        if (r10 < 0) goto L9;
        r13 = true;
    L9:
        Preconditions.checkArgument(r13, "duration cannot be negative: %s %s", r10, r11);
        this.expireAfterAccessNanos = r11.toNanos(r10);
        return this;
    L5:
        r14 = false;
        goto L6
    }

    public CacheBuilder<K, V> expireAfterWrite(long r10, TimeUnit r11) {
        long r12 = this.expireAfterWriteNanos;
        boolean r13 = false;
        if (r12 != (-1)) goto L5;
        boolean r14 = true;
    L6:
        Preconditions.checkState(r14, "expireAfterWrite was already set to %s ns", r12);
        if (r10 < 0) goto L9;
        r13 = true;
    L9:
        Preconditions.checkArgument(r13, "duration cannot be negative: %s %s", r10, r11);
        this.expireAfterWriteNanos = r11.toNanos(r10);
        return this;
    L5:
        r14 = false;
        goto L6
    }

    public int getConcurrencyLevel() {
        int r10 = this.concurrencyLevel;
        if (r10 != (-1)) goto L6;
        return 4;
    L6:
        return r10;
    }

    public long getExpireAfterAccessNanos() {
        long r10 = this.expireAfterAccessNanos;
        if (r10 != (-1)) goto L6;
        return 0;
    L6:
        return r10;
    }

    public long getExpireAfterWriteNanos() {
        long r10 = this.expireAfterWriteNanos;
        if (r10 != (-1)) goto L6;
        return 0;
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

    public LocalCache.Strength getKeyStrength() {
        return (LocalCache.Strength) MoreObjects.firstNonNull(this.keyStrength, LocalCache.Strength.STRONG);
    }

    public long getMaximumWeight() {
        if (this.expireAfterWriteNanos != 0) goto L5;
    L12:
        return 0;
    L5:
        if (this.expireAfterAccessNanos == 0) goto L12;
        if (this.weigher != null) goto L11;
        return this.maximumSize;
    L11:
        return this.maximumWeight;
    }

    public long getRefreshNanos() {
        long r10 = this.refreshNanos;
        if (r10 != (-1)) goto L6;
        return 0;
    L6:
        return r10;
    }

    public <K1 extends K, V1 extends V> RemovalListener<K1, V1> getRemovalListener() {
        return (RemovalListener) MoreObjects.firstNonNull(this.removalListener, NullListener.INSTANCE);
    }

    public Supplier<? extends AbstractCache.StatsCounter> getStatsCounterSupplier() {
        return this.statsCounterSupplier;
    }

    public Ticker getTicker(boolean r10) {
        Ticker r11 = this.ticker;
        if (r11 == null) goto L5;
        return r11;
    L5:
        if (r10 == false) goto L8;
        return Ticker.systemTicker();
    L8:
        return NULL_TICKER;
    }

    public Equivalence<Object> getValueEquivalence() {
        return (Equivalence) MoreObjects.firstNonNull(this.valueEquivalence, getValueStrength().defaultEquivalence());
    }

    public LocalCache.Strength getValueStrength() {
        return (LocalCache.Strength) MoreObjects.firstNonNull(this.valueStrength, LocalCache.Strength.STRONG);
    }

    public <K1 extends K, V1 extends V> Weigher<K1, V1> getWeigher() {
        return (Weigher) MoreObjects.firstNonNull(this.weigher, OneWeigher.INSTANCE);
    }

    public CacheBuilder<K, V> initialCapacity(int r10) {
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

    public boolean isRecordingStats() {
        if (this.statsCounterSupplier != CACHE_STATS_COUNTER) goto L5;
        return true;
    L5:
        return false;
    }

    @GwtIncompatible
    public CacheBuilder<K, V> keyEquivalence(Equivalence<Object> r10) {
        Equivalence<Object> r11 = this.keyEquivalence;
        if (r11 != null) goto L5;
        boolean r12 = true;
    L6:
        Preconditions.checkState(r12, "key equivalence was already set to %s", r11);
        this.keyEquivalence = (Equivalence) Preconditions.checkNotNull(r10);
        return this;
    L5:
        r12 = false;
        goto L6
    }

    @GwtIncompatible
    public CacheBuilder<K, V> lenientParsing() {
        this.strictParsing = false;
        return this;
    }

    public CacheBuilder<K, V> maximumSize(long r10) {
        long r11 = this.maximumSize;
        boolean r12 = false;
        if (r11 != (-1)) goto L5;
        boolean r13 = true;
    L6:
        Preconditions.checkState(r13, "maximum size was already set to %s", r11);
        long r14 = this.maximumWeight;
        if (r14 != (-1)) goto L9;
        boolean r15 = true;
    L10:
        Preconditions.checkState(r15, "maximum weight was already set to %s", r14);
        if (this.weigher != null) goto L13;
        boolean r16 = true;
    L14:
        Preconditions.checkState(r16, "maximum size can not be combined with weigher");
        if (r10 < 0) goto L17;
        r12 = true;
    L17:
        Preconditions.checkArgument(r12, "maximum size must not be negative");
        this.maximumSize = r10;
        return this;
    L13:
        r16 = false;
        goto L14
    L9:
        r15 = false;
        goto L10
    L5:
        r13 = false;
        goto L6
    }

    @GwtIncompatible
    public CacheBuilder<K, V> maximumWeight(long r10) {
        long r11 = this.maximumWeight;
        boolean r12 = false;
        if (r11 != (-1)) goto L5;
        boolean r13 = true;
    L6:
        Preconditions.checkState(r13, "maximum weight was already set to %s", r11);
        long r14 = this.maximumSize;
        if (r14 != (-1)) goto L9;
        boolean r15 = true;
    L10:
        Preconditions.checkState(r15, "maximum size was already set to %s", r14);
        this.maximumWeight = r10;
        if (r10 < 0) goto L13;
        r12 = true;
    L13:
        Preconditions.checkArgument(r12, "maximum weight must not be negative");
        return this;
    L9:
        r15 = false;
        goto L10
    L5:
        r13 = false;
        goto L6
    }

    public CacheBuilder<K, V> recordStats() {
        this.statsCounterSupplier = CACHE_STATS_COUNTER;
        return this;
    }

    @GwtIncompatible
    public CacheBuilder<K, V> refreshAfterWrite(long r10, TimeUnit r11) {
        Preconditions.checkNotNull(r11);
        long r12 = this.refreshNanos;
        boolean r13 = false;
        if (r12 != (-1)) goto L5;
        boolean r14 = true;
    L6:
        Preconditions.checkState(r14, "refresh was already set to %s ns", r12);
        if (r10 <= 0) goto L9;
        r13 = true;
    L9:
        Preconditions.checkArgument(r13, "duration must be positive: %s %s", r10, r11);
        this.refreshNanos = r11.toNanos(r10);
        return this;
    L5:
        r14 = false;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    @CheckReturnValue
    public <K1 extends K, V1 extends V> CacheBuilder<K1, V1> removalListener(RemovalListener<? super K1, ? super V1> r10) {
        if (this.removalListener != null) goto L5;
        boolean r11 = true;
    L6:
        Preconditions.checkState(r11);
        this.removalListener = (RemovalListener) Preconditions.checkNotNull(r10);
        return this;
    L5:
        r11 = false;
        goto L6
    }

    public CacheBuilder<K, V> setKeyStrength(LocalCache.Strength r10) {
        LocalCache.Strength r11 = this.keyStrength;
        if (r11 != null) goto L5;
        boolean r12 = true;
    L6:
        Preconditions.checkState(r12, "Key strength was already set to %s", r11);
        this.keyStrength = (LocalCache.Strength) Preconditions.checkNotNull(r10);
        return this;
    L5:
        r12 = false;
        goto L6
    }

    public CacheBuilder<K, V> setValueStrength(LocalCache.Strength r10) {
        LocalCache.Strength r11 = this.valueStrength;
        if (r11 != null) goto L5;
        boolean r12 = true;
    L6:
        Preconditions.checkState(r12, "Value strength was already set to %s", r11);
        this.valueStrength = (LocalCache.Strength) Preconditions.checkNotNull(r10);
        return this;
    L5:
        r12 = false;
        goto L6
    }

    @GwtIncompatible
    public CacheBuilder<K, V> softValues() {
        return setValueStrength(LocalCache.Strength.SOFT);
    }

    public CacheBuilder<K, V> ticker(Ticker r10) {
        if (this.ticker != null) goto L5;
        boolean r11 = true;
    L6:
        Preconditions.checkState(r11);
        this.ticker = (Ticker) Preconditions.checkNotNull(r10);
        return this;
    L5:
        r11 = false;
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
        long r13 = this.maximumSize;
        if (r13 == (-1)) goto L11;
        r10.add("maximumSize", r13);
    L11:
        long r14 = this.maximumWeight;
        if (r14 == (-1)) goto L15;
        r10.add("maximumWeight", r14);
    L15:
        if (this.expireAfterWriteNanos == (-1)) goto L18;
        r10.add("expireAfterWrite", this.expireAfterWriteNanos + "ns");
    L18:
        if (this.expireAfterAccessNanos == (-1)) goto L20;
        r10.add("expireAfterAccess", this.expireAfterAccessNanos + "ns");
    L20:
        LocalCache.Strength r15 = this.keyStrength;
        if (r15 == null) goto L23;
        r10.add("keyStrength", Ascii.toLowerCase(r15.toString()));
    L23:
        LocalCache.Strength r16 = this.valueStrength;
        if (r16 == null) goto L27;
        r10.add("valueStrength", Ascii.toLowerCase(r16.toString()));
    L27:
        if (this.keyEquivalence == null) goto L30;
        r10.addValue("keyEquivalence");
    L30:
        if (this.valueEquivalence == null) goto L33;
        r10.addValue("valueEquivalence");
    L33:
        if (this.removalListener == null) goto L36;
        r10.addValue("removalListener");
    L36:
        return r10.toString();
    }

    @GwtIncompatible
    public CacheBuilder<K, V> valueEquivalence(Equivalence<Object> r10) {
        Equivalence<Object> r11 = this.valueEquivalence;
        if (r11 != null) goto L5;
        boolean r12 = true;
    L6:
        Preconditions.checkState(r12, "value equivalence was already set to %s", r11);
        this.valueEquivalence = (Equivalence) Preconditions.checkNotNull(r10);
        return this;
    L5:
        r12 = false;
        goto L6
    }

    @GwtIncompatible
    public CacheBuilder<K, V> weakKeys() {
        return setKeyStrength(LocalCache.Strength.WEAK);
    }

    @GwtIncompatible
    public CacheBuilder<K, V> weakValues() {
        return setValueStrength(LocalCache.Strength.WEAK);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @GwtIncompatible
    public <K1 extends K, V1 extends V> CacheBuilder<K1, V1> weigher(Weigher<? super K1, ? super V1> r10) {
        boolean r11 = false;
        if (this.weigher != null) goto L5;
        boolean r12 = true;
    L6:
        Preconditions.checkState(r12);
        if (this.strictParsing == false) goto L12;
        long r13 = this.maximumSize;
        if (r13 != (-1)) goto L11;
        r11 = true;
    L11:
        Preconditions.checkState(r11, "weigher can not be combined with maximum size", r13);
    L12:
        this.weigher = (Weigher) Preconditions.checkNotNull(r10);
        return this;
    L5:
        r12 = false;
        goto L6
    }

    @GwtIncompatible
    public static CacheBuilder<Object, Object> from(String r10) {
        return from(CacheBuilderSpec.parse(r10));
    }

    public <K1 extends K, V1 extends V> Cache<K1, V1> build() {
        checkWeightWithWeigher();
        checkNonLoadingCache();
        return new LocalCache.LocalManualCache(this);
    }
}
