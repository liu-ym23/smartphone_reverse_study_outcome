package com.android.server.accessibility.magnification;

import android.os.IBinder;
import android.os.RemoteException;
import android.view.accessibility.IMagnificationConnection;
import android.view.accessibility.IMagnificationConnectionCallback;
import android.view.accessibility.IRemoteMagnificationAnimationCallback;
import android.view.accessibility.MagnificationAnimationCallback;
import com.android.server.accessibility.AccessibilityTraceManager;

/* JADX INFO: loaded from: classes.dex */
class MagnificationConnectionWrapper {
    private static final boolean DBG = false;
    private static final String TAG = "MagnificationConnectionWrapper";
    private final IMagnificationConnection mConnection;
    private final AccessibilityTraceManager mTrace;

    private static class RemoteAnimationCallback extends IRemoteMagnificationAnimationCallback.Stub {
        private final MagnificationAnimationCallback mCallback;
        private final AccessibilityTraceManager mTrace;

        RemoteAnimationCallback(MagnificationAnimationCallback callback, AccessibilityTraceManager trace) {
            this.mCallback = callback;
            this.mTrace = trace;
            if (this.mTrace.isA11yTracingEnabledForTypes(64) == false) goto L6;
            this.mTrace.logTrace("RemoteAnimationCallback.constructor", 64, "callback=" + callback);
            return;
        }

        public void onResult(boolean success) throws RemoteException {
            this.mCallback.onResult(success);
            if (this.mTrace.isA11yTracingEnabledForTypes(64) == false) goto L6;
            this.mTrace.logTrace("RemoteAnimationCallback.onResult", 64, "success=" + success);
            return;
        }
    }

    MagnificationConnectionWrapper(IMagnificationConnection connection, AccessibilityTraceManager trace) {
        this.mConnection = connection;
        this.mTrace = trace;
    }

    void unlinkToDeath(IBinder.DeathRecipient deathRecipient) {
        this.mConnection.asBinder().unlinkToDeath(deathRecipient, 0);
    }

    void linkToDeath(IBinder.DeathRecipient deathRecipient) throws RemoteException {
        this.mConnection.asBinder().linkToDeath(deathRecipient, 0);
    }

    boolean onFullscreenMagnificationActivationChanged(int displayId, boolean activated) {
        if (this.mTrace.isA11yTracingEnabledForTypes(128) == false) goto L11;
        this.mTrace.logTrace("MagnificationConnectionWrapper.onFullscreenMagnificationActivationChanged", 128);
    L11:
        this.mConnection.onFullscreenMagnificationActivationChanged(displayId, activated);     // Catch: RemoteException -> L8
        return true;
    L9:
        return false;
    }

    boolean enableWindowMagnification(int displayId, float scale, float centerX, float centerY, float magnificationFrameOffsetRatioX, float magnificationFrameOffsetRatioY, MagnificationAnimationCallback callback) {
        if (this.mTrace.isA11yTracingEnabledForTypes(128) == false) goto L5;
        AccessibilityTraceManager r0 = this.mTrace;
        StringBuilder r4 = new StringBuilder();
        r4.append("displayId=");
        r4.append(displayId);
        r4.append(";scale=");
        float r8 = scale;
        r4.append(r8);
        r4.append(";centerX=");
        float r9 = centerX;
        r4.append(r9);
        r4.append(";centerY=");
        float r10 = centerY;
        r4.append(r10);
        r4.append(";magnificationFrameOffsetRatioX=");
        float r11 = magnificationFrameOffsetRatioX;
        r4.append(r11);
        r4.append(";magnificationFrameOffsetRatioY=");
        float r12 = magnificationFrameOffsetRatioY;
        r4.append(r12);
        r4.append(";callback=");
        r4.append(callback);
        r0.logTrace("MagnificationConnectionWrapper.enableWindowMagnification", 128, r4.toString());
    L12:
        this.mConnection.enableWindowMagnification(displayId, r8, r9, r10, r11, r12, transformToRemoteCallback(callback, this.mTrace));     // Catch: RemoteException -> L9
        return true;
    L10:
        return false;
    L5:
        r8 = scale;
        r9 = centerX;
        r10 = centerY;
        r11 = magnificationFrameOffsetRatioX;
        r12 = magnificationFrameOffsetRatioY;
        goto L12
    }

    boolean setScaleForWindowMagnification(int displayId, float scale) {
        if (this.mTrace.isA11yTracingEnabledForTypes(128) == false) goto L11;
        this.mTrace.logTrace("MagnificationConnectionWrapper.setScale", 128, "displayId=" + displayId + ";scale=" + scale);
    L11:
        this.mConnection.setScaleForWindowMagnification(displayId, scale);     // Catch: RemoteException -> L8
        return true;
    L9:
        return false;
    }

