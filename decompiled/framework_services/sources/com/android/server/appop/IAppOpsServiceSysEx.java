package com.android.server.appop;

import android.os.DebugSmtEx;

/* JADX INFO: loaded from: classes.dex */
public interface IAppOpsServiceSysEx {
    default void systemReady(AppOpsService appOpsService) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default boolean isMutedApp(int uid, String packageName) {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return false;
    }

    default void updateMutedApp(int uid, String packageName, boolean isMute) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }
}
