package androidx.work.impl.utils;

import androidx.work.Operation;
import androidx.work.impl.OperationImpl;
import androidx.work.impl.WorkManagerImpl;
import com.larus.apm.impl.protector.RunnableProtector;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes28.dex */
public class PruneWorkRunnable implements Runnable {
    private final OperationImpl mOperation;
    private final WorkManagerImpl mWorkManagerImpl;

    @Override // java.lang.Runnable
    public void run() {
        androidx_work_impl_utils_PruneWorkRunnable_com_larus_apm_impl_protector_RunnableLancet_run(this);
    }

    public void androidx_work_impl_utils_PruneWorkRunnable__run$___twin___() {
        this.mWorkManagerImpl.getWorkDatabase().workSpecDao().pruneFinishedWorkWithZeroDependentsIgnoringKeepForAtLeast();     // Catch: Throwable -> L4
        this.mOperation.setState(Operation.SUCCESS);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        this.mOperation.setState(new Operation.State.FAILURE(th));
    }

    public Operation getOperation() {
        return this.mOperation;
    }

    public PruneWorkRunnable(WorkManagerImpl r100) {
        this.mWorkManagerImpl = r100;
        this.mOperation = new OperationImpl();
    }

    @Skip({"com.ss.android.ugc.bytex.pthread+"})
    public static void androidx_work_impl_utils_PruneWorkRunnable_com_larus_apm_impl_protector_RunnableLancet_run(PruneWorkRunnable r100) {
        r100.androidx_work_impl_utils_PruneWorkRunnable__run$___twin___();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
