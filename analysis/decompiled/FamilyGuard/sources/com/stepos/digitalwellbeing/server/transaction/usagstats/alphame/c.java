package com.stepos.digitalwellbeing.server.transaction.usagstats.alphame;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import com.stepos.common.alphame.AlphaMe;
import com.stepos.digitalwellbeing.server.data.StatsDataSet;
import com.stepos.digitalwellbeing.server.transaction.usagstats.alphame.AlphaMeEntities;
import com.stepos.digitalwellbeing.utils.PackageUtils;
import f2.C0697b;
import f2.C0702g;
import f2.C0711p;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.libpag.BuildConfig;

/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static final A1.e f14654a = new A1.e();

    class a extends com.google.gson.reflect.a<Map<String, Object>> {
        a() {
        }
    }

    class b extends com.google.gson.reflect.a<Map<String, Long>> {
        b() {
        }
    }

    private static long A(Map<String, Long> map, String str) {
        if (map != null && !TextUtils.isEmpty(str) && map.containsKey(str)) {
            Long l5 = map.get(str);
            if (l5 instanceof Number) {
                return l5.longValue();
            }
        }
        return 0L;
    }

    public static void B() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            P1.a.a().getSharedPreferences("digital_wellbeing_user_clear", 0).edit().putLong("user_clear_time_ms", jCurrentTimeMillis).apply();
        } catch (Exception e6) {
            C0702g.p("AlphaMeUtils", "markUserInitiatedClear failed: " + e6.getMessage());
        }
        C0702g.O("AlphaMeUtils", "markUserInitiatedClear time=" + C0711p.j(jCurrentTimeMillis));
    }

    public static Map<String, Long> C(List<AlphaMeEntities.TimeEvent> list) {
        long[] jArrE;
        HashMap map = new HashMap();
        if (list == null) {
            return new HashMap();
        }
        for (AlphaMeEntities.TimeEvent timeEvent : list) {
            String packageName = timeEvent.getPackageName();
            if (!PackageUtils.u(packageName) && (jArrE = e(timeEvent.getStartTime(), timeEvent.getEndTime())) != null) {
                List arrayList = (List) map.get(packageName);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    map.put(packageName, arrayList);
                }
                arrayList.add(new com.stepos.digitalwellbeing.server.data.k(jArrE[0], jArrE[1]));
            }
        }
        HashMap map2 = new HashMap();
        for (Map.Entry entry : map.entrySet()) {
            Iterator<com.stepos.digitalwellbeing.server.data.k> it = com.stepos.digitalwellbeing.server.data.k.d((List) entry.getValue()).iterator();
            long jB = 0;
            while (it.hasNext()) {
                jB += it.next().b();
            }
            if (jB >= 1000) {
                map2.put((String) entry.getKey(), Long.valueOf(jB));
            }
        }
        return map2;
    }

    public static void D(StatsDataSet statsDataSet, int i5) {
        int iMax;
        if (statsDataSet == null || i5 <= 0 || i5 <= (iMax = Math.max(0, statsDataSet.getPickupTimes()))) {
            return;
        }
        int iK = K(statsDataSet.getChildren());
        if (!u(statsDataSet) && i5 > iK + 30 && i5 > 40) {
            C0702g.O("AlphaMeUtils", "reject inflated daily pickup=" + i5 + " keep=" + iMax + " date=" + C0711p.j(statsDataSet.getStartTime()));
            return;
        }
        statsDataSet.setPickupTimes(i5);
        C0702g.O("AlphaMeUtils", "prefer daily pickup=" + i5 + " over hour/day=" + iMax + " date=" + C0711p.j(statsDataSet.getStartTime()));
    }

    private static void E(StatsDataSet statsDataSet) {
        StatsDataSet[] children = statsDataSet.getChildren();
        if (children == null) {
            return;
        }
        long jMax = 0;
        int iMax = 0;
        int iMax2 = 0;
        for (StatsDataSet statsDataSet2 : children) {
            if (statsDataSet2 != null) {
                jMax += Math.max(0L, statsDataSet2.getUsingTime());
                iMax += Math.max(0, statsDataSet2.getPickupTimes());
                iMax2 += Math.max(0, statsDataSet2.getNotifyTimes());
            }
        }
        statsDataSet.setUsingTime(jMax);
        statsDataSet.setPickupTimes(iMax);
        statsDataSet.setNotifyTimes(iMax2);
        statsDataSet.setLongestUseTime(Math.min(statsDataSet.getLongestUseTime(), jMax));
    }

    public static void F(StatsDataSet statsDataSet) {
        if (statsDataSet == null) {
            C0702g.O("AlphaMeUtils", "saveUserClearBaseline skip empty today");
            return;
        }
        int[] iArrS = s(statsDataSet, true);
        int[] iArrS2 = s(statsDataSet, false);
        Map<String, Integer> packageNotifyTimesMap = statsDataSet.getPackageNotifyTimesMap();
        if (q()) {
            iArrS = a(iArrS, y("user_clear_hour_pickup_json"));
            iArrS2 = a(iArrS2, y("user_clear_hour_notify_json"));
            packageNotifyTimesMap = b(packageNotifyTimesMap, z());
        }
        try {
            SharedPreferences.Editor editorEdit = P1.a.a().getSharedPreferences("digital_wellbeing_user_clear", 0).edit();
            A1.e eVar = f14654a;
            editorEdit.putString("user_clear_day_packages_json", eVar.r(statsDataSet.getPackageUsingTimeMap())).putString("user_clear_package_notify_json", eVar.r(packageNotifyTimesMap)).putString("user_clear_hour_pickup_json", eVar.r(iArrS)).putString("user_clear_hour_notify_json", eVar.r(iArrS2)).apply();
        } catch (Exception e6) {
            C0702g.p("AlphaMeUtils", "saveUserClearBaseline failed: " + e6.getMessage());
        }
        StringBuilder sb = new StringBuilder();
        sb.append("saveUserClearBaseline packages=");
        sb.append(statsDataSet.getPackageUsingTimeMap() == null ? 0 : statsDataSet.getPackageUsingTimeMap().size());
        sb.append(" pickup=");
        sb.append(L(iArrS));
        sb.append(" notify=");
        sb.append(L(iArrS2));
        sb.append(" notifyPackages=");
        sb.append(packageNotifyTimesMap != null ? packageNotifyTimesMap.size() : 0);
        C0702g.O("AlphaMeUtils", sb.toString());
    }

    public static int G(int i5, long j5, long j6) {
        if (i5 <= 0) {
            return 0;
        }
        if (j5 > 0 || v(j6)) {
            return i5;
        }
        return 0;
    }

    public static void H(String[] strArr) {
        C0702g.b("AlphaMeUtils", "setTimeRestrictedAppList packageNames = " + C0702g.h(strArr));
        AlphaMe.p().s("setTimeRestrictedAppList", strArr);
    }

    private static Map<String, Integer> I(Map<String, Integer> map, Map<String, Integer> map2) {
        Integer num;
        HashMap map3 = new HashMap();
        if (map != null) {
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                int iIntValue = 0;
                int iIntValue2 = entry.getValue() == null ? 0 : entry.getValue().intValue();
                if (map2 != null && map2.containsKey(entry.getKey()) && (num = map2.get(entry.getKey())) != null) {
                    iIntValue = num.intValue();
                }
                int i5 = iIntValue2 - iIntValue;
                if (i5 > 0) {
                    map3.put(entry.getKey(), Integer.valueOf(i5));
                }
            }
        }
        return map3;
    }

    private static Map<String, Long> J(Map<String, Long> map, Map<String, Long> map2) {
        HashMap map3 = new HashMap();
        if (map != null) {
            for (Map.Entry<String, Long> entry : map.entrySet()) {
                long jLongValue = (entry.getValue() == null ? 0L : entry.getValue().longValue()) - A(map2, entry.getKey());
                if (jLongValue >= 1000) {
                    map3.put(entry.getKey(), Long.valueOf(jLongValue));
                }
            }
        }
        return map3;
    }

    private static int K(StatsDataSet[] statsDataSetArr) {
        if (statsDataSetArr == null) {
            return 0;
        }
        int iMax = 0;
        for (StatsDataSet statsDataSet : statsDataSetArr) {
            if (statsDataSet != null) {
                iMax += Math.max(0, statsDataSet.getPickupTimes());
            }
        }
        return iMax;
    }

    private static int L(int[] iArr) {
        if (iArr == null) {
            return 0;
        }
        int iMax = 0;
        for (int i5 : iArr) {
            iMax += Math.max(0, i5);
        }
        return iMax;
    }

    public static void M(Context context) {
        if (context == null) {
            return;
        }
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = context.getContentResolver().query(g.f14667a, null, null, null, null);
                StringBuilder sb = new StringBuilder();
                sb.append("wakeAlphaMeProcess cursor=");
                sb.append(cursorQuery != null);
                C0702g.b("AlphaMeUtils", sb.toString());
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            } catch (Exception e6) {
                C0702g.O("AlphaMeUtils", "wakeAlphaMeProcess failed: " + e6.getMessage());
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            }
        } finally {
        }
    }

    private static int[] a(int[] iArr, int[] iArr2) {
        int[] iArr3 = new int[24];
        int i5 = 0;
        while (i5 < 24) {
            iArr3[i5] = ((iArr == null || i5 >= iArr.length) ? 0 : Math.max(0, iArr[i5])) + ((iArr2 == null || i5 >= iArr2.length) ? 0 : Math.max(0, iArr2[i5]));
            i5++;
        }
        return iArr3;
    }

    private static Map<String, Integer> b(Map<String, Integer> map, Map<String, Integer> map2) {
        HashMap map3 = new HashMap();
        if (map2 != null) {
            for (Map.Entry<String, Integer> entry : map2.entrySet()) {
                if (entry.getKey() != null && entry.getValue() != null && entry.getValue().intValue() > 0) {
                    map3.put(entry.getKey(), entry.getValue());
                }
            }
        }
        if (map != null) {
            for (Map.Entry<String, Integer> entry2 : map.entrySet()) {
                if (entry2.getKey() != null && entry2.getValue() != null && entry2.getValue().intValue() > 0) {
                    map3.put(entry2.getKey(), Integer.valueOf((map3.containsKey(entry2.getKey()) ? ((Integer) map3.get(entry2.getKey())).intValue() : 0) + entry2.getValue().intValue()));
                }
            }
        }
        return map3;
    }

    private static void c(StatsDataSet[] statsDataSetArr, int i5, int i6) {
        StatsDataSet statsDataSet;
        if (i5 <= 0 || statsDataSetArr == null || statsDataSetArr.length == 0) {
            return;
        }
        if (i6 < 0 || i6 >= statsDataSetArr.length || statsDataSetArr[i6] == null) {
            i6 = statsDataSetArr.length - 1;
            int i7 = -1;
            while (true) {
                if (i6 < 0) {
                    i6 = i7;
                    break;
                }
                StatsDataSet statsDataSet2 = statsDataSetArr[i6];
                if (statsDataSet2 != null) {
                    if (statsDataSet2.getUsingTime() > 0 || statsDataSetArr[i6].getPickupTimes() > 0) {
                        break;
                    } else {
                        i7 = i6;
                    }
                }
                i6--;
            }
        }
        if (i6 < 0 || (statsDataSet = statsDataSetArr[i6]) == null) {
            return;
        }
        statsDataSet.setPickupTimes(statsDataSet.getPickupTimes() + i5);
    }

    private static void d(StatsDataSet statsDataSet) {
        if (statsDataSet == null) {
            return;
        }
        statsDataSet.setUsingTime(0L);
        statsDataSet.setPickupTimes(0);
        statsDataSet.setNotifyTimes(0);
        statsDataSet.setLongestUseTime(0L);
        statsDataSet.setPackageUsingTimeMap(new HashMap());
        statsDataSet.setPackageNotifyTimesMap(new HashMap());
        statsDataSet.setCategoryUsingTimeMap(new HashMap());
    }

    public static long[] e(long j5, long j6) {
        if (j6 <= j5) {
            return null;
        }
        long jK = k();
        if (jK > 0) {
            if (j6 <= jK) {
                return null;
            }
            if (j5 < jK) {
                j5 = jK;
            }
        }
        if (j6 - j5 >= 1000 || !q()) {
            return new long[]{j5, j6};
        }
        return null;
    }

    public static void f() {
        AlphaMe.p().s("setDigitalHealthClearDataTime", new Object[0]);
    }

    private static int g(StatsDataSet statsDataSet) {
        StatsDataSet[] children;
        int iCurrentTimeMillis;
        if (statsDataSet == null || statsDataSet.getStartTime() != C0711p.y() || (children = statsDataSet.getChildren()) == null || children.length == 0 || (iCurrentTimeMillis = (int) ((System.currentTimeMillis() - C0711p.y()) / 3600000)) < 0 || iCurrentTimeMillis >= children.length) {
            return -1;
        }
        return iCurrentTimeMillis;
    }

    public static void h(StatsDataSet statsDataSet) {
        if (statsDataSet != null && q() && statsDataSet.getStartTime() == C0711p.y()) {
            long jK = k();
            if (jK <= 0) {
                return;
            }
            int[] iArrY = y("user_clear_hour_pickup_json");
            int[] iArrY2 = y("user_clear_hour_notify_json");
            long startTime = statsDataSet.getStartTime();
            StatsDataSet[] children = statsDataSet.getChildren();
            if (children != null) {
                for (int i5 = 0; i5 < children.length; i5++) {
                    StatsDataSet statsDataSet2 = children[i5];
                    if (statsDataSet2 != null) {
                        long startTime2 = statsDataSet2.getStartTime();
                        if (startTime2 <= 0) {
                            startTime2 = (i5 * 3600000) + startTime;
                        }
                        if (startTime2 + 3600000 <= jK) {
                            statsDataSet2.setPickupTimes(0);
                            statsDataSet2.setNotifyTimes(0);
                            statsDataSet2.setPackageNotifyTimesMap(new HashMap());
                        } else {
                            int i6 = (int) ((startTime2 - startTime) / 3600000);
                            statsDataSet2.setPickupTimes(Math.max(0, statsDataSet2.getPickupTimes() - r(iArrY, i6)));
                            statsDataSet2.setNotifyTimes(Math.max(0, statsDataSet2.getNotifyTimes() - r(iArrY2, i6)));
                        }
                    }
                }
            }
            statsDataSet.setPackageNotifyTimesMap(I(statsDataSet.getPackageNotifyTimesMap(), z()));
            if (children != null) {
                int iMax = 0;
                int iMax2 = 0;
                for (StatsDataSet statsDataSet3 : children) {
                    if (statsDataSet3 != null) {
                        iMax += Math.max(0, statsDataSet3.getPickupTimes());
                        iMax2 += Math.max(0, statsDataSet3.getNotifyTimes());
                    }
                }
                statsDataSet.setPickupTimes(iMax);
                statsDataSet.setNotifyTimes(iMax2);
            }
            StringBuilder sb = new StringBuilder();
            sb.append("drop pickup/notify after user clear pickup=");
            sb.append(statsDataSet.getPickupTimes());
            sb.append(" notify=");
            sb.append(statsDataSet.getNotifyTimes());
            sb.append(" notifyPackages=");
            sb.append(statsDataSet.getPackageNotifyTimesMap() != null ? statsDataSet.getPackageNotifyTimesMap().size() : 0);
            sb.append(" clear=");
            sb.append(C0711p.j(jK));
            C0702g.O("AlphaMeUtils", sb.toString());
        }
    }

    public static void i(StatsDataSet statsDataSet) {
        if (statsDataSet == null) {
            return;
        }
        StatsDataSet[] children = statsDataSet.getChildren();
        if (children == null || children.length == 0) {
            if (statsDataSet.getUsingTime() > 0 || statsDataSet.getPickupTimes() <= 0) {
                return;
            }
            C0702g.O("AlphaMeUtils", "drop day pickup without usage pickup=" + statsDataSet.getPickupTimes() + " date=" + C0711p.j(statsDataSet.getStartTime()));
            statsDataSet.setPickupTimes(0);
            return;
        }
        int iG = g(statsDataSet);
        int pickupTimes = 0;
        for (int i5 = 0; i5 < children.length; i5++) {
            StatsDataSet statsDataSet2 = children[i5];
            if (statsDataSet2 != null) {
                if (i5 != iG && statsDataSet2.getUsingTime() <= 0 && statsDataSet2.getPickupTimes() > 0) {
                    C0702g.O("AlphaMeUtils", "drop hour pickup without usage pickup=" + statsDataSet2.getPickupTimes() + " hour=" + C0711p.j(statsDataSet2.getStartTime()));
                    statsDataSet2.setPickupTimes(0);
                }
                pickupTimes += statsDataSet2.getPickupTimes();
            }
        }
        int pickupTimes2 = statsDataSet.getPickupTimes();
        if (pickupTimes2 <= pickupTimes || statsDataSet.getUsingTime() <= 0 || (!u(statsDataSet) && pickupTimes != 0 && pickupTimes2 > pickupTimes + 30 && pickupTimes2 > 40)) {
            if (pickupTimes2 != pickupTimes) {
                C0702g.O("AlphaMeUtils", "align day pickup to hourSum=" + pickupTimes + " (was " + pickupTimes2 + ") date=" + C0711p.j(statsDataSet.getStartTime()));
                statsDataSet.setPickupTimes(pickupTimes);
                return;
            }
            return;
        }
        int i6 = pickupTimes2 - pickupTimes;
        c(children, i6, iG);
        C0702g.O("AlphaMeUtils", "keep day pickup=" + pickupTimes2 + " above hourSum=" + pickupTimes + " backfill gap=" + i6 + " date=" + C0711p.j(statsDataSet.getStartTime()));
    }

    public static void j(StatsDataSet statsDataSet) {
        if (statsDataSet == null) {
            return;
        }
        long jK = k();
        long j5 = 0;
        if (jK <= 0) {
            return;
        }
        long startTime = statsDataSet.getStartTime();
        int i5 = 0;
        if (86400000 + startTime <= jK) {
            C0702g.O("AlphaMeUtils", "drop historical day before user clear date=" + C0711p.j(startTime));
            d(statsDataSet);
            StatsDataSet[] children = statsDataSet.getChildren();
            if (children != null) {
                int length = children.length;
                while (i5 < length) {
                    d(children[i5]);
                    i5++;
                }
            }
            e.n();
            return;
        }
        if (startTime >= jK) {
            return;
        }
        HashMap map = statsDataSet.getCategoryUsingTimeMap() == null ? new HashMap() : new HashMap(statsDataSet.getCategoryUsingTimeMap());
        HashMap map2 = statsDataSet.getPackageUsingTimeMap() == null ? new HashMap() : new HashMap(statsDataSet.getPackageUsingTimeMap());
        StatsDataSet[] children2 = statsDataSet.getChildren();
        long jMax = Math.max(0L, System.currentTimeMillis() - jK);
        if (children2 != null) {
            int length2 = children2.length;
            int i6 = 0;
            while (i5 < length2) {
                StatsDataSet statsDataSet2 = children2[i5];
                if (statsDataSet2 != null) {
                    long startTime2 = statsDataSet2.getStartTime();
                    long j6 = startTime2 + 3600000;
                    if (startTime2 < jK) {
                        if (j6 <= jK) {
                            if (statsDataSet2.getUsingTime() > j5 || statsDataSet2.getPickupTimes() > 0) {
                                i6 = 1;
                            }
                            d(statsDataSet2);
                        } else if (statsDataSet2.getUsingTime() > jMax) {
                            statsDataSet2.setUsingTime(jMax);
                            statsDataSet2.setLongestUseTime(Math.min(statsDataSet2.getLongestUseTime(), jMax));
                            i6 = 1;
                        }
                    }
                }
                i5++;
                j5 = 0;
            }
            i5 = i6;
        }
        if (i5 != 0) {
            e.n();
            E(statsDataSet);
        } else if ((children2 == null || children2.length == 0) && statsDataSet.getUsingTime() > jMax) {
            statsDataSet.setUsingTime(jMax);
            statsDataSet.setLongestUseTime(Math.min(statsDataSet.getLongestUseTime(), jMax));
        }
        statsDataSet.setPackageUsingTimeMap(J(map2, x()));
        statsDataSet.setCategoryUsingTimeMap(map);
        C0702g.O("AlphaMeUtils", "truncated today after user clear using=" + C0711p.t(statsDataSet.getUsingTime()) + " clear=" + C0711p.j(jK) + " overlapCap=" + C0711p.t(jMax));
    }

    public static long k() {
        Object objS = AlphaMe.p().s("getDigitalHealthClearDataTime", new Object[0]);
        long jLongValue = objS instanceof Long ? ((Long) objS).longValue() : 0L;
        long jP = p();
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jP <= 0 || jP > jCurrentTimeMillis) {
            if (jLongValue > 0 && C0697b.x(jLongValue)) {
                return 0L;
            }
        } else if (jLongValue <= jP || C0697b.x(jLongValue)) {
            return jP;
        }
        return jLongValue;
    }

    public static String l(Context context, String str) throws IOException {
        C0702g.y("AlphaMeUtils", "getFromAlphameFileUri START");
        try {
            ParcelFileDescriptor parcelFileDescriptorOpenFile = context.getContentResolver().openFile(Uri.parse(str), "r", null);
            try {
                FileInputStream fileInputStream = new FileInputStream(parcelFileDescriptorOpenFile != null ? parcelFileDescriptorOpenFile.getFileDescriptor() : null);
                try {
                    if (parcelFileDescriptorOpenFile == null) {
                        C0702g.O("AlphaMeUtils", "ParcelFileDescriptor is null");
                        C0702g.p("AlphaMeUtils", "getFromAlphameFileUri END return null");
                        fileInputStream.close();
                        if (parcelFileDescriptorOpenFile == null) {
                            return null;
                        }
                        parcelFileDescriptorOpenFile.close();
                        return null;
                    }
                    byte[] bArr = new byte[8192];
                    StringBuilder sb = new StringBuilder();
                    while (true) {
                        int i5 = fileInputStream.read(bArr);
                        if (i5 == -1) {
                            String string = sb.toString();
                            C0702g.z("AlphaMeUtils", "getFromAlphameFileUri END result = " + string, false);
                            fileInputStream.close();
                            parcelFileDescriptorOpenFile.close();
                            return string;
                        }
                        sb.append(new String(bArr, 0, i5, StandardCharsets.UTF_8));
                    }
                } finally {
                }
            } finally {
            }
        } catch (IOException e6) {
            e6.printStackTrace();
            C0702g.p("AlphaMeUtils", "Error reading file: " + e6.getMessage());
            C0702g.p("AlphaMeUtils", "getFromAlphameFileUri END return null");
            return null;
        }
    }

    public static AlphaMeEntities.TimeEventData m(int i5, long j5) throws IOException {
        C0702g.b("AlphaMeUtils", "getTodayTimeRestrictedAppTimeUsages mode = " + i5 + " minorId = " + j5);
        String strN = n(i5, j5);
        if (TextUtils.isEmpty(strN)) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            C0702g.O("AlphaMeUtils", "result is empty reload from file start");
            String strO = o(i5, j5);
            long jCurrentTimeMillis2 = System.currentTimeMillis();
            C0702g.b("AlphaMeUtils", "uri loaded time = " + C0711p.t(jCurrentTimeMillis2 - jCurrentTimeMillis));
            strN = l(P1.a.a(), strO);
            long jCurrentTimeMillis3 = System.currentTimeMillis();
            C0702g.b("AlphaMeUtils", "result loaded time = " + C0711p.t(jCurrentTimeMillis3 - jCurrentTimeMillis2));
            C0702g.b("AlphaMeUtils", "total time = " + C0711p.t(jCurrentTimeMillis3 - jCurrentTimeMillis));
        }
        if (TextUtils.isEmpty(strN)) {
            C0702g.p("AlphaMeUtils", "file result is empty");
            return null;
        }
        try {
            return (AlphaMeEntities.TimeEventData) new A1.e().i(strN, AlphaMeEntities.TimeEventData.class);
        } catch (Exception e6) {
            C0702g.p("AlphaMeUtils", "Error parsing JSON: " + e6.getMessage());
            return null;
        }
    }

    public static String n(int i5, long j5) {
        String str = (String) AlphaMe.p().s("getTodayTimeRestrictedAppTimeUsages", Integer.valueOf(i5), Long.valueOf(j5));
        C0702g.b("AlphaMeUtils", "getTodayTimeRestrictedAppTimeUsages mode = " + i5 + " minorId = " + j5 + " result = " + str);
        return str;
    }

    public static String o(int i5, long j5) {
        try {
            String str = (String) AlphaMe.p().s("getTodayTimeRestrictedAppTimeUsagesByUri", Integer.valueOf(i5), Long.valueOf(j5));
            C0702g.b("AlphaMeUtils", "getTodayTimeRestrictedAppTimeUsages mode = " + i5 + " minorId = " + j5 + " result = " + str);
            return str;
        } catch (Exception e6) {
            e6.printStackTrace();
            return null;
        }
    }

    public static long p() {
        try {
            return P1.a.a().getSharedPreferences("digital_wellbeing_user_clear", 0).getLong("user_clear_time_ms", 0L);
        } catch (Exception unused) {
            return 0L;
        }
    }

    public static boolean q() {
        long jP = p();
        return jP > 0 && jP <= System.currentTimeMillis() && jP > C0711p.y();
    }

    private static int r(int[] iArr, int i5) {
        if (iArr == null || i5 < 0 || i5 >= iArr.length) {
            return 0;
        }
        return Math.max(0, iArr[i5]);
    }

    private static int[] s(StatsDataSet statsDataSet, boolean z5) {
        int[] iArr = new int[24];
        StatsDataSet[] children = statsDataSet.getChildren();
        if (children != null) {
            long startTime = statsDataSet.getStartTime();
            int iMin = Math.min(24, children.length);
            for (int i5 = 0; i5 < iMin; i5++) {
                StatsDataSet statsDataSet2 = children[i5];
                if (statsDataSet2 != null) {
                    int startTime2 = (statsDataSet2.getStartTime() <= 0 || startTime <= 0) ? i5 : (int) ((statsDataSet2.getStartTime() - startTime) / 3600000);
                    if (startTime2 >= 0 && startTime2 < 24) {
                        iArr[startTime2] = Math.max(0, z5 ? statsDataSet2.getPickupTimes() : statsDataSet2.getNotifyTimes());
                    }
                }
            }
        }
        return iArr;
    }

    public static boolean t() {
        return true;
    }

    private static boolean u(StatsDataSet statsDataSet) {
        return (statsDataSet == null || statsDataSet.getStartTime() != C0711p.y() || C0697b.n()) ? false : true;
    }

    private static boolean v(long j5) {
        if (j5 <= 0) {
            return false;
        }
        long jY = C0711p.y();
        long jCurrentTimeMillis = System.currentTimeMillis();
        return j5 >= jY && j5 < jY + 86400000 && jCurrentTimeMillis >= j5 && jCurrentTimeMillis < j5 + 3600000;
    }

    public static boolean w() {
        Object objS = AlphaMe.p().s("isSupportMinorsMode", new Object[0]);
        if (objS != null && (objS instanceof Boolean)) {
            return ((Boolean) objS).booleanValue();
        }
        return false;
    }

    private static Map<String, Long> x() {
        Map<String, Long> map;
        try {
            String string = P1.a.a().getSharedPreferences("digital_wellbeing_user_clear", 0).getString("user_clear_day_packages_json", BuildConfig.FLAVOR);
            return (TextUtils.isEmpty(string) || (map = (Map) f14654a.j(string, new b().getType())) == null) ? new HashMap() : map;
        } catch (Exception e6) {
            C0702g.p("AlphaMeUtils", "loadUserClearDayBaseline failed: " + e6.getMessage());
            return new HashMap();
        }
    }

    private static int[] y(String str) {
        try {
            String string = P1.a.a().getSharedPreferences("digital_wellbeing_user_clear", 0).getString(str, BuildConfig.FLAVOR);
            if (TextUtils.isEmpty(string)) {
                return new int[0];
            }
            int[] iArr = (int[]) f14654a.i(string, int[].class);
            return iArr == null ? new int[0] : iArr;
        } catch (Exception e6) {
            C0702g.p("AlphaMeUtils", "loadUserClearHourCounters failed: " + e6.getMessage());
            return new int[0];
        }
    }

    private static Map<String, Integer> z() {
        Map map;
        int iIntValue;
        try {
            String string = P1.a.a().getSharedPreferences("digital_wellbeing_user_clear", 0).getString("user_clear_package_notify_json", BuildConfig.FLAVOR);
            if (!TextUtils.isEmpty(string) && (map = (Map) f14654a.j(string, new a().getType())) != null) {
                HashMap map2 = new HashMap();
                for (Map.Entry entry : map.entrySet()) {
                    if (entry.getKey() != null && (entry.getValue() instanceof Number) && (iIntValue = ((Number) entry.getValue()).intValue()) > 0) {
                        map2.put((String) entry.getKey(), Integer.valueOf(iIntValue));
                    }
                }
                return map2;
            }
            return new HashMap();
        } catch (Exception e6) {
            C0702g.p("AlphaMeUtils", "loadUserClearPackageNotifyBaseline failed: " + e6.getMessage());
            return new HashMap();
        }
    }
}
