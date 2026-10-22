package androidx.work.impl.background.systemjob;

import B0.e;
import B0.k;
import H.a;
import android.app.Application;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.os.PersistableBundle;
import android.support.v4.media.session.c;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import e.EnumC0546d;
import java.util.Arrays;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import s0.t;
import t0.C0911F;
import t0.C0913H;
import t0.InterfaceC0918d;
import t0.r;
import t0.x;
import w0.d;

@RequiresApi(23)
@RestrictTo({EnumC0546d.f12493b})
/* loaded from: classes.dex */
public class SystemJobService extends JobService implements InterfaceC0918d {

    /* renamed from: e, reason: collision with root package name */
    public static final String f4334e = t.f("SystemJobService");

    /* renamed from: a, reason: collision with root package name */
    public C0913H f4335a;

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f4336b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    public final e f4337c = new e();

    /* renamed from: d, reason: collision with root package name */
    public C0911F f4338d;

    public static k a(JobParameters jobParameters) {
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

    @Override // t0.InterfaceC0918d
    public final void c(k kVar, boolean z4) {
        JobParameters jobParameters;
        t.d().a(f4334e, kVar.f150a + " executed on JobScheduler");
        synchronized (this.f4336b) {
            jobParameters = (JobParameters) this.f4336b.remove(kVar);
        }
        this.f4337c.m(kVar);
        if (jobParameters != null) {
            jobFinished(jobParameters, z4);
        }
    }

    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
        try {
            C0913H c0913hE0 = C0913H.e0(getApplicationContext());
            this.f4335a = c0913hE0;
            r rVar = c0913hE0.f15330g;
            this.f4338d = new C0911F(rVar, c0913hE0.f15328e);
            rVar.a(this);
        } catch (IllegalStateException e4) {
            if (!Application.class.equals(getApplication().getClass())) {
                throw new IllegalStateException("WorkManager needs to be initialized via a ContentProvider#onCreate() or an Application#onCreate().", e4);
            }
            t.d().g(f4334e, "Could not find WorkManager instance; this may be because an auto-backup is in progress. Ignoring JobScheduler commands for now. Please make sure that you are initializing WorkManager if you have manually disabled WorkManagerInitializer.");
        }
    }

    @Override // android.app.Service
    public final void onDestroy() {
        super.onDestroy();
        C0913H c0913h = this.f4335a;
        if (c0913h != null) {
            c0913h.f15330g.f(this);
        }
    }

    @Override // android.app.job.JobService
    public final boolean onStartJob(JobParameters jobParameters) {
        if (this.f4335a == null) {
            t.d().a(f4334e, "WorkManager is not initialized; requesting retry.");
            jobFinished(jobParameters, true);
            return false;
        }
        k kVarA = a(jobParameters);
        if (kVarA == null) {
            t.d().b(f4334e, "WorkSpec id not found!");
            return false;
        }
        synchronized (this.f4336b) {
            try {
                if (this.f4336b.containsKey(kVarA)) {
                    t.d().a(f4334e, "Job is already being executed by SystemJobService: " + kVarA);
                    return false;
                }
                t.d().a(f4334e, "onStartJob for " + kVarA);
                this.f4336b.put(kVarA, jobParameters);
                c cVar = new c(11);
                if (w0.c.b(jobParameters) != null) {
                    cVar.f2365c = Arrays.asList(w0.c.b(jobParameters));
                }
                if (w0.c.a(jobParameters) != null) {
                    cVar.f2364b = Arrays.asList(w0.c.a(jobParameters));
                }
                cVar.f2366d = d.a(jobParameters);
                C0911F c0911f = this.f4338d;
                x workSpecId = this.f4337c.n(kVarA);
                c0911f.getClass();
                Intrinsics.checkNotNullParameter(workSpecId, "workSpecId");
                c0911f.f15321b.a(new a(c0911f.f15320a, workSpecId, cVar));
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.app.job.JobService
    public final boolean onStopJob(JobParameters jobParameters) {
        boolean zContains;
        if (this.f4335a == null) {
            t.d().a(f4334e, "WorkManager is not initialized; requesting retry.");
            return true;
        }
        k kVarA = a(jobParameters);
        if (kVarA == null) {
            t.d().b(f4334e, "WorkSpec id not found!");
            return false;
        }
        t.d().a(f4334e, "onStopJob for " + kVarA);
        synchronized (this.f4336b) {
            this.f4336b.remove(kVarA);
        }
        x workSpecId = this.f4337c.m(kVarA);
        if (workSpecId != null) {
            int iA = w0.e.a(jobParameters);
            C0911F c0911f = this.f4338d;
            c0911f.getClass();
            Intrinsics.checkNotNullParameter(workSpecId, "workSpecId");
            c0911f.a(workSpecId, iA);
        }
        r rVar = this.f4335a.f15330g;
        String str = kVarA.f150a;
        synchronized (rVar.f15413k) {
            zContains = rVar.f15411i.contains(str);
        }
        return !zContains;
    }
}
