package com.stepos.digitalwellbeing.server.transaction.usagstats.alphame;

import android.content.Context;
import android.provider.Settings;
import android.text.TextUtils;
import com.stepos.digitalwellbeing.server.data.StatsDataSet;
import com.stepos.digitalwellbeing.utils.PackageUtils;
import f2.C0697b;
import f2.C0702g;
import f2.C0711p;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import k3.C0813a;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    private static final Object f14657a = new Object();

    /* renamed from: b, reason: collision with root package name */
    private static final a f14658b = new a();

    private static final class a {

        /* renamed from: a, reason: collision with root package name */
        long f14659a;

        /* renamed from: b, reason: collision with root package name */
        int f14660b;

        /* renamed from: c, reason: collision with root package name */
        StatsDataSet[] f14661c;

        /* renamed from: d, reason: collision with root package name */
        StatsDataSet f14662d;

        /* renamed from: e, reason: collision with root package name */
        int f14663e;

        /* renamed from: f, reason: collision with root package name */
        int f14664f;

        /* renamed from: g, reason: collision with root package name */
        long f14665g;

        /* renamed from: h, reason: collision with root package name */
        long f14666h;

        private a() {
            this.f14659a = Long.MIN_VALUE;
            this.f14660b = -1;
            this.f14663e = -1;
            this.f14664f = -1;
        }
    }

    private static boolean A(StatsDataSet statsDataSet, long j5) {
        if (statsDataSet != null && j5 >= 3600000) {
            if (PackageUtils.t(j5, statsDataSet.getLongestUseTime(), statsDataSet.getStartTime())) {
                return true;
            }
            if (!C0697b.s(y(statsDataSet.getChildren()))) {
                return false;
            }
            long jMax = Math.max(statsDataSet.getUsingTime(), J(statsDataSet));
            if (jMax > 0 && j5 * 10 >= jMax * 8) {
                return true;
            }
        }
        return false;
    }

    private static boolean B(StatsDataSet statsDataSet, StatsDataSet statsDataSet2) {
        if (statsDataSet != null && x(statsDataSet)) {
            if (C(statsDataSet)) {
                return true;
            }
            long usingTime = statsDataSet.getUsingTime();
            long usingTime2 = statsDataSet2 == null ? 0L : statsDataSet2.getUsingTime();
            if (usingTime2 >= 120000 && x(statsDataSet2) && usingTime > 3600000 + usingTime2 && usingTime > usingTime2 * 3) {
                return true;
            }
        }
        return false;
    }

    static boolean C(StatsDataSet statsDataSet) {
        if (statsDataSet == null) {
            return false;
        }
        return C0697b.s(y(statsDataSet.getChildren()));
    }

    static boolean D(long j5, long j6) {
        if (j5 > 0 && j6 > 0) {
            long jE = C0697b.e();
            if (jE > 0 && jE != Long.MAX_VALUE) {
                boolean z5 = Math.abs(j5 - jE) <= 60000;
                boolean z6 = j6 >= jE - 60000;
                if (z5 && z6) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean E(Context context) {
        return Settings.Secure.getInt(context.getContentResolver(), "minors_mode_enabled", 0) == 1 && Settings.Secure.getLong(context.getContentResolver(), "active_minor_id", -1L) > 0;
    }

    private static StatsDataSet F(StatsDataSet statsDataSet, StatsDataSet statsDataSet2) {
        StatsDataSet statsDataSetO = o(statsDataSet);
        if (statsDataSetO != null && statsDataSet2 != null) {
            statsDataSetO.setUsingTime(Math.max(0L, statsDataSetO.getUsingTime()) + Math.max(0L, statsDataSet2.getUsingTime()));
            if (statsDataSetO.getPackageUsingTimeMap() == null) {
                statsDataSetO.setPackageUsingTimeMap(new HashMap());
            }
            if (statsDataSetO.getCategoryUsingTimeMap() == null) {
                statsDataSetO.setCategoryUsingTimeMap(new HashMap());
            }
            c(statsDataSetO.getPackageUsingTimeMap(), statsDataSet2.getPackageUsingTimeMap());
            c(statsDataSetO.getCategoryUsingTimeMap(), statsDataSet2.getCategoryUsingTimeMap());
        }
        return statsDataSetO;
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x009e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static void G(com.stepos.digitalwellbeing.server.data.StatsDataSet r21, com.stepos.digitalwellbeing.server.data.StatsDataSet r22, W1.c r23) {
        /*
            Method dump skipped, instructions count: 345
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.digitalwellbeing.server.transaction.usagstats.alphame.e.G(com.stepos.digitalwellbeing.server.data.StatsDataSet, com.stepos.digitalwellbeing.server.data.StatsDataSet, W1.c):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00d1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static boolean H(android.content.Context r32, W1.c r33, com.stepos.digitalwellbeing.server.data.StatsDataSet r34) {
        /*
            Method dump skipped, instructions count: 474
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.digitalwellbeing.server.transaction.usagstats.alphame.e.H(android.content.Context, W1.c, com.stepos.digitalwellbeing.server.data.StatsDataSet):boolean");
    }

    public static void I(Context context, W1.c cVar, StatsDataSet[] statsDataSetArr, long j5) throws Throwable {
        int iY;
        if (context == null || cVar == null || statsDataSetArr == null || E(context) || c.q() || C0697b.n() || (iY = (int) ((C0711p.y() - j5) / 86400000)) < 0 || iY >= statsDataSetArr.length) {
            return;
        }
        StatsDataSet statsDataSet = statsDataSetArr[iY];
        long usingTime = statsDataSet == null ? 0L : statsDataSet.getUsingTime();
        StatsDataSet statsDataSetD = s.d(context, cVar);
        boolean z5 = usingTime < 900000 && statsDataSetD != null && statsDataSetD.getUsingTime() > 300000 + usingTime && x(statsDataSetD);
        if (statsDataSet == null || usingTime <= 0 || !x(statsDataSet) || z5) {
            if (statsDataSetD != null && statsDataSetD.getUsingTime() > usingTime) {
                C0702g.O("ClockJumpUsageRecovery", "replace lagging multi_daily today with today_simple using=" + C0711p.t(statsDataSetD.getUsingTime()) + " multi_daily=" + C0711p.t(usingTime));
                statsDataSetArr[iY] = statsDataSetD;
                statsDataSet = statsDataSetD;
            }
        } else if (s.f(context, cVar, statsDataSet)) {
            s.c(context, cVar, statsDataSet);
            e(statsDataSet, cVar);
            j.j(context, cVar, statsDataSet);
            c.i(statsDataSet);
            statsDataSetArr[iY] = statsDataSet;
            C0702g.O("ClockJumpUsageRecovery", "merged today_simple into multi_daily using=" + C0711p.t(statsDataSet.getUsingTime()));
        }
        if (statsDataSet != null && H(context, cVar, statsDataSet)) {
            statsDataSetArr[iY] = statsDataSet;
        }
        L(statsDataSet);
    }

    private static long J(StatsDataSet statsDataSet) {
        Map<String, Long> packageUsingTimeMap = statsDataSet.getPackageUsingTimeMap();
        long jLongValue = 0;
        if (packageUsingTimeMap != null && !packageUsingTimeMap.isEmpty()) {
            for (Long l5 : packageUsingTimeMap.values()) {
                if (l5 != null) {
                    jLongValue += l5.longValue();
                }
            }
        }
        return jLongValue;
    }

    private static void K(StatsDataSet statsDataSet) {
        StatsDataSet statsDataSet2;
        StatsDataSet statsDataSet3;
        if (statsDataSet == null || statsDataSet.getStartTime() != C0711p.y()) {
            return;
        }
        if (C0697b.q() || C0697b.n()) {
            n();
            return;
        }
        StatsDataSet[] children = statsDataSet.getChildren();
        if (children == null || children.length == 0) {
            return;
        }
        long startTime = statsDataSet.getStartTime();
        int iCurrentTimeMillis = (int) ((System.currentTimeMillis() - startTime) / 3600000);
        if (iCurrentTimeMillis < 0) {
            return;
        }
        synchronized (f14657a) {
            try {
                a aVar = f14658b;
                StatsDataSet[] statsDataSetArr = aVar.f14661c;
                if (aVar.f14659a != startTime || statsDataSetArr == null || statsDataSetArr.length != children.length) {
                    aVar.f14659a = startTime;
                    aVar.f14660b = -1;
                    statsDataSetArr = new StatsDataSet[children.length];
                    aVar.f14661c = statsDataSetArr;
                    aVar.f14662d = null;
                    aVar.f14663e = -1;
                    aVar.f14664f = -1;
                    aVar.f14665g = 0L;
                    aVar.f14666h = 0L;
                }
                int i5 = aVar.f14660b;
                if (i5 >= 0 && iCurrentTimeMillis < i5) {
                    for (int iMax = Math.max(0, iCurrentTimeMillis); iMax < statsDataSetArr.length; iMax++) {
                        statsDataSetArr[iMax] = null;
                    }
                    a aVar2 = f14658b;
                    aVar2.f14662d = null;
                    aVar2.f14663e = -1;
                    aVar2.f14664f = -1;
                    aVar2.f14665g = 0L;
                    aVar2.f14666h = 0L;
                }
                a aVar3 = f14658b;
                int i6 = aVar3.f14660b;
                if (i6 >= 0 && iCurrentTimeMillis > i6 && (statsDataSet2 = aVar3.f14662d) != null) {
                    int i7 = aVar3.f14663e;
                    if (i7 >= 0 && i7 < statsDataSetArr.length && (statsDataSet3 = statsDataSetArr[i7]) != null) {
                        statsDataSetArr[i7] = F(statsDataSet3, statsDataSet2);
                    }
                    aVar3.f14662d = null;
                    aVar3.f14663e = -1;
                    aVar3.f14664f = -1;
                    aVar3.f14665g = 0L;
                    aVar3.f14666h = 0L;
                }
                aVar3.f14660b = iCurrentTimeMillis;
                int iMin = Math.min(children.length, statsDataSetArr.length);
                for (int i8 = 0; i8 < iMin; i8++) {
                    if (i8 < iCurrentTimeMillis) {
                        StatsDataSet statsDataSet4 = statsDataSetArr[i8];
                        if (statsDataSet4 != null) {
                            children[i8] = o(statsDataSet4);
                        } else if (w(children[i8])) {
                            statsDataSetArr[i8] = o(children[i8]);
                        }
                    } else if (i8 == iCurrentTimeMillis && w(children[i8])) {
                        statsDataSetArr[i8] = o(children[i8]);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    static void L(StatsDataSet statsDataSet) {
        N(statsDataSet);
        M(statsDataSet);
    }

    static void M(StatsDataSet statsDataSet) {
        StatsDataSet[] children;
        if (statsDataSet == null || (children = statsDataSet.getChildren()) == null || children.length == 0) {
            return;
        }
        Z(statsDataSet, children, true);
        Z(statsDataSet, children, false);
    }

    static void N(StatsDataSet statsDataSet) {
        StatsDataSet[] children;
        if (statsDataSet == null || (children = statsDataSet.getChildren()) == null || children.length == 0) {
            return;
        }
        K(statsDataSet);
        long jMax = Math.max(0L, statsDataSet.getUsingTime());
        long jMax2 = 0;
        for (StatsDataSet statsDataSet2 : children) {
            if (statsDataSet2 != null) {
                jMax2 += Math.max(0L, statsDataSet2.getUsingTime());
            }
        }
        if (jMax2 == jMax) {
            f(statsDataSet);
            k(statsDataSet);
            return;
        }
        if (jMax <= 0) {
            k(statsDataSet);
            return;
        }
        boolean z5 = statsDataSet.getStartTime() == C0711p.y();
        if (jMax2 <= 0) {
            if (!z5) {
                C0702g.O("ClockJumpUsageRecovery", "skip empty-hour backfill on historic day date=" + C0711p.j(statsDataSet.getStartTime()));
                k(statsDataSet);
                return;
            }
            t.a(statsDataSet, jMax);
            C0702g.O("ClockJumpUsageRecovery", "align empty hours to day using=" + C0711p.t(jMax));
            f(statsDataSet);
            k(statsDataSet);
            return;
        }
        if (jMax2 > jMax) {
            T(children, jMax2, jMax);
            C0702g.O("ClockJumpUsageRecovery", "scale hour usingTime from " + C0711p.t(jMax2) + " to day " + C0711p.t(jMax) + " date=" + C0711p.j(statsDataSet.getStartTime()));
            f(statsDataSet);
            k(statsDataSet);
            return;
        }
        if (!z5) {
            C0702g.O("ClockJumpUsageRecovery", "skip hour backfill on historic day hourSum=" + C0711p.t(jMax2) + " day=" + C0711p.t(jMax) + " date=" + C0711p.j(statsDataSet.getStartTime()));
            k(statsDataSet);
            return;
        }
        long j5 = jMax - jMax2;
        t.a(statsDataSet, j5);
        C0702g.O("ClockJumpUsageRecovery", "add hour usingTime gap=" + C0711p.t(j5) + " hourSum was=" + C0711p.t(jMax2) + " day=" + C0711p.t(jMax));
        f(statsDataSet);
        k(statsDataSet);
    }

    public static StatsDataSet O(Context context, W1.c cVar, StatsDataSet statsDataSet, long j5) {
        if (context == null || cVar == null || E(context) || c.k() > j5) {
            return statsDataSet;
        }
        StatsDataSet statsDataSetZ = t.z(context, j5, statsDataSet, cVar);
        if (statsDataSetZ != statsDataSet) {
            StringBuilder sb = new StringBuilder();
            sb.append("restore previous-day snapshot on forward jump dayStart=");
            sb.append(C0711p.j(j5));
            sb.append(" recovered=");
            sb.append(C0711p.t(statsDataSetZ.getUsingTime()));
            sb.append(" raw=");
            sb.append(C0711p.t(statsDataSet == null ? 0L : statsDataSet.getUsingTime()));
            C0702g.O("ClockJumpUsageRecovery", sb.toString());
            M(statsDataSetZ);
            c.i(statsDataSetZ);
        }
        R(statsDataSetZ, cVar);
        e(statsDataSetZ, cVar);
        j.j(context, cVar, statsDataSetZ);
        L(statsDataSetZ);
        if (C0697b.r() && j5 == C0711p.y() - 86400000 && statsDataSetZ == statsDataSet) {
            t.B(context, statsDataSetZ);
        }
        return statsDataSetZ;
    }

    public static StatsDataSet P(Context context, W1.c cVar, StatsDataSet statsDataSet, long j5, boolean z5) throws Throwable {
        if (context == null || cVar == null) {
            return statsDataSet;
        }
        if (E(context)) {
            StringBuilder sb = new StringBuilder();
            sb.append("skip adult snapshot restore in minors mode using=");
            sb.append(C0711p.t(statsDataSet != null ? statsDataSet.getUsingTime() : 0L));
            C0702g.O("ClockJumpUsageRecovery", sb.toString());
            v(statsDataSet, cVar);
            c.i(statsDataSet);
            return statsDataSet;
        }
        if (c.q()) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("skip clock-jump restore after user closed digital wellbeing using=");
            sb2.append(C0711p.t(statsDataSet != null ? statsDataSet.getUsingTime() : 0L));
            C0702g.O("ClockJumpUsageRecovery", sb2.toString());
            v(statsDataSet, cVar);
            j.j(context, cVar, statsDataSet);
            c.i(statsDataSet);
            return statsDataSet;
        }
        if (W(statsDataSet, z5)) {
            StatsDataSet statsDataSetD = s.d(context, cVar);
            long usingTime = statsDataSet == null ? 0L : statsDataSet.getUsingTime();
            if (B(statsDataSetD, statsDataSet)) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("reject phantom today_simple fallback using=");
                sb3.append(C0711p.t(statsDataSetD != null ? statsDataSetD.getUsingTime() : 0L));
                sb3.append(" keep multi_daily=");
                sb3.append(C0711p.t(usingTime));
                C0702g.O("ClockJumpUsageRecovery", sb3.toString());
            } else if (statsDataSetD != null && statsDataSetD.getUsingTime() > 300000 + usingTime && x(statsDataSetD)) {
                C0702g.O("ClockJumpUsageRecovery", "use today_simple fallback using=" + C0711p.t(statsDataSetD.getUsingTime()) + " instead of multi_daily=" + C0711p.t(usingTime));
                statsDataSet = statsDataSetD;
            }
        }
        StatsDataSet statsDataSetZ = t.z(context, j5, statsDataSet, cVar);
        t.b(context, statsDataSetZ, cVar);
        if (statsDataSetZ != null && C0697b.n()) {
            s.c(context, cVar, statsDataSetZ);
            R(statsDataSetZ, cVar);
            j(statsDataSetZ, cVar);
        }
        v(statsDataSetZ, cVar);
        M(statsDataSetZ);
        c.i(statsDataSetZ);
        if (statsDataSetZ != null && C0697b.r() && statsDataSetZ.getStartTime() == j5) {
            t.h(context);
        }
        if (statsDataSetZ != null && C0697b.p()) {
            t.e(context, statsDataSetZ);
        }
        j.j(context, cVar, statsDataSetZ);
        c.i(statsDataSetZ);
        if (statsDataSetZ != null && statsDataSetZ.getUsingTime() >= 120000 && x(statsDataSetZ) && !C(statsDataSetZ)) {
            t.B(context, statsDataSetZ);
        } else if (statsDataSetZ != null && C(statsDataSetZ)) {
            C0702g.O("ClockJumpUsageRecovery", "skip saving saturated phantom snapshot using=" + C0711p.t(statsDataSetZ.getUsingTime()));
        }
        if (statsDataSetZ != null && C0697b.n()) {
            G(statsDataSetZ, statsDataSet, cVar);
            s.f(context, cVar, statsDataSetZ);
            e(statsDataSetZ, cVar);
            j.j(context, cVar, statsDataSetZ);
            c.i(statsDataSetZ);
        }
        L(statsDataSetZ);
        if (statsDataSetZ != null && C0697b.r() && statsDataSetZ.getStartTime() == j5) {
            t.C(context, statsDataSetZ);
        }
        return statsDataSetZ;
    }

    static long Q(long j5) {
        if (!C0697b.p() || !C0697b.q()) {
            return Long.MAX_VALUE;
        }
        long jE = C0697b.e();
        if (jE < 0 || jE == Long.MAX_VALUE) {
            jE = 0;
        }
        return Math.max(0L, j5) + jE;
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0121  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static void R(com.stepos.digitalwellbeing.server.data.StatsDataSet r21, W1.c r22) {
        /*
            Method dump skipped, instructions count: 348
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.digitalwellbeing.server.transaction.usagstats.alphame.e.R(com.stepos.digitalwellbeing.server.data.StatsDataSet, W1.c):void");
    }

    private static long[] S(final long[] jArr, long j5, long j6) {
        int length = jArr == null ? 0 : jArr.length;
        long[] jArr2 = new long[length];
        if (length != 0 && j5 > 0 && j6 >= 0 && j6 != 0) {
            final long[] jArr3 = new long[length];
            long j7 = 0;
            for (int i5 = 0; i5 < length; i5++) {
                long jMax = Math.max(0L, jArr[i5]);
                if (jMax > 0) {
                    long j8 = jMax * j6;
                    jArr2[i5] = j8 / j5;
                    jArr3[i5] = j8 % j5;
                    j7 += jArr2[i5];
                }
            }
            long j9 = j6 - j7;
            if (j9 > 0) {
                Integer[] numArr = new Integer[length];
                for (int i6 = 0; i6 < length; i6++) {
                    numArr[i6] = Integer.valueOf(i6);
                }
                Arrays.sort(numArr, new Comparator() { // from class: com.stepos.digitalwellbeing.server.transaction.usagstats.alphame.d
                    @Override // java.util.Comparator
                    public final int compare(Object obj, Object obj2) {
                        return e.a(jArr3, jArr, (Integer) obj, (Integer) obj2);
                    }
                });
                for (int i7 = 0; j9 > 0 && i7 < length; i7++) {
                    int iIntValue = numArr[i7].intValue();
                    if (jArr[iIntValue] > 0) {
                        jArr2[iIntValue] = jArr2[iIntValue] + 1;
                        j9--;
                    }
                }
            }
        }
        return jArr2;
    }

    private static void T(StatsDataSet[] statsDataSetArr, long j5, long j6) {
        if (statsDataSetArr == null || j5 <= 0 || j6 < 0) {
            return;
        }
        long j7 = j5 - j6;
        if (j7 <= 0) {
            return;
        }
        int iR = r(statsDataSetArr);
        if (iR >= 0 && iR < statsDataSetArr.length) {
            StatsDataSet statsDataSet = statsDataSetArr[iR];
            if (statsDataSet != null) {
                long jMax = Math.max(0L, Math.max(0L, statsDataSet.getUsingTime()) - j7);
                U(statsDataSet.getPackageUsingTimeMap(), jMax);
                U(statsDataSet.getCategoryUsingTimeMap(), jMax);
                statsDataSet.setUsingTime(jMax);
                return;
            }
            return;
        }
        int length = statsDataSetArr.length;
        long[] jArr = new long[length];
        for (int i5 = 0; i5 < length; i5++) {
            StatsDataSet statsDataSet2 = statsDataSetArr[i5];
            if (statsDataSet2 != null) {
                jArr[i5] = Math.max(0L, statsDataSet2.getUsingTime());
            }
        }
        long[] jArrS = S(jArr, j5, j6);
        for (int i6 = 0; i6 < length; i6++) {
            StatsDataSet statsDataSet3 = statsDataSetArr[i6];
            if (statsDataSet3 != null) {
                long j8 = jArrS[i6];
                U(statsDataSet3.getPackageUsingTimeMap(), j8);
                U(statsDataSet3.getCategoryUsingTimeMap(), j8);
                statsDataSet3.setUsingTime(j8);
            }
        }
    }

    private static void U(Map<String, Long> map, long j5) {
        if (map == null || map.isEmpty()) {
            return;
        }
        if (j5 <= 0) {
            map.clear();
            return;
        }
        ArrayList arrayList = new ArrayList(map.keySet());
        int size = arrayList.size();
        long[] jArr = new long[size];
        long j6 = 0;
        for (int i5 = 0; i5 < size; i5++) {
            Long l5 = map.get(arrayList.get(i5));
            long jMax = l5 == null ? 0L : Math.max(0L, l5.longValue());
            jArr[i5] = jMax;
            j6 += jMax;
        }
        if (j6 > 0 && j6 != j5) {
            long[] jArrS = S(jArr, j6, j5);
            for (int i6 = 0; i6 < size; i6++) {
                map.put((String) arrayList.get(i6), Long.valueOf(jArrS[i6]));
            }
        }
    }

    private static long V(StatsDataSet statsDataSet) {
        long jLongValue = 0;
        long jLongValue2 = ((Long) C0813a.a(statsDataSet.getPackageUsingTimeMap(), "com.android.settings", 0L)).longValue();
        if (jLongValue2 > 0) {
            return jLongValue2;
        }
        StatsDataSet[] children = statsDataSet.getChildren();
        if (children == null) {
            return 0L;
        }
        for (StatsDataSet statsDataSet2 : children) {
            if (statsDataSet2 != null) {
                jLongValue += ((Long) C0813a.a(statsDataSet2.getPackageUsingTimeMap(), "com.android.settings", 0L)).longValue();
            }
        }
        return jLongValue;
    }

    private static boolean W(StatsDataSet statsDataSet, boolean z5) {
        if (C0697b.n() && C0697b.l()) {
            return !z5 || statsDataSet == null || statsDataSet.getUsingTime() < 3600000 || !x(statsDataSet);
        }
        return false;
    }

    private static void X(StatsDataSet statsDataSet, String str) {
        i(statsDataSet, str, 0L, null);
    }

    private static int Y(StatsDataSet[] statsDataSetArr, boolean z5) {
        int pickupTimes = 0;
        for (StatsDataSet statsDataSet : statsDataSetArr) {
            if (statsDataSet != null) {
                pickupTimes += z5 ? statsDataSet.getPickupTimes() : statsDataSet.getNotifyTimes();
            }
        }
        return pickupTimes;
    }

    private static void Z(StatsDataSet statsDataSet, StatsDataSet[] statsDataSetArr, boolean z5) {
        int pickupTimes = z5 ? statsDataSet.getPickupTimes() : statsDataSet.getNotifyTimes();
        int iY = Y(statsDataSetArr, z5);
        if (C0697b.r()) {
            if (z5) {
                statsDataSet.setPickupTimes(iY);
            } else {
                statsDataSet.setNotifyTimes(iY);
            }
            if (pickupTimes != iY) {
                StringBuilder sb = new StringBuilder();
                sb.append("reset forward-jump day ");
                sb.append(z5 ? "pickup" : "notify");
                sb.append(" to hourSum=");
                sb.append(iY);
                sb.append(" (was ");
                sb.append(pickupTimes);
                sb.append(")");
                C0702g.O("ClockJumpUsageRecovery", sb.toString());
                return;
            }
            return;
        }
        if (pickupTimes == iY) {
            return;
        }
        if (iY > pickupTimes) {
            if (statsDataSet.getStartTime() == C0711p.y() && !C0697b.n() && z5 && pickupTimes > 1) {
                int i5 = iY - pickupTimes;
                C0702g.O("ClockJumpUsageRecovery", "trim today pickup excess=" + i5 + " trimmed=" + a0(statsDataSet, statsDataSetArr, i5, true) + " keep day=" + pickupTimes);
                return;
            }
            if (z5) {
                statsDataSet.setPickupTimes(iY);
            } else {
                statsDataSet.setNotifyTimes(iY);
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("align day ");
            sb2.append(z5 ? "pickup" : "notify");
            sb2.append(" to hourSum=");
            sb2.append(iY);
            sb2.append(" (was ");
            sb2.append(pickupTimes);
            sb2.append(")");
            C0702g.O("ClockJumpUsageRecovery", sb2.toString());
            return;
        }
        if (iY <= 0 || pickupTimes <= iY) {
            if (pickupTimes > 0) {
                u(statsDataSetArr, pickupTimes, z5);
                StringBuilder sb3 = new StringBuilder();
                sb3.append("backfill hour ");
                sb3.append(z5 ? "pickup" : "notify");
                sb3.append(" from day total=");
                sb3.append(pickupTimes);
                sb3.append(" (hourSum was ");
                sb3.append(iY);
                sb3.append(")");
                C0702g.O("ClockJumpUsageRecovery", sb3.toString());
                return;
            }
            return;
        }
        if ((statsDataSet.getStartTime() != C0711p.y() || C0697b.n()) && pickupTimes > iY + 30 && pickupTimes > 40) {
            StringBuilder sb4 = new StringBuilder();
            sb4.append("reject inflated day ");
            sb4.append(z5 ? "pickup" : "notify");
            sb4.append("=");
            sb4.append(pickupTimes);
            sb4.append(" keep hourSum=");
            sb4.append(iY);
            C0702g.O("ClockJumpUsageRecovery", sb4.toString());
            if (z5) {
                statsDataSet.setPickupTimes(iY);
                return;
            } else {
                statsDataSet.setNotifyTimes(iY);
                return;
            }
        }
        int i6 = pickupTimes - iY;
        b(statsDataSet, statsDataSetArr, i6, z5);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("backfill hour ");
        sb5.append(z5 ? "pickup" : "notify");
        sb5.append(" gap=");
        sb5.append(i6);
        sb5.append(" hourSum was=");
        sb5.append(iY);
        sb5.append(" day=");
        sb5.append(pickupTimes);
        C0702g.O("ClockJumpUsageRecovery", sb5.toString());
    }

    public static /* synthetic */ int a(long[] jArr, long[] jArr2, Integer num, Integer num2) {
        int iCompare = Long.compare(jArr[num2.intValue()], jArr[num.intValue()]);
        if (iCompare != 0) {
            return iCompare;
        }
        int iCompare2 = Long.compare(jArr2[num2.intValue()], jArr2[num.intValue()]);
        return iCompare2 != 0 ? iCompare2 : Integer.compare(num.intValue(), num2.intValue());
    }

    private static int a0(StatsDataSet statsDataSet, StatsDataSet[] statsDataSetArr, int i5, boolean z5) {
        StatsDataSet statsDataSet2;
        if (i5 > 0 && statsDataSetArr != null && statsDataSetArr.length != 0) {
            int iCurrentTimeMillis = statsDataSet.getStartTime() == C0711p.y() ? (int) ((System.currentTimeMillis() - C0711p.y()) / 3600000) : -1;
            if (iCurrentTimeMillis >= 0 && iCurrentTimeMillis < statsDataSetArr.length && (statsDataSet2 = statsDataSetArr[iCurrentTimeMillis]) != null) {
                int pickupTimes = z5 ? statsDataSet2.getPickupTimes() : statsDataSet2.getNotifyTimes();
                int iMin = Math.min(i5, Math.max(0, pickupTimes));
                if (z5) {
                    statsDataSet2.setPickupTimes(pickupTimes - iMin);
                    return iMin;
                }
                statsDataSet2.setNotifyTimes(pickupTimes - iMin);
                return iMin;
            }
        }
        return 0;
    }

    private static void b(StatsDataSet statsDataSet, StatsDataSet[] statsDataSetArr, int i5, boolean z5) {
        StatsDataSet statsDataSet2;
        if (i5 <= 0 || statsDataSetArr == null || statsDataSetArr.length == 0) {
            return;
        }
        int i6 = -1;
        int iCurrentTimeMillis = statsDataSet.getStartTime() == C0711p.y() ? (int) ((System.currentTimeMillis() - C0711p.y()) / 3600000) : -1;
        if (iCurrentTimeMillis < 0 || iCurrentTimeMillis >= statsDataSetArr.length || statsDataSetArr[iCurrentTimeMillis] == null) {
            iCurrentTimeMillis = statsDataSetArr.length - 1;
            while (true) {
                if (iCurrentTimeMillis < 0) {
                    iCurrentTimeMillis = i6;
                    break;
                }
                StatsDataSet statsDataSet3 = statsDataSetArr[iCurrentTimeMillis];
                if (statsDataSet3 != null) {
                    if (statsDataSet3.getUsingTime() > 0 || statsDataSetArr[iCurrentTimeMillis].getNotifyTimes() > 0 || statsDataSetArr[iCurrentTimeMillis].getPickupTimes() > 0) {
                        break;
                    } else {
                        i6 = iCurrentTimeMillis;
                    }
                }
                iCurrentTimeMillis--;
            }
        }
        if (iCurrentTimeMillis < 0 || (statsDataSet2 = statsDataSetArr[iCurrentTimeMillis]) == null) {
            return;
        }
        if (z5) {
            statsDataSet2.setPickupTimes(statsDataSet2.getPickupTimes() + i5);
        } else {
            statsDataSet2.setNotifyTimes(statsDataSet2.getNotifyTimes() + i5);
        }
    }

    private static void c(Map<String, Long> map, Map<String, Long> map2) {
        if (map == null || map2 == null || map2.isEmpty()) {
            return;
        }
        for (Map.Entry<String, Long> entry : map2.entrySet()) {
            long jMax = entry.getValue() == null ? 0L : Math.max(0L, entry.getValue().longValue());
            if (jMax > 0) {
                Long l5 = map.get(entry.getKey());
                map.put(entry.getKey(), Long.valueOf((l5 != null ? Math.max(0L, l5.longValue()) : 0L) + jMax));
            }
        }
    }

    private static void d(StatsDataSet statsDataSet, String str, long j5, W1.c cVar) {
        StatsDataSet[] children;
        int iCurrentTimeMillis;
        StatsDataSet statsDataSet2;
        if (statsDataSet == null || j5 <= 0 || TextUtils.isEmpty(str) || (children = statsDataSet.getChildren()) == null || children.length == 0 || (iCurrentTimeMillis = (int) ((System.currentTimeMillis() - statsDataSet.getStartTime()) / 3600000)) < 0 || iCurrentTimeMillis >= children.length || (statsDataSet2 = children[iCurrentTimeMillis]) == null) {
            return;
        }
        Map<String, Long> packageUsingTimeMap = statsDataSet2.getPackageUsingTimeMap();
        HashMap map = packageUsingTimeMap == null ? new HashMap() : new HashMap(packageUsingTimeMap);
        map.put(str, Long.valueOf(((Long) C0813a.a(map, str, 0L)).longValue() + j5));
        statsDataSet2.setPackageUsingTimeMap(map);
        statsDataSet2.setUsingTime(statsDataSet2.getUsingTime() + j5);
        if (cVar != null) {
            statsDataSet2.setCategoryUsingTimeMap(s.e(cVar, map));
        }
    }

    private static void e(StatsDataSet statsDataSet, W1.c cVar) {
        if (statsDataSet == null || statsDataSet.getPackageUsingTimeMap() == null) {
            return;
        }
        long J5 = J(statsDataSet);
        if (J5 <= 0) {
            return;
        }
        statsDataSet.setUsingTime(J5);
        if (cVar != null) {
            statsDataSet.setCategoryUsingTimeMap(s.e(cVar, statsDataSet.getPackageUsingTimeMap()));
        }
    }

    private static void f(StatsDataSet statsDataSet) {
        StatsDataSet[] children;
        a aVar;
        long jMin;
        if (statsDataSet == null || statsDataSet.getStartTime() != C0711p.y() || C0697b.q() || C0697b.n() || (children = statsDataSet.getChildren()) == null || children.length == 0) {
            return;
        }
        long startTime = statsDataSet.getStartTime();
        long j5 = 3600000;
        int iCurrentTimeMillis = (int) ((System.currentTimeMillis() - startTime) / 3600000);
        if (iCurrentTimeMillis <= 0 || iCurrentTimeMillis >= children.length || children[iCurrentTimeMillis] == null) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis() - (startTime + (iCurrentTimeMillis * 3600000));
        if (jCurrentTimeMillis < 0) {
            j5 = 0;
        } else if (jCurrentTimeMillis <= 3600000) {
            j5 = jCurrentTimeMillis;
        }
        StatsDataSet statsDataSet2 = children[iCurrentTimeMillis];
        long jMax = Math.max(0L, statsDataSet2.getUsingTime());
        Object obj = f14657a;
        synchronized (obj) {
            try {
                aVar = f14658b;
                if (aVar.f14664f != iCurrentTimeMillis || jMax < aVar.f14666h) {
                    aVar.f14665g = Math.max(0L, jMax - j5);
                } else {
                    long j6 = jMax - j5;
                    if (j6 > aVar.f14665g) {
                        aVar.f14665g = j6;
                    }
                }
                aVar.f14664f = iCurrentTimeMillis;
                aVar.f14666h = jMax;
                jMin = Math.min(jMax, Math.max(0L, aVar.f14665g));
            } finally {
            }
        }
        if (jMin > 0) {
            int i5 = iCurrentTimeMillis - 1;
            if (children[i5] != null) {
                long j7 = jMax - jMin;
                Map<String, Long> mapQ = q(statsDataSet2.getPackageUsingTimeMap());
                Map<String, Long> mapQ2 = q(statsDataSet2.getCategoryUsingTimeMap());
                U(statsDataSet2.getPackageUsingTimeMap(), j7);
                U(statsDataSet2.getCategoryUsingTimeMap(), j7);
                statsDataSet2.setUsingTime(j7);
                Map<String, Long> mapT = t(mapQ, statsDataSet2.getPackageUsingTimeMap());
                Map<String, Long> mapT2 = t(mapQ2, statsDataSet2.getCategoryUsingTimeMap());
                StatsDataSet statsDataSetO = o(children[i5]);
                statsDataSetO.setUsingTime(Math.max(0L, statsDataSetO.getUsingTime()) + jMin);
                if (statsDataSetO.getPackageUsingTimeMap() == null) {
                    statsDataSetO.setPackageUsingTimeMap(new HashMap());
                }
                if (statsDataSetO.getCategoryUsingTimeMap() == null) {
                    statsDataSetO.setCategoryUsingTimeMap(new HashMap());
                }
                c(statsDataSetO.getPackageUsingTimeMap(), mapT);
                c(statsDataSetO.getCategoryUsingTimeMap(), mapT2);
                children[i5] = statsDataSetO;
                StatsDataSet statsDataSetO2 = o(statsDataSet2);
                statsDataSetO2.setUsingTime(jMin);
                statsDataSetO2.setStartTime(statsDataSetO.getStartTime());
                statsDataSetO2.setPackageUsingTimeMap(mapT);
                statsDataSetO2.setCategoryUsingTimeMap(mapT2);
                synchronized (obj) {
                    try {
                        aVar.f14662d = statsDataSetO2;
                        aVar.f14663e = i5;
                        StatsDataSet[] statsDataSetArr = aVar.f14661c;
                        if (statsDataSetArr != null && iCurrentTimeMillis < statsDataSetArr.length) {
                            statsDataSetArr[iCurrentTimeMillis] = o(statsDataSet2);
                        }
                    } finally {
                    }
                }
                C0702g.O("ClockJumpUsageRecovery", "cap hour " + iCurrentTimeMillis + " from " + C0711p.t(jMax) + " to " + C0711p.t(j7) + " move " + C0711p.t(jMin) + " to previous");
                return;
            }
        }
        synchronized (obj) {
            try {
                aVar.f14662d = null;
                aVar.f14663e = -1;
                StatsDataSet[] statsDataSetArr2 = aVar.f14661c;
                if (statsDataSetArr2 != null && iCurrentTimeMillis < statsDataSetArr2.length) {
                    statsDataSetArr2[iCurrentTimeMillis] = o(statsDataSet2);
                }
            } finally {
            }
        }
    }

    static long g(long j5, long j6) {
        if (j5 <= 0) {
            return 0L;
        }
        long jE = C0697b.e();
        if (jE < 0 || jE == Long.MAX_VALUE) {
            jE = 180000;
        }
        long jMin = Math.min(j5, jE);
        if (D(jMin, j6)) {
            return 0L;
        }
        return jMin;
    }

    private static void h(StatsDataSet statsDataSet, String str, long j5) {
        Map<String, Long> packageUsingTimeMap;
        if (statsDataSet == null || (packageUsingTimeMap = statsDataSet.getPackageUsingTimeMap()) == null || !packageUsingTimeMap.containsKey(str)) {
            return;
        }
        long jMax = Math.max(0L, ((Long) C0813a.a(packageUsingTimeMap, str, 0L)).longValue());
        if (jMax <= j5) {
            return;
        }
        if (j5 <= 0) {
            packageUsingTimeMap.remove(str);
            Map<String, Integer> packageNotifyTimesMap = statsDataSet.getPackageNotifyTimesMap();
            if (packageNotifyTimesMap != null) {
                packageNotifyTimesMap.remove(str);
            }
        } else {
            packageUsingTimeMap.put(str, Long.valueOf(j5));
        }
        statsDataSet.setUsingTime(Math.max(0L, statsDataSet.getUsingTime() - (jMax - j5)));
    }

    private static void i(StatsDataSet statsDataSet, String str, long j5, W1.c cVar) {
        if (statsDataSet == null) {
            return;
        }
        long jMax = Math.max(0L, j5);
        StatsDataSet[] children = statsDataSet.getChildren();
        if (children != null) {
            for (StatsDataSet statsDataSet2 : children) {
                h(statsDataSet2, str, jMax);
            }
        }
        h(statsDataSet, str, jMax);
        if (cVar == null || statsDataSet.getPackageUsingTimeMap() == null) {
            return;
        }
        statsDataSet.setCategoryUsingTimeMap(s.e(cVar, statsDataSet.getPackageUsingTimeMap()));
    }

    static void j(StatsDataSet statsDataSet, W1.c cVar) {
        long j5;
        Map.Entry<String, Long> entry;
        long jMax;
        if (statsDataSet != null && C0697b.r() && statsDataSet.getStartTime() == C0711p.y()) {
            long jE = C0697b.e();
            long j6 = 0;
            if (jE < 0 || jE == Long.MAX_VALUE) {
                return;
            }
            long j7 = jE + 60000;
            Map<String, Long> packageUsingTimeMap = statsDataSet.getPackageUsingTimeMap();
            if (packageUsingTimeMap != null && packageUsingTimeMap.containsKey("com.android.settings")) {
                long jMax2 = Math.max(0L, ((Long) C0813a.a(packageUsingTimeMap, "com.android.settings", 0L)).longValue());
                long jG = g(jMax2, Math.max(0L, J(statsDataSet) - jMax2));
                if (jG <= 0) {
                    i(statsDataSet, "com.android.settings", 0L, cVar);
                } else if (jG < jMax2) {
                    i(statsDataSet, "com.android.settings", jG, cVar);
                }
            }
            long J5 = J(statsDataSet);
            long usingTime = statsDataSet.getUsingTime();
            long jMax3 = Math.max(usingTime, J5);
            if (jMax3 <= j7) {
                if (J5 <= 0 || usingTime == J5) {
                    return;
                }
                statsDataSet.setUsingTime(J5);
                if (cVar == null || statsDataSet.getPackageUsingTimeMap() == null) {
                    return;
                }
                statsDataSet.setCategoryUsingTimeMap(s.e(cVar, statsDataSet.getPackageUsingTimeMap()));
                return;
            }
            Map<String, Long> packageUsingTimeMap2 = statsDataSet.getPackageUsingTimeMap();
            if (J5 > j7 && packageUsingTimeMap2 != null && !packageUsingTimeMap2.isEmpty()) {
                HashMap map = new HashMap();
                String key = null;
                long j8 = 0;
                for (Map.Entry<String, Long> entry2 : packageUsingTimeMap2.entrySet()) {
                    if (entry2.getValue() == null) {
                        j5 = j8;
                        entry = entry2;
                        jMax = j6;
                    } else {
                        j5 = j8;
                        entry = entry2;
                        jMax = Math.max(j6, entry2.getValue().longValue());
                    }
                    long j9 = (long) ((jMax * j7) / J5);
                    map.put(entry.getKey(), Long.valueOf(j9));
                    key = entry.getKey();
                    j8 = j5 + j9;
                    j6 = 0;
                }
                long j10 = j8;
                if (key != null) {
                    map.put(key, Long.valueOf(Math.max(0L, map.get(key).longValue() + (j7 - j10))));
                }
                statsDataSet.setPackageUsingTimeMap(map);
                if (cVar != null) {
                    statsDataSet.setCategoryUsingTimeMap(s.e(cVar, map));
                }
            }
            statsDataSet.setUsingTime(Math.min(jMax3, j7));
            C0702g.O("ClockJumpUsageRecovery", "clamp forward fake today to elapsed cap=" + C0711p.t(j7) + " was=" + C0711p.t(jMax3));
        }
    }

    private static void k(StatsDataSet statsDataSet) {
        StatsDataSet[] children;
        long j5;
        long jMin;
        if (statsDataSet == null || (children = statsDataSet.getChildren()) == null || children.length == 0) {
            return;
        }
        int i5 = 0;
        boolean z5 = statsDataSet.getStartTime() == C0711p.y();
        long j6 = 3600000;
        int iCurrentTimeMillis = z5 ? (int) ((System.currentTimeMillis() - statsDataSet.getStartTime()) / 3600000) : -1;
        HashMap map = new HashMap();
        long j7 = 0;
        while (i5 < children.length) {
            StatsDataSet statsDataSet2 = children[i5];
            if (statsDataSet2 != null) {
                if (z5 && i5 == iCurrentTimeMillis) {
                    j5 = 0;
                    long jCurrentTimeMillis = System.currentTimeMillis() - (statsDataSet.getStartTime() + (iCurrentTimeMillis * j6));
                    if (jCurrentTimeMillis < 0) {
                        jCurrentTimeMillis = 0;
                    }
                    jMin = Math.min(j6, jCurrentTimeMillis);
                } else {
                    j5 = 0;
                    jMin = (!z5 || iCurrentTimeMillis < 0 || i5 <= iCurrentTimeMillis) ? j6 : 0L;
                }
                long jMax = Math.max(j5, statsDataSet2.getUsingTime());
                if (jMax > jMin) {
                    Map<String, Long> mapQ = q(statsDataSet2.getPackageUsingTimeMap());
                    U(statsDataSet2.getPackageUsingTimeMap(), jMin);
                    U(statsDataSet2.getCategoryUsingTimeMap(), jMin);
                    statsDataSet2.setUsingTime(jMin);
                    j7 += jMax - jMin;
                    c(map, t(mapQ, statsDataSet2.getPackageUsingTimeMap()));
                    C0702g.O("ClockJumpUsageRecovery", "clamp hour " + i5 + " from " + C0711p.t(jMax) + " to " + C0711p.t(jMin));
                }
            }
            i5++;
            j6 = 3600000;
        }
        if (j7 <= 0) {
            return;
        }
        Map<String, Long> packageUsingTimeMap = statsDataSet.getPackageUsingTimeMap();
        if (packageUsingTimeMap != null) {
            for (Map.Entry entry : map.entrySet()) {
                long jMax2 = Math.max(0L, ((Long) C0813a.a(packageUsingTimeMap, (String) entry.getKey(), 0L)).longValue() - (entry.getValue() == null ? 0L : ((Long) entry.getValue()).longValue()));
                if (jMax2 <= 0) {
                    packageUsingTimeMap.remove(entry.getKey());
                } else {
                    packageUsingTimeMap.put((String) entry.getKey(), Long.valueOf(jMax2));
                }
            }
        }
        statsDataSet.setUsingTime(Math.max(0L, Math.max(0L, statsDataSet.getUsingTime()) - j7));
        U(statsDataSet.getCategoryUsingTimeMap(), statsDataSet.getUsingTime());
    }

    static void l(StatsDataSet statsDataSet, W1.c cVar, long j5) {
        long j6;
        long j7;
        long jMax;
        if (statsDataSet == null) {
            return;
        }
        long jQ = Q(j5);
        if (jQ == Long.MAX_VALUE) {
            return;
        }
        long J5 = J(statsDataSet);
        long usingTime = statsDataSet.getUsingTime();
        long jMax2 = Math.max(usingTime, J5);
        long j8 = 0;
        if (jMax2 <= jQ) {
            if (J5 <= 0 || usingTime == J5) {
                return;
            }
            statsDataSet.setUsingTime(J5);
            if (cVar == null || statsDataSet.getPackageUsingTimeMap() == null) {
                return;
            }
            statsDataSet.setCategoryUsingTimeMap(s.e(cVar, statsDataSet.getPackageUsingTimeMap()));
            return;
        }
        Map<String, Long> packageUsingTimeMap = statsDataSet.getPackageUsingTimeMap();
        if (J5 <= jQ || packageUsingTimeMap == null || packageUsingTimeMap.isEmpty()) {
            j6 = jMax2;
        } else {
            HashMap map = new HashMap();
            String key = null;
            long j9 = 0;
            for (Map.Entry<String, Long> entry : packageUsingTimeMap.entrySet()) {
                if (entry.getValue() == null) {
                    j7 = jMax2;
                    jMax = j8;
                } else {
                    j7 = jMax2;
                    jMax = Math.max(j8, entry.getValue().longValue());
                }
                long j10 = (long) ((jMax * jQ) / J5);
                map.put(entry.getKey(), Long.valueOf(j10));
                j9 += j10;
                key = entry.getKey();
                jMax2 = j7;
                j8 = 0;
            }
            j6 = jMax2;
            if (key != null) {
                map.put(key, Long.valueOf(Math.max(0L, map.get(key).longValue() + (jQ - j9))));
            }
            statsDataSet.setPackageUsingTimeMap(map);
            if (cVar != null) {
                statsDataSet.setCategoryUsingTimeMap(s.e(cVar, map));
            }
        }
        statsDataSet.setUsingTime(jQ);
        C0702g.O("ClockJumpUsageRecovery", "clamp rewind duration to cap=" + C0711p.t(jQ) + " floor=" + C0711p.t(j5) + " live=" + C0711p.t(j6));
    }

    private static void m(StatsDataSet statsDataSet) {
        long J5 = J(statsDataSet);
        if (J5 <= 0) {
            return;
        }
        long usingTime = statsDataSet.getUsingTime();
        if (C0697b.n()) {
            if (usingTime != J5) {
                statsDataSet.setUsingTime(J5);
                C0702g.O("ClockJumpUsageRecovery", "align today usingTime from " + C0711p.t(usingTime) + " to packageSum " + C0711p.t(J5));
                return;
            }
            return;
        }
        if (usingTime <= J5 + 900000) {
            return;
        }
        StatsDataSet[] children = statsDataSet.getChildren();
        if (children != null) {
            for (StatsDataSet statsDataSet2 : children) {
                if (statsDataSet2 != null) {
                    statsDataSet2.clampUsingTimeToAtMostPackageSum();
                }
            }
        }
        if (statsDataSet.clampUsingTimeToAtMostPackageSum()) {
            C0702g.O("ClockJumpUsageRecovery", "clamp today usingTime from " + C0711p.t(usingTime) + " to packageSum " + C0711p.t(statsDataSet.getUsingTime()));
        }
    }

    static void n() {
        synchronized (f14657a) {
            a aVar = f14658b;
            aVar.f14659a = Long.MIN_VALUE;
            aVar.f14660b = -1;
            aVar.f14661c = null;
            aVar.f14662d = null;
            aVar.f14663e = -1;
            aVar.f14664f = -1;
            aVar.f14665g = 0L;
            aVar.f14666h = 0L;
        }
    }

    private static StatsDataSet o(StatsDataSet statsDataSet) {
        if (statsDataSet == null) {
            return null;
        }
        StatsDataSet statsDataSet2 = new StatsDataSet(statsDataSet.getInterval(), statsDataSet.getSize(), statsDataSet.getUpdateTime(), statsDataSet.getStartTime(), null);
        statsDataSet2.setUsingTime(statsDataSet.getUsingTime());
        statsDataSet2.setPickupTimes(statsDataSet.getPickupTimes());
        statsDataSet2.setNotifyTimes(statsDataSet.getNotifyTimes());
        statsDataSet2.setLongestUseTime(statsDataSet.getLongestUseTime());
        statsDataSet2.setPackageUsingTimeMap(q(statsDataSet.getPackageUsingTimeMap()));
        statsDataSet2.setPackageNotifyTimesMap(p(statsDataSet.getPackageNotifyTimesMap()));
        statsDataSet2.setCategoryUsingTimeMap(q(statsDataSet.getCategoryUsingTimeMap()));
        return statsDataSet2;
    }

    private static Map<String, Integer> p(Map<String, Integer> map) {
        return (map == null || map.isEmpty()) ? new HashMap() : new HashMap(map);
    }

    private static Map<String, Long> q(Map<String, Long> map) {
        return (map == null || map.isEmpty()) ? new HashMap() : new HashMap(map);
    }

    private static int r(StatsDataSet[] statsDataSetArr) {
        StatsDataSet statsDataSet;
        if (statsDataSetArr == null || statsDataSetArr.length == 0 || (statsDataSet = statsDataSetArr[0]) == null) {
            return -1;
        }
        long startTime = statsDataSet.getStartTime();
        if (startTime != C0711p.y()) {
            return -1;
        }
        return (int) ((System.currentTimeMillis() - startTime) / 3600000);
    }

    private static long s(StatsDataSet statsDataSet, long j5) {
        StatsDataSet[] children;
        if (statsDataSet != null && (children = statsDataSet.getChildren()) != null && children.length != 0) {
            int startTime = (int) ((j5 - statsDataSet.getStartTime()) / 3600000);
            if (startTime >= 0 && startTime < children.length && children[startTime] != null) {
                long startTime2 = j5 - (statsDataSet.getStartTime() + (startTime * 3600000));
                if (startTime2 < 0) {
                    return 0L;
                }
                return Math.max(0L, (startTime2 <= 3600000 ? startTime2 : 3600000L) - Math.max(0L, children[startTime].getUsingTime()));
            }
        }
        return 0L;
    }

    private static Map<String, Long> t(Map<String, Long> map, Map<String, Long> map2) {
        Long l5;
        HashMap map3 = new HashMap();
        if (map != null && !map.isEmpty()) {
            for (Map.Entry<String, Long> entry : map.entrySet()) {
                long jMax = 0;
                long jMax2 = entry.getValue() == null ? 0L : Math.max(0L, entry.getValue().longValue());
                if (map2 != null && (l5 = map2.get(entry.getKey())) != null) {
                    jMax = Math.max(0L, l5.longValue());
                }
                if (jMax2 > jMax) {
                    map3.put(entry.getKey(), Long.valueOf(jMax2 - jMax));
                }
            }
        }
        return map3;
    }

    private static void u(StatsDataSet[] statsDataSetArr, int i5, boolean z5) {
        StatsDataSet statsDataSet;
        if (i5 <= 0 || statsDataSetArr == null || statsDataSetArr.length == 0) {
            return;
        }
        long usingTime = 0;
        for (StatsDataSet statsDataSet2 : statsDataSetArr) {
            if (statsDataSet2 != null && statsDataSet2.getUsingTime() > 0) {
                usingTime += statsDataSet2.getUsingTime();
            }
        }
        if (usingTime <= 0) {
            int iCurrentTimeMillis = (int) ((System.currentTimeMillis() - C0711p.y()) / 3600000);
            length = iCurrentTimeMillis >= 0 ? iCurrentTimeMillis : 0;
            if (length >= statsDataSetArr.length) {
                length = statsDataSetArr.length - 1;
            }
            StatsDataSet statsDataSet3 = statsDataSetArr[length];
            if (statsDataSet3 != null) {
                if (z5) {
                    statsDataSet3.setPickupTimes(i5);
                    return;
                } else {
                    statsDataSet3.setNotifyTimes(i5);
                    return;
                }
            }
            return;
        }
        int i6 = -1;
        int i7 = 0;
        while (length < statsDataSetArr.length) {
            StatsDataSet statsDataSet4 = statsDataSetArr[length];
            if (statsDataSet4 != null && statsDataSet4.getUsingTime() > 0) {
                int usingTime2 = (int) ((i5 * statsDataSet4.getUsingTime()) / usingTime);
                if (z5) {
                    statsDataSet4.setPickupTimes(usingTime2);
                } else {
                    statsDataSet4.setNotifyTimes(usingTime2);
                }
                i7 += usingTime2;
                i6 = length;
            }
            length++;
        }
        int i8 = i5 - i7;
        if (i8 == 0 || i6 < 0 || (statsDataSet = statsDataSetArr[i6]) == null) {
            return;
        }
        if (z5) {
            statsDataSet.setPickupTimes(statsDataSet.getPickupTimes() + i8);
        } else {
            statsDataSet.setNotifyTimes(statsDataSet.getNotifyTimes() + i8);
        }
    }

    static void v(StatsDataSet statsDataSet, W1.c cVar) {
        StatsDataSet[] children;
        int iCurrentTimeMillis;
        int i5;
        if (statsDataSet == null || statsDataSet.getStartTime() != C0711p.y() || (children = statsDataSet.getChildren()) == null || children.length == 0 || (iCurrentTimeMillis = (int) ((System.currentTimeMillis() - statsDataSet.getStartTime()) / 3600000)) < 0) {
            return;
        }
        int i6 = iCurrentTimeMillis + 1;
        long j5 = 0;
        long usingTime = 0;
        while (true) {
            i5 = 0;
            if (i6 >= children.length) {
                break;
            }
            StatsDataSet statsDataSet2 = children[i6];
            if (statsDataSet2 != null && statsDataSet2.getUsingTime() > 0) {
                usingTime += statsDataSet2.getUsingTime();
                statsDataSet2.setUsingTime(0L);
                statsDataSet2.setPickupTimes(0);
                statsDataSet2.setNotifyTimes(0);
                statsDataSet2.setPackageUsingTimeMap(new HashMap());
                statsDataSet2.setCategoryUsingTimeMap(new HashMap());
            }
            i6++;
        }
        if (usingTime <= 0) {
            return;
        }
        HashMap map = new HashMap();
        long jMax = 0;
        while (i5 <= iCurrentTimeMillis && i5 < children.length) {
            StatsDataSet statsDataSet3 = children[i5];
            if (statsDataSet3 != null) {
                jMax += Math.max(j5, statsDataSet3.getUsingTime());
                Map<String, Long> packageUsingTimeMap = statsDataSet3.getPackageUsingTimeMap();
                if (packageUsingTimeMap != null) {
                    for (Map.Entry<String, Long> entry : packageUsingTimeMap.entrySet()) {
                        long jLongValue = entry.getValue() == null ? j5 : entry.getValue().longValue();
                        if (jLongValue > j5) {
                            long j6 = j5;
                            map.put(entry.getKey(), Long.valueOf(((Long) C0813a.a(map, entry.getKey(), Long.valueOf(j6))).longValue() + jLongValue));
                            j5 = j6;
                        }
                    }
                }
            }
            i5++;
            j5 = j5;
        }
        if (statsDataSet.getUsingTime() <= 900000 + jMax) {
            return;
        }
        C0702g.O("ClockJumpUsageRecovery", "drop future-hour usage dropped=" + C0711p.t(usingTime) + " remain=" + C0711p.t(jMax) + " was=" + C0711p.t(statsDataSet.getUsingTime()));
        statsDataSet.setUsingTime(jMax);
        statsDataSet.setPackageUsingTimeMap(map);
        if (cVar != null) {
            statsDataSet.setCategoryUsingTimeMap(s.e(cVar, map));
        }
    }

    private static boolean w(StatsDataSet statsDataSet) {
        return statsDataSet != null && statsDataSet.getUsingTime() > 0;
    }

    private static boolean x(StatsDataSet statsDataSet) {
        Map<String, Long> packageUsingTimeMap;
        if (statsDataSet != null && (packageUsingTimeMap = statsDataSet.getPackageUsingTimeMap()) != null && !packageUsingTimeMap.isEmpty()) {
            for (Long l5 : packageUsingTimeMap.values()) {
                if (l5 != null && l5.longValue() > 0) {
                    return true;
                }
            }
        }
        return false;
    }

    static long[] y(StatsDataSet[] statsDataSetArr) {
        if (statsDataSetArr == null || statsDataSetArr.length == 0) {
            return null;
        }
        long[] jArr = new long[statsDataSetArr.length];
        for (int i5 = 0; i5 < statsDataSetArr.length; i5++) {
            StatsDataSet statsDataSet = statsDataSetArr[i5];
            if (statsDataSet != null) {
                jArr[i5] = statsDataSet.getUsingTime();
            }
        }
        return jArr;
    }

    private static boolean z(StatsDataSet statsDataSet, long j5) {
        if (statsDataSet != null && j5 >= 600000) {
            long startTime = statsDataSet.getStartTime();
            long jY = C0711p.y();
            boolean z5 = C0697b.p() && startTime == jY;
            boolean z6 = C0697b.r() && startTime == jY - 86400000;
            if (!z5 && !z6) {
                return false;
            }
            long longestUseTime = statsDataSet.getLongestUseTime();
            if (PackageUtils.t(j5, longestUseTime, startTime)) {
                return true;
            }
            long j6 = 0;
            if (j5 >= 2700000 && longestUseTime >= 0 && longestUseTime < 1800000) {
                return true;
            }
            if (z5) {
                return false;
            }
            long[] jArrY = y(statsDataSet.getChildren());
            if (jArrY != null) {
                long jMax = 0;
                for (long j7 : jArrY) {
                    jMax += Math.max(0L, j7);
                }
                j6 = jMax;
            }
            long jMax2 = Math.max(statsDataSet.getUsingTime(), J(statsDataSet)) - j6;
            if (jMax2 >= 600000 && 10 * j5 >= jMax2 * 6) {
                return true;
            }
        }
        return false;
    }
}
