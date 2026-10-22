package k5;

import a1.g;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.net.NetworkRequest;
import android.os.Build;
import android.os.PersistableBundle;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkDatabase_Impl;
import androidx.work.impl.background.systemjob.SystemJobService;
import g5.d;
import g5.u;
import h5.f;
import java.lang.invoke.VarHandle;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import kb.k;
import kb.l;
import p5.h;
import p5.i;
import p5.j;
import p5.p;
import p5.s;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class c implements f {

    /* renamed from: j, reason: collision with root package name */
    public static final String f7248j = u.f("SystemJobScheduler");

    /* renamed from: c, reason: collision with root package name */
    public Context f7249c;

    /* renamed from: f, reason: collision with root package name */
    public JobScheduler f7250f;

    /* renamed from: g, reason: collision with root package name */
    public b f7251g;

    /* renamed from: h, reason: collision with root package name */
    public WorkDatabase f7252h;
    public g5.a i;

    public static void a(JobScheduler jobScheduler, int i) {
        try {
            jobScheduler.cancel(i);
        } catch (Throwable th) {
            u.d().c(f7248j, String.format(Locale.getDefault(), "Exception while trying to cancel job (%d)", Integer.valueOf(i)), th);
        }
    }

    public static ArrayList e(Context context, JobScheduler jobScheduler) {
        List<JobInfo> allPendingJobs;
        String str = a.f7243a;
        jobScheduler.getClass();
        try {
            allPendingJobs = jobScheduler.getAllPendingJobs();
            allPendingJobs.getClass();
        } catch (Throwable th) {
            u.d().c(a.f7243a, "getAllPendingJobs() is not reliable on this device.", th);
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

    public static j f(JobInfo jobInfo) {
        PersistableBundle extras = jobInfo.getExtras();
        if (extras == null) {
            return null;
        }
        try {
            if (!extras.containsKey("EXTRA_WORK_SPEC_ID")) {
                return null;
            }
            return new j(extras.getString("EXTRA_WORK_SPEC_ID"), extras.getInt("EXTRA_WORK_SPEC_GENERATION", 0));
        } catch (NullPointerException unused) {
            return null;
        }
    }

    @Override // h5.f
    public final boolean b() {
        return true;
    }

    @Override // h5.f
    public final void c(String str) {
        ArrayList arrayList;
        Context context = this.f7249c;
        JobScheduler jobScheduler = this.f7250f;
        ArrayList arrayListE = e(context, jobScheduler);
        int i = 0;
        if (arrayListE == null) {
            arrayList = null;
        } else {
            ArrayList arrayList2 = new ArrayList(2);
            int size = arrayListE.size();
            int i3 = 0;
            while (i3 < size) {
                Object obj = arrayListE.get(i3);
                i3++;
                JobInfo jobInfo = (JobInfo) obj;
                j jVarF = f(jobInfo);
                if (jVarF != null && str.equals(jVarF.f9734a)) {
                    arrayList2.add(Integer.valueOf(jobInfo.getId()));
                }
            }
            arrayList = arrayList2;
        }
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        int size2 = arrayList.size();
        while (i < size2) {
            Object obj2 = arrayList.get(i);
            i++;
            a(jobScheduler, ((Integer) obj2).intValue());
        }
        i iVarZ = this.f7252h.z();
        WorkDatabase_Impl workDatabase_Impl = (WorkDatabase_Impl) iVarZ.f9730c;
        workDatabase_Impl.b();
        h hVar = (h) iVarZ.f9733h;
        z4.j jVarA = hVar.a();
        jVarA.h(1, str);
        try {
            workDatabase_Impl.c();
            try {
                jVarA.d();
                workDatabase_Impl.v();
            } finally {
                workDatabase_Impl.q();
            }
        } finally {
            hVar.c(jVarA);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // h5.f
    public final void d(p... pVarArr) {
        int iIntValue;
        g5.a aVar = this.i;
        WorkDatabase workDatabase = this.f7252h;
        g gVar = new g(24, (boolean) (0 == true ? 1 : 0));
        gVar.f19f = workDatabase;
        for (p pVar : pVarArr) {
            workDatabase.c();
            try {
                s sVarC = workDatabase.C();
                String str = pVar.f9764a;
                p pVarJ = sVarC.j(str);
                String str2 = f7248j;
                if (pVarJ == null) {
                    u.d().g(str2, "Skipping scheduling " + str + " because it's no longer in the DB");
                    workDatabase.v();
                } else if (pVarJ.f9765b != 1) {
                    u.d().g(str2, "Skipping scheduling " + str + " because it is no longer enqueued");
                    workDatabase.v();
                } else {
                    j jVarR = td.h.r(pVar);
                    p5.g gVarW = workDatabase.z().w(jVarR);
                    if (gVarW != null) {
                        iIntValue = gVarW.f9728c;
                    } else {
                        int i = aVar.i;
                        WorkDatabase workDatabase2 = (WorkDatabase) gVar.f19f;
                        q5.c cVar = new q5.c();
                        cVar.f10081c = gVar;
                        cVar.f10082f = i;
                        VarHandle.storeStoreFence();
                        Object objT = workDatabase2.t(cVar);
                        objT.getClass();
                        iIntValue = ((Number) objT).intValue();
                    }
                    if (gVarW == null) {
                        workDatabase.z().z(new p5.g(jVarR.f9734a, jVarR.f9735b, iIntValue));
                    }
                    g(pVar, iIntValue);
                    workDatabase.v();
                }
            } finally {
                workDatabase.q();
            }
        }
    }

    public final void g(p pVar, int i) {
        int i3;
        int i10;
        List<JobInfo> allPendingJobs;
        String str;
        g5.a aVar = this.i;
        b bVar = this.f7251g;
        d dVar = pVar.f9772j;
        PersistableBundle persistableBundle = new PersistableBundle();
        String str2 = pVar.f9764a;
        persistableBundle.putString("EXTRA_WORK_SPEC_ID", str2);
        persistableBundle.putInt("EXTRA_WORK_SPEC_GENERATION", pVar.f9782t);
        persistableBundle.putBoolean("EXTRA_IS_PERIODIC", pVar.c());
        JobInfo.Builder builder = new JobInfo.Builder(i, bVar.f7245a);
        boolean z10 = dVar.f4289c;
        Set<g5.c> set = dVar.i;
        JobInfo.Builder requiresCharging = builder.setRequiresCharging(z10);
        boolean z11 = dVar.f4290d;
        JobInfo.Builder extras = requiresCharging.setRequiresDeviceIdle(z11).setExtras(persistableBundle);
        NetworkRequest networkRequestA = dVar.a();
        if (networkRequestA != null) {
            extras.getClass();
            extras.setRequiredNetwork(networkRequestA);
        } else {
            int i11 = dVar.f4287a;
            if (i11 == 6) {
                extras.setRequiredNetwork(new NetworkRequest.Builder().addCapability(25).build());
            } else {
                int iC = s.f.c(i11);
                if (iC == 0) {
                    i3 = 0;
                } else if (iC == 1) {
                    i3 = 1;
                } else if (iC != 2) {
                    i3 = 3;
                    if (iC != 3) {
                        i3 = 4;
                        if (iC != 4) {
                            u.d().a(b.f7244d, "API version too low. Cannot convert network type value ".concat(androidx.activity.b.y(i11)));
                            i3 = 1;
                        }
                    }
                } else {
                    i3 = 2;
                }
                extras.setRequiredNetworkType(i3);
            }
        }
        if (!z11) {
            extras.setBackoffCriteria(pVar.f9775m, pVar.f9774l == 2 ? 0 : 1);
        }
        long jA = pVar.a();
        bVar.f7246b.getClass();
        long jMax = Math.max(jA - System.currentTimeMillis(), 0L);
        if (jMax > 0) {
            extras.setMinimumLatency(jMax);
        } else if (!pVar.f9779q && bVar.f7247c) {
            extras.setImportantWhileForeground(true);
        }
        if (!set.isEmpty()) {
            for (g5.c cVar : set) {
                extras.addTriggerContentUri(new JobInfo.TriggerContentUri(cVar.f4282a, cVar.f4283b ? 1 : 0));
            }
            extras.setTriggerContentUpdateDelay(dVar.f4293g);
            extras.setTriggerContentMaxDelay(dVar.f4294h);
        }
        extras.setPersisted(false);
        extras.setRequiresBatteryNotLow(dVar.f4291e);
        extras.setRequiresStorageNotLow(dVar.f4292f);
        boolean z12 = pVar.f9773k > 0;
        boolean z13 = jMax > 0;
        if (pVar.f9779q && !z12 && !z13) {
            extras.setExpedited(true);
        }
        if (Build.VERSION.SDK_INT >= 35 && (str = pVar.f9786x) != null) {
            extras.setTraceTag(str);
        }
        JobInfo jobInfoBuild = extras.build();
        String str3 = f7248j;
        u.d().a(str3, "Scheduling work ID " + str2 + "Job ID " + i);
        try {
            try {
                if (this.f7250f.schedule(jobInfoBuild) == 0) {
                    u.d().g(str3, "Unable to schedule work ID " + str2);
                    if (pVar.f9779q) {
                        if (pVar.f9780r == 1) {
                            i10 = 0;
                            try {
                                pVar.f9779q = false;
                                u.d().a(str3, "Scheduling a non-expedited job (work ID " + str2 + ")");
                                g(pVar, i);
                            } catch (IllegalStateException e10) {
                                e = e10;
                                IllegalStateException illegalStateException = e;
                                Context context = this.f7249c;
                                WorkDatabase workDatabase = this.f7252h;
                                String str4 = a.f7243a;
                                context.getClass();
                                int size = workDatabase.C().h().size();
                                String strB0 = "<faulty JobScheduler failed to getPendingJobs>";
                                if (Build.VERSION.SDK_INT >= 34) {
                                    JobScheduler jobSchedulerA = a.a(context);
                                    try {
                                        allPendingJobs = jobSchedulerA.getAllPendingJobs();
                                        allPendingJobs.getClass();
                                    } catch (Throwable th) {
                                        u.d().c(a.f7243a, "getAllPendingJobs() is not reliable on this device.", th);
                                        allPendingJobs = null;
                                    }
                                    if (allPendingJobs != null) {
                                        ArrayList arrayListE = e(context, jobSchedulerA);
                                        int size2 = arrayListE != null ? allPendingJobs.size() - arrayListE.size() : i10;
                                        String str5 = size2 == 0 ? null : size2 + " of which are not owned by WorkManager";
                                        Object systemService = context.getSystemService("jobscheduler");
                                        systemService.getClass();
                                        ArrayList arrayListE2 = e(context, (JobScheduler) systemService);
                                        int size3 = arrayListE2 != null ? arrayListE2.size() : i10;
                                        strB0 = l.B0(k.p0(new String[]{allPendingJobs.size() + " jobs in \"androidx.work.systemjobscheduler\" namespace", str5, size3 != 0 ? size3 + " from WorkManager in the default namespace" : null}), ",\n", null, null, null, 62);
                                    }
                                } else {
                                    ArrayList arrayListE3 = e(context, a.a(context));
                                    if (arrayListE3 != null) {
                                        strB0 = arrayListE3.size() + " jobs from WorkManager";
                                    }
                                }
                                StringBuilder sb2 = new StringBuilder("JobScheduler 150 job limit exceeded.\nIn JobScheduler there are ");
                                sb2.append(strB0);
                                sb2.append(".\nThere are ");
                                sb2.append(size);
                                sb2.append(" jobs tracked by WorkManager's database;\nthe Configuration limit is ");
                                String strL = androidx.activity.b.l(sb2, aVar.f4277k, '.');
                                u.d().b(str3, strL);
                                throw new IllegalStateException(strL, illegalStateException);
                            }
                        }
                    }
                }
            } catch (IllegalStateException e11) {
                e = e11;
                i10 = 0;
            }
        } catch (Throwable th2) {
            u.d().c(str3, "Unable to schedule " + pVar, th2);
        }
    }
}
