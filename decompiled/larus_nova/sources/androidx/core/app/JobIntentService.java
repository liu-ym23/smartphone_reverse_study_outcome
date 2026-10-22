package androidx.core.app;

import android.app.Service;
import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobServiceEngine;
import android.app.job.JobWorkItem;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.IBinder;
import android.os.PowerManager;
import com.bytedance.apm.battery.config.BatteryTypeInf;
import com.obric.performance.power.monitor.cpu.d;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadAsyncTask;
import fna.g;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: classes17.dex */
public abstract class JobIntentService extends Service {
    static final boolean DEBUG = false;
    static final String TAG = "JobIntentService";
    static final HashMap<ComponentName, WorkEnqueuer> sClassWorkEnqueuer = null;
    static final Object sLock = null;
    final ArrayList<CompatWorkItem> mCompatQueue;
    WorkEnqueuer mCompatWorkEnqueuer;
    CommandProcessor mCurProcessor;
    boolean mDestroyed;
    boolean mInterruptIfStopped;
    CompatJobEngine mJobImpl;
    boolean mStopped;

    public final class CommandProcessor extends PthreadAsyncTask<Void, Void, Void> {
        final /* synthetic */ JobIntentService this$0;

        public CommandProcessor(JobIntentService r100) {
            this.this$0 = r100;
        }

        public Void doInBackground(Void... r100) {
        L2:
            GenericWorkItem r101 = this.this$0.dequeueWork();
            if (r101 == null) goto L5;
            this.this$0.onHandleWork(r101.getIntent());
            r101.complete();
            goto L2
        L5:
            return null;
        }

        @Override // android.os.AsyncTask
        public /* bridge */ /* synthetic */ void onCancelled(Object r100) {
            onCancelled((Void) r100);
        }

        @Override // android.os.AsyncTask
        public /* bridge */ /* synthetic */ void onPostExecute(Object r100) {
            onPostExecute((Void) r100);
        }

        @Override // android.os.AsyncTask
        public /* bridge */ /* synthetic */ Object doInBackground(Object[] r100) {
            return doInBackground((Void[]) r100);
        }

        public void onCancelled(Void r100) {
            this.this$0.processorFinished();
        }

        public void onPostExecute(Void r100) {
            this.this$0.processorFinished();
        }
    }

    public interface CompatJobEngine {
        IBinder compatGetBinder();

        GenericWorkItem dequeueWork();
    }

    public static final class CompatWorkEnqueuer extends WorkEnqueuer {
        private final Context mContext;
        private final PowerManager.WakeLock mLaunchWakeLock;
        boolean mLaunchingService;
        private final PowerManager.WakeLock mRunWakeLock;
        boolean mServiceProcessing;

        @Override // androidx.core.app.JobIntentService.WorkEnqueuer
        public void serviceProcessingFinished() {
            monitor-enter(this);
        L11:
            th = move-exception;
            throw th;
        L4:
            if (this.mServiceProcessing == true) goto L6;
        L9:
            monitor-exit(this);     // Catch: Throwable -> L11
            return;
        L6:
            if (this.mLaunchingService == false) goto L8;
            INVOKEVIRTUAL_androidx_core_app_JobIntentService$CompatWorkEnqueuer_com_obric_performance_power_monitor_cpu_WakeLockLancet_acquire(this.mLaunchWakeLock, 60000);     // Catch: Throwable -> L11
        L8:
            this.mServiceProcessing = false;     // Catch: Throwable -> L11
            INVOKEVIRTUAL_androidx_core_app_JobIntentService$CompatWorkEnqueuer_com_obric_performance_power_monitor_cpu_WakeLockLancet_release(this.mRunWakeLock);     // Catch: Throwable -> L11
            goto L9
        }

        @Override // androidx.core.app.JobIntentService.WorkEnqueuer
        public void serviceProcessingStarted() {
            monitor-enter(this);
        L8:
            th = move-exception;
            throw th;
        L4:
            if (this.mServiceProcessing == true) goto L6;
            this.mServiceProcessing = true;     // Catch: Throwable -> L8
            INVOKEVIRTUAL_androidx_core_app_JobIntentService$CompatWorkEnqueuer_com_obric_performance_power_monitor_cpu_WakeLockLancet_acquire(this.mRunWakeLock, 600000);     // Catch: Throwable -> L8
            INVOKEVIRTUAL_androidx_core_app_JobIntentService$CompatWorkEnqueuer_com_obric_performance_power_monitor_cpu_WakeLockLancet_release(this.mLaunchWakeLock);     // Catch: Throwable -> L8
        L6:
            monitor-exit(this);     // Catch: Throwable -> L8
        }

