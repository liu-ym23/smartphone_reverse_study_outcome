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
public class m {

    /* renamed from: a, reason: collision with root package name */
    private final Context f14690a;

    /* renamed from: b, reason: collision with root package name */
    private final W1.c f14691b;

    public m(Context context, W1.c cVar) {
        this.f14690a = context.getApplicationContext();
        this.f14691b = cVar;
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
                        Category categoryI = this.f14691b.i(packageName);
                        int id = categoryI != null ? categoryI.getId() : 10;
                        if ((categoryI == null || id == 10) && j6 > j5) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("USAGE_DEBUG other_category_period source=today_time_event reason=");
                            sb.append(categoryI == null ? "null_category" : "category_other");
                            sb.append(" package=");
                            sb.append(packageName);
                            sb.append(" start=");
                            sb.append(C0711p.j(j5));
                            sb.append(" end=");
                            sb.append(C0711p.j(j6));
                            sb.append(" duration=");
                            sb.append(C0711p.t(j6 - j5));
                            C0702g.O("TodayAlphaMeDataParser", sb.toString());
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
                    Category categoryI = this.f14691b.i(key);
                    int id = categoryI != null ? categoryI.getId() : 10;
                    if ((categoryI == null || id == 10) && jLongValue > 0) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("USAGE_DEBUG other_category_package source=today_package reason=");
                        sb.append(categoryI == null ? "null_category" : "category_other");
                        sb.append(" package=");
                        sb.append(key);
                        sb.append(" usage=");
                        sb.append(C0711p.t(jLongValue));
                        C0702g.O("TodayAlphaMeDataParser", sb.toString());
                    }
                    String strB = W1.a.b(id);
                    map2.put(strB, Long.valueOf(((Long) C0813a.a(map2, strB, 0L)).longValue() + jLongValue));
                }
            }
        }
        return map2;
    }

    private StatsDataSet d() {
        return StatsDataSet.createEmptyStatsDataSet(C0711p.y(), System.currentTimeMillis(), com.stepos.digitalwellbeing.server.data.a.DAY.ordinal());
    }

    private StatsDataSet e(AlphaMeEntities.HourlyUsageSummary hourlyUsageSummary, long j5, long j6, int i5) {
        long j7 = j5 + (i5 * 3600000);
        StatsDataSet statsDataSet = new StatsDataSet(com.stepos.digitalwellbeing.server.data.a.HOUR.ordinal(), 0, j6, j7, null);
        statsDataSet.setUsingTime(hourlyUsageSummary.getHourlyUsageTime());
        statsDataSet.setNotifyTimes(hourlyUsageSummary.getNotificationNumber());
        statsDataSet.setPickupTimes(c.G(hourlyUsageSummary.getScreenOnTimes(), hourlyUsageSummary.getHourlyUsageTime(), j7));
        List<AlphaMeEntities.AppUsage> appUsages = hourlyUsageSummary.getAppUsages();
        if (appUsages != null && !appUsages.isEmpty()) {
            g(appUsages, statsDataSet);
        }
        return statsDataSet;
    }

    private void g(List<AlphaMeEntities.AppUsage> list, StatsDataSet statsDataSet) {
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
            Log.w("TodayAlphaMeDataParser", "lift hourly usingTime from " + C0711p.t(usingTime) + " to packageSum " + C0711p.t(statsDataSet.getUsingTime()));
        }
    }

    private void h(StatsDataSet statsDataSet) {
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

    private void i(StatsDataSet statsDataSet, List<AlphaMeEntities.AppDailyUsage> list, boolean z5) {
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
                        C0702g.O("TodayAlphaMeDataParser", "skip stale AppDailyUsage package=" + packageName + " dailyUsed=" + C0711p.t(jMax));
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
        e.j(statsDataSet, this.f14691b);
        long usingTime = statsDataSet.getUsingTime();
        if (statsDataSet.liftUsingTimeToAtLeastPackageSum()) {
            Log.w("TodayAlphaMeDataParser", "lift today usingTime from " + C0711p.t(usingTime) + " to packageSum " + C0711p.t(statsDataSet.getUsingTime()));
        }
    }

    private boolean j(StatsDataSet statsDataSet, long j5, long j6) {
        Map<String, Long> packageUsingTimeMap = statsDataSet.getPackageUsingTimeMap();
        if (packageUsingTimeMap == null || packageUsingTimeMap.isEmpty()) {
            return false;
        }
        long jLongValue = ((Long) C0813a.a(packageUsingTimeMap, "com.stepos.familyguard", 0L)).longValue();
        if (!PackageUtils.s(jLongValue, j6, j5)) {
            return false;
        }
        C0702g.O("TodayAlphaMeDataParser", "sanitize phantom self package usage self=" + C0711p.t(jLongValue) + " longest=" + C0711p.t(j6));
        StatsDataSet[] children = statsDataSet.getChildren();
        if (children != null) {
            for (StatsDataSet statsDataSet2 : children) {
                k(statsDataSet2, "com.stepos.familyguard");
            }
        }
        h(statsDataSet);
        statsDataSet.setLongestUseTime(j6);
        return true;
    }

    private void k(StatsDataSet statsDataSet, String str) {
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

    /* JADX WARN: Removed duplicated region for block: B:27:0x0116  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.stepos.digitalwellbeing.server.data.StatsDataSet f(com.stepos.digitalwellbeing.server.transaction.usagstats.alphame.AlphaMeEntities.Result r24) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 957
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.digitalwellbeing.server.transaction.usagstats.alphame.m.f(com.stepos.digitalwellbeing.server.transaction.usagstats.alphame.AlphaMeEntities$Result):com.stepos.digitalwellbeing.server.data.StatsDataSet");
    }
}
