package com.android.server.am;

import android.os.DebugSmtEx;

/* JADX INFO: loaded from: classes.dex */
public interface IIoLimiter {
    default void init(ActivityManagerService ams) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void notifyStartIoLimit(int uid, int pid) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void notifyStopIoLimit(int uid, int pid) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }
}
