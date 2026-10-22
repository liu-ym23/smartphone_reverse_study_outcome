package org.threeten.bp.chrono;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.DataInput;
import java.io.DataOutput;
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
    public /* synthetic */ ChronoLocalDate minus(long r3, TemporalUnit r5) {
        return minus(r3, (TemporalUnit) ZeusTransformUtils.wrapperContextForParams(r5, TemporalUnit.class, "com.obric.aiagent.plugin"));
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate, org.threeten.bp.jdk8.DefaultInterfaceTemporal, org.threeten.bp.temporal.Temporal
    public /* synthetic */ ChronoLocalDate minus(TemporalAmount r3) {
        return minus((TemporalAmount) ZeusTransformUtils.wrapperContextForParams(r3, TemporalAmount.class, "com.obric.aiagent.plugin"));
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate, org.threeten.bp.jdk8.DefaultInterfaceTemporal, org.threeten.bp.temporal.Temporal
    public /* synthetic */ Temporal minus(long r3, TemporalUnit r5) {
        return minus(r3, (TemporalUnit) ZeusTransformUtils.wrapperContextForParams(r5, TemporalUnit.class, "com.obric.aiagent.plugin"));
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate, org.threeten.bp.jdk8.DefaultInterfaceTemporal, org.threeten.bp.temporal.Temporal
    public /* synthetic */ Temporal minus(TemporalAmount r3) {
        return minus((TemporalAmount) ZeusTransformUtils.wrapperContextForParams(r3, TemporalAmount.class, "com.obric.aiagent.plugin"));
    }

    @Override // org.threeten.bp.chrono.ChronoDateImpl, org.threeten.bp.chrono.ChronoLocalDate, org.threeten.bp.temporal.Temporal
    public /* synthetic */ ChronoDateImpl plus(long r3, TemporalUnit r5) {
        return plus(r3, (TemporalUnit) ZeusTransformUtils.wrapperContextForParams(r5, TemporalUnit.class, "com.obric.aiagent.plugin"));
    }

    @Override // org.threeten.bp.chrono.ChronoDateImpl, org.threeten.bp.chrono.ChronoLocalDate, org.threeten.bp.temporal.Temporal
    public /* synthetic */ ChronoLocalDate plus(long r3, TemporalUnit r5) {
        return plus(r3, (TemporalUnit) ZeusTransformUtils.wrapperContextForParams(r5, TemporalUnit.class, "com.obric.aiagent.plugin"));
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate, org.threeten.bp.jdk8.DefaultInterfaceTemporal, org.threeten.bp.temporal.Temporal
    public /* synthetic */ ChronoLocalDate plus(TemporalAmount r3) {
        return plus((TemporalAmount) ZeusTransformUtils.wrapperContextForParams(r3, TemporalAmount.class, "com.obric.aiagent.plugin"));
    }

    @Override // org.threeten.bp.chrono.ChronoDateImpl, org.threeten.bp.chrono.ChronoLocalDate, org.threeten.bp.temporal.Temporal
    public /* synthetic */ Temporal plus(long r3, TemporalUnit r5) {
        return plus(r3, (TemporalUnit) ZeusTransformUtils.wrapperContextForParams(r5, TemporalUnit.class, "com.obric.aiagent.plugin"));
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate, org.threeten.bp.jdk8.DefaultInterfaceTemporal, org.threeten.bp.temporal.Temporal
    public /* synthetic */ Temporal plus(TemporalAmount r3) {
        return plus((TemporalAmount) ZeusTransformUtils.wrapperContextForParams(r3, TemporalAmount.class, "com.obric.aiagent.plugin"));
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
    public /* synthetic */ long until(Temporal r3, TemporalUnit r4) {
        return super.until((Temporal) ZeusTransformUtils.wrapperContextForParams(r3, Temporal.class, "com.obric.aiagent.plugin"), (TemporalUnit) ZeusTransformUtils.wrapperContextForParams(r4, TemporalUnit.class, "com.obric.aiagent.plugin"));
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate, org.threeten.bp.jdk8.DefaultInterfaceTemporal, org.threeten.bp.temporal.Temporal
    public /* synthetic */ ChronoLocalDate with(TemporalAdjuster r3) {
        return with((TemporalAdjuster) ZeusTransformUtils.wrapperContextForParams(r3, TemporalAdjuster.class, "com.obric.aiagent.plugin"));
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate, org.threeten.bp.temporal.Temporal
    public /* synthetic */ ChronoLocalDate with(TemporalField r3, long r4) {
        return with((TemporalField) ZeusTransformUtils.wrapperContextForParams(r3, TemporalField.class, "com.obric.aiagent.plugin"), r4);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate, org.threeten.bp.jdk8.DefaultInterfaceTemporal, org.threeten.bp.temporal.Temporal
    public /* synthetic */ Temporal with(TemporalAdjuster r3) {
        return with((TemporalAdjuster) ZeusTransformUtils.wrapperContextForParams(r3, TemporalAdjuster.class, "com.obric.aiagent.plugin"));
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate, org.threeten.bp.temporal.Temporal
    public /* synthetic */ Temporal with(TemporalField r3, long r4) {
        return with((TemporalField) ZeusTransformUtils.wrapperContextForParams(r3, TemporalField.class, "com.obric.aiagent.plugin"), r4);
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

    public static MinguoDate from(TemporalAccessor r2) {
        TemporalAccessor r3 = (TemporalAccessor) ZeusTransformUtils.wrapperContextForParams(r2, TemporalAccessor.class, "com.obric.aiagent.plugin");
        return MinguoChronology.INSTANCE.date(r3);
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
        return (MinguoEra) ZeusTransformUtils.preCheckCast(super.getEra(), MinguoEra.class, "com.obric.aiagent.plugin");
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate
    public int lengthOfMonth() {
        return this.isoDate.lengthOfMonth();
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor, org.threeten.bp.temporal.TemporalAccessor
    public ValueRange range(TemporalField r5) {
        TemporalField r6 = (TemporalField) ZeusTransformUtils.wrapperContextForParams(r5, TemporalField.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r6, ChronoField.class) == false) goto L27;
        if (isSupported(r6) == false) goto L25;
        ChronoField r0 = (ChronoField) ZeusTransformUtils.preCheckCast(r6, ChronoField.class, "com.obric.aiagent.plugin");
        int r1 = AnonymousClass1.$SwitchMap$org$threeten$bp$temporal$ChronoField[r0.ordinal()];
        if (r1 == 1) goto L23;
        if (r1 == 2) goto L23;
        if (r1 == 3) goto L23;
        if (r1 != 4) goto L15;
        ValueRange r7 = ChronoField.YEAR.range();
        if (getProlepticYear() > 0) goto L19;
        long r4 = ((-r7.getMinimum()) + 1) + 1911;
    L21:
        return ValueRange.of(1, r4);
    L19:
        r4 = r7.getMaximum() - 1911;
        goto L21
    L15:
        return getChronology().range(r0);
    L23:
        return this.isoDate.range(r6);
    L25:
        throw new UnsupportedTemporalTypeException("Unsupported field: " + r6);
    L27:
        return r6.rangeRefinedBy(this);
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public long getLong(TemporalField r4) {
        TemporalField r5 = (TemporalField) ZeusTransformUtils.wrapperContextForParams(r4, TemporalField.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r5, ChronoField.class) == false) goto L31;
        int r0 = AnonymousClass1.$SwitchMap$org$threeten$bp$temporal$ChronoField[((ChronoField) ZeusTransformUtils.preCheckCast(r5, ChronoField.class, "com.obric.aiagent.plugin")).ordinal()];
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
        return this.isoDate.getLong(r5);
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
        return r5.getFrom(this);
    }

    private long getProlepticMonth() {
        return ((((long) getProlepticYear()) * 12) + ((long) this.isoDate.getMonthValue())) - 1;
    }

    private int getProlepticYear() {
        return this.isoDate.getYear() - 1911;
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate, org.threeten.bp.jdk8.DefaultInterfaceTemporal, org.threeten.bp.temporal.Temporal
    public MinguoDate with(TemporalAdjuster r3) {
        return (MinguoDate) ZeusTransformUtils.preCheckCast(super.with((TemporalAdjuster) ZeusTransformUtils.wrapperContextForParams(r3, TemporalAdjuster.class, "com.obric.aiagent.plugin")), MinguoDate.class, "com.obric.aiagent.plugin");
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate, org.threeten.bp.temporal.Temporal
    public MinguoDate with(TemporalField r7, long r8) {
        TemporalField r9 = (TemporalField) ZeusTransformUtils.wrapperContextForParams(r7, TemporalField.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r9, ChronoField.class) == false) goto L33;
        ChronoField r0 = (ChronoField) ZeusTransformUtils.preCheckCast(r9, ChronoField.class, "com.obric.aiagent.plugin");
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
        return with(this.isoDate.with(r9, r8));
    L23:
        return with(this.isoDate.withYear((1 - getProlepticYear()) + 1911));
    L25:
        return with(this.isoDate.withYear(r2 + 1911));
    L26:
        LocalDate r10 = this.isoDate;
        if (getProlepticYear() < 1) goto L29;
        int r4 = r2 + 1911;
    L31:
        return with(r10.withYear(r4));
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
        return (MinguoDate) ZeusTransformUtils.preCheckCast(r9.adjustInto(this, r8), MinguoDate.class, "com.obric.aiagent.plugin");
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate, org.threeten.bp.jdk8.DefaultInterfaceTemporal, org.threeten.bp.temporal.Temporal
    public MinguoDate plus(TemporalAmount r3) {
        return (MinguoDate) ZeusTransformUtils.preCheckCast(super.plus((TemporalAmount) ZeusTransformUtils.wrapperContextForParams(r3, TemporalAmount.class, "com.obric.aiagent.plugin")), MinguoDate.class, "com.obric.aiagent.plugin");
    }

    @Override // org.threeten.bp.chrono.ChronoDateImpl, org.threeten.bp.chrono.ChronoLocalDate, org.threeten.bp.temporal.Temporal
    public MinguoDate plus(long r3, TemporalUnit r5) {
        return (MinguoDate) ZeusTransformUtils.preCheckCast(super.plus(r3, (TemporalUnit) ZeusTransformUtils.wrapperContextForParams(r5, TemporalUnit.class, "com.obric.aiagent.plugin")), MinguoDate.class, "com.obric.aiagent.plugin");
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate, org.threeten.bp.jdk8.DefaultInterfaceTemporal, org.threeten.bp.temporal.Temporal
    public MinguoDate minus(TemporalAmount r3) {
        return (MinguoDate) ZeusTransformUtils.preCheckCast(super.minus((TemporalAmount) ZeusTransformUtils.wrapperContextForParams(r3, TemporalAmount.class, "com.obric.aiagent.plugin")), MinguoDate.class, "com.obric.aiagent.plugin");
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate, org.threeten.bp.jdk8.DefaultInterfaceTemporal, org.threeten.bp.temporal.Temporal
    public MinguoDate minus(long r3, TemporalUnit r5) {
        return (MinguoDate) ZeusTransformUtils.preCheckCast(super.minus(r3, (TemporalUnit) ZeusTransformUtils.wrapperContextForParams(r5, TemporalUnit.class, "com.obric.aiagent.plugin")), MinguoDate.class, "com.obric.aiagent.plugin");
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
    public boolean equals(Object r3) {
        if (this != r3) goto L7;
        return true;
    L7:
        if (ZeusTransformUtils.instanceOf(r3, MinguoDate.class) == false) goto L10;
        MinguoDate r4 = (MinguoDate) ZeusTransformUtils.preCheckCast(r3, MinguoDate.class, "com.obric.aiagent.plugin");
        return this.isoDate.equals(r4.isoDate);
    L10:
        return false;
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate
    public int hashCode() {
        int r0 = getChronology().getId().hashCode();
        return this.isoDate.hashCode() ^ r0;
    }

    private Object writeReplace() {
        return new Ser((byte) 5, this);
    }

    void writeExternal(DataOutput r3) {
        DataOutput r4 = (DataOutput) ZeusTransformUtils.wrapperContextForParams(r3, DataOutput.class, "com.obric.aiagent.plugin");
        r4.writeInt(get(ChronoField.YEAR));
        r4.writeByte(get(ChronoField.MONTH_OF_YEAR));
        r4.writeByte(get(ChronoField.DAY_OF_MONTH));
    }

    static ChronoLocalDate readExternal(DataInput r3) {
        DataInput r4 = (DataInput) ZeusTransformUtils.wrapperContextForParams(r3, DataInput.class, "com.obric.aiagent.plugin");
        int r0 = r4.readInt();
        byte r1 = r4.readByte();
        byte r5 = r4.readByte();
        return MinguoChronology.INSTANCE.date(r0, r1, r5);
    }
}
