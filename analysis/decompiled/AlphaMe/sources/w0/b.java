package w0;

import B0.f;
import B0.h;
import B0.k;
import B0.p;
import B0.r;
import C0.i;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.net.NetworkRequest;
import android.os.PersistableBundle;
import androidx.room.A;
import androidx.room.G;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.background.systemjob.SystemJobService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.Callable;
import k0.j;
import kotlin.jvm.internal.Intrinsics;
import s0.C;
import s0.C0844b;
import s0.C0846d;
import s0.C0847e;
import s0.EnumC0843a;
import s0.u;
import t0.t;

/* loaded from: classes.dex */
public final class b implements t {

    /* renamed from: f, reason: collision with root package name */
    public static final String f15798f = s0.t.f("SystemJobScheduler");

    /* renamed from: a, reason: collision with root package name */
    public final Context f15799a;

    /* renamed from: b, reason: collision with root package name */
    public final JobScheduler f15800b;

    /* renamed from: c, reason: collision with root package name */
    public final C0969a f15801c;

    /* renamed from: d, reason: collision with root package name */
    public final WorkDatabase f15802d;

    /* renamed from: e, reason: collision with root package name */
    public final C0844b f15803e;

    public b(Context context, WorkDatabase workDatabase, C0844b c0844b) {
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        C0969a c0969a = new C0969a(context, c0844b.f14172c);
        this.f15799a = context;
        this.f15800b = jobScheduler;
        this.f15801c = c0969a;
        this.f15802d = workDatabase;
        this.f15803e = c0844b;
    }

    public static void b(JobScheduler jobScheduler, int i4) {
        try {
            jobScheduler.cancel(i4);
        } catch (Throwable th) {
            s0.t.d().c(f15798f, String.format(Locale.getDefault(), "Exception while trying to cancel job (%d)", Integer.valueOf(i4)), th);
        }
    }

    public static ArrayList c(Context context, JobScheduler jobScheduler) {
        List<JobInfo> allPendingJobs;
        try {
            allPendingJobs = jobScheduler.getAllPendingJobs();
        } catch (Throwable th) {
            s0.t.d().c(f15798f, "getAllPendingJobs() is not reliable on this device.", th);
            allPendingJobs = null;
        }
        if (allPendingJobs == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(allPendingJobs.size());
        ComponentName componentName = new ComponentName(context, (Class<?>) SystemJobService.class);
        for (JobInfo jobInfo : allPendingJobs) {
            if (componentName.equals(jobInfo.getService())) {
                arrayList.add(jobInfo);
            }
        }
        return arrayList;
    }

    public static k f(JobInfo jobInfo) {
        PersistableBundle extras = jobInfo.getExtras();
        if (extras == null) {
            return null;
        }
        try {
            if (!extras.containsKey("EXTRA_WORK_SPEC_ID")) {
                return null;
            }
            return new k(extras.getString("EXTRA_WORK_SPEC_ID"), extras.getInt("EXTRA_WORK_SPEC_GENERATION", 0));
        } catch (NullPointerException unused) {
            return null;
        }
    }

    @Override // t0.t
    public final void a(String str) {
        ArrayList arrayList;
        Context context = this.f15799a;
        JobScheduler jobScheduler = this.f15800b;
        ArrayList arrayListC = c(context, jobScheduler);
        if (arrayListC == null) {
            arrayList = null;
        } else {
            ArrayList arrayList2 = new ArrayList(2);
            Iterator it = arrayListC.iterator();
            while (it.hasNext()) {
                JobInfo jobInfo = (JobInfo) it.next();
                k kVarF = f(jobInfo);
                if (kVarF != null && str.equals(kVarF.f150a)) {
                    arrayList2.add(Integer.valueOf(jobInfo.getId()));
                }
            }
            arrayList = arrayList2;
        }
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            b(jobScheduler, ((Integer) it2.next()).intValue());
        }
        p pVar = (p) this.f15802d.d();
        A a4 = pVar.f160a;
        a4.assertNotSuspendingTransaction();
        G g4 = pVar.f163d;
        j jVarAcquire = g4.acquire();
        if (str == null) {
            jVarAcquire.bindNull(1);
        } else {
            jVarAcquire.bindString(1, str);
        }
        a4.beginTransaction();
        try {
            jVarAcquire.executeUpdateDelete();
            a4.setTransactionSuccessful();
        } finally {
            a4.endTransaction();
            g4.release(jVarAcquire);
        }
    }

