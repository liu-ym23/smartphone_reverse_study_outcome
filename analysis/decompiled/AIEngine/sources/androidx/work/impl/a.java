package androidx.work.impl;

import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import androidx.appcompat.app.l;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.work.WorkerParameters;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.d;
import androidx.work.impl.foreground.SystemForegroundService;
import h2.i;
import h2.j;
import i2.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import kotlinx.coroutines.JobKt__JobKt;
import q2.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: l, reason: collision with root package name */
    public static final String f2863l = j.f("Processor");

    /* renamed from: b, reason: collision with root package name */
    public final Context f2865b;

    /* renamed from: c, reason: collision with root package name */
    public final androidx.work.a f2866c;

    /* renamed from: d, reason: collision with root package name */
    public final s2.c f2867d;

    /* renamed from: e, reason: collision with root package name */
    public final WorkDatabase f2868e;

    /* renamed from: g, reason: collision with root package name */
    public final HashMap f2870g = new HashMap();

    /* renamed from: f, reason: collision with root package name */
    public final HashMap f2869f = new HashMap();

    /* renamed from: i, reason: collision with root package name */
    public final HashSet f2871i = new HashSet();

    /* renamed from: j, reason: collision with root package name */
    public final ArrayList f2872j = new ArrayList();

    /* renamed from: a, reason: collision with root package name */
    public PowerManager.WakeLock f2864a = null;

    /* renamed from: k, reason: collision with root package name */
    public final Object f2873k = new Object();
    public final HashMap h = new HashMap();

    public a(Context context, androidx.work.a aVar, s2.c cVar, WorkDatabase workDatabase) {
        this.f2865b = context;
        this.f2866c = aVar;
        this.f2867d = cVar;
        this.f2868e = workDatabase;
    }

    public static boolean d(String str, d dVar, int i10) {
        String str2 = f2863l;
        if (dVar == null) {
            j.d().a(str2, "WorkerWrapper could not be found for " + str);
            return false;
        }
        dVar.f2953n.cancel(new WorkerStoppedException(i10));
        j.d().a(str2, "WorkerWrapper interrupted for " + str);
        return true;
    }

    public final void a(i2.b bVar) {
        synchronized (this.f2873k) {
            this.f2872j.add(bVar);
        }
    }

    public final d b(String str) {
        d dVar = (d) this.f2869f.remove(str);
        boolean z = dVar != null;
        if (!z) {
            dVar = (d) this.f2870g.remove(str);
        }
        this.h.remove(str);
        if (z) {
            synchronized (this.f2873k) {
                try {
                    if (this.f2869f.isEmpty()) {
                        Context context = this.f2865b;
                        String str2 = p2.a.f11394m;
                        Intent intent = new Intent(context, (Class<?>) SystemForegroundService.class);
                        intent.setAction("ACTION_STOP_FOREGROUND");
                        try {
                            this.f2865b.startService(intent);
                        } catch (Throwable th) {
                            j.d().c(f2863l, "Unable to stop foreground service", th);
                        }
                        PowerManager.WakeLock wakeLock = this.f2864a;
                        if (wakeLock != null) {
                            wakeLock.release();
                            this.f2864a = null;
                        }
                    }
                } finally {
                }
            }
        }
        return dVar;
    }

    public final d c(String str) {
        d dVar = (d) this.f2869f.get(str);
        return dVar == null ? (d) this.f2870g.get(str) : dVar;
    }

    public final boolean e(String str) {
        boolean z;
        synchronized (this.f2873k) {
            z = c(str) != null;
        }
        return z;
    }

    public final void f(i2.b bVar) {
        synchronized (this.f2873k) {
            this.f2872j.remove(bVar);
        }
    }

    public final boolean g(k kVar, WorkerParameters.a aVar) {
        q2.k kVar2 = kVar.f9470a;
        final String str = kVar2.f11498a;
        final ArrayList arrayList = new ArrayList();
        p pVar = (p) this.f2868e.n(new Callable() { // from class: i2.f
            @Override // java.util.concurrent.Callable
            public final Object call() {
                WorkDatabase workDatabase = this.f9461a.f2868e;
                q2.u uVarX = workDatabase.x();
                String str2 = str;
                arrayList.addAll(uVarX.a(str2));
                return workDatabase.w().i(str2);
            }
        });
        if (pVar == null) {
            j.d().g(f2863l, "Didn't find WorkSpec for id " + kVar2);
            this.f2867d.f11881d.execute(new l(16, this, kVar2));
            return false;
        }
        synchronized (this.f2873k) {
            try {
                if (e(str)) {
                    Set set = (Set) this.h.get(str);
                    if (((k) set.iterator().next()).f9470a.f11499b == kVar2.f11499b) {
                        set.add(kVar);
                        j.d().a(f2863l, "Work " + kVar2 + " is already enqueued for processing");
                    } else {
                        this.f2867d.f11881d.execute(new l(16, this, kVar2));
                    }
                    return false;
                }
                if (pVar.f11522t != kVar2.f11499b) {
                    this.f2867d.f11881d.execute(new l(16, this, kVar2));
                    return false;
                }
                d.a aVar2 = new d.a(this.f2865b, this.f2866c, this.f2867d, this, this.f2868e, pVar, arrayList);
                if (aVar != null) {
                    aVar2.h = aVar;
                }
                d dVar = new d(aVar2);
                CallbackToFutureAdapter.c cVarA = i.a(dVar.f2945e.f11879b.plus(JobKt__JobKt.Job$default(null, 1, null)), new WorkerWrapper$launch$1(dVar, null));
                cVarA.f1027b.a(new com.stepos.statsapp.v3.lib.plugin.emitter.remote.c(this, cVarA, dVar, 5), this.f2867d.f11881d);
                this.f2870g.put(str, dVar);
                HashSet hashSet = new HashSet();
                hashSet.add(kVar);
                this.h.put(str, hashSet);
                j.d().a(f2863l, a.class.getSimpleName() + ": processing " + kVar2);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
