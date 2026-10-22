package com.bytedance.lego.init;

import d.h.b.h;

/* JADX INFO: compiled from: IdleTaskDispatcher.kt */
/* JADX INFO: loaded from: classes.dex */
public final class IdleTaskConfig {
    public static final Companion Companion = null;
    private static final IdleTaskConfig DEFAULT_IDLETASK_CONFIG = null;
    private static final long IDLE_START_TIME_OUT = 15000;
    private final boolean autoIdleTask;
    private final long bootFinishTimeOut;
    private final int nonUIThreadTaskNum;
    private final int uiThreadTaskNum;

    /* JADX INFO: compiled from: IdleTaskDispatcher.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(h r1) {
            this();
        }

        public final IdleTaskConfig getDEFAULT_IDLETASK_CONFIG$initscheduler_release() {
            return IdleTaskConfig.access$getDEFAULT_IDLETASK_CONFIG$cp();
        }
    }

    public IdleTaskConfig() {
        this(0, 0, false, 0, 15, null);
    }

    public IdleTaskConfig(int r1, int r2, boolean r3, long r4) {
        this.uiThreadTaskNum = r1;
        this.nonUIThreadTaskNum = r2;
        this.autoIdleTask = r3;
        this.bootFinishTimeOut = r4;
    }

    public /* synthetic */ IdleTaskConfig(int r2, int r3, boolean r4, long r5, int r7, h r8) {
        if ((r7 & 1) == 0) goto L6;
        r2 = 1;
    L6:
        if ((r7 & 2) == 0) goto L9;
        r3 = 1;
    L9:
        if ((r7 & 4) == 0) goto L12;
        r4 = false;
    L12:
        if ((r7 & 8) == 0) goto L14;
        r5 = IDLE_START_TIME_OUT;
    L14:
        this(r2, r3, r4, r5);
    }

    public static final /* synthetic */ IdleTaskConfig access$getDEFAULT_IDLETASK_CONFIG$cp() {
        return DEFAULT_IDLETASK_CONFIG;
    }

    public final boolean getAutoIdleTask() {
        return this.autoIdleTask;
    }

    public final long getBootFinishTimeOut() {
        return this.bootFinishTimeOut;
    }

    public final int getNonUIThreadTaskNum() {
        return this.nonUIThreadTaskNum;
    }

    public final int getUiThreadTaskNum() {
        return this.uiThreadTaskNum;
    }

    static {
        Companion = new Companion(null);
        DEFAULT_IDLETASK_CONFIG = new IdleTaskConfig(0, 0, false, 0, 15, null);
    }
}
