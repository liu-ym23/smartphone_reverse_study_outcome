package androidx.work.impl;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.os.BuildCompat;
import androidx.lifecycle.LiveData;
import androidx.work.Configuration;
import androidx.work.ExistingPeriodicWorkPolicy;
import androidx.work.ExistingWorkPolicy;
import androidx.work.Logger;
import androidx.work.OneTimeWorkRequest;
import androidx.work.Operation;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkContinuation;
import androidx.work.WorkInfo;
import androidx.work.WorkManager;
import androidx.work.WorkQuery;
import androidx.work.WorkRequest;
import androidx.work.WorkerParameters;
import androidx.work.impl.background.greedy.GreedyScheduler;
import androidx.work.impl.background.systemjob.SystemJobScheduler;
import androidx.work.impl.foreground.SystemForegroundDispatcher;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.CancelWorkRunnable;
import androidx.work.impl.utils.ForceStopRunnable;
import androidx.work.impl.utils.LiveDataUtils;
import androidx.work.impl.utils.PreferenceUtils;
import androidx.work.impl.utils.PruneWorkRunnable;
import androidx.work.impl.utils.RawQueries;
import androidx.work.impl.utils.StartWorkRunnable;
import androidx.work.impl.utils.StatusRunnable;
import androidx.work.impl.utils.StopWorkRunnable;
import androidx.work.impl.utils.futures.SettableFuture;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import androidx.work.impl.utils.taskexecutor.WorkManagerTaskExecutor;
import androidx.work.multiprocess.RemoteWorkManager;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.google.common.util.concurrent.ListenableFuture;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.larus.nova.R;
import el9.a;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes3.dex */
public class WorkManagerImpl extends WorkManager {
    public static final int MAX_PRE_JOB_SCHEDULER_API_LEVEL = 22;
    public static final int MIN_JOB_SCHEDULER_API_LEVEL = 23;
    public static final String REMOTE_WORK_MANAGER_CLIENT = "androidx.work.multiprocess.RemoteWorkManagerClient";
    private static final String TAG = null;
    private static WorkManagerImpl sDefaultInstance;
    private static WorkManagerImpl sDelegatedInstance;
    private static final Object sLock = null;
    private Configuration mConfiguration;
    private Context mContext;
    private boolean mForceStopRunnableCompleted;
    private PreferenceUtils mPreferenceUtils;
    private Processor mProcessor;
    private volatile RemoteWorkManager mRemoteWorkManager;
    private BroadcastReceiver.PendingResult mRescheduleReceiverResult;
    private List<Scheduler> mSchedulers;
    private WorkDatabase mWorkDatabase;
    private TaskExecutor mWorkTaskExecutor;

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    private void tryInitializeMultiProcessSupport() {
        this.mRemoteWorkManager = (RemoteWorkManager) INVOKESTATIC_androidx_work_impl_WorkManagerImpl_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(REMOTE_WORK_MANAGER_CLIENT).getConstructor(new Class[]{Context.class, WorkManagerImpl.class}).newInstance(new Object[]{this.mContext, this});     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        Logger.get().debug(TAG, "Unable to initialize multi-process support", new Throwable[]{th});
    }

    static {
        TAG = Logger.tagWithPrefix("WorkManagerImpl");
        sDelegatedInstance = null;
        sDefaultInstance = null;
        sLock = new Object();
    }

