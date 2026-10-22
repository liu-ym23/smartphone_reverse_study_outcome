package bytedance.jvm.time;

import bytedance.jvm.time.format.DateTimeFormatterBuilder;
import bytedance.jvm.time.format.TextStyle;
import bytedance.jvm.time.zone.ZoneRules;
import bytedance.jvm.time.zone.ZoneRulesException;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TimeZone;
import org.slf4j.Marker;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ZoneId implements Serializable {
    public static final Map<String, String> SHORT_IDS = null;
    private static final long serialVersionUID = 8352817235686L;

    public abstract String getId();

    public abstract ZoneRules getRules();

    abstract void write(DataOutput r100) throws IOException;

    static {
        int r100 = 0;
        Map.Entry[] r101 = {new AbstractMap.SimpleImmutableEntry("ACT", "Australia/Darwin"), new AbstractMap.SimpleImmutableEntry("AET", "Australia/Sydney"), new AbstractMap.SimpleImmutableEntry("AGT", "America/Argentina/Buenos_Aires"), new AbstractMap.SimpleImmutableEntry("ART", "Africa/Cairo"), new AbstractMap.SimpleImmutableEntry("AST", "America/Anchorage"), new AbstractMap.SimpleImmutableEntry("BET", "America/Sao_Paulo"), new AbstractMap.SimpleImmutableEntry("BST", "Asia/Dhaka"), new AbstractMap.SimpleImmutableEntry("CAT", "Africa/Harare"), new AbstractMap.SimpleImmutableEntry("CNT", "America/St_Johns"), new AbstractMap.SimpleImmutableEntry("CST", "America/Chicago"), new AbstractMap.SimpleImmutableEntry("CTT", "Asia/Shanghai"), new AbstractMap.SimpleImmutableEntry("EAT", "Africa/Addis_Ababa"), new AbstractMap.SimpleImmutableEntry("ECT", "Europe/Paris"), new AbstractMap.SimpleImmutableEntry("IET", "America/Indiana/Indianapolis"), new AbstractMap.SimpleImmutableEntry("IST", "Asia/Kolkata"), new AbstractMap.SimpleImmutableEntry("JST", "Asia/Tokyo"), new AbstractMap.SimpleImmutableEntry("MIT", "Pacific/Apia"), new AbstractMap.SimpleImmutableEntry("NET", "Asia/Yerevan"), new AbstractMap.SimpleImmutableEntry("NST", "Pacific/Auckland"), new AbstractMap.SimpleImmutableEntry("PLT", "Asia/Karachi"), new AbstractMap.SimpleImmutableEntry("PNT", "America/Phoenix"), new AbstractMap.SimpleImmutableEntry("PRT", "America/Puerto_Rico"), new AbstractMap.SimpleImmutableEntry("PST", "America/Los_Angeles"), new AbstractMap.SimpleImmutableEntry("SST", "Pacific/Guadalcanal"), new AbstractMap.SimpleImmutableEntry("VST", "Asia/Ho_Chi_Minh"), new AbstractMap.SimpleImmutableEntry("EST", "-05:00"), new AbstractMap.SimpleImmutableEntry("MST", "-07:00"), new AbstractMap.SimpleImmutableEntry("HST", "-10:00")};
        HashMap r102 = new HashMap(28);
    L3:
        if (r100 >= 28) goto L9;
        Map.Entry r103 = r101[r100];
        Object r104 = r103.getKey();
        Objects.requireNonNull(r104);
        Object r105 = r103.getValue();
        Objects.requireNonNull(r105);
        if (r102.put(r104, r105) != null) goto L8;
        r100 = r100 + 1;
        goto L3
    L8:
        throw new IllegalArgumentException("duplicate key: " + r104);
    L9:
        SHORT_IDS = Collections.unmodifiableMap(r102);
    }

    public static Set<String> getAvailableZoneIds() {
        return new HashSet(bytedance.jvm.time.zone.a.f21730c);
    }

    private Object writeReplace() {
        return new Ser((byte) 7, this);
    }

    public ZoneId() {
        if (getClass() != ZoneOffset.class) goto L5;
        return;
    L5:
        if (getClass() != ZoneRegion.class) goto L8;
        return;
    L8:
        throw new AssertionError("Invalid subclass");
    }

    public static ZoneId systemDefault() {
        return of(TimeZone.getDefault().getID(), SHORT_IDS);
    }

    public int hashCode() {
        return getId().hashCode();
    }

    public ZoneId normalized() {
        ZoneRules r100 = getRules();     // Catch: ZoneRulesException -> L7
        if (r100.isFixedOffset() == false) goto L6;
        return r100.getOffset(Instant.EPOCH);
    L6:
        return this;
    }

    public String toString() {
        return getId();
    }

    public static ZoneId from(bytedance.jvm.time.temporal.d r100) {
        ZoneId r101 = (ZoneId) r100.query(bytedance.jvm.time.temporal.k.f21718e);
        if (r101 == null) goto L6;
        return r101;
    L6:
        throw new DateTimeException("Unable to obtain ZoneId from TemporalAccessor: " + r100 + " of type " + r100.getClass().getName());
    }

    public static ZoneId of(String r100) {
        return of(r100, true);
    }

    private void readObject(ObjectInputStream r100) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ZoneId) == true) goto L8;
        return false;
    L8:
        return getId().equals(((ZoneId) r100).getId());
    }

    public static ZoneId of(String r100, boolean r101) {
        Objects.requireNonNull(r100, "zoneId");
        if (r100.length() <= 1) goto L23;
        if (r100.startsWith(Marker.ANY_NON_NULL_MARKER) == true) goto L23;
        if (r100.startsWith("-") == true) goto L23;
        if (r100.startsWith("UTC") == true) goto L21;
        if (r100.startsWith("GMT") == true) goto L21;
        if (r100.startsWith("UT") == false) goto L19;
        return a(r100, 2, r101);
    L19:
        return ZoneRegion.ofId(r100, r101);
    L21:
        return a(r100, 3, r101);
    L23:
        return ZoneOffset.of(r100);
    }

    public static ZoneId ofOffset(String r100, ZoneOffset r101) {
        Objects.requireNonNull(r100, "prefix");
        Objects.requireNonNull(r101, "offset");
        if (r100.isEmpty() == false) goto L6;
        return r101;
    L6:
        if (r100.equals("GMT") == true) goto L15;
        if (r100.equals("UTC") == true) goto L15;
        if (r100.equals("UT") == true) goto L15;
        throw new IllegalArgumentException("prefix should be GMT, UTC or UT, is: ".concat(r100));
    L15:
        if (r101.getTotalSeconds() == 0) goto L18;
        r100 = r100.concat(r101.getId());
    L18:
        return new ZoneRegion(r100, r101.getRules());
    }

    public String getDisplayName(TextStyle r100, Locale r101) {
        DateTimeFormatterBuilder r102 = new DateTimeFormatterBuilder();
        r102.b(new DateTimeFormatterBuilder.n(r100));
        return r102.o(r101).a(new o(this));
    }

    public static ZoneId of(String r100, Map<String, String> r101) {
        Objects.requireNonNull(r100, "zoneId");
        Objects.requireNonNull(r101, "aliasMap");
        String r102 = r101.get(r100);
        if (r102 == null) goto L6;
        r100 = r102;
    L6:
        return of(r100);
    }

    public static ZoneId a(String r100, int r101, boolean r102) {
        String r103 = r100.substring(0, r101);
        if (r100.length() != r101) goto L7;
        return ofOffset(r103, ZoneOffset.UTC);
    L7:
        if (r100.charAt(r101) != '+') goto L9;
    L21:
        ZoneOffset r104 = ZoneOffset.of(r100.substring(r101));     // Catch: DateTimeException -> L18
        if (r104 != ZoneOffset.UTC) goto L17;
        return ofOffset(r103, r104);
    L17:
        return ofOffset(r103, r104);
    L18:
        e = move-exception;
        throw new DateTimeException("Invalid ID for offset-based ZoneId: ".concat(r100), e);
    L9:
        if (r100.charAt(r101) == '-') goto L21;
        return ZoneRegion.ofId(r100, r102);
    }
}
