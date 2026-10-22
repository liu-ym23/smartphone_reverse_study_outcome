package org.threeten.bp.chrono;

import com.bytedance.apm.battery.config.BatteryFactorConfig;
import com.google.common.base.Ascii;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.Serializable;
import org.threeten.bp.LocalTime;
import org.threeten.bp.ZoneId;
import org.threeten.bp.chrono.a;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.Temporal;
import org.threeten.bp.temporal.TemporalAdjuster;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.TemporalUnit;
import org.threeten.bp.temporal.ValueRange;

/* JADX INFO: loaded from: classes4.dex */
final class ChronoLocalDateTimeImpl<D extends org.threeten.bp.chrono.a> extends b implements Temporal, TemporalAdjuster, Serializable {
    private static final int HOURS_PER_DAY = 24;
    private static final long MICROS_PER_DAY = 86400000000L;
    private static final long MILLIS_PER_DAY = 86400000;
    private static final int MINUTES_PER_DAY = 1440;
    private static final int MINUTES_PER_HOUR = 60;
    private static final long NANOS_PER_DAY = 86400000000000L;
    private static final long NANOS_PER_HOUR = 3600000000000L;
    private static final long NANOS_PER_MINUTE = 60000000000L;
    private static final long NANOS_PER_SECOND = 1000000000;
    private static final int SECONDS_PER_DAY = 86400;
    private static final int SECONDS_PER_HOUR = 3600;
    private static final int SECONDS_PER_MINUTE = 60;
    private static final long serialVersionUID = 4556003607393004514L;
    private final D date;
    private final LocalTime time;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f23087a = null;

