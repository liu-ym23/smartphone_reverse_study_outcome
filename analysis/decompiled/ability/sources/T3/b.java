package T3;

import I4.l;
import N9.j;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.stepos.ability.commoninternal.DeviceIdPrefsUtils;
import com.stepos.taskrobot.llmapi.stepfun.TaskTimeouts;
import j9.m;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Result;
import kotlin.jvm.internal.k;

/* loaded from: classes3.dex */
public final class b extends c {
    public static final long[] k = {1000, 2000, 5000, 15000, 30000, 60000, TaskTimeouts.TAKEOVER_IDLE_MS};

    /* renamed from: a, reason: collision with root package name */
    public final Context f1205a;
    public final ScheduledExecutorService b;
    public final Handler c;
    public final CopyOnWriteArraySet d;
    public final CountDownLatch e;
    public final Object f;
    public volatile String g;
    public volatile boolean h;
    public final AtomicBoolean i;

    /* renamed from: j, reason: collision with root package name */
    public volatile int f1206j;

    public b(Context context) {
        k.f(context, "context");
        this.f1205a = context;
        ScheduledExecutorService scheduledExecutorServiceNewSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor(new A4.b(4));
        this.b = scheduledExecutorServiceNewSingleThreadScheduledExecutor;
        this.c = new Handler(Looper.getMainLooper());
        this.d = new CopyOnWriteArraySet();
        this.e = new CountDownLatch(1);
        this.f = new Object();
        this.i = new AtomicBoolean(false);
        scheduledExecutorServiceNewSingleThreadScheduledExecutor.execute(new a(this, 0));
    }

    @Override // T3.c
    public final String a() {
        String strC;
        String str = this.g;
        if (str != null) {
            return str;
        }
        synchronized (this.f) {
            strC = this.g;
            if (strC == null) {
                strC = c();
                this.g = strC;
            }
        }
        return strC;
    }

    public final void b(String str) {
        Object objA;
        Object objA2;
        this.i.set(false);
        try {
            objA = j.y(this.f1205a);
            if (objA == null) {
                objA = "";
            }
        } catch (Throwable th) {
            objA = kotlin.b.a(th);
        }
        Throwable thA = Result.a(objA);
        if (thA != null) {
            Log.w("DeviceIdManager", "getOAID threw: " + thA.getMessage(), thA);
        }
        String str2 = (String) (objA instanceof Result.Failure ? "" : objA);
        if (!m.s0(str2)) {
            this.f1206j = 0;
            String str3 = this.g;
            boolean z10 = !this.h;
            this.h = true;
            synchronized (this.f) {
                this.g = str2;
            }
            this.e.countDown();
            if (k.b(str3, str2)) {
                Log.i("DeviceIdManager", "applyOaid: oaid confirmed unchanged reason=" + str + " first=" + z10);
                return;
            }
            boolean zWrite = DeviceIdPrefsUtils.INSTANCE.write(this.f1205a, str2);
            StringBuilder sbL = androidx.constraintlayout.core.dsl.a.l("applyOaid: switched to oaid reason=", str, " hadPrevious=", " persisted=", str3 != null);
            sbL.append(zWrite);
            Log.i("DeviceIdManager", sbL.toString());
            this.c.post(new l(3, this, str2));
            return;
        }
        this.f1206j++;
        Log.w("DeviceIdManager", "fetchAndApply: oaid unavailable reason=" + str + " failures=" + this.f1206j);
        if (!this.i.compareAndSet(false, true)) {
            Log.d("DeviceIdManager", "scheduleRetry: already scheduled");
            return;
        }
        int i = this.f1206j - 1;
        if (i < 0) {
            i = 0;
        }
        long[] jArr = k;
        long j5 = (i < 0 || i >= 7) ? jArr[6] : jArr[i];
        Log.i("DeviceIdManager", "scheduleRetry: next attempt in " + j5 + "ms (failures=" + this.f1206j + ")");
        try {
            objA2 = this.b.schedule(new a(this, 2), j5, TimeUnit.MILLISECONDS);
        } catch (Throwable th2) {
            objA2 = kotlin.b.a(th2);
        }
        Throwable thA2 = Result.a(objA2);
        if (thA2 != null) {
            this.i.set(false);
            Log.w("DeviceIdManager", "scheduleRetry failed", thA2);
        }
    }

    public final String c() {
        DeviceIdPrefsUtils deviceIdPrefsUtils = DeviceIdPrefsUtils.INSTANCE;
        Context context = this.f1205a;
        String str = deviceIdPrefsUtils.read(context);
        if (str != null) {
            if (m.s0(str)) {
                str = null;
            }
            if (str != null) {
                Log.i("DeviceIdManager", "resolveFallbackId: use persisted id");
                return str;
            }
        }
        String strGenerateNewId = deviceIdPrefsUtils.generateNewId(context);
        Log.i("DeviceIdManager", "resolveFallbackId: generated new id, persisted=" + deviceIdPrefsUtils.write(context, strGenerateNewId));
        return strGenerateNewId;
    }
}
