package com.android.server.wm;

import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.util.SparseArray;
import android.view.IWallpaperVisibilityListener;

/* JADX INFO: loaded from: classes3.dex */
class WallpaperVisibilityListeners {
    private final SparseArray<RemoteCallbackList<IWallpaperVisibilityListener>> mDisplayListeners;

    WallpaperVisibilityListeners() {
        this.mDisplayListeners = new SparseArray();
    }

    void registerWallpaperVisibilityListener(IWallpaperVisibilityListener listener, int displayId) {
        RemoteCallbackList<IWallpaperVisibilityListener> listeners = this.mDisplayListeners.get(displayId);
        if (listeners != null) goto L5;
        listeners = new RemoteCallbackList();
        this.mDisplayListeners.append(displayId, listeners);
    L5:
        listeners.register(listener);
    }

    void unregisterWallpaperVisibilityListener(IWallpaperVisibilityListener listener, int displayId) {
        RemoteCallbackList<IWallpaperVisibilityListener> listeners = this.mDisplayListeners.get(displayId);
        if (listeners != null) goto L5;
        return;
    L5:
        listeners.unregister(listener);
    }

    void notifyWallpaperVisibilityChanged(DisplayContent displayContent) {
        int displayId = displayContent.getDisplayId();
        boolean visible = displayContent.mWallpaperController.isWallpaperVisible();
        RemoteCallbackList<IWallpaperVisibilityListener> displayListeners = this.mDisplayListeners.get(displayId);
        if (displayListeners != null) goto L5;
        return;
    L5:
        int i = displayListeners.beginBroadcast();
    L6:
        if (i <= 0) goto L12;
        i = i - 1;
        IWallpaperVisibilityListener listener = displayListeners.getBroadcastItem(i);
        listener.onWallpaperVisibilityChanged(visible, displayId);     // Catch: RemoteException -> L10
        goto L6
    L12:
        displayListeners.finishBroadcast();
    }
}
