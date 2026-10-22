package com.android.server.am;

import android.os.DebugSmtEx;

/* JADX INFO: loaded from: classes.dex */
public interface IProcessGuard {
    default void onMemoryPsiEvent(int newPressureState) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void keepAliveBackground(int uid, String pkg, String proc, int action, String reason) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }
}
