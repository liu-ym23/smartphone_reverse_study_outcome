package androidx.work.impl;

import android.content.Context;
import android.os.PowerManager;
import androidx.core.content.ContextCompat;
import androidx.work.Configuration;
import androidx.work.ForegroundInfo;
import androidx.work.Logger;
import androidx.work.WorkerParameters;
import androidx.work.impl.foreground.ForegroundProcessor;
import androidx.work.impl.foreground.SystemForegroundDispatcher;
import androidx.work.impl.utils.WakeLocks;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import com.google.common.util.concurrent.ListenableFuture;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.performance.power.monitor.cpu.d;
import fna.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes3.dex */
public class Processor implements ExecutionListener, ForegroundProcessor {
    private static final String FOREGROUND_WAKELOCK_TAG = "ProcessorForegroundLck";
    private static final String TAG = null;
    private Context mAppContext;
    private Set<String> mCancelledIds;
    private Configuration mConfiguration;
    private Map<String, WorkerWrapper> mEnqueuedWorkMap;
    private PowerManager.WakeLock mForegroundLock;
    private Map<String, WorkerWrapper> mForegroundWorkMap;
    private final Object mLock;
    private final List<ExecutionListener> mOuterListeners;
    private List<Scheduler> mSchedulers;
    private WorkDatabase mWorkDatabase;
    private TaskExecutor mWorkTaskExecutor;

    /* JADX INFO: loaded from: classes17.dex */
    public static class FutureListener implements Runnable {
        private ExecutionListener mExecutionListener;
        private ListenableFuture<Boolean> mFuture;
        private String mWorkSpecId;

