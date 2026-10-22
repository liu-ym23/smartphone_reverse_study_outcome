package androidx.work.multiprocess;

import android.content.Context;
import androidx.work.Data;
import androidx.work.ExistingPeriodicWorkPolicy;
import androidx.work.ExistingWorkPolicy;
import androidx.work.OneTimeWorkRequest;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkContinuation;
import androidx.work.WorkInfo;
import androidx.work.WorkQuery;
import androidx.work.WorkRequest;
import androidx.work.impl.WorkManagerImpl;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

/* JADX INFO: loaded from: classes28.dex */
public abstract class RemoteWorkManager {
    public abstract RemoteWorkContinuation beginUniqueWork(String r100, ExistingWorkPolicy r101, List<OneTimeWorkRequest> r102);

    public abstract RemoteWorkContinuation beginWith(List<OneTimeWorkRequest> r100);

    public abstract ListenableFuture<Void> cancelAllWork();

    public abstract ListenableFuture<Void> cancelAllWorkByTag(String r100);

    public abstract ListenableFuture<Void> cancelUniqueWork(String r100);

    public abstract ListenableFuture<Void> cancelWorkById(UUID r100);

    public abstract ListenableFuture<Void> enqueue(WorkContinuation r100);

    public abstract ListenableFuture<Void> enqueue(WorkRequest r100);

    public abstract ListenableFuture<Void> enqueue(List<WorkRequest> r100);

    public abstract ListenableFuture<Void> enqueueUniquePeriodicWork(String r100, ExistingPeriodicWorkPolicy r101, PeriodicWorkRequest r102);

    public abstract ListenableFuture<Void> enqueueUniqueWork(String r100, ExistingWorkPolicy r101, List<OneTimeWorkRequest> r102);

    public abstract ListenableFuture<List<WorkInfo>> getWorkInfos(WorkQuery r100);

    public abstract ListenableFuture<Void> setProgress(UUID r100, Data r101);

    public RemoteWorkManager() {
    }

    public static RemoteWorkManager getInstance(Context r100) {
        RemoteWorkManager r101 = WorkManagerImpl.getInstance(r100).getRemoteWorkManager();
        if (r101 == null) goto L6;
        return r101;
    L6:
        throw new IllegalStateException("Unable to initialize RemoteWorkManager");
    }

    public final RemoteWorkContinuation beginWith(OneTimeWorkRequest r100) {
        return beginWith(Collections.singletonList(r100));
    }

    public final RemoteWorkContinuation beginUniqueWork(String r100, ExistingWorkPolicy r101, OneTimeWorkRequest r102) {
        return beginUniqueWork(r100, r101, Collections.singletonList(r102));
    }

    public final ListenableFuture<Void> enqueueUniqueWork(String r100, ExistingWorkPolicy r101, OneTimeWorkRequest r102) {
        return enqueueUniqueWork(r100, r101, Collections.singletonList(r102));
    }
}
