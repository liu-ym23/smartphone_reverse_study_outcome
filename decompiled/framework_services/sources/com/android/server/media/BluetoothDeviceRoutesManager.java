package com.android.server.media;

import android.R;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.MediaRoute2Info;
import android.os.Handler;
import android.os.UserHandle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Slog;
import android.util.SparseBooleanArray;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

/* JADX INFO: loaded from: classes2.dex */
class BluetoothDeviceRoutesManager {
    private static final String HEARING_AID_ROUTE_ID_PREFIX = "HEARING_AID_";
    private static final String LE_AUDIO_ROUTE_ID_PREFIX = "LE_AUDIO_";
    private static final String TAG = "MR2SystemProvider";
    private final AdapterStateChangedReceiver mAdapterStateChangedReceiver;
    private Map<String, BluetoothDevice> mAddressToBondedDevice;
    private final BluetoothAdapter mBluetoothAdapter;
    private final BluetoothProfileMonitor mBluetoothProfileMonitor;
    private final Map<String, BluetoothRouteInfo> mBluetoothRoutes;
    private final Context mContext;
    private final DeviceStateChangedReceiver mDeviceStateChangedReceiver;
    private final Handler mHandler;
    private final BluetoothRouteController.BluetoothRoutesUpdatedListener mListener;

    private class AdapterStateChangedReceiver extends BroadcastReceiver {
        final /* synthetic */ BluetoothDeviceRoutesManager this$0;

        /* JADX INFO: renamed from: $r8$lambda$Y-94Ecaq9Hg_LeQVGeIkV-Bn8iw, reason: not valid java name */
        public static /* synthetic */ void m5513$r8$lambda$Y94Ecaq9Hg_LeQVGeIkVBn8iw(AdapterStateChangedReceiver r0, int r1) {
            r0.lambda$onReceive$0(r1);
        }

        /* synthetic */ AdapterStateChangedReceiver(BluetoothDeviceRoutesManager r1, BluetoothDeviceRoutesManagerIA r2) {
            this(r1);
        }

        private AdapterStateChangedReceiver(BluetoothDeviceRoutesManager r1) {
            this.this$0 = r1;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            final int state = intent.getIntExtra("android.bluetooth.adapter.extra.STATE", -1);
            BluetoothDeviceRoutesManager.m5509$$Nest$fgetmHandler(this.this$0).post(new BluetoothDeviceRoutesManager$AdapterStateChangedReceiver$$ExternalSyntheticLambda0(this, state));
        }

        private /* synthetic */ void lambda$onReceive$0(int state) {
            BluetoothDeviceRoutesManager.m5510$$Nest$mhandleBluetoothAdapterStateChange(this.this$0, state);
        }
    }

    private static class BluetoothRouteInfo {
        private BluetoothDevice mBtDevice;
        private SparseBooleanArray mConnectedProfiles;
        private MediaRoute2Info mRoute;

