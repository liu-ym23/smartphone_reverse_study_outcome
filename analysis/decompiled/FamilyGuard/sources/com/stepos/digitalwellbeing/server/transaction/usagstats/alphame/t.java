package com.stepos.digitalwellbeing.server.transaction.usagstats.alphame;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.stepos.digitalwellbeing.server.data.Category;
import com.stepos.digitalwellbeing.server.data.StatsDataSet;
import com.stepos.digitalwellbeing.utils.PackageUtils;
import f2.C0697b;
import f2.C0702g;
import f2.C0711p;
import java.util.HashMap;
import java.util.Map;
import k3.C0813a;

/* loaded from: classes.dex */
public final class t {

    /* renamed from: a, reason: collision with root package name */
    private static final A1.e f14694a = new A1.e();

    /* renamed from: b, reason: collision with root package name */
    private static final Object f14695b = new Object();

    private static final class a {

        /* renamed from: a, reason: collision with root package name */
        final int f14696a;

        /* renamed from: b, reason: collision with root package name */
        final int f14697b;

        a(int i5, int i6) {
            this.f14696a = i5;
            this.f14697b = i6;
        }
    }

    private static final class b {

        /* renamed from: a, reason: collision with root package name */
        long f14698a;

        /* renamed from: b, reason: collision with root package name */
        long f14699b;

        /* renamed from: c, reason: collision with root package name */
        long f14700c;

        /* renamed from: d, reason: collision with root package name */
        int f14701d;

        /* renamed from: e, reason: collision with root package name */
        int f14702e;

        /* renamed from: f, reason: collision with root package name */
        Map<String, Long> f14703f;

        /* renamed from: g, reason: collision with root package name */
        Map<String, Integer> f14704g;

        /* renamed from: h, reason: collision with root package name */
        long[] f14705h;

        /* renamed from: i, reason: collision with root package name */
        int[] f14706i;

        /* renamed from: j, reason: collision with root package name */
        int[] f14707j;

        private static void a(StatsDataSet[] statsDataSetArr, int[] iArr, int[] iArr2) {
            int i5;
            int i6;
            if (statsDataSetArr == null) {
                return;
            }
            if (iArr != null) {
                int iMin = Math.min(statsDataSetArr.length, iArr.length);
                for (int i7 = 0; i7 < iMin; i7++) {
                    StatsDataSet statsDataSet = statsDataSetArr[i7];
                    if (statsDataSet != null && (i6 = iArr[i7]) > 0) {
                        statsDataSet.setPickupTimes(i6);
                    }
                }
            }
            if (iArr2 != null) {
                int iMin2 = Math.min(statsDataSetArr.length, iArr2.length);
                for (int i8 = 0; i8 < iMin2; i8++) {
                    StatsDataSet statsDataSet2 = statsDataSetArr[i8];
                    if (statsDataSet2 != null && (i5 = iArr2[i8]) > 0) {
                        statsDataSet2.setNotifyTimes(i5);
                    }
                }
            }
        }

        private static void b(StatsDataSet[] statsDataSetArr, long[] jArr) {
            if (statsDataSetArr == null || jArr == null) {
                return;
            }
            int iMin = Math.min(statsDataSetArr.length, jArr.length);
            for (int i5 = 0; i5 < iMin; i5++) {
                StatsDataSet statsDataSet = statsDataSetArr[i5];
                if (statsDataSet != null) {
                    long j5 = jArr[i5];
                    if (j5 > 0) {
                        statsDataSet.setUsingTime(j5);
                    }
                }
            }
        }

        private static Map<String, Long> c(W1.c cVar, Map<String, Long> map) throws Throwable {
            HashMap map2 = new HashMap();
            for (Map.Entry<String, Long> entry : map.entrySet()) {
                Category categoryI = cVar.i(entry.getKey());
                String strB = W1.a.b(categoryI != null ? categoryI.getId() : 10);
                map2.put(strB, Long.valueOf(((Long) C0813a.a(map2, strB, 0L)).longValue() + entry.getValue().longValue()));
            }
            return map2;
        }

        private static int[] d(StatsDataSet[] statsDataSetArr, boolean z5) {
            if (statsDataSetArr != null && statsDataSetArr.length != 0) {
                int[] iArr = new int[statsDataSetArr.length];
                boolean z6 = false;
                for (int i5 = 0; i5 < statsDataSetArr.length; i5++) {
                    StatsDataSet statsDataSet = statsDataSetArr[i5];
                    if (statsDataSet != null) {
                        int pickupTimes = z5 ? statsDataSet.getPickupTimes() : statsDataSet.getNotifyTimes();
                        if (pickupTimes > 0) {
                            iArr[i5] = pickupTimes;
                            z6 = true;
                        }
                    }
                }
                if (z6) {
                    return iArr;
                }
            }
            return null;
        }

