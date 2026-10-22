package org.threeten.bp;

import ig.c;
import ig.d;
import java.io.DataOutput;
import java.io.IOException;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import org.threeten.bp.format.DateTimeFormatterBuilder;
import org.threeten.bp.format.TextStyle;
import org.threeten.bp.temporal.TemporalAccessor;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.TemporalQuery;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;
import org.threeten.bp.zone.ZoneRules;
import org.threeten.bp.zone.ZoneRulesException;

/* JADX INFO: loaded from: classes4.dex */
public abstract class ZoneId implements Serializable {
    public static final TemporalQuery<ZoneId> FROM = null;
    public static final Map<String, String> SHORT_IDS = null;
    private static final long serialVersionUID = 8352817235686L;

    public static class a implements TemporalQuery {
        public a() {
        }

        public ZoneId a(TemporalAccessor r10) {
            return ZoneId.from(r10);
        }

        @Override // org.threeten.bp.temporal.TemporalQuery
        public /* bridge */ /* synthetic */ Object queryFrom(TemporalAccessor r10) {
            return a(r10);
        }
    }

    public class b extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ZoneId f23082a;

        public b(ZoneId r10) {
            this.f23082a = r10;
        }

        @Override // org.threeten.bp.temporal.TemporalAccessor
        public long getLong(TemporalField r10) {
            throw new UnsupportedTemporalTypeException("Unsupported field: " + r10);
        }

        @Override // org.threeten.bp.temporal.TemporalAccessor
        public boolean isSupported(TemporalField r10) {
            return false;
        }

        @Override // ig.c, org.threeten.bp.temporal.TemporalAccessor
        public Object query(TemporalQuery r10) {
            if (r10 != org.threeten.bp.temporal.b.g()) goto L7;
            return this.f23082a;
        L7:
            return super.query(r10);
        }
    }

    static {
        FROM = new a();
        HashMap r10 = new HashMap();
        r10.put("ACT", "Australia/Darwin");
        r10.put("AET", "Australia/Sydney");
        r10.put("AGT", "America/Argentina/Buenos_Aires");
        r10.put("ART", "Africa/Cairo");
        r10.put("AST", "America/Anchorage");
        r10.put("BET", "America/Sao_Paulo");
        r10.put("BST", "Asia/Dhaka");
        r10.put("CAT", "Africa/Harare");
        r10.put("CNT", "America/St_Johns");
        r10.put("CST", "America/Chicago");
        r10.put("CTT", "Asia/Shanghai");
        r10.put("EAT", "Africa/Addis_Ababa");
        r10.put("ECT", "Europe/Paris");
        r10.put("IET", "America/Indiana/Indianapolis");
        r10.put("IST", "Asia/Kolkata");
        r10.put("JST", "Asia/Tokyo");
        r10.put("MIT", "Pacific/Apia");
        r10.put("NET", "Asia/Yerevan");
        r10.put("NST", "Pacific/Auckland");
        r10.put("PLT", "Asia/Karachi");
        r10.put("PNT", "America/Phoenix");
        r10.put("PRT", "America/Puerto_Rico");
        r10.put("PST", "America/Los_Angeles");
        r10.put("SST", "Pacific/Guadalcanal");
        r10.put("VST", "Asia/Ho_Chi_Minh");
        r10.put("EST", "-05:00");
        r10.put("MST", "-07:00");
        r10.put("HST", "-10:00");
        SHORT_IDS = Collections.unmodifiableMap(r10);
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

    public static ZoneId from(TemporalAccessor r10) {
        ZoneId r11 = (ZoneId) r10.query(org.threeten.bp.temporal.b.f());
        if (r11 == null) goto L6;
        return r11;
    L6:
        throw new DateTimeException("Unable to obtain ZoneId from TemporalAccessor: " + r10 + ", type " + r10.getClass().getName());
    }

    public static Set<String> getAvailableZoneIds() {
        return new HashSet(org.threeten.bp.zone.c.a());
    }

    public static ZoneId of(String r10, Map<String, String> r11) {
        d.h(r10, "zoneId");
        d.h(r11, "aliasMap");
        String r12 = r11.get(r10);
        if (r12 == null) goto L6;
        r10 = r12;
    L6:
        return of(r10);
    }

    public static ZoneId ofOffset(String r10, ZoneOffset r11) {
        d.h(r10, "prefix");
        d.h(r11, "offset");
        if (r10.length() != 0) goto L6;
        return r11;
    L6:
        if (r10.equals("GMT") == true) goto L15;
        if (r10.equals("UTC") == true) goto L15;
        if (r10.equals("UT") == true) goto L15;
        throw new IllegalArgumentException("Invalid prefix, must be GMT, UTC or UT: " + r10);
    L15:
        if (r11.getTotalSeconds() != 0) goto L19;
        return new ZoneRegion(r10, r11.getRules());
    L19:
        return new ZoneRegion(r10 + r11.getId(), r11.getRules());
    }

    public static ZoneId systemDefault() {
        return of(TimeZone.getDefault().getID(), SHORT_IDS);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof ZoneId) == true) goto L8;
        return false;
    L8:
        return getId().equals(((ZoneId) r10).getId());
    }

    public String getDisplayName(TextStyle r10, Locale r11) {
        return new DateTimeFormatterBuilder().u(r10).F(r11).d(new b(this));
    }

    public abstract String getId();

    public abstract ZoneRules getRules();

    public int hashCode() {
        return getId().hashCode();
    }

    public ZoneId normalized() {
        ZoneRules r10 = getRules();     // Catch: ZoneRulesException -> L6
        if (r10.isFixedOffset() == false) goto L9;
        return r10.getOffset(Instant.EPOCH);
    L9:
        return this;
    L10:
        return this;
    }

    public String toString() {
        return getId();
    }

    public abstract void write(DataOutput r10) throws IOException;

    public static ZoneId of(String r10) {
        d.h(r10, "zoneId");
        if (r10.equals("Z") == false) goto L7;
        return ZoneOffset.UTC;
    L7:
        if (r10.length() == 1) goto L53;
        if (r10.startsWith("+") == true) goto L51;
        if (r10.startsWith("-") == true) goto L51;
        if (r10.equals("UTC") == true) goto L49;
        if (r10.equals("GMT") == true) goto L49;
        if (r10.equals("UT") == true) goto L49;
        if (r10.startsWith("UTC+") == false) goto L23;
    L42:
        ZoneOffset r11 = ZoneOffset.of(r10.substring(3));
        if (r11.getTotalSeconds() != 0) goto L47;
        return new ZoneRegion(r10.substring(0, 3), r11.getRules());
    L47:
        return new ZoneRegion(r10.substring(0, 3) + r11.getId(), r11.getRules());
    L23:
        if (r10.startsWith("GMT+") == true) goto L42;
        if (r10.startsWith("UTC-") == true) goto L42;
        if (r10.startsWith("GMT-") == true) goto L42;
        if (r10.startsWith("UT+") == false) goto L32;
    L36:
        ZoneOffset r12 = ZoneOffset.of(r10.substring(2));
        if (r12.getTotalSeconds() != 0) goto L41;
        return new ZoneRegion("UT", r12.getRules());
    L41:
        return new ZoneRegion("UT" + r12.getId(), r12.getRules());
    L32:
        if (r10.startsWith("UT-") == true) goto L36;
        return ZoneRegion.ofId(r10, true);
    L49:
        return new ZoneRegion(r10, ZoneOffset.UTC.getRules());
    L51:
        return ZoneOffset.of(r10);
    L53:
        throw new DateTimeException("Invalid zone: " + r10);
    }
}
