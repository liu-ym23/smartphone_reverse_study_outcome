package androidx.work.impl.utils;

import androidx.work.WorkerParameters;
import androidx.work.impl.WorkManagerImpl;
import com.larus.apm.impl.protector.RunnableProtector;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes28.dex */
public class StartWorkRunnable implements Runnable {
    private WorkerParameters.RuntimeExtras mRuntimeExtras;
    private WorkManagerImpl mWorkManagerImpl;
    private String mWorkSpecId;

    @Override // java.lang.Runnable
    public void run() {
        androidx_work_impl_utils_StartWorkRunnable_com_larus_apm_impl_protector_RunnableLancet_run(this);
    }

    public void androidx_work_impl_utils_StartWorkRunnable__run$___twin___() {
        this.mWorkManagerImpl.getProcessor().startWork(this.mWorkSpecId, this.mRuntimeExtras);
    }

    @Skip({"com.ss.android.ugc.bytex.pthread+"})
    public static void androidx_work_impl_utils_StartWorkRunnable_com_larus_apm_impl_protector_RunnableLancet_run(StartWorkRunnable r100) {
        r100.androidx_work_impl_utils_StartWorkRunnable__run$___twin___();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public StartWorkRunnable(WorkManagerImpl r100, String r101, WorkerParameters.RuntimeExtras r102) {
        this.mWorkManagerImpl = r100;
        this.mWorkSpecId = r101;
        this.mRuntimeExtras = r102;
    }
}
