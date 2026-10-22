package com.android.server.companion.virtual;

import android.content.AttributionSource;
import android.graphics.PointF;
import android.hardware.display.DisplayManagerInternal;
import android.hardware.input.InputManager;
import android.hardware.input.InputManagerGlobal;
import android.hardware.input.VirtualKeyEvent;
import android.hardware.input.VirtualMouseButtonEvent;
import android.hardware.input.VirtualMouseRelativeEvent;
import android.hardware.input.VirtualMouseScrollEvent;
import android.hardware.input.VirtualRotaryEncoderScrollEvent;
import android.hardware.input.VirtualStylusButtonEvent;
import android.hardware.input.VirtualStylusMotionEvent;
import android.hardware.input.VirtualTouchEvent;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.Log;
import android.util.Slog;
import android.view.WindowManager;
import com.android.modules.expresslog.Counter;
import com.android.server.LocalServices;
import com.android.server.input.InputManagerInternal;
import java.io.PrintWriter;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes.dex */
class InputController {
    static final String NAVIGATION_TOUCHPAD_DEVICE_TYPE = "touchNavigation";
    static final String PHYS_TYPE_DPAD = "Dpad";
    static final String PHYS_TYPE_KEYBOARD = "Keyboard";
    static final String PHYS_TYPE_MOUSE = "Mouse";
    static final String PHYS_TYPE_NAVIGATION_TOUCHPAD = "NavigationTouchpad";
    static final String PHYS_TYPE_ROTARY_ENCODER = "RotaryEncoder";
    static final String PHYS_TYPE_STYLUS = "Stylus";
    static final String PHYS_TYPE_TOUCHSCREEN = "Touchscreen";
    private static final String TAG = "VirtualInputController";
    private static final AtomicLong sNextPhysId = null;
    private final AttributionSource mAttributionSource;
    private final DisplayManagerInternal mDisplayManagerInternal;
    private final Handler mHandler;
    private final ArrayMap<IBinder, InputDeviceDescriptor> mInputDeviceDescriptors;
    private final InputManagerInternal mInputManagerInternal;
    final Object mLock;
    private final NativeWrapper mNativeWrapper;
    private final DeviceCreationThreadVerifier mThreadVerifier;
    private final WindowManager mWindowManager;

    private final class BinderDeathRecipient implements IBinder.DeathRecipient {
        private final IBinder mDeviceToken;
        final /* synthetic */ InputController this$0;

        BinderDeathRecipient(InputController r1, IBinder deviceToken) {
            this.this$0 = r1;
            this.mDeviceToken = deviceToken;
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            Slog.e(InputController.TAG, "Virtual input controller binder died");
            this.this$0.unregisterInputDevice(this.mDeviceToken);
        }
    }

    static class DeviceCreationException extends Exception {
        DeviceCreationException() {
        }

        DeviceCreationException(String message) {
            super(message);
        }

        DeviceCreationException(String message, Throwable cause) {
            super(message, cause);
        }

        DeviceCreationException(Throwable cause) {
            super(cause);
        }
    }

    interface DeviceCreationThreadVerifier {
        boolean isValidThread();
    }

    static final class InputDeviceDescriptor {
        static final int TYPE_DPAD = 4;
        static final int TYPE_KEYBOARD = 1;
        static final int TYPE_MOUSE = 2;
        static final int TYPE_NAVIGATION_TOUCHPAD = 5;
        static final int TYPE_ROTARY_ENCODER = 7;
        static final int TYPE_STYLUS = 6;
        static final int TYPE_TOUCHSCREEN = 3;
        private static final AtomicLong sNextCreationOrderNumber = null;
        private final long mCreationOrderNumber;
        private final IBinder.DeathRecipient mDeathRecipient;
        private final int mDisplayId;
        private final int mInputDeviceId;
        private final String mName;
        private final String mPhys;
        private final long mPtr;
        private final int mType;

        @Retention(RetentionPolicy.SOURCE)
        @interface Type {
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmName, reason: not valid java name */
        static /* bridge */ /* synthetic */ String m2998$$Nest$fgetmName(InputDeviceDescriptor r0) {
            return r0.mName;
        }

        static {
            sNextCreationOrderNumber = new AtomicLong(1);
        }

        InputDeviceDescriptor(long ptr, IBinder.DeathRecipient deathRecipient, int type, int displayId, String phys, String name, int inputDeviceId) {
            this.mPtr = ptr;
            this.mDeathRecipient = deathRecipient;
            this.mType = type;
            this.mDisplayId = displayId;
            this.mPhys = phys;
            this.mName = name;
            this.mInputDeviceId = inputDeviceId;
            this.mCreationOrderNumber = sNextCreationOrderNumber.getAndIncrement();
        }

        public long getNativePointer() {
            return this.mPtr;
        }

        public int getType() {
            return this.mType;
        }

        public boolean isMouse() {
            if (this.mType != 2) goto L5;
            return true;
        L5:
            return false;
        }

        public IBinder.DeathRecipient getDeathRecipient() {
            return this.mDeathRecipient;
        }

        public int getDisplayId() {
            return this.mDisplayId;
        }

        public long getCreationOrderNumber() {
            return this.mCreationOrderNumber;
        }

        public String getPhys() {
            return this.mPhys;
        }

        public int getInputDeviceId() {
            return this.mInputDeviceId;
        }
    }

    protected static class NativeWrapper {
        protected NativeWrapper() {
        }

        public long openUinputDpad(String deviceName, int vendorId, int productId, String phys) {
            return InputController.m2983$$Nest$smnativeOpenUinputDpad(deviceName, vendorId, productId, phys);
        }

