package org.threeten.bp.format;

import com.volcengine.zeus.transform.ZeusTransformUtils;
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

/* JADX INFO: loaded from: classes5.dex */
final class SimpleDateTimeTextProvider extends DateTimeTextProvider {
    private static final Comparator<Map.Entry<String, Long>> COMPARATOR = null;
    private final ConcurrentMap<Map.Entry<TemporalField, Locale>, Object> cache;

    static final class LocaleStore {
        private final Map<TextStyle, List<Map.Entry<String, Long>>> parsable;
        private final Map<TextStyle, Map<Long, String>> valueTextMap;

        LocaleStore(Map<TextStyle, Map<Long, String>> r11) {
            Map<TextStyle, Map<Long, String>> r12 = (Map) ZeusTransformUtils.wrapperContextForParams(r11, Map.class, "com.obric.aiagent.plugin");
            this.valueTextMap = r12;
            HashMap r0 = new HashMap();
            ArrayList r2 = new ArrayList();
            Iterator<TextStyle> r3 = r12.keySet().iterator();
        L4:
            if (r3.hasNext() == false) goto L10;
            TextStyle r4 = (TextStyle) ZeusTransformUtils.preCheckCast(r3.next(), TextStyle.class, "com.obric.aiagent.plugin");
            HashMap r5 = new HashMap();
            Iterator r6 = ((Map) ZeusTransformUtils.preCheckCast(r12.get(r4), Map.class, "com.obric.aiagent.plugin")).entrySet().iterator();
        L7:
            if (r6.hasNext() == false) goto L9;
            Map.Entry r7 = (Map.Entry) ZeusTransformUtils.preCheckCast(r6.next(), Map.Entry.class, "com.obric.aiagent.plugin");
            r5.put(r7.getValue(), SimpleDateTimeTextProvider.access$000(r7.getValue(), r7.getKey()));
            goto L7
        L9:
            ArrayList r8 = new ArrayList(r5.values());
            Collections.sort(r8, SimpleDateTimeTextProvider.access$100());
            r0.put(r4, r8);
            r2.addAll(r8);
            r0.put(null, r2);
            goto L4
        L10:
            Collections.sort(r2, SimpleDateTimeTextProvider.access$100());
            this.parsable = r0;
        }

        String getText(long r2, TextStyle r4) {
            Map r1 = (Map) ZeusTransformUtils.preCheckCast(this.valueTextMap.get(r4), Map.class, "com.obric.aiagent.plugin");
            if (r1 != null) goto L7;
            return null;
        L7:
            return (String) ZeusTransformUtils.preCheckCast(r1.get(Long.valueOf(r2)), String.class, "com.obric.aiagent.plugin");
        }

        Iterator<Map.Entry<String, Long>> getTextIterator(TextStyle r2) {
            List r1 = (List) ZeusTransformUtils.preCheckCast(this.parsable.get(r2), List.class, "com.obric.aiagent.plugin");
            if (r1 != null) goto L7;
            return null;
        L7:
            return r1.iterator();
        }
    }

    SimpleDateTimeTextProvider() {
        this.cache = new ConcurrentHashMap(16, 0.75f, 2);
    }

    static /* synthetic */ Map.Entry access$000(Object r0, Object r1) {
        return createEntry(r0, r1);
    }

    static /* synthetic */ Comparator access$100() {
        return COMPARATOR;
    }

    static {
        COMPARATOR = new AnonymousClass1();
    }

    @Override // org.threeten.bp.format.DateTimeTextProvider
    public String getText(TemporalField r3, long r4, TextStyle r6, Locale r7) {
        Object r2 = findStore((TemporalField) ZeusTransformUtils.wrapperContextForParams(r3, TemporalField.class, "com.obric.aiagent.plugin"), r7);
        if (ZeusTransformUtils.instanceOf(r2, LocaleStore.class) == true) goto L5;
        return null;
    L5:
        return ((LocaleStore) ZeusTransformUtils.preCheckCast(r2, LocaleStore.class, "com.obric.aiagent.plugin")).getText(r4, r6);
    }

