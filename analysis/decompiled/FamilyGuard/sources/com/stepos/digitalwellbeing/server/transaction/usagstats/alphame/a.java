package com.stepos.digitalwellbeing.server.transaction.usagstats.alphame;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.stepos.digitalwellbeing.server.data.Category;
import com.stepos.digitalwellbeing.server.data.StatsDataSet;
import com.stepos.digitalwellbeing.server.transaction.usagstats.alphame.AlphaMeEntities;
import com.stepos.digitalwellbeing.utils.PackageUtils;
import f2.C0697b;
import f2.C0702g;
import f2.C0711p;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import k3.C0813a;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private final Context f14651a;

    /* renamed from: b, reason: collision with root package name */
    private final W1.c f14652b;

    public a(Context context, W1.c cVar) {
        this.f14651a = context.getApplicationContext();
        this.f14652b = cVar;
    }

    private Map<String, Long> a(List<AlphaMeEntities.TimeEvent> list) {
        return b(list, false);
    }

    private Map<String, Long> b(List<AlphaMeEntities.TimeEvent> list, boolean z5) throws Throwable {
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        if (list != null && !list.isEmpty()) {
            for (AlphaMeEntities.TimeEvent timeEvent : list) {
                String packageName = timeEvent.getPackageName();
                long[] jArrE = c.e(timeEvent.getStartTime(), timeEvent.getEndTime());
                if (jArrE != null) {
                    long j5 = jArrE[0];
                    long j6 = jArrE[1];
                    if (!PackageUtils.u(packageName) && (!z5 || !TextUtils.equals(packageName, "com.stepos.familyguard"))) {
                        Category categoryI = this.f14652b.i(packageName);
                        int id = categoryI != null ? categoryI.getId() : 10;
                        if ((categoryI == null || id == 10) && j6 > j5) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("USAGE_DEBUG other_category_period source=last_two_week_time_event reason=");
                            sb.append(categoryI == null ? "null_category" : "category_other");
                            sb.append(" package=");
                            sb.append(packageName);
                            sb.append(" start=");
                            sb.append(C0711p.j(j5));
                            sb.append(" end=");
                            sb.append(C0711p.j(j6));
                            sb.append(" duration=");
                            sb.append(C0711p.t(j6 - j5));
                            C0702g.O("AlphaMeDataParser", sb.toString());
                        }
                        String strB = W1.a.b(id);
                        com.stepos.digitalwellbeing.server.data.k kVar = new com.stepos.digitalwellbeing.server.data.k(j5, j6);
                        if (map2.containsKey(strB)) {
                            List list2 = (List) map2.get(strB);
                            if (list2 != null) {
                                list2.add(kVar);
                            } else {
                                ArrayList arrayList = new ArrayList();
                                arrayList.add(kVar);
                                map2.put(strB, arrayList);
                            }
                        } else {
                            ArrayList arrayList2 = new ArrayList();
                            arrayList2.add(kVar);
                            map2.put(strB, arrayList2);
                        }
                    }
                }
            }
            for (Map.Entry entry : map2.entrySet()) {
                String str = (String) entry.getKey();
                List list3 = (List) entry.getValue();
                long jB = 0;
                if (list3 == null || list3.isEmpty()) {
                    map.put(str, 0L);
                } else {
                    Iterator<com.stepos.digitalwellbeing.server.data.k> it = com.stepos.digitalwellbeing.server.data.k.d(list3).iterator();
                    while (it.hasNext()) {
                        jB += it.next().b();
                    }
                    map.put(str, Long.valueOf(jB));
                }
            }
        }
        return map;
    }

    private Map<String, Long> c(Map<String, Long> map) throws Throwable {
        HashMap map2 = new HashMap();
        if (map != null && !map.isEmpty()) {
            for (Map.Entry<String, Long> entry : map.entrySet()) {
                String key = entry.getKey();
                long jLongValue = entry.getValue().longValue();
                if (!PackageUtils.u(key)) {
                    Category categoryI = this.f14652b.i(key);
                    int id = categoryI != null ? categoryI.getId() : 10;
                    if ((categoryI == null || id == 10) && jLongValue > 0) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("USAGE_DEBUG other_category_package source=last_two_week_package reason=");
                        sb.append(categoryI == null ? "null_category" : "category_other");
                        sb.append(" package=");
                        sb.append(key);
                        sb.append(" usage=");
                        sb.append(C0711p.t(jLongValue));
                        C0702g.O("AlphaMeDataParser", sb.toString());
                    }
                    String strB = W1.a.b(id);
                    map2.put(strB, Long.valueOf(((Long) C0813a.a(map2, strB, 0L)).longValue() + jLongValue));
                }
            }
        }
        return map2;
    }

    private StatsDataSet d(AlphaMeEntities.HourlyUsageSummary hourlyUsageSummary, long j5, long j6, int i5) {
        long j7 = j5 + (i5 * 3600000);
        StatsDataSet statsDataSet = new StatsDataSet(com.stepos.digitalwellbeing.server.data.a.HOUR.ordinal(), 0, j6, j7, null);
        statsDataSet.setUsingTime(hourlyUsageSummary.getHourlyUsageTime());
        statsDataSet.setNotifyTimes(hourlyUsageSummary.getNotificationNumber());
        statsDataSet.setPickupTimes(c.G(hourlyUsageSummary.getScreenOnTimes(), hourlyUsageSummary.getHourlyUsageTime(), j7));
        List<AlphaMeEntities.AppUsage> appUsages = hourlyUsageSummary.getAppUsages();
        if (appUsages != null && !appUsages.isEmpty()) {
            j(appUsages, statsDataSet);
        }
        return statsDataSet;
    }

    private StatsDataSet[] e(List<AlphaMeEntities.HourlyUsageSummary> list, long j5, long j6) {
        StatsDataSet[] statsDataSetArrCreateEmptyStatsDataSetArray = StatsDataSet.createEmptyStatsDataSetArray(j5, j6, com.stepos.digitalwellbeing.server.data.a.DAY.ordinal());
        if (list != null && !list.isEmpty()) {
            int size = list.size();
            if (size != 24) {
                Log.w("AlphaMeDataParser", "hourlyList size error: expected=24, actual=" + size + " date=" + C0711p.j(j5) + ", keep parsed hours");
            }
            int iMin = Math.min(size, 24);
            int i5 = 0;
            while (i5 < iMin) {
                AlphaMeEntities.HourlyUsageSummary hourlyUsageSummary = list.get(i5);
                a aVar = this;
                long j7 = j5;
                long j8 = j6;
                if (hourlyUsageSummary != null) {
                    statsDataSetArrCreateEmptyStatsDataSetArray[i5] = aVar.d(hourlyUsageSummary, j7, j8, i5);
                }
                i5++;
                this = aVar;
                j5 = j7;
                j6 = j8;
            }
        }
        return statsDataSetArrCreateEmptyStatsDataSetArray;
    }

    private StatsDataSet f(long j5, long j6, StatsDataSet[] statsDataSetArr) {
        return new StatsDataSet(com.stepos.digitalwellbeing.server.data.a.WEEK.ordinal(), 7, j5, j6, statsDataSetArr);
    }

    private static int g(long j5, long j6) {
        long j7 = (j6 - j5) / 86400000;
        if (j7 >= 0 && j7 < 7) {
            return (int) j7;
        }
        C0702g.O("AlphaMeDataParser", "Day out of week range weekStart=" + C0711p.j(j5) + " day=" + C0711p.j(j6));
        return -1;
    }

    private static void h(String str, StatsDataSet statsDataSet) {
        if (statsDataSet == null) {
            C0702g.O("AlphaMeDataParser", "USAGE_DEBUG week_summary " + str + " week=null");
            return;
        }
        StatsDataSet[] children = statsDataSet.getChildren();
        StringBuilder sb = new StringBuilder();
        if (children != null) {
            for (int i5 = 0; i5 < children.length; i5++) {
                StatsDataSet statsDataSet2 = children[i5];
                long usingTime = statsDataSet2 == null ? 0L : statsDataSet2.getUsingTime();
                if (usingTime > 0) {
                    if (sb.length() > 0) {
                        sb.append(',');
                    }
                    sb.append(i5);
                    sb.append('=');
                    sb.append(C0711p.t(usingTime));
                }
            }
        }
        C0702g.O("AlphaMeDataParser", "USAGE_DEBUG week_summary " + str + " start=" + C0711p.j(statsDataSet.getStartTime()) + " total=" + C0711p.t(statsDataSet.getUsingTime()) + " days={" + ((Object) sb) + "}");
    }

    private void j(List<AlphaMeEntities.AppUsage> list, StatsDataSet statsDataSet) {
        if (list.isEmpty()) {
            return;
        }
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        long jMax = 0;
        for (AlphaMeEntities.AppUsage appUsage : list) {
            String packageName = appUsage.getPackageName();
            long usedTime = appUsage.getUsedTime();
            int notificationNumber = appUsage.getNotificationNumber();
            if (PackageUtils.u(packageName) || ((TextUtils.equals(packageName, "com.stepos.familyguard") && PackageUtils.r(usedTime, statsDataSet.getUsingTime())) || (C0697b.n() && TextUtils.equals(packageName, "com.android.settings") && usedTime >= 2700000))) {
                jMax += Math.max(0L, usedTime);
            } else {
                map.put(packageName, Long.valueOf(((Long) C0813a.a(map, packageName, 0L)).longValue() + usedTime));
                map2.put(packageName, Integer.valueOf(((Integer) C0813a.a(map2, packageName, 0)).intValue() + notificationNumber));
            }
        }
        statsDataSet.setPackageUsingTimeMap(new HashMap(map));
        statsDataSet.setPackageNotifyTimesMap(new HashMap(map2));
        statsDataSet.setCategoryUsingTimeMap(c(map));
        if (jMax > 0) {
            statsDataSet.setUsingTime(Math.max(0L, statsDataSet.getUsingTime() - jMax));
        }
        long usingTime = statsDataSet.getUsingTime();
        if (statsDataSet.liftUsingTimeToAtLeastPackageSum()) {
            Log.w("AlphaMeDataParser", "lift hourly usingTime from " + C0711p.t(usingTime) + " to packageSum " + C0711p.t(statsDataSet.getUsingTime()));
        }
    }

    private static void k(long j5, long j6, int i5, StatsDataSet statsDataSet, StatsDataSet[] statsDataSetArr, StatsDataSet[] statsDataSetArr2) {
        if (i5 < 0 || i5 >= 7 || statsDataSet == null) {
            return;
        }
        if (j5 < j6) {
            statsDataSetArr[i5] = statsDataSet;
        } else {
            statsDataSetArr2[i5] = statsDataSet;
        }
    }

    private void l(StatsDataSet statsDataSet) {
        StatsDataSet[] children = statsDataSet.getChildren();
        statsDataSet.setUsingTime(0L);
        statsDataSet.setPickupTimes(0);
        statsDataSet.setNotifyTimes(0);
        statsDataSet.setPackageUsingTimeMap(new HashMap());
        statsDataSet.setPackageNotifyTimesMap(new HashMap());
        statsDataSet.setCategoryUsingTimeMap(new HashMap());
        if (children != null) {
            statsDataSet.addChildren(children);
        }
    }

    private void m(StatsDataSet statsDataSet, List<AlphaMeEntities.AppDailyUsage> list, boolean z5) {
        if (list == null || list.isEmpty()) {
            return;
        }
        Map<String, Long> packageUsingTimeMap = statsDataSet.getPackageUsingTimeMap();
        Map<String, Integer> packageNotifyTimesMap = statsDataSet.getPackageNotifyTimesMap();
        HashMap map = packageUsingTimeMap == null ? new HashMap() : new HashMap(packageUsingTimeMap);
        HashMap map2 = packageNotifyTimesMap == null ? new HashMap() : new HashMap(packageNotifyTimesMap);
        for (AlphaMeEntities.AppDailyUsage appDailyUsage : list) {
            if (appDailyUsage != null) {
                String packageName = appDailyUsage.getPackageName();
                long jMax = Math.max(0L, appDailyUsage.getUsedTime());
                if (!PackageUtils.u(packageName) && (!z5 || !TextUtils.equals(packageName, "com.stepos.familyguard"))) {
                    if (TextUtils.equals(packageName, "com.android.settings")) {
                        if (!C0697b.n() || jMax < 2700000) {
                            if (PackageUtils.t(jMax, statsDataSet.getLongestUseTime(), statsDataSet.getStartTime())) {
                            }
                        }
                    }
                    if (C0697b.r()) {
                        long jE = C0697b.e();
                        if (jE >= 0 && jE != Long.MAX_VALUE && jMax > jE) {
                            jMax = jE;
                        }
                        if (jMax > 0) {
                            map.put(packageName, Long.valueOf(Math.max(((Long) C0813a.a(map, packageName, 0L)).longValue(), jMax)));
                            map2.put(packageName, Integer.valueOf(Math.max(((Integer) C0813a.a(map2, packageName, 0)).intValue(), appDailyUsage.getNotificationNumber())));
                        }
                    } else if (((Long) C0813a.a(map, packageName, 0L)).longValue() <= 0) {
                        C0702g.O("AlphaMeDataParser", "skip stale AppDailyUsage package=" + packageName + " dailyUsed=" + C0711p.t(jMax));
                    } else {
                        map.put(packageName, Long.valueOf(Math.max(((Long) C0813a.a(map, packageName, 0L)).longValue(), jMax)));
                        map2.put(packageName, Integer.valueOf(Math.max(((Integer) C0813a.a(map2, packageName, 0)).intValue(), appDailyUsage.getNotificationNumber())));
                    }
                }
            }
        }
        statsDataSet.setPackageUsingTimeMap(map);
        statsDataSet.setPackageNotifyTimesMap(map2);
        statsDataSet.setCategoryUsingTimeMap(c(map));
        e.j(statsDataSet, this.f14652b);
        long usingTime = statsDataSet.getUsingTime();
        if (statsDataSet.liftUsingTimeToAtLeastPackageSum()) {
            Log.w("AlphaMeDataParser", "lift today usingTime from " + C0711p.t(usingTime) + " to packageSum " + C0711p.t(statsDataSet.getUsingTime()));
        }
    }

    private boolean n(StatsDataSet statsDataSet, long j5, long j6) {
        Map<String, Long> packageUsingTimeMap = statsDataSet.getPackageUsingTimeMap();
        if (packageUsingTimeMap == null || packageUsingTimeMap.isEmpty()) {
            return false;
        }
        long jLongValue = ((Long) C0813a.a(packageUsingTimeMap, "com.stepos.familyguard", 0L)).longValue();
        if (!PackageUtils.s(jLongValue, j6, j5)) {
            return false;
        }
        C0702g.O("AlphaMeDataParser", "sanitize phantom self package usage self=" + C0711p.t(jLongValue) + " longest=" + C0711p.t(j6));
        StatsDataSet[] children = statsDataSet.getChildren();
        if (children != null) {
            for (StatsDataSet statsDataSet2 : children) {
                o(statsDataSet2, "com.stepos.familyguard");
            }
        }
        l(statsDataSet);
        statsDataSet.setLongestUseTime(j6);
        return true;
    }

    private void o(StatsDataSet statsDataSet, String str) {
        Map<String, Long> packageUsingTimeMap;
        if (statsDataSet == null || (packageUsingTimeMap = statsDataSet.getPackageUsingTimeMap()) == null || !packageUsingTimeMap.containsKey(str)) {
            return;
        }
        long jMax = Math.max(0L, ((Long) C0813a.a(packageUsingTimeMap, str, 0L)).longValue());
        packageUsingTimeMap.remove(str);
        Map<String, Integer> packageNotifyTimesMap = statsDataSet.getPackageNotifyTimesMap();
        if (packageNotifyTimesMap != null) {
            packageNotifyTimesMap.remove(str);
        }
        if (jMax > 0) {
            statsDataSet.setUsingTime(Math.max(0L, statsDataSet.getUsingTime() - jMax));
        }
        statsDataSet.setCategoryUsingTimeMap(c(packageUsingTimeMap));
    }

    public StatsDataSet[] i(AlphaMeEntities.Result result) throws Throwable {
        StatsDataSet[] statsDataSetArr;
        long j5;
        a aVar;
        String str;
        long j6;
        a aVar2;
        long j7;
        long j8;
        StatsDataSet statsDataSet;
        com.stepos.digitalwellbeing.server.data.a aVar3;
        StatsDataSet statsDataSet2;
        boolean zM;
        long j9;
        int i5;
        StatsDataSet statsDataSet3;
        int i6;
        boolean zN;
        boolean z5;
        int iG;
        StatsDataSet statsDataSetO;
        Map<String, Long> mapC;
        long jCurrentTimeMillis = System.currentTimeMillis();
        long jG = C0711p.g((result != null && result.getRequestTime() > 0) ? result.getRequestTime() : jCurrentTimeMillis);
        long j10 = 604800000;
        long j11 = jG - 604800000;
        com.stepos.digitalwellbeing.server.data.a aVar4 = com.stepos.digitalwellbeing.server.data.a.WEEK;
        StatsDataSet[] statsDataSetArrCreateEmptyStatsDataSetArray = StatsDataSet.createEmptyStatsDataSetArray(jG, jCurrentTimeMillis, aVar4.ordinal());
        StatsDataSet[] statsDataSetArrCreateEmptyStatsDataSetArray2 = StatsDataSet.createEmptyStatsDataSetArray(j11, jCurrentTimeMillis, aVar4.ordinal());
        String str2 = "AlphaMeDataParser";
        if (result == null) {
            C0702g.p("AlphaMeDataParser", "parse: input is null");
            e.I(this.f14651a, this.f14652b, statsDataSetArrCreateEmptyStatsDataSetArray, jG);
            return new StatsDataSet[]{f(jCurrentTimeMillis, j11, statsDataSetArrCreateEmptyStatsDataSetArray2), f(jCurrentTimeMillis, jG, statsDataSetArrCreateEmptyStatsDataSetArray)};
        }
        StatsDataSet[] statsDataSetArr2 = statsDataSetArrCreateEmptyStatsDataSetArray2;
        long j12 = j11;
        List<AlphaMeEntities.DailyUsageSummary> dailyUsageSummaries = result.getDailyUsageSummaries();
        if (dailyUsageSummaries == null || dailyUsageSummaries.isEmpty()) {
            C0702g.p("AlphaMeDataParser", "parse: dailySummaries is empty or null");
            e.I(this.f14651a, this.f14652b, statsDataSetArrCreateEmptyStatsDataSetArray, jG);
            return new StatsDataSet[]{f(jCurrentTimeMillis, j12, statsDataSetArr2), f(jCurrentTimeMillis, jG, statsDataSetArrCreateEmptyStatsDataSetArray)};
        }
        try {
            for (AlphaMeEntities.DailyUsageSummary dailyUsageSummary : dailyUsageSummaries) {
                try {
                    long date = dailyUsageSummary.getDate();
                    if (date < j12 || date >= jG + j10) {
                        j7 = jCurrentTimeMillis;
                        str = str2;
                        j8 = j12;
                        statsDataSetArr = statsDataSetArr2;
                        Log.w(str, "Date out of range: " + C0711p.j(date));
                        statsDataSetArr2 = statsDataSetArr;
                        str2 = str;
                        jCurrentTimeMillis = j7;
                        j10 = 604800000;
                        j12 = j8;
                    } else if (!C0697b.n() || date <= C0711p.y()) {
                        try {
                            C0702g.b(str2, "parse date = " + C0711p.j(date));
                            long j13 = jCurrentTimeMillis;
                            try {
                                aVar2 = this;
                                try {
                                    try {
                                        try {
                                            StatsDataSet statsDataSet4 = new StatsDataSet(com.stepos.digitalwellbeing.server.data.a.DAY.ordinal(), 24, j13, date, aVar2.e(dailyUsageSummary.getHourlyUsageSummaries(), date, j13));
                                            j7 = j13;
                                            date = date;
                                            try {
                                                long dailyUsedTime = dailyUsageSummary.getDailyUsedTime();
                                                int notificationNumbers = dailyUsageSummary.getNotificationNumbers();
                                                int screenOnTimes = dailyUsageSummary.getScreenOnTimes();
                                                long maximumUsageTime = dailyUsageSummary.getMaximumUsageTime();
                                                try {
                                                    zM = C0697b.m(dailyUsedTime, statsDataSet4.getUsingTime(), date);
                                                    if (zM) {
                                                        C0702g.O(str2, "ignore inflated AlphaMe daily summary, use hourly aggregate=" + C0711p.t(statsDataSet4.getUsingTime()) + " date=" + C0711p.j(date));
                                                        maximumUsageTime = statsDataSet4.getLongestUseTime();
                                                    }
                                                    statsDataSet4.setLongestUseTime(maximumUsageTime);
                                                    boolean z6 = C0697b.r() && date == C0711p.y();
                                                    if (date == C0711p.y() || zM) {
                                                        long j14 = maximumUsageTime;
                                                        j9 = date;
                                                        i5 = screenOnTimes;
                                                        statsDataSet3 = statsDataSet4;
                                                        i6 = notificationNumbers;
                                                        aVar2 = this;
                                                        zN = aVar2.n(statsDataSet3, j9, j14);
                                                        if (!zN && !z6 && (zM || dailyUsedTime > statsDataSet3.getUsingTime() + 3600000)) {
                                                            C0702g.O(str2, "hourly phantom usage removed, use sanitized package categories");
                                                            zN = true;
                                                        }
                                                    } else {
                                                        j9 = date;
                                                        zN = false;
                                                        i5 = screenOnTimes;
                                                        statsDataSet3 = statsDataSet4;
                                                        i6 = notificationNumbers;
                                                        aVar2 = this;
                                                    }
                                                    if (j9 == C0711p.y() && (!zM || z6)) {
                                                        try {
                                                            aVar2.m(statsDataSet3, dailyUsageSummary.getAppDailyUsages(), zN && !z6);
                                                        } catch (Exception e6) {
                                                            e = e6;
                                                            date = j9;
                                                            str = str2;
                                                            j8 = j12;
                                                            statsDataSetArr = statsDataSetArr2;
                                                            try {
                                                                C0702g.p(str, "skip day after parse error date=" + C0711p.j(date) + " " + Log.getStackTraceString(e));
                                                                statsDataSetArr2 = statsDataSetArr;
                                                                str2 = str;
                                                                jCurrentTimeMillis = j7;
                                                                j10 = 604800000;
                                                                j12 = j8;
                                                            } catch (Exception e7) {
                                                                e = e7;
                                                                aVar = aVar2;
                                                                j5 = j8;
                                                                j6 = jG;
                                                                jCurrentTimeMillis = j7;
                                                                C0702g.p(str, "parse aborted, keep partial weeks " + Log.getStackTraceString(e));
                                                                e.I(aVar.f14651a, aVar.f14652b, statsDataSetArrCreateEmptyStatsDataSetArray, j6);
                                                                a aVar5 = aVar;
                                                                StatsDataSet statsDataSetF = aVar5.f(jCurrentTimeMillis, j5, statsDataSetArr);
                                                                StatsDataSet statsDataSetF2 = aVar5.f(jCurrentTimeMillis, j6, statsDataSetArrCreateEmptyStatsDataSetArray);
                                                                h("lastWeek-partial", statsDataSetF);
                                                                h("thisWeek-partial", statsDataSetF2);
                                                                return new StatsDataSet[]{statsDataSetF, statsDataSetF2};
                                                            }
                                                        }
                                                    }
                                                    if (j9 == C0711p.y() || zM) {
                                                        e.R(statsDataSet3, aVar2.f14652b);
                                                    }
                                                    if (dailyUsedTime != statsDataSet3.getUsingTime()) {
                                                        StringBuilder sb = new StringBuilder();
                                                        sb.append("date = ");
                                                        z5 = zN;
                                                        sb.append(C0711p.j(j9));
                                                        sb.append(" totalUsedTime data error: expected=");
                                                        sb.append(C0711p.t(dailyUsedTime));
                                                        sb.append(", actual=");
                                                        sb.append(C0711p.t(statsDataSet3.getUsingTime()));
                                                        Log.w(str2, sb.toString());
                                                    } else {
                                                        z5 = zN;
                                                    }
                                                    if (i6 != statsDataSet3.getNotifyTimes()) {
                                                        Log.w(str2, "date = " + C0711p.j(j9) + " totalNotifyTimes data error: expected=" + i6 + ", actual=" + statsDataSet3.getNotifyTimes());
                                                    }
                                                    if (i5 != statsDataSet3.getPickupTimes()) {
                                                        Log.w(str2, "date = " + C0711p.j(j9) + " totalPickUpTimes data error: expected=" + i5 + ", actual=" + statsDataSet3.getPickupTimes());
                                                    }
                                                    if (j9 == C0711p.y()) {
                                                        c.D(statsDataSet3, i5);
                                                    }
                                                    if (C0697b.n() && j9 == C0711p.y() && i6 > statsDataSet3.getNotifyTimes()) {
                                                        statsDataSet3.setNotifyTimes(i6);
                                                    }
                                                    C0702g.b(str2, "daySet #" + statsDataSet3.hashCode() + " = " + statsDataSet3);
                                                    C0702g.F(str2, 2);
                                                    iG = j9 < jG ? g(j12, j9) : g(jG, j9);
                                                } catch (Exception e8) {
                                                    e = e8;
                                                    aVar2 = this;
                                                    str = str2;
                                                    j8 = j12;
                                                    statsDataSetArr = statsDataSetArr2;
                                                    date = date;
                                                }
                                            } catch (Exception e9) {
                                                e = e9;
                                                aVar2 = this;
                                            }
                                        } catch (Exception e10) {
                                            e = e10;
                                            aVar2 = this;
                                            j7 = j13;
                                            date = date;
                                            str = str2;
                                            j8 = j12;
                                            statsDataSetArr = statsDataSetArr2;
                                            C0702g.p(str, "skip day after parse error date=" + C0711p.j(date) + " " + Log.getStackTraceString(e));
                                            statsDataSetArr2 = statsDataSetArr;
                                            str2 = str;
                                            jCurrentTimeMillis = j7;
                                            j10 = 604800000;
                                            j12 = j8;
                                        }
                                    } catch (Exception e11) {
                                        e = e11;
                                        aVar2 = this;
                                        j7 = j13;
                                    }
                                } catch (Exception e12) {
                                    e = e12;
                                    j7 = j13;
                                    str = str2;
                                    date = date;
                                    j8 = j12;
                                    statsDataSetArr = statsDataSetArr2;
                                    C0702g.p(str, "skip day after parse error date=" + C0711p.j(date) + " " + Log.getStackTraceString(e));
                                    statsDataSetArr2 = statsDataSetArr;
                                    str2 = str;
                                    jCurrentTimeMillis = j7;
                                    j10 = 604800000;
                                    j12 = j8;
                                }
                            } catch (Exception e13) {
                                e = e13;
                                aVar2 = this;
                                j7 = j13;
                            }
                        } catch (Exception e14) {
                            e = e14;
                            aVar2 = this;
                            j7 = jCurrentTimeMillis;
                        }
                        if (iG < 0) {
                            C0702g.O(str2, "skip day out of week slots date=" + C0711p.j(j9));
                            jCurrentTimeMillis = j7;
                            j10 = 604800000;
                        } else {
                            date = j9;
                            str = str2;
                            j8 = j12;
                            statsDataSetArr = statsDataSetArr2;
                            int i7 = iG;
                            StatsDataSet statsDataSet5 = statsDataSet3;
                            try {
                                k(date, jG, i7, statsDataSet5, statsDataSetArr, statsDataSetArrCreateEmptyStatsDataSetArray);
                                List<AlphaMeEntities.TimeEvent> timeEvents = result.getTimeEvents();
                                if (date == C0711p.y() && timeEvents != null && !timeEvents.isEmpty()) {
                                    if (C0697b.y() || zM || z5) {
                                        mapC = aVar2.c(statsDataSet5.getPackageUsingTimeMap());
                                        C0702g.O(str, "use package category map after clock jump");
                                    } else {
                                        mapC = aVar2.a(timeEvents);
                                    }
                                    C0702g.b(str, "parse today categoryMap = " + mapC);
                                    statsDataSet5.setCategoryUsingTimeMap(mapC);
                                } else if (zM || z5) {
                                    statsDataSet5.setCategoryUsingTimeMap(aVar2.c(statsDataSet5.getPackageUsingTimeMap()));
                                } else if (timeEvents == null) {
                                    Log.w(str, "timeEvents is empty or null");
                                    statsDataSet5.setCategoryUsingTimeMap(aVar2.c(statsDataSet5.getPackageUsingTimeMap()));
                                }
                                if (date == C0711p.y()) {
                                    try {
                                        statsDataSetO = e.P(aVar2.f14651a, aVar2.f14652b, statsDataSet5, date, zM);
                                        date = date;
                                        e.R(statsDataSetO, aVar2.f14652b);
                                        k(date, jG, i7, statsDataSetO, statsDataSetArr, statsDataSetArrCreateEmptyStatsDataSetArray);
                                    } catch (Exception e15) {
                                        e = e15;
                                        date = date;
                                        C0702g.p(str, "skip day after parse error date=" + C0711p.j(date) + " " + Log.getStackTraceString(e));
                                        statsDataSetArr2 = statsDataSetArr;
                                        str2 = str;
                                        jCurrentTimeMillis = j7;
                                        j10 = 604800000;
                                        j12 = j8;
                                    }
                                } else if (C0697b.n() && date == C0711p.y() - 86400000) {
                                    statsDataSetO = e.O(aVar2.f14651a, aVar2.f14652b, statsDataSet5, date);
                                    k(date, jG, i7, statsDataSetO, statsDataSetArr, statsDataSetArrCreateEmptyStatsDataSetArray);
                                } else {
                                    statsDataSetO = statsDataSet5;
                                }
                                c.i(statsDataSetO);
                                j.j(aVar2.f14651a, aVar2.f14652b, statsDataSetO);
                                c.i(statsDataSetO);
                                c.j(statsDataSetO);
                                if (date == C0711p.y() && c.q() && timeEvents != null) {
                                    statsDataSetO.setPackageUsingTimeMap(c.C(timeEvents));
                                }
                                e.L(statsDataSetO);
                                c.h(statsDataSetO);
                                k(date, jG, i7, statsDataSetO, statsDataSetArr, statsDataSetArrCreateEmptyStatsDataSetArray);
                            } catch (Exception e16) {
                                e = e16;
                            }
                            statsDataSetArr2 = statsDataSetArr;
                            str2 = str;
                            jCurrentTimeMillis = j7;
                            j10 = 604800000;
                            j12 = j8;
                        }
                    } else {
                        C0702g.O(str2, "skip future day after clock jump date=" + C0711p.j(date) + " todayStart=" + C0711p.j(C0711p.y()));
                    }
                } catch (Exception e17) {
                    e = e17;
                    str = str2;
                    long j15 = j12;
                    statsDataSetArr = statsDataSetArr2;
                    aVar = this;
                    j5 = j15;
                    j6 = jG;
                    C0702g.p(str, "parse aborted, keep partial weeks " + Log.getStackTraceString(e));
                    e.I(aVar.f14651a, aVar.f14652b, statsDataSetArrCreateEmptyStatsDataSetArray, j6);
                    a aVar52 = aVar;
                    StatsDataSet statsDataSetF3 = aVar52.f(jCurrentTimeMillis, j5, statsDataSetArr);
                    StatsDataSet statsDataSetF22 = aVar52.f(jCurrentTimeMillis, j6, statsDataSetArrCreateEmptyStatsDataSetArray);
                    h("lastWeek-partial", statsDataSetF3);
                    h("thisWeek-partial", statsDataSetF22);
                    return new StatsDataSet[]{statsDataSetF3, statsDataSetF22};
                }
            }
            aVar2 = this;
            j7 = jCurrentTimeMillis;
            str = str2;
            j8 = j12;
            statsDataSetArr = statsDataSetArr2;
            e.I(aVar2.f14651a, aVar2.f14652b, statsDataSetArrCreateEmptyStatsDataSetArray, jG);
            aVar3 = com.stepos.digitalwellbeing.server.data.a.WEEK;
        } catch (Exception e18) {
            e = e18;
            statsDataSetArr = statsDataSetArr2;
            j5 = j12;
            aVar = this;
            str = str2;
        }
        try {
            aVar = this;
            try {
                statsDataSet = new StatsDataSet(aVar3.ordinal(), 7, j7, j8, statsDataSetArr);
                jCurrentTimeMillis = j7;
                j5 = j8;
                try {
                    try {
                        statsDataSet2 = new StatsDataSet(aVar3.ordinal(), 7, jCurrentTimeMillis, jG, statsDataSetArrCreateEmptyStatsDataSetArray);
                        jCurrentTimeMillis = jCurrentTimeMillis;
                        j6 = jG;
                    } catch (Exception e19) {
                        e = e19;
                        jCurrentTimeMillis = jCurrentTimeMillis;
                        j6 = jG;
                        statsDataSetArrCreateEmptyStatsDataSetArray = statsDataSetArrCreateEmptyStatsDataSetArray;
                    }
                } catch (Exception e20) {
                    e = e20;
                    j6 = jG;
                    C0702g.p(str, "parse aborted, keep partial weeks " + Log.getStackTraceString(e));
                    e.I(aVar.f14651a, aVar.f14652b, statsDataSetArrCreateEmptyStatsDataSetArray, j6);
                    a aVar522 = aVar;
                    StatsDataSet statsDataSetF32 = aVar522.f(jCurrentTimeMillis, j5, statsDataSetArr);
                    StatsDataSet statsDataSetF222 = aVar522.f(jCurrentTimeMillis, j6, statsDataSetArrCreateEmptyStatsDataSetArray);
                    h("lastWeek-partial", statsDataSetF32);
                    h("thisWeek-partial", statsDataSetF222);
                    return new StatsDataSet[]{statsDataSetF32, statsDataSetF222};
                }
            } catch (Exception e21) {
                e = e21;
                jCurrentTimeMillis = j7;
                j5 = j8;
                statsDataSetArr = statsDataSetArr;
            }
        } catch (Exception e22) {
            e = e22;
            aVar = this;
            j5 = j8;
            j6 = jG;
            jCurrentTimeMillis = j7;
            C0702g.p(str, "parse aborted, keep partial weeks " + Log.getStackTraceString(e));
            e.I(aVar.f14651a, aVar.f14652b, statsDataSetArrCreateEmptyStatsDataSetArray, j6);
            a aVar5222 = aVar;
            StatsDataSet statsDataSetF322 = aVar5222.f(jCurrentTimeMillis, j5, statsDataSetArr);
            StatsDataSet statsDataSetF2222 = aVar5222.f(jCurrentTimeMillis, j6, statsDataSetArrCreateEmptyStatsDataSetArray);
            h("lastWeek-partial", statsDataSetF322);
            h("thisWeek-partial", statsDataSetF2222);
            return new StatsDataSet[]{statsDataSetF322, statsDataSetF2222};
        }
        try {
            h("lastWeek", statsDataSet);
            h("thisWeek", statsDataSet2);
            return new StatsDataSet[]{statsDataSet, statsDataSet2};
        } catch (Exception e23) {
            e = e23;
            C0702g.p(str, "parse aborted, keep partial weeks " + Log.getStackTraceString(e));
            e.I(aVar.f14651a, aVar.f14652b, statsDataSetArrCreateEmptyStatsDataSetArray, j6);
            a aVar52222 = aVar;
            StatsDataSet statsDataSetF3222 = aVar52222.f(jCurrentTimeMillis, j5, statsDataSetArr);
            StatsDataSet statsDataSetF22222 = aVar52222.f(jCurrentTimeMillis, j6, statsDataSetArrCreateEmptyStatsDataSetArray);
            h("lastWeek-partial", statsDataSetF3222);
            h("thisWeek-partial", statsDataSetF22222);
            return new StatsDataSet[]{statsDataSetF3222, statsDataSetF22222};
        }
    }
}
