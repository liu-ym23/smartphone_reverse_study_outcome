package bytedance.jvm.time;

import bytedance.jvm.time.format.DateTimeFormatter;
import bytedance.jvm.time.temporal.ChronoField;
import bytedance.jvm.time.temporal.ChronoUnit;
import bytedance.jvm.time.temporal.UnsupportedTemporalTypeException;
import bytedance.jvm.time.temporal.ValueRange;
import com.bytedance.android.livesdk.announcement.AnnouncementViewModel;
import com.ss.ttm.player.C;
import com.ttnet.org.chromium.base.TimeUtils;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final class Instant implements bytedance.jvm.time.temporal.b, bytedance.jvm.time.temporal.e, Comparable<Instant>, Serializable {
    public static final Instant EPOCH = null;
    public static final Instant MAX = null;
    public static final Instant MIN = null;
    private static final long serialVersionUID = -665713676816604388L;
    private final int nanos;
    private final long seconds;

    /* JADX INFO: loaded from: classes28.dex */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f21492a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f21493b = null;

        static {
            int[] r100 = new int[ChronoUnit.values().length];
            f21493b = r100;
            r100[ChronoUnit.NANOS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L20
        L32:
            f21493b[ChronoUnit.MICROS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L21
        L38:
            f21493b[ChronoUnit.MILLIS.ordinal()] = 3;     // Catch: NoSuchFieldError -> L22
        L54:
            f21493b[ChronoUnit.SECONDS.ordinal()] = 4;     // Catch: NoSuchFieldError -> L23
        L34:
            f21493b[ChronoUnit.MINUTES.ordinal()] = 5;     // Catch: NoSuchFieldError -> L24
        L40:
            f21493b[ChronoUnit.HOURS.ordinal()] = 6;     // Catch: NoSuchFieldError -> L25
        L44:
            f21493b[ChronoUnit.HALF_DAYS.ordinal()] = 7;     // Catch: NoSuchFieldError -> L26
        L48:
            f21493b[ChronoUnit.DAYS.ordinal()] = 8;     // Catch: NoSuchFieldError -> L27
        L14:
            int[] r101 = new int[ChronoField.values().length];
            f21492a = r101;
            r101[ChronoField.NANO_OF_SECOND.ordinal()] = 1;     // Catch: NoSuchFieldError -> L28
        L42:
            f21492a[ChronoField.MICRO_OF_SECOND.ordinal()] = 2;     // Catch: NoSuchFieldError -> L29
        L46:
            f21492a[ChronoField.MILLI_OF_SECOND.ordinal()] = 3;     // Catch: NoSuchFieldError -> L30
        L36:
            f21492a[ChronoField.INSTANT_SECONDS.ordinal()] = 4;     // Catch: NoSuchFieldError -> L31
            return;
        }
    }

    static {
        EPOCH = new Instant(0, 0);
        MIN = ofEpochSecond(-31557014167219200L, 0);
        MAX = ofEpochSecond(31556889864403199L, 999999999);
    }

    private Object writeReplace() {
        return new Ser((byte) 2, this);
    }

    public int hashCode() {
        long r100 = this.seconds;
        return ((int) (r100 ^ (r100 >>> 32))) + (this.nanos * 51);
    }

    public long toEpochMilli() {
        long r100 = this.seconds;
        if (r100 < 0) goto L5;
    L40:
        long r101 = 1000;
        int r110 = ((Long.numberOfLeadingZeros(r100) + Long.numberOfLeadingZeros(~r100)) + Long.numberOfLeadingZeros(r101)) + Long.numberOfLeadingZeros(~r101);
        if (r110 <= 65) goto L43;
        long r102 = r100 * r101;
    L59:
        long r103 = this.nanos / 1000000;
        long r104 = r102 + r103;
        if ((r103 ^ r102) >= 0) goto L62;
        boolean r105 = true;
    L64:
        if ((r102 ^ r104) < 0) goto L66;
        boolean r106 = true;
    L68:
        if ((r105 | r106) == false) goto L71;
        return r104;
    L71:
        throw new ArithmeticException();
    L66:
        r106 = false;
        goto L68
    L62:
        r105 = false;
        goto L64
    L43:
        if (r110 < 64) goto L73;
        if (r100 < 0) goto L47;
        boolean r107 = true;
    L49:
        if (r101 == Long.MIN_VALUE) goto L51;
        boolean r108 = true;
    L53:
        if ((r108 | r107) == false) goto L73;
        long r109 = r100 * r101;
        if (r100 != 0) goto L57;
    L58:
        r102 = r109;
        goto L59
    L57:
        if ((r109 / r100) != r101) goto L73;
    L51:
        r108 = false;
        goto L53
    L47:
        r107 = false;
    L73:
        throw new ArithmeticException();
    L5:
        if (this.nanos <= 0) goto L40;
        long r111 = r100 + 1;
        long r112 = 1000;
        int r113 = ((Long.numberOfLeadingZeros(r111) + Long.numberOfLeadingZeros(~r111)) + Long.numberOfLeadingZeros(r112)) + Long.numberOfLeadingZeros(~r112);
        if (r113 <= 65) goto L9;
        long r114 = r111 * r112;
    L25:
        long r115 = (this.nanos / 1000000) - 1000;
        long r116 = r114 + r115;
        if ((r115 ^ r114) >= 0) goto L28;
        boolean r117 = true;
    L30:
        if ((r114 ^ r116) < 0) goto L32;
        boolean r118 = true;
    L34:
        if ((r117 | r118) == false) goto L37;
        return r116;
    L37:
        throw new ArithmeticException();
    L32:
        r118 = false;
        goto L34
    L28:
        r117 = false;
        goto L30
    L9:
        if (r113 < 64) goto L39;
        if (r111 < 0) goto L13;
        boolean r119 = true;
    L15:
        if (r112 == Long.MIN_VALUE) goto L17;
        boolean r120 = true;
    L19:
        if ((r120 | r119) == false) goto L39;
        long r121 = r111 * r112;
        if (r111 != 0) goto L23;
    L24:
        r114 = r121;
        goto L25
    L23:
        if ((r121 / r111) != r112) goto L39;
    L17:
        r120 = false;
        goto L19
    L13:
        r119 = false;
    L39:
        throw new ArithmeticException();
    }

    public String toString() {
        return DateTimeFormatter.f21584n.a(this);
    }

    public static Instant now() {
        return Clock.systemUTC().instant();
    }

    public long getEpochSecond() {
        return this.seconds;
    }

    public int getNano() {
        return this.nanos;
    }

    public static Instant from(bytedance.jvm.time.temporal.d r100) {
        if ((r100 instanceof Instant) == true) goto L5;
        Objects.requireNonNull(r100, "temporal");
        return ofEpochSecond(r100.getLong(ChronoField.INSTANT_SECONDS), r100.get(ChronoField.NANO_OF_SECOND));
    L9:
        e = move-exception;
        throw new DateTimeException("Unable to obtain Instant from TemporalAccessor: " + r100 + " of type " + r100.getClass().getName(), e);
    L5:
        return (Instant) r100;
    }

    public static Instant now(Clock r100) {
        Objects.requireNonNull(r100, "clock");
        return r100.instant();
    }

    public static Instant ofEpochMilli(long r110) {
        long r100 = 1000;
        long r101 = r110 / r100;
        long r102 = 0;
        if ((r110 - (r100 * r101)) != 0) goto L6;
    L8:
        long r103 = r110 % r100;
        if (r103 == 0) goto L17;
        if ((((r110 ^ r100) >> 63) | 1) > 0) goto L15;
        r103 = r103 + r100;
    L15:
        r102 = r103;
    L17:
        return a(r101, ((int) r102) * 1000000);
    L6:
        if ((((r110 ^ r100) >> 63) | 1) >= 0) goto L8;
        r101 = r101 - 1;
        goto L8
    }

    public static Instant ofEpochSecond(long r100) {
        return a(r100, 0);
    }

    public static Instant parse(CharSequence r100) {
        return (Instant) DateTimeFormatter.f21584n.c(r100, new b());
    }

    public static Instant readExternal(DataInput r100) throws IOException {
        return ofEpochSecond(r100.readLong(), r100.readInt());
    }

    private void readObject(ObjectInputStream r100) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    @Override // bytedance.jvm.time.temporal.e
    public bytedance.jvm.time.temporal.b adjustInto(bytedance.jvm.time.temporal.b r100) {
        return r100.with(ChronoField.INSTANT_SECONDS, this.seconds).with(ChronoField.NANO_OF_SECOND, this.nanos);
    }

    public OffsetDateTime atOffset(ZoneOffset r100) {
        return OffsetDateTime.ofInstant(this, r100);
    }

    public ZonedDateTime atZone(ZoneId r100) {
        return ZonedDateTime.ofInstant(this, r100);
    }

    public final long b(Instant r110) {
        long r100 = r110.seconds;
        long r101 = this.seconds;
        long r102 = r100 - r101;
        boolean r103 = false;
        if ((r101 ^ r100) < 0) goto L5;
        boolean r104 = true;
    L7:
        if ((r100 ^ r102) < 0) goto L9;
        boolean r105 = true;
    L11:
        if ((r105 | r104) == false) goto L43;
        int r106 = ((Long.numberOfLeadingZeros(r102) + Long.numberOfLeadingZeros(~r102)) + Long.numberOfLeadingZeros(C.NANOS_PER_SECOND)) + Long.numberOfLeadingZeros(-1000000001);
        if (r106 <= 65) goto L16;
        long r107 = r102 * C.NANOS_PER_SECOND;
    L28:
        long r108 = r110.nanos - this.nanos;
        long r109 = r107 + r108;
        if ((r108 ^ r107) >= 0) goto L31;
        boolean r111 = true;
    L33:
        if ((r107 ^ r109) < 0) goto L36;
        r103 = true;
    L36:
        if ((r111 | r103) == false) goto L39;
        return r109;
    L39:
        throw new ArithmeticException();
    L31:
        r111 = false;
        goto L33
    L16:
        if (r106 < 64) goto L41;
        if (r102 < 0) goto L20;
        boolean r112 = true;
    L22:
        if ((r112 | true) == false) goto L41;
        long r113 = r102 * C.NANOS_PER_SECOND;
        if (r102 != 0) goto L26;
    L27:
        r107 = r113;
        goto L28
    L26:
        if ((r113 / r102) != C.NANOS_PER_SECOND) goto L41;
    L20:
        r112 = false;
    L41:
        throw new ArithmeticException();
    L43:
        throw new ArithmeticException();
    L9:
        r105 = false;
        goto L11
    L5:
        r104 = false;
        goto L7
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(Instant r100) {
        int r101 = Long.compare(this.seconds, r100.seconds);
        if (r101 == 0) goto L6;
        return r101;
    L6:
        return this.nanos - r100.nanos;
    }

    public final long d(Instant r110) {
        long r100 = r110.seconds;
        long r101 = this.seconds;
        long r102 = r100 - r101;
        boolean r103 = false;
        if ((r101 ^ r100) < 0) goto L5;
        boolean r104 = true;
    L7:
        if ((r100 ^ r102) < 0) goto L10;
        r103 = true;
    L10:
        if ((r104 | r103) == false) goto L22;
        long r105 = r110.nanos - this.nanos;
        if (r102 > 0) goto L14;
    L16:
        if (r102 < 0) goto L18;
        return r102;
    L18:
        if (r105 > 0) goto L20;
        return r102;
    L20:
        return r102 + 1;
    L14:
        if (r105 >= 0) goto L16;
        return r102 - 1;
    L22:
        throw new ArithmeticException();
    L5:
        r104 = false;
        goto L7
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof Instant) == false) goto L14;
        Instant r101 = (Instant) r100;
        if (this.seconds == r101.seconds) goto L10;
    L12:
        return false;
    L10:
        if (this.nanos != r101.nanos) goto L12;
        return true;
    L14:
        return false;
    }

    @Override // bytedance.jvm.time.temporal.d
    public int get(bytedance.jvm.time.temporal.j r100) {
        if ((r100 instanceof ChronoField) == false) goto L23;
        int r101 = a.f21492a[((ChronoField) r100).ordinal()];
        if (r101 == 1) goto L21;
        if (r101 == 2) goto L19;
        if (r101 == 3) goto L17;
        if (r101 != 4) goto L15;
        ChronoField.INSTANT_SECONDS.checkValidIntValue(this.seconds);
    L15:
        throw new UnsupportedTemporalTypeException("Unsupported field: " + r100);
    L17:
        return this.nanos / 1000000;
    L19:
        return this.nanos / 1000;
    L21:
        return this.nanos;
    L23:
        return range(r100).checkValidIntValue(r100.getFrom(this), r100);
    }

    @Override // bytedance.jvm.time.temporal.d
    public long getLong(bytedance.jvm.time.temporal.j r100) {
        if ((r100 instanceof ChronoField) == false) goto L22;
        int r101 = a.f21492a[((ChronoField) r100).ordinal()];
        if (r101 != 1) goto L7;
        int r102 = this.nanos;
    L18:
        return r102;
    L7:
        if (r101 != 2) goto L9;
        r102 = this.nanos / 1000;
        goto L18
    L9:
        if (r101 != 3) goto L11;
        r102 = this.nanos / 1000000;
        goto L18
    L11:
        if (r101 != 4) goto L15;
        return this.seconds;
    L15:
        throw new UnsupportedTemporalTypeException("Unsupported field: " + r100);
    L22:
        return r100.getFrom(this);
    }

    public boolean isAfter(Instant r100) {
        if (compareTo2(r100) <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isBefore(Instant r100) {
        if (compareTo2(r100) >= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // bytedance.jvm.time.temporal.d
    public boolean isSupported(bytedance.jvm.time.temporal.j r100) {
        if ((r100 instanceof ChronoField) == true) goto L5;
        if (r100 != null) goto L17;
    L19:
        return false;
    L17:
        if (r100.isSupportedBy(this) == false) goto L19;
        return true;
    L5:
        if (r100 != ChronoField.INSTANT_SECONDS) goto L7;
        return true;
    L7:
        if (r100 != ChronoField.NANO_OF_SECOND) goto L9;
        return true;
    L9:
        if (r100 != ChronoField.MICRO_OF_SECOND) goto L11;
        return true;
    L11:
        if (r100 == ChronoField.MILLI_OF_SECOND) goto L24;
        return false;
    L24:
        return true;
    }

    public Instant minus(bytedance.jvm.time.temporal.i r100) {
        return (Instant) r100.subtractFrom(this);
    }

    public Instant minusMillis(long r100) {
        if (r100 != Long.MIN_VALUE) goto L7;
        return plusMillis(Long.MAX_VALUE).plusMillis(1);
    L7:
        return plusMillis(-r100);
    }

    public Instant minusNanos(long r100) {
        if (r100 != Long.MIN_VALUE) goto L7;
        return plusNanos(Long.MAX_VALUE).plusNanos(1);
    L7:
        return plusNanos(-r100);
    }

    public Instant minusSeconds(long r100) {
        if (r100 != Long.MIN_VALUE) goto L7;
        return plusSeconds(Long.MAX_VALUE).plusSeconds(1);
    L7:
        return plusSeconds(-r100);
    }

    public Instant plus(bytedance.jvm.time.temporal.i r100) {
        return (Instant) r100.addTo(this);
    }

    public Instant plusMillis(long r100) {
        return c(r100 / 1000, (r100 % 1000) * 1000000);
    }

    public Instant plusNanos(long r100) {
        return c(0, r100);
    }

    public Instant plusSeconds(long r100) {
        return c(r100, 0);
    }

    @Override // bytedance.jvm.time.temporal.b, bytedance.jvm.time.temporal.d
    public <R> R query(bytedance.jvm.time.temporal.l<R> r100) {
        if (r100 != bytedance.jvm.time.temporal.k.f21716c) goto L7;
        return (R) ChronoUnit.NANOS;
    L7:
        if (r100 != bytedance.jvm.time.temporal.k.f21715b) goto L9;
        return null;
    L9:
        if (r100 != bytedance.jvm.time.temporal.k.f21714a) goto L11;
        return null;
    L11:
        if (r100 != bytedance.jvm.time.temporal.k.f21718e) goto L13;
        return null;
    L13:
        if (r100 != bytedance.jvm.time.temporal.k.f21717d) goto L15;
        return null;
    L15:
        if (r100 != bytedance.jvm.time.temporal.k.f21719f) goto L17;
        return null;
    L17:
        if (r100 != bytedance.jvm.time.temporal.k.f21720g) goto L20;
        return null;
    L20:
        return r100.a(this);
    }

    @Override // bytedance.jvm.time.temporal.d
    public ValueRange range(bytedance.jvm.time.temporal.j r100) {
        return bytedance.jvm.time.temporal.c.c(this, r100);
    }

    public Instant truncatedTo(bytedance.jvm.time.temporal.m r110) {
        if (r110 != ChronoUnit.NANOS) goto L5;
        return this;
    L5:
        Duration r111 = r110.getDuration();
        if (r111.getSeconds() > 86400) goto L20;
        long r100 = r111.toNanos();
        if ((86400000000000L % r100) != 0) goto L18;
        long r101 = ((this.seconds % 86400) * C.NANOS_PER_SECOND) + ((long) this.nanos);
        long r102 = r101 / r100;
        if ((r101 - (r100 * r102)) != 0) goto L13;
    L15:
        Long.signum(r102);
        return plusNanos((r102 * r100) - r101);
    L13:
        if ((((r101 ^ r100) >> 63) | 1) >= 0) goto L15;
        r102 = r102 - 1;
        goto L15
    L18:
        throw new UnsupportedTemporalTypeException("Unit must divide into a standard day without remainder");
    L20:
        throw new UnsupportedTemporalTypeException("Unit is too large to be used for truncation");
    }

    @Override // bytedance.jvm.time.temporal.b
    public Instant with(bytedance.jvm.time.temporal.e r100) {
        return (Instant) r100.adjustInto(this);
    }

    public void writeExternal(DataOutput r100) throws IOException {
        r100.writeLong(this.seconds);
        r100.writeInt(this.nanos);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Instant r100) {
        return compareTo2(r100);
    }

    @Override // bytedance.jvm.time.temporal.b
    public boolean isSupported(bytedance.jvm.time.temporal.m r100) {
        if ((r100 instanceof ChronoUnit) == true) goto L5;
        if (r100 != null) goto L13;
    L15:
        return false;
    L13:
        if (r100.isSupportedBy(this) == false) goto L15;
        return true;
    L5:
        if (r100.isTimeBased() == false) goto L7;
        return true;
    L7:
        if (r100 == ChronoUnit.DAYS) goto L18;
        return false;
    L18:
        return true;
    }

    /* JADX INFO: renamed from: minus, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ bytedance.jvm.time.temporal.b m7965minus(bytedance.jvm.time.temporal.i r100) {
        return minus(r100);
    }

    /* JADX INFO: renamed from: plus, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ bytedance.jvm.time.temporal.b m7966plus(bytedance.jvm.time.temporal.i r100) {
        return plus(r100);
    }

    @Override // bytedance.jvm.time.temporal.b
    public /* bridge */ /* synthetic */ bytedance.jvm.time.temporal.b with(bytedance.jvm.time.temporal.e r100) {
        return with(r100);
    }

    public Instant(long r100, int r101) {
        this.seconds = r100;
        this.nanos = r101;
    }

    public static Instant a(long r100, int r101) {
        if ((((long) r101) | r100) != 0) goto L7;
        return EPOCH;
    L7:
        if (r100 < (-31557014167219200L)) goto L13;
        if (r100 > 31556889864403199L) goto L13;
        return new Instant(r100, r101);
    L13:
        throw new DateTimeException("Instant exceeds minimum or maximum instant");
    }

    public static Instant ofEpochSecond(long r110, long r111) {
        long r100 = r111 / C.NANOS_PER_SECOND;
        long r101 = 0;
        if ((r111 - (C.NANOS_PER_SECOND * r100)) != 0) goto L6;
    L8:
        long r102 = r110 + r100;
        boolean r112 = false;
        if ((r100 ^ r110) >= 0) goto L11;
        boolean r103 = true;
    L13:
        if ((r110 ^ r102) < 0) goto L16;
        r112 = true;
    L16:
        if ((r103 | r112) == false) goto L28;
        long r104 = r111 % C.NANOS_PER_SECOND;
        if (r104 == 0) goto L26;
        if ((1 | ((r111 ^ C.NANOS_PER_SECOND) >> 63)) > 0) goto L24;
        r104 = r104 + C.NANOS_PER_SECOND;
    L24:
        r101 = r104;
    L26:
        return a(r102, (int) r101);
    L28:
        throw new ArithmeticException();
    L11:
        r103 = false;
        goto L13
    L6:
        if ((((r111 ^ C.NANOS_PER_SECOND) >> 63) | 1) >= 0) goto L8;
        r100 = r100 - 1;
        goto L8
    }

    public final Instant c(long r110, long r111) {
        if ((r110 | r111) != 0) goto L5;
        return this;
    L5:
        long r100 = this.seconds;
        long r101 = r100 + r110;
        boolean r102 = false;
        if ((r110 ^ r100) >= 0) goto L8;
        boolean r112 = true;
    L10:
        if ((r100 ^ r101) < 0) goto L12;
        boolean r113 = true;
    L14:
        if ((r112 | r113) == false) goto L29;
        long r103 = r111 / C.NANOS_PER_SECOND;
        long r104 = r101 + r103;
        if ((r103 ^ r101) >= 0) goto L18;
        boolean r105 = true;
    L20:
        if ((r101 ^ r104) < 0) goto L23;
        r102 = true;
    L23:
        if ((r105 | r102) == false) goto L27;
        long r114 = r111 % C.NANOS_PER_SECOND;
        return ofEpochSecond(r104, ((long) this.nanos) + r114);
    L27:
        throw new ArithmeticException();
    L18:
        r105 = false;
        goto L20
    L29:
        throw new ArithmeticException();
    L12:
        r113 = false;
        goto L14
    L8:
        r112 = false;
        goto L10
    }

    @Override // bytedance.jvm.time.temporal.b
    public Instant minus(long r100, bytedance.jvm.time.temporal.m r101) {
        if (r100 != Long.MIN_VALUE) goto L6;
        return plus(Long.MAX_VALUE, r101).plus(1, r101);
    L6:
        return plus(-r100, r101);
    }

    @Override // bytedance.jvm.time.temporal.b
    public Instant plus(long r110, bytedance.jvm.time.temporal.m r111) {
        if ((r111 instanceof ChronoUnit) == false) goto L109;
        boolean r112 = true;
        switch(a.f21493b[((ChronoUnit) r111).ordinal()]) {
            case 1: goto L107;
            case 2: goto L105;
            case 3: goto L103;
            case 4: goto L101;
            case 5: goto L77;
            case 6: goto L54;
            case 7: goto L31;
            case 8: goto L8;
            default: goto L7;
        };
    L8:
        long r100 = 86400;
        int r113 = ((Long.numberOfLeadingZeros(r110) + Long.numberOfLeadingZeros(~r110)) + Long.numberOfLeadingZeros(r100)) + Long.numberOfLeadingZeros(~r100);
        if (r113 <= 65) goto L11;
        long r101 = r110 * r100;
    L28:
        return plusSeconds(r101);
    L11:
        if (r113 < 64) goto L30;
        if (r110 < 0) goto L15;
        boolean r102 = true;
    L17:
        if (r100 != Long.MIN_VALUE) goto L21;
        r112 = false;
    L21:
        if ((r112 | r102) == false) goto L30;
        long r103 = r110 * r100;
        if (r110 != 0) goto L25;
    L26:
        r101 = r103;
        goto L28
    L25:
        if ((r103 / r110) != r100) goto L30;
    L15:
        r102 = false;
    L30:
        throw new ArithmeticException();
    L31:
        long r104 = 43200;
        int r114 = ((Long.numberOfLeadingZeros(r110) + Long.numberOfLeadingZeros(~r110)) + Long.numberOfLeadingZeros(r104)) + Long.numberOfLeadingZeros(~r104);
        if (r114 <= 65) goto L34;
        long r105 = r110 * r104;
    L51:
        return plusSeconds(r105);
    L34:
        if (r114 < 64) goto L53;
        if (r110 < 0) goto L38;
        boolean r106 = true;
    L40:
        if (r104 != Long.MIN_VALUE) goto L44;
        r112 = false;
    L44:
        if ((r112 | r106) == false) goto L53;
        long r107 = r110 * r104;
        if (r110 != 0) goto L48;
    L49:
        r105 = r107;
        goto L51
    L48:
        if ((r107 / r110) != r104) goto L53;
    L38:
        r106 = false;
    L53:
        throw new ArithmeticException();
    L54:
        long r108 = AnnouncementViewModel.HOUR_DURATION;
        int r115 = ((Long.numberOfLeadingZeros(r110) + Long.numberOfLeadingZeros(~r110)) + Long.numberOfLeadingZeros(r108)) + Long.numberOfLeadingZeros(~r108);
        if (r115 <= 65) goto L57;
        long r109 = r110 * r108;
    L74:
        return plusSeconds(r109);
    L57:
        if (r115 < 64) goto L76;
        if (r110 < 0) goto L61;
        boolean r116 = true;
    L63:
        if (r108 != Long.MIN_VALUE) goto L67;
        r112 = false;
    L67:
        if ((r112 | r116) == false) goto L76;
        long r117 = r110 * r108;
        if (r110 != 0) goto L71;
    L72:
        r109 = r117;
        goto L74
    L71:
        if ((r117 / r110) != r108) goto L76;
    L61:
        r116 = false;
    L76:
        throw new ArithmeticException();
    L77:
        long r118 = 60;
        int r119 = ((Long.numberOfLeadingZeros(r110) + Long.numberOfLeadingZeros(~r110)) + Long.numberOfLeadingZeros(r118)) + Long.numberOfLeadingZeros(~r118);
        if (r119 <= 65) goto L80;
        long r120 = r110 * r118;
    L97:
        return plusSeconds(r120);
    L80:
        if (r119 < 64) goto L99;
        if (r110 < 0) goto L84;
        boolean r121 = true;
    L86:
        if (r118 != Long.MIN_VALUE) goto L90;
        r112 = false;
    L90:
        if ((r112 | r121) == false) goto L99;
        long r122 = r110 * r118;
        if (r110 != 0) goto L94;
    L95:
        r120 = r122;
        goto L97
    L94:
        if ((r122 / r110) != r118) goto L99;
    L84:
        r121 = false;
    L99:
        throw new ArithmeticException();
    L7:
        throw new UnsupportedTemporalTypeException("Unsupported unit: " + r111);
    L101:
        return plusSeconds(r110);
    L103:
        return plusMillis(r110);
    L105:
        return c(r110 / 1000000, (r110 % 1000000) * 1000);
    L107:
        return plusNanos(r110);
    L109:
        return (Instant) r111.addTo(this, r110);
    }

    @Override // bytedance.jvm.time.temporal.b
    public long until(bytedance.jvm.time.temporal.b r110, bytedance.jvm.time.temporal.m r111) {
        Instant r112 = from(r110);
        if ((r111 instanceof ChronoUnit) == false) goto L35;
        switch(a.f21493b[((ChronoUnit) r111).ordinal()]) {
            case 1: goto L33;
            case 2: goto L31;
            case 3: goto L18;
            case 4: goto L17;
            case 5: goto L15;
            case 6: goto L13;
            case 7: goto L11;
            case 8: goto L9;
            default: goto L7;
        };
    L18:
        long r113 = r112.toEpochMilli();
        long r100 = toEpochMilli();
        long r101 = r113 - r100;
        boolean r102 = false;
        if ((r100 ^ r113) < 0) goto L21;
        boolean r103 = true;
    L23:
        if ((r113 ^ r101) < 0) goto L26;
        r102 = true;
    L26:
        if ((r103 | r102) == false) goto L29;
        return r101;
    L29:
        throw new ArithmeticException();
    L21:
        r103 = false;
        goto L23
    L7:
        throw new UnsupportedTemporalTypeException("Unsupported unit: " + r111);
    L9:
        return d(r112) / 86400;
    L11:
        return d(r112) / 43200;
    L13:
        return d(r112) / TimeUtils.SECONDS_PER_HOUR;
    L15:
        return d(r112) / 60;
    L17:
        return d(r112);
    L31:
        return b(r112) / 1000;
    L33:
        return b(r112);
    L35:
        return r111.between(this, r112);
    }

    @Override // bytedance.jvm.time.temporal.b
    public Instant with(bytedance.jvm.time.temporal.j r100, long r101) {
        if ((r100 instanceof ChronoField) == false) goto L35;
        ChronoField r102 = (ChronoField) r100;
        r102.checkValidValue(r101);
        int r103 = a.f21492a[r102.ordinal()];
        if (r103 == 1) goto L30;
        if (r103 != 2) goto L9;
        int r104 = ((int) r101) * 1000;
        if (r104 == this.nanos) goto L28;
        return a(this.seconds, r104);
    L28:
        return this;
    L9:
        if (r103 != 3) goto L11;
        int r105 = ((int) r101) * 1000000;
        if (r105 == this.nanos) goto L23;
        return a(this.seconds, r105);
    L23:
        return this;
    L11:
        if (r103 != 4) goto L18;
        if (r101 == this.seconds) goto L16;
        return a(r101, this.nanos);
    L16:
        return this;
    L18:
        throw new UnsupportedTemporalTypeException("Unsupported field: " + r100);
    L30:
        if (r101 == this.nanos) goto L33;
        return a(this.seconds, (int) r101);
    L33:
        return this;
    L35:
        return (Instant) r100.adjustInto(this, r101);
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
}
