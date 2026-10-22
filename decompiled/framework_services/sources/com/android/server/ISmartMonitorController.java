package com.android.server;

import android.os.DebugSmtEx;

/* JADX INFO: loaded from: classes.dex */
public interface ISmartMonitorController {
    default void updateSwitchStatus(long switchType, boolean open) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void updateDailyCpuUsage() {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }
}
