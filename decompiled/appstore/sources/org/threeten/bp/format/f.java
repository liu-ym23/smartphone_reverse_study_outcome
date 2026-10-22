package org.threeten.bp.format;

import java.text.DateFormatSymbols;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.IsoFields;
import org.threeten.bp.temporal.TemporalField;

/* JADX INFO: loaded from: classes4.dex */
public final class f extends d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Comparator f23213c = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentMap f23214b;

    public static class a implements Comparator {
        public a() {
        }

        public int a(Map.Entry r10, Map.Entry r11) {
            return ((String) r11.getKey()).length() - ((String) r10.getKey()).length();
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(Object r10, Object r11) {
            return a((Map.Entry) r10, (Map.Entry) r11);
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Map f23215a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Map f23216b;

        public b(Map r10) {
            this.f23215a = r10;
            HashMap r11 = new HashMap();
            ArrayList r12 = new ArrayList();
            Iterator r13 = r10.keySet().iterator();
        L4:
            if (r13.hasNext() == false) goto L10;
            TextStyle r14 = (TextStyle) r13.next();
            HashMap r15 = new HashMap();
            Iterator r16 = ((Map) r10.get(r14)).entrySet().iterator();
        L7:
            if (r16.hasNext() == false) goto L9;
            Map.Entry r17 = (Map.Entry) r16.next();
            r15.put(r17.getValue(), f.e(r17.getValue(), r17.getKey()));
            goto L7
        L9:
            ArrayList r18 = new ArrayList(r15.values());
            Collections.sort(r18, f.f());
            r11.put(r14, r18);
            r12.addAll(r18);
            r11.put(null, r12);
            goto L4
        L10:
            Collections.sort(r12, f.f());
            this.f23216b = r11;
        }

        public String a(long r10, TextStyle r11) {
            Map r12 = (Map) this.f23215a.get(r11);
            if (r12 != null) goto L7;
            return null;
        L7:
            return (String) r12.get(Long.valueOf(r10));
        }

        public Iterator b(TextStyle r10) {
            List r11 = (List) this.f23216b.get(r10);
            if (r11 != null) goto L7;
            return null;
        L7:
            return r11.iterator();
        }
    }

    static {
        f23213c = new a();
    }

    public f() {
        this.f23214b = new ConcurrentHashMap(16, 0.75f, 2);
    }

    public static /* synthetic */ Map.Entry e(Object r10, Object r11) {
        return g(r10, r11);
    }

    public static /* synthetic */ Comparator f() {
        return f23213c;
    }

    public static Map.Entry g(Object r10, Object r11) {
        return new AbstractMap.SimpleImmutableEntry(r10, r11);
    }

    public static b h(Map r10) {
        r10.put(TextStyle.FULL_STANDALONE, r10.get(TextStyle.FULL));
        r10.put(TextStyle.SHORT_STANDALONE, r10.get(TextStyle.SHORT));
        TextStyle r11 = TextStyle.NARROW;
        if (r10.containsKey(r11) == false) goto L8;
        TextStyle r12 = TextStyle.NARROW_STANDALONE;
        if (r10.containsKey(r12) == true) goto L8;
        r10.put(r12, r10.get(r11));
    L8:
        return new b(r10);
    }

    @Override // org.threeten.bp.format.d
    public String c(TemporalField r10, long r11, TextStyle r12, Locale r13) {
        Object r14 = j(r10, r13);
        if ((r14 instanceof b) == true) goto L5;
        return null;
    L5:
        return ((b) r14).a(r11, r12);
    }

    @Override // org.threeten.bp.format.d
    public Iterator d(TemporalField r10, TextStyle r11, Locale r12) {
        Object r13 = j(r10, r12);
        if ((r13 instanceof b) == true) goto L5;
        return null;
    L5:
        return ((b) r13).b(r11);
    }

    public final Object i(TemporalField r21, Locale r22) {
        if (r21 != ChronoField.MONTH_OF_YEAR) goto L7;
        DateFormatSymbols r10 = DateFormatSymbols.getInstance(r22);
        HashMap r11 = new HashMap();
        String[] r16 = r10.getMonths();
        HashMap r12 = new HashMap();
        r12.put(1L, r16[0]);
        r12.put(2L, r16[1]);
        r12.put(3L, r16[2]);
        r12.put(4L, r16[3]);
        r12.put(5L, r16[4]);
        r12.put(6L, r16[5]);
        r12.put(7L, r16[6]);
        r12.put(8L, r16[7]);
        r12.put(9L, r16[8]);
        r12.put(10L, r16[9]);
        r12.put(11L, r16[10]);
        r12.put(12L, r16[11]);
        r11.put(TextStyle.FULL, r12);
        HashMap r13 = new HashMap();
        r13.put(1L, r16[0].substring(0, 1));
        r13.put(2L, r16[1].substring(0, 1));
        r13.put(3L, r16[2].substring(0, 1));
        r13.put(4L, r16[3].substring(0, 1));
        r13.put(5L, r16[4].substring(0, 1));
        r13.put(6L, r16[5].substring(0, 1));
        r13.put(7L, r16[6].substring(0, 1));
        r13.put(8L, r16[7].substring(0, 1));
        r13.put(9L, r16[8].substring(0, 1));
        r13.put(10L, r16[9].substring(0, 1));
        r13.put(11L, r16[10].substring(0, 1));
        r13.put(12L, r16[11].substring(0, 1));
        r11.put(TextStyle.NARROW, r13);
        String[] r14 = r10.getShortMonths();
        HashMap r15 = new HashMap();
        r15.put(1L, r14[0]);
        r15.put(2L, r14[1]);
        r15.put(3L, r14[2]);
        r15.put(4L, r14[3]);
        r15.put(5L, r14[4]);
        r15.put(6L, r14[5]);
        r15.put(7L, r14[6]);
        r15.put(8L, r14[7]);
        r15.put(9L, r14[8]);
        r15.put(10L, r14[9]);
        r15.put(11L, r14[10]);
        r15.put(12L, r14[11]);
        r11.put(TextStyle.SHORT, r15);
        return h(r11);
    L7:
        if (r21 != ChronoField.DAY_OF_WEEK) goto L11;
        DateFormatSymbols r17 = DateFormatSymbols.getInstance(r22);
        HashMap r18 = new HashMap();
        String[] r19 = r17.getWeekdays();
        HashMap r20 = new HashMap();
        r20.put(1L, r19[2]);
        r20.put(2L, r19[3]);
        r20.put(3L, r19[4]);
        r20.put(4L, r19[5]);
        r20.put(5L, r19[6]);
        r20.put(6L, r19[7]);
        r20.put(7L, r19[1]);
        r18.put(TextStyle.FULL, r20);
        HashMap r23 = new HashMap();
        r23.put(1L, r19[2].substring(0, 1));
        r23.put(2L, r19[3].substring(0, 1));
        r23.put(3L, r19[4].substring(0, 1));
        r23.put(4L, r19[5].substring(0, 1));
        r23.put(5L, r19[6].substring(0, 1));
        r23.put(6L, r19[7].substring(0, 1));
        r23.put(7L, r19[1].substring(0, 1));
        r18.put(TextStyle.NARROW, r23);
        String[] r24 = r17.getShortWeekdays();
        HashMap r25 = new HashMap();
        r25.put(1L, r24[2]);
        r25.put(2L, r24[3]);
        r25.put(3L, r24[4]);
        r25.put(4L, r24[5]);
        r25.put(5L, r24[6]);
        r25.put(6L, r24[7]);
        r25.put(7L, r24[1]);
        r18.put(TextStyle.SHORT, r25);
        return h(r18);
    L11:
        if (r21 != ChronoField.AMPM_OF_DAY) goto L15;
        DateFormatSymbols r26 = DateFormatSymbols.getInstance(r22);
        HashMap r27 = new HashMap();
        String[] r28 = r26.getAmPmStrings();
        HashMap r29 = new HashMap();
        r29.put(0L, r28[0]);
        r29.put(1L, r28[1]);
        r27.put(TextStyle.FULL, r29);
        r27.put(TextStyle.SHORT, r29);
        return h(r27);
    L15:
        if (r21 != ChronoField.ERA) goto L23;
        DateFormatSymbols r30 = DateFormatSymbols.getInstance(r22);
        HashMap r31 = new HashMap();
        String[] r32 = r30.getEras();
        HashMap r33 = new HashMap();
        r33.put(0L, r32[0]);
        r33.put(1L, r32[1]);
        r31.put(TextStyle.SHORT, r33);
        if (r22.getLanguage().equals(Locale.ENGLISH.getLanguage()) == false) goto L19;
        HashMap r34 = new HashMap();
        r34.put(0L, "Before Christ");
        r34.put(1L, "Anno Domini");
        r31.put(TextStyle.FULL, r34);
    L20:
        HashMap r35 = new HashMap();
        r35.put(0L, r32[0].substring(0, 1));
        r35.put(1L, r32[1].substring(0, 1));
        r31.put(TextStyle.NARROW, r35);
        return h(r31);
    L19:
        r31.put(TextStyle.FULL, r33);
        goto L20
    L23:
        if (r21 != IsoFields.f23218b) goto L26;
        HashMap r36 = new HashMap();
        HashMap r37 = new HashMap();
        r37.put(1L, "Q1");
        r37.put(2L, "Q2");
        r37.put(3L, "Q3");
        r37.put(4L, "Q4");
        r36.put(TextStyle.SHORT, r37);
        HashMap r38 = new HashMap();
        r38.put(1L, "1st quarter");
        r38.put(2L, "2nd quarter");
        r38.put(3L, "3rd quarter");
        r38.put(4L, "4th quarter");
        r36.put(TextStyle.FULL, r38);
        return h(r36);
    L26:
        return "";
    }

    public final Object j(TemporalField r10, Locale r11) {
        Map.Entry r12 = g(r10, r11);
        Object r13 = this.f23214b.get(r12);
        if (r13 != null) goto L6;
        Object r14 = i(r10, r11);
        this.f23214b.putIfAbsent(r12, r14);
        return this.f23214b.get(r12);
    L6:
        return r13;
    }
}
