package l2;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.net.NetworkRequest;
import android.os.Build;
import android.os.PersistableBundle;
import androidx.work.BackoffPolicy;
import androidx.work.NetworkType;
import androidx.work.OutOfQuotaPolicy;
import androidx.work.WorkInfo$State;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.background.systemjob.SystemJobService;
import com.stepos.backend.onnx.SmsParseCpuModel;
import com.stepos.core.ota.d;
import h0.e;
import h2.c;
import h2.j;
import i2.h;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Callable;
import mb.l;
import mb.y;
import q2.g;
import q2.k;
import q2.p;
import q2.q;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class c implements h {
    public static final String h = j.f("SystemJobScheduler");

    /* renamed from: a, reason: collision with root package name */
    public final Context f10194a;

    /* renamed from: b, reason: collision with root package name */
    public final JobScheduler f10195b;

    /* renamed from: c, reason: collision with root package name */
    public final b f10196c;

    /* renamed from: d, reason: collision with root package name */
    public final WorkDatabase f10197d;

    /* renamed from: e, reason: collision with root package name */
    public final androidx.work.a f10198e;

    public c(Context context, WorkDatabase workDatabase, androidx.work.a aVar) {
        JobScheduler jobSchedulerB = a.b(context);
        b bVar = new b(context, aVar.f2817d, aVar.f2824l);
        this.f10194a = context;
        this.f10195b = jobSchedulerB;
        this.f10196c = bVar;
        this.f10197d = workDatabase;
        this.f10198e = aVar;
    }

    public static void a(JobScheduler jobScheduler, int i10) {
        try {
            jobScheduler.cancel(i10);
        } catch (Throwable th) {
            j.d().c(h, String.format(Locale.getDefault(), "Exception while trying to cancel job (%d)", Integer.valueOf(i10)), th);
        }
    }

    public static ArrayList b(Context context, JobScheduler jobScheduler) {
        List<JobInfo> listA = a.a(jobScheduler);
        if (listA == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(listA.size());
        ComponentName componentName = new ComponentName(context, (Class<?>) SystemJobService.class);
        for (JobInfo jobInfo : listA) {
            if (componentName.equals(jobInfo.getService())) {
                arrayList.add(jobInfo);
            }
        }
        return arrayList;
    }

    public static k e(JobInfo jobInfo) {
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

    @Override // i2.h
    public final void c(p... pVarArr) {
        int iIntValue;
        androidx.work.a aVar = this.f10198e;
        WorkDatabase workDatabase = this.f10197d;
        final androidx.lifecycle.b bVar = new androidx.lifecycle.b(workDatabase);
        for (p pVar : pVarArr) {
            workDatabase.c();
            try {
                q qVarW = workDatabase.w();
                String str = pVar.f11505a;
                p pVarI = qVarW.i(str);
                String str2 = h;
                if (pVarI == null) {
                    j.d().g(str2, "Skipping scheduling " + str + " because it's no longer in the DB");
                    workDatabase.p();
                } else if (pVarI.f11506b != WorkInfo$State.f2792a) {
                    j.d().g(str2, "Skipping scheduling " + str + " because it is no longer enqueued");
                    workDatabase.p();
                } else {
                    k kVarT = y.t(pVar);
                    g gVarC = workDatabase.t().c(kVarT);
                    if (gVarC != null) {
                        iIntValue = gVarC.f11495c;
                    } else {
                        aVar.getClass();
                        final int i10 = aVar.f2821i;
                        Object objN = ((WorkDatabase) bVar.h).n(new Callable() { // from class: r2.c
                            @Override // java.util.concurrent.Callable
                            public final Object call() {
                                WorkDatabase workDatabase2 = (WorkDatabase) bVar.h;
                                Long lI = workDatabase2.s().i("next_job_scheduler_id");
                                int i11 = 0;
                                int iLongValue = lI != null ? (int) lI.longValue() : 0;
                                workDatabase2.s().b(new q2.d("next_job_scheduler_id", Long.valueOf(iLongValue == Integer.MAX_VALUE ? 0 : iLongValue + 1)));
                                if (iLongValue < 0 || iLongValue > i10) {
                                    workDatabase2.s().b(new q2.d("next_job_scheduler_id", Long.valueOf(1)));
                                } else {
                                    i11 = iLongValue;
                                }
                                return Integer.valueOf(i11);
                            }
                        });
                        kotlin.jvm.internal.g.e(objN, "workDatabase.runInTransa…d\n            }\n        )");
                        iIntValue = ((Number) objN).intValue();
                    }
                    if (gVarC == null) {
                        workDatabase.t().p(new g(kVarT.f11498a, kVarT.f11499b, iIntValue));
                    }
                    f(pVar, iIntValue);
                    workDatabase.p();
                }
            } finally {
                workDatabase.k();
            }
        }
    }

    @Override // i2.h
    public final void cancel(String str) {
        ArrayList arrayList;
        Context context = this.f10194a;
        JobScheduler jobScheduler = this.f10195b;
        ArrayList arrayListB = b(context, jobScheduler);
        int i10 = 0;
        if (arrayListB == null) {
            arrayList = null;
        } else {
            ArrayList arrayList2 = new ArrayList(2);
            int size = arrayListB.size();
            int i11 = 0;
            while (i11 < size) {
                Object obj = arrayListB.get(i11);
                i11++;
                JobInfo jobInfo = (JobInfo) obj;
                k kVarE = e(jobInfo);
                if (kVarE != null && str.equals(kVarE.f11498a)) {
                    arrayList2.add(Integer.valueOf(jobInfo.getId()));
                }
            }
            arrayList = arrayList2;
        }
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        int size2 = arrayList.size();
        while (i10 < size2) {
            Object obj2 = arrayList.get(i10);
            i10++;
            a(jobScheduler, ((Integer) obj2).intValue());
        }
        this.f10197d.t().r(str);
    }

    @Override // i2.h
    public final boolean d() {
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void f(p pVar, int i10) {
        int i11;
        String str;
        b bVar = this.f10196c;
        bVar.getClass();
        h2.c cVar = pVar.f11513j;
        PersistableBundle persistableBundle = new PersistableBundle();
        String str2 = pVar.f11505a;
        persistableBundle.putString("EXTRA_WORK_SPEC_ID", str2);
        persistableBundle.putInt("EXTRA_WORK_SPEC_GENERATION", pVar.f11522t);
        persistableBundle.putBoolean("EXTRA_IS_PERIODIC", pVar.c());
        JobInfo.Builder requiresCharging = new JobInfo.Builder(i10, bVar.f10191a).setRequiresCharging(cVar.f9258c);
        boolean z = cVar.f9259d;
        JobInfo.Builder builder = requiresCharging.setRequiresDeviceIdle(z).setExtras(persistableBundle);
        NetworkRequest networkRequestA = cVar.a();
        if (networkRequestA != null) {
            kotlin.jvm.internal.g.f(builder, "builder");
            builder.setRequiredNetwork(networkRequestA);
        } else {
            NetworkType networkType = cVar.f9256a;
            if (networkType == NetworkType.h) {
                builder.setRequiredNetwork(new NetworkRequest.Builder().addCapability(25).build());
            } else {
                int iOrdinal = networkType.ordinal();
                if (iOrdinal == 0) {
                    i11 = 0;
                } else if (iOrdinal != 1) {
                    i11 = 2;
                    if (iOrdinal != 2) {
                        i11 = 3;
                        if (iOrdinal != 3) {
                            i11 = 4;
                            if (iOrdinal != 4) {
                                j.d().a(b.f10190d, "API version too low. Cannot convert network type value " + networkType);
                                i11 = 1;
                            }
                        }
                    }
                } else {
                    i11 = 1;
                }
                builder.setRequiredNetworkType(i11);
            }
        }
        if (!z) {
            builder.setBackoffCriteria(pVar.f11516m, pVar.f11515l == BackoffPolicy.f2760b ? 0 : 1);
        }
        long jMax = Math.max(pVar.a() - bVar.f10192b.z(), 0L);
        if (jMax > 0) {
            builder.setMinimumLatency(jMax);
        } else if (!pVar.f11520q && bVar.f10193c) {
            builder.setImportantWhileForeground(true);
        }
        if (cVar.b()) {
            for (c.a aVar : cVar.f9263i) {
                builder.addTriggerContentUri(new JobInfo.TriggerContentUri(aVar.f9264a, aVar.f9265b ? 1 : 0));
            }
            builder.setTriggerContentUpdateDelay(cVar.f9262g);
            builder.setTriggerContentMaxDelay(cVar.h);
        }
        builder.setPersisted(false);
        int i12 = Build.VERSION.SDK_INT;
        builder.setRequiresBatteryNotLow(cVar.f9260e);
        builder.setRequiresStorageNotLow(cVar.f9261f);
        Object[] objArr = pVar.f11514k > 0;
        Object[] objArr2 = jMax > 0;
        if (i12 >= 31 && pVar.f11520q && objArr == false && objArr2 == false) {
            builder.setExpedited(true);
        }
        if (i12 >= 35 && (str = pVar.f11526x) != null) {
            builder.setTraceTag(str);
        }
        JobInfo jobInfoBuild = builder.build();
        j jVarD = j.d();
        String strH = d.h("Scheduling work ID ", i10, str2, "Job ID ");
        String str3 = h;
        jVarD.a(str3, strH);
        try {
            if (this.f10195b.schedule(jobInfoBuild) == 0) {
                j.d().g(str3, "Unable to schedule work ID " + str2);
                if (pVar.f11520q && pVar.r == OutOfQuotaPolicy.f2789a) {
                    pVar.f11520q = false;
                    j.d().a(str3, "Scheduling a non-expedited job (work ID " + str2 + ")");
                    f(pVar, i10);
                }
            }
        } catch (IllegalStateException e10) {
            String str4 = a.f10189a;
            Context context = this.f10194a;
            kotlin.jvm.internal.g.f(context, "context");
            WorkDatabase workDatabase = this.f10197d;
            kotlin.jvm.internal.g.f(workDatabase, "workDatabase");
            androidx.work.a configuration = this.f10198e;
            kotlin.jvm.internal.g.f(configuration, "configuration");
            int i13 = Build.VERSION.SDK_INT;
            int i14 = i13 >= 31 ? SmsParseCpuModel.MAX_SEQ_LEN : 100;
            int size = workDatabase.w().f().size();
            String strZ0 = "<faulty JobScheduler failed to getPendingJobs>";
            if (i13 >= 34) {
                JobScheduler jobSchedulerB = a.b(context);
                List<JobInfo> listA = a.a(jobSchedulerB);
                if (listA != null) {
                    ArrayList arrayListB = b(context, jobSchedulerB);
                    int size2 = arrayListB != null ? listA.size() - arrayListB.size() : 0;
                    String str5 = size2 == 0 ? null : size2 + " of which are not owned by WorkManager";
                    Object systemService = context.getSystemService("jobscheduler");
                    kotlin.jvm.internal.g.d(systemService, "null cannot be cast to non-null type android.app.job.JobScheduler");
                    ArrayList arrayListB2 = b(context, (JobScheduler) systemService);
                    int size3 = arrayListB2 != null ? arrayListB2.size() : 0;
                    strZ0 = kotlin.collections.a.z0(l.d0(new String[]{listA.size() + " jobs in \"androidx.work.systemjobscheduler\" namespace", str5, size3 != 0 ? size3 + " from WorkManager in the default namespace" : null}), ",\n", null, null, null, 62);
                }
            } else {
                ArrayList arrayListB3 = b(context, a.b(context));
                if (arrayListB3 != null) {
                    strZ0 = arrayListB3.size() + " jobs from WorkManager";
                }
            }
            StringBuilder sbE = e.e("JobScheduler ", i14, " job limit exceeded.\nIn JobScheduler there are ", strZ0, ".\nThere are ");
            sbE.append(size);
            sbE.append(" jobs tracked by WorkManager's database;\nthe Configuration limit is ");
            String strL = a0.a.l(sbE, configuration.f2823k, '.');
            j.d().b(str3, strL);
            throw new IllegalStateException(strL, e10);
        } catch (Throwable th) {
            j.d().c(str3, "Unable to schedule " + pVar, th);
        }
    }
}
