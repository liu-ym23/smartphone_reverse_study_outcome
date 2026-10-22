package com.android.server.am;

import android.os.DebugSmtEx;

/* JADX INFO: loaded from: classes.dex */
public interface IProcLifeStats {
    default void onProcStartEvent(String processName, int uid, String pkgName, String className, String callerPkg, String callType, String action) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void onProcStopEvent(int uid, int pid, String reason) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default String getProcNameFromWaitingDied(int uid, int pid) {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return null;
    }

    default void setPid(int uid, int pid, String processName) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }
}
