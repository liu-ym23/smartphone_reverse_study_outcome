package com.stepos.digitalwellbeing.server.transaction.usagstats.alphame;

import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import com.stepos.digitalwellbeing.server.data.Category;
import com.stepos.digitalwellbeing.server.data.StatsDataSet;
import com.stepos.digitalwellbeing.utils.PackageUtils;
import f2.C0702g;
import f2.C0711p;
import java.util.HashMap;
import java.util.Map;
import k3.C0813a;

/* loaded from: classes.dex */
public final class s {
    private static Map<String, Long> a(StatsDataSet[] statsDataSetArr) {
        HashMap map = new HashMap();
        if (statsDataSetArr != null) {
            for (StatsDataSet statsDataSet : statsDataSetArr) {
                if (statsDataSet != null && statsDataSet.getPackageUsingTimeMap() != null) {
                    for (Map.Entry<String, Long> entry : statsDataSet.getPackageUsingTimeMap().entrySet()) {
                        if (entry.getValue() != null && entry.getValue().longValue() > 0) {
                            map.put(entry.getKey(), Long.valueOf(((Long) C0813a.a(map, entry.getKey(), 0L)).longValue() + entry.getValue().longValue()));
                        }
                    }
                }
            }
        }
        return map;
    }

    private static void b(String str, String str2, StatsDataSet statsDataSet, W1.c cVar) throws Throwable {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        String strTrim = str.trim();
        String strTrim2 = str2.trim();
        if (strTrim.contains("=")) {
            String[] strArrSplit = strTrim.split("=", 2);
            if (strArrSplit.length != 2) {
                return;
            }
            String strTrim3 = strArrSplit[0].trim();
            String strTrim4 = strArrSplit[1].trim();
            if (strTrim4.startsWith("(") && strTrim2.endsWith(")")) {
                try {
                    int i5 = Integer.parseInt(strTrim4.substring(1));
                    long j5 = Long.parseLong(strTrim2.substring(0, strTrim2.length() - 1));
                    if (!PackageUtils.u(strTrim3) && !PackageUtils.q(strTrim3) && j5 > 0) {
                        Map<String, Long> packageUsingTimeMap = statsDataSet.getPackageUsingTimeMap();
                        packageUsingTimeMap.put(strTrim3, Long.valueOf(((Long) C0813a.a(packageUsingTimeMap, strTrim3, 0L)).longValue() + j5));
                        Map<String, Integer> packageNotifyTimesMap = statsDataSet.getPackageNotifyTimesMap();
                        packageNotifyTimesMap.put(strTrim3, Integer.valueOf(((Integer) C0813a.a(packageNotifyTimesMap, strTrim3, 0)).intValue() + i5));
                        Category categoryI = cVar.i(strTrim3);
                        String strB = W1.a.b(categoryI != null ? categoryI.getId() : 10);
                        Map<String, Long> categoryUsingTimeMap = statsDataSet.getCategoryUsingTimeMap();
                        categoryUsingTimeMap.put(strB, Long.valueOf(((Long) C0813a.a(categoryUsingTimeMap, strB, 0L)).longValue() + j5));
                    }
                } catch (Exception unused) {
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:89:0x021d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int c(android.content.Context r25, W1.c r26, com.stepos.digitalwellbeing.server.data.StatsDataSet r27) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 552
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.digitalwellbeing.server.transaction.usagstats.alphame.s.c(android.content.Context, W1.c, com.stepos.digitalwellbeing.server.data.StatsDataSet):int");
    }

    /* JADX WARN: Not initialized variable reg: 4, insn: 0x002b: MOVE (r3 I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY]), block:B:13:0x002b */
    public static StatsDataSet d(Context context, W1.c cVar) throws Throwable {
        Cursor cursor;
        StatsDataSet statsDataSet;
        Cursor cursorQuery;
        Cursor cursor2;
        Cursor cursor3 = null;
        if (context != null) {
            try {
                if (cVar != null) {
                    try {
                        cursorQuery = context.getContentResolver().query(g.f14667a, null, null, null, null);
                        try {
                            if (cursorQuery == null) {
                                C0702g.O("TodaySimpleStatsFallback", "today_simple cursor is null");
                                if (cursorQuery != null) {
                                    cursorQuery.close();
                                }
                                return null;
                            }
                            try {
                                if (cursorQuery.getCount() == 0) {
                                    C0702g.O("TodaySimpleStatsFallback", "today_simple cursor is empty");
                                    cursorQuery.close();
                                    return null;
                                }
                                cursorQuery.moveToFirst();
                                long j5 = cursorQuery.getLong(cursorQuery.getColumnIndexOrThrow("total_used_time"));
                                int i5 = cursorQuery.getInt(cursorQuery.getColumnIndexOrThrow("screen_on_times"));
                                int i6 = cursorQuery.getInt(cursorQuery.getColumnIndexOrThrow("notifications"));
                                Map<String, Long> mapG = g(cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("app_details")));
                                if (mapG.isEmpty() && j5 <= 0) {
                                    C0702g.O("TodaySimpleStatsFallback", "today_simple has no usable package data");
                                    cursorQuery.close();
                                    return null;
                                }
                                long jY = C0711p.y();
                                statsDataSet = null;
                                cursor2 = cursorQuery;
                                try {
                                    long jCurrentTimeMillis = System.currentTimeMillis();
                                    com.stepos.digitalwellbeing.server.data.a aVar = com.stepos.digitalwellbeing.server.data.a.DAY;
                                    StatsDataSet statsDataSet2 = new StatsDataSet(aVar.ordinal(), 24, jCurrentTimeMillis, jY, StatsDataSet.createEmptyStatsDataSetArray(jY, jCurrentTimeMillis, aVar.ordinal()));
                                    long jK = k(mapG);
                                    statsDataSet2.setUsingTime(jK > 0 ? jK : j5);
                                    statsDataSet2.setPickupTimes(i5);
                                    statsDataSet2.setNotifyTimes(i6);
                                    statsDataSet2.setPackageUsingTimeMap(mapG);
                                    statsDataSet2.setCategoryUsingTimeMap(e(cVar, mapG));
                                    if (c(context, cVar, statsDataSet2) == 3) {
                                        C0702g.O("TodaySimpleStatsFallback", "drop today_simple fallback due to inflated today_hours using=" + C0711p.t(statsDataSet2.getUsingTime()));
                                        cursor2.close();
                                        return null;
                                    }
                                    c.i(statsDataSet2);
                                    C0702g.O("TodaySimpleStatsFallback", "today_simple fallback using=" + C0711p.t(statsDataSet2.getUsingTime()) + " totalUsedTime=" + C0711p.t(j5) + " packageSum=" + C0711p.t(jK) + " packages=" + mapG.size());
                                    cursor2.close();
                                    return statsDataSet2;
                                } catch (Exception e6) {
                                    e = e6;
                                    cursorQuery = cursor2;
                                    C0702g.p("TodaySimpleStatsFallback", "build today_simple fallback failed: " + C0702g.o(e));
                                    if (cursorQuery != null) {
                                        cursorQuery.close();
                                    }
                                    return statsDataSet;
                                } catch (Throwable th) {
                                    th = th;
                                    cursor3 = cursor2;
                                    if (cursor3 != null) {
                                        cursor3.close();
                                    }
                                    throw th;
                                }
                            } catch (Exception e7) {
                                e = e7;
                                statsDataSet = null;
                            } catch (Throwable th2) {
                                th = th2;
                                cursor2 = cursorQuery;
                            }
                        } catch (Exception e8) {
                            e = e8;
                            statsDataSet = null;
                        }
                    } catch (Exception e9) {
                        e = e9;
                        statsDataSet = null;
                        cursorQuery = null;
                    } catch (Throwable th3) {
                        th = th3;
                    }
                }
            } catch (Throwable th4) {
                th = th4;
                cursor3 = cursor;
            }
        }
        return null;
    }

    static Map<String, Long> e(W1.c cVar, Map<String, Long> map) throws Throwable {
        HashMap map2 = new HashMap();
        for (Map.Entry<String, Long> entry : map.entrySet()) {
            Category categoryI = cVar.i(entry.getKey());
            String strB = W1.a.b(categoryI != null ? categoryI.getId() : 10);
            map2.put(strB, Long.valueOf(((Long) C0813a.a(map2, strB, 0L)).longValue() + entry.getValue().longValue()));
        }
        return map2;
    }

    /* JADX WARN: Removed duplicated region for block: B:203:0x03bc  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x03c3  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0098  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean f(android.content.Context r31, W1.c r32, com.stepos.digitalwellbeing.server.data.StatsDataSet r33) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 968
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.digitalwellbeing.server.transaction.usagstats.alphame.s.f(android.content.Context, W1.c, com.stepos.digitalwellbeing.server.data.StatsDataSet):boolean");
    }

    private static Map<String, Long> g(String str) throws NumberFormatException {
        HashMap map = new HashMap();
        if (!TextUtils.isEmpty(str)) {
            for (String str2 : str.split("\\|")) {
                if (!TextUtils.isEmpty(str2)) {
                    try {
                        String[] strArrSplit = str2.split("=", 2);
                        if (strArrSplit.length == 2) {
                            String strTrim = strArrSplit[0].trim();
                            String strTrim2 = strArrSplit[1].trim();
                            if (strTrim2.startsWith("(") && strTrim2.endsWith(")")) {
                                String[] strArrSplit2 = strTrim2.substring(1, strTrim2.length() - 1).split(",");
                                if (strArrSplit2.length >= 2) {
                                    long j5 = Long.parseLong(strArrSplit2[1].trim());
                                    if (!PackageUtils.u(strTrim) && !PackageUtils.q(strTrim) && j5 > 0) {
                                        map.put(strTrim, Long.valueOf(((Long) C0813a.a(map, strTrim, 0L)).longValue() + j5));
                                    }
                                }
                            }
                        }
                    } catch (Exception unused) {
                    }
                }
            }
        }
        return map;
    }

    private static StatsDataSet[] h(long j5, long j6, String str, W1.c cVar) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] strArrSplit = str.split("\\|");
        if (strArrSplit.length == 0) {
            return null;
        }
        StatsDataSet[] statsDataSetArr = new StatsDataSet[strArrSplit.length];
        int i5 = 0;
        while (i5 < strArrSplit.length) {
            long j7 = j5;
            statsDataSetArr[i5] = i(strArrSplit[i5], i5, j7, j6, cVar);
            i5++;
            j5 = j7;
        }
        return statsDataSetArr;
    }

    private static StatsDataSet i(String str, int i5, long j5, long j6, W1.c cVar) throws Throwable {
        StatsDataSet statsDataSet = new StatsDataSet(com.stepos.digitalwellbeing.server.data.a.HOUR.ordinal(), 0, j6, j5 + (i5 * 3600000), null);
        if (!TextUtils.isEmpty(str) && !TextUtils.equals("null", str.trim())) {
            try {
                String[] strArrSplit = str.split(",");
                int i6 = 3;
                if (strArrSplit.length >= 3) {
                    long j7 = Long.parseLong(strArrSplit[0].trim());
                    int i7 = Integer.parseInt(strArrSplit[1].trim());
                    int i8 = Integer.parseInt(strArrSplit[2].trim());
                    statsDataSet.setUsingTime(j7);
                    statsDataSet.setPickupTimes(c.G(i7, j7, statsDataSet.getStartTime()));
                    statsDataSet.setNotifyTimes(i8);
                    while (true) {
                        int i9 = i6 + 1;
                        if (i9 >= strArrSplit.length) {
                            break;
                        }
                        b(strArrSplit[i6], strArrSplit[i9], statsDataSet, cVar);
                        i6 += 2;
                    }
                }
            } catch (Exception e6) {
                C0702g.p("TodaySimpleStatsFallback", "parseOneHourBucket failed index=" + i5 + " err=" + C0702g.o(e6));
            }
        }
        return statsDataSet;
    }

    private static long j(StatsDataSet[] statsDataSetArr) {
        long usingTime = 0;
        if (statsDataSetArr == null) {
            return 0L;
        }
        for (StatsDataSet statsDataSet : statsDataSetArr) {
            if (statsDataSet != null) {
                usingTime += statsDataSet.getUsingTime();
            }
        }
        return usingTime;
    }

    private static long k(Map<String, Long> map) {
        long jLongValue = 0;
        for (Long l5 : map.values()) {
            if (l5 != null) {
                jLongValue += l5.longValue();
            }
        }
        return jLongValue;
    }
}