    boolean disableWindowMagnification(int displayId, MagnificationAnimationCallback callback) {
        if (this.mTrace.isA11yTracingEnabledForTypes(128) == false) goto L11;
        this.mTrace.logTrace("MagnificationConnectionWrapper.disableWindowMagnification", 128, "displayId=" + displayId + ";callback=" + callback);
    L11:
        this.mConnection.disableWindowMagnification(displayId, transformToRemoteCallback(callback, this.mTrace));     // Catch: RemoteException -> L8
        return true;
    L9:
        return false;
    }

    boolean moveWindowMagnifier(int displayId, float offsetX, float offsetY) {
        if (this.mTrace.isA11yTracingEnabledForTypes(128) == false) goto L11;
        this.mTrace.logTrace("MagnificationConnectionWrapper.moveWindowMagnifier", 128, "displayId=" + displayId + ";offsetX=" + offsetX + ";offsetY=" + offsetY);
    L11:
        this.mConnection.moveWindowMagnifier(displayId, offsetX, offsetY);     // Catch: RemoteException -> L8
        return true;
    L9:
        return false;
    }

    boolean moveWindowMagnifierToPosition(int displayId, float positionX, float positionY, MagnificationAnimationCallback callback) {
        if (this.mTrace.isA11yTracingEnabledForTypes(128) == false) goto L11;
        this.mTrace.logTrace("MagnificationConnectionWrapper.moveWindowMagnifierToPosition", 128, "displayId=" + displayId + ";positionX=" + positionX + ";positionY=" + positionY);
    L11:
        this.mConnection.moveWindowMagnifierToPosition(displayId, positionX, positionY, transformToRemoteCallback(callback, this.mTrace));     // Catch: RemoteException -> L8
        return true;
    L9:
        return false;
    }

    boolean showMagnificationButton(int displayId, int magnificationMode) {
        if (this.mTrace.isA11yTracingEnabledForTypes(128) == false) goto L11;
        this.mTrace.logTrace("MagnificationConnectionWrapper.showMagnificationButton", 128, "displayId=" + displayId + ";mode=" + magnificationMode);
    L11:
        this.mConnection.showMagnificationButton(displayId, magnificationMode);     // Catch: RemoteException -> L8
        return true;
    L9:
        return false;
    }

    boolean removeMagnificationButton(int displayId) {
        if (this.mTrace.isA11yTracingEnabledForTypes(128) == false) goto L11;
        this.mTrace.logTrace("MagnificationConnectionWrapper.removeMagnificationButton", 128, "displayId=" + displayId);
    L11:
        this.mConnection.removeMagnificationButton(displayId);     // Catch: RemoteException -> L8
        return true;
    L9:
        return false;
    }

    boolean removeMagnificationSettingsPanel(int displayId) {
        if (this.mTrace.isA11yTracingEnabledForTypes(128) == false) goto L11;
        this.mTrace.logTrace("MagnificationConnectionWrapper.removeMagnificationSettingsPanel", 128, "displayId=" + displayId);
    L11:
        this.mConnection.removeMagnificationSettingsPanel(displayId);     // Catch: RemoteException -> L8
        return true;
    L9:
        return false;
    }

    boolean onUserMagnificationScaleChanged(int userId, int displayId, float scale) {
        if (this.mTrace.isA11yTracingEnabledForTypes(128) == false) goto L11;
        this.mTrace.logTrace("MagnificationConnectionWrapper.onMagnificationScaleUpdated", 128, "displayId=" + displayId);
    L11:
        this.mConnection.onUserMagnificationScaleChanged(userId, displayId, scale);     // Catch: RemoteException -> L8
        return true;
    L9:
        return false;
    }

    boolean setConnectionCallback(IMagnificationConnectionCallback connectionCallback) {
        if (this.mTrace.isA11yTracingEnabledForTypes(384) == false) goto L11;
        this.mTrace.logTrace("MagnificationConnectionWrapper.setConnectionCallback", 384, "callback=" + connectionCallback);
    L11:
        this.mConnection.setConnectionCallback(connectionCallback);     // Catch: RemoteException -> L8
        return true;
    L9:
        return false;
    }

    private static IRemoteMagnificationAnimationCallback transformToRemoteCallback(MagnificationAnimationCallback callback, AccessibilityTraceManager trace) {
        if (callback != null) goto L6;
        return null;
    L6:
        return new RemoteAnimationCallback(callback, trace);
    }
}
