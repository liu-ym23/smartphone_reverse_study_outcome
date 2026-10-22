package androidx.work.impl.utils;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayDeque;
import java.util.concurrent.Executor;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes3.dex */
public class SerialExecutor implements Executor {
    private volatile Runnable mActive;
    private final Executor mExecutor;
    private final Object mLock;
    private final ArrayDeque<Task> mTasks;

    public static class Task implements Runnable {
        final Runnable mRunnable;
        final SerialExecutor mSerialExecutor;

        @Override // java.lang.Runnable
        public void run() {
            androidx_work_impl_utils_SerialExecutor$Task_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void androidx_work_impl_utils_SerialExecutor$Task__run$___twin___() {
            this.mRunnable.run();     // Catch: Throwable -> L5
            this.mSerialExecutor.scheduleNext();
            return;
        L5:
            th = move-exception;
            this.mSerialExecutor.scheduleNext();
            throw th;
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void androidx_work_impl_utils_SerialExecutor$Task_com_larus_apm_impl_protector_RunnableLancet_run(Task r100) {
            r100.androidx_work_impl_utils_SerialExecutor$Task__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public Task(SerialExecutor r100, Runnable r101) {
            this.mSerialExecutor = r100;
            this.mRunnable = r101;
        }
    }

    public boolean hasPendingTasks() {
        Object r100 = this.mLock;
        monitor-enter(r100);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.mTasks.isEmpty() == true) goto L7;
        boolean r101 = true;
    L8:
        monitor-exit(r100);     // Catch: Throwable -> L10
        return r101;
    L7:
        r101 = false;
        goto L8
    }

    public void scheduleNext() {
        Object r100 = this.mLock;
        monitor-enter(r100);
        Task r101 = this.mTasks.poll();     // Catch: Throwable -> L9
        this.mActive = r101;     // Catch: Throwable -> L9
        if (r101 == null) goto L7;
        this.mExecutor.execute(this.mActive);     // Catch: Throwable -> L9
    L7:
        monitor-exit(r100);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public Executor getDelegatedExecutor() {
        return this.mExecutor;
    }

    public SerialExecutor(Executor r100) {
        this.mExecutor = r100;
        this.mTasks = new ArrayDeque();
        this.mLock = new Object();
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable r100) {
        Object r101 = this.mLock;
        monitor-enter(r101);
        this.mTasks.add(new Task(this, r100));     // Catch: Throwable -> L9
        if (this.mActive != null) goto L7;
        scheduleNext();     // Catch: Throwable -> L9
    L7:
        monitor-exit(r101);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }
}
