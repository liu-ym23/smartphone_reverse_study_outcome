package org.threeten.bp.temporal;

import ig.d;
import java.util.Locale;
import java.util.Map;
import org.threeten.bp.DateTimeException;
import org.threeten.bp.chrono.e;
import org.threeten.bp.format.ResolverStyle;

/* JADX INFO: loaded from: classes4.dex */
final enum JulianFields$Field extends Enum<JulianFields$Field> implements TemporalField {
    private static final /* synthetic */ JulianFields$Field[] $VALUES = null;
    public static final JulianFields$Field JULIAN_DAY = null;
    public static final JulianFields$Field MODIFIED_JULIAN_DAY = null;
    public static final JulianFields$Field RATA_DIE = null;
    private final TemporalUnit baseUnit;
    private final String name;
    private final long offset;
    private final ValueRange range;
    private final TemporalUnit rangeUnit;

    static {
        ChronoUnit r10 = ChronoUnit.DAYS;
        ChronoUnit r11 = ChronoUnit.FOREVER;
        JulianFields$Field r12 = new JulianFields$Field("JULIAN_DAY", 0, "JulianDay", r10, r11, 2440588);
        JULIAN_DAY = r12;
        JulianFields$Field r13 = new JulianFields$Field("MODIFIED_JULIAN_DAY", 1, "ModifiedJulianDay", r10, r11, 40587);
        MODIFIED_JULIAN_DAY = r13;
        JulianFields$Field r14 = new JulianFields$Field("RATA_DIE", 2, "RataDie", r10, r11, 719163);
        RATA_DIE = r14;
        $VALUES = new JulianFields$Field[]{r12, r13, r14};
    }

    private JulianFields$Field(String r10, int r11, String r12, TemporalUnit r13, TemporalUnit r14, long r15) {
        super(r10, r11);
        this.name = r12;
        this.baseUnit = r13;
        this.rangeUnit = r14;
        this.range = ValueRange.of((-365243219162L) + r15, 365241780471L + r15);
        this.offset = r15;
    }

    public static JulianFields$Field valueOf(String r10) {
        return (JulianFields$Field) Enum.valueOf(JulianFields$Field.class, r10);
    }

    public static JulianFields$Field[] values() {
        return (JulianFields$Field[]) $VALUES.clone();
    }

    @Override // org.threeten.bp.temporal.TemporalField
    public <R extends Temporal> R adjustInto(R r10, long r11) {
        if (range().isValidValue(r11) == false) goto L7;
        return (R) r10.with(ChronoField.EPOCH_DAY, d.o(r11, this.offset));
    L7:
        throw new DateTimeException("Invalid value: " + this.name + " " + r11);
    }

    @Override // org.threeten.bp.temporal.TemporalField
    public TemporalUnit getBaseUnit() {
        return this.baseUnit;
    }

    @Override // org.threeten.bp.temporal.TemporalField
    public String getDisplayName(Locale r10) {
        d.h(r10, "locale");
        return toString();
    }

    @Override // org.threeten.bp.temporal.TemporalField
    public long getFrom(TemporalAccessor r10) {
        return r10.getLong(ChronoField.EPOCH_DAY) + this.offset;
    }

    @Override // org.threeten.bp.temporal.TemporalField
    public TemporalUnit getRangeUnit() {
        return this.rangeUnit;
    }

    @Override // org.threeten.bp.temporal.TemporalField
    public boolean isDateBased() {
        return true;
    }

    @Override // org.threeten.bp.temporal.TemporalField
    public boolean isSupportedBy(TemporalAccessor r10) {
        return r10.isSupported(ChronoField.EPOCH_DAY);
    }

    @Override // org.threeten.bp.temporal.TemporalField
    public boolean isTimeBased() {
        return false;
    }

    @Override // org.threeten.bp.temporal.TemporalField
    public ValueRange range() {
        return this.range;
    }

    @Override // org.threeten.bp.temporal.TemporalField
    public ValueRange rangeRefinedBy(TemporalAccessor r10) {
        if (isSupportedBy(r10) == false) goto L7;
        return range();
    L7:
        throw new UnsupportedTemporalTypeException("Unsupported field: " + this);
    }

    @Override // org.threeten.bp.temporal.TemporalField
    public TemporalAccessor resolve(Map<TemporalField, Long> r10, TemporalAccessor r11, ResolverStyle r12) {
        long r13 = r10.remove(this).longValue();
        return e.from(r11).dateEpochDay(d.o(r13, this.offset));
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.name;
    }
}
