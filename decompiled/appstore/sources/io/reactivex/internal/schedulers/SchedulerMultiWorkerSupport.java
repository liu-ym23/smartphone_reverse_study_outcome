package io.reactivex.internal.schedulers;

import io.reactivex.annotations.NonNull;
import mf.f;

/* JADX INFO: loaded from: classes4.dex */
public interface SchedulerMultiWorkerSupport {

    public interface WorkerCallback {
        void onWorker(int r10, @NonNull f.a r11);
    }

    void createWorkers(int r10, @NonNull WorkerCallback r11);
}
