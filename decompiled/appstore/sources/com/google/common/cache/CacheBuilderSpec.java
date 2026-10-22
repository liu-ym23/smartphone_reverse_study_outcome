package com.google.common.cache;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Splitter;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@GwtIncompatible
public final class CacheBuilderSpec {
    private static final Splitter KEYS_SPLITTER = null;
    private static final Splitter KEY_VALUE_SPLITTER = null;
    private static final ImmutableMap<String, ValueParser> VALUE_PARSERS = null;

    @VisibleForTesting
    long accessExpirationDuration;

    @VisibleForTesting
    @MonotonicNonNullDecl
    TimeUnit accessExpirationTimeUnit;

    @VisibleForTesting
    @MonotonicNonNullDecl
    Integer concurrencyLevel;

    @VisibleForTesting
    @MonotonicNonNullDecl
    Integer initialCapacity;

    @VisibleForTesting
    @MonotonicNonNullDecl
    LocalCache.Strength keyStrength;

    @VisibleForTesting
    @MonotonicNonNullDecl
    Long maximumSize;

    @VisibleForTesting
    @MonotonicNonNullDecl
    Long maximumWeight;

    @VisibleForTesting
    @MonotonicNonNullDecl
    Boolean recordStats;

    @VisibleForTesting
    long refreshDuration;

    @VisibleForTesting
    @MonotonicNonNullDecl
    TimeUnit refreshTimeUnit;
    private final String specification;

    @VisibleForTesting
    @MonotonicNonNullDecl
    LocalCache.Strength valueStrength;

    @VisibleForTesting
    long writeExpirationDuration;

    @VisibleForTesting
    @MonotonicNonNullDecl
    TimeUnit writeExpirationTimeUnit;

