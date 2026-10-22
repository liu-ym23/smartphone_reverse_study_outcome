package com.android.server.accessibility;

import android.os.Binder;
import android.os.RemoteException;
import android.util.Slog;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.IAccessibilityInteractionConnection;
import android.view.accessibility.IAccessibilityInteractionConnectionCallback;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ActionReplacingCallback extends IAccessibilityInteractionConnectionCallback.Stub {
    private static final boolean DEBUG = false;
    private static final String LOG_TAG = "ActionReplacingCallback";
    private final IAccessibilityInteractionConnection mConnectionWithReplacementActions;
    private final int mInteractionId;
    private final Object mLock;
    AccessibilityNodeInfo mNodeFromOriginalWindow;
    AccessibilityNodeInfo mNodeWithReplacementActions;
    private final int mNodeWithReplacementActionsInteractionId;
    List<AccessibilityNodeInfo> mNodesFromOriginalWindow;
    List<AccessibilityNodeInfo> mPrefetchedNodesFromOriginalWindow;
    private boolean mReplacementNodeIsReadyOrFailed;
    private final IAccessibilityInteractionConnectionCallback mServiceCallback;
    boolean mSetFindNodeFromOriginalWindowCalled;
    boolean mSetFindNodesFromOriginalWindowCalled;
    boolean mSetPrefetchFromOriginalWindowCalled;

    public ActionReplacingCallback(IAccessibilityInteractionConnectionCallback serviceCallback, IAccessibilityInteractionConnection connectionWithReplacementActions, int interactionId, int interrogatingPid, long interrogatingTid) {
        this.mLock = new Object();
        this.mSetFindNodeFromOriginalWindowCalled = false;
        this.mSetFindNodesFromOriginalWindowCalled = false;
        this.mSetPrefetchFromOriginalWindowCalled = false;
        this.mServiceCallback = serviceCallback;
        this.mConnectionWithReplacementActions = connectionWithReplacementActions;
        this.mInteractionId = interactionId;
        this.mNodeWithReplacementActionsInteractionId = interactionId + 1;
        long identityToken = Binder.clearCallingIdentity();
        this.mConnectionWithReplacementActions.findAccessibilityNodeInfoByAccessibilityId(AccessibilityNodeInfo.ROOT_NODE_ID, null, this.mNodeWithReplacementActionsInteractionId, this, 0, interrogatingPid, interrogatingTid, null, null, null);     // Catch: Throwable -> L5 RemoteException -> L7
    L4:
        Binder.restoreCallingIdentity(identityToken);
        return;
    L5:
        th = move-exception;
        Binder.restoreCallingIdentity(identityToken);
        throw th;
    L9:
        this.mReplacementNodeIsReadyOrFailed = true;     // Catch: Throwable -> L5
        goto L4
    }

    public void setFindAccessibilityNodeInfoResult(AccessibilityNodeInfo info, int interactionId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (interactionId != this.mInteractionId) goto L10;
        this.mNodeFromOriginalWindow = info;     // Catch: Throwable -> L7
        this.mSetFindNodeFromOriginalWindowCalled = true;     // Catch: Throwable -> L7
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L7
        replaceInfoActionsAndCallServiceIfReady();
        return;
    L10:
        if (interactionId != this.mNodeWithReplacementActionsInteractionId) goto L15;
        this.mNodeWithReplacementActions = info;     // Catch: Throwable -> L7
        this.mReplacementNodeIsReadyOrFailed = true;     // Catch: Throwable -> L7
        goto L12
    L15:
        Slog.e(LOG_TAG, "Callback with unexpected interactionId");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
    }

    public void setFindAccessibilityNodeInfosResult(List<AccessibilityNodeInfo> infos, int interactionId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (interactionId != this.mInteractionId) goto L10;
        this.mNodesFromOriginalWindow = infos;     // Catch: Throwable -> L7
        this.mSetFindNodesFromOriginalWindowCalled = true;     // Catch: Throwable -> L7
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L7
        replaceInfoActionsAndCallServiceIfReady();
        return;
    L10:
        if (interactionId != this.mNodeWithReplacementActionsInteractionId) goto L15;
        setNodeWithReplacementActionsFromList(infos);     // Catch: Throwable -> L7
        this.mReplacementNodeIsReadyOrFailed = true;     // Catch: Throwable -> L7
        goto L12
    L15:
        Slog.e(LOG_TAG, "Callback with unexpected interactionId");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
    }

    public void setPrefetchAccessibilityNodeInfoResult(List<AccessibilityNodeInfo> infos, int interactionId) throws RemoteException {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (interactionId != this.mInteractionId) goto L12;
        this.mPrefetchedNodesFromOriginalWindow = infos;     // Catch: Throwable -> L10
        this.mSetPrefetchFromOriginalWindowCalled = true;     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        replaceInfoActionsAndCallServiceIfReady();
        return;
    L12:
        Slog.e(LOG_TAG, "Callback with unexpected interactionId");     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
    }

    private void replaceInfoActionsAndCallServiceIfReady() {
        replaceInfoActionsAndCallService();
        replaceInfosActionsAndCallService();
        replacePrefetchInfosActionsAndCallService();
    }

    private void setNodeWithReplacementActionsFromList(List<AccessibilityNodeInfo> infos) {
        int i = 0;
    L4:
        if (i >= infos.size()) goto L10;
        AccessibilityNodeInfo info = infos.get(i);
        if (info.getSourceNodeId() != AccessibilityNodeInfo.ROOT_NODE_ID) goto L8;
        this.mNodeWithReplacementActions = info;
    L8:
        i = i + 1;
        goto L4
    }

    public void setPerformAccessibilityActionResult(boolean succeeded, int interactionId) throws RemoteException {
        this.mServiceCallback.setPerformAccessibilityActionResult(succeeded, interactionId);
    }

    public void sendTakeScreenshotOfWindowError(int errorCode, int interactionId) throws RemoteException {
        this.mServiceCallback.sendTakeScreenshotOfWindowError(errorCode, interactionId);
    }

    private void replaceInfoActionsAndCallService() {
        Object r1 = this.mLock;
        monitor-enter(r1);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mReplacementNodeIsReadyOrFailed == true) goto L7;
    L11:
        boolean r2 = false;
    L12:
        boolean doCallback = r2;
        if (doCallback == true) goto L15;
    L17:
        AccessibilityNodeInfo nodeToReturn = this.mNodeFromOriginalWindow;     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        if (doCallback == false) goto L30;
        this.mServiceCallback.setFindAccessibilityNodeInfoResult(nodeToReturn, this.mInteractionId);     // Catch: RemoteException -> L22
        return;
    L23:
        return;
    L30:
        return;
    L15:
        if (this.mNodeFromOriginalWindow == null) goto L17;
        replaceActionsOnInfoLocked(this.mNodeFromOriginalWindow);     // Catch: Throwable -> L9
        this.mSetFindNodeFromOriginalWindowCalled = false;     // Catch: Throwable -> L9
        goto L17
    L7:
        if (this.mSetFindNodeFromOriginalWindowCalled == false) goto L11;
        r2 = true;
        goto L12
    }

    private void replaceInfosActionsAndCallService() {
        List<AccessibilityNodeInfo> nodesToReturn = null;
        Object r2 = this.mLock;
        monitor-enter(r2);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mReplacementNodeIsReadyOrFailed == true) goto L7;
    L11:
        boolean r3 = false;
    L12:
        boolean doCallback = r3;
        if (doCallback == false) goto L15;
        nodesToReturn = replaceActionsLocked(this.mNodesFromOriginalWindow);     // Catch: Throwable -> L9
        this.mSetFindNodesFromOriginalWindowCalled = false;     // Catch: Throwable -> L9
    L15:
        monitor-exit(r2);     // Catch: Throwable -> L9
        if (doCallback == false) goto L27;
        this.mServiceCallback.setFindAccessibilityNodeInfosResult(nodesToReturn, this.mInteractionId);     // Catch: RemoteException -> L19
        return;
    L20:
        return;
    L27:
        return;
    L7:
        if (this.mSetFindNodesFromOriginalWindowCalled == false) goto L11;
        r3 = true;
        goto L12
    }

    private void replacePrefetchInfosActionsAndCallService() {
        List<AccessibilityNodeInfo> nodesToReturn = null;
        Object r2 = this.mLock;
        monitor-enter(r2);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mReplacementNodeIsReadyOrFailed == true) goto L7;
    L11:
        boolean r3 = false;
    L12:
        boolean doCallback = r3;
        if (doCallback == false) goto L15;
        nodesToReturn = replaceActionsLocked(this.mPrefetchedNodesFromOriginalWindow);     // Catch: Throwable -> L9
        this.mSetPrefetchFromOriginalWindowCalled = false;     // Catch: Throwable -> L9
    L15:
        monitor-exit(r2);     // Catch: Throwable -> L9
        if (doCallback == false) goto L27;
        this.mServiceCallback.setPrefetchAccessibilityNodeInfoResult(nodesToReturn, this.mInteractionId);     // Catch: RemoteException -> L19
        return;
    L20:
        return;
    L27:
        return;
    L7:
        if (this.mSetPrefetchFromOriginalWindowCalled == false) goto L11;
        r3 = true;
        goto L12
    }

    private List<AccessibilityNodeInfo> replaceActionsLocked(List<AccessibilityNodeInfo> infos) {
        if (infos == null) goto L7;
        int i = 0;
    L5:
        if (i >= infos.size()) goto L7;
        replaceActionsOnInfoLocked(infos.get(i));
        i = i + 1;
    L7:
        if (infos != null) goto L10;
        return null;
    L10:
        return new ArrayList(infos);
    }

    private void replaceActionsOnInfoLocked(AccessibilityNodeInfo info) {
        info.removeAllActions();
        info.setClickable(false);
        info.setFocusable(false);
        info.setContextClickable(false);
        info.setScrollable(false);
        info.setLongClickable(false);
        info.setDismissable(false);
        if (info.getSourceNodeId() == AccessibilityNodeInfo.ROOT_NODE_ID) goto L5;
        return;
    L5:
        if (this.mNodeWithReplacementActions == null) goto L17;
        List<AccessibilityNodeInfo.AccessibilityAction> actions = this.mNodeWithReplacementActions.getActionList();
        if (actions == null) goto L13;
        int j = 0;
    L10:
        if (j >= actions.size()) goto L12;
        info.addAction(actions.get(j));
        j = j + 1;
        goto L10
    L12:
        info.addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_ACCESSIBILITY_FOCUS);
        info.addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_CLEAR_ACCESSIBILITY_FOCUS);
    L13:
        info.setClickable(this.mNodeWithReplacementActions.isClickable());
        info.setFocusable(this.mNodeWithReplacementActions.isFocusable());
        info.setContextClickable(this.mNodeWithReplacementActions.isContextClickable());
        info.setScrollable(this.mNodeWithReplacementActions.isScrollable());
        info.setLongClickable(this.mNodeWithReplacementActions.isLongClickable());
        info.setDismissable(this.mNodeWithReplacementActions.isDismissable());
        return;
    }

    public void sendAttachOverlayResult(int result, int interactionId) throws RemoteException {
        this.mServiceCallback.sendAttachOverlayResult(result, interactionId);
    }
}
