package androidx.work;

import android.os.Build;
import androidx.work.impl.DefaultRunnableScheduler;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: classes3.dex */
public final class Configuration {
    public static final int MIN_SCHEDULER_LIMIT = 20;
    final String mDefaultProcessName;
    final InitializationExceptionHandler mExceptionHandler;
    final Executor mExecutor;
    final InputMergerFactory mInputMergerFactory;
    private final boolean mIsUsingDefaultTaskExecutor;
    final int mLoggingLevel;
    final int mMaxJobSchedulerId;
    final int mMaxSchedulerLimit;
    final int mMinJobSchedulerId;
    final RunnableScheduler mRunnableScheduler;
    final Executor mTaskExecutor;
    final WorkerFactory mWorkerFactory;

    public static final class Builder {
        String mDefaultProcessName;
        InitializationExceptionHandler mExceptionHandler;
        Executor mExecutor;
        InputMergerFactory mInputMergerFactory;
        int mLoggingLevel;
        int mMaxJobSchedulerId;
        int mMaxSchedulerLimit;
        int mMinJobSchedulerId;
        RunnableScheduler mRunnableScheduler;
        Executor mTaskExecutor;
        WorkerFactory mWorkerFactory;

        public Configuration build() {
            return new Configuration(this);
        }

        public Builder() {
            this.mLoggingLevel = 4;
            this.mMinJobSchedulerId = 0;
            this.mMaxJobSchedulerId = Integer.MAX_VALUE;
            this.mMaxSchedulerLimit = 20;
        }

        public Builder(Configuration r100) {
            this.mExecutor = r100.mExecutor;
            this.mWorkerFactory = r100.mWorkerFactory;
            this.mInputMergerFactory = r100.mInputMergerFactory;
            this.mTaskExecutor = r100.mTaskExecutor;
            this.mLoggingLevel = r100.mLoggingLevel;
            this.mMinJobSchedulerId = r100.mMinJobSchedulerId;
            this.mMaxJobSchedulerId = r100.mMaxJobSchedulerId;
            this.mMaxSchedulerLimit = r100.mMaxSchedulerLimit;
            this.mRunnableScheduler = r100.mRunnableScheduler;
            this.mExceptionHandler = r100.mExceptionHandler;
            this.mDefaultProcessName = r100.mDefaultProcessName;
        }

        public Builder setDefaultProcessName(String r100) {
            this.mDefaultProcessName = r100;
            return this;
        }

        public Builder setExecutor(Executor r100) {
            this.mExecutor = r100;
            return this;
        }

        public Builder setInitializationExceptionHandler(InitializationExceptionHandler r100) {
            this.mExceptionHandler = r100;
            return this;
        }

        public Builder setInputMergerFactory(InputMergerFactory r100) {
            this.mInputMergerFactory = r100;
            return this;
        }

        public Builder setMaxSchedulerLimit(int r100) {
            if (r100 < 20) goto L7;
            this.mMaxSchedulerLimit = Math.min(r100, 50);
            return this;
        L7:
            throw new IllegalArgumentException("WorkManager needs to be able to schedule at least 20 jobs in JobScheduler.");
        }

        public Builder setMinimumLoggingLevel(int r100) {
            this.mLoggingLevel = r100;
            return this;
        }

        public Builder setRunnableScheduler(RunnableScheduler r100) {
            this.mRunnableScheduler = r100;
            return this;
        }

        public Builder setTaskExecutor(Executor r100) {
            this.mTaskExecutor = r100;
            return this;
        }

        public Builder setWorkerFactory(WorkerFactory r100) {
            this.mWorkerFactory = r100;
            return this;
        }

        public Builder setJobSchedulerJobIdRange(int r100, int r101) {
            if ((r101 - r100) < 1000) goto L7;
            this.mMinJobSchedulerId = r100;
            this.mMaxJobSchedulerId = r101;
            return this;
        L7:
            throw new IllegalArgumentException("WorkManager needs a range of at least 1000 job ids.");
        }
    }

    /* JADX INFO: loaded from: classes17.dex */
    public interface Provider {
        Configuration getWorkManagerConfiguration();
    }

    public int getMaxSchedulerLimit() {
        if (Build.VERSION.SDK_INT != 23) goto L7;
        return this.mMaxSchedulerLimit / 2;
    L7:
        return this.mMaxSchedulerLimit;
    }

    public String getDefaultProcessName() {
        return this.mDefaultProcessName;
    }

    public InitializationExceptionHandler getExceptionHandler() {
        return this.mExceptionHandler;
    }

    public Executor getExecutor() {
        return this.mExecutor;
    }

    public InputMergerFactory getInputMergerFactory() {
        return this.mInputMergerFactory;
    }

    public int getMaxJobSchedulerId() {
        return this.mMaxJobSchedulerId;
    }

    public int getMinJobSchedulerId() {
        return this.mMinJobSchedulerId;
    }

    public int getMinimumLoggingLevel() {
        return this.mLoggingLevel;
    }

    public RunnableScheduler getRunnableScheduler() {
        return this.mRunnableScheduler;
    }

    public Executor getTaskExecutor() {
        return this.mTaskExecutor;
    }

    public WorkerFactory getWorkerFactory() {
        return this.mWorkerFactory;
    }

    public boolean isUsingDefaultTaskExecutor() {
        return this.mIsUsingDefaultTaskExecutor;
    }

    public Configuration(Builder r100) {
        Executor r101 = r100.mExecutor;
        if (r101 != null) goto L5;
        this.mExecutor = createDefaultExecutor(false);
    L6:
        Executor r102 = r100.mTaskExecutor;
        if (r102 != null) goto L9;
        this.mIsUsingDefaultTaskExecutor = true;
        this.mTaskExecutor = createDefaultExecutor(true);
    L10:
        WorkerFactory r103 = r100.mWorkerFactory;
        if (r103 != null) goto L13;
        this.mWorkerFactory = WorkerFactory.getDefaultWorkerFactory();
    L14:
        InputMergerFactory r104 = r100.mInputMergerFactory;
        if (r104 != null) goto L17;
        this.mInputMergerFactory = InputMergerFactory.getDefaultInputMergerFactory();
    L18:
        RunnableScheduler r105 = r100.mRunnableScheduler;
        if (r105 != null) goto L21;
        this.mRunnableScheduler = new DefaultRunnableScheduler();
    L22:
        this.mLoggingLevel = r100.mLoggingLevel;
        this.mMinJobSchedulerId = r100.mMinJobSchedulerId;
        this.mMaxJobSchedulerId = r100.mMaxJobSchedulerId;
        this.mMaxSchedulerLimit = r100.mMaxSchedulerLimit;
        this.mExceptionHandler = r100.mExceptionHandler;
        this.mDefaultProcessName = r100.mDefaultProcessName;
        return;
    L21:
        this.mRunnableScheduler = r105;
        goto L22
    L17:
        this.mInputMergerFactory = r104;
        goto L18
    L13:
        this.mWorkerFactory = r103;
        goto L14
    L9:
        this.mIsUsingDefaultTaskExecutor = false;
        this.mTaskExecutor = r102;
        goto L10
    L5:
        this.mExecutor = r101;
        goto L6
    }

    private Executor createDefaultExecutor(boolean r100) {
        return PThreadExecutorsUtils.newFixedThreadPool(Math.max(2, Math.min(Runtime.getRuntime().availableProcessors() - 1, 4)), createDefaultThreadFactory(r100));
    }

    private ThreadFactory createDefaultThreadFactory(final boolean r100) {
        return new AnonymousClass1(this, r100);
    }
}
