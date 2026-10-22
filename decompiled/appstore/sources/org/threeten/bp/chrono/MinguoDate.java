package org.threeten.bp.chrono;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.Serializable;
import org.threeten.bp.Clock;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalTime;
import org.threeten.bp.Period;
import org.threeten.bp.ZoneId;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.Temporal;
import org.threeten.bp.temporal.TemporalAccessor;
import org.threeten.bp.temporal.TemporalAdjuster;
import org.threeten.bp.temporal.TemporalAmount;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.TemporalUnit;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;
import org.threeten.bp.temporal.ValueRange;

/* JADX INFO: loaded from: classes4.dex */
public final class MinguoDate extends ChronoDateImpl<MinguoDate> implements Serializable {
    private static final long serialVersionUID = 1300372329181994526L;
    private final LocalDate isoDate;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f23093a = null;

        static {
            int[] r10 = new int[ChronoField.values().length];
            f23093a = r10;
            r10[ChronoField.DAY_OF_MONTH.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L18:
            f23093a[ChronoField.DAY_OF_YEAR.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L22:
            f23093a[ChronoField.ALIGNED_WEEK_OF_MONTH.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L30:
            f23093a[ChronoField.YEAR_OF_ERA.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L20:
            f23093a[ChronoField.PROLEPTIC_MONTH.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L24:
            f23093a[ChronoField.YEAR.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L26:
            f23093a[ChronoField.ERA.ordinal()] = 7;     // Catch: NoSuchFieldError -> L17
            return;
        }
    }

    public MinguoDate(LocalDate r10) {
        ig.d.h(r10, "date");
        this.isoDate = r10;
    }

    public static MinguoDate from(TemporalAccessor r10) {
        return MinguoChronology.INSTANCE.date(r10);
    }

    private long getProlepticMonth() {
        return ((((long) getProlepticYear()) * 12) + ((long) this.isoDate.getMonthValue())) - 1;
    }

    private int getProlepticYear() {
        return this.isoDate.getYear() - 1911;
    }

    public static MinguoDate now() {
        return now(Clock.systemDefaultZone());
    }

    public static MinguoDate of(int r10, int r11, int r12) {
        return MinguoChronology.INSTANCE.date(r10, r11, r12);
    }

    public static org.threeten.bp.chrono.a readExternal(DataInput r10) throws IOException {
        int r11 = r10.readInt();
        byte r12 = r10.readByte();
        byte r13 = r10.readByte();
        return MinguoChronology.INSTANCE.date(r11, r12, r13);
    }

    private Object writeReplace() {
        return new Ser((byte) 5, this);
    }

    @Override // org.threeten.bp.chrono.ChronoDateImpl, org.threeten.bp.chrono.a
    public final b atTime(LocalTime r10) {
        return super.atTime(r10);
    }

    @Override // org.threeten.bp.chrono.a
    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof MinguoDate) == true) goto L8;
        return false;
    L8:
        return this.isoDate.equals(((MinguoDate) r10).isoDate);
    }

    @Override // org.threeten.bp.chrono.a
    public /* bridge */ /* synthetic */ e getChronology() {
        return getChronology();
    }

    @Override // org.threeten.bp.chrono.a
    public /* bridge */ /* synthetic */ Era getEra() {
        return getEra();
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public long getLong(TemporalField r10) {
        if ((r10 instanceof ChronoField) == false) goto L31;
        int r11 = a.f23093a[((ChronoField) r10).ordinal()];
        int r12 = 1;
        if (r11 != 4) goto L7;
        int r13 = getProlepticYear();
        if (r13 >= 1) goto L29;
        r13 = 1 - r13;
    L29:
        return r13;
    L7:
        if (r11 == 5) goto L23;
        if (r11 == 6) goto L21;
        if (r11 == 7) goto L15;
        return this.isoDate.getLong(r10);
    L15:
        if (getProlepticYear() >= 1) goto L19;
        r12 = 0;
    L19:
        return r12;
    L21:
        return getProlepticYear();
    L23:
        return getProlepticMonth();
    L31:
        return r10.getFrom(this);
    }

    @Override // org.threeten.bp.chrono.a
    public int hashCode() {
        int r10 = getChronology().getId().hashCode();
        return this.isoDate.hashCode() ^ r10;
    }

    @Override // org.threeten.bp.chrono.a
    public int lengthOfMonth() {
        return this.isoDate.lengthOfMonth();
    }

    @Override // org.threeten.bp.chrono.a, ig.b, org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ org.threeten.bp.chrono.a minus(long r10, TemporalUnit r11) {
        return minus(r10, r11);
    }

    @Override // org.threeten.bp.chrono.ChronoDateImpl, org.threeten.bp.chrono.a, org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ ChronoDateImpl plus(long r10, TemporalUnit r11) {
        return plus(r10, r11);
    }

    @Override // org.threeten.bp.chrono.ChronoDateImpl
    public /* bridge */ /* synthetic */ ChronoDateImpl plusDays(long r10) {
        return plusDays(r10);
    }

    @Override // org.threeten.bp.chrono.ChronoDateImpl
    public /* bridge */ /* synthetic */ ChronoDateImpl plusMonths(long r10) {
        return plusMonths(r10);
    }

    @Override // org.threeten.bp.chrono.ChronoDateImpl
    public /* bridge */ /* synthetic */ ChronoDateImpl plusYears(long r10) {
        return plusYears(r10);
    }

    @Override // ig.c, org.threeten.bp.temporal.TemporalAccessor
    public ValueRange range(TemporalField r10) {
        if ((r10 instanceof ChronoField) == false) goto L27;
        if (isSupported(r10) == false) goto L25;
        ChronoField r11 = (ChronoField) r10;
        int r12 = a.f23093a[r11.ordinal()];
        if (r12 == 1) goto L23;
        if (r12 == 2) goto L23;
        if (r12 == 3) goto L23;
        if (r12 != 4) goto L15;
        ValueRange r13 = ChronoField.YEAR.range();
        if (getProlepticYear() > 0) goto L19;
        long r14 = (-r13.getMinimum()) + 1912;
    L21:
        return ValueRange.of(1, r14);
    L19:
        r14 = r13.getMaximum() - 1911;
        goto L21
    L15:
        return getChronology().range(r11);
    L23:
        return this.isoDate.range(r10);
    L25:
        throw new UnsupportedTemporalTypeException("Unsupported field: " + r10);
    L27:
        return r10.rangeRefinedBy(this);
    }

    @Override // org.threeten.bp.chrono.a
    public long toEpochDay() {
        return this.isoDate.toEpochDay();
    }

    @Override // org.threeten.bp.chrono.ChronoDateImpl, org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ long until(Temporal r10, TemporalUnit r11) {
        return super.until(r10, r11);
    }

