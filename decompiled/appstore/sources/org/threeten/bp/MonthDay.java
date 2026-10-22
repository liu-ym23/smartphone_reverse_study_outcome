package org.threeten.bp;

import com.bytedanceos.common.ad.param.AdReportParam;
import com.google.common.primitives.SignedBytes;
import ig.c;
import ig.d;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import org.threeten.bp.chrono.IsoChronology;
import org.threeten.bp.chrono.e;
import org.threeten.bp.format.DateTimeFormatter;
import org.threeten.bp.format.DateTimeFormatterBuilder;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.Temporal;
import org.threeten.bp.temporal.TemporalAccessor;
import org.threeten.bp.temporal.TemporalAdjuster;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.TemporalQuery;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;
import org.threeten.bp.temporal.ValueRange;

/* JADX INFO: loaded from: classes4.dex */
public final class MonthDay extends c implements TemporalAccessor, TemporalAdjuster, Comparable<MonthDay>, Serializable {
    public static final TemporalQuery<MonthDay> FROM = null;
    private static final DateTimeFormatter PARSER = null;
    private static final long serialVersionUID = -939150713474957432L;
    private final int day;
    private final int month;

    public static class a implements TemporalQuery {
        public a() {
        }

        public MonthDay a(TemporalAccessor r10) {
            return MonthDay.from(r10);
        }

        @Override // org.threeten.bp.temporal.TemporalQuery
        public /* bridge */ /* synthetic */ Object queryFrom(TemporalAccessor r10) {
            return a(r10);
        }
    }

    public static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f23075a = null;