        @Override // androidx.core.app.JobIntentService.WorkEnqueuer
        public void serviceStartReceived() {
            monitor-enter(this);
            this.mLaunchingService = false;     // Catch: Throwable -> L7
            monitor-exit(this);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        public static void INVOKEVIRTUAL_androidx_core_app_JobIntentService$CompatWorkEnqueuer_com_obric_performance_power_monitor_cpu_WakeLockLancet_release(PowerManager.WakeLock r100) {
            if (g.d() == true) goto L6;
            r100.release();
            return;
        L6:
            r100.release();
            d.b(r100);
        }

        @Override // androidx.core.app.JobIntentService.WorkEnqueuer
        public void enqueueWork(Intent r100) {
            Intent r101 = new Intent(r100);
            r101.setComponent(this.mComponentName);
            if (this.mContext.startService(r101) == null) goto L15;
            monitor-enter(this);
        L12:
            th = move-exception;
            throw th;
        L6:
            if (this.mLaunchingService == true) goto L10;
            this.mLaunchingService = true;     // Catch: Throwable -> L12
            if (this.mServiceProcessing == true) goto L10;
            INVOKEVIRTUAL_androidx_core_app_JobIntentService$CompatWorkEnqueuer_com_obric_performance_power_monitor_cpu_WakeLockLancet_acquire(this.mLaunchWakeLock, 60000);     // Catch: Throwable -> L12
        L10:
            monitor-exit(this);     // Catch: Throwable -> L12
            return;
        }

        public CompatWorkEnqueuer(Context r100, ComponentName r101) {
            super(r101);
            this.mContext = r100.getApplicationContext();
            PowerManager r102 = (PowerManager) r100.getSystemService(BatteryTypeInf.BATTERY_POWER_LOCK);
            PowerManager.WakeLock r103 = r102.newWakeLock(1, r101.getClassName() + ":launch");
            this.mLaunchWakeLock = r103;
            r103.setReferenceCounted(false);
            PowerManager.WakeLock r104 = r102.newWakeLock(1, r101.getClassName() + ":run");
            this.mRunWakeLock = r104;
            r104.setReferenceCounted(false);
        }

        public static void INVOKEVIRTUAL_androidx_core_app_JobIntentService$CompatWorkEnqueuer_com_obric_performance_power_monitor_cpu_WakeLockLancet_acquire(PowerManager.WakeLock r100, long r101) {
            if (g.d() == true) goto L6;
            r100.acquire(r101);
            return;
        L6:
            r100.acquire(r101);
            d.a(r100);
        }
    }

    public final class CompatWorkItem implements GenericWorkItem {
        final Intent mIntent;
        final int mStartId;
        final /* synthetic */ JobIntentService this$0;

        @Override // androidx.core.app.JobIntentService.GenericWorkItem
        public void complete() {
            this.this$0.stopSelf(this.mStartId);
        }

        @Override // androidx.core.app.JobIntentService.GenericWorkItem
        public Intent getIntent() {
            return this.mIntent;
        }

        public CompatWorkItem(JobIntentService r100, Intent r101, int r102) {
            this.this$0 = r100;
            this.mIntent = r101;
            this.mStartId = r102;
        }
    }

    public interface GenericWorkItem {
        void complete();

        Intent getIntent();
    }

    public static final class JobServiceEngineImpl extends JobServiceEngine implements CompatJobEngine {
        static final boolean DEBUG = false;
        static final String TAG = "JobServiceEngineImpl";
        final Object mLock;
        JobParameters mParams;
        final JobIntentService mService;

        public final class WrapperWorkItem implements GenericWorkItem {
            final JobWorkItem mJobWork;
            final /* synthetic */ JobServiceEngineImpl this$0;

            @Override // androidx.core.app.JobIntentService.GenericWorkItem
            public void complete() {
                Object r100 = this.this$0.mLock;
                monitor-enter(r100);
                JobParameters r101 = this.this$0.mParams;     // Catch: Throwable -> L9
                if (r101 == null) goto L7;
                r101.completeWork(this.mJobWork);     // Catch: Throwable -> L9
            L7:
                monitor-exit(r100);     // Catch: Throwable -> L9
                return;
            L9:
                th = move-exception;
                throw th;
            }

            @Override // androidx.core.app.JobIntentService.GenericWorkItem
            public Intent getIntent() {
                return this.mJobWork.getIntent();
            }

            public WrapperWorkItem(JobServiceEngineImpl r100, JobWorkItem r101) {
                this.this$0 = r100;
                this.mJobWork = r101;
            }
        }

