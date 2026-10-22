package com.android.server.input;

import android.hardware.display.DisplayTopologyGraph;
import android.hardware.display.DisplayViewport;
import android.hardware.input.InputSensorInfo;
import android.hardware.lights.Light;
import android.os.IBinder;
import android.os.MessageQueue;
import android.util.SparseArray;
import android.view.InputApplicationHandle;
import android.view.InputChannel;
import android.view.InputEvent;
import android.view.PointerIcon;
import android.view.VerifiedInputEvent;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
interface NativeInputManagerService {

    public static class NativeImpl implements NativeInputManagerService {
        private final long mPtr;

        private native long init(InputManagerService r1, MessageQueue r2);

        @Override // com.android.server.input.NativeInputManagerService
        public native boolean canDispatchToDisplay(int r1, int r2);

        @Override // com.android.server.input.NativeInputManagerService
        public native void cancelCurrentTouch();

        @Override // com.android.server.input.NativeInputManagerService
        public native void cancelVibrate(int r1, int r2);

        @Override // com.android.server.input.NativeInputManagerService
        public native void changeKeyboardLayoutAssociation();

        @Override // com.android.server.input.NativeInputManagerService
        public native void changeTypeAssociation();

        @Override // com.android.server.input.NativeInputManagerService
        public native void changeUniqueIdAssociation();

        @Override // com.android.server.input.NativeInputManagerService
        public native InputChannel createInputChannel(String r1);

        @Override // com.android.server.input.NativeInputManagerService
        public native InputChannel createInputMonitor(int r1, String r2, int r3);

        @Override // com.android.server.input.NativeInputManagerService
        public native void disableInputDevice(int r1);

        @Override // com.android.server.input.NativeInputManagerService
        public native void disableSensor(int r1, int r2);

        @Override // com.android.server.input.NativeInputManagerService
        public native void displayRemoved(int r1);

        @Override // com.android.server.input.NativeInputManagerService
        public native String dump();

        @Override // com.android.server.input.NativeInputManagerService
        public native void enableInputDevice(int r1);

        @Override // com.android.server.input.NativeInputManagerService
        public native boolean enableSensor(int r1, int r2, int r3, int r4);

        @Override // com.android.server.input.NativeInputManagerService
        public native boolean flushSensor(int r1, int r2);

        @Override // com.android.server.input.NativeInputManagerService
        public native int getBatteryCapacity(int r1);

        @Override // com.android.server.input.NativeInputManagerService
        public native String getBatteryDevicePath(int r1);

        @Override // com.android.server.input.NativeInputManagerService
        public native int getBatteryStatus(int r1);

        @Override // com.android.server.input.NativeInputManagerService
        public native String getBluetoothAddress(int r1);

        @Override // com.android.server.input.NativeInputManagerService
        public native int getKeyCodeForKeyLocation(int r1, int r2);

        @Override // com.android.server.input.NativeInputManagerService
        public native int getKeyCodeState(int r1, int r2, int r3);

        @Override // com.android.server.input.NativeInputManagerService
        public native int getLastUsedInputDeviceId();

        @Override // com.android.server.input.NativeInputManagerService
        public native int getLightColor(int r1, int r2);

        @Override // com.android.server.input.NativeInputManagerService
        public native int getLightPlayerId(int r1, int r2);

        @Override // com.android.server.input.NativeInputManagerService
        public native List<Light> getLights(int r1);

        @Override // com.android.server.input.NativeInputManagerService
        public native float[] getMouseCursorPosition(int r1);

        @Override // com.android.server.input.NativeInputManagerService
        public native int getMousePointerSpeed();

        @Override // com.android.server.input.NativeInputManagerService
        public native int getScanCodeState(int r1, int r2, int r3);

        @Override // com.android.server.input.NativeInputManagerService
        public native InputSensorInfo[] getSensorList(int r1);

        @Override // com.android.server.input.NativeInputManagerService
        public native int getSwitchState(int r1, int r2, int r3);

        @Override // com.android.server.input.NativeInputManagerService
        public native String getSysfsRootPath(int r1);

        @Override // com.android.server.input.NativeInputManagerService
        public native TouchpadHardwareProperties getTouchpadHardwareProperties(int r1);

        @Override // com.android.server.input.NativeInputManagerService
        public native int[] getVibratorIds(int r1);

        @Override // com.android.server.input.NativeInputManagerService
        public native boolean hasKeys(int r1, int r2, int[] r3, boolean[] r4);

        @Override // com.android.server.input.NativeInputManagerService
        public native int injectInputEvent(InputEvent r1, boolean r2, int r3, int r4, int r5, int r6);

