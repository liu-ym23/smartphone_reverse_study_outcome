package com.bytedance.lego.init.config;

import android.content.Context;
import com.bytedance.lego.init.IdleTaskConfig;
import com.bytedance.lego.init.util.InitLogger;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: TaskConfig.kt */
/* JADX INFO: loaded from: classes.dex */
public final class TaskConfig {
    private boolean agreePrivacyPopupWindow;
    private final long applicationStartTime;
    private final Context base;
    private final boolean catchException;
    private final int coreThreadNum;
    private final ThreadPoolExecutor executor;
    private final IdleTaskConfig idleTaskConfig;
    private final boolean isDebug;
    private final boolean isMainProcess;
    private final ProcessMatchMode mode;
    private final String processName;
    private ThreadPoolExecutor taskExecutor;
    private final ThreadFactory threadFactory;
    private final int timeout;

    /* JADX INFO: compiled from: TaskConfig.kt */
    public static final class Builder {
        private boolean agreePrivacyPopupWindow;
        private long applicationStartTime;
        private final Context base;
        private boolean catchException;
        private int coreThreadNum;
        private ThreadPoolExecutor executor;
        private IdleTaskConfig idleTaskConfig;
        private boolean isDebug;
        private final boolean isMainProcess;
        private ProcessMatchMode processMatchMode;
        private final String processName;
        private ThreadFactory threadFactory;
        private int timeout;

        public Builder(Context r3, boolean r4, String r5) {
            Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
            o.d(r6, "base");
            o.d(r5, "processName");
            this.base = ZeusTransformUtils.wrapperContext(r6, "com.obric.aiagent.plugin");
            this.isMainProcess = r4;
            this.processName = r5;
            this.processMatchMode = ProcessMatchMode.CONTAIN;
            this.coreThreadNum = Runtime.getRuntime().availableProcessors();
            this.timeout = 8000;
            this.idleTaskConfig = IdleTaskConfig.Companion.getDEFAULT_IDLETASK_CONFIG$initscheduler_release();
            this.applicationStartTime = System.currentTimeMillis();
            this.agreePrivacyPopupWindow = true;
        }

        public final Builder isDebug(boolean r1) {
            this.isDebug = r1;
            return this;
        }

        public final Builder setExecutorService(ThreadPoolExecutor r2) {
            o.d(r2, "executor");
            this.executor = r2;
            return this;
        }

        public final Builder setProcessMatchMode(ProcessMatchMode r2) {
            o.d(r2, "mode");
            this.processMatchMode = r2;
            return this;
        }

        public final Builder setThreadFactory(ThreadFactory r3) {
            ThreadFactory r4 = (ThreadFactory) ZeusTransformUtils.wrapperContextForParams(r3, ThreadFactory.class, "com.obric.aiagent.plugin");
            o.d(r4, "threadFactory");
            this.threadFactory = r4;
            return this;
        }

        public final Builder setCoreThreadNum(int r1) {
            this.coreThreadNum = r1;
            return this;
        }

        public final Builder setTimeOut(int r5) {
            if (r5 >= 3000) goto L5;
            InitLogger.e$default(InitLogger.INSTANCE, null, "TaskConfig.timeout must not be less than 3*1000", 1, null);
            this.timeout = 3000;
        L6:
            return this;
        L5:
            this.timeout = r5;
            goto L6
        }

        public final Builder enableCatchException(boolean r1) {
            this.catchException = r1;
            return this;
        }

        public final Builder setIdleTaskConfig(IdleTaskConfig r2) {
            o.d(r2, "idleTaskConfig");
            this.idleTaskConfig = r2;
            return this;
        }

        public final Builder setApplicationStartTime(long r1) {
            this.applicationStartTime = r1;
            return this;
        }

        public final Builder agreePrivacyPopupWindow(boolean r1) {
            this.agreePrivacyPopupWindow = r1;
            return this;
        }

        public final TaskConfig build() {
            boolean r1 = this.isDebug;
            Context r2 = this.base;
            ThreadPoolExecutor r4 = this.executor;
            ProcessMatchMode r3 = this.processMatchMode;
            int r6 = this.coreThreadNum;
            return new TaskConfig(r1, r2, r3, r4, this.threadFactory, r6, this.isMainProcess, this.processName, this.timeout, this.catchException, this.applicationStartTime, this.idleTaskConfig, this.agreePrivacyPopupWindow, null);
        }
    }

