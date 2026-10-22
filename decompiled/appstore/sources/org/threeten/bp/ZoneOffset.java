package org.threeten.bp;

import com.bytedanceos.common.ad.param.AdReportParam;
import ig.d;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.Temporal;
import org.threeten.bp.temporal.TemporalAccessor;
import org.threeten.bp.temporal.TemporalAdjuster;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.TemporalQuery;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;
import org.threeten.bp.temporal.ValueRange;
import org.threeten.bp.temporal.b;
import org.threeten.bp.zone.ZoneRules;

/* JADX INFO: loaded from: classes4.dex */
public final class ZoneOffset extends ZoneId implements TemporalAccessor, TemporalAdjuster, Comparable<ZoneOffset>, Serializable {
    public static final TemporalQuery<ZoneOffset> FROM = null;
    private static final ConcurrentMap<String, ZoneOffset> ID_CACHE = null;
    public static final ZoneOffset MAX = null;
    private static final int MAX_SECONDS = 64800;
    public static final ZoneOffset MIN = null;
    private static final int MINUTES_PER_HOUR = 60;
    private static final ConcurrentMap<Integer, ZoneOffset> SECONDS_CACHE = null;
    private static final int SECONDS_PER_HOUR = 3600;
    private static final int SECONDS_PER_MINUTE = 60;
    public static final ZoneOffset UTC = null;
    private static final long serialVersionUID = 2357656521762053153L;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final transient String f23083id;
    private final int totalSeconds;

    public static class a implements TemporalQuery {
        public a() {
        }

        public ZoneOffset a(TemporalAccessor r10) {
            return ZoneOffset.from(r10);
        }

        @Override // org.threeten.bp.temporal.TemporalQuery
        public /* bridge */ /* synthetic */ Object queryFrom(TemporalAccessor r10) {
            return a(r10);
        }
    }

    static {
        FROM = new a();
        SECONDS_CACHE = new ConcurrentHashMap(16, 0.75f, 4);
        ID_CACHE = new ConcurrentHashMap(16, 0.75f, 4);
        UTC = ofTotalSeconds(0);
        MIN = ofTotalSeconds(-64800);
        MAX = ofTotalSeconds(MAX_SECONDS);
    }

    private ZoneOffset(int r10) {
        this.totalSeconds = r10;
        this.f23083id = buildId(r10);
    }

    private static String buildId(int r10) {
        if (r10 != 0) goto L5;
        return "Z";
    L5:
        int r11 = Math.abs(r10);
        StringBuilder r12 = new StringBuilder();
        int r13 = r11 / 3600;
        int r14 = (r11 / 60) % 60;
        if (r10 >= 0) goto L8;
        String r15 = "-";
    L9:
        r12.append(r15);
        if (r13 >= 10) goto L12;
        String r16 = AdReportParam.ClickPosType.SKIP;
    L13:
        r12.append(r16);
        r12.append(r13);
        String r17 = ":";
        if (r14 >= 10) goto L16;
        String r18 = ":0";
    L17:
        r12.append(r18);
        r12.append(r14);
        int r19 = r11 % 60;
        if (r19 == 0) goto L23;
        if (r19 >= 10) goto L21;
        r17 = ":0";
    L21:
        r12.append(r17);
        r12.append(r19);
    L23:
        return r12.toString();
    L16:
        r18 = ":";
        goto L17
    L12:
        r16 = "";
        goto L13
    L8:
        r15 = "+";
        goto L9
    }

    public static ZoneOffset from(TemporalAccessor r10) {
        ZoneOffset r11 = (ZoneOffset) r10.query(b.d());
        if (r11 == null) goto L6;
        return r11;
    L6:
        throw new DateTimeException("Unable to obtain ZoneOffset from TemporalAccessor: " + r10 + ", type " + r10.getClass().getName());
    }