        @Override // androidx.core.app.JobIntentService.CompatJobEngine
        public GenericWorkItem dequeueWork() {
            Object r100 = this.mLock;
            monitor-enter(r100);
            JobParameters r101 = this.mParams;     // Catch: Throwable -> L14
            if (r101 != null) goto L8;
            monitor-exit(r100);     // Catch: Throwable -> L14
            return null;
        L8:
            JobWorkItem r102 = r101.dequeueWork();     // Catch: Throwable -> L14
            monitor-exit(r100);     // Catch: Throwable -> L14
            if (r102 == null) goto L13;
            r102.getIntent().setExtrasClassLoader(this.mService.getClassLoader());
            return new WrapperWorkItem(this, r102);
        L13:
            return null;
        L14:
            th = move-exception;
            throw th;
        }

        @Override // androidx.core.app.JobIntentService.CompatJobEngine
        public IBinder compatGetBinder() {
            return getBinder();
        }

        public JobServiceEngineImpl(JobIntentService r100) {
            super(r100);
            this.mLock = new Object();
            this.mService = r100;
        }

        @Override // android.app.job.JobServiceEngine
        public boolean onStartJob(JobParameters r100) {
            this.mParams = r100;
            this.mService.ensureProcessorRunningLocked(false);
            return true;
        }

        @Override // android.app.job.JobServiceEngine
        public boolean onStopJob(JobParameters r100) {
            boolean r101 = this.mService.doStopCurrentWork();
            Object r102 = this.mLock;
            monitor-enter(r102);
            this.mParams = null;     // Catch: Throwable -> L8
            monitor-exit(r102);     // Catch: Throwable -> L8
            return r101;
        L8:
            th = move-exception;
            throw th;
        }
    }

    public static final class JobWorkEnqueuer extends WorkEnqueuer {
        private final JobInfo mJobInfo;
        private final JobScheduler mJobScheduler;

        @Override // androidx.core.app.JobIntentService.WorkEnqueuer
        public void enqueueWork(Intent r100) {
            this.mJobScheduler.enqueue(this.mJobInfo, new JobWorkItem(r100));
        }

        public JobWorkEnqueuer(Context r100, ComponentName r101, int r102) {
            super(r101);
            ensureJobId(r102);
            this.mJobInfo = new JobInfo.Builder(r102, this.mComponentName).setOverrideDeadline(0).build();
            this.mJobScheduler = (JobScheduler) r100.getApplicationContext().getSystemService("jobscheduler");
        }
    }

    public static abstract class WorkEnqueuer {
        final ComponentName mComponentName;
        boolean mHasJobId;
        int mJobId;

        public abstract void enqueueWork(Intent r100);

        public void serviceProcessingFinished() {
        }

        public void serviceProcessingStarted() {
        }

        public void serviceStartReceived() {
        }

        public WorkEnqueuer(ComponentName r100) {
            this.mComponentName = r100;
        }

        public void ensureJobId(int r100) {
            if (this.mHasJobId == true) goto L6;
            this.mHasJobId = true;
            this.mJobId = r100;
            return;
        L6:
            if (this.mJobId != r100) goto L9;
            return;
        L9:
            throw new IllegalArgumentException("Given job ID " + r100 + " is different than previous " + this.mJobId);
        }
    }

    public abstract void onHandleWork(Intent r100);

    public boolean onStopCurrentWork() {
        return true;
    }

    static {
        sLock = new Object();
        sClassWorkEnqueuer = new HashMap();
    }

    public GenericWorkItem dequeueWork() {
        CompatJobEngine r100 = this.mJobImpl;
        if (r100 != null) goto L5;
        ArrayList<CompatWorkItem> r101 = this.mCompatQueue;
        monitor-enter(r101);
    L16:
        th = move-exception;
        throw th;
    L9:
        if (this.mCompatQueue.size() <= 0) goto L13;
        CompatWorkItem r102 = this.mCompatQueue.remove(0);     // Catch: Throwable -> L16
        monitor-exit(r101);     // Catch: Throwable -> L16
        return r102;
    L13:
        monitor-exit(r101);     // Catch: Throwable -> L16
        return null;
    L5:
        return r100.dequeueWork();
    }

    public boolean doStopCurrentWork() {
        CommandProcessor r100 = this.mCurProcessor;
        if (r100 == null) goto L5;
        r100.cancel(this.mInterruptIfStopped);
    L5:
        this.mStopped = true;
        return onStopCurrentWork();
    }

