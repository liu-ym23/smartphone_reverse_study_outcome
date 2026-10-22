package androidx.work.impl.background.systemjob;

import android.app.Application;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.net.Network;
import android.net.Uri;
import android.os.PersistableBundle;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.work.WorkerParameters;
import androidx.work.i;
import androidx.work.impl.ExecutionListener;
import androidx.work.impl.c0;
import androidx.work.impl.t;
import androidx.work.impl.u;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(23)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class SystemJobService extends JobService implements ExecutionListener {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f5488d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c0 f5489a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map f5490b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final u f5491c;

    public static class a {
        @DoNotInline
        public static String[] a(JobParameters r10) {
            return r10.getTriggeredContentAuthorities();
        }

        @DoNotInline
        public static Uri[] b(JobParameters r10) {
            return r10.getTriggeredContentUris();
        }
    }

    public static class b {
        @DoNotInline
        public static Network a(JobParameters r10) {
            return r10.getNetwork();
        }
    }

    static {
        f5488d = i.i("SystemJobService");
    }

    public SystemJobService() {
        this.f5490b = new HashMap();
        this.f5491c = new u();
    }

    public static androidx.work.impl.model.i a(JobParameters r10) {
        PersistableBundle r11 = r10.getExtras();     // Catch: NullPointerException -> L11
        if (r11 != null) goto L6;
        return null;
    L6:
        if (r11.containsKey("EXTRA_WORK_SPEC_ID") == false) goto L14;
        return new androidx.work.impl.model.i(r11.getString("EXTRA_WORK_SPEC_ID"), r11.getInt("EXTRA_WORK_SPEC_GENERATION"));
    L14:
        return null;
    L15:
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        c0 r10 = c0.l(getApplicationContext());     // Catch: IllegalStateException -> L5
        this.f5489a = r10;     // Catch: IllegalStateException -> L5
        r10.n().c(this);     // Catch: IllegalStateException -> L5
        return;
    L6:
        if (Application.class.equals(getApplication().getClass()) == false) goto L10;
        i.e().k(f5488d, "Could not find WorkManager instance; this may be because an auto-backup is in progress. Ignoring JobScheduler commands for now. Please make sure that you are initializing WorkManager if you have manually disabled WorkManagerInitializer.");
        return;
    L10:
        throw new IllegalStateException("WorkManager needs to be initialized via a ContentProvider#onCreate() or an Application#onCreate().");
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        c0 r10 = this.f5489a;
        if (r10 == null) goto L6;
        r10.n().j(this);
        return;
    }

    @Override // androidx.work.impl.ExecutionListener
    public void onExecuted(androidx.work.impl.model.i r10, boolean r11) {
        i.e().a(f5488d, r10.b() + " executed on JobScheduler");
        Map r12 = this.f5490b;
        monitor-enter(r12);
        JobParameters r13 = (JobParameters) this.f5490b.remove(r10);     // Catch: Throwable -> L10
        monitor-exit(r12);     // Catch: Throwable -> L10
        this.f5491c.b(r10);
        if (r13 == null) goto L15;
        jobFinished(r13, r11);
        return;
    L15:
        return;
    L10:
        th = move-exception;
        throw th;
    }

    @Override // android.app.job.JobService
    public boolean onStartJob(JobParameters r10) {
        if (this.f5489a != null) goto L6;
        i.e().a(f5488d, "WorkManager is not initialized; requesting retry.");
        jobFinished(r10, true);
        return false;
    L6:
        androidx.work.impl.model.i r11 = a(r10);
        if (r11 != null) goto L10;
        i.e().c(f5488d, "WorkSpec id not found!");
        return false;
    L10:
        Map r12 = this.f5490b;
        monitor-enter(r12);
    L17:
        th = move-exception;
        throw th;
    L13:
        if (this.f5490b.containsKey(r11) == false) goto L19;
        i.e().a(f5488d, "Job is already being executed by SystemJobService: " + r11);     // Catch: Throwable -> L17
        monitor-exit(r12);     // Catch: Throwable -> L17
        return false;
    L19:
        i.e().a(f5488d, "onStartJob for " + r11);     // Catch: Throwable -> L17
        this.f5490b.put(r11, r10);     // Catch: Throwable -> L17
        monitor-exit(r12);     // Catch: Throwable -> L17
        WorkerParameters.a r13 = new WorkerParameters.a();
        if (a.b(r10) == null) goto L25;
        r13.f5390b = Arrays.asList(a.b(r10));
    L25:
        if (a.a(r10) == null) goto L27;
        r13.f5389a = Arrays.asList(a.a(r10));
    L27:
        r13.f5391c = b.a(r10);
        this.f5489a.x(this.f5491c.d(r11), r13);
        return true;
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters r10) {
        if (this.f5489a != null) goto L6;
        i.e().a(f5488d, "WorkManager is not initialized; requesting retry.");
        return true;
    L6:
        androidx.work.impl.model.i r11 = a(r10);
        if (r11 != null) goto L10;
        i.e().c(f5488d, "WorkSpec id not found!");
        return false;
    L10:
        i.e().a(f5488d, "onStopJob for " + r11);
        Map r12 = this.f5490b;
        monitor-enter(r12);
        this.f5490b.remove(r11);     // Catch: Throwable -> L19
        monitor-exit(r12);     // Catch: Throwable -> L19
        t r13 = this.f5491c.b(r11);
        if (r13 == null) goto L18;
        this.f5489a.z(r13);
    L18:
        return !this.f5489a.n().f(r11.b());
    L19:
        th = move-exception;
        throw th;
    }
}
