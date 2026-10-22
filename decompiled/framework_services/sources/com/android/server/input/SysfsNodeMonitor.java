package com.android.server.input;

import android.content.Context;
import android.hardware.input.InputManager;
import android.os.Handler;
import android.os.Looper;
import android.os.UEventObserver;
import android.text.TextUtils;
import android.util.Log;
import android.util.Slog;
import android.util.SparseArray;
import android.view.InputDevice;

/* JADX INFO: loaded from: classes2.dex */
final class SysfsNodeMonitor {
    private static final boolean DEBUG = false;
    private static final long SYSFS_NODE_MONITORING_TIMEOUT_MS = 60000;
    private static final String TAG = null;
    private final Context mContext;
    private final Handler mHandler;
    private final InputManager.InputDeviceListener mInputDeviceListener;
    private InputManager mInputManager;
    private final NativeInputManagerService mNative;
    private final SparseArray<SysfsNodeAddedListener> mUEventListenersByDeviceId;
    private final UEventManager mUEventManager;

    class SysfsNodeAddedListener extends UEventManager.UEventListener {
        private boolean mHasReceivedPowerSupplyNotification;
        private boolean mHasReceivedRemovalNotification;
        final /* synthetic */ SysfsNodeMonitor this$0;

        public static /* synthetic */ void $r8$lambda$A8GB7pJL44mEC8RsWsS_eXkLo9c(SysfsNodeAddedListener r0, UEventObserver.UEvent r1) {
            r0.lambda$onUEvent$0(r1);
        }

        SysfsNodeAddedListener(SysfsNodeMonitor this$0) {
            this.this$0 = this$0;
            this.mHasReceivedRemovalNotification = false;
            this.mHasReceivedPowerSupplyNotification = false;
        }

        private /* synthetic */ void lambda$onUEvent$0(UEventObserver.UEvent event) {
            handleUEvent(event);
        }

        @Override // com.android.server.input.UEventManager.UEventListener
        public void onUEvent(final UEventObserver.UEvent event) {
            SysfsNodeMonitor.m4604$$Nest$fgetmHandler(this.this$0).post(new SysfsNodeMonitor$SysfsNodeAddedListener$$ExternalSyntheticLambda0(this, event));
        }

        private void handleUEvent(UEventObserver.UEvent event) {
            if (SysfsNodeMonitor.m4608$$Nest$sfgetDEBUG() == false) goto L5;
            Slog.d(SysfsNodeMonitor.m4609$$Nest$sfgetTAG(), "UEventListener: Received UEvent: " + event);
        L5:
            String subsystem = event.get("SUBSYSTEM");
            StringBuilder r1 = new StringBuilder();
            r1.append("/sys");
            String r2 = TextUtils.nullIfEmpty(event.get("DEVPATH"));
            r2.getClass();
            r1.append(r2);
            String devPath = r1.toString();
            String action = event.get("ACTION");
            if (this.mHasReceivedRemovalNotification == false) goto L8;
        L29:
            this.mHasReceivedRemovalNotification = true;
            return;
        L8:
            if ("REMOVE".equalsIgnoreCase(action) == true) goto L29;
            if ("LEDS".equalsIgnoreCase(subsystem) == false) goto L20;
            if ("ADD".equalsIgnoreCase(action) == false) goto L20;
            if (SysfsNodeMonitor.m4608$$Nest$sfgetDEBUG() == false) goto L17;
            Slog.d(SysfsNodeMonitor.m4609$$Nest$sfgetTAG(), "Reconfiguring sysfs node because 'leds' node was added: " + devPath);
        L17:
            SysfsNodeMonitor.m4605$$Nest$fgetmNative(this.this$0).sysfsNodeChanged(devPath);
            return;
        L20:
            if ("POWER_SUPPLY".equalsIgnoreCase(subsystem) == true) goto L22;
            return;
        L22:
            if (this.mHasReceivedPowerSupplyNotification == false) goto L25;
            return;
        L25:
            if (SysfsNodeMonitor.m4608$$Nest$sfgetDEBUG() == false) goto L27;
            Slog.d(SysfsNodeMonitor.m4609$$Nest$sfgetTAG(), "Reconfiguring sysfs node because 'power_supply' node had action '" + action + "': " + devPath);
        L27:
            this.mHasReceivedPowerSupplyNotification = true;
            SysfsNodeMonitor.m4605$$Nest$fgetmNative(this.this$0).sysfsNodeChanged(devPath);
        }
    }

