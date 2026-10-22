package com.android.server.accessibility;

import android.companion.virtual.VirtualDeviceManager;
import android.companion.virtual.VirtualDeviceParams;
import android.hardware.input.InputManager;
import android.hardware.input.VirtualMouse;
import android.hardware.input.VirtualMouseButtonEvent;
import android.hardware.input.VirtualMouseConfig;
import android.hardware.input.VirtualMouseRelativeEvent;
import android.hardware.input.VirtualMouseScrollEvent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.MathUtils;
import android.util.Slog;
import android.util.SparseArray;
import android.view.InputDevice;
import android.view.KeyEvent;
import com.android.server.LocalServices;
import com.android.server.companion.virtual.VirtualDeviceManagerInternal;

/* JADX INFO: loaded from: classes.dex */
public class MouseKeysInterceptor extends BaseEventStreamTransformation implements Handler.Callback, InputManager.InputDeviceListener {
    private static final boolean DEBUG = false;
    private static final int INTERVAL_MILLIS = 10;
    private static final int KEY_NOT_SET = -1;
    private static final String LOG_TAG = "MouseKeysInterceptor";
    private static final int MESSAGE_MOVE_MOUSE_POINTER = 1;
    private static final int MESSAGE_SCROLL_MOUSE_POINTER = 2;
    public static final float MOUSE_POINTER_MOVEMENT_STEP = 1.8f;
    public static final float MOUSE_SCROLL_STEP = 0.2f;
    private int mActiveInputDeviceId;
    private int mActiveMoveKey;
    private int mActiveScrollKey;
    private final AccessibilityManagerService mAms;
    private final Thread mCreateVirtualMouseThread;
    private final SparseArray<SparseArray<MouseKeyEvent>> mDeviceKeyCodeMap;
    private final Handler mHandler;
    private final InputManager mInputManager;
    private long mLastTimeKeyActionPerformed;
    private boolean mScrollToggleOn;
    VirtualDeviceManager.VirtualDevice mVirtualDevice;
    private VirtualMouse mVirtualMouse;

    public static final enum MouseKeyEvent extends Enum<MouseKeyEvent> {
        private static final /* synthetic */ MouseKeyEvent[] $VALUES = null;
        public static final MouseKeyEvent DIAGONAL_DOWN_LEFT_MOVE = null;
        public static final MouseKeyEvent DIAGONAL_DOWN_RIGHT_MOVE = null;
        public static final MouseKeyEvent DIAGONAL_UP_LEFT_MOVE = null;
        public static final MouseKeyEvent DIAGONAL_UP_RIGHT_MOVE = null;
        public static final MouseKeyEvent DOWN_MOVE_OR_SCROLL = null;
        public static final MouseKeyEvent HOLD = null;
        public static final MouseKeyEvent LEFT_CLICK = null;
        public static final MouseKeyEvent LEFT_MOVE_OR_SCROLL = null;
        public static final MouseKeyEvent RELEASE = null;
        public static final MouseKeyEvent RIGHT_CLICK = null;
        public static final MouseKeyEvent RIGHT_MOVE_OR_SCROLL = null;
        public static final MouseKeyEvent SCROLL_TOGGLE = null;
        public static final MouseKeyEvent UP_MOVE_OR_SCROLL = null;
        private final int mLocationKeyCode;

        private static /* synthetic */ MouseKeyEvent[] $values() {
            return new MouseKeyEvent[]{DIAGONAL_UP_LEFT_MOVE, UP_MOVE_OR_SCROLL, DIAGONAL_UP_RIGHT_MOVE, LEFT_MOVE_OR_SCROLL, RIGHT_MOVE_OR_SCROLL, DIAGONAL_DOWN_LEFT_MOVE, DOWN_MOVE_OR_SCROLL, DIAGONAL_DOWN_RIGHT_MOVE, LEFT_CLICK, RIGHT_CLICK, HOLD, RELEASE, SCROLL_TOGGLE};
        }

        public static MouseKeyEvent valueOf(String name) {
            return (MouseKeyEvent) Enum.valueOf(MouseKeyEvent.class, name);
        }

        public static MouseKeyEvent[] values() {
            return (MouseKeyEvent[]) $VALUES.clone();
        }

