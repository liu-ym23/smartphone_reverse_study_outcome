package androidx.work;

import android.net.Network;
import android.net.Uri;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes17.dex */
public final class WorkerParameters {
    private Executor mBackgroundExecutor;
    private ForegroundUpdater mForegroundUpdater;
    private UUID mId;
    private Data mInputData;
    private ProgressUpdater mProgressUpdater;
    private int mRunAttemptCount;
    private RuntimeExtras mRuntimeExtras;
    private Set<String> mTags;
    private TaskExecutor mWorkTaskExecutor;
    private WorkerFactory mWorkerFactory;

    public static class RuntimeExtras {
        public Network network;
        public List<String> triggeredContentAuthorities;
        public List<Uri> triggeredContentUris;

        public RuntimeExtras() {
            this.triggeredContentAuthorities = Collections.emptyList();
            this.triggeredContentUris = Collections.emptyList();
        }
    }

    public Network getNetwork() {
        return this.mRuntimeExtras.network;
    }

    public List<String> getTriggeredContentAuthorities() {
        return this.mRuntimeExtras.triggeredContentAuthorities;
    }

    public List<Uri> getTriggeredContentUris() {
        return this.mRuntimeExtras.triggeredContentUris;
    }

    public Executor getBackgroundExecutor() {
        return this.mBackgroundExecutor;
    }

    public ForegroundUpdater getForegroundUpdater() {
        return this.mForegroundUpdater;
    }

    public UUID getId() {
        return this.mId;
    }

    public Data getInputData() {
        return this.mInputData;
    }

    public ProgressUpdater getProgressUpdater() {
        return this.mProgressUpdater;
    }

    public int getRunAttemptCount() {
        return this.mRunAttemptCount;
    }

    public RuntimeExtras getRuntimeExtras() {
        return this.mRuntimeExtras;
    }

    public Set<String> getTags() {
        return this.mTags;
    }

    public TaskExecutor getTaskExecutor() {
        return this.mWorkTaskExecutor;
    }

    public WorkerFactory getWorkerFactory() {
        return this.mWorkerFactory;
    }

    public WorkerParameters(UUID r100, Data r101, Collection<String> r102, RuntimeExtras r103, int r104, Executor r105, TaskExecutor r106, WorkerFactory r107, ProgressUpdater r108, ForegroundUpdater r110) {
        this.mId = r100;
        this.mInputData = r101;
        this.mTags = new HashSet(r102);
        this.mRuntimeExtras = r103;
        this.mRunAttemptCount = r104;
        this.mBackgroundExecutor = r105;
        this.mWorkTaskExecutor = r106;
        this.mWorkerFactory = r107;
        this.mProgressUpdater = r108;
        this.mForegroundUpdater = r110;
    }
}
