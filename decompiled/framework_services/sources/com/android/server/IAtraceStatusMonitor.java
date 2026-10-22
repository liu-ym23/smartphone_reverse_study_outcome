package com.android.server;

import android.os.DebugSmtEx;

/* JADX INFO: loaded from: classes.dex */
public interface IAtraceStatusMonitor {
    default void addAppCrash(String packageName, int uid) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }
}
