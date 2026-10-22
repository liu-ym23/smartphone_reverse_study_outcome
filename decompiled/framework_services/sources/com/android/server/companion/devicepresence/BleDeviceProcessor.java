package com.android.server.companion.devicepresence;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanFilter;
import android.bluetooth.le.ScanSettings;
import android.companion.AssociationInfo;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.util.Slog;
import com.android.server.companion.association.AssociationStore;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
class BleDeviceProcessor implements AssociationStore.OnChangeListener {
    private static final ScanSettings SCAN_SETTINGS = null;
    private static final String TAG = "CDM_BleDeviceProcessor";
    private final AssociationStore mAssociationStore;
    private BluetoothLeScanner mBleScanner;
    private BluetoothAdapter mBtAdapter;
    private final Callback mCallback;
    private final ScanCallback mScanCallback;
    private boolean mScanning;

    /* JADX INFO: renamed from: com.android.server.companion.devicepresence.BleDeviceProcessor$1, reason: invalid class name */
    class AnonymousClass1 extends BroadcastReceiver {
        final /* synthetic */ BleDeviceProcessor this$0;

        /* JADX INFO: renamed from: $r8$lambda$GG5h9OK5k90dQ3r6u26HI7ldv-E, reason: not valid java name */
        public static /* synthetic */ void m2953$r8$lambda$GG5h9OK5k90dQ3r6u26HI7ldvE(AnonymousClass1 r0) {
            r0.lambda$onReceive$0();
        }

        AnonymousClass1(BleDeviceProcessor this$0) {
            this.this$0 = this$0;
        }

        private /* synthetic */ void lambda$onReceive$0() {
            BleDeviceProcessor.m2949$$Nest$mcheckBleState(this.this$0);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            new Handler(Looper.getMainLooper()).post(new BleDeviceProcessor$1$$ExternalSyntheticLambda0(this));
        }
    }

    interface Callback {
        void onBleCompanionDeviceFound(int r1, int r2);

        void onBleCompanionDeviceLost(int r1, int r2);
    }

