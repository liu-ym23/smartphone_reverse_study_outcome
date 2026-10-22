package org.threeten.bp.temporal;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Locale;
import java.util.Map;
import org.threeten.bp.DateTimeException;
import org.threeten.bp.chrono.Chronology;
import org.threeten.bp.format.ResolverStyle;
import org.threeten.bp.jdk8.Jdk8Methods;

/* JADX INFO: loaded from: classes5.dex */
public final class JulianFields {
    public static final TemporalField JULIAN_DAY = null;
    public static final TemporalField MODIFIED_JULIAN_DAY = null;
    public static final TemporalField RATA_DIE = null;

    private static final enum Field extends Enum<Field> implements TemporalField {
        private static final /* synthetic */ Field[] $VALUES = null;
        public static final Field JULIAN_DAY = null;
        public static final Field MODIFIED_JULIAN_DAY = null;
        public static final Field RATA_DIE = null;
        private final TemporalUnit baseUnit;
        private final String name;
        private final long offset;
        private final ValueRange range;
        private final TemporalUnit rangeUnit;

        @Override // org.threeten.bp.temporal.TemporalField
        public boolean isDateBased() {
            return true;
        }

        @Override // org.threeten.bp.temporal.TemporalField
        public boolean isTimeBased() {
            return false;
        }

        public static Field valueOf(String r2) {
            return (Field) ZeusTransformUtils.preCheckCast(Enum.valueOf(Field.class, r2), Field.class, "com.obric.aiagent.plugin");
        }

        public static Field[] values() {
            return (Field[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Field[].class, "com.obric.aiagent.plugin");
        }

        static {
            Field r8 = new Field("JULIAN_DAY", 0, "JulianDay", ChronoUnit.DAYS, ChronoUnit.FOREVER, 2440588);
            JULIAN_DAY = r8;
            Field r0 = new Field("MODIFIED_JULIAN_DAY", 1, "ModifiedJulianDay", ChronoUnit.DAYS, ChronoUnit.FOREVER, 40587);
            MODIFIED_JULIAN_DAY = r0;
            Field r1 = new Field("RATA_DIE", 2, "RataDie", ChronoUnit.DAYS, ChronoUnit.FOREVER, 719163);
            RATA_DIE = r1;
            $VALUES = new Field[]{r8, r0, r1};
        }

        private Field(String r3, int r4, String r5, TemporalUnit r6, TemporalUnit r7, long r8) {
            TemporalUnit r9 = (TemporalUnit) ZeusTransformUtils.wrapperContextForParams(r6, TemporalUnit.class, "com.obric.aiagent.plugin");
            TemporalUnit r10 = (TemporalUnit) ZeusTransformUtils.wrapperContextForParams(r7, TemporalUnit.class, "com.obric.aiagent.plugin");
            super(r3, r4);
            this.name = r5;
            this.baseUnit = r9;
            this.rangeUnit = r10;
            this.range = ValueRange.of((-365243219162L) + r8, 365241780471L + r8);
            this.offset = r8;
        }

        @Override // org.threeten.bp.temporal.TemporalField
        public TemporalUnit getBaseUnit() {
            return this.baseUnit;
        }

        @Override // org.threeten.bp.temporal.TemporalField
        public TemporalUnit getRangeUnit() {
            return this.rangeUnit;
        }

        @Override // org.threeten.bp.temporal.TemporalField
        public ValueRange range() {
            return this.range;
        }

        @Override // org.threeten.bp.temporal.TemporalField
        public boolean isSupportedBy(TemporalAccessor r2) {
            return ((TemporalAccessor) ZeusTransformUtils.wrapperContextForParams(r2, TemporalAccessor.class, "com.obric.aiagent.plugin")).isSupported(ChronoField.EPOCH_DAY);
        }

        @Override // org.threeten.bp.temporal.TemporalField
        public ValueRange rangeRefinedBy(TemporalAccessor r3) {
            if (isSupportedBy((TemporalAccessor) ZeusTransformUtils.wrapperContextForParams(r3, TemporalAccessor.class, "com.obric.aiagent.plugin")) == false) goto L7;
            return range();
        L7:
            throw new UnsupportedTemporalTypeException("Unsupported field: " + this);
        }

        @Override // org.threeten.bp.temporal.TemporalField
        public long getFrom(TemporalAccessor r3) {
            return ((TemporalAccessor) ZeusTransformUtils.wrapperContextForParams(r3, TemporalAccessor.class, "com.obric.aiagent.plugin")).getLong(ChronoField.EPOCH_DAY) + this.offset;
        }

        @Override // org.threeten.bp.temporal.TemporalField
        public <R extends Temporal> R adjustInto(R r4, long r5) {
            Temporal r6 = (Temporal) ZeusTransformUtils.wrapperContextForParams(r4, Temporal.class, "com.obric.aiagent.plugin");
            if (range().isValidValue(r5) == false) goto L7;
            return (R) r6.with(ChronoField.EPOCH_DAY, Jdk8Methods.safeSubtract(r5, this.offset));
        L7:
            throw new DateTimeException("Invalid value: " + this.name + " " + r5);
        }

        @Override // org.threeten.bp.temporal.TemporalField
        public String getDisplayName(Locale r2) {
            Jdk8Methods.requireNonNull(r2, "locale");
            return toString();
        }

        @Override // org.threeten.bp.temporal.TemporalField
        public TemporalAccessor resolve(Map<TemporalField, Long> r3, TemporalAccessor r4, ResolverStyle r5) {
            Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
            TemporalAccessor r7 = (TemporalAccessor) ZeusTransformUtils.wrapperContextForParams(r4, TemporalAccessor.class, "com.obric.aiagent.plugin");
            long r0 = ((Long) ZeusTransformUtils.preCheckCast(r6.remove(this), Long.class, "com.obric.aiagent.plugin")).longValue();
            return Chronology.from(r7).dateEpochDay(Jdk8Methods.safeSubtract(r0, this.offset));
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.name;
        }
    }

    public JulianFields() {
    }

    static {
        JULIAN_DAY = Field.JULIAN_DAY;
        MODIFIED_JULIAN_DAY = Field.MODIFIED_JULIAN_DAY;
        RATA_DIE = Field.RATA_DIE;
    }
}
