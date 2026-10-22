package androidx.work.impl.workers;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

/* JADX INFO: loaded from: classes28.dex */
public class CombineContinuationsWorker extends Worker {
    @Override // androidx.work.Worker
    public ListenableWorker.Result doWork() {
        return ListenableWorker.Result.success(getInputData());
    }

    public CombineContinuationsWorker(Context r100, WorkerParameters r101) {
        super(r100, r101);
    }
}
