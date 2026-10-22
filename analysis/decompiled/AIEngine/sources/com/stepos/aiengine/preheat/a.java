package com.stepos.aiengine.preheat;

import android.os.SystemClock;
import androidx.appcompat.widget.y0;
import b6.b;
import com.stepos.core.ability.speech.AsrFilePcmSegmentPolicy;
import com.stepos.core.ability.speech.TtsCloudConfig;
import com.stepos.core.common.loadguard.PreheatLoadBudget;
import com.stepos.core.common.log.AIEngineLogger;
import com.stepos.core.common.log.LogModule;
import com.stepos.core.model.manifest.ModelManifest;
import com.stepos.core.ota.process.OtaIdleExitPolicy;
import com.tencent.mmkv.MMKV;
import dc.h;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Result;
import kotlin.c;
import kotlin.jvm.internal.g;
import lb.d;
import lb.n;
import mb.l;
import mb.m;
import mb.v;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: q, reason: collision with root package name */
    public static volatile a f5912q;

    /* renamed from: a, reason: collision with root package name */
    public final b6.a f5913a;

    /* renamed from: b, reason: collision with root package name */
    public final b f5914b;

    /* renamed from: c, reason: collision with root package name */
    public final l6.a f5915c;

    /* renamed from: d, reason: collision with root package name */
    public final com.stepos.aiengine.b f5916d;

    /* renamed from: e, reason: collision with root package name */
    public final zb.a<Double> f5917e;

    /* renamed from: f, reason: collision with root package name */
    public final ConcurrentHashMap.KeySetView f5918f;

    /* renamed from: g, reason: collision with root package name */
    public final ConcurrentLinkedDeque<String> f5919g;
    public final ConcurrentHashMap<String, AtomicLong> h;

    /* renamed from: i, reason: collision with root package name */
    public final ConcurrentHashMap<String, AtomicLong> f5920i;

    /* renamed from: j, reason: collision with root package name */
    public final Object f5921j;

    /* renamed from: k, reason: collision with root package name */
    public ScheduledExecutorService f5922k;

    /* renamed from: l, reason: collision with root package name */
    public ScheduledFuture<?> f5923l;

    /* renamed from: m, reason: collision with root package name */
    public long f5924m;

    /* renamed from: n, reason: collision with root package name */
    public final d f5925n;

    /* renamed from: o, reason: collision with root package name */
    public static final C0040a f5910o = new C0040a();

    /* renamed from: p, reason: collision with root package name */
    public static final long[] f5911p = {AsrFilePcmSegmentPolicy.MAX_SEGMENT_MS, TtsCloudConfig.DEFAULT_AUDIO_FIRST_FRAME_BUDGET_MS, 600000, OtaIdleExitPolicy.TERMINAL_IDLE_MS};
    public static final SimpleDateFormat r = new SimpleDateFormat("MM-dd HH:mm:ss", Locale.US);

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    /* renamed from: com.stepos.aiengine.preheat.a$a, reason: collision with other inner class name */
    public static final class C0040a {
        public static final String a(C0040a c0040a, long j10) {
            Object objA;
            c0040a.getClass();
            try {
                objA = a.r.format(new Date(j10));
            } catch (Throwable th) {
                objA = c.a(th);
            }
            Object objValueOf = String.valueOf(j10);
            if (objA instanceof Result.Failure) {
                objA = objValueOf;
            }
            return (String) objA;
        }
    }

    public a() {
        throw null;
    }

    public a(b6.a aVar, b bVar, l6.a aVar2, com.stepos.aiengine.b bVar2) {
        PreheatGateController$1 preheatGateController$1 = new PreheatGateController$1(0, PreheatLoadBudget.INSTANCE, PreheatLoadBudget.class, "readMemAvailableRatio", "readMemAvailableRatio()Ljava/lang/Double;", 0);
        this.f5913a = aVar;
        this.f5914b = bVar;
        this.f5915c = aVar2;
        this.f5916d = bVar2;
        this.f5917e = preheatGateController$1;
        ConcurrentHashMap.KeySetView keySetViewNewKeySet = ConcurrentHashMap.newKeySet();
        g.e(keySetViewNewKeySet, "newKeySet(...)");
        this.f5918f = keySetViewNewKeySet;
        this.f5919g = new ConcurrentLinkedDeque<>();
        this.h = new ConcurrentHashMap<>();
        this.f5920i = new ConcurrentHashMap<>();
        this.f5921j = new Object();
        this.f5925n = kotlin.b.b(new com.stepos.cpuset.b(8));
    }

    public final void a(PrintWriter printWriter) {
        Object objA;
        Object objA2;
        Object objA3;
        long j10;
        String str;
        printWriter.println("=== Preheat Gate ===");
        try {
            objA = this.f5913a.invoke();
        } catch (Throwable th) {
            objA = c.a(th);
        }
        if (objA instanceof Result.Failure) {
            objA = null;
        }
        try {
            objA2 = this.f5914b.invoke();
        } catch (Throwable th2) {
            objA2 = c.a(th2);
        }
        if (objA2 instanceof Result.Failure) {
            objA2 = null;
        }
        printWriter.println("  pressure       : level=" + objA + " sdkCallbackArrived=" + objA2);
        try {
            objA3 = this.f5917e.invoke();
        } catch (Throwable th3) {
            objA3 = c.a(th3);
        }
        if (objA3 instanceof Result.Failure) {
            objA3 = null;
        }
        Double d8 = (Double) objA3;
        printWriter.println("  memAvailable   : " + (d8 != null ? String.format("%.1f%%", Arrays.copyOf(new Object[]{Double.valueOf(d8.doubleValue() * 100)}, 1)) : "n/a") + " (lowThreshold=1.0%)");
        printWriter.println("  pending        : " + this.f5918f);
        int iC = c();
        long[] jArr = f5911p;
        int i10 = 0;
        printWriter.println("  backoffLevel   : " + iC + " (next interval=" + (jArr[h.a0(iC, 0, l.f0(jArr))] / 1000) + "s)");
        synchronized (this.f5921j) {
            j10 = this.f5924m;
        }
        if (j10 > 0) {
            str = (j10 - SystemClock.elapsedRealtime()) + "ms";
        } else {
            str = ModelManifest.BACKEND_NONE;
        }
        com.stepos.core.ota.d.r("  nextRetryIn    : ", str, printWriter);
        ConcurrentHashMap<String, AtomicLong> concurrentHashMap = this.h;
        LinkedHashMap linkedHashMap = new LinkedHashMap(v.a0(concurrentHashMap.size()));
        Iterator<T> it = concurrentHashMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            linkedHashMap.put(entry.getKey(), Long.valueOf(((AtomicLong) entry.getValue()).get()));
        }
        printWriter.println("  denyByReason   : " + linkedHashMap);
        ConcurrentHashMap<String, AtomicLong> concurrentHashMap2 = this.f5920i;
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(v.a0(concurrentHashMap2.size()));
        Iterator<T> it2 = concurrentHashMap2.entrySet().iterator();
        while (it2.hasNext()) {
            Map.Entry entry2 = (Map.Entry) it2.next();
            linkedHashMap2.put(entry2.getKey(), Long.valueOf(((AtomicLong) entry2.getValue()).get()));
        }
        printWriter.println("  recoverTrigger : " + linkedHashMap2);
        l6.a aVar = this.f5915c;
        long jCurrentTimeMillis = System.currentTimeMillis();
        List<Long> listB = aVar.b();
        if (listB == null || !listB.isEmpty()) {
            Iterator<T> it3 = listB.iterator();
            while (it3.hasNext()) {
                long jLongValue = jCurrentTimeMillis - ((Number) it3.next()).longValue();
                if (0 <= jLongValue && jLongValue <= 600000 && (i10 = i10 + 1) < 0) {
                    m.e0();
                    throw null;
                }
            }
        }
        List<Long> listB2 = this.f5915c.b();
        ArrayList arrayList = new ArrayList(m.Z(listB2, 10));
        Iterator<T> it4 = listB2.iterator();
        while (it4.hasNext()) {
            arrayList.add(C0040a.a(f5910o, ((Number) it4.next()).longValue()));
        }
        printWriter.println("  restarts(10min): " + i10 + " recent=" + arrayList);
        printWriter.println("  recentDecisions:");
        Iterator<String> it5 = this.f5919g.iterator();
        while (it5.hasNext()) {
            com.stepos.core.ota.d.r("    ", it5.next(), printWriter);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0079  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean b(java.lang.String r9) {
        /*
            Method dump skipped, instructions count: 246
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.aiengine.preheat.a.b(java.lang.String):boolean");
    }

    public final int c() {
        Object objA;
        try {
            MMKV mmkv = (MMKV) this.f5925n.getValue();
            objA = Integer.valueOf(mmkv != null ? mmkv.e(0, "preheat_backoff_level") : 0);
        } catch (Throwable th) {
            objA = c.a(th);
        }
        if (objA instanceof Result.Failure) {
            objA = 0;
        }
        return ((Number) objA).intValue();
    }

    public final void d(String str, String str2) {
        AtomicLong atomicLongPutIfAbsent;
        e("DENY  " + str + " reason=" + str2);
        ConcurrentHashMap<String, AtomicLong> concurrentHashMap = this.h;
        AtomicLong atomicLong = concurrentHashMap.get(str2);
        if (atomicLong == null && (atomicLongPutIfAbsent = concurrentHashMap.putIfAbsent(str2, (atomicLong = new AtomicLong()))) != null) {
            atomicLong = atomicLongPutIfAbsent;
        }
        atomicLong.incrementAndGet();
        ConcurrentHashMap.KeySetView keySetView = this.f5918f;
        keySetView.add(str);
        LogModule logModule = LogModule.SERVICE;
        StringBuilder sbS = ai.onnxruntime.a.s("preheat denied: model=", str, " reason=", str2, " (pending=");
        sbS.append(keySetView);
        sbS.append(")");
        AIEngineLogger.w(logModule, "PreheatGateController", sbS.toString());
        int iC = c();
        long[] jArr = f5911p;
        f(jArr[h.a0(iC, 0, l.f0(jArr))]);
    }

    public final void e(String str) {
        String str2 = C0040a.a(f5910o, System.currentTimeMillis()) + " " + str;
        ConcurrentLinkedDeque<String> concurrentLinkedDeque = this.f5919g;
        concurrentLinkedDeque.addFirst(str2);
        while (concurrentLinkedDeque.size() > 20) {
            concurrentLinkedDeque.pollLast();
        }
    }

    public final void f(long j10) {
        synchronized (this.f5921j) {
            long jElapsedRealtime = SystemClock.elapsedRealtime() + j10;
            ScheduledFuture<?> scheduledFuture = this.f5923l;
            if (scheduledFuture == null || scheduledFuture.isDone() || this.f5924m > jElapsedRealtime) {
                if (scheduledFuture != null) {
                    scheduledFuture.cancel(false);
                }
                ScheduledExecutorService scheduledExecutorServiceNewSingleThreadScheduledExecutor = this.f5922k;
                if (scheduledExecutorServiceNewSingleThreadScheduledExecutor == null) {
                    scheduledExecutorServiceNewSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor(new a6.d(5));
                    this.f5922k = scheduledExecutorServiceNewSingleThreadScheduledExecutor;
                }
                this.f5924m = jElapsedRealtime;
                this.f5923l = scheduledExecutorServiceNewSingleThreadScheduledExecutor.schedule(new y0(this, 12), j10, TimeUnit.MILLISECONDS);
                n nVar = n.f10413a;
            }
        }
    }
}