    /* JADX INFO: renamed from: com.google.common.cache.CacheBuilderSpec$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$common$cache$LocalCache$Strength = null;

        static {
            int[] r10 = new int[LocalCache.Strength.values().length];
            $SwitchMap$com$google$common$cache$LocalCache$Strength = r10;
            r10[LocalCache.Strength.WEAK.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            $SwitchMap$com$google$common$cache$LocalCache$Strength[LocalCache.Strength.SOFT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    public static class AccessDurationParser extends DurationParser {
        public AccessDurationParser() {
        }

        @Override // com.google.common.cache.CacheBuilderSpec.DurationParser
        public void parseDuration(CacheBuilderSpec r10, long r11, TimeUnit r12) {
            if (r10.accessExpirationTimeUnit != null) goto L5;
            boolean r13 = true;
        L6:
            Preconditions.checkArgument(r13, "expireAfterAccess already set");
            r10.accessExpirationDuration = r11;
            r10.accessExpirationTimeUnit = r12;
            return;
        L5:
            r13 = false;
            goto L6
        }
    }

    public static class ConcurrencyLevelParser extends IntegerParser {
        public ConcurrencyLevelParser() {
        }

        @Override // com.google.common.cache.CacheBuilderSpec.IntegerParser
        public void parseInteger(CacheBuilderSpec r10, int r11) {
            Integer r12 = r10.concurrencyLevel;
            if (r12 != null) goto L5;
            boolean r13 = true;
        L6:
            Preconditions.checkArgument(r13, "concurrency level was already set to ", r12);
            r10.concurrencyLevel = Integer.valueOf(r11);
            return;
        L5:
            r13 = false;
            goto L6
        }
    }

    public static abstract class DurationParser implements ValueParser {
        public DurationParser() {
        }

        @Override // com.google.common.cache.CacheBuilderSpec.ValueParser
        public void parse(CacheBuilderSpec r10, String r11, String r12) {
            if (r12 != null) goto L5;
        L7:
            boolean r13 = false;
        L8:
            Preconditions.checkArgument(r13, "value of key %s omitted", r11);
            char r14 = r12.charAt(r12.length() - 1);     // Catch: NumberFormatException -> L25
            if (r14 != 'd') goto L12;
            TimeUnit r15 = TimeUnit.DAYS;     // Catch: NumberFormatException -> L25
        L23:
            parseDuration(r10, Long.parseLong(r12.substring(0, r12.length() - 1)), r15);     // Catch: NumberFormatException -> L25
            return;
        L12:
            if (r14 != 'h') goto L14;
            r15 = TimeUnit.HOURS;     // Catch: NumberFormatException -> L25
            goto L23
        L14:
            if (r14 != 'm') goto L16;
            r15 = TimeUnit.MINUTES;     // Catch: NumberFormatException -> L25
            goto L23
        L16:
            if (r14 != 's') goto L19;
            r15 = TimeUnit.SECONDS;     // Catch: NumberFormatException -> L25
            goto L23
        L19:
            throw new IllegalArgumentException(CacheBuilderSpec.access$000("key %s invalid format.  was %s, must end with one of [dDhHmMsS]", new Object[]{r11, r12}));     // Catch: NumberFormatException -> L25
        L26:
            throw new IllegalArgumentException(CacheBuilderSpec.access$000("key %s value set to %s, must be integer", new Object[]{r11, r12}));
        L5:
            if (r12.isEmpty() == true) goto L7;
            r13 = true;
            goto L8
        }

        public abstract void parseDuration(CacheBuilderSpec r10, long r11, TimeUnit r12);
    }

    public static class InitialCapacityParser extends IntegerParser {
        public InitialCapacityParser() {
        }

        @Override // com.google.common.cache.CacheBuilderSpec.IntegerParser
        public void parseInteger(CacheBuilderSpec r10, int r11) {
            Integer r12 = r10.initialCapacity;
            if (r12 != null) goto L5;
            boolean r13 = true;
        L6:
            Preconditions.checkArgument(r13, "initial capacity was already set to ", r12);
            r10.initialCapacity = Integer.valueOf(r11);
            return;
        L5:
            r13 = false;
            goto L6
        }
    }

    public static abstract class IntegerParser implements ValueParser {
        public IntegerParser() {
        }

        @Override // com.google.common.cache.CacheBuilderSpec.ValueParser
        public void parse(CacheBuilderSpec r10, String r11, String r12) {
            if (r12 != null) goto L4;
        L6:
            boolean r13 = false;
        L7:
            Preconditions.checkArgument(r13, "value of key %s omitted", r11);
            parseInteger(r10, Integer.parseInt(r12));     // Catch: NumberFormatException -> L10
            return;
        L10:
            e = move-exception;
            throw new IllegalArgumentException(CacheBuilderSpec.access$000("key %s value set to %s, must be integer", new Object[]{r11, r12}), e);
        L4:
            if (r12.isEmpty() == true) goto L6;
            r13 = true;
            goto L7
        }

        public abstract void parseInteger(CacheBuilderSpec r10, int r11);
    }

    public static class KeyStrengthParser implements ValueParser {
        private final LocalCache.Strength strength;

        public KeyStrengthParser(LocalCache.Strength r10) {
            this.strength = r10;
        }

        @Override // com.google.common.cache.CacheBuilderSpec.ValueParser
        public void parse(CacheBuilderSpec r10, String r11, @NullableDecl String r12) {
            boolean r13 = false;
            if (r12 != null) goto L5;
            boolean r14 = true;
        L6:
            Preconditions.checkArgument(r14, "key %s does not take values", r11);
            LocalCache.Strength r15 = r10.keyStrength;
            if (r15 != null) goto L9;
            r13 = true;
        L9:
            Preconditions.checkArgument(r13, "%s was already set to %s", r11, r15);
            r10.keyStrength = this.strength;
            return;
        L5:
            r14 = false;
            goto L6
        }
    }

    public static abstract class LongParser implements ValueParser {
        public LongParser() {
        }

        @Override // com.google.common.cache.CacheBuilderSpec.ValueParser
        public void parse(CacheBuilderSpec r10, String r11, String r12) {
            if (r12 != null) goto L4;
        L6:
            boolean r13 = false;
        L7:
            Preconditions.checkArgument(r13, "value of key %s omitted", r11);
            parseLong(r10, Long.parseLong(r12));     // Catch: NumberFormatException -> L10
            return;
        L10:
            e = move-exception;
            throw new IllegalArgumentException(CacheBuilderSpec.access$000("key %s value set to %s, must be integer", new Object[]{r11, r12}), e);
        L4:
            if (r12.isEmpty() == true) goto L6;
            r13 = true;
            goto L7
        }

        public abstract void parseLong(CacheBuilderSpec r10, long r11);
    }

    public static class MaximumSizeParser extends LongParser {
        public MaximumSizeParser() {
        }

        @Override // com.google.common.cache.CacheBuilderSpec.LongParser
        public void parseLong(CacheBuilderSpec r10, long r11) {
            Long r12 = r10.maximumSize;
            boolean r13 = false;
            if (r12 != null) goto L5;
            boolean r14 = true;
        L6:
            Preconditions.checkArgument(r14, "maximum size was already set to ", r12);
            Long r15 = r10.maximumWeight;
            if (r15 != null) goto L9;
            r13 = true;
        L9:
            Preconditions.checkArgument(r13, "maximum weight was already set to ", r15);
            r10.maximumSize = Long.valueOf(r11);
            return;
        L5:
            r14 = false;
            goto L6
        }
    }

    public static class MaximumWeightParser extends LongParser {
        public MaximumWeightParser() {
        }

        @Override // com.google.common.cache.CacheBuilderSpec.LongParser
        public void parseLong(CacheBuilderSpec r10, long r11) {
            Long r12 = r10.maximumWeight;
            boolean r13 = false;
            if (r12 != null) goto L5;
            boolean r14 = true;
        L6:
            Preconditions.checkArgument(r14, "maximum weight was already set to ", r12);
            Long r15 = r10.maximumSize;
            if (r15 != null) goto L9;
            r13 = true;
        L9:
            Preconditions.checkArgument(r13, "maximum size was already set to ", r15);
            r10.maximumWeight = Long.valueOf(r11);
            return;
        L5:
            r14 = false;
            goto L6
        }
    }

    public static class RecordStatsParser implements ValueParser {
        public RecordStatsParser() {
        }

        @Override // com.google.common.cache.CacheBuilderSpec.ValueParser
        public void parse(CacheBuilderSpec r10, String r11, @NullableDecl String r12) {
            boolean r13 = false;
            if (r12 != null) goto L5;
            boolean r14 = true;
        L6:
            Preconditions.checkArgument(r14, "recordStats does not take values");
            if (r10.recordStats != null) goto L9;
            r13 = true;
        L9:
            Preconditions.checkArgument(r13, "recordStats already set");
            r10.recordStats = Boolean.TRUE;
            return;
        L5:
            r14 = false;
            goto L6
        }
    }

    public static class RefreshDurationParser extends DurationParser {
        public RefreshDurationParser() {
        }

        @Override // com.google.common.cache.CacheBuilderSpec.DurationParser
        public void parseDuration(CacheBuilderSpec r10, long r11, TimeUnit r12) {
            if (r10.refreshTimeUnit != null) goto L5;
            boolean r13 = true;
        L6:
            Preconditions.checkArgument(r13, "refreshAfterWrite already set");
            r10.refreshDuration = r11;
            r10.refreshTimeUnit = r12;
            return;
        L5:
            r13 = false;
            goto L6
        }
    }

    public interface ValueParser {
        void parse(CacheBuilderSpec r10, String r11, @NullableDecl String r12);
    }

    public static class ValueStrengthParser implements ValueParser {
        private final LocalCache.Strength strength;

        public ValueStrengthParser(LocalCache.Strength r10) {
            this.strength = r10;
        }

        @Override // com.google.common.cache.CacheBuilderSpec.ValueParser
        public void parse(CacheBuilderSpec r10, String r11, @NullableDecl String r12) {
            boolean r13 = false;
            if (r12 != null) goto L5;
            boolean r14 = true;
        L6:
            Preconditions.checkArgument(r14, "key %s does not take values", r11);
            LocalCache.Strength r15 = r10.valueStrength;
            if (r15 != null) goto L9;
            r13 = true;
        L9:
            Preconditions.checkArgument(r13, "%s was already set to %s", r11, r15);
            r10.valueStrength = this.strength;
            return;
        L5:
            r14 = false;
            goto L6
        }
    }

    public static class WriteDurationParser extends DurationParser {
        public WriteDurationParser() {
        }

        @Override // com.google.common.cache.CacheBuilderSpec.DurationParser
        public void parseDuration(CacheBuilderSpec r10, long r11, TimeUnit r12) {
            if (r10.writeExpirationTimeUnit != null) goto L5;
            boolean r13 = true;
        L6:
            Preconditions.checkArgument(r13, "expireAfterWrite already set");
            r10.writeExpirationDuration = r11;
            r10.writeExpirationTimeUnit = r12;
            return;
        L5:
            r13 = false;
            goto L6
        }
    }

    static {
        KEYS_SPLITTER = Splitter.on(',').trimResults();
        KEY_VALUE_SPLITTER = Splitter.on('=').trimResults();
        ImmutableMap.Builder r10 = ImmutableMap.builder().put("initialCapacity", new InitialCapacityParser()).put("maximumSize", new MaximumSizeParser()).put("maximumWeight", new MaximumWeightParser()).put("concurrencyLevel", new ConcurrencyLevelParser());
        LocalCache.Strength r11 = LocalCache.Strength.WEAK;
        VALUE_PARSERS = r10.put("weakKeys", new KeyStrengthParser(r11)).put("softValues", new ValueStrengthParser(LocalCache.Strength.SOFT)).put("weakValues", new ValueStrengthParser(r11)).put("recordStats", new RecordStatsParser()).put("expireAfterAccess", new AccessDurationParser()).put("expireAfterWrite", new WriteDurationParser()).put("refreshAfterWrite", new RefreshDurationParser()).put("refreshInterval", new RefreshDurationParser()).build();
    }

    private CacheBuilderSpec(String r10) {
        this.specification = r10;
    }

    public static /* synthetic */ String access$000(String r10, Object[] r11) {
        return format(r10, r11);
    }

