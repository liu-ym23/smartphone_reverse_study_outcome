package com.android.server.am;

import android.os.DebugSmtEx;

/* JADX INFO: loaded from: classes.dex */
public interface IPauseTimeoutDataUpload {
    default void updatePauseTimeoutEvent(String packageName, String className, long duration) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }
}