        @Override // com.android.server.input.NativeInputManagerService
        public native boolean isVibrating(int r1);

        @Override // com.android.server.input.NativeInputManagerService
        public native void monitor();

        @Override // com.android.server.input.NativeInputManagerService
        public native void notifyPortAssociationsChanged();

        @Override // com.android.server.input.NativeInputManagerService
        public native void pilferPointers(IBinder r1);

        @Override // com.android.server.input.NativeInputManagerService
        public native void reloadCalibration();

        @Override // com.android.server.input.NativeInputManagerService
        public native void reloadDeviceAliases();

        @Override // com.android.server.input.NativeInputManagerService
        public native void reloadKeyboardLayouts();

        @Override // com.android.server.input.NativeInputManagerService
        public native void reloadPointerIcons();

        @Override // com.android.server.input.NativeInputManagerService
        public native void removeInputChannel(IBinder r1);

        @Override // com.android.server.input.NativeInputManagerService
        public native void requestPointerCapture(IBinder r1, boolean r2);

        @Override // com.android.server.input.NativeInputManagerService
        public native void resetLockedModifierState();

        @Override // com.android.server.input.NativeInputManagerService
        public native void setAccessibilityBounceKeysThreshold(int r1);

        @Override // com.android.server.input.NativeInputManagerService
        public native void setAccessibilityPointerMotionFilterEnabled(boolean r1);

        @Override // com.android.server.input.NativeInputManagerService
        public native void setAccessibilitySlowKeysThreshold(int r1);

        @Override // com.android.server.input.NativeInputManagerService
        public native void setAccessibilityStickyKeysEnabled(boolean r1);

        @Override // com.android.server.input.NativeInputManagerService
        public native void setDisplayEligibilityForPointerCapture(int r1, boolean r2);

        @Override // com.android.server.input.NativeInputManagerService
        public native void setDisplayTopology(DisplayTopologyGraph r1);

        @Override // com.android.server.input.NativeInputManagerService
        public native void setDisplayViewports(DisplayViewport[] r1);

        @Override // com.android.server.input.NativeInputManagerService
        public native void setFocusedApplication(int r1, InputApplicationHandle r2);

        @Override // com.android.server.input.NativeInputManagerService
        public native void setFocusedDisplay(int r1);

        @Override // com.android.server.input.NativeInputManagerService
        public native boolean setInTouchMode(boolean r1, int r2, int r3, boolean r4, int r5);

        @Override // com.android.server.input.NativeInputManagerService
        public native void setInputDispatchMode(boolean r1, boolean r2);

        @Override // com.android.server.input.NativeInputManagerService
        public native void setInputFilterEnabled(boolean r1);

        @Override // com.android.server.input.NativeInputManagerService
        public native void setInputMethodConnectionIsActive(boolean r1);

        @Override // com.android.server.input.NativeInputManagerService
        public native boolean setKernelWakeEnabled(int r1, boolean r2);

        @Override // com.android.server.input.NativeInputManagerService
        public native void setKeyRemapping(int[] r1, int[] r2);

        @Override // com.android.server.input.NativeInputManagerService
        public native void setKeyRepeatConfiguration(int r1, int r2, boolean r3);

        @Override // com.android.server.input.NativeInputManagerService
        public native void setLightColor(int r1, int r2, int r3);

        @Override // com.android.server.input.NativeInputManagerService
        public native void setLightPlayerId(int r1, int r2, int r3);

        @Override // com.android.server.input.NativeInputManagerService
        public native void setMaximumObscuringOpacityForTouch(float r1);

        @Override // com.android.server.input.NativeInputManagerService
        public native void setMinTimeBetweenUserActivityPokes(long r1);

        @Override // com.android.server.input.NativeInputManagerService
        public native void setMotionClassifierEnabled(boolean r1);

        @Override // com.android.server.input.NativeInputManagerService
        public native void setMouseAccelerationEnabled(boolean r1);

        @Override // com.android.server.input.NativeInputManagerService
        public native void setMouseReverseVerticalScrollingEnabled(boolean r1);

        @Override // com.android.server.input.NativeInputManagerService
        public native void setMouseScalingEnabled(int r1, boolean r2);

        @Override // com.android.server.input.NativeInputManagerService
        public native void setMouseScrollingAccelerationEnabled(boolean r1);

        @Override // com.android.server.input.NativeInputManagerService
        public native void setMouseScrollingSpeed(int r1);