    public static /* synthetic */ void $r8$lambda$jsLQvX7rv9bx_iMb9KuwO8ozKj8(SysfsNodeMonitor r0, int r1) {
        r0.lambda$startMonitoring$0(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmHandler, reason: not valid java name */
    static /* bridge */ /* synthetic */ Handler m4604$$Nest$fgetmHandler(SysfsNodeMonitor r0) {
        return r0.mHandler;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmNative, reason: not valid java name */
    static /* bridge */ /* synthetic */ NativeInputManagerService m4605$$Nest$fgetmNative(SysfsNodeMonitor r0) {
        return r0.mNative;
    }

    /* JADX INFO: renamed from: -$$Nest$mstartMonitoring, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4606$$Nest$mstartMonitoring(SysfsNodeMonitor r0, int r1) {
        r0.startMonitoring(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mstopMonitoring, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4607$$Nest$mstopMonitoring(SysfsNodeMonitor r0, int r1) {
        r0.stopMonitoring(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetDEBUG, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m4608$$Nest$sfgetDEBUG() {
        return DEBUG;
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetTAG, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m4609$$Nest$sfgetTAG() {
        return TAG;
    }

    static {
        TAG = SysfsNodeMonitor.class.getSimpleName();
        DEBUG = Log.isLoggable(TAG, 3);
    }

    SysfsNodeMonitor(Context context, NativeInputManagerService nativeService, Looper looper, UEventManager uEventManager) {
        this.mUEventListenersByDeviceId = new SparseArray();
        this.mInputDeviceListener = new AnonymousClass1(this);
        this.mContext = context;
        this.mNative = nativeService;
        this.mHandler = new Handler(looper);
        this.mUEventManager = uEventManager;
    }

    public void systemRunning() {
        InputManager r0 = (InputManager) this.mContext.getSystemService(InputManager.class);
        r0.getClass();
        this.mInputManager = r0;
        this.mInputManager.registerInputDeviceListener(this.mInputDeviceListener, this.mHandler);
        int[] r1 = this.mInputManager.getInputDeviceIds();
        int r2 = r1.length;
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L5;
        int deviceId = r1[r3];
        this.mInputDeviceListener.onInputDeviceAdded(deviceId);
        r3 = r3 + 1;
        goto L3
    }

    private void startMonitoring(final int deviceId) {
        InputDevice inputDevice = this.mInputManager.getInputDevice(deviceId);
        if (inputDevice != null) goto L6;
        return;
    L6:
        if (inputDevice.isExternal() == false) goto L8;
        String sysfsRootPath = formatDevPath(this.mNative.getSysfsRootPath(deviceId));
        if (sysfsRootPath != null) goto L18;
        if (DEBUG == false) goto L23;
        Log.d(TAG, "Sysfs node not found for external input device: " + deviceId);
        return;
    L23:
        return;
    L18:
        if (DEBUG == false) goto L20;
        Log.d(TAG, "Start listening to sysfs node changes for input device: " + deviceId + ", node: " + sysfsRootPath);
    L20:
        SysfsNodeAddedListener listener = new SysfsNodeAddedListener(this);
        this.mUEventListenersByDeviceId.put(deviceId, listener);
        this.mUEventManager.addListener(listener, sysfsRootPath);
        this.mNative.sysfsNodeChanged(sysfsRootPath);
        this.mHandler.postDelayed(new SysfsNodeMonitor$$ExternalSyntheticLambda0(this, deviceId), 60000);
        return;
    L8:
        if (DEBUG == false) goto L22;
        Log.d(TAG, "Not listening to sysfs node changes for internal input device: " + deviceId);
        return;
    }

    private /* synthetic */ void lambda$startMonitoring$0(int deviceId) {
        stopMonitoring(deviceId);
    }

    private static String formatDevPath(String path) {
        if (path == null) goto L7;
        if (path.startsWith("/sys") == false) goto L7;
        return path.substring(4);
    L7:
        return path;
    }

    private void stopMonitoring(int deviceId) {
        SysfsNodeAddedListener listener = (SysfsNodeAddedListener) this.mUEventListenersByDeviceId.removeReturnOld(deviceId);
        if (listener != null) goto L6;
        return;
    L6:
        if (DEBUG == false) goto L8;
        Log.d(TAG, "Stop listening to sysfs node changes for input device: " + deviceId);
    L8:
        this.mUEventManager.removeListener(listener);
    }
}
