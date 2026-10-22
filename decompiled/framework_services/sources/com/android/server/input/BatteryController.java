package com.android.server.input;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.hardware.input.IInputDeviceBatteryListener;
import android.hardware.input.IInputDeviceBatteryState;
import android.hardware.input.InputManager;
import android.os.Handler;
import android.os.HandlerExecutor;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.os.SystemClock;
import android.os.UEventObserver;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.IndentingPrintWriter;
import android.util.Log;
import android.util.Slog;
import android.view.InputDevice;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/* JADX INFO: loaded from: classes2.dex */
final class BatteryController {
    private static final boolean DEBUG = false;
    static final long POLLING_PERIOD_MILLIS = 10000;
    private static final String TAG = null;
    static final long USI_BATTERY_VALIDITY_DURATION_MILLIS = 3600000;
    private BluetoothBatteryManager.BluetoothBatteryListener mBluetoothBatteryListener;
    private final BluetoothBatteryManager mBluetoothBatteryManager;
    private final Context mContext;
    private final ArrayMap<Integer, DeviceMonitor> mDeviceMonitors;
    private final Runnable mHandlePollEventCallback;
    private final Handler mHandler;
    private final InputManager.InputDeviceListener mInputDeviceListener;
    private boolean mIsInteractive;
    private boolean mIsPolling;
    private final ArrayMap<Integer, ListenerRecord> mListenerRecords;
    private final Object mLock;
    private final NativeInputManagerService mNative;
    private final UEventManager mUEventManager;

    interface BluetoothBatteryManager {

        public interface BluetoothBatteryListener {
            void onBluetoothBatteryChanged(long r1, String r3, int r4);
        }

        void addBatteryListener(BluetoothBatteryListener r1);

        void addMetadataListener(String r1, BluetoothAdapter.OnMetadataChangedListener r2);

        int getBatteryLevel(String r1);

        byte[] getMetadata(String r1, int r2);

        void removeBatteryListener(BluetoothBatteryListener r1);

        void removeMetadataListener(String r1, BluetoothAdapter.OnMetadataChangedListener r2);
    }

    private class DeviceMonitor {
        int mBluetoothBatteryLevel;
        private BluetoothDevice mBluetoothDevice;
        long mBluetoothEventTime;
        int mBluetoothMetadataBatteryLevel;
        int mBluetoothMetadataBatteryStatus;
        private BluetoothAdapter.OnMetadataChangedListener mBluetoothMetadataListener;
        protected boolean mHasBattery;
        protected final State mState;
        private UEventBatteryListener mUEventBatteryListener;
        final /* synthetic */ BatteryController this$0;

        public static /* synthetic */ void $r8$lambda$7buFpLtmMejcI7cgEwRdymEhidA(DeviceMonitor r0, int r1, Long r2) {
            r0.lambda$onBluetoothBatteryChanged$0(r1, r2);
        }

        /* JADX INFO: renamed from: $r8$lambda$9x1owp5vGvnTX-D3xFonFX8_0oc, reason: not valid java name */
        public static /* synthetic */ void m4490$r8$lambda$9x1owp5vGvnTXD3xFonFX8_0oc(DeviceMonitor r0, int r1, byte[] r2, Long r3) {
            r0.lambda$onBluetoothMetadataChanged$1(r1, r2, r3);
        }

        public static /* synthetic */ void $r8$lambda$HAsKSnuizKaoaR_8D1ZrX4MoiKs(BatteryController r0, BluetoothDevice r1, int r2, byte[] r3) {
            BatteryController.m4478$$Nest$mhandleBluetoothMetadataChange(r0, r1, r2, r3);
        }

        public static /* synthetic */ void $r8$lambda$bLiOczRFkxi39agDP6yaXv7ai5M(DeviceMonitor r0, long r1) {
            r0.configureDeviceMonitor(r1);
        }

