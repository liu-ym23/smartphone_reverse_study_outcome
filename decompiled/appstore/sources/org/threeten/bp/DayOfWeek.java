package org.threeten.bp;

import java.util.Locale;
import org.threeten.bp.format.DateTimeFormatterBuilder;
import org.threeten.bp.format.TextStyle;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.Temporal;
import org.threeten.bp.temporal.TemporalAccessor;
import org.threeten.bp.temporal.TemporalAdjuster;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.TemporalQuery;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;
import org.threeten.bp.temporal.ValueRange;
import org.threeten.bp.temporal.b;

/* JADX INFO: loaded from: classes4.dex */
public final enum DayOfWeek extends Enum<DayOfWeek> implements TemporalAccessor, TemporalAdjuster {
    private static final /* synthetic */ DayOfWeek[] $VALUES = null;
    private static final DayOfWeek[] ENUMS = null;
    public static final DayOfWeek FRIDAY = null;
    public static final TemporalQuery<DayOfWeek> FROM = null;
    public static final DayOfWeek MONDAY = null;
    public static final DayOfWeek SATURDAY = null;
    public static final DayOfWeek SUNDAY = null;
    public static final DayOfWeek THURSDAY = null;
    public static final DayOfWeek TUESDAY = null;
    public static final DayOfWeek WEDNESDAY = null;

    static {
        DayOfWeek r10 = new DayOfWeek("MONDAY", 0);
        MONDAY = r10;
        DayOfWeek r11 = new DayOfWeek("TUESDAY", 1);
        TUESDAY = r11;
        DayOfWeek r12 = new DayOfWeek("WEDNESDAY", 2);
        WEDNESDAY = r12;
        DayOfWeek r13 = new DayOfWeek("THURSDAY", 3);
        THURSDAY = r13;
        DayOfWeek r14 = new DayOfWeek("FRIDAY", 4);
        FRIDAY = r14;
        DayOfWeek r15 = new DayOfWeek("SATURDAY", 5);
        SATURDAY = r15;
        DayOfWeek r16 = new DayOfWeek("SUNDAY", 6);
        SUNDAY = r16;
        $VALUES = new DayOfWeek[]{r10, r11, r12, r13, r14, r15, r16};
        FROM = new a();
        ENUMS = values();
    }

    private DayOfWeek(String r10, int r11) {
        super(r10, r11);
    }

    public static DayOfWeek from(TemporalAccessor r10) {
        if ((r10 instanceof DayOfWeek) == true) goto L5;
        return of(r10.get(ChronoField.DAY_OF_WEEK));
    L8:
        e = move-exception;
        throw new DateTimeException("Unable to obtain DayOfWeek from TemporalAccessor: " + r10 + ", type " + r10.getClass().getName(), e);
    L5:
        return (DayOfWeek) r10;
    }

    public static DayOfWeek of(int r10) {
        if (r10 < 1) goto L9;
        if (r10 > 7) goto L9;
        return ENUMS[r10 - 1];
    L9:
        throw new DateTimeException("Invalid value for DayOfWeek: " + r10);
    }

    public static DayOfWeek valueOf(String r10) {
        return (DayOfWeek) Enum.valueOf(DayOfWeek.class, r10);
    }

    public static DayOfWeek[] values() {
        return (DayOfWeek[]) $VALUES.clone();
    }

    @Override // org.threeten.bp.temporal.TemporalAdjuster
    public Temporal adjustInto(Temporal r10) {
        return r10.with(ChronoField.DAY_OF_WEEK, getValue());
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public int get(TemporalField r10) {
        if (r10 != ChronoField.DAY_OF_WEEK) goto L7;
        return getValue();
    L7:
        return range(r10).checkValidIntValue(getLong(r10), r10);
    }

    public String getDisplayName(TextStyle r10, Locale r11) {
        return new DateTimeFormatterBuilder().m(ChronoField.DAY_OF_WEEK, r10).F(r11).d(this);
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public long getLong(TemporalField r10) {
        if (r10 != ChronoField.DAY_OF_WEEK) goto L7;
        return getValue();
    L7:
        if ((r10 instanceof ChronoField) == true) goto L11;
        return r10.getFrom(this);
    L11:
        throw new UnsupportedTemporalTypeException("Unsupported field: " + r10);
    }

    public int getValue() {
        return ordinal() + 1;
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public boolean isSupported(TemporalField r10) {
        if ((r10 instanceof ChronoField) == true) goto L5;
        if (r10 != null) goto L10;
        return false;
    L10:
        if (r10.isSupportedBy(this) == true) goto L12;
        return false;
    L12:
        return true;
    L5:
        if (r10 == ChronoField.DAY_OF_WEEK) goto L7;
        return false;
    L7:
        return true;
    }

    public DayOfWeek minus(long r10) {
        return plus(-(r10 % 7));
    }

    public DayOfWeek plus(long r10) {
        return ENUMS[(ordinal() + (((int) (r10 % 7)) + 7)) % 7];
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public <R> R query(TemporalQuery<R> r10) {
        if (r10 != b.e()) goto L7;
        return (R) ChronoUnit.DAYS;
    L7:
        if (r10 != b.b()) goto L9;
        return null;
    L9:
        if (r10 != b.c()) goto L11;
        return null;
    L11:
        if (r10 != b.a()) goto L13;
        return null;
    L13:
        if (r10 != b.f()) goto L15;
        return null;
    L15:
        if (r10 != b.g()) goto L17;
        return null;
    L17:
        if (r10 != b.d()) goto L20;
        return null;
    L20:
        return r10.queryFrom(this);
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public ValueRange range(TemporalField r10) {
        if (r10 != ChronoField.DAY_OF_WEEK) goto L7;
        return r10.range();
    L7:
        if ((r10 instanceof ChronoField) == true) goto L11;
        return r10.rangeRefinedBy(this);
    L11:
        throw new UnsupportedTemporalTypeException("Unsupported field: " + r10);
    }
}
