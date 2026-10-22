package com.google.common.cache;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Splitter;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class CacheBuilderSpec {
    private static final Splitter KEYS_SPLITTER = null;
    private static final Splitter KEY_VALUE_SPLITTER = null;
    private static final ImmutableMap<String, ValueParser> VALUE_PARSERS = null;
    long accessExpirationDuration;
    TimeUnit accessExpirationTimeUnit;
    Integer concurrencyLevel;
    Integer initialCapacity;
    LocalCache.Strength keyStrength;
    Long maximumSize;
    Long maximumWeight;
    Boolean recordStats;
    long refreshDuration;
    TimeUnit refreshTimeUnit;
    private final String specification;
    LocalCache.Strength valueStrength;
    long writeExpirationDuration;
    TimeUnit writeExpirationTimeUnit;

    /* JADX INFO: renamed from: com.google.common.cache.CacheBuilderSpec$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$common$cache$LocalCache$Strength = null;

        static {
            int[] r0 = new int[LocalCache.Strength.values().length];
            $SwitchMap$com$google$common$cache$LocalCache$Strength = r0;
            r0[LocalCache.Strength.WEAK.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            $SwitchMap$com$google$common$cache$LocalCache$Strength[LocalCache.Strength.SOFT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    static class AccessDurationParser extends DurationParser {
        AccessDurationParser() {
        }

        @Override // com.google.common.cache.CacheBuilderSpec.DurationParser
        protected void parseDuration(CacheBuilderSpec r2, long r3, TimeUnit r5) {
            if (r2.accessExpirationTimeUnit != null) goto L5;
            boolean r1 = true;
        L6:
            Preconditions.checkArgument(r1, "expireAfterAccess already set");
            r2.accessExpirationDuration = r3;
            r2.accessExpirationTimeUnit = r5;
            return;
        L5:
            r1 = false;
            goto L6
        }
    }

    static class ConcurrencyLevelParser extends IntegerParser {
        ConcurrencyLevelParser() {
        }

        @Override // com.google.common.cache.CacheBuilderSpec.IntegerParser
        protected void parseInteger(CacheBuilderSpec r4, int r5) {
            if (r4.concurrencyLevel != null) goto L5;
            boolean r3 = true;
        L6:
            Preconditions.checkArgument(r3, "concurrency level was already set to ", new Object[]{r4.concurrencyLevel});
            r4.concurrencyLevel = Integer.valueOf(r5);
            return;
        L5:
            r3 = false;
            goto L6
        }
    }

    static abstract class DurationParser implements ValueParser {
        protected abstract void parseDuration(CacheBuilderSpec r1, long r2, TimeUnit r4);

        DurationParser() {
        }

        @Override // com.google.common.cache.CacheBuilderSpec.ValueParser
        public void parse(CacheBuilderSpec r7, String r8, String r9) {
            if (r9 != null) goto L5;
        L7:
            boolean r2 = false;
        L8:
            Preconditions.checkArgument(r2, "value of key %s omitted", new Object[]{r8});
            char r3 = r9.charAt(r9.length() - 1);     // Catch: NumberFormatException -> L25
            if (r3 != 'd') goto L12;
            TimeUnit r4 = TimeUnit.DAYS;     // Catch: NumberFormatException -> L25
        L23:
            parseDuration(r7, Long.parseLong(r9.substring(0, r9.length() - 1)), r4);     // Catch: NumberFormatException -> L25
            return;
        L12:
            if (r3 != 'h') goto L14;
            r4 = TimeUnit.HOURS;     // Catch: NumberFormatException -> L25
            goto L23
        L14:
            if (r3 != 'm') goto L16;
            r4 = TimeUnit.MINUTES;     // Catch: NumberFormatException -> L25
            goto L23
        L16:
            if (r3 != 's') goto L19;
            r4 = TimeUnit.SECONDS;     // Catch: NumberFormatException -> L25
            goto L23
        L19:
            throw new IllegalArgumentException(String.format("key %s invalid format.  was %s, must end with one of [dDhHmMsS]", new Object[]{r8, r9}));     // Catch: NumberFormatException -> L25
        L26:
            throw new IllegalArgumentException(String.format("key %s value set to %s, must be integer", new Object[]{r8, r9}));
        L5:
            if (r9.isEmpty() == true) goto L7;
            r2 = true;
            goto L8
        }
    }

    static class InitialCapacityParser extends IntegerParser {
        InitialCapacityParser() {
        }

        @Override // com.google.common.cache.CacheBuilderSpec.IntegerParser
        protected void parseInteger(CacheBuilderSpec r4, int r5) {
            if (r4.initialCapacity != null) goto L5;
            boolean r3 = true;
        L6:
            Preconditions.checkArgument(r3, "initial capacity was already set to ", new Object[]{r4.initialCapacity});
            r4.initialCapacity = Integer.valueOf(r5);
            return;
        L5:
            r3 = false;
            goto L6
        }
    }

    static abstract class IntegerParser implements ValueParser {
        protected abstract void parseInteger(CacheBuilderSpec r1, int r2);

        IntegerParser() {
        }

        @Override // com.google.common.cache.CacheBuilderSpec.ValueParser
        public void parse(CacheBuilderSpec r6, String r7, String r8) {
            if (r8 != null) goto L5;
        L7:
            boolean r2 = false;
        L8:
            Preconditions.checkArgument(r2, "value of key %s omitted", new Object[]{r7});
            parseInteger(r6, Integer.parseInt(r8));     // Catch: NumberFormatException -> L11
            return;
        L11:
            e = move-exception;
            throw new IllegalArgumentException(String.format("key %s value set to %s, must be integer", new Object[]{r7, r8}), e);
        L5:
            if (r8.isEmpty() == true) goto L7;
            r2 = true;
            goto L8
        }
    }

    static class KeyStrengthParser implements ValueParser {
        private final LocalCache.Strength strength;

        public KeyStrengthParser(LocalCache.Strength r1) {
            this.strength = r1;
        }

        @Override // com.google.common.cache.CacheBuilderSpec.ValueParser
        public void parse(CacheBuilderSpec r5, String r6, @Nullable String r7) {
            if (r7 != null) goto L5;
            boolean r8 = true;
        L6:
            Preconditions.checkArgument(r8, "key %s does not take values", new Object[]{r6});
            if (r5.keyStrength != null) goto L9;
            boolean r9 = true;
        L10:
            Preconditions.checkArgument(r9, "%s was already set to %s", new Object[]{r6, r5.keyStrength});
            r5.keyStrength = this.strength;
            return;
        L9:
            r9 = false;
            goto L10
        L5:
            r8 = false;
            goto L6
        }
    }

    static abstract class LongParser implements ValueParser {
        protected abstract void parseLong(CacheBuilderSpec r1, long r2);

        LongParser() {
        }

        @Override // com.google.common.cache.CacheBuilderSpec.ValueParser
        public void parse(CacheBuilderSpec r6, String r7, String r8) {
            if (r8 != null) goto L5;
        L7:
            boolean r2 = false;
        L8:
            Preconditions.checkArgument(r2, "value of key %s omitted", new Object[]{r7});
            parseLong(r6, Long.parseLong(r8));     // Catch: NumberFormatException -> L11
            return;
        L11:
            e = move-exception;
            throw new IllegalArgumentException(String.format("key %s value set to %s, must be integer", new Object[]{r7, r8}), e);
        L5:
            if (r8.isEmpty() == true) goto L7;
            r2 = true;
            goto L8
        }
    }

    static class MaximumSizeParser extends LongParser {
        MaximumSizeParser() {
        }

        @Override // com.google.common.cache.CacheBuilderSpec.LongParser
        protected void parseLong(CacheBuilderSpec r5, long r6) {
            if (r5.maximumSize != null) goto L5;
            boolean r4 = true;
        L6:
            Preconditions.checkArgument(r4, "maximum size was already set to ", new Object[]{r5.maximumSize});
            if (r5.maximumWeight != null) goto L9;
            boolean r7 = true;
        L10:
            Preconditions.checkArgument(r7, "maximum weight was already set to ", new Object[]{r5.maximumWeight});
            r5.maximumSize = Long.valueOf(r6);
            return;
        L9:
            r7 = false;
            goto L10
        L5:
            r4 = false;
            goto L6
        }
    }

    static class MaximumWeightParser extends LongParser {
        MaximumWeightParser() {
        }

        @Override // com.google.common.cache.CacheBuilderSpec.LongParser
        protected void parseLong(CacheBuilderSpec r5, long r6) {
            if (r5.maximumWeight != null) goto L5;
            boolean r4 = true;
        L6:
            Preconditions.checkArgument(r4, "maximum weight was already set to ", new Object[]{r5.maximumWeight});
            if (r5.maximumSize != null) goto L9;
            boolean r7 = true;
        L10:
            Preconditions.checkArgument(r7, "maximum size was already set to ", new Object[]{r5.maximumSize});
            r5.maximumWeight = Long.valueOf(r6);
            return;
        L9:
            r7 = false;
            goto L10
        L5:
            r4 = false;
            goto L6
        }
    }

    static class RecordStatsParser implements ValueParser {
        RecordStatsParser() {
        }

        @Override // com.google.common.cache.CacheBuilderSpec.ValueParser
        public void parse(CacheBuilderSpec r2, String r3, @Nullable String r4) {
            boolean r1 = false;
            if (r4 != null) goto L5;
            boolean r5 = true;
        L6:
            Preconditions.checkArgument(r5, "recordStats does not take values");
            if (r2.recordStats != null) goto L9;
            r1 = true;
        L9:
            Preconditions.checkArgument(r1, "recordStats already set");
            r2.recordStats = true;
            return;
        L5:
            r5 = false;
            goto L6
        }
    }

    static class RefreshDurationParser extends DurationParser {
        RefreshDurationParser() {
        }

        @Override // com.google.common.cache.CacheBuilderSpec.DurationParser
        protected void parseDuration(CacheBuilderSpec r2, long r3, TimeUnit r5) {
            if (r2.refreshTimeUnit != null) goto L5;
            boolean r1 = true;
        L6:
            Preconditions.checkArgument(r1, "refreshAfterWrite already set");
            r2.refreshDuration = r3;
            r2.refreshTimeUnit = r5;
            return;
        L5:
            r1 = false;
            goto L6
        }
    }

    private interface ValueParser {
        void parse(CacheBuilderSpec r1, String r2, @Nullable String r3);
    }

    static class ValueStrengthParser implements ValueParser {
        private final LocalCache.Strength strength;

        public ValueStrengthParser(LocalCache.Strength r1) {
            this.strength = r1;
        }

        @Override // com.google.common.cache.CacheBuilderSpec.ValueParser
        public void parse(CacheBuilderSpec r5, String r6, @Nullable String r7) {
            if (r7 != null) goto L5;
            boolean r8 = true;
        L6:
            Preconditions.checkArgument(r8, "key %s does not take values", new Object[]{r6});
            if (r5.valueStrength != null) goto L9;
            boolean r9 = true;
        L10:
            Preconditions.checkArgument(r9, "%s was already set to %s", new Object[]{r6, r5.valueStrength});
            r5.valueStrength = this.strength;
            return;
        L9:
            r9 = false;
            goto L10
        L5:
            r8 = false;
            goto L6
        }
    }

    static class WriteDurationParser extends DurationParser {
        WriteDurationParser() {
        }

        @Override // com.google.common.cache.CacheBuilderSpec.DurationParser
        protected void parseDuration(CacheBuilderSpec r2, long r3, TimeUnit r5) {
            if (r2.writeExpirationTimeUnit != null) goto L5;
            boolean r1 = true;
        L6:
            Preconditions.checkArgument(r1, "expireAfterWrite already set");
            r2.writeExpirationDuration = r3;
            r2.writeExpirationTimeUnit = r5;
            return;
        L5:
            r1 = false;
            goto L6
        }
    }

    static {
        KEYS_SPLITTER = Splitter.on(',').trimResults();
        KEY_VALUE_SPLITTER = Splitter.on('=').trimResults();
        VALUE_PARSERS = ImmutableMap.builder().put("initialCapacity", new InitialCapacityParser()).put("maximumSize", new MaximumSizeParser()).put("maximumWeight", new MaximumWeightParser()).put("concurrencyLevel", new ConcurrencyLevelParser()).put("weakKeys", new KeyStrengthParser(LocalCache.Strength.WEAK)).put("softValues", new ValueStrengthParser(LocalCache.Strength.SOFT)).put("weakValues", new ValueStrengthParser(LocalCache.Strength.WEAK)).put("recordStats", new RecordStatsParser()).put("expireAfterAccess", new AccessDurationParser()).put("expireAfterWrite", new WriteDurationParser()).put("refreshAfterWrite", new RefreshDurationParser()).put("refreshInterval", new RefreshDurationParser()).build();
    }

    private CacheBuilderSpec(String r1) {
        this.specification = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static CacheBuilderSpec parse(String r8) {
        CacheBuilderSpec r0 = new CacheBuilderSpec(r8);
        if (r8.isEmpty() == true) goto L20;
        Iterator<String> r9 = KEYS_SPLITTER.split(r8).iterator();
    L6:
        if (r9.hasNext() == false) goto L20;
        String r1 = r9.next();
        ImmutableList r2 = ImmutableList.copyOf(KEY_VALUE_SPLITTER.split(r1));
        Preconditions.checkArgument(!r2.isEmpty(), "blank key-value pair");
        if (r2.size() > 2) goto L10;
        boolean r3 = true;
    L11:
        Preconditions.checkArgument(r3, "key-value pair %s with more than one equals sign", new Object[]{r1});
        String r4 = (String) r2.get(0);
        ValueParser r5 = VALUE_PARSERS.get(r4);
        if (r5 == null) goto L14;
        boolean r6 = true;
    L15:
        Preconditions.checkArgument(r6, "unknown key %s", new Object[]{r4});
        if (r2.size() != 1) goto L18;
        String r7 = null;
    L19:
        r5.parse(r0, r4, r7);
        goto L6
    L18:
        r7 = (String) r2.get(1);
        goto L19
    L14:
        r6 = false;
        goto L15
    L10:
        r3 = false;
    L20:
        return r0;
    }

    public static CacheBuilderSpec disableCaching() {
        return parse("maximumSize=0");
    }

    CacheBuilder<Object, Object> toCacheBuilder() {
        CacheBuilder<Object, Object> r0 = CacheBuilder.newBuilder();
        Integer r1 = this.initialCapacity;
        if (r1 == null) goto L5;
        r0.initialCapacity(r1.intValue());
    L5:
        Long r2 = this.maximumSize;
        if (r2 == null) goto L8;
        r0.maximumSize(r2.longValue());
    L8:
        Long r3 = this.maximumWeight;
        if (r3 == null) goto L11;
        r0.maximumWeight(r3.longValue());
    L11:
        Integer r4 = this.concurrencyLevel;
        if (r4 == null) goto L15;
        r0.concurrencyLevel(r4.intValue());
    L15:
        if (this.keyStrength == null) goto L22;
        if (AnonymousClass1.$SwitchMap$com$google$common$cache$LocalCache$Strength[this.keyStrength.ordinal()] != 1) goto L20;
        r0.weakKeys();
        goto L22
    L20:
        throw new AssertionError();
    L22:
        if (this.valueStrength == null) goto L31;
        int r5 = AnonymousClass1.$SwitchMap$com$google$common$cache$LocalCache$Strength[this.valueStrength.ordinal()];
        if (r5 != 1) goto L26;
        r0.weakValues();
        goto L31
    L26:
        if (r5 != 2) goto L29;
        r0.softValues();
        goto L31
    L29:
        throw new AssertionError();
    L31:
        Boolean r6 = this.recordStats;
        if (r6 != null) goto L34;
    L36:
        TimeUnit r7 = this.writeExpirationTimeUnit;
        if (r7 == null) goto L39;
        r0.expireAfterWrite(this.writeExpirationDuration, r7);
    L39:
        TimeUnit r8 = this.accessExpirationTimeUnit;
        if (r8 == null) goto L42;
        r0.expireAfterAccess(this.accessExpirationDuration, r8);
    L42:
        TimeUnit r9 = this.refreshTimeUnit;
        if (r9 == null) goto L45;
        r0.refreshAfterWrite(this.refreshDuration, r9);
    L45:
        return r0;
    L34:
        if (r6.booleanValue() == false) goto L36;
        r0.recordStats();
        goto L36
    }

    public String toParsableString() {
        return this.specification;
    }

    public String toString() {
        return MoreObjects.toStringHelper(this).addValue(toParsableString()).toString();
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{this.initialCapacity, this.maximumSize, this.maximumWeight, this.concurrencyLevel, this.keyStrength, this.valueStrength, this.recordStats, durationInNanos(this.writeExpirationDuration, this.writeExpirationTimeUnit), durationInNanos(this.accessExpirationDuration, this.accessExpirationTimeUnit), durationInNanos(this.refreshDuration, this.refreshTimeUnit)});
    }

    public boolean equals(@Nullable Object r7) {
        if (this != r7) goto L6;
        return true;
    L6:
        if ((r7 instanceof CacheBuilderSpec) == true) goto L8;
        return false;
    L8:
        CacheBuilderSpec r8 = (CacheBuilderSpec) r7;
        if (Objects.equal(this.initialCapacity, r8.initialCapacity) == false) goto L30;
        if (Objects.equal(this.maximumSize, r8.maximumSize) == false) goto L30;
        if (Objects.equal(this.maximumWeight, r8.maximumWeight) == false) goto L30;
        if (Objects.equal(this.concurrencyLevel, r8.concurrencyLevel) == false) goto L30;
        if (Objects.equal(this.keyStrength, r8.keyStrength) == false) goto L30;
        if (Objects.equal(this.valueStrength, r8.valueStrength) == false) goto L30;
        if (Objects.equal(this.recordStats, r8.recordStats) == false) goto L30;
        if (Objects.equal(durationInNanos(this.writeExpirationDuration, this.writeExpirationTimeUnit), durationInNanos(r8.writeExpirationDuration, r8.writeExpirationTimeUnit)) == false) goto L30;
        if (Objects.equal(durationInNanos(this.accessExpirationDuration, this.accessExpirationTimeUnit), durationInNanos(r8.accessExpirationDuration, r8.accessExpirationTimeUnit)) == false) goto L30;
        if (Objects.equal(durationInNanos(this.refreshDuration, this.refreshTimeUnit), durationInNanos(r8.refreshDuration, r8.refreshTimeUnit)) == false) goto L30;
        return true;
    L30:
        return false;
    }

    @Nullable
    private static Long durationInNanos(long r0, @Nullable TimeUnit r2) {
        if (r2 != null) goto L5;
        return null;
    L5:
        return Long.valueOf(r2.toNanos(r0));
    }
}