        static {
            int[] r10 = new int[ChronoField.values().length];
            f23075a = r10;
            r10[ChronoField.DAY_OF_MONTH.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            f23075a[ChronoField.MONTH_OF_YEAR.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    static {
        FROM = new a();
        PARSER = new DateTimeFormatterBuilder().g("--").p(ChronoField.MONTH_OF_YEAR, 2).f('-').p(ChronoField.DAY_OF_MONTH, 2).E();
    }

    private MonthDay(int r10, int r11) {
        this.month = r10;
        this.day = r11;
    }

    public static MonthDay from(TemporalAccessor r10) {
        if ((r10 instanceof MonthDay) == true) goto L5;
        if (IsoChronology.INSTANCE.equals(e.from(r10)) == true) goto L9;
        r10 = LocalDate.from(r10);     // Catch: DateTimeException -> L11
    L9:
        return of(r10.get(ChronoField.MONTH_OF_YEAR), r10.get(ChronoField.DAY_OF_MONTH));
    L12:
        throw new DateTimeException("Unable to obtain MonthDay from TemporalAccessor: " + r10 + ", type " + r10.getClass().getName());
    L5:
        return (MonthDay) r10;
    }

    public static MonthDay now() {
        return now(Clock.systemDefaultZone());
    }

    public static MonthDay of(Month r10, int r11) {
        d.h(r10, "month");
        ChronoField.DAY_OF_MONTH.checkValidValue(r11);
        if (r11 > r10.maxLength()) goto L7;
        return new MonthDay(r10.getValue(), r11);
    L7:
        throw new DateTimeException("Illegal value for DayOfMonth field, value " + r11 + " is not valid for month " + r10.name());
    }

    public static MonthDay parse(CharSequence r10) {
        return parse(r10, PARSER);
    }

    public static MonthDay readExternal(DataInput r10) throws IOException {
        return of(r10.readByte(), r10.readByte());
    }

    private Object readResolve() throws ObjectStreamException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new Ser(SignedBytes.MAX_POWER_OF_TWO, this);
    }

    @Override // org.threeten.bp.temporal.TemporalAdjuster
    public Temporal adjustInto(Temporal r10) {
        if (e.from(r10).equals(IsoChronology.INSTANCE) == false) goto L7;
        Temporal r11 = r10.with(ChronoField.MONTH_OF_YEAR, this.month);
        ChronoField r12 = ChronoField.DAY_OF_MONTH;
        return r11.with(r12, Math.min(r11.range(r12).getMaximum(), this.day));
    L7:
        throw new DateTimeException("Adjustment only supported on ISO date-time");
    }

    public LocalDate atYear(int r10) {
        int r11 = this.month;
        if (isValidYear(r10) == false) goto L5;
        int r12 = this.day;
    L7:
        return LocalDate.of(r10, r11, r12);
    L5:
        r12 = 28;
        goto L7
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(MonthDay r10) {
        return compareTo2(r10);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof MonthDay) == false) goto L14;
        MonthDay r11 = (MonthDay) r10;
        if (this.month != r11.month) goto L13;
        if (this.day != r11.day) goto L13;
        return true;
    L13:
        return false;
    L14:
        return false;
    }

    public String format(DateTimeFormatter r10) {
        d.h(r10, "formatter");
        return r10.d(this);
    }

    @Override // ig.c, org.threeten.bp.temporal.TemporalAccessor
    public int get(TemporalField r10) {
        return range(r10).checkValidIntValue(getLong(r10), r10);
    }

    public int getDayOfMonth() {
        return this.day;
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public long getLong(TemporalField r10) {
        if ((r10 instanceof ChronoField) == false) goto L15;
        int r11 = b.f23075a[((ChronoField) r10).ordinal()];
        if (r11 != 1) goto L7;
        int r12 = this.day;
    L10:
        return r12;
    L7:
        if (r11 != 2) goto L12;
        r12 = this.month;
        goto L10
    L12:
        throw new UnsupportedTemporalTypeException("Unsupported field: " + r10);
    L15:
        return r10.getFrom(this);
    }

    public Month getMonth() {
        return Month.of(this.month);
    }

    public int getMonthValue() {
        return this.month;
    }

    public int hashCode() {
        return (this.month << 6) + this.day;
    }

    public boolean isAfter(MonthDay r10) {
        if (compareTo2(r10) <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isBefore(MonthDay r10) {
        if (compareTo2(r10) >= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public boolean isSupported(TemporalField r10) {
        if ((r10 instanceof ChronoField) == true) goto L5;
        if (r10 == null) goto L16;
        if (r10.isSupportedBy(this) == false) goto L16;
        return true;
    L16:
        return false;
    L5:
        if (r10 != ChronoField.MONTH_OF_YEAR) goto L7;
        return true;
    L7:
        if (r10 != ChronoField.DAY_OF_MONTH) goto L10;
        return true;
    L10:
        return false;
    }

    public boolean isValidYear(int r10) {
        if (this.day == 29) goto L5;
    L9:
        boolean r11 = false;
    L11:
        return !r11;
    L5:
        if (this.month != 2) goto L9;
        if (Year.isLeap(r10) == true) goto L9;
        r11 = true;
        goto L11
    }

    @Override // ig.c, org.threeten.bp.temporal.TemporalAccessor
    public <R> R query(TemporalQuery<R> r10) {
        if (r10 != org.threeten.bp.temporal.b.a()) goto L7;
        return (R) IsoChronology.INSTANCE;
    L7:
        return (R) super.query(r10);
    }

    @Override // ig.c, org.threeten.bp.temporal.TemporalAccessor
    public ValueRange range(TemporalField r10) {
        if (r10 != ChronoField.MONTH_OF_YEAR) goto L7;
        return r10.range();
    L7:
        if (r10 != ChronoField.DAY_OF_MONTH) goto L11;
        return ValueRange.of(1, getMonth().minLength(), getMonth().maxLength());
    L11:
        return super.range(r10);
    }

    public String toString() {
        StringBuilder r10 = new StringBuilder(10);
        r10.append("--");
        if (this.month >= 10) goto L5;
        String r11 = AdReportParam.ClickPosType.SKIP;
    L6:
        r10.append(r11);
        r10.append(this.month);
        if (this.day >= 10) goto L9;
        String r12 = "-0";
    L10:
        r10.append(r12);
        r10.append(this.day);
        return r10.toString();
    L9:
        r12 = "-";
        goto L10
    L5:
        r11 = "";
        goto L6
    }

    public MonthDay with(Month r10) {
        d.h(r10, "month");
        if (r10.getValue() != this.month) goto L5;
        return this;
    L5:
        int r11 = Math.min(this.day, r10.maxLength());
        return new MonthDay(r10.getValue(), r11);
    }

    public MonthDay withDayOfMonth(int r10) {
        if (r10 != this.day) goto L6;
        return this;
    L6:
        return of(this.month, r10);
    }

    public MonthDay withMonth(int r10) {
        return with(Month.of(r10));
    }

    public void writeExternal(DataOutput r10) throws IOException {
        r10.writeByte(this.month);
        r10.writeByte(this.day);
    }

    public static MonthDay now(ZoneId r10) {
        return now(Clock.system(r10));
    }

    public static MonthDay parse(CharSequence r10, DateTimeFormatter r11) {
        d.h(r11, "formatter");
        return (MonthDay) r11.n(r10, FROM);
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(MonthDay r10) {
        int r11 = this.month - r10.month;
        if (r11 == 0) goto L5;
        return r11;
    L5:
        return this.day - r10.day;
    }

    public static MonthDay now(Clock r10) {
        LocalDate r11 = LocalDate.now(r10);
        return of(r11.getMonth(), r11.getDayOfMonth());
    }

    public static MonthDay of(int r10, int r11) {
        return of(Month.of(r10), r11);
    }
}
