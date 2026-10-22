package bytedance.jvm.time;

import bytedance.jvm.time.temporal.ChronoField;
import bytedance.jvm.time.temporal.UnsupportedTemporalTypeException;
import bytedance.jvm.time.temporal.ValueRange;
import bytedance.jvm.time.zone.ZoneRules;
import com.bytedance.android.livesdk.announcement.AnnouncementViewModel;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.slf4j.Marker;

/* JADX INFO: loaded from: classes3.dex */
public final class ZoneOffset extends ZoneId implements bytedance.jvm.time.temporal.d, bytedance.jvm.time.temporal.e, Comparable<ZoneOffset> {
    public static final ZoneOffset MAX = null;
    public static final ZoneOffset MIN = null;
    public static final ZoneOffset UTC = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentMap<Integer, ZoneOffset> f21515b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ConcurrentMap<String, ZoneOffset> f21516c = null;
    private static final long serialVersionUID = 2357656521762053153L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final transient String f21517a;
    private final int totalSeconds;

    static {
        f21515b = new ConcurrentHashMap(16, 0.75f, 4);
        f21516c = new ConcurrentHashMap(16, 0.75f, 4);
        UTC = ofTotalSeconds(0);
        MIN = ofTotalSeconds(-64800);
        MAX = ofTotalSeconds(64800);
    }

    private Object writeReplace() {
        return new Ser((byte) 8, this);
    }

    @Override // bytedance.jvm.time.ZoneId
    public ZoneRules getRules() {
        return ZoneRules.of(this);
    }

    @Override // bytedance.jvm.time.ZoneId
    public String getId() {
        return this.f21517a;
    }

    public int getTotalSeconds() {
        return this.totalSeconds;
    }

    @Override // bytedance.jvm.time.ZoneId
    public int hashCode() {
        return this.totalSeconds;
    }

    @Override // bytedance.jvm.time.ZoneId
    public String toString() {
        return this.f21517a;
    }

    public ZoneOffset(int r100) {
        this.totalSeconds = r100;
        if (r100 != 0) goto L5;
        String r101 = "Z";
    L24:
        this.f21517a = r101;
        return;
    L5:
        int r102 = Math.abs(r100);
        StringBuilder r103 = new StringBuilder();
        int r104 = r102 / AnnouncementViewModel.HOUR_DURATION;
        int r105 = (r102 / 60) % 60;
        if (r100 >= 0) goto L8;
        String r106 = "-";
    L9:
        r103.append(r106);
        if (r104 >= 10) goto L12;
        String r107 = "0";
    L13:
        r103.append(r107);
        r103.append(r104);
        String r108 = ":0";
        if (r105 >= 10) goto L16;
        String r109 = ":0";
    L17:
        r103.append(r109);
        r103.append(r105);
        int r110 = r102 % 60;
        if (r110 == 0) goto L23;
        if (r110 < 10) goto L22;
        r108 = ":";
    L22:
        r103.append(r108);
        r103.append(r110);
    L23:
        r101 = r103.toString();
        goto L24
    L16:
        r109 = ":";
        goto L17
    L12:
        r107 = "";
        goto L13
    L8:
        r106 = Marker.ANY_NON_NULL_MARKER;
        goto L9
    }

    public static ZoneOffset from(bytedance.jvm.time.temporal.d r100) {
        Objects.requireNonNull(r100, "temporal");
        ZoneOffset r101 = (ZoneOffset) r100.query(bytedance.jvm.time.temporal.k.f21717d);
        if (r101 == null) goto L6;
        return r101;
    L6:
        throw new DateTimeException("Unable to obtain ZoneOffset from TemporalAccessor: " + r100 + " of type " + r100.getClass().getName());
    }

