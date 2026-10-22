package androidx.work.impl.background.systemjob;

import a0.a;
import android.app.Application;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.os.Build;
import android.os.Looper;
import android.os.PersistableBundle;
import androidx.work.WorkerParameters;
import h2.j;
import i2.b;
import i2.s;
import java.util.Arrays;
import java.util.HashMap;
import q2.k;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class SystemJobService extends JobService implements b {

    /* renamed from: e, reason: collision with root package name */
    public static final String f2895e = j.f("SystemJobService");

    /* renamed from: a, reason: collision with root package name */
    public androidx.work.impl.b f2896a;

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f2897b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    public final stepos.support.v7.app.palette.b f2898c = new stepos.support.v7.app.palette.b(9);

    /* renamed from: d, reason: collision with root package name */
    public s f2899d;

    public static void b(String str) {
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            throw new IllegalStateException(a.k("Cannot invoke ", str, " on a background thread"));
        }
    }

    public static k c(JobParameters jobParameters) {
        try {
            PersistableBundle extras = jobParameters.getExtras();
            if (extras == null || !extras.containsKey("EXTRA_WORK_SPEC_ID")) {
                return null;
            }
            return new k(extras.getString("EXTRA_WORK_SPEC_ID"), extras.getInt("EXTRA_WORK_SPEC_GENERATION"));
        } catch (NullPointerException unused) {
            return null;
        }
    }

    @Override // i2.b
    public final void a(k kVar, boolean z) {
        b("onExecuted");
        j.d().a(f2895e, kVar.f11498a + " executed on JobScheduler");
        JobParameters jobParameters = (JobParameters) this.f2897b.remove(kVar);
        this.f2898c.i(kVar);
        if (jobParameters != null) {
            jobFinished(jobParameters, z);
        }
    }

    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
        try {
            androidx.work.impl.b bVarA = androidx.work.impl.b.a(getApplicationContext());
            this.f2896a = bVarA;
            androidx.work.impl.a aVar = bVarA.f2882f;
            this.f2899d = new s(aVar, bVarA.f2880d);
            aVar.a(this);
        } catch (IllegalStateException e10) {
            if (!Application.class.equals(getApplication().getClass())) {
                throw new IllegalStateException("WorkManager needs to be initialized via a ContentProvider#onCreate() or an Application#onCreate().", e10);
            }
            j.d().g(f2895e, "Could not find WorkManager instance; this may be because an auto-backup is in progress. Ignoring JobScheduler commands for now. Please make sure that you are initializing WorkManager if you have manually disabled WorkManagerInitializer.");
        }
    }

    @Override // android.app.Service
    public final void onDestroy() {
        super.onDestroy();
        androidx.work.impl.b bVar = this.f2896a;
        if (bVar != null) {
            bVar.f2882f.f(this);
        }
    }

    @Override // android.app.job.JobService
    public final boolean onStartJob(JobParameters jobParameters) {
        b("onStartJob");
        androidx.work.impl.b bVar = this.f2896a;
        String str = f2895e;
        if (bVar == null) {
            j.d().a(str, "WorkManager is not initialized; requesting retry.");
            jobFinished(jobParameters, true);
            return false;
        }
        k kVarC = c(jobParameters);
        if (kVarC == null) {
            j.d().b(str, "WorkSpec id not found!");
            return false;
        }
        HashMap map = this.f2897b;
        if (map.containsKey(kVarC)) {
            j.d().a(str, "Job is already being executed by SystemJobService: " + kVarC);
            return false;
        }
        j.d().a(str, "onStartJob for " + kVarC);
        map.put(kVarC, jobParameters);
        WorkerParameters.a aVar = new WorkerParameters.a();
        if (jobParameters.getTriggeredContentUris() != null) {
            aVar.f2812b = Arrays.asList(jobParameters.getTriggeredContentUris());
        }
        if (jobParameters.getTriggeredContentAuthorities() != null) {
            aVar.f2811a = Arrays.asList(jobParameters.getTriggeredContentAuthorities());
        }
        aVar.f2813c = jobParameters.getNetwork();
        this.f2899d.c(this.f2898c.l(kVarC), aVar);
        return true;
    }

    @Override // android.app.job.JobService
    public final boolean onStopJob(JobParameters jobParameters) {
        boolean zContains;
        b("onStopJob");
        if (this.f2896a == null) {
            j.d().a(f2895e, "WorkManager is not initialized; requesting retry.");
            return true;
        }
        k kVarC = c(jobParameters);
        if (kVarC == null) {
            j.d().b(f2895e, "WorkSpec id not found!");
            return false;
        }
        j.d().a(f2895e, "onStopJob for " + kVarC);
        this.f2897b.remove(kVarC);
        i2.k kVarI = this.f2898c.i(kVarC);
        if (kVarI != null) {
            int i10 = -512;
            if (Build.VERSION.SDK_INT >= 31) {
                int stopReason = jobParameters.getStopReason();
                switch (stopReason) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    case 9:
                    case 10:
                    case 11:
                    case 12:
                    case 13:
                    case 14:
                    case 15:
                        i10 = stopReason;
                        break;
                }
            }
            s sVar = this.f2899d;
            sVar.getClass();
            sVar.b(kVarI, i10);
        }
        androidx.work.impl.a aVar = this.f2896a.f2882f;
        String str = kVarC.f11498a;
        synchronized (aVar.f2873k) {
            zContains = aVar.f2871i.contains(str);
        }
        return !zContains;
    }
}
