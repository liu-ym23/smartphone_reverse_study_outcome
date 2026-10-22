package org.threeten.bp;

import com.blankj.utilcode.constant.CacheConstants;
import com.bytedance.apm.battery.config.BatteryFactorConfig;
import ig.c;
import ig.d;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import org.threeten.bp.format.DateTimeFormatter;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.Temporal;
import org.threeten.bp.temporal.TemporalAccessor;
import org.threeten.bp.temporal.TemporalAdjuster;
import org.threeten.bp.temporal.TemporalAmount;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.TemporalQuery;
import org.threeten.bp.temporal.TemporalUnit;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;
import org.threeten.bp.temporal.ValueRange;

/* JADX INFO: loaded from: classes4.dex */
public final class Instant extends c implements Temporal, TemporalAdjuster, Comparable<Instant>, Serializable {
    public static final Instant EPOCH = null;
    public static final TemporalQuery<Instant> FROM = null;
    public static final Instant MAX = null;
    private static final long MAX_SECOND = 31556889864403199L;
    private static final long MILLIS_PER_SEC = 1000;
    public static final Instant MIN = null;
    private static final long MIN_SECOND = -31557014167219200L;
    private static final int NANOS_PER_MILLI = 1000000;
    private static final int NANOS_PER_SECOND = 1000000000;
    private static final long serialVersionUID = -665713676816604388L;
    private final int nanos;
    private final long seconds;

    public static class a implements TemporalQuery {
        public a() {
        }

        public Instant a(TemporalAccessor r10) {
            return Instant.from(r10);
        }

        @Override // org.threeten.bp.temporal.TemporalQuery
        public /* bridge */ /* synthetic */ Object queryFrom(TemporalAccessor r10) {
            return a(r10);
        }
    }

    public static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f23067a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f23068b = null;