        public static /* synthetic */ State $r8$lambda$zWVmBVahkgMiVfp5hOJbzxUexHI(DeviceMonitor r0) {
            return r0.lambda$getBatteryStateForReporting$2();
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmBluetoothDevice, reason: not valid java name */
        static /* bridge */ /* synthetic */ BluetoothDevice m4491$$Nest$fgetmBluetoothDevice(DeviceMonitor r0) {
            return r0.mBluetoothDevice;
        }

        DeviceMonitor(BatteryController r3, int deviceId) {
            this.this$0 = r3;
            this.mHasBattery = false;
            this.mBluetoothEventTime = 0;
            this.mBluetoothBatteryLevel = -1;
            this.mBluetoothMetadataBatteryLevel = -1;
            this.mBluetoothMetadataBatteryStatus = 1;
            this.mState = new State(deviceId);
            long eventTime = SystemClock.uptimeMillis();
            configureDeviceMonitor(eventTime);
        }

        protected void processChangesAndNotify(long eventTime, Consumer<Long> changes) {
            State oldState = getBatteryStateForReporting();
            changes.accept(Long.valueOf(eventTime));
            State newState = getBatteryStateForReporting();
            if (oldState.equalsIgnoringUpdateTime(newState) == true) goto L6;
            BatteryController.m4484$$Nest$mnotifyAllListenersForDevice(this.this$0, newState);
            return;
        }

        public void onConfiguration(long eventTime) {
            processChangesAndNotify(eventTime, new BatteryController$DeviceMonitor$$ExternalSyntheticLambda2(this));
        }

        private void configureDeviceMonitor(long eventTime) {
            int deviceId = ((IInputDeviceBatteryState) this.mState).deviceId;
            if (this.mHasBattery == BatteryController.m4482$$Nest$mhasBattery(this.this$0, ((IInputDeviceBatteryState) this.mState).deviceId)) goto L9;
            this.mHasBattery = !this.mHasBattery;
            if (this.mHasBattery == false) goto L7;
            startNativeMonitoring();
        L8:
            updateBatteryStateFromNative(eventTime);
            goto L9
        L7:
            stopNativeMonitoring();
        L9:
            BluetoothDevice bluetoothDevice = BatteryController.m4476$$Nest$mgetBluetoothDevice(this.this$0, deviceId);
            if (Objects.equals(this.mBluetoothDevice, bluetoothDevice) == false) goto L12;
            return;
        L12:
            if (BatteryController.m4487$$Nest$sfgetDEBUG() == false) goto L18;
            String r2 = BatteryController.m4488$$Nest$sfgetTAG();
            StringBuilder r3 = new StringBuilder();
            r3.append("Bluetooth device is now ");
            if (bluetoothDevice == null) goto L16;
            String r4 = "";
        L17:
            r3.append(r4);
            r3.append(" present for deviceId ");
            r3.append(deviceId);
            Slog.d(r2, r3.toString());
            goto L18
        L16:
            r4 = "not";
        L18:
            this.mBluetoothBatteryLevel = -1;
            stopBluetoothMetadataMonitoring();
            this.mBluetoothDevice = bluetoothDevice;
            BatteryController.m4486$$Nest$mupdateBluetoothBatteryMonitoring(this.this$0);
            if (this.mBluetoothDevice == null) goto L23;
            this.mBluetoothBatteryLevel = BatteryController.m4470$$Nest$fgetmBluetoothBatteryManager(this.this$0).getBatteryLevel(this.mBluetoothDevice.getAddress());
            startBluetoothMetadataMonitoring(eventTime);
            return;
        }

        private void startNativeMonitoring() {
            String batteryPath = BatteryController.m4474$$Nest$fgetmNative(this.this$0).getBatteryDevicePath(((IInputDeviceBatteryState) this.mState).deviceId);
            if (batteryPath != null) goto L5;
            return;
        L5:
            final int deviceId = ((IInputDeviceBatteryState) this.mState).deviceId;
            this.mUEventBatteryListener = new AnonymousClass1(this, deviceId);
            BatteryController.m4475$$Nest$fgetmUEventManager(this.this$0).addListener(this.mUEventBatteryListener, "DEVPATH=" + formatDevPath(batteryPath));
        }

        private String formatDevPath(String path) {
            if (path.startsWith("/sys") == false) goto L6;
            return path.substring(4);
        L6:
            return path;
        }

        private void stopNativeMonitoring() {
            if (this.mUEventBatteryListener == null) goto L6;
            BatteryController.m4475$$Nest$fgetmUEventManager(this.this$0).removeListener(this.mUEventBatteryListener);
            this.mUEventBatteryListener = null;
            return;
        }

        private void startBluetoothMetadataMonitoring(long eventTime) {
            this.mBluetoothDevice.getClass();
            final BatteryController r0 = this.this$0;
            this.mBluetoothMetadataListener = new BatteryController$DeviceMonitor$$ExternalSyntheticLambda1(r0);
            BatteryController.m4470$$Nest$fgetmBluetoothBatteryManager(this.this$0).addMetadataListener(this.mBluetoothDevice.getAddress(), this.mBluetoothMetadataListener);
            updateBluetoothMetadataState(eventTime, 18, BatteryController.m4470$$Nest$fgetmBluetoothBatteryManager(this.this$0).getMetadata(this.mBluetoothDevice.getAddress(), 18));
            updateBluetoothMetadataState(eventTime, 19, BatteryController.m4470$$Nest$fgetmBluetoothBatteryManager(this.this$0).getMetadata(this.mBluetoothDevice.getAddress(), 19));
        }

        private void stopBluetoothMetadataMonitoring() {
            if (this.mBluetoothMetadataListener != null) goto L5;
            return;
        L5:
            this.mBluetoothDevice.getClass();
            BatteryController.m4470$$Nest$fgetmBluetoothBatteryManager(this.this$0).removeMetadataListener(this.mBluetoothDevice.getAddress(), this.mBluetoothMetadataListener);
            this.mBluetoothMetadataListener = null;
            this.mBluetoothMetadataBatteryLevel = -1;
            this.mBluetoothMetadataBatteryStatus = 1;
        }

        public void onMonitorDestroy() {
            stopNativeMonitoring();
            stopBluetoothMetadataMonitoring();
            this.mBluetoothDevice = null;
            BatteryController.m4486$$Nest$mupdateBluetoothBatteryMonitoring(this.this$0);
        }

        protected void updateBatteryStateFromNative(long eventTime) {
            this.mState.updateIfChanged(BatteryController.m4485$$Nest$mqueryBatteryStateFromNative(this.this$0, ((IInputDeviceBatteryState) this.mState).deviceId, eventTime, this.mHasBattery));
        }

        public void onPoll(long eventTime) {
            processChangesAndNotify(eventTime, new BatteryController$DeviceMonitor$$ExternalSyntheticLambda0(this));
        }

        public void onUEvent(long eventTime) {
            processChangesAndNotify(eventTime, new BatteryController$DeviceMonitor$$ExternalSyntheticLambda0(this));
        }

        public void onBluetoothBatteryChanged(long eventTime, final int bluetoothBatteryLevel) {
            processChangesAndNotify(eventTime, new BatteryController$DeviceMonitor$$ExternalSyntheticLambda5(this, bluetoothBatteryLevel));
        }

        private /* synthetic */ void lambda$onBluetoothBatteryChanged$0(int bluetoothBatteryLevel, Long time) {
            this.mBluetoothBatteryLevel = bluetoothBatteryLevel;
            this.mBluetoothEventTime = time.longValue();
        }

        public void onBluetoothMetadataChanged(long eventTime, final int key, final byte[] value) {
            processChangesAndNotify(eventTime, new BatteryController$DeviceMonitor$$ExternalSyntheticLambda3(this, key, value));
        }

        private /* synthetic */ void lambda$onBluetoothMetadataChanged$1(int key, byte[] value, Long time) {
            updateBluetoothMetadataState(time.longValue(), key, value);
        }

        private void updateBluetoothMetadataState(long eventTime, int key, byte[] value) {
            switch(key) {
                case 18: goto L12;
                case 19: goto L4;
                default: goto L23;
            };
        L4:
            this.mBluetoothEventTime = eventTime;
            if (value != null) goto L7;
            this.mBluetoothMetadataBatteryStatus = 1;
            return;
        L7:
            if (Boolean.parseBoolean(new String(value)) == false) goto L9;
            int r0 = 2;
        L10:
            this.mBluetoothMetadataBatteryStatus = r0;
            return;
        L9:
            r0 = 3;
            goto L10
        L12:
            this.mBluetoothEventTime = eventTime;
            this.mBluetoothMetadataBatteryLevel = -1;
            if (value == null) goto L22;
            this.mBluetoothMetadataBatteryLevel = Integer.parseInt(new String(value));     // Catch: NumberFormatException -> L16
            return;
        L17:
            Slog.wtf(BatteryController.m4488$$Nest$sfgetTAG(), "Failed to parse bluetooth METADATA_MAIN_BATTERY with value '" + new String(value) + "' for device " + this.mBluetoothDevice);
            return;
        L22:
            return;
        }

        public boolean requiresPolling() {
            return true;
        }

        public boolean isPersistent() {
            return false;
        }

        public void onTimeout(long eventTime) {
        }

        public void onStylusGestureStarted(long eventTime) {
        }

        public State getBatteryStateForReporting() {
            return (State) Objects.requireNonNullElseGet(resolveBluetoothBatteryState(), new BatteryController$DeviceMonitor$$ExternalSyntheticLambda4(this));
        }

        private /* synthetic */ State lambda$getBatteryStateForReporting$2() {
            return new State(this.mState);
        }

        protected State resolveBluetoothBatteryState() {
            if (this.mBluetoothMetadataBatteryLevel >= 0) goto L5;
        L7:
            int level = this.mBluetoothBatteryLevel;
            if (level >= 0) goto L10;
            return null;
        L10:
            if (this.mBluetoothBatteryLevel > 100) goto L16;
            int level2 = this.mBluetoothBatteryLevel;
        L13:
            return new State(((IInputDeviceBatteryState) this.mState).deviceId, this.mBluetoothEventTime, true, this.mBluetoothMetadataBatteryStatus, level2 / 100.0f);
        L16:
            return null;
        L5:
            if (this.mBluetoothMetadataBatteryLevel > 100) goto L7;
            level2 = this.mBluetoothMetadataBatteryLevel;
            goto L13
        }

        public String toString() {
            StringBuilder r0 = new StringBuilder();
            r0.append("DeviceId=");
            r0.append(((IInputDeviceBatteryState) this.mState).deviceId);
            r0.append(", Name='");
            r0.append(BatteryController.m4477$$Nest$mgetInputDeviceName(this.this$0, ((IInputDeviceBatteryState) this.mState).deviceId));
            r0.append("', NativeBattery=");
            r0.append(this.mState);
            r0.append(", UEventListener=");
            if (this.mUEventBatteryListener == null) goto L5;
            String r1 = "added";
        L6:
            r0.append(r1);
            r0.append(", BluetoothState=");
            r0.append(resolveBluetoothBatteryState());
            return r0.toString();
        L5:
            r1 = "none";
            goto L6
        }
    }

