package com.android.server.am;

import android.os.DebugSmtEx;

/* JADX INFO: loaded from: classes.dex */
public interface IMpamHelper {
    default void init() {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void onAppDisplayed(String pkg, int uid, int pid) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }
}