    public static ZoneOffset of(String r100) {
        Objects.requireNonNull(r100, "offsetId");
        ZoneOffset r101 = (ZoneOffset) ((ConcurrentHashMap) f21516c).get(r100);
        if (r101 == null) goto L5;
        return r101;
    L5:
        int r102 = r100.length();
        if (r102 != 2) goto L8;
        r100 = r100.charAt(0) + "0" + r100.charAt(1);
    L24:
        int r103 = b(r100, 1, false);
        int r104 = 0;
    L25:
        int r105 = 0;
    L26:
        char r106 = r100.charAt(0);
        if (r106 == '+') goto L32;
        if (r106 == '-') goto L32;
        throw new DateTimeException("Invalid ID for ZoneOffset, plus/minus not found when expected: ".concat(r100));
    L32:
        if (r106 != '-') goto L36;
        return ofHoursMinutesSeconds(-r103, -r104, -r105);
    L36:
        return ofHoursMinutesSeconds(r103, r104, r105);
    L8:
        if (r102 == 3) goto L24;
        if (r102 != 5) goto L12;
        r103 = b(r100, 1, false);
        r104 = b(r100, 3, false);
        goto L25
    L12:
        if (r102 != 6) goto L14;
        r103 = b(r100, 1, false);
        r104 = b(r100, 4, true);
        goto L25
    L14:
        if (r102 != 7) goto L16;
        r103 = b(r100, 1, false);
        r104 = b(r100, 3, false);
        r105 = b(r100, 5, false);
        goto L26
    L16:
        if (r102 != 9) goto L19;
        r103 = b(r100, 1, false);
        r104 = b(r100, 4, true);
        r105 = b(r100, 7, true);
        goto L26
    L19:
        throw new DateTimeException("Invalid ID for ZoneOffset, invalid format: ".concat(r100));
    }

    public static ZoneOffset ofHours(int r100) {
        return ofHoursMinutesSeconds(r100, 0, 0);
    }

    public static ZoneOffset ofTotalSeconds(int r100) {
        if (r100 < (-64800)) goto L15;
        if (r100 > 64800) goto L15;
        if ((r100 % 900) != 0) goto L13;
        Integer r101 = Integer.valueOf(r100);
        ConcurrentMap<Integer, ZoneOffset> r102 = f21515b;
        ZoneOffset r103 = (ZoneOffset) ((ConcurrentHashMap) r102).get(r101);
        if (r103 != null) goto L16;
        ZoneOffset r104 = new ZoneOffset(r100);
        ((ConcurrentHashMap) r102).putIfAbsent(r101, r104);
        ZoneOffset r105 = (ZoneOffset) ((ConcurrentHashMap) r102).get(r101);
        ConcurrentMap<String, ZoneOffset> r106 = f21516c;
        ConcurrentHashMap r107 = (ConcurrentHashMap) r106;
        r107.putIfAbsent(r105.getId(), r105);
        return r105;
    L16:
        return r103;
    L13:
        return new ZoneOffset(r100);
    L15:
        throw new DateTimeException("Zone offset not in valid range: -18:00 to +18:00");
    }

    public static ZoneOffset readExternal(DataInput r100) throws IOException {
        byte r101 = r100.readByte();
        if (r101 != 127) goto L6;
        return ofTotalSeconds(r100.readInt());
    L6:
        return ofTotalSeconds(r101 * 900);
    }

