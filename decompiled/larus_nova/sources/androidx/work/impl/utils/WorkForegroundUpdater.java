package androidx.work.impl.utils;

import android.content.Context;
import androidx.work.ForegroundInfo;
import androidx.work.ForegroundUpdater;
import androidx.work.Logger;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.foreground.ForegroundProcessor;
import androidx.work.impl.model.WorkSpecDao;
import androidx.work.impl.utils.futures.SettableFuture;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.UUID;

/* JADX INFO: loaded from: classes28.dex */
public class WorkForegroundUpdater implements ForegroundUpdater {
    private static final String TAG = null;
    final ForegroundProcessor mForegroundProcessor;
    private final TaskExecutor mTaskExecutor;
    final WorkSpecDao mWorkSpecDao;

    static {
        TAG = Logger.tagWithPrefix("WMFgUpdater");
    }

    public WorkForegroundUpdater(WorkDatabase r100, ForegroundProcessor r101, TaskExecutor r102) {
        this.mForegroundProcessor = r101;
        this.mTaskExecutor = r102;
        this.mWorkSpecDao = r100.workSpecDao();
    }

    @Override // androidx.work.ForegroundUpdater
    public ListenableFuture<Void> setForegroundAsync(final Context r110, final UUID r111, final ForegroundInfo r112) {
        final SettableFuture r100 = SettableFuture.create();
        this.mTaskExecutor.executeOnBackgroundThread(new AnonymousClass1(this, r100, r111, r112, r110));
        return r100;
    }
}
