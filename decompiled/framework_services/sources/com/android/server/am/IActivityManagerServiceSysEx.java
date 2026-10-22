package com.android.server.am;

/* JADX INFO: loaded from: classes.dex */
public interface IActivityManagerServiceSysEx {
    default void setSystemProcess() {
    }

    default void freezePrefetchApp() {
    }

    default int getPrefetchStateByInfo(String pkg, int uid) {
        return 0;
    }

    default void setPrefetchStateByPid(int pid, int state) {
    }
}