        private static long[] e(StatsDataSet[] statsDataSetArr) {
            if (statsDataSetArr != null && statsDataSetArr.length != 0) {
                long[] jArr = new long[statsDataSetArr.length];
                boolean z5 = false;
                for (int i5 = 0; i5 < statsDataSetArr.length; i5++) {
                    StatsDataSet statsDataSet = statsDataSetArr[i5];
                    if (statsDataSet != null && statsDataSet.getUsingTime() > 0) {
                        jArr[i5] = statsDataSetArr[i5].getUsingTime();
                        z5 = true;
                    }
                }
                if (z5) {
                    return jArr;
                }
            }
            return null;
        }

        private static Map<String, Integer> f(Map<String, Integer> map) {
            return map == null ? new HashMap() : new HashMap(map);
        }

        private static Map<String, Long> g(Map<String, Long> map) {
            return map == null ? new HashMap() : new HashMap(map);
        }

        private static Map<String, Long> h(Map<String, Long> map) {
            HashMap map2 = new HashMap();
            for (Map.Entry<String, Long> entry : map.entrySet()) {
                if (!PackageUtils.u(entry.getKey()) && !PackageUtils.q(entry.getKey())) {
                    map2.put(entry.getKey(), entry.getValue());
                }
            }
            return map2;
        }

        static b i(StatsDataSet statsDataSet) {
            b bVar = new b();
            bVar.f14698a = statsDataSet.getStartTime();
            Map<String, Long> mapH = h(g(statsDataSet.getPackageUsingTimeMap()));
            bVar.f14703f = mapH;
            bVar.f14704g = f(statsDataSet.getPackageNotifyTimesMap());
            long j5 = j(mapH);
            long usingTime = statsDataSet.getUsingTime();
            if (j5 <= 0 || (usingTime > 0 && usingTime <= 3600000 + j5)) {
                j5 = usingTime;
            }
            bVar.f14699b = j5;
            bVar.f14700c = statsDataSet.getLongestUseTime();
            bVar.f14701d = statsDataSet.getPickupTimes();
            bVar.f14702e = statsDataSet.getNotifyTimes();
            bVar.f14705h = e(statsDataSet.getChildren());
            bVar.f14706i = d(statsDataSet.getChildren(), true);
            bVar.f14707j = d(statsDataSet.getChildren(), false);
            return bVar;
        }

        private static long j(Map<String, Long> map) {
            long jLongValue = 0;
            for (Long l5 : map.values()) {
                if (l5 != null) {
                    jLongValue += l5.longValue();
                }
            }
            return jLongValue;
        }

        StatsDataSet k(W1.c cVar) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            long j5 = this.f14698a;
            com.stepos.digitalwellbeing.server.data.a aVar = com.stepos.digitalwellbeing.server.data.a.DAY;
            StatsDataSet[] statsDataSetArrCreateEmptyStatsDataSetArray = StatsDataSet.createEmptyStatsDataSetArray(j5, jCurrentTimeMillis, aVar.ordinal());
            b(statsDataSetArrCreateEmptyStatsDataSetArray, this.f14705h);
            a(statsDataSetArrCreateEmptyStatsDataSetArray, this.f14706i, this.f14707j);
            StatsDataSet statsDataSet = new StatsDataSet(aVar.ordinal(), 24, jCurrentTimeMillis, this.f14698a, statsDataSetArrCreateEmptyStatsDataSetArray);
            statsDataSet.setUsingTime(this.f14699b);
            statsDataSet.setLongestUseTime(this.f14700c);
            statsDataSet.setPickupTimes(this.f14701d);
            statsDataSet.setNotifyTimes(this.f14702e);
            HashMap map = this.f14703f == null ? new HashMap() : new HashMap(this.f14703f);
            statsDataSet.setPackageUsingTimeMap(map);
            if (this.f14704g != null) {
                statsDataSet.setPackageNotifyTimesMap(new HashMap(this.f14704g));
            }
            statsDataSet.setCategoryUsingTimeMap(c(cVar, map));
            return statsDataSet;
        }