    @Override // t0.t
    public final boolean d() {
        return true;
    }

    @Override // t0.t
    public final void e(r... rVarArr) {
        int iIntValue;
        C0844b c0844b = this.f15803e;
        WorkDatabase workDatabase = this.f15802d;
        final i iVar = new i(workDatabase, 0);
        for (r rVar : rVarArr) {
            workDatabase.beginTransaction();
            try {
                r rVarI = workDatabase.g().i(rVar.f167a);
                String str = f15798f;
                String str2 = rVar.f167a;
                if (rVarI == null) {
                    s0.t.d().g(str, "Skipping scheduling " + str2 + " because it's no longer in the DB");
                    workDatabase.setTransactionSuccessful();
                } else if (rVarI.f168b != s0.G.f14153a) {
                    s0.t.d().g(str, "Skipping scheduling " + str2 + " because it is no longer enqueued");
                    workDatabase.setTransactionSuccessful();
                } else {
                    k generationalId = f.v(rVar);
                    h hVarB = ((p) workDatabase.d()).b(generationalId);
                    if (hVarB != null) {
                        iIntValue = hVarB.f147c;
                    } else {
                        c0844b.getClass();
                        final int i4 = c0844b.f14177h;
                        Object objRunInTransaction = iVar.f306a.runInTransaction((Callable<Object>) new Callable() { // from class: C0.h

                            /* renamed from: b, reason: collision with root package name */
                            public final /* synthetic */ int f304b = 0;

                            @Override // java.util.concurrent.Callable
                            public final Object call() {
                                i this$0 = iVar;
                                Intrinsics.checkNotNullParameter(this$0, "this$0");
                                WorkDatabase workDatabase2 = this$0.f306a;
                                Long lG = workDatabase2.c().g("next_job_scheduler_id");
                                int iLongValue = lG != null ? (int) lG.longValue() : 0;
                                workDatabase2.c().j(new B0.d("next_job_scheduler_id", Long.valueOf(iLongValue != Integer.MAX_VALUE ? iLongValue + 1 : 0)));
                                int i5 = this.f304b;
                                if (i5 > iLongValue || iLongValue > i4) {
                                    this$0.f306a.c().j(new B0.d("next_job_scheduler_id", Long.valueOf(i5 + 1)));
                                    iLongValue = i5;
                                }
                                return Integer.valueOf(iLongValue);
                            }
                        });
                        Intrinsics.checkNotNullExpressionValue(objRunInTransaction, "workDatabase.runInTransa…            id\n        })");
                        iIntValue = ((Number) objRunInTransaction).intValue();
                    }
                    if (hVarB == null) {
                        Intrinsics.checkNotNullParameter(generationalId, "generationalId");
                        ((p) workDatabase.d()).c(new h(generationalId.f150a, generationalId.f151b, iIntValue));
                    }
                    g(rVar, iIntValue);
                    workDatabase.setTransactionSuccessful();
                }
            } finally {
                workDatabase.endTransaction();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void g(r rVar, int i4) {
        int i5;
        JobScheduler jobScheduler = this.f15800b;
        C0969a c0969a = this.f15801c;
        c0969a.getClass();
        C0847e c0847e = rVar.f176j;
        PersistableBundle persistableBundle = new PersistableBundle();
        String str = rVar.f167a;
        persistableBundle.putString("EXTRA_WORK_SPEC_ID", str);
        persistableBundle.putInt("EXTRA_WORK_SPEC_GENERATION", rVar.f186t);
        persistableBundle.putBoolean("EXTRA_IS_PERIODIC", rVar.d());
        JobInfo.Builder requiresCharging = new JobInfo.Builder(i4, c0969a.f15796a).setRequiresCharging(c0847e.f14186b);
        boolean z4 = c0847e.f14187c;
        JobInfo.Builder extras = requiresCharging.setRequiresDeviceIdle(z4).setExtras(persistableBundle);
        u uVar = u.f14219f;
        u uVar2 = c0847e.f14185a;
        if (uVar2 == uVar) {
            extras.setRequiredNetwork(new NetworkRequest.Builder().addCapability(25).build());
        } else {
            int iOrdinal = uVar2.ordinal();
            if (iOrdinal == 0) {
                i5 = 0;
            } else if (iOrdinal != 1) {
                i5 = 2;
                if (iOrdinal != 2) {
                    i5 = 3;
                    if (iOrdinal != 3) {
                        i5 = 4;
                        if (iOrdinal != 4) {
                            s0.t.d().a(C0969a.f15795c, "API version too low. Cannot convert network type value " + uVar2);
                            i5 = 1;
                        }
                    }
                }
            } else {
                i5 = 1;
            }
            extras.setRequiredNetworkType(i5);
        }
        if (!z4) {
            extras.setBackoffCriteria(rVar.f179m, rVar.f178l == EnumC0843a.f14168b ? 0 : 1);
        }
        long jA = rVar.a();
        c0969a.f15797b.getClass();
        long jMax = Math.max(jA - System.currentTimeMillis(), 0L);
        if (jMax > 0) {
            extras.setMinimumLatency(jMax);
        } else if (!rVar.f183q) {
            extras.setImportantWhileForeground(true);
        }
        Set<C0846d> set = c0847e.f14192h;
        if (!set.isEmpty()) {
            for (C0846d c0846d : set) {
                extras.addTriggerContentUri(new JobInfo.TriggerContentUri(c0846d.f14182a, c0846d.f14183b ? 1 : 0));
            }
            extras.setTriggerContentUpdateDelay(c0847e.f14190f);
            extras.setTriggerContentMaxDelay(c0847e.f14191g);
        }
        extras.setPersisted(false);
        extras.setRequiresBatteryNotLow(c0847e.f14188d);
        extras.setRequiresStorageNotLow(c0847e.f14189e);
        Object[] objArr = rVar.f177k > 0;
        Object[] objArr2 = jMax > 0;
        if (rVar.f183q && objArr == false && objArr2 == false) {
            extras.setExpedited(true);
        }
        JobInfo jobInfoBuild = extras.build();
        String str2 = f15798f;
        s0.t.d().a(str2, "Scheduling work ID " + str + "Job ID " + i4);
        try {
            if (jobScheduler.schedule(jobInfoBuild) == 0) {
                s0.t.d().g(str2, "Unable to schedule work ID " + str);
                if (rVar.f183q && rVar.f184r == C.f14150a) {
                    rVar.f183q = false;
                    s0.t.d().a(str2, "Scheduling a non-expedited job (work ID " + str + ")");
                    g(rVar, i4);
                }
            }
        } catch (IllegalStateException e4) {
            ArrayList arrayListC = c(this.f15799a, jobScheduler);
            String str3 = String.format(Locale.getDefault(), "JobScheduler 100 job limit exceeded.  We count %d WorkManager jobs in JobScheduler; we have %d tracked jobs in our DB; our Configuration limit is %d.", Integer.valueOf(arrayListC != null ? arrayListC.size() : 0), Integer.valueOf(this.f15802d.g().f().size()), Integer.valueOf(this.f15803e.f14179j));
            s0.t.d().b(str2, str3);
            throw new IllegalStateException(str3, e4);
        } catch (Throwable th) {
            s0.t.d().c(str2, "Unable to schedule " + rVar, th);
        }
    }
}
