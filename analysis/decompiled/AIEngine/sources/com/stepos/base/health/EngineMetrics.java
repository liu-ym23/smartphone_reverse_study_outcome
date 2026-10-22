package com.stepos.base.health;

import android.os.SystemClock;
import androidx.preference.c;
import com.stepos.base.concurrency.data.PoolType;
import dc.h;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.enums.a;
import kotlin.jvm.internal.g;
import lb.n;
import mb.v;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class EngineMetrics {
    public static final AtomicLong A;
    public static final AtomicLong B;
    public static final AtomicLong C;
    public static final AtomicLong D;
    public static final AtomicLong E;
    public static final c F;
    public static final AtomicLong G;
    public static final AtomicLong H;
    public static final AtomicLong I;
    public static final AtomicLong J;
    public static final AtomicLong K;
    public static final AtomicLong L;
    public static final AtomicLong M;
    public static final AtomicLong N;
    public static final c O;
    public static final AtomicLong P;
    public static final AtomicLong Q;
    public static final c R;
    public static final ConcurrentHashMap<String, long[]> S;
    public static final ConcurrentHashMap<String, Integer> T;
    public static final ConcurrentHashMap<String, Integer> U;
    public static final ConcurrentHashMap<String, Object> V;

    /* renamed from: a, reason: collision with root package name */
    public static final AtomicLong f6226a = new AtomicLong(0);

    /* renamed from: b, reason: collision with root package name */
    public static final AtomicLong f6227b = new AtomicLong(0);

    /* renamed from: c, reason: collision with root package name */
    public static final AtomicInteger f6228c = new AtomicInteger(0);

    /* renamed from: d, reason: collision with root package name */
    public static final AtomicLong f6229d = new AtomicLong(0);

    /* renamed from: e, reason: collision with root package name */
    public static final LinkedHashMap f6230e;

    /* renamed from: f, reason: collision with root package name */
    public static final ConcurrentHashMap<Integer, AtomicLong> f6231f;

    /* renamed from: g, reason: collision with root package name */
    public static final AtomicLong f6232g;
    public static final AtomicLong h;

    /* renamed from: i, reason: collision with root package name */
    public static final AtomicLong f6233i;

    /* renamed from: j, reason: collision with root package name */
    public static final AtomicLong f6234j;

    /* renamed from: k, reason: collision with root package name */
    public static final AtomicLong f6235k;

    /* renamed from: l, reason: collision with root package name */
    public static final AtomicLong f6236l;

    /* renamed from: m, reason: collision with root package name */
    public static final AtomicLong f6237m;

    /* renamed from: n, reason: collision with root package name */
    public static final AtomicLong f6238n;

    /* renamed from: o, reason: collision with root package name */
    public static final AtomicLong f6239o;

    /* renamed from: p, reason: collision with root package name */
    public static final AtomicLong f6240p;

    /* renamed from: q, reason: collision with root package name */
    public static final AtomicLong f6241q;
    public static final AtomicLong r;

    /* renamed from: s, reason: collision with root package name */
    public static final c f6242s;

    /* renamed from: t, reason: collision with root package name */
    public static final AtomicLong f6243t;

    /* renamed from: u, reason: collision with root package name */
    public static final AtomicLong f6244u;

    /* renamed from: v, reason: collision with root package name */
    public static final AtomicLong f6245v;

    /* renamed from: w, reason: collision with root package name */
    public static final AtomicLong f6246w;

    /* renamed from: x, reason: collision with root package name */
    public static final AtomicLong f6247x;

    /* renamed from: y, reason: collision with root package name */
    public static final AtomicLong f6248y;
    public static final AtomicLong z;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class HealthStatus {

        /* renamed from: a, reason: collision with root package name */
        public static final HealthStatus f6249a;

        /* renamed from: b, reason: collision with root package name */
        public static final HealthStatus f6250b;

        /* renamed from: c, reason: collision with root package name */
        public static final HealthStatus f6251c;

        /* renamed from: d, reason: collision with root package name */
        public static final /* synthetic */ HealthStatus[] f6252d;

        static {
            HealthStatus healthStatus = new HealthStatus("HEALTHY", 0);
            f6249a = healthStatus;
            HealthStatus healthStatus2 = new HealthStatus("DEGRADED", 1);
            f6250b = healthStatus2;
            HealthStatus healthStatus3 = new HealthStatus("CRITICAL", 2);
            f6251c = healthStatus3;
            HealthStatus[] healthStatusArr = {healthStatus, healthStatus2, healthStatus3};
            f6252d = healthStatusArr;
            a.a(healthStatusArr);
        }

        public HealthStatus() {
            throw null;
        }

        public static HealthStatus valueOf(String str) {
            return (HealthStatus) Enum.valueOf(HealthStatus.class, str);
        }

        public static HealthStatus[] values() {
            return (HealthStatus[]) f6252d.clone();
        }
    }

    static {
        PoolType[] poolTypeArrValues = PoolType.values();
        int iA0 = v.a0(poolTypeArrValues.length);
        if (iA0 < 16) {
            iA0 = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iA0);
        for (PoolType poolType : poolTypeArrValues) {
            linkedHashMap.put(poolType, new AtomicLong(0L));
        }
        f6230e = linkedHashMap;
        f6231f = new ConcurrentHashMap<>();
        f6232g = new AtomicLong(0L);
        h = new AtomicLong(0L);
        f6233i = new AtomicLong(0L);
        f6234j = new AtomicLong(0L);
        f6235k = new AtomicLong(0L);
        f6236l = new AtomicLong(0L);
        f6237m = new AtomicLong(0L);
        f6238n = new AtomicLong(0L);
        f6239o = new AtomicLong(0L);
        f6240p = new AtomicLong(0L);
        f6241q = new AtomicLong(0L);
        new AtomicLong(0L);
        new AtomicLong(0L);
        r = new AtomicLong(0L);
        f6242s = new c(6);
        f6243t = new AtomicLong(0L);
        f6244u = new AtomicLong(0L);
        f6245v = new AtomicLong(0L);
        f6246w = new AtomicLong(0L);
        f6247x = new AtomicLong(0L);
        f6248y = new AtomicLong(0L);
        z = new AtomicLong(0L);
        A = new AtomicLong(0L);
        B = new AtomicLong(0L);
        C = new AtomicLong(0L);
        D = new AtomicLong(0L);
        E = new AtomicLong(0L);
        F = new c(6);
        G = new AtomicLong(0L);
        H = new AtomicLong(0L);
        I = new AtomicLong(0L);
        J = new AtomicLong(0L);
        K = new AtomicLong(0L);
        L = new AtomicLong(0L);
        M = new AtomicLong(0L);
        N = new AtomicLong(0L);
        O = new c(6);
        P = new AtomicLong(0L);
        Q = new AtomicLong(0L);
        R = new c(6);
        S = new ConcurrentHashMap<>();
        T = new ConcurrentHashMap<>();
        U = new ConcurrentHashMap<>();
        V = new ConcurrentHashMap<>();
    }

    public static void a(long j10, String abilityId, boolean z3) {
        long[] jArrPutIfAbsent;
        Object objPutIfAbsent;
        g.f(abilityId, "abilityId");
        f6228c.decrementAndGet();
        if (z3) {
            f6227b.incrementAndGet();
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime() - j10;
        ConcurrentHashMap<String, Object> concurrentHashMap = V;
        Object obj = concurrentHashMap.get(abilityId);
        if (obj == null && (objPutIfAbsent = concurrentHashMap.putIfAbsent(abilityId, (obj = new Object()))) != null) {
            obj = objPutIfAbsent;
        }
        synchronized (obj) {
            try {
                ConcurrentHashMap<String, long[]> concurrentHashMap2 = S;
                long[] jArr = concurrentHashMap2.get(abilityId);
                if (jArr == null && (jArrPutIfAbsent = concurrentHashMap2.putIfAbsent(abilityId, (jArr = new long[100]))) != null) {
                    jArr = jArrPutIfAbsent;
                }
                ConcurrentHashMap<String, Integer> concurrentHashMap3 = T;
                Integer orDefault = concurrentHashMap3.getOrDefault(abilityId, 0);
                g.e(orDefault, "getOrDefault(...)");
                int iIntValue = orDefault.intValue();
                jArr[iIntValue] = jElapsedRealtime;
                concurrentHashMap3.put(abilityId, Integer.valueOf((iIntValue + 1) % 100));
                ConcurrentHashMap<String, Integer> concurrentHashMap4 = U;
                Integer orDefault2 = concurrentHashMap4.getOrDefault(abilityId, 0);
                g.e(orDefault2, "getOrDefault(...)");
                int iIntValue2 = orDefault2.intValue();
                if (iIntValue2 < 100) {
                    concurrentHashMap4.put(abilityId, Integer.valueOf(iIntValue2 + 1));
                }
                n nVar = n.f10413a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static long b(int i10, String str) {
        Object obj = V.get(str);
        long j10 = -1;
        if (obj == null) {
            return -1L;
        }
        synchronized (obj) {
            long[] jArr = S.get(str);
            if (jArr != null) {
                Integer orDefault = U.getOrDefault(str, 0);
                g.e(orDefault, "getOrDefault(...)");
                int iIntValue = orDefault.intValue();
                if (iIntValue != 0) {
                    long[] jArrCopyOf = Arrays.copyOf(jArr, iIntValue);
                    g.e(jArrCopyOf, "copyOf(...)");
                    if (jArrCopyOf.length > 1) {
                        Arrays.sort(jArrCopyOf);
                    }
                    int i11 = iIntValue - 1;
                    j10 = jArrCopyOf[h.a0((int) ((i10 / 100.0d) * i11), 0, i11)];
                }
            }
        }
        return j10;
    }
}
