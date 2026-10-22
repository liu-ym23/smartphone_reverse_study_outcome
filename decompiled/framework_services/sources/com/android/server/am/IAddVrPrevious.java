package com.android.server.am;

import android.os.DebugSmtEx;
import com.android.server.wm.WindowProcessController;

/* JADX INFO: loaded from: classes.dex */
public interface IAddVrPrevious {
    default void init(ActivityManagerService ams) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void updatePreviousVrProcess(WindowProcessController wpc, long visibleTime) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void dumpsysMemInfo(long cachedKernelMb, int cachedProcs) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default boolean isEnable() {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return false;
    }
}
