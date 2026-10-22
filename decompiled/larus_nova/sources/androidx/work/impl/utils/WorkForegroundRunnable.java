package androidx.work.impl.utils;

import android.content.Context;
import androidx.core.os.BuildCompat;
import androidx.work.ForegroundUpdater;
import androidx.work.ListenableWorker;
import androidx.work.Logger;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.futures.SettableFuture;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import com.google.common.util.concurrent.ListenableFuture;
import com.larus.apm.impl.protector.RunnableProtector;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes28.dex */
public class WorkForegroundRunnable implements Runnable {
    static final String TAG = null;
    final Context mContext;
    final ForegroundUpdater mForegroundUpdater;
    final SettableFuture<Void> mFuture;
    final TaskExecutor mTaskExecutor;
    final WorkSpec mWorkSpec;
    final ListenableWorker mWorker;

    @Override // java.lang.Runnable
    public void run() {
        androidx_work_impl_utils_WorkForegroundRunnable_com_larus_apm_impl_protector_RunnableLancet_run(this);
    }

    static {
        TAG = Logger.tagWithPrefix("WorkForegroundRunnable");
    }

    public void androidx_work_impl_utils_WorkForegroundRunnable__run$___twin___() {
        if (this.mWorkSpec.expedited == true) goto L5;
    L9:
        this.mFuture.set(null);
        return;
    L5:
        if (BuildCompat.isAtLeastS() == true) goto L9;
        final SettableFuture r100 = SettableFuture.create();
        this.mTaskExecutor.getMainThreadExecutor().execute(new AnonymousClass1(this, r100));
        r100.addListener(new AnonymousClass2(this, r100), this.mTaskExecutor.getMainThreadExecutor());
    }

    public ListenableFuture<Void> getFuture() {
        return this.mFuture;
    }

    @Skip({"com.ss.android.ugc.bytex.pthread+"})
    public static void androidx_work_impl_utils_WorkForegroundRunnable_com_larus_apm_impl_protector_RunnableLancet_run(WorkForegroundRunnable r100) {
        r100.androidx_work_impl_utils_WorkForegroundRunnable__run$___twin___();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public WorkForegroundRunnable(Context r100, WorkSpec r101, ListenableWorker r102, ForegroundUpdater r103, TaskExecutor r104) {
        this.mFuture = SettableFuture.create();
        this.mContext = r100;
        this.mWorkSpec = r101;
        this.mWorker = r102;
        this.mForegroundUpdater = r103;
        this.mTaskExecutor = r104;
    }
}
