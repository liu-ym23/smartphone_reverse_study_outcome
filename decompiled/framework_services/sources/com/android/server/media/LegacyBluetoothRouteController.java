package com.android.server.media;

import android.R;
import android.bluetooth.BluetoothA2dp;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothHearingAid;
import android.bluetooth.BluetoothLeAudio;
import android.bluetooth.BluetoothProfile;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.audio.common.V2_0.AudioDevice;
import android.media.AudioManager;
import android.media.MediaRoute2Info;
import android.os.UserHandle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Slog;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
class LegacyBluetoothRouteController implements BluetoothRouteController {
    private static final boolean DEBUG = false;
    private static final String HEARING_AID_ROUTE_ID_PREFIX = "HEARING_AID_";
    private static final String LE_AUDIO_ROUTE_ID_PREFIX = "LE_AUDIO_";
    private static final String TAG = "LBtRouteProvider";
    private BluetoothA2dp mA2dpProfile;
    private final List<BluetoothRouteInfo> mActiveRoutes;
    private final AdapterStateChangedReceiver mAdapterStateChangedReceiver;
    private final AudioManager mAudioManager;
    private final BluetoothAdapter mBluetoothAdapter;
    private final Map<String, BluetoothRouteInfo> mBluetoothRoutes;
    private final Context mContext;
    private final DeviceStateChangedReceiver mDeviceStateChangedReceiver;
    private BluetoothHearingAid mHearingAidProfile;
    private BluetoothLeAudio mLeAudioProfile;
    private final BluetoothRouteController.BluetoothRoutesUpdatedListener mListener;
    private final BluetoothProfileListener mProfileListener;
    private final SparseIntArray mVolumeMap;

    private class AdapterStateChangedReceiver extends BroadcastReceiver {
        final /* synthetic */ LegacyBluetoothRouteController this$0;

        /* synthetic */ AdapterStateChangedReceiver(LegacyBluetoothRouteController r1, LegacyBluetoothRouteControllerIA r2) {
            this(r1);
        }

        private AdapterStateChangedReceiver(LegacyBluetoothRouteController r1) {
            this.this$0 = r1;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            int state = intent.getIntExtra("android.bluetooth.adapter.extra.STATE", -1);
            if (state != 10) goto L5;
        L12:
            LegacyBluetoothRouteController.m5525$$Nest$fgetmBluetoothRoutes(this.this$0).clear();
            LegacyBluetoothRouteController.m5534$$Nest$mnotifyBluetoothRoutesUpdated(this.this$0);
            return;
        L5:
            if (state == 13) goto L12;
            if (state != 12) goto L14;
            LegacyBluetoothRouteController.m5531$$Nest$mbuildBluetoothRoutes(this.this$0);
            if (LegacyBluetoothRouteController.m5525$$Nest$fgetmBluetoothRoutes(this.this$0).isEmpty() == true) goto L15;
            LegacyBluetoothRouteController.m5534$$Nest$mnotifyBluetoothRoutesUpdated(this.this$0);
            return;
        L15:
            return;
        }
    }

    private final class BluetoothProfileListener implements BluetoothProfile.ServiceListener {
        final /* synthetic */ LegacyBluetoothRouteController this$0;

        /* synthetic */ BluetoothProfileListener(LegacyBluetoothRouteController r1, LegacyBluetoothRouteControllerIA r2) {
            this(r1);
        }

        private BluetoothProfileListener(LegacyBluetoothRouteController r1) {
            this.this$0 = r1;
        }

