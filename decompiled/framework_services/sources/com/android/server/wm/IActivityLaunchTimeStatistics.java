package com.android.server.wm;

/* JADX INFO: loaded from: classes3.dex */
public interface IActivityLaunchTimeStatistics {
    public static final int LAUNCH_TYPE_COLD_ACTIVITY = 20;
    public static final int LAUNCH_TYPE_COLD_ACTIVITY_FREEZE = 30;
    public static final int LAUNCH_TYPE_COLD_ACTIVITY_PREFETCH_FREEZE = 31;
    public static final int LAUNCH_TYPE_COLD_PROCESS = 10;
    public static final int LAUNCH_TYPE_HOT = 40;
    public static final int LAUNCH_TYPE_HOT_FREEZE = 50;
    public static final int LAUNCH_TYPE_NONE = 0;
    public static final int LAUNCH_TYPE_VR_PREFETCH_HOT = 41;

    default void clearLaunchStepIfPausing(String reason) {
    }

    default void reportLaunchTime(long endTime) {
    }

    default void setLaunchStartTime(long start) {
    }

    default long getLaunchStartTime() {
        return 0;
    }

    default int getLaunchType() {
        return 0;
    }

    default void setLaunchType(int type) {
    }

    default boolean isColdLaunch() {
        return false;
    }
}
