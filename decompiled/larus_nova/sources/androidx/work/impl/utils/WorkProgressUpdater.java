package androidx.work.impl.utils;

import android.content.Context;
import androidx.work.Data;
import androidx.work.Logger;
import androidx.work.ProgressUpdater;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.utils.futures.SettableFuture;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.UUID;

/* JADX INFO: loaded from: classes28.dex */
public class WorkProgressUpdater implements ProgressUpdater {
    static final String TAG = null;
    final TaskExecutor mTaskExecutor;
    final WorkDatabase mWorkDatabase;

    static {
        TAG = Logger.tagWithPrefix("WorkProgressUpdater");
    }

    public WorkProgressUpdater(WorkDatabase r100, TaskExecutor r101) {
        this.mWorkDatabase = r100;
        this.mTaskExecutor = r101;
    }

    @Override // androidx.work.ProgressUpdater
    public ListenableFuture<Void> updateProgress(Context r100, final UUID r101, final Data r102) {
        final SettableFuture r103 = SettableFuture.create();
        this.mTaskExecutor.executeOnBackgroundThread(new AnonymousClass1(this, r101, r102, r103));
        return r103;
    }
}
