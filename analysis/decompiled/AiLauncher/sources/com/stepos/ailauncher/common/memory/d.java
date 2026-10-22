package com.stepos.ailauncher.common.memory;

import La.C0953c;
import La.H;
import O6.l;
import Y8.j;
import Y8.t;
import Z8.A;
import Z8.C1165m;
import Z8.C1173v;
import Z8.F;
import android.app.Application;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Process;
import android.os.SystemClock;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.common.memory.d;
import h8.C4148a;
import io.ktor.http.ContentType;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntUnaryOperator;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.jvm.internal.p;
import l9.i;
import l9.m;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002Z[B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u0004¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u0004¢\u0006\u0004\b\u000e\u0010\rJ\u0015\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0013\u0010\u0003J?\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001bH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\u0004H\u0002¢\u0006\u0004\b!\u0010 J\u0017\u0010#\u001a\u00020\u00142\u0006\u0010\"\u001a\u00020\u0004H\u0002¢\u0006\u0004\b#\u0010$J\u000f\u0010%\u001a\u00020\u0019H\u0002¢\u0006\u0004\b%\u0010&J\u0017\u0010(\u001a\u00020\u00042\u0006\u0010'\u001a\u00020\u0014H\u0002¢\u0006\u0004\b(\u0010)J\u0017\u0010+\u001a\u00020\u00192\u0006\u0010*\u001a\u00020\u0014H\u0002¢\u0006\u0004\b+\u0010,J\u0017\u0010.\u001a\u00020\u00042\u0006\u0010-\u001a\u00020\u0019H\u0002¢\u0006\u0004\b.\u0010/R\u0014\u00100\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b0\u00101R\u0014\u00102\u001a\u00020\u00148\u0002X\u0082T¢\u0006\u0006\n\u0004\b2\u00103R\u0014\u00104\u001a\u00020\u00148\u0002X\u0082T¢\u0006\u0006\n\u0004\b4\u00103R\u0014\u00105\u001a\u00020\u00148\u0002X\u0082T¢\u0006\u0006\n\u0004\b5\u00103R\u0014\u00106\u001a\u00020\u00148\u0002X\u0082T¢\u0006\u0006\n\u0004\b6\u00103R\u0014\u00107\u001a\u00020\u00148\u0002X\u0082T¢\u0006\u0006\n\u0004\b7\u00103R\u0014\u00108\u001a\u00020\u00148\u0002X\u0082T¢\u0006\u0006\n\u0004\b8\u00103R\u0014\u00109\u001a\u00020\u00148\u0002X\u0082T¢\u0006\u0006\n\u0004\b9\u00103R\u0014\u0010:\u001a\u00020\u00198\u0002X\u0082T¢\u0006\u0006\n\u0004\b:\u0010;R\u0014\u0010<\u001a\u00020\u00198\u0002X\u0082T¢\u0006\u0006\n\u0004\b<\u0010;R\u0014\u0010=\u001a\u00020\u00148\u0002X\u0082T¢\u0006\u0006\n\u0004\b=\u00103R\u0014\u0010?\u001a\u00020>8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b?\u0010@R&\u0010C\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060B0A8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bC\u0010DR \u0010G\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020F0E8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bG\u0010HR\u0014\u0010I\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bI\u0010JR\u001a\u0010M\u001a\b\u0012\u0004\u0012\u00020L0K8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bM\u0010NR\u0018\u0010P\u001a\u0004\u0018\u00010O8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bP\u0010QR\u0016\u0010R\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bR\u00103R\u0016\u0010S\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bS\u00103R\u0016\u0010T\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bT\u00103R\u0016\u0010U\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bU\u0010;R\u0016\u0010V\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bV\u0010WR\u0014\u0010X\u001a\u00020\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bX\u0010;R\u0014\u0010Y\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bY\u00101¨\u0006\\"}, d2 = {"Lcom/stepos/ailauncher/common/memory/d;", "", "<init>", "()V", "", "name", "Lcom/stepos/ailauncher/common/memory/d$a;", Const.JSON_KEY_PROVIDER, "LY8/t;", "s", "(Ljava/lang/String;Lcom/stepos/ailauncher/common/memory/d$a;)V", "kind", "v", "(Ljava/lang/String;)V", "w", "Landroid/app/Application;", ContentType.Application.TYPE, "k", "(Landroid/app/Application;)V", "u", "", "totalMb", "mappedKb", "unmappedKb", "importedKb", "", "objCount", "", "bytesAvailable", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(JJJJIZ)Ljava/lang/String;", "n", "()Ljava/lang/String;", "q", "path", "p", "(Ljava/lang/String;)J", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "()I", "kb", "o", "(J)Ljava/lang/String;", "mb", "m", "(J)I", "level", "l", "(I)Ljava/lang/String;", "TAG", "Ljava/lang/String;", "WARN_MB", "J", "HIGH_MB", "CRITICAL_MB", "SAMPLE_INTERVAL_MS", "RISING_REPORT_GAP_MS", "STEADY_REPORT_INTERVAL_MS", "HEARTBEAT_INTERVAL_MS", "RING_CAPACITY", "I", "OBJ_RISE_DELTA", "RISE_REPORT_GAP_MS", "Ljava/util/concurrent/atomic/AtomicBoolean;", "installed", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lkotlin/Pair;", "providers", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/concurrent/atomic/AtomicInteger;", "liveCounts", "Ljava/util/concurrent/ConcurrentHashMap;", "ringLock", "Ljava/lang/Object;", "LZ8/m;", "Lcom/stepos/ailauncher/common/memory/d$b;", "ring", "LZ8/m;", "Landroid/os/Handler;", "sampler", "Landroid/os/Handler;", "lastReportUptimeMs", "lastHeartbeatUptimeMs", "lastRiseUptimeMs", "lastLevel", "kgslBytesReadable", "Z", "pid", "kgslProcDir", Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_PKGNAME, "utils_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class d {
    private static final long CRITICAL_MB = 1800;
    private static final long HEARTBEAT_INTERVAL_MS = 120000;
    private static final long HIGH_MB = 1500;
    private static final int OBJ_RISE_DELTA = 150;
    private static final int RING_CAPACITY = 12;
    private static final long RISE_REPORT_GAP_MS = 30000;
    private static final long RISING_REPORT_GAP_MS = 30000;
    private static final long SAMPLE_INTERVAL_MS = 30000;
    private static final long STEADY_REPORT_INTERVAL_MS = 300000;
    private static final String TAG = "GpuMemGate";
    private static final long WARN_MB = 1200;
    private static volatile boolean kgslBytesReadable;
    private static final String kgslProcDir;
    private static volatile long lastHeartbeatUptimeMs;
    private static volatile int lastLevel;
    private static volatile long lastReportUptimeMs;
    private static volatile long lastRiseUptimeMs;
    private static final int pid;
    private static Handler sampler;
    public static final d INSTANCE = new d();
    private static final AtomicBoolean installed = new AtomicBoolean(false);
    private static final CopyOnWriteArrayList<Pair<String, a>> providers = new CopyOnWriteArrayList<>();
    private static final ConcurrentHashMap<String, AtomicInteger> liveCounts = new ConcurrentHashMap<>();
    private static final Object ringLock = new Object();
    private static final C1165m<Sample> ring = new C1165m<>();

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005À\u0006\u0003"}, d2 = {"Lcom/stepos/ailauncher/common/memory/d$a;", "", "", Const.INTENT_KEY_APIKEY, "()Ljava/lang/String;", "utils_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface a {
        String a();
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0016\b\u0082\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0012\u001a\u00020\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0014\u001a\u0004\b\u0017\u0010\u0016R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0018\u001a\u0004\b\u0019\u0010\u0010R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010\n\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u0010\u001d\u001a\u0004\b\u001e\u0010\u000e¨\u0006\u001f"}, d2 = {"Lcom/stepos/ailauncher/common/memory/d$b;", "", "", "elapsedMs", "totalMb", "", "objCount", "", "bytesAvailable", "", "live", "<init>", "(JJIZLjava/lang/String;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "J", Const.INTENT_KEY_PKGNAME, "()J", "e", "I", Const.INTENT_KEY_UMID, "Z", Const.INTENT_KEY_APIKEY, "()Z", "Ljava/lang/String;", "c", "utils_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.common.memory.d$b, reason: from toString */
    public static final /* data */ class Sample {
        private final boolean bytesAvailable;
        private final long elapsedMs;
        private final String live;
        private final int objCount;
        private final long totalMb;

        public Sample(long j10, long j11, int i10, boolean z10, String live) {
            p.i(live, "live");
            this.elapsedMs = j10;
            this.totalMb = j11;
            this.objCount = i10;
            this.bytesAvailable = z10;
            this.live = live;
        }

        /* renamed from: a, reason: from getter */
        public final boolean getBytesAvailable() {
            return this.bytesAvailable;
        }

        /* renamed from: b, reason: from getter */
        public final long getElapsedMs() {
            return this.elapsedMs;
        }

        /* renamed from: c, reason: from getter */
        public final String getLive() {
            return this.live;
        }

        /* renamed from: d, reason: from getter */
        public final int getObjCount() {
            return this.objCount;
        }

        /* renamed from: e, reason: from getter */
        public final long getTotalMb() {
            return this.totalMb;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Sample)) {
                return false;
            }
            Sample sample = (Sample) other;
            return this.elapsedMs == sample.elapsedMs && this.totalMb == sample.totalMb && this.objCount == sample.objCount && this.bytesAvailable == sample.bytesAvailable && p.d(this.live, sample.live);
        }

        public int hashCode() {
            return (((((((Long.hashCode(this.elapsedMs) * 31) + Long.hashCode(this.totalMb)) * 31) + Integer.hashCode(this.objCount)) * 31) + Boolean.hashCode(this.bytesAvailable)) * 31) + this.live.hashCode();
        }

        public String toString() {
            return "Sample(elapsedMs=" + this.elapsedMs + ", totalMb=" + this.totalMb + ", objCount=" + this.objCount + ", bytesAvailable=" + this.bytesAvailable + ", live=" + this.live + ")";
        }
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"com/stepos/ailauncher/common/memory/d$c", "Ljava/lang/Runnable;", "LY8/t;", "run", "()V", "", "probed", "Z", "utils_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class c implements Runnable {
        final /* synthetic */ Handler $handler;
        private boolean probed;

        public c(Handler handler) {
            this.$handler = handler;
        }

        @Override // java.lang.Runnable
        public void run() {
            Object objB;
            try {
                Result.Companion companion = Result.INSTANCE;
                if (!this.probed) {
                    boolean z10 = true;
                    this.probed = true;
                    d dVar = d.INSTANCE;
                    if (dVar.p(d.kgslProcDir + "/gpumem_mapped") < 0) {
                        if (dVar.p(d.kgslProcDir + "/gpumem_unmapped") < 0) {
                            z10 = false;
                        }
                    }
                    d.kgslBytesReadable = z10;
                    if (!d.kgslBytesReadable) {
                        C4148a.u(d.TAG, "kgsl bytes not readable at " + d.kgslProcDir + " (SELinux/机型差异) → 退化为归因心跳模式，后续不再重复探测该路径", false, 4, null);
                    }
                }
                d.INSTANCE.u();
                objB = Result.b(t.f7040a);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objB = Result.b(C4849c.a(th));
            }
            Throwable thE = Result.e(objB);
            if (thE != null) {
                C4148a.u(d.TAG, "sample failed: " + thE.getMessage(), false, 4, null);
            }
            this.$handler.postDelayed(this, 30000L);
        }
    }

    static {
        int iMyPid = Process.myPid();
        pid = iMyPid;
        kgslProcDir = "/sys/class/kgsl/kgsl/proc/" + iMyPid;
    }

    public static final CharSequence r(long j10, Sample s10) {
        String str;
        p.i(s10, "s");
        long elapsedMs = (j10 - s10.getElapsedMs()) / 1000;
        if (s10.getBytesAvailable()) {
            str = l.DATE_SEPARATOR + elapsedMs + "s:" + s10.getTotalMb() + "MB";
        } else {
            str = l.DATE_SEPARATOR + elapsedMs + "s:obj" + s10.getObjCount();
        }
        if (p.d(s10.getLive(), "none")) {
            return str;
        }
        return str + Const.STR_MART_JSON_BEGIN + s10.getLive() + "}";
    }

    public static final boolean t(String str, Pair pair) {
        return p.d(pair.e(), str);
    }

    public static final int x(int i10) {
        if (i10 > 0) {
            return i10 - 1;
        }
        return 0;
    }

    public final String i(long totalMb, long mappedKb, long unmappedKb, long importedKb, int objCount, boolean bytesAvailable) {
        Object objB;
        StringBuilder sb2 = new StringBuilder();
        if (bytesAvailable) {
            d dVar = INSTANCE;
            sb2.append("gpu=" + totalMb + "MB(mapped=" + dVar.o(mappedKb) + " unmapped=" + dVar.o(unmappedKb) + " imported=" + dVar.o(importedKb) + ") ");
        } else {
            sb2.append("gpu=n/a(kgsl bytes unreadable) ");
        }
        sb2.append("kgslObj=" + objCount + " pid=" + pid + " | live: ");
        sb2.append(INSTANCE.n());
        sb2.append(" | src: ");
        CopyOnWriteArrayList<Pair<String, a>> copyOnWriteArrayList = providers;
        if (copyOnWriteArrayList.isEmpty()) {
            sb2.append("none");
        } else {
            Iterator<T> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                Pair pair = (Pair) it.next();
                String str = (String) pair.a();
                a aVar = (a) pair.b();
                sb2.append(str);
                sb2.append('=');
                try {
                    Result.Companion companion = Result.INSTANCE;
                    objB = Result.b(aVar.a());
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    objB = Result.b(C4849c.a(th));
                }
                if (Result.g(objB)) {
                    objB = "?";
                }
                sb2.append((String) objB);
                sb2.append("  ");
            }
        }
        sb2.append("| recent[");
        sb2.append(INSTANCE.q());
        sb2.append(']');
        return sb2.toString();
    }

    public final int j() {
        Object objB;
        try {
            Result.Companion companion = Result.INSTANCE;
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("/proc/self/maps")), C0953c.UTF_8), com.stepos.agentframework.chatui.longtext.b.THRESHOLD);
            try {
                Iterator<String> it = m.d(bufferedReader).iterator();
                int i10 = 0;
                while (it.hasNext()) {
                    if (H.g0(it.next(), "/dev/kgsl", false, 2, null)) {
                        i10++;
                    }
                }
                t tVar = t.f7040a;
                l9.b.a(bufferedReader, null);
                objB = Result.b(Integer.valueOf(i10));
            } finally {
            }
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        if (Result.g(objB)) {
            objB = -1;
        }
        return ((Number) objB).intValue();
    }

    public final void k(Application application) {
        p.i(application, "application");
        if (installed.compareAndSet(false, true)) {
            HandlerThread handlerThread = new HandlerThread("gpu-mem-gate");
            handlerThread.start();
            Handler handler = new Handler(handlerThread.getLooper());
            sampler = handler;
            handler.post(new c(handler));
            C4148a.k(TAG, "installed interval=30000ms thresholds(MB)=1200/1500/1800 (bytes 不可读时只做归因心跳，不用对象数当量级阈值)", false, 4, null);
        }
    }

    public final String l(int level) {
        return level != 1 ? level != 2 ? level != 3 ? "NORMAL" : "CRITICAL" : "HIGH" : "WARN";
    }

    public final int m(long mb2) {
        if (mb2 >= 1800) {
            return 3;
        }
        if (mb2 >= 1500) {
            return 2;
        }
        return mb2 >= 1200 ? 1 : 0;
    }

    public final String n() {
        String str;
        Set<Map.Entry<String, AtomicInteger>> setEntrySet = liveCounts.entrySet();
        p.h(setEntrySet, "<get-entries>(...)");
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = setEntrySet.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            p.f(entry);
            Object key = entry.getKey();
            p.h(key, "component1(...)");
            String str2 = (String) key;
            Object value = entry.getValue();
            p.h(value, "component2(...)");
            int i10 = ((AtomicInteger) value).get();
            if (i10 > 0) {
                str = str2 + "=" + i10;
            } else {
                str = null;
            }
            if (str != null) {
                arrayList.add(str);
            }
        }
        return arrayList.isEmpty() ? "none" : F.A0(arrayList, Const.STR_MART_COMMA, null, null, 0, null, null, 62, null);
    }

    public final String o(long kb2) {
        if (kb2 < 0) {
            return "n/a";
        }
        return (kb2 / 1024) + "MB";
    }

    public final long p(String path) {
        Object objB;
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(Long.valueOf(Long.parseLong(H.D1(i.o(new File(path), null, 1, null)).toString()) / 1024));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        if (Result.g(objB)) {
            objB = -1L;
        }
        return ((Number) objB).longValue();
    }

    public final String q() {
        List listM1;
        final long jElapsedRealtime = SystemClock.elapsedRealtime();
        synchronized (ringLock) {
            listM1 = F.m1(ring);
        }
        return F.A0(listM1, Const.STR_MART_COMMA, null, null, 0, null, new InterfaceC5074l() { // from class: com.stepos.ailauncher.common.memory.c
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return d.r(jElapsedRealtime, (d.Sample) obj);
            }
        }, 30, null);
    }

    public final void s(final String name, a provider) {
        p.i(name, "name");
        p.i(provider, "provider");
        CopyOnWriteArrayList<Pair<String, a>> copyOnWriteArrayList = providers;
        A.L(copyOnWriteArrayList, new InterfaceC5074l() { // from class: com.stepos.ailauncher.common.memory.b
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Boolean.valueOf(d.t(name, (Pair) obj));
            }
        });
        copyOnWriteArrayList.add(j.a(name, provider));
    }

    public final void u() {
        C1165m<Sample> c1165m;
        Integer num;
        int i10;
        int i11;
        long jP = kgslBytesReadable ? p(kgslProcDir + "/gpumem_mapped") : -1L;
        long jP2 = kgslBytesReadable ? p(kgslProcDir + "/gpumem_unmapped") : -1L;
        long jP3 = kgslBytesReadable ? p(kgslProcDir + "/imported_mem") : -1L;
        boolean z10 = jP >= 0 || jP2 >= 0;
        List listP = C1173v.p(Long.valueOf(jP), Long.valueOf(jP2), Long.valueOf(jP3));
        ArrayList arrayList = new ArrayList();
        for (Object obj : listP) {
            if (((Number) obj).longValue() >= 0) {
                arrayList.add(obj);
            }
        }
        long jE1 = F.e1(arrayList) / 1024;
        int iM = z10 ? m(jE1) : 0;
        int iJ = (!z10 || iM >= 1) ? j() : -1;
        String strN = n();
        synchronized (ringLock) {
            try {
                ring.addLast(new Sample(SystemClock.elapsedRealtime(), jE1, iJ, z10, strN));
                while (true) {
                    c1165m = ring;
                    if (c1165m.size() <= 12) {
                        break;
                    } else {
                        c1165m.removeFirst();
                    }
                }
                t tVar = t.f7040a;
            } catch (Throwable th) {
                throw th;
            }
        }
        long jUptimeMillis = SystemClock.uptimeMillis();
        Integer numValueOf = null;
        if (z10) {
            boolean z11 = iM > lastLevel;
            long j10 = jUptimeMillis - lastReportUptimeMs;
            if (iM < 1 || ((!z11 || j10 < 30000) && j10 < 300000)) {
                i11 = iM;
            } else {
                lastReportUptimeMs = jUptimeMillis;
                i11 = iM;
                String str = "GPU_HIGH lvl=" + l(iM) + " " + i(jE1, jP, jP2, jP3, iJ, z10);
                if (i11 >= 3) {
                    C4148a.h(TAG, str, false, 4, null);
                } else {
                    C4148a.u(TAG, str, false, 4, null);
                }
            }
            lastLevel = i11;
            return;
        }
        long j11 = jP2;
        long j12 = jP3;
        long j13 = jP;
        synchronized (ringLock) {
            try {
                ArrayList arrayList2 = new ArrayList();
                for (Sample sample : c1165m) {
                    if (sample.getObjCount() >= 0) {
                        numValueOf = Integer.valueOf(sample.getObjCount());
                    }
                    if (numValueOf != null) {
                        arrayList2.add(numValueOf);
                    }
                    numValueOf = null;
                }
                num = (Integer) F.K0(arrayList2);
            } catch (Throwable th2) {
                throw th2;
            }
        }
        boolean z12 = iJ >= 0 && num != null && iJ - num.intValue() >= 150;
        Collection<AtomicInteger> collectionValues = liveCounts.values();
        p.h(collectionValues, "<get-values>(...)");
        Iterator<T> it = collectionValues.iterator();
        int i12 = 0;
        while (it.hasNext()) {
            i12 += ((AtomicInteger) it.next()).get();
        }
        if (z12 && jUptimeMillis - lastRiseUptimeMs >= 30000) {
            lastRiseUptimeMs = jUptimeMillis;
            lastHeartbeatUptimeMs = jUptimeMillis;
            p.f(num);
            i10 = 0;
            C4148a.u(TAG, "GPU_ATTR_RISE Δobj=" + (iJ - num.intValue()) + " " + i(jE1, j13, j11, j12, iJ, z10), false, 4, null);
        } else if (i12 <= 0 || jUptimeMillis - lastHeartbeatUptimeMs < HEARTBEAT_INTERVAL_MS) {
            i10 = 0;
        } else {
            lastHeartbeatUptimeMs = jUptimeMillis;
            i10 = 0;
            C4148a.u(TAG, "GPU_ATTR_HEARTBEAT " + i(jE1, j13, j11, j12, iJ, z10), false, 4, null);
        }
        lastLevel = i10;
    }

    public final void v(String kind) {
        AtomicInteger atomicIntegerPutIfAbsent;
        p.i(kind, "kind");
        try {
            Result.Companion companion = Result.INSTANCE;
            ConcurrentHashMap<String, AtomicInteger> concurrentHashMap = liveCounts;
            AtomicInteger atomicInteger = concurrentHashMap.get(kind);
            if (atomicInteger == null && (atomicIntegerPutIfAbsent = concurrentHashMap.putIfAbsent(kind, (atomicInteger = new AtomicInteger(0)))) != null) {
                atomicInteger = atomicIntegerPutIfAbsent;
            }
            Result.b(Integer.valueOf(atomicInteger.incrementAndGet()));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.b(C4849c.a(th));
        }
    }

    public final void w(String kind) {
        p.i(kind, "kind");
        try {
            Result.Companion companion = Result.INSTANCE;
            AtomicInteger atomicInteger = liveCounts.get(kind);
            Result.b(atomicInteger != null ? Integer.valueOf(atomicInteger.updateAndGet(new IntUnaryOperator() { // from class: com.stepos.ailauncher.common.memory.a
                @Override // java.util.function.IntUnaryOperator
                public final int applyAsInt(int i10) {
                    return d.x(i10);
                }
            })) : null);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.b(C4849c.a(th));
        }
    }
}