    @Override // org.threeten.bp.chrono.a, ig.b, org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ org.threeten.bp.chrono.a with(TemporalAdjuster r10) {
        return with(r10);
    }

    public void writeExternal(DataOutput r10) throws IOException {
        r10.writeInt(get(ChronoField.YEAR));
        r10.writeByte(get(ChronoField.MONTH_OF_YEAR));
        r10.writeByte(get(ChronoField.DAY_OF_MONTH));
    }

    public static MinguoDate now(ZoneId r10) {
        return now(Clock.system(r10));
    }

    @Override // org.threeten.bp.chrono.a
    public MinguoChronology getChronology() {
        return MinguoChronology.INSTANCE;
    }

    @Override // org.threeten.bp.chrono.a
    public MinguoEra getEra() {
        return (MinguoEra) super.getEra();
    }

    @Override // org.threeten.bp.chrono.a, ig.b, org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ org.threeten.bp.chrono.a minus(TemporalAmount r10) {
        return minus(r10);
    }

    @Override // org.threeten.bp.chrono.ChronoDateImpl, org.threeten.bp.chrono.a, org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ org.threeten.bp.chrono.a plus(long r10, TemporalUnit r11) {
        return plus(r10, r11);
    }

    @Override // org.threeten.bp.chrono.ChronoDateImpl
    public MinguoDate plusDays(long r10) {
        return with(this.isoDate.plusDays(r10));
    }

    @Override // org.threeten.bp.chrono.ChronoDateImpl
    public MinguoDate plusMonths(long r10) {
        return with(this.isoDate.plusMonths(r10));
    }

    @Override // org.threeten.bp.chrono.ChronoDateImpl
    public MinguoDate plusYears(long r10) {
        return with(this.isoDate.plusYears(r10));
    }

    @Override // org.threeten.bp.chrono.ChronoDateImpl, org.threeten.bp.chrono.a
    public c until(org.threeten.bp.chrono.a r10) {
        Period r11 = this.isoDate.until(r10);
        return getChronology().period(r11.getYears(), r11.getMonths(), r11.getDays());
    }

    @Override // org.threeten.bp.chrono.a, org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ org.threeten.bp.chrono.a with(TemporalField r10, long r11) {
        return with(r10, r11);
    }

    public static MinguoDate now(Clock r10) {
        return new MinguoDate(LocalDate.now(r10));
    }

    @Override // org.threeten.bp.chrono.a, ig.b, org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ Temporal minus(long r10, TemporalUnit r11) {
        return minus(r10, r11);
    }

    @Override // org.threeten.bp.chrono.a, ig.b, org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ org.threeten.bp.chrono.a plus(TemporalAmount r10) {
        return plus(r10);
    }

    @Override // org.threeten.bp.chrono.a, ig.b, org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ Temporal with(TemporalAdjuster r10) {
        return with(r10);
    }

    @Override // org.threeten.bp.chrono.a, ig.b, org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ Temporal minus(TemporalAmount r10) {
        return minus(r10);
    }

    @Override // org.threeten.bp.chrono.ChronoDateImpl, org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ Temporal plus(long r10, TemporalUnit r11) {
        return plus(r10, r11);
    }

    @Override // org.threeten.bp.chrono.a, org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ Temporal with(TemporalField r10, long r11) {
        return with(r10, r11);
    }

    @Override // org.threeten.bp.chrono.a, ig.b, org.threeten.bp.temporal.Temporal
    public MinguoDate minus(TemporalAmount r10) {
        return (MinguoDate) super.minus(r10);
    }

    @Override // org.threeten.bp.chrono.a, ig.b, org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ Temporal plus(TemporalAmount r10) {
        return plus(r10);
    }

    @Override // org.threeten.bp.chrono.a, ig.b, org.threeten.bp.temporal.Temporal
    public MinguoDate with(TemporalAdjuster r10) {
        return (MinguoDate) super.with(r10);
    }

    @Override // org.threeten.bp.chrono.a, ig.b, org.threeten.bp.temporal.Temporal
    public MinguoDate minus(long r10, TemporalUnit r11) {
        return (MinguoDate) super.minus(r10, r11);
    }

    @Override // org.threeten.bp.chrono.a, ig.b, org.threeten.bp.temporal.Temporal
    public MinguoDate plus(TemporalAmount r10) {
        return (MinguoDate) super.plus(r10);
    }

    @Override // org.threeten.bp.chrono.a, org.threeten.bp.temporal.Temporal
    public MinguoDate with(TemporalField r10, long r11) {
        if ((r10 instanceof ChronoField) == false) goto L33;
        ChronoField r12 = (ChronoField) r10;
        if (getLong(r12) != r11) goto L7;
        return this;
    L7:
        int[] r13 = a.f23093a;
        int r14 = r13[r12.ordinal()];
        if (r14 != 4) goto L10;
    L16:
        int r15 = getChronology().range(r12).checkValidIntValue(r11, r12);
        int r16 = r13[r12.ordinal()];
        if (r16 == 4) goto L26;
        if (r16 == 6) goto L25;
        if (r16 == 7) goto L23;
    L21:
        return with(this.isoDate.with(r10, r11));
    L23:
        return with(this.isoDate.withYear(1912 - getProlepticYear()));
    L25:
        return with(this.isoDate.withYear(r15 + 1911));
    L26:
        LocalDate r17 = this.isoDate;
        if (getProlepticYear() < 1) goto L29;
        int r18 = r15 + 1911;
    L31:
        return with(r17.withYear(r18));
    L29:
        r18 = 1912 - r15;
        goto L31
    L10:
        if (r14 == 5) goto L14;
        if (r14 == 6) goto L16;
        if (r14 == 7) goto L16;
    L14:
        getChronology().range(r12).checkValidValue(r11, r12);
        return plusMonths(r11 - getProlepticMonth());
    L33:
        return (MinguoDate) r10.adjustInto(this, r11);
    }

    @Override // org.threeten.bp.chrono.ChronoDateImpl, org.threeten.bp.chrono.a, org.threeten.bp.temporal.Temporal
    public MinguoDate plus(long r10, TemporalUnit r11) {
        return (MinguoDate) super.plus(r10, r11);
    }

    private MinguoDate with(LocalDate r10) {
        if (r10.equals(this.isoDate) == false) goto L6;
        return this;
    L6:
        return new MinguoDate(r10);
    }
}
