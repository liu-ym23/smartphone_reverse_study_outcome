package com.android.server.perf;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.DebugSmtEx;
import com.android.server.am.ActivityManagerService;

/* JADX INFO: loaded from: classes2.dex */
public interface IPerfThermalMonitor {
    default void systemReady(ActivityManagerService ams, Context context) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default boolean isAllowStart(ApplicationInfo info) {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return true;
    }

    default int isPerfThermalState(int type) {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return 0;
    }

    default boolean isPerfThermalShotInterval(int type) {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return true;
    }
}
