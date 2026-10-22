package com.bytedance.android.livesdk.announce;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes7.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String[] f103134a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SimpleDateFormat f103135b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final LinkedHashMap<String, Integer> f103136c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final LinkedHashMap<Integer, String> f103137d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String[] f103138e = null;

    static {
        f103134a = new String[]{"", "周日", "周一", "周二", "周三", "周四", "周五", "周六"};
        f103135b = new SimpleDateFormat("yyyy|M月d日 E|HH|mm");
        LinkedHashMap<String, Integer> r100 = new LinkedHashMap();
        r100.put("每周一", 1);
        r100.put("每周二", 2);
        r100.put("每周三", 3);
        r100.put("每周四", 4);
        r100.put("每周五", 5);
        r100.put("每周六", 6);
        r100.put("每周日", 0);
        f103136c = r100;
        LinkedHashMap<Integer, String> r101 = new LinkedHashMap();
        Iterator<Map.Entry<String, Integer>> r102 = r100.entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        Map.Entry<String, Integer> r103 = r102.next();
        r101.put(r103.getValue(), r103.getKey());
        goto L4
    L6:
        f103137d = r101;
        Object[] r104 = f103136c.keySet().toArray(new String[0]);
        if (r104 == null) goto L11;
        f103138e = (String[]) r104;
        new DateFormatSymbols().setShortWeekdays(f103134a);
        return;
    L11:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    public static String a(long r100) {
        String r101 = new SimpleDateFormat("MM月dd日 HH:mm").format(new Date(r100));     // Catch: Exception -> L5
        if (r101 != null) goto L11;
    L7:
        return "";
    L11:
        return r101;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    public static String b(Date r100) {
        if (r100 != null) goto L5;
        return "";
    L5:
        List r101 = StringsKt.split$default(f103135b.format(r100), new String[]{HiAnalyticsConstant.REPORT_VAL_SEPARATOR}, false, 0, 6, null);
        if (r101.size() >= 4) goto L9;
        return "";
    L9:
        return (String) ListProtector.get(r101, 1);
    }

    public static String c(Date r100) {
        if (r100 != null) goto L5;
        return "";
    L5:
        List r101 = StringsKt.split$default(f103135b.format(r100), new String[]{HiAnalyticsConstant.REPORT_VAL_SEPARATOR}, false, 0, 6, null);
        if (r101.size() >= 3) goto L9;
        return "";
    L9:
        return (String) ListProtector.get(r101, 2);
    }

    public static String d(Date r100) {
        if (r100 != null) goto L5;
        return "";
    L5:
        List r101 = StringsKt.split$default(f103135b.format(r100), new String[]{HiAnalyticsConstant.REPORT_VAL_SEPARATOR}, false, 0, 6, null);
        if (r101.size() >= 3) goto L9;
        return "";
    L9:
        return (String) ListProtector.get(r101, 3);
    }

    public static long f(b r100) {
        if (r100 == null) goto L4;
        Date r101 = r100.f103130a;
    L6:
        if (r101 != null) goto L8;
        return 0;
    L8:
        boolean r102 = false;
        List r103 = h(r100, false);
        if (r103.isEmpty() == false) goto L11;
        return 0;
    L11:
        Calendar r104 = Calendar.getInstance();
        Iterator r105 = r103.iterator();
    L12:
        boolean r106 = true;
        if (r105.hasNext() == false) goto L21;
        int r107 = ((Number) r105.next()).intValue();
        Date r108 = r100.f103130a;
        Intrinsics.checkNotNull(r108);
        if (r104.getFirstDayOfWeek() == 1) goto L18;
        r106 = false;
    L18:
        long r109 = e(0, r108, r107, r106);
        if (r109 <= r104.getTimeInMillis()) goto L12;
        return r109;
    L21:
        Date r110 = r100.f103130a;
        Intrinsics.checkNotNull(r110);
        int r111 = ((Number) CollectionsKt.first(r103)).intValue();
        if (r104.getFirstDayOfWeek() != 1) goto L25;
        r102 = true;
    L25:
        return e(1, r110, r111, r102);
    L4:
        r101 = null;
        goto L6
    }

    public static int g(b r100) {
        if (r100 != null) goto L5;
        return 0;
    L5:
        Integer r101 = StringsKt.toIntOrNull(c(r100.f103130a) + d(r100.f103130a));
        if (r101 != null) goto L8;
        return 0;
    L8:
        return r101.intValue();
    }

    public static List h(b r100, boolean r101) {
        if (r100 == null) goto L4;
        ArrayList r102 = new ArrayList();
        Iterator<T> r103 = r100.f103131b.iterator();
    L7:
        if (r103.hasNext() == false) goto L12;
        d r104 = (d) r103.next();
        Integer r105 = f103136c.get(r104.f103139a);
        if (r105 != null) goto L11;
        r105 = -1;
    L11:
        r102.add(r105);
        goto L7
    L12:
        ArrayList r106 = new ArrayList();
        Iterator r107 = r102.iterator();
    L13:
        boolean r108 = true;
        if (r107.hasNext() == false) goto L21;
        Object r109 = r107.next();
        if (((Number) r109).intValue() != (-1)) goto L19;
        r108 = false;
    L19:
        if (r108 == false) goto L13;
        r106.add(r109);
        goto L13
    L21:
        List r110 = CollectionsKt.toMutableList(CollectionsKt.sorted(r106));
        if (r101 == true) goto L24;
        return r110;
    L24:
        if (r110.size() > 1) goto L26;
        return r110;
    L26:
        if (((Number) ListProtector.get(r110, 0)).intValue() != 0) goto L39;
        List r111 = CollectionsKt.toMutableList(r110.subList(1, r110.size()));
        r111.add(0);
        return r111;
    L39:
        return r110;
    L4:
        return CollectionsKt.emptyList();
    }

    public static long e(int r100, Date r101, int r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r101, "date");
        Calendar r104 = Calendar.getInstance();
        r104.add(4, r100);
        if (r103 == false) goto L5;
        r104.set(7, r102 + 1);
    L8:
        r104.set(11, CastIntegerProtector.parseInt(c(r101)));
        r104.set(12, CastIntegerProtector.parseInt(d(r101)));
        r104.set(13, 0);
        r104.set(14, 0);
        return r104.getTimeInMillis();
    L5:
        if (r102 != 0) goto L7;
        r102 = 7;
    L7:
        r104.set(7, r102);
        goto L8
    }
}
