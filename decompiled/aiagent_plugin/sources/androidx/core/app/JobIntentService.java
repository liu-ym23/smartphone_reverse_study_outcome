package androidx.core.app;

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
import com.volcengine.zeus.service.PluginService;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public abstract class JobIntentService extends PluginService {
    static final boolean DEBUG = false;
    static final String TAG = "JobIntentService";
    static final HashMap<ComponentName, f> sClassWorkEnqueuer = null;
    static final Object sLock = null;
    final ArrayList<c> mCompatQueue;
    f mCompatWorkEnqueuer;
    CommandProcessor mCurProcessor;
    boolean mDestroyed;
    boolean mInterruptIfStopped;
    a mJobImpl;
    boolean mStopped;

    final class CommandProcessor extends AsyncTask<Void, Void, Void> {
        final /* synthetic */ JobIntentService this$0;

        CommandProcessor(JobIntentService r3) {
            this.this$0 = (JobIntentService) ZeusTransformUtils.wrapperContextForParams(r3, JobIntentService.class, "com.obric.aiagent.plugin");
        }

        @Override // android.os.AsyncTask
        public /* synthetic */ Void doInBackground(Void[] r3) {
            return doInBackground2((Void[]) ZeusTransformUtils.preCheckCast(r3, Void[].class, "com.obric.aiagent.plugin"));
        }

        @Override // android.os.AsyncTask
        public /* synthetic */ void onCancelled(Void r3) {
            onCancelled2((Void) ZeusTransformUtils.preCheckCast(r3, Void.class, "com.obric.aiagent.plugin"));
        }

        @Override // android.os.AsyncTask
        public /* synthetic */ void onPostExecute(Void r3) {
            onPostExecute2((Void) ZeusTransformUtils.preCheckCast(r3, Void.class, "com.obric.aiagent.plugin"));
        }

        /* JADX INFO: renamed from: doInBackground, reason: avoid collision after fix types in other method */
        public Void doInBackground2(Void... r3) {
        L2:
            d r4 = this.this$0.dequeueWork();
            if (r4 == null) goto L5;
            this.this$0.onHandleWork(r4.a());
            r4.b();
            goto L2
        L5:
            return null;
        }

        /* JADX INFO: renamed from: onCancelled, reason: avoid collision after fix types in other method */
        public void onCancelled2(Void r1) {
            this.this$0.processorFinished();
        }

        /* JADX INFO: renamed from: onPostExecute, reason: avoid collision after fix types in other method */
        public void onPostExecute2(Void r1) {
            this.this$0.processorFinished();
        }
    }

    static final class JobServiceEngineImpl extends JobServiceEngine implements a {
        static final boolean DEBUG = false;
        static final String TAG = "JobServiceEngineImpl";
        final Object mLock;
        JobParameters mParams;
        final JobIntentService mService;

        final class a implements d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final JobWorkItem f1042a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ JobServiceEngineImpl f1043b;

            a(JobServiceEngineImpl r1, JobWorkItem r2) {
                this.f1043b = r1;
                this.f1042a = r2;
            }

            @Override // androidx.core.app.JobIntentService.d
            public Intent a() {
                return this.f1042a.getIntent();
            }

            @Override // androidx.core.app.JobIntentService.d
            public void b() {
                Object r0 = this.f1043b.mLock;
                monitor-enter(r0);
            L9:
                th = move-exception;
                throw th;
            L5:
                if (this.f1043b.mParams == null) goto L7;
                this.f1043b.mParams.completeWork(this.f1042a);     // Catch: Throwable -> L9
            L7:
                monitor-exit(r0);     // Catch: Throwable -> L9
            }
        }

        /* JADX WARN: Type inference failed for: r3v2, types: [android.app.Service, androidx.core.app.JobIntentService] */
        JobServiceEngineImpl(JobIntentService r3) {
            ?? r4 = (JobIntentService) ZeusTransformUtils.wrapperContextForParams(r3, JobIntentService.class, "com.obric.aiagent.plugin");
            super(r4);
            this.mLock = new Object();
            this.mService = r4;
        }

        @Override // androidx.core.app.JobIntentService.a
        public IBinder compatGetBinder() {
            return getBinder();
        }

        @Override // android.app.job.JobServiceEngine
        public boolean onStartJob(JobParameters r1) {
            this.mParams = r1;
            this.mService.ensureProcessorRunningLocked(false);
            return true;
        }

        @Override // android.app.job.JobServiceEngine
        public boolean onStopJob(JobParameters r3) {
            boolean r4 = this.mService.doStopCurrentWork();
            Object r0 = this.mLock;
            monitor-enter(r0);
            this.mParams = null;     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            return r4;
        L8:
            th = move-exception;
            throw th;
        }

        @Override // androidx.core.app.JobIntentService.a
        public d dequeueWork() {
            Object r0 = this.mLock;
            monitor-enter(r0);
            JobParameters r1 = this.mParams;     // Catch: Throwable -> L14
            if (r1 != null) goto L8;
            monitor-exit(r0);     // Catch: Throwable -> L14
            return null;
        L8:
            JobWorkItem r2 = r1.dequeueWork();     // Catch: Throwable -> L14
            monitor-exit(r0);     // Catch: Throwable -> L14
            if (r2 == null) goto L13;
            r2.getIntent().setExtrasClassLoader(this.mService.getClassLoader());
            return new a(this, r2);
        L13:
            return null;
        L14:
            th = move-exception;
            throw th;
        }
    }

    interface a {
        IBinder compatGetBinder();

        d dequeueWork();
    }

    static final class b extends f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        boolean f1044a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        boolean f1045b;
        private final Context f;
        private final PowerManager.WakeLock g;
        private final PowerManager.WakeLock h;

        b(Context r4, ComponentName r5) {
            Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
            super(r5);
            this.f = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r6.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
            PowerManager r7 = (PowerManager) ZeusTransformUtils.preCheckCast(r6.getSystemService("power"), PowerManager.class, "com.obric.aiagent.plugin");
            PowerManager.WakeLock r0 = r7.newWakeLock(1, r5.getClassName() + ":launch");
            this.g = r0;
            r0.setReferenceCounted(false);
            PowerManager.WakeLock r8 = r7.newWakeLock(1, r5.getClassName() + ":run");
            this.h = r8;
            r8.setReferenceCounted(false);
        }

        @Override // androidx.core.app.JobIntentService.f
        void a(Intent r3) {
            Intent r0 = new Intent(r3);
            r0.setComponent(this.f1051c);
            if (ZeusTransformUtils.startService(this.f, r0, "com.obric.aiagent.plugin") == null) goto L15;
            monitor-enter(this);
        L12:
            th = move-exception;
            throw th;
        L6:
            if (this.f1044a == true) goto L10;
            this.f1044a = true;     // Catch: Throwable -> L12
            if (this.f1045b == true) goto L10;
            a(this.g, 60000);     // Catch: Throwable -> L12
        L10:
            monitor-exit(this);     // Catch: Throwable -> L12
            return;
        }

        @Override // androidx.core.app.JobIntentService.f
        public void a() {
            monitor-enter(this);
            this.f1044a = false;     // Catch: Throwable -> L7
            monitor-exit(this);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // androidx.core.app.JobIntentService.f
        public void b() {
            monitor-enter(this);
        L8:
            th = move-exception;
            throw th;
        L4:
            if (this.f1045b == true) goto L6;
            this.f1045b = true;     // Catch: Throwable -> L8
            a(this.h, 600000);     // Catch: Throwable -> L8
            a(this.g);     // Catch: Throwable -> L8
        L6:
            monitor-exit(this);     // Catch: Throwable -> L8
        }

        @Override // androidx.core.app.JobIntentService.f
        public void c() {
            monitor-enter(this);
        L11:
            th = move-exception;
            throw th;
        L4:
            if (this.f1045b == true) goto L6;
        L9:
            monitor-exit(this);     // Catch: Throwable -> L11
            return;
        L6:
            if (this.f1044a == false) goto L8;
            a(this.g, 60000);     // Catch: Throwable -> L11
        L8:
            this.f1045b = false;     // Catch: Throwable -> L11
            a(this.h);     // Catch: Throwable -> L11
            goto L9
        }

        public static void a(PowerManager.WakeLock r1, long r2) {
            if (com.obric.performance.power.monitor.a.f36932a.a() == true) goto L6;
            r1.acquire(r2);
            return;
        L6:
            r1.acquire(r2);
            com.obric.performance.power.monitor.cpu.c.a(r1);
        }

        public static void a(PowerManager.WakeLock r1) {
            if (com.obric.performance.power.monitor.a.f36932a.a() == true) goto L6;
            r1.release();
            return;
        L6:
            r1.release();
            com.obric.performance.power.monitor.cpu.c.b(r1);
        }
    }

    final class c implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Intent f1046a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final int f1047b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ JobIntentService f1048c;

        c(JobIntentService r3, Intent r4, int r5) {
            this.f1048c = (JobIntentService) ZeusTransformUtils.wrapperContextForParams(r3, JobIntentService.class, "com.obric.aiagent.plugin");
            this.f1046a = r4;
            this.f1047b = r5;
        }

        @Override // androidx.core.app.JobIntentService.d
        public Intent a() {
            return this.f1046a;
        }

        @Override // androidx.core.app.JobIntentService.d
        public void b() {
            this.f1048c.stopSelf(this.f1047b);
        }
    }

    interface d {
        Intent a();

        void b();
    }

    static final class e extends f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final JobInfo f1049a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final JobScheduler f1050b;

        e(Context r5, ComponentName r6, int r7) {
            Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
            super(r6);
            a(r7);
            this.f1049a = new JobInfo.Builder(r7, this.f1051c).setOverrideDeadline(0).build();
            this.f1050b = (JobScheduler) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r8.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getSystemService("jobscheduler"), JobScheduler.class, "com.obric.aiagent.plugin");
        }

        @Override // androidx.core.app.JobIntentService.f
        void a(Intent r3) {
            this.f1050b.enqueue(this.f1049a, new JobWorkItem(r3));
        }
    }

    static abstract class f {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final ComponentName f1051c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f1052d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f1053e;

        public void a() {
        }

        abstract void a(Intent r1);

        public void b() {
        }

        public void c() {
        }

        f(ComponentName r1) {
            this.f1051c = r1;
        }

        void a(int r4) {
            if (this.f1052d == true) goto L6;
            this.f1052d = true;
            this.f1053e = r4;
            return;
        L6:
            if (this.f1053e != r4) goto L9;
            return;
        L9:
            throw new IllegalArgumentException("Given job ID " + r4 + " is different than previous " + this.f1053e);
        }
    }

    public abstract void onHandleWork(Intent r1);

    public boolean onStopCurrentWork() {
        return true;
    }

    static {
        sLock = new Object();
        sClassWorkEnqueuer = new HashMap();
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

    /* JADX WARN: Multi-variable type inference failed */
    public void onCreate() {
        super/*android.app.Service*/.onCreate();
        if (Build.VERSION.SDK_INT < 26) goto L5;
        this.mJobImpl = new JobServiceEngineImpl(this);
        this.mCompatWorkEnqueuer = null;
        return;
    L5:
        this.mJobImpl = null;
        this.mCompatWorkEnqueuer = getWorkEnqueuer(this, new ComponentName(this, getClass()), false, 0);
    }

    public int onStartCommand(Intent r3, int r4, int r5) {
        if (this.mCompatQueue == null) goto L17;
        this.mCompatWorkEnqueuer.a();
        ArrayList<c> r6 = this.mCompatQueue;
        monitor-enter(r6);
        ArrayList<c> r0 = this.mCompatQueue;     // Catch: Throwable -> L14
        if (r3 != null) goto L10;
        r3 = new Intent();     // Catch: Throwable -> L14
    L10:
        r0.add(new c(this, r3, r5));     // Catch: Throwable -> L14
        ensureProcessorRunningLocked(true);     // Catch: Throwable -> L14
        monitor-exit(r6);     // Catch: Throwable -> L14
        return 3;
    L14:
        th = move-exception;
        throw th;
    L17:
        return 2;
    }

    public IBinder onBind(Intent r1) {
        a r0 = this.mJobImpl;
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.compatGetBinder();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onDestroy() {
        super/*android.app.Service*/.onDestroy();
        ArrayList<c> r0 = this.mCompatQueue;
        if (r0 == null) goto L12;
        monitor-enter(r0);
        this.mDestroyed = true;     // Catch: Throwable -> L9
        this.mCompatWorkEnqueuer.c();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public static void enqueueWork(Context r2, Class<?> r3, int r4, Intent r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        enqueueWork(r6, new ComponentName(r6, r3), r4, r5);
    }

    public static void enqueueWork(Context r2, ComponentName r3, int r4, Intent r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        if (r5 == null) goto L14;
        Object r0 = sLock;
        monitor-enter(r0);
        f r7 = getWorkEnqueuer(r6, r3, true, r4);     // Catch: Throwable -> L10
        r7.a(r4);     // Catch: Throwable -> L10
        r7.a(r5);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    L14:
        throw new IllegalArgumentException("work must not be null");
    }

    static f getWorkEnqueuer(Context r4, ComponentName r5, boolean r6, int r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        HashMap<ComponentName, f> r0 = sClassWorkEnqueuer;
        f r1 = (f) ZeusTransformUtils.preCheckCast(r0.get(r5), f.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L5;
        return r1;
    L5:
        if (Build.VERSION.SDK_INT < 26) goto L10;
        if (r6 == false) goto L9;
        f r9 = new e(r8, r5, r7);
    L11:
        f r2 = r9;
        r0.put(r5, r2);
        return r2;
    L9:
        throw new IllegalArgumentException("Can't be here without a job id");
    L10:
        r9 = new b(r8, r5);
        goto L11
    }

    public void setInterruptIfStopped(boolean r1) {
        this.mInterruptIfStopped = r1;
    }

    public boolean isStopped() {
        return this.mStopped;
    }

    boolean doStopCurrentWork() {
        CommandProcessor r0 = this.mCurProcessor;
        if (r0 == null) goto L5;
        r0.cancel(this.mInterruptIfStopped);
    L5:
        this.mStopped = true;
        return onStopCurrentWork();
    }

    void ensureProcessorRunningLocked(boolean r2) {
        if (this.mCurProcessor != null) goto L10;
        this.mCurProcessor = new CommandProcessor(this);
        f r0 = this.mCompatWorkEnqueuer;
        if (r0 == null) goto L8;
        if (r2 == false) goto L8;
        r0.b();
    L8:
        this.mCurProcessor.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        return;
    }

    void processorFinished() {
        ArrayList<c> r0 = this.mCompatQueue;
        if (r0 == null) goto L19;
        monitor-enter(r0);
        this.mCurProcessor = null;     // Catch: Throwable -> L16
        ArrayList<c> r1 = this.mCompatQueue;     // Catch: Throwable -> L16
        if (r1 == null) goto L12;
        if (r1.size() <= 0) goto L12;
        ensureProcessorRunningLocked(false);     // Catch: Throwable -> L16
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L16
        return;
    L12:
        if (this.mDestroyed == true) goto L14;
        this.mCompatWorkEnqueuer.c();     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        throw th;
    }

    d dequeueWork() {
        a r0 = this.mJobImpl;
        if (r0 != null) goto L5;
        ArrayList<c> r1 = this.mCompatQueue;
        monitor-enter(r1);
    L16:
        th = move-exception;
        throw th;
    L9:
        if (this.mCompatQueue.size() <= 0) goto L14;
        d r3 = (d) ZeusTransformUtils.preCheckCast(this.mCompatQueue.remove(0), d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L16
        monitor-exit(r1);     // Catch: Throwable -> L16
        return r3;
    L14:
        monitor-exit(r1);     // Catch: Throwable -> L16
        return null;
    L5:
        return r0.dequeueWork();
    }
}
