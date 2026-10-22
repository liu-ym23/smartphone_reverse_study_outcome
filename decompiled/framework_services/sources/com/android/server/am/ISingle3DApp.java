package com.android.server.am;

import android.os.DebugSmtEx;
import com.android.server.wm.ActivityRecord;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public interface ISingle3DApp {
    default void init(ActivityManagerService ams) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void updateTopResumedActivity(ActivityRecord r, int containerType) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void stopMarkedPkg(String pkg, int uid, ActivityRecord ar) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void updatePendingLaunchActivity(ArrayList<String> targetPackages, ArrayList<Integer> targetUids, ArrayList<String> sourcePackages, ArrayList<Integer> sourceUids) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }
}
