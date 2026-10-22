package com.android.server.am;

import android.os.DebugSmtEx;

/* JADX INFO: loaded from: classes.dex */
public interface IOomAdjChecker {
    default void scheduleOomAdjCheck(int delay) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void setDebugLowMem(boolean debug) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }
}
