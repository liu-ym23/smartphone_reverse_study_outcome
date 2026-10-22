package bytedance.jvm.time.zone;

import bytedance.jvm.time.Clock;
import bytedance.jvm.time.Duration;
import bytedance.jvm.time.Instant;
import bytedance.jvm.time.LocalDate;
import bytedance.jvm.time.LocalDateTime;
import bytedance.jvm.time.ZoneOffset;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: loaded from: classes28.dex */
public final class ZoneRules implements Serializable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final long[] f21723b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ZoneOffsetTransitionRule[] f21724c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final LocalDateTime[] f21725d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ZoneOffsetTransition[] f21726e = null;
    private static final long serialVersionUID = 3044319355680032515L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final transient ConcurrentMap<Integer, ZoneOffsetTransition[]> f21727a;
    private final ZoneOffsetTransitionRule[] lastRules;
    private final long[] savingsInstantTransitions;
    private final LocalDateTime[] savingsLocalTransitions;
    private final ZoneOffset[] standardOffsets;
    private final long[] standardTransitions;
    private final TimeZone timeZone;
    private final ZoneOffset[] wallOffsets;

    static {
        f21723b = new long[0];
        f21724c = new ZoneOffsetTransitionRule[0];
        f21725d = new LocalDateTime[0];
        f21726e = new ZoneOffsetTransition[0];
    }

    private Object writeReplace() {
        if (this.timeZone == null) goto L5;
        byte r100 = 100;
    L7:
        return new Ser(r100, this);
    L5:
        r100 = 1;
        goto L7
    }

    public List<ZoneOffsetTransitionRule> getTransitionRules() {
        ZoneOffsetTransitionRule[] r100 = this.lastRules;
        ArrayList r101 = new ArrayList(r100.length);
        int r102 = r100.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L6;
        ZoneOffsetTransitionRule r104 = r100[r103];
        Objects.requireNonNull(r104);
        r101.add(r104);
        r103 = r103 + 1;
        goto L3
    L6:
        return Collections.unmodifiableList(r101);
    }

    public List<ZoneOffsetTransition> getTransitions() {
        ArrayList r100 = new ArrayList();
        int r101 = 0;
    L4:
        if (r101 >= this.savingsInstantTransitions.length) goto L7;
        long r102 = this.savingsInstantTransitions[r101];
        ZoneOffset[] r103 = this.wallOffsets;
        ZoneOffset r104 = r103[r101];
        r101 = r101 + 1;
        r100.add(new ZoneOffsetTransition(r102, r104, r103[r101]));
        goto L4
    L7:
        return Collections.unmodifiableList(r100);
    }

    public int hashCode() {
        return ((((Objects.hashCode(this.timeZone) ^ Arrays.hashCode(this.standardTransitions)) ^ Arrays.hashCode(this.standardOffsets)) ^ Arrays.hashCode(this.savingsInstantTransitions)) ^ Arrays.hashCode(this.wallOffsets)) ^ Arrays.hashCode(this.lastRules);
    }

    public boolean isFixedOffset() {
        TimeZone r100 = this.timeZone;
        if (r100 == null) goto L16;
        if (r100.useDaylightTime() == false) goto L7;
    L14:
        return false;
    L7:
        if (this.timeZone.getDSTSavings() != 0) goto L14;
        if (previousTransition(Instant.now()) == null) goto L20;
        return false;
    L20:
        return true;
    L16:
        if (this.savingsInstantTransitions.length == 0) goto L21;
        return false;
    L21:
        return true;
    }

    public String toString() {
        if (this.timeZone != null) goto L5;
        StringBuilder r100 = new StringBuilder("ZoneRules[currentStandardOffset=");
        ZoneOffset[] r101 = this.standardOffsets;
        r100.append(r101[r101.length - 1]);
        r100.append("]");
        return r100.toString();
    L5:
        return "ZoneRules[timeZone=" + this.timeZone.getID() + "]";
    }

    public ZoneRules(TimeZone r100) {
        this.f21727a = new ConcurrentHashMap();
        ZoneOffset[] r101 = {e(r100.getRawOffset())};
        this.standardOffsets = r101;
        long[] r102 = f21723b;
        this.standardTransitions = r102;
        this.savingsInstantTransitions = r102;
        this.savingsLocalTransitions = f21725d;
        this.wallOffsets = r101;
        this.lastRules = f21724c;
        this.timeZone = r100;
    }

    public static ZoneOffset e(int r100) {
        return ZoneOffset.ofTotalSeconds(r100 / 1000);
    }

    public static ZoneRules of(ZoneOffset r100) {
        Objects.requireNonNull(r100, "offset");
        return new ZoneRules(r100);
    }

    public static ZoneRules readExternal(DataInput r100) throws IOException, ClassNotFoundException {
        int r101 = r100.readInt();
        long[] r102 = f21723b;
        if (r101 != 0) goto L5;
        long[] r103 = r102;
    L6:
        int r104 = 0;
        int r105 = 0;
    L7:
        if (r105 >= r101) goto L9;
        r103[r105] = Ser.readEpochSec(r100);
        r105 = r105 + 1;
        goto L7
    L9:
        int r106 = r101 + 1;
        ZoneOffset[] r107 = new ZoneOffset[r106];
        int r108 = 0;
    L10:
        if (r108 >= r106) goto L12;
        r107[r108] = Ser.readOffset(r100);
        r108 = r108 + 1;
        goto L10
    L12:
        int r109 = r100.readInt();
        if (r109 == 0) goto L16;
        r102 = new long[r109];
    L16:
        long[] r110 = r102;
        int r111 = 0;
    L17:
        if (r111 >= r109) goto L19;
        r110[r111] = Ser.readEpochSec(r100);
        r111 = r111 + 1;
        goto L17
    L19:
        int r112 = r109 + 1;
        ZoneOffset[] r113 = new ZoneOffset[r112];
        int r114 = 0;
    L20:
        if (r114 >= r112) goto L22;
        r113[r114] = Ser.readOffset(r100);
        r114 = r114 + 1;
        goto L20
    L22:
        int r115 = r100.readByte();
        if (r115 != 0) goto L25;
        ZoneOffsetTransitionRule[] r116 = f21724c;
    L26:
        ZoneOffsetTransitionRule[] r117 = r116;
    L27:
        if (r104 >= r115) goto L30;
        r117[r104] = ZoneOffsetTransitionRule.readExternal(r100);
        r104 = r104 + 1;
        goto L27
    L30:
        return new ZoneRules(r103, r107, r110, r113, r117);
    L25:
        r116 = new ZoneOffsetTransitionRule[r115];
        goto L26
    L5:
        r103 = new long[r101];
        goto L6
    }

    public static ZoneRules readExternalTimeZone(DataInput r100) throws IOException {
        return new ZoneRules(TimeZone.getTimeZone(r100.readUTF()));
    }

    private void readObject(ObjectInputStream r100) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    public final ZoneOffsetTransition[] b(int r210) {
        Integer r100 = Integer.valueOf(r210);
        ZoneOffsetTransition[] r101 = (ZoneOffsetTransition[]) ((ConcurrentHashMap) this.f21727a).get(r100);
        if (r101 == null) goto L5;
        return r101;
    L5:
        int r102 = 0;
        if (this.timeZone == null) goto L44;
        ZoneOffsetTransition[] r103 = f21726e;
        if (r210 >= 1800) goto L10;
        return r103;
    L10:
        long r104 = LocalDateTime.of(r210 - 1, 12, 31, 0, 0).toEpochSecond(this.standardOffsets[0]);
        int r105 = this.timeZone.getOffset(r104 * 1000);
        long r110 = 31968000 + r104;
    L12:
        if (r104 >= r110) goto L39;
        long r111 = 7776000 + r104;
        long r112 = r104;
        if (r105 == this.timeZone.getOffset(r111 * 1000)) goto L36;
        r104 = r112;
    L17:
        if ((r111 - r104) <= 1) goto L29;
        long r113 = r111 + r104;
        long r211 = r113 / 2;
        if ((r113 - (r211 * 2)) != 0) goto L22;
    L24:
        long r114 = r110;
        if (this.timeZone.getOffset(r211 * 1000) != r105) goto L27;
        r104 = r211;
    L28:
        r110 = r114;
        goto L17
    L27:
        r111 = r211;
        goto L28
    L22:
        if ((((r113 ^ 2) >> 63) | 1) >= 0) goto L24;
        r211 = r211 - 1;
        goto L24
    L29:
        long r115 = r110;
        if (this.timeZone.getOffset(r104 * 1000) != r105) goto L33;
        r104 = r111;
    L33:
        ZoneOffset r106 = e(r105);
        r105 = this.timeZone.getOffset(r104 * 1000);
        ZoneOffset r116 = e(r105);
        if (c(r104, r116) != r210) goto L37;
        r103 = (ZoneOffsetTransition[]) Arrays.copyOf(r103, r103.length + 1);
        r103[r103.length - 1] = new ZoneOffsetTransition(r104, r106, r116);
    L37:
        r110 = r115;
        goto L12
    L36:
        r115 = r110;
        r104 = r111;
        goto L37
    L39:
        if (1916 <= r210) goto L41;
    L43:
        return r103;
    L41:
        if (r210 >= 2100) goto L43;
        ((ConcurrentHashMap) this.f21727a).putIfAbsent(r100, r103);
        goto L43
    L44:
        ZoneOffsetTransitionRule[] r107 = this.lastRules;
        ZoneOffsetTransition[] r108 = new ZoneOffsetTransition[r107.length];
    L46:
        if (r102 >= r107.length) goto L49;
        r108[r102] = r107[r102].createTransition(r210);
        r102 = r102 + 1;
        goto L46
    L49:
        if (r210 >= 2100) goto L51;
        ((ConcurrentHashMap) this.f21727a).putIfAbsent(r100, r108);
    L51:
        return r108;
    }

    public final Object d(LocalDateTime r100) {
        Object r101 = null;
        int r102 = 0;
        if (this.timeZone == null) goto L19;
        ZoneOffsetTransition[] r103 = b(r100.getYear());
        if (r103.length == 0) goto L7;
        int r104 = r103.length;
    L9:
        if (r102 >= r104) goto L17;
        ZoneOffsetTransition r105 = r103[r102];
        Object r106 = a(r100, r105);
        if ((r106 instanceof ZoneOffsetTransition) == true) goto L16;
        if (r106.equals(r105.getOffsetBefore()) == true) goto L16;
        r102 = r102 + 1;
        r101 = r106;
    L16:
        return r106;
    L17:
        return r101;
    L7:
        return e(this.timeZone.getOffset(r100.toEpochSecond(this.standardOffsets[0]) * 1000));
    L19:
        if (this.savingsInstantTransitions.length != 0) goto L23;
        return this.standardOffsets[0];
    L23:
        if (this.lastRules.length <= 0) goto L36;
        LocalDateTime[] r107 = this.savingsLocalTransitions;
        if (r100.isAfter(r107[r107.length - 1]) == false) goto L36;
        ZoneOffsetTransition[] r108 = b(r100.getYear());
        int r109 = r108.length;
    L27:
        if (r102 >= r109) goto L35;
        ZoneOffsetTransition r110 = r108[r102];
        Object r111 = a(r100, r110);
        if ((r111 instanceof ZoneOffsetTransition) == true) goto L34;
        if (r111.equals(r110.getOffsetBefore()) == true) goto L34;
        r102 = r102 + 1;
        r101 = r111;
    L34:
        return r111;
    L35:
        return r101;
    L36:
        int r112 = Arrays.binarySearch(this.savingsLocalTransitions, r100);
        if (r112 == (-1)) goto L39;
        if (r112 >= 0) goto L42;
        r112 = (-r112) - 2;
    L48:
        if ((r112 & 1) != 0) goto L56;
        LocalDateTime[] r113 = this.savingsLocalTransitions;
        LocalDateTime r114 = r113[r112];
        LocalDateTime r115 = r113[r112 + 1];
        ZoneOffset[] r116 = this.wallOffsets;
        int r117 = r112 / 2;
        ZoneOffset r118 = r116[r117];
        ZoneOffset r119 = r116[r117 + 1];
        if (r119.getTotalSeconds() <= r118.getTotalSeconds()) goto L54;
        return new ZoneOffsetTransition(r114, r118, r119);
    L54:
        return new ZoneOffsetTransition(r115, r118, r119);
    L56:
        return this.wallOffsets[(r112 / 2) + 1];
    L42:
        Object[] r120 = this.savingsLocalTransitions;
        if (r112 >= (r120.length - 1)) goto L48;
        int r121 = r112 + 1;
        if (r120[r112].equals(r120[r121]) == false) goto L48;
        r112 = r121;
        goto L48
    L39:
        return this.wallOffsets[0];
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ZoneRules) == false) goto L22;
        ZoneRules r101 = (ZoneRules) r100;
        if (Objects.equals(this.timeZone, r101.timeZone) == true) goto L10;
    L20:
        return false;
    L10:
        if (Arrays.equals(this.standardTransitions, r101.standardTransitions) == false) goto L20;
        if (Arrays.equals(this.standardOffsets, r101.standardOffsets) == false) goto L20;
        if (Arrays.equals(this.savingsInstantTransitions, r101.savingsInstantTransitions) == false) goto L20;
        if (Arrays.equals(this.wallOffsets, r101.wallOffsets) == false) goto L20;
        if (Arrays.equals(this.lastRules, r101.lastRules) == false) goto L20;
        return true;
    L22:
        return false;
    }

    public Duration getDaylightSavings(Instant r100) {
        TimeZone r101 = this.timeZone;
        if (r101 == null) goto L7;
        return Duration.ofMillis(r101.getOffset(r100.toEpochMilli()) - this.timeZone.getRawOffset());
    L7:
        if (this.savingsInstantTransitions.length != 0) goto L11;
        return Duration.ZERO;
    L11:
        return Duration.ofSeconds(getOffset(r100).getTotalSeconds() - getStandardOffset(r100).getTotalSeconds());
    }

    public ZoneOffset getOffset(Instant r100) {
        TimeZone r101 = this.timeZone;
        if (r101 != null) goto L5;
        int r102 = 0;
        if (this.savingsInstantTransitions.length == 0) goto L9;
        long r103 = r100.getEpochSecond();
        if (this.lastRules.length <= 0) goto L24;
        long[] r104 = this.savingsInstantTransitions;
        if (r103 <= r104[r104.length - 1]) goto L24;
        ZoneOffset[] r105 = this.wallOffsets;
        ZoneOffsetTransition[] r106 = b(c(r103, r105[r105.length - 1]));
        ZoneOffsetTransition r107 = null;
    L16:
        if (r102 >= r106.length) goto L23;
        r107 = r106[r102];
        if (r103 < r107.toEpochSecond()) goto L20;
        r102 = r102 + 1;
        goto L16
    L20:
        return r107.getOffsetBefore();
    L23:
        return r107.getOffsetAfter();
    L24:
        int r108 = Arrays.binarySearch(this.savingsInstantTransitions, r103);
        if (r108 >= 0) goto L28;
        r108 = (-r108) - 2;
    L28:
        return this.wallOffsets[r108 + 1];
    L9:
        return this.standardOffsets[0];
    L5:
        return e(r101.getOffset(r100.toEpochMilli()));
    }

    public ZoneOffset getStandardOffset(Instant r100) {
        TimeZone r101 = this.timeZone;
        if (r101 == null) goto L7;
        return e(r101.getRawOffset());
    L7:
        if (this.savingsInstantTransitions.length == 0) goto L9;
        int r102 = Arrays.binarySearch(this.standardTransitions, r100.getEpochSecond());
        if (r102 >= 0) goto L14;
        r102 = (-r102) - 2;
    L14:
        return this.standardOffsets[r102 + 1];
    L9:
        return this.standardOffsets[0];
    }

    public ZoneOffsetTransition getTransition(LocalDateTime r100) {
        Object r101 = d(r100);
        if ((r101 instanceof ZoneOffsetTransition) == true) goto L7;
        return null;
    L7:
        return (ZoneOffsetTransition) r101;
    }

    public List<ZoneOffset> getValidOffsets(LocalDateTime r100) {
        Object r101 = d(r100);
        if ((r101 instanceof ZoneOffsetTransition) == false) goto L7;
        return ((ZoneOffsetTransition) r101).getValidOffsets();
    L7:
        return Collections.singletonList((ZoneOffset) r101);
    }

    public boolean isDaylightSavings(Instant r100) {
        return !getStandardOffset(r100).equals(getOffset(r100));
    }

    public ZoneOffsetTransition nextTransition(Instant r110) {
        if (this.timeZone == null) goto L33;
        long r100 = r110.getEpochSecond();
        int r111 = c(r100, getOffset(r110));
        ZoneOffsetTransition[] r101 = b(r111);
        int r102 = r101.length;
        int r103 = 0;
    L5:
        if (r103 >= r102) goto L10;
        ZoneOffsetTransition r104 = r101[r103];
        if (r100 < r104.toEpochSecond()) goto L8;
        r103 = r103 + 1;
        goto L5
    L8:
        return r104;
    L10:
        if (r111 >= 999999999) goto L17;
        ZoneOffsetTransition[] r112 = b(r111 + 1);
        int r105 = r112.length;
        int r106 = 0;
    L12:
        if (r106 >= r105) goto L17;
        ZoneOffsetTransition r107 = r112[r106];
        if (r100 < r107.toEpochSecond()) goto L15;
        r106 = r106 + 1;
        goto L12
    L15:
        return r107;
    L17:
        long r108 = 31104000 + r100;
        int r113 = this.timeZone.getOffset((1 + r100) * 1000);
        long r109 = (Clock.systemUTC().millis() / 1000) + 31968000;
    L19:
        if (r108 > r109) goto L31;
        int r114 = this.timeZone.getOffset(r108 * 1000);
        if (r113 != r114) goto L22;
        r108 = r108 + 7776000;
        goto L19
    L22:
        int r115 = c(r108, e(r114));
        ZoneOffsetTransition[] r116 = b(r115 - 1);
        int r117 = r116.length;
        int r118 = 0;
    L23:
        if (r118 >= r117) goto L29;
        ZoneOffsetTransition r119 = r116[r118];
        if (r100 < r119.toEpochSecond()) goto L26;
        r118 = r118 + 1;
        goto L23
    L26:
        return r119;
    L29:
        return b(r115)[0];
    L31:
        return null;
    L33:
        if (this.savingsInstantTransitions.length != 0) goto L35;
        return null;
    L35:
        long r120 = r110.getEpochSecond();
        long[] r121 = this.savingsInstantTransitions;
        if (r120 >= r121[r121.length - 1]) goto L38;
        int r122 = Arrays.binarySearch(r121, r120);
        if (r122 >= 0) goto L53;
        int r123 = (-r122) - 1;
    L54:
        long r124 = this.savingsInstantTransitions[r123];
        ZoneOffset[] r125 = this.wallOffsets;
        return new ZoneOffsetTransition(r124, r125[r123], r125[r123 + 1]);
    L53:
        r123 = r122 + 1;
        goto L54
    L38:
        if (this.lastRules.length != 0) goto L40;
        return null;
    L40:
        ZoneOffset[] r126 = this.wallOffsets;
        int r127 = c(r120, r126[r126.length - 1]);
        ZoneOffsetTransition[] r128 = b(r127);
        int r129 = r128.length;
        int r130 = 0;
    L41:
        if (r130 >= r129) goto L46;
        ZoneOffsetTransition r131 = r128[r130];
        if (r120 < r131.toEpochSecond()) goto L44;
        r130 = r130 + 1;
        goto L41
    L44:
        return r131;
    L46:
        if (r127 < 999999999) goto L48;
        return null;
    L48:
        return b(r127 + 1)[0];
    }

    public ZoneOffsetTransition previousTransition(Instant r110) {
        if (this.timeZone == null) goto L42;
        long r100 = r110.getEpochSecond();
        if (r110.getNano() > 0) goto L7;
    L9:
        int r101 = c(r100, getOffset(r110));
        ZoneOffsetTransition[] r102 = b(r101);
        int r103 = r102.length - 1;
    L10:
        if (r103 < 0) goto L17;
        if (r100 > r102[r103].toEpochSecond()) goto L14;
        r103 = r103 - 1;
        goto L10
    L14:
        return r102[r103];
    L17:
        if (r101 <= 1800) goto L40;
        ZoneOffsetTransition[] r104 = b(r101 - 1);
        int r105 = r104.length - 1;
    L19:
        if (r105 < 0) goto L25;
        if (r100 > r104[r105].toEpochSecond()) goto L23;
        r105 = r105 - 1;
        goto L19
    L23:
        return r104[r105];
    L25:
        long r111 = Math.min(r100 - 31104000, (Clock.systemUTC().millis() / 1000) + 31968000);
        int r106 = this.timeZone.getOffset((r100 - 1) * 1000);
        long r107 = LocalDate.of(1800, 1, 1).toEpochDay() * 86400;
    L27:
        if (r107 > r111) goto L40;
        int r108 = this.timeZone.getOffset(r111 * 1000);
        if (r106 != r108) goto L30;
        r111 = r111 - 7776000;
        goto L27
    L30:
        int r109 = c(r111, e(r108));
        ZoneOffsetTransition[] r112 = b(r109 + 1);
        int r113 = r112.length - 1;
    L31:
        if (r113 < 0) goto L37;
        if (r100 > r112[r113].toEpochSecond()) goto L35;
        r113 = r113 - 1;
        goto L31
    L35:
        return r112[r113];
    L37:
        ZoneOffsetTransition[] r114 = b(r109);
        return r114[r114.length - 1];
    L40:
        return null;
    L7:
        if (r100 >= Long.MAX_VALUE) goto L9;
        r100 = r100 + 1;
        goto L9
    L42:
        if (this.savingsInstantTransitions.length != 0) goto L44;
        return null;
    L44:
        long r115 = r110.getEpochSecond();
        if (r110.getNano() > 0) goto L47;
    L49:
        long[] r116 = this.savingsInstantTransitions;
        long r117 = r116[r116.length - 1];
        if (this.lastRules.length > 0) goto L52;
    L64:
        int r118 = Arrays.binarySearch(this.savingsInstantTransitions, r115);
        if (r118 >= 0) goto L67;
        r118 = (-r118) - 1;
    L67:
        if (r118 > 0) goto L69;
        return null;
    L69:
        int r119 = r118 - 1;
        long r120 = this.savingsInstantTransitions[r119];
        ZoneOffset[] r121 = this.wallOffsets;
        return new ZoneOffsetTransition(r120, r121[r119], r121[r118]);
    L52:
        if (r115 <= r117) goto L64;
        ZoneOffset[] r122 = this.wallOffsets;
        ZoneOffset r123 = r122[r122.length - 1];
        int r124 = c(r115, r123);
        ZoneOffsetTransition[] r125 = b(r124);
        int r126 = r125.length - 1;
    L54:
        if (r126 < 0) goto L60;
        if (r115 > r125[r126].toEpochSecond()) goto L58;
        r126 = r126 - 1;
        goto L54
    L58:
        return r125[r126];
    L60:
        int r127 = r124 - 1;
        if (r127 <= c(r117, r123)) goto L64;
        ZoneOffsetTransition[] r128 = b(r127);
        return r128[r128.length - 1];
    L47:
        if (r115 >= Long.MAX_VALUE) goto L49;
        r115 = r115 + 1;
        goto L49
    }

    public void writeExternal(DataOutput r100) throws IOException {
        r100.writeInt(this.standardTransitions.length);
        long[] r101 = this.standardTransitions;
        int r102 = r101.length;
        int r103 = 0;
        int r104 = 0;
    L3:
        if (r104 >= r102) goto L5;
        Ser.writeEpochSec(r101[r104], r100);
        r104 = r104 + 1;
        goto L3
    L5:
        ZoneOffset[] r105 = this.standardOffsets;
        int r106 = r105.length;
        int r107 = 0;
    L6:
        if (r107 >= r106) goto L8;
        Ser.writeOffset(r105[r107], r100);
        r107 = r107 + 1;
        goto L6
    L8:
        r100.writeInt(this.savingsInstantTransitions.length);
        long[] r108 = this.savingsInstantTransitions;
        int r109 = r108.length;
        int r110 = 0;
    L9:
        if (r110 >= r109) goto L11;
        Ser.writeEpochSec(r108[r110], r100);
        r110 = r110 + 1;
        goto L9
    L11:
        ZoneOffset[] r111 = this.wallOffsets;
        int r112 = r111.length;
        int r113 = 0;
    L12:
        if (r113 >= r112) goto L14;
        Ser.writeOffset(r111[r113], r100);
        r113 = r113 + 1;
        goto L12
    L14:
        r100.writeByte(this.lastRules.length);
        ZoneOffsetTransitionRule[] r114 = this.lastRules;
        int r115 = r114.length;
    L15:
        if (r103 >= r115) goto L17;
        r114[r103].writeExternal(r100);
        r103 = r103 + 1;
        goto L15
    }

    public void writeExternalTimeZone(DataOutput r100) throws IOException {
        r100.writeUTF(this.timeZone.getID());
    }

    public ZoneRules(ZoneOffset r100) {
        this.f21727a = new ConcurrentHashMap();
        ZoneOffset[] r101 = {r100};
        this.standardOffsets = r101;
        long[] r102 = f21723b;
        this.standardTransitions = r102;
        this.savingsInstantTransitions = r102;
        this.savingsLocalTransitions = f21725d;
        this.wallOffsets = r101;
        this.lastRules = f21724c;
        this.timeZone = null;
    }

    public ZoneOffset getOffset(LocalDateTime r100) {
        Object r101 = d(r100);
        if ((r101 instanceof ZoneOffsetTransition) == false) goto L7;
        return ((ZoneOffsetTransition) r101).getOffsetBefore();
    L7:
        return (ZoneOffset) r101;
    }

    public static Object a(LocalDateTime r100, ZoneOffsetTransition r101) {
        LocalDateTime r102 = r101.getDateTimeBefore();
        if (r101.isGap() == false) goto L14;
        if (r100.isBefore(r102) == false) goto L9;
        return r101.getOffsetBefore();
    L9:
        if (r100.isBefore(r101.getDateTimeAfter()) == false) goto L12;
        return r101;
    L12:
        return r101.getOffsetAfter();
    L14:
        if (r100.isBefore(r102) == true) goto L18;
        return r101.getOffsetAfter();
    L18:
        if (r100.isBefore(r101.getDateTimeAfter()) == true) goto L20;
        return r101;
    L20:
        return r101.getOffsetBefore();
    }

    public static int c(long r100, ZoneOffset r110) {
        long r101 = r100 + ((long) r110.getTotalSeconds());
        long r102 = 86400;
        long r103 = r101 / r102;
        if ((r101 - (r102 * r103)) == 0) goto L9;
        if ((((r101 ^ r102) >> 63) | 1) >= 0) goto L9;
        r103 = r103 - 1;
    L9:
        return LocalDate.ofEpochDay(r103).getYear();
    }

    public boolean isValidOffset(LocalDateTime r100, ZoneOffset r101) {
        return getValidOffsets(r100).contains(r101);
    }

    public ZoneRules(ZoneOffset r100, ZoneOffset r101, List<ZoneOffsetTransition> r102, List<ZoneOffsetTransition> r103, List<ZoneOffsetTransitionRule> r104) {
        this.f21727a = new ConcurrentHashMap();
        this.standardTransitions = new long[r102.size()];
        ZoneOffset[] r105 = new ZoneOffset[r102.size() + 1];
        this.standardOffsets = r105;
        int r106 = 0;
        r105[0] = r100;
        int r107 = 0;
    L4:
        if (r107 >= r102.size()) goto L6;
        this.standardTransitions[r107] = ((ZoneOffsetTransition) ListProtector.get(r102, r107)).toEpochSecond();
        int r108 = r107 + 1;
        this.standardOffsets[r108] = ((ZoneOffsetTransition) ListProtector.get(r102, r107)).getOffsetAfter();
        r107 = r108;
        goto L4
    L6:
        ArrayList r109 = new ArrayList();
        ArrayList r110 = new ArrayList();
        r110.add(r101);
        Iterator<ZoneOffsetTransition> r111 = r103.iterator();
    L8:
        if (r111.hasNext() == false) goto L14;
        ZoneOffsetTransition r112 = r111.next();
        if (r112.isGap() == false) goto L12;
        r109.add(r112.getDateTimeBefore());
        r109.add(r112.getDateTimeAfter());
    L13:
        r110.add(r112.getOffsetAfter());
        goto L8
    L12:
        r109.add(r112.getDateTimeAfter());
        r109.add(r112.getDateTimeBefore());
        goto L13
    L14:
        this.savingsLocalTransitions = (LocalDateTime[]) r109.toArray(new LocalDateTime[r109.size()]);
        this.wallOffsets = (ZoneOffset[]) r110.toArray(new ZoneOffset[r110.size()]);
        this.savingsInstantTransitions = new long[r103.size()];
    L16:
        if (r106 >= r103.size()) goto L19;
        this.savingsInstantTransitions[r106] = ((ZoneOffsetTransition) ListProtector.get(r103, r106)).toEpochSecond();
        r106 = r106 + 1;
        goto L16
    L19:
        if (r104.size() > 16) goto L23;
        this.lastRules = (ZoneOffsetTransitionRule[]) r104.toArray(new ZoneOffsetTransitionRule[r104.size()]);
        this.timeZone = null;
        return;
    L23:
        throw new IllegalArgumentException("Too many transition rules");
    }

    public static ZoneRules of(ZoneOffset r100, ZoneOffset r101, List<ZoneOffsetTransition> r102, List<ZoneOffsetTransition> r110, List<ZoneOffsetTransitionRule> r111) {
        Objects.requireNonNull(r100, "baseStandardOffset");
        Objects.requireNonNull(r101, "baseWallOffset");
        Objects.requireNonNull(r102, "standardOffsetTransitionList");
        Objects.requireNonNull(r110, "transitionList");
        Objects.requireNonNull(r111, "lastRules");
        return new ZoneRules(r100, r101, r102, r110, r111);
    }

    public ZoneRules(long[] r100, ZoneOffset[] r101, long[] r102, ZoneOffset[] r103, ZoneOffsetTransitionRule[] r110) {
        this.f21727a = new ConcurrentHashMap();
        this.standardTransitions = r100;
        this.standardOffsets = r101;
        this.savingsInstantTransitions = r102;
        this.wallOffsets = r103;
        this.lastRules = r110;
        if (r102.length != 0) goto L5;
        this.savingsLocalTransitions = f21725d;
    L14:
        this.timeZone = null;
        return;
    L5:
        ArrayList r104 = new ArrayList();
        int r105 = 0;
    L7:
        if (r105 >= r102.length) goto L13;
        ZoneOffset r111 = r103[r105];
        int r106 = r105 + 1;
        ZoneOffset r107 = r103[r106];
        ZoneOffsetTransition r108 = new ZoneOffsetTransition(r102[r105], r111, r107);
        if (r108.isGap() == false) goto L11;
        r104.add(r108.getDateTimeBefore());
        r104.add(r108.getDateTimeAfter());
    L12:
        r105 = r106;
        goto L7
    L11:
        r104.add(r108.getDateTimeAfter());
        r104.add(r108.getDateTimeBefore());
        goto L12
    L13:
        this.savingsLocalTransitions = (LocalDateTime[]) r104.toArray(new LocalDateTime[r104.size()]);
        goto L14
    }
}
