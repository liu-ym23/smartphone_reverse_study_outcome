package androidx.work.impl.background.systemalarm;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.text.TextUtils;
import androidx.work.Logger;
import androidx.work.impl.ExecutionListener;
import androidx.work.impl.Processor;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.utils.SerialExecutor;
import androidx.work.impl.utils.WakeLocks;
import androidx.work.impl.utils.WorkTimer;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.performance.power.monitor.cpu.d;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import fna.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes17.dex */
public class SystemAlarmDispatcher implements ExecutionListener {
    private static final int DEFAULT_START_ID = 0;
    private static final String KEY_START_ID = "KEY_START_ID";
    private static final String PROCESS_COMMAND_TAG = "ProcessCommand";
    static final String TAG = null;
    final CommandHandler mCommandHandler;
    private CommandsCompletedListener mCompletedListener;
    final Context mContext;
    Intent mCurrentIntent;
    final List<Intent> mIntents;
    private final Handler mMainHandler;
    private final Processor mProcessor;
    private final TaskExecutor mTaskExecutor;
    private final WorkManagerImpl mWorkManager;
    private final WorkTimer mWorkTimer;

    public static class AddRunnable implements Runnable {
        private final SystemAlarmDispatcher mDispatcher;
        private final Intent mIntent;
        private final int mStartId;