    private class ListenerRecord {
        public final IBinder.DeathRecipient mDeathRecipient;
        public final IInputDeviceBatteryListener mListener;
        public final Set<Integer> mMonitoredDevices;
        public final int mPid;
        final /* synthetic */ BatteryController this$0;

        public static /* synthetic */ void $r8$lambda$ZBlwIivbKgnBE15a7ZyblIFDLYc(ListenerRecord r0, int r1) {
            r0.lambda$new$0(r1);
        }

        ListenerRecord(BatteryController r1, final int pid, IInputDeviceBatteryListener listener) {
            this.this$0 = r1;
            this.mPid = pid;
            this.mListener = listener;
            this.mMonitoredDevices = new ArraySet();
            this.mDeathRecipient = new BatteryController$ListenerRecord$$ExternalSyntheticLambda0(this, pid);
        }

        private /* synthetic */ void lambda$new$0(int pid) {
            BatteryController.m4479$$Nest$mhandleListeningProcessDied(this.this$0, pid);
        }

        public String toString() {
            return "pid=" + this.mPid + ", monitored devices=" + Arrays.toString(this.mMonitoredDevices.toArray());
        }
    }

    private static class LocalBluetoothBatteryManager implements BluetoothBatteryManager {
        private final BroadcastReceiver mBroadcastReceiver;
        private final Context mContext;
        private final Executor mExecutor;
        private BluetoothBatteryManager.BluetoothBatteryListener mRegisteredListener;

        /* JADX INFO: renamed from: -$$Nest$fgetmBroadcastReceiver, reason: not valid java name */
        static /* bridge */ /* synthetic */ BroadcastReceiver m4492$$Nest$fgetmBroadcastReceiver(LocalBluetoothBatteryManager r0) {
            return r0.mBroadcastReceiver;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmRegisteredListener, reason: not valid java name */
        static /* bridge */ /* synthetic */ BluetoothBatteryManager.BluetoothBatteryListener m4493$$Nest$fgetmRegisteredListener(LocalBluetoothBatteryManager r0) {
            return r0.mRegisteredListener;
        }

        LocalBluetoothBatteryManager(Context context, Looper looper) {
            this.mBroadcastReceiver = new AnonymousClass1(this);
            this.mContext = context;
            this.mExecutor = new HandlerExecutor(new Handler(looper));
        }

        @Override // com.android.server.input.BatteryController.BluetoothBatteryManager
        public void addBatteryListener(BluetoothBatteryManager.BluetoothBatteryListener listener) {
            BroadcastReceiver r0 = this.mBroadcastReceiver;
            monitor-enter(r0);
        L9:
            th = move-exception;
            throw th;
        L5:
            if (this.mRegisteredListener != null) goto L12;
            this.mRegisteredListener = listener;     // Catch: Throwable -> L9
            this.mContext.registerReceiver(this.mBroadcastReceiver, new IntentFilter("android.bluetooth.device.action.BATTERY_LEVEL_CHANGED"));     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            return;
        L12:
            throw new IllegalStateException("Only one bluetooth battery listener can be registered at once.");     // Catch: Throwable -> L9
        }

        @Override // com.android.server.input.BatteryController.BluetoothBatteryManager
        public void removeBatteryListener(BluetoothBatteryManager.BluetoothBatteryListener listener) {
            BroadcastReceiver r0 = this.mBroadcastReceiver;
            monitor-enter(r0);
        L9:
            th = move-exception;
            throw th;
        L5:
            if (listener.equals(this.mRegisteredListener) == false) goto L12;
            this.mRegisteredListener = null;     // Catch: Throwable -> L9
            this.mContext.unregisterReceiver(this.mBroadcastReceiver);     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            return;
        L12:
            throw new IllegalStateException("Listener is not registered.");     // Catch: Throwable -> L9
        }

        @Override // com.android.server.input.BatteryController.BluetoothBatteryManager
        public int getBatteryLevel(String address) {
            return BatteryController.m4489$$Nest$smgetBluetoothDevice(this.mContext, address).getBatteryLevel();
        }

        @Override // com.android.server.input.BatteryController.BluetoothBatteryManager
        public void addMetadataListener(String address, BluetoothAdapter.OnMetadataChangedListener listener) {
            BluetoothManager r0 = (BluetoothManager) this.mContext.getSystemService(BluetoothManager.class);
            r0.getClass();
            r0.getAdapter().addOnMetadataChangedListener(BatteryController.m4489$$Nest$smgetBluetoothDevice(this.mContext, address), this.mExecutor, listener);
        }

        @Override // com.android.server.input.BatteryController.BluetoothBatteryManager
        public void removeMetadataListener(String address, BluetoothAdapter.OnMetadataChangedListener listener) {
            BluetoothManager r0 = (BluetoothManager) this.mContext.getSystemService(BluetoothManager.class);
            r0.getClass();
            r0.getAdapter().removeOnMetadataChangedListener(BatteryController.m4489$$Nest$smgetBluetoothDevice(this.mContext, address), listener);
        }

        @Override // com.android.server.input.BatteryController.BluetoothBatteryManager
        public byte[] getMetadata(String address, int key) {
            return BatteryController.m4489$$Nest$smgetBluetoothDevice(this.mContext, address).getMetadata(key);
        }
    }

    private static class State extends IInputDeviceBatteryState {
        State(int deviceId) {
            reset(deviceId);
        }

        State(IInputDeviceBatteryState s) {
            copyFrom(s);
        }

