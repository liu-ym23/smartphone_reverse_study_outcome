package androidx.work.multiprocess;

import androidx.work.OneTimeWorkRequest;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes28.dex */
public abstract class RemoteWorkContinuation {
    public abstract RemoteWorkContinuation combineInternal(List<RemoteWorkContinuation> r100);

    public abstract ListenableFuture<Void> enqueue();

    public abstract RemoteWorkContinuation then(List<OneTimeWorkRequest> r100);

    public RemoteWorkContinuation() {
    }

    public static RemoteWorkContinuation combine(List<RemoteWorkContinuation> r100) {
        return ((RemoteWorkContinuation) ListProtector.get(r100, 0)).combineInternal(r100);
    }

    public final RemoteWorkContinuation then(OneTimeWorkRequest r100) {
        return then(Collections.singletonList(r100));
    }
}
