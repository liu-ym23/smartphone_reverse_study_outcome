package com.android.server.wm;

/* JADX INFO: loaded from: classes3.dex */
public interface IActivityTaskManagerOptEx {
    default void init(ActivityTaskManagerService atmService) {
    }

    default void onProcessFrozen(WindowProcessController proc, int stat, String from) {
    }

    default boolean hasResumedActivity(int uid) {
        return false;
    }

    default boolean hasSetResumedActivity(int uid) {
        return false;
    }
}
