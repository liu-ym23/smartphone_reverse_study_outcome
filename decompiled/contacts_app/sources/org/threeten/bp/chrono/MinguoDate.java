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
import org.threeten.bp.jdk8.Jdk8Methods;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.Temporal;
import org.threeten.bp.temporal.TemporalAccessor;
import org.threeten.bp.temporal.TemporalAdjuster;
import org.threeten.bp.temporal.TemporalAmount;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.TemporalUnit;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;
import org.threeten.bp.temporal.ValueRange;

/* JADX INFO: loaded from: classes5.dex */
public final class MinguoDate extends ChronoDateImpl<MinguoDate> implements Serializable {
    private static final long serialVersionUID = 1300372329181994526L;
    private final LocalDate isoDate;

    /* JADX INFO: renamed from: org.threeten.bp.chrono.MinguoDate$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$threeten$bp$temporal$ChronoField = null;

        static {
            int[] r0 = new int[ChronoField.values().length];
            $SwitchMap$org$threeten$bp$temporal$ChronoField = r0;
            r0[ChronoField.DAY_OF_MONTH.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L18:
            $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.DAY_OF_YEAR.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L22:
            $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.ALIGNED_WEEK_OF_MONTH.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L30:
            $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.YEAR_OF_ERA.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L20:
            $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.PROLEPTIC_MONTH.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L24:
            $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.YEAR.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L26:
            $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.ERA.ordinal()] = 7;     // Catch: NoSuchFieldError -> L17
            return;
        }
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate
    public /* bridge */ /* synthetic */ Chronology getChronology() {
        return getChronology();
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate
    public /* bridge */ /* synthetic */ Era getEra() {
        return getEra();
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate, org.threeten.bp.jdk8.DefaultInterfaceTemporal, org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ ChronoLocalDate minus(long r1, TemporalUnit r3) {
        return minus(r1, r3);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate, org.threeten.bp.jdk8.DefaultInterfaceTemporal, org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ ChronoLocalDate minus(TemporalAmount r1) {
        return minus(r1);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate, org.threeten.bp.jdk8.DefaultInterfaceTemporal, org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ Temporal minus(long r1, TemporalUnit r3) {
        return minus(r1, r3);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate, org.threeten.bp.jdk8.DefaultInterfaceTemporal, org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ Temporal minus(TemporalAmount r1) {
        return minus(r1);
    }

    @Override // org.threeten.bp.chrono.ChronoDateImpl, org.threeten.bp.chrono.ChronoLocalDate, org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ ChronoDateImpl plus(long r1, TemporalUnit r3) {
        return plus(r1, r3);
    }

    @Override // org.threeten.bp.chrono.ChronoDateImpl, org.threeten.bp.chrono.ChronoLocalDate, org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ ChronoLocalDate plus(long r1, TemporalUnit r3) {
        return plus(r1, r3);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate, org.threeten.bp.jdk8.DefaultInterfaceTemporal, org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ ChronoLocalDate plus(TemporalAmount r1) {
        return plus(r1);
    }

    @Override // org.threeten.bp.chrono.ChronoDateImpl, org.threeten.bp.chrono.ChronoLocalDate, org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ Temporal plus(long r1, TemporalUnit r3) {
        return plus(r1, r3);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate, org.threeten.bp.jdk8.DefaultInterfaceTemporal, org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ Temporal plus(TemporalAmount r1) {
        return plus(r1);
    }

    @Override // org.threeten.bp.chrono.ChronoDateImpl
    /* bridge */ /* synthetic */ ChronoDateImpl plusDays(long r1) {
        return plusDays(r1);
    }

    @Override // org.threeten.bp.chrono.ChronoDateImpl
    /* bridge */ /* synthetic */ ChronoDateImpl plusMonths(long r1) {
        return plusMonths(r1);
    }

    @Override // org.threeten.bp.chrono.ChronoDateImpl
    /* bridge */ /* synthetic */ ChronoDateImpl plusYears(long r1) {
        return plusYears(r1);
    }

    @Override // org.threeten.bp.chrono.ChronoDateImpl, org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ long until(Temporal r1, TemporalUnit r2) {
        return super.until(r1, r2);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate, org.threeten.bp.jdk8.DefaultInterfaceTemporal, org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ ChronoLocalDate with(TemporalAdjuster r1) {
        return with(r1);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate, org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ ChronoLocalDate with(TemporalField r1, long r2) {
        return with(r1, r2);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate, org.threeten.bp.jdk8.DefaultInterfaceTemporal, org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ Temporal with(TemporalAdjuster r1) {
        return with(r1);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate, org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ Temporal with(TemporalField r1, long r2) {
        return with(r1, r2);
    }

    public static MinguoDate now() {
        return now(Clock.systemDefaultZone());
    }

    public static MinguoDate now(ZoneId r0) {
        return now(Clock.system(r0));
    }

    public static MinguoDate now(Clock r1) {
        return new MinguoDate(LocalDate.now(r1));
    }

    public static MinguoDate of(int r1, int r2, int r3) {
        return MinguoChronology.INSTANCE.date(r1, r2, r3);
    }

    public static MinguoDate from(TemporalAccessor r1) {
        return MinguoChronology.INSTANCE.date(r1);
    }

    MinguoDate(LocalDate r2) {
        Jdk8Methods.requireNonNull(r2, "date");
        this.isoDate = r2;
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate
    public MinguoChronology getChronology() {
        return MinguoChronology.INSTANCE;
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate
    public MinguoEra getEra() {
        return (MinguoEra) super.getEra();
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate
    public int lengthOfMonth() {
        return this.isoDate.lengthOfMonth();
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor, org.threeten.bp.temporal.TemporalAccessor
    public ValueRange range(TemporalField r5) {
        if ((r5 instanceof ChronoField) == false) goto L27;
        if (isSupported(r5) == false) goto L25;
        ChronoField r0 = (ChronoField) r5;
        int r1 = AnonymousClass1.$SwitchMap$org$threeten$bp$temporal$ChronoField[r0.ordinal()];
        if (r1 == 1) goto L23;
        if (r1 == 2) goto L23;
        if (r1 == 3) goto L23;
        if (r1 != 4) goto L15;
        ValueRange r6 = ChronoField.YEAR.range();
        if (getProlepticYear() > 0) goto L19;
        long r4 = ((-r6.getMinimum()) + 1) + 1911;
    L21:
        return ValueRange.of(1, r4);
    L19:
        r4 = r6.getMaximum() - 1911;
        goto L21
    L15:
        return getChronology().range(r0);
    L23:
        return this.isoDate.range(r5);
    L25:
        throw new UnsupportedTemporalTypeException("Unsupported field: " + r5);
    L27:
        return r5.rangeRefinedBy(this);
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public long getLong(TemporalField r4) {
        if ((r4 instanceof ChronoField) == false) goto L31;
        int r0 = AnonymousClass1.$SwitchMap$org$threeten$bp$temporal$ChronoField[((ChronoField) r4).ordinal()];
        int r2 = 1;
        if (r0 != 4) goto L7;
        int r3 = getProlepticYear();
        if (r3 >= 1) goto L29;
        r3 = 1 - r3;
    L29:
        return r3;
    L7:
        if (r0 == 5) goto L23;
        if (r0 == 6) goto L21;
        if (r0 == 7) goto L15;
        return this.isoDate.getLong(r4);
    L15:
        if (getProlepticYear() >= 1) goto L19;
        r2 = 0;
    L19:
        return r2;
    L21:
        return getProlepticYear();
    L23:
        return getProlepticMonth();
    L31:
        return r4.getFrom(this);
    }

    private long getProlepticMonth() {
        return ((((long) getProlepticYear()) * 12) + ((long) this.isoDate.getMonthValue())) - 1;
    }

    private int getProlepticYear() {
        return this.isoDate.getYear() - 1911;
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate, org.threeten.bp.jdk8.DefaultInterfaceTemporal, org.threeten.bp.temporal.Temporal
    public MinguoDate with(TemporalAdjuster r1) {
        return (MinguoDate) super.with(r1);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate, org.threeten.bp.temporal.Temporal
    public MinguoDate with(TemporalField r7, long r8) {
        if ((r7 instanceof ChronoField) == false) goto L33;
        ChronoField r0 = (ChronoField) r7;
        if (getLong(r0) != r8) goto L7;
        return this;
    L7:
        int r1 = AnonymousClass1.$SwitchMap$org$threeten$bp$temporal$ChronoField[r0.ordinal()];
        if (r1 != 4) goto L10;
    L16:
        int r2 = getChronology().range(r0).checkValidIntValue(r8, r0);
        int r3 = AnonymousClass1.$SwitchMap$org$threeten$bp$temporal$ChronoField[r0.ordinal()];
        if (r3 == 4) goto L26;
        if (r3 == 6) goto L25;
        if (r3 == 7) goto L23;
    L21:
        return with(this.isoDate.with(r7, r8));
    L23:
        return with(this.isoDate.withYear((1 - getProlepticYear()) + 1911));
    L25:
        return with(this.isoDate.withYear(r2 + 1911));
    L26:
        LocalDate r9 = this.isoDate;
        if (getProlepticYear() < 1) goto L29;
        int r4 = r2 + 1911;
    L31:
        return with(r9.withYear(r4));
    L29:
        r4 = (1 - r2) + 1911;
        goto L31
    L10:
        if (r1 == 5) goto L14;
        if (r1 == 6) goto L16;
        if (r1 == 7) goto L16;
    L14:
        getChronology().range(r0).checkValidValue(r8, r0);
        return plusMonths(r8 - getProlepticMonth());
    L33:
        return (MinguoDate) r7.adjustInto(this, r8);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate, org.threeten.bp.jdk8.DefaultInterfaceTemporal, org.threeten.bp.temporal.Temporal
    public MinguoDate plus(TemporalAmount r1) {
        return (MinguoDate) super.plus(r1);
    }

    @Override // org.threeten.bp.chrono.ChronoDateImpl, org.threeten.bp.chrono.ChronoLocalDate, org.threeten.bp.temporal.Temporal
    public MinguoDate plus(long r1, TemporalUnit r3) {
        return (MinguoDate) super.plus(r1, r3);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate, org.threeten.bp.jdk8.DefaultInterfaceTemporal, org.threeten.bp.temporal.Temporal
    public MinguoDate minus(TemporalAmount r1) {
        return (MinguoDate) super.minus(r1);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate, org.threeten.bp.jdk8.DefaultInterfaceTemporal, org.threeten.bp.temporal.Temporal
    public MinguoDate minus(long r1, TemporalUnit r3) {
        return (MinguoDate) super.minus(r1, r3);
    }

    @Override // org.threeten.bp.chrono.ChronoDateImpl
    MinguoDate plusYears(long r2) {
        return with(this.isoDate.plusYears(r2));
    }

    @Override // org.threeten.bp.chrono.ChronoDateImpl
    MinguoDate plusMonths(long r2) {
        return with(this.isoDate.plusMonths(r2));
    }

    @Override // org.threeten.bp.chrono.ChronoDateImpl
    MinguoDate plusDays(long r2) {
        return with(this.isoDate.plusDays(r2));
    }

    private MinguoDate with(LocalDate r2) {
        if (r2.equals(this.isoDate) == false) goto L6;
        return this;
    L6:
        return new MinguoDate(r2);
    }

    @Override // org.threeten.bp.chrono.ChronoDateImpl, org.threeten.bp.chrono.ChronoLocalDate
    public final ChronoLocalDateTime<MinguoDate> atTime(LocalTime r1) {
        return super.atTime(r1);
    }

    @Override // org.threeten.bp.chrono.ChronoDateImpl, org.threeten.bp.chrono.ChronoLocalDate
    public ChronoPeriod until(ChronoLocalDate r3) {
        Period r4 = this.isoDate.until(r3);
        return getChronology().period(r4.getYears(), r4.getMonths(), r4.getDays());
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate
    public long toEpochDay() {
        return this.isoDate.toEpochDay();
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate
    public boolean equals(Object r2) {
        if (this != r2) goto L6;
        return true;
    L6:
        if ((r2 instanceof MinguoDate) == true) goto L8;
        return false;
    L8:
        return this.isoDate.equals(((MinguoDate) r2).isoDate);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate
    public int hashCode() {
        int r0 = getChronology().getId().hashCode();
        return this.isoDate.hashCode() ^ r0;
    }

    private Object writeReplace() {
        return new Ser((byte) 5, this);
    }

    void writeExternal(DataOutput r2) throws IOException {
        r2.writeInt(get(ChronoField.YEAR));
        r2.writeByte(get(ChronoField.MONTH_OF_YEAR));
        r2.writeByte(get(ChronoField.DAY_OF_MONTH));
    }

    static ChronoLocalDate readExternal(DataInput r3) throws IOException {
        int r0 = r3.readInt();
        byte r1 = r3.readByte();
        byte r4 = r3.readByte();
        return MinguoChronology.INSTANCE.date(r0, r1, r4);
    }
}