    private TaskConfig(boolean r6, Context r7, ProcessMatchMode r8, ThreadPoolExecutor r9, ThreadFactory r10, int r11, boolean r12, String r13, int r14, boolean r15, long r16, IdleTaskConfig r18, boolean r19) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        ThreadFactory r3 = (ThreadFactory) ZeusTransformUtils.wrapperContextForParams(r10, ThreadFactory.class, "com.obric.aiagent.plugin");
        this.isDebug = r6;
        this.base = ZeusTransformUtils.wrapperContext(r1, "com.obric.aiagent.plugin");
        this.mode = r8;
        this.executor = r9;
        this.threadFactory = r3;
        this.coreThreadNum = r11;
        this.isMainProcess = r12;
        this.processName = r13;
        this.timeout = r14;
        this.catchException = r15;
        this.applicationStartTime = r16;
        this.idleTaskConfig = r18;
        this.agreePrivacyPopupWindow = r19;
    }

    public /* synthetic */ TaskConfig(boolean r18, Context r19, ProcessMatchMode r20, ThreadPoolExecutor r21, ThreadFactory r22, int r23, boolean r24, String r25, int r26, boolean r27, long r28, IdleTaskConfig r30, boolean r31, h r32) {
        this(r18, (Context) ZeusTransformUtils.wrapperContextForParams(r19, Context.class, "com.obric.aiagent.plugin"), r20, r21, (ThreadFactory) ZeusTransformUtils.wrapperContextForParams(r22, ThreadFactory.class, "com.obric.aiagent.plugin"), r23, r24, r25, r26, r27, r28, r30, r31);
    }

    public final Context getBase() {
        return this.base;
    }

    public final ProcessMatchMode getMode() {
        return this.mode;
    }

    public final boolean isDebug() {
        return this.isDebug;
    }

    /* synthetic */ TaskConfig(boolean r18, Context r19, ProcessMatchMode r20, ThreadPoolExecutor r21, ThreadFactory r22, int r23, boolean r24, String r25, int r26, boolean r27, long r28, IdleTaskConfig r30, boolean r31, int r32, h r33) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r19, Context.class, "com.obric.aiagent.plugin");
        ThreadFactory r0 = (ThreadFactory) ZeusTransformUtils.wrapperContextForParams(r22, ThreadFactory.class, "com.obric.aiagent.plugin");
        if ((r32 & 8) == 0) goto L5;
        ThreadPoolExecutor r6 = (ThreadPoolExecutor) ZeusTransformUtils.preCheckCast(null, ThreadPoolExecutor.class, "com.obric.aiagent.plugin");
    L7:
        if ((r32 & 16) == 0) goto L9;
        r0 = (ThreadFactory) ZeusTransformUtils.preCheckCast(null, ThreadFactory.class, "com.obric.aiagent.plugin");
    L9:
        this(r18, r4, r20, r6, r0, r23, r24, r25, r26, r27, r28, r30, r31);
        return;
    L5:
        r6 = r21;
        goto L7
    }

    public final boolean getCatchException() {
        return this.catchException;
    }

    public final String getProcessName() {
        return this.processName;
    }

    public final int getTimeout() {
        return this.timeout;
    }

    public final boolean isMainProcess() {
        return this.isMainProcess;
    }

    public final long getApplicationStartTime() {
        return this.applicationStartTime;
    }

    public final IdleTaskConfig getIdleTaskConfig() {
        return this.idleTaskConfig;
    }

    public final boolean getAgreePrivacyPopupWindow() {
        return this.agreePrivacyPopupWindow;
    }

    public final void setAgreePrivacyPopupWindow(boolean r1) {
        this.agreePrivacyPopupWindow = r1;
    }

    public final void setTaskExecutor(ThreadPoolExecutor r1) {
        this.taskExecutor = r1;
    }

    public final ThreadPoolExecutor getTaskExecutor() {
        ThreadPoolExecutor r0 = this.taskExecutor;
        if (r0 != null) goto L6;
        r0 = this.executor;
    L6:
        if (r0 == null) goto L9;
        return r0;
    L9:
        return getDefaultExecutor();
    }

    private final ThreadPoolExecutor getDefaultExecutor() {
        int r2 = this.coreThreadNum;
        return new ThreadPoolExecutor(r2, r2, 0, TimeUnit.MILLISECONDS, (BlockingQueue) ZeusTransformUtils.preCheckCast(new LinkedBlockingQueue(), BlockingQueue.class, "com.obric.aiagent.plugin"), getThreadFactory());
    }

    private final ThreadFactory getThreadFactory() {
        ThreadFactory r0 = this.threadFactory;
        if (r0 == null) goto L6;
        return r0;
    L6:
        return getDefaultThreadFactory();
    }

    private final ThreadFactory getDefaultThreadFactory() {
        return (ThreadFactory) ZeusTransformUtils.preCheckCast(new AnonymousClass1(), ThreadFactory.class, "com.obric.aiagent.plugin");
    }
}
