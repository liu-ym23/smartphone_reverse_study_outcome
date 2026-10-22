package com.android.server.resmng;

import android.os.DebugSmtEx;

/* JADX INFO: loaded from: classes3.dex */
public interface IPerformanceSchedUtils {
    default int getBoostSystemAppDuration() {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return 0;
    }

    default int getBoostNormalDuration() {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return 0;
    }

    default boolean isBoostEnabled() {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return false;
    }
}