    public static CacheBuilderSpec disableCaching() {
        return parse("maximumSize=0");
    }

    @NullableDecl
    private static Long durationInNanos(long r10, @NullableDecl TimeUnit r11) {
        if (r11 != null) goto L5;
        return null;
    L5:
        return Long.valueOf(r11.toNanos(r10));
    }

    private static String format(String r10, Object... r11) {
        return String.format(Locale.ROOT, r10, r11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static CacheBuilderSpec parse(String r10) {
        CacheBuilderSpec r11 = new CacheBuilderSpec(r10);
        if (r10.isEmpty() == true) goto L19;
        Iterator<String> r12 = KEYS_SPLITTER.split(r10).iterator();
    L6:
        if (r12.hasNext() == false) goto L19;
        String r13 = r12.next();
        ImmutableList r14 = ImmutableList.copyOf(KEY_VALUE_SPLITTER.split(r13));
        Preconditions.checkArgument(!r14.isEmpty(), "blank key-value pair");
        boolean r15 = false;
        if (r14.size() > 2) goto L10;
        boolean r16 = true;
    L11:
        Preconditions.checkArgument(r16, "key-value pair %s with more than one equals sign", r13);
        String r17 = (String) r14.get(0);
        ValueParser r18 = VALUE_PARSERS.get(r17);
        if (r18 == null) goto L14;
        r15 = true;
    L14:
        Preconditions.checkArgument(r15, "unknown key %s", r17);
        if (r14.size() != 1) goto L17;
        String r19 = null;
    L18:
        r18.parse(r11, r17, r19);
        goto L6
    L17:
        r19 = (String) r14.get(1);
        goto L18
    L10:
        r16 = false;
    L19:
        return r11;
    }

    public boolean equals(@NullableDecl Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof CacheBuilderSpec) == true) goto L8;
        return false;
    L8:
        CacheBuilderSpec r11 = (CacheBuilderSpec) r10;
        if (Objects.equal(this.initialCapacity, r11.initialCapacity) == false) goto L30;
        if (Objects.equal(this.maximumSize, r11.maximumSize) == false) goto L30;
        if (Objects.equal(this.maximumWeight, r11.maximumWeight) == false) goto L30;
        if (Objects.equal(this.concurrencyLevel, r11.concurrencyLevel) == false) goto L30;
        if (Objects.equal(this.keyStrength, r11.keyStrength) == false) goto L30;
        if (Objects.equal(this.valueStrength, r11.valueStrength) == false) goto L30;
        if (Objects.equal(this.recordStats, r11.recordStats) == false) goto L30;
        if (Objects.equal(durationInNanos(this.writeExpirationDuration, this.writeExpirationTimeUnit), durationInNanos(r11.writeExpirationDuration, r11.writeExpirationTimeUnit)) == false) goto L30;
        if (Objects.equal(durationInNanos(this.accessExpirationDuration, this.accessExpirationTimeUnit), durationInNanos(r11.accessExpirationDuration, r11.accessExpirationTimeUnit)) == false) goto L30;
        if (Objects.equal(durationInNanos(this.refreshDuration, this.refreshTimeUnit), durationInNanos(r11.refreshDuration, r11.refreshTimeUnit)) == false) goto L30;
        return true;
    L30:
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{this.initialCapacity, this.maximumSize, this.maximumWeight, this.concurrencyLevel, this.keyStrength, this.valueStrength, this.recordStats, durationInNanos(this.writeExpirationDuration, this.writeExpirationTimeUnit), durationInNanos(this.accessExpirationDuration, this.accessExpirationTimeUnit), durationInNanos(this.refreshDuration, this.refreshTimeUnit)});
    }

    public CacheBuilder<Object, Object> toCacheBuilder() {
        CacheBuilder<Object, Object> r10 = CacheBuilder.newBuilder();
        Integer r11 = this.initialCapacity;
        if (r11 == null) goto L5;
        r10.initialCapacity(r11.intValue());
    L5:
        Long r12 = this.maximumSize;
        if (r12 == null) goto L8;
        r10.maximumSize(r12.longValue());
    L8:
        Long r13 = this.maximumWeight;
        if (r13 == null) goto L11;
        r10.maximumWeight(r13.longValue());
    L11:
        Integer r14 = this.concurrencyLevel;
        if (r14 == null) goto L14;
        r10.concurrencyLevel(r14.intValue());
    L14:
        LocalCache.Strength r15 = this.keyStrength;
        if (r15 != null) goto L17;
    L21:
        LocalCache.Strength r16 = this.valueStrength;
        if (r16 == null) goto L31;
        int r17 = AnonymousClass1.$SwitchMap$com$google$common$cache$LocalCache$Strength[r16.ordinal()];
        if (r17 != 1) goto L26;
        r10.weakValues();
        goto L31
    L26:
        if (r17 != 2) goto L29;
        r10.softValues();
        goto L31
    L29:
        throw new AssertionError();
    L31:
        Boolean r18 = this.recordStats;
        if (r18 != null) goto L34;
    L36:
        TimeUnit r19 = this.writeExpirationTimeUnit;
        if (r19 == null) goto L39;
        r10.expireAfterWrite(this.writeExpirationDuration, r19);
    L39:
        TimeUnit r20 = this.accessExpirationTimeUnit;
        if (r20 == null) goto L42;
        r10.expireAfterAccess(this.accessExpirationDuration, r20);
    L42:
        TimeUnit r21 = this.refreshTimeUnit;
        if (r21 == null) goto L45;
        r10.refreshAfterWrite(this.refreshDuration, r21);
    L45:
        return r10;
    L34:
        if (r18.booleanValue() == false) goto L36;
        r10.recordStats();
        goto L36
    L17:
        if (AnonymousClass1.$SwitchMap$com$google$common$cache$LocalCache$Strength[r15.ordinal()] != 1) goto L20;
        r10.weakKeys();
        goto L21
    L20:
        throw new AssertionError();
    }

    public String toParsableString() {
        return this.specification;
    }

    public String toString() {
        return MoreObjects.toStringHelper(this).addValue(toParsableString()).toString();
    }
}
