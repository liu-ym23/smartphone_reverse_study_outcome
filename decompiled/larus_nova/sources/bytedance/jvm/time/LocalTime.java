package bytedance.jvm.time;

import bytedance.jvm.time.format.DateTimeFormatter;
import bytedance.jvm.time.temporal.ChronoField;
import bytedance.jvm.time.temporal.ChronoUnit;
import bytedance.jvm.time.temporal.UnsupportedTemporalTypeException;
import bytedance.jvm.time.temporal.ValueRange;
import com.ttnet.org.chromium.base.TimeUtils;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Objects;

/* JADX INFO: loaded from: classes28.dex */
public final class LocalTime implements bytedance.jvm.time.temporal.b, bytedance.jvm.time.temporal.e, Comparable<LocalTime>, Serializable {
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
    static final long NANOS_PER_MILLI = 1000000;
    static final long NANOS_PER_MINUTE = 60000000000L;
    static final long NANOS_PER_SECOND = 1000000000;
    public static final LocalTime NOON = null;
    static final int SECONDS_PER_DAY = 86400;
    static final int SECONDS_PER_HOUR = 3600;
    static final int SECONDS_PER_MINUTE = 60;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LocalTime[] f21497a = null;
    private static final long serialVersionUID = 6414437269572265201L;
    private final byte hour;
    private final byte minute;
    private final int nano;
    private final byte second;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f21498a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f21499b = null;