        State(int deviceId, long updateTime, boolean isPresent, int status, float capacity) {
            initialize(deviceId, updateTime, isPresent, status, capacity);
        }

        public void updateIfChanged(IInputDeviceBatteryState other) {
            if (equalsIgnoringUpdateTime(other) == true) goto L6;
            copyFrom(other);
            return;
        }

        public void reset(int deviceId) {
            initialize(deviceId, 0, false, 1, Float.NaN);
        }

        private void copyFrom(IInputDeviceBatteryState s) {
            initialize(s.deviceId, s.updateTime, s.isPresent, s.status, s.capacity);
        }

        private void initialize(int deviceId, long updateTime, boolean isPresent, int status, float capacity) {
            ((IInputDeviceBatteryState) this).deviceId = deviceId;
            ((IInputDeviceBatteryState) this).updateTime = updateTime;
            ((IInputDeviceBatteryState) this).isPresent = isPresent;
            ((IInputDeviceBatteryState) this).status = status;
            ((IInputDeviceBatteryState) this).capacity = capacity;
        }

        public boolean equalsIgnoringUpdateTime(IInputDeviceBatteryState other) {
            long updateTime = ((IInputDeviceBatteryState) this).updateTime;
            ((IInputDeviceBatteryState) this).updateTime = other.updateTime;
            boolean eq = equals(other);
            ((IInputDeviceBatteryState) this).updateTime = updateTime;
            return eq;
        }

        public String toString() {
            if (((IInputDeviceBatteryState) this).isPresent == true) goto L7;
            return "State{<not present>}";
        L7:
            return "State{time=" + ((IInputDeviceBatteryState) this).updateTime + ", isPresent=" + ((IInputDeviceBatteryState) this).isPresent + ", status=" + ((IInputDeviceBatteryState) this).status + ", capacity=" + ((IInputDeviceBatteryState) this).capacity + "}";
        }
    }

    static abstract class UEventBatteryListener extends UEventManager.UEventListener {
        public abstract void onBatteryUEvent(long r1);

        UEventBatteryListener() {
        }

        @Override // com.android.server.input.UEventManager.UEventListener
        public void onUEvent(UEventObserver.UEvent event) {
            long eventTime = SystemClock.uptimeMillis();
            if (BatteryController.m4487$$Nest$sfgetDEBUG() == false) goto L6;
            Slog.d(BatteryController.m4488$$Nest$sfgetTAG(), "UEventListener: Received UEvent: " + event + " eventTime: " + eventTime);
        L6:
            if ("CHANGE".equalsIgnoreCase(event.get("ACTION")) == true) goto L8;
            return;
        L8:
            if ("POWER_SUPPLY".equalsIgnoreCase(event.get("SUBSYSTEM")) == false) goto L13;
            onBatteryUEvent(eventTime);
            return;
        }
    }

    private class UsiDeviceMonitor extends DeviceMonitor {
        private Runnable mValidityTimeoutCallback;
        final /* synthetic */ BatteryController this$0;

        /* JADX INFO: renamed from: $r8$lambda$-cJNuCsN_d_xc1htYugv1m1kpj8, reason: not valid java name */
        public static /* synthetic */ void m4494$r8$lambda$cJNuCsN_d_xc1htYugv1m1kpj8(UsiDeviceMonitor r0, Long r1) {
            r0.lambda$onUEvent$0(r1);
        }

        public static /* synthetic */ void $r8$lambda$8fX_uneh3sMSg7Nh4NCXiMfLUrM(UsiDeviceMonitor r0, Long r1) {
            r0.lambda$onTimeout$2(r1);
        }

        public static /* synthetic */ void $r8$lambda$KkZZhhONz8E8IZlxv9I0cQ6pZn0(UsiDeviceMonitor r0, int r1) {
            r0.lambda$markUsiBatteryValid$3(r1);
        }

        public static /* synthetic */ void $r8$lambda$P0yvKLsgmQh0tOsIrcdm3xtui_E(UsiDeviceMonitor r0, Long r1) {
            r0.lambda$onStylusGestureStarted$1(r1);
        }

        public static /* synthetic */ State $r8$lambda$tQWu7C6DnJYXYPqff9ccyFapESQ(UsiDeviceMonitor r0) {
            return r0.lambda$getBatteryStateForReporting$4();
        }

        UsiDeviceMonitor(BatteryController r1, int deviceId) {
            this.this$0 = r1;
            super(r1, deviceId);
        }

        @Override // com.android.server.input.BatteryController.DeviceMonitor
        public void onPoll(long eventTime) {
        }

        @Override // com.android.server.input.BatteryController.DeviceMonitor
        public void onUEvent(long eventTime) {
            processChangesAndNotify(eventTime, new BatteryController$UsiDeviceMonitor$$ExternalSyntheticLambda1(this));
        }

        private /* synthetic */ void lambda$onUEvent$0(Long time) {
            updateBatteryStateFromNative(time.longValue());
            markUsiBatteryValid();
        }

        @Override // com.android.server.input.BatteryController.DeviceMonitor
        public void onStylusGestureStarted(long eventTime) {
            processChangesAndNotify(eventTime, new BatteryController$UsiDeviceMonitor$$ExternalSyntheticLambda0(this));
        }

        private /* synthetic */ void lambda$onStylusGestureStarted$1(Long time) {
            if (this.mValidityTimeoutCallback == null) goto L5;
            boolean wasValid = true;
        L6:
            if (wasValid == false) goto L8;
        L10:
            markUsiBatteryValid();
            return;
        L8:
            if (((IInputDeviceBatteryState) this.mState).capacity != 0.0f) goto L10;
            return;
        L5:
            wasValid = false;
            goto L6
        }

        private /* synthetic */ void lambda$onTimeout$2(Long time) {
            markUsiBatteryInvalid();
        }

        @Override // com.android.server.input.BatteryController.DeviceMonitor
        public void onTimeout(long eventTime) {
            processChangesAndNotify(eventTime, new BatteryController$UsiDeviceMonitor$$ExternalSyntheticLambda4(this));
        }

        @Override // com.android.server.input.BatteryController.DeviceMonitor
        public void onConfiguration(long eventTime) {
            super.onConfiguration(eventTime);
            if (this.mHasBattery == false) goto L6;
            return;
        L6:
            throw new IllegalStateException("UsiDeviceMonitor: USI devices are always expected to report a valid battery, but no battery was detected!");
        }

        private void markUsiBatteryValid() {
            if (this.mValidityTimeoutCallback == null) goto L5;
            BatteryController.m4472$$Nest$fgetmHandler(this.this$0).removeCallbacks(this.mValidityTimeoutCallback);
        L6:
            BatteryController.m4472$$Nest$fgetmHandler(this.this$0).postDelayed(this.mValidityTimeoutCallback, 3600000);
            return;
        L5:
            final int deviceId = ((IInputDeviceBatteryState) this.mState).deviceId;
            this.mValidityTimeoutCallback = new BatteryController$UsiDeviceMonitor$$ExternalSyntheticLambda3(this, deviceId);
            goto L6
        }

