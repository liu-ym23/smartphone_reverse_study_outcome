package com.android.server.am;

import android.os.DebugSmtEx;

/* JADX INFO: loaded from: classes.dex */
public interface IProcessGuardService {
    default void init(ActivityManagerService ams) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void tryDumpMeminfo(String name, int uid, int pid, int adj, String reason) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }
}