        @Override // android.bluetooth.BluetoothProfile.ServiceListener
        public void onServiceConnected(int profile, BluetoothProfile proxy) {
            switch(profile) {
                case 2: goto L6;
                case 21: goto L5;
                case 22: goto L4;
                default: goto L3;
            };
        L3:
            return;
        L4:
            LegacyBluetoothRouteController.m5528$$Nest$fputmLeAudioProfile(this.this$0, (BluetoothLeAudio) proxy);
            List<BluetoothDevice> activeDevices = LegacyBluetoothRouteController.m5524$$Nest$fgetmBluetoothAdapter(this.this$0).getActiveDevices(22);
        L7:
            Iterator<BluetoothDevice> r1 = proxy.getConnectedDevices().iterator();
        L9:
            if (r1.hasNext() == false) goto L17;
            BluetoothDevice device = r1.next();
            BluetoothRouteInfo btRoute = (BluetoothRouteInfo) LegacyBluetoothRouteController.m5525$$Nest$fgetmBluetoothRoutes(this.this$0).get(device.getAddress());
            if (btRoute != null) goto L14;
            btRoute = LegacyBluetoothRouteController.m5533$$Nest$mcreateBluetoothRoute(this.this$0, device);
            LegacyBluetoothRouteController.m5525$$Nest$fgetmBluetoothRoutes(this.this$0).put(device.getAddress(), btRoute);
        L14:
            if (activeDevices.contains(device) == false) goto L9;
            LegacyBluetoothRouteController.m5530$$Nest$maddActiveRoute(this.this$0, btRoute);
            goto L9
        L17:
            LegacyBluetoothRouteController.m5534$$Nest$mnotifyBluetoothRoutesUpdated(this.this$0);
            return;
        L5:
            LegacyBluetoothRouteController.m5527$$Nest$fputmHearingAidProfile(this.this$0, (BluetoothHearingAid) proxy);
            activeDevices = LegacyBluetoothRouteController.m5524$$Nest$fgetmBluetoothAdapter(this.this$0).getActiveDevices(21);
            goto L7
        L6:
            LegacyBluetoothRouteController.m5526$$Nest$fputmA2dpProfile(this.this$0, (BluetoothA2dp) proxy);
            activeDevices = LegacyBluetoothRouteController.m5524$$Nest$fgetmBluetoothAdapter(this.this$0).getActiveDevices(2);
            goto L7
        }

        @Override // android.bluetooth.BluetoothProfile.ServiceListener
        public void onServiceDisconnected(int profile) {
            switch(profile) {
                case 2: goto L7;
                case 21: goto L6;
                case 22: goto L5;
                default: goto L4;
            };
        L4:
            return;
        L5:
            LegacyBluetoothRouteController.m5528$$Nest$fputmLeAudioProfile(this.this$0, null);
            return;
        L6:
            LegacyBluetoothRouteController.m5527$$Nest$fputmHearingAidProfile(this.this$0, null);
            return;
        L7:
            LegacyBluetoothRouteController.m5526$$Nest$fputmA2dpProfile(this.this$0, null);
        }
    }

    private static class BluetoothRouteInfo {
        private BluetoothDevice mBtDevice;
        private SparseBooleanArray mConnectedProfiles;
        private MediaRoute2Info mRoute;

