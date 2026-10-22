package com.android.server.am;

import android.app.IApplicationThread;
import android.os.DebugSmtEx;
import com.android.server.wm.ActivityRecord;

/* JADX INFO: loaded from: classes.dex */
public interface ISkipDoFrameController {
    default void notifyTopResumedActivityChangedLocked(ActivityRecord topResumedActivity) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void notifyAppDiedLocked(ProcessRecord app, int pid, IApplicationThread thread, boolean fromBinderDied) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void notifyUidStateChanged(String packageName, int uid, int uidState) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }
}
