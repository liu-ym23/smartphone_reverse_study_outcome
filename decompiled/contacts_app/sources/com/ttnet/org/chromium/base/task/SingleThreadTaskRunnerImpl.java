package com.ttnet.org.chromium.base.task;

import android.os.Handler;
import android.os.Message;
import com.bytedance.apm.constant.TraceStatsConsts;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import com.ttnet.org.chromium.base.metrics.RecordHistogram;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes4.dex */
@JNINamespace(TraceStatsConsts.STATS_BASE_MODULE)
public class SingleThreadTaskRunnerImpl extends TaskRunnerImpl implements SingleThreadTaskRunner {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Handler mHandler;
    private final boolean mPostPreNativeTasksAtFrontOfQueue;

    @Retention(RetentionPolicy.SOURCE)
    private @interface PreNativeTaskPostType {
        public static final int DEFERRED_TO_NATIVE_INIT = 2;
        public static final int NUM_ENTRIES = 3;
        public static final int POSTED_AT_BACK_OF_QUEUE = 0;
        public static final int POSTED_AT_FRONT_OF_QUEUE = 1;
    }

    static {
    }

    public SingleThreadTaskRunnerImpl(Handler r3, TaskTraits r4, boolean r5) {
        super(r4, "SingleThreadTaskRunnerImpl", 2);
        this.mHandler = r3;
        this.mPostPreNativeTasksAtFrontOfQueue = r5;
    }

    public SingleThreadTaskRunnerImpl(Handler r2, TaskTraits r3) {
        this(r2, r3, false);
    }

    @Override // com.ttnet.org.chromium.base.task.SingleThreadTaskRunner
    public boolean belongsToCurrentThread() {
        Boolean r0 = belongsToCurrentThreadInternal();
        if (r0 == null) goto L7;
        return r0.booleanValue();
    L7:
        if (this.mHandler.getLooper().getThread() != Thread.currentThread()) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // com.ttnet.org.chromium.base.task.TaskRunnerImpl
    protected void schedulePreNativeTask() {
        if (this.mHandler != null) goto L7;
        RecordHistogram.recordEnumeratedHistogram("Android.TaskScheduling.PreNativeTaskPostType", 2, 3);
        return;
    L7:
        if (this.mPostPreNativeTasksAtFrontOfQueue == false) goto L9;
        RecordHistogram.recordEnumeratedHistogram("Android.TaskScheduling.PreNativeTaskPostType", 1, 3);
        postAtFrontOfQueue();
        return;
    L9:
        RecordHistogram.recordEnumeratedHistogram("Android.TaskScheduling.PreNativeTaskPostType", 0, 3);
        this.mHandler.post(this.mRunPreNativeTaskClosure);
    }

    private void postAtFrontOfQueue() {
        Message r0 = Message.obtain(this.mHandler, this.mRunPreNativeTaskClosure);
        r0.setAsynchronous(true);
        this.mHandler.sendMessageAtFrontOfQueue(r0);
    }
}
