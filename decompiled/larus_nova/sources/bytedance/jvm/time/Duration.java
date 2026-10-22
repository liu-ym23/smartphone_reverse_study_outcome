package bytedance.jvm.time;

import bytedance.jvm.time.format.DateTimeParseException;
import bytedance.jvm.time.temporal.ChronoField;
import bytedance.jvm.time.temporal.ChronoUnit;
import bytedance.jvm.time.temporal.UnsupportedTemporalTypeException;
import com.bytedance.android.livesdk.announcement.AnnouncementViewModel;
import com.bytedance.crash.dumper.Scraps;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.ss.ttm.player.C;
import com.ttnet.org.chromium.base.TimeUtils;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes28.dex */
public final class Duration implements bytedance.jvm.time.temporal.i, Comparable<Duration>, Serializable {
    public static final Duration ZERO = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final BigInteger f21488a = null;
    private static final long serialVersionUID = 3078945930695997490L;
    private final int nanos;
    private final long seconds;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f21489a = null;

        static {
            int[] r100 = new int[ChronoUnit.values().length];
            f21489a = r100;
            r100[ChronoUnit.NANOS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            f21489a[ChronoUnit.MICROS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            f21489a[ChronoUnit.MILLIS.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            f21489a[ChronoUnit.SECONDS.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final List<bytedance.jvm.time.temporal.m> f21490a = null;

        static {
            int r100 = 0;
            Object[] r101 = {ChronoUnit.SECONDS, ChronoUnit.NANOS};
            ArrayList r102 = new ArrayList(2);
        L3:
            if (r100 >= 2) goto L5;
            Object r103 = r101[r100];
            Objects.requireNonNull(r103);
            r102.add(r103);
            r100 = r100 + 1;
            goto L3
        L5:
            f21490a = Collections.unmodifiableList(r102);
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Pattern f21491a = null;

        static {
            f21491a = PatternProtector.compile("([-+]?)P(?:([-+]?[0-9]+)D)?(T(?:([-+]?[0-9]+)H)?(?:([-+]?[0-9]+)M)?(?:([-+]?[0-9]+)(?:[.,]([0-9]{0,9}))?S)?)?", 2);
        }
    }

    static {
        ZERO = new Duration(0, 0);
        f21488a = BigInteger.valueOf(C.NANOS_PER_SECOND);
    }

    private Object writeReplace() {
        return new Ser((byte) 1, this);
    }

    public final BigDecimal e() {
        return BigDecimal.valueOf(this.seconds).add(BigDecimal.valueOf(this.nanos, 9));
    }

    public int hashCode() {
        long r100 = this.seconds;
        return ((int) (r100 ^ (r100 >>> 32))) + (this.nanos * 51);
    }

    public boolean isNegative() {
        if (this.seconds >= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isZero() {
        if ((this.seconds | ((long) this.nanos)) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public Duration negated() {
        return multipliedBy(-1);
    }

    public long toDays() {
        return this.seconds / 86400;
    }

    public long toDaysPart() {
        return this.seconds / 86400;
    }

    public long toHours() {
        return this.seconds / TimeUtils.SECONDS_PER_HOUR;
    }

    public long toMillis() {
        long r100 = this.seconds;
        long r101 = this.nanos;
        if (r100 >= 0) goto L5;
        r100 = r100 + 1;
        r101 = r101 - C.NANOS_PER_SECOND;
    L5:
        long r102 = 1000;
        int r103 = ((Long.numberOfLeadingZeros(r100) + Long.numberOfLeadingZeros(~r100)) + Long.numberOfLeadingZeros(r102)) + Long.numberOfLeadingZeros(~r102);
        boolean r110 = true;
        if (r103 <= 65) goto L9;
        long r104 = r100 * r102;
    L25:
        long r105 = r101 / 1000000;
        long r106 = r104 + r105;
        if ((r105 ^ r104) >= 0) goto L28;
        boolean r107 = true;
    L30:
        if ((r104 ^ r106) >= 0) goto L34;
        r110 = false;
    L34:
        if ((r107 | r110) == false) goto L37;
        return r106;
    L37:
        throw new ArithmeticException();
    L28:
        r107 = false;
        goto L30
    L9:
        if (r103 < 64) goto L39;
        if (r100 < 0) goto L13;
        boolean r108 = true;
    L15:
        if (r102 == Long.MIN_VALUE) goto L17;
        boolean r111 = true;
    L19:
        if ((r108 | r111) == false) goto L39;
        long r112 = r100 * r102;
        if (r100 != 0) goto L23;
    L24:
        r104 = r112;
        goto L25
    L23:
        if ((r112 / r100) != r102) goto L39;
    L17:
        r111 = false;
        goto L19
    L13:
        r108 = false;
    L39:
        throw new ArithmeticException();
    }

    public int toMillisPart() {
        return this.nanos / 1000000;
    }

    public long toMinutes() {
        return this.seconds / 60;
    }

    public long toNanos() {
        long r100 = this.seconds;
        long r101 = this.nanos;
        if (r100 >= 0) goto L5;
        r100 = r100 + 1;
        r101 = r101 - C.NANOS_PER_SECOND;
    L5:
        int r102 = ((Long.numberOfLeadingZeros(r100) + Long.numberOfLeadingZeros(~r100)) + Long.numberOfLeadingZeros(C.NANOS_PER_SECOND)) + Long.numberOfLeadingZeros(-1000000001);
        boolean r110 = false;
        if (r102 <= 65) goto L9;
        long r103 = r100 * C.NANOS_PER_SECOND;
    L21:
        long r104 = r103 + r101;
        if ((r101 ^ r103) >= 0) goto L24;
        boolean r105 = true;
    L26:
        if ((r103 ^ r104) < 0) goto L29;
        r110 = true;
    L29:
        if ((r105 | r110) == false) goto L32;
        return r104;
    L32:
        throw new ArithmeticException();
    L24:
        r105 = false;
        goto L26
    L9:
        if (r102 < 64) goto L34;
        if (r100 < 0) goto L13;
        boolean r106 = true;
    L15:
        if ((r106 | true) == false) goto L34;
        long r111 = r100 * C.NANOS_PER_SECOND;
        if (r100 != 0) goto L19;
    L20:
        r103 = r111;
        goto L21
    L19:
        if ((r111 / r100) != C.NANOS_PER_SECOND) goto L34;
    L13:
        r106 = false;
    L34:
        throw new ArithmeticException();
    }

    public int toSecondsPart() {
        return (int) (this.seconds % 60);
    }

    public String toString() {
        if (this != ZERO) goto L6;
        return "PT0S";
    L6:
        long r100 = this.seconds;
        if (r100 < 0) goto L9;
    L11:
        long r101 = r100 / TimeUtils.SECONDS_PER_HOUR;
        int r102 = (int) ((r100 % TimeUtils.SECONDS_PER_HOUR) / 60);
        int r103 = (int) (r100 % 60);
        StringBuilder r104 = new StringBuilder(24);
        r104.append("PT");
        if (r101 == 0) goto L14;
        r104.append(r101);
        r104.append('H');
    L14:
        if (r102 == 0) goto L16;
        r104.append(r102);
        r104.append('M');
    L16:
        if (r103 != 0) goto L24;
        if (this.nanos != 0) goto L24;
        if (r104.length() <= 2) goto L24;
        return r104.toString();
    L24:
        if (this.seconds < 0) goto L26;
    L30:
        r104.append(r103);
    L32:
        if (this.nanos <= 0) goto L41;
        int r105 = r104.length();
        if (this.seconds >= 0) goto L36;
        r104.append(2000000000 - ((long) this.nanos));
    L38:
        if (r104.charAt(r104.length() - 1) != '0') goto L40;
        r104.setLength(r104.length() - 1);
        goto L38
    L40:
        r104.setCharAt(r105, '.');
        goto L41
    L36:
        r104.append(((long) this.nanos) + C.NANOS_PER_SECOND);
    L41:
        r104.append('S');
        return r104.toString();
    L26:
        if (this.nanos <= 0) goto L30;
        if (r103 != 0) goto L29;
        r104.append("-0");
        goto L32
    L29:
        r104.append(r103);
        goto L32
    L9:
        if (this.nanos <= 0) goto L11;
        r100 = r100 + 1;
        goto L11
    }

    public Duration abs() {
        if (isNegative() == false) goto L6;
        return negated();
    L6:
        return this;
    }

    public int toHoursPart() {
        return (int) (toHours() % 24);
    }

    public int toMinutesPart() {
        return (int) (toMinutes() % 60);
    }

    public int getNano() {
        return this.nanos;
    }

    public long getSeconds() {
        return this.seconds;
    }

    @Override // bytedance.jvm.time.temporal.i
    public List<bytedance.jvm.time.temporal.m> getUnits() {
        return b.f21490a;
    }

    public int toNanosPart() {
        return this.nanos;
    }

    public long toSeconds() {
        return this.seconds;
    }

    public static Duration b(BigDecimal r100) {
        BigInteger r101 = r100.movePointRight(9).toBigIntegerExact();
        BigInteger[] r102 = r101.divideAndRemainder(f21488a);
        if (r102[0].bitLength() > 63) goto L7;
        return ofSeconds(r102[0].longValue(), r102[1].intValue());
    L7:
        throw new ArithmeticException("Exceeds capacity of Duration: " + r101);
    }

    public static Duration from(bytedance.jvm.time.temporal.i r100) {
        Objects.requireNonNull(r100, "amount");
        Duration r101 = ZERO;
        Iterator<bytedance.jvm.time.temporal.m> r102 = r100.getUnits().iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        bytedance.jvm.time.temporal.m r103 = r102.next();
        r101 = r101.plus(r100.get(r103), r103);
        goto L4
    L6:
        return r101;
    }

    public static Duration ofDays(long r100) {
        long r101 = 86400;
        int r102 = ((Long.numberOfLeadingZeros(r100) + Long.numberOfLeadingZeros(~r100)) + Long.numberOfLeadingZeros(r101)) + Long.numberOfLeadingZeros(~r101);
        if (r102 <= 65) goto L6;
        long r103 = r100 * r101;
    L23:
        return a(r103, 0);
    L6:
        if (r102 < 64) goto L25;
        boolean r104 = true;
        if (r100 < 0) goto L10;
        boolean r105 = true;
    L12:
        if (r101 != Long.MIN_VALUE) goto L16;
        r104 = false;
    L16:
        if ((r105 | r104) == false) goto L25;
        long r106 = r100 * r101;
        if (r100 != 0) goto L20;
    L21:
        r103 = r106;
        goto L23
    L20:
        if ((r106 / r100) != r101) goto L25;
    L10:
        r105 = false;
    L25:
        throw new ArithmeticException();
    }

    public static Duration ofHours(long r100) {
        long r101 = AnnouncementViewModel.HOUR_DURATION;
        int r102 = ((Long.numberOfLeadingZeros(r100) + Long.numberOfLeadingZeros(~r100)) + Long.numberOfLeadingZeros(r101)) + Long.numberOfLeadingZeros(~r101);
        if (r102 <= 65) goto L6;
        long r103 = r100 * r101;
    L23:
        return a(r103, 0);
    L6:
        if (r102 < 64) goto L25;
        boolean r104 = true;
        if (r100 < 0) goto L10;
        boolean r105 = true;
    L12:
        if (r101 != Long.MIN_VALUE) goto L16;
        r104 = false;
    L16:
        if ((r105 | r104) == false) goto L25;
        long r106 = r100 * r101;
        if (r100 != 0) goto L20;
    L21:
        r103 = r106;
        goto L23
    L20:
        if ((r106 / r100) != r101) goto L25;
    L10:
        r105 = false;
    L25:
        throw new ArithmeticException();
    }

    public static Duration ofMillis(long r100) {
        long r101 = r100 / 1000;
        int r102 = (int) (r100 % 1000);
        if (r102 >= 0) goto L6;
        r102 = r102 + 1000;
        r101 = r101 - 1;
    L6:
        return a(r101, r102 * 1000000);
    }

    public static Duration ofMinutes(long r100) {
        long r101 = 60;
        int r102 = ((Long.numberOfLeadingZeros(r100) + Long.numberOfLeadingZeros(~r100)) + Long.numberOfLeadingZeros(r101)) + Long.numberOfLeadingZeros(~r101);
        if (r102 <= 65) goto L6;
        long r103 = r100 * r101;
    L23:
        return a(r103, 0);
    L6:
        if (r102 < 64) goto L25;
        boolean r104 = true;
        if (r100 < 0) goto L10;
        boolean r105 = true;
    L12:
        if (r101 != Long.MIN_VALUE) goto L16;
        r104 = false;
    L16:
        if ((r105 | r104) == false) goto L25;
        long r106 = r100 * r101;
        if (r100 != 0) goto L20;
    L21:
        r103 = r106;
        goto L23
    L20:
        if ((r106 / r100) != r101) goto L25;
    L10:
        r105 = false;
    L25:
        throw new ArithmeticException();
    }

    public static Duration ofNanos(long r100) {
        long r101 = r100 / C.NANOS_PER_SECOND;
        int r102 = (int) (r100 % C.NANOS_PER_SECOND);
        if (r102 >= 0) goto L6;
        r102 = (int) (((long) r102) + C.NANOS_PER_SECOND);
        r101 = r101 - 1;
    L6:
        return a(r101, r102);
    }

    public static Duration ofSeconds(long r100) {
        return a(r100, 0);
    }

    public static Duration parse(CharSequence r110) {
        Objects.requireNonNull(r110, "text");
        Matcher r100 = c.f21491a.matcher(r110);
        if (r100.matches() == false) goto L96;
        int r101 = r100.start(3);
        int r102 = r100.end(3);
        boolean r103 = true;
        if (r101 >= 0) goto L7;
    L11:
        boolean r104 = false;
    L12:
        if (r104 == true) goto L96;
        int r105 = r100.start(1);
        int r106 = r100.end(1);
        if (r105 >= 0) goto L16;
    L20:
        boolean r107 = false;
    L21:
        int r108 = r100.start(2);
        int r109 = r100.end(2);
        int r111 = r100.start(4);
        int r112 = r100.end(4);
        int r113 = r100.start(5);
        int r114 = r100.end(5);
        int r115 = r100.start(6);
        int r116 = r100.end(6);
        int r117 = r100.start(7);
        int r118 = r100.end(7);
        if (r108 >= 0) goto L26;
        if (r111 >= 0) goto L26;
        if (r113 >= 0) goto L26;
        if (r115 < 0) goto L96;
    L26:
        long r119 = c(r110, r108, r109, 86400, "days");
        long r120 = c(r110, r111, r112, AnnouncementViewModel.HOUR_DURATION, "hours");
        long r121 = c(r110, r113, r114, 60, DocumentType.MINUTES_NAME);
        long r122 = c(r110, r115, r116, 1, "seconds");
        if (r115 >= 0) goto L29;
    L31:
        boolean r123 = false;
    L32:
        if (r123 == false) goto L34;
        int r124 = -1;
    L35:
        if (r117 < 0) goto L50;
        if (r118 < 0) goto L50;
        int r125 = r118 - r117;
        if (r125 == 0) goto L50;
        int r126 = Integer.parseInt(r110.subSequence(r117, r118).toString(), 10);     // Catch: Throwable -> L45 NumberFormatException -> L47
    L42:
        if (r125 >= 9) goto L44;
        r126 = r126 * 10;
        r125 = r125 + 1;
        goto L42
    L44:
        int r127 = r126 * r124;
    L51:
        long r128 = r121 + r122;
        if ((r122 ^ r121) >= 0) goto L54;
        boolean r129 = true;
    L56:
        if ((r121 ^ r128) < 0) goto L58;
        boolean r130 = true;
    L97:
        if ((r129 | r130) == false) goto L91;
        long r131 = r120 + r128;
        if ((r128 ^ r120) >= 0) goto L64;
        boolean r132 = true;
    L66:
        if ((r120 ^ r131) < 0) goto L68;
        boolean r133 = true;
    L70:
        if ((r132 | r133) == false) goto L89;
        long r134 = r119 + r131;
        if ((r131 ^ r119) >= 0) goto L74;
        boolean r135 = true;
    L76:
        if ((r119 ^ r134) >= 0) goto L80;
        r103 = false;
    L80:
        if ((r103 | r135) == false) goto L87;
        if (r107 == false) goto L85;
        return ofSeconds(r134, r127).negated();
    L85:
        return ofSeconds(r134, r127);
    L87:
        throw new ArithmeticException();     // Catch: ArithmeticException -> L92
    L74:
        r135 = false;
        goto L76
    L89:
        throw new ArithmeticException();     // Catch: ArithmeticException -> L92
    L68:
        r133 = false;
        goto L70
    L64:
        r132 = false;
        goto L66
    L91:
        throw new ArithmeticException();     // Catch: ArithmeticException -> L92
    L92:
        e = move-exception;
        throw ((DateTimeParseException) new DateTimeParseException("Text cannot be parsed to a Duration: overflow", r110, 0).initCause(e));
    L58:
        r130 = false;
        goto L97
    L54:
        r129 = false;
    L45:
        e = move-exception;
        throw ((DateTimeParseException) new DateTimeParseException("Text cannot be parsed to a Duration: fraction", r110, 0).initCause(e));
    L50:
        r127 = 0;
        goto L51
    L34:
        r124 = 1;
        goto L35
    L29:
        if (r110.charAt(r115) != '-') goto L31;
        r123 = true;
        goto L32
    L16:
        if (r106 != (r105 + 1)) goto L20;
        if (r110.charAt(r105) != '-') goto L20;
        r107 = true;
        goto L21
    L7:
        if (r102 != (r101 + 1)) goto L11;
        if (r110.charAt(r101) != 'T') goto L11;
        r104 = true;
    L96:
        throw new DateTimeParseException("Text cannot be parsed to a Duration", r110, 0);
    }

    public static Duration readExternal(DataInput r100) throws IOException {
        return ofSeconds(r100.readLong(), r100.readInt());
    }

    private void readObject(ObjectInputStream r100) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    @Override // bytedance.jvm.time.temporal.i
    public bytedance.jvm.time.temporal.b addTo(bytedance.jvm.time.temporal.b r100) {
        long r101 = this.seconds;
        if (r101 == 0) goto L5;
        r100 = r100.plus(r101, ChronoUnit.SECONDS);
    L5:
        int r102 = this.nanos;
        if (r102 != 0) goto L8;
        return r100;
    L8:
        return r100.plus(r102, ChronoUnit.NANOS);
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(Duration r100) {
        int r101 = Long.compare(this.seconds, r100.seconds);
        if (r101 == 0) goto L6;
        return r101;
    L6:
        return this.nanos - r100.nanos;
    }

    public Duration dividedBy(long r100) {
        if (r100 == 0) goto L10;
        if (r100 != 1) goto L8;
        return this;
    L8:
        return b(e().divide(BigDecimal.valueOf(r100), RoundingMode.DOWN));
    L10:
        throw new ArithmeticException("Cannot divide by zero");
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof Duration) == false) goto L14;
        Duration r101 = (Duration) r100;
        if (this.seconds == r101.seconds) goto L10;
    L12:
        return false;
    L10:
        if (this.nanos != r101.nanos) goto L12;
        return true;
    L14:
        return false;
    }

    @Override // bytedance.jvm.time.temporal.i
    public long get(bytedance.jvm.time.temporal.m r100) {
        if (r100 != ChronoUnit.SECONDS) goto L7;
        return this.seconds;
    L7:
        if (r100 != ChronoUnit.NANOS) goto L11;
        return this.nanos;
    L11:
        throw new UnsupportedTemporalTypeException("Unsupported unit: " + r100);
    }

    public Duration minus(Duration r100) {
        long r101 = r100.getSeconds();
        int r102 = r100.getNano();
        if (r101 != Long.MIN_VALUE) goto L7;
        return d(Long.MAX_VALUE, -r102).d(1, 0);
    L7:
        return d(-r101, -r102);
    }

    public Duration minusDays(long r100) {
        if (r100 != Long.MIN_VALUE) goto L6;
        return plusDays(Long.MAX_VALUE).plusDays(1);
    L6:
        return plusDays(-r100);
    }

    public Duration minusHours(long r100) {
        if (r100 != Long.MIN_VALUE) goto L6;
        return plusHours(Long.MAX_VALUE).plusHours(1);
    L6:
        return plusHours(-r100);
    }

    public Duration minusMillis(long r100) {
        if (r100 != Long.MIN_VALUE) goto L6;
        return plusMillis(Long.MAX_VALUE).plusMillis(1);
    L6:
        return plusMillis(-r100);
    }

    public Duration minusMinutes(long r100) {
        if (r100 != Long.MIN_VALUE) goto L6;
        return plusMinutes(Long.MAX_VALUE).plusMinutes(1);
    L6:
        return plusMinutes(-r100);
    }

    public Duration minusNanos(long r100) {
        if (r100 != Long.MIN_VALUE) goto L6;
        return plusNanos(Long.MAX_VALUE).plusNanos(1);
    L6:
        return plusNanos(-r100);
    }

    public Duration minusSeconds(long r100) {
        if (r100 != Long.MIN_VALUE) goto L6;
        return plusSeconds(Long.MAX_VALUE).plusSeconds(1);
    L6:
        return plusSeconds(-r100);
    }

    public Duration multipliedBy(long r100) {
        if (r100 != 0) goto L7;
        return ZERO;
    L7:
        if (r100 != 1) goto L10;
        return this;
    L10:
        return b(e().multiply(BigDecimal.valueOf(r100)));
    }

    public Duration plus(Duration r100) {
        return d(r100.getSeconds(), r100.getNano());
    }

    public Duration plusDays(long r110) {
        long r100 = 86400;
        int r101 = ((Long.numberOfLeadingZeros(r110) + Long.numberOfLeadingZeros(~r110)) + Long.numberOfLeadingZeros(r100)) + Long.numberOfLeadingZeros(~r100);
        if (r101 <= 65) goto L6;
        long r111 = r110 * r100;
    L23:
        return d(r111, 0);
    L6:
        if (r101 < 64) goto L25;
        boolean r102 = true;
        if (r110 < 0) goto L10;
        boolean r103 = true;
    L12:
        if (r100 != Long.MIN_VALUE) goto L16;
        r102 = false;
    L16:
        if ((r102 | r103) == false) goto L25;
        long r104 = r110 * r100;
        if (r110 != 0) goto L20;
    L21:
        r111 = r104;
        goto L23
    L20:
        if ((r104 / r110) != r100) goto L25;
    L10:
        r103 = false;
    L25:
        throw new ArithmeticException();
    }

    public Duration plusHours(long r110) {
        long r100 = AnnouncementViewModel.HOUR_DURATION;
        int r101 = ((Long.numberOfLeadingZeros(r110) + Long.numberOfLeadingZeros(~r110)) + Long.numberOfLeadingZeros(r100)) + Long.numberOfLeadingZeros(~r100);
        if (r101 <= 65) goto L6;
        long r111 = r110 * r100;
    L23:
        return d(r111, 0);
    L6:
        if (r101 < 64) goto L25;
        boolean r102 = true;
        if (r110 < 0) goto L10;
        boolean r103 = true;
    L12:
        if (r100 != Long.MIN_VALUE) goto L16;
        r102 = false;
    L16:
        if ((r102 | r103) == false) goto L25;
        long r104 = r110 * r100;
        if (r110 != 0) goto L20;
    L21:
        r111 = r104;
        goto L23
    L20:
        if ((r104 / r110) != r100) goto L25;
    L10:
        r103 = false;
    L25:
        throw new ArithmeticException();
    }

    public Duration plusMillis(long r100) {
        return d(r100 / 1000, (r100 % 1000) * 1000000);
    }

    public Duration plusMinutes(long r110) {
        long r100 = 60;
        int r101 = ((Long.numberOfLeadingZeros(r110) + Long.numberOfLeadingZeros(~r110)) + Long.numberOfLeadingZeros(r100)) + Long.numberOfLeadingZeros(~r100);
        if (r101 <= 65) goto L6;
        long r111 = r110 * r100;
    L23:
        return d(r111, 0);
    L6:
        if (r101 < 64) goto L25;
        boolean r102 = true;
        if (r110 < 0) goto L10;
        boolean r103 = true;
    L12:
        if (r100 != Long.MIN_VALUE) goto L16;
        r102 = false;
    L16:
        if ((r102 | r103) == false) goto L25;
        long r104 = r110 * r100;
        if (r110 != 0) goto L20;
    L21:
        r111 = r104;
        goto L23
    L20:
        if ((r104 / r110) != r100) goto L25;
    L10:
        r103 = false;
    L25:
        throw new ArithmeticException();
    }

    public Duration plusNanos(long r100) {
        return d(0, r100);
    }

    public Duration plusSeconds(long r100) {
        return d(r100, 0);
    }

    @Override // bytedance.jvm.time.temporal.i
    public bytedance.jvm.time.temporal.b subtractFrom(bytedance.jvm.time.temporal.b r100) {
        long r101 = this.seconds;
        if (r101 == 0) goto L5;
        r100 = r100.minus(r101, ChronoUnit.SECONDS);
    L5:
        int r102 = this.nanos;
        if (r102 != 0) goto L8;
        return r100;
    L8:
        return r100.minus(r102, ChronoUnit.NANOS);
    }

    public Duration truncatedTo(bytedance.jvm.time.temporal.m r110) {
        Objects.requireNonNull(r110, Scraps.INNER_UNIT);
        if (r110 != ChronoUnit.SECONDS) goto L11;
        long r100 = this.seconds;
        if (r100 >= 0) goto L9;
        if (this.nanos != 0) goto L11;
    L9:
        return new Duration(r100, 0);
    L11:
        if (r110 != ChronoUnit.NANOS) goto L13;
        return this;
    L13:
        Duration r111 = r110.getDuration();
        if (r111.getSeconds() > 86400) goto L22;
        long r101 = r111.toNanos();
        if ((86400000000000L % r101) != 0) goto L20;
        long r102 = ((this.seconds % 86400) * C.NANOS_PER_SECOND) + ((long) this.nanos);
        return plusNanos(((r102 / r101) * r101) - r102);
    L20:
        throw new UnsupportedTemporalTypeException("Unit must divide into a standard day without remainder");
    L22:
        throw new UnsupportedTemporalTypeException("Unit is too large to be used for truncation");
    }

    public Duration withNanos(int r100) {
        ChronoField.NANO_OF_SECOND.checkValidIntValue(r100);
        return a(this.seconds, r100);
    }

    public Duration withSeconds(long r100) {
        return a(r100, this.nanos);
    }

    public void writeExternal(DataOutput r100) throws IOException {
        r100.writeLong(this.seconds);
        r100.writeInt(this.nanos);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Duration r100) {
        return compareTo2(r100);
    }

    public long dividedBy(Duration r100) {
        Objects.requireNonNull(r100, "divisor");
        return e().divideToIntegralValue(r100.e()).longValueExact();
    }

    public Duration(long r100, int r101) {
        this.seconds = r100;
        this.nanos = r101;
    }

    public static Duration a(long r100, int r101) {
        if ((((long) r101) | r100) != 0) goto L7;
        return ZERO;
    L7:
        return new Duration(r100, r101);
    }

    public static Duration between(bytedance.jvm.time.temporal.b r100, bytedance.jvm.time.temporal.b r101) {
        return ofNanos(r100.until(r101, ChronoUnit.NANOS));
    L4:
        long r102 = r100.until(r101, ChronoUnit.SECONDS);
        long r103 = 0;
        ChronoField r104 = ChronoField.NANO_OF_SECOND;     // Catch: DateTimeException -> L18
        long r105 = r101.getLong(r104) - r100.getLong(r104);
        if (r102 > 0) goto L9;
    L11:
        if (r102 < 0) goto L13;
    L15:
        r103 = r105;
        goto L17
    L13:
        if (r105 <= 0) goto L15;
        r102 = r102 - 1;
        goto L15
    L9:
        if (r105 >= 0) goto L11;
        r102 = r102 + 1;
    L17:
        return ofSeconds(r102, r103);
    }

    public static Duration of(long r100, bytedance.jvm.time.temporal.m r101) {
        return ZERO.plus(r100, r101);
    }

    public static Duration ofSeconds(long r110, long r111) {
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

    public final Duration d(long r110, long r111) {
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
        return ofSeconds(r104, ((long) this.nanos) + r114);
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

    public Duration minus(long r100, bytedance.jvm.time.temporal.m r101) {
        if (r100 != Long.MIN_VALUE) goto L6;
        return plus(Long.MAX_VALUE, r101).plus(1, r101);
    L6:
        return plus(-r100, r101);
    }

    public Duration plus(long r110, bytedance.jvm.time.temporal.m r111) {
        Objects.requireNonNull(r111, Scraps.INNER_UNIT);
        boolean r100 = false;
        if (r111 != ChronoUnit.DAYS) goto L27;
        long r101 = 86400;
        int r112 = ((Long.numberOfLeadingZeros(r110) + Long.numberOfLeadingZeros(~r110)) + Long.numberOfLeadingZeros(r101)) + Long.numberOfLeadingZeros(~r101);
        if (r112 <= 65) goto L7;
        long r102 = r110 * r101;
    L23:
        return d(r102, 0);
    L7:
        if (r112 < 64) goto L25;
        if (r110 < 0) goto L11;
        boolean r103 = true;
    L13:
        if (r101 == Long.MIN_VALUE) goto L16;
        r100 = true;
    L16:
        if ((r100 | r103) == false) goto L25;
        long r104 = r110 * r101;
        if (r110 != 0) goto L20;
    L21:
        r102 = r104;
        goto L23
    L20:
        if ((r104 / r110) != r101) goto L25;
    L11:
        r103 = false;
    L25:
        throw new ArithmeticException();
    L27:
        if (r111.isDurationEstimated() == true) goto L74;
        if (r110 != 0) goto L32;
        return this;
    L32:
        if ((r111 instanceof ChronoUnit) == false) goto L71;
        int r105 = a.f21489a[((ChronoUnit) r111).ordinal()];
        if (r105 == 1) goto L70;
        if (r105 == 2) goto L68;
        if (r105 == 3) goto L66;
        if (r105 == 4) goto L64;
        long r106 = r111.getDuration().seconds;
        int r113 = ((Long.numberOfLeadingZeros(r106) + Long.numberOfLeadingZeros(~r106)) + Long.numberOfLeadingZeros(r110)) + Long.numberOfLeadingZeros(~r110);
        if (r113 <= 65) goto L44;
        long r107 = r106 * r110;
    L60:
        return plusSeconds(r107);
    L44:
        if (r113 < 64) goto L62;
        if (r106 < 0) goto L48;
        boolean r108 = true;
    L50:
        if (r110 == Long.MIN_VALUE) goto L53;
        r100 = true;
    L53:
        if ((r108 | r100) == false) goto L62;
        long r109 = r106 * r110;
        if (r106 != 0) goto L57;
    L58:
        r107 = r109;
        goto L60
    L57:
        if ((r109 / r106) != r110) goto L62;
    L48:
        r108 = false;
    L62:
        throw new ArithmeticException();
    L64:
        return plusSeconds(r110);
    L66:
        return plusMillis(r110);
    L68:
        return plusSeconds((r110 / C.NANOS_PER_SECOND) * 1000).plusNanos((r110 % C.NANOS_PER_SECOND) * 1000);
    L70:
        return plusNanos(r110);
    L71:
        Duration r114 = r111.getDuration().multipliedBy(r110);
        return plusSeconds(r114.getSeconds()).plusNanos(r114.getNano());
    L74:
        throw new UnsupportedTemporalTypeException("Unit must not have an estimated duration");
    }

    public static long c(CharSequence r100, int r101, int r102, int r103, String r104) {
        if (r101 < 0) goto L12;
        if (r102 < 0) goto L16;
        return bytedance.jvm.time.a.a(Long.parseLong(r100.subSequence(r101, r102).toString(), 10), r103);
    L7:
        e = move-exception;
        throw ((DateTimeParseException) new DateTimeParseException("Text cannot be parsed to a Duration: ".concat(r104), r100, 0).initCause(e));
    L16:
        return 0;
    L12:
        return 0;
    }
}