        static {
            int[] r100 = new int[ChronoUnit.values().length];
            f21499b = r100;
            r100[ChronoUnit.NANOS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L33
        L81:
            f21499b[ChronoUnit.MICROS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L34
        L61:
            f21499b[ChronoUnit.MILLIS.ordinal()] = 3;     // Catch: NoSuchFieldError -> L35
        L77:
            f21499b[ChronoUnit.SECONDS.ordinal()] = 4;     // Catch: NoSuchFieldError -> L36
        L83:
            f21499b[ChronoUnit.MINUTES.ordinal()] = 5;     // Catch: NoSuchFieldError -> L37
        L65:
            f21499b[ChronoUnit.HOURS.ordinal()] = 6;     // Catch: NoSuchFieldError -> L38
        L67:
            f21499b[ChronoUnit.HALF_DAYS.ordinal()] = 7;     // Catch: NoSuchFieldError -> L39
        L16:
            int[] r101 = new int[ChronoField.values().length];
            f21498a = r101;
            r101[ChronoField.NANO_OF_SECOND.ordinal()] = 1;     // Catch: NoSuchFieldError -> L40
        L59:
            f21498a[ChronoField.NANO_OF_DAY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L41
        L87:
            f21498a[ChronoField.MICRO_OF_SECOND.ordinal()] = 3;     // Catch: NoSuchFieldError -> L42
        L97:
            f21498a[ChronoField.MICRO_OF_DAY.ordinal()] = 4;     // Catch: NoSuchFieldError -> L43
        L57:
            f21498a[ChronoField.MILLI_OF_SECOND.ordinal()] = 5;     // Catch: NoSuchFieldError -> L44
        L71:
            f21498a[ChronoField.MILLI_OF_DAY.ordinal()] = 6;     // Catch: NoSuchFieldError -> L45
        L95:
            f21498a[ChronoField.SECOND_OF_MINUTE.ordinal()] = 7;     // Catch: NoSuchFieldError -> L46
        L55:
            f21498a[ChronoField.SECOND_OF_DAY.ordinal()] = 8;     // Catch: NoSuchFieldError -> L47
        L85:
            f21498a[ChronoField.MINUTE_OF_HOUR.ordinal()] = 9;     // Catch: NoSuchFieldError -> L48
        L89:
            f21498a[ChronoField.MINUTE_OF_DAY.ordinal()] = 10;     // Catch: NoSuchFieldError -> L49
        L73:
            f21498a[ChronoField.HOUR_OF_AMPM.ordinal()] = 11;     // Catch: NoSuchFieldError -> L50
        L79:
            f21498a[ChronoField.CLOCK_HOUR_OF_AMPM.ordinal()] = 12;     // Catch: NoSuchFieldError -> L51
        L63:
            f21498a[ChronoField.HOUR_OF_DAY.ordinal()] = 13;     // Catch: NoSuchFieldError -> L52
        L69:
            f21498a[ChronoField.CLOCK_HOUR_OF_DAY.ordinal()] = 14;     // Catch: NoSuchFieldError -> L53
        L93:
            f21498a[ChronoField.AMPM_OF_DAY.ordinal()] = 15;     // Catch: NoSuchFieldError -> L54
            return;
        }
    }

    static {
        f21497a = new LocalTime[24];
        int r100 = 0;
    L3:
        LocalTime[] r101 = f21497a;
        if (r100 >= r101.length) goto L6;
        r101[r100] = new LocalTime(r100, 0, 0, 0);
        r100 = r100 + 1;
        goto L3
    L6:
        LocalTime r102 = r101[0];
        MIDNIGHT = r102;
        NOON = r101[12];
        MIN = r102;
        MAX = new LocalTime(23, 59, 59, 999999999);
    }

    private Object writeReplace() {
        return new Ser((byte) 4, this);
    }

    public long toNanoOfDay() {
        return (((((long) this.hour) * NANOS_PER_HOUR) + (((long) this.minute) * NANOS_PER_MINUTE)) + (((long) this.second) * 1000000000)) + ((long) this.nano);
    }

    public int toSecondOfDay() {
        return ((this.hour * 3600) + (this.minute * 60)) + this.second;
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder(18);
        byte r101 = this.hour;
        byte r102 = this.minute;
        byte r103 = this.second;
        int r104 = this.nano;
        if (r101 >= 10) goto L5;
        String r105 = "0";
    L6:
        r100.append(r105);
        r100.append(r101);
        String r106 = ":0";
        if (r102 >= 10) goto L9;
        String r107 = ":0";
    L10:
        r100.append(r107);
        r100.append(r102);
        if (r103 > 0) goto L13;
        if (r104 > 0) goto L13;
    L26:
        return r100.toString();
    L13:
        if (r103 < 10) goto L16;
        r106 = ":";
    L16:
        r100.append(r106);
        r100.append(r103);
        if (r104 <= 0) goto L26;
        r100.append('.');
        if ((r104 % 1000000) != 0) goto L22;
        r100.append(Integer.toString((r104 / 1000000) + 1000).substring(1));
        goto L26
    L22:
        if ((r104 % 1000) != 0) goto L24;
        r100.append(Integer.toString((r104 / 1000) + 1000000).substring(1));
        goto L26
    L24:
        r100.append(Integer.toString(r104 + 1000000000).substring(1));
        goto L26
    L9:
        r107 = ":";
        goto L10
    L5:
        r105 = "";
        goto L6
    }

    public static LocalTime now() {
        return now(Clock.systemDefaultZone());
    }

    public int hashCode() {
        long r100 = toNanoOfDay();
        return (int) (r100 ^ (r100 >>> 32));
    }

    public int getHour() {
        return this.hour;
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

    public static LocalTime from(bytedance.jvm.time.temporal.d r100) {
        Objects.requireNonNull(r100, "temporal");
        LocalTime r101 = (LocalTime) r100.query(bytedance.jvm.time.temporal.k.f21720g);
        if (r101 == null) goto L6;
        return r101;
    L6:
        throw new DateTimeException("Unable to obtain LocalTime from TemporalAccessor: " + r100 + " of type " + r100.getClass().getName());
    }

    public static LocalTime now(Clock r100) {
        Objects.requireNonNull(r100, "clock");
        return ofInstant(r100.instant(), r100.getZone());
    }

    public static LocalTime ofNanoOfDay(long r100) {
        ChronoField.NANO_OF_DAY.checkValidValue(r100);
        int r101 = (int) (r100 / NANOS_PER_HOUR);
        long r102 = r100 - (((long) r101) * NANOS_PER_HOUR);
        int r103 = (int) (r102 / NANOS_PER_MINUTE);
        long r104 = r102 - (((long) r103) * NANOS_PER_MINUTE);
        int r105 = (int) (r104 / 1000000000);
        return a(r101, r103, r105, (int) (r104 - (((long) r105) * 1000000000)));
    }

    public static LocalTime ofSecondOfDay(long r100) {
        ChronoField.SECOND_OF_DAY.checkValidValue(r100);
        int r101 = (int) (r100 / TimeUtils.SECONDS_PER_HOUR);
        long r102 = r100 - ((long) (r101 * 3600));
        int r103 = (int) (r102 / 60);
        return a(r101, r103, (int) (r102 - ((long) (r103 * 60))), 0);
    }

    public static LocalTime parse(CharSequence r100) {
        return parse(r100, DateTimeFormatter.f21579i);
    }

    public static LocalTime readExternal(DataInput r100) throws IOException {
        int r101 = r100.readByte();
        int r102 = 0;
        if (r101 >= 0) goto L6;
        r101 = ~r101;
        int r103 = 0;
    L5:
        int r104 = 0;
    L14:
        return of(r101, r102, r103, r104);
    L6:
        byte r105 = r100.readByte();
        if (r105 >= 0) goto L9;
        int r106 = ~r105;
        r104 = 0;
        r102 = r106;
        r103 = 0;
        goto L14
    L9:
        byte r107 = r100.readByte();
        if (r107 >= 0) goto L12;
        r103 = ~r107;
        r102 = r105;
        goto L5
    L12:
        int r108 = r100.readInt();
        r103 = r107;
        r104 = r108;
        r102 = r105;
        goto L14
    }

    private void readObject(ObjectInputStream r100) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    @Override // bytedance.jvm.time.temporal.e
    public bytedance.jvm.time.temporal.b adjustInto(bytedance.jvm.time.temporal.b r100) {
        return r100.with(ChronoField.NANO_OF_DAY, toNanoOfDay());
    }

    public LocalDateTime atDate(LocalDate r100) {
        return LocalDateTime.of(r100, this);
    }

    public OffsetTime atOffset(ZoneOffset r100) {
        return OffsetTime.of(this, r100);
    }

    public final int b(bytedance.jvm.time.temporal.j r100) {
        switch(a.f21498a[((ChronoField) r100).ordinal()]) {
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
        byte r101 = this.hour;
        if (r101 != 0) goto L41;
        return 24;
    L41:
        return r101;
    L14:
        int r102 = this.hour % 12;
        if ((r102 % 12) != 0) goto L18;
        return 12;
    L18:
        return r102;
    L5:
        throw new UnsupportedTemporalTypeException("Unsupported field: " + r100);
    L7:
        return this.hour / 12;
    L13:
        return this.hour;
    L20:
        return this.hour % 12;
    L22:
        return (this.hour * 60) + this.minute;
    L24:
        return this.minute;
    L26:
        return toSecondOfDay();
    L28:
        return this.second;
    L30:
        return (int) (toNanoOfDay() / 1000000);
    L32:
        return this.nano / 1000000;
    L34:
        throw new UnsupportedTemporalTypeException("Invalid field 'MicroOfDay' for get() method, use getLong() instead");
    L36:
        return this.nano / 1000;
    L38:
        throw new UnsupportedTemporalTypeException("Invalid field 'NanoOfDay' for get() method, use getLong() instead");
    L40:
        return this.nano;
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(LocalTime r100) {
        int r101 = Integer.compare(this.hour, r100.hour);
        if (r101 != 0) goto L10;
        int r102 = Integer.compare(this.minute, r100.minute);
        if (r102 != 0) goto L11;
        int r103 = Integer.compare(this.second, r100.second);
        if (r103 == 0) goto L9;
        return r103;
    L9:
        return Integer.compare(this.nano, r100.nano);
    L11:
        return r102;
    L10:
        return r101;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof LocalTime) == false) goto L18;
        LocalTime r101 = (LocalTime) r100;
        if (this.hour == r101.hour) goto L10;
    L16:
        return false;
    L10:
        if (this.minute != r101.minute) goto L16;
        if (this.second != r101.second) goto L16;
        if (this.nano != r101.nano) goto L16;
        return true;
    L18:
        return false;
    }

    public String format(DateTimeFormatter r100) {
        Objects.requireNonNull(r100, "formatter");
        return r100.a(this);
    }

    @Override // bytedance.jvm.time.temporal.d
    public int get(bytedance.jvm.time.temporal.j r100) {
        if ((r100 instanceof ChronoField) == false) goto L7;
        return b(r100);
    L7:
        return bytedance.jvm.time.temporal.c.a(this, r100);
    }

    @Override // bytedance.jvm.time.temporal.d
    public long getLong(bytedance.jvm.time.temporal.j r100) {
        if ((r100 instanceof ChronoField) == false) goto L15;
        if (r100 != ChronoField.NANO_OF_DAY) goto L9;
        return toNanoOfDay();
    L9:
        if (r100 != ChronoField.MICRO_OF_DAY) goto L13;
        return toNanoOfDay() / 1000;
    L13:
        return b(r100);
    L15:
        return r100.getFrom(this);
    }

    public boolean isAfter(LocalTime r100) {
        if (compareTo2(r100) <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isBefore(LocalTime r100) {
        if (compareTo2(r100) >= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // bytedance.jvm.time.temporal.d
    public boolean isSupported(bytedance.jvm.time.temporal.j r100) {
        if ((r100 instanceof ChronoField) == true) goto L5;
        if (r100 != null) goto L8;
    L10:
        return false;
    L8:
        if (r100.isSupportedBy(this) == false) goto L10;
        return true;
    L5:
        return r100.isTimeBased();
    }

    public LocalTime minus(bytedance.jvm.time.temporal.i r100) {
        return (LocalTime) r100.subtractFrom(this);
    }

    public LocalTime minusHours(long r100) {
        return plusHours(-(r100 % 24));
    }

    public LocalTime minusMinutes(long r100) {
        return plusMinutes(-(r100 % 1440));
    }

    public LocalTime minusNanos(long r100) {
        return plusNanos(-(r100 % NANOS_PER_DAY));
    }

    public LocalTime minusSeconds(long r100) {
        return plusSeconds(-(r100 % 86400));
    }

    public LocalTime plus(bytedance.jvm.time.temporal.i r100) {
        return (LocalTime) r100.addTo(this);
    }

    public LocalTime plusHours(long r100) {
        if (r100 != 0) goto L6;
        return this;
    L6:
        return a(((((int) (r100 % 24)) + this.hour) + 24) % 24, this.minute, this.second, this.nano);
    }

    public LocalTime plusMinutes(long r100) {
        if (r100 != 0) goto L5;
        return this;
    L5:
        int r101 = (this.hour * 60) + this.minute;
        int r102 = ((((int) (r100 % 1440)) + r101) + 1440) % 1440;
        if (r101 != r102) goto L9;
        return this;
    L9:
        return a(r102 / 60, r102 % 60, this.second, this.nano);
    }

    public LocalTime plusNanos(long r100) {
        if (r100 != 0) goto L5;
        return this;
    L5:
        long r101 = toNanoOfDay();
        long r102 = (((r100 % NANOS_PER_DAY) + r101) + NANOS_PER_DAY) % NANOS_PER_DAY;
        if (r101 != r102) goto L9;
        return this;
    L9:
        return a((int) (r102 / NANOS_PER_HOUR), (int) ((r102 / NANOS_PER_MINUTE) % 60), (int) ((r102 / 1000000000) % 60), (int) (r102 % 1000000000));
    }

    public LocalTime plusSeconds(long r100) {
        if (r100 != 0) goto L5;
        return this;
    L5:
        int r101 = ((this.hour * 3600) + (this.minute * 60)) + this.second;
        int r102 = ((((int) (r100 % 86400)) + r101) + 86400) % 86400;
        if (r101 != r102) goto L9;
        return this;
    L9:
        return a(r102 / 3600, (r102 / 60) % 60, r102 % 60, this.nano);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // bytedance.jvm.time.temporal.b, bytedance.jvm.time.temporal.d
    public <R> R query(bytedance.jvm.time.temporal.l<R> r100) {
        if (r100 != bytedance.jvm.time.temporal.k.f21715b) goto L5;
    L23:
        return null;
    L5:
        if (r100 == bytedance.jvm.time.temporal.k.f21714a) goto L23;
        if (r100 == bytedance.jvm.time.temporal.k.f21718e) goto L23;
        if (r100 == bytedance.jvm.time.temporal.k.f21717d) goto L23;
        if (r100 != bytedance.jvm.time.temporal.k.f21720g) goto L15;
        return this;
    L15:
        if (r100 != bytedance.jvm.time.temporal.k.f21719f) goto L18;
        return null;
    L18:
        if (r100 != bytedance.jvm.time.temporal.k.f21716c) goto L22;
        return (R) ChronoUnit.NANOS;
    L22:
        return r100.a(this);
    }

    @Override // bytedance.jvm.time.temporal.d
    public ValueRange range(bytedance.jvm.time.temporal.j r100) {
        return bytedance.jvm.time.temporal.c.c(this, r100);
    }

    public LocalTime truncatedTo(bytedance.jvm.time.temporal.m r100) {
        if (r100 != ChronoUnit.NANOS) goto L5;
        return this;
    L5:
        Duration r101 = r100.getDuration();
        if (r101.getSeconds() > 86400) goto L14;
        long r102 = r101.toNanos();
        if ((NANOS_PER_DAY % r102) != 0) goto L12;
        return ofNanoOfDay((toNanoOfDay() / r102) * r102);
    L12:
        throw new UnsupportedTemporalTypeException("Unit must divide into a standard day without remainder");
    L14:
        throw new UnsupportedTemporalTypeException("Unit is too large to be used for truncation");
    }

    @Override // bytedance.jvm.time.temporal.b
    public LocalTime with(bytedance.jvm.time.temporal.e r100) {
        if ((r100 instanceof LocalTime) == false) goto L7;
        return (LocalTime) r100;
    L7:
        return (LocalTime) r100.adjustInto(this);
    }

    public LocalTime withHour(int r100) {
        if (this.hour != r100) goto L5;
        return this;
    L5:
        ChronoField.HOUR_OF_DAY.checkValidValue(r100);
        return a(r100, this.minute, this.second, this.nano);
    }

    public LocalTime withMinute(int r100) {
        if (this.minute != r100) goto L5;
        return this;
    L5:
        ChronoField.MINUTE_OF_HOUR.checkValidValue(r100);
        return a(this.hour, r100, this.second, this.nano);
    }

    public LocalTime withNano(int r100) {
        if (this.nano != r100) goto L5;
        return this;
    L5:
        ChronoField.NANO_OF_SECOND.checkValidValue(r100);
        return a(this.hour, this.minute, this.second, r100);
    }

    public LocalTime withSecond(int r100) {
        if (this.second != r100) goto L5;
        return this;
    L5:
        ChronoField.SECOND_OF_MINUTE.checkValidValue(r100);
        return a(this.hour, this.minute, r100, this.nano);
    }

    public void writeExternal(DataOutput r100) throws IOException {
        if (this.nano == 0) goto L5;
        r100.writeByte(this.hour);
        r100.writeByte(this.minute);
        r100.writeByte(this.second);
        r100.writeInt(this.nano);
        return;
    L5:
        if (this.second == 0) goto L7;
        r100.writeByte(this.hour);
        r100.writeByte(this.minute);
        r100.writeByte(~this.second);
        return;
    L7:
        if (this.minute != 0) goto L9;
        r100.writeByte(~this.hour);
        return;
    L9:
        r100.writeByte(this.hour);
        r100.writeByte(~this.minute);
    }

    public static LocalTime now(ZoneId r100) {
        return now(Clock.system(r100));
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(LocalTime r100) {
        return compareTo2(r100);
    }

    @Override // bytedance.jvm.time.temporal.b
    public boolean isSupported(bytedance.jvm.time.temporal.m r100) {
        if ((r100 instanceof ChronoUnit) == true) goto L5;
        if (r100 != null) goto L8;
    L10:
        return false;
    L8:
        if (r100.isSupportedBy(this) == false) goto L10;
        return true;
    L5:
        return r100.isTimeBased();
    }

    /* JADX INFO: renamed from: minus, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ bytedance.jvm.time.temporal.b m7973minus(bytedance.jvm.time.temporal.i r100) {
        return minus(r100);
    }

    /* JADX INFO: renamed from: plus, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ bytedance.jvm.time.temporal.b m7974plus(bytedance.jvm.time.temporal.i r100) {
        return plus(r100);
    }

    @Override // bytedance.jvm.time.temporal.b
    public /* bridge */ /* synthetic */ bytedance.jvm.time.temporal.b with(bytedance.jvm.time.temporal.e r100) {
        return with(r100);
    }

    public static LocalTime of(int r100, int r101) {
        ChronoField.HOUR_OF_DAY.checkValidValue(r100);
        if (r101 == 0) goto L5;
        ChronoField.MINUTE_OF_HOUR.checkValidValue(r101);
        return new LocalTime(r100, r101, 0, 0);
    L5:
        return f21497a[r100];
    }

    public static LocalTime ofInstant(Instant r110, ZoneId r111) {
        Objects.requireNonNull(r110, "instant");
        Objects.requireNonNull(r111, "zone");
        long r100 = r110.getEpochSecond() + ((long) r111.getRules().getOffset(r110).getTotalSeconds());
        long r101 = 86400;
        long r102 = r100 % r101;
        long r103 = 0;
        if (r102 == 0) goto L11;
        if ((((r100 ^ r101) >> 63) | 1) > 0) goto L9;
        r102 = r102 + r101;
    L9:
        r103 = r102;
    L11:
        return ofNanoOfDay((((long) ((int) r103)) * 1000000000) + ((long) r110.getNano()));
    }

    public static LocalTime parse(CharSequence r100, DateTimeFormatter r101) {
        Objects.requireNonNull(r101, "formatter");
        return (LocalTime) r101.c(r100, new h());
    }

    @Override // bytedance.jvm.time.temporal.b
    public LocalTime minus(long r100, bytedance.jvm.time.temporal.m r101) {
        if (r100 != Long.MIN_VALUE) goto L6;
        return plus(Long.MAX_VALUE, r101).plus(1, r101);
    L6:
        return plus(-r100, r101);
    }

    @Override // bytedance.jvm.time.temporal.b
    public LocalTime plus(long r100, bytedance.jvm.time.temporal.m r101) {
        if ((r101 instanceof ChronoUnit) == false) goto L23;
        switch(a.f21499b[((ChronoUnit) r101).ordinal()]) {
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
        throw new UnsupportedTemporalTypeException("Unsupported unit: " + r101);
    L9:
        return plusHours((r100 % 2) * 12);
    L11:
        return plusHours(r100);
    L13:
        return plusMinutes(r100);
    L15:
        return plusSeconds(r100);
    L17:
        return plusNanos((r100 % 86400000) * 1000000);
    L19:
        return plusNanos((r100 % MICROS_PER_DAY) * 1000);
    L21:
        return plusNanos(r100);
    L23:
        return (LocalTime) r101.addTo(this, r100);
    }

    public long toEpochSecond(LocalDate r100, ZoneOffset r101) {
        Objects.requireNonNull(r100, "date");
        Objects.requireNonNull(r101, "offset");
        return ((r100.toEpochDay() * 86400) + ((long) toSecondOfDay())) - ((long) r101.getTotalSeconds());
    }

    @Override // bytedance.jvm.time.temporal.b
    public long until(bytedance.jvm.time.temporal.b r100, bytedance.jvm.time.temporal.m r101) {
        LocalTime r102 = from(r100);
        if ((r101 instanceof ChronoUnit) == false) goto L21;
        long r103 = r102.toNanoOfDay() - toNanoOfDay();
        switch(a.f21499b[((ChronoUnit) r101).ordinal()]) {
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
        return r103;
    L7:
        throw new UnsupportedTemporalTypeException("Unsupported unit: " + r101);
    L9:
        return r103 / 43200000000000L;
    L11:
        return r103 / NANOS_PER_HOUR;
    L13:
        return r103 / NANOS_PER_MINUTE;
    L15:
        return r103 / 1000000000;
    L17:
        return r103 / 1000000;
    L19:
        return r103 / 1000;
    L21:
        return r101.between(this, r102);
    }

    @Override // bytedance.jvm.time.temporal.b
    public LocalTime with(bytedance.jvm.time.temporal.j r100, long r101) {
        if ((r100 instanceof ChronoField) == false) goto L45;
        ChronoField r102 = (ChronoField) r100;
        r102.checkValidValue(r101);
        switch(a.f21498a[r102.ordinal()]) {
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
        throw new UnsupportedTemporalTypeException("Unsupported field: " + r100);
    L9:
        return plusHours((r101 - ((long) (this.hour / 12))) * 12);
    L11:
        if (r101 != 24) goto L14;
        r101 = 0;
    L14:
        return withHour((int) r101);
    L16:
        return withHour((int) r101);
    L18:
        if (r101 != 12) goto L21;
        r101 = 0;
    L21:
        return plusHours(r101 - ((long) (this.hour % 12)));
    L23:
        return plusHours(r101 - ((long) (this.hour % 12)));
    L25:
        return plusMinutes(r101 - ((long) ((this.hour * 60) + this.minute)));
    L27:
        return withMinute((int) r101);
    L29:
        return plusSeconds(r101 - ((long) toSecondOfDay()));
    L31:
        return withSecond((int) r101);
    L33:
        return ofNanoOfDay(r101 * 1000000);
    L35:
        return withNano(((int) r101) * 1000000);
    L37:
        return ofNanoOfDay(r101 * 1000);
    L39:
        return withNano(((int) r101) * 1000);
    L41:
        return ofNanoOfDay(r101);
    L43:
        return withNano((int) r101);
    L45:
        return (LocalTime) r100.adjustInto(this, r101);
    }

    @Override // bytedance.jvm.time.temporal.b
    public /* bridge */ /* synthetic */ bytedance.jvm.time.temporal.b minus(long r100, bytedance.jvm.time.temporal.m r101) {
        return minus(r100, r101);
    }

    @Override // bytedance.jvm.time.temporal.b
    public /* bridge */ /* synthetic */ bytedance.jvm.time.temporal.b plus(long r100, bytedance.jvm.time.temporal.m r101) {
        return plus(r100, r101);
    }

    @Override // bytedance.jvm.time.temporal.b
    public /* bridge */ /* synthetic */ bytedance.jvm.time.temporal.b with(bytedance.jvm.time.temporal.j r100, long r101) {
        return with(r100, r101);
    }

    public static LocalTime of(int r100, int r101, int r102) {
        ChronoField.HOUR_OF_DAY.checkValidValue(r100);
        if ((r101 | r102) == 0) goto L5;
        ChronoField.MINUTE_OF_HOUR.checkValidValue(r101);
        ChronoField.SECOND_OF_MINUTE.checkValidValue(r102);
        return new LocalTime(r100, r101, r102, 0);
    L5:
        return f21497a[r100];
    }

    public LocalTime(int r100, int r101, int r102, int r103) {
        this.hour = (byte) r100;
        this.minute = (byte) r101;
        this.second = (byte) r102;
        this.nano = r103;
    }

    public static LocalTime a(int r100, int r101, int r102, int r103) {
        if (((r101 | r102) | r103) != 0) goto L7;
        return f21497a[r100];
    L7:
        return new LocalTime(r100, r101, r102, r103);
    }

    public static LocalTime of(int r100, int r101, int r102, int r103) {
        ChronoField.HOUR_OF_DAY.checkValidValue(r100);
        ChronoField.MINUTE_OF_HOUR.checkValidValue(r101);
        ChronoField.SECOND_OF_MINUTE.checkValidValue(r102);
        ChronoField.NANO_OF_SECOND.checkValidValue(r103);
        return a(r100, r101, r102, r103);
    }
}