        @Override // java.lang.Runnable
        public void run() {
            androidx_work_impl_background_systemalarm_SystemAlarmDispatcher$AddRunnable_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void androidx_work_impl_background_systemalarm_SystemAlarmDispatcher$AddRunnable__run$___twin___() {
            this.mDispatcher.add(this.mIntent, this.mStartId);
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void androidx_work_impl_background_systemalarm_SystemAlarmDispatcher$AddRunnable_com_larus_apm_impl_protector_RunnableLancet_run(AddRunnable r100) {
            r100.androidx_work_impl_background_systemalarm_SystemAlarmDispatcher$AddRunnable__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public AddRunnable(SystemAlarmDispatcher r100, Intent r101, int r102) {
            this.mDispatcher = r100;
            this.mIntent = r101;
            this.mStartId = r102;
        }
    }

    public interface CommandsCompletedListener {
        void onAllCommandsCompleted();
    }

    public static class DequeueAndCheckForCompletion implements Runnable {
        private final SystemAlarmDispatcher mDispatcher;

        @Override // java.lang.Runnable
        public void run() {
            androidx_work_impl_background_systemalarm_SystemAlarmDispatcher$DequeueAndCheckForCompletion_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void androidx_work_impl_background_systemalarm_SystemAlarmDispatcher$DequeueAndCheckForCompletion__run$___twin___() {
            this.mDispatcher.dequeueAndCheckForCompletion();
        }

        public DequeueAndCheckForCompletion(SystemAlarmDispatcher r100) {
            this.mDispatcher = r100;
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void androidx_work_impl_background_systemalarm_SystemAlarmDispatcher$DequeueAndCheckForCompletion_com_larus_apm_impl_protector_RunnableLancet_run(DequeueAndCheckForCompletion r100) {
            r100.androidx_work_impl_background_systemalarm_SystemAlarmDispatcher$DequeueAndCheckForCompletion__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
        TAG = Logger.tagWithPrefix("SystemAlarmDispatcher");
    }

    private void assertMainThread() {
        if (ThreadMethodProxy.getLooperThread(this.mMainHandler.getLooper()) != ThreadMethodProxy.currentThread()) goto L6;
        return;
    L6:
        throw new IllegalStateException("Needs to be invoked on the main thread.");
    }

    private void processCommand() {
        assertMainThread();
        PowerManager.WakeLock r100 = WakeLocks.newWakeLock(this.mContext, PROCESS_COMMAND_TAG);
        INVOKEVIRTUAL_androidx_work_impl_background_systemalarm_SystemAlarmDispatcher_com_obric_performance_power_monitor_cpu_WakeLockLancet_acquire(r100);     // Catch: Throwable -> L6
        this.mWorkManager.getWorkTaskExecutor().executeOnBackgroundThread(new AnonymousClass1(this));     // Catch: Throwable -> L6
        INVOKEVIRTUAL_androidx_work_impl_background_systemalarm_SystemAlarmDispatcher_com_obric_performance_power_monitor_cpu_WakeLockLancet_release(r100);
        return;
    L6:
        th = move-exception;
        INVOKEVIRTUAL_androidx_work_impl_background_systemalarm_SystemAlarmDispatcher_com_obric_performance_power_monitor_cpu_WakeLockLancet_release(r100);
        throw th;
    }

    public void dequeueAndCheckForCompletion() {
        Logger r100 = Logger.get();
        String r101 = TAG;
        r100.debug(r101, "Checking if commands are complete.", new Throwable[0]);
        assertMainThread();
        List<Intent> r102 = this.mIntents;
        monitor-enter(r102);
    L25:
        th = move-exception;
        throw th;
    L5:
        if (this.mCurrentIntent == null) goto L11;
        Logger.get().debug(r101, String.format("Removing command %s", new Object[]{this.mCurrentIntent}), new Throwable[0]);     // Catch: Throwable -> L25
        if (this.mIntents.remove(0).equals(this.mCurrentIntent) == false) goto L10;
        this.mCurrentIntent = null;     // Catch: Throwable -> L25
        goto L11
    L10:
        throw new IllegalStateException("Dequeue-d command is not the first.");     // Catch: Throwable -> L25
    L11:
        SerialExecutor r103 = this.mTaskExecutor.getBackgroundExecutor();     // Catch: Throwable -> L25
        if (this.mCommandHandler.hasPendingCommands() == true) goto L21;
        if (this.mIntents.isEmpty() == false) goto L21;
        if (r103.hasPendingTasks() == true) goto L21;
        Logger.get().debug(r101, "No more commands & intents.", new Throwable[0]);     // Catch: Throwable -> L25
        CommandsCompletedListener r104 = this.mCompletedListener;     // Catch: Throwable -> L25
        if (r104 == null) goto L23;
        r104.onAllCommandsCompleted();     // Catch: Throwable -> L25
    L23:
        monitor-exit(r102);     // Catch: Throwable -> L25
        return;
    L21:
        if (this.mIntents.isEmpty() == true) goto L23;
        processCommand();     // Catch: Throwable -> L25
        goto L23
    }

    public void onDestroy() {
        Logger.get().debug(TAG, "Destroying SystemAlarmDispatcher", new Throwable[0]);
        this.mProcessor.removeExecutionListener(this);
        this.mWorkTimer.onDestroy();
        this.mCompletedListener = null;
    }

    public Processor getProcessor() {
        return this.mProcessor;
    }

    public TaskExecutor getTaskExecutor() {
        return this.mTaskExecutor;
    }

    public WorkManagerImpl getWorkManager() {
        return this.mWorkManager;
    }

    public WorkTimer getWorkTimer() {
        return this.mWorkTimer;
    }

    public SystemAlarmDispatcher(Context r100) {
        this(r100, null, null);
    }

    public static void INVOKEVIRTUAL_androidx_work_impl_background_systemalarm_SystemAlarmDispatcher_com_obric_performance_power_monitor_cpu_WakeLockLancet_acquire(PowerManager.WakeLock r100) {
        if (g.d() == true) goto L6;
        r100.acquire();
        return;
    L6:
        r100.acquire();
        d.a(r100);
    }

    public static void INVOKEVIRTUAL_androidx_work_impl_background_systemalarm_SystemAlarmDispatcher_com_obric_performance_power_monitor_cpu_WakeLockLancet_release(PowerManager.WakeLock r100) {
        if (g.d() == true) goto L6;
        r100.release();
        return;
    L6:
        r100.release();
        d.b(r100);
    }

    private boolean hasIntentWithAction(String r100) {
        assertMainThread();
        List<Intent> r101 = this.mIntents;
        monitor-enter(r101);
        Iterator<Intent> r102 = this.mIntents.iterator();     // Catch: Throwable -> L15
    L6:
        if (r102.hasNext() == false) goto L12;
        if (r100.equals(r102.next().getAction()) == false) goto L6;
        monitor-exit(r101);     // Catch: Throwable -> L15
        return true;
    L12:
        monitor-exit(r101);     // Catch: Throwable -> L15
        return false;
    L15:
        th = move-exception;
        throw th;
    }

    public void postOnMainThread(Runnable r100) {
        this.mMainHandler.post(r100);
    }

    public void setCompletedListener(CommandsCompletedListener r100) {
        if (this.mCompletedListener == null) goto L6;
        Logger.get().error(TAG, "A completion listener for SystemAlarmDispatcher already exists.", new Throwable[0]);
        return;
    L6:
        this.mCompletedListener = r100;
    }

    public boolean add(Intent r100, int r101) {
        Logger r102 = Logger.get();
        String r103 = TAG;
        boolean r104 = false;
        r102.debug(r103, String.format("Adding command %s (%s)", new Object[]{r100, Integer.valueOf(r101)}), new Throwable[0]);
        assertMainThread();
        String r105 = r100.getAction();
        if (TextUtils.isEmpty(r105) == false) goto L7;
        Logger.get().warning(r103, "Unknown command. Ignoring", new Throwable[0]);
        return false;
    L7:
        if ("ACTION_CONSTRAINTS_CHANGED".equals(r105) == true) goto L9;
    L11:
        r100.putExtra(KEY_START_ID, r101);
        List<Intent> r106 = this.mIntents;
        monitor-enter(r106);
    L21:
        th = move-exception;
        throw th;
    L14:
        if (this.mIntents.isEmpty() == true) goto L16;
        r104 = true;
    L16:
        this.mIntents.add(r100);     // Catch: Throwable -> L21
        if (r104 == true) goto L19;
        processCommand();     // Catch: Throwable -> L21
    L19:
        monitor-exit(r106);     // Catch: Throwable -> L21
        return true;
    L9:
        if (hasIntentWithAction("ACTION_CONSTRAINTS_CHANGED") == false) goto L11;
        return false;
    }

    @Override // androidx.work.impl.ExecutionListener
    public void onExecuted(String r100, boolean r101) {
        postOnMainThread(new AddRunnable(this, CommandHandler.createExecutionCompletedIntent(this.mContext, r100, r101), 0));
    }

    public SystemAlarmDispatcher(Context r100, Processor r101, WorkManagerImpl r102) {
        Context r103 = r100.getApplicationContext();
        this.mContext = r103;
        this.mCommandHandler = new CommandHandler(r103);
        this.mWorkTimer = new WorkTimer();
        if (r102 != null) goto L6;
        r102 = WorkManagerImpl.getInstance(r100);
    L6:
        this.mWorkManager = r102;
        if (r101 != null) goto L10;
        r101 = r102.getProcessor();
    L10:
        this.mProcessor = r101;
        this.mTaskExecutor = r102.getWorkTaskExecutor();
        r101.addExecutionListener(this);
        this.mIntents = new ArrayList();
        this.mCurrentIntent = null;
        this.mMainHandler = new Handler(Looper.getMainLooper());
    }
}
