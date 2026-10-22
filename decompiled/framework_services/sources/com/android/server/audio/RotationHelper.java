package com.android.server.audio;

import android.companion.virtualcamera.SensorOrientation;
import android.content.Context;
import android.hardware.devicestate.DeviceStateManager;
import android.hardware.display.DisplayManager;
import android.hardware.display.DisplayManagerGlobal;
import android.os.Handler;
import android.os.HandlerExecutor;
import android.util.Log;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes.dex */
class RotationHelper {
    private static final boolean DEBUG_ROTATION = false;
    private static final String TAG = "AudioService.RotationHelper";
    private static Context sContext;
    private static AudioDisplayListener sDisplayListener;
    private static Boolean sFoldState;
    private static Consumer<Boolean> sFoldStateCallback;
    private static DeviceStateManager.FoldStateListener sFoldStateListener;
    private static final Object sFoldStateLock = null;
    private static Handler sHandler;
    private static Integer sRotation;
    private static Consumer<Integer> sRotationCallback;
    private static final Object sRotationLock = null;

    static final class AudioDisplayListener implements DisplayManager.DisplayListener {
        AudioDisplayListener() {
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayAdded(int displayId) {
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayRemoved(int displayId) {
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayChanged(int displayId) {
            RotationHelper.updateOrientation();
        }
    }

    RotationHelper() {
    }

    static {
        sRotationLock = new Object();
        sFoldStateLock = new Object();
        sRotation = null;
        sFoldState = null;
    }

    static void init(Context context, Handler handler, Consumer<Integer> rotationCallback, Consumer<Boolean> foldStateCallback) {
        if (context == null) goto L6;
        sContext = context;
        sHandler = handler;
        sDisplayListener = new AudioDisplayListener();
        sFoldStateListener = new DeviceStateManager.FoldStateListener(sContext, new RotationHelper$$ExternalSyntheticLambda0());
        sRotationCallback = rotationCallback;
        sFoldStateCallback = foldStateCallback;
        enable();
        return;
    L6:
        throw new IllegalArgumentException("Invalid null context");
    }

    static void enable() {
        ((DisplayManager) sContext.getSystemService("display")).registerDisplayListener(sDisplayListener, sHandler);
        updateOrientation();
        ((DeviceStateManager) sContext.getSystemService(DeviceStateManager.class)).registerCallback(new HandlerExecutor(sHandler), sFoldStateListener);
    }

    static void disable() {
        ((DisplayManager) sContext.getSystemService("display")).unregisterDisplayListener(sDisplayListener);
        ((DeviceStateManager) sContext.getSystemService(DeviceStateManager.class)).unregisterCallback(sFoldStateListener);
    }

    static void updateOrientation() {
        int newRotation = DisplayManagerGlobal.getInstance().getDisplayInfo(0).rotation;
        Object r1 = sRotationLock;
        monitor-enter(r1);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (sRotation == null) goto L11;
        if (sRotation.intValue() != newRotation) goto L11;
    L12:
        monitor-exit(r1);     // Catch: Throwable -> L9
        return;
    L11:
        sRotation = Integer.valueOf(newRotation);     // Catch: Throwable -> L9
        publishRotation(sRotation.intValue());     // Catch: Throwable -> L9
        goto L12
    }

    private static void publishRotation(int rotation) {
        switch(rotation) {
            case 0: goto L7;
            case 1: goto L6;
            case 2: goto L5;
            case 3: goto L4;
            default: goto L3;
        };
    L3:
        Log.e(TAG, "Unknown device rotation");
        int rotationDegrees = -1;
    L9:
        if (rotationDegrees == (-1)) goto L12;
        sRotationCallback.accept(Integer.valueOf(rotationDegrees));
        return;
    L12:
        return;
    L4:
        rotationDegrees = SensorOrientation.ORIENTATION_270;
        goto L9
    L5:
        rotationDegrees = 180;
        goto L9
    L6:
        rotationDegrees = 90;
        goto L9
    L7:
        rotationDegrees = 0;
        goto L9
    }

    static void updateFoldState(boolean foldState) {
        Object r0 = sFoldStateLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (sFoldState == null) goto L11;
        if (sFoldState.booleanValue() != foldState) goto L11;
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L11:
        sFoldState = Boolean.valueOf(foldState);     // Catch: Throwable -> L9
        sFoldStateCallback.accept(Boolean.valueOf(foldState));     // Catch: Throwable -> L9
        goto L12
    }

    static void forceUpdate() {
        Object r0 = sRotationLock;
        monitor-enter(r0);
        sRotation = null;     // Catch: Throwable -> L18
        monitor-exit(r0);     // Catch: Throwable -> L18
        updateOrientation();
        Object r1 = sFoldStateLock;
        monitor-enter(r1);
    L12:
        th = move-exception;
        throw th;
    L10:
        if (sFoldState == null) goto L14;
        sFoldStateCallback.accept(sFoldState);     // Catch: Throwable -> L12
    L14:
        monitor-exit(r1);     // Catch: Throwable -> L12
        return;
    L18:
        th = move-exception;
        throw th;
    }
}