    public static ZoneOffset of(String r10) {
        d.h(r10, "offsetId");
        ZoneOffset r11 = ID_CACHE.get(r10);
        if (r11 == null) goto L5;
        return r11;
    L5:
        int r12 = r10.length();
        if (r12 != 2) goto L8;
        r10 = r10.charAt(0) + AdReportParam.ClickPosType.SKIP + r10.charAt(1);
    L25:
        int r13 = parseNumber(r10, 1, false);
        int r14 = 0;
        int r15 = 0;
    L26:
        char r16 = r10.charAt(0);
        if (r16 == '+') goto L32;
        if (r16 == '-') goto L32;
        throw new DateTimeException("Invalid ID for ZoneOffset, plus/minus not found when expected: " + r10);
    L32:
        if (r16 != '-') goto L36;
        return ofHoursMinutesSeconds(-r13, -r14, -r15);
    L36:
        return ofHoursMinutesSeconds(r13, r14, r15);
    L8:
        if (r12 == 3) goto L25;
        if (r12 != 5) goto L12;
        r13 = parseNumber(r10, 1, false);
        r14 = parseNumber(r10, 3, false);
    L22:
        r15 = 0;
        goto L26
    L12:
        if (r12 != 6) goto L14;
        r13 = parseNumber(r10, 1, false);
        r14 = parseNumber(r10, 4, true);
        goto L22
    L14:
        if (r12 != 7) goto L16;
        r13 = parseNumber(r10, 1, false);
        r14 = parseNumber(r10, 3, false);
        r15 = parseNumber(r10, 5, false);
        goto L26
    L16:
        if (r12 != 9) goto L19;
        r13 = parseNumber(r10, 1, false);
        r14 = parseNumber(r10, 4, true);
        r15 = parseNumber(r10, 7, true);
        goto L26
    L19:
        throw new DateTimeException("Invalid ID for ZoneOffset, invalid format: " + r10);
    }

    public static ZoneOffset ofHours(int r10) {
        return ofHoursMinutesSeconds(r10, 0, 0);
    }

    public static ZoneOffset ofHoursMinutes(int r10, int r11) {
        return ofHoursMinutesSeconds(r10, r11, 0);
    }

    public static ZoneOffset ofHoursMinutesSeconds(int r10, int r11, int r12) {
        validate(r10, r11, r12);
        return ofTotalSeconds(totalSeconds(r10, r11, r12));
    }

    public static ZoneOffset ofTotalSeconds(int r10) {
        if (Math.abs(r10) > MAX_SECONDS) goto L13;
        if ((r10 % 900) != 0) goto L11;
        Integer r11 = Integer.valueOf(r10);
        ConcurrentMap<Integer, ZoneOffset> r12 = SECONDS_CACHE;
        ZoneOffset r13 = r12.get(r11);
        if (r13 != null) goto L14;
        r12.putIfAbsent(r11, new ZoneOffset(r10));
        ZoneOffset r14 = r12.get(r11);
        ID_CACHE.putIfAbsent(r14.getId(), r14);
        return r14;
    L14:
        return r13;
    L11:
        return new ZoneOffset(r10);
    L13:
        throw new DateTimeException("Zone offset not in valid range: -18:00 to +18:00");
    }

    private static int parseNumber(CharSequence r10, int r11, boolean r12) {
        if (r12 == true) goto L4;
    L8:
        char r13 = r10.charAt(r11);
        char r14 = r10.charAt(r11 + 1);
        if (r13 < '0') goto L17;
        if (r13 > '9') goto L17;
        if (r14 < '0') goto L17;
        if (r14 > '9') goto L17;
        return ((r13 - '0') * 10) + (r14 - '0');
    L17:
        throw new DateTimeException("Invalid ID for ZoneOffset, non numeric characters found: " + r10);
    L4:
        if (r10.charAt(r11 - 1) == ':') goto L8;
        throw new DateTimeException("Invalid ID for ZoneOffset, colon not found when expected: " + r10);
    }

    public static ZoneOffset readExternal(DataInput r10) throws IOException {
        byte r11 = r10.readByte();
        if (r11 != 127) goto L6;
        return ofTotalSeconds(r10.readInt());
    L6:
        return ofTotalSeconds(r11 * 900);
    }

    private Object readResolve() throws ObjectStreamException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private static int totalSeconds(int r10, int r11, int r12) {
        return ((r10 * 3600) + (r11 * 60)) + r12;
    }

    private static void validate(int r10, int r11, int r12) {
        if (r10 < (-18)) goto L44;
        if (r10 > 18) goto L44;
        if (r10 <= 0) goto L12;
        if (r11 < 0) goto L11;
        if (r12 < 0) goto L11;
    L26:
        if (Math.abs(r11) > 59) goto L42;
        if (Math.abs(r12) > 59) goto L40;
        if (Math.abs(r10) == 18) goto L32;
        return;
    L32:
        if (Math.abs(r11) > 0) goto L37;
        if (Math.abs(r12) > 0) goto L37;
        return;
    L37:
        throw new DateTimeException("Zone offset not in valid range: -18:00 to +18:00");
    L40:
        throw new DateTimeException("Zone offset seconds not in valid range: abs(value) " + Math.abs(r12) + " is not in the range 0 to 59");
    L42:
        throw new DateTimeException("Zone offset minutes not in valid range: abs(value) " + Math.abs(r11) + " is not in the range 0 to 59");
    L11:
        throw new DateTimeException("Zone offset minutes and seconds must be positive because hours is positive");
    L12:
        if (r10 >= 0) goto L18;
        if (r11 > 0) goto L17;
        if (r12 <= 0) goto L26;
    L17:
        throw new DateTimeException("Zone offset minutes and seconds must be negative because hours is negative");
    L18:
        if (r11 <= 0) goto L20;
        if (r12 >= 0) goto L20;
    L24:
        throw new DateTimeException("Zone offset minutes and seconds must have the same sign");
    L20:
        if (r11 >= 0) goto L26;
        if (r12 > 0) goto L24;
    L44:
        throw new DateTimeException("Zone offset hours not in valid range: value " + r10 + " is not in the range -18 to 18");
    }