        private b() {
        }
    }

    private static int A(int i5, int i6) {
        return (i5 > i6 + 30 && i5 > 40) ? Math.max(0, i6) : i5;
    }

    public static void B(Context context, StatsDataSet statsDataSet) {
        long j5;
        boolean z5;
        boolean z6;
        boolean z7;
        long j6;
        boolean z8;
        if (context == null || statsDataSet == null || statsDataSet.getUsingTime() < 120000) {
            return;
        }
        long startTime = statsDataSet.getStartTime();
        long jY = C0711p.y();
        boolean z9 = C0697b.r() && startTime == jY - 86400000;
        if (startTime == jY || z9) {
            if (C0697b.r() && !z9) {
                C0702g.O("UsageDaySnapshotCache", "skip saving snapshot on forward-jump fake today dayStart=" + C0711p.j(startTime) + " using=" + C0711p.t(statsDataSet.getUsingTime()));
                return;
            }
            b bVarI = b.i(statsDataSet);
            if (C0697b.s(bVarI.f14705h)) {
                C0702g.O("UsageDaySnapshotCache", "skip saturated phantom snapshot save using=" + C0711p.t(bVarI.f14699b) + " dayStart=" + C0711p.j(startTime));
                return;
            }
            SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences("usage_day_snapshot", 0);
            b bVarM = m(sharedPreferences, startTime);
            if (bVarM == null || bVarM.f14699b <= bVarI.f14699b + 60000) {
                j5 = 60000;
                z5 = false;
                z6 = false;
            } else {
                z5 = C0697b.n() && l(bVarM.f14705h, startTime) && !l(bVarI.f14705h, startTime);
                if (!C0697b.n() || E(bVarM) < 600000 || E(bVarI) + 300000 >= E(bVarM)) {
                    j5 = 60000;
                } else {
                    j5 = 60000;
                    if (bVarM.f14699b - bVarI.f14699b <= (E(bVarM) - E(bVarI)) + 120000) {
                        z6 = true;
                    }
                    if (!z5 && !z6) {
                        C0702g.O("UsageDaySnapshotCache", "skip weaker snapshot save existing=" + C0711p.t(bVarM.f14699b) + " incoming=" + C0711p.t(bVarI.f14699b) + " dayStart=" + C0711p.j(startTime));
                        return;
                    }
                }
                z6 = false;
                if (!z5) {
                    C0702g.O("UsageDaySnapshotCache", "skip weaker snapshot save existing=" + C0711p.t(bVarM.f14699b) + " incoming=" + C0711p.t(bVarI.f14699b) + " dayStart=" + C0711p.j(startTime));
                    return;
                }
            }
            if (bVarM == null || !C0697b.p() || !C0697b.q() || bVarI.f14699b <= bVarM.f14699b + j5) {
                z7 = z6;
                j6 = startTime;
                z8 = z5;
            } else {
                long jE = C0697b.e();
                if (jE < 0 || jE == Long.MAX_VALUE) {
                    jE = 0;
                }
                j6 = startTime;
                z8 = z5;
                z7 = z6;
                if (bVarI.f14699b > bVarM.f14699b + jE + u(sharedPreferences, startTime) + j5) {
                    C0702g.O("UsageDaySnapshotCache", "skip rewind inflated snapshot save existing=" + C0711p.t(bVarM.f14699b) + " incoming=" + C0711p.t(bVarI.f14699b) + " dayStart=" + C0711p.j(j6));
                    return;
                }
            }
            boolean z10 = bVarM == null || bVarI.f14701d > bVarM.f14701d;
            boolean z11 = bVarM == null || bVarI.f14702e > bVarM.f14702e;
            boolean z12 = bVarM == null || bVarI.f14699b > bVarM.f14699b;
            boolean z13 = bVarM == null || s(bVarI) > s(bVarM);
            if (bVarM == null || z12 || z10 || z11 || z13 || bVarM.f14699b < bVarI.f14699b - j5 || z8 || z7) {
                SharedPreferences.Editor editorEdit = sharedPreferences.edit();
                String strJ = j(j6);
                A1.e eVar = f14694a;
                editorEdit.putString(strJ, eVar.r(bVarI));
                editorEdit.putString("snapshot_json", eVar.r(bVarI));
                long j7 = j6;
                v(sharedPreferences, editorEdit, j7, bVarI.f14701d, bVarI.f14702e);
                w(editorEdit, sharedPreferences, j7);
                editorEdit.apply();
                C0702g.b("UsageDaySnapshotCache", "saved day snapshot using=" + C0711p.t(bVarI.f14699b) + " pickup=" + bVarI.f14701d + " notify=" + bVarI.f14702e + " dayStart=" + C0711p.j(bVarI.f14698a));
            }
        }
    }

    public static void C(Context context, StatsDataSet statsDataSet) {
        if (context == null || statsDataSet == null || !C0697b.r() || statsDataSet.getStartTime() != C0711p.y()) {
            return;
        }
        long jE = C0697b.e();
        if (jE <= 0 || jE == Long.MAX_VALUE) {
            return;
        }
        b bVarI = b.i(statsDataSet);
        f(bVarI, jE, statsDataSet.getStartTime(), statsDataSet.getLongestUseTime());
        if (bVarI.f14699b > 0 || s(bVarI) > 0) {
            bVarI.f14698a = C0711p.y() - 86400000;
            boolean z5 = false;
            SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences("usage_day_snapshot", 0);
            long jG = C0697b.g();
            long j5 = sharedPreferences.getLong("forward_session_jump_wall", 0L);
            b bVarT = t(sharedPreferences.getString("forward_session_json", null));
            if (jG > 0 && j5 == jG) {
                z5 = true;
            }
            long jQ = q(bVarI);
            long jQ2 = q(bVarT);
            if (!z5 || bVarT == null || bVarT.f14698a != bVarI.f14698a || jQ2 < jQ || bVarT.f14699b < bVarI.f14699b || s(bVarT) < s(bVarI)) {
                sharedPreferences.edit().putString("forward_session_json", f14694a.r(bVarI)).putLong("forward_session_jump_wall", jG).remove("forward_session_applied_day").apply();
                C0702g.O("UsageDaySnapshotCache", "saved forward-jump session using=" + C0711p.t(bVarI.f14699b) + " target=" + C0711p.j(bVarI.f14698a) + " jumpWall=" + C0711p.j(jG));
            }
        }
    }

    private static void D(StatsDataSet statsDataSet, int i5, int i6) {
        StatsDataSet[] children = statsDataSet.getChildren();
        if (children == null) {
            return;
        }
        int pickupTimes = 0;
        int notifyTimes = 0;
        for (StatsDataSet statsDataSet2 : children) {
            if (statsDataSet2 != null) {
                pickupTimes += statsDataSet2.getPickupTimes();
                notifyTimes += statsDataSet2.getNotifyTimes();
            }
        }
        if (pickupTimes > i5 + 30 && pickupTimes > 40) {
            C0702g.O("UsageDaySnapshotCache", "scrub inflated hour pickup sum=" + pickupTimes + " saneDay=" + i5);
            int length = children.length;
            for (int i7 = 0; i7 < length; i7++) {
                StatsDataSet statsDataSet3 = children[i7];
                if (statsDataSet3 != null) {
                    statsDataSet3.setPickupTimes(0);
                }
            }
        }
        if (notifyTimes <= i6 + 30 || notifyTimes <= 40) {
            return;
        }
        C0702g.O("UsageDaySnapshotCache", "scrub inflated hour notify sum=" + notifyTimes + " saneDay=" + i6);
        int length2 = children.length;
        for (int i8 = 0; i8 < length2; i8++) {
            StatsDataSet statsDataSet4 = children[i8];
            if (statsDataSet4 != null) {
                statsDataSet4.setNotifyTimes(0);
            }
        }
    }

    private static long E(b bVar) {
        Map<String, Long> map;
        Long l5;
        if (bVar == null || (map = bVar.f14703f) == null || (l5 = map.get("com.android.settings")) == null) {
            return 0L;
        }
        return Math.max(0L, l5.longValue());
    }

    static void a(StatsDataSet statsDataSet, long j5) {
        StatsDataSet[] children;
        int iCurrentTimeMillis;
        StatsDataSet statsDataSet2;
        if (statsDataSet == null || j5 <= 0 || (children = statsDataSet.getChildren()) == null || children.length == 0 || (iCurrentTimeMillis = (int) ((System.currentTimeMillis() - statsDataSet.getStartTime()) / 3600000)) < 0 || iCurrentTimeMillis >= children.length || (statsDataSet2 = children[iCurrentTimeMillis]) == null) {
            return;
        }
        statsDataSet2.setUsingTime(statsDataSet2.getUsingTime() + j5);
    }

    public static void b(Context context, StatsDataSet statsDataSet, W1.c cVar) {
        long j5;
        if (context == null || statsDataSet == null || cVar == null || !C0697b.p()) {
            return;
        }
        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences("usage_day_snapshot", 0);
        b bVarT = t(sharedPreferences.getString("forward_session_json", null));
        if (bVarT == null || bVarT.f14698a != statsDataSet.getStartTime()) {
            return;
        }
        if ((bVarT.f14699b > 0 || s(bVarT) > 0) && sharedPreferences.getLong("forward_session_applied_day", Long.MIN_VALUE) != statsDataSet.getStartTime()) {
            HashMap map = statsDataSet.getPackageUsingTimeMap() == null ? new HashMap() : new HashMap(statsDataSet.getPackageUsingTimeMap());
            Map<String, Long> map2 = bVarT.f14703f;
            if (map2 != null) {
                j5 = 0;
                for (Map.Entry<String, Long> entry : map2.entrySet()) {
                    long jLongValue = entry.getValue() == null ? 0L : entry.getValue().longValue();
                    if (jLongValue > 0) {
                        map.put(entry.getKey(), Long.valueOf(((Long) C0813a.a(map, entry.getKey(), 0L)).longValue() + jLongValue));
                        j5 += jLongValue;
                    }
                }
            } else {
                j5 = 0;
            }
            if (j5 <= 0) {
                return;
            }
            long jLongValue2 = 0;
            for (Long l5 : map.values()) {
                if (l5 != null) {
                    jLongValue2 += l5.longValue();
                }
            }
            statsDataSet.setPackageUsingTimeMap(map);
            statsDataSet.setCategoryUsingTimeMap(s.e(cVar, map));
            statsDataSet.setUsingTime(jLongValue2);
            a(statsDataSet, Math.max(0L, bVarT.f14699b));
            C0702g.O("UsageDaySnapshotCache", "apply forward-jump session added=" + C0711p.t(bVarT.f14699b) + " using=" + C0711p.t(jLongValue2) + " dayStart=" + C0711p.j(statsDataSet.getStartTime()));
            sharedPreferences.edit().putLong("forward_session_applied_day", statsDataSet.getStartTime()).apply();
        }
    }

    private static Map<String, Long> c(W1.c cVar, Map<String, Long> map) throws Throwable {
        HashMap map2 = new HashMap();
        for (Map.Entry<String, Long> entry : map.entrySet()) {
            Category categoryI = cVar.i(entry.getKey());
            String strB = W1.a.b(categoryI != null ? categoryI.getId() : 10);
            map2.put(strB, Long.valueOf(((Long) C0813a.a(map2, strB, 0L)).longValue() + entry.getValue().longValue()));
        }
        return map2;
    }

    private static void d(SharedPreferences sharedPreferences, SharedPreferences.Editor editor, String str, int i5) {
        if (i5 <= 0) {
            return;
        }
        int i6 = sharedPreferences.getInt(str + "last_raw", 0);
        int i7 = i6 + 30;
        if (i5 > i7 && i5 > 40) {
            C0702g.O("UsageDaySnapshotCache", "skip persisting inflated counter floor prefix=" + str + " total=" + i5 + " lastRaw=" + i6);
            return;
        }
        String str2 = str + "last_total";
        int iMax = Math.max(i5, sharedPreferences.getInt(str2, 0));
        if (iMax > i7 && iMax > 40) {
            iMax = Math.max(i5, i6);
        }
        editor.putInt(str2, iMax);
    }

    public static void e(Context context, StatsDataSet statsDataSet) {
        if (context == null || statsDataSet == null || !C0697b.p() || statsDataSet.getUsingTime() < 120000 || !k(statsDataSet)) {
            return;
        }
        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences("usage_day_snapshot", 0);
        b bVarT = t(sharedPreferences.getString("rewind_base_json", null));
        if (bVarT == null || bVarT.f14698a != statsDataSet.getStartTime() || bVarT.f14699b + 60000 < statsDataSet.getUsingTime()) {
            b bVarI = b.i(statsDataSet);
            sharedPreferences.edit().putString("rewind_base_json", f14694a.r(bVarI)).apply();
            C0702g.O("UsageDaySnapshotCache", "capture rewind base using=" + C0711p.t(bVarI.f14699b) + " dayStart=" + C0711p.j(bVarI.f14698a));
        }
    }

    private static void f(b bVar, long j5, long j6, long j7) {
        long j8;
        if (bVar.f14703f == null) {
            bVar.f14703f = new HashMap();
        }
        Long l5 = bVar.f14703f.get("com.android.settings");
        long j9 = 0;
        long jMax = l5 == null ? 0L : Math.max(0L, l5.longValue());
        long jMax2 = 0;
        for (Map.Entry<String, Long> entry : bVar.f14703f.entrySet()) {
            if (!TextUtils.equals(entry.getKey(), "com.android.settings") && entry.getValue() != null) {
                jMax2 += Math.max(0L, entry.getValue().longValue());
            }
        }
        long jG = e.g(jMax, jMax2);
        if (jG <= 0) {
            bVar.f14703f.remove("com.android.settings");
        } else if (jMax > jG) {
            bVar.f14703f.put("com.android.settings", Long.valueOf(jG));
        }
        Long l6 = bVar.f14703f.get("com.stepos.familyguard");
        if (l6 != null && PackageUtils.s(l6.longValue(), j7, j6)) {
            bVar.f14703f.remove("com.stepos.familyguard");
        }
        long jLongValue = 0;
        for (Long l7 : bVar.f14703f.values()) {
            if (l7 != null) {
                jLongValue += l7.longValue();
            }
        }
        if (jLongValue <= j5 || jLongValue <= 0) {
            j8 = 0;
        } else {
            HashMap map = new HashMap();
            long j10 = 0;
            String key = null;
            for (Map.Entry<String, Long> entry2 : bVar.f14703f.entrySet()) {
                long jMax3 = (long) (((entry2.getValue() == null ? j9 : Math.max(j9, entry2.getValue().longValue())) * j5) / jLongValue);
                map.put(entry2.getKey(), Long.valueOf(jMax3));
                j10 += jMax3;
                key = entry2.getKey();
                j9 = 0;
            }
            if (key != null) {
                long jLongValue2 = ((Long) map.get(key)).longValue() + (j5 - j10);
                j8 = 0;
                map.put(key, Long.valueOf(Math.max(0L, jLongValue2)));
            } else {
                j8 = 0;
            }
            bVar.f14703f = map;
            jLongValue = j5;
        }
        bVar.f14699b = jLongValue > j8 ? Math.min(jLongValue, j5) : Math.min(Math.max(j8, bVar.f14699b), j5);
        bVar.f14705h = null;
        bVar.f14706i = null;
        bVar.f14707j = null;
    }

    public static void g(Context context) {
        if (context == null) {
            return;
        }
        context.getApplicationContext().getSharedPreferences("usage_day_snapshot", 0).edit().clear().apply();
        e.n();
        C0702g.O("UsageDaySnapshotCache", "cleared usage day snapshots after digital wellbeing reset");
    }

    public static void h(Context context) {
        if (context == null) {
            return;
        }
        context.getApplicationContext().getSharedPreferences("usage_day_snapshot", 0).edit().remove("rewind_base_json").apply();
    }

    private static b i(b bVar, int i5, int i6) {
        b bVar2 = new b();
        bVar2.f14698a = bVar.f14698a;
        bVar2.f14699b = bVar.f14699b;
        bVar2.f14700c = bVar.f14700c;
        bVar2.f14701d = i5;
        bVar2.f14702e = i6;
        bVar2.f14703f = bVar.f14703f;
        bVar2.f14705h = bVar.f14705h;
        bVar2.f14706i = bVar.f14706i;
        bVar2.f14707j = bVar.f14707j;
        return bVar2;
    }

    private static String j(long j5) {
        return "day_" + j5;
    }

    private static boolean k(StatsDataSet statsDataSet) {
        if (statsDataSet != null && statsDataSet.getPackageUsingTimeMap() != null) {
            for (Long l5 : statsDataSet.getPackageUsingTimeMap().values()) {
                if (l5 != null && l5.longValue() > 0) {
                    return true;
                }
            }
        }
        return false;
    }

    static boolean l(long[] jArr, long j5) {
        int iCurrentTimeMillis;
        if (jArr == null || jArr.length == 0 || j5 != C0711p.y() || (iCurrentTimeMillis = (int) ((System.currentTimeMillis() - j5) / 3600000)) < 0) {
            return false;
        }
        int i5 = -1;
        long j6 = 0;
        long j7 = 0;
        for (int i6 = 0; i6 < jArr.length; i6++) {
            long jMax = Math.max(0L, jArr[i6]);
            if (jMax > 0 && i5 < 0) {
                i5 = i6;
            }
            if (i6 > iCurrentTimeMillis) {
                j6 += jMax;
            } else {
                j7 += jMax;
            }
        }
        if (i5 <= iCurrentTimeMillis || j6 < 60000) {
            return j6 >= 1800000 && j6 > j7;
        }
        return true;
    }

    private static b m(SharedPreferences sharedPreferences, long j5) {
        b bVarT = t(sharedPreferences.getString(j(j5), null));
        if (bVarT != null && bVarT.f14698a == j5) {
            return bVarT;
        }
        b bVarT2 = t(sharedPreferences.getString("snapshot_json", null));
        if (bVarT2 == null || bVarT2.f14698a != j5) {
            return null;
        }
        return bVarT2;
    }

    private static b n(SharedPreferences sharedPreferences, long j5) {
        b bVarT = t(sharedPreferences.getString("rewind_base_json", null));
        if (bVarT == null || bVarT.f14698a != j5) {
            return null;
        }
        return bVarT;
    }

    private static void o(StatsDataSet statsDataSet, b bVar, W1.c cVar) {
        Map<String, Long> map;
        if (statsDataSet == null || bVar == null || cVar == null || (map = bVar.f14703f) == null || map.isEmpty()) {
            return;
        }
        Map<String, Long> packageUsingTimeMap = statsDataSet.getPackageUsingTimeMap();
        HashMap map2 = packageUsingTimeMap == null ? new HashMap() : new HashMap(packageUsingTimeMap);
        Map<String, Integer> packageNotifyTimesMap = statsDataSet.getPackageNotifyTimesMap();
        HashMap map3 = packageNotifyTimesMap == null ? new HashMap() : new HashMap(packageNotifyTimesMap);
        boolean z5 = false;
        long j5 = 0;
        for (Map.Entry<String, Long> entry : bVar.f14703f.entrySet()) {
            String key = entry.getKey();
            if (!PackageUtils.u(key) && !PackageUtils.q(key)) {
                long jLongValue = entry.getValue() == null ? 0L : entry.getValue().longValue();
                if (jLongValue > 0 && ((Long) C0813a.a(map2, key, 0L)).longValue() <= 0) {
                    map2.put(key, Long.valueOf(jLongValue));
                    j5 += jLongValue;
                    z5 = true;
                }
            }
        }
        Map<String, Integer> map4 = bVar.f14704g;
        if (map4 != null) {
            for (Map.Entry<String, Integer> entry2 : map4.entrySet()) {
                String key2 = entry2.getKey();
                if (!PackageUtils.u(key2) && !PackageUtils.q(key2)) {
                    int iIntValue = entry2.getValue() == null ? 0 : entry2.getValue().intValue();
                    if (iIntValue > 0 && ((Integer) C0813a.a(map3, key2, 0)).intValue() <= 0) {
                        map3.put(key2, Integer.valueOf(iIntValue));
                        z5 = true;
                    }
                }
            }
        }
        if (z5) {
            statsDataSet.setPackageUsingTimeMap(map2);
            statsDataSet.setPackageNotifyTimesMap(map3);
            statsDataSet.setCategoryUsingTimeMap(c(cVar, map2));
            if (j5 > 0) {
                long usingTime = statsDataSet.getUsingTime() + j5;
                statsDataSet.setUsingTime(usingTime);
                C0702g.O("UsageDaySnapshotCache", "merge missing snapshot packages onto live stats added=" + C0711p.t(j5) + " using=" + C0711p.t(usingTime) + " dayStart=" + C0711p.j(statsDataSet.getStartTime()));
            }
            c.i(statsDataSet);
        }
    }

    private static void p(StatsDataSet statsDataSet, b bVar) {
        int i5;
        int iA = A(bVar.f14701d, statsDataSet.getPickupTimes());
        int iA2 = A(bVar.f14702e, statsDataSet.getNotifyTimes());
        if (iA > statsDataSet.getPickupTimes()) {
            statsDataSet.setPickupTimes(iA);
        }
        if (iA2 > statsDataSet.getNotifyTimes()) {
            statsDataSet.setNotifyTimes(iA2);
        }
        StatsDataSet[] children = statsDataSet.getChildren();
        if (children == null || children.length == 0) {
            return;
        }
        int[] iArr = bVar.f14706i;
        if (iArr != null) {
            int iMin = Math.min(children.length, iArr.length);
            int iMax = 0;
            for (int i6 = 0; i6 < iMin; i6++) {
                iMax += Math.max(0, bVar.f14706i[i6]);
            }
            boolean z5 = iMax > statsDataSet.getPickupTimes() + 30 && iMax > 40;
            for (int i7 = 0; i7 < iMin; i7++) {
                StatsDataSet statsDataSet2 = children[i7];
                if (statsDataSet2 != null && bVar.f14706i[i7] > 0 && !z5 && ((statsDataSet2.getPickupTimes() <= 0 || bVar.f14706i[i7] <= children[i7].getPickupTimes()) && bVar.f14706i[i7] > children[i7].getPickupTimes())) {
                    children[i7].setPickupTimes(bVar.f14706i[i7]);
                }
            }
        }
        int[] iArr2 = bVar.f14707j;
        if (iArr2 != null) {
            int iMin2 = Math.min(children.length, iArr2.length);
            for (int i8 = 0; i8 < iMin2; i8++) {
                StatsDataSet statsDataSet3 = children[i8];
                if (statsDataSet3 != null && (i5 = bVar.f14707j[i8]) > 0 && i5 > statsDataSet3.getNotifyTimes()) {
                    children[i8].setNotifyTimes(bVar.f14707j[i8]);
                }
            }
        }
        c.i(statsDataSet);
    }

    private static long q(b bVar) {
        Map<String, Long> map;
        if (bVar == null || (map = bVar.f14703f) == null) {
            return 0L;
        }
        long jMax = 0;
        for (Map.Entry<String, Long> entry : map.entrySet()) {
            if (entry.getValue() != null && !TextUtils.equals(entry.getKey(), "com.android.settings") && !TextUtils.equals(entry.getKey(), "com.stepos.familyguard")) {
                jMax += Math.max(0L, entry.getValue().longValue());
            }
        }
        return jMax;
    }

    private static int r(StatsDataSet statsDataSet) {
        if (statsDataSet == null || statsDataSet.getPackageUsingTimeMap() == null) {
            return 0;
        }
        return statsDataSet.getPackageUsingTimeMap().size();
    }

    private static int s(b bVar) {
        Map<String, Long> map;
        if (bVar == null || (map = bVar.f14703f) == null) {
            return 0;
        }
        return map.size();
    }

    private static b t(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return (b) f14694a.i(str, b.class);
        } catch (Exception e6) {
            C0702g.p("UsageDaySnapshotCache", "load snapshot failed: " + C0702g.o(e6));
            return null;
        }
    }

    private static long u(SharedPreferences sharedPreferences, long j5) {
        b bVarT = t(sharedPreferences.getString("forward_session_json", null));
        if (bVarT == null || bVarT.f14698a != j5) {
            return 0L;
        }
        return Math.max(0L, bVarT.f14699b);
    }

    private static void v(SharedPreferences sharedPreferences, SharedPreferences.Editor editor, long j5, int i5, int i6) {
        editor.putLong("counter_recovery_day", j5);
        d(sharedPreferences, editor, "counter_pickup_", i5);
        d(sharedPreferences, editor, "counter_notify_", i6);
    }

    private static void w(SharedPreferences.Editor editor, SharedPreferences sharedPreferences, long j5) {
        long j6 = j5 - 172800000;
        for (String str : sharedPreferences.getAll().keySet()) {
            if (str.startsWith("day_")) {
                try {
                    if (Long.parseLong(str.substring(4)) < j6) {
                        editor.remove(str);
                    }
                } catch (NumberFormatException unused) {
                    editor.remove(str);
                }
            }
        }
    }

    private static a x(SharedPreferences sharedPreferences, long j5, b bVar, int i5, int i6) {
        a aVar;
        synchronized (f14695b) {
            try {
                boolean z5 = sharedPreferences.getLong("counter_recovery_day", Long.MIN_VALUE) != j5;
                SharedPreferences.Editor editorEdit = sharedPreferences.edit();
                if (z5) {
                    editorEdit.putLong("counter_recovery_day", j5);
                }
                int iY = y(sharedPreferences, editorEdit, "counter_pickup_", i5, bVar.f14701d, z5);
                int iY2 = y(sharedPreferences, editorEdit, "counter_notify_", i6, bVar.f14702e, z5);
                editorEdit.apply();
                if (iY != i5 || iY2 != i6) {
                    C0702g.O("UsageDaySnapshotCache", "recover counter delta after rewind rawPickup=" + i5 + " pickup=" + iY + " rawNotify=" + i6 + " notify=" + iY2 + " dayStart=" + C0711p.j(j5));
                }
                aVar = new a(iY, iY2);
            } catch (Throwable th) {
                throw th;
            }
        }
        return aVar;
    }

    private static int y(SharedPreferences sharedPreferences, SharedPreferences.Editor editor, String str, int i5, int i6, boolean z5) {
        String str2 = str + "raw_base";
        String str3 = str + "total_base";
        String str4 = str + "last_raw";
        String str5 = str + "last_total";
        int i7 = z5 ? i5 : sharedPreferences.getInt(str2, i5);
        int iMax = z5 ? Math.max(i6, i5) : sharedPreferences.getInt(str3, Math.max(i6, i5));
        int i8 = z5 ? i5 : sharedPreferences.getInt(str4, i5);
        int i9 = z5 ? iMax : sharedPreferences.getInt(str5, iMax);
        int iMax2 = Math.max(Math.max(0, i6), Math.max(0, i5));
        if (!z5 && iMax > iMax2 + 30) {
            C0702g.O("UsageDaySnapshotCache", "reset corrupted counter floor prefix=" + str + " totalBase=" + iMax + " snapshot=" + i6 + " raw=" + i5);
            i7 = i5;
            i9 = iMax2;
            iMax = i9;
        }
        if (!z5 && i5 < i8) {
            iMax = Math.max(i6, Math.min(i9, iMax2 + 30));
            i7 = i5;
        }
        int iMax3 = Math.max(i6, Math.max(0, i5 - i7) + iMax);
        int i10 = iMax2 + 30;
        if (iMax3 > i10) {
            C0702g.O("UsageDaySnapshotCache", "clamp inflated counter prefix=" + str + " recovered=" + iMax3 + " cap=" + i10 + " snapshot=" + i6 + " raw=" + i5);
            iMax = Math.max(i6, i5);
            i7 = i5;
            iMax3 = i10;
        }
        editor.putInt(str2, i7).putInt(str3, iMax).putInt(str4, i5).putInt(str5, iMax3);
        return iMax3;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01bd  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x020b  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x021a  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0249  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.stepos.digitalwellbeing.server.data.StatsDataSet z(android.content.Context r31, long r32, com.stepos.digitalwellbeing.server.data.StatsDataSet r34, W1.c r35) {
        /*
            Method dump skipped, instructions count: 1140
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.digitalwellbeing.server.transaction.usagstats.alphame.t.z(android.content.Context, long, com.stepos.digitalwellbeing.server.data.StatsDataSet, W1.c):com.stepos.digitalwellbeing.server.data.StatsDataSet");
    }
}