        @Override // com.android.server.input.NativeInputManagerService
        public native void setMouseSwapPrimaryButtonEnabled(boolean r1);

        @Override // com.android.server.input.NativeInputManagerService
        public native void setNonInteractiveDisplays(int[] r1);

        @Override // com.android.server.input.NativeInputManagerService
        public native void setPointerDisplayId(int r1);

        @Override // com.android.server.input.NativeInputManagerService
        public native boolean setPointerIcon(PointerIcon r1, int r2, int r3, int r4, IBinder r5);

        @Override // com.android.server.input.NativeInputManagerService
        public native void setPointerIconVisibility(int r1, boolean r2);

        @Override // com.android.server.input.NativeInputManagerService
        public native void setPointerSpeed(int r1);

        @Override // com.android.server.input.NativeInputManagerService
        public native void setShouldNotifyTouchpadHardwareState(boolean r1);

        @Override // com.android.server.input.NativeInputManagerService
        public native void setShowTouches(boolean r1);

        @Override // com.android.server.input.NativeInputManagerService
        public native void setStylusButtonMotionEventsEnabled(boolean r1);

        @Override // com.android.server.input.NativeInputManagerService
        public native void setStylusPointerIconEnabled(boolean r1);

        @Override // com.android.server.input.NativeInputManagerService
        public native void setSystemUiLightsOut(boolean r1);

        @Override // com.android.server.input.NativeInputManagerService
        public native void setTouchpadAccelerationEnabled(boolean r1);

        @Override // com.android.server.input.NativeInputManagerService
        public native void setTouchpadNaturalScrollingEnabled(boolean r1);

        @Override // com.android.server.input.NativeInputManagerService
        public native void setTouchpadPointerSpeed(int r1);

        @Override // com.android.server.input.NativeInputManagerService
        public native void setTouchpadRightClickZoneEnabled(boolean r1);

        @Override // com.android.server.input.NativeInputManagerService
        public native void setTouchpadSystemGesturesEnabled(boolean r1);

        @Override // com.android.server.input.NativeInputManagerService
        public native void setTouchpadTapDraggingEnabled(boolean r1);

        @Override // com.android.server.input.NativeInputManagerService
        public native void setTouchpadTapToClickEnabled(boolean r1);

        @Override // com.android.server.input.NativeInputManagerService
        public native void setTouchpadThreeFingerTapShortcutEnabled(boolean r1);

        @Override // com.android.server.input.NativeInputManagerService
        public native void start();

        @Override // com.android.server.input.NativeInputManagerService
        public native void sysfsNodeChanged(String r1);

        @Override // com.android.server.input.NativeInputManagerService
        public native void toggleCapsLock(int r1);

        @Override // com.android.server.input.NativeInputManagerService
        @Deprecated
        public native boolean transferTouch(IBinder r1, int r2);

        @Override // com.android.server.input.NativeInputManagerService
        public native boolean transferTouchGesture(IBinder r1, IBinder r2, boolean r3, boolean r4);

        @Override // com.android.server.input.NativeInputManagerService
        public native VerifiedInputEvent verifyInputEvent(InputEvent r1);

        @Override // com.android.server.input.NativeInputManagerService
        public native void vibrate(int r1, long[] r2, int[] r3, int r4, int r5);

        @Override // com.android.server.input.NativeInputManagerService
        public native void vibrateCombined(int r1, long[] r2, SparseArray<int[]> r3, int r4, int r5);

        NativeImpl(InputManagerService service, MessageQueue messageQueue) {
            this.mPtr = init(service, messageQueue);
        }
    }

    boolean canDispatchToDisplay(int r1, int r2);

    void cancelCurrentTouch();

    void cancelVibrate(int r1, int r2);

    void changeKeyboardLayoutAssociation();

    void changeTypeAssociation();

    void changeUniqueIdAssociation();

    InputChannel createInputChannel(String r1);

    InputChannel createInputMonitor(int r1, String r2, int r3);

    void disableInputDevice(int r1);

    void disableSensor(int r1, int r2);

    void displayRemoved(int r1);

    String dump();

    void enableInputDevice(int r1);

    boolean enableSensor(int r1, int r2, int r3, int r4);

    boolean flushSensor(int r1, int r2);

    int getBatteryCapacity(int r1);

    String getBatteryDevicePath(int r1);

    int getBatteryStatus(int r1);

    String getBluetoothAddress(int r1);

    int getKeyCodeForKeyLocation(int r1, int r2);

    int getKeyCodeState(int r1, int r2, int r3);

    int getLastUsedInputDeviceId();

