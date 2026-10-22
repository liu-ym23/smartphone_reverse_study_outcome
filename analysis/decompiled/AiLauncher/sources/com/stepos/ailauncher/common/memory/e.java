package com.stepos.ailauncher.common.memory;

import Y8.t;
import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Debug;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.common.imageloader.g;
import com.zyql.ai.selector.config.PictureConfig;
import h8.C4148a;
import io.ktor.http.ContentType;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;
import v9.C5685n;

@Metadata(d1 = {"\u0000\u0081\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0006*\u0001A\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002DEB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\nJ\u0017\u0010\f\u001a\u00020\b2\b\b\u0002\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\f\u0010\nJ\u0019\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0010\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\u0010\u0010\u000fJ\u001f\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\r2\b\b\u0002\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0017\u0010\u0018J\u0015\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0019\u0010\u0018J\u0015\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001c\u0010\u001dJ7\u0010#\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\u001e2\b\b\u0002\u0010 \u001a\u00020\b2\u0016\b\u0002\u0010\"\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0016\u0018\u00010!¢\u0006\u0004\b#\u0010$J\u0017\u0010%\u001a\u00020\u00162\u0006\u0010\u0011\u001a\u00020\rH\u0002¢\u0006\u0004\b%\u0010&R\u0014\u0010(\u001a\u00020'8\u0002X\u0082T¢\u0006\u0006\n\u0004\b(\u0010)R\u0014\u0010+\u001a\u00020*8\u0006X\u0086T¢\u0006\u0006\n\u0004\b+\u0010,R\u0014\u0010.\u001a\u00020-8\u0006X\u0086T¢\u0006\u0006\n\u0004\b.\u0010/R\u0014\u00100\u001a\u00020-8\u0006X\u0086T¢\u0006\u0006\n\u0004\b0\u0010/R\u0014\u00101\u001a\u00020*8\u0006X\u0086T¢\u0006\u0006\n\u0004\b1\u0010,R\u0014\u00102\u001a\u00020*8\u0006X\u0086T¢\u0006\u0006\n\u0004\b2\u0010,R\u0014\u00103\u001a\u00020*8\u0002X\u0082T¢\u0006\u0006\n\u0004\b3\u0010,R\u0014\u00104\u001a\u00020*8\u0002X\u0082T¢\u0006\u0006\n\u0004\b4\u0010,R\u0014\u00106\u001a\u0002058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b6\u00107R\u001a\u00109\u001a\b\u0012\u0004\u0012\u00020\u0014088\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b9\u0010:R\u0018\u0010<\u001a\u0004\u0018\u00010;8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b<\u0010=R\u0018\u0010>\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010@\u001a\u00020*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010,R\u0014\u0010B\u001a\u00020A8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bB\u0010C¨\u0006F"}, d2 = {"Lcom/stepos/ailauncher/common/memory/e;", "", "<init>", "()V", "Lcom/stepos/ailauncher/common/memory/e$b;", "p", "()Lcom/stepos/ailauncher/common/memory/e$b;", "snap", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Lcom/stepos/ailauncher/common/memory/e$b;)Z", "k", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "", "n", "(Lcom/stepos/ailauncher/common/memory/e$b;)Ljava/lang/Integer;", "m", "level", "e", "(ILcom/stepos/ailauncher/common/memory/e$b;)I", "Lcom/stepos/ailauncher/common/memory/e$a;", "listener", "LY8/t;", "c", "(Lcom/stepos/ailauncher/common/memory/e$a;)V", "o", "Landroid/app/Application;", ContentType.Application.TYPE, Const.INTENT_KEY_BACKGROUND_COMMAND, "(Landroid/app/Application;)V", "Landroid/content/Context;", "context", "force", "Lkotlin/Function1;", "pageTrim", "q", "(Landroid/content/Context;ZLp9/l;)Z", Const.INTENT_KEY_UMID, "(I)V", "", "TAG", "Ljava/lang/String;", "", "ELEVATED_USED_BYTES", "J", "", "HIGH_RATIO", "D", "CRITICAL_RATIO", "NATIVE_HIGH_BYTES", "NATIVE_CRITICAL_BYTES", "MIN_TRIM_INTERVAL_MS", "WATCH_INTERVAL_MS", "Ljava/util/concurrent/atomic/AtomicBoolean;", "installed", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "pageTrimListeners", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Landroid/os/Handler;", "watchHandler", "Landroid/os/Handler;", "app", "Landroid/app/Application;", "lastTrimUptimeMs", "com/stepos/ailauncher/common/memory/e$d", "watchRunnable", "Lcom/stepos/ailauncher/common/memory/e$d;", Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_PKGNAME, "utils_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class e {
    public static final double CRITICAL_RATIO = 0.92d;
    public static final long ELEVATED_USED_BYTES = 188743680;
    public static final double HIGH_RATIO = 0.85d;
    private static final long MIN_TRIM_INTERVAL_MS = 5000;
    public static final long NATIVE_CRITICAL_BYTES = 402653184;
    public static final long NATIVE_HIGH_BYTES = 268435456;
    private static final String TAG = "HeapPressureGate";
    private static final long WATCH_INTERVAL_MS = 60000;
    private static Application app;
    private static volatile long lastTrimUptimeMs;
    private static Handler watchHandler;
    public static final e INSTANCE = new e();
    private static final AtomicBoolean installed = new AtomicBoolean(false);
    private static final CopyOnWriteArrayList<a> pageTrimListeners = new CopyOnWriteArrayList<>();
    private static final d watchRunnable = new d();

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007À\u0006\u0003"}, d2 = {"Lcom/stepos/ailauncher/common/memory/e$a;", "", "", "level", "LY8/t;", Const.INTENT_KEY_APIKEY, "(I)V", "utils_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface a {
        void a(int level);
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0006\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0012\u001a\u0004\b\u0015\u0010\u0014R\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0016\u0010\u0014R\u0011\u0010\u001a\u001a\u00020\u00178F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u001c\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0014R\u0011\u0010\u001e\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0014R\u0011\u0010 \u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0014¨\u0006!"}, d2 = {"Lcom/stepos/ailauncher/common/memory/e$b;", "", "", "usedBytes", "maxBytes", "nativeHeapBytes", "<init>", "(JJJ)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "J", "e", "()J", "getMaxBytes", Const.INTENT_KEY_PKGNAME, "", Const.INTENT_KEY_UMID, "()D", "ratio", "f", "usedMb", Const.INTENT_KEY_APIKEY, "maxMb", "c", "nativeHeapMb", "utils_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.common.memory.e$b, reason: from toString */
    public static final /* data */ class Snapshot {
        private final long maxBytes;
        private final long nativeHeapBytes;
        private final long usedBytes;

        public Snapshot(long j10, long j11, long j12) {
            this.usedBytes = j10;
            this.maxBytes = j11;
            this.nativeHeapBytes = j12;
        }

        public final long a() {
            return this.maxBytes / PictureConfig.MB;
        }

        /* renamed from: b, reason: from getter */
        public final long getNativeHeapBytes() {
            return this.nativeHeapBytes;
        }

        public final long c() {
            return this.nativeHeapBytes / PictureConfig.MB;
        }

        public final double d() {
            long j10 = this.maxBytes;
            if (j10 <= 0) {
                return 0.0d;
            }
            return this.usedBytes / j10;
        }

        /* renamed from: e, reason: from getter */
        public final long getUsedBytes() {
            return this.usedBytes;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Snapshot)) {
                return false;
            }
            Snapshot snapshot = (Snapshot) other;
            return this.usedBytes == snapshot.usedBytes && this.maxBytes == snapshot.maxBytes && this.nativeHeapBytes == snapshot.nativeHeapBytes;
        }

        public final long f() {
            return this.usedBytes / PictureConfig.MB;
        }

        public int hashCode() {
            return (((Long.hashCode(this.usedBytes) * 31) + Long.hashCode(this.maxBytes)) * 31) + Long.hashCode(this.nativeHeapBytes);
        }

        public String toString() {
            return "Snapshot(usedBytes=" + this.usedBytes + ", maxBytes=" + this.maxBytes + ", nativeHeapBytes=" + this.nativeHeapBytes + ")";
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0017¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"com/stepos/ailauncher/common/memory/e$c", "Landroid/content/ComponentCallbacks2;", "", "level", "LY8/t;", "onTrimMemory", "(I)V", "onLowMemory", "()V", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "utils_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class c implements ComponentCallbacks2 {
        final /* synthetic */ Application $application;

        public c(Application application) {
            this.$application = application;
        }

        @Override // android.content.ComponentCallbacks
        public void onConfigurationChanged(Configuration newConfig) {
            p.i(newConfig, "newConfig");
        }

        @Override // android.content.ComponentCallbacks
        public void onLowMemory() {
            e.r(e.INSTANCE, this.$application, true, null, 4, null);
        }

        @Override // android.content.ComponentCallbacks2
        public void onTrimMemory(int level) {
            if (level >= 20 || e.j(e.INSTANCE, null, 1, null)) {
                e.r(e.INSTANCE, this.$application, false, null, 4, null);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"com/stepos/ailauncher/common/memory/e$d", "Ljava/lang/Runnable;", "LY8/t;", "run", "()V", "utils_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class d implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            Application application = e.app;
            if (application != null) {
                e eVar = e.INSTANCE;
                if (e.j(eVar, null, 1, null)) {
                    e.r(eVar, application, false, null, 4, null);
                } else {
                    g.INSTANCE.x(application);
                }
            }
            Handler handler = e.watchHandler;
            if (handler != null) {
                handler.postDelayed(this, 60000L);
            }
        }
    }

    public static /* synthetic */ int f(e eVar, int i10, Snapshot snapshot, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            snapshot = eVar.p();
        }
        return eVar.e(i10, snapshot);
    }

    public static /* synthetic */ boolean j(e eVar, Snapshot snapshot, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            snapshot = eVar.p();
        }
        return eVar.i(snapshot);
    }

    public static /* synthetic */ boolean l(e eVar, Snapshot snapshot, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            snapshot = eVar.p();
        }
        return eVar.k(snapshot);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ boolean r(e eVar, Context context, boolean z10, InterfaceC5074l interfaceC5074l, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        if ((i10 & 4) != 0) {
            interfaceC5074l = null;
        }
        return eVar.q(context, z10, interfaceC5074l);
    }

    public final void c(a listener) {
        p.i(listener, "listener");
        CopyOnWriteArrayList<a> copyOnWriteArrayList = pageTrimListeners;
        if (copyOnWriteArrayList.contains(listener)) {
            return;
        }
        copyOnWriteArrayList.add(listener);
    }

    public final void d(int level) {
        Object objB;
        Iterator<a> it = pageTrimListeners.iterator();
        p.h(it, "iterator(...)");
        while (it.hasNext()) {
            a next = it.next();
            try {
                Result.Companion companion = Result.INSTANCE;
                next.a(level);
                objB = Result.b(t.f7040a);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objB = Result.b(C4849c.a(th));
            }
            Throwable thE = Result.e(objB);
            if (thE != null) {
                C4148a.t(TAG, "pageTrim listener failed", thE, false, 8, null);
            }
        }
    }

    public final int e(int level, Snapshot snap) {
        p.i(snap, "snap");
        return i(snap) ? Math.max(level, 20) : level;
    }

    public final void g(Application application) {
        p.i(application, "application");
        if (installed.compareAndSet(false, true)) {
            app = application;
            application.registerComponentCallbacks(new c(application));
            Handler handler = new Handler(Looper.getMainLooper());
            watchHandler = handler;
            handler.post(watchRunnable);
            C4148a.k(TAG, "installed watchInterval=60000ms", false, 4, null);
        }
    }

    public final boolean h(Snapshot snap) {
        p.i(snap, "snap");
        return snap.d() >= 0.92d || snap.getNativeHeapBytes() >= NATIVE_CRITICAL_BYTES;
    }

    public final boolean i(Snapshot snap) {
        p.i(snap, "snap");
        return snap.getUsedBytes() >= ELEVATED_USED_BYTES || k(snap);
    }

    public final boolean k(Snapshot snap) {
        p.i(snap, "snap");
        return snap.d() >= 0.85d || snap.getNativeHeapBytes() >= NATIVE_HIGH_BYTES;
    }

    public final Integer m(Snapshot snap) {
        p.i(snap, "snap");
        return i(snap) ? 20 : null;
    }

    public final Integer n(Snapshot snap) {
        p.i(snap, "snap");
        if (h(snap)) {
            return 80;
        }
        if (k(snap)) {
            return 10;
        }
        return i(snap) ? 20 : null;
    }

    public final void o(a listener) {
        p.i(listener, "listener");
        pageTrimListeners.remove(listener);
    }

    public final Snapshot p() {
        Object objB;
        Runtime runtime = Runtime.getRuntime();
        long jMaxMemory = runtime.maxMemory();
        long jG = C5685n.g(runtime.totalMemory() - runtime.freeMemory(), 0L);
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(Long.valueOf(Debug.getNativeHeapAllocatedSize()));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        if (Result.g(objB)) {
            objB = 0L;
        }
        return new Snapshot(jG, jMaxMemory, ((Number) objB).longValue());
    }

    public final boolean q(Context context, boolean force, InterfaceC5074l<? super Integer, t> pageTrim) {
        Object objB;
        t tVar;
        p.i(context, "context");
        Snapshot snapshotP = p();
        Integer numN = n(snapshotP);
        if (numN == null) {
            return false;
        }
        int iIntValue = numN.intValue();
        Integer numM = m(snapshotP);
        int iIntValue2 = numM != null ? numM.intValue() : iIntValue;
        long jUptimeMillis = SystemClock.uptimeMillis();
        if (!force && jUptimeMillis - lastTrimUptimeMs < 5000) {
            String str = String.format("%.2f", Arrays.copyOf(new Object[]{Double.valueOf(snapshotP.d())}, 1));
            p.h(str, "format(...)");
            C4148a.d(TAG, "trimIfHigh debounce skip ratio=" + str + " used=" + snapshotP.f() + "MB/" + snapshotP.a() + "MB native=" + snapshotP.c() + "MB", false, 4, null);
            return false;
        }
        lastTrimUptimeMs = jUptimeMillis;
        String str2 = String.format("%.2f", Arrays.copyOf(new Object[]{Double.valueOf(snapshotP.d())}, 1));
        p.h(str2, "format(...)");
        C4148a.u(TAG, "memory high → trim image=" + iIntValue + " page=" + iIntValue2 + " ratio=" + str2 + " used=" + snapshotP.f() + "MB/" + snapshotP.a() + "MB native=" + snapshotP.c() + "MB force=" + force, false, 4, null);
        g.INSTANCE.F(context, iIntValue);
        try {
            Result.Companion companion = Result.INSTANCE;
            if (pageTrim != null) {
                pageTrim.invoke(Integer.valueOf(iIntValue2));
                tVar = t.f7040a;
            } else {
                tVar = null;
            }
            objB = Result.b(tVar);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.t(TAG, "pageTrim failed", thE, false, 8, null);
        }
        d(iIntValue2);
        return true;
    }
}