    private Object writeReplace() {
        return new Ser((byte) 8, this);
    }

    @Override // org.threeten.bp.temporal.TemporalAdjuster
    public Temporal adjustInto(Temporal r10) {
        return r10.with(ChronoField.OFFSET_SECONDS, this.totalSeconds);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(ZoneOffset r10) {
        return compareTo2(r10);
    }

    @Override // org.threeten.bp.ZoneId
    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof ZoneOffset) == true) goto L8;
        return false;
    L8:
        if (this.totalSeconds != ((ZoneOffset) r10).totalSeconds) goto L11;
        return true;
    L11:
        return false;
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public int get(TemporalField r10) {
        if (r10 != ChronoField.OFFSET_SECONDS) goto L7;
        return this.totalSeconds;
    L7:
        if ((r10 instanceof ChronoField) == true) goto L11;
        return range(r10).checkValidIntValue(getLong(r10), r10);
    L11:
        throw new UnsupportedTemporalTypeException("Unsupported field: " + r10);
    }

    @Override // org.threeten.bp.ZoneId
    public String getId() {
        return this.f23083id;
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public long getLong(TemporalField r10) {
        if (r10 != ChronoField.OFFSET_SECONDS) goto L7;
        return this.totalSeconds;
    L7:
        if ((r10 instanceof ChronoField) == true) goto L11;
        return r10.getFrom(this);
    L11:
        throw new DateTimeException("Unsupported field: " + r10);
    }

    @Override // org.threeten.bp.ZoneId
    public ZoneRules getRules() {
        return ZoneRules.of(this);
    }

    public int getTotalSeconds() {
        return this.totalSeconds;
    }

    @Override // org.threeten.bp.ZoneId
    public int hashCode() {
        return this.totalSeconds;
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public boolean isSupported(TemporalField r10) {
        if ((r10 instanceof ChronoField) == true) goto L5;
        if (r10 != null) goto L10;
        return false;
    L10:
        if (r10.isSupportedBy(this) == true) goto L12;
        return false;
    L12:
        return true;
    L5:
        if (r10 == ChronoField.OFFSET_SECONDS) goto L7;
        return false;
    L7:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.threeten.bp.temporal.TemporalAccessor
    public <R> R query(TemporalQuery<R> r10) {
        if (r10 != b.d()) goto L5;
        return this;
    L5:
        if (r10 != b.f()) goto L8;
        return this;
    L8:
        if (r10 != b.b()) goto L10;
    L20:
        return null;
    L10:
        if (r10 == b.c()) goto L20;
        if (r10 == b.e()) goto L20;
        if (r10 == b.a()) goto L20;
        if (r10 == b.g()) goto L20;
        return r10.queryFrom(this);
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public ValueRange range(TemporalField r10) {
        if (r10 != ChronoField.OFFSET_SECONDS) goto L7;
        return r10.range();
    L7:
        if ((r10 instanceof ChronoField) == true) goto L11;
        return r10.rangeRefinedBy(this);
    L11:
        throw new UnsupportedTemporalTypeException("Unsupported field: " + r10);
    }

    @Override // org.threeten.bp.ZoneId
    public String toString() {
        return this.f23083id;
    }

    @Override // org.threeten.bp.ZoneId
    public void write(DataOutput r10) throws IOException {
        r10.writeByte(8);
        writeExternal(r10);
    }

    public void writeExternal(DataOutput r10) throws IOException {
        int r11 = this.totalSeconds;
        if ((r11 % 900) != 0) goto L5;
        int r12 = r11 / 900;
    L6:
        r10.writeByte(r12);
        if (r12 != 127) goto L10;
        r10.writeInt(r11);
        return;
    L10:
        return;
    L5:
        r12 = 127;
        goto L6
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(ZoneOffset r10) {
        return r10.totalSeconds - this.totalSeconds;
    }
}