    public static WorkManagerImpl getInstance() {
        Object r100 = sLock;
        monitor-enter(r100);
        WorkManagerImpl r101 = sDelegatedInstance;     // Catch: Throwable -> L11
        if (r101 == null) goto L8;
        monitor-exit(r100);     // Catch: Throwable -> L11
        return r101;
    L8:
        WorkManagerImpl r102 = sDefaultInstance;     // Catch: Throwable -> L11
        monitor-exit(r100);     // Catch: Throwable -> L11
        return r102;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // androidx.work.WorkManager
    public LiveData<Long> getLastCancelAllTimeMillisLiveData() {
        return this.mPreferenceUtils.getLastCancelAllTimeMillisLiveData();
    }

    public RemoteWorkManager getRemoteWorkManager() {
        if (this.mRemoteWorkManager != null) goto L21;
        Object r100 = sLock;
        monitor-enter(r100);
    L17:
        th = move-exception;
        throw th;
    L7:
        if (this.mRemoteWorkManager != null) goto L15;
        tryInitializeMultiProcessSupport();     // Catch: Throwable -> L17
        if (this.mRemoteWorkManager != null) goto L15;
        if (TextUtils.isEmpty(this.mConfiguration.getDefaultProcessName()) == true) goto L15;
        throw new IllegalStateException("Invalid multiprocess configuration. Define an `implementation` dependency on :work:work-multiprocess library");     // Catch: Throwable -> L17
    L15:
        monitor-exit(r100);     // Catch: Throwable -> L17
    L21:
        return this.mRemoteWorkManager;
    }

    public void onForceStopRunnableCompleted() {
        Object r100 = sLock;
        monitor-enter(r100);
        this.mForceStopRunnableCompleted = true;     // Catch: Throwable -> L10
        BroadcastReceiver.PendingResult r101 = this.mRescheduleReceiverResult;     // Catch: Throwable -> L10
        if (r101 == null) goto L8;
        r101.finish();     // Catch: Throwable -> L10
        this.mRescheduleReceiverResult = null;     // Catch: Throwable -> L10
    L8:
        monitor-exit(r100);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    @Override // androidx.work.WorkManager
    public Operation pruneWork() {
        PruneWorkRunnable r100 = new PruneWorkRunnable(this);
        this.mWorkTaskExecutor.executeOnBackgroundThread(r100);
        return r100.getOperation();
    }

    public void rescheduleEligibleWork() {
        if (Build.VERSION.SDK_INT < 23) goto L5;
        SystemJobScheduler.cancelAll(getApplicationContext());
    L5:
        getWorkDatabase().workSpecDao().resetScheduledState();
        Schedulers.schedule(getConfiguration(), getWorkDatabase(), getSchedulers());
    }

    @Override // androidx.work.WorkManager
    public Operation cancelAllWork() {
        CancelWorkRunnable r100 = CancelWorkRunnable.forAll(this);
        this.mWorkTaskExecutor.executeOnBackgroundThread(r100);
        return r100.getOperation();
    }

    @Override // androidx.work.WorkManager
    public ListenableFuture<Long> getLastCancelAllTimeMillis() {
        final SettableFuture r100 = SettableFuture.create();
        final PreferenceUtils r101 = this.mPreferenceUtils;
        this.mWorkTaskExecutor.executeOnBackgroundThread(new AnonymousClass1(this, r100, r101));
        return r100;
    }

    public Context getApplicationContext() {
        return this.mContext;
    }

    public Configuration getConfiguration() {
        return this.mConfiguration;
    }

    public PreferenceUtils getPreferenceUtils() {
        return this.mPreferenceUtils;
    }

    public Processor getProcessor() {
        return this.mProcessor;
    }

    public List<Scheduler> getSchedulers() {
        return this.mSchedulers;
    }

    public WorkDatabase getWorkDatabase() {
        return this.mWorkDatabase;
    }

    public TaskExecutor getWorkTaskExecutor() {
        return this.mWorkTaskExecutor;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_androidx_work_impl_WorkManagerImpl_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class r103 = access$000(r100);     // Catch: Throwable -> L8
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r103;
    L8:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class r104 = access$000(r100);     // Catch: Throwable -> L17
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r104;
    L17:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r100);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static WorkManagerImpl getInstance(Context r100) {
        Object r101 = sLock;
        monitor-enter(r101);
        WorkManagerImpl r102 = getInstance();     // Catch: Throwable -> L13
        if (r102 != null) goto L11;
        Context r103 = r100.getApplicationContext();     // Catch: Throwable -> L13
        if ((r103 instanceof Configuration.Provider) == false) goto L10;
        initialize(r103, ((Configuration.Provider) r103).getWorkManagerConfiguration());     // Catch: Throwable -> L13
        r102 = getInstance(r103);     // Catch: Throwable -> L13
        goto L11
    L10:
        throw new IllegalStateException("WorkManager is not initialized properly.  You have explicitly disabled WorkManagerInitializer in your manifest, have not manually called WorkManager#initialize at this point, and your Application does not implement Configuration.Provider.");     // Catch: Throwable -> L13
    L11:
        monitor-exit(r101);     // Catch: Throwable -> L13
        return r102;
    L13:
        th = move-exception;
        throw th;
    }

    public static void setDelegate(WorkManagerImpl r100) {
        Object r101 = sLock;
        monitor-enter(r101);
        sDelegatedInstance = r100;     // Catch: Throwable -> L7
        monitor-exit(r101);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // androidx.work.WorkManager
    public WorkContinuation beginWith(List<OneTimeWorkRequest> r100) {
        if (r100.isEmpty() == true) goto L7;
        return new WorkContinuationImpl(this, r100);
    L7:
        throw new IllegalArgumentException("beginWith needs at least one OneTimeWorkRequest.");
    }

    @Override // androidx.work.WorkManager
    public Operation cancelAllWorkByTag(String r100) {
        CancelWorkRunnable r101 = CancelWorkRunnable.forTag(r100, this);
        this.mWorkTaskExecutor.executeOnBackgroundThread(r101);
        return r101.getOperation();
    }

    @Override // androidx.work.WorkManager
    public Operation cancelUniqueWork(String r100) {
        CancelWorkRunnable r101 = CancelWorkRunnable.forName(r100, this, true);
        this.mWorkTaskExecutor.executeOnBackgroundThread(r101);
        return r101.getOperation();
    }

    @Override // androidx.work.WorkManager
    public Operation cancelWorkById(UUID r100) {
        CancelWorkRunnable r101 = CancelWorkRunnable.forId(r100, this);
        this.mWorkTaskExecutor.executeOnBackgroundThread(r101);
        return r101.getOperation();
    }

    @Override // androidx.work.WorkManager
    public PendingIntent createCancelPendingIntent(UUID r100) {
        Intent r101 = SystemForegroundDispatcher.createCancelWorkIntent(this.mContext, r100.toString());
        if (BuildCompat.isAtLeastS() == false) goto L5;
        int r102 = 167772160;
    L7:
        return PendingIntent.getService(this.mContext, 0, r101, r102);
    L5:
        r102 = AMapEngineUtils.HALF_MAX_P20_WIDTH;
        goto L7
    }

    @Override // androidx.work.WorkManager
    public Operation enqueue(List<? extends WorkRequest> r100) {
        if (r100.isEmpty() == true) goto L7;
        return new WorkContinuationImpl(this, r100).enqueue();
    L7:
        throw new IllegalArgumentException("enqueue needs at least one WorkRequest.");
    }

    @Override // androidx.work.WorkManager
    public ListenableFuture<WorkInfo> getWorkInfoById(UUID r100) {
        StatusRunnable<WorkInfo> r101 = StatusRunnable.forUUID(this, r100);
        this.mWorkTaskExecutor.getBackgroundExecutor().execute(r101);
        return r101.getFuture();
    }

    @Override // androidx.work.WorkManager
    public LiveData<WorkInfo> getWorkInfoByIdLiveData(UUID r100) {
        return LiveDataUtils.dedupedMappedLiveDataFor(this.mWorkDatabase.workSpecDao().getWorkStatusPojoLiveDataForIds(Collections.singletonList(r100.toString())), new AnonymousClass2(this), this.mWorkTaskExecutor);
    }

    @Override // androidx.work.WorkManager
    public ListenableFuture<List<WorkInfo>> getWorkInfos(WorkQuery r100) {
        StatusRunnable<List<WorkInfo>> r101 = StatusRunnable.forWorkQuerySpec(this, r100);
        this.mWorkTaskExecutor.getBackgroundExecutor().execute(r101);
        return r101.getFuture();
    }

    public LiveData<List<WorkInfo>> getWorkInfosById(List<String> r100) {
        return LiveDataUtils.dedupedMappedLiveDataFor(this.mWorkDatabase.workSpecDao().getWorkStatusPojoLiveDataForIds(r100), WorkSpec.WORK_INFO_MAPPER, this.mWorkTaskExecutor);
    }

    @Override // androidx.work.WorkManager
    public ListenableFuture<List<WorkInfo>> getWorkInfosByTag(String r100) {
        StatusRunnable<List<WorkInfo>> r101 = StatusRunnable.forTag(this, r100);
        this.mWorkTaskExecutor.getBackgroundExecutor().execute(r101);
        return r101.getFuture();
    }

    @Override // androidx.work.WorkManager
    public LiveData<List<WorkInfo>> getWorkInfosByTagLiveData(String r100) {
        return LiveDataUtils.dedupedMappedLiveDataFor(this.mWorkDatabase.workSpecDao().getWorkStatusPojoLiveDataForTag(r100), WorkSpec.WORK_INFO_MAPPER, this.mWorkTaskExecutor);
    }

    @Override // androidx.work.WorkManager
    public ListenableFuture<List<WorkInfo>> getWorkInfosForUniqueWork(String r100) {
        StatusRunnable<List<WorkInfo>> r101 = StatusRunnable.forUniqueWork(this, r100);
        this.mWorkTaskExecutor.getBackgroundExecutor().execute(r101);
        return r101.getFuture();
    }

    @Override // androidx.work.WorkManager
    public LiveData<List<WorkInfo>> getWorkInfosForUniqueWorkLiveData(String r100) {
        return LiveDataUtils.dedupedMappedLiveDataFor(this.mWorkDatabase.workSpecDao().getWorkStatusPojoLiveDataForName(r100), WorkSpec.WORK_INFO_MAPPER, this.mWorkTaskExecutor);
    }

    @Override // androidx.work.WorkManager
    public LiveData<List<WorkInfo>> getWorkInfosLiveData(WorkQuery r100) {
        return LiveDataUtils.dedupedMappedLiveDataFor(this.mWorkDatabase.rawWorkInfoDao().getWorkInfoPojosLiveData(RawQueries.workQueryToRawQuery(r100)), WorkSpec.WORK_INFO_MAPPER, this.mWorkTaskExecutor);
    }

    public void setReschedulePendingResult(BroadcastReceiver.PendingResult r100) {
        Object r101 = sLock;
        monitor-enter(r101);
        this.mRescheduleReceiverResult = r100;     // Catch: Throwable -> L9
        if (this.mForceStopRunnableCompleted == false) goto L7;
        r100.finish();     // Catch: Throwable -> L9
        this.mRescheduleReceiverResult = null;     // Catch: Throwable -> L9
    L7:
        monitor-exit(r101);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public void startWork(String r100) {
        startWork(r100, null);
    }

    public void stopForegroundWork(String r100) {
        this.mWorkTaskExecutor.executeOnBackgroundThread(new StopWorkRunnable(this, r100, true));
    }

    public void stopWork(String r100) {
        this.mWorkTaskExecutor.executeOnBackgroundThread(new StopWorkRunnable(this, r100, false));
    }

    public static void initialize(Context r100, Configuration r101) {
        Object r102 = sLock;
        monitor-enter(r102);
        WorkManagerImpl r103 = sDelegatedInstance;     // Catch: Throwable -> L18
        if (r103 != null) goto L7;
    L11:
        if (r103 != null) goto L16;
        Context r104 = r100.getApplicationContext();     // Catch: Throwable -> L18
        if (sDefaultInstance != null) goto L15;
        sDefaultInstance = new WorkManagerImpl(r104, r101, new WorkManagerTaskExecutor(r101.getTaskExecutor()));     // Catch: Throwable -> L18
    L15:
        sDelegatedInstance = sDefaultInstance;     // Catch: Throwable -> L18
    L16:
        monitor-exit(r102);     // Catch: Throwable -> L18
        return;
    L7:
        if (sDefaultInstance == null) goto L11;
        throw new IllegalStateException("WorkManager is already initialized.  Did you try to initialize it manually without disabling WorkManagerInitializer? See WorkManager#initialize(Context, Configuration) or the class level Javadoc for more information.");     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        throw th;
    }

    public void startWork(String r100, WorkerParameters.RuntimeExtras r101) {
        this.mWorkTaskExecutor.executeOnBackgroundThread(new StartWorkRunnable(this, r100, r101));
    }

    public WorkManagerImpl(Context r100, Configuration r101, TaskExecutor r102) {
        this(r100, r101, r102, r100.getResources().getBoolean(R.bool.workmanager_test_configuration));
    }

    @Override // androidx.work.WorkManager
    public WorkContinuation beginUniqueWork(String r100, ExistingWorkPolicy r101, List<OneTimeWorkRequest> r102) {
        if (r102.isEmpty() == true) goto L7;
        return new WorkContinuationImpl(this, r100, r101, r102);
    L7:
        throw new IllegalArgumentException("beginUniqueWork needs at least one OneTimeWorkRequest.");
    }

    public List<Scheduler> createSchedulers(Context r100, Configuration r101, TaskExecutor r102) {
        return Arrays.asList(new Scheduler[]{Schedulers.createBestAvailableBackgroundScheduler(r100, this), new GreedyScheduler(r100, r101, r102, this)});
    }

    public WorkContinuationImpl createWorkContinuationForUniquePeriodicWork(String r100, ExistingPeriodicWorkPolicy r101, PeriodicWorkRequest r102) {
        if (r101 != ExistingPeriodicWorkPolicy.KEEP) goto L5;
        ExistingWorkPolicy r103 = ExistingWorkPolicy.KEEP;
    L7:
        return new WorkContinuationImpl(this, r100, r103, Collections.singletonList(r102));
    L5:
        r103 = ExistingWorkPolicy.REPLACE;
        goto L7
    }

    @Override // androidx.work.WorkManager
    public Operation enqueueUniquePeriodicWork(String r100, ExistingPeriodicWorkPolicy r101, PeriodicWorkRequest r102) {
        return createWorkContinuationForUniquePeriodicWork(r100, r101, r102).enqueue();
    }

    @Override // androidx.work.WorkManager
    public Operation enqueueUniqueWork(String r100, ExistingWorkPolicy r101, List<OneTimeWorkRequest> r102) {
        return new WorkContinuationImpl(this, r100, r101, r102).enqueue();
    }

    public WorkManagerImpl(Context r110, Configuration r111, TaskExecutor r112, WorkDatabase r113) {
        Context r100 = r110.getApplicationContext();
        Logger.setLogger(new Logger.LogcatLogger(r111.getMinimumLoggingLevel()));
        List<Scheduler> r101 = createSchedulers(r100, r111, r112);
        internalInit(r110, r111, r112, r113, r101, new Processor(r110, r111, r112, r113, r101));
    }

    public WorkManagerImpl(Context r100, Configuration r101, TaskExecutor r102, boolean r103) {
        this(r100, r101, r102, WorkDatabase.create(r100.getApplicationContext(), r102.getBackgroundExecutor(), r103));
    }

    public WorkManagerImpl(Context r100, Configuration r101, TaskExecutor r102, WorkDatabase r103, List<Scheduler> r104, Processor r105) {
        internalInit(r100, r101, r102, r103, r104, r105);
    }

    private void internalInit(Context r100, Configuration r101, TaskExecutor r102, WorkDatabase r103, List<Scheduler> r104, Processor r105) {
        Context r106 = r100.getApplicationContext();
        this.mContext = r106;
        this.mConfiguration = r101;
        this.mWorkTaskExecutor = r102;
        this.mWorkDatabase = r103;
        this.mSchedulers = r104;
        this.mProcessor = r105;
        this.mPreferenceUtils = new PreferenceUtils(r103);
        this.mForceStopRunnableCompleted = false;
        if (Build.VERSION.SDK_INT >= 24) goto L5;
    L9:
        this.mWorkTaskExecutor.executeOnBackgroundThread(new ForceStopRunnable(r106, this));
        return;
    L5:
        if (r106.isDeviceProtectedStorage() == false) goto L9;
        throw new IllegalStateException("Cannot initialize WorkManager in direct boot mode");
    }
}