        static {
            int[] r10 = new int[ChronoUnit.values().length];
            f23087a = r10;
            r10[ChronoUnit.NANOS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L18:
            f23087a[ChronoUnit.MICROS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L22:
            f23087a[ChronoUnit.MILLIS.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L30:
            f23087a[ChronoUnit.SECONDS.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L20:
            f23087a[ChronoUnit.MINUTES.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L24:
            f23087a[ChronoUnit.HOURS.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L26:
            f23087a[ChronoUnit.HALF_DAYS.ordinal()] = 7;     // Catch: NoSuchFieldError -> L17
            return;
        }
    }

    private ChronoLocalDateTimeImpl(D r10, LocalTime r11) {
        ig.d.h(r10, "date");
        ig.d.h(r11, "time");
        this.date = r10;
        this.time = r11;
    }

    public static <R extends org.threeten.bp.chrono.a> ChronoLocalDateTimeImpl<R> of(R r10, LocalTime r11) {
        return new ChronoLocalDateTimeImpl(r10, r11);
    }

    private ChronoLocalDateTimeImpl<D> plusDays(long r10) {
        return with(this.date.plus(r10, ChronoUnit.DAYS), this.time);
    }

    private ChronoLocalDateTimeImpl<D> plusHours(long r11) {
        return plusWithOverflow(this.date, r11, 0, 0, 0);
    }

    private ChronoLocalDateTimeImpl<D> plusMinutes(long r11) {
        return plusWithOverflow(this.date, 0, r11, 0, 0);
    }

    private ChronoLocalDateTimeImpl<D> plusNanos(long r11) {
        return plusWithOverflow(this.date, 0, 0, 0, r11);
    }

    private ChronoLocalDateTimeImpl<D> plusWithOverflow(D r17, long r18, long r20, long r22, long r24) {
        if ((((r18 | r20) | r22) | r24) == 0) goto L5;
        long r10 = (((r24 / NANOS_PER_DAY) + (r22 / 86400)) + (r20 / 1440)) + (r18 / 24);
        long r12 = (((r24 % NANOS_PER_DAY) + ((r22 % 86400) * NANOS_PER_SECOND)) + ((r20 % 1440) * NANOS_PER_MINUTE)) + ((r18 % 24) * NANOS_PER_HOUR);
        long r11 = this.time.toNanoOfDay();
        long r13 = r12 + r11;
        long r14 = r10 + ig.d.d(r13, NANOS_PER_DAY);
        long r15 = ig.d.g(r13, NANOS_PER_DAY);
        if (r15 != r11) goto L9;
        LocalTime r16 = this.time;
    L11:
        return with(r17.plus(r14, ChronoUnit.DAYS), r16);
    L9:
        r16 = LocalTime.ofNanoOfDay(r15);
        goto L11
    L5:
        return with(r17, this.time);
    }

    public static b readExternal(ObjectInput r10) throws IOException, ClassNotFoundException {
        return ((org.threeten.bp.chrono.a) r10.readObject()).atTime((LocalTime) r10.readObject());
    }

    private Object writeReplace() {
        return new Ser(Ascii.FF, this);
    }

    @Override // org.threeten.bp.chrono.b
    public d atZone(ZoneId r10) {
        return ChronoZonedDateTimeImpl.ofBest(this, r10, null);
    }

    @Override // ig.c, org.threeten.bp.temporal.TemporalAccessor
    public int get(TemporalField r10) {
        if ((r10 instanceof ChronoField) == false) goto L10;
        if (r10.isTimeBased() == false) goto L8;
        return this.time.get(r10);
    L8:
        return this.date.get(r10);
    L10:
        return range(r10).checkValidIntValue(getLong(r10), r10);
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public long getLong(TemporalField r10) {
        if ((r10 instanceof ChronoField) == false) goto L10;
        if (r10.isTimeBased() == false) goto L8;
        return this.time.getLong(r10);
    L8:
        return this.date.getLong(r10);
    L10:
        return r10.getFrom(this);
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
        if (r10.isDateBased() == false) goto L7;
        return true;
    L7:
        if (r10.isTimeBased() == false) goto L10;
        return true;
    L10:
        return false;
    }

    @Override // org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ b plus(long r10, TemporalUnit r11) {
        return plus(r10, r11);
    }

    public ChronoLocalDateTimeImpl<D> plusSeconds(long r11) {
        return plusWithOverflow(this.date, 0, 0, r11, 0);
    }

    @Override // ig.c, org.threeten.bp.temporal.TemporalAccessor
    public ValueRange range(TemporalField r10) {
        if ((r10 instanceof ChronoField) == false) goto L10;
        if (r10.isTimeBased() == false) goto L8;
        return this.time.range(r10);
    L8:
        return this.date.range(r10);
    L10:
        return r10.rangeRefinedBy(this);
    }

    @Override // org.threeten.bp.chrono.b
    public D toLocalDate() {
        return this.date;
    }

    @Override // org.threeten.bp.chrono.b
    public LocalTime toLocalTime() {
        return this.time;
    }

    @Override // org.threeten.bp.temporal.Temporal
    public long until(Temporal r10, TemporalUnit r11) {
        b r12 = toLocalDate().getChronology().localDateTime(r10);
        if ((r11 instanceof ChronoUnit) == false) goto L24;
        ChronoUnit r13 = (ChronoUnit) r11;
        if (r13.isTimeBased() == false) goto L18;
        ChronoField r14 = ChronoField.EPOCH_DAY;
        long r15 = r12.getLong(r14) - this.date.getLong(r14);
        switch(a.f23087a[r13.ordinal()]) {
            case 1: goto L15;
            case 2: goto L14;
            case 3: goto L13;
            case 4: goto L12;
            case 5: goto L11;
            case 6: goto L10;
            case 7: goto L9;
            default: goto L17;
        };
    L9:
        r15 = ig.d.l(r15, 2);
        goto L17
    L10:
        r15 = ig.d.l(r15, 24);
        goto L17
    L11:
        r15 = ig.d.l(r15, MINUTES_PER_DAY);
        goto L17
    L12:
        r15 = ig.d.l(r15, 86400);
        goto L17
    L13:
        r15 = ig.d.m(r15, 86400000);
        goto L17
    L14:
        r15 = ig.d.m(r15, MICROS_PER_DAY);
        goto L17
    L15:
        r15 = ig.d.m(r15, NANOS_PER_DAY);
    L17:
        return ig.d.j(r15, this.time.until(r12.toLocalTime(), r11));
    L18:
        org.threeten.bp.chrono.a r16 = r12.toLocalDate();
        if (r12.toLocalTime().isBefore(this.time) == false) goto L22;
        r16 = r16.minus(1, ChronoUnit.DAYS);
    L22:
        return this.date.until(r16, r11);
    L24:
        return r11.between(this, r12);
    }

    @Override // ig.b, org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ b with(TemporalAdjuster r10) {
        return with(r10);
    }

    public void writeExternal(ObjectOutput r10) throws IOException {
        r10.writeObject(this.date);
        r10.writeObject(this.time);
    }

    @Override // org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ Temporal plus(long r10, TemporalUnit r11) {
        return plus(r10, r11);
    }

    @Override // org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ b with(TemporalField r10, long r11) {
        return with(r10, r11);
    }

    @Override // org.threeten.bp.temporal.Temporal
    public ChronoLocalDateTimeImpl<D> plus(long r10, TemporalUnit r11) {
        if ((r11 instanceof ChronoUnit) == false) goto L23;
        switch(a.f23087a[((ChronoUnit) r11).ordinal()]) {
            case 1: goto L21;
            case 2: goto L19;
            case 3: goto L17;
            case 4: goto L15;
            case 5: goto L13;
            case 6: goto L11;
            case 7: goto L9;
            default: goto L7;
        };
    L7:
        return with(this.date.plus(r10, r11), this.time);
    L9:
        return plusDays(r10 / 256).plusHours((r10 % 256) * 12);
    L11:
        return plusHours(r10);
    L13:
        return plusMinutes(r10);
    L15:
        return plusSeconds(r10);
    L17:
        return plusDays(r10 / 86400000).plusNanos((r10 % 86400000) * BatteryFactorConfig.WIFI_BPS);
    L19:
        return plusDays(r10 / MICROS_PER_DAY).plusNanos((r10 % MICROS_PER_DAY) * 1000);
    L21:
        return plusNanos(r10);
    L23:
        return this.date.getChronology().ensureChronoLocalDateTime(r11.addTo(this, r10));
    }

    @Override // ig.b, org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ Temporal with(TemporalAdjuster r10) {
        return with(r10);
    }

    @Override // org.threeten.bp.temporal.Temporal
    public boolean isSupported(TemporalUnit r10) {
        if ((r10 instanceof ChronoUnit) == true) goto L5;
        if (r10 == null) goto L16;
        if (r10.isSupportedBy(this) == false) goto L16;
        return true;
    L16:
        return false;
    L5:
        if (r10.isDateBased() == false) goto L7;
        return true;
    L7:
        if (r10.isTimeBased() == false) goto L10;
        return true;
    L10:
        return false;
    }

    @Override // org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ Temporal with(TemporalField r10, long r11) {
        return with(r10, r11);
    }