    public void processorFinished() {
        ArrayList<CompatWorkItem> r100 = this.mCompatQueue;
        if (r100 == null) goto L19;
        monitor-enter(r100);
        this.mCurProcessor = null;     // Catch: Throwable -> L16
        ArrayList<CompatWorkItem> r101 = this.mCompatQueue;     // Catch: Throwable -> L16
        if (r101 == null) goto L12;
        if (r101.size() <= 0) goto L12;
        ensureProcessorRunningLocked(false);     // Catch: Throwable -> L16
    L14:
        monitor-exit(r100);     // Catch: Throwable -> L16
        return;
    L12:
        if (this.mDestroyed == true) goto L14;
        this.mCompatWorkEnqueuer.serviceProcessingFinished();     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        throw th;
    }

    public JobIntentService() {
        this.mInterruptIfStopped = false;
        this.mStopped = false;
        this.mDestroyed = false;
        if (Build.VERSION.SDK_INT < 26) goto L5;
        this.mCompatQueue = null;
        return;
    L5:
        this.mCompatQueue = new ArrayList();
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        if (Build.VERSION.SDK_INT < 26) goto L5;
        this.mJobImpl = new JobServiceEngineImpl(this);
        this.mCompatWorkEnqueuer = null;
        return;
    L5:
        this.mJobImpl = null;
        this.mCompatWorkEnqueuer = getWorkEnqueuer(this, new ComponentName(this, getClass()), false, 0);
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        ArrayList<CompatWorkItem> r100 = this.mCompatQueue;
        if (r100 == null) goto L12;
        monitor-enter(r100);
        this.mDestroyed = true;     // Catch: Throwable -> L9
        this.mCompatWorkEnqueuer.serviceProcessingFinished();     // Catch: Throwable -> L9
        monitor-exit(r100);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public boolean isStopped() {
        return this.mStopped;
    }

    public void ensureProcessorRunningLocked(boolean r100) {
        if (this.mCurProcessor != null) goto L10;
        this.mCurProcessor = new CommandProcessor(this);
        WorkEnqueuer r101 = this.mCompatWorkEnqueuer;
        if (r101 == null) goto L8;
        if (r100 == false) goto L8;
        r101.serviceProcessingStarted();
    L8:
        this.mCurProcessor.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        return;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent r100) {
        CompatJobEngine r101 = this.mJobImpl;
        if (r101 != null) goto L5;
        return null;
    L5:
        return r101.compatGetBinder();
    }

    public void setInterruptIfStopped(boolean r100) {
        this.mInterruptIfStopped = r100;
    }

    @Override // android.app.Service
    public int onStartCommand(Intent r100, int r101, int r102) {
        if (this.mCompatQueue == null) goto L17;
        this.mCompatWorkEnqueuer.serviceStartReceived();
        ArrayList<CompatWorkItem> r103 = this.mCompatQueue;
        monitor-enter(r103);
        ArrayList<CompatWorkItem> r104 = this.mCompatQueue;     // Catch: Throwable -> L14
        if (r100 != null) goto L10;
        r100 = new Intent();     // Catch: Throwable -> L14
    L10:
        r104.add(new CompatWorkItem(this, r100, r102));     // Catch: Throwable -> L14
        ensureProcessorRunningLocked(true);     // Catch: Throwable -> L14
        monitor-exit(r103);     // Catch: Throwable -> L14
        return 3;
    L14:
        th = move-exception;
        throw th;
    L17:
        return 2;
    }

    public static void enqueueWork(Context r100, ComponentName r101, int r102, Intent r103) {
        if (r103 == null) goto L13;
        Object r104 = sLock;
        monitor-enter(r104);
        WorkEnqueuer r105 = getWorkEnqueuer(r100, r101, true, r102);     // Catch: Throwable -> L9
        r105.ensureJobId(r102);     // Catch: Throwable -> L9
        r105.enqueueWork(r103);     // Catch: Throwable -> L9
        monitor-exit(r104);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    L13:
        throw new IllegalArgumentException("work must not be null");
    }

    public static WorkEnqueuer getWorkEnqueuer(Context r100, ComponentName r101, boolean r102, int r103) {
        HashMap<ComponentName, WorkEnqueuer> r104 = sClassWorkEnqueuer;
        WorkEnqueuer r105 = r104.get(r101);
        if (r105 == null) goto L5;
        return r105;
    L5:
        if (Build.VERSION.SDK_INT < 26) goto L10;
        if (r102 == false) goto L9;
        WorkEnqueuer r106 = new JobWorkEnqueuer(r100, r101, r103);
    L11:
        WorkEnqueuer r107 = r106;
        r104.put(r101, r107);
        return r107;
    L9:
        throw new IllegalArgumentException("Can't be here without a job id");
    L10:
        r106 = new CompatWorkEnqueuer(r100, r101);
        goto L11
    }

    public static void enqueueWork(Context r100, Class<?> r101, int r102, Intent r103) {
        enqueueWork(r100, new ComponentName(r100, r101), r102, r103);
    }
}
