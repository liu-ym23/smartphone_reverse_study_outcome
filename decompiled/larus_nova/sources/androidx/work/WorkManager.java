package androidx.work;

import android.app.PendingIntent;
import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.work.impl.WorkManagerImpl;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

/* JADX INFO: loaded from: classes3.dex */
public abstract class WorkManager {
    public abstract WorkContinuation beginUniqueWork(String r100, ExistingWorkPolicy r101, List<OneTimeWorkRequest> r102);

    public abstract WorkContinuation beginWith(List<OneTimeWorkRequest> r100);

    public abstract Operation cancelAllWork();

    public abstract Operation cancelAllWorkByTag(String r100);

    public abstract Operation cancelUniqueWork(String r100);

    public abstract Operation cancelWorkById(UUID r100);

    public abstract PendingIntent createCancelPendingIntent(UUID r100);

    public abstract Operation enqueue(List<? extends WorkRequest> r100);

    public abstract Operation enqueueUniquePeriodicWork(String r100, ExistingPeriodicWorkPolicy r101, PeriodicWorkRequest r102);

    public abstract Operation enqueueUniqueWork(String r100, ExistingWorkPolicy r101, List<OneTimeWorkRequest> r102);

    public abstract ListenableFuture<Long> getLastCancelAllTimeMillis();

    public abstract LiveData<Long> getLastCancelAllTimeMillisLiveData();

    public abstract ListenableFuture<WorkInfo> getWorkInfoById(UUID r100);

    public abstract LiveData<WorkInfo> getWorkInfoByIdLiveData(UUID r100);

    public abstract ListenableFuture<List<WorkInfo>> getWorkInfos(WorkQuery r100);

    public abstract ListenableFuture<List<WorkInfo>> getWorkInfosByTag(String r100);

    public abstract LiveData<List<WorkInfo>> getWorkInfosByTagLiveData(String r100);

    public abstract ListenableFuture<List<WorkInfo>> getWorkInfosForUniqueWork(String r100);

    public abstract LiveData<List<WorkInfo>> getWorkInfosForUniqueWorkLiveData(String r100);

    public abstract LiveData<List<WorkInfo>> getWorkInfosLiveData(WorkQuery r100);

    public abstract Operation pruneWork();

    public static WorkManager getInstance() {
        WorkManagerImpl r100 = WorkManagerImpl.getInstance();
        if (r100 == null) goto L6;
        return r100;
    L6:
        throw new IllegalStateException("WorkManager is not initialized properly.  The most likely cause is that you disabled WorkManagerInitializer in your manifest but forgot to call WorkManager#initialize in your Application#onCreate or a ContentProvider.");
    }

    public WorkManager() {
    }

    public static WorkManager getInstance(Context r100) {
        return WorkManagerImpl.getInstance(r100);
    }

    public final WorkContinuation beginWith(OneTimeWorkRequest r100) {
        return beginWith(Collections.singletonList(r100));
    }

    public final Operation enqueue(WorkRequest r100) {
        return enqueue(Collections.singletonList(r100));
    }

    public static void initialize(Context r100, Configuration r101) {
        WorkManagerImpl.initialize(r100, r101);
    }

    public final WorkContinuation beginUniqueWork(String r100, ExistingWorkPolicy r101, OneTimeWorkRequest r102) {
        return beginUniqueWork(r100, r101, Collections.singletonList(r102));
    }

    public Operation enqueueUniqueWork(String r100, ExistingWorkPolicy r101, OneTimeWorkRequest r102) {
        return enqueueUniqueWork(r100, r101, Collections.singletonList(r102));
    }
}
