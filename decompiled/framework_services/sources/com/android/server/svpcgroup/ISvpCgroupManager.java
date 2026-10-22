package com.android.server.svpcgroup;

import android.os.DebugSmtEx;

/* JADX INFO: loaded from: classes3.dex */
public interface ISvpCgroupManager {
    default int addSvpBackgroundCgroupThread(int pid, int tid) {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return 0;
    }

    default int addSvpBackgroundCgroupThreads(int[] tids, int pid) {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return 0;
    }

    default void limit() {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void testandrelimit(int pid) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void recover() {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void removeProcess(int pid) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }
}
