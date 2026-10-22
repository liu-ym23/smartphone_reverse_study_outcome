package com.android.server.deviceidle;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Message;
import com.android.server.DeviceIdleInternal;

/* JADX INFO: loaded from: classes.dex */
public class BluetoothConstraint implements IDeviceIdleConstraint {
    private static final long INACTIVITY_TIMEOUT_MS = 1200000;
    private static final String TAG = null;
    private final BluetoothManager mBluetoothManager;
    private volatile boolean mConnected;
    private final Context mContext;
    private final Handler mHandler;
    private final DeviceIdleInternal mLocalService;
    private volatile boolean mMonitoring;
    final BroadcastReceiver mReceiver;
    private final Runnable mTimeoutCallback;

    public static /* synthetic */ void $r8$lambda$w8zIi9hadBqD0ZwgbpFasdgqwuc(BluetoothConstraint r0) {
        r0.lambda$new$0();
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLocalService, reason: not valid java name */
    static /* bridge */ /* synthetic */ DeviceIdleInternal m3318$$Nest$fgetmLocalService(BluetoothConstraint r0) {
        return r0.mLocalService;
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateAndReportActiveLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3319$$Nest$mupdateAndReportActiveLocked(BluetoothConstraint r0) {
        r0.updateAndReportActiveLocked();
    }

    static {
        TAG = BluetoothConstraint.class.getSimpleName();
    }

    public BluetoothConstraint(Context context, Handler handler, DeviceIdleInternal localService) {
        this.mConnected = true;
        this.mMonitoring = false;
        this.mReceiver = new AnonymousClass1(this);
        this.mTimeoutCallback = new BluetoothConstraint$$ExternalSyntheticLambda0(this);
        this.mContext = context;
        this.mHandler = handler;
        this.mLocalService = localService;
        this.mBluetoothManager = (BluetoothManager) this.mContext.getSystemService(BluetoothManager.class);
    }

    public synchronized void startMonitoring() {
        monitor-enter(this);
        this.mConnected = true;     // Catch: Throwable -> L7
        this.mMonitoring = true;     // Catch: Throwable -> L7
        IntentFilter filter = new IntentFilter();     // Catch: Throwable -> L7
        filter.addAction("android.bluetooth.device.action.ACL_DISCONNECTED");     // Catch: Throwable -> L7
        filter.addAction("android.bluetooth.device.action.ACL_CONNECTED");     // Catch: Throwable -> L7
        filter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");     // Catch: Throwable -> L7
        this.mContext.registerReceiver(this.mReceiver, filter);     // Catch: Throwable -> L7
        this.mHandler.sendMessageDelayed(Message.obtain(this.mHandler, this.mTimeoutCallback), INACTIVITY_TIMEOUT_MS);     // Catch: Throwable -> L7
        updateAndReportActiveLocked();     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public synchronized void stopMonitoring() {
        monitor-enter(this);
        this.mContext.unregisterReceiver(this.mReceiver);     // Catch: Throwable -> L6
        this.mHandler.removeCallbacks(this.mTimeoutCallback);     // Catch: Throwable -> L6
        this.mMonitoring = false;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    private synchronized void cancelMonitoringDueToTimeout() {
        monitor-enter(this);
    L7:
        th = move-exception;
        throw th;
    L4:
        if (this.mMonitoring == false) goto L9;
        this.mMonitoring = false;     // Catch: Throwable -> L7
        this.mLocalService.onConstraintStateChanged(this, false);     // Catch: Throwable -> L7
    L9:
        monitor-exit(this);
    }

    private void updateAndReportActiveLocked() {
        boolean connected = isBluetoothConnected(this.mBluetoothManager);
        if (connected == this.mConnected) goto L6;
        this.mConnected = connected;
        this.mLocalService.onConstraintStateChanged(this, this.mConnected);
        return;
    }

    static boolean isBluetoothConnected(BluetoothManager bluetoothManager) {
        BluetoothAdapter adapter = bluetoothManager.getAdapter();
        if (adapter != null) goto L5;
    L10:
        return false;
    L5:
        if (adapter.isEnabled() == false) goto L10;
        if (bluetoothManager.getConnectedDevices(7).size() <= 0) goto L11;
        return true;
    L11:
        return false;
    }

    private /* synthetic */ void lambda$new$0() {
        cancelMonitoringDueToTimeout();
    }
}