        public long openUinputKeyboard(String deviceName, int vendorId, int productId, String phys) {
            return InputController.m2984$$Nest$smnativeOpenUinputKeyboard(deviceName, vendorId, productId, phys);
        }

        public long openUinputMouse(String deviceName, int vendorId, int productId, String phys) {
            return InputController.m2985$$Nest$smnativeOpenUinputMouse(deviceName, vendorId, productId, phys);
        }

        public long openUinputTouchscreen(String deviceName, int vendorId, int productId, String phys, int height, int width) {
            return InputController.m2988$$Nest$smnativeOpenUinputTouchscreen(deviceName, vendorId, productId, phys, height, width);
        }

        public long openUinputStylus(String deviceName, int vendorId, int productId, String phys, int height, int width) {
            return InputController.m2987$$Nest$smnativeOpenUinputStylus(deviceName, vendorId, productId, phys, height, width);
        }

        public long openUinputRotaryEncoder(String deviceName, int vendorId, int productId, String phys) {
            return InputController.m2986$$Nest$smnativeOpenUinputRotaryEncoder(deviceName, vendorId, productId, phys);
        }

        public void closeUinput(long ptr) {
            InputController.m2982$$Nest$smnativeCloseUinput(ptr);
        }

        public boolean writeDpadKeyEvent(long ptr, int androidKeyCode, int action, long eventTimeNanos) {
            return InputController.m2990$$Nest$smnativeWriteDpadKeyEvent(ptr, androidKeyCode, action, eventTimeNanos);
        }

        public boolean writeKeyEvent(long ptr, int androidKeyCode, int action, long eventTimeNanos) {
            return InputController.m2991$$Nest$smnativeWriteKeyEvent(ptr, androidKeyCode, action, eventTimeNanos);
        }

        public boolean writeButtonEvent(long ptr, int buttonCode, int action, long eventTimeNanos) {
            return InputController.m2989$$Nest$smnativeWriteButtonEvent(ptr, buttonCode, action, eventTimeNanos);
        }

        public boolean writeTouchEvent(long ptr, int pointerId, int toolType, int action, float locationX, float locationY, float pressure, float majorAxisSize, long eventTimeNanos) {
            return InputController.m2997$$Nest$smnativeWriteTouchEvent(ptr, pointerId, toolType, action, locationX, locationY, pressure, majorAxisSize, eventTimeNanos);
        }

        public boolean writeRelativeEvent(long ptr, float relativeX, float relativeY, long eventTimeNanos) {
            return InputController.m2992$$Nest$smnativeWriteRelativeEvent(ptr, relativeX, relativeY, eventTimeNanos);
        }

        public boolean writeScrollEvent(long ptr, float xAxisMovement, float yAxisMovement, long eventTimeNanos) {
            return InputController.m2994$$Nest$smnativeWriteScrollEvent(ptr, xAxisMovement, yAxisMovement, eventTimeNanos);
        }

        public boolean writeStylusMotionEvent(long ptr, int toolType, int action, int locationX, int locationY, int pressure, int tiltX, int tiltY, long eventTimeNanos) {
            return InputController.m2996$$Nest$smnativeWriteStylusMotionEvent(ptr, toolType, action, locationX, locationY, pressure, tiltX, tiltY, eventTimeNanos);
        }

        public boolean writeStylusButtonEvent(long ptr, int buttonCode, int action, long eventTimeNanos) {
            return InputController.m2995$$Nest$smnativeWriteStylusButtonEvent(ptr, buttonCode, action, eventTimeNanos);
        }

