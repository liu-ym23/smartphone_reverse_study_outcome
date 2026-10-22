package com.android.server.am;

import android.os.DebugSmtEx;

/* JADX INFO: loaded from: classes.dex */
public interface IHandleMemoryLeak {
    default boolean killMemoryLeakProcess(String processName, int pid) {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return false;
    }
}