        static {
            DIAGONAL_UP_LEFT_MOVE = new MouseKeyEvent("DIAGONAL_UP_LEFT_MOVE", 0, 14);
            UP_MOVE_OR_SCROLL = new MouseKeyEvent("UP_MOVE_OR_SCROLL", 1, 15);
            DIAGONAL_UP_RIGHT_MOVE = new MouseKeyEvent("DIAGONAL_UP_RIGHT_MOVE", 2, 16);
            LEFT_MOVE_OR_SCROLL = new MouseKeyEvent("LEFT_MOVE_OR_SCROLL", 3, 49);
            RIGHT_MOVE_OR_SCROLL = new MouseKeyEvent("RIGHT_MOVE_OR_SCROLL", 4, 43);
            DIAGONAL_DOWN_LEFT_MOVE = new MouseKeyEvent("DIAGONAL_DOWN_LEFT_MOVE", 5, 38);
            DOWN_MOVE_OR_SCROLL = new MouseKeyEvent("DOWN_MOVE_OR_SCROLL", 6, 39);
            DIAGONAL_DOWN_RIGHT_MOVE = new MouseKeyEvent("DIAGONAL_DOWN_RIGHT_MOVE", 7, 40);
            LEFT_CLICK = new MouseKeyEvent("LEFT_CLICK", 8, 37);
            RIGHT_CLICK = new MouseKeyEvent("RIGHT_CLICK", 9, 76);
            HOLD = new MouseKeyEvent("HOLD", 10, 41);
            RELEASE = new MouseKeyEvent("RELEASE", 11, 55);
            SCROLL_TOGGLE = new MouseKeyEvent("SCROLL_TOGGLE", 12, 56);
            $VALUES = $values();
        }

        private MouseKeyEvent(String r1, int r2, int enumValue) {
            super(r1, r2);
            this.mLocationKeyCode = enumValue;
        }

        public final int getKeyCodeValue() {
            return this.mLocationKeyCode;
        }

        public int getKeyCode(InputDevice inputDevice) {
            if (inputDevice.getGeneration() != (-1)) goto L7;
            return this.mLocationKeyCode;
        L7:
            return inputDevice.getKeyCodeForKeyLocation(this.mLocationKeyCode);
        }

        public static MouseKeyEvent from(int keyCode, int deviceId, SparseArray<SparseArray<MouseKeyEvent>> deviceKeyCodeMap) {
            SparseArray<MouseKeyEvent> keyCodeToEnumMap = deviceKeyCodeMap.get(deviceId);
            if (keyCodeToEnumMap != null) goto L5;
            return null;
        L5:
            return keyCodeToEnumMap.get(keyCode);
        }
    }

