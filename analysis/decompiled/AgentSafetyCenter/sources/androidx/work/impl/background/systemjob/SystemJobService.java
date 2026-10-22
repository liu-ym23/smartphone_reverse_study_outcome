package androidx.work.impl.background.systemjob;

import android.app.Application;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.os.Looper;
import android.os.PersistableBundle;
import e6.n;
import g5.u;
import h5.a;
import h5.d;
import h5.r;
import java.lang.invoke.VarHandle;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import od.f;
import p5.e;
import p5.j;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class SystemJobService extends JobService implements a {
    public static final String i = u.f("SystemJobService");

    /* renamed from: c, reason: collision with root package name */
    public r f1674c;

    /* renamed from: f, reason: collision with root package name */
    public final HashMap f1675f = new HashMap();

    /* renamed from: g, reason: collision with root package name */
    public final n f1676g;

    /* renamed from: h, reason: collision with root package name */
    public e f1677h;

    public SystemJobService() {
        n nVar = new n();
        nVar.f3587c = new LinkedHashMap();
        VarHandle.storeStoreFence();
        this.f1676g = nVar;
    }

    public static void a(String str) {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            return;
        }
        f.e(k0.a.C("Cannot invoke ", str, " on a background thread"));
    }

    public static j b(JobParameters jobParameters) {
        try {
            PersistableBundle extras = jobParameters.getExtras();
            if (extras == null || !extras.containsKey("EXTRA_WORK_SPEC_ID")) {
                return null;
            }
            return new j(extras.getString("EXTRA_WORK_SPEC_ID"), extras.getInt("EXTRA_WORK_SPEC_GENERATION"));
        } catch (NullPointerException unused) {
            return null;
        }
    }

    @Override // h5.a
    public final void e(j jVar, boolean z10) {
        a("onExecuted");
        u.d().a(i, jVar.f9734a + " executed on JobScheduler");
        JobParameters jobParameters = (JobParameters) this.f1675f.remove(jVar);
        this.f1676g.b(jVar);
        if (jobParameters != null) {
            jobFinished(jobParameters, z10);
        }
    }

    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
        try {
            r rVarB = r.b(getApplicationContext());
            this.f1674c = rVarB;
            d dVar = rVarB.f5375f;
            this.f1677h = new e(dVar, rVarB.f5373d);
            dVar.a(this);
        } catch (IllegalStateException e10) {
            if (!Application.class.equals(getApplication().getClass())) {
                throw new IllegalStateException("WorkManager needs to be initialized via a ContentProvider#onCreate() or an Application#onCreate().", e10);
            }
            u.d().g(i, "Could not find WorkManager instance; this may be because an auto-backup is in progress. Ignoring JobScheduler commands for now. Please make sure that you are initializing WorkManager if you have manually disabled WorkManagerInitializer.");
        }
    }

    @Override // android.app.Service
    public final void onDestroy() {
        super.onDestroy();
        r rVar = this.f1674c;
        if (rVar != null) {
            rVar.f5375f.f(this);
        }
    }

    @Override // android.app.job.JobService
    public final boolean onStartJob(JobParameters jobParameters) {
        a("onStartJob");
        r rVar = this.f1674c;
        String str = i;
        if (rVar == null) {
            u.d().a(str, "WorkManager is not initialized; requesting retry.");
            jobFinished(jobParameters, true);
            return false;
        }
        j jVarB = b(jobParameters);
        if (jVarB == null) {
            u.d().b(str, "WorkSpec id not found!");
            return false;
        }
        HashMap map = this.f1675f;
        if (map.containsKey(jVarB)) {
            u.d().a(str, "Job is already being executed by SystemJobService: " + jVarB);
            return false;
        }
        u.d().a(str, "onStartJob for " + jVarB);
        map.put(jVarB, jobParameters);
        n6.a aVar = new n6.a();
        if (jobParameters.getTriggeredContentUris() != null) {
            aVar.f8777f = Arrays.asList(jobParameters.getTriggeredContentUris());
        }
        if (jobParameters.getTriggeredContentAuthorities() != null) {
            aVar.f8776c = Arrays.asList(jobParameters.getTriggeredContentAuthorities());
        }
        jobParameters.getNetwork();
        this.f1677h.x(this.f1676g.d(jVarB), aVar);
        return true;
    }

    @Override // android.app.job.JobService
    public final boolean onStopJob(JobParameters jobParameters) {
        boolean zContains;
        a("onStopJob");
        if (this.f1674c == null) {
            u.d().a(i, "WorkManager is not initialized; requesting retry.");
            return true;
        }
        j jVarB = b(jobParameters);
        if (jVarB == null) {
            u.d().b(i, "WorkSpec id not found!");
            return false;
        }
        u.d().a(i, "onStopJob for " + jVarB);
        this.f1675f.remove(jVarB);
        h5.j jVarB2 = this.f1676g.b(jVarB);
        if (jVarB2 != null) {
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
                    break;
                default:
                    stopReason = -512;
                    break;
            }
            e eVar = this.f1677h;
            eVar.getClass();
            eVar.y(jVarB2, stopReason);
        }
        d dVar = this.f1674c.f5375f;
        String str = jVarB.f9734a;
        synchronized (dVar.f5324j) {
            zContains = dVar.f5323h.contains(str);
        }
        return !zContains;
    }
}