        private /* synthetic */ void lambda$markUsiBatteryValid$3(int deviceId) {
            BatteryController.m4480$$Nest$mhandleMonitorTimeout(this.this$0, deviceId);
        }

        private void markUsiBatteryInvalid() {
            if (this.mValidityTimeoutCallback != null) goto L5;
            return;
        L5:
            BatteryController.m4472$$Nest$fgetmHandler(this.this$0).removeCallbacks(this.mValidityTimeoutCallback);
            this.mValidityTimeoutCallback = null;
        }

        @Override // com.android.server.input.BatteryController.DeviceMonitor
        public State getBatteryStateForReporting() {
            return (State) Objects.requireNonNullElseGet(resolveBluetoothBatteryState(), new BatteryController$UsiDeviceMonitor$$ExternalSyntheticLambda2(this));
        }

        private /* synthetic */ State lambda$getBatteryStateForReporting$4() {
            if (this.mValidityTimeoutCallback == null) goto L6;
            return new State(this.mState);
        L6:
            return new State(((IInputDeviceBatteryState) this.mState).deviceId);
        }

        @Override // com.android.server.input.BatteryController.DeviceMonitor
        public boolean requiresPolling() {
            return false;
        }

        @Override // com.android.server.input.BatteryController.DeviceMonitor
        public boolean isPersistent() {
            return true;
        }

        @Override // com.android.server.input.BatteryController.DeviceMonitor
        public String toString() {
            StringBuilder r0 = new StringBuilder();
            r0.append(super.toString());
            r0.append(", UsiStateIsValid=");
            if (this.mValidityTimeoutCallback == null) goto L5;
            boolean r1 = true;
        L6:
            r0.append(r1);
            return r0.toString();
        L5:
            r1 = false;
            goto L6
        }
    }

