package com.stepos.digitalwellbeing.server.transaction.usagstats.alphame;

import android.app.usage.UsageEvents;
import android.app.usage.UsageStatsManager;
import android.content.Context;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.stepos.digitalwellbeing.server.data.StatsDataSet;
import com.stepos.digitalwellbeing.utils.PackageUtils;
import f2.C0702g;
import f2.C0711p;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import k3.C0813a;

/* loaded from: classes.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    private static final Map<Long, Integer> f14676a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    private static b f14677b;

    /* renamed from: c, reason: collision with root package name */
    private static long f14678c;

    /* renamed from: d, reason: collision with root package name */
    private static long f14679d;

    /* renamed from: e, reason: collision with root package name */
    private static long f14680e;

    private static final class a {

        /* renamed from: a, reason: collision with root package name */
        String f14681a;

        /* renamed from: b, reason: collision with root package name */
        long f14682b;

        /* renamed from: c, reason: collision with root package name */
        boolean f14683c;

        private a() {
        }
    }

    private static final class b {

        /* renamed from: a, reason: collision with root package name */
        boolean f14684a;

        /* renamed from: b, reason: collision with root package name */
        final ArrayList<a> f14685b;

        private b() {
            this.f14685b = new ArrayList<>();
        }
    }

    private static final class c {

        /* renamed from: a, reason: collision with root package name */
        long f14686a;

        /* renamed from: b, reason: collision with root package name */
        long f14687b;

        /* renamed from: c, reason: collision with root package name */
        boolean f14688c;

        private c() {
            this.f14686a = -1L;
            this.f14687b = -1L;
        }
    }

    private static void a(b bVar, long j5, long j6, long j7) {
        f14677b = bVar;
        f14678c = j5;
        f14679d = j6;
        f14680e = j7;
    }

    private static Map<String, long[]> b(b bVar, long j5) {
        Long l5;
        boolean z5;
        HashMap map = new HashMap();
        if (bVar != null && !bVar.f14684a && !bVar.f14685b.isEmpty()) {
            HashMap map2 = new HashMap();
            HashMap map3 = new HashMap();
            HashMap map4 = new HashMap();
            HashMap map5 = new HashMap();
            ArrayList<a> arrayList = bVar.f14685b;
            int size = arrayList.size();
            boolean z6 = false;
            int i5 = 0;
            while (i5 < size) {
                a aVar = arrayList.get(i5);
                i5++;
                a aVar2 = aVar;
                if (!z6 && aVar2.f14682b >= j5) {
                    o(map2, map3);
                    z6 = true;
                }
                c cVar = (c) map2.get(aVar2.f14681a);
                if (cVar == null) {
                    cVar = new c();
                    map2.put(aVar2.f14681a, cVar);
                }
                if (aVar2.f14683c) {
                    z5 = z6;
                    long j6 = aVar2.f14682b;
                    cVar.f14686a = j6;
                    cVar.f14688c = true;
                    if (j6 >= j5 && !map4.containsKey(aVar2.f14681a)) {
                        map4.put(aVar2.f14681a, Long.valueOf(aVar2.f14682b));
                    }
                } else {
                    z5 = z6;
                    long j7 = aVar2.f14682b;
                    cVar.f14687b = j7;
                    cVar.f14688c = false;
                    if (j7 >= j5 && !map5.containsKey(aVar2.f14681a)) {
                        map5.put(aVar2.f14681a, Long.valueOf(aVar2.f14682b));
                    }
                }
                z6 = z5;
            }
            if (!z6) {
                o(map2, map3);
            }
            for (Map.Entry entry : map5.entrySet()) {
                String str = (String) entry.getKey();
                long jLongValue = entry.getValue() == null ? 0L : ((Long) entry.getValue()).longValue();
                if (Boolean.TRUE.equals(map3.get(str)) && ((l5 = (Long) map4.get(str)) == null || jLongValue <= l5.longValue())) {
                    if (g(jLongValue, j5)) {
                        map.put(str, new long[]{j5, jLongValue});
                        C0702g.O("OvernightUnattendedUsage", "unattended overnight stop package=" + str + " fromMidnight=" + C0711p.t(jLongValue - j5));
                    }
                }
            }
        }
        return map;
    }

    private static String c(StatsDataSet statsDataSet) {
        Map<String, Long> packageUsingTimeMap;
        if (statsDataSet == null || (packageUsingTimeMap = statsDataSet.getPackageUsingTimeMap()) == null || packageUsingTimeMap.isEmpty()) {
            return null;
        }
        String str = null;
        long j5 = 0;
        for (Map.Entry<String, Long> entry : packageUsingTimeMap.entrySet()) {
            String key = entry.getKey();
            long jLongValue = entry.getValue() == null ? 0L : entry.getValue().longValue();
            if (jLongValue > j5 && !PackageUtils.u(key) && !PackageUtils.q(key)) {
                str = key;
                j5 = jLongValue;
            }
        }
        if (j5 < 3000000) {
            return null;
        }
        return str;
    }

    private static Map<String, long[]> d(StatsDataSet statsDataSet, long j5, long j6) {
        String strC;
        HashMap map = new HashMap();
        StatsDataSet[] children = statsDataSet.getChildren();
        if (children != null) {
            if (children.length >= 5 && (strC = c(children[0])) != null && !f(strC)) {
                int i5 = 1;
                while (true) {
                    if (i5 >= 5) {
                        int i6 = 4;
                        for (int i7 = 5; i7 < children.length && h(children[i7], strC) >= 2700000; i7++) {
                            i6 = i7;
                        }
                        long jMin = Math.min(j6, ((i6 + 1) * 3600000) + j5);
                        if (jMin - j5 >= 10800000) {
                            map.put(strC, new long[]{j5, jMin});
                            C0702g.O("OvernightUnattendedUsage", "unattended overnight hour pattern package=" + strC + " hours=0-" + i6);
                        }
                    } else {
                        if (!TextUtils.equals(strC, c(children[i5]))) {
                            break;
                        }
                        i5++;
                    }
                }
            }
        }
        return map;
    }

    private static int e(StatsDataSet statsDataSet) {
        int usingTime = (int) statsDataSet.getUsingTime();
        Map<String, Long> packageUsingTimeMap = statsDataSet.getPackageUsingTimeMap();
        if (packageUsingTimeMap == null) {
            return usingTime;
        }
        int size = (usingTime * 31) + packageUsingTimeMap.size();
        for (Map.Entry<String, Long> entry : packageUsingTimeMap.entrySet()) {
            int iHashCode = 0;
            int iHashCode2 = ((size * 31) + (entry.getKey() == null ? 0 : entry.getKey().hashCode())) * 31;
            if (entry.getValue() != null) {
                iHashCode = entry.getValue().hashCode();
            }
            size = iHashCode2 + iHashCode;
        }
        return size;
    }

    private static boolean f(String str) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        String lowerCase = str.toLowerCase(Locale.US);
        return lowerCase.contains("maps") || lowerCase.contains("navigation") || lowerCase.contains("autonavi") || lowerCase.contains("music") || lowerCase.contains("spotify") || lowerCase.contains("youtube") || lowerCase.contains("video") || lowerCase.contains("bili") || lowerCase.contains("iqiyi") || lowerCase.contains("qqlive") || lowerCase.contains("netease.cloudmusic");
    }

    public static boolean g(long j5, long j6) {
        return j5 - j6 >= 10800000;
    }

    private static long h(StatsDataSet statsDataSet, String str) {
        if (statsDataSet == null || statsDataSet.getPackageUsingTimeMap() == null) {
            return 0L;
        }
        return ((Long) C0813a.a(statsDataSet.getPackageUsingTimeMap(), str, 0L)).longValue();
    }

    private static void i(StatsDataSet statsDataSet, W1.c cVar) {
        StatsDataSet[] children = statsDataSet.getChildren();
        if (children == null) {
            return;
        }
        statsDataSet.setUsingTime(0L);
        statsDataSet.setPickupTimes(0);
        statsDataSet.setNotifyTimes(0);
        statsDataSet.setPackageUsingTimeMap(new HashMap());
        statsDataSet.setPackageNotifyTimesMap(new HashMap());
        statsDataSet.setCategoryUsingTimeMap(new HashMap());
        statsDataSet.addChildren(children);
        if (cVar == null || statsDataSet.getPackageUsingTimeMap() == null) {
            return;
        }
        statsDataSet.setCategoryUsingTimeMap(s.e(cVar, statsDataSet.getPackageUsingTimeMap()));
    }

    public static void j(Context context, W1.c cVar, StatsDataSet statsDataSet) {
        l(context, cVar, statsDataSet, false);
    }

    public static void k(Context context, W1.c cVar, StatsDataSet statsDataSet) {
        l(context, cVar, statsDataSet, true);
    }

    private static void l(Context context, W1.c cVar, StatsDataSet statsDataSet, boolean z5) {
        StatsDataSet[] children;
        W1.c cVar2;
        if (context == null || statsDataSet == null || (children = statsDataSet.getChildren()) == null || children.length == 0) {
            return;
        }
        long startTime = statsDataSet.getStartTime();
        if (startTime <= 0) {
            return;
        }
        int iE = e(statsDataSet);
        Map<Long, Integer> map = f14676a;
        Integer num = map.get(Long.valueOf(startTime));
        if (num == null || num.intValue() != iE) {
            long jMin = Math.min(System.currentTimeMillis(), 86400000 + startTime);
            if (jMin <= startTime) {
                return;
            }
            if (z5 && d(statsDataSet, startTime, jMin).isEmpty()) {
                map.put(Long.valueOf(startTime), Integer.valueOf(iE));
                r();
                return;
            }
            b bVarM = m(context, startTime, jMin);
            Map<String, long[]> mapD = bVarM.f14684a ? d(statsDataSet, startTime, jMin) : b(bVarM, startTime);
            if (mapD.isEmpty()) {
                map.put(Long.valueOf(startTime), Integer.valueOf(iE));
                r();
                return;
            }
            boolean zQ = false;
            for (Map.Entry<String, long[]> entry : mapD.entrySet()) {
                long[] value = entry.getValue();
                if (value == null || value.length < 2) {
                    cVar2 = cVar;
                    statsDataSet = statsDataSet;
                } else {
                    cVar2 = cVar;
                    zQ |= q(statsDataSet, entry.getKey(), value[0], value[1], cVar2);
                }
                cVar = cVar2;
            }
            W1.c cVar3 = cVar;
            StatsDataSet statsDataSet2 = statsDataSet;
            if (zQ) {
                i(statsDataSet2, cVar3);
                C0702g.O("OvernightUnattendedUsage", "stripped unattended overnight usage date=" + C0711p.j(startTime) + " using=" + C0711p.t(statsDataSet2.getUsingTime()));
            }
            f14676a.put(Long.valueOf(startTime), Integer.valueOf(e(statsDataSet2)));
            r();
        }
    }

    private static b m(Context context, long j5, long j6) {
        b bVar = new b();
        if (context == null || Looper.myLooper() == Looper.getMainLooper()) {
            bVar.f14684a = true;
            return bVar;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        b bVar2 = f14677b;
        if (bVar2 != null && f14678c == j5 && f14679d == j6 && jElapsedRealtime - f14680e < 10000) {
            return bVar2;
        }
        UsageStatsManager usageStatsManager = (UsageStatsManager) context.getSystemService("usagestats");
        if (usageStatsManager == null) {
            bVar.f14684a = true;
            a(bVar, j5, j6, jElapsedRealtime);
            return bVar;
        }
        long j7 = j5 - 86400000;
        try {
            UsageEvents usageEventsQueryEvents = usageStatsManager.queryEvents(j7, j6);
            if (usageEventsQueryEvents == null) {
                bVar.f14684a = true;
                a(bVar, j5, j6, jElapsedRealtime);
                return bVar;
            }
            UsageEvents.Event event = new UsageEvents.Event();
            int i5 = 0;
            while (usageEventsQueryEvents.getNextEvent(event)) {
                i5++;
                if (i5 > 5000) {
                    C0702g.O("OvernightUnattendedUsage", "queryEvents hit cap=5000");
                    bVar.f14684a = true;
                    a(bVar, j5, j6, jElapsedRealtime);
                    return bVar;
                }
                int eventType = event.getEventType();
                if (eventType == 1 || eventType == 23 || eventType == 2) {
                    String packageName = event.getPackageName();
                    long timeStamp = event.getTimeStamp();
                    if (TextUtils.isEmpty(packageName) || timeStamp < j7 || timeStamp > j6 || PackageUtils.u(packageName) || PackageUtils.q(packageName)) {
                        event = new UsageEvents.Event();
                    } else {
                        a aVar = new a();
                        aVar.f14681a = packageName;
                        aVar.f14682b = timeStamp;
                        aVar.f14683c = eventType == 1;
                        bVar.f14685b.add(aVar);
                        event = new UsageEvents.Event();
                    }
                } else {
                    event = new UsageEvents.Event();
                }
            }
            f14677b = bVar;
            f14678c = j5;
            f14679d = j6;
            f14680e = jElapsedRealtime;
            return bVar;
        } catch (RuntimeException e6) {
            C0702g.O("OvernightUnattendedUsage", "queryEvents failed: " + e6.getMessage());
            bVar.f14684a = true;
            a(bVar, j5, j6, jElapsedRealtime);
            return bVar;
        }
    }

    public static boolean n(Context context, String str, long j5, long j6) {
        long[] jArr;
        if (!TextUtils.isEmpty(str) && g(j5, j6)) {
            b bVarM = m(context, j6, Math.min(System.currentTimeMillis(), 86400000 + j6));
            if (!bVarM.f14684a && (jArr = b(bVarM, j6).get(str)) != null && jArr.length >= 2) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0030  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void o(java.util.Map<java.lang.String, com.stepos.digitalwellbeing.server.transaction.usagstats.alphame.j.c> r6, java.util.Map<java.lang.String, java.lang.Boolean> r7) {
        /*
            java.util.Set r6 = r6.entrySet()
            java.util.Iterator r6 = r6.iterator()
        L8:
            boolean r0 = r6.hasNext()
            if (r0 == 0) goto L3f
            java.lang.Object r0 = r6.next()
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0
            java.lang.Object r1 = r0.getValue()
            com.stepos.digitalwellbeing.server.transaction.usagstats.alphame.j$c r1 = (com.stepos.digitalwellbeing.server.transaction.usagstats.alphame.j.c) r1
            if (r1 == 0) goto L30
            boolean r2 = r1.f14688c
            if (r2 == 0) goto L30
            long r2 = r1.f14686a
            r4 = 0
            int r4 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r4 <= 0) goto L30
            long r4 = r1.f14687b
            int r1 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r1 <= 0) goto L30
            r1 = 1
            goto L31
        L30:
            r1 = 0
        L31:
            java.lang.Object r0 = r0.getKey()
            java.lang.String r0 = (java.lang.String) r0
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
            r7.put(r0, r1)
            goto L8
        L3f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.digitalwellbeing.server.transaction.usagstats.alphame.j.o(java.util.Map, java.util.Map):void");
    }

    private static boolean p(StatsDataSet statsDataSet, String str, long j5, long j6, W1.c cVar) {
        Map<String, Long> packageUsingTimeMap;
        if (statsDataSet != null && (packageUsingTimeMap = statsDataSet.getPackageUsingTimeMap()) != null && packageUsingTimeMap.containsKey(str)) {
            long startTime = statsDataSet.getStartTime();
            long jMin = Math.min(3600000 + startTime, j6) - Math.max(startTime, j5);
            if (jMin <= 0) {
                return false;
            }
            long jMax = Math.max(0L, ((Long) C0813a.a(packageUsingTimeMap, str, 0L)).longValue());
            if (jMax <= 0) {
                return false;
            }
            long jMin2 = Math.min(jMax, jMin);
            long j7 = jMax - jMin2;
            if (j7 <= 0) {
                packageUsingTimeMap.remove(str);
            } else {
                packageUsingTimeMap.put(str, Long.valueOf(j7));
            }
            statsDataSet.setUsingTime(Math.max(0L, statsDataSet.getUsingTime() - jMin2));
            if (cVar != null) {
                statsDataSet.setCategoryUsingTimeMap(s.e(cVar, packageUsingTimeMap));
            }
            if (jMin2 > 0) {
                return true;
            }
        }
        return false;
    }

    private static boolean q(StatsDataSet statsDataSet, String str, long j5, long j6, W1.c cVar) {
        StatsDataSet[] children;
        if (j6 <= j5 || (children = statsDataSet.getChildren()) == null) {
            return false;
        }
        boolean zP = false;
        for (StatsDataSet statsDataSet2 : children) {
            zP |= p(statsDataSet2, str, j5, j6, cVar);
        }
        return zP;
    }

    private static void r() {
        Map<Long, Integer> map = f14676a;
        if (map.size() <= 16) {
            return;
        }
        map.clear();
    }
}
