package com.android.server.wm;

import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.util.IntArray;
import android.view.IDisplayWindowListener;
import java.util.ArrayList;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
class DisplayWindowListenerController {
    RemoteCallbackList<IDisplayWindowListener> mDisplayListeners;
    private final WindowManagerService mService;

    public static /* synthetic */ void $r8$lambda$P8K3uBbEYTKb3aHmbBwg4TPLVDk(IntArray r0, DisplayContent r1) {
        lambda$registerListener$0(r0, r1);
    }

    DisplayWindowListenerController(WindowManagerService service) {
        this.mDisplayListeners = new RemoteCallbackList();
        this.mService = service;
    }

    int[] registerListener(IDisplayWindowListener listener) {
        this.mDisplayListeners.register(listener);
        final IntArray displayIds = new IntArray();
        WindowManagerGlobalLock r1 = this.mService.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r1);
        this.mService.mAtmService.mRootWindowContainer.forAllDisplays(new DisplayWindowListenerController$$ExternalSyntheticLambda0(displayIds));     // Catch: Throwable -> L8
        monitor-exit(r1);     // Catch: Throwable -> L8
        WindowManagerService.resetPriorityAfterLockedSection();
        return displayIds.toArray();
    L8:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    private static /* synthetic */ void lambda$registerListener$0(IntArray displayIds, DisplayContent displayContent) {
        displayIds.add(displayContent.mDisplayId);
    }

    void unregisterListener(IDisplayWindowListener listener) {
        this.mDisplayListeners.unregister(listener);
    }

    void dispatchDisplayAdded(DisplayContent display) {
        int count = this.mDisplayListeners.beginBroadcast();
        int i = 0;
    L3:
        if (i >= count) goto L8;
        this.mDisplayListeners.getBroadcastItem(i).onDisplayAdded(display.mDisplayId);     // Catch: RemoteException -> L6
    L7:
        i = i + 1;
        goto L3
    L8:
        this.mDisplayListeners.finishBroadcast();
    }

    void dispatchDisplayChanged(DisplayContent display, Configuration newConfig) {
        boolean isInHierarchy = false;
        int i = 0;
    L4:
        if (i >= display.getParent().getChildCount()) goto L10;
        if (display.getParent().getChildAt(i) != display) goto L8;
        isInHierarchy = true;
    L8:
        i = i + 1;
        goto L4
    L10:
        if (isInHierarchy == true) goto L12;
        return;
    L12:
        int count = this.mDisplayListeners.beginBroadcast();
        int i2 = 0;
    L13:
        if (i2 >= count) goto L18;
        this.mDisplayListeners.getBroadcastItem(i2).onDisplayConfigurationChanged(display.getDisplayId(), newConfig);     // Catch: RemoteException -> L16
    L17:
        i2 = i2 + 1;
        goto L13
    L18:
        this.mDisplayListeners.finishBroadcast();
    }

    void dispatchDisplayRemoved(DisplayContent display) {
        int count = this.mDisplayListeners.beginBroadcast();
        int i = 0;
    L3:
        if (i >= count) goto L8;
        this.mDisplayListeners.getBroadcastItem(i).onDisplayRemoved(display.mDisplayId);     // Catch: RemoteException -> L6
    L7:
        i = i + 1;
        goto L3
    L8:
        this.mDisplayListeners.finishBroadcast();
    }

    void dispatchFixedRotationStarted(DisplayContent display, int newRotation) {
        int count = this.mDisplayListeners.beginBroadcast();
        int i = 0;
    L3:
        if (i >= count) goto L8;
        this.mDisplayListeners.getBroadcastItem(i).onFixedRotationStarted(display.mDisplayId, newRotation);     // Catch: RemoteException -> L6
    L7:
        i = i + 1;
        goto L3
    L8:
        this.mDisplayListeners.finishBroadcast();
    }

    void dispatchFixedRotationFinished(DisplayContent display) {
        int count = this.mDisplayListeners.beginBroadcast();
        int i = 0;
    L3:
        if (i >= count) goto L8;
        this.mDisplayListeners.getBroadcastItem(i).onFixedRotationFinished(display.mDisplayId);     // Catch: RemoteException -> L6
    L7:
        i = i + 1;
        goto L3
    L8:
        this.mDisplayListeners.finishBroadcast();
    }

    void dispatchKeepClearAreasChanged(DisplayContent display, Set<Rect> restricted, Set<Rect> unrestricted) {
        int count = this.mDisplayListeners.beginBroadcast();
        int i = 0;
    L3:
        if (i >= count) goto L8;
        this.mDisplayListeners.getBroadcastItem(i).onKeepClearAreasChanged(display.mDisplayId, new ArrayList(restricted), new ArrayList(unrestricted));     // Catch: RemoteException -> L6
    L7:
        i = i + 1;
        goto L3
    L8:
        this.mDisplayListeners.finishBroadcast();
    }

    void dispatchDesktopModeEligibleChanged(int displayId) {
        int count = this.mDisplayListeners.beginBroadcast();
        int i = 0;
    L3:
        if (i >= count) goto L8;
        this.mDisplayListeners.getBroadcastItem(i).onDesktopModeEligibleChanged(displayId);     // Catch: RemoteException -> L6
    L7:
        i = i + 1;
        goto L3
    L8:
        this.mDisplayListeners.finishBroadcast();
    }
}
