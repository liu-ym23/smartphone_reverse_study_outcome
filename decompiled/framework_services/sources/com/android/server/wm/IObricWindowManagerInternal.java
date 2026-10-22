package com.android.server.wm;

import android.graphics.Bitmap;
import android.os.IBinder;
import android.view.InputEvent;
import android.view.MotionEvent;
import com.android.internal.inputmethod.IRemoteInputConnection;

/* JADX INFO: loaded from: classes3.dex */
public interface IObricWindowManagerInternal {
    int getAutoDisplayId();

    IBinder getAutoFocusedWindowToken();

    int getCallingFocusedDisplayId();

    int getRobotsAgentUid();

    Bitmap getWallPaperScreenShot(IBinder r1);

    boolean hasSecureWindow(int r1);

    void hideImeInAuto(int r1);

    boolean hideImeInAuto(IBinder r1, int r2);

    boolean isPkgRunWithOAuto(String r1);

    void onInputEventInjectedForRobots(InputEvent r1);

    void setFakeInputConnection(IRemoteInputConnection r1);

    boolean shouldBlockVibrationForAuto(String r1);

    boolean shouldClipBoardIsolate();

    boolean shouldDispatchToAutoDisplay();

    boolean showImeInAuto(IBinder r1, int r2);

    default int getAllowlistedAssistSourceDisplayId() {
        return 0;
    }

    default boolean isAutoActionRunning() {
        return false;
    }

    default boolean isOwningFocusedWindowOnDisplay(int uid, int pid, String packageName, String activityClassName, int displayId) {
        return false;
    }

    default void reportKeyEventOnAutoDisplay(InputEvent event) {
    }

    default void recordClickViewTreeCandidate(MotionEvent event) {
    }

    default boolean isVDPlayerOnTop() {
        return false;
    }
}
