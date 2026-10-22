package com.android.server.companion.devicepresence;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.companion.AssociationInfo;
import android.companion.DeviceNotAssociatedException;
import android.companion.DevicePresenceEvent;
import android.companion.ObservingDevicePresenceRequest;
import android.content.Context;
import android.os.Binder;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.ParcelUuid;
import android.os.PowerManagerInternal;
import android.os.RemoteException;
import android.os.UserManager;
import android.util.Slog;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import com.android.internal.util.CollectionUtils;
import com.android.server.companion.CompanionExemptionProcessor;
import com.android.server.companion.association.AssociationStore;
import com.android.server.companion.utils.PermissionsUtils;
import com.android.server.job.controllers.JobStatus;
import com.android.server.slice.SliceClientPermissions;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class DevicePresenceProcessor implements AssociationStore.OnChangeListener, BluetoothDeviceProcessor.Callback, BleDeviceProcessor.Callback {
    private static final String TAG = "CDM_DevicePresenceProcessor";
    private final AssociationStore mAssociationStore;
    private final BleDeviceDisappearedScheduler mBleDeviceDisappearedScheduler;
    private final BleDeviceProcessor mBleDeviceProcessor;
    private final BluetoothDeviceProcessor mBluetoothDeviceProcessor;
    private final Set<Integer> mBtDisconnectedDevices;
    private final SparseBooleanArray mBtDisconnectedDevicesBlePresence;
    private final CompanionAppBinder mCompanionAppBinder;
    private final CompanionExemptionProcessor mCompanionExemptionProcessor;
    private final Set<Integer> mConnectedBtDevices;
    private final Set<Integer> mConnectedSelfManagedDevices;
    private final Set<ParcelUuid> mConnectedUuidDevices;
    private final Context mContext;
    private final Set<Integer> mNearbyBleDevices;
    private final ObservableUuidStore mObservableUuidStore;
    public final SparseArray<List<DevicePresenceEvent>> mPendingDevicePresenceEvents;
    private final PowerManagerInternal mPowerManagerInternal;
    private final SimulatedDevicePresenceSchedulerHelper mSchedulerHelper;
    private final Set<Integer> mSimulated;
    private final UserManager mUserManager;

    private class BleDeviceDisappearedScheduler extends Handler {
        final /* synthetic */ DevicePresenceProcessor this$0;

        BleDeviceDisappearedScheduler(DevicePresenceProcessor r1) {
            this.this$0 = r1;
            super(Looper.getMainLooper());
        }

        void scheduleBleDeviceDisappeared(int associationId) {
            if (hasMessages(associationId) == false) goto L5;
            removeMessages(associationId);
        L5:
            Slog.i(DevicePresenceProcessor.TAG, "scheduleBleDeviceDisappeared for Device: ( " + associationId + " ).");
            sendEmptyMessageDelayed(associationId, JobStatus.DEFAULT_TRIGGER_UPDATE_DELAY);
        }

        void unScheduleDeviceDisappeared(int associationId) {
            if (hasMessages(associationId) == false) goto L12;
            Slog.i(DevicePresenceProcessor.TAG, "unScheduleDeviceDisappeared for Device( " + associationId + " )");
            Set r0 = DevicePresenceProcessor.m2960$$Nest$fgetmBtDisconnectedDevices(this.this$0);
            monitor-enter(r0);
            DevicePresenceProcessor.m2960$$Nest$fgetmBtDisconnectedDevices(this.this$0).remove(Integer.valueOf(associationId));     // Catch: Throwable -> L9
            DevicePresenceProcessor.m2961$$Nest$fgetmBtDisconnectedDevicesBlePresence(this.this$0).delete(associationId);     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            removeMessages(associationId);
            return;
        L9:
            th = move-exception;
            throw th;
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            int associationId = msg.what;
            Set r1 = DevicePresenceProcessor.m2960$$Nest$fgetmBtDisconnectedDevices(this.this$0);
            monitor-enter(r1);
            boolean isCurrentPresent = DevicePresenceProcessor.m2961$$Nest$fgetmBtDisconnectedDevicesBlePresence(this.this$0).get(associationId);     // Catch: Throwable -> L8
            if (DevicePresenceProcessor.m2960$$Nest$fgetmBtDisconnectedDevices(this.this$0).contains(Integer.valueOf(associationId)) == false) goto L10;
            if (isCurrentPresent == true) goto L10;
            Slog.i(DevicePresenceProcessor.TAG, "Device ( " + associationId + " ) is likely BLE out of range, sending callback with event ( 1 )");     // Catch: Throwable -> L8
            DevicePresenceProcessor.m2964$$Nest$monDevicePresenceEvent(this.this$0, DevicePresenceProcessor.m2962$$Nest$fgetmNearbyBleDevices(this.this$0), associationId, 1);     // Catch: Throwable -> L8
        L10:
            DevicePresenceProcessor.m2960$$Nest$fgetmBtDisconnectedDevices(this.this$0).remove(Integer.valueOf(associationId));     // Catch: Throwable -> L8
            DevicePresenceProcessor.m2961$$Nest$fgetmBtDisconnectedDevicesBlePresence(this.this$0).delete(associationId);     // Catch: Throwable -> L8
            monitor-exit(r1);     // Catch: Throwable -> L8
            return;
        L8:
            th = move-exception;
            throw th;
        }
    }

    private class SimulatedDevicePresenceSchedulerHelper extends Handler {
        final /* synthetic */ DevicePresenceProcessor this$0;

        SimulatedDevicePresenceSchedulerHelper(DevicePresenceProcessor r1) {
            this.this$0 = r1;
            super(Looper.getMainLooper());
        }

        void scheduleOnDeviceGoneCallForSimulatedDevicePresence(int associationId) {
            if (hasMessages(associationId) == false) goto L5;
            removeMessages(associationId);
        L5:
            sendEmptyMessageDelayed(associationId, 60000);
        }

        void unscheduleOnDeviceGoneCallForSimulatedDevicePresence(int associationId) {
            removeMessages(associationId);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            int associationId = msg.what;
            if (DevicePresenceProcessor.m2963$$Nest$fgetmSimulated(this.this$0).contains(Integer.valueOf(associationId)) == false) goto L6;
            DevicePresenceProcessor.m2964$$Nest$monDevicePresenceEvent(this.this$0, DevicePresenceProcessor.m2963$$Nest$fgetmSimulated(this.this$0), associationId, 1);
            return;
        }
    }

    public static /* synthetic */ void $r8$lambda$0qcO9TrgAC2aaxEam4IC9byNKT8(DevicePresenceProcessor r0, int r1, String r2, CompanionServiceConnector r3) {
        r0.onBinderDied(r1, r2, r3);
    }

    public static /* synthetic */ boolean $r8$lambda$OYuMYwX8vaOdEbdPDeDV6liLTeg(ParcelUuid r0, int r1, DevicePresenceEvent r2) {
        return lambda$onDeviceLocked$1(r0, r1, r2);
    }

    public static /* synthetic */ boolean $r8$lambda$fVxyn90fpb5c8oOabBCjNtjl6d8(ParcelUuid r0, int r1, DevicePresenceEvent r2) {
        return lambda$onDeviceLocked$0(r0, r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmBtDisconnectedDevices, reason: not valid java name */
    static /* bridge */ /* synthetic */ Set m2960$$Nest$fgetmBtDisconnectedDevices(DevicePresenceProcessor r0) {
        return r0.mBtDisconnectedDevices;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmBtDisconnectedDevicesBlePresence, reason: not valid java name */
    static /* bridge */ /* synthetic */ SparseBooleanArray m2961$$Nest$fgetmBtDisconnectedDevicesBlePresence(DevicePresenceProcessor r0) {
        return r0.mBtDisconnectedDevicesBlePresence;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmNearbyBleDevices, reason: not valid java name */
    static /* bridge */ /* synthetic */ Set m2962$$Nest$fgetmNearbyBleDevices(DevicePresenceProcessor r0) {
        return r0.mNearbyBleDevices;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmSimulated, reason: not valid java name */
    static /* bridge */ /* synthetic */ Set m2963$$Nest$fgetmSimulated(DevicePresenceProcessor r0) {
        return r0.mSimulated;
    }

    /* JADX INFO: renamed from: -$$Nest$monDevicePresenceEvent, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2964$$Nest$monDevicePresenceEvent(DevicePresenceProcessor r0, Set r1, int r2, int r3) {
        r0.onDevicePresenceEvent(r1, r2, r3);
    }

    public DevicePresenceProcessor(Context context, CompanionAppBinder companionAppBinder, UserManager userManager, AssociationStore associationStore, ObservableUuidStore observableUuidStore, PowerManagerInternal powerManagerInternal, CompanionExemptionProcessor companionExemptionProcessor) {
        this.mConnectedBtDevices = new HashSet();
        this.mNearbyBleDevices = new HashSet();
        this.mConnectedSelfManagedDevices = new HashSet();
        this.mConnectedUuidDevices = new HashSet();
        this.mBtDisconnectedDevices = new HashSet();
        this.mBtDisconnectedDevicesBlePresence = new SparseBooleanArray();
        this.mSimulated = new HashSet();
        this.mSchedulerHelper = new SimulatedDevicePresenceSchedulerHelper(this);
        this.mBleDeviceDisappearedScheduler = new BleDeviceDisappearedScheduler(this);
        this.mPendingDevicePresenceEvents = new SparseArray();
        this.mContext = context;
        this.mCompanionAppBinder = companionAppBinder;
        this.mAssociationStore = associationStore;
        this.mObservableUuidStore = observableUuidStore;
        this.mUserManager = userManager;
        this.mBluetoothDeviceProcessor = new BluetoothDeviceProcessor(associationStore, this.mObservableUuidStore, this);
        this.mBleDeviceProcessor = new BleDeviceProcessor(associationStore, this);
        this.mPowerManagerInternal = powerManagerInternal;
        this.mCompanionExemptionProcessor = companionExemptionProcessor;
    }

    public void init(Context context) {
        BluetoothManager bm = (BluetoothManager) context.getSystemService("bluetooth");
        if (bm != null) goto L6;
        Slog.w(TAG, "BluetoothManager is not available.");
        return;
    L6:
        BluetoothAdapter btAdapter = bm.getAdapter();
        if (btAdapter != null) goto L10;
        Slog.w(TAG, "BluetoothAdapter is NOT available.");
        return;
    L10:
        this.mBluetoothDeviceProcessor.init(btAdapter);
        this.mBleDeviceProcessor.init(context, btAdapter);
        this.mAssociationStore.registerLocalListener(this);
    }

    public void startObservingDevicePresence(ObservingDevicePresenceRequest request, String packageName, int userId, boolean enforcePermissions) {
        Slog.i(TAG, "Start observing request=[" + request + "] for userId=[" + userId + "], package=[" + packageName + "]...");
        ParcelUuid requestUuid = request.getUuid();
        if (requestUuid == null) goto L11;
        if (enforcePermissions == false) goto L7;
        PermissionsUtils.enforceCallerCanObserveDevicePresenceByUuid(this.mContext, packageName, userId);
    L7:
        if (this.mObservableUuidStore.isUuidBeingObserved(requestUuid, userId, packageName) == false) goto L10;
        Slog.i(TAG, "UUID=[" + requestUuid + "], package=[" + packageName + "], userId=[" + userId + "] is already being observed.");
        return;
    L10:
        ObservableUuid observableUuid = new ObservableUuid(userId, requestUuid, packageName, Long.valueOf(System.currentTimeMillis()));
        this.mObservableUuidStore.writeObservableUuid(userId, observableUuid);
    L26:
        Slog.i(TAG, "Registered device presence listener.");
        return;
    L11:
        int associationId = request.getAssociationId();
        AssociationInfo association = this.mAssociationStore.getAssociationWithCallerChecks(associationId);
        if (association.isNotifyOnDeviceNearby() == false) goto L15;
        Slog.i(TAG, "Associated device id=[" + association.getId() + "] is already being observed. No-op.");
        return;
    L15:
        this.mAssociationStore.updateAssociation(new AssociationInfo.Builder(association).setNotifyOnDeviceNearby(true).build());
        if (isDevicePresent(associationId) == false) goto L26;
        Slog.i(TAG, "Device is already present. Triggering callback.");
        if (isBlePresent(associationId) == false) goto L21;
        onDevicePresenceEvent(this.mNearbyBleDevices, associationId, 0);
        goto L26
    L21:
        if (isBtConnected(associationId) == false) goto L24;
        onDevicePresenceEvent(this.mConnectedBtDevices, associationId, 2);
        goto L26
    L24:
        if (isSimulatePresent(associationId) == false) goto L26;
        onDevicePresenceEvent(this.mSimulated, associationId, 0);
        goto L26
    }

    public void stopObservingDevicePresence(ObservingDevicePresenceRequest request, String packageName, int userId, boolean enforcePermissions) {
        Slog.i(TAG, "Stop observing request=[" + request + "] for userId=[" + userId + "], package=[" + packageName + "]...");
        ParcelUuid requestUuid = request.getUuid();
        if (requestUuid == null) goto L11;
        if (enforcePermissions == false) goto L7;
        PermissionsUtils.enforceCallerCanObserveDevicePresenceByUuid(this.mContext, packageName, userId);
    L7:
        if (this.mObservableUuidStore.isUuidBeingObserved(requestUuid, userId, packageName) == true) goto L10;
        Slog.i(TAG, "UUID=[" + requestUuid + "], package=[" + packageName + "], userId=[" + userId + "] is already not being observed.");
        return;
    L10:
        this.mObservableUuidStore.removeObservableUuid(userId, requestUuid, packageName);
        removeCurrentConnectedUuidDevice(requestUuid);
    L16:
        Slog.i(TAG, "Unregistered device presence listener.");
        if (shouldBindPackage(userId, packageName) == true) goto L20;
        this.mCompanionAppBinder.unbindCompanionApp(userId, packageName);
        return;
    L20:
        return;
    L11:
        int associationId = request.getAssociationId();
        AssociationInfo association = this.mAssociationStore.getAssociationWithCallerChecks(associationId);
        if (association.isNotifyOnDeviceNearby() == true) goto L15;
        Slog.i(TAG, "Associated device id=[" + association.getId() + "] is already not being observed. No-op.");
        return;
    L15:
        this.mAssociationStore.updateAssociation(new AssociationInfo.Builder(association).setNotifyOnDeviceNearby(false).build());
        goto L16
    }

    @Deprecated
    public void startObservingDevicePresence(int userId, String packageName, String deviceAddress) throws RemoteException {
        Slog.i(TAG, "Start observing device=[" + deviceAddress + "] for userId=[" + userId + "], package=[" + packageName + "]...");
        PermissionsUtils.enforceCallerCanManageAssociationsForPackage(this.mContext, userId, packageName, null);
        AssociationInfo association = this.mAssociationStore.getFirstAssociationByAddress(userId, packageName, deviceAddress);
        if (association == null) goto L7;
        startObservingDevicePresence(new ObservingDevicePresenceRequest.Builder().setAssociationId(association.getId()).build(), packageName, userId, true);
        return;
    L7:
        throw new RemoteException(new DeviceNotAssociatedException("App " + packageName + " is not associated with device " + deviceAddress + " for user " + userId));
    }

    @Deprecated
    public void stopObservingDevicePresence(int userId, String packageName, String deviceAddress) throws RemoteException {
        Slog.i(TAG, "Stop observing device=[" + deviceAddress + "] for userId=[" + userId + "], package=[" + packageName + "]...");
        PermissionsUtils.enforceCallerCanManageAssociationsForPackage(this.mContext, userId, packageName, null);
        AssociationInfo association = this.mAssociationStore.getFirstAssociationByAddress(userId, packageName, deviceAddress);
        if (association == null) goto L7;
        stopObservingDevicePresence(new ObservingDevicePresenceRequest.Builder().setAssociationId(association.getId()).build(), packageName, userId, true);
        return;
    L7:
        throw new RemoteException(new DeviceNotAssociatedException("App " + packageName + " is not associated with device " + deviceAddress + " for user " + userId));
    }

    private boolean shouldBindPackage(int userId, String packageName) {
        List<AssociationInfo> packageAssociations = this.mAssociationStore.getActiveAssociationsByPackage(userId, packageName);
        List<ObservableUuid> observableUuids = this.mObservableUuidStore.getObservableUuidsForPackage(userId, packageName);
        Iterator<AssociationInfo> r2 = packageAssociations.iterator();
    L4:
        if (r2.hasNext() == false) goto L12;
        AssociationInfo association = r2.next();
        if (association.shouldBindWhenPresent() == false) goto L4;
        if (isDevicePresent(association.getId()) == false) goto L4;
        return true;
    L12:
        Iterator<ObservableUuid> r3 = observableUuids.iterator();
    L14:
        if (r3.hasNext() == false) goto L19;
        ObservableUuid uuid = r3.next();
        if (isDeviceUuidPresent(uuid.getUuid()) == false) goto L14;
        return true;
    L19:
        return false;
    }

    private void bindApplicationIfNeeded(int userId, String packageName, boolean bindImportant) {
        if (this.mCompanionAppBinder.isCompanionApplicationBound(userId, packageName) == true) goto L5;
        this.mCompanionAppBinder.bindCompanionApp(userId, packageName, bindImportant, new DevicePresenceProcessor$$ExternalSyntheticLambda0(this));
        return;
    L5:
        Slog.i(TAG, "UserId=[" + userId + "], packageName=[" + packageName + "] is already bound.");
    }

    public Set<ParcelUuid> getCurrentConnectedUuidDevices() {
        return this.mConnectedUuidDevices;
    }

    public void removeCurrentConnectedUuidDevice(ParcelUuid uuid) {
        this.mConnectedUuidDevices.remove(uuid);
    }

    public boolean isDevicePresent(int associationId) {
        if (this.mConnectedSelfManagedDevices.contains(Integer.valueOf(associationId)) == false) goto L5;
    L12:
        return true;
    L5:
        if (this.mConnectedBtDevices.contains(Integer.valueOf(associationId)) == true) goto L12;
        if (this.mNearbyBleDevices.contains(Integer.valueOf(associationId)) == true) goto L12;
        if (this.mSimulated.contains(Integer.valueOf(associationId)) == true) goto L12;
        return false;
    }

    public boolean isDeviceUuidPresent(ParcelUuid uuid) {
        return this.mConnectedUuidDevices.contains(uuid);
    }

    public boolean isBtConnected(int associationId) {
        return this.mConnectedBtDevices.contains(Integer.valueOf(associationId));
    }

    public boolean isBlePresent(int associationId) {
        return this.mNearbyBleDevices.contains(Integer.valueOf(associationId));
    }

    public boolean isSimulatePresent(int associationId) {
        return this.mSimulated.contains(Integer.valueOf(associationId));
    }

    public void onSelfManagedDeviceConnected(int associationId) {
        onDevicePresenceEvent(this.mConnectedSelfManagedDevices, associationId, 4);
    }

    public void onSelfManagedDeviceDisconnected(int associationId) {
        onDevicePresenceEvent(this.mConnectedSelfManagedDevices, associationId, 5);
    }

    public void onSelfManagedDeviceReporterBinderDied(int associationId) {
        onDevicePresenceEvent(this.mConnectedSelfManagedDevices, associationId, 5);
    }

    @Override // com.android.server.companion.devicepresence.BluetoothDeviceProcessor.Callback
    public void onBluetoothCompanionDeviceConnected(int associationId, int userId) {
        Slog.i(TAG, "onBluetoothCompanionDeviceConnected: associationId( " + associationId + " )");
        if (this.mUserManager.isUserUnlockingOrUnlocked(userId) == true) goto L6;
        onDeviceLocked(associationId, userId, 2, null);
        return;
    L6:
        Set<Integer> r0 = this.mBtDisconnectedDevices;
        monitor-enter(r0);
        boolean isReconnected = this.mBtDisconnectedDevices.contains(Integer.valueOf(associationId));     // Catch: Throwable -> L11
        if (isReconnected == false) goto L13;
        Slog.i(TAG, "Device ( " + associationId + " ) is reconnected within 10s.");     // Catch: Throwable -> L11
        this.mBleDeviceDisappearedScheduler.unScheduleDeviceDisappeared(associationId);     // Catch: Throwable -> L11
    L13:
        Slog.i(TAG, "onBluetoothCompanionDeviceConnected: associationId( " + associationId + " )");     // Catch: Throwable -> L11
        onDevicePresenceEvent(this.mConnectedBtDevices, associationId, 2);     // Catch: Throwable -> L11
        if (canStopBleScan() == false) goto L16;
        this.mBleDeviceProcessor.stopScanIfNeeded();     // Catch: Throwable -> L11
    L16:
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.companion.devicepresence.BluetoothDeviceProcessor.Callback
    public void onBluetoothCompanionDeviceDisconnected(int associationId, int userId) {
        Slog.i(TAG, "onBluetoothCompanionDeviceDisconnected associationId( " + associationId + " )");
        if (this.mUserManager.isUserUnlockingOrUnlocked(userId) == true) goto L6;
        onDeviceLocked(associationId, userId, 3, null);
        return;
    L6:
        this.mBleDeviceProcessor.startScan();
        onDevicePresenceEvent(this.mConnectedBtDevices, associationId, 3);
        if (isBlePresent(associationId) == false) goto L16;
        Set<Integer> r0 = this.mBtDisconnectedDevices;
        monitor-enter(r0);
        this.mBtDisconnectedDevices.add(Integer.valueOf(associationId));     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
        this.mBleDeviceDisappearedScheduler.scheduleBleDeviceDisappeared(associationId);
        return;
    L13:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.companion.devicepresence.BleDeviceProcessor.Callback
    public void onBleCompanionDeviceFound(int associationId, int userId) {
        Slog.i(TAG, "onBleCompanionDeviceFound associationId( " + associationId + " )");
        if (this.mUserManager.isUserUnlockingOrUnlocked(userId) == true) goto L6;
        onDeviceLocked(associationId, userId, 0, null);
        return;
    L6:
        onDevicePresenceEvent(this.mNearbyBleDevices, associationId, 0);
        Set<Integer> r0 = this.mBtDisconnectedDevices;
        monitor-enter(r0);
        boolean isCurrentPresent = this.mBtDisconnectedDevicesBlePresence.get(associationId);     // Catch: Throwable -> L12
        if (this.mBtDisconnectedDevices.contains(Integer.valueOf(associationId)) == false) goto L14;
        if (isCurrentPresent == false) goto L14;
        this.mBleDeviceDisappearedScheduler.unScheduleDeviceDisappeared(associationId);     // Catch: Throwable -> L12
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.companion.devicepresence.BleDeviceProcessor.Callback
    public void onBleCompanionDeviceLost(int associationId, int userId) {
        Slog.i(TAG, "onBleCompanionDeviceLost associationId( " + associationId + " )");
        if (this.mUserManager.isUserUnlockingOrUnlocked(userId) == true) goto L6;
        onDeviceLocked(associationId, userId, 0, null);
        return;
    L6:
        onDevicePresenceEvent(this.mNearbyBleDevices, associationId, 1);
    }

    public void simulateDeviceEvent(int associationId, int event) {
        enforceCallerShellOrRoot();
        enforceAssociationExists(associationId);
        AssociationInfo associationInfo = this.mAssociationStore.getAssociationById(associationId);
        switch(event) {
            case 0: goto L9;
            case 1: goto L8;
            case 2: goto L7;
            case 3: goto L6;
            default: goto L5;
        };
    L6:
        onBluetoothCompanionDeviceDisconnected(associationId, associationInfo.getUserId());
        return;
    L7:
        onBluetoothCompanionDeviceConnected(associationId, associationInfo.getUserId());
        return;
    L8:
        simulateDeviceDisappeared(associationId, event);
        return;
    L9:
        simulateDeviceAppeared(associationId, event);
        return;
    L5:
        throw new IllegalArgumentException("Event: " + event + "is not supported");
    }

    public void simulateDeviceEventByUuid(ObservableUuid uuid, int event) {
        enforceCallerShellOrRoot();
        onDevicePresenceEventByUuid(uuid, event);
    }

    public void simulateDeviceEventOnDeviceLocked(int associationId, int userId, int event, ParcelUuid uuid) {
        enforceCallerShellOrRoot();
        onDeviceLocked(associationId, userId, event, uuid);
    }

    public void simulateDeviceEventOnUserUnlocked(int userId) {
        enforceCallerShellOrRoot();
        sendDevicePresenceEventOnUnlocked(userId);
    }

    private void simulateDeviceAppeared(int associationId, int state) {
        onDevicePresenceEvent(this.mSimulated, associationId, state);
        this.mSchedulerHelper.scheduleOnDeviceGoneCallForSimulatedDevicePresence(associationId);
    }

    private void simulateDeviceDisappeared(int associationId, int state) {
        this.mSchedulerHelper.unscheduleOnDeviceGoneCallForSimulatedDevicePresence(associationId);
        onDevicePresenceEvent(this.mSimulated, associationId, state);
    }

    private void enforceAssociationExists(int associationId) {
        if (this.mAssociationStore.getAssociationById(associationId) == null) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("Association with id " + associationId + " does not exist.");
    }

    private void onDevicePresenceEvent(Set<Integer> presentDevicesForSource, int associationId, int eventType) {
        Slog.i(TAG, "onDevicePresenceEvent() id=[" + associationId + "], event=[" + eventType + "]...");
        AssociationInfo association = this.mAssociationStore.getAssociationById(associationId);
        if (association != null) goto L6;
        Slog.e(TAG, "Association doesn't exist.");
        return;
    L6:
        int userId = association.getUserId();
        String packageName = association.getPackageName();
        DevicePresenceEvent event = new DevicePresenceEvent(associationId, eventType, null);
        if (eventType != 0) goto L19;
        Set<Integer> r6 = this.mBtDisconnectedDevices;
        monitor-enter(r6);
    L13:
        th = move-exception;
        throw th;
    L11:
        if (this.mBtDisconnectedDevices.contains(Integer.valueOf(associationId)) == false) goto L15;
        Slog.i(TAG, "Device ( " + associationId + " ) is present, do not need to send the callback with event ( 0 ).");     // Catch: Throwable -> L13
        this.mBtDisconnectedDevicesBlePresence.append(associationId, true);     // Catch: Throwable -> L13
    L15:
        monitor-exit(r6);     // Catch: Throwable -> L13
    L19:
        switch(eventType) {
            case 0: goto L35;
            case 1: goto L21;
            case 2: goto L35;
            case 3: goto L21;
            case 4: goto L35;
            case 5: goto L21;
            default: goto L20;
        };
    L20:
        Slog.e(TAG, "Event: " + eventType + " is not supported.");
        return;
    L21:
        boolean removed = presentDevicesForSource.remove(Integer.valueOf(associationId));
        if (removed == true) goto L25;
        Slog.w(TAG, "The association is already NOT present.");
    L25:
        if (this.mCompanionAppBinder.isCompanionApplicationBound(userId, packageName) == true) goto L29;
        Slog.e(TAG, "Package is not bound");
        return;
    L29:
        if (association.isSelfManaged() == true) goto L31;
        if (removed == true) goto L31;
    L33:
        if (shouldBindPackage(userId, packageName) == true) goto L49;
        this.mCompanionAppBinder.unbindCompanionApp(userId, packageName);
        this.mCompanionExemptionProcessor.exemptPackage(userId, packageName, false);
        return;
    L49:
        return;
    L31:
        notifyDevicePresenceEvent(userId, packageName, event);
        legacyNotifyDevicePresenceEvent(association, false);
        goto L33
    L35:
        boolean added = presentDevicesForSource.add(Integer.valueOf(associationId));
        if (added == true) goto L39;
        Slog.w(TAG, "The association is already present.");
    L39:
        if (association.shouldBindWhenPresent() == false) goto L45;
        bindApplicationIfNeeded(userId, packageName, association.isSelfManaged());
        this.mCompanionExemptionProcessor.exemptPackage(userId, packageName, true);
        if (association.isSelfManaged() == true) goto L43;
        if (added == true) goto L43;
        return;
    L43:
        notifyDevicePresenceEvent(userId, packageName, event);
        legacyNotifyDevicePresenceEvent(association, true);
        return;
    }

    @Override // com.android.server.companion.devicepresence.BluetoothDeviceProcessor.Callback
    public void onDevicePresenceEventByUuid(ObservableUuid uuid, int eventType) {
        Slog.i(TAG, "onDevicePresenceEventByUuid ObservableUuid=[" + uuid + "], event=[" + eventType + "]...");
        ParcelUuid parcelUuid = uuid.getUuid();
        int userId = uuid.getUserId();
        if (this.mUserManager.isUserUnlockingOrUnlocked(userId) == true) goto L6;
        onDeviceLocked(-1, userId, eventType, parcelUuid);
        return;
    L6:
        String packageName = uuid.getPackageName();
        DevicePresenceEvent event = new DevicePresenceEvent(-1, eventType, parcelUuid);
        switch(eventType) {
            case 2: goto L20;
            case 3: goto L9;
            default: goto L8;
        };
    L8:
        Slog.e(TAG, "Event: " + eventType + " is not supported");
        return;
    L9:
        boolean removed = this.mConnectedUuidDevices.remove(parcelUuid);
        if (removed == true) goto L14;
        Slog.w(TAG, "This device is already disconnected.");
        return;
    L14:
        if (this.mCompanionAppBinder.isCompanionApplicationBound(userId, packageName) == true) goto L17;
        Slog.e(TAG, "Package is not bound.");
        return;
    L17:
        notifyDevicePresenceEvent(userId, packageName, event);
        if (shouldBindPackage(userId, packageName) == true) goto L26;
        this.mCompanionAppBinder.unbindCompanionApp(userId, packageName);
        return;
    L26:
        return;
    L20:
        boolean added = this.mConnectedUuidDevices.add(parcelUuid);
        if (added == true) goto L23;
        Slog.w(TAG, "This device is already connected.");
    L23:
        bindApplicationIfNeeded(userId, packageName, false);
        notifyDevicePresenceEvent(userId, packageName, event);
    }

    @Deprecated
    private void legacyNotifyDevicePresenceEvent(AssociationInfo association, boolean isAppeared) {
        Slog.i(TAG, "legacyNotifyDevicePresenceEvent() association=[" + association.toShortString() + "], isAppeared=[" + isAppeared + "]");
        int userId = association.getUserId();
        String packageName = association.getPackageName();
        CompanionServiceConnector primaryServiceConnector = this.mCompanionAppBinder.getPrimaryServiceConnector(userId, packageName);
        if (primaryServiceConnector != null) goto L6;
        Slog.e(TAG, "Package is not bound.");
        return;
    L6:
        if (isAppeared == false) goto L8;
        primaryServiceConnector.postOnDeviceAppeared(association);
        return;
    L8:
        primaryServiceConnector.postOnDeviceDisappeared(association);
    }

    private void notifyDevicePresenceEvent(int userId, String packageName, DevicePresenceEvent event) {
        Slog.i(TAG, "notifyCompanionDevicePresenceEvent userId=[" + userId + "], packageName=[" + packageName + "], event=[" + event + "]...");
        CompanionServiceConnector primaryServiceConnector = this.mCompanionAppBinder.getPrimaryServiceConnector(userId, packageName);
        if (primaryServiceConnector != null) goto L6;
        Slog.e(TAG, "Package is NOT bound.");
        return;
    L6:
        primaryServiceConnector.postOnDevicePresenceEvent(event);
    }

    public void notifySelfManagedDevicePresenceEvent(int associationId, boolean isAppeared) {
        Slog.i(TAG, "notifySelfManagedDeviceAppeared() id=" + associationId);
        AssociationInfo association = this.mAssociationStore.getAssociationWithCallerChecks(associationId);
        if (association.isSelfManaged() == false) goto L13;
        AssociationInfo association2 = new AssociationInfo.Builder(association).setLastTimeConnected(System.currentTimeMillis()).build();
        this.mAssociationStore.updateAssociation(association2);
        if (isAppeared == false) goto L7;
        onSelfManagedDeviceConnected(associationId);
    L8:
        String deviceProfile = association2.getDeviceProfile();
        if ("android.app.role.SYSTEM_AUTOMOTIVE_PROJECTION".equals(deviceProfile) == false) goto L14;
        Slog.i(TAG, "Enable hint mode for device device profile: " + deviceProfile);
        this.mPowerManagerInternal.setPowerMode(18, isAppeared);
        return;
    L14:
        return;
    L7:
        onSelfManagedDeviceDisconnected(associationId);
        goto L8
    L13:
        throw new IllegalArgumentException("Association id=[" + associationId + "] is not self-managed.");
    }

    private void onBinderDied(int userId, String packageName, CompanionServiceConnector serviceConnector) {
        boolean isPrimary = serviceConnector.isPrimary();
        Slog.i(TAG, "onBinderDied() u" + userId + SliceClientPermissions.SliceAuthority.DELIMITER + packageName + " isPrimary: " + isPrimary);
        if (isPrimary == false) goto L12;
        List<AssociationInfo> associations = this.mAssociationStore.getActiveAssociationsByPackage(userId, packageName);
        Iterator<AssociationInfo> r3 = associations.iterator();
    L6:
        if (r3.hasNext() == false) goto L11;
        AssociationInfo association = r3.next();
        String deviceProfile = association.getDeviceProfile();
        if ("android.app.role.SYSTEM_AUTOMOTIVE_PROJECTION".equals(deviceProfile) == false) goto L6;
        Slog.i(TAG, "Disable hint mode for device profile: " + deviceProfile);
        this.mPowerManagerInternal.setPowerMode(18, false);
    L11:
        this.mCompanionAppBinder.removePackage(userId, packageName);
    L12:
        boolean shouldScheduleRebind = shouldScheduleRebind(userId, packageName, isPrimary);
        if (shouldScheduleRebind == false) goto L19;
        this.mCompanionAppBinder.scheduleRebinding(userId, packageName, serviceConnector);
        return;
    }

    private boolean shouldScheduleRebind(int userId, String packageName, boolean isPrimary) {
        boolean stillAssociated = false;
        boolean shouldScheduleRebind = false;
        boolean shouldScheduleRebindForUuid = false;
        List<ObservableUuid> uuids = this.mObservableUuidStore.getObservableUuidsForPackage(userId, packageName);
        Iterator<AssociationInfo> r4 = this.mAssociationStore.getActiveAssociationsByPackage(userId, packageName).iterator();
    L4:
        if (r4.hasNext() == false) goto L16;
        AssociationInfo ai = r4.next();
        int associationId = ai.getId();
        stillAssociated = true;
        if (ai.isSelfManaged() == true) goto L7;
        if (ai.isNotifyOnDeviceNearby() == false) goto L4;
        shouldScheduleRebind = true;
        goto L4
    L7:
        if (isPrimary == true) goto L9;
    L11:
        shouldScheduleRebind = this.mCompanionAppBinder.isCompanionApplicationBound(userId, packageName);
        goto L4
    L9:
        if (isDevicePresent(associationId) == false) goto L11;
        onSelfManagedDeviceReporterBinderDied(associationId);
        goto L11
    L16:
        Iterator<ObservableUuid> r5 = uuids.iterator();
    L18:
        if (r5.hasNext() == false) goto L23;
        ObservableUuid uuid = r5.next();
        if (isDeviceUuidPresent(uuid.getUuid()) == false) goto L18;
        shouldScheduleRebindForUuid = true;
    L23:
        if (stillAssociated == false) goto L25;
        if (shouldScheduleRebind == false) goto L25;
    L26:
        return true;
    L25:
        if (shouldScheduleRebindForUuid == true) goto L26;
        return false;
    }

    @Override // com.android.server.companion.association.AssociationStore.OnChangeListener
    public void onAssociationRemoved(AssociationInfo association) {
        int id = association.getId();
        this.mConnectedBtDevices.remove(Integer.valueOf(id));
        this.mNearbyBleDevices.remove(Integer.valueOf(id));
        this.mConnectedSelfManagedDevices.remove(Integer.valueOf(id));
        this.mSimulated.remove(Integer.valueOf(id));
        Set<Integer> r1 = this.mBtDisconnectedDevices;
        monitor-enter(r1);
        this.mBtDisconnectedDevices.remove(Integer.valueOf(id));     // Catch: Throwable -> L7
        this.mBtDisconnectedDevicesBlePresence.delete(id);     // Catch: Throwable -> L7
        monitor-exit(r1);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private static void enforceCallerShellOrRoot() {
        int callingUid = Binder.getCallingUid();
        if (callingUid == 2000) goto L8;
        if (callingUid != 0) goto L7;
        return;
    L7:
        throw new SecurityException("Caller is neither Shell nor Root");
    }

    private boolean canStopBleScan() {
        Iterator<AssociationInfo> r0 = this.mAssociationStore.getActiveAssociations().iterator();
    L4:
        if (r0.hasNext() == false) goto L26;
        AssociationInfo ai = r0.next();
        int id = ai.getId();
        Set<Integer> r3 = this.mBtDisconnectedDevices;
        monitor-enter(r3);
    L16:
        th = move-exception;
        throw th;
    L8:
        if (ai.isNotifyOnDeviceNearby() == true) goto L10;
    L22:
        monitor-exit(r3);     // Catch: Throwable -> L16
        goto L4
    L10:
        if (isBtConnected(id) == false) goto L18;
        if (isBlePresent(id) == false) goto L18;
        if (this.mBtDisconnectedDevices.isEmpty() == true) goto L22;
    L18:
        Slog.i(TAG, "The BLE scan cannot be stopped, device( " + id + " ) is not yet connected OR the BLE is not current present Or is pending to report BLE lost");     // Catch: Throwable -> L16
        monitor-exit(r3);     // Catch: Throwable -> L16
        return false;
    L26:
        return true;
    }

    private void onDeviceLocked(final int associationId, int userId, int event, final ParcelUuid uuid) {
        switch(event) {
            case 0: goto L26;
            case 1: goto L15;
            case 2: goto L26;
            case 3: goto L4;
            default: goto L3;
        };
    L3:
        Slog.e(TAG, "Event: " + event + "is not supported");
        return;
    L4:
        SparseArray<List<DevicePresenceEvent>> r0 = this.mPendingDevicePresenceEvents;
        monitor-enter(r0);
        List<DevicePresenceEvent> deviceEvents = this.mPendingDevicePresenceEvents.get(userId);     // Catch: Throwable -> L9
        if (deviceEvents == null) goto L11;
        deviceEvents.removeIf(new DevicePresenceProcessor$$ExternalSyntheticLambda2(uuid, associationId));     // Catch: Throwable -> L9
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    L15:
        SparseArray<List<DevicePresenceEvent>> r1 = this.mPendingDevicePresenceEvents;
        monitor-enter(r1);
        List<DevicePresenceEvent> deviceEvents2 = this.mPendingDevicePresenceEvents.get(userId);     // Catch: Throwable -> L20
        if (deviceEvents2 == null) goto L22;
        deviceEvents2.removeIf(new DevicePresenceProcessor$$ExternalSyntheticLambda1(uuid, associationId));     // Catch: Throwable -> L20
    L22:
        monitor-exit(r1);     // Catch: Throwable -> L20
        return;
    L20:
        th = move-exception;
        throw th;
    L26:
        Slog.i(TAG, "Current user is not in unlocking or unlocked stage yet. Notify the application when the phone is unlocked");
        SparseArray<List<DevicePresenceEvent>> r2 = this.mPendingDevicePresenceEvents;
        monitor-enter(r2);
        DevicePresenceEvent devicePresenceEvent = new DevicePresenceEvent(associationId, event, uuid);     // Catch: Throwable -> L31
        List<DevicePresenceEvent> deviceEvents3 = this.mPendingDevicePresenceEvents.get(userId, new ArrayList());     // Catch: Throwable -> L31
        deviceEvents3.add(devicePresenceEvent);     // Catch: Throwable -> L31
        this.mPendingDevicePresenceEvents.put(userId, deviceEvents3);     // Catch: Throwable -> L31
        monitor-exit(r2);     // Catch: Throwable -> L31
        return;
    L31:
        th = move-exception;
        throw th;
    }

    private static /* synthetic */ boolean lambda$onDeviceLocked$0(ParcelUuid uuid, int associationId, DevicePresenceEvent deviceEvent) {
        if (deviceEvent.getEvent() == 0) goto L5;
    L9:
        return false;
    L5:
        if (Objects.equals(deviceEvent.getUuid(), uuid) == false) goto L9;
        if (deviceEvent.getAssociationId() != associationId) goto L9;
        return true;
    }

    private static /* synthetic */ boolean lambda$onDeviceLocked$1(ParcelUuid uuid, int associationId, DevicePresenceEvent deviceEvent) {
        if (deviceEvent.getEvent() == 2) goto L5;
    L9:
        return false;
    L5:
        if (Objects.equals(deviceEvent.getUuid(), uuid) == false) goto L9;
        if (deviceEvent.getAssociationId() != associationId) goto L9;
        return true;
    }

    public void sendDevicePresenceEventOnUnlocked(int userId) {
        List<DevicePresenceEvent> deviceEvents = getPendingDevicePresenceEventsByUserId(userId);
        if (CollectionUtils.isEmpty(deviceEvents) == false) goto L5;
        return;
    L5:
        List<ObservableUuid> observableUuids = this.mObservableUuidStore.getObservableUuidsForUser(userId);
        Iterator<DevicePresenceEvent> r2 = deviceEvents.iterator();
    L7:
        if (r2.hasNext() == false) goto L29;
        DevicePresenceEvent deviceEvent = r2.next();
        if (deviceEvent.getUuid() == null) goto L11;
        boolean isUuid = true;
    L12:
        if (isUuid == true) goto L13;
        int event = deviceEvent.getEvent();
        int associationId = deviceEvent.getAssociationId();
        AssociationInfo associationInfo = this.mAssociationStore.getAssociationById(associationId);
        if (associationInfo == null) goto L23;
        switch(event) {
            case 0: goto L27;
            case 1: goto L25;
            case 2: goto L26;
            default: goto L25;
        };
    L26:
        onBluetoothCompanionDeviceConnected(associationInfo.getId(), associationInfo.getUserId());
        goto L7
    L27:
        onBleCompanionDeviceFound(associationInfo.getId(), associationInfo.getUserId());
        goto L7
    L25:
        Slog.e(TAG, "Event: " + event + "is not supported");
        goto L7
    L23:
        return;
    L13:
        Iterator<ObservableUuid> r5 = observableUuids.iterator();
    L15:
        if (r5.hasNext() == false) goto L7;
        ObservableUuid uuid = r5.next();
        if (uuid.getUuid().equals(deviceEvent.getUuid()) == false) goto L15;
        onDevicePresenceEventByUuid(uuid, 2);
        goto L15
    L11:
        isUuid = false;
        goto L12
    L29:
        removePendingDevicePresenceEventsByUserId(userId);
    }

    private List<DevicePresenceEvent> getPendingDevicePresenceEventsByUserId(int userId) {
        SparseArray<List<DevicePresenceEvent>> r0 = this.mPendingDevicePresenceEvents;
        monitor-enter(r0);
        List<DevicePresenceEvent> r1 = this.mPendingDevicePresenceEvents.get(userId, new ArrayList());     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    private void removePendingDevicePresenceEventsByUserId(int userId) {
        SparseArray<List<DevicePresenceEvent>> r0 = this.mPendingDevicePresenceEvents;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.mPendingDevicePresenceEvents.contains(userId) == false) goto L9;
        this.mPendingDevicePresenceEvents.remove(userId);     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
    }

    public void dump(PrintWriter out) {
        out.append("Companion Device Present: ");
        if (this.mConnectedBtDevices.isEmpty() == true) goto L5;
    L10:
        out.append("\n");
        out.append("  Connected Bluetooth Devices: ");
        if (this.mConnectedBtDevices.isEmpty() == false) goto L13;
        out.append("<empty>\n");
    L17:
        out.append("  Nearby BLE Devices: ");
        if (this.mNearbyBleDevices.isEmpty() == false) goto L20;
        out.append("<empty>\n");
    L24:
        out.append("  Self-Reported Devices: ");
        if (this.mConnectedSelfManagedDevices.isEmpty() == false) goto L27;
        out.append("<empty>\n");
        return;
    L27:
        out.append("\n");
        Iterator<Integer> r0 = this.mConnectedSelfManagedDevices.iterator();
    L29:
        if (r0.hasNext() == false) goto L35;
        int associationId = r0.next().intValue();
        AssociationInfo a = this.mAssociationStore.getAssociationById(associationId);
        out.append("    ").append(a.toShortString()).append('\n');
        goto L29
    L35:
        return;
    L20:
        out.append("\n");
        Iterator<Integer> r2 = this.mNearbyBleDevices.iterator();
    L22:
        if (r2.hasNext() == false) goto L24;
        int associationId2 = r2.next().intValue();
        AssociationInfo a2 = this.mAssociationStore.getAssociationById(associationId2);
        out.append("    ").append(a2.toShortString()).append('\n');
        goto L22
    L13:
        out.append("\n");
        Iterator<Integer> r3 = this.mConnectedBtDevices.iterator();
    L15:
        if (r3.hasNext() == false) goto L17;
        int associationId3 = r3.next().intValue();
        AssociationInfo a3 = this.mAssociationStore.getAssociationById(associationId3);
        out.append("    ").append(a3.toShortString()).append('\n');
        goto L15
    L5:
        if (this.mNearbyBleDevices.isEmpty() == false) goto L10;
        if (this.mConnectedSelfManagedDevices.isEmpty() == false) goto L10;
        out.append("<empty>\n");
    }
}
