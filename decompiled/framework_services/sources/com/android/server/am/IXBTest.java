package com.android.server.am;

import android.os.DebugSmtEx;
import com.android.server.wm.ActivityRecord;

/* JADX INFO: loaded from: classes.dex */
public interface IXBTest {
    default void init(ActivityManagerService ams) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void onTopResumedEvent(ActivityRecord r, Object o) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void onStartAppEvent(String pkgName, int targetUid, String callerPkgName, int callerUid) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default boolean shouldLightNingFreezeForXB() {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return false;
    }

    default void uidDied(int uid, String pkgName, String diedReason) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default boolean isInTrimMemTestMode() {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return false;
    }
}