    public static /* synthetic */ void $r8$lambda$bmlvUec6jxm8e9vAdANaoGIFYyk(MouseKeysInterceptor r0, KeyEvent r1, int r2) {
        r0.lambda$onKeyEvent$1(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$dSqd1rgrVUZV5NMqrkklERpGuZ0(MouseKeysInterceptor r0, int r1) {
        r0.lambda$new$0(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$wk5OZrrrRXLaJvhXFs3Q-lNgiRo, reason: not valid java name */
    public static /* synthetic */ void m722$r8$lambda$wk5OZrrrRXLaJvhXFs3QlNgiRo(MouseKeysInterceptor r0) {
        r0.lambda$onDestroy$2();
    }

    static {
        DEBUG = Log.isLoggable(LOG_TAG, 3);
    }

    public void initializeDeviceToEnumMap(InputDevice inputDevice) {
        int deviceId = inputDevice.getId();
        SparseArray<MouseKeyEvent> keyCodeToEnumMap = new SparseArray();
        MouseKeyEvent[] r2 = MouseKeyEvent.values();
        int r3 = r2.length;
        int r4 = 0;
    L3:
        if (r4 >= r3) goto L5;
        MouseKeyEvent mouseKeyEventType = r2[r4];
        int keyCode = mouseKeyEventType.getKeyCode(inputDevice);
        keyCodeToEnumMap.put(keyCode, mouseKeyEventType);
        r4 = r4 + 1;
        goto L3
    L5:
        this.mDeviceKeyCodeMap.put(deviceId, keyCodeToEnumMap);
    }

    public MouseKeysInterceptor(AccessibilityManagerService service, InputManager inputManager, Looper looper, final int displayId) {
        this.mDeviceKeyCodeMap = new SparseArray();
        this.mVirtualDevice = null;
        this.mVirtualMouse = null;
        this.mActiveMoveKey = -1;
        this.mActiveScrollKey = -1;
        this.mLastTimeKeyActionPerformed = 0;
        this.mScrollToggleOn = false;
        this.mActiveInputDeviceId = 0;
        this.mAms = service;
        this.mInputManager = inputManager;
        this.mHandler = new Handler(looper, this);
        this.mCreateVirtualMouseThread = new Thread(new MouseKeysInterceptor$$ExternalSyntheticLambda0(this, displayId));
        this.mCreateVirtualMouseThread.start();
        this.mInputManager.registerInputDeviceListener(this, this.mHandler);
    }

    private /* synthetic */ void lambda$new$0(int displayId) {
        this.mVirtualMouse = createVirtualMouse(displayId);
    }

    private void waitForVirtualMouseCreation() {
        this.mCreateVirtualMouseThread.join();     // Catch: InterruptedException -> L4
        return;
    L4:
        e = move-exception;
        Thread.currentThread().interrupt();
        throw new RuntimeException(e);
    }

    private void sendVirtualMouseRelativeEvent(float x, float y) {
        waitForVirtualMouseCreation();
        this.mVirtualMouse.sendRelativeEvent(new VirtualMouseRelativeEvent.Builder().setRelativeX(x).setRelativeY(y).build());
    }

    private void sendVirtualMouseButtonEvent(int buttonCode, int actionCode) {
        waitForVirtualMouseCreation();
        this.mVirtualMouse.sendButtonEvent(new VirtualMouseButtonEvent.Builder().setAction(actionCode).setButtonCode(buttonCode).build());
    }

    private void sendVirtualMouseScrollEvent(float x, float y) {
        waitForVirtualMouseCreation();
        this.mVirtualMouse.sendScrollEvent(new VirtualMouseScrollEvent.Builder().setXAxisMovement(x).setYAxisMovement(y).build());
    }

    private void performMouseScrollAction(int keyCode) {
        MouseKeyEvent mouseKeyEvent = MouseKeyEvent.from(keyCode, this.mActiveInputDeviceId, this.mDeviceKeyCodeMap);
        float x = 0.0f;
        float y = 0.0f;
        switch(mouseKeyEvent.ordinal()) {
            case 1: goto L8;
            case 2: goto L4;
            case 3: goto L7;
            case 4: goto L6;
            case 5: goto L4;
            case 6: goto L5;
            default: goto L4;
        };
    L4:
        x = 0.0f;
        y = 0.0f;
    L9:
        sendVirtualMouseScrollEvent(x, y);
        if (DEBUG == false) goto L13;
        Slog.d(LOG_TAG, "Performed mouse key event: " + mouseKeyEvent.name() + " for scroll action with axis movement (x=" + x + ", y=" + y + ")");
        return;
    L13:
        return;
    L5:
        y = -0.2f;
        goto L9
    L6:
        x = -0.2f;
        goto L9
    L7:
        x = 0.2f;
        goto L9
    L8:
        y = 0.2f;
        goto L9
    }

    private void performMouseButtonAction(int keyCode) {
        MouseKeyEvent mouseKeyEvent = MouseKeyEvent.from(keyCode, this.mActiveInputDeviceId, this.mDeviceKeyCodeMap);
        switch(mouseKeyEvent.ordinal()) {
            case 8: goto L6;
            case 9: goto L5;
            default: goto L4;
        };
    L4:
        int buttonCode = -1;
    L8:
        if (buttonCode == (-1)) goto L11;
        sendVirtualMouseButtonEvent(buttonCode, 11);
        sendVirtualMouseButtonEvent(buttonCode, 12);
    L11:
        if (DEBUG == true) goto L13;
        return;
    L13:
        if (buttonCode != (-1)) goto L15;
        Slog.d(LOG_TAG, "Button code is unknown for mouse key event: " + mouseKeyEvent.name());
        return;
    L15:
        Slog.d(LOG_TAG, "Performed mouse key event: " + mouseKeyEvent.name() + " for button action");
        return;
    L5:
        buttonCode = 2;
        goto L8
    L6:
        buttonCode = 1;
        goto L8
    }

    private void performMousePointerAction(int keyCode) {
        float x = 0.0f;
        float y = 0.0f;
        MouseKeyEvent mouseKeyEvent = MouseKeyEvent.from(keyCode, this.mActiveInputDeviceId, this.mDeviceKeyCodeMap);
        switch(mouseKeyEvent.ordinal()) {
            case 0: goto L16;
            case 1: goto L14;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L7;
            case 7: goto L5;
            default: goto L4;
        };
    L4:
        x = 0.0f;
        y = 0.0f;
    L17:
        sendVirtualMouseRelativeEvent(x, y);
        if (DEBUG == false) goto L21;
        Slog.d(LOG_TAG, "Performed mouse key event: " + mouseKeyEvent.name() + " for relative pointer movement (x=" + x + ", y=" + y + ")");
        return;
    L21:
        return;
    L5:
        x = 1.8f / MathUtils.sqrt(2.0f);
        y = 1.8f / MathUtils.sqrt(2.0f);
        goto L17
    L9:
        x = (-1.8f) / MathUtils.sqrt(2.0f);
        y = 1.8f / MathUtils.sqrt(2.0f);
        goto L17
    L10:
        x = 1.8f;
        goto L17
    L11:
        x = -1.8f;
        goto L17
    L12:
        x = 1.8f / MathUtils.sqrt(2.0f);
        y = (-1.8f) / MathUtils.sqrt(2.0f);
        goto L17
    L16:
        x = (-1.8f) / MathUtils.sqrt(2.0f);
        y = (-1.8f) / MathUtils.sqrt(2.0f);
        goto L17
    L7:
        if (this.mScrollToggleOn == true) goto L17;
        y = 1.8f;
        goto L17
    L14:
        if (this.mScrollToggleOn == true) goto L17;
        y = -1.8f;
        goto L17
    }

    private boolean isMouseKey(int keyCode, int deviceId) {
        SparseArray<MouseKeyEvent> keyCodeToEnumMap = this.mDeviceKeyCodeMap.get(deviceId);
        return keyCodeToEnumMap.contains(keyCode);
    }

    private boolean isMouseButtonKey(int keyCode, InputDevice inputDevice) {
        if (keyCode != MouseKeyEvent.LEFT_CLICK.getKeyCode(inputDevice)) goto L5;
    L8:
        return true;
    L5:
        if (keyCode == MouseKeyEvent.RIGHT_CLICK.getKeyCode(inputDevice)) goto L8;
        return false;
    }

    private boolean isMouseScrollKey(int keyCode, InputDevice inputDevice) {
        if (keyCode != MouseKeyEvent.UP_MOVE_OR_SCROLL.getKeyCode(inputDevice)) goto L5;
    L12:
        return true;
    L5:
        if (keyCode == MouseKeyEvent.DOWN_MOVE_OR_SCROLL.getKeyCode(inputDevice)) goto L12;
        if (keyCode == MouseKeyEvent.LEFT_MOVE_OR_SCROLL.getKeyCode(inputDevice)) goto L12;
        if (keyCode == MouseKeyEvent.RIGHT_MOVE_OR_SCROLL.getKeyCode(inputDevice)) goto L12;
        return false;
    }

    private VirtualMouse createVirtualMouse(int displayId) {
        VirtualDeviceManagerInternal localVdm = (VirtualDeviceManagerInternal) LocalServices.getService(VirtualDeviceManagerInternal.class);
        this.mVirtualDevice = localVdm.createVirtualDevice(new VirtualDeviceParams.Builder().setName("Mouse Keys Virtual Device").build());
        VirtualMouse virtualMouse = this.mVirtualDevice.createVirtualMouse(new VirtualMouseConfig.Builder().setInputDeviceName("Mouse Keys Virtual Mouse").setAssociatedDisplayId(displayId).build());
        return virtualMouse;
    }

    @Override // com.android.server.accessibility.EventStreamTransformation
    public void onKeyEvent(final KeyEvent event, final int policyFlags) {
        if (this.mAms.getTraceManager().isA11yTracingEnabledForTypes(4096) == false) goto L5;
        this.mAms.getTraceManager().logTrace("MouseKeysInterceptor.onKeyEvent", 4096, "event=" + event + ";policyFlags=" + policyFlags);
    L5:
        this.mHandler.post(new MouseKeysInterceptor$$ExternalSyntheticLambda1(this, event, policyFlags));
    }

    private /* synthetic */ void lambda$onKeyEvent$1(KeyEvent event, int policyFlags) {
        onKeyEventInternal(event, policyFlags);
    }

    private void onKeyEventInternal(KeyEvent event, int policyFlags) {
        if (event.getAction() != 0) goto L5;
        boolean isDown = true;
    L6:
        int keyCode = event.getKeyCode();
        this.mActiveInputDeviceId = event.getDeviceId();
        InputDevice inputDevice = this.mInputManager.getInputDevice(this.mActiveInputDeviceId);
        if (this.mDeviceKeyCodeMap.contains(this.mActiveInputDeviceId) == true) goto L10;
        initializeDeviceToEnumMap(inputDevice);
    L10:
        if (isMouseKey(keyCode, this.mActiveInputDeviceId) == true) goto L13;
        super.onKeyEvent(event, policyFlags);
        return;
    L13:
        if (isDown == false) goto L43;
        if (keyCode != MouseKeyEvent.SCROLL_TOGGLE.getKeyCode(inputDevice)) goto L24;
        this.mScrollToggleOn = true ^ this.mScrollToggleOn;
        if (DEBUG == false) goto L51;
        StringBuilder r1 = new StringBuilder();
        r1.append("Scroll toggle ");
        if (this.mScrollToggleOn == false) goto L21;
        String r4 = "ON";
    L22:
        r1.append(r4);
        Slog.d(LOG_TAG, r1.toString());
        return;
    L21:
        r4 = "OFF";
        goto L22
    L51:
        return;
    L24:
        if (keyCode != MouseKeyEvent.HOLD.getKeyCode(inputDevice)) goto L27;
        sendVirtualMouseButtonEvent(1, 11);
        return;
    L27:
        if (keyCode != MouseKeyEvent.RELEASE.getKeyCode(inputDevice)) goto L30;
        sendVirtualMouseButtonEvent(1, 12);
        return;
    L30:
        if (isMouseButtonKey(keyCode, inputDevice) == false) goto L33;
        performMouseButtonAction(keyCode);
        return;
    L33:
        if (this.mScrollToggleOn == false) goto L40;
        if (isMouseScrollKey(keyCode, inputDevice) == false) goto L40;
        if (this.mActiveScrollKey != (-1)) goto L56;
        this.mActiveScrollKey = keyCode;
        this.mLastTimeKeyActionPerformed = event.getDownTime();
        this.mHandler.sendEmptyMessage(2);
        return;
    L56:
        return;
    L40:
        if (this.mActiveMoveKey != (-1)) goto L58;
        this.mActiveMoveKey = keyCode;
        this.mLastTimeKeyActionPerformed = event.getDownTime();
        this.mHandler.sendEmptyMessage(1);
        return;
    L58:
        return;
    L43:
        if (this.mActiveMoveKey != keyCode) goto L46;
        this.mActiveMoveKey = -1;
        this.mHandler.removeMessages(1);
        return;
    L46:
        if (this.mActiveScrollKey != keyCode) goto L48;
        this.mActiveScrollKey = -1;
        this.mHandler.removeMessages(2);
        return;
    L48:
        Slog.i(LOG_TAG, "Dropping event with key code: '" + keyCode + "', with no matching down event from deviceId = " + event.getDeviceId());
        return;
    L5:
        isDown = false;
        goto L6
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message msg) {
        switch(msg.what) {
            case 1: goto L7;
            case 2: goto L6;
            default: goto L4;
        };
    L4:
        Slog.e(LOG_TAG, "Unexpected message type");
        return false;
    L6:
        handleMouseMessage(msg.getWhen(), this.mActiveScrollKey, 2);
    L8:
        return true;
    L7:
        handleMouseMessage(msg.getWhen(), this.mActiveMoveKey, 1);
        goto L8
    }

    public void handleMouseMessage(long currentTime, int activeKey, int messageType) {
        if ((currentTime - this.mLastTimeKeyActionPerformed) < 10) goto L12;
        if (messageType != 1) goto L8;
        performMousePointerAction(activeKey);
    L10:
        this.mLastTimeKeyActionPerformed = currentTime;
        goto L12
    L8:
        if (messageType != 2) goto L10;
        performMouseScrollAction(activeKey);
    L12:
        if (activeKey == (-1)) goto L15;
        this.mHandler.sendEmptyMessageDelayed(messageType, 10);
        return;
    }

    @Override // com.android.server.accessibility.EventStreamTransformation
    public void onDestroy() {
        this.mHandler.post(new MouseKeysInterceptor$$ExternalSyntheticLambda2(this));
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.mVirtualDevice == null) goto L6;
        this.mVirtualDevice.close();
        return;
    }

    private /* synthetic */ void lambda$onDestroy$2() {
        this.mActiveMoveKey = -1;
        this.mActiveScrollKey = -1;
        this.mLastTimeKeyActionPerformed = 0;
        this.mDeviceKeyCodeMap.clear();
    }

    @Override // android.hardware.input.InputManager.InputDeviceListener
    public void onInputDeviceAdded(int deviceId) {
    }

    @Override // android.hardware.input.InputManager.InputDeviceListener
    public void onInputDeviceRemoved(int deviceId) {
        this.mDeviceKeyCodeMap.remove(deviceId);
    }

    @Override // android.hardware.input.InputManager.InputDeviceListener
    public void onInputDeviceChanged(int deviceId) {
        InputDevice inputDevice = this.mInputManager.getInputDevice(deviceId);
        if (inputDevice.isFullKeyboard() == true) goto L5;
        return;
    L5:
        if (this.mDeviceKeyCodeMap.contains(deviceId) == true) goto L9;
        initializeDeviceToEnumMap(inputDevice);
        return;
    }
}
