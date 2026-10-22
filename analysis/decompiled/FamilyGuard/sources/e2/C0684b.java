package e2;

import android.content.Context;
import android.os.SystemClock;
import androidx.exifinterface.media.ExifInterface;
import com.stepos.common.alphame.AlphaMe;
import com.stepos.digitalwellbeing.server.data.Category;
import com.stepos.digitalwellbeing.server.data.CategoryUsingTimeStats;
import com.stepos.digitalwellbeing.server.data.DataToken;
import com.stepos.digitalwellbeing.server.data.NotificationTimesStats;
import com.stepos.digitalwellbeing.server.data.PackageNotificationTimesStats;
import com.stepos.digitalwellbeing.server.data.PackageUsingTimeStats;
import com.stepos.digitalwellbeing.server.data.PickupTimesStats;
import com.stepos.digitalwellbeing.server.data.StatsDataSet;
import com.stepos.digitalwellbeing.server.data.UsingTimeStats;
import com.stepos.digitalwellbeing.server.transaction.usagstats.alphame.p;
import com.stepos.digitalwellbeing.server.transaction.usagstats.alphame.q;
import com.stepos.digitalwellbeing.server.transaction.usagstats.alphame.t;
import com.stepos.digitalwellbeing.server.transaction.usagstats.alphame.v;
import com.stepos.digitalwellbeing.server.transaction.usagstats.alphame.w;
import d2.C0653a;
import d2.C0661i;
import d2.C0663k;
import f2.C0697b;
import f2.C0702g;
import f2.C0711p;
import f2.C0712q;
import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import p2.g;

