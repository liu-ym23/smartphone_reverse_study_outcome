package androidx.work;

import androidx.lifecycle.LiveData;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes17.dex */
public abstract class WorkContinuation {
    public WorkContinuation() {
    }

    public abstract WorkContinuation combineInternal(List<WorkContinuation> r100);

    public abstract Operation enqueue();

    public abstract ListenableFuture<List<WorkInfo>> getWorkInfos();

    public abstract LiveData<List<WorkInfo>> getWorkInfosLiveData();

    public abstract WorkContinuation then(List<OneTimeWorkRequest> r100);

    public static WorkContinuation combine(List<WorkContinuation> r100) {
        return ((WorkContinuation) ListProtector.get(r100, 0)).combineInternal(r100);
    }

    public final WorkContinuation then(OneTimeWorkRequest r100) {
        return then(Collections.singletonList(r100));
    }
}