        @Override // java.lang.Runnable
        public void run() {
            androidx_work_impl_Processor$FutureListener_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void androidx_work_impl_Processor$FutureListener__run$___twin___() {
            boolean r100 = this.mFuture.get().booleanValue();     // Catch: Throwable -> L4
        L5:
            this.mExecutionListener.onExecuted(this.mWorkSpecId, r100);
            return;
        L4:
            r100 = true;
            goto L5
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void androidx_work_impl_Processor$FutureListener_com_larus_apm_impl_protector_RunnableLancet_run(FutureListener r100) {
            r100.androidx_work_impl_Processor$FutureListener__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public FutureListener(ExecutionListener r100, String r101, ListenableFuture<Boolean> r102) {
            this.mExecutionListener = r100;
            this.mWorkSpecId = r101;
            this.mFuture = r102;
        }
    }

    static {
        TAG = Logger.tagWithPrefix("Processor");
    }

    private void stopForegroundService() {
        Object r100 = this.mLock;
        monitor-enter(r100);
    L16:
        th = move-exception;
        throw th;
    L5:
        if ((!this.mForegroundWorkMap.isEmpty()) == false) goto L21;
    L14:
        monitor-exit(r100);     // Catch: Throwable -> L16
        return;
    L21:
        this.mAppContext.startService(SystemForegroundDispatcher.createStopForegroundIntent(this.mAppContext));     // Catch: Throwable -> L9
    L11:
        PowerManager.WakeLock r101 = this.mForegroundLock;     // Catch: Throwable -> L16
        if (r101 == null) goto L14;
        INVOKEVIRTUAL_androidx_work_impl_Processor_com_obric_performance_power_monitor_cpu_WakeLockLancet_release(r101);     // Catch: Throwable -> L16
        this.mForegroundLock = null;     // Catch: Throwable -> L16
        goto L14
    L9:
        th = move-exception;
        Logger.get().error(TAG, "Unable to stop foreground service", new Throwable[]{th});     // Catch: Throwable -> L16
        goto L11
    }

    public boolean hasWork() {
        Object r100 = this.mLock;
        monitor-enter(r100);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (this.mEnqueuedWorkMap.isEmpty() == true) goto L7;
    L10:
        boolean r101 = true;
    L11:
        monitor-exit(r100);     // Catch: Throwable -> L13
        return r101;
    L7:
        if (this.mForegroundWorkMap.isEmpty() == false) goto L10;
        r101 = false;
        goto L11
    }

    public static void INVOKEVIRTUAL_androidx_work_impl_Processor_com_obric_performance_power_monitor_cpu_WakeLockLancet_acquire(PowerManager.WakeLock r100) {
        if (g.d() == true) goto L6;
        r100.acquire();
        return;
    L6:
        r100.acquire();
        d.a(r100);
    }

    public static void INVOKEVIRTUAL_androidx_work_impl_Processor_com_obric_performance_power_monitor_cpu_WakeLockLancet_release(PowerManager.WakeLock r100) {
        if (g.d() == true) goto L6;
        r100.release();
        return;
    L6:
        r100.release();
        d.b(r100);
    }

    public void addExecutionListener(ExecutionListener r100) {
        Object r101 = this.mLock;
        monitor-enter(r101);
        this.mOuterListeners.add(r100);     // Catch: Throwable -> L7
        monitor-exit(r101);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean isCancelled(String r100) {
        Object r101 = this.mLock;
        monitor-enter(r101);
        boolean r102 = this.mCancelledIds.contains(r100);     // Catch: Throwable -> L7
        monitor-exit(r101);     // Catch: Throwable -> L7
        return r102;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean isEnqueued(String r100) {
        Object r101 = this.mLock;
        monitor-enter(r101);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (this.mEnqueuedWorkMap.containsKey(r100) == false) goto L7;
    L10:
        boolean r102 = true;
    L11:
        monitor-exit(r101);     // Catch: Throwable -> L13
        return r102;
    L7:
        if (this.mForegroundWorkMap.containsKey(r100) == true) goto L10;
        r102 = false;
        goto L11
    }

    public boolean isEnqueuedInForeground(String r100) {
        Object r101 = this.mLock;
        monitor-enter(r101);
        boolean r102 = this.mForegroundWorkMap.containsKey(r100);     // Catch: Throwable -> L7
        monitor-exit(r101);     // Catch: Throwable -> L7
        return r102;
    L7:
        th = move-exception;
        throw th;
    }

    public void removeExecutionListener(ExecutionListener r100) {
        Object r101 = this.mLock;
        monitor-enter(r101);
        this.mOuterListeners.remove(r100);     // Catch: Throwable -> L7
        monitor-exit(r101);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean startWork(String r100) {
        return startWork(r100, null);
    }

    public boolean stopAndCancelWork(String r100) {
        Object r101 = this.mLock;
        monitor-enter(r101);
        boolean r102 = true;
        Logger.get().debug(TAG, String.format("Processor cancelling %s", new Object[]{r100}), new Throwable[0]);     // Catch: Throwable -> L15
        this.mCancelledIds.add(r100);     // Catch: Throwable -> L15
        WorkerWrapper r103 = this.mForegroundWorkMap.remove(r100);     // Catch: Throwable -> L15
        if (r103 != null) goto L8;
        r102 = false;
    L8:
        if (r103 != null) goto L10;
        r103 = this.mEnqueuedWorkMap.remove(r100);     // Catch: Throwable -> L15
    L10:
        boolean r104 = interrupt(r100, r103);     // Catch: Throwable -> L15
        if (r102 == false) goto L13;
        stopForegroundService();     // Catch: Throwable -> L15
    L13:
        monitor-exit(r101);     // Catch: Throwable -> L15
        return r104;
    L15:
        th = move-exception;
        throw th;
    }

    @Override // androidx.work.impl.foreground.ForegroundProcessor
    public void stopForeground(String r100) {
        Object r101 = this.mLock;
        monitor-enter(r101);
        this.mForegroundWorkMap.remove(r100);     // Catch: Throwable -> L7
        stopForegroundService();     // Catch: Throwable -> L7
        monitor-exit(r101);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean stopForegroundWork(String r100) {
        Object r101 = this.mLock;
        monitor-enter(r101);
        Logger.get().debug(TAG, String.format("Processor stopping foreground work %s", new Object[]{r100}), new Throwable[0]);     // Catch: Throwable -> L7
        boolean r102 = interrupt(r100, this.mForegroundWorkMap.remove(r100));     // Catch: Throwable -> L7
        monitor-exit(r101);     // Catch: Throwable -> L7
        return r102;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean stopWork(String r100) {
        Object r101 = this.mLock;
        monitor-enter(r101);
        Logger.get().debug(TAG, String.format("Processor stopping background work %s", new Object[]{r100}), new Throwable[0]);     // Catch: Throwable -> L7
        boolean r102 = interrupt(r100, this.mEnqueuedWorkMap.remove(r100));     // Catch: Throwable -> L7
        monitor-exit(r101);     // Catch: Throwable -> L7
        return r102;
    L7:
        th = move-exception;
        throw th;
    }

    private static boolean interrupt(String r100, WorkerWrapper r101) {
        if (r101 == null) goto L6;
        r101.interrupt();
        Logger.get().debug(TAG, String.format("WorkerWrapper interrupted for %s", new Object[]{r100}), new Throwable[0]);
        return true;
    L6:
        Logger.get().debug(TAG, String.format("WorkerWrapper could not be found for %s", new Object[]{r100}), new Throwable[0]);
        return false;
    }

    @Override // androidx.work.impl.ExecutionListener
    public void onExecuted(String r100, boolean r110) {
        Object r101 = this.mLock;
        monitor-enter(r101);
        this.mEnqueuedWorkMap.remove(r100);     // Catch: Throwable -> L10
        Logger.get().debug(TAG, String.format("%s %s executed; reschedule = %s", new Object[]{getClass().getSimpleName(), r100, Boolean.valueOf(r110)}), new Throwable[0]);     // Catch: Throwable -> L10
        Iterator<ExecutionListener> r102 = this.mOuterListeners.iterator();     // Catch: Throwable -> L10
    L6:
        if (r102.hasNext() == false) goto L8;
        r102.next().onExecuted(r100, r110);     // Catch: Throwable -> L10
        goto L6
    L8:
        monitor-exit(r101);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    @Override // androidx.work.impl.foreground.ForegroundProcessor
    public void startForeground(String r100, ForegroundInfo r101) {
        Object r102 = this.mLock;
        monitor-enter(r102);
        Logger.get().info(TAG, String.format("Moving WorkSpec (%s) to the foreground", new Object[]{r100}), new Throwable[0]);     // Catch: Throwable -> L12
        WorkerWrapper r103 = this.mEnqueuedWorkMap.remove(r100);     // Catch: Throwable -> L12
        if (r103 != null) goto L7;
    L10:
        monitor-exit(r102);     // Catch: Throwable -> L12
        return;
    L7:
        if (this.mForegroundLock != null) goto L9;
        PowerManager.WakeLock r104 = WakeLocks.newWakeLock(this.mAppContext, FOREGROUND_WAKELOCK_TAG);     // Catch: Throwable -> L12
        this.mForegroundLock = r104;     // Catch: Throwable -> L12
        INVOKEVIRTUAL_androidx_work_impl_Processor_com_obric_performance_power_monitor_cpu_WakeLockLancet_acquire(r104);     // Catch: Throwable -> L12
    L9:
        this.mForegroundWorkMap.put(r100, r103);     // Catch: Throwable -> L12
        ContextCompat.startForegroundService(this.mAppContext, SystemForegroundDispatcher.createStartForegroundIntent(this.mAppContext, r100, r101));     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    }

    public boolean startWork(String r110, WorkerParameters.RuntimeExtras r111) {
        Object r100 = this.mLock;
        monitor-enter(r100);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (isEnqueued(r110) == false) goto L9;
        Logger.get().debug(TAG, String.format("Work %s is already enqueued for processing", new Object[]{r110}), new Throwable[0]);     // Catch: Throwable -> L13
        monitor-exit(r100);     // Catch: Throwable -> L13
        return false;
    L9:
        WorkerWrapper r112 = new WorkerWrapper.Builder(this.mAppContext, this.mConfiguration, this.mWorkTaskExecutor, this, this.mWorkDatabase, r110).withSchedulers(this.mSchedulers).withRuntimeExtras(r111).build();     // Catch: Throwable -> L13
        ListenableFuture<Boolean> r101 = r112.getFuture();     // Catch: Throwable -> L13
        r101.addListener(new FutureListener(this, r110, r101), this.mWorkTaskExecutor.getMainThreadExecutor());     // Catch: Throwable -> L13
        this.mEnqueuedWorkMap.put(r110, r112);     // Catch: Throwable -> L13
        monitor-exit(r100);     // Catch: Throwable -> L13
        this.mWorkTaskExecutor.getBackgroundExecutor().execute(r112);
        Logger.get().debug(TAG, String.format("%s: processing %s", new Object[]{getClass().getSimpleName(), r110}), new Throwable[0]);
        return true;
    }

    public Processor(Context r100, Configuration r101, TaskExecutor r102, WorkDatabase r103, List<Scheduler> r104) {
        this.mAppContext = r100;
        this.mConfiguration = r101;
        this.mWorkTaskExecutor = r102;
        this.mWorkDatabase = r103;
        this.mEnqueuedWorkMap = new HashMap();
        this.mForegroundWorkMap = new HashMap();
        this.mSchedulers = r104;
        this.mCancelledIds = new HashSet();
        this.mOuterListeners = new ArrayList();
        this.mForegroundLock = null;
        this.mLock = new Object();
    }
}