    private ChronoLocalDateTimeImpl<D> with(Temporal r10, LocalTime r11) {
        D r12 = this.date;
        if (r12 != r10) goto L8;
        if (this.time != r11) goto L8;
        return this;
    L8:
        return new ChronoLocalDateTimeImpl(r12.getChronology().ensureChronoLocalDate(r10), r11);
    }

    @Override // ig.b, org.threeten.bp.temporal.Temporal
    public ChronoLocalDateTimeImpl<D> with(TemporalAdjuster r10) {
        if ((r10 instanceof org.threeten.bp.chrono.a) == false) goto L7;
        return with((org.threeten.bp.chrono.a) r10, this.time);
    L7:
        if ((r10 instanceof LocalTime) == false) goto L11;
        return with(this.date, (LocalTime) r10);
    L11:
        if ((r10 instanceof ChronoLocalDateTimeImpl) == false) goto L15;
        return this.date.getChronology().ensureChronoLocalDateTime((ChronoLocalDateTimeImpl) r10);
    L15:
        return this.date.getChronology().ensureChronoLocalDateTime((ChronoLocalDateTimeImpl) r10.adjustInto(this));
    }

    @Override // org.threeten.bp.temporal.Temporal
    public ChronoLocalDateTimeImpl<D> with(TemporalField r10, long r11) {
        if ((r10 instanceof ChronoField) == false) goto L11;
        if (r10.isTimeBased() == false) goto L9;
        return with(this.date, this.time.with(r10, r11));
    L9:
        return with(this.date.with(r10, r11), this.time);
    L11:
        return this.date.getChronology().ensureChronoLocalDateTime(r10.adjustInto(this, r11));
    }
}
