package org.threeten.bp;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Locale;
import org.threeten.bp.format.DateTimeFormatterBuilder;
import org.threeten.bp.format.TextStyle;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.Temporal;
import org.threeten.bp.temporal.TemporalAccessor;
import org.threeten.bp.temporal.TemporalAdjuster;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.TemporalQueries;
import org.threeten.bp.temporal.TemporalQuery;
import org.threeten.bp.temporal.TemporalUnit;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;
import org.threeten.bp.temporal.ValueRange;

/* JADX INFO: loaded from: classes5.dex */
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

    private DayOfWeek(String r1, int r2) {
        super(r1, r2);
    }

    public static DayOfWeek valueOf(String r2) {
        return (DayOfWeek) ZeusTransformUtils.preCheckCast(Enum.valueOf(DayOfWeek.class, r2), DayOfWeek.class, "com.obric.aiagent.plugin");
    }

    public static DayOfWeek[] values() {
        return (DayOfWeek[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), DayOfWeek[].class, "com.obric.aiagent.plugin");
    }

    static {
        DayOfWeek r0 = new DayOfWeek("MONDAY", 0);
        MONDAY = r0;
        DayOfWeek r1 = new DayOfWeek("TUESDAY", 1);
        TUESDAY = r1;
        DayOfWeek r3 = new DayOfWeek("WEDNESDAY", 2);
        WEDNESDAY = r3;
        DayOfWeek r5 = new DayOfWeek("THURSDAY", 3);
        THURSDAY = r5;
        DayOfWeek r7 = new DayOfWeek("FRIDAY", 4);
        FRIDAY = r7;
        DayOfWeek r9 = new DayOfWeek("SATURDAY", 5);
        SATURDAY = r9;
        DayOfWeek r11 = new DayOfWeek("SUNDAY", 6);
        SUNDAY = r11;
        $VALUES = new DayOfWeek[]{r0, r1, r3, r5, r7, r9, r11};
        FROM = new AnonymousClass1();
        ENUMS = values();
    }

    public static DayOfWeek of(int r3) {
        if (r3 < 1) goto L9;
        if (r3 > 7) goto L9;
        return ENUMS[r3 - 1];
    L9:
        throw new DateTimeException("Invalid value for DayOfWeek: " + r3);
    }

    public static DayOfWeek from(TemporalAccessor r4) {
        TemporalAccessor r5 = (TemporalAccessor) ZeusTransformUtils.wrapperContextForParams(r4, TemporalAccessor.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r5, DayOfWeek.class) == true) goto L5;
        return of(r5.get(ChronoField.DAY_OF_WEEK));
    L8:
        e = move-exception;
        throw new DateTimeException("Unable to obtain DayOfWeek from TemporalAccessor: " + r5 + ", type " + r5.getClass().getName(), e);
    L5:
        return (DayOfWeek) ZeusTransformUtils.preCheckCast(r5, DayOfWeek.class, "com.obric.aiagent.plugin");
    }

    public int getValue() {
        return ordinal() + 1;
    }

    public String getDisplayName(TextStyle r3, Locale r4) {
        return new DateTimeFormatterBuilder().appendText(ChronoField.DAY_OF_WEEK, r3).toFormatter(r4).format(this);
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public boolean isSupported(TemporalField r4) {
        TemporalField r5 = (TemporalField) ZeusTransformUtils.wrapperContextForParams(r4, TemporalField.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r5, ChronoField.class) == true) goto L5;
        if (r5 == null) goto L14;
        if (r5.isSupportedBy(this) == false) goto L14;
        return true;
    L14:
        return false;
    L5:
        if (r5 != ChronoField.DAY_OF_WEEK) goto L8;
        return true;
    L8:
        return false;
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public ValueRange range(TemporalField r3) {
        TemporalField r4 = (TemporalField) ZeusTransformUtils.wrapperContextForParams(r3, TemporalField.class, "com.obric.aiagent.plugin");
        if (r4 != ChronoField.DAY_OF_WEEK) goto L7;
        return r4.range();
    L7:
        if (ZeusTransformUtils.instanceOf(r4, ChronoField.class) == true) goto L11;
        return r4.rangeRefinedBy(this);
    L11:
        throw new UnsupportedTemporalTypeException("Unsupported field: " + r4);
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public int get(TemporalField r4) {
        TemporalField r5 = (TemporalField) ZeusTransformUtils.wrapperContextForParams(r4, TemporalField.class, "com.obric.aiagent.plugin");
        if (r5 != ChronoField.DAY_OF_WEEK) goto L7;
        return getValue();
    L7:
        return range(r5).checkValidIntValue(getLong(r5), r5);
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public long getLong(TemporalField r3) {
        TemporalField r4 = (TemporalField) ZeusTransformUtils.wrapperContextForParams(r3, TemporalField.class, "com.obric.aiagent.plugin");
        if (r4 != ChronoField.DAY_OF_WEEK) goto L7;
        return getValue();
    L7:
        if (ZeusTransformUtils.instanceOf(r4, ChronoField.class) == true) goto L11;
        return r4.getFrom(this);
    L11:
        throw new UnsupportedTemporalTypeException("Unsupported field: " + r4);
    }

    public DayOfWeek plus(long r3) {
        return ENUMS[(ordinal() + (((int) (r3 % 7)) + 7)) % 7];
    }

    public DayOfWeek minus(long r3) {
        return plus(-(r3 % 7));
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public <R> R query(TemporalQuery<R> r3) {
        TemporalQuery<TemporalUnit> r4 = (TemporalQuery) ZeusTransformUtils.wrapperContextForParams(r3, TemporalQuery.class, "com.obric.aiagent.plugin");
        if (r4 != TemporalQueries.precision()) goto L7;
        return (R) ChronoUnit.DAYS;
    L7:
        if (r4 != TemporalQueries.localDate()) goto L9;
        return null;
    L9:
        if (r4 != TemporalQueries.localTime()) goto L11;
        return null;
    L11:
        if (r4 != TemporalQueries.chronology()) goto L13;
        return null;
    L13:
        if (r4 != TemporalQueries.zone()) goto L15;
        return null;
    L15:
        if (r4 != TemporalQueries.zoneId()) goto L17;
        return null;
    L17:
        if (r4 != TemporalQueries.offset()) goto L20;
        return null;
    L20:
        return (R) r4.queryFrom(this);
    }

    @Override // org.threeten.bp.temporal.TemporalAdjuster
    public Temporal adjustInto(Temporal r4) {
        return ((Temporal) ZeusTransformUtils.wrapperContextForParams(r4, Temporal.class, "com.obric.aiagent.plugin")).with(ChronoField.DAY_OF_WEEK, getValue());
    }
}