        /* JADX INFO: renamed from: -$$Nest$fgetmBtDevice, reason: not valid java name */
        static /* bridge */ /* synthetic */ BluetoothDevice m5537$$Nest$fgetmBtDevice(BluetoothRouteInfo r0) {
            return r0.mBtDevice;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmConnectedProfiles, reason: not valid java name */
        static /* bridge */ /* synthetic */ SparseBooleanArray m5538$$Nest$fgetmConnectedProfiles(BluetoothRouteInfo r0) {
            return r0.mConnectedProfiles;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmRoute, reason: not valid java name */
        static /* bridge */ /* synthetic */ MediaRoute2Info m5539$$Nest$fgetmRoute(BluetoothRouteInfo r0) {
            return r0.mRoute;
        }

        /* JADX INFO: renamed from: -$$Nest$fputmBtDevice, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m5540$$Nest$fputmBtDevice(BluetoothRouteInfo r0, BluetoothDevice r1) {
            r0.mBtDevice = r1;
        }

        /* JADX INFO: renamed from: -$$Nest$fputmConnectedProfiles, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m5541$$Nest$fputmConnectedProfiles(BluetoothRouteInfo r0, SparseBooleanArray r1) {
            r0.mConnectedProfiles = r1;
        }

        /* JADX INFO: renamed from: -$$Nest$fputmRoute, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m5542$$Nest$fputmRoute(BluetoothRouteInfo r0, MediaRoute2Info r1) {
            r0.mRoute = r1;
        }

        /* synthetic */ BluetoothRouteInfo(LegacyBluetoothRouteControllerIA r1) {
            this();
        }

        private BluetoothRouteInfo() {
        }

        int getRouteType() {
            if (this.mConnectedProfiles.get(21, false) == false) goto L7;
            return 23;
        L7:
            if (this.mConnectedProfiles.get(22, false) == false) goto L10;
            return 26;
        L10:
            return 8;
        }
    }

    private class DeviceStateChangedReceiver extends BroadcastReceiver {
        final /* synthetic */ LegacyBluetoothRouteController this$0;

        /* synthetic */ DeviceStateChangedReceiver(LegacyBluetoothRouteController r1, LegacyBluetoothRouteControllerIA r2) {
            this(r1);
        }

        private DeviceStateChangedReceiver(LegacyBluetoothRouteController r1) {
            this.this$0 = r1;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            BluetoothDevice device = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE", BluetoothDevice.class);
            String r1 = intent.getAction();
            switch(r1.hashCode()) {
                case -1765714821: goto L21;
                case -749511570: goto L18;
                case -612790895: goto L15;
                case 487423555: goto L12;
                case 1176349464: goto L9;
                case 1244161670: goto L6;
                default: goto L23;
            };
        L23:
            byte r2 = -1;
        L25:
            switch(r2) {
                case 0: goto L44;
                case 1: goto L37;
                case 2: goto L30;
                case 3: goto L29;
                case 4: goto L28;
                case 5: goto L27;
                default: goto L57;
            };
        L27:
            handleConnectionStateChanged(22, intent, device);
            return;
        L28:
            handleConnectionStateChanged(21, intent, device);
            return;
        L29:
            handleConnectionStateChanged(2, intent, device);
            return;
        L30:
            LegacyBluetoothRouteController.m5532$$Nest$mclearActiveRoutesWithType(this.this$0, 26);
            if (device != null) goto L33;
        L36:
            LegacyBluetoothRouteController.m5534$$Nest$mnotifyBluetoothRoutesUpdated(this.this$0);
            return;
        L33:
            if (LegacyBluetoothRouteController.m5536$$Nest$sfgetDEBUG() == false) goto L35;
            Log.d(LegacyBluetoothRouteController.TAG, "Setting active le audio devices. device=" + device);
        L35:
            LegacyBluetoothRouteController.m5529$$Nest$maddActiveDevices(this.this$0, device);
            goto L36
        L37:
            LegacyBluetoothRouteController.m5532$$Nest$mclearActiveRoutesWithType(this.this$0, 23);
            if (device != null) goto L40;
        L43:
            LegacyBluetoothRouteController.m5534$$Nest$mnotifyBluetoothRoutesUpdated(this.this$0);
            return;
        L40:
            if (LegacyBluetoothRouteController.m5536$$Nest$sfgetDEBUG() == false) goto L42;
            Log.d(LegacyBluetoothRouteController.TAG, "Setting active hearing aid devices. device=" + device);
        L42:
            LegacyBluetoothRouteController.m5529$$Nest$maddActiveDevices(this.this$0, device);
            goto L43
        L44:
            LegacyBluetoothRouteController.m5532$$Nest$mclearActiveRoutesWithType(this.this$0, 8);
            if (device != null) goto L47;
        L50:
            LegacyBluetoothRouteController.m5534$$Nest$mnotifyBluetoothRoutesUpdated(this.this$0);
            return;
        L47:
            if (LegacyBluetoothRouteController.m5536$$Nest$sfgetDEBUG() == false) goto L49;
            Log.d(LegacyBluetoothRouteController.TAG, "Setting active a2dp devices. device=" + device);
        L49:
            LegacyBluetoothRouteController.m5529$$Nest$maddActiveDevices(this.this$0, device);
            goto L50
        L57:
            return;
        L6:
            if (r1.equals("android.bluetooth.a2dp.profile.action.CONNECTION_STATE_CHANGED") == false) goto L23;
            r2 = 3;
            goto L25
        L9:
            if (r1.equals("android.bluetooth.hearingaid.profile.action.ACTIVE_DEVICE_CHANGED") == false) goto L23;
            r2 = 1;
            goto L25
        L12:
            if (r1.equals("android.bluetooth.a2dp.profile.action.ACTIVE_DEVICE_CHANGED") == false) goto L23;
            r2 = 0;
            goto L25
        L15:
            if (r1.equals("android.bluetooth.hearingaid.profile.action.CONNECTION_STATE_CHANGED") == false) goto L23;
            r2 = 4;
            goto L25
        L18:
            if (r1.equals("android.bluetooth.action.LE_AUDIO_ACTIVE_DEVICE_CHANGED") == false) goto L23;
            r2 = 2;
            goto L25
        L21:
            if (r1.equals("android.bluetooth.action.LE_AUDIO_CONNECTION_STATE_CHANGED") == false) goto L23;
            r2 = 5;
            goto L25
        }

        private void handleConnectionStateChanged(int profile, Intent intent, BluetoothDevice device) {
            int state = intent.getIntExtra("android.bluetooth.profile.extra.STATE", -1);
            BluetoothRouteInfo btRoute = (BluetoothRouteInfo) LegacyBluetoothRouteController.m5525$$Nest$fgetmBluetoothRoutes(this.this$0).get(device.getAddress());
            if (state != 2) goto L10;
            if (btRoute != null) goto L8;
            BluetoothRouteInfo btRoute2 = LegacyBluetoothRouteController.m5533$$Nest$mcreateBluetoothRoute(this.this$0, device);
            if (BluetoothRouteInfo.m5538$$Nest$fgetmConnectedProfiles(btRoute2).size() <= 0) goto L17;
            LegacyBluetoothRouteController.m5525$$Nest$fgetmBluetoothRoutes(this.this$0).put(device.getAddress(), btRoute2);
            LegacyBluetoothRouteController.m5534$$Nest$mnotifyBluetoothRoutesUpdated(this.this$0);
            return;
        L17:
            return;
        L8:
            BluetoothRouteInfo.m5538$$Nest$fgetmConnectedProfiles(btRoute).put(profile, true);
            return;
        L10:
            if (state == 3) goto L12;
            if (state == 0) goto L12;
            return;
        L12:
            if (btRoute == null) goto L21;
            BluetoothRouteInfo.m5538$$Nest$fgetmConnectedProfiles(btRoute).delete(profile);
            if (BluetoothRouteInfo.m5538$$Nest$fgetmConnectedProfiles(btRoute).size() != 0) goto L22;
            LegacyBluetoothRouteController.m5535$$Nest$mremoveActiveRoute(this.this$0, (BluetoothRouteInfo) LegacyBluetoothRouteController.m5525$$Nest$fgetmBluetoothRoutes(this.this$0).remove(device.getAddress()));
            LegacyBluetoothRouteController.m5534$$Nest$mnotifyBluetoothRoutesUpdated(this.this$0);
            return;
        L22:
            return;
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmBluetoothAdapter, reason: not valid java name */
    static /* bridge */ /* synthetic */ BluetoothAdapter m5524$$Nest$fgetmBluetoothAdapter(LegacyBluetoothRouteController r0) {
        return r0.mBluetoothAdapter;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmBluetoothRoutes, reason: not valid java name */
    static /* bridge */ /* synthetic */ Map m5525$$Nest$fgetmBluetoothRoutes(LegacyBluetoothRouteController r0) {
        return r0.mBluetoothRoutes;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmA2dpProfile, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5526$$Nest$fputmA2dpProfile(LegacyBluetoothRouteController r0, BluetoothA2dp r1) {
        r0.mA2dpProfile = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmHearingAidProfile, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5527$$Nest$fputmHearingAidProfile(LegacyBluetoothRouteController r0, BluetoothHearingAid r1) {
        r0.mHearingAidProfile = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmLeAudioProfile, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5528$$Nest$fputmLeAudioProfile(LegacyBluetoothRouteController r0, BluetoothLeAudio r1) {
        r0.mLeAudioProfile = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$maddActiveDevices, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5529$$Nest$maddActiveDevices(LegacyBluetoothRouteController r0, BluetoothDevice r1) {
        r0.addActiveDevices(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$maddActiveRoute, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5530$$Nest$maddActiveRoute(LegacyBluetoothRouteController r0, BluetoothRouteInfo r1) {
        r0.addActiveRoute(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mbuildBluetoothRoutes, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5531$$Nest$mbuildBluetoothRoutes(LegacyBluetoothRouteController r0) {
        r0.buildBluetoothRoutes();
    }

    /* JADX INFO: renamed from: -$$Nest$mclearActiveRoutesWithType, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5532$$Nest$mclearActiveRoutesWithType(LegacyBluetoothRouteController r0, int r1) {
        r0.clearActiveRoutesWithType(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mcreateBluetoothRoute, reason: not valid java name */
    static /* bridge */ /* synthetic */ BluetoothRouteInfo m5533$$Nest$mcreateBluetoothRoute(LegacyBluetoothRouteController r0, BluetoothDevice r1) {
        return r0.createBluetoothRoute(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mnotifyBluetoothRoutesUpdated, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5534$$Nest$mnotifyBluetoothRoutesUpdated(LegacyBluetoothRouteController r0) {
        r0.notifyBluetoothRoutesUpdated();
    }

    /* JADX INFO: renamed from: -$$Nest$mremoveActiveRoute, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5535$$Nest$mremoveActiveRoute(LegacyBluetoothRouteController r0, BluetoothRouteInfo r1) {
        r0.removeActiveRoute(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetDEBUG, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m5536$$Nest$sfgetDEBUG() {
        return DEBUG;
    }

    static {
        DEBUG = Log.isLoggable(TAG, 3);
    }

    LegacyBluetoothRouteController(Context context, BluetoothAdapter btAdapter, BluetoothRouteController.BluetoothRoutesUpdatedListener listener) {
        this.mBluetoothRoutes = new HashMap();
        this.mActiveRoutes = new ArrayList();
        this.mVolumeMap = new SparseIntArray();
        LegacyBluetoothRouteControllerIA r1 = null;
        this.mProfileListener = new BluetoothProfileListener(this, r1);
        this.mAdapterStateChangedReceiver = new AdapterStateChangedReceiver(this, r1);
        this.mDeviceStateChangedReceiver = new DeviceStateChangedReceiver(this, r1);
        this.mContext = context;
        this.mBluetoothAdapter = btAdapter;
        this.mListener = listener;
        this.mAudioManager = (AudioManager) this.mContext.getSystemService("audio");
        buildBluetoothRoutes();
    }

    @Override // com.android.server.media.BluetoothRouteController
    public void start(UserHandle user) {
        this.mBluetoothAdapter.getProfileProxy(this.mContext, this.mProfileListener, 2);
        this.mBluetoothAdapter.getProfileProxy(this.mContext, this.mProfileListener, 21);
        this.mBluetoothAdapter.getProfileProxy(this.mContext, this.mProfileListener, 22);
        IntentFilter adapterStateChangedIntentFilter = new IntentFilter();
        adapterStateChangedIntentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
        this.mContext.registerReceiverAsUser(this.mAdapterStateChangedReceiver, user, adapterStateChangedIntentFilter, null, null);
        IntentFilter deviceStateChangedIntentFilter = new IntentFilter();
        deviceStateChangedIntentFilter.addAction("android.bluetooth.a2dp.profile.action.ACTIVE_DEVICE_CHANGED");
        deviceStateChangedIntentFilter.addAction("android.bluetooth.a2dp.profile.action.CONNECTION_STATE_CHANGED");
        deviceStateChangedIntentFilter.addAction("android.bluetooth.hearingaid.profile.action.ACTIVE_DEVICE_CHANGED");
        deviceStateChangedIntentFilter.addAction("android.bluetooth.hearingaid.profile.action.CONNECTION_STATE_CHANGED");
        deviceStateChangedIntentFilter.addAction("android.bluetooth.action.LE_AUDIO_CONNECTION_STATE_CHANGED");
        deviceStateChangedIntentFilter.addAction("android.bluetooth.action.LE_AUDIO_ACTIVE_DEVICE_CHANGED");
        this.mContext.registerReceiverAsUser(this.mDeviceStateChangedReceiver, user, deviceStateChangedIntentFilter, null, null);
    }

    @Override // com.android.server.media.BluetoothRouteController
    public void stop() {
        this.mContext.unregisterReceiver(this.mAdapterStateChangedReceiver);
        this.mContext.unregisterReceiver(this.mDeviceStateChangedReceiver);
    }

    @Override // com.android.server.media.BluetoothRouteController
    public void transferTo(String routeId) {
        if (routeId != null) goto L5;
        clearActiveDevices();
        return;
    L5:
        BluetoothRouteInfo btRouteInfo = findBluetoothRouteWithRouteId(routeId);
        if (btRouteInfo != null) goto L10;
        Slog.w(TAG, "transferTo: Unknown route. ID=" + routeId);
        return;
    L10:
        if (this.mBluetoothAdapter == null) goto L13;
        this.mBluetoothAdapter.setActiveDevice(BluetoothRouteInfo.m5537$$Nest$fgetmBtDevice(btRouteInfo), 0);
        return;
    }

    private BluetoothRouteInfo findBluetoothRouteWithRouteId(String routeId) {
        if (routeId != null) goto L5;
        return null;
    L5:
        Iterator<BluetoothRouteInfo> r1 = this.mBluetoothRoutes.values().iterator();
    L7:
        if (r1.hasNext() == false) goto L12;
        BluetoothRouteInfo btRouteInfo = r1.next();
        if (TextUtils.equals(BluetoothRouteInfo.m5539$$Nest$fgetmRoute(btRouteInfo).getId(), routeId) == false) goto L7;
        return btRouteInfo;
    L12:
        return null;
    }

    private void clearActiveDevices() {
        if (this.mBluetoothAdapter == null) goto L6;
        this.mBluetoothAdapter.removeActiveDevice(0);
        return;
    }

    private void buildBluetoothRoutes() {
        this.mBluetoothRoutes.clear();
        Set<BluetoothDevice> bondedDevices = this.mBluetoothAdapter.getBondedDevices();
        if (bondedDevices == null) goto L13;
        Iterator<BluetoothDevice> r1 = bondedDevices.iterator();
    L6:
        if (r1.hasNext() == false) goto L21;
        BluetoothDevice device = r1.next();
        if (device.isConnected() == false) goto L6;
        BluetoothRouteInfo newBtRoute = createBluetoothRoute(device);
        if (BluetoothRouteInfo.m5538$$Nest$fgetmConnectedProfiles(newBtRoute).size() <= 0) goto L6;
        this.mBluetoothRoutes.put(device.getAddress(), newBtRoute);
        goto L6
    L21:
        return;
    }

    @Override // com.android.server.media.BluetoothRouteController
    public MediaRoute2Info getSelectedRoute() {
        if (this.mActiveRoutes.isEmpty() == false) goto L6;
        return null;
    L6:
        return BluetoothRouteInfo.m5539$$Nest$fgetmRoute(this.mActiveRoutes.get(0));
    }

    @Override // com.android.server.media.BluetoothRouteController
    public List<MediaRoute2Info> getTransferableRoutes() {
        List<MediaRoute2Info> routes = getAllBluetoothRoutes();
        Iterator<BluetoothRouteInfo> r1 = this.mActiveRoutes.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        BluetoothRouteInfo btRoute = r1.next();
        routes.remove(BluetoothRouteInfo.m5539$$Nest$fgetmRoute(btRoute));
        goto L4
    L6:
        return routes;
    }

    @Override // com.android.server.media.BluetoothRouteController
    public List<MediaRoute2Info> getAllBluetoothRoutes() {
        List<MediaRoute2Info> routes = new ArrayList();
        List<String> routeIds = new ArrayList();
        MediaRoute2Info selectedRoute = getSelectedRoute();
        if (selectedRoute == null) goto L5;
        routes.add(selectedRoute);
        routeIds.add(selectedRoute.getId());
    L5:
        Iterator<BluetoothRouteInfo> r3 = this.mBluetoothRoutes.values().iterator();
    L7:
        if (r3.hasNext() == false) goto L12;
        BluetoothRouteInfo btRoute = r3.next();
        if (routeIds.contains(BluetoothRouteInfo.m5539$$Nest$fgetmRoute(btRoute).getId()) == true) goto L7;
        routes.add(BluetoothRouteInfo.m5539$$Nest$fgetmRoute(btRoute));
        routeIds.add(BluetoothRouteInfo.m5539$$Nest$fgetmRoute(btRoute).getId());
        goto L7
    L12:
        return routes;
    }

    @Override // com.android.server.media.BluetoothRouteController
    public boolean updateVolumeForDevices(int devices, int volume) {
        if ((134217728 & devices) == 0) goto L5;
        int routeType = 23;
    L11:
        this.mVolumeMap.put(routeType, volume);
        boolean shouldNotify = false;
        Iterator<BluetoothRouteInfo> r2 = this.mActiveRoutes.iterator();
    L13:
        if (r2.hasNext() == false) goto L18;
        BluetoothRouteInfo btRoute = r2.next();
        if (BluetoothRouteInfo.m5539$$Nest$fgetmRoute(btRoute).getType() != routeType) goto L13;
        BluetoothRouteInfo.m5542$$Nest$fputmRoute(btRoute, new MediaRoute2Info.Builder(BluetoothRouteInfo.m5539$$Nest$fgetmRoute(btRoute)).setVolume(volume).build());
        shouldNotify = true;
        goto L13
    L18:
        if (shouldNotify == false) goto L29;
        notifyBluetoothRoutesUpdated();
        return true;
    L29:
        return true;
    L5:
        int routeType2 = devices & AudioDevice.OUT_ALL_A2DP;
        if (routeType2 == 0) goto L9;
        routeType = 8;
        goto L11
    L9:
        if ((536870912 & devices) == 0) goto L22;
        routeType = 26;
        goto L11
    L22:
        return false;
    }

    private void notifyBluetoothRoutesUpdated() {
        if (this.mListener == null) goto L6;
        this.mListener.onBluetoothRoutesUpdated();
        return;
    }

    private BluetoothRouteInfo createBluetoothRoute(BluetoothDevice device) {
        BluetoothRouteInfo newBtRoute = new BluetoothRouteInfo(null);
        BluetoothRouteInfo.m5540$$Nest$fputmBtDevice(newBtRoute, device);
        String routeId = device.getAddress();
        String deviceName = device.getAlias();
        if (TextUtils.isEmpty(deviceName) == false) goto L5;
        deviceName = this.mContext.getResources().getText(R.string.unknownName).toString();
    L5:
        int type = 8;
        BluetoothRouteInfo.m5541$$Nest$fputmConnectedProfiles(newBtRoute, new SparseBooleanArray());
        if (this.mA2dpProfile == null) goto L11;
        if (this.mA2dpProfile.getConnectedDevices().contains(device) == false) goto L11;
        BluetoothRouteInfo.m5538$$Nest$fgetmConnectedProfiles(newBtRoute).put(2, true);
    L11:
        if (this.mHearingAidProfile == null) goto L16;
        if (this.mHearingAidProfile.getConnectedDevices().contains(device) == false) goto L16;
        BluetoothRouteInfo.m5538$$Nest$fgetmConnectedProfiles(newBtRoute).put(21, true);
        routeId = HEARING_AID_ROUTE_ID_PREFIX + this.mHearingAidProfile.getHiSyncId(device);
        type = 23;
    L16:
        if (this.mLeAudioProfile != null) goto L18;
    L20:
        BluetoothRouteInfo.m5542$$Nest$fputmRoute(newBtRoute, new MediaRoute2Info.Builder(routeId, deviceName).addFeature("android.media.route.feature.LIVE_AUDIO").addFeature("android.media.route.feature.LOCAL_PLAYBACK").setConnectionState(0).setDescription(this.mContext.getResources().getText(R.string.car_mode_disable_notification_message).toString()).setType(type).setVolumeHandling(1).setVolumeMax(this.mAudioManager.getStreamMaxVolume(3)).setAddress(device.getAddress()).build());
        return newBtRoute;
    L18:
        if (this.mLeAudioProfile.getConnectedDevices().contains(device) == false) goto L20;
        BluetoothRouteInfo.m5538$$Nest$fgetmConnectedProfiles(newBtRoute).put(22, true);
        routeId = LE_AUDIO_ROUTE_ID_PREFIX + this.mLeAudioProfile.getGroupId(device);
        type = 26;
        goto L20
    }

    private void setRouteConnectionState(BluetoothRouteInfo btRoute, int state) {
        if (btRoute != null) goto L6;
        Slog.w(TAG, "setRouteConnectionState: route shouldn't be null");
        return;
    L6:
        if (BluetoothRouteInfo.m5539$$Nest$fgetmRoute(btRoute).getConnectionState() != state) goto L8;
        return;
    L8:
        MediaRoute2Info.Builder builder = new MediaRoute2Info.Builder(BluetoothRouteInfo.m5539$$Nest$fgetmRoute(btRoute)).setConnectionState(state);
        builder.setType(btRoute.getRouteType());
        if (state != 2) goto L11;
        builder.setVolume(this.mVolumeMap.get(btRoute.getRouteType(), 0));
    L11:
        BluetoothRouteInfo.m5542$$Nest$fputmRoute(btRoute, builder.build());
    }

    private void addActiveRoute(BluetoothRouteInfo btRoute) {
        if (btRoute != null) goto L7;
        Slog.w(TAG, "addActiveRoute: btRoute is null");
        return;
    L7:
        if (DEBUG == false) goto L10;
        Log.d(TAG, "Adding active route: " + BluetoothRouteInfo.m5539$$Nest$fgetmRoute(btRoute));
    L10:
        if (this.mActiveRoutes.contains(btRoute) == false) goto L13;
        Slog.w(TAG, "addActiveRoute: btRoute is already added.");
        return;
    L13:
        setRouteConnectionState(btRoute, 2);
        this.mActiveRoutes.add(btRoute);
    }

    private void removeActiveRoute(BluetoothRouteInfo btRoute) {
        if (DEBUG == false) goto L6;
        Log.d(TAG, "Removing active route: " + BluetoothRouteInfo.m5539$$Nest$fgetmRoute(btRoute));
    L6:
        if (this.mActiveRoutes.remove(btRoute) == false) goto L9;
        setRouteConnectionState(btRoute, 0);
        return;
    }

    private void clearActiveRoutesWithType(int type) {
        if (DEBUG == false) goto L5;
        Log.d(TAG, "Clearing active routes with type. type=" + type);
    L5:
        Iterator<BluetoothRouteInfo> iter = this.mActiveRoutes.iterator();
    L7:
        if (iter.hasNext() == false) goto L12;
        BluetoothRouteInfo btRoute = iter.next();
        if (BluetoothRouteInfo.m5539$$Nest$fgetmRoute(btRoute).getType() != type) goto L7;
        iter.remove();
        setRouteConnectionState(btRoute, 0);
        goto L7
    }

    private void addActiveDevices(BluetoothDevice device) {
        BluetoothRouteInfo activeBtRoute = this.mBluetoothRoutes.get(device.getAddress());
        if (activeBtRoute != null) goto L5;
        activeBtRoute = createBluetoothRoute(device);
        this.mBluetoothRoutes.put(device.getAddress(), activeBtRoute);
    L5:
        addActiveRoute(activeBtRoute);
        Iterator<BluetoothRouteInfo> r1 = this.mBluetoothRoutes.values().iterator();
    L7:
        if (r1.hasNext() == false) goto L14;
        BluetoothRouteInfo btRoute = r1.next();
        if (TextUtils.equals(BluetoothRouteInfo.m5539$$Nest$fgetmRoute(btRoute).getId(), BluetoothRouteInfo.m5539$$Nest$fgetmRoute(activeBtRoute).getId()) == false) goto L7;
        if (TextUtils.equals(BluetoothRouteInfo.m5537$$Nest$fgetmBtDevice(btRoute).getAddress(), BluetoothRouteInfo.m5537$$Nest$fgetmBtDevice(activeBtRoute).getAddress()) == true) goto L7;
        addActiveRoute(btRoute);
        goto L7
    }
}