    public static /* synthetic */ void $r8$lambda$8D5bOF2yXHmJbX30VIhNcd9306c(State r0, Integer r1, ListenerRecord r2) {
        lambda$notifyAllListenersForDevice$0(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$CQleDsNEE174VGVNEyfPVkU2Ab0(BatteryController r0) {
        r0.handlePollEvent();
    }

    public static /* synthetic */ boolean $r8$lambda$OH_whUZINAnrsAjHUF7NrVOQfsg(BluetoothDevice r0, DeviceMonitor r1) {
        return lambda$handleBluetoothMetadataChange$4(r0, r1);
    }

    public static /* synthetic */ boolean $r8$lambda$cnxGh4zKgvrsQ3_5r00_WgS_whE(String r0, DeviceMonitor r1) {
        return lambda$handleBluetoothBatteryLevelChange$3(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$kHxElP6jGL2CI2h9-PGs0oeXj6g, reason: not valid java name */
    public static /* synthetic */ void m4469$r8$lambda$kHxElP6jGL2CI2h9PGs0oeXj6g(BatteryController r0, long r1, String r3, int r4) {
        r0.handleBluetoothBatteryLevelChange(r1, r3, r4);
    }

    public static /* synthetic */ Boolean $r8$lambda$n6_ejU_h9YIm1A7iCB3zx5esPWg(InputDevice r0) {
        return lambda$isUsiDevice$1(r0);
    }

    public static /* synthetic */ boolean $r8$lambda$uXL3tRDSIIozxS3fEjf8MUOs07c(DeviceMonitor r0) {
        return lambda$updateBluetoothBatteryMonitoring$5(r0);
    }

    public static /* synthetic */ void $r8$lambda$wwmhpf6g1js9PibUpk1hcymg6EQ(long r0, Integer r2, DeviceMonitor r3) {
        lambda$handlePollEvent$2(r0, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmBluetoothBatteryManager, reason: not valid java name */
    static /* bridge */ /* synthetic */ BluetoothBatteryManager m4470$$Nest$fgetmBluetoothBatteryManager(BatteryController r0) {
        return r0.mBluetoothBatteryManager;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmDeviceMonitors, reason: not valid java name */
    static /* bridge */ /* synthetic */ ArrayMap m4471$$Nest$fgetmDeviceMonitors(BatteryController r0) {
        return r0.mDeviceMonitors;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmHandler, reason: not valid java name */
    static /* bridge */ /* synthetic */ Handler m4472$$Nest$fgetmHandler(BatteryController r0) {
        return r0.mHandler;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m4473$$Nest$fgetmLock(BatteryController r0) {
        return r0.mLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmNative, reason: not valid java name */
    static /* bridge */ /* synthetic */ NativeInputManagerService m4474$$Nest$fgetmNative(BatteryController r0) {
        return r0.mNative;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmUEventManager, reason: not valid java name */
    static /* bridge */ /* synthetic */ UEventManager m4475$$Nest$fgetmUEventManager(BatteryController r0) {
        return r0.mUEventManager;
    }

    /* JADX INFO: renamed from: -$$Nest$mgetBluetoothDevice, reason: not valid java name */
    static /* bridge */ /* synthetic */ BluetoothDevice m4476$$Nest$mgetBluetoothDevice(BatteryController r0, int r1) {
        return r0.getBluetoothDevice(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mgetInputDeviceName, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m4477$$Nest$mgetInputDeviceName(BatteryController r0, int r1) {
        return r0.getInputDeviceName(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleBluetoothMetadataChange, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4478$$Nest$mhandleBluetoothMetadataChange(BatteryController r0, BluetoothDevice r1, int r2, byte[] r3) {
        r0.handleBluetoothMetadataChange(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleListeningProcessDied, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4479$$Nest$mhandleListeningProcessDied(BatteryController r0, int r1) {
        r0.handleListeningProcessDied(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleMonitorTimeout, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4480$$Nest$mhandleMonitorTimeout(BatteryController r0, int r1) {
        r0.handleMonitorTimeout(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleUEventNotification, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4481$$Nest$mhandleUEventNotification(BatteryController r0, int r1, long r2) {
        r0.handleUEventNotification(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mhasBattery, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m4482$$Nest$mhasBattery(BatteryController r0, int r1) {
        return r0.hasBattery(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$misUsiDevice, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m4483$$Nest$misUsiDevice(BatteryController r0, int r1) {
        return r0.isUsiDevice(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mnotifyAllListenersForDevice, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4484$$Nest$mnotifyAllListenersForDevice(BatteryController r0, State r1) {
        r0.notifyAllListenersForDevice(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mqueryBatteryStateFromNative, reason: not valid java name */
    static /* bridge */ /* synthetic */ State m4485$$Nest$mqueryBatteryStateFromNative(BatteryController r0, int r1, long r2, boolean r4) {
        return r0.queryBatteryStateFromNative(r1, r2, r4);
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateBluetoothBatteryMonitoring, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4486$$Nest$mupdateBluetoothBatteryMonitoring(BatteryController r0) {
        r0.updateBluetoothBatteryMonitoring();
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetDEBUG, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m4487$$Nest$sfgetDEBUG() {
        return DEBUG;
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetTAG, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m4488$$Nest$sfgetTAG() {
        return TAG;
    }

    /* JADX INFO: renamed from: -$$Nest$smgetBluetoothDevice, reason: not valid java name */
    static /* bridge */ /* synthetic */ BluetoothDevice m4489$$Nest$smgetBluetoothDevice(Context r0, String r1) {
        return getBluetoothDevice(r0, r1);
    }

    static {
        TAG = BatteryController.class.getSimpleName();
        DEBUG = Log.isLoggable(TAG, 3);
    }

    BatteryController(Context context, NativeInputManagerService nativeService, Looper looper, UEventManager uEventManager) {
        this(context, nativeService, looper, uEventManager, new LocalBluetoothBatteryManager(context, looper));
    }

    BatteryController(Context context, NativeInputManagerService nativeService, Looper looper, UEventManager uEventManager, BluetoothBatteryManager bbm) {
        this.mLock = new Object();
        this.mHandlePollEventCallback = new BatteryController$$ExternalSyntheticLambda8(this);
        this.mListenerRecords = new ArrayMap();
        this.mDeviceMonitors = new ArrayMap();
        this.mIsPolling = false;
        this.mIsInteractive = true;
        this.mInputDeviceListener = new AnonymousClass1(this);
        this.mContext = context;
        this.mNative = nativeService;
        this.mHandler = new Handler(looper);
        this.mUEventManager = uEventManager;
        this.mBluetoothBatteryManager = bbm;
    }

    public void systemRunning() {
        InputManager inputManager = (InputManager) this.mContext.getSystemService(InputManager.class);
        inputManager.getClass();
        inputManager.registerInputDeviceListener(this.mInputDeviceListener, this.mHandler);
        int[] r1 = inputManager.getInputDeviceIds();
        int r2 = r1.length;
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L5;
        int deviceId = r1[r3];
        this.mInputDeviceListener.onInputDeviceAdded(deviceId);
        r3 = r3 + 1;
        goto L3
    }

    public void registerBatteryListener(int deviceId, IInputDeviceBatteryListener listener, int pid) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        ListenerRecord listenerRecord = this.mListenerRecords.get(Integer.valueOf(pid));     // Catch: Throwable -> L12
        if (listenerRecord != null) goto L19;
        listenerRecord = new ListenerRecord(this, pid, listener);     // Catch: Throwable -> L12
        listener.asBinder().linkToDeath(listenerRecord.mDeathRecipient, 0);     // Catch: Throwable -> L12 RemoteException -> L14
        this.mListenerRecords.put(Integer.valueOf(pid), listenerRecord);     // Catch: Throwable -> L12
        if (DEBUG == false) goto L19;
        Slog.d(TAG, "Battery listener added for pid " + pid);     // Catch: Throwable -> L12
        goto L19
    L15:
        Slog.i(TAG, "Client died before battery listener could be registered.");     // Catch: Throwable -> L12
        return;
    L19:
        if (listenerRecord.mListener.asBinder() != listener.asBinder()) goto L34;
        if (listenerRecord.mMonitoredDevices.add(Integer.valueOf(deviceId)) == false) goto L32;
        DeviceMonitor monitor = this.mDeviceMonitors.get(Integer.valueOf(deviceId));     // Catch: Throwable -> L12
        if (monitor != null) goto L26;
        monitor = new DeviceMonitor(this, deviceId);     // Catch: Throwable -> L12
        this.mDeviceMonitors.put(Integer.valueOf(deviceId), monitor);     // Catch: Throwable -> L12
        updateBluetoothBatteryMonitoring();     // Catch: Throwable -> L12
    L26:
        if (DEBUG == false) goto L28;
        Slog.d(TAG, "Battery listener for pid " + pid + " is monitoring deviceId " + deviceId);     // Catch: Throwable -> L12
    L28:
        updatePollingLocked(true);     // Catch: Throwable -> L12
        notifyBatteryListener(listenerRecord, monitor.getBatteryStateForReporting());     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L32:
        throw new IllegalArgumentException("The battery listener for pid " + pid + " is already monitoring deviceId " + deviceId);     // Catch: Throwable -> L12
    L34:
        throw new SecurityException("Cannot register a new battery listener when there is already another registered listener for pid " + pid);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    }

    private static void notifyBatteryListener(ListenerRecord listenerRecord, State state) {
        listenerRecord.mListener.onBatteryStateChanged(state);     // Catch: RemoteException -> L4
    L7:
        if (DEBUG == false) goto L12;
        Slog.d(TAG, "Notified battery listener from pid " + listenerRecord.mPid + " of state of deviceId " + ((IInputDeviceBatteryState) state).deviceId);
        return;
    L12:
        return;
    L4:
        e = move-exception;
        Slog.e(TAG, "Failed to notify listener", e);
        goto L7
    }

    private void notifyAllListenersForDevice(final State state) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (DEBUG == false) goto L9;
        Slog.d(TAG, "Notifying all listeners of battery state: " + state);     // Catch: Throwable -> L7
    L9:
        this.mListenerRecords.forEach(new BatteryController$$ExternalSyntheticLambda6(state));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
    }

    private static /* synthetic */ void lambda$notifyAllListenersForDevice$0(State state, Integer pid, ListenerRecord listenerRecord) {
        if (listenerRecord.mMonitoredDevices.contains(Integer.valueOf(((IInputDeviceBatteryState) state).deviceId)) == false) goto L6;
        notifyBatteryListener(listenerRecord, state);
        return;
    }

    private void updatePollingLocked(boolean delayStart) {
        if (this.mIsInteractive == true) goto L5;
    L16:
        this.mIsPolling = false;
        this.mHandler.removeCallbacks(this.mHandlePollEventCallback);
        return;
    L5:
        if (anyOf(this.mDeviceMonitors, new BatteryController$$ExternalSyntheticLambda7()) == false) goto L16;
        if (this.mIsPolling == false) goto L10;
        return;
    L10:
        this.mIsPolling = true;
        Handler r0 = this.mHandler;
        Runnable r1 = this.mHandlePollEventCallback;
        if (delayStart == false) goto L13;
        long r2 = 10000;
    L14:
        r0.postDelayed(r1, r2);
        return;
    L13:
        r2 = 0;
        goto L14
    }

    private <R> R processInputDevice(int deviceId, R defaultValue, Function<InputDevice, R> func) {
        InputManager r0 = (InputManager) this.mContext.getSystemService(InputManager.class);
        r0.getClass();
        InputDevice device = r0.getInputDevice(deviceId);
        if (device != null) goto L6;
        return defaultValue;
    L6:
        return func.apply(device);
    }

    private String getInputDeviceName(int deviceId) {
        return (String) processInputDevice(deviceId, "<none>", new BatteryController$$ExternalSyntheticLambda0());
    }

    private boolean hasBattery(int deviceId) {
        return ((Boolean) processInputDevice(deviceId, false, new BatteryController$$ExternalSyntheticLambda3())).booleanValue();
    }

    private boolean isUsiDevice(int deviceId) {
        return ((Boolean) processInputDevice(deviceId, false, new BatteryController$$ExternalSyntheticLambda1())).booleanValue();
    }

    private static /* synthetic */ Boolean lambda$isUsiDevice$1(InputDevice device) {
        if (device.getHostUsiVersion() == null) goto L5;
        boolean r0 = true;
    L7:
        return Boolean.valueOf(r0);
    L5:
        r0 = false;
        goto L7
    }

    private BluetoothDevice getBluetoothDevice(int inputDeviceId) {
        return getBluetoothDevice(this.mContext, (String) processInputDevice(inputDeviceId, null, new BatteryController$$ExternalSyntheticLambda4()));
    }

    private static BluetoothDevice getBluetoothDevice(Context context, String address) {
        if (address != null) goto L5;
        return null;
    L5:
        BluetoothManager r0 = (BluetoothManager) context.getSystemService(BluetoothManager.class);
        r0.getClass();
        BluetoothAdapter adapter = r0.getAdapter();
        return adapter.getRemoteDevice(address);
    }

    private DeviceMonitor getDeviceMonitorOrThrowLocked(int deviceId) {
        DeviceMonitor r0 = this.mDeviceMonitors.get(Integer.valueOf(deviceId));
        String r1 = "Maps are out of sync: Cannot find device state for deviceId " + deviceId;
        r0.getClass();
        return r0;
    }

    public void unregisterBatteryListener(int deviceId, IInputDeviceBatteryListener listener, int pid) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        ListenerRecord listenerRecord = this.mListenerRecords.get(Integer.valueOf(pid));     // Catch: Throwable -> L13
        if (listenerRecord == null) goto L20;
        if (listenerRecord.mListener.asBinder() != listener.asBinder()) goto L18;
        if (listenerRecord.mMonitoredDevices.contains(Integer.valueOf(deviceId)) == false) goto L16;
        unregisterRecordLocked(listenerRecord, deviceId);     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
        return;
    L16:
        throw new IllegalArgumentException("Cannot unregister battery callback: The device is not being monitored for deviceId " + deviceId);     // Catch: Throwable -> L13
    L18:
        throw new IllegalArgumentException("Cannot unregister battery callback: The listener is not the one that is registered for pid " + pid);     // Catch: Throwable -> L13
    L20:
        throw new IllegalArgumentException("Cannot unregister battery callback: No listener registered for pid " + pid);     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    }

    private void unregisterRecordLocked(ListenerRecord listenerRecord, int deviceId) {
        int pid = listenerRecord.mPid;
        if (listenerRecord.mMonitoredDevices.remove(Integer.valueOf(deviceId)) == false) goto L17;
        if (hasRegisteredListenerForDeviceLocked(deviceId) == true) goto L10;
        DeviceMonitor monitor = getDeviceMonitorOrThrowLocked(deviceId);
        if (monitor.isPersistent() == true) goto L10;
        monitor.onMonitorDestroy();
        this.mDeviceMonitors.remove(Integer.valueOf(deviceId));
    L10:
        if (listenerRecord.mMonitoredDevices.isEmpty() == false) goto L14;
        listenerRecord.mListener.asBinder().unlinkToDeath(listenerRecord.mDeathRecipient, 0);
        this.mListenerRecords.remove(Integer.valueOf(pid));
        if (DEBUG == false) goto L14;
        Slog.d(TAG, "Battery listener removed for pid " + pid);
    L14:
        updatePollingLocked(false);
        return;
    L17:
        throw new IllegalStateException("Cannot unregister battery callback: The deviceId " + deviceId + " is not being monitored by pid " + pid);
    }

    private boolean hasRegisteredListenerForDeviceLocked(int deviceId) {
        int i = 0;
    L4:
        if (i >= this.mListenerRecords.size()) goto L10;
        if (this.mListenerRecords.valueAt(i).mMonitoredDevices.contains(Integer.valueOf(deviceId)) == true) goto L7;
        i = i + 1;
        goto L4
    L7:
        return true;
    L10:
        return false;
    }

    private void handleListeningProcessDied(int pid) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        ListenerRecord listenerRecord = this.mListenerRecords.get(Integer.valueOf(pid));     // Catch: Throwable -> L8
        if (listenerRecord != null) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L11:
        if (DEBUG == false) goto L13;
        Slog.d(TAG, "Removing battery listener for pid " + pid + " because the process died");     // Catch: Throwable -> L8
    L13:
        Iterator<Integer> r2 = listenerRecord.mMonitoredDevices.iterator();     // Catch: Throwable -> L8
    L15:
        if (r2.hasNext() == false) goto L17;
        int deviceId = r2.next().intValue();     // Catch: Throwable -> L8
        unregisterRecordLocked(listenerRecord, deviceId);     // Catch: Throwable -> L8
        goto L15
    L17:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private void handleUEventNotification(int deviceId, long eventTime) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        DeviceMonitor monitor = this.mDeviceMonitors.get(Integer.valueOf(deviceId));     // Catch: Throwable -> L8
        if (monitor != null) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        monitor.onUEvent(eventTime);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private void handlePollEvent() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mIsPolling == true) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        final long eventTime = SystemClock.uptimeMillis();     // Catch: Throwable -> L8
        this.mDeviceMonitors.forEach(new BatteryController$$ExternalSyntheticLambda9(eventTime));     // Catch: Throwable -> L8
        this.mHandler.postDelayed(this.mHandlePollEventCallback, 10000);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
    }

    private static /* synthetic */ void lambda$handlePollEvent$2(long eventTime, Integer deviceId, DeviceMonitor monitor) {
        monitor.onPoll(eventTime);
    }

    private void handleMonitorTimeout(int deviceId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        DeviceMonitor monitor = this.mDeviceMonitors.get(Integer.valueOf(deviceId));     // Catch: Throwable -> L8
        if (monitor != null) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        long updateTime = SystemClock.uptimeMillis();     // Catch: Throwable -> L8
        monitor.onTimeout(updateTime);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private void handleBluetoothBatteryLevelChange(long eventTime, final String address, int batteryLevel) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        DeviceMonitor monitor = (DeviceMonitor) findIf(this.mDeviceMonitors, new BatteryController$$ExternalSyntheticLambda2(address));     // Catch: Throwable -> L7
        if (monitor == null) goto L9;
        monitor.onBluetoothBatteryChanged(eventTime, batteryLevel);     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private static /* synthetic */ boolean lambda$handleBluetoothBatteryLevelChange$3(String address, DeviceMonitor m) {
        if (DeviceMonitor.m4491$$Nest$fgetmBluetoothDevice(m) != null) goto L5;
    L7:
        return false;
    L5:
        if (address.equals(DeviceMonitor.m4491$$Nest$fgetmBluetoothDevice(m).getAddress()) == false) goto L7;
        return true;
    }

    private void handleBluetoothMetadataChange(final BluetoothDevice device, int key, byte[] value) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        DeviceMonitor monitor = (DeviceMonitor) findIf(this.mDeviceMonitors, new BatteryController$$ExternalSyntheticLambda5(device));     // Catch: Throwable -> L7
        if (monitor == null) goto L9;
        long eventTime = SystemClock.uptimeMillis();     // Catch: Throwable -> L7
        monitor.onBluetoothMetadataChanged(eventTime, key, value);     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private static /* synthetic */ boolean lambda$handleBluetoothMetadataChange$4(BluetoothDevice device, DeviceMonitor m) {
        return device.equals(DeviceMonitor.m4491$$Nest$fgetmBluetoothDevice(m));
    }

    public IInputDeviceBatteryState getBatteryState(int deviceId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        long updateTime = SystemClock.uptimeMillis();     // Catch: Throwable -> L9
        DeviceMonitor monitor = this.mDeviceMonitors.get(Integer.valueOf(deviceId));     // Catch: Throwable -> L9
        if (monitor != null) goto L11;
        State r4 = queryBatteryStateFromNative(deviceId, updateTime, hasBattery(deviceId));     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r4;
    L11:
        monitor.onPoll(updateTime);     // Catch: Throwable -> L9
        State r5 = monitor.getBatteryStateForReporting();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r5;
    L9:
        th = move-exception;
        throw th;
    }

    public void onInteractiveChanged(boolean interactive) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mIsInteractive = interactive;     // Catch: Throwable -> L7
        updatePollingLocked(false);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void notifyStylusGestureStarted(int deviceId, long eventTime) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        DeviceMonitor monitor = this.mDeviceMonitors.get(Integer.valueOf(deviceId));     // Catch: Throwable -> L8
        if (monitor != null) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        monitor.onStylusGestureStarted(eventTime);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public void dump(PrintWriter pw) {
        IndentingPrintWriter ipw = new IndentingPrintWriter(pw);
        Object r1 = this.mLock;
        monitor-enter(r1);
        ipw.println(TAG + ":");     // Catch: Throwable -> L8
        ipw.increaseIndent();     // Catch: Throwable -> L8
        ipw.println("State: Polling = " + this.mIsPolling + ", Interactive = " + this.mIsInteractive);     // Catch: Throwable -> L8
        StringBuilder r2 = new StringBuilder();     // Catch: Throwable -> L8
        r2.append("Listeners: ");     // Catch: Throwable -> L8
        r2.append(this.mListenerRecords.size());     // Catch: Throwable -> L8
        r2.append(" battery listeners");     // Catch: Throwable -> L8
        ipw.println(r2.toString());     // Catch: Throwable -> L8
        ipw.increaseIndent();     // Catch: Throwable -> L8
        int i = 0;
    L6:
        if (i >= this.mListenerRecords.size()) goto L10;
        ipw.println(i + ": " + this.mListenerRecords.valueAt(i));     // Catch: Throwable -> L8
        i = i + 1;     // Catch: Throwable -> L8
        goto L6
    L10:
        ipw.decreaseIndent();     // Catch: Throwable -> L8
        ipw.println("Device Monitors: " + this.mDeviceMonitors.size() + " monitors");     // Catch: Throwable -> L8
        ipw.increaseIndent();     // Catch: Throwable -> L8
        int i2 = 0;
    L12:
        if (i2 >= this.mDeviceMonitors.size()) goto L14;
        ipw.println(i2 + ": " + this.mDeviceMonitors.valueAt(i2));     // Catch: Throwable -> L8
        i2 = i2 + 1;     // Catch: Throwable -> L8
        goto L12
    L14:
        ipw.decreaseIndent();     // Catch: Throwable -> L8
        ipw.decreaseIndent();     // Catch: Throwable -> L8
        monitor-exit(r1);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public void monitor() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        monitor-exit(r0);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    private State queryBatteryStateFromNative(int deviceId, long updateTime, boolean isPresent) {
        if (isPresent == false) goto L6;
        int r1 = this.mNative.getBatteryStatus(deviceId);
    L5:
        int r5 = r1;
        if (isPresent == false) goto L10;
        float r2 = this.mNative.getBatteryCapacity(deviceId) / 100.0f;
    L12:
        return new State(deviceId, updateTime, isPresent, r5, r2);
    L10:
        r2 = Float.NaN;
        goto L12
    L6:
        r1 = 1;
        goto L5
    }

    private void updateBluetoothBatteryMonitoring() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (anyOf(this.mDeviceMonitors, new BatteryController$$ExternalSyntheticLambda10()) == false) goto L15;
        if (this.mBluetoothBatteryListener == null) goto L9;
    L20:
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L9:
        if (DEBUG == false) goto L13;
        Slog.d(TAG, "Registering bluetooth battery listener");     // Catch: Throwable -> L11
    L13:
        this.mBluetoothBatteryListener = new BatteryController$$ExternalSyntheticLambda11(this);     // Catch: Throwable -> L11
        this.mBluetoothBatteryManager.addBatteryListener(this.mBluetoothBatteryListener);     // Catch: Throwable -> L11
        goto L20
    L15:
        if (this.mBluetoothBatteryListener == null) goto L20;
        if (DEBUG == false) goto L19;
        Slog.d(TAG, "Unregistering bluetooth battery listener");     // Catch: Throwable -> L11
    L19:
        this.mBluetoothBatteryManager.removeBatteryListener(this.mBluetoothBatteryListener);     // Catch: Throwable -> L11
        this.mBluetoothBatteryListener = null;     // Catch: Throwable -> L11
        goto L20
    }

    private static /* synthetic */ boolean lambda$updateBluetoothBatteryMonitoring$5(DeviceMonitor m) {
        if (DeviceMonitor.m4491$$Nest$fgetmBluetoothDevice(m) == null) goto L5;
        return true;
    L5:
        return false;
    }

    private static <K, V> boolean anyOf(ArrayMap<K, V> arrayMap, Predicate<V> test) {
        if (findIf(arrayMap, test) == null) goto L5;
        return true;
    L5:
        return false;
    }

    private static <K, V> V findIf(ArrayMap<K, V> arrayMap, Predicate<V> test) {
        int i = 0;
    L4:
        if (i >= arrayMap.size()) goto L9;
        V value = arrayMap.valueAt(i);
        if (test.test(value) == true) goto L7;
        i = i + 1;
        goto L4
    L7:
        return value;
    L9:
        return null;
    }
}
