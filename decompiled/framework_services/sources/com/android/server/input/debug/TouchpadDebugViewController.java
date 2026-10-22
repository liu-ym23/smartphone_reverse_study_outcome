package com.android.server.input.debug;

import android.content.Context;
import android.hardware.input.InputManager;
import android.os.Handler;
import android.os.Looper;
import android.util.Slog;
import android.view.InputDevice;
import android.view.WindowManager;
import com.android.server.input.InputManagerService;
import com.android.server.input.TouchpadHardwareProperties;
import com.android.server.input.TouchpadHardwareState;

/* JADX INFO: loaded from: classes2.dex */
public class TouchpadDebugViewController implements InputManager.InputDeviceListener {
    private static final String TAG = "TouchpadDebugView";
    private final Context mContext;
    private final Handler mHandler;
    private final InputManagerService mInputManagerService;
    private TouchpadDebugView mTouchpadDebugView;
    private boolean mTouchpadVisualizerEnabled;

    public static /* synthetic */ void $r8$lambda$BeordBCjb5TpEf41Cw7I5cpB3xQ(TouchpadDebugViewController r0, TouchpadHardwareState r1, int r2) {
        r0.lambda$updateTouchpadHardwareState$0(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$JqXJSMgAzLWSBiqI10dJ5mXQ1mg(TouchpadDebugViewController r0, TouchpadHardwareState r1, int r2) {
        r0.lambda$updateTouchpadHardwareState$1(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$VrwpYRXgtCd46Qf9IzHjcvpUKQA(TouchpadDebugViewController r0, int r1, int r2) {
        r0.lambda$updateTouchpadGestureInfo$3(r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$gLIf-xkECijmuq31oG13zm3nI30, reason: not valid java name */
    public static /* synthetic */ void m4621$r8$lambda$gLIfxkECijmuq31oG13zm3nI30(TouchpadDebugViewController r0, int r1, int r2) {
        r0.lambda$updateTouchpadGestureInfo$2(r1, r2);
    }

    public TouchpadDebugViewController(Context context, Looper looper, InputManagerService inputManagerService) {
        this.mTouchpadVisualizerEnabled = false;
        this.mContext = context;
        this.mHandler = new Handler(looper);
        this.mInputManagerService = inputManagerService;
    }

    @Override // android.hardware.input.InputManager.InputDeviceListener
    public void onInputDeviceAdded(int deviceId) {
        if (this.mTouchpadVisualizerEnabled == true) goto L5;
        return;
    L5:
        InputManager inputManager = (InputManager) this.mContext.getSystemService(InputManager.class);
        inputManager.getClass();
        InputDevice inputDevice = inputManager.getInputDevice(deviceId);
        if (inputDevice != null) goto L8;
        return;
    L8:
        if (inputDevice.supportsSource(1056778) == false) goto L13;
        showDebugView(deviceId);
        return;
    }

    @Override // android.hardware.input.InputManager.InputDeviceListener
    public void onInputDeviceRemoved(int deviceId) {
        hideDebugView(deviceId);
        if (this.mTouchpadDebugView != null) goto L8;
        InputManager inputManager = (InputManager) this.mContext.getSystemService(InputManager.class);
        inputManager.getClass();
        int[] r1 = inputManager.getInputDeviceIds();
        int r2 = r1.length;
        int r3 = 0;
    L6:
        if (r3 >= r2) goto L10;
        int id = r1[r3];
        onInputDeviceAdded(id);
        r3 = r3 + 1;
        goto L6
    L10:
        return;
    }

    public void switchVisualisationToTouchpadId(int newDeviceId) {
        if (this.mTouchpadDebugView == null) goto L5;
        hideDebugView(this.mTouchpadDebugView.getTouchpadId());
    L5:
        showDebugView(newDeviceId);
    }

    @Override // android.hardware.input.InputManager.InputDeviceListener
    public void onInputDeviceChanged(int deviceId) {
    }

    public void updateTouchpadVisualizerEnabled(boolean touchpadVisualizerEnabled) {
        if (this.mTouchpadVisualizerEnabled != touchpadVisualizerEnabled) goto L5;
        return;
    L5:
        this.mTouchpadVisualizerEnabled = touchpadVisualizerEnabled;
        InputManager inputManager = (InputManager) this.mContext.getSystemService(InputManager.class);
        inputManager.getClass();
        if (touchpadVisualizerEnabled == false) goto L12;
        inputManager.registerInputDeviceListener(this, this.mHandler);
        int[] r1 = inputManager.getInputDeviceIds();
        int r2 = r1.length;
        int r3 = 0;
    L9:
        if (r3 >= r2) goto L17;
        int deviceId = r1[r3];
        onInputDeviceAdded(deviceId);
        r3 = r3 + 1;
        goto L9
    L17:
        return;
    L12:
        if (this.mTouchpadDebugView == null) goto L14;
        hideDebugView(this.mTouchpadDebugView.getTouchpadId());
    L14:
        inputManager.unregisterInputDeviceListener(this);
    }

    private void showDebugView(int touchpadId) {
        if (this.mTouchpadDebugView == null) goto L5;
        return;
    L5:
        WindowManager wm = (WindowManager) this.mContext.getSystemService(WindowManager.class);
        wm.getClass();
        TouchpadHardwareProperties touchpadHardwareProperties = this.mInputManagerService.getTouchpadHardwareProperties(touchpadId);
        this.mTouchpadDebugView = new TouchpadDebugView(this.mContext, touchpadId, touchpadHardwareProperties, new TouchpadDebugViewController$$ExternalSyntheticLambda3(this));
        WindowManager.LayoutParams mWindowLayoutParams = this.mTouchpadDebugView.getWindowLayoutParams();
        wm.addView(this.mTouchpadDebugView, mWindowLayoutParams);
        Slog.d(TAG, "Touchpad debug view created.");
        if (touchpadHardwareProperties == null) goto L8;
        Slog.d(TAG, touchpadHardwareProperties.toString());
        return;
    L8:
        Slog.w(TAG, "Failed to retrieve touchpad hardware properties for device ID: " + touchpadId);
    }

    private void hideDebugView(int touchpadId) {
        if (this.mTouchpadDebugView != null) goto L5;
        return;
    L5:
        if (this.mTouchpadDebugView.getTouchpadId() != touchpadId) goto L10;
        WindowManager wm = (WindowManager) this.mContext.getSystemService(WindowManager.class);
        wm.getClass();
        wm.removeView(this.mTouchpadDebugView);
        this.mTouchpadDebugView = null;
        Slog.d(TAG, "Touchpad debug view removed.");
        return;
    }

    public void updateTouchpadHardwareState(final TouchpadHardwareState touchpadHardwareState, final int deviceId) {
        this.mHandler.post(new TouchpadDebugViewController$$ExternalSyntheticLambda1(this, touchpadHardwareState, deviceId));
    }

    private /* synthetic */ void lambda$updateTouchpadHardwareState$1(final TouchpadHardwareState touchpadHardwareState, final int deviceId) {
        if (this.mTouchpadDebugView == null) goto L6;
        this.mTouchpadDebugView.post(new TouchpadDebugViewController$$ExternalSyntheticLambda2(this, touchpadHardwareState, deviceId));
        return;
    }

    private /* synthetic */ void lambda$updateTouchpadHardwareState$0(TouchpadHardwareState touchpadHardwareState, int deviceId) {
        if (this.mTouchpadDebugView == null) goto L6;
        this.mTouchpadDebugView.updateHardwareState(touchpadHardwareState, deviceId);
        return;
    }

    public void updateTouchpadGestureInfo(final int gestureType, final int deviceId) {
        this.mHandler.post(new TouchpadDebugViewController$$ExternalSyntheticLambda4(this, gestureType, deviceId));
    }

    private /* synthetic */ void lambda$updateTouchpadGestureInfo$3(final int gestureType, final int deviceId) {
        if (this.mTouchpadDebugView == null) goto L6;
        this.mTouchpadDebugView.post(new TouchpadDebugViewController$$ExternalSyntheticLambda0(this, gestureType, deviceId));
        return;
    }

    private /* synthetic */ void lambda$updateTouchpadGestureInfo$2(int gestureType, int deviceId) {
        if (this.mTouchpadDebugView == null) goto L6;
        this.mTouchpadDebugView.updateGestureInfo(gestureType, deviceId);
        return;
    }
}