        static {
            int[] r10 = new int[ChronoUnit.values().length];
            f23068b = r10;
            r10[ChronoUnit.NANOS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L20
        L32:
            f23068b[ChronoUnit.MICROS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L21
        L38:
            f23068b[ChronoUnit.MILLIS.ordinal()] = 3;     // Catch: NoSuchFieldError -> L22
        L54:
            f23068b[ChronoUnit.SECONDS.ordinal()] = 4;     // Catch: NoSuchFieldError -> L23
        L34:
            f23068b[ChronoUnit.MINUTES.ordinal()] = 5;     // Catch: NoSuchFieldError -> L24
        L40:
            f23068b[ChronoUnit.HOURS.ordinal()] = 6;     // Catch: NoSuchFieldError -> L25
        L44:
            f23068b[ChronoUnit.HALF_DAYS.ordinal()] = 7;     // Catch: NoSuchFieldError -> L26
        L48:
            f23068b[ChronoUnit.DAYS.ordinal()] = 8;     // Catch: NoSuchFieldError -> L27
        L14:
            int[] r11 = new int[ChronoField.values().length];
            f23067a = r11;
            r11[ChronoField.NANO_OF_SECOND.ordinal()] = 1;     // Catch: NoSuchFieldError -> L28
        L42:
            f23067a[ChronoField.MICRO_OF_SECOND.ordinal()] = 2;     // Catch: NoSuchFieldError -> L29
        L46:
            f23067a[ChronoField.MILLI_OF_SECOND.ordinal()] = 3;     // Catch: NoSuchFieldError -> L30
        L36:
            f23067a[ChronoField.INSTANT_SECONDS.ordinal()] = 4;     // Catch: NoSuchFieldError -> L31
            return;
        }
    }

    static {
        EPOCH = new Instant(0, 0);
        MIN = ofEpochSecond(MIN_SECOND, 0);
        MAX = ofEpochSecond(MAX_SECOND, 999999999);
        FROM = new a();
    }

    private Instant(long r10, int r11) {
        this.seconds = r10;
        this.nanos = r11;
    }

    private static Instant create(long r10, int r11) {
        if ((((long) r11) | r10) != 0) goto L7;
        return EPOCH;
    L7:
        if (r10 < MIN_SECOND) goto L13;
        if (r10 > MAX_SECOND) goto L13;
        return new Instant(r10, r11);
    L13:
        throw new DateTimeException("Instant exceeds minimum or maximum instant");
    }

    public static Instant from(TemporalAccessor r10) {
        return ofEpochSecond(r10.getLong(ChronoField.INSTANT_SECONDS), r10.get(ChronoField.NANO_OF_SECOND));
    L4:
        e = move-exception;
        throw new DateTimeException("Unable to obtain Instant from TemporalAccessor: " + r10 + ", type " + r10.getClass().getName(), e);
    }

    private long nanosUntil(Instant r10) {
        return d.j(d.l(d.o(r10.seconds, this.seconds), NANOS_PER_SECOND), r10.nanos - this.nanos);
    }

    public static Instant now() {
        return Clock.systemUTC().instant();
    }

    public static Instant ofEpochMilli(long r10) {
        return create(d.d(r10, 1000), d.f(r10, 1000) * 1000000);
    }

    public static Instant ofEpochSecond(long r10) {
        return create(r10, 0);
    }

    public static Instant parse(CharSequence r10) {
        return (Instant) DateTimeFormatter.f23110t.n(r10, FROM);
    }

    public static Instant readExternal(DataInput r10) throws IOException {
        return ofEpochSecond(r10.readLong(), r10.readInt());
    }

    private Object readResolve() throws ObjectStreamException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private long secondsUntil(Instant r10) {
        long r11 = d.o(r10.seconds, this.seconds);
        long r12 = r10.nanos - this.nanos;
        if (r11 > 0) goto L5;
    L7:
        if (r11 < 0) goto L9;
        return r11;
    L9:
        if (r12 > 0) goto L11;
        return r11;
    L11:
        return r11 + 1;
    L5:
        if (r12 >= 0) goto L7;
        return r11 - 1;
    }

    private Object writeReplace() {
        return new Ser((byte) 2, this);
    }

    @Override // org.threeten.bp.temporal.TemporalAdjuster
    public Temporal adjustInto(Temporal r10) {
        return r10.with(ChronoField.INSTANT_SECONDS, this.seconds).with(ChronoField.NANO_OF_SECOND, this.nanos);
    }

    public OffsetDateTime atOffset(ZoneOffset r10) {
        return OffsetDateTime.ofInstant(this, r10);
    }

    public ZonedDateTime atZone(ZoneId r10) {
        return ZonedDateTime.ofInstant(this, r10);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Instant r10) {
        return compareTo2(r10);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof Instant) == false) goto L14;
        Instant r11 = (Instant) r10;
        if (this.seconds != r11.seconds) goto L13;
        if (this.nanos != r11.nanos) goto L13;
        return true;
    L13:
        return false;
    L14:
        return false;
    }

    @Override // ig.c, org.threeten.bp.temporal.TemporalAccessor
    public int get(TemporalField r10) {
        if ((r10 instanceof ChronoField) == false) goto L19;
        int r11 = b.f23067a[((ChronoField) r10).ordinal()];
        if (r11 == 1) goto L17;
        if (r11 == 2) goto L15;
        if (r11 != 3) goto L13;
        return this.nanos / 1000000;
    L13:
        throw new UnsupportedTemporalTypeException("Unsupported field: " + r10);
    L15:
        return this.nanos / 1000;
    L17:
        return this.nanos;
    L19:
        return range(r10).checkValidIntValue(r10.getFrom(this), r10);
    }

    public long getEpochSecond() {
        return this.seconds;
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public long getLong(TemporalField r10) {
        if ((r10 instanceof ChronoField) == false) goto L22;
        int r11 = b.f23067a[((ChronoField) r10).ordinal()];
        if (r11 != 1) goto L7;
        int r12 = this.nanos;
    L18:
        return r12;
    L7:
        if (r11 != 2) goto L9;
        r12 = this.nanos / 1000;
        goto L18
    L9:
        if (r11 != 3) goto L11;
        r12 = this.nanos / 1000000;
        goto L18
    L11:
        if (r11 != 4) goto L15;
        return this.seconds;
    L15:
        throw new UnsupportedTemporalTypeException("Unsupported field: " + r10);
    L22:
        return r10.getFrom(this);
    }

    public int getNano() {
        return this.nanos;
    }

    public int hashCode() {
        long r10 = this.seconds;
        return ((int) (r10 ^ (r10 >>> 32))) + (this.nanos * 51);
    }

    public boolean isAfter(Instant r10) {
        if (compareTo2(r10) <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isBefore(Instant r10) {
        if (compareTo2(r10) >= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public boolean isSupported(TemporalField r10) {
        if ((r10 instanceof ChronoField) == true) goto L5;
        if (r10 == null) goto L20;
        if (r10.isSupportedBy(this) == false) goto L20;
        return true;
    L20:
        return false;
    L5:
        if (r10 != ChronoField.INSTANT_SECONDS) goto L7;
        return true;
    L7:
        if (r10 != ChronoField.NANO_OF_SECOND) goto L9;
        return true;
    L9:
        if (r10 != ChronoField.MICRO_OF_SECOND) goto L11;
        return true;
    L11:
        if (r10 != ChronoField.MILLI_OF_SECOND) goto L14;
        return true;
    L14:
        return false;
    }

    @Override // org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ Temporal minus(long r10, TemporalUnit r11) {
        return minus(r10, r11);
    }

    public Instant minusMillis(long r10) {
        if (r10 != Long.MIN_VALUE) goto L7;
        return plusMillis(Long.MAX_VALUE).plusMillis(1);
    L7:
        return plusMillis(-r10);
    }

    public Instant minusNanos(long r10) {
        if (r10 != Long.MIN_VALUE) goto L7;
        return plusNanos(Long.MAX_VALUE).plusNanos(1);
    L7:
        return plusNanos(-r10);
    }

    public Instant minusSeconds(long r10) {
        if (r10 != Long.MIN_VALUE) goto L7;
        return plusSeconds(Long.MAX_VALUE).plusSeconds(1);
    L7:
        return plusSeconds(-r10);
    }

    @Override // org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ Temporal plus(long r10, TemporalUnit r11) {
        return plus(r10, r11);
    }

    public Instant plusMillis(long r10) {
        return plus(r10 / 1000, (r10 % 1000) * BatteryFactorConfig.WIFI_BPS);
    }

    public Instant plusNanos(long r10) {
        return plus(0, r10);
    }

    public Instant plusSeconds(long r10) {
        return plus(r10, 0);
    }

    @Override // ig.c, org.threeten.bp.temporal.TemporalAccessor
    public <R> R query(TemporalQuery<R> r10) {
        if (r10 != org.threeten.bp.temporal.b.e()) goto L7;
        return (R) ChronoUnit.NANOS;
    L7:
        if (r10 != org.threeten.bp.temporal.b.b()) goto L9;
        return null;
    L9:
        if (r10 != org.threeten.bp.temporal.b.c()) goto L11;
        return null;
    L11:
        if (r10 != org.threeten.bp.temporal.b.a()) goto L13;
        return null;
    L13:
        if (r10 != org.threeten.bp.temporal.b.g()) goto L15;
        return null;
    L15:
        if (r10 != org.threeten.bp.temporal.b.f()) goto L17;
        return null;
    L17:
        if (r10 != org.threeten.bp.temporal.b.d()) goto L20;
        return null;
    L20:
        return r10.queryFrom(this);
    }

    @Override // ig.c, org.threeten.bp.temporal.TemporalAccessor
    public ValueRange range(TemporalField r10) {
        return super.range(r10);
    }

    public long toEpochMilli() {
        long r10 = this.seconds;
        if (r10 < 0) goto L7;
        return d.j(d.m(r10, 1000), this.nanos / 1000000);
    L7:
        return d.o(d.m(r10 + 1, 1000), 1000 - ((long) (this.nanos / 1000000)));
    }

    public String toString() {
        return DateTimeFormatter.f23110t.d(this);
    }

    public Instant truncatedTo(TemporalUnit r10) {
        if (r10 != ChronoUnit.NANOS) goto L5;
        return this;
    L5:
        Duration r11 = r10.getDuration();
        if (r11.getSeconds() > 86400) goto L14;
        long r12 = r11.toNanos();
        if ((86400000000000L % r12) != 0) goto L12;
        long r13 = ((this.seconds % 86400) * 1000000000) + ((long) this.nanos);
        return plusNanos((d.d(r13, r12) * r12) - r13);
    L12:
        throw new DateTimeException("Unit must divide into a standard day without remainder");
    L14:
        throw new DateTimeException("Unit is too large to be used for truncation");
    }

    @Override // org.threeten.bp.temporal.Temporal
    public long until(Temporal r10, TemporalUnit r11) {
        Instant r12 = from(r10);
        if ((r11 instanceof ChronoUnit) == false) goto L25;
        switch(b.f23068b[((ChronoUnit) r11).ordinal()]) {
            case 1: goto L23;
            case 2: goto L21;
            case 3: goto L19;
            case 4: goto L17;
            case 5: goto L15;
            case 6: goto L13;
            case 7: goto L11;
            case 8: goto L9;
            default: goto L7;
        };
    L7:
        throw new UnsupportedTemporalTypeException("Unsupported unit: " + r11);
    L9:
        return secondsUntil(r12) / 86400;
    L11:
        return secondsUntil(r12) / 43200;
    L13:
        return secondsUntil(r12) / 3600;
    L15:
        return secondsUntil(r12) / 60;
    L17:
        return secondsUntil(r12);
    L19:
        return d.o(r12.toEpochMilli(), toEpochMilli());
    L21:
        return nanosUntil(r12) / 1000;
    L23:
        return nanosUntil(r12);
    L25:
        return r11.between(this, r12);
    }

    @Override // org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ Temporal with(TemporalAdjuster r10) {
        return with(r10);
    }

    public void writeExternal(DataOutput r10) throws IOException {
        r10.writeLong(this.seconds);
        r10.writeInt(this.nanos);
    }

    public static Instant now(Clock r10) {
        d.h(r10, "clock");
        return r10.instant();
    }

    public static Instant ofEpochSecond(long r10, long r11) {
        return create(d.j(r10, d.d(r11, 1000000000)), d.f(r11, NANOS_PER_SECOND));
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(Instant r10) {
        int r11 = d.b(this.seconds, r10.seconds);
        if (r11 == 0) goto L6;
        return r11;
    L6:
        return this.nanos - r10.nanos;
    }

    @Override // org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ Temporal minus(TemporalAmount r10) {
        return minus(r10);
    }

    @Override // org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ Temporal plus(TemporalAmount r10) {
        return plus(r10);
    }

    @Override // org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ Temporal with(TemporalField r10, long r11) {
        return with(r10, r11);
    }

    @Override // org.threeten.bp.temporal.Temporal
    public Instant minus(TemporalAmount r10) {
        return (Instant) r10.subtractFrom(this);
    }

    @Override // org.threeten.bp.temporal.Temporal
    public Instant plus(TemporalAmount r10) {
        return (Instant) r10.addTo(this);
    }

    @Override // org.threeten.bp.temporal.Temporal
    public Instant with(TemporalAdjuster r10) {
        return (Instant) r10.adjustInto(this);
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
        if (r10.isTimeBased() == false) goto L7;
        return true;
    L7:
        if (r10 != ChronoUnit.DAYS) goto L10;
        return true;
    L10:
        return false;
    }

    @Override // org.threeten.bp.temporal.Temporal
    public Instant minus(long r10, TemporalUnit r11) {
        if (r10 != Long.MIN_VALUE) goto L6;
        Instant this = plus(Long.MAX_VALUE, r11);
        long r12 = 1;
    L7:
        return this.plus(r12, r11);
    L6:
        r12 = -r10;
        goto L7
    }

    @Override // org.threeten.bp.temporal.Temporal
    public Instant plus(long r10, TemporalUnit r11) {
        if ((r11 instanceof ChronoUnit) == false) goto L25;
        switch(b.f23068b[((ChronoUnit) r11).ordinal()]) {
            case 1: goto L23;
            case 2: goto L21;
            case 3: goto L19;
            case 4: goto L17;
            case 5: goto L15;
            case 6: goto L13;
            case 7: goto L11;
            case 8: goto L9;
            default: goto L7;
        };
    L7:
        throw new UnsupportedTemporalTypeException("Unsupported unit: " + r11);
    L9:
        return plusSeconds(d.l(r10, CacheConstants.DAY));
    L11:
        return plusSeconds(d.l(r10, 43200));
    L13:
        return plusSeconds(d.l(r10, CacheConstants.HOUR));
    L15:
        return plusSeconds(d.l(r10, 60));
    L17:
        return plusSeconds(r10);
    L19:
        return plusMillis(r10);
    L21:
        return plus(r10 / BatteryFactorConfig.WIFI_BPS, (r10 % BatteryFactorConfig.WIFI_BPS) * 1000);
    L23:
        return plusNanos(r10);
    L25:
        return (Instant) r11.addTo(this, r10);
    }

    @Override // org.threeten.bp.temporal.Temporal
    public Instant with(TemporalField r10, long r11) {
        if ((r10 instanceof ChronoField) == false) goto L31;
        ChronoField r12 = (ChronoField) r10;
        r12.checkValidValue(r11);
        int r13 = b.f23067a[r12.ordinal()];
        if (r13 == 1) goto L27;
        if (r13 != 2) goto L9;
        int r14 = ((int) r11) * 1000;
        if (r14 != this.nanos) goto L25;
        return this;
    L25:
        return create(this.seconds, r14);
    L9:
        if (r13 != 3) goto L11;
        int r15 = ((int) r11) * 1000000;
        if (r15 != this.nanos) goto L21;
        return this;
    L21:
        return create(this.seconds, r15);
    L11:
        if (r13 != 4) goto L17;
        if (r11 != this.seconds) goto L15;
        return this;
    L15:
        return create(r11, this.nanos);
    L17:
        throw new UnsupportedTemporalTypeException("Unsupported field: " + r10);
    L27:
        if (r11 != this.nanos) goto L29;
        return this;
    L29:
        return create(this.seconds, (int) r11);
    L31:
        return (Instant) r10.adjustInto(this, r11);
    }

    private Instant plus(long r10, long r11) {
        if ((r10 | r11) != 0) goto L6;
        return this;
    L6:
        return ofEpochSecond(d.j(d.j(this.seconds, r10), r11 / 1000000000), this.nanos + (r11 % 1000000000));
    }
}
