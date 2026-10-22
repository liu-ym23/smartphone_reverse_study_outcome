package com.android.server.wm;

import android.content.ComponentName;
import android.os.Bundle;
import com.android.server.LocalServices;
import com.android.server.scene.ZteSceneDecisionInternal;
import com.zte.performance.scene.ZteSceneDecisionManager;

/* JADX INFO: loaded from: classes3.dex */
public interface IZswActivityRecord {
    boolean isAlterCameraSnapshotZTE(ActivityRecord r1);

    boolean isCameraTaskZTE(ComponentName r1);

    boolean isCameraTaskZTE(ActivityRecord r1);

    boolean isJankedActivitiesDrawFinished(ActivityRecord r1);

    void noteMovedToDisplay(Bundle r1);

    void noteStoppingActivity(int r1, int r2, int r3, String r4, String r5, int r6);

    void notifyActivityDisplayChanged(DisplayContent r1, DisplayContent r2, ActivityRecord r3);

    boolean shouldBypassSizeCompatMode(DisplayContent r1, ActivityRecord r2);

    static void noteAppNotifyActivityResumed(ActivityRecord r) {
        if (ZteSceneDecisionManager.ENABLED == false) goto L9;
        ZteSceneDecisionInternal sceneDecision = (ZteSceneDecisionInternal) LocalServices.getService(ZteSceneDecisionInternal.class);
        if (sceneDecision == null) goto L10;
        if (r == null) goto L11;
        sceneDecision.noteAppNotifyActivityResumed(r.getDisplayId(), r.info.applicationInfo.uid, r.getRootTaskId(), r.mActivityComponent.getPackageName(), r.mActivityComponent.getClassName(), r.app.getPid(), r.getWindowingMode());
        return;
    L11:
        return;
    L10:
        return;
    }
}
