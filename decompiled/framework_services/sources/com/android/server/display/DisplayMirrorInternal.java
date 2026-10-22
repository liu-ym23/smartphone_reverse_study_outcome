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
import com.android.server.ZteGameServiceFactory;
import com.android.server.wm.ActivityRecord;
import java.io.PrintWriter;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class DisplayMirrorInternal {
    private static DisplayMirrorStub mDisplayMirrorStub;
    public static boolean mIsReuseByAppMirror;
    public static boolean mNeedCreateHome;
    private static boolean sIsEnable;

    public interface MediaControl {
        void exitMirror(boolean r1);

        void noteMirrorTopPkg(String r1);
    }

    public DisplayMirrorInternal() {
    }

    static {
        sIsEnable = false;
        mNeedCreateHome = false;
        mIsReuseByAppMirror = false;
        mDisplayMirrorStub = ZteGameServiceFactory.getInstance().makeDisplayMirrorStub();
    }

    public static boolean isEnable() {
        return mDisplayMirrorStub.isEnable();
    }

    public static boolean isDebug() {
        return false;
    }

    public static void setCmdToCtrl(int cmd, int arg1, int arg2) {
        if (isEnable() == true) goto L5;
        return;
    L5:
        setCmdToCtrl(cmd, arg1, arg2, null);
    }

    public static void setCmdToCtrl(int cmd, int arg1, int arg2, Bundle bundle) {
        if (isEnable() == true) goto L5;
        return;
    L5:
        mDisplayMirrorStub.setCmdToCtrl(cmd, arg1, arg2, bundle);
    }

    static int getMirrorDisplayType(int displayId) {
        if (isEnable() == true) goto L7;
        return 0;
    L7:
        return mDisplayMirrorStub.getMirrorDisplayType(displayId);
    }

    static int getMirrorDisplayState(int displayId, int which) {
        if (isEnable() == true) goto L7;
        return -1;
    L7:
        return mDisplayMirrorStub.getMirrorDisplayState(displayId, which);
    }

    static IDisplayMirrorWindow getFocusMirrorWindow() {
        if (isEnable() == true) goto L7;
        return null;
    L7:
        return mDisplayMirrorStub.getFocusMirrorWindow();
    }

    static void noteMirrorInputPanelStatus(IBinder binder) {
        if (isEnable() == true) goto L5;
        return;
    L5:
        mDisplayMirrorStub.noteMirrorInputPanelStatus(binder);
    }

    static void requestInputMethodChange(IBinder windowToken, boolean isShow) {
        if (isEnable() == true) goto L5;
        return;
    L5:
        mDisplayMirrorStub.requestInputMethodChange(windowToken, isShow);
    }

    public static void setMirrorWindow(int displayId, IBinder client, IDisplayMirrorWindow win) {
        if (isEnable() == true) goto L5;
        return;
    L5:
        mDisplayMirrorStub.setMirrorWindow(displayId, client, win);
    }

    public static Intent getGameBoxIntent() {
        return mDisplayMirrorStub.getGameBoxIntent();
    }

    public static Intent getGameBoxIntent(int displayId) {
        if (isEnable() == true) goto L7;
        return null;
    L7:
        return mDisplayMirrorStub.getGameBoxIntent(displayId);
    }

    public static int getAppMirrorDisplayId() {
        if (isEnable() == true) goto L7;
        return -1;
    L7:
        return mDisplayMirrorStub.getAppMirrorDisplayId();
    }

    public static void setGameAssistVRVirtualDisplayToken(IBinder token) {
        if (isEnable() == true) goto L5;
        return;
    L5:
        mDisplayMirrorStub.setGameAssistVRVirtualDisplayToken(token);
    }

    public static IBinder changeVirtualDisplayTokenIfNeed(IBinder token) {
        if (isEnable() == true) goto L7;
        return null;
    L7:
        return mDisplayMirrorStub.changeVirtualDisplayTokenIfNeed(token);
    }

    public static void setMediaControl(MediaControl control) {
        mDisplayMirrorStub.setMediaControl(control);
    }

    public static void notifyAudioHdmiConnect() {
        if (isEnable() == true) goto L5;
        return;
    L5:
        mDisplayMirrorStub.notifyAudioHdmiConnect();
    }

    public static void setCallbackRunnable(Runnable r, String name) {
        if (isEnable() == true) goto L5;
        return;
    L5:
        mDisplayMirrorStub.setCallbackRunnable(r, name);
    }

    static void dump(PrintWriter pw, String[] args) {
        mDisplayMirrorStub.dump(pw, args);
    }

    static void setDMSInfo(Context context, Object lock, DisplayMirrorToSys.MirrorToDMSCallback dms) {
        mDisplayMirrorStub.setDMSInfo(context, lock, dms);
    }

    public static void setATMS(DisplayMirrorToSys.MirrorToATMSCallback atms) {
        mDisplayMirrorStub.setATMS(atms);
    }

    public static void noteAllTaskRemoved(int displayId) {
        if (isEnable() == true) goto L5;
        return;
    L5:
        mDisplayMirrorStub.noteAllTaskRemoved(displayId);
    }

    public static void noteStartInput(IBinder windowToken, IRemoteInputConnection inputContext, int displayId, EditorInfo info) {
        if (isEnable() == true) goto L5;
        return;
    L5:
        mDisplayMirrorStub.noteStartInput(windowToken, inputContext, displayId, info);
    }

    public static void applyImeVisibility(boolean setVisible) {
        if (isEnable() == true) goto L5;
        return;
    L5:
        mDisplayMirrorStub.applyImeVisibility(setVisible);
    }

    static void setLogicalDisplays(SparseArray<LogicalDisplay> logicalDisplays) {
        mDisplayMirrorStub.setLogicalDisplays(logicalDisplays);
    }

    static void noteDisplayAdded(int displayId) {
        if (isEnable() == true) goto L5;
        return;
    L5:
        mDisplayMirrorStub.noteDisplayAdded(displayId);
    }

    static void noteDisplayRemoved(int displayId) {
        if (isEnable() == true) goto L5;
        return;
    L5:
        mDisplayMirrorStub.noteDisplayRemoved(displayId);
    }

    public static void noteDisplayContentAdded(int displayId) {
        if (isEnable() == true) goto L5;
        return;
    L5:
        mDisplayMirrorStub.noteDisplayContentAdded(displayId);
    }

    public static void noteStartActivityForDisplay(ActivityOptions options) {
        if (isEnable() == true) goto L5;
        return;
    L5:
        mDisplayMirrorStub.noteStartActivityForDisplay(options);
    }

    public static void setInputManagerService(DisplayMirrorToSys.MirrorToIMSCallback callback) {
        mDisplayMirrorStub.setInputManagerService(callback);
    }

    public static void noteKeyguardStatus(boolean isShown) {
        if (isEnable() == true) goto L5;
        return;
    L5:
        mDisplayMirrorStub.noteKeyguardStatus(isShown);
    }

    public static void notifyUpdateFocusedWindow(int displayId, Object win) {
        if (isEnable() == true) goto L5;
        return;
    L5:
        mDisplayMirrorStub.notifyUpdateFocusedWindow(displayId, win);
    }

    public static void noteRotationChange(int displayId, int rotation) {
        if (isEnable() == true) goto L5;
        return;
    L5:
        mDisplayMirrorStub.noteRotationChange(displayId, rotation);
    }

    public static void noteFinishDrawingWindow(int displayId) {
        if (isEnable() == true) goto L5;
        return;
    L5:
        mDisplayMirrorStub.noteFinishDrawingWindow(displayId);
    }

    public static void noteResumedActivity(ActivityRecord r, int displayId) {
        if (isEnable() == true) goto L5;
        return;
    L5:
        mDisplayMirrorStub.noteResumedActivity(r, displayId);
    }

    public static void noteWindowFinishDraw(ActivityRecord r, int displayId) {
        if (isEnable() == true) goto L5;
        return;
    L5:
        mDisplayMirrorStub.noteWindowFinishDraw(r, displayId);
    }

    public static void noteDisplayContentProxy(DisplayMirrorDisplay.DisplayContentProxy proxy) {
        if (isEnable() == true) goto L5;
        return;
    L5:
        mDisplayMirrorStub.noteDisplayContentProxy(proxy);
    }

    static LogicalDisplay getSourceDisplay(LogicalDisplay defaultDisplay, DisplayDevice targetDevice) {
        if (isEnable() == true) goto L6;
        return defaultDisplay;
    L6:
        return mDisplayMirrorStub.getSourceDisplay(defaultDisplay, targetDevice);
    }

    static boolean isNeedForceUpdateViewports(ArrayList<DisplayViewport> list) {
        if (isEnable() == true) goto L7;
        return false;
    L7:
        return mDisplayMirrorStub.isNeedForceUpdateViewports(list);
    }

    static DisplayInfo getDisplayInfoFromMirrorIfNeeded(int displayId, int callingPid) {
        if (isEnable() == true) goto L7;
        return null;
    L7:
        return mDisplayMirrorStub.getDisplayInfoFromMirrorIfNeeded(displayId, callingPid);
    }

    static void changeDisplayDeviceInfoIfNeed(DisplayDeviceInfo info, String deviceName) {
        if (isEnable() == true) goto L5;
        return;
    L5:
        mDisplayMirrorStub.changeDisplayDeviceInfoIfNeed(info, deviceName);
    }

    public static boolean showSoftInput(IBinder windowToken, int displayId) {
        if (isEnable() == true) goto L7;
        return false;
    L7:
        return mDisplayMirrorStub.showSoftInput(windowToken, displayId);
    }

    public static boolean hideSoftInput(IBinder windowToken, int displayId) {
        if (isEnable() == true) goto L7;
        return false;
    L7:
        return mDisplayMirrorStub.hideSoftInput(windowToken, displayId);
    }

    public static boolean handleBroadcastIntent(Intent intent, int callingUid) {
        if (isEnable() == true) goto L7;
        return false;
    L7:
        return mDisplayMirrorStub.handleBroadcastIntent(intent, callingUid);
    }

    public static boolean isInGameBoxMode() {
        if (isEnable() == true) goto L7;
        return false;
    L7:
        return mDisplayMirrorStub.isInGameBoxMode();
    }

    public static ActivityOptions changeOptionsIfNeeded(ActivityOptions options, int sourceDisplayId) {
        if (isEnable() == true) goto L6;
        return options;
    L6:
        return mDisplayMirrorStub.changeOptionsIfNeeded(options, sourceDisplayId);
    }

    public static boolean isDisplayMirror(int displayId) {
        if (isEnable() == true) goto L7;
        return false;
    L7:
        return mDisplayMirrorStub.isDisplayMirror(displayId);
    }

    public static boolean handleInjectInputEvent(InputEvent event) {
        if (isEnable() == true) goto L7;
        return false;
    L7:
        return mDisplayMirrorStub.handleInjectInputEvent(event);
    }

    public static boolean handleExtendInputEvent(InputEvent event) {
        if (isEnable() == true) goto L7;
        return false;
    L7:
        return mDisplayMirrorStub.handleExtendInputEvent(event);
    }

    public static boolean isSkipPointer() {
        if (isEnable() == true) goto L7;
        return false;
    L7:
        return mDisplayMirrorStub.isSkipPointer();
    }

    public static boolean needIgnoreReuseTaskWhenCalculateTaskDisplayArea(int displayId) {
        if (isEnable() == true) goto L7;
        return false;
    L7:
        return mDisplayMirrorStub.needIgnoreReuseTaskWhenCalculateTaskDisplayArea(displayId);
    }

    public static boolean isDisplayCanStartActivityToMirror(int displayId) {
        if (isEnable() == true) goto L7;
        return false;
    L7:
        return mDisplayMirrorStub.isDisplayCanStartActivityToMirror(displayId);
    }

    public static int getPointerDisplayId() {
        if (isEnable() == true) goto L7;
        return -1;
    L7:
        return mDisplayMirrorStub.getPointerDisplayId();
    }

    public static boolean isDuringMirror() {
        if (isEnable() == true) goto L7;
        return false;
    L7:
        return mDisplayMirrorStub.isDuringMirror();
    }

    public static int getDisplayMirrorStatus(int displayId, String name) {
        if (isEnable() == true) goto L7;
        return -1;
    L7:
        return mDisplayMirrorStub.getDisplayMirrorStatus(displayId, name);
    }

    public static ScreenCapture.ScreenshotHardwareBuffer getScreenshot(int displayId) {
        if (isEnable() == true) goto L7;
        return null;
    L7:
        return mDisplayMirrorStub.getScreenshot(displayId);
    }

    public static boolean isStartGameBoxWhenNoMoreActivity(int displayId) {
        if (isEnable() == true) goto L7;
        return false;
    L7:
        return mDisplayMirrorStub.isStartGameBoxWhenNoMoreActivity(displayId);
    }

    public static boolean noteStartHome(int sourceDisplayId) {
        if (isEnable() == true) goto L7;
        return false;
    L7:
        return mDisplayMirrorStub.noteStartHome(sourceDisplayId);
    }

    public static int noteReusedFgTaskStart(ComponentName reusedActivity, int sourceDisplayId, int targetDisplayId) {
        if (isEnable() == true) goto L7;
        return 0;
    L7:
        return mDisplayMirrorStub.noteReusedFgTaskStart(reusedActivity, sourceDisplayId, targetDisplayId);
    }

    public static int noteReusedBgTaskStart(ComponentName reusedActivity, int userId) {
        if (isEnable() == true) goto L7;
        return 0;
    L7:
        return mDisplayMirrorStub.noteReusedBgTaskStart(reusedActivity, userId);
    }

    public static boolean noteStartActivity(ActivityRecord r, boolean isFromActivity, int sourceDisplayId, boolean isSourceHomeOrRecent, int targetDisplayId) {
        if (isEnable() == true) goto L7;
        return false;
    L7:
        return mDisplayMirrorStub.noteStartActivity(r, isFromActivity, sourceDisplayId, isSourceHomeOrRecent, targetDisplayId);
    }

    public static boolean noteStartActivity(ActivityRecord r) {
        if (isEnable() == true) goto L7;
        return false;
    L7:
        return mDisplayMirrorStub.noteStartActivity(r);
    }

    public static void noteStatusbarVisible(boolean visible) {
        mDisplayMirrorStub.noteStatusbarVisible(visible);
    }

    public static boolean shouldStartGameBoxToMirror() {
        if (isEnable() == true) goto L7;
        return false;
    L7:
        return mDisplayMirrorStub.shouldStartGameBoxToMirror();
    }

    public static boolean needMirrorRealFocus() {
        if (isEnable() == true) goto L7;
        return false;
    L7:
        return mDisplayMirrorStub.needMirrorRealFocus();
    }

    public static String getTopActivityTypeInDefaultDisplay() {
        if (isEnable() == true) goto L7;
        return "";
    L7:
        return mDisplayMirrorStub.getTopActivityTypeInDefaultDisplay();
    }

    public static void saveLastRequestToMirror(Object request) {
        if (isEnable() == true) goto L5;
        return;
    L5:
        mDisplayMirrorStub.saveLastRequestToMirror(request);
    }

    public static void allTaskToDisplay(int fromDisplayId, int toDisplayId, boolean toTop) {
        if (isEnable() == true) goto L5;
        return;
    L5:
        mDisplayMirrorStub.allTaskToDisplay(fromDisplayId, toDisplayId, toTop);
    }

    public static void taskToDisplay(int taskId, int displayId, boolean toTop) {
        if (isEnable() == true) goto L5;
        return;
    L5:
        mDisplayMirrorStub.taskToDisplay(taskId, displayId, toTop);
    }

    public static String getLableOfActivity(ActivityRecord r) {
        if (isEnable() == true) goto L7;
        return "";
    L7:
        return mDisplayMirrorStub.getLableOfActivity(r);
    }
}