    int getLightColor(int r1, int r2);

    int getLightPlayerId(int r1, int r2);

    List<Light> getLights(int r1);

    float[] getMouseCursorPosition(int r1);

    int getMousePointerSpeed();

    int getScanCodeState(int r1, int r2, int r3);

    InputSensorInfo[] getSensorList(int r1);

    int getSwitchState(int r1, int r2, int r3);

    String getSysfsRootPath(int r1);

    TouchpadHardwareProperties getTouchpadHardwareProperties(int r1);

    int[] getVibratorIds(int r1);

    boolean hasKeys(int r1, int r2, int[] r3, boolean[] r4);

    int injectInputEvent(InputEvent r1, boolean r2, int r3, int r4, int r5, int r6);

    boolean isVibrating(int r1);

    void monitor();

    void notifyPortAssociationsChanged();

    void pilferPointers(IBinder r1);

    void reloadCalibration();

    void reloadDeviceAliases();

    void reloadKeyboardLayouts();

    void reloadPointerIcons();

    void removeInputChannel(IBinder r1);

    void requestPointerCapture(IBinder r1, boolean r2);

    void resetLockedModifierState();

    void setAccessibilityBounceKeysThreshold(int r1);

    void setAccessibilityPointerMotionFilterEnabled(boolean r1);

    void setAccessibilitySlowKeysThreshold(int r1);

    void setAccessibilityStickyKeysEnabled(boolean r1);

    void setDisplayEligibilityForPointerCapture(int r1, boolean r2);

    void setDisplayTopology(DisplayTopologyGraph r1);

    void setDisplayViewports(DisplayViewport[] r1);

    void setFocusedApplication(int r1, InputApplicationHandle r2);

    void setFocusedDisplay(int r1);

    boolean setInTouchMode(boolean r1, int r2, int r3, boolean r4, int r5);

    void setInputDispatchMode(boolean r1, boolean r2);

    void setInputFilterEnabled(boolean r1);

    void setInputMethodConnectionIsActive(boolean r1);

    boolean setKernelWakeEnabled(int r1, boolean r2);

    void setKeyRemapping(int[] r1, int[] r2);

    void setKeyRepeatConfiguration(int r1, int r2, boolean r3);

    void setLightColor(int r1, int r2, int r3);

    void setLightPlayerId(int r1, int r2, int r3);

    void setMaximumObscuringOpacityForTouch(float r1);

    void setMinTimeBetweenUserActivityPokes(long r1);

    void setMotionClassifierEnabled(boolean r1);

    void setMouseAccelerationEnabled(boolean r1);

    void setMouseReverseVerticalScrollingEnabled(boolean r1);

    void setMouseScalingEnabled(int r1, boolean r2);

    void setMouseScrollingAccelerationEnabled(boolean r1);

    void setMouseScrollingSpeed(int r1);

    void setMouseSwapPrimaryButtonEnabled(boolean r1);

    void setNonInteractiveDisplays(int[] r1);

    void setPointerDisplayId(int r1);

    boolean setPointerIcon(PointerIcon r1, int r2, int r3, int r4, IBinder r5);

    void setPointerIconVisibility(int r1, boolean r2);

    void setPointerSpeed(int r1);

    void setShouldNotifyTouchpadHardwareState(boolean r1);

    void setShowTouches(boolean r1);

    void setStylusButtonMotionEventsEnabled(boolean r1);

    void setStylusPointerIconEnabled(boolean r1);

    void setSystemUiLightsOut(boolean r1);

    void setTouchpadAccelerationEnabled(boolean r1);

    void setTouchpadNaturalScrollingEnabled(boolean r1);

    void setTouchpadPointerSpeed(int r1);

    void setTouchpadRightClickZoneEnabled(boolean r1);

    void setTouchpadSystemGesturesEnabled(boolean r1);

    void setTouchpadTapDraggingEnabled(boolean r1);

    void setTouchpadTapToClickEnabled(boolean r1);

    void setTouchpadThreeFingerTapShortcutEnabled(boolean r1);

    void start();

    void sysfsNodeChanged(String r1);

    void toggleCapsLock(int r1);

    @Deprecated
    boolean transferTouch(IBinder r1, int r2);

    boolean transferTouchGesture(IBinder r1, IBinder r2, boolean r3, boolean r4);

    VerifiedInputEvent verifyInputEvent(InputEvent r1);

    void vibrate(int r1, long[] r2, int[] r3, int r4, int r5);

    void vibrateCombined(int r1, long[] r2, SparseArray<int[]> r3, int r4, int r5);
}