/* renamed from: e2.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0684b {

    /* renamed from: A, reason: collision with root package name */
    private static final boolean f16657A = R1.a.f("UsageManager", R1.a.f4966b);

    /* renamed from: a, reason: collision with root package name */
    private final ReentrantReadWriteLock f16658a = new ReentrantReadWriteLock();

    /* renamed from: b, reason: collision with root package name */
    private final Lock f16659b = new ReentrantLock();

    /* renamed from: c, reason: collision with root package name */
    private final Lock f16660c = new ReentrantLock();

    /* renamed from: d, reason: collision with root package name */
    private Context f16661d;

    /* renamed from: e, reason: collision with root package name */
    private UsingTimeStats[] f16662e;

    /* renamed from: f, reason: collision with root package name */
    private UsingTimeStats[] f16663f;

    /* renamed from: g, reason: collision with root package name */
    private NotificationTimesStats[] f16664g;

    /* renamed from: h, reason: collision with root package name */
    private NotificationTimesStats[] f16665h;

    /* renamed from: i, reason: collision with root package name */
    private PickupTimesStats[] f16666i;

    /* renamed from: j, reason: collision with root package name */
    private PickupTimesStats[] f16667j;

    /* renamed from: k, reason: collision with root package name */
    private HashMap<String, PackageUsingTimeStats> f16668k;

    /* renamed from: l, reason: collision with root package name */
    private HashMap<String, PackageUsingTimeStats> f16669l;

    /* renamed from: m, reason: collision with root package name */
    private HashMap<String, PackageNotificationTimesStats> f16670m;

    /* renamed from: n, reason: collision with root package name */
    private HashMap<String, PackageNotificationTimesStats> f16671n;

    /* renamed from: o, reason: collision with root package name */
    private HashMap<String, PackageUsingTimeStats[]> f16672o;

    /* renamed from: p, reason: collision with root package name */
    private HashMap<String, PackageNotificationTimesStats[]> f16673p;

    /* renamed from: q, reason: collision with root package name */
    private HashMap<String, PackageUsingTimeStats[]> f16674q;

    /* renamed from: r, reason: collision with root package name */
    private HashMap<String, PackageNotificationTimesStats[]> f16675r;

    /* renamed from: s, reason: collision with root package name */
    private StatsDataSet[] f16676s;

    /* renamed from: t, reason: collision with root package name */
    private StatsDataSet f16677t;

    /* renamed from: u, reason: collision with root package name */
    private StatsDataSet f16678u;

    /* renamed from: v, reason: collision with root package name */
    private DataToken f16679v;

    /* renamed from: w, reason: collision with root package name */
    private DataToken f16680w;

    /* renamed from: x, reason: collision with root package name */
    private DataToken f16681x;

    /* renamed from: y, reason: collision with root package name */
    private DataToken f16682y;

    /* renamed from: z, reason: collision with root package name */
    private W1.c f16683z;

    public C0684b(Context context, W1.c cVar) {
        J(context, cVar);
    }

    public static boolean A() {
        return true;
    }

    private static boolean B(StatsDataSet statsDataSet) {
        if (statsDataSet == null) {
            return true;
        }
        if (statsDataSet.getUsingTime() > 0) {
            return false;
        }
        Map<String, Long> packageUsingTimeMap = statsDataSet.getPackageUsingTimeMap();
        if (packageUsingTimeMap != null && !packageUsingTimeMap.isEmpty()) {
            for (Long l5 : packageUsingTimeMap.values()) {
                if (l5 != null && l5.longValue() > 0) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean C() {
        StatsDataSet statsDataSet = this.f16677t;
        if (statsDataSet == null || statsDataSet.getUsingTime() < 120000 || this.f16677t.getStartTime() != C0711p.y()) {
            return false;
        }
        DataToken dataToken = this.f16682y;
        return dataToken == null || n(dataToken.getType()) == 0;
    }

    private boolean D(int i5, long j5, DataToken dataToken) {
        if (dataToken != null) {
            return dataToken.getType() == i(i5, j5);
        }
        C0702g.O("UsageManager", "isSameMinorEnv dataToken is null");
        return false;
    }

    private static boolean E(int i5, long j5) {
        return (i5 == 1) == ((j5 > 0L ? 1 : (j5 == 0L ? 0 : -1)) > 0);
    }

    private StatsDataSet[] F(StatsDataSet[] statsDataSetArr) {
        StatsDataSet[] statsDataSetArr2;
        if (statsDataSetArr != null && statsDataSetArr.length >= 1 && (statsDataSetArr2 = this.f16676s) != null && statsDataSetArr2.length >= 1) {
            StatsDataSet statsDataSet = statsDataSetArr[0];
            StatsDataSet statsDataSet2 = statsDataSetArr2[0];
            if (statsDataSet2 != null && b0(statsDataSet2) > 0 && ((statsDataSet == null || b0(statsDataSet) <= 0) && (statsDataSet == null || statsDataSet2.getStartTime() == statsDataSet.getStartTime()))) {
                R1.a.l("UsageManager", "keep previous last week using=" + C0711p.t(b0(statsDataSet2)) + " start=" + C0711p.j(statsDataSet2.getStartTime()));
                statsDataSetArr[0] = statsDataSet2;
            }
        }
        return statsDataSetArr;
    }

    private <K, V> V[] I(Class<V> cls, Map<K, V> map) {
        if (map == null) {
            return null;
        }
        V[] vArr = (V[]) ((Object[]) Array.newInstance((Class<?>) cls, map.values().size()));
        map.values().toArray(vArr);
        return vArr;
    }

    private void J(Context context, W1.c cVar) {
        if (f16657A) {
            R1.a.a("UsageManager", "onInit");
        }
        this.f16661d = context;
        this.f16683z = cVar;
    }

    private void K(StatsDataSet[] statsDataSetArr) {
        if (statsDataSetArr == null) {
            return;
        }
        long jY = C0711p.y();
        StatsDataSet statsDataSetF = f(statsDataSetArr, jY);
        if (B(statsDataSetF)) {
            StatsDataSet statsDataSet = this.f16677t;
            if (!B(statsDataSet) && statsDataSet.getStartTime() == jY && O(statsDataSetArr, statsDataSet)) {
                StringBuilder sb = new StringBuilder();
                sb.append("overlay live today onto empty week slot using=");
                sb.append(C0711p.t(statsDataSet.getUsingTime()));
                sb.append(" weekToday=");
                sb.append(C0711p.t(statsDataSetF == null ? 0L : statsDataSetF.getUsingTime()));
                C0702g.O("UsageManager", sb.toString());
            }
        }
    }

    private StatsDataSet[] L() {
        boolean zTryLock = false;
        try {
            try {
                zTryLock = this.f16658a.readLock().tryLock(3L, TimeUnit.SECONDS);
                if (!zTryLock) {
                    R1.a.l("UsageManager", "Failed to acquire read lock for getStatsDataSets within 3 seconds");
                }
                StatsDataSet[] statsDataSetArr = this.f16676s;
                if (zTryLock) {
                    this.f16658a.readLock().unlock();
                }
                return statsDataSetArr;
            } catch (InterruptedException e6) {
                R1.a.m("UsageManager", "Interrupted while waiting for read lock in getStatsDataSets", e6);
                Thread.currentThread().interrupt();
                StatsDataSet[] statsDataSetArr2 = this.f16676s;
                if (zTryLock) {
                    this.f16658a.readLock().unlock();
                }
                return statsDataSetArr2;
            }
        } catch (Throwable th) {
            if (zTryLock) {
                this.f16658a.readLock().unlock();
            }
            throw th;
        }
    }

    private void N(int i5) {
        if (i5 != com.stepos.digitalwellbeing.server.data.a.LAST_TWO_WEEK.ordinal()) {
            M();
        } else {
            this.f16676s = null;
            this.f16681x = null;
        }
    }

    private static boolean O(StatsDataSet[] statsDataSetArr, StatsDataSet statsDataSet) {
        if (statsDataSetArr != null && statsDataSet != null) {
            for (StatsDataSet statsDataSet2 : statsDataSetArr) {
                if (statsDataSet2 != null && statsDataSet2.getChildren() != null) {
                    StatsDataSet[] children = statsDataSet2.getChildren();
                    for (int i5 = 0; i5 < children.length; i5++) {
                        StatsDataSet statsDataSet3 = children[i5];
                        if (statsDataSet3 != null && statsDataSet3.getStartTime() == statsDataSet.getStartTime()) {
                            children[i5] = statsDataSet;
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    private StatsDataSet Q(int i5, long j5, StatsDataSet statsDataSet) {
        if (z(i5, j5) && this.f16678u != null) {
            long jY = C0711p.y();
            if (this.f16678u.getStartTime() != jY) {
                C0702g.O("UsageManager", "drop stale adult today stash date=" + C0711p.j(this.f16678u.getStartTime()) + " todayStart=" + C0711p.j(jY));
                this.f16678u = null;
                return statsDataSet;
            }
            long usingTime = statsDataSet == null ? 0L : statsDataSet.getUsingTime();
            long usingTime2 = this.f16678u.getUsingTime();
            if (usingTime2 > 60000 + usingTime) {
                C0702g.O("UsageManager", "restore adult today after minor-mode switch stashed=" + C0711p.t(usingTime2) + " fetched=" + C0711p.t(usingTime));
                return this.f16678u;
            }
        }
        return statsDataSet;
    }

    private void R() {
        StatsDataSet statsDataSet;
        if (this.f16661d == null) {
            return;
        }
        if (!C0697b.r()) {
            DataToken dataToken = this.f16682y;
            if (dataToken == null || n(dataToken.getType()) == 0) {
                StatsDataSet statsDataSetE = e(C0711p.y());
                if (statsDataSetE == null) {
                    statsDataSetE = this.f16677t;
                }
                if (statsDataSetE != null) {
                    t.B(this.f16661d, statsDataSetE);
                    return;
                }
                return;
            }
            return;
        }
        long jY = C0711p.y() - 86400000;
        StatsDataSet statsDataSetE2 = e(jY);
        if (statsDataSetE2 == null && (statsDataSet = this.f16677t) != null && statsDataSet.getStartTime() == jY) {
            statsDataSetE2 = this.f16677t;
        }
        if (statsDataSetE2 != null) {
            t.B(this.f16661d, statsDataSetE2);
        }
        StatsDataSet statsDataSet2 = this.f16677t;
        if (statsDataSet2 == null || statsDataSet2.getStartTime() != C0711p.y()) {
            return;
        }
        t.C(this.f16661d, this.f16677t);
    }

    private void S() {
        if (C()) {
            this.f16678u = this.f16677t;
        }
    }

    private void T(int i5, long j5) {
        if (z(i5, j5)) {
            return;
        }
        S();
    }

    private static void U(DataToken dataToken, DataToken dataToken2) {
        if (dataToken2 == null || dataToken == null || dataToken.getUpdateTime() <= dataToken2.getUpdateTime()) {
            return;
        }
        dataToken2.setUpdateTime(dataToken.getUpdateTime());
    }

    private DataToken V(int i5, long j5, StatsDataSet statsDataSet) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        int i6 = i(i5, j5);
        if (statsDataSet == null) {
            this.f16682y = new DataToken(i6, jCurrentTimeMillis, hashCode(), g());
        } else {
            int interval = statsDataSet.getInterval();
            if (interval != com.stepos.digitalwellbeing.server.data.a.DAY.ordinal()) {
                throw new IllegalStateException("error result interval interval = " + interval);
            }
            this.f16682y = new DataToken(i6, statsDataSet.getUpdateTime(), hashCode());
            this.f16677t = statsDataSet;
        }
        return this.f16682y;
    }

    private DataToken W(StatsDataSet statsDataSet) {
        return V(0, -1L, statsDataSet);
    }

    private DataToken X(C0661i c0661i) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (c0661i == null) {
            this.f16679v = new DataToken(0, jCurrentTimeMillis, hashCode(), g());
        } else {
            this.f16679v = new DataToken(0, c0661i.f(), hashCode());
            this.f16662e = C0653a.l(c0661i);
            this.f16664g = C0653a.f(c0661i);
            this.f16666i = C0653a.k(c0661i);
            this.f16668k = C0653a.j(c0661i);
            this.f16670m = C0653a.h(c0661i);
            this.f16672o = C0653a.i(c0661i);
            this.f16673p = C0653a.g(c0661i);
            this.f16679v = new DataToken(0, c0661i.f(), hashCode());
        }
        return this.f16679v;
    }

    private DataToken Y(int i5, long j5, StatsDataSet[] statsDataSetArr) {
        C0702g.b("UsageManager", "updateTwoWeekDataToken");
        long jCurrentTimeMillis = System.currentTimeMillis();
        int i6 = i(i5, j5);
        if (statsDataSetArr == null || statsDataSetArr.length == 0) {
            this.f16681x = new DataToken(i6, jCurrentTimeMillis, hashCode(), g());
        } else {
            StatsDataSet[] statsDataSetArrF = F(statsDataSetArr);
            StatsDataSet statsDataSet = statsDataSetArrF[0];
            if (statsDataSet == null) {
                this.f16681x = new DataToken(i6, 0L, hashCode(), -2);
            } else {
                int interval = statsDataSet.getInterval();
                if (interval != com.stepos.digitalwellbeing.server.data.a.WEEK.ordinal()) {
                    throw new IllegalStateException("error result interval interval = " + interval);
                }
                this.f16681x = new DataToken(i6, statsDataSet.getUpdateTime(), hashCode());
            }
            this.f16676s = statsDataSetArrF;
        }
        return this.f16681x;
    }

    private DataToken Z(StatsDataSet[] statsDataSetArr) {
        return Y(0, -1L, statsDataSetArr);
    }

    private void a(DataToken dataToken) {
        if (dataToken == null || dataToken.getToken() != hashCode()) {
            throw new IllegalArgumentException();
        }
    }

    private DataToken a0(C0663k c0663k) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (c0663k == null) {
            this.f16680w = new DataToken(0, jCurrentTimeMillis, hashCode(), g());
        } else {
            this.f16680w = new DataToken(0, c0663k.f(), hashCode());
            this.f16663f = C0653a.l(c0663k);
            this.f16665h = C0653a.f(c0663k);
            this.f16667j = C0653a.k(c0663k);
            this.f16669l = C0653a.j(c0663k);
            this.f16671n = C0653a.h(c0663k);
            this.f16674q = C0653a.i(c0663k);
            this.f16675r = C0653a.g(c0663k);
            this.f16680w = new DataToken(0, c0663k.f(), hashCode());
        }
        return this.f16680w;
    }

    private void b(int i5) {
        if (i5 != com.stepos.digitalwellbeing.server.data.a.DAY.ordinal() && i5 != com.stepos.digitalwellbeing.server.data.a.WEEK.ordinal()) {
            throw new IllegalArgumentException("only support day and week");
        }
    }

    private static long b0(StatsDataSet statsDataSet) {
        if (statsDataSet == null) {
            return 0L;
        }
        long usingTime = statsDataSet.getUsingTime();
        if (usingTime > 0) {
            return usingTime;
        }
        StatsDataSet[] children = statsDataSet.getChildren();
        if (children == null) {
            return 0L;
        }
        long jMax = 0;
        for (StatsDataSet statsDataSet2 : children) {
            if (statsDataSet2 != null) {
                jMax += Math.max(0L, statsDataSet2.getUsingTime());
            }
        }
        return jMax;
    }

    private void c(int i5, DataToken dataToken) throws Throwable {
        String str;
        String str2;
        String str3;
        b(i5);
        StringBuilder sb = new StringBuilder();
        sb.append("FG_USAGE_TRACE START checkInvalidUpdateToken interval=");
        sb.append(i5);
        sb.append(", clientToken=");
        String str4 = "null";
        if (dataToken == null) {
            str = "null";
        } else {
            str = "type=" + dataToken.getType() + ", updateTime=" + dataToken.getUpdateTime() + ", invalidType=" + dataToken.getInvalidType() + ", token=" + dataToken.getToken();
        }
        sb.append(str);
        C0702g.b("UsageManager", sb.toString());
        a(dataToken);
        DataToken dataTokenY = y(i5);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("FG_USAGE_TRACE MID checkInvalidUpdateToken serviceToken(before reload)=");
        if (dataTokenY == null) {
            str2 = "null";
        } else {
            str2 = "type=" + dataTokenY.getType() + ", updateTime=" + dataTokenY.getUpdateTime() + ", invalidType=" + dataTokenY.getInvalidType() + ", token=" + dataTokenY.getToken();
        }
        sb2.append(str2);
        C0702g.b("UsageManager", sb2.toString());
        if (dataTokenY == null) {
            if (com.stepos.digitalwellbeing.server.transaction.usagstats.alphame.c.t()) {
                H(i5, true);
            } else {
                G(i5, true);
            }
            dataTokenY = y(i5);
            StringBuilder sb3 = new StringBuilder();
            sb3.append("FG_USAGE_TRACE MID checkInvalidUpdateToken serviceToken(after reload)=");
            if (dataTokenY == null) {
                str3 = "null";
            } else {
                str3 = "type=" + dataTokenY.getType() + ", updateTime=" + dataTokenY.getUpdateTime() + ", invalidType=" + dataTokenY.getInvalidType() + ", token=" + dataTokenY.getToken();
            }
            sb3.append(str3);
            C0702g.b("UsageManager", sb3.toString());
        }
        U(dataTokenY, dataToken);
        StringBuilder sb4 = new StringBuilder();
        sb4.append("FG_USAGE_TRACE END checkInvalidUpdateToken interval=");
        sb4.append(i5);
        sb4.append(", clientTokenAfterUpdate=");
        if (dataToken != null) {
            str4 = "updateTime=" + dataToken.getUpdateTime() + ", invalidType=" + dataToken.getInvalidType() + ", token=" + dataToken.getToken();
        }
        sb4.append(str4);
        C0702g.b("UsageManager", sb4.toString());
    }

    private void d() {
        this.f16678u = null;
        this.f16662e = null;
        this.f16663f = null;
        this.f16664g = null;
        this.f16665h = null;
        this.f16666i = null;
        this.f16667j = null;
        this.f16668k = null;
        this.f16669l = null;
        this.f16670m = null;
        this.f16671n = null;
        this.f16672o = null;
        this.f16673p = null;
        this.f16674q = null;
        this.f16675r = null;
        this.f16676s = null;
        this.f16677t = null;
        this.f16679v = null;
        this.f16680w = null;
        this.f16681x = null;
        this.f16682y = null;
    }

    private StatsDataSet e(long j5) {
        StatsDataSet[] statsDataSetArr = this.f16676s;
        if (statsDataSetArr == null) {
            return null;
        }
        for (StatsDataSet statsDataSet : statsDataSetArr) {
            if (statsDataSet != null && statsDataSet.getChildren() != null) {
                for (StatsDataSet statsDataSet2 : statsDataSet.getChildren()) {
                    if (statsDataSet2 != null && statsDataSet2.getStartTime() == j5) {
                        return statsDataSet2;
                    }
                }
            }
        }
        return null;
    }

    private static StatsDataSet f(StatsDataSet[] statsDataSetArr, long j5) {
        if (statsDataSetArr == null) {
            return null;
        }
        for (StatsDataSet statsDataSet : statsDataSetArr) {
            if (statsDataSet != null && statsDataSet.getChildren() != null) {
                for (StatsDataSet statsDataSet2 : statsDataSet.getChildren()) {
                    if (statsDataSet2 != null && statsDataSet2.getStartTime() == j5) {
                        return statsDataSet2;
                    }
                }
            }
        }
        return null;
    }

    private int g() {
        return g.u() ? -2 : -3;
    }

    private void h() {
        try {
            Object objS = AlphaMe.p().s("getDigitalHealthClearDataTime", new Object[0]);
            long jLongValue = objS != null ? ((Long) objS).longValue() : 0L;
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (jLongValue > jCurrentTimeMillis) {
                R1.a.l("UsageManager", "fixAlphameCloseTime: future clearTime=" + C0711p.j(jLongValue) + " now=" + C0711p.j(jCurrentTimeMillis) + ", skip re-clear");
            }
        } catch (Exception e6) {
            R1.a.b("UsageManager", "fixAlphameCloseTime() called with: e = [" + e6 + "]");
        }
    }

    private static int i(int i5, long j5) {
        return (i5 << 8) | (((int) j5) & 255);
    }

    private static int n(int i5) {
        return (i5 & ExifInterface.COLOR_SPACE_UNCALIBRATED) >> 8;
    }

    private static boolean z(int i5, long j5) {
        return i5 != 1 && j5 <= 0;
    }

    public DataToken G(int i5, boolean z5) throws Throwable {
        long updateTime;
        DataToken dataToken;
        DataToken dataToken2;
        C0702g.b("UsageManager", "loadUsageStats() START with: interval = [" + i5 + "]forceRefresh = [" + z5 + "]");
        b(i5);
        h();
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (i5 != com.stepos.digitalwellbeing.server.data.a.DAY.ordinal()) {
            DataToken dataToken3 = this.f16680w;
            updateTime = dataToken3 != null ? dataToken3.getUpdateTime() : 0L;
            if ((!z5 || jCurrentTimeMillis - updateTime <= 1000) && (dataToken = this.f16680w) != null && dataToken.isValid()) {
                C0702g.b("UsageManager", "loadUsageStats() END");
                return this.f16680w;
            }
            C0663k c0663kA = new w().a(new v().a(this.f16661d));
            try {
                try {
                    boolean zTryLock = this.f16660c.tryLock(3L, TimeUnit.SECONDS);
                    if (!zTryLock) {
                        R1.a.l("UsageManager", "Failed to acquire lock for mWeekLock within 3 seconds");
                        if (zTryLock) {
                            this.f16660c.unlock();
                        }
                        return null;
                    }
                    DataToken dataTokenA0 = a0(c0663kA);
                    if (zTryLock) {
                        this.f16660c.unlock();
                    }
                    C0702g.b("UsageManager", "loadUsageStats() END");
                    return dataTokenA0;
                } catch (InterruptedException e6) {
                    R1.a.m("UsageManager", "Interrupted while waiting for mWeekLock in loadUsageStats", e6);
                    Thread.currentThread().interrupt();
                    if (0 != 0) {
                        this.f16660c.unlock();
                    }
                    return null;
                }
            } catch (Throwable th) {
                if (0 != 0) {
                    this.f16660c.unlock();
                }
                throw th;
            }
        }
        DataToken dataToken4 = this.f16679v;
        updateTime = dataToken4 != null ? dataToken4.getUpdateTime() : 0L;
        if ((!z5 || jCurrentTimeMillis - updateTime <= 1000) && (dataToken2 = this.f16679v) != null && dataToken2.isValid()) {
            C0702g.b("UsageManager", "loadUsageStats() END");
            return this.f16679v;
        }
        C0702g.n("UsageManager", R1.a.f4966b);
        C0661i c0661iA = new q().a(new p().a(this.f16661d));
        try {
            try {
                boolean zTryLock2 = this.f16659b.tryLock(3L, TimeUnit.SECONDS);
                if (!zTryLock2) {
                    R1.a.l("UsageManager", "Failed to acquire lock for mTodayLock within 3 seconds");
                    if (zTryLock2) {
                        this.f16659b.unlock();
                    }
                    return null;
                }
                DataToken dataTokenX = X(c0661iA);
                if (zTryLock2) {
                    this.f16659b.unlock();
                }
                C0702g.b("UsageManager", "loadUsageStats() END");
                return dataTokenX;
            } catch (InterruptedException e7) {
                R1.a.m("UsageManager", "Interrupted while waiting for mTodayLock in loadUsageStats", e7);
                Thread.currentThread().interrupt();
                if (0 != 0) {
                    this.f16659b.unlock();
                }
                return null;
            }
        } catch (Throwable th2) {
            if (0 != 0) {
                this.f16659b.unlock();
            }
            throw th2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:116:0x0348  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x034a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0378  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0277  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0279 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.stepos.digitalwellbeing.server.data.DataToken H(int r27, boolean r28) {
        /*
            Method dump skipped, instructions count: 910
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: e2.C0684b.H(int, boolean):com.stepos.digitalwellbeing.server.data.DataToken");
    }

    public void M() {
        if (f16657A) {
            R1.a.a("UsageManager", "releaseBackgroundCaches");
        }
        S();
        R();
        this.f16662e = null;
        this.f16663f = null;
        this.f16664g = null;
        this.f16665h = null;
        this.f16666i = null;
        this.f16667j = null;
        HashMap<String, PackageUsingTimeStats> map = this.f16668k;
        if (map != null) {
            map.clear();
        }
        this.f16668k = null;
        HashMap<String, PackageUsingTimeStats> map2 = this.f16669l;
        if (map2 != null) {
            map2.clear();
        }
        this.f16669l = null;
        HashMap<String, PackageNotificationTimesStats> map3 = this.f16670m;
        if (map3 != null) {
            map3.clear();
        }
        this.f16670m = null;
        HashMap<String, PackageNotificationTimesStats> map4 = this.f16671n;
        if (map4 != null) {
            map4.clear();
        }
        this.f16671n = null;
        HashMap<String, PackageUsingTimeStats[]> map5 = this.f16672o;
        if (map5 != null) {
            map5.clear();
        }
        this.f16672o = null;
        HashMap<String, PackageNotificationTimesStats[]> map6 = this.f16673p;
        if (map6 != null) {
            map6.clear();
        }
        this.f16673p = null;
        HashMap<String, PackageUsingTimeStats[]> map7 = this.f16674q;
        if (map7 != null) {
            map7.clear();
        }
        this.f16674q = null;
        HashMap<String, PackageNotificationTimesStats[]> map8 = this.f16675r;
        if (map8 != null) {
            map8.clear();
        }
        this.f16675r = null;
        this.f16676s = null;
        this.f16677t = null;
        this.f16679v = null;
        this.f16680w = null;
        this.f16681x = null;
        this.f16682y = null;
    }

    public void P() {
        com.stepos.digitalwellbeing.server.transaction.usagstats.alphame.c.F(this.f16677t);
        com.stepos.digitalwellbeing.server.transaction.usagstats.alphame.c.B();
        com.stepos.digitalwellbeing.server.transaction.usagstats.alphame.c.f();
        Context context = this.f16661d;
        if (context != null) {
            t.g(context);
        }
        d();
    }

    public CategoryUsingTimeStats[] j(int i5, DataToken dataToken) {
        List<Category> listJ = this.f16683z.j();
        int size = listJ.size();
        CategoryUsingTimeStats[] categoryUsingTimeStatsArr = new CategoryUsingTimeStats[size];
        for (int i6 = 0; i6 < size; i6++) {
            categoryUsingTimeStatsArr[i6] = l(i5, listJ.get(i6).getId(), dataToken);
        }
        return categoryUsingTimeStatsArr;
    }

    public long k(int i5, int i6, DataToken dataToken) throws Throwable {
        Long l5;
        c(i5, dataToken);
        if (!com.stepos.digitalwellbeing.server.transaction.usagstats.alphame.c.t()) {
            CategoryUsingTimeStats categoryUsingTimeStatsL = l(i5, i6, dataToken);
            if (categoryUsingTimeStatsL == null) {
                return 0L;
            }
            return categoryUsingTimeStatsL.getUsingTime();
        }
        StatsDataSet statsDataSet = this.f16677t;
        Map<String, Long> categoryUsingTimeMap = statsDataSet == null ? null : statsDataSet.getCategoryUsingTimeMap();
        if (categoryUsingTimeMap == null) {
            return 0L;
        }
        String strB = W1.a.b(i6);
        if (categoryUsingTimeMap.containsKey(strB) && (l5 = categoryUsingTimeMap.get(strB)) != null) {
            return l5.longValue();
        }
        return 0L;
    }

    public CategoryUsingTimeStats l(int i5, int i6, DataToken dataToken) throws Throwable {
        Category categoryK = this.f16683z.k(i6);
        if (categoryK == null || dataToken == null) {
            return null;
        }
        List<String> packages = categoryK.getPackages();
        long updateTime = dataToken.getUpdateTime();
        Iterator<String> it = packages.iterator();
        long j5 = 0;
        long usingTime = 0;
        while (it.hasNext()) {
            PackageUsingTimeStats packageUsingTimeStatsQ = q(i5, it.next(), dataToken);
            if (packageUsingTimeStatsQ != null) {
                long startTime = packageUsingTimeStatsQ.getStartTime();
                usingTime += packageUsingTimeStatsQ.getUsingTime();
                j5 = startTime;
            }
        }
        return new CategoryUsingTimeStats(i5, j5, updateTime, usingTime, i6);
    }

    public long m(int i5, DataToken dataToken) {
        c(i5, dataToken);
        if (!com.stepos.digitalwellbeing.server.transaction.usagstats.alphame.c.t()) {
            return i5 == com.stepos.digitalwellbeing.server.data.a.DAY.ordinal() ? C0712q.b(this.f16662e) : C0712q.b(this.f16663f);
        }
        StatsDataSet statsDataSet = this.f16677t;
        return statsDataSet == null ? SystemClock.elapsedRealtime() : statsDataSet.getUsingTime();
    }

    public PackageNotificationTimesStats[] o(int i5, String str, DataToken dataToken) throws Throwable {
        c(i5, dataToken);
        if (i5 == com.stepos.digitalwellbeing.server.data.a.DAY.ordinal()) {
            HashMap<String, PackageNotificationTimesStats[]> map = this.f16673p;
            if (map == null) {
                return null;
            }
            return map.get(str);
        }
        HashMap<String, PackageNotificationTimesStats[]> map2 = this.f16675r;
        if (map2 == null) {
            return null;
        }
        return map2.get(str);
    }

    public long p(int i5, String str, DataToken dataToken) throws Throwable {
        Long l5;
        c(i5, dataToken);
        if (!com.stepos.digitalwellbeing.server.transaction.usagstats.alphame.c.t()) {
            PackageUsingTimeStats packageUsingTimeStatsQ = q(i5, str, dataToken);
            if (packageUsingTimeStatsQ == null) {
                return 0L;
            }
            return packageUsingTimeStatsQ.getUsingTime();
        }
        StatsDataSet statsDataSet = this.f16677t;
        Map<String, Long> packageUsingTimeMap = statsDataSet == null ? null : statsDataSet.getPackageUsingTimeMap();
        if (packageUsingTimeMap == null || !packageUsingTimeMap.containsKey(str) || (l5 = packageUsingTimeMap.get(str)) == null) {
            return 0L;
        }
        return l5.longValue();
    }

    public PackageUsingTimeStats q(int i5, String str, DataToken dataToken) throws Throwable {
        c(i5, dataToken);
        if (i5 == com.stepos.digitalwellbeing.server.data.a.DAY.ordinal()) {
            HashMap<String, PackageUsingTimeStats> map = this.f16668k;
            if (map == null) {
                return null;
            }
            return map.get(str);
        }
        HashMap<String, PackageUsingTimeStats> map2 = this.f16669l;
        if (map2 == null) {
            return null;
        }
        return map2.get(str);
    }

    public PackageUsingTimeStats[] r(int i5, String str, DataToken dataToken) throws Throwable {
        c(i5, dataToken);
        if (i5 == com.stepos.digitalwellbeing.server.data.a.DAY.ordinal()) {
            HashMap<String, PackageUsingTimeStats[]> map = this.f16672o;
            if (map == null) {
                return null;
            }
            return map.get(str);
        }
        HashMap<String, PackageUsingTimeStats[]> map2 = this.f16674q;
        if (map2 == null) {
            return null;
        }
        return map2.get(str);
    }

    public PackageNotificationTimesStats[] s(int i5, DataToken dataToken) throws Throwable {
        c(i5, dataToken);
        return i5 == com.stepos.digitalwellbeing.server.data.a.DAY.ordinal() ? (PackageNotificationTimesStats[]) I(PackageNotificationTimesStats.class, this.f16670m) : (PackageNotificationTimesStats[]) I(PackageNotificationTimesStats.class, this.f16671n);
    }

    public PackageUsingTimeStats[] t(int i5, DataToken dataToken) throws Throwable {
        c(i5, dataToken);
        return i5 == com.stepos.digitalwellbeing.server.data.a.DAY.ordinal() ? (PackageUsingTimeStats[]) I(PackageUsingTimeStats.class, this.f16668k) : (PackageUsingTimeStats[]) I(PackageUsingTimeStats.class, this.f16669l);
    }

    public NotificationTimesStats[] u(int i5, DataToken dataToken) throws Throwable {
        c(i5, dataToken);
        return i5 == com.stepos.digitalwellbeing.server.data.a.DAY.ordinal() ? this.f16664g : this.f16665h;
    }

    public UsingTimeStats[] v(int i5, DataToken dataToken) throws Throwable {
        try {
            c(i5, dataToken);
            if (i5 == com.stepos.digitalwellbeing.server.data.a.DAY.ordinal()) {
                StringBuilder sb = new StringBuilder();
                sb.append("FG_USAGE_TRACE END getPhoneUsingTimeStats DAY resultLength=");
                UsingTimeStats[] usingTimeStatsArr = this.f16662e;
                sb.append(usingTimeStatsArr != null ? usingTimeStatsArr.length : -1);
                C0702g.b("UsageManager", sb.toString());
                return this.f16662e;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("FG_USAGE_TRACE END getPhoneUsingTimeStats WEEK resultLength=");
            UsingTimeStats[] usingTimeStatsArr2 = this.f16663f;
            sb2.append(usingTimeStatsArr2 != null ? usingTimeStatsArr2.length : -1);
            C0702g.b("UsageManager", sb2.toString());
            return this.f16663f;
        } catch (IllegalArgumentException e6) {
            C0702g.p("UsageManager", "getPhoneUsingTimeStats invalid token interval=" + i5 + ", token=" + dataToken);
            e6.printStackTrace();
            return new UsingTimeStats[0];
        }
    }

    public PickupTimesStats[] w(int i5, DataToken dataToken) throws Throwable {
        c(i5, dataToken);
        return i5 == com.stepos.digitalwellbeing.server.data.a.DAY.ordinal() ? this.f16666i : this.f16667j;
    }

    public StatsDataSet[] x(DataToken dataToken) {
        a(dataToken);
        StatsDataSet[] statsDataSetArrL = L();
        if (statsDataSetArrL == null) {
            R1.a.l("UsageManager", "getStatsDataSets cache released by concurrent refresh, reload");
            H(com.stepos.digitalwellbeing.server.data.a.LAST_TWO_WEEK.ordinal(), true);
            statsDataSetArrL = L();
        }
        if (B(f(statsDataSetArrL, C0711p.y())) && B(this.f16677t)) {
            H(com.stepos.digitalwellbeing.server.data.a.DAY.ordinal(), false);
            statsDataSetArrL = L();
        }
        K(statsDataSetArrL);
        return statsDataSetArrL;
    }

    public DataToken y(int i5) {
        b(i5);
        return i5 == com.stepos.digitalwellbeing.server.data.a.DAY.ordinal() ? com.stepos.digitalwellbeing.server.transaction.usagstats.alphame.c.w() ? this.f16682y : this.f16679v : this.f16680w;
    }
}
