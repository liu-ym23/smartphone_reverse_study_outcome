package androidx.work.impl.background.greedy;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.work.Configuration;
import androidx.work.Logger;
import androidx.work.WorkInfo;
import androidx.work.impl.ExecutionListener;
import androidx.work.impl.Scheduler;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.constraints.WorkConstraintsCallback;
import androidx.work.impl.constraints.WorkConstraintsTracker;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.ProcessUtils;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public class GreedyScheduler implements Scheduler, WorkConstraintsCallback, ExecutionListener {
    private static final String TAG = null;
    private final Set<WorkSpec> mConstrainedWorkSpecs;
    private final Context mContext;
    private DelayedWorkTracker mDelayedWorkTracker;
    Boolean mInDefaultProcess;
    private final Object mLock;
    private boolean mRegisteredExecutionListener;
    private final WorkConstraintsTracker mWorkConstraintsTracker;
    private final WorkManagerImpl mWorkManagerImpl;

    @Override // androidx.work.impl.Scheduler
    public boolean hasLimitedSchedulingSlots() {
        return false;
    }

    static {
        TAG = Logger.tagWithPrefix("GreedyScheduler");
    }

    private void checkDefaultProcess() {
        Configuration r100 = this.mWorkManagerImpl.getConfiguration();
        this.mInDefaultProcess = Boolean.valueOf(ProcessUtils.isDefaultProcess(this.mContext, r100));
    }

    private void registerExecutionListenerIfNeeded() {
        if (this.mRegisteredExecutionListener == true) goto L6;
        this.mWorkManagerImpl.getProcessor().addExecutionListener(this);
        this.mRegisteredExecutionListener = true;
        return;
    }

    private void removeConstraintTrackingFor(String r100) {
        Object r101 = this.mLock;
        monitor-enter(r101);
        Iterator<WorkSpec> r102 = this.mConstrainedWorkSpecs.iterator();     // Catch: Throwable -> L12
    L6:
        if (r102.hasNext() == false) goto L10;
        WorkSpec r103 = r102.next();     // Catch: Throwable -> L12
        if (r103.f15686id.equals(r100) == false) goto L6;
        Logger.get().debug(TAG, String.format("Stopping tracking for %s", new Object[]{r100}), new Throwable[0]);     // Catch: Throwable -> L12
        this.mConstrainedWorkSpecs.remove(r103);     // Catch: Throwable -> L12
        this.mWorkConstraintsTracker.replace(this.mConstrainedWorkSpecs);     // Catch: Throwable -> L12
    L10:
        monitor-exit(r101);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    @Override // androidx.work.impl.Scheduler
    public void cancel(String r100) {
        if (this.mInDefaultProcess != null) goto L6;
        checkDefaultProcess();
    L6:
        if (this.mInDefaultProcess.booleanValue() == true) goto L9;
        Logger.get().info(TAG, "Ignoring schedule request in non-main process", new Throwable[0]);
        return;
    L9:
        registerExecutionListenerIfNeeded();
        Logger.get().debug(TAG, String.format("Cancelling work ID %s", new Object[]{r100}), new Throwable[0]);
        DelayedWorkTracker r101 = this.mDelayedWorkTracker;
        if (r101 == null) goto L12;
        r101.unschedule(r100);
    L12:
        this.mWorkManagerImpl.stopWork(r100);
    }

    @Override // androidx.work.impl.constraints.WorkConstraintsCallback
    public void onAllConstraintsMet(List<String> r100) {
        Iterator<String> r101 = r100.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        String r102 = r101.next();
        Logger.get().debug(TAG, String.format("Constraints met: Scheduling work ID %s", new Object[]{r102}), new Throwable[0]);
        this.mWorkManagerImpl.startWork(r102);
        goto L4
    }

    @Override // androidx.work.impl.constraints.WorkConstraintsCallback
    public void onAllConstraintsNotMet(List<String> r100) {
        Iterator<String> r101 = r100.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        String r102 = r101.next();
        Logger.get().debug(TAG, String.format("Constraints not met: Cancelling work ID %s", new Object[]{r102}), new Throwable[0]);
        this.mWorkManagerImpl.stopWork(r102);
        goto L4
    }

    @Override // androidx.work.impl.Scheduler
    public void schedule(WorkSpec... r110) {
        if (this.mInDefaultProcess != null) goto L6;
        checkDefaultProcess();
    L6:
        if (this.mInDefaultProcess.booleanValue() == true) goto L9;
        Logger.get().info(TAG, "Ignoring schedule request in a secondary process", new Throwable[0]);
        return;
    L9:
        registerExecutionListenerIfNeeded();
        HashSet r100 = new HashSet();
        HashSet r101 = new HashSet();
        int r102 = r110.length;
        int r103 = 0;
    L11:
        if (r103 >= r102) goto L34;
        WorkSpec r104 = r110[r103];
        long r105 = r104.calculateNextRunTime();
        long r106 = System.currentTimeMillis();
        if (r104.state != WorkInfo.State.ENQUEUED) goto L33;
        if (r106 >= r105) goto L20;
        DelayedWorkTracker r107 = this.mDelayedWorkTracker;
        if (r107 == null) goto L33;
        r107.schedule(r104);
        goto L33
    L20:
        if (r104.hasConstraints() == false) goto L32;
        int r108 = Build.VERSION.SDK_INT;
        if (r108 < 23) goto L27;
        if (r104.constraints.requiresDeviceIdle() == false) goto L27;
        Logger.get().debug(TAG, String.format("Ignoring WorkSpec %s, Requires device idle.", new Object[]{r104}), new Throwable[0]);
    L27:
        if (r108 >= 24) goto L29;
    L31:
        r100.add(r104);
        r101.add(r104.f15686id);
        goto L33
    L29:
        if (r104.constraints.hasContentUriTriggers() == false) goto L31;
        Logger.get().debug(TAG, String.format("Ignoring WorkSpec %s, Requires ContentUri triggers.", new Object[]{r104}), new Throwable[0]);
        goto L33
    L32:
        Logger.get().debug(TAG, String.format("Starting work for %s", new Object[]{r104.f15686id}), new Throwable[0]);
        this.mWorkManagerImpl.startWork(r104.f15686id);
    L33:
        r103 = r103 + 1;
        goto L11
    L34:
        Object r111 = this.mLock;
        monitor-enter(r111);
    L41:
        th = move-exception;
        throw th;
    L37:
        if (r100.isEmpty() == true) goto L39;
        Logger.get().debug(TAG, String.format("Starting tracking for [%s]", new Object[]{TextUtils.join(",", r101)}), new Throwable[0]);     // Catch: Throwable -> L41
        this.mConstrainedWorkSpecs.addAll(r100);     // Catch: Throwable -> L41
        this.mWorkConstraintsTracker.replace(this.mConstrainedWorkSpecs);     // Catch: Throwable -> L41
    L39:
        monitor-exit(r111);     // Catch: Throwable -> L41
    }

    public void setDelayedWorkTracker(DelayedWorkTracker r100) {
        this.mDelayedWorkTracker = r100;
    }

    @Override // androidx.work.impl.ExecutionListener
    public void onExecuted(String r100, boolean r101) {
        removeConstraintTrackingFor(r100);
    }

    public GreedyScheduler(Context r100, WorkManagerImpl r101, WorkConstraintsTracker r102) {
        this.mConstrainedWorkSpecs = new HashSet();
        this.mContext = r100;
        this.mWorkManagerImpl = r101;
        this.mWorkConstraintsTracker = r102;
        this.mLock = new Object();
    }

    public GreedyScheduler(Context r100, Configuration r101, TaskExecutor r102, WorkManagerImpl r103) {
        this.mConstrainedWorkSpecs = new HashSet();
        this.mContext = r100;
        this.mWorkManagerImpl = r103;
        this.mWorkConstraintsTracker = new WorkConstraintsTracker(r100, r102, this);
        this.mDelayedWorkTracker = new DelayedWorkTracker(this, r101.getRunnableScheduler());
        this.mLock = new Object();
    }
}
