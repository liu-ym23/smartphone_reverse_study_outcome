package org.threeten.bp;

import com.bytedance.apm.battery.config.BatteryFactorConfig;
import com.bytedanceos.common.ad.param.AdReportParam;
import com.google.common.base.Ascii;
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
public final class LocalTime extends c implements Temporal, TemporalAdjuster, Comparable<LocalTime>, Serializable {
    public static final TemporalQuery<LocalTime> FROM = null;
    private static final LocalTime[] HOURS = null;
    static final int HOURS_PER_DAY = 24;
    public static final LocalTime MAX = null;
    static final long MICROS_PER_DAY = 86400000000L;
    public static final LocalTime MIDNIGHT = null;
    static final long MILLIS_PER_DAY = 86400000;
    public static final LocalTime MIN = null;
    static final int MINUTES_PER_DAY = 1440;
    static final int MINUTES_PER_HOUR = 60;
    static final long NANOS_PER_DAY = 86400000000000L;
    static final long NANOS_PER_HOUR = 3600000000000L;
    static final long NANOS_PER_MINUTE = 60000000000L;
    static final long NANOS_PER_SECOND = 1000000000;
    public static final LocalTime NOON = null;
    static final int SECONDS_PER_DAY = 86400;
    static final int SECONDS_PER_HOUR = 3600;
    static final int SECONDS_PER_MINUTE = 60;
    private static final long serialVersionUID = 6414437269572265201L;
    private final byte hour;
    private final byte minute;
    private final int nano;
    private final byte second;

    public static class a implements TemporalQuery {
        public a() {
        }

        public LocalTime a(TemporalAccessor r10) {
            return LocalTime.from(r10);
        }

        @Override // org.threeten.bp.temporal.TemporalQuery
        public /* bridge */ /* synthetic */ Object queryFrom(TemporalAccessor r10) {
            return a(r10);
        }
    }

    public static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f23072a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f23073b = null;

