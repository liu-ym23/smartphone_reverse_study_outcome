package bytedance.jvm.time.format;

import bytedance.jvm.time.chrono.IsoChronology;
import bytedance.jvm.time.temporal.ChronoField;
import java.text.DateFormatSymbols;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: loaded from: classes28.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentMap<Map.Entry<bytedance.jvm.time.temporal.j, Locale>, Object> f21653a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f21654b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final f f21655c = null;

    public class a implements Comparator<Map.Entry<String, Long>> {
        public a() {
        }

        @Override // java.util.Comparator
        public final int compare(Map.Entry<String, Long> r100, Map.Entry<String, Long> r101) {
            return r101.getKey().length() - r100.getKey().length();
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Map<TextStyle, Map<Long, String>> f21656a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Map<TextStyle, List<Map.Entry<String, Long>>> f21657b;

        public b(Map<TextStyle, Map<Long, String>> r110) {
            this.f21656a = r110;
            HashMap r100 = new HashMap();
            ArrayList r101 = new ArrayList();
            Iterator<Map.Entry<TextStyle, Map<Long, String>>> r111 = r110.entrySet().iterator();
        L4:
            if (r111.hasNext() == false) goto L10;
            Map.Entry<TextStyle, Map<Long, String>> r102 = r111.next();
            HashMap r103 = new HashMap();
            Iterator<Map.Entry<Long, String>> r104 = r102.getValue().entrySet().iterator();
        L7:
            if (r104.hasNext() == false) goto L9;
            Map.Entry<Long, String> r105 = r104.next();
            String r106 = r105.getValue();
            String r107 = r105.getValue();
            Long r108 = r105.getKey();
            ConcurrentMap<Map.Entry<bytedance.jvm.time.temporal.j, Locale>, Object> r109 = f.f21653a;
            r103.put(r106, new AbstractMap.SimpleImmutableEntry(r107, r108));
            goto L7
        L9:
            ArrayList r112 = new ArrayList(r103.values());
            Collections.sort(r112, f.f21654b);
            r100.put(r102.getKey(), r112);
            r101.addAll(r112);
            r100.put(null, r101);
            goto L4
        L10:
            Collections.sort(r101, f.f21654b);
            this.f21657b = r100;
        }

        public final Iterator<Map.Entry<String, Long>> b(TextStyle r100) {
            List r101 = (List) ((HashMap) this.f21657b).get(r100);
            if (r101 != null) goto L7;
            return null;
        L7:
            return r101.iterator();
        }

        public final String a(long r100, TextStyle r101) {
            Map<Long, String> r102 = this.f21656a.get(r101);
            if (r102 != null) goto L7;
            return null;
        L7:
            return r102.get(Long.valueOf(r100));
        }
    }

    public f() {
    }

    static {
        f21653a = new ConcurrentHashMap(16, 0.75f, 2);
        f21654b = new a();
        f21655c = new f();
    }

    public static Object a(bytedance.jvm.time.temporal.j r110, Locale r111) {
        AbstractMap.SimpleImmutableEntry r100 = new AbstractMap.SimpleImmutableEntry(r110, r111);
        Object r101 = ((ConcurrentHashMap) f21653a).get(r100);
        if (r101 != null) goto L72;
        HashMap r102 = new HashMap();
        if (r110 != ChronoField.ERA) goto L18;
        DateFormatSymbols r112 = DateFormatSymbols.getInstance(r111);
        HashMap r113 = new HashMap();
        HashMap r103 = new HashMap();
        String[] r114 = r112.getEras();
        int r104 = 0;
    L8:
        if (r104 >= r114.length) goto L14;
        if (r114[r104].isEmpty() == true) goto L12;
        long r105 = r104;
        r113.put(Long.valueOf(r105), r114[r104]);
        Long r106 = Long.valueOf(r105);
        String r107 = r114[r104];
        r103.put(r106, r107.substring(0, Character.charCount(r107.codePointAt(0))));
    L12:
        r104 = r104 + 1;
        goto L8
    L14:
        if (r113.isEmpty() == true) goto L16;
        r102.put(TextStyle.FULL, r113);
        r102.put(TextStyle.SHORT, r113);
        r102.put(TextStyle.NARROW, r103);
    L16:
        Object r115 = new b(r102);
    L60:
        ConcurrentHashMap r116 = (ConcurrentHashMap) f21653a;
        r116.putIfAbsent(r100, r115);
        return r116.get(r100);
    L18:
        if (r110 != ChronoField.MONTH_OF_YEAR) goto L27;
        int r117 = DateFormatSymbols.getInstance(r111).getMonths().length;
        LinkedHashMap r108 = new LinkedHashMap();
        LinkedHashMap r109 = new LinkedHashMap();
        LinkedHashMap r118 = new LinkedHashMap();
        long r119 = 1;
    L21:
        if (r119 > r117) goto L23;
        String r120 = h.b(r119, "LLLL", r111);
        r108.put(Long.valueOf(r119), r120);
        r109.put(Long.valueOf(r119), r120.substring(0, Character.charCount(r120.codePointAt(0))));
        r118.put(Long.valueOf(r119), h.b(r119, "LLL", r111));
        r119 = r119 + 1;
        goto L21
    L23:
        if (r117 <= 0) goto L25;
        r102.put(TextStyle.FULL_STANDALONE, r108);
        r102.put(TextStyle.NARROW_STANDALONE, r109);
        r102.put(TextStyle.SHORT_STANDALONE, r118);
        r102.put(TextStyle.FULL, r108);
        r102.put(TextStyle.NARROW, r109);
        r102.put(TextStyle.SHORT, r118);
    L25:
        r115 = new b(r102);
        goto L60
    L27:
        if (r110 != ChronoField.DAY_OF_WEEK) goto L47;
        int r121 = DateFormatSymbols.getInstance(r111).getWeekdays().length;
        LinkedHashMap r122 = new LinkedHashMap();
        LinkedHashMap r123 = new LinkedHashMap();
        LinkedHashMap r124 = new LinkedHashMap();
        if (r111 != Locale.SIMPLIFIED_CHINESE) goto L31;
    L34:
        boolean r125 = true;
    L35:
        long r126 = 1;
    L37:
        if (r126 > r121) goto L43;
        String r127 = h.a(r126, "cccc", r111);
        r122.put(Long.valueOf(r126), r127);
        Long r128 = Long.valueOf(r126);
        if (r125 == false) goto L41;
        String r129 = new StringBuilder().appendCodePoint(r127.codePointBefore(r127.length())).toString();
    L42:
        r123.put(r128, r129);
        r124.put(Long.valueOf(r126), h.a(r126, "ccc", r111));
        r126 = r126 + 1;
        goto L37
    L41:
        r129 = r127.substring(0, Character.charCount(r127.codePointAt(0)));
        goto L42
    L43:
        if (r121 <= 0) goto L45;
        r102.put(TextStyle.FULL_STANDALONE, r122);
        r102.put(TextStyle.NARROW_STANDALONE, r123);
        r102.put(TextStyle.SHORT_STANDALONE, r124);
        r102.put(TextStyle.FULL, r122);
        r102.put(TextStyle.NARROW, r123);
        r102.put(TextStyle.SHORT, r124);
    L45:
        r115 = new b(r102);
        goto L60
    L31:
        if (r111 == Locale.TRADITIONAL_CHINESE) goto L34;
        r125 = false;
        goto L35
    L47:
        if (r110 != ChronoField.AMPM_OF_DAY) goto L59;
        DateFormatSymbols r130 = DateFormatSymbols.getInstance(r111);
        HashMap r131 = new HashMap();
        HashMap r132 = new HashMap();
        String[] r133 = r130.getAmPmStrings();
        int r134 = 0;
    L50:
        if (r134 >= r133.length) goto L56;
        if (r133[r134].isEmpty() == true) goto L54;
        long r135 = r134;
        r131.put(Long.valueOf(r135), r133[r134]);
        Long r136 = Long.valueOf(r135);
        String r137 = r133[r134];
        r132.put(r136, r137.substring(0, Character.charCount(r137.codePointAt(0))));
    L54:
        r134 = r134 + 1;
        goto L50
    L56:
        if (r131.isEmpty() == true) goto L58;
        r102.put(TextStyle.FULL, r131);
        r102.put(TextStyle.SHORT, r131);
        r102.put(TextStyle.NARROW, r132);
    L58:
        r115 = new b(r102);
        goto L60
    L59:
        r115 = "";
        goto L60
    L72:
        return r101;
    }

    public Iterator<Map.Entry<String, Long>> e(bytedance.jvm.time.temporal.j r100, TextStyle r101, Locale r102) {
        Object r103 = a(r100, r102);
        if ((r103 instanceof b) == true) goto L5;
        return null;
    L5:
        return ((b) r103).b(r101);
    }

    public String c(bytedance.jvm.time.temporal.j r100, long r101, TextStyle r102, Locale r103) {
        Object r104 = a(r100, r103);
        if ((r104 instanceof b) == true) goto L5;
        return null;
    L5:
        return ((b) r104).a(r101, r102);
    }

    public Iterator<Map.Entry<String, Long>> d(bytedance.jvm.time.chrono.j r100, bytedance.jvm.time.temporal.j r101, TextStyle r102, Locale r103) {
        if (r100 == IsoChronology.INSTANCE) goto L10;
        if ((r101 instanceof ChronoField) == false) goto L10;
        return null;
    L10:
        return e(r101, r102, r103);
    }

    public String b(bytedance.jvm.time.chrono.j r100, bytedance.jvm.time.temporal.j r101, long r102, TextStyle r110, Locale r111) {
        if (r100 == IsoChronology.INSTANCE) goto L10;
        if ((r101 instanceof ChronoField) == false) goto L10;
        return null;
    L10:
        return c(r101, r102, r110, r111);
    }
}
