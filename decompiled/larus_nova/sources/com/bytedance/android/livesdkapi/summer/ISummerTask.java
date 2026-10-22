package com.bytedance.android.livesdkapi.summer;

/* JADX INFO: loaded from: classes12.dex */
public interface ISummerTask extends Runnable {

    public interface Priority {
        public static final int High = 0;
        public static final int Normal = 1;
    }

    public interface Status {
        public static final int CANCEL = 3;
        public static final int COMPLETE = 2;
        public static final int IDLE = 0;
        public static final int RELEASE = 4;
        public static final int RUNNING = 1;
    }

    public interface TaskType {
        public static final int Async = 1;
        public static final int Sync = 0;
    }

    void cancelTask();

    int getPriority();

    int getStatus();

    int getTaskType();

    boolean isInterrupt();

    Boolean needCancel();

    void onRelease();

    void processTask();

    void releaseTask();
}
