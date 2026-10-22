package androidx.work.impl.background.systemjob;

import android.app.Application;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.os.Build;
import android.os.PersistableBundle;
import android.text.TextUtils;
import androidx.work.Logger;
import androidx.work.WorkerParameters;
import androidx.work.impl.ExecutionListener;
import androidx.work.impl.WorkManagerImpl;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class SystemJobService extends JobService implements ExecutionListener {
    private static final String TAG = null;
    private final Map<String, JobParameters> mJobParameters;
    private WorkManagerImpl mWorkManagerImpl;

    static {
        TAG = Logger.tagWithPrefix("SystemJobService");
    }

    public SystemJobService() {
        this.mJobParameters = new HashMap();
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        WorkManagerImpl r100 = WorkManagerImpl.getInstance(getApplicationContext());     // Catch: IllegalStateException -> L5
        this.mWorkManagerImpl = r100;     // Catch: IllegalStateException -> L5
        r100.getProcessor().addExecutionListener(this);     // Catch: IllegalStateException -> L5
        return;
    L6:
        if (Application.class.equals(getApplication().getClass()) == false) goto L10;
        Logger.get().warning(TAG, "Could not find WorkManager instance; this may be because an auto-backup is in progress. Ignoring JobScheduler commands for now. Please make sure that you are initializing WorkManager if you have manually disabled WorkManagerInitializer.", new Throwable[0]);
        return;
    L10:
        throw new IllegalStateException("WorkManager needs to be initialized via a ContentProvider#onCreate() or an Application#onCreate().");
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        WorkManagerImpl r100 = this.mWorkManagerImpl;
        if (r100 == null) goto L6;
        r100.getProcessor().removeExecutionListener(this);
        return;
    }

    private static String getWorkSpecIdFromJobParameters(JobParameters r100) {
        PersistableBundle r101 = r100.getExtras();     // Catch: NullPointerException -> L11
        if (r101 != null) goto L6;
        return null;
    L6:
        if (r101.containsKey("EXTRA_WORK_SPEC_ID") == false) goto L14;
        return r101.getString("EXTRA_WORK_SPEC_ID");
    L14:
        return null;
    L15:
        return null;
    }

    @Override // android.app.job.JobService
    public boolean onStartJob(JobParameters r100) {
        if (this.mWorkManagerImpl != null) goto L6;
        Logger.get().debug(TAG, "WorkManager is not initialized; requesting retry.", new Throwable[0]);
        jobFinished(r100, true);
        return false;
    L6:
        String r101 = getWorkSpecIdFromJobParameters(r100);
        if (TextUtils.isEmpty(r101) == false) goto L10;
        Logger.get().error(TAG, "WorkSpec id not found!", new Throwable[0]);
        return false;
    L10:
        Map<String, JobParameters> r102 = this.mJobParameters;
        monitor-enter(r102);
    L33:
        th = move-exception;
        throw th;
    L13:
        if (this.mJobParameters.containsKey(r101) == false) goto L17;
        Logger.get().debug(TAG, String.format("Job is already being executed by SystemJobService: %s", new Object[]{r101}), new Throwable[0]);     // Catch: Throwable -> L33
        monitor-exit(r102);     // Catch: Throwable -> L33
        return false;
    L17:
        Logger.get().debug(TAG, String.format("onStartJob for %s", new Object[]{r101}), new Throwable[0]);     // Catch: Throwable -> L33
        this.mJobParameters.put(r101, r100);     // Catch: Throwable -> L33
        monitor-exit(r102);     // Catch: Throwable -> L33
        int r103 = Build.VERSION.SDK_INT;
        if (r103 < 24) goto L30;
        WorkerParameters.RuntimeExtras r104 = new WorkerParameters.RuntimeExtras();
        if (r100.getTriggeredContentUris() == null) goto L25;
        r104.triggeredContentUris = Arrays.asList(r100.getTriggeredContentUris());
    L25:
        if (r100.getTriggeredContentAuthorities() == null) goto L28;
        r104.triggeredContentAuthorities = Arrays.asList(r100.getTriggeredContentAuthorities());
    L28:
        if (r103 < 28) goto L31;
        r104.network = r100.getNetwork();
    L31:
        this.mWorkManagerImpl.startWork(r101, r104);
        return true;
    L30:
        r104 = null;
        goto L31
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters r100) {
        if (this.mWorkManagerImpl != null) goto L6;
        Logger.get().debug(TAG, "WorkManager is not initialized; requesting retry.", new Throwable[0]);
        return true;
    L6:
        String r101 = getWorkSpecIdFromJobParameters(r100);
        if (TextUtils.isEmpty(r101) == false) goto L10;
        Logger.get().error(TAG, "WorkSpec id not found!", new Throwable[0]);
        return false;
    L10:
        Logger.get().debug(TAG, String.format("onStopJob for %s", new Object[]{r101}), new Throwable[0]);
        Map<String, JobParameters> r102 = this.mJobParameters;
        monitor-enter(r102);
        this.mJobParameters.remove(r101);     // Catch: Throwable -> L16
        monitor-exit(r102);     // Catch: Throwable -> L16
        this.mWorkManagerImpl.stopWork(r101);
        return !this.mWorkManagerImpl.getProcessor().isCancelled(r101);
    L16:
        th = move-exception;
        throw th;
    }

    @Override // androidx.work.impl.ExecutionListener
    public void onExecuted(String r100, boolean r101) {
        Logger.get().debug(TAG, String.format("%s executed on JobScheduler", new Object[]{r100}), new Throwable[0]);
        Map<String, JobParameters> r102 = this.mJobParameters;
        monitor-enter(r102);
        JobParameters r103 = this.mJobParameters.remove(r100);     // Catch: Throwable -> L9
        monitor-exit(r102);     // Catch: Throwable -> L9
        if (r103 == null) goto L14;
        jobFinished(r103, r101);
        return;
    L14:
        return;
    L9:
        th = move-exception;
        throw th;
    }
}
