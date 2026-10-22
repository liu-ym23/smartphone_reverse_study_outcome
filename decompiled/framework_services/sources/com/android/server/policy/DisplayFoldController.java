package com.android.server.policy;

import android.R;
import android.content.Context;
import android.graphics.Rect;
import android.hardware.devicestate.DeviceStateManager;
import android.hardware.display.DisplayManagerInternal;
import android.os.Handler;
import android.os.HandlerExecutor;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.view.DisplayInfo;
import android.view.IDisplayFoldListener;
import com.android.server.DisplayThread;
import com.android.server.LocalServices;
import com.android.server.wm.WindowManagerInternal;

/* JADX INFO: loaded from: classes2.dex */
class DisplayFoldController {
    private final int mDisplayId;
    private final DisplayManagerInternal mDisplayManagerInternal;
    private final DisplayFoldDurationLogger mDurationLogger;
    private String mFocusedApp;
    private Boolean mFolded;
    private final Rect mFoldedArea;
    private final Handler mHandler;
    private final RemoteCallbackList<IDisplayFoldListener> mListeners;
    private final DisplayInfo mNonOverrideDisplayInfo;
    private Rect mOverrideFoldedArea;
    private final WindowManagerInternal mWindowManagerInternal;

    public static /* synthetic */ void $r8$lambda$UP61ySHIdmxonM9JQcOhYZ_jOG0(DisplayFoldController r0, Boolean r1) {
        r0.lambda$new$0(r1);
    }

    public static /* synthetic */ void $r8$lambda$l7mN5lzK0DsUwxRCkhWSdM0X7Jo(DisplayFoldController r0, IDisplayFoldListener r1) {
        r0.lambda$registerDisplayFoldListener$1(r1);
    }

    DisplayFoldController(Context context, WindowManagerInternal windowManagerInternal, DisplayManagerInternal displayManagerInternal, int displayId, Rect foldedArea, Handler handler) {
        this.mOverrideFoldedArea = new Rect();
        this.mNonOverrideDisplayInfo = new DisplayInfo();
        this.mListeners = new RemoteCallbackList();
        this.mDurationLogger = new DisplayFoldDurationLogger();
        this.mWindowManagerInternal = windowManagerInternal;
        this.mDisplayManagerInternal = displayManagerInternal;
        this.mDisplayId = displayId;
        this.mFoldedArea = new Rect(foldedArea);
        this.mHandler = handler;
        DeviceStateManager deviceStateManager = (DeviceStateManager) context.getSystemService(DeviceStateManager.class);
        deviceStateManager.registerCallback(new HandlerExecutor(handler), new DeviceStateManager.FoldStateListener(context, new DisplayFoldController$$ExternalSyntheticLambda0(this)));
    }

    private /* synthetic */ void lambda$new$0(Boolean folded) {
        setDeviceFolded(folded.booleanValue());
    }

    void finishedGoingToSleep() {
        this.mDurationLogger.onFinishedGoingToSleep();
    }

    void finishedWakingUp() {
        this.mDurationLogger.onFinishedWakingUp(this.mFolded);
    }

    private void setDeviceFolded(boolean folded) {
        if (this.mFolded == null) goto L8;
        if (this.mFolded.booleanValue() != folded) goto L8;
        return;
    L8:
        if (this.mOverrideFoldedArea.isEmpty() == true) goto L10;
        Rect foldedArea = this.mOverrideFoldedArea;
    L14:
        if (foldedArea == null) goto L18;
        if (folded == false) goto L17;
        this.mDisplayManagerInternal.getNonOverrideDisplayInfo(this.mDisplayId, this.mNonOverrideDisplayInfo);
        int dx = ((this.mNonOverrideDisplayInfo.logicalWidth - foldedArea.width()) / 2) - foldedArea.left;
        int dy = ((this.mNonOverrideDisplayInfo.logicalHeight - foldedArea.height()) / 2) - foldedArea.top;
        this.mDisplayManagerInternal.setDisplayScalingDisabled(this.mDisplayId, true);
        this.mWindowManagerInternal.setForcedDisplaySize(this.mDisplayId, foldedArea.width(), foldedArea.height());
        this.mDisplayManagerInternal.setDisplayOffsets(this.mDisplayId, -dx, -dy);
        goto L18
    L17:
        this.mDisplayManagerInternal.setDisplayScalingDisabled(this.mDisplayId, false);
        this.mWindowManagerInternal.clearForcedDisplaySize(this.mDisplayId);
        this.mDisplayManagerInternal.setDisplayOffsets(this.mDisplayId, 0, 0);
    L18:
        this.mDurationLogger.setDeviceFolded(folded);
        this.mDurationLogger.logFocusedAppWithFoldState(folded, this.mFocusedApp);
        this.mFolded = Boolean.valueOf(folded);
        int n = this.mListeners.beginBroadcast();
        int i = 0;
    L19:
        if (i >= n) goto L24;
        this.mListeners.getBroadcastItem(i).onDisplayFoldChanged(this.mDisplayId, folded);     // Catch: RemoteException -> L22
    L23:
        i = i + 1;
        goto L19
    L24:
        this.mListeners.finishBroadcast();
        return;
    L10:
        Rect foldedArea2 = this.mFoldedArea;
        if (foldedArea2.isEmpty() == true) goto L13;
        foldedArea = this.mFoldedArea;
        goto L14
    L13:
        foldedArea = null;
        goto L14
    }

    void registerDisplayFoldListener(final IDisplayFoldListener listener) {
        this.mListeners.register(listener);
        if (this.mFolded != null) goto L5;
        return;
    L5:
        this.mHandler.post(new DisplayFoldController$$ExternalSyntheticLambda1(this, listener));
    }

    private /* synthetic */ void lambda$registerDisplayFoldListener$1(IDisplayFoldListener listener) {
        listener.onDisplayFoldChanged(this.mDisplayId, this.mFolded.booleanValue());     // Catch: RemoteException -> L4
        return;
    }

    void unregisterDisplayFoldListener(IDisplayFoldListener listener) {
        this.mListeners.unregister(listener);
    }

    void setOverrideFoldedArea(Rect area) {
        this.mOverrideFoldedArea.set(area);
    }

    Rect getFoldedArea() {
        if (this.mOverrideFoldedArea.isEmpty() == true) goto L7;
        return this.mOverrideFoldedArea;
    L7:
        return this.mFoldedArea;
    }

    void onDefaultDisplayFocusChanged(String pkg) {
        this.mFocusedApp = pkg;
    }

    static DisplayFoldController create(Context context, int displayId) {
        WindowManagerInternal windowManagerService = (WindowManagerInternal) LocalServices.getService(WindowManagerInternal.class);
        DisplayManagerInternal displayService = (DisplayManagerInternal) LocalServices.getService(DisplayManagerInternal.class);
        String configFoldedArea = context.getResources().getString(R.string.config_platformVpnConfirmDialogComponent);
        if (configFoldedArea != null) goto L5;
    L8:
        Rect foldedArea = new Rect();
    L10:
        return new DisplayFoldController(context, windowManagerService, displayService, displayId, foldedArea, DisplayThread.getHandler());
    L5:
        if (configFoldedArea.isEmpty() == true) goto L8;
        foldedArea = Rect.unflattenFromString(configFoldedArea);
        goto L10
    }
}
