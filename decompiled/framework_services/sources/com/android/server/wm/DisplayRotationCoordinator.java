package com.android.server.wm;

import android.util.Slog;

/* JADX INFO: loaded from: classes3.dex */
class DisplayRotationCoordinator {
    private static final String TAG = "DisplayRotationCoordinator";
    private int mCallbackDisplayId;
    private int mDefaultDisplayCurrentRotation;
    private int mDefaultDisplayDefaultRotation;
    Runnable mDefaultDisplayRotationChangedCallback;

    DisplayRotationCoordinator() {
        this.mCallbackDisplayId = -1;
    }

    void onDefaultDisplayRotationChanged(int rotation) {
        this.mDefaultDisplayCurrentRotation = rotation;
        if (this.mDefaultDisplayRotationChangedCallback == null) goto L6;
        this.mDefaultDisplayRotationChangedCallback.run();
        return;
    }

    void setDefaultDisplayDefaultRotation(int rotation) {
        this.mDefaultDisplayDefaultRotation = rotation;
    }

    int getDefaultDisplayCurrentRotation() {
        return this.mDefaultDisplayCurrentRotation;
    }

    void setDefaultDisplayRotationChangedCallback(int displayId, Runnable callback) {
        if (this.mDefaultDisplayRotationChangedCallback != null) goto L5;
    L9:
        this.mDefaultDisplayRotationChangedCallback = callback;
        this.mCallbackDisplayId = displayId;
        if (this.mDefaultDisplayCurrentRotation == this.mDefaultDisplayDefaultRotation) goto L13;
        callback.run();
        return;
    L13:
        return;
    L5:
        if (displayId == this.mCallbackDisplayId) goto L9;
        throw new UnsupportedOperationException("Multiple clients unsupported. Incoming displayId: " + displayId + ", existing displayId: " + this.mCallbackDisplayId);
    }

    void removeDefaultDisplayRotationChangedCallback(Runnable callback) {
        if (callback == this.mDefaultDisplayRotationChangedCallback) goto L6;
        Slog.w(TAG, "Attempted to remove non-matching callback. DisplayId: " + this.mCallbackDisplayId);
        return;
    L6:
        this.mDefaultDisplayRotationChangedCallback = null;
        this.mCallbackDisplayId = -1;
    }

    static boolean isSecondaryInternalDisplay(DisplayContent displayContent) {
        if (displayContent.isDefaultDisplay == false) goto L6;
        return false;
    L6:
        if (displayContent.mDisplay != null) goto L9;
        return false;
    L9:
        if (displayContent.mDisplay.getType() == 1) goto L11;
        return false;
    L11:
        return true;
    }
}