        static {
            int[] r10 = new int[ChronoUnit.values().length];
            f23073b = r10;
            r10[ChronoUnit.NANOS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L33
        L81:
            f23073b[ChronoUnit.MICROS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L34
        L61:
            f23073b[ChronoUnit.MILLIS.ordinal()] = 3;     // Catch: NoSuchFieldError -> L35
        L77:
            f23073b[ChronoUnit.SECONDS.ordinal()] = 4;     // Catch: NoSuchFieldError -> L36
        L83:
            f23073b[ChronoUnit.MINUTES.ordinal()] = 5;     // Catch: NoSuchFieldError -> L37
        L65:
            f23073b[ChronoUnit.HOURS.ordinal()] = 6;     // Catch: NoSuchFieldError -> L38
        L67:
            f23073b[ChronoUnit.HALF_DAYS.ordinal()] = 7;     // Catch: NoSuchFieldError -> L39
        L16:
            int[] r11 = new int[ChronoField.values().length];
            f23072a = r11;
            r11[ChronoField.NANO_OF_SECOND.ordinal()] = 1;     // Catch: NoSuchFieldError -> L40
        L59:
            f23072a[ChronoField.NANO_OF_DAY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L41
        L87:
            f23072a[ChronoField.MICRO_OF_SECOND.ordinal()] = 3;     // Catch: NoSuchFieldError -> L42
        L97:
            f23072a[ChronoField.MICRO_OF_DAY.ordinal()] = 4;     // Catch: NoSuchFieldError -> L43
        L57:
            f23072a[ChronoField.MILLI_OF_SECOND.ordinal()] = 5;     // Catch: NoSuchFieldError -> L44
        L71:
            f23072a[ChronoField.MILLI_OF_DAY.ordinal()] = 6;     // Catch: NoSuchFieldError -> L45
        L95:
            f23072a[ChronoField.SECOND_OF_MINUTE.ordinal()] = 7;     // Catch: NoSuchFieldError -> L46
        L55:
            f23072a[ChronoField.SECOND_OF_DAY.ordinal()] = 8;     // Catch: NoSuchFieldError -> L47
        L85:
            f23072a[ChronoField.MINUTE_OF_HOUR.ordinal()] = 9;     // Catch: NoSuchFieldError -> L48
        L89:
            f23072a[ChronoField.MINUTE_OF_DAY.ordinal()] = 10;     // Catch: NoSuchFieldError -> L49
        L73:
            f23072a[ChronoField.HOUR_OF_AMPM.ordinal()] = 11;     // Catch: NoSuchFieldError -> L50
        L79:
            f23072a[ChronoField.CLOCK_HOUR_OF_AMPM.ordinal()] = 12;     // Catch: NoSuchFieldError -> L51
        L63:
            f23072a[ChronoField.HOUR_OF_DAY.ordinal()] = 13;     // Catch: NoSuchFieldError -> L52
        L69:
            f23072a[ChronoField.CLOCK_HOUR_OF_DAY.ordinal()] = 14;     // Catch: NoSuchFieldError -> L53
        L93:
            f23072a[ChronoField.AMPM_OF_DAY.ordinal()] = 15;     // Catch: NoSuchFieldError -> L54
            return;
        }
    }

    static {
        FROM = new a();
        HOURS = new LocalTime[24];
        int r10 = 0;
    L3:
        LocalTime[] r11 = HOURS;
        if (r10 >= r11.length) goto L6;
        r11[r10] = new LocalTime(r10, 0, 0, 0);
        r10 = r10 + 1;
        goto L3
    L6:
        LocalTime r12 = r11[0];
        MIDNIGHT = r12;
        NOON = r11[12];
        MIN = r12;
        MAX = new LocalTime(23, 59, 59, Year.MAX_VALUE);
    }

    private LocalTime(int r10, int r11, int r12, int r13) {
        this.hour = (byte) r10;
        this.minute = (byte) r11;
        this.second = (byte) r12;
        this.nano = r13;
    }

    private static LocalTime create(int r10, int r11, int r12, int r13) {
        if (((r11 | r12) | r13) != 0) goto L7;
        return HOURS[r10];
    L7:
        return new LocalTime(r10, r11, r12, r13);
    }

    public static LocalTime from(TemporalAccessor r10) {
        LocalTime r11 = (LocalTime) r10.query(org.threeten.bp.temporal.b.c());
        if (r11 == null) goto L6;
        return r11;
    L6:
        throw new DateTimeException("Unable to obtain LocalTime from TemporalAccessor: " + r10 + ", type " + r10.getClass().getName());
    }

    private int get0(TemporalField r10) {
        switch(b.f23072a[((ChronoField) r10).ordinal()]) {
            case 1: goto L40;
            case 2: goto L38;
            case 3: goto L36;
            case 4: goto L34;
            case 5: goto L32;
            case 6: goto L30;
            case 7: goto L28;
            case 8: goto L26;
            case 9: goto L24;
            case 10: goto L22;
            case 11: goto L20;
            case 12: goto L14;
            case 13: goto L13;
            case 14: goto L8;
            case 15: goto L7;
            default: goto L5;
        };
    L8:
        byte r11 = this.hour;
        if (r11 != 0) goto L41;
        return 24;
    L41:
        return r11;
    L14:
        int r12 = this.hour % Ascii.FF;
        if ((r12 % 12) != 0) goto L18;
        return 12;
    L18:
        return r12;
    L5:
        throw new UnsupportedTemporalTypeException("Unsupported field: " + r10);
    L7:
        return this.hour / Ascii.FF;
    L13:
        return this.hour;
    L20:
        return this.hour % Ascii.FF;
    L22:
        return (this.hour * 60) + this.minute;
    L24:
        return this.minute;
    L26:
        return toSecondOfDay();
    L28:
        return this.second;
    L30:
        return (int) (toNanoOfDay() / BatteryFactorConfig.WIFI_BPS);
    L32:
        return this.nano / 1000000;
    L34:
        throw new DateTimeException("Field too large for an int: " + r10);
    L36:
        return this.nano / 1000;
    L38:
        throw new DateTimeException("Field too large for an int: " + r10);
    L40:
        return this.nano;
    }

    public static LocalTime now() {
        return now(Clock.systemDefaultZone());
    }

    public static LocalTime of(int r10, int r11) {
        ChronoField.HOUR_OF_DAY.checkValidValue(r10);
        if (r11 == 0) goto L5;
        ChronoField.MINUTE_OF_HOUR.checkValidValue(r11);
        return new LocalTime(r10, r11, 0, 0);
    L5:
        return HOURS[r10];
    }

    public static LocalTime ofNanoOfDay(long r10) {
        ChronoField.NANO_OF_DAY.checkValidValue(r10);
        int r11 = (int) (r10 / NANOS_PER_HOUR);
        long r12 = r10 - (((long) r11) * NANOS_PER_HOUR);
        int r13 = (int) (r12 / NANOS_PER_MINUTE);
        long r14 = r12 - (((long) r13) * NANOS_PER_MINUTE);
        int r15 = (int) (r14 / NANOS_PER_SECOND);
        return create(r11, r13, r15, (int) (r14 - (((long) r15) * NANOS_PER_SECOND)));
    }

    public static LocalTime ofSecondOfDay(long r10) {
        ChronoField.SECOND_OF_DAY.checkValidValue(r10);
        int r11 = (int) (r10 / 3600);
        long r12 = r10 - ((long) (r11 * 3600));
        int r13 = (int) (r12 / 60);
        return create(r11, r13, (int) (r12 - ((long) (r13 * 60))), 0);
    }

    public static LocalTime parse(CharSequence r10) {
        return parse(r10, DateTimeFormatter.f23101k);
    }

    public static LocalTime readExternal(DataInput r10) throws IOException {
        int r11 = r10.readByte();
        int r12 = 0;
        if (r11 >= 0) goto L5;
        r11 = ~r11;
        int r13 = 0;
        int r14 = 0;
    L14:
        return of(r11, r12, r13, r14);
    L5:
        byte r15 = r10.readByte();
        if (r15 >= 0) goto L8;
        int r16 = ~r15;
        r14 = 0;
        r12 = r16;
        r13 = 0;
        goto L14
    L8:
        byte r17 = r10.readByte();
        if (r17 >= 0) goto L12;
        r13 = ~r17;
    L11:
        r14 = r12;
        r12 = r15;
        goto L14
    L12:
        r12 = r10.readInt();
        r13 = r17;
        goto L11
    }

    private Object readResolve() throws ObjectStreamException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new Ser((byte) 5, this);
    }

    @Override // org.threeten.bp.temporal.TemporalAdjuster
    public Temporal adjustInto(Temporal r10) {
        return r10.with(ChronoField.NANO_OF_DAY, toNanoOfDay());
    }

    public LocalDateTime atDate(LocalDate r10) {
        return LocalDateTime.of(r10, this);
    }

    public OffsetTime atOffset(ZoneOffset r10) {
        return OffsetTime.of(this, r10);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(LocalTime r10) {
        return compareTo2(r10);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof LocalTime) == false) goto L18;
        LocalTime r11 = (LocalTime) r10;
        if (this.hour != r11.hour) goto L17;
        if (this.minute != r11.minute) goto L17;
        if (this.second != r11.second) goto L17;
        if (this.nano != r11.nano) goto L17;
        return true;
    L17:
        return false;
    L18:
        return false;
    }

