package com.android.server.display;

import android.app.ActivityOptions;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.hardware.display.DisplayViewport;
import android.os.Bundle;
import android.os.IBinder;
import android.util.SparseArray;
import android.view.DisplayInfo;
import android.view.IDisplayMirrorWindow;
import android.view.InputEvent;
import android.view.inputmethod.EditorInfo;
import android.window.ScreenCapture;
import com.android.internal.inputmethod.IRemoteInputConnection;
import com.android.server.wm.ActivityRecord;
import java.io.PrintWriter;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class DisplayMirrorStub {
    private static final String TAG = "DisplayMirrorStub";

    public DisplayMirrorStub() {
    }

    public boolean isEnable() {
        return false;
    }

    public boolean isDebug() {
        return false;
    }

    public void setCmdToCtrl(int cmd, int arg1, int arg2) {
    }

    public void setCmdToCtrl(int cmd, int arg1, int arg2, Bundle bundle) {
    }

    public int getMirrorDisplayType(int displayId) {
        return 0;
    }

    public int getMirrorDisplayState(int displayId, int which) {
        return -1;
    }

    public IDisplayMirrorWindow getFocusMirrorWindow() {
        return null;
    }

    public void noteMirrorInputPanelStatus(IBinder binder) {
    }

    public void requestInputMethodChange(IBinder windowToken, boolean isShow) {
    }

    public void setMirrorWindow(int displayId, IBinder client, IDisplayMirrorWindow win) {
    }

    public Intent getGameBoxIntent() {
        return null;
    }

    public Intent getGameBoxIntent(int displayId) {
        return null;
    }

    public int getAppMirrorDisplayId() {
        return -1;
    }

    public void setGameAssistVRVirtualDisplayToken(IBinder token) {
    }

    public IBinder changeVirtualDisplayTokenIfNeed(IBinder token) {
        return null;
    }

    public void setMediaControl(DisplayMirrorInternal.MediaControl control) {
    }

    public void notifyAudioHdmiConnect() {
    }

    public void setCallbackRunnable(Runnable r, String name) {
    }

    public void dump(PrintWriter pw, String[] args) {
    }

    public void setDMSInfo(Context context, Object lock, DisplayMirrorToSys.MirrorToDMSCallback dms) {
    }

    public void setATMS(DisplayMirrorToSys.MirrorToATMSCallback atms) {
    }

    public void noteAllTaskRemoved(int displayId) {
    }

    public void noteStartInput(IBinder windowToken, IRemoteInputConnection inputContext, int displayId, EditorInfo info) {
    }

    public void applyImeVisibility(boolean setVisible) {
    }

    public void setLogicalDisplays(SparseArray<LogicalDisplay> logicalDisplays) {
    }

    public void noteDisplayAdded(int displayId) {
    }

    public void noteDisplayRemoved(int displayId) {
    }

    public void noteDisplayContentAdded(int displayId) {
    }

    public void noteStartActivityForDisplay(ActivityOptions options) {
    }

    public void setInputManagerService(DisplayMirrorToSys.MirrorToIMSCallback callback) {
    }

    public void noteKeyguardStatus(boolean isShown) {
    }

    public void notifyUpdateFocusedWindow(int displayId, Object win) {
    }

    public void noteRotationChange(int displayId, int rotation) {
    }

    public void noteFinishDrawingWindow(int displayId) {
    }

    public void noteResumedActivity(ActivityRecord r, int displayId) {
    }

    public void noteWindowFinishDraw(ActivityRecord r, int displayId) {
    }

    public void noteDisplayContentProxy(DisplayMirrorDisplay.DisplayContentProxy proxy) {
    }

    public LogicalDisplay getSourceDisplay(LogicalDisplay defaultDisplay, DisplayDevice targetDevice) {
        return null;
    }

    public boolean isNeedForceUpdateViewports(ArrayList<DisplayViewport> list) {
        return false;
    }

    public DisplayInfo getDisplayInfoFromMirrorIfNeeded(int displayId, int callingPid) {
        return null;
    }

    public void changeDisplayDeviceInfoIfNeed(DisplayDeviceInfo info, String deviceName) {
    }

    public boolean showSoftInput(IBinder windowToken, int displayId) {
        return false;
    }

    public boolean hideSoftInput(IBinder windowToken, int displayId) {
        return false;
    }

    public boolean handleBroadcastIntent(Intent intent, int callingUid) {
        return false;
    }

    public boolean isInGameBoxMode() {
        return false;
    }

    public ActivityOptions changeOptionsIfNeeded(ActivityOptions options, int sourceDisplayId) {
        return null;
    }

    public boolean isDisplayMirror(int displayId) {
        return false;
    }

    public boolean handleInjectInputEvent(InputEvent event) {
        return false;
    }

    public boolean handleExtendInputEvent(InputEvent event) {
        return false;
    }

    public boolean isSkipPointer() {
        return false;
    }

    public boolean needIgnoreReuseTaskWhenCalculateTaskDisplayArea(int displayId) {
        return false;
    }

    public boolean isDisplayCanStartActivityToMirror(int displayId) {
        return false;
    }

    public int getPointerDisplayId() {
        return -1;
    }

    public boolean isDuringMirror() {
        return false;
    }

    public int getDisplayMirrorStatus(int displayId, String name) {
        return -1;
    }

    public ScreenCapture.ScreenshotHardwareBuffer getScreenshot(int displayId) {
        return null;
    }

    public boolean isStartGameBoxWhenNoMoreActivity(int displayId) {
        return false;
    }

    public boolean noteStartHome(int sourceDisplayId) {
        return false;
    }

    public int noteReusedFgTaskStart(ComponentName reusedActivity, int sourceDisplayId, int targetDisplayId) {
        return 0;
    }

    public int noteReusedBgTaskStart(ComponentName reusedActivity, int userId) {
        return 0;
    }

    public boolean noteStartActivity(ActivityRecord r, boolean isFromActivity, int sourceDisplayId, boolean isSourceHomeOrRecent, int targetDisplayId) {
        return false;
    }

    public boolean noteStartActivity(ActivityRecord r) {
        return false;
    }

    public void noteStatusbarVisible(boolean visible) {
    }

    public boolean shouldStartGameBoxToMirror() {
        return false;
    }

    public boolean needMirrorRealFocus() {
        return false;
    }

    public String getTopActivityTypeInDefaultDisplay() {
        return "";
    }

    public void saveLastRequestToMirror(Object request) {
    }

    public void allTaskToDisplay(int fromDisplayId, int toDisplayId, boolean toTop) {
    }

    public void taskToDisplay(int taskId, int displayId, boolean toTop) {
    }

    public String getLableOfActivity(ActivityRecord r) {
        return "";
    }
}
