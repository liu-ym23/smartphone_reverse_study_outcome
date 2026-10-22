package t0;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.BroadcastReceiver;
import android.content.Context;
import androidx.work.impl.WorkDatabase;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import s0.C0844b;

/* renamed from: t0.H, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0913H extends J {

    /* renamed from: l, reason: collision with root package name */
    public static C0913H f15322l;

    /* renamed from: m, reason: collision with root package name */
    public static C0913H f15323m;

    /* renamed from: n, reason: collision with root package name */
    public static final Object f15324n;

    /* renamed from: b, reason: collision with root package name */
    public final Context f15325b;

    /* renamed from: c, reason: collision with root package name */
    public final C0844b f15326c;

    /* renamed from: d, reason: collision with root package name */
    public final WorkDatabase f15327d;

    /* renamed from: e, reason: collision with root package name */
    public final E0.a f15328e;

    /* renamed from: f, reason: collision with root package name */
    public final List f15329f;

    /* renamed from: g, reason: collision with root package name */
    public final r f15330g;

    /* renamed from: h, reason: collision with root package name */
    public final C0.i f15331h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f15332i = false;

    /* renamed from: j, reason: collision with root package name */
    public BroadcastReceiver.PendingResult f15333j;

    /* renamed from: k, reason: collision with root package name */
    public final z0.l f15334k;

    static {
        s0.t.f("WorkManagerImpl");
        f15322l = null;
        f15323m = null;
        f15324n = new Object();
    }

    public C0913H(Context context, final C0844b c0844b, E0.a aVar, final WorkDatabase workDatabase, final List list, r rVar, z0.l lVar) {
        Context applicationContext = context.getApplicationContext();
        if (AbstractC0912G.a(applicationContext)) {
            throw new IllegalStateException("Cannot initialize WorkManager in direct boot mode");
        }
        s0.t tVar = new s0.t(c0844b.f14176g);
        synchronized (s0.t.f14211b) {
            s0.t.f14212c = tVar;
        }
        this.f15325b = applicationContext;
        this.f15328e = aVar;
        this.f15327d = workDatabase;
        this.f15330g = rVar;
        this.f15334k = lVar;
        this.f15326c = c0844b;
        this.f15329f = list;
        this.f15331h = new C0.i(workDatabase, 1);
        final C0.o oVar = ((E0.c) aVar).f400a;
        String str = w.f15424a;
        rVar.a(new InterfaceC0918d() { // from class: t0.u
            @Override // t0.InterfaceC0918d
            public final void c(final B0.k kVar, boolean z4) {
                final C0844b c0844b2 = c0844b;
                final WorkDatabase workDatabase2 = workDatabase;
                final List list2 = list;
                oVar.execute(new Runnable() { // from class: t0.v
                    @Override // java.lang.Runnable
                    public final void run() {
                        List list3 = list2;
                        Iterator it = list3.iterator();
                        while (it.hasNext()) {
                            ((t) it.next()).a(kVar.f150a);
                        }
                        w.b(c0844b2, workDatabase2, list3);
                    }
                });
            }
        });
        aVar.a(new C0.f(applicationContext, this));
    }

    public static C0913H e0(Context context) {
        C0913H c0913h;
        Object obj = f15324n;
        synchronized (obj) {
            try {
                synchronized (obj) {
                    c0913h = f15322l;
                    if (c0913h == null) {
                        c0913h = f15323m;
                    }
                }
                return c0913h;
            } catch (Throwable th) {
                throw th;
            } finally {
            }
        }
        if (c0913h != null) {
            return c0913h;
        }
        context.getApplicationContext();
        throw new IllegalStateException("WorkManager is not initialized properly.  You have explicitly disabled WorkManagerInitializer in your manifest, have not manually called WorkManager#initialize at this point, and your Application does not implement Configuration.Provider.");
    }

    public final s0.B d0(List list) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException("enqueue needs at least one WorkRequest.");
        }
        return new y(this, null, 2, list).I0();
    }

    public final void f0() {
        synchronized (f15324n) {
            try {
                this.f15332i = true;
                BroadcastReceiver.PendingResult pendingResult = this.f15333j;
                if (pendingResult != null) {
                    pendingResult.finish();
                    this.f15333j = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void g0() {
        ArrayList arrayListC;
        String str = w0.b.f15798f;
        Context context = this.f15325b;
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        if (jobScheduler != null && (arrayListC = w0.b.c(context, jobScheduler)) != null && !arrayListC.isEmpty()) {
            Iterator it = arrayListC.iterator();
            while (it.hasNext()) {
                w0.b.b(jobScheduler, ((JobInfo) it.next()).getId());
            }
        }
        WorkDatabase workDatabase = this.f15327d;
        B0.u uVarG = workDatabase.g();
        androidx.room.A a4 = uVarG.f191a;
        a4.assertNotSuspendingTransaction();
        B0.s sVar = uVarG.f204n;
        k0.j jVarAcquire = sVar.acquire();
        a4.beginTransaction();
        try {
            jVarAcquire.executeUpdateDelete();
            a4.setTransactionSuccessful();
            a4.endTransaction();
            sVar.release(jVarAcquire);
            w.b(this.f15326c, workDatabase, this.f15329f);
        } catch (Throwable th) {
            a4.endTransaction();
            sVar.release(jVarAcquire);
            throw th;
        }
    }
}
