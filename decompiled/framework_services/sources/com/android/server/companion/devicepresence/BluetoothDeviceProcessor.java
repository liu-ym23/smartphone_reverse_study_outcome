package com.android.server.companion.devicepresence;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.companion.AssociationInfo;
import android.net.MacAddress;
import android.os.Handler;
import android.os.HandlerExecutor;
import android.os.ParcelUuid;
import android.os.UserHandle;
import com.android.internal.util.ArrayUtils;
import com.android.server.companion.association.AssociationStore;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class BluetoothDeviceProcessor extends BluetoothAdapter.BluetoothConnectionCallback implements AssociationStore.OnChangeListener {
    private static final String TAG = "CDM_BluetoothDeviceProcessor";
    private final Map<MacAddress, BluetoothDevice> mAllConnectedDevices;
    private final AssociationStore mAssociationStore;
    private final Callback mCallback;
    private final ObservableUuidStore mObservableUuidStore;

    interface Callback {
        void onBluetoothCompanionDeviceConnected(int r1, int r2);

        void onBluetoothCompanionDeviceDisconnected(int r1, int r2);

        void onDevicePresenceEventByUuid(ObservableUuid r1, int r2);
    }

    BluetoothDeviceProcessor(AssociationStore associationStore, ObservableUuidStore observableUuidStore, Callback callback) {
        this.mAllConnectedDevices = new HashMap();
        this.mAssociationStore = associationStore;
        this.mObservableUuidStore = observableUuidStore;
        this.mCallback = callback;
    }

    void init(BluetoothAdapter btAdapter) {
        btAdapter.registerBluetoothConnectionCallback(new HandlerExecutor(Handler.getMain()), this);
        this.mAssociationStore.registerLocalListener(this);
    }

    public void onDeviceConnected(BluetoothDevice device) {
        MacAddress macAddress = MacAddress.fromString(device.getAddress());
        if (this.mAllConnectedDevices.put(macAddress, device) == null) goto L5;
        return;
    L5:
        onDeviceConnectivityChanged(device, true);
    }

    public void onDeviceDisconnected(BluetoothDevice device, int reason) {
        MacAddress macAddress = MacAddress.fromString(device.getAddress());
        if (this.mAllConnectedDevices.remove(macAddress) != null) goto L5;
        return;
    L5:
        onDeviceConnectivityChanged(device, false);
    }

    private void onDeviceConnectivityChanged(BluetoothDevice device, boolean connected) {
        int userId = UserHandle.myUserId();
        List<AssociationInfo> associations = this.mAssociationStore.getActiveAssociationsByAddress(device.getAddress());
        Iterator<AssociationInfo> r2 = associations.iterator();
    L4:
        if (r2.hasNext() == false) goto L13;
        AssociationInfo association = r2.next();
        if (association.isNotifyOnDeviceNearby() == false) goto L4;
        int id = association.getId();
        if (connected == true) goto L10;
        this.mCallback.onBluetoothCompanionDeviceDisconnected(id, association.getUserId());
        goto L4
    L10:
        this.mCallback.onBluetoothCompanionDeviceConnected(id, association.getUserId());
        goto L4
    L13:
        List<ObservableUuid> observableUuids = this.mObservableUuidStore.getObservableUuidsForUser(userId);
        ParcelUuid[] bluetoothDeviceUuids = device.getUuids();
        if (ArrayUtils.isEmpty(bluetoothDeviceUuids) == false) goto L16;
        List<ParcelUuid> deviceUuids = Collections.emptyList();
    L17:
        Iterator<ObservableUuid> r5 = observableUuids.iterator();
    L19:
        if (r5.hasNext() == false) goto L28;
        ObservableUuid uuid = r5.next();
        if (deviceUuids.contains(uuid.getUuid()) == false) goto L19;
        Callback r7 = this.mCallback;
        if (connected == false) goto L25;
        int r8 = 2;
    L26:
        r7.onDevicePresenceEventByUuid(uuid, r8);
        goto L19
    L25:
        r8 = 3;
        goto L26
    L28:
        return;
    L16:
        deviceUuids = Arrays.asList(bluetoothDeviceUuids);
        goto L17
    }

    @Override // com.android.server.companion.association.AssociationStore.OnChangeListener
    public void onAssociationAdded(AssociationInfo association) {
        if (this.mAllConnectedDevices.containsKey(association.getDeviceMacAddress()) == false) goto L6;
        this.mCallback.onBluetoothCompanionDeviceConnected(association.getId(), association.getUserId());
        return;
    }
}