    public String format(DateTimeFormatter r10) {
        d.h(r10, "formatter");
        return r10.d(this);
    }

    @Override // ig.c, org.threeten.bp.temporal.TemporalAccessor
    public int get(TemporalField r10) {
        if ((r10 instanceof ChronoField) == false) goto L7;
        return get0(r10);
    L7:
        return super.get(r10);
    }

    public int getHour() {
        return this.hour;
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public long getLong(TemporalField r10) {
        if ((r10 instanceof ChronoField) == false) goto L15;
        if (r10 != ChronoField.NANO_OF_DAY) goto L9;
        return toNanoOfDay();
    L9:
        if (r10 != ChronoField.MICRO_OF_DAY) goto L13;
        return toNanoOfDay() / 1000;
    L13:
        return get0(r10);
    L15:
        return r10.getFrom(this);
    }

    public int getMinute() {
        return this.minute;
    }

    public int getNano() {
        return this.nano;
    }

    public int getSecond() {
        return this.second;
    }

    public int hashCode() {
        long r10 = toNanoOfDay();
        return (int) (r10 ^ (r10 >>> 32));
    }

    public boolean isAfter(LocalTime r10) {
        if (compareTo2(r10) <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isBefore(LocalTime r10) {
        if (compareTo2(r10) >= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public boolean isSupported(TemporalField r10) {
        if ((r10 instanceof ChronoField) == true) goto L5;
        if (r10 != null) goto L8;
    L10:
        return false;
    L8:
        if (r10.isSupportedBy(this) == false) goto L10;
        return true;
    L5:
        return r10.isTimeBased();
    }

    @Override // org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ Temporal minus(long r10, TemporalUnit r11) {
        return minus(r10, r11);
    }

    public LocalTime minusHours(long r10) {
        return plusHours(-(r10 % 24));
    }

    public LocalTime minusMinutes(long r10) {
        return plusMinutes(-(r10 % 1440));
    }

    public LocalTime minusNanos(long r10) {
        return plusNanos(-(r10 % NANOS_PER_DAY));
    }

    public LocalTime minusSeconds(long r10) {
        return plusSeconds(-(r10 % 86400));
    }

    @Override // org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ Temporal plus(long r10, TemporalUnit r11) {
        return plus(r10, r11);
    }

    public LocalTime plusHours(long r10) {
        if (r10 != 0) goto L6;
        return this;
    L6:
        return create(((((int) (r10 % 24)) + this.hour) + 24) % 24, this.minute, this.second, this.nano);
    }

    public LocalTime plusMinutes(long r10) {
        if (r10 != 0) goto L5;
        return this;
    L5:
        int r11 = (this.hour * 60) + this.minute;
        int r12 = ((((int) (r10 % 1440)) + r11) + MINUTES_PER_DAY) % MINUTES_PER_DAY;
        if (r11 != r12) goto L9;
        return this;
    L9:
        return create(r12 / 60, r12 % 60, this.second, this.nano);
    }

    public LocalTime plusNanos(long r10) {
        if (r10 != 0) goto L5;
        return this;
    L5:
        long r11 = toNanoOfDay();
        long r12 = (((r10 % NANOS_PER_DAY) + r11) + NANOS_PER_DAY) % NANOS_PER_DAY;
        if (r11 != r12) goto L9;
        return this;
    L9:
        return create((int) (r12 / NANOS_PER_HOUR), (int) ((r12 / NANOS_PER_MINUTE) % 60), (int) ((r12 / NANOS_PER_SECOND) % 60), (int) (r12 % NANOS_PER_SECOND));
    }

    public LocalTime plusSeconds(long r10) {
        if (r10 != 0) goto L5;
        return this;
    L5:
        int r11 = ((this.hour * Ascii.DLE) + (this.minute * 60)) + this.second;
        int r12 = ((((int) (r10 % 86400)) + r11) + 86400) % 86400;
        if (r11 != r12) goto L9;
        return this;
    L9:
        return create(r12 / 3600, (r12 / 60) % 60, r12 % 60, this.nano);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // ig.c, org.threeten.bp.temporal.TemporalAccessor
    public <R> R query(TemporalQuery<R> r10) {
        if (r10 != org.threeten.bp.temporal.b.e()) goto L7;
        return (R) ChronoUnit.NANOS;
    L7:
        if (r10 != org.threeten.bp.temporal.b.c()) goto L10;
        return this;
    L10:
        if (r10 != org.threeten.bp.temporal.b.a()) goto L12;
        return null;
    L12:
        if (r10 != org.threeten.bp.temporal.b.g()) goto L14;
        return null;
    L14:
        if (r10 != org.threeten.bp.temporal.b.f()) goto L16;
        return null;
    L16:
        if (r10 != org.threeten.bp.temporal.b.d()) goto L18;
        return null;
    L18:
        if (r10 != org.threeten.bp.temporal.b.b()) goto L21;
        return null;
    L21:
        return r10.queryFrom(this);
    }

    @Override // ig.c, org.threeten.bp.temporal.TemporalAccessor
    public ValueRange range(TemporalField r10) {
        return super.range(r10);
    }

    public long toNanoOfDay() {
        return (((((long) this.hour) * NANOS_PER_HOUR) + (((long) this.minute) * NANOS_PER_MINUTE)) + (((long) this.second) * NANOS_PER_SECOND)) + ((long) this.nano);
    }

    public int toSecondOfDay() {
        return ((this.hour * Ascii.DLE) + (this.minute * 60)) + this.second;
    }

    public String toString() {
        StringBuilder r10 = new StringBuilder(18);
        byte r11 = this.hour;
        byte r12 = this.minute;
        byte r13 = this.second;
        int r14 = this.nano;
        if (r11 >= 10) goto L5;
        String r15 = AdReportParam.ClickPosType.SKIP;
    L6:
        r10.append(r15);
        r10.append(r11);
        String r16 = ":";
        if (r12 >= 10) goto L9;
        String r17 = ":0";
    L10:
        r10.append(r17);
        r10.append(r12);
        if (r13 > 0) goto L13;
        if (r14 > 0) goto L13;
    L25:
        return r10.toString();
    L13:
        if (r13 >= 10) goto L15;
        r16 = ":0";
    L15:
        r10.append(r16);
        r10.append(r13);
        if (r14 <= 0) goto L25;
        r10.append('.');
        if ((r14 % 1000000) != 0) goto L21;
        r10.append(Integer.toString((r14 / 1000000) + 1000).substring(1));
        goto L25
    L21:
        if ((r14 % 1000) != 0) goto L23;
        r10.append(Integer.toString((r14 / 1000) + 1000000).substring(1));
        goto L25
    L23:
        r10.append(Integer.toString(r14 + 1000000000).substring(1));
        goto L25
    L9:
        r17 = ":";
        goto L10
    L5:
        r15 = "";
        goto L6
    }

    public LocalTime truncatedTo(TemporalUnit r10) {
        if (r10 != ChronoUnit.NANOS) goto L5;
        return this;
    L5:
        Duration r11 = r10.getDuration();
        if (r11.getSeconds() > 86400) goto L14;
        long r12 = r11.toNanos();
        if ((NANOS_PER_DAY % r12) != 0) goto L12;
        return ofNanoOfDay((toNanoOfDay() / r12) * r12);
    L12:
        throw new DateTimeException("Unit must divide into a standard day without remainder");
    L14:
        throw new DateTimeException("Unit is too large to be used for truncation");
    }

    @Override // org.threeten.bp.temporal.Temporal
    public long until(Temporal r10, TemporalUnit r11) {
        LocalTime r12 = from(r10);
        if ((r11 instanceof ChronoUnit) == false) goto L21;
        long r13 = r12.toNanoOfDay() - toNanoOfDay();
        switch(b.f23073b[((ChronoUnit) r11).ordinal()]) {
            case 1: goto L22;
            case 2: goto L19;
            case 3: goto L17;
            case 4: goto L15;
            case 5: goto L13;
            case 6: goto L11;
            case 7: goto L9;
            default: goto L7;
        };
    L22:
        return r13;
    L7:
        throw new UnsupportedTemporalTypeException("Unsupported unit: " + r11);
    L9:
        return r13 / 43200000000000L;
    L11:
        return r13 / NANOS_PER_HOUR;
    L13:
        return r13 / NANOS_PER_MINUTE;
    L15:
        return r13 / NANOS_PER_SECOND;
    L17:
        return r13 / BatteryFactorConfig.WIFI_BPS;
    L19:
        return r13 / 1000;
    L21:
        return r11.between(this, r12);
    }

    @Override // org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ Temporal with(TemporalAdjuster r10) {
        return with(r10);
    }

    public LocalTime withHour(int r10) {
        if (this.hour != r10) goto L5;
        return this;
    L5:
        ChronoField.HOUR_OF_DAY.checkValidValue(r10);
        return create(r10, this.minute, this.second, this.nano);
    }

    public LocalTime withMinute(int r10) {
        if (this.minute != r10) goto L5;
        return this;
    L5:
        ChronoField.MINUTE_OF_HOUR.checkValidValue(r10);
        return create(this.hour, r10, this.second, this.nano);
    }

    public LocalTime withNano(int r10) {
        if (this.nano != r10) goto L5;
        return this;
    L5:
        ChronoField.NANO_OF_SECOND.checkValidValue(r10);
        return create(this.hour, this.minute, this.second, r10);
    }

    public LocalTime withSecond(int r10) {
        if (this.second != r10) goto L5;
        return this;
    L5:
        ChronoField.SECOND_OF_MINUTE.checkValidValue(r10);
        return create(this.hour, this.minute, r10, this.nano);
    }

    public void writeExternal(DataOutput r10) throws IOException {
        if (this.nano == 0) goto L5;
        r10.writeByte(this.hour);
        r10.writeByte(this.minute);
        r10.writeByte(this.second);
        r10.writeInt(this.nano);
        return;
    L5:
        if (this.second == 0) goto L7;
        r10.writeByte(this.hour);
        r10.writeByte(this.minute);
        r10.writeByte(~this.second);
        return;
    L7:
        if (this.minute != 0) goto L9;
        r10.writeByte(~this.hour);
        return;
    L9:
        r10.writeByte(this.hour);
        r10.writeByte(~this.minute);
    }

    public static LocalTime now(ZoneId r10) {
        return now(Clock.system(r10));
    }

    public static LocalTime parse(CharSequence r10, DateTimeFormatter r11) {
        d.h(r11, "formatter");
        return (LocalTime) r11.n(r10, FROM);
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(LocalTime r10) {
        int r11 = d.a(this.hour, r10.hour);
        if (r11 != 0) goto L10;
        int r12 = d.a(this.minute, r10.minute);
        if (r12 != 0) goto L11;
        int r13 = d.a(this.second, r10.second);
        if (r13 == 0) goto L9;
        return r13;
    L9:
        return d.a(this.nano, r10.nano);
    L11:
        return r12;
    L10:
        return r11;
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

    public static LocalTime now(Clock r10) {
        d.h(r10, "clock");
        Instant r11 = r10.instant();
        ZoneOffset r12 = r10.getZone().getRules().getOffset(r11);
        long r13 = ((r11.getEpochSecond() % 86400) + ((long) r12.getTotalSeconds())) % 86400;
        if (r13 >= 0) goto L6;
        r13 = r13 + 86400;
    L6:
        return ofSecondOfDay(r13, r11.getNano());
    }

    @Override // org.threeten.bp.temporal.Temporal
    public LocalTime minus(TemporalAmount r10) {
        return (LocalTime) r10.subtractFrom(this);
    }

    @Override // org.threeten.bp.temporal.Temporal
    public LocalTime plus(TemporalAmount r10) {
        return (LocalTime) r10.addTo(this);
    }

    @Override // org.threeten.bp.temporal.Temporal
    public LocalTime with(TemporalAdjuster r10) {
        if ((r10 instanceof LocalTime) == false) goto L7;
        return (LocalTime) r10;
    L7:
        return (LocalTime) r10.adjustInto(this);
    }

    @Override // org.threeten.bp.temporal.Temporal
    public boolean isSupported(TemporalUnit r10) {
        if ((r10 instanceof ChronoUnit) == true) goto L5;
        if (r10 != null) goto L8;
    L10:
        return false;
    L8:
        if (r10.isSupportedBy(this) == false) goto L10;
        return true;
    L5:
        return r10.isTimeBased();
    }

    @Override // org.threeten.bp.temporal.Temporal
    public LocalTime minus(long r10, TemporalUnit r11) {
        if (r10 != Long.MIN_VALUE) goto L6;
        LocalTime this = plus(Long.MAX_VALUE, r11);
        long r12 = 1;
    L7:
        return this.plus(r12, r11);
    L6:
        r12 = -r10;
        goto L7
    }

    @Override // org.threeten.bp.temporal.Temporal
    public LocalTime plus(long r10, TemporalUnit r11) {
        if ((r11 instanceof ChronoUnit) == false) goto L23;
        switch(b.f23073b[((ChronoUnit) r11).ordinal()]) {
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
        throw new UnsupportedTemporalTypeException("Unsupported unit: " + r11);
    L9:
        return plusHours((r10 % 2) * 12);
    L11:
        return plusHours(r10);
    L13:
        return plusMinutes(r10);
    L15:
        return plusSeconds(r10);
    L17:
        return plusNanos((r10 % 86400000) * BatteryFactorConfig.WIFI_BPS);
    L19:
        return plusNanos((r10 % MICROS_PER_DAY) * 1000);
    L21:
        return plusNanos(r10);
    L23:
        return (LocalTime) r11.addTo(this, r10);
    }

    public static LocalTime of(int r10, int r11, int r12) {
        ChronoField.HOUR_OF_DAY.checkValidValue(r10);
        if ((r11 | r12) == 0) goto L5;
        ChronoField.MINUTE_OF_HOUR.checkValidValue(r11);
        ChronoField.SECOND_OF_MINUTE.checkValidValue(r12);
        return new LocalTime(r10, r11, r12, 0);
    L5:
        return HOURS[r10];
    }

    public static LocalTime ofSecondOfDay(long r10, int r11) {
        ChronoField.SECOND_OF_DAY.checkValidValue(r10);
        ChronoField.NANO_OF_SECOND.checkValidValue(r11);
        int r12 = (int) (r10 / 3600);
        long r13 = r10 - ((long) (r12 * 3600));
        int r14 = (int) (r13 / 60);
        return create(r12, r14, (int) (r13 - ((long) (r14 * 60))), r11);
    }

    @Override // org.threeten.bp.temporal.Temporal
    public LocalTime with(TemporalField r10, long r11) {
        if ((r10 instanceof ChronoField) == false) goto L45;
        ChronoField r12 = (ChronoField) r10;
        r12.checkValidValue(r11);
        switch(b.f23072a[r12.ordinal()]) {
            case 1: goto L43;
            case 2: goto L41;
            case 3: goto L39;
            case 4: goto L37;
            case 5: goto L35;
            case 6: goto L33;
            case 7: goto L31;
            case 8: goto L29;
            case 9: goto L27;
            case 10: goto L25;
            case 11: goto L23;
            case 12: goto L18;
            case 13: goto L16;
            case 14: goto L11;
            case 15: goto L9;
            default: goto L7;
        };
    L7:
        throw new UnsupportedTemporalTypeException("Unsupported field: " + r10);
    L9:
        return plusHours((r11 - ((long) (this.hour / Ascii.FF))) * 12);
    L11:
        if (r11 != 24) goto L14;
        r11 = 0;
    L14:
        return withHour((int) r11);
    L16:
        return withHour((int) r11);
    L18:
        if (r11 != 12) goto L21;
        r11 = 0;
    L21:
        return plusHours(r11 - ((long) (this.hour % Ascii.FF)));
    L23:
        return plusHours(r11 - ((long) (this.hour % Ascii.FF)));
    L25:
        return plusMinutes(r11 - ((long) ((this.hour * 60) + this.minute)));
    L27:
        return withMinute((int) r11);
    L29:
        return plusSeconds(r11 - ((long) toSecondOfDay()));
    L31:
        return withSecond((int) r11);
    L33:
        return ofNanoOfDay(r11 * BatteryFactorConfig.WIFI_BPS);
    L35:
        return withNano(((int) r11) * 1000000);
    L37:
        return ofNanoOfDay(r11 * 1000);
    L39:
        return withNano(((int) r11) * 1000);
    L41:
        return ofNanoOfDay(r11);
    L43:
        return withNano((int) r11);
    L45:
        return (LocalTime) r10.adjustInto(this, r11);
    }

    public static LocalTime of(int r10, int r11, int r12, int r13) {
        ChronoField.HOUR_OF_DAY.checkValidValue(r10);
        ChronoField.MINUTE_OF_HOUR.checkValidValue(r11);
        ChronoField.SECOND_OF_MINUTE.checkValidValue(r12);
        ChronoField.NANO_OF_SECOND.checkValidValue(r13);
        return create(r10, r11, r12, r13);
    }
}
