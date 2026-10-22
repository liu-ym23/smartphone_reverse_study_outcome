package com.android.server.resmng;

import android.os.DebugSmtEx;

/* JADX INFO: loaded from: classes3.dex */
public interface IBoostFrameworkService {
    default int perfLockAcquire(int hint_id) {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return 0;
    }

    default int perfLockAcquireType(int hint_id, int type, int duration) {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return 0;
    }

    default int perfLockAcquireType(int hint_id, int type, int duration, int pid) {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return 0;
    }

    default int perfLockAcquireCustom(int duration, int[] list) {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return 0;
    }

    default int perfLockReleaseHandler(int handle) {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return 0;
    }

    default int thremalPriorityUpdate(int theramLevel) {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return 0;
    }

    default void releasethremalPriority(int handler) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default boolean isEnable(int hint) {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return false;
    }
}
