package k2;

import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.os.PowerManager;
import android.text.TextUtils;
import androidx.work.impl.background.systemalarm.SystemAlarmService;
import h2.j;
import i2.s;
import java.util.ArrayList;
import q2.k;
import r2.m;
import r2.r;
import s2.c;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class f implements i2.b {

    /* renamed from: n, reason: collision with root package name */
    public static final String f9882n = j.f("SystemAlarmDispatcher");

    /* renamed from: a, reason: collision with root package name */
    public final Context f9883a;

    /* renamed from: b, reason: collision with root package name */
    public final s2.b f9884b;

    /* renamed from: c, reason: collision with root package name */
    public final r f9885c;

    /* renamed from: d, reason: collision with root package name */
    public final androidx.work.impl.a f9886d;

    /* renamed from: e, reason: collision with root package name */
    public final androidx.work.impl.b f9887e;
    public final k2.b h;

    /* renamed from: j, reason: collision with root package name */
    public final ArrayList f9888j;

    /* renamed from: k, reason: collision with root package name */
    public Intent f9889k;

    /* renamed from: l, reason: collision with root package name */
    public SystemAlarmService f9890l;

    /* renamed from: m, reason: collision with root package name */
    public final i2.r f9891m;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            c.a aVarA;
            c cVar;
            synchronized (f.this.f9888j) {
                f fVar = f.this;
                fVar.f9889k = (Intent) fVar.f9888j.get(0);
            }
            Intent intent = f.this.f9889k;
            if (intent != null) {
                String action = intent.getAction();
                int intExtra = f.this.f9889k.getIntExtra("KEY_START_ID", 0);
                j jVarD = j.d();
                String str = f.f9882n;
                jVarD.a(str, "Processing command " + f.this.f9889k + ", " + intExtra);
                PowerManager.WakeLock wakeLockA = m.a(f.this.f9883a, action + " (" + intExtra + ")");
                try {
                    j.d().a(str, "Acquiring operation wake lock (" + action + ") " + wakeLockA);
                    wakeLockA.acquire();
                    f fVar2 = f.this;
                    fVar2.h.b(intExtra, fVar2.f9889k, fVar2);
                    j.d().a(str, "Releasing operation wake lock (" + action + ") " + wakeLockA);
                    wakeLockA.release();
                    aVarA = f.this.f9884b.a();
                    cVar = new c(f.this);
                } catch (Throwable th) {
                    try {
                        j jVarD2 = j.d();
                        String str2 = f.f9882n;
                        jVarD2.c(str2, "Unexpected error in onHandleIntent", th);
                        j.d().a(str2, "Releasing operation wake lock (" + action + ") " + wakeLockA);
                        wakeLockA.release();
                        aVarA = f.this.f9884b.a();
                        cVar = new c(f.this);
                    } catch (Throwable th2) {
                        j.d().a(f.f9882n, "Releasing operation wake lock (" + action + ") " + wakeLockA);
                        wakeLockA.release();
                        f.this.f9884b.a().execute(new c(f.this));
                        throw th2;
                    }
                }
                aVarA.execute(cVar);
            }
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final f f9893a;

        /* renamed from: b, reason: collision with root package name */
        public final Intent f9894b;

        /* renamed from: c, reason: collision with root package name */
        public final int f9895c;

        public b(int i10, Intent intent, f fVar) {
            this.f9893a = fVar;
            this.f9894b = intent;
            this.f9895c = i10;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Intent intent = this.f9894b;
            this.f9893a.b(this.f9895c, intent);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final f f9896a;

        public c(f fVar) {
            this.f9896a = fVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:32:0x0089 A[Catch: all -> 0x0043, TryCatch #0 {all -> 0x0043, blocks: (B:4:0x0015, B:6:0x0019, B:8:0x003f, B:11:0x0045, B:12:0x004c, B:13:0x004d, B:14:0x0057, B:18:0x0061, B:20:0x0069, B:21:0x006b, B:25:0x0075, B:27:0x0082, B:35:0x0094, B:31:0x0088, B:32:0x0089, B:34:0x0091, B:39:0x0098, B:22:0x006c, B:23:0x0072, B:15:0x0058, B:16:0x005e), top: B:42:0x0015, inners: #1, #2 }] */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void run() {
            /*
                r5 = this;
                k2.f r5 = r5.f9896a
                java.lang.String r0 = "Removing command "
                h2.j r1 = h2.j.d()
                java.lang.String r2 = k2.f.f9882n
                java.lang.String r3 = "Checking if commands are complete."
                r1.a(r2, r3)
                k2.f.c()
                java.util.ArrayList r1 = r5.f9888j
                monitor-enter(r1)
                android.content.Intent r3 = r5.f9889k     // Catch: java.lang.Throwable -> L43
                if (r3 == 0) goto L4d
                h2.j r3 = h2.j.d()     // Catch: java.lang.Throwable -> L43
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L43
                r4.<init>(r0)     // Catch: java.lang.Throwable -> L43
                android.content.Intent r0 = r5.f9889k     // Catch: java.lang.Throwable -> L43
                r4.append(r0)     // Catch: java.lang.Throwable -> L43
                java.lang.String r0 = r4.toString()     // Catch: java.lang.Throwable -> L43
                r3.a(r2, r0)     // Catch: java.lang.Throwable -> L43
                java.util.ArrayList r0 = r5.f9888j     // Catch: java.lang.Throwable -> L43
                r3 = 0
                java.lang.Object r0 = r0.remove(r3)     // Catch: java.lang.Throwable -> L43
                android.content.Intent r0 = (android.content.Intent) r0     // Catch: java.lang.Throwable -> L43
                android.content.Intent r3 = r5.f9889k     // Catch: java.lang.Throwable -> L43
                boolean r0 = r0.equals(r3)     // Catch: java.lang.Throwable -> L43
                if (r0 == 0) goto L45
                r0 = 0
                r5.f9889k = r0     // Catch: java.lang.Throwable -> L43
                goto L4d
            L43:
                r5 = move-exception
                goto L99
            L45:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L43
                java.lang.String r0 = "Dequeue-d command is not the first."
                r5.<init>(r0)     // Catch: java.lang.Throwable -> L43
                throw r5     // Catch: java.lang.Throwable -> L43
            L4d:
                s2.b r0 = r5.f9884b     // Catch: java.lang.Throwable -> L43
                r2.k r0 = r0.c()     // Catch: java.lang.Throwable -> L43
                k2.b r3 = r5.h     // Catch: java.lang.Throwable -> L43
                java.lang.Object r4 = r3.f9861c     // Catch: java.lang.Throwable -> L43
                monitor-enter(r4)     // Catch: java.lang.Throwable -> L43
                java.util.HashMap r3 = r3.f9860b     // Catch: java.lang.Throwable -> L96
                boolean r3 = r3.isEmpty()     // Catch: java.lang.Throwable -> L96
                monitor-exit(r4)     // Catch: java.lang.Throwable -> L96
                if (r3 == 0) goto L89
                java.util.ArrayList r3 = r5.f9888j     // Catch: java.lang.Throwable -> L43
                boolean r3 = r3.isEmpty()     // Catch: java.lang.Throwable -> L43
                if (r3 == 0) goto L89
                java.lang.Object r3 = r0.f11699d     // Catch: java.lang.Throwable -> L43
                monitor-enter(r3)     // Catch: java.lang.Throwable -> L43
                java.util.ArrayDeque<r2.k$a> r0 = r0.f11696a     // Catch: java.lang.Throwable -> L86
                boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> L86
                monitor-exit(r3)     // Catch: java.lang.Throwable -> L86
                if (r0 == 0) goto L89
                h2.j r0 = h2.j.d()     // Catch: java.lang.Throwable -> L43
                java.lang.String r3 = "No more commands & intents."
                r0.a(r2, r3)     // Catch: java.lang.Throwable -> L43
                androidx.work.impl.background.systemalarm.SystemAlarmService r5 = r5.f9890l     // Catch: java.lang.Throwable -> L43
                if (r5 == 0) goto L94
                r5.a()     // Catch: java.lang.Throwable -> L43
                goto L94
            L86:
                r5 = move-exception
                monitor-exit(r3)     // Catch: java.lang.Throwable -> L86
                throw r5     // Catch: java.lang.Throwable -> L43
            L89:
                java.util.ArrayList r0 = r5.f9888j     // Catch: java.lang.Throwable -> L43
                boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> L43
                if (r0 != 0) goto L94
                r5.d()     // Catch: java.lang.Throwable -> L43
            L94:
                monitor-exit(r1)     // Catch: java.lang.Throwable -> L43
                return
            L96:
                r5 = move-exception
                monitor-exit(r4)     // Catch: java.lang.Throwable -> L96
                throw r5     // Catch: java.lang.Throwable -> L43
            L99:
                monitor-exit(r1)     // Catch: java.lang.Throwable -> L43
                throw r5
            */
            throw new UnsupportedOperationException("Method not decompiled: k2.f.c.run():void");
        }
    }

    public f(SystemAlarmService systemAlarmService) {
        Context applicationContext = systemAlarmService.getApplicationContext();
        this.f9883a = applicationContext;
        androidx.preference.c cVar = new androidx.preference.c(new stepos.support.v7.app.palette.b(9));
        androidx.work.impl.b bVarA = androidx.work.impl.b.a(systemAlarmService);
        this.f9887e = bVarA;
        this.h = new k2.b(applicationContext, bVarA.f2878b.f2817d, cVar);
        this.f9885c = new r(bVarA.f2878b.f2820g);
        androidx.work.impl.a aVar = bVarA.f2882f;
        this.f9886d = aVar;
        s2.b bVar = bVarA.f2880d;
        this.f9884b = bVar;
        this.f9891m = new s(aVar, bVar);
        aVar.a(this);
        this.f9888j = new ArrayList();
        this.f9889k = null;
    }

    public static void c() {
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            throw new IllegalStateException("Needs to be invoked on the main thread.");
        }
    }

    @Override // i2.b
    public final void a(k kVar, boolean z) {
        c.a aVarA = this.f9884b.a();
        String str = k2.b.h;
        Intent intent = new Intent(this.f9883a, (Class<?>) SystemAlarmService.class);
        intent.setAction("ACTION_EXECUTION_COMPLETED");
        intent.putExtra("KEY_NEEDS_RESCHEDULE", z);
        k2.b.d(intent, kVar);
        aVarA.execute(new b(0, intent, this));
    }

    public final void b(int i10, Intent intent) {
        j jVarD = j.d();
        String str = f9882n;
        jVarD.a(str, "Adding command " + intent + " (" + i10 + ")");
        c();
        String action = intent.getAction();
        if (TextUtils.isEmpty(action)) {
            j.d().g(str, "Unknown command. Ignoring");
            return;
        }
        if ("ACTION_CONSTRAINTS_CHANGED".equals(action)) {
            c();
            synchronized (this.f9888j) {
                try {
                    ArrayList arrayList = this.f9888j;
                    int size = arrayList.size();
                    int i11 = 0;
                    while (i11 < size) {
                        Object obj = arrayList.get(i11);
                        i11++;
                        if ("ACTION_CONSTRAINTS_CHANGED".equals(((Intent) obj).getAction())) {
                            return;
                        }
                    }
                } finally {
                }
            }
        }
        intent.putExtra("KEY_START_ID", i10);
        synchronized (this.f9888j) {
            try {
                boolean zIsEmpty = this.f9888j.isEmpty();
                this.f9888j.add(intent);
                if (zIsEmpty) {
                    d();
                }
            } finally {
            }
        }
    }

    public final void d() {
        c();
        PowerManager.WakeLock wakeLockA = m.a(this.f9883a, "ProcessCommand");
        try {
            wakeLockA.acquire();
            this.f9887e.f2880d.d(new a());
        } finally {
            wakeLockA.release();
        }
    }
}