        /* JADX INFO: renamed from: -$$Nest$fgetmBtDevice, reason: not valid java name */
        static /* bridge */ /* synthetic */ BluetoothDevice m5514$$Nest$fgetmBtDevice(BluetoothRouteInfo r0) {
            return r0.mBtDevice;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmConnectedProfiles, reason: not valid java name */
        static /* bridge */ /* synthetic */ SparseBooleanArray m5515$$Nest$fgetmConnectedProfiles(BluetoothRouteInfo r0) {
            return r0.mConnectedProfiles;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmRoute, reason: not valid java name */
        static /* bridge */ /* synthetic */ MediaRoute2Info m5516$$Nest$fgetmRoute(BluetoothRouteInfo r0) {
            return r0.mRoute;
        }

        /* JADX INFO: renamed from: -$$Nest$fputmBtDevice, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m5517$$Nest$fputmBtDevice(BluetoothRouteInfo r0, BluetoothDevice r1) {
            r0.mBtDevice = r1;
        }

        /* JADX INFO: renamed from: -$$Nest$fputmConnectedProfiles, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m5518$$Nest$fputmConnectedProfiles(BluetoothRouteInfo r0, SparseBooleanArray r1) {
            r0.mConnectedProfiles = r1;
        }

        /* JADX INFO: renamed from: -$$Nest$fputmRoute, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m5519$$Nest$fputmRoute(BluetoothRouteInfo r0, MediaRoute2Info r1) {
            r0.mRoute = r1;
        }

        /* synthetic */ BluetoothRouteInfo(BluetoothDeviceRoutesManagerIA r1) {
            this();
        }

        private BluetoothRouteInfo() {
        }
    }

    private class DeviceStateChangedReceiver extends BroadcastReceiver {
        final /* synthetic */ BluetoothDeviceRoutesManager this$0;

        /* JADX INFO: renamed from: $r8$lambda$YnNdjO8jUafYW9nGc-fEBOr8Jm4, reason: not valid java name */
        public static /* synthetic */ void m5520$r8$lambda$YnNdjO8jUafYW9nGcfEBOr8Jm4(DeviceStateChangedReceiver r0) {
            r0.lambda$onReceive$0();
        }

        /* synthetic */ DeviceStateChangedReceiver(BluetoothDeviceRoutesManager r1, BluetoothDeviceRoutesManagerIA r2) {
            this(r1);
        }

        private DeviceStateChangedReceiver(BluetoothDeviceRoutesManager r1) {
            this.this$0 = r1;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String r0 = intent.getAction();
            switch(r0.hashCode()) {
                case -1765714821: goto L15;
                case -612790895: goto L12;
                case 1174571750: goto L9;
                case 1244161670: goto L6;
                default: goto L17;
            };
        L17:
            byte r1 = -1;
        L18:
            switch(r1) {
                case 0: goto L20;
                case 1: goto L20;
                case 2: goto L20;
                case 3: goto L20;
                default: goto L22;
            };
        L20:
            BluetoothDeviceRoutesManager.m5509$$Nest$fgetmHandler(this.this$0).post(new BluetoothDeviceRoutesManager$DeviceStateChangedReceiver$$ExternalSyntheticLambda0(this));
            return;
        L22:
            return;
        L6:
            if (r0.equals("android.bluetooth.a2dp.profile.action.CONNECTION_STATE_CHANGED") == false) goto L17;
            r1 = 0;
            goto L18
        L9:
            if (r0.equals("android.bluetooth.device.action.ALIAS_CHANGED") == false) goto L17;
            r1 = 3;
            goto L18
        L12:
            if (r0.equals("android.bluetooth.hearingaid.profile.action.CONNECTION_STATE_CHANGED") == false) goto L17;
            r1 = 1;
            goto L18
        L15:
            if (r0.equals("android.bluetooth.action.LE_AUDIO_CONNECTION_STATE_CHANGED") == false) goto L17;
            r1 = 2;
            goto L18
        }

        private /* synthetic */ void lambda$onReceive$0() {
            BluetoothDeviceRoutesManager.m5512$$Nest$mupdateBluetoothRoutes(this.this$0);
            BluetoothDeviceRoutesManager.m5511$$Nest$mnotifyBluetoothRoutesUpdated(this.this$0);
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmHandler, reason: not valid java name */
    static /* bridge */ /* synthetic */ Handler m5509$$Nest$fgetmHandler(BluetoothDeviceRoutesManager r0) {
        return r0.mHandler;
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleBluetoothAdapterStateChange, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5510$$Nest$mhandleBluetoothAdapterStateChange(BluetoothDeviceRoutesManager r0, int r1) {
        r0.handleBluetoothAdapterStateChange(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mnotifyBluetoothRoutesUpdated, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5511$$Nest$mnotifyBluetoothRoutesUpdated(BluetoothDeviceRoutesManager r0) {
        r0.notifyBluetoothRoutesUpdated();
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateBluetoothRoutes, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5512$$Nest$mupdateBluetoothRoutes(BluetoothDeviceRoutesManager r0) {
        r0.updateBluetoothRoutes();
    }

    BluetoothDeviceRoutesManager(Context context, Handler handler, BluetoothAdapter bluetoothAdapter, BluetoothRouteController.BluetoothRoutesUpdatedListener listener) {
        this(context, handler, bluetoothAdapter, new BluetoothProfileMonitor(context, bluetoothAdapter), listener);
    }

    BluetoothDeviceRoutesManager(Context context, Handler handler, BluetoothAdapter bluetoothAdapter, BluetoothProfileMonitor bluetoothProfileMonitor, BluetoothRouteController.BluetoothRoutesUpdatedListener listener) {
        BluetoothDeviceRoutesManagerIA r1 = null;
        this.mAdapterStateChangedReceiver = new AdapterStateChangedReceiver(this, r1);
        this.mDeviceStateChangedReceiver = new DeviceStateChangedReceiver(this, r1);
        this.mAddressToBondedDevice = new HashMap();
        this.mBluetoothRoutes = new HashMap();
        context.getClass();
        this.mContext = context;
        this.mHandler = handler;
        bluetoothAdapter.getClass();
        this.mBluetoothAdapter = bluetoothAdapter;
        bluetoothProfileMonitor.getClass();
        this.mBluetoothProfileMonitor = bluetoothProfileMonitor;
        listener.getClass();
        this.mListener = listener;
    }

    public void start(UserHandle user) {
        this.mBluetoothProfileMonitor.start();
        IntentFilter adapterStateChangedIntentFilter = new IntentFilter();
        adapterStateChangedIntentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
        this.mContext.registerReceiverAsUser(this.mAdapterStateChangedReceiver, user, adapterStateChangedIntentFilter, null, null);
        IntentFilter deviceStateChangedIntentFilter = new IntentFilter();
        deviceStateChangedIntentFilter.addAction("android.bluetooth.a2dp.profile.action.CONNECTION_STATE_CHANGED");
        deviceStateChangedIntentFilter.addAction("android.bluetooth.hearingaid.profile.action.ACTIVE_DEVICE_CHANGED");
        deviceStateChangedIntentFilter.addAction("android.bluetooth.hearingaid.profile.action.CONNECTION_STATE_CHANGED");
        deviceStateChangedIntentFilter.addAction("android.bluetooth.action.LE_AUDIO_CONNECTION_STATE_CHANGED");
        deviceStateChangedIntentFilter.addAction("android.bluetooth.device.action.ALIAS_CHANGED");
        this.mContext.registerReceiverAsUser(this.mDeviceStateChangedReceiver, user, deviceStateChangedIntentFilter, null, null);
        updateBluetoothRoutes();
    }

    public void stop() {
        this.mContext.unregisterReceiver(this.mAdapterStateChangedReceiver);
        this.mContext.unregisterReceiver(this.mDeviceStateChangedReceiver);
    }

    public synchronized boolean containsBondedDeviceWithAddress(String address) {
        monitor-enter(this);
        boolean r0 = this.mAddressToBondedDevice.containsKey(address);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized String getRouteIdForBluetoothAddress(String address) {
        monitor-enter(this);
        BluetoothDevice bluetoothDevice = this.mAddressToBondedDevice.get(address);     // Catch: Throwable -> L7
        if (bluetoothDevice == null) goto L9;
        String r1 = getRouteIdForType(bluetoothDevice, getDeviceType(bluetoothDevice));     // Catch: Throwable -> L7
    L10:
        monitor-exit(this);
        return r1;
    L9:
        r1 = null;
    L7:
        th = move-exception;
        throw th;
    }

    public synchronized String getNameForBluetoothAddress(String address) {
        monitor-enter(this);
        BluetoothDevice bluetoothDevice = this.mAddressToBondedDevice.get(address);     // Catch: Throwable -> L7
        if (bluetoothDevice == null) goto L9;
        String r1 = getDeviceName(bluetoothDevice);     // Catch: Throwable -> L7
    L10:
        monitor-exit(this);
        return r1;
    L9:
        r1 = null;
    L7:
        th = move-exception;
        throw th;
    }

    public synchronized void activateBluetoothDeviceWithAddress(String address) {
        monitor-enter(this);
        BluetoothRouteInfo btRouteInfo = this.mBluetoothRoutes.get(address);     // Catch: Throwable -> L8
        if (btRouteInfo != null) goto L10;
        Slog.w(TAG, "activateBluetoothDeviceWithAddress: Ignoring unknown address " + address);     // Catch: Throwable -> L8
        monitor-exit(this);
        return;
    L10:
        this.mBluetoothAdapter.setActiveDevice(BluetoothRouteInfo.m5514$$Nest$fgetmBtDevice(btRouteInfo), 0);     // Catch: Throwable -> L8
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private void updateBluetoothRoutes() {
        Set<BluetoothDevice> bondedDevices = this.mBluetoothAdapter.getBondedDevices();
        monitor-enter(this);
        this.mBluetoothRoutes.clear();     // Catch: Throwable -> L9
        if (bondedDevices != null) goto L11;
        Log.w(TAG, "BluetoothAdapter.getBondedDevices returned null.");     // Catch: Throwable -> L9
        monitor-exit(this);     // Catch: Throwable -> L9
        return;
    L11:
        this.mAddressToBondedDevice = (Map) bondedDevices.stream().collect(Collectors.toMap(new BluetoothDeviceRoutesManager$$ExternalSyntheticLambda0(), Function.identity()));     // Catch: Throwable -> L9
        Iterator<BluetoothDevice> r1 = bondedDevices.iterator();     // Catch: Throwable -> L9
    L13:
        if (r1.hasNext() == false) goto L20;
        BluetoothDevice device = r1.next();     // Catch: Throwable -> L9
        if (device.isConnected() == false) goto L13;
        BluetoothRouteInfo newBtRoute = createBluetoothRoute(device);     // Catch: Throwable -> L9
        if (BluetoothRouteInfo.m5515$$Nest$fgetmConnectedProfiles(newBtRoute).size() <= 0) goto L13;
        this.mBluetoothRoutes.put(device.getAddress(), newBtRoute);     // Catch: Throwable -> L9
        goto L13
    L20:
        monitor-exit(this);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public List<MediaRoute2Info> getAvailableBluetoothRoutes() {
        List<MediaRoute2Info> routes = new ArrayList();
        Set<String> routeIds = new HashSet();
        monitor-enter(this);
        Iterator<BluetoothRouteInfo> r2 = this.mBluetoothRoutes.values().iterator();     // Catch: Throwable -> L10
    L6:
        if (r2.hasNext() == false) goto L13;
        BluetoothRouteInfo btRoute = r2.next();     // Catch: Throwable -> L10
        if (routeIds.add(BluetoothRouteInfo.m5516$$Nest$fgetmRoute(btRoute).getId()) == false) goto L6;
        routes.add(BluetoothRouteInfo.m5516$$Nest$fgetmRoute(btRoute));     // Catch: Throwable -> L10
        goto L6
    L13:
        monitor-exit(this);     // Catch: Throwable -> L10
        return routes;
    L10:
        th = move-exception;
        throw th;
    }

    private void notifyBluetoothRoutesUpdated() {
        this.mListener.onBluetoothRoutesUpdated();
    }

    private BluetoothRouteInfo createBluetoothRoute(BluetoothDevice device) {
        BluetoothRouteInfo newBtRoute = new BluetoothRouteInfo(null);
        BluetoothRouteInfo.m5517$$Nest$fputmBtDevice(newBtRoute, device);
        String deviceName = getDeviceName(device);
        int type = getDeviceType(device);
        String routeId = getRouteIdForType(device, type);
        BluetoothRouteInfo.m5518$$Nest$fputmConnectedProfiles(newBtRoute, getConnectedProfiles(device));
        BluetoothRouteInfo.m5519$$Nest$fputmRoute(newBtRoute, new MediaRoute2Info.Builder(routeId, deviceName).addFeature("android.media.route.feature.LIVE_AUDIO").addFeature("android.media.route.feature.LOCAL_PLAYBACK").setConnectionState(0).setDescription(this.mContext.getResources().getText(R.string.car_mode_disable_notification_message).toString()).setType(type).setAddress(device.getAddress()).build());
        return newBtRoute;
    }

    private String getDeviceName(BluetoothDevice device) {
        String deviceName = device.getAlias();
        if (TextUtils.isEmpty(deviceName) == true) goto L5;
        return deviceName;
    L5:
        return this.mContext.getResources().getText(R.string.unknownName).toString();
    }

    private SparseBooleanArray getConnectedProfiles(BluetoothDevice device) {
        SparseBooleanArray connectedProfiles = new SparseBooleanArray();
        if (this.mBluetoothProfileMonitor.isProfileSupported(2, device) == false) goto L6;
        connectedProfiles.put(2, true);
    L6:
        if (this.mBluetoothProfileMonitor.isProfileSupported(21, device) == false) goto L9;
        connectedProfiles.put(21, true);
    L9:
        if (this.mBluetoothProfileMonitor.isProfileSupported(22, device) == false) goto L11;
        connectedProfiles.put(22, true);
    L11:
        return connectedProfiles;
    }

    private int getDeviceType(BluetoothDevice device) {
        if (this.mBluetoothProfileMonitor.isProfileSupported(22, device) == false) goto L7;
        return 26;
    L7:
        if (this.mBluetoothProfileMonitor.isProfileSupported(21, device) == false) goto L10;
        return 23;
    L10:
        return 8;
    }

    private String getRouteIdForType(BluetoothDevice device, int type) {
        switch(type) {
            case 23: goto L6;
            case 26: goto L8;
            default: goto L7;
        };
    L7:
        return device.getAddress();
    L8:
        return LE_AUDIO_ROUTE_ID_PREFIX + this.mBluetoothProfileMonitor.getGroupId(22, device);
    L6:
        return HEARING_AID_ROUTE_ID_PREFIX + this.mBluetoothProfileMonitor.getGroupId(21, device);
    }

    private void handleBluetoothAdapterStateChange(int state) {
        if (state != 10) goto L5;
    L21:
        monitor-enter(this);
        this.mBluetoothRoutes.clear();     // Catch: Throwable -> L26
        monitor-exit(this);     // Catch: Throwable -> L26
        notifyBluetoothRoutesUpdated();
        return;
    L26:
        th = move-exception;
        throw th;
    L5:
        if (state == 13) goto L21;
        if (state != 12) goto L33;
        updateBluetoothRoutes();
        monitor-enter(this);
    L18:
        th = move-exception;
        throw th;
    L12:
        if (this.mBluetoothRoutes.isEmpty() == true) goto L14;
        boolean shouldCallListener = true;
    L15:
        monitor-exit(this);     // Catch: Throwable -> L18
        if (shouldCallListener == false) goto L34;
        notifyBluetoothRoutesUpdated();
        return;
    L34:
        return;
    L14:
        shouldCallListener = false;
        goto L15
    }
}