    private void readObject(ObjectInputStream r100) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    @Override // bytedance.jvm.time.temporal.e
    public bytedance.jvm.time.temporal.b adjustInto(bytedance.jvm.time.temporal.b r100) {
        return r100.with(ChronoField.OFFSET_SECONDS, this.totalSeconds);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(ZoneOffset r100) {
        return compareTo2(r100);
    }

    @Override // bytedance.jvm.time.ZoneId
    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ZoneOffset) == true) goto L8;
        return false;
    L8:
        if (this.totalSeconds == ((ZoneOffset) r100).totalSeconds) goto L13;
        return false;
    L13:
        return true;
    }

    @Override // bytedance.jvm.time.temporal.d
    public int get(bytedance.jvm.time.temporal.j r100) {
        if (r100 != ChronoField.OFFSET_SECONDS) goto L7;
        return this.totalSeconds;
    L7:
        if ((r100 instanceof ChronoField) == true) goto L11;
        return range(r100).checkValidIntValue(getLong(r100), r100);
    L11:
        throw new UnsupportedTemporalTypeException("Unsupported field: " + r100);
    }

    @Override // bytedance.jvm.time.temporal.d
    public long getLong(bytedance.jvm.time.temporal.j r100) {
        if (r100 != ChronoField.OFFSET_SECONDS) goto L7;
        return this.totalSeconds;
    L7:
        if ((r100 instanceof ChronoField) == true) goto L11;
        return r100.getFrom(this);
    L11:
        throw new UnsupportedTemporalTypeException("Unsupported field: " + r100);
    }

    @Override // bytedance.jvm.time.temporal.d
    public boolean isSupported(bytedance.jvm.time.temporal.j r100) {
        if ((r100 instanceof ChronoField) == true) goto L5;
        if (r100 != null) goto L11;
    L13:
        return false;
    L11:
        if (r100.isSupportedBy(this) == false) goto L13;
        return true;
    L5:
        if (r100 == ChronoField.OFFSET_SECONDS) goto L15;
        return false;
    L15:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // bytedance.jvm.time.temporal.d
    public <R> R query(bytedance.jvm.time.temporal.l<R> r100) {
        if (r100 != bytedance.jvm.time.temporal.k.f21717d) goto L5;
    L9:
        return this;
    L5:
        if (r100 == bytedance.jvm.time.temporal.k.f21718e) goto L9;
        return (R) bytedance.jvm.time.temporal.c.b(this, r100);
    }

    @Override // bytedance.jvm.time.temporal.d
    public ValueRange range(bytedance.jvm.time.temporal.j r100) {
        return bytedance.jvm.time.temporal.c.c(this, r100);
    }

    @Override // bytedance.jvm.time.ZoneId
    public void write(DataOutput r100) throws IOException {
        r100.writeByte(8);
        writeExternal(r100);
    }

    public void writeExternal(DataOutput r100) throws IOException {
        int r101 = this.totalSeconds;
        if ((r101 % 900) != 0) goto L5;
        int r102 = r101 / 900;
    L6:
        r100.writeByte(r102);
        if (r102 != 127) goto L10;
        r100.writeInt(r101);
        return;
    L10:
        return;
    L5:
        r102 = 127;
        goto L6
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(ZoneOffset r100) {
        return r100.totalSeconds - this.totalSeconds;
    }

    public static ZoneOffset ofHoursMinutes(int r100, int r101) {
        return ofHoursMinutesSeconds(r100, r101, 0);
    }

    public static int b(CharSequence r100, int r101, boolean r102) {
        if (r102 == true) goto L4;
    L8:
        char r103 = r100.charAt(r101);
        char r104 = r100.charAt(r101 + 1);
        if (r103 < '0') goto L17;
        if (r103 > '9') goto L17;
        if (r104 < '0') goto L17;
        if (r104 > '9') goto L17;
        return ((r103 - '0') * 10) + (r104 - '0');
    L17:
        throw new DateTimeException("Invalid ID for ZoneOffset, non numeric characters found: " + r100);
    L4:
        if (r100.charAt(r101 - 1) == ':') goto L8;
        throw new DateTimeException("Invalid ID for ZoneOffset, colon not found when expected: " + r100);
    }

    public static ZoneOffset ofHoursMinutesSeconds(int r100, int r101, int r102) {
        if (r100 < (-18)) goto L45;
        if (r100 > 18) goto L45;
        if (r100 <= 0) goto L12;
        if (r101 < 0) goto L11;
        if (r102 < 0) goto L11;
    L26:
        if (r101 < (-59)) goto L43;
        if (r101 > 59) goto L43;
        if (r102 < (-59)) goto L41;
        if (r102 > 59) goto L41;
        if (Math.abs(r100) != 18) goto L39;
        if ((r101 | r102) == 0) goto L39;
        throw new DateTimeException("Zone offset not in valid range: -18:00 to +18:00");
    L39:
        return ofTotalSeconds(((r100 * AnnouncementViewModel.HOUR_DURATION) + (r101 * 60)) + r102);
    L41:
        throw new DateTimeException("Zone offset seconds not in valid range: value " + r102 + " is not in the range -59 to 59");
    L43:
        throw new DateTimeException("Zone offset minutes not in valid range: value " + r101 + " is not in the range -59 to 59");
    L11:
        throw new DateTimeException("Zone offset minutes and seconds must be positive because hours is positive");
    L12:
        if (r100 >= 0) goto L18;
        if (r101 > 0) goto L17;
        if (r102 <= 0) goto L26;
    L17:
        throw new DateTimeException("Zone offset minutes and seconds must be negative because hours is negative");
    L18:
        if (r101 <= 0) goto L20;
        if (r102 >= 0) goto L20;
    L24:
        throw new DateTimeException("Zone offset minutes and seconds must have the same sign");
    L20:
        if (r101 >= 0) goto L26;
        if (r102 > 0) goto L24;
    L45:
        throw new DateTimeException("Zone offset hours not in valid range: value " + r100 + " is not in the range -18 to 18");
    }
}