        public boolean writeRotaryEncoderScrollEvent(long ptr, float scrollAmount, long eventTimeNanos) {
            return InputController.m2993$$Nest$smnativeWriteRotaryEncoderScrollEvent(ptr, scrollAmount, eventTimeNanos);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @interface PhysType {
    }

    private class WaitForDevice implements AutoCloseable {
        private final CountDownLatch mDeviceAddedLatch;
        private final String mDeviceName;
        private int mInputDeviceId;
        private final InputManager.InputDeviceListener mListener;

        /* JADX INFO: renamed from: -$$Nest$fgetmDeviceAddedLatch, reason: not valid java name */
        static /* bridge */ /* synthetic */ CountDownLatch m2999$$Nest$fgetmDeviceAddedLatch(WaitForDevice r0) {
            return r0.mDeviceAddedLatch;
        }

        /* JADX INFO: renamed from: -$$Nest$fputmInputDeviceId, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m3000$$Nest$fputmInputDeviceId(WaitForDevice r0, int r1) {
            r0.mInputDeviceId = r1;
        }

        WaitForDevice(final InputController r9, final String deviceName, final int vendorId, final int productId, final int associatedDisplayId) {
            this.mDeviceAddedLatch = new CountDownLatch(1);
            this.mInputDeviceId = -2;
            this.mDeviceName = deviceName;
            this.mListener = new AnonymousClass1(this, r9, deviceName, vendorId, productId, associatedDisplayId);
            InputManagerGlobal.getInstance().registerInputDeviceListener(this.mListener, InputController.m2981$$Nest$fgetmHandler(r9));
        }

        int waitForDeviceCreation() throws DeviceCreationException {
        L13:
            e = move-exception;
            throw new DeviceCreationException("Interrupted while waiting for virtual input device " + this.mDeviceName + " to be created.", e);
        L4:
            if (this.mDeviceAddedLatch.await(1, TimeUnit.MINUTES) == false) goto L12;
            if (this.mInputDeviceId == (-2)) goto L10;
            return this.mInputDeviceId;
        L10:
            throw new IllegalStateException("Virtual input device " + this.mDeviceName + " was created with an invalid id=" + this.mInputDeviceId);
        L12:
            throw new DeviceCreationException("Timed out waiting for virtual input device " + this.mDeviceName + " to be created.");     // Catch: InterruptedException -> L13
        }

        @Override // java.lang.AutoCloseable
        public void close() {
            InputManagerGlobal.getInstance().unregisterInputDeviceListener(this.mListener);
        }
    }

    public static /* synthetic */ Long $r8$lambda$01sEoYmFLrArypyzJcRPU3RVqhM(InputController r0, String r1, int r2, int r3, String r4) {
        return r0.lambda$createDpad$1(r1, r2, r3, r4);
    }

    public static /* synthetic */ Long $r8$lambda$LU3qwNeZqBTpQt435BDblRAWSxE(InputController r0, String r1, int r2, int r3, String r4) {
        return r0.lambda$createMouse$3(r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: $r8$lambda$Uu-r0qSTZ4oUo4yYfoRNcHCFv8Q, reason: not valid java name */
    public static /* synthetic */ boolean m2978$r8$lambda$Uur0qSTZ4oUo4yYfoRNcHCFv8Q(Handler r0) {
        return lambda$new$0(r0);
    }

    public static /* synthetic */ Long $r8$lambda$Uv1DNnuIOQk4S6cgtXSLvY3wmoM(InputController r0, String r1, int r2, int r3, String r4, int r5, int r6) {
        return r0.lambda$createTouchscreen$4(r1, r2, r3, r4, r5, r6);
    }

    public static /* synthetic */ Long $r8$lambda$XRZ4I4aEkG5eqjgHu047xsm9Yzo(InputController r0, String r1, int r2, int r3, String r4, int r5, int r6) {
        return r0.lambda$createNavigationTouchpad$5(r1, r2, r3, r4, r5, r6);
    }

    /* JADX INFO: renamed from: $r8$lambda$e7OjR5ys8FqU-mOd2TEfStRWlT8, reason: not valid java name */
    public static /* synthetic */ Long m2979$r8$lambda$e7OjR5ys8FqUmOd2TEfStRWlT8(InputController r0, String r1, int r2, int r3, String r4) {
        return r0.lambda$createRotaryEncoder$7(r1, r2, r3, r4);
    }

    public static /* synthetic */ void $r8$lambda$h4q6hXa3_j37gjmyGaYo4ibHyEc() {
        lambda$addDeviceForTesting$8();
    }

    public static /* synthetic */ Long $r8$lambda$kzjMsROvXK3A4Nscl_kfjh6nkIM(InputController r0, String r1, int r2, int r3, String r4, int r5, int r6) {
        return r0.lambda$createStylus$6(r1, r2, r3, r4, r5, r6);
    }

    /* JADX INFO: renamed from: $r8$lambda$n7Xuh-Fem3ZZvob9nNb1xk3wyec, reason: not valid java name */
    public static /* synthetic */ Long m2980$r8$lambda$n7XuhFem3ZZvob9nNb1xk3wyec(InputController r0, String r1, int r2, int r3, String r4) {
        return r0.lambda$createKeyboard$2(r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmHandler, reason: not valid java name */
    static /* bridge */ /* synthetic */ Handler m2981$$Nest$fgetmHandler(InputController r0) {
        return r0.mHandler;
    }

    /* JADX INFO: renamed from: -$$Nest$smnativeCloseUinput, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2982$$Nest$smnativeCloseUinput(long r0) {
        nativeCloseUinput(r0);
    }

    /* JADX INFO: renamed from: -$$Nest$smnativeOpenUinputDpad, reason: not valid java name */
    static /* bridge */ /* synthetic */ long m2983$$Nest$smnativeOpenUinputDpad(String r0, int r1, int r2, String r3) {
        return nativeOpenUinputDpad(r0, r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$smnativeOpenUinputKeyboard, reason: not valid java name */
    static /* bridge */ /* synthetic */ long m2984$$Nest$smnativeOpenUinputKeyboard(String r0, int r1, int r2, String r3) {
        return nativeOpenUinputKeyboard(r0, r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$smnativeOpenUinputMouse, reason: not valid java name */
    static /* bridge */ /* synthetic */ long m2985$$Nest$smnativeOpenUinputMouse(String r0, int r1, int r2, String r3) {
        return nativeOpenUinputMouse(r0, r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$smnativeOpenUinputRotaryEncoder, reason: not valid java name */
    static /* bridge */ /* synthetic */ long m2986$$Nest$smnativeOpenUinputRotaryEncoder(String r0, int r1, int r2, String r3) {
        return nativeOpenUinputRotaryEncoder(r0, r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$smnativeOpenUinputStylus, reason: not valid java name */
    static /* bridge */ /* synthetic */ long m2987$$Nest$smnativeOpenUinputStylus(String r0, int r1, int r2, String r3, int r4, int r5) {
        return nativeOpenUinputStylus(r0, r1, r2, r3, r4, r5);
    }

    /* JADX INFO: renamed from: -$$Nest$smnativeOpenUinputTouchscreen, reason: not valid java name */
    static /* bridge */ /* synthetic */ long m2988$$Nest$smnativeOpenUinputTouchscreen(String r0, int r1, int r2, String r3, int r4, int r5) {
        return nativeOpenUinputTouchscreen(r0, r1, r2, r3, r4, r5);
    }

    /* JADX INFO: renamed from: -$$Nest$smnativeWriteButtonEvent, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m2989$$Nest$smnativeWriteButtonEvent(long r0, int r2, int r3, long r4) {
        return nativeWriteButtonEvent(r0, r2, r3, r4);
    }

    /* JADX INFO: renamed from: -$$Nest$smnativeWriteDpadKeyEvent, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m2990$$Nest$smnativeWriteDpadKeyEvent(long r0, int r2, int r3, long r4) {
        return nativeWriteDpadKeyEvent(r0, r2, r3, r4);
    }

    /* JADX INFO: renamed from: -$$Nest$smnativeWriteKeyEvent, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m2991$$Nest$smnativeWriteKeyEvent(long r0, int r2, int r3, long r4) {
        return nativeWriteKeyEvent(r0, r2, r3, r4);
    }

    /* JADX INFO: renamed from: -$$Nest$smnativeWriteRelativeEvent, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m2992$$Nest$smnativeWriteRelativeEvent(long r0, float r2, float r3, long r4) {
        return nativeWriteRelativeEvent(r0, r2, r3, r4);
    }

    /* JADX INFO: renamed from: -$$Nest$smnativeWriteRotaryEncoderScrollEvent, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m2993$$Nest$smnativeWriteRotaryEncoderScrollEvent(long r0, float r2, long r3) {
        return nativeWriteRotaryEncoderScrollEvent(r0, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$smnativeWriteScrollEvent, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m2994$$Nest$smnativeWriteScrollEvent(long r0, float r2, float r3, long r4) {
        return nativeWriteScrollEvent(r0, r2, r3, r4);
    }

    /* JADX INFO: renamed from: -$$Nest$smnativeWriteStylusButtonEvent, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m2995$$Nest$smnativeWriteStylusButtonEvent(long r0, int r2, int r3, long r4) {
        return nativeWriteStylusButtonEvent(r0, r2, r3, r4);
    }

    /* JADX INFO: renamed from: -$$Nest$smnativeWriteStylusMotionEvent, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m2996$$Nest$smnativeWriteStylusMotionEvent(long r0, int r2, int r3, int r4, int r5, int r6, int r7, int r8, long r9) {
        return nativeWriteStylusMotionEvent(r0, r2, r3, r4, r5, r6, r7, r8, r9);
    }

    /* JADX INFO: renamed from: -$$Nest$smnativeWriteTouchEvent, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m2997$$Nest$smnativeWriteTouchEvent(long r0, int r2, int r3, int r4, float r5, float r6, float r7, float r8, long r9) {
        return nativeWriteTouchEvent(r0, r2, r3, r4, r5, r6, r7, r8, r9);
    }

    private static native void nativeCloseUinput(long r0);

    private static native long nativeOpenUinputDpad(String r0, int r1, int r2, String r3);

    private static native long nativeOpenUinputKeyboard(String r0, int r1, int r2, String r3);

    private static native long nativeOpenUinputMouse(String r0, int r1, int r2, String r3);

    private static native long nativeOpenUinputRotaryEncoder(String r0, int r1, int r2, String r3);

    private static native long nativeOpenUinputStylus(String r0, int r1, int r2, String r3, int r4, int r5);

    private static native long nativeOpenUinputTouchscreen(String r0, int r1, int r2, String r3, int r4, int r5);

    private static native boolean nativeWriteButtonEvent(long r0, int r2, int r3, long r4);

    private static native boolean nativeWriteDpadKeyEvent(long r0, int r2, int r3, long r4);

    private static native boolean nativeWriteKeyEvent(long r0, int r2, int r3, long r4);

    private static native boolean nativeWriteRelativeEvent(long r0, float r2, float r3, long r4);

    private static native boolean nativeWriteRotaryEncoderScrollEvent(long r0, float r2, long r3);

    private static native boolean nativeWriteScrollEvent(long r0, float r2, float r3, long r4);

    private static native boolean nativeWriteStylusButtonEvent(long r0, int r2, int r3, long r4);

    private static native boolean nativeWriteStylusMotionEvent(long r0, int r2, int r3, int r4, int r5, int r6, int r7, int r8, long r9);

    private static native boolean nativeWriteTouchEvent(long r0, int r2, int r3, int r4, float r5, float r6, float r7, float r8, long r9);

    static {
        sNextPhysId = new AtomicLong(1);
    }

    InputController(final Handler handler, WindowManager windowManager, AttributionSource attributionSource) {
        this(new NativeWrapper(), handler, windowManager, attributionSource, new InputController$$ExternalSyntheticLambda1(handler));
    }

    private static /* synthetic */ boolean lambda$new$0(Handler handler) {
        return !handler.getLooper().isCurrentThread();
    }

    InputController(NativeWrapper nativeWrapper, Handler handler, WindowManager windowManager, AttributionSource attributionSource, DeviceCreationThreadVerifier threadVerifier) {
        this.mLock = new Object();
        this.mInputDeviceDescriptors = new ArrayMap();
        this.mHandler = handler;
        this.mNativeWrapper = nativeWrapper;
        this.mDisplayManagerInternal = (DisplayManagerInternal) LocalServices.getService(DisplayManagerInternal.class);
        this.mInputManagerInternal = (InputManagerInternal) LocalServices.getService(InputManagerInternal.class);
        this.mWindowManager = windowManager;
        this.mAttributionSource = attributionSource;
        this.mThreadVerifier = threadVerifier;
    }

    void close() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        Iterator<Map.Entry<IBinder, InputDeviceDescriptor>> iterator = this.mInputDeviceDescriptors.entrySet().iterator();     // Catch: Throwable -> L7
        if (iterator.hasNext() == false) goto L9;
        Map.Entry<IBinder, InputDeviceDescriptor> entry = iterator.next();     // Catch: Throwable -> L7
        IBinder token = entry.getKey();     // Catch: Throwable -> L7
        InputDeviceDescriptor inputDeviceDescriptor = entry.getValue();     // Catch: Throwable -> L7
        iterator.remove();     // Catch: Throwable -> L7
        closeInputDeviceDescriptorLocked(token, inputDeviceDescriptor);     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    void createDpad(final String deviceName, final int vendorId, final int productId, IBinder deviceToken, int displayId) throws DeviceCreationException {
        final String phys = createPhys(PHYS_TYPE_DPAD);
        createDeviceInternal(4, deviceName, vendorId, productId, deviceToken, displayId, phys, new InputController$$ExternalSyntheticLambda4(this, deviceName, vendorId, productId, phys));
    }

    private /* synthetic */ Long lambda$createDpad$1(String deviceName, int vendorId, int productId, String phys) {
        return Long.valueOf(this.mNativeWrapper.openUinputDpad(deviceName, vendorId, productId, phys));
    }

    void createKeyboard(final String deviceName, final int vendorId, final int productId, IBinder deviceToken, int displayId, String languageTag, String layoutType) throws DeviceCreationException {
        final String phys = createPhys(PHYS_TYPE_KEYBOARD);
        this.mInputManagerInternal.addKeyboardLayoutAssociation(phys, languageTag, layoutType);
    L9:
        e = e;
    L13:
        this.mInputManagerInternal.removeKeyboardLayoutAssociation(phys);
        throw e;
    L17:
        createDeviceInternal(1, deviceName, vendorId, productId, deviceToken, displayId, phys, new InputController$$ExternalSyntheticLambda0(this, deviceName, vendorId, productId, phys));     // Catch: DeviceCreationException -> L9
        return;
    L11:
        e = e;
        phys = phys;
        goto L13
    }

    private /* synthetic */ Long lambda$createKeyboard$2(String deviceName, int vendorId, int productId, String phys) {
        return Long.valueOf(this.mNativeWrapper.openUinputKeyboard(deviceName, vendorId, productId, phys));
    }

    void createMouse(final String deviceName, final int vendorId, final int productId, IBinder deviceToken, int displayId) throws DeviceCreationException {
        final String phys = createPhys(PHYS_TYPE_MOUSE);
        createDeviceInternal(2, deviceName, vendorId, productId, deviceToken, displayId, phys, new InputController$$ExternalSyntheticLambda2(this, deviceName, vendorId, productId, phys));
    }

    private /* synthetic */ Long lambda$createMouse$3(String deviceName, int vendorId, int productId, String phys) {
        return Long.valueOf(this.mNativeWrapper.openUinputMouse(deviceName, vendorId, productId, phys));
    }

    void createTouchscreen(final String deviceName, final int vendorId, final int productId, IBinder deviceToken, int displayId, final int height, final int width) throws DeviceCreationException {
        final String phys = createPhys(PHYS_TYPE_TOUCHSCREEN);
        createDeviceInternal(3, deviceName, vendorId, productId, deviceToken, displayId, phys, new InputController$$ExternalSyntheticLambda6(this, deviceName, vendorId, productId, phys, height, width));
    }

    private /* synthetic */ Long lambda$createTouchscreen$4(String deviceName, int vendorId, int productId, String phys, int height, int width) {
        return Long.valueOf(this.mNativeWrapper.openUinputTouchscreen(deviceName, vendorId, productId, phys, height, width));
    }

    void createNavigationTouchpad(final String deviceName, final int vendorId, final int productId, IBinder deviceToken, int displayId, final int height, final int width) throws DeviceCreationException {
        final String phys = createPhys(PHYS_TYPE_NAVIGATION_TOUCHPAD);
        this.mInputManagerInternal.setTypeAssociation(phys, NAVIGATION_TOUCHPAD_DEVICE_TYPE);
    L9:
        e = e;
    L13:
        this.mInputManagerInternal.unsetTypeAssociation(phys);
        throw e;
    L17:
        Supplier<Long> r9 = new InputController$$ExternalSyntheticLambda7(this, deviceName, vendorId, productId, phys, height, width);     // Catch: DeviceCreationException -> L11
        phys = phys;
        createDeviceInternal(5, deviceName, vendorId, productId, deviceToken, displayId, phys, r9);     // Catch: DeviceCreationException -> L9
        return;
    L11:
        e = e;
        phys = phys;
        goto L13
    }

    private /* synthetic */ Long lambda$createNavigationTouchpad$5(String deviceName, int vendorId, int productId, String phys, int height, int width) {
        return Long.valueOf(this.mNativeWrapper.openUinputTouchscreen(deviceName, vendorId, productId, phys, height, width));
    }

    void createStylus(final String deviceName, final int vendorId, final int productId, IBinder deviceToken, int displayId, final int height, final int width) throws DeviceCreationException {
        final String phys = createPhys(PHYS_TYPE_STYLUS);
        createDeviceInternal(6, deviceName, vendorId, productId, deviceToken, displayId, phys, new InputController$$ExternalSyntheticLambda8(this, deviceName, vendorId, productId, phys, height, width));
    }

    private /* synthetic */ Long lambda$createStylus$6(String deviceName, int vendorId, int productId, String phys, int height, int width) {
        return Long.valueOf(this.mNativeWrapper.openUinputStylus(deviceName, vendorId, productId, phys, height, width));
    }

    void createRotaryEncoder(final String deviceName, final int vendorId, final int productId, IBinder deviceToken, int displayId) throws DeviceCreationException {
        final String phys = createPhys(PHYS_TYPE_ROTARY_ENCODER);
        createDeviceInternal(7, deviceName, vendorId, productId, deviceToken, displayId, phys, new InputController$$ExternalSyntheticLambda3(this, deviceName, vendorId, productId, phys));
    }

    private /* synthetic */ Long lambda$createRotaryEncoder$7(String deviceName, int vendorId, int productId, String phys) {
        return Long.valueOf(this.mNativeWrapper.openUinputRotaryEncoder(deviceName, vendorId, productId, phys));
    }

    void unregisterInputDevice(IBinder token) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        InputDeviceDescriptor inputDeviceDescriptor = this.mInputDeviceDescriptors.remove(token);     // Catch: Throwable -> L7
        if (inputDeviceDescriptor != null) goto L9;
        Slog.w(TAG, "Could not unregister input device for given token.");     // Catch: Throwable -> L7
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L9:
        closeInputDeviceDescriptorLocked(token, inputDeviceDescriptor);     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        throw th;
    }

    private void closeInputDeviceDescriptorLocked(IBinder token, InputDeviceDescriptor inputDeviceDescriptor) {
        token.unlinkToDeath(inputDeviceDescriptor.getDeathRecipient(), 0);
        this.mNativeWrapper.closeUinput(inputDeviceDescriptor.getNativePointer());
        String phys = inputDeviceDescriptor.getPhys();
        InputManagerGlobal.getInstance().removeUniqueIdAssociationByPort(phys);
        if (inputDeviceDescriptor.getType() != 5) goto L6;
        this.mInputManagerInternal.unsetTypeAssociation(phys);
    L6:
        if (inputDeviceDescriptor.getType() != 1) goto L9;
        this.mInputManagerInternal.removeKeyboardLayoutAssociation(phys);
        return;
    }

    int getInputDeviceId(IBinder token) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        InputDeviceDescriptor inputDeviceDescriptor = this.mInputDeviceDescriptors.get(token);     // Catch: Throwable -> L9
        if (inputDeviceDescriptor == null) goto L12;
        int r2 = inputDeviceDescriptor.getInputDeviceId();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r2;
    L12:
        throw new IllegalArgumentException("Could not get device id for given token");     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    void setShowPointerIcon(boolean visible, int displayId) {
        this.mInputManagerInternal.setPointerIconVisible(visible, displayId);
    }

    void setMouseScalingEnabled(boolean enabled, int displayId) {
        this.mInputManagerInternal.setMouseScalingEnabled(enabled, displayId);
    }

    void setDisplayEligibilityForPointerCapture(boolean isEligible, int displayId) {
        this.mInputManagerInternal.setDisplayEligibilityForPointerCapture(displayId, isEligible);
    }

    void setDisplayImePolicy(int displayId, int policy) {
        this.mWindowManager.setDisplayImePolicy(displayId, policy);
    }

    private void validateDeviceName(String deviceName) throws DeviceCreationException {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int i = 0;
    L19:
    L12:
        th = move-exception;
        throw th;
    L6:
        if (i >= this.mInputDeviceDescriptors.size()) goto L15;
        if (InputDeviceDescriptor.m2998$$Nest$fgetmName(this.mInputDeviceDescriptors.valueAt(i)).equals(deviceName) == true) goto L11;
        i = i + 1;     // Catch: Throwable -> L12
        goto L19
    L11:
        throw new DeviceCreationException("Input device name already in use: " + deviceName);     // Catch: Throwable -> L12
    L15:
        monitor-exit(r0);     // Catch: Throwable -> L12
    }

    private static String createPhys(String type) {
        return TextUtils.formatSimple("virtual%s:%d", new Object[]{type, Long.valueOf(sNextPhysId.getAndIncrement())});
    }

    private void setUniqueIdAssociation(int displayId, String phys) {
        String displayUniqueId = this.mDisplayManagerInternal.getDisplayInfo(displayId).uniqueId;
        InputManagerGlobal.getInstance().addUniqueIdAssociationByPort(phys, displayUniqueId);
    }

    boolean sendDpadKeyEvent(IBinder token, VirtualKeyEvent event) {
        Object r1 = this.mLock;
        monitor-enter(r1);
        InputDeviceDescriptor inputDeviceDescriptor = this.mInputDeviceDescriptors.get(token);     // Catch: Throwable -> L9
        if (inputDeviceDescriptor != null) goto L11;
        monitor-exit(r1);     // Catch: Throwable -> L9
        return false;
    L11:
        boolean r2 = this.mNativeWrapper.writeDpadKeyEvent(inputDeviceDescriptor.getNativePointer(), event.getKeyCode(), event.getAction(), event.getEventTimeNanos());     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return r2;
    L9:
        th = move-exception;
        throw th;
    }

    boolean sendKeyEvent(IBinder token, VirtualKeyEvent event) {
        Object r1 = this.mLock;
        monitor-enter(r1);
        InputDeviceDescriptor inputDeviceDescriptor = this.mInputDeviceDescriptors.get(token);     // Catch: Throwable -> L9
        if (inputDeviceDescriptor != null) goto L11;
        monitor-exit(r1);     // Catch: Throwable -> L9
        return false;
    L11:
        boolean r2 = this.mNativeWrapper.writeKeyEvent(inputDeviceDescriptor.getNativePointer(), event.getKeyCode(), event.getAction(), event.getEventTimeNanos());     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return r2;
    L9:
        th = move-exception;
        throw th;
    }

    boolean sendButtonEvent(IBinder token, VirtualMouseButtonEvent event) {
        Object r1 = this.mLock;
        monitor-enter(r1);
        InputDeviceDescriptor inputDeviceDescriptor = this.mInputDeviceDescriptors.get(token);     // Catch: Throwable -> L9
        if (inputDeviceDescriptor != null) goto L11;
        monitor-exit(r1);     // Catch: Throwable -> L9
        return false;
    L11:
        boolean r2 = this.mNativeWrapper.writeButtonEvent(inputDeviceDescriptor.getNativePointer(), event.getButtonCode(), event.getAction(), event.getEventTimeNanos());     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return r2;
    L9:
        th = move-exception;
        throw th;
    }

    boolean sendTouchEvent(IBinder token, VirtualTouchEvent event) {
        Object r2 = this.mLock;
        monitor-enter(r2);
        InputDeviceDescriptor inputDeviceDescriptor = this.mInputDeviceDescriptors.get(token);     // Catch: Throwable -> L11
        if (inputDeviceDescriptor != null) goto L13;
        monitor-exit(r2);     // Catch: Throwable -> L11
        return false;
    L13:
        boolean r4 = this.mNativeWrapper.writeTouchEvent(inputDeviceDescriptor.getNativePointer(), event.getPointerId(), event.getToolType(), event.getAction(), event.getX(), event.getY(), event.getPressure(), event.getMajorAxisSize(), event.getEventTimeNanos());     // Catch: Throwable -> L11
        monitor-exit(r2);     // Catch: Throwable -> L11
        return r4;
    L16:
        th = th;
    L18:
        monitor-exit(r2);     // Catch: Throwable -> L11
        throw th;
    L11:
        th = th;
        goto L18
    }

    boolean sendRelativeEvent(IBinder token, VirtualMouseRelativeEvent event) {
        Object r1 = this.mLock;
        monitor-enter(r1);
        InputDeviceDescriptor inputDeviceDescriptor = this.mInputDeviceDescriptors.get(token);     // Catch: Throwable -> L9
        if (inputDeviceDescriptor != null) goto L11;
        monitor-exit(r1);     // Catch: Throwable -> L9
        return false;
    L11:
        boolean r2 = this.mNativeWrapper.writeRelativeEvent(inputDeviceDescriptor.getNativePointer(), event.getRelativeX(), event.getRelativeY(), event.getEventTimeNanos());     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return r2;
    L9:
        th = move-exception;
        throw th;
    }

    boolean sendScrollEvent(IBinder token, VirtualMouseScrollEvent event) {
        Object r1 = this.mLock;
        monitor-enter(r1);
        InputDeviceDescriptor inputDeviceDescriptor = this.mInputDeviceDescriptors.get(token);     // Catch: Throwable -> L9
        if (inputDeviceDescriptor != null) goto L11;
        monitor-exit(r1);     // Catch: Throwable -> L9
        return false;
    L11:
        boolean r2 = this.mNativeWrapper.writeScrollEvent(inputDeviceDescriptor.getNativePointer(), event.getXAxisMovement(), event.getYAxisMovement(), event.getEventTimeNanos());     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return r2;
    L9:
        th = move-exception;
        throw th;
    }

    public PointF getCursorPosition(IBinder token) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        InputDeviceDescriptor inputDeviceDescriptor = this.mInputDeviceDescriptors.get(token);     // Catch: Throwable -> L9
        if (inputDeviceDescriptor == null) goto L12;
        PointF r2 = ((InputManagerInternal) LocalServices.getService(InputManagerInternal.class)).getCursorPosition(inputDeviceDescriptor.getDisplayId());     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r2;
    L12:
        throw new IllegalArgumentException("Could not get cursor position for input device for given token");     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    boolean sendStylusMotionEvent(IBinder token, VirtualStylusMotionEvent event) {
        Object r2 = this.mLock;
        monitor-enter(r2);
        InputDeviceDescriptor inputDeviceDescriptor = this.mInputDeviceDescriptors.get(token);     // Catch: Throwable -> L11
        if (inputDeviceDescriptor != null) goto L13;
        monitor-exit(r2);     // Catch: Throwable -> L11
        return false;
    L13:
        boolean r4 = this.mNativeWrapper.writeStylusMotionEvent(inputDeviceDescriptor.getNativePointer(), event.getToolType(), event.getAction(), event.getX(), event.getY(), event.getPressure(), event.getTiltX(), event.getTiltY(), event.getEventTimeNanos());     // Catch: Throwable -> L11
        monitor-exit(r2);     // Catch: Throwable -> L11
        return r4;
    L16:
        th = th;
    L18:
        monitor-exit(r2);     // Catch: Throwable -> L11
        throw th;
    L11:
        th = th;
        goto L18
    }

    boolean sendStylusButtonEvent(IBinder token, VirtualStylusButtonEvent event) {
        Object r1 = this.mLock;
        monitor-enter(r1);
        InputDeviceDescriptor inputDeviceDescriptor = this.mInputDeviceDescriptors.get(token);     // Catch: Throwable -> L9
        if (inputDeviceDescriptor != null) goto L11;
        monitor-exit(r1);     // Catch: Throwable -> L9
        return false;
    L11:
        boolean r2 = this.mNativeWrapper.writeStylusButtonEvent(inputDeviceDescriptor.getNativePointer(), event.getButtonCode(), event.getAction(), event.getEventTimeNanos());     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return r2;
    L9:
        th = move-exception;
        throw th;
    }

    boolean sendRotaryEncoderScrollEvent(IBinder token, VirtualRotaryEncoderScrollEvent event) {
        Object r1 = this.mLock;
        monitor-enter(r1);
        InputDeviceDescriptor inputDeviceDescriptor = this.mInputDeviceDescriptors.get(token);     // Catch: Throwable -> L9
        if (inputDeviceDescriptor != null) goto L11;
        monitor-exit(r1);     // Catch: Throwable -> L9
        return false;
    L11:
        boolean r2 = this.mNativeWrapper.writeRotaryEncoderScrollEvent(inputDeviceDescriptor.getNativePointer(), event.getScrollAmount(), event.getEventTimeNanos());     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return r2;
    L9:
        th = move-exception;
        throw th;
    }

    public void dump(PrintWriter fout) {
        fout.println("    InputController: ");
        Object r0 = this.mLock;
        monitor-enter(r0);
        fout.println("      Active descriptors: ");     // Catch: Throwable -> L8
        int i = 0;
    L6:
        if (i >= this.mInputDeviceDescriptors.size()) goto L11;
        InputDeviceDescriptor inputDeviceDescriptor = this.mInputDeviceDescriptors.valueAt(i);     // Catch: Throwable -> L8
        fout.println("        ptr: " + inputDeviceDescriptor.getNativePointer());     // Catch: Throwable -> L8
        fout.println("          displayId: " + inputDeviceDescriptor.getDisplayId());     // Catch: Throwable -> L8
        fout.println("          creationOrder: " + inputDeviceDescriptor.getCreationOrderNumber());     // Catch: Throwable -> L8
        fout.println("          type: " + inputDeviceDescriptor.getType());     // Catch: Throwable -> L8
        fout.println("          phys: " + inputDeviceDescriptor.getPhys());     // Catch: Throwable -> L8
        fout.println("          inputDeviceId: " + inputDeviceDescriptor.getInputDeviceId());     // Catch: Throwable -> L8
        i = i + 1;     // Catch: Throwable -> L8
        goto L6
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    void addDeviceForTesting(IBinder deviceToken, long ptr, int type, int displayId, String phys, String deviceName, int inputDeviceId) {
        Object r1 = this.mLock;
        monitor-enter(r1);
        this.mInputDeviceDescriptors.put(deviceToken, new InputDeviceDescriptor(ptr, new InputController$$ExternalSyntheticLambda5(), type, displayId, phys, deviceName, inputDeviceId));     // Catch: Throwable -> L7
        monitor-exit(r1);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private static /* synthetic */ void lambda$addDeviceForTesting$8() {
    }

    Map<IBinder, InputDeviceDescriptor> getInputDeviceDescriptors() {
        Map<IBinder, InputDeviceDescriptor> inputDeviceDescriptors = new ArrayMap();
        Object r1 = this.mLock;
        monitor-enter(r1);
        inputDeviceDescriptors.putAll(this.mInputDeviceDescriptors);     // Catch: Throwable -> L7
        monitor-exit(r1);     // Catch: Throwable -> L7
        return inputDeviceDescriptors;
    L7:
        th = move-exception;
        throw th;
    }

    private void createDeviceInternal(int type, String deviceName, int vendorId, int productId, IBinder deviceToken, int displayId, String phys, Supplier<Long> deviceOpener) throws DeviceCreationException {
        if (this.mThreadVerifier.isValidThread() == false) goto L46;
        validateDeviceName(deviceName);
        setUniqueIdAssociation(displayId, phys);
        WaitForDevice waiter = new WaitForDevice(this, deviceName, vendorId, productId, displayId);     // Catch: DeviceCreationException -> L24
        long ptr = deviceOpener.get().longValue();     // Catch: Throwable -> L26
        if (ptr == 0) goto L37;
        int inputDeviceId = waiter.waitForDeviceCreation();     // Catch: Throwable -> L26 DeviceCreationException -> L28
        BinderDeathRecipient binderDeathRecipient = new BinderDeathRecipient(this, deviceToken);     // Catch: Throwable -> L26 DeviceCreationException -> L28
        deviceToken.linkToDeath(binderDeathRecipient, 0);     // Catch: Throwable -> L26 DeviceCreationException -> L28 RemoteException -> L30
        waiter.close();     // Catch: DeviceCreationException -> L24
        Object r11 = this.mLock;
        monitor-enter(r11);
        this.mInputDeviceDescriptors.put(deviceToken, new InputDeviceDescriptor(ptr, binderDeathRecipient, type, displayId, phys, deviceName, inputDeviceId));     // Catch: Throwable -> L21
        monitor-exit(r11);     // Catch: Throwable -> L21
        String metricId = getMetricIdForInputType(type);
        if (metricId == null) goto L57;
        Counter.logIncrementWithUid(metricId, this.mAttributionSource.getUid());
        return;
    L57:
        return;
    L21:
        th = move-exception;
        throw th;
    L30:
        e = move-exception;
        throw new DeviceCreationException("Client died before virtual device could be created.", e);     // Catch: Throwable -> L26 DeviceCreationException -> L28
    L28:
        e = move-exception;
        this.mNativeWrapper.closeUinput(ptr);     // Catch: Throwable -> L26
        throw e;     // Catch: Throwable -> L26
    L37:
        throw new DeviceCreationException("A native error occurred when creating virtual input device: " + deviceName);     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        waiter.close();     // Catch: Throwable -> L40
    L58:
        throw th;     // Catch: DeviceCreationException -> L24
    L40:
        th = move-exception;
        th.addSuppressed(th);     // Catch: DeviceCreationException -> L24
        throw th;     // Catch: DeviceCreationException -> L24
    L24:
        e = move-exception;
        InputManagerGlobal.getInstance().removeUniqueIdAssociationByPort(phys);
        throw e;
    L46:
        throw new IllegalStateException("Virtual device creation should happen on an auxiliary thread (e.g. binder thread) and not from the handler's thread.");
    }

    private static String getMetricIdForInputType(int type) {
        switch(type) {
            case 1: goto L17;
            case 2: goto L15;
            case 3: goto L13;
            case 4: goto L11;
            case 5: goto L9;
            case 6: goto L7;
            case 7: goto L5;
            default: goto L3;
        };
    L3:
        Log.e(TAG, "No metric known for input type: " + type);
        return null;
    L5:
        return "virtual_devices.value_virtual_rotary_created_count";
    L7:
        return "virtual_devices.value_virtual_stylus_created_count";
    L9:
        return "virtual_devices.value_virtual_navigationtouchpad_created_count";
    L11:
        return "virtual_devices.value_virtual_dpad_created_count";
    L13:
        return "virtual_devices.value_virtual_touchscreen_created_count";
    L15:
        return "virtual_devices.value_virtual_mouse_created_count";
    L17:
        return "virtual_devices.value_virtual_keyboard_created_count";
    }
}
