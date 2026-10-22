package org.threeten.bp;

import java.util.Locale;
import org.threeten.bp.chrono.IsoChronology;
import org.threeten.bp.chrono.e;
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

/* JADX INFO: loaded from: classes4.dex */
public final enum Month extends Enum<Month> implements TemporalAccessor, TemporalAdjuster {
    private static final /* synthetic */ Month[] $VALUES = null;
    public static final Month APRIL = null;
    public static final Month AUGUST = null;
    public static final Month DECEMBER = null;
    private static final Month[] ENUMS = null;
    public static final Month FEBRUARY = null;
    public static final TemporalQuery<Month> FROM = null;
    public static final Month JANUARY = null;
    public static final Month JULY = null;
    public static final Month JUNE = null;
    public static final Month MARCH = null;
    public static final Month MAY = null;
    public static final Month NOVEMBER = null;
    public static final Month OCTOBER = null;
    public static final Month SEPTEMBER = null;

    public static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f23074a = null;

        static {
            int[] r10 = new int[Month.values().length];
            f23074a = r10;
            r10[Month.FEBRUARY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L16
        L30:
            f23074a[Month.APRIL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L17
        L36:
            f23074a[Month.JUNE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L18
        L50:
            f23074a[Month.SEPTEMBER.ordinal()] = 4;     // Catch: NoSuchFieldError -> L19
        L32:
            f23074a[Month.NOVEMBER.ordinal()] = 5;     // Catch: NoSuchFieldError -> L20
        L38:
            f23074a[Month.JANUARY.ordinal()] = 6;     // Catch: NoSuchFieldError -> L21
        L42:
            f23074a[Month.MARCH.ordinal()] = 7;     // Catch: NoSuchFieldError -> L22
        L46:
            f23074a[Month.MAY.ordinal()] = 8;     // Catch: NoSuchFieldError -> L23
        L28:
            f23074a[Month.JULY.ordinal()] = 9;     // Catch: NoSuchFieldError -> L24
        L34:
            f23074a[Month.AUGUST.ordinal()] = 10;     // Catch: NoSuchFieldError -> L25
        L40:
            f23074a[Month.OCTOBER.ordinal()] = 11;     // Catch: NoSuchFieldError -> L26
        L44:
            f23074a[Month.DECEMBER.ordinal()] = 12;     // Catch: NoSuchFieldError -> L27
            return;
        }
    }

    static {
        Month r10 = new Month("JANUARY", 0);
        JANUARY = r10;
        Month r11 = new Month("FEBRUARY", 1);
        FEBRUARY = r11;
        Month r12 = new Month("MARCH", 2);
        MARCH = r12;
        Month r13 = new Month("APRIL", 3);
        APRIL = r13;
        Month r14 = new Month("MAY", 4);
        MAY = r14;
        Month r15 = new Month("JUNE", 5);
        JUNE = r15;
        Month r16 = new Month("JULY", 6);
        JULY = r16;
        Month r17 = new Month("AUGUST", 7);
        AUGUST = r17;
        Month r18 = new Month("SEPTEMBER", 8);
        SEPTEMBER = r18;
        Month r19 = new Month("OCTOBER", 9);
        OCTOBER = r19;
        Month r110 = new Month("NOVEMBER", 10);
        NOVEMBER = r110;
        Month r111 = new Month("DECEMBER", 11);
        DECEMBER = r111;
        $VALUES = new Month[]{r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110, r111};
        FROM = new a();
        ENUMS = values();
    }

    private Month(String r10, int r11) {
        super(r10, r11);
    }

    public static Month from(TemporalAccessor r10) {
        if ((r10 instanceof Month) == true) goto L5;
    L9:
        e = move-exception;
        throw new DateTimeException("Unable to obtain Month from TemporalAccessor: " + r10 + ", type " + r10.getClass().getName(), e);
    L7:
        if (IsoChronology.INSTANCE.equals(e.from(r10)) == true) goto L11;
        r10 = LocalDate.from(r10);     // Catch: DateTimeException -> L9
    L11:
        return of(r10.get(ChronoField.MONTH_OF_YEAR));
    L5:
        return (Month) r10;
    }

    public static Month of(int r10) {
        if (r10 < 1) goto L9;
        if (r10 > 12) goto L9;
        return ENUMS[r10 - 1];
    L9:
        throw new DateTimeException("Invalid value for MonthOfYear: " + r10);
    }

    public static Month valueOf(String r10) {
        return (Month) Enum.valueOf(Month.class, r10);
    }

    public static Month[] values() {
        return (Month[]) $VALUES.clone();
    }

    @Override // org.threeten.bp.temporal.TemporalAdjuster
    public Temporal adjustInto(Temporal r10) {
        if (e.from(r10).equals(IsoChronology.INSTANCE) == false) goto L7;
        return r10.with(ChronoField.MONTH_OF_YEAR, getValue());
    L7:
        throw new DateTimeException("Adjustment only supported on ISO date-time");
    }

    public int firstDayOfYear(boolean r10) {
        switch(b.f23074a[ordinal()]) {
            case 1: goto L26;
            case 2: goto L25;
            case 3: goto L23;
            case 4: goto L21;
            case 5: goto L19;
            case 6: goto L16;
            case 7: goto L15;
            case 8: goto L13;
            case 9: goto L11;
            case 10: goto L9;
            case 11: goto L7;
            default: goto L5;
        };
    L16:
        return 1;
    L26:
        return 32;
    L5:
        return (r10 ? 1 : 0) + 335;
    L7:
        return (r10 ? 1 : 0) + 274;
    L9:
        return (r10 ? 1 : 0) + 213;
    L11:
        return (r10 ? 1 : 0) + 182;
    L13:
        return (r10 ? 1 : 0) + 121;
    L15:
        return (r10 ? 1 : 0) + 60;
    L19:
        return (r10 ? 1 : 0) + 305;
    L21:
        return (r10 ? 1 : 0) + 244;
    L23:
        return (r10 ? 1 : 0) + 152;
    L25:
        return (r10 ? 1 : 0) + 91;
    }

    public Month firstMonthOfQuarter() {
        return ENUMS[(ordinal() / 3) * 3];
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public int get(TemporalField r10) {
        if (r10 != ChronoField.MONTH_OF_YEAR) goto L7;
        return getValue();
    L7:
        return range(r10).checkValidIntValue(getLong(r10), r10);
    }

    public String getDisplayName(TextStyle r10, Locale r11) {
        return new DateTimeFormatterBuilder().m(ChronoField.MONTH_OF_YEAR, r10).F(r11).d(this);
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public long getLong(TemporalField r10) {
        if (r10 != ChronoField.MONTH_OF_YEAR) goto L7;
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
        if (r10 == ChronoField.MONTH_OF_YEAR) goto L7;
        return false;
    L7:
        return true;
    }

    public int length(boolean r10) {
        int r11 = b.f23074a[ordinal()];
        if (r11 != 1) goto L5;
        if (r10 == false) goto L18;
        return 29;
    L18:
        return 28;
    L5:
        if (r11 != 2) goto L7;
        return 30;
    L7:
        if (r11 != 3) goto L9;
        return 30;
    L9:
        if (r11 != 4) goto L11;
        return 30;
    L11:
        if (r11 == 5) goto L23;
        return 31;
    L23:
        return 30;
    }

    public int maxLength() {
        int r10 = b.f23074a[ordinal()];
        if (r10 != 1) goto L5;
        return 29;
    L5:
        if (r10 != 2) goto L7;
        return 30;
    L7:
        if (r10 != 3) goto L9;
        return 30;
    L9:
        if (r10 != 4) goto L11;
        return 30;
    L11:
        if (r10 == 5) goto L20;
        return 31;
    L20:
        return 30;
    }

    public int minLength() {
        int r10 = b.f23074a[ordinal()];
        if (r10 != 1) goto L5;
        return 28;
    L5:
        if (r10 != 2) goto L7;
        return 30;
    L7:
        if (r10 != 3) goto L9;
        return 30;
    L9:
        if (r10 != 4) goto L11;
        return 30;
    L11:
        if (r10 == 5) goto L20;
        return 31;
    L20:
        return 30;
    }

    public Month minus(long r10) {
        return plus(-(r10 % 12));
    }

    public Month plus(long r10) {
        return ENUMS[(ordinal() + (((int) (r10 % 12)) + 12)) % 12];
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public <R> R query(TemporalQuery<R> r10) {
        if (r10 != org.threeten.bp.temporal.b.a()) goto L7;
        return (R) IsoChronology.INSTANCE;
    L7:
        if (r10 != org.threeten.bp.temporal.b.e()) goto L11;
        return (R) ChronoUnit.MONTHS;
    L11:
        if (r10 != org.threeten.bp.temporal.b.b()) goto L13;
        return null;
    L13:
        if (r10 != org.threeten.bp.temporal.b.c()) goto L15;
        return null;
    L15:
        if (r10 != org.threeten.bp.temporal.b.f()) goto L17;
        return null;
    L17:
        if (r10 != org.threeten.bp.temporal.b.g()) goto L19;
        return null;
    L19:
        if (r10 != org.threeten.bp.temporal.b.d()) goto L22;
        return null;
    L22:
        return r10.queryFrom(this);
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public ValueRange range(TemporalField r10) {
        if (r10 != ChronoField.MONTH_OF_YEAR) goto L7;
        return r10.range();
    L7:
        if ((r10 instanceof ChronoField) == true) goto L11;
        return r10.rangeRefinedBy(this);
    L11:
        throw new UnsupportedTemporalTypeException("Unsupported field: " + r10);
    }
}
