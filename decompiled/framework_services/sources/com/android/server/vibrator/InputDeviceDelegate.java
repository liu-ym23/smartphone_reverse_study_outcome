package com.android.server.vibrator;

import android.content.Context;
import android.hardware.input.InputManager;
import android.os.CombinedVibration;
import android.os.Handler;
import android.os.VibratorManager;
import android.util.SparseArray;
import android.view.InputDevice;

/* JADX INFO: loaded from: classes3.dex */
final class InputDeviceDelegate implements InputManager.InputDeviceListener {
    private static final String TAG = "InputDeviceDelegate";
    private final Context mContext;
    private final Handler mHandler;
    private final SparseArray<VibratorManager> mInputDeviceVibrators;
    private InputManager mInputManager;
    private final Object mLock;
    private boolean mShouldVibrateInputDevices;

    InputDeviceDelegate(Context context, Handler handler) {
        this.mLock = new Object();
        this.mInputDeviceVibrators = new SparseArray();
        this.mHandler = handler;
        this.mContext = context;
    }

    public void onSystemReady() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mInputManager = (InputManager) this.mContext.getSystemService(InputManager.class);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // android.hardware.input.InputManager.InputDeviceListener
    public void onInputDeviceAdded(int deviceId) {
        updateInputDevice(deviceId);
    }

    @Override // android.hardware.input.InputManager.InputDeviceListener
    public void onInputDeviceChanged(int deviceId) {
        updateInputDevice(deviceId);
    }

    @Override // android.hardware.input.InputManager.InputDeviceListener
    public void onInputDeviceRemoved(int deviceId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mInputDeviceVibrators.remove(deviceId);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean isAvailable() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.mInputDeviceVibrators.size() <= 0) goto L7;
        boolean r1 = true;
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r1;
    L7:
        r1 = false;
        goto L8
    }

    public boolean vibrateIfAvailable(VibrationSession.CallerInfo callerInfo, CombinedVibration effect) {
        Object r1 = this.mLock;
        monitor-enter(r1);
        int i = 0;
    L23:
    L12:
        th = move-exception;
        Throwable r11 = th;
    L20:
        monitor-exit(r1);     // Catch: Throwable -> L10
        throw r11;
    L6:
        if (i >= this.mInputDeviceVibrators.size()) goto L15;
        CombinedVibration effect2 = effect;
        this.mInputDeviceVibrators.valueAt(i).vibrate(callerInfo.uid, callerInfo.opPkg, effect2, callerInfo.reason, callerInfo.attrs);     // Catch: Throwable -> L10
        i = i + 1;     // Catch: Throwable -> L10
        effect = effect2;
    L10:
        th = move-exception;
        r11 = th;
        goto L20
    L15:
        if (this.mInputDeviceVibrators.size() <= 0) goto L17;
        boolean r12 = true;
    L18:
        monitor-exit(r1);     // Catch: Throwable -> L10
        return r12;
    L17:
        r12 = false;
        goto L18
    }

    public boolean cancelVibrateIfAvailable() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int i = 0;
    L18:
    L8:
        th = move-exception;
        throw th;
    L6:
        if (i >= this.mInputDeviceVibrators.size()) goto L11;
        this.mInputDeviceVibrators.valueAt(i).cancel();     // Catch: Throwable -> L8
        i = i + 1;     // Catch: Throwable -> L8
        goto L18
    L11:
        if (this.mInputDeviceVibrators.size() <= 0) goto L13;
        boolean r1 = true;
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return r1;
    L13:
        r1 = false;
        goto L14
    }

    public boolean updateInputDeviceVibrators(boolean vibrateInputDevices) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int r2 = 0;
        if (this.mInputManager != null) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return false;
    L11:
        if (vibrateInputDevices != this.mShouldVibrateInputDevices) goto L14;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return false;
    L14:
        this.mShouldVibrateInputDevices = vibrateInputDevices;     // Catch: Throwable -> L8
        this.mInputDeviceVibrators.clear();     // Catch: Throwable -> L8
        if (vibrateInputDevices == false) goto L25;
        this.mInputManager.registerInputDeviceListener(this, this.mHandler);     // Catch: Throwable -> L8
        int[] r1 = this.mInputManager.getInputDeviceIds();     // Catch: Throwable -> L8
        int r3 = r1.length;     // Catch: Throwable -> L8
    L17:
        if (r2 >= r3) goto L26;
        int deviceId = r1[r2];     // Catch: Throwable -> L8
        InputDevice device = this.mInputManager.getInputDevice(deviceId);     // Catch: Throwable -> L8
        if (device == null) goto L24;
        VibratorManager vibratorManager = device.getVibratorManager();     // Catch: Throwable -> L8
        if (vibratorManager.getVibratorIds().length <= 0) goto L24;
        this.mInputDeviceVibrators.put(device.getId(), vibratorManager);     // Catch: Throwable -> L8
    L24:
        r2 = r2 + 1;     // Catch: Throwable -> L8
    L26:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return true;
    L25:
        this.mInputManager.unregisterInputDeviceListener(this);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        throw th;
    }

    private void updateInputDevice(int deviceId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mInputManager != null) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L11:
        if (this.mShouldVibrateInputDevices == true) goto L14;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L14:
        InputDevice device = this.mInputManager.getInputDevice(deviceId);     // Catch: Throwable -> L8
        if (device != null) goto L19;
        this.mInputDeviceVibrators.remove(deviceId);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L19:
        VibratorManager vibratorManager = device.getVibratorManager();     // Catch: Throwable -> L8
        if (vibratorManager.getVibratorIds().length <= 0) goto L22;
        this.mInputDeviceVibrators.put(device.getId(), vibratorManager);     // Catch: Throwable -> L8
    L23:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L22:
        this.mInputDeviceVibrators.remove(deviceId);     // Catch: Throwable -> L8
        goto L23
    }
}