    @Override // org.threeten.bp.format.DateTimeTextProvider
    public Iterator<Map.Entry<String, Long>> getTextIterator(TemporalField r3, TextStyle r4, Locale r5) {
        Object r2 = findStore((TemporalField) ZeusTransformUtils.wrapperContextForParams(r3, TemporalField.class, "com.obric.aiagent.plugin"), r5);
        if (ZeusTransformUtils.instanceOf(r2, LocaleStore.class) == true) goto L5;
        return null;
    L5:
        return ((LocaleStore) ZeusTransformUtils.preCheckCast(r2, LocaleStore.class, "com.obric.aiagent.plugin")).getTextIterator(r4);
    }

    private Object findStore(TemporalField r3, Locale r4) {
        TemporalField r5 = (TemporalField) ZeusTransformUtils.wrapperContextForParams(r3, TemporalField.class, "com.obric.aiagent.plugin");
        Map.Entry<TemporalField, Locale> r0 = createEntry(r5, r4);
        Object r1 = this.cache.get(r0);
        if (r1 != null) goto L6;
        Object r6 = createStore(r5, r4);
        this.cache.putIfAbsent(r0, r6);
        return this.cache.get(r0);
    L6:
        return r1;
    }

    private Object createStore(TemporalField r21, Locale r22) {
        TemporalField r0 = (TemporalField) ZeusTransformUtils.wrapperContextForParams(r21, TemporalField.class, "com.obric.aiagent.plugin");
        if (r0 != ChronoField.MONTH_OF_YEAR) goto L7;
        DateFormatSymbols r1 = DateFormatSymbols.getInstance(r22);
        HashMap r2 = new HashMap();
        String[] r16 = r1.getMonths();
        HashMap r8 = new HashMap();
        r8.put(1L, r16[0]);
        r8.put(2L, r16[1]);
        r8.put(3L, r16[2]);
        r8.put(4L, r16[3]);
        r8.put(5L, r16[4]);
        r8.put(6L, r16[5]);
        r8.put(7L, r16[6]);
        r8.put(8L, r16[7]);
        r8.put(9L, r16[8]);
        r8.put(10L, r16[9]);
        r8.put(11L, r16[10]);
        r8.put(12L, r16[11]);
        r2.put(TextStyle.FULL, r8);
        HashMap r3 = new HashMap();
        r3.put(1L, r16[0].substring(0, 1));
        r3.put(2L, r16[1].substring(0, 1));
        r3.put(3L, r16[2].substring(0, 1));
        r3.put(4L, r16[3].substring(0, 1));
        r3.put(5L, r16[4].substring(0, 1));
        r3.put(6L, r16[5].substring(0, 1));
        r3.put(7L, r16[6].substring(0, 1));
        r3.put(8L, r16[7].substring(0, 1));
        r3.put(9L, r16[8].substring(0, 1));
        r3.put(10L, r16[9].substring(0, 1));
        r3.put(11L, r16[10].substring(0, 1));
        r3.put(12L, r16[11].substring(0, 1));
        r2.put(TextStyle.NARROW, r3);
        String[] r4 = r1.getShortMonths();
        HashMap r7 = new HashMap();
        r7.put(1L, r4[0]);
        r7.put(2L, r4[1]);
        r7.put(3L, r4[2]);
        r7.put(4L, r4[3]);
        r7.put(5L, r4[4]);
        r7.put(6L, r4[5]);
        r7.put(7L, r4[6]);
        r7.put(8L, r4[7]);
        r7.put(9L, r4[8]);
        r7.put(10L, r4[9]);
        r7.put(11L, r4[10]);
        r7.put(12L, r4[11]);
        r2.put(TextStyle.SHORT, r7);
        return createLocaleStore(r2);
    L7:
        if (r0 != ChronoField.DAY_OF_WEEK) goto L11;
        DateFormatSymbols r5 = DateFormatSymbols.getInstance(r22);
        HashMap r6 = new HashMap();
        String[] r9 = r5.getWeekdays();
        HashMap r10 = new HashMap();
        r10.put(1L, r9[2]);
        r10.put(2L, r9[3]);
        r10.put(3L, r9[4]);
        r10.put(4L, r9[5]);
        r10.put(5L, r9[6]);
        r10.put(6L, r9[7]);
        r10.put(7L, r9[1]);
        r6.put(TextStyle.FULL, r10);
        HashMap r11 = new HashMap();
        r11.put(1L, r9[2].substring(0, 1));
        r11.put(2L, r9[3].substring(0, 1));
        r11.put(3L, r9[4].substring(0, 1));
        r11.put(4L, r9[5].substring(0, 1));
        r11.put(5L, r9[6].substring(0, 1));
        r11.put(6L, r9[7].substring(0, 1));
        r11.put(7L, r9[1].substring(0, 1));
        r6.put(TextStyle.NARROW, r11);
        String[] r12 = r5.getShortWeekdays();
        HashMap r13 = new HashMap();
        r13.put(1L, r12[2]);
        r13.put(2L, r12[3]);
        r13.put(3L, r12[4]);
        r13.put(4L, r12[5]);
        r13.put(5L, r12[6]);
        r13.put(6L, r12[7]);
        r13.put(7L, r12[1]);
        r6.put(TextStyle.SHORT, r13);
        return createLocaleStore(r6);
    L11:
        if (r0 != ChronoField.AMPM_OF_DAY) goto L15;
        DateFormatSymbols r14 = DateFormatSymbols.getInstance(r22);
        HashMap r15 = new HashMap();
        String[] r17 = r14.getAmPmStrings();
        HashMap r18 = new HashMap();
        r18.put(0L, r17[0]);
        r18.put(1L, r17[1]);
        r15.put(TextStyle.FULL, r18);
        r15.put(TextStyle.SHORT, r18);
        return createLocaleStore(r15);
    L15:
        if (r0 != ChronoField.ERA) goto L23;
        DateFormatSymbols r19 = DateFormatSymbols.getInstance(r22);
        HashMap r20 = new HashMap();
        String[] r23 = r19.getEras();
        HashMap r24 = new HashMap();
        r24.put(0L, r23[0]);
        r24.put(1L, r23[1]);
        r20.put(TextStyle.SHORT, r24);
        if (r22.getLanguage().equals(Locale.ENGLISH.getLanguage()) == false) goto L19;
        HashMap r25 = new HashMap();
        r25.put(0L, "Before Christ");
        r25.put(1L, "Anno Domini");
        r20.put(TextStyle.FULL, r25);
    L20:
        HashMap r26 = new HashMap();
        r26.put(0L, r23[0].substring(0, 1));
        r26.put(1L, r23[1].substring(0, 1));
        r20.put(TextStyle.NARROW, r26);
        return createLocaleStore(r20);
    L19:
        r20.put(TextStyle.FULL, r24);
        goto L20
    L23:
        if (r0 != IsoFields.QUARTER_OF_YEAR) goto L26;
        HashMap r27 = new HashMap();
        HashMap r28 = new HashMap();
        r28.put(1L, "Q1");
        r28.put(2L, "Q2");
        r28.put(3L, "Q3");
        r28.put(4L, "Q4");
        r27.put(TextStyle.SHORT, r28);
        HashMap r29 = new HashMap();
        r29.put(1L, "1st quarter");
        r29.put(2L, "2nd quarter");
        r29.put(3L, "3rd quarter");
        r29.put(4L, "4th quarter");
        r27.put(TextStyle.FULL, r29);
        return createLocaleStore(r27);
    L26:
        return "";
    }

    private static <A, B> Map.Entry<A, B> createEntry(A r1, B r2) {
        return new AbstractMap.SimpleImmutableEntry(r1, r2);
    }

    private static LocaleStore createLocaleStore(Map<TextStyle, Map<Long, String>> r2) {
        Map r3 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.aiagent.plugin");
        r3.put(TextStyle.FULL_STANDALONE, r3.get(TextStyle.FULL));
        r3.put(TextStyle.SHORT_STANDALONE, r3.get(TextStyle.SHORT));
        if (r3.containsKey(TextStyle.NARROW) == false) goto L8;
        if (r3.containsKey(TextStyle.NARROW_STANDALONE) == true) goto L8;
        r3.put(TextStyle.NARROW_STANDALONE, r3.get(TextStyle.NARROW));
    L8:
        return new LocaleStore(r3);
    }
}