    /* JADX INFO: renamed from: -$$Nest$fputmScanning, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2948$$Nest$fputmScanning(BleDeviceProcessor r0, boolean r1) {
        r0.mScanning = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$mcheckBleState, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2949$$Nest$mcheckBleState(BleDeviceProcessor r0) {
        r0.checkBleState();
    }

    /* JADX INFO: renamed from: -$$Nest$mnotifyDeviceFound, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2950$$Nest$mnotifyDeviceFound(BleDeviceProcessor r0, BluetoothDevice r1) {
        r0.notifyDeviceFound(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mnotifyDeviceLost, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2951$$Nest$mnotifyDeviceLost(BleDeviceProcessor r0, BluetoothDevice r1) {
        r0.notifyDeviceLost(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$smnameForBleScanCallbackType, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m2952$$Nest$smnameForBleScanCallbackType(int r0) {
        return nameForBleScanCallbackType(r0);
    }

    BleDeviceProcessor(AssociationStore associationStore, Callback callback) {
        this.mScanning = false;
        this.mScanCallback = new AnonymousClass2(this);
        this.mAssociationStore = associationStore;
        this.mCallback = callback;
    }

    void init(Context context, BluetoothAdapter btAdapter) {
        if (this.mBtAdapter != null) goto L7;
        btAdapter.getClass();
        this.mBtAdapter = btAdapter;
        checkBleState();
        registerBluetoothStateBroadcastReceiver(context);
        this.mAssociationStore.registerLocalListener(this);
        return;
    L7:
        throw new IllegalStateException(getClass().getSimpleName() + " is already initialized");
    }

    final void restartScan() {
        enforceInitialized();
        if (this.mBleScanner != null) goto L5;
        return;
    L5:
        stopScanIfNeeded();
        startScan();
    }

    @Override // com.android.server.companion.association.AssociationStore.OnChangeListener
    public void onAssociationChanged(int changeType, AssociationInfo association) {
        if (Looper.getMainLooper().isCurrentThread() == false) goto L5;
        restartScan();
        return;
    L5:
        new Handler(Looper.getMainLooper()).post(new BleDeviceProcessor$$ExternalSyntheticLambda0(this));
    }

    private void checkBleState() {
        enforceInitialized();
        boolean bleAvailable = this.mBtAdapter.isLeEnabled();
        if (bleAvailable == true) goto L5;
    L6:
        if (bleAvailable == false) goto L8;
    L10:
        if (bleAvailable == false) goto L15;
        this.mBleScanner = this.mBtAdapter.getBluetoothLeScanner();
        if (this.mBleScanner != null) goto L14;
        return;
    L14:
        startScan();
        return;
    L15:
        stopScanIfNeeded();
        this.mBleScanner = null;
        return;
    L8:
        if (this.mBleScanner != null) goto L10;
        return;
    L5:
        if (this.mBleScanner == null) goto L6;
    }

    void startScan() {
        enforceInitialized();
        Slog.i(TAG, "startBleScan()");
        if (this.mScanning == false) goto L7;
        Slog.w(TAG, "Scan is already in progress.");
        return;
    L7:
        if (this.mBleScanner != null) goto L10;
        Slog.w(TAG, "BLE is not available.");
        return;
    L10:
        Set<String> macAddresses = new HashSet();
        Iterator<AssociationInfo> r2 = this.mAssociationStore.getActiveAssociations().iterator();
    L12:
        if (r2.hasNext() == false) goto L21;
        AssociationInfo association = r2.next();
        if (association.isNotifyOnDeviceNearby() == false) goto L12;
        String macAddress = association.getDeviceMacAddressAsString();
        if (macAddress == null) goto L12;
        macAddresses.add(macAddress);
        goto L12
    L21:
        if (macAddresses.isEmpty() == false) goto L23;
        return;
    L23:
        List<ScanFilter> filters = new ArrayList(macAddresses.size());
        Iterator<String> r3 = macAddresses.iterator();
    L25:
        if (r3.hasNext() == false) goto L28;
        String macAddress2 = r3.next();
        ScanFilter filter = new ScanFilter.Builder().setDeviceAddress(macAddress2).build();
        filters.add(filter);
        goto L25
    L28:
        if (this.mBtAdapter.isLeEnabled() == true) goto L35;
        Slog.w(TAG, "BLE scanning is not turned on");
        return;
    L35:
        this.mBleScanner.startScan(filters, SCAN_SETTINGS, this.mScanCallback);     // Catch: IllegalStateException -> L31
        this.mScanning = true;     // Catch: IllegalStateException -> L31
        return;
    L31:
        e = move-exception;
        Slog.w(TAG, "Exception while starting BLE scanning", e);
    }

    void stopScanIfNeeded() {
        enforceInitialized();
        Slog.i(TAG, "stopBleScan()");
        if (this.mScanning == true) goto L6;
        return;
    L6:
        if (this.mBtAdapter.isLeEnabled() == true) goto L14;
        Slog.w(TAG, "BLE scanning is not turned on");
    L12:
        this.mScanning = false;
        return;
    L14:
        this.mBleScanner.stopScan(this.mScanCallback);     // Catch: IllegalStateException -> L9
    L9:
        e = move-exception;
        Slog.w(TAG, "Exception while stopping BLE scanning", e);
        goto L12
    }

    private void notifyDeviceFound(BluetoothDevice device) {
        Iterator<AssociationInfo> r0 = this.mAssociationStore.getActiveAssociationsByAddress(device.getAddress()).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        AssociationInfo association = r0.next();
        this.mCallback.onBleCompanionDeviceFound(association.getId(), association.getUserId());
        goto L4
    }

    private void notifyDeviceLost(BluetoothDevice device) {
        Iterator<AssociationInfo> r0 = this.mAssociationStore.getActiveAssociationsByAddress(device.getAddress()).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        AssociationInfo association = r0.next();
        this.mCallback.onBleCompanionDeviceLost(association.getId(), association.getUserId());
        goto L4
    }

    private void registerBluetoothStateBroadcastReceiver(Context context) {
        BroadcastReceiver receiver = new AnonymousClass1(this);
        IntentFilter filter = new IntentFilter();
        filter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
        filter.addAction("android.bluetooth.adapter.action.BLE_STATE_CHANGED");
        context.registerReceiver(receiver, filter);
    }

    private void enforceInitialized() {
        if (this.mBtAdapter == null) goto L6;
        return;
    L6:
        throw new IllegalStateException(getClass().getSimpleName() + " is not initialized");
    }

    private static String nameForBleScanCallbackType(int callbackType) {
        switch(callbackType) {
            case 1: goto L6;
            case 2: goto L5;
            case 3: goto L3;
            case 4: goto L4;
            default: goto L3;
        };
    L3:
        String name = "Unknown";
    L8:
        return name + "(" + callbackType + ")";
    L4:
        name = "MATCH_LOST";
        goto L8
    L5:
        name = "FIRST_MATCH";
        goto L8
    L6:
        name = "ALL_MATCHES";
        goto L8
    }

    static {
        SCAN_SETTINGS = new ScanSettings.Builder().setCallbackType(6).setScanMode(0).build();
    }
}
