package com.android.server.input;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.hardware.SensorPrivacyManager;
import android.hardware.input.InputManager;
import android.hardware.lights.Light;
import android.media.AudioManager;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.UserHandle;
import android.util.IndentingPrintWriter;
import android.util.SparseArray;
import android.view.InputDevice;
import java.io.PrintWriter;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public final class KeyboardLedController implements InputManager.InputDeviceListener {
    private static final int MSG_UPDATE_AUDIO_MUTE_LED_STATE = 3;
    private static final int MSG_UPDATE_EXISTING_DEVICES = 1;
    private static final int MSG_UPDATE_MIC_MUTE_LED_STATE = 2;
    private static final String TAG = null;
    private AudioManager mAudioManager;
    private final Context mContext;
    private final Handler mHandler;
    private InputManager mInputManager;
    private final SparseArray<InputDevice> mKeyboardsWithMicMuteLed;
    private final SparseArray<InputDevice> mKeyboardsWithVolumeMuteLed;
    private BroadcastReceiver mMicrophoneMuteChangedIntentReceiver;
    private final NativeInputManagerService mNative;
    private SensorPrivacyManager mSensorPrivacyManager;
    private BroadcastReceiver mVolumeMuteIntentReceiver;

    public static /* synthetic */ boolean $r8$lambda$M7Y2jSMgjsEFqeSkQBUoRJOYDRI(KeyboardLedController r0, Message r1) {
        return r0.handleMessage(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmHandler, reason: not valid java name */
    static /* bridge */ /* synthetic */ Handler m4593$$Nest$fgetmHandler(KeyboardLedController r0) {
        return r0.mHandler;
    }

    static {
        TAG = KeyboardLedController.class.getSimpleName();
    }

    KeyboardLedController(Context context, Looper looper, NativeInputManagerService nativeService) {
        this.mKeyboardsWithMicMuteLed = new SparseArray();
        this.mKeyboardsWithVolumeMuteLed = new SparseArray();
        this.mMicrophoneMuteChangedIntentReceiver = new AnonymousClass1(this);
        this.mVolumeMuteIntentReceiver = new AnonymousClass2(this);
        this.mContext = context;
        this.mNative = nativeService;
        this.mHandler = new Handler(looper, new KeyboardLedController$$ExternalSyntheticLambda0(this));
    }

    private boolean handleMessage(Message msg) {
        int r1 = 0;
        switch(msg.what) {
            case 1: goto L9;
            case 2: goto L7;
            case 3: goto L5;
            default: goto L4;
        };
    L4:
        return false;
    L5:
        updateVolumeMuteLedState();
        return true;
    L7:
        updateMicMuteLedState();
        return true;
    L9:
        int[] r0 = (int[]) msg.obj;
        int r3 = r0.length;
    L10:
        if (r1 >= r3) goto L12;
        int deviceId = r0[r1];
        onInputDeviceAdded(deviceId);
        r1 = r1 + 1;
        goto L10
    L12:
        return true;
    }

    private void updateMicMuteLedState() {
        int color = 0;
        boolean isMicrophoneMute = true;
        if (this.mAudioManager.isMicrophoneMute() == false) goto L5;
    L10:
        if (isMicrophoneMute == false) goto L12;
        color = -1;
    L12:
        int i = 0;
    L14:
        if (i >= this.mKeyboardsWithMicMuteLed.size()) goto L22;
        InputDevice device = this.mKeyboardsWithMicMuteLed.valueAt(i);
        if (device == null) goto L20;
        int deviceId = device.getId();
        Light light = getKeyboardMicMuteLight(device);
        if (light == null) goto L20;
        this.mNative.setLightColor(deviceId, light.getId(), color);
    L20:
        i = i + 1;
        goto L14
    L22:
        return;
    L5:
        if (this.mSensorPrivacyManager.areAnySensorPrivacyTogglesEnabled(1) == true) goto L10;
        isMicrophoneMute = false;
        goto L10
    }

    private void updateVolumeMuteLedState() {
        if (this.mAudioManager.isStreamMute(Integer.MIN_VALUE) == false) goto L5;
        int color = -1;
    L6:
        int i = 0;
    L8:
        if (i >= this.mKeyboardsWithVolumeMuteLed.size()) goto L16;
        InputDevice device = this.mKeyboardsWithVolumeMuteLed.valueAt(i);
        if (device == null) goto L14;
        int deviceId = device.getId();
        Light light = getKeyboardVolumeMuteLight(device);
        if (light == null) goto L14;
        this.mNative.setLightColor(deviceId, light.getId(), color);
    L14:
        i = i + 1;
        goto L8
    L16:
        return;
    L5:
        color = 0;
        goto L6
    }

    private Light getKeyboardMicMuteLight(InputDevice device) {
        Iterator<Light> r0 = device.getLightsManager().getLights().iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        Light light = r0.next();
        if (light.getType() != 10004) goto L4;
        if (light.hasBrightnessControl() == false) goto L4;
        return light;
    L11:
        return null;
    }

    private Light getKeyboardVolumeMuteLight(InputDevice device) {
        Iterator<Light> r0 = device.getLightsManager().getLights().iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        Light light = r0.next();
        if (light.getType() != 10005) goto L4;
        if (light.hasBrightnessControl() == false) goto L4;
        return light;
    L11:
        return null;
    }

    public void systemRunning() {
        SensorPrivacyManager r0 = (SensorPrivacyManager) this.mContext.getSystemService(SensorPrivacyManager.class);
        r0.getClass();
        this.mSensorPrivacyManager = r0;
        InputManager r1 = (InputManager) this.mContext.getSystemService(InputManager.class);
        r1.getClass();
        this.mInputManager = r1;
        AudioManager r2 = (AudioManager) this.mContext.getSystemService(AudioManager.class);
        r2.getClass();
        this.mAudioManager = r2;
        this.mInputManager.registerInputDeviceListener(this, this.mHandler);
        Message msg = Message.obtain(this.mHandler, 1, this.mInputManager.getInputDeviceIds());
        this.mHandler.sendMessage(msg);
        this.mContext.registerReceiverAsUser(this.mMicrophoneMuteChangedIntentReceiver, UserHandle.ALL, new IntentFilter("android.media.action.MICROPHONE_MUTE_CHANGED"), null, this.mHandler);
        this.mContext.registerReceiverAsUser(this.mVolumeMuteIntentReceiver, UserHandle.ALL, new IntentFilter("android.media.STREAM_MUTE_CHANGED_ACTION"), null, this.mHandler);
    }

    @Override // android.hardware.input.InputManager.InputDeviceListener
    public void onInputDeviceAdded(int deviceId) {
        onInputDeviceChanged(deviceId);
    }

    @Override // android.hardware.input.InputManager.InputDeviceListener
    public void onInputDeviceRemoved(int deviceId) {
        this.mKeyboardsWithMicMuteLed.remove(deviceId);
        this.mKeyboardsWithVolumeMuteLed.remove(deviceId);
    }

    @Override // android.hardware.input.InputManager.InputDeviceListener
    public void onInputDeviceChanged(int deviceId) {
        InputDevice inputDevice = this.mInputManager.getInputDevice(deviceId);
        if (inputDevice != null) goto L6;
        return;
    L6:
        if (getKeyboardMicMuteLight(inputDevice) == null) goto L9;
        this.mKeyboardsWithMicMuteLed.put(deviceId, inputDevice);
        Message msg = Message.obtain(this.mHandler, 2);
        this.mHandler.sendMessage(msg);
    L9:
        if (getKeyboardVolumeMuteLight(inputDevice) == null) goto L12;
        this.mKeyboardsWithVolumeMuteLed.put(deviceId, inputDevice);
        Message msg2 = Message.obtain(this.mHandler, 3);
        this.mHandler.sendMessage(msg2);
        return;
    }

    public void dump(PrintWriter pw) {
        IndentingPrintWriter ipw = new IndentingPrintWriter(pw);
        ipw.println(TAG + ": " + this.mKeyboardsWithMicMuteLed.size() + " keyboard mic mute lights");
        ipw.increaseIndent();
        int i = 0;
    L4:
        if (i >= this.mKeyboardsWithMicMuteLed.size()) goto L6;
        InputDevice inputDevice = this.mKeyboardsWithMicMuteLed.valueAt(i);
        ipw.println(i + " " + inputDevice.getName() + ": " + getKeyboardMicMuteLight(inputDevice).toString());
        i = i + 1;
        goto L4
    L6:
        ipw.decreaseIndent();
        ipw.println(TAG + ": " + this.mKeyboardsWithVolumeMuteLed.size() + " keyboard volume mute lights");
        ipw.increaseIndent();
        int i2 = 0;
    L8:
        if (i2 >= this.mKeyboardsWithVolumeMuteLed.size()) goto L10;
        InputDevice inputDevice2 = this.mKeyboardsWithVolumeMuteLed.valueAt(i2);
        ipw.println(i2 + " " + inputDevice2.getName() + ": " + getKeyboardVolumeMuteLight(inputDevice2).toString());
        i2 = i2 + 1;
        goto L8
    L10:
        ipw.decreaseIndent();
    }
}
