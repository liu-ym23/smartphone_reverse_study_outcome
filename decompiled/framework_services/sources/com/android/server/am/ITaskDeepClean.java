package com.android.server.am;

import android.os.DebugSmtEx;

/* JADX INFO: loaded from: classes.dex */
public interface ITaskDeepClean {
    default void init(ActivityManagerService ams) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default boolean isDeepClean(String packageName, int cleanLevel) {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return false;
    }

    default void updateVpnPackage(String vpnPackage) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void tryDoForceStop(int callerPid, String pkgName, int userId) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void addTdcEvent(int type, int cleanLevel, String pkg, int reason) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }
}
