package com.android.server.am;

import android.app.IAppStartEventObserver;
import android.os.DebugSmtEx;

/* JADX INFO: loaded from: classes.dex */
public interface IAppStartStatistics {
    default void init(ActivityManagerService ams) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void registerAppStartEventObserver(IAppStartEventObserver observe) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void unregisterAppStartEventObserver(IAppStartEventObserver observe) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void updateSystemUidProcStateChange(ProcessRecord app, int procState) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }
}
