package com.android.server.audio;

import android.bluetooth.BluetoothA2dp;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothClass;
import android.bluetooth.BluetoothCodecConfig;
import android.bluetooth.BluetoothCodecStatus;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothHeadset;
import android.bluetooth.BluetoothHearingAid;
import android.bluetooth.BluetoothLeAudio;
import android.bluetooth.BluetoothLeAudioCodecConfig;
import android.bluetooth.BluetoothLeAudioCodecStatus;
import android.bluetooth.BluetoothProfile;
import android.content.Context;
import android.content.Intent;
import android.hardware.audio.common.V2_0.AudioDevice;
import android.hardware.audio.common.V2_0.AudioFormat;
import android.media.AudioDeviceAttributes;
import android.media.AudioSystem;
import android.media.BluetoothProfileConnectionInfo;
import android.os.Binder;
import android.os.Bundle;
import android.os.SystemProperties;
import android.os.UserHandle;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.android.server.utils.EventLogger;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class BtHelper {
    private static final int BT_HEARING_AID_GAIN_MIN = -128;
    private static final int BT_LE_AUDIO_MAX_VOL = 255;
    private static final String DEVICE_TYPE_CARKIT = "Carkit";
    private static final String DEVICE_TYPE_HEADSET = "Headset";
    private static final String DEVICE_TYPE_HEARING_AID = "HearingAid";
    private static final String DEVICE_TYPE_SPEAKER = "Speaker";
    static final int EVENT_DEVICE_CONFIG_CHANGE = 0;
    private static final int GROUP_ID_END = 15;
    private static final int GROUP_ID_START = 0;
    private static final int SCO_MODE_MAX = 2;
    static final int SCO_MODE_UNDEFINED = -1;
    static final int SCO_MODE_VIRTUAL_CALL = 0;
    private static final int SCO_MODE_VR = 2;
    private static final int SCO_STATE_ACTIVATE_REQ = 1;
    private static final int SCO_STATE_ACTIVE_EXTERNAL = 2;
    private static final int SCO_STATE_ACTIVE_INTERNAL = 3;
    private static final int SCO_STATE_DEACTIVATE_REQ = 4;
    private static final int SCO_STATE_DEACTIVATING = 5;
    private static final int SCO_STATE_INACTIVE = 0;
    private static final String TAG = "AS.BtHelper";
    private static BluetoothA2dp mA2dp;
    private static BluetoothDevice mBluetoothA2dpActiveDevice;
    private BluetoothCodecConfig mA2dpCodecConfig;
    private boolean mAvrcpAbsVolSupported;
    private BluetoothHeadset mBluetoothHeadset;
    private BluetoothDevice mBluetoothHeadsetDevice;
    private BluetoothDevice mBluetoothHeadsetDummyDevice;
    private BluetoothProfile.ServiceListener mBluetoothProfileServiceListener;
    private final Context mContext;
    private final AudioDeviceBroker mDeviceBroker;
    private BluetoothHearingAid mHearingAid;
    private BluetoothLeAudio mLeAudio;
    private int mLeAudioBroadcastCodec;
    MyLeAudioCallback mLeAudioCallback;
    private BluetoothLeAudioCodecConfig mLeAudioCodecConfig;
    private final Map<BluetoothDevice, AudioDeviceAttributes> mResolvedScoAudioDevices;
    private int mScoAudioMode;
    private int mScoAudioState;
    private HashMap<BluetoothDevice, Integer> mScoClientDevices;
    private int mScoConnectionState;

    class MyLeAudioCallback implements BluetoothLeAudio.Callback {
        final /* synthetic */ BtHelper this$0;

        MyLeAudioCallback(BtHelper this$0) {
            this.this$0 = this$0;
        }

        public void onCodecConfigChanged(int groupId, BluetoothLeAudioCodecStatus status) {
        }

        public void onGroupNodeAdded(BluetoothDevice device, int groupId) {
            BtHelper.m2134$$Nest$fgetmDeviceBroker(this.this$0).postUpdateLeAudioGroupAddresses(groupId);
        }

        public void onGroupNodeRemoved(BluetoothDevice device, int groupId) {
            BtHelper.m2134$$Nest$fgetmDeviceBroker(this.this$0).postUpdateLeAudioGroupAddresses(groupId);
        }

        public void onGroupStatusChanged(int groupId, int groupStatus) {
            BtHelper.m2134$$Nest$fgetmDeviceBroker(this.this$0).postUpdateLeAudioGroupAddresses(groupId);
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmDeviceBroker, reason: not valid java name */
    static /* bridge */ /* synthetic */ AudioDeviceBroker m2134$$Nest$fgetmDeviceBroker(BtHelper r0) {
        return r0.mDeviceBroker;
    }

    BtHelper(AudioDeviceBroker broker, Context context) {
        this.mResolvedScoAudioDevices = new HashMap();
        this.mHearingAid = null;
        this.mLeAudio = null;
        this.mLeAudioBroadcastCodec = 0;
        this.mAvrcpAbsVolSupported = false;
        this.mScoClientDevices = new HashMap();
        this.mLeAudioCallback = null;
        this.mBluetoothProfileServiceListener = new AnonymousClass1(this);
        this.mDeviceBroker = broker;
        this.mContext = context;
    }

    static {
        mA2dp = null;
    }

    public static String scoAudioModeToString(int scoAudioMode) {
        switch(scoAudioMode) {
            case -1: goto L9;
            case 0: goto L7;
            case 1: goto L4;
            case 2: goto L5;
            default: goto L4;
        };
    L5:
        return "SCO_MODE_VR";
    L7:
        return "SCO_MODE_VIRTUAL_CALL";
    L9:
        return "SCO_MODE_UNDEFINED";
    L4:
        return "SCO_MODE_(" + scoAudioMode + ")";
    }

    public static String scoAudioStateToString(int scoAudioState) {
        switch(scoAudioState) {
            case 0: goto L13;
            case 1: goto L11;
            case 2: goto L9;
            case 3: goto L7;
            case 4: goto L4;
            case 5: goto L5;
            default: goto L4;
        };
    L5:
        return "SCO_STATE_DEACTIVATING";
    L7:
        return "SCO_STATE_ACTIVE_INTERNAL";
    L9:
        return "SCO_STATE_ACTIVE_EXTERNAL";
    L11:
        return "SCO_STATE_ACTIVATE_REQ";
    L13:
        return "SCO_STATE_INACTIVE";
    L4:
        return "SCO_STATE_(" + scoAudioState + ")";
    }

    static String deviceEventToString(int event) {
        switch(event) {
            case 0: goto L5;
            default: goto L4;
        };
    L5:
        return "DEVICE_CONFIG_CHANGE";
    L4:
        return new String("invalid event:" + event);
    }

    static String getName(BluetoothDevice device) {
        String deviceName = device.getName();
        if (deviceName != null) goto L6;
        return "";
    L6:
        return deviceName;
    }

    static void SetA2dpActiveDevice(BluetoothDevice device) {
        Log.w(TAG, "SetA2dpActiveDevice for TWS+ pair as " + device);
        mBluetoothA2dpActiveDevice = device;
    }

    static boolean isTwsPlusSwitch(BluetoothDevice device, String address) {
        BluetoothAdapter adapter = BluetoothAdapter.getDefaultAdapter();
        BluetoothDevice connDevice = adapter.getRemoteDevice(address);
        if (device == null) goto L7;
        if (connDevice == null) goto L7;
        return false;
    L7:
        return false;
    }

    synchronized void onSystemReady() {
        monitor-enter(this);
        this.mScoConnectionState = -1;     // Catch: Throwable -> L8
        Log.i(TAG, "In onSystemReady(), calling resetBluetoothSco()");     // Catch: Throwable -> L8
        resetBluetoothSco();     // Catch: Throwable -> L8
        getBluetoothHeadset();     // Catch: Throwable -> L8
        Intent newIntent = new Intent("android.media.SCO_AUDIO_STATE_CHANGED");     // Catch: Throwable -> L8
        newIntent.putExtra("android.media.extra.SCO_AUDIO_STATE", 0);     // Catch: Throwable -> L8
        sendStickyBroadcastToAll(newIntent);     // Catch: Throwable -> L8
        BluetoothAdapter adapter = BluetoothAdapter.getDefaultAdapter();     // Catch: Throwable -> L8
        if (adapter == null) goto L10;
        adapter.getProfileProxy(this.mDeviceBroker.getContext(), this.mBluetoothProfileServiceListener, 2);     // Catch: Throwable -> L8
        adapter.getProfileProxy(this.mDeviceBroker.getContext(), this.mBluetoothProfileServiceListener, 11);     // Catch: Throwable -> L8
        adapter.getProfileProxy(this.mDeviceBroker.getContext(), this.mBluetoothProfileServiceListener, 21);     // Catch: Throwable -> L8
        adapter.getProfileProxy(this.mDeviceBroker.getContext(), this.mBluetoothProfileServiceListener, 22);     // Catch: Throwable -> L8
        adapter.getProfileProxy(this.mDeviceBroker.getContext(), this.mBluetoothProfileServiceListener, 26);     // Catch: Throwable -> L8
    L10:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    void setAvrcpAbsoluteVolumeSupported(boolean supported) {
        this.mAvrcpAbsVolSupported = supported;
        Log.i(TAG, "setAvrcpAbsoluteVolumeSupported supported=" + supported);
    }

    synchronized void setAvrcpAbsoluteVolumeIndex(int index) {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (mA2dp != null) goto L11;
        AudioService.sVolumeLogger.enqueue(new EventLogger.StringEvent("setAvrcpAbsoluteVolumeIndex: bailing due to null mA2dp").printLog(TAG));     // Catch: Throwable -> L8
        monitor-exit(this);
        return;
    L11:
        if (this.mAvrcpAbsVolSupported == true) goto L15;
        AudioService.sVolumeLogger.enqueue(new EventLogger.StringEvent("setAvrcpAbsoluteVolumeIndex: abs vol not supported ").printLog(TAG));     // Catch: Throwable -> L8
        monitor-exit(this);
        return;
    L15:
        Log.i(TAG, "setAvrcpAbsoluteVolumeIndex index=" + index);     // Catch: Throwable -> L8
        AudioService.sVolumeLogger.enqueue(new AudioServiceEvents.VolumeEvent(4, index));     // Catch: Throwable -> L8
        mA2dp.setAvrcpAbsoluteVolume(index);     // Catch: Throwable -> L8 Exception -> L18
    L20:
        monitor-exit(this);
        return;
    L18:
        e = move-exception;
        Log.e(TAG, "Exception while changing abs volume", e);     // Catch: Throwable -> L8
        goto L20
    }

    private synchronized Pair<Integer, Boolean> getCodec(BluetoothDevice device, int profile) {
        monitor-enter(this);
        boolean changed = true;
        switch(profile) {
            case 2: goto L50;
            case 22: goto L18;
            case 26: goto L11;
            default: goto L5;
        };
    L5:
        Pair<Integer, Boolean> r0 = new Pair(0, false);     // Catch: Throwable -> L8
        monitor-exit(this);
        return r0;
    L11:
        if (this.mLeAudioBroadcastCodec != 721420288) goto L14;
        changed = false;
    L14:
        this.mLeAudioBroadcastCodec = 721420288;     // Catch: Throwable -> L8
        Pair<Integer, Boolean> r1 = new Pair(Integer.valueOf(this.mLeAudioBroadcastCodec), Boolean.valueOf(changed));     // Catch: Throwable -> L8
        monitor-exit(this);
        return r1;
    L18:
        if (this.mLeAudioCodecConfig == null) goto L20;
        boolean changed2 = true;
    L22:
        if (this.mLeAudio != null) goto L26;
        this.mLeAudioCodecConfig = null;     // Catch: Throwable -> L8
        Pair<Integer, Boolean> r2 = new Pair(0, Boolean.valueOf(changed2));     // Catch: Throwable -> L8
        monitor-exit(this);
        return r2;
    L26:
        BluetoothLeAudioCodecStatus btLeCodecStatus = null;
        int groupId = this.mLeAudio.getGroupId(device);     // Catch: Throwable -> L8
        btLeCodecStatus = this.mLeAudio.getCodecStatus(groupId);     // Catch: Throwable -> L8 Exception -> L30
    L32:
        if (btLeCodecStatus != null) goto L37;
        Log.e(TAG, "getCodec, null LE codec status for device: " + device);     // Catch: Throwable -> L8
        this.mLeAudioCodecConfig = null;     // Catch: Throwable -> L8
        Pair<Integer, Boolean> r3 = new Pair(0, Boolean.valueOf(changed2));     // Catch: Throwable -> L8
        monitor-exit(this);
        return r3;
    L37:
        BluetoothLeAudioCodecConfig btLeCodecConfig = btLeCodecStatus.getOutputCodecConfig();     // Catch: Throwable -> L8
        if (btLeCodecConfig != null) goto L43;
        this.mLeAudioCodecConfig = null;     // Catch: Throwable -> L8
        Pair<Integer, Boolean> r4 = new Pair(0, Boolean.valueOf(changed2));     // Catch: Throwable -> L8
        monitor-exit(this);
        return r4;
    L43:
        if (btLeCodecConfig.equals(this.mLeAudioCodecConfig) == false) goto L46;
        changed = false;
    L46:
        this.mLeAudioCodecConfig = btLeCodecConfig;     // Catch: Throwable -> L8
        Pair<Integer, Boolean> r5 = new Pair(Integer.valueOf(AudioSystem.bluetoothLeCodecToAudioFormat(btLeCodecConfig.getCodecType())), Boolean.valueOf(changed));     // Catch: Throwable -> L8
        monitor-exit(this);
        return r5;
    L30:
        e = move-exception;
        Log.e(TAG, "Exception while getting status of " + device, e);     // Catch: Throwable -> L8
        goto L32
    L20:
        changed2 = false;
        goto L22
    L50:
        if (this.mA2dpCodecConfig == null) goto L52;
        boolean changed3 = true;
    L54:
        if (mA2dp != null) goto L58;
        this.mA2dpCodecConfig = null;     // Catch: Throwable -> L8
        Pair<Integer, Boolean> r6 = new Pair(0, Boolean.valueOf(changed3));     // Catch: Throwable -> L8
        monitor-exit(this);
        return r6;
    L58:
        BluetoothCodecStatus btCodecStatus = null;
        btCodecStatus = mA2dp.getCodecStatus(device);     // Catch: Throwable -> L8 Exception -> L61
    L63:
        if (btCodecStatus != null) goto L67;
        Log.e(TAG, "getCodec, null A2DP codec status for device: " + device);     // Catch: Throwable -> L8
        this.mA2dpCodecConfig = null;     // Catch: Throwable -> L8
        Pair<Integer, Boolean> r7 = new Pair(0, Boolean.valueOf(changed3));     // Catch: Throwable -> L8
        monitor-exit(this);
        return r7;
    L67:
        BluetoothCodecConfig btCodecConfig = btCodecStatus.getCodecConfig();     // Catch: Throwable -> L8
        if (btCodecConfig != null) goto L73;
        this.mA2dpCodecConfig = null;     // Catch: Throwable -> L8
        Pair<Integer, Boolean> r8 = new Pair(0, Boolean.valueOf(changed3));     // Catch: Throwable -> L8
        monitor-exit(this);
        return r8;
    L73:
        if (btCodecConfig.equals(this.mA2dpCodecConfig) == false) goto L76;
        changed = false;
    L76:
        this.mA2dpCodecConfig = btCodecConfig;     // Catch: Throwable -> L8
        Pair<Integer, Boolean> r9 = new Pair(Integer.valueOf(AudioSystem.bluetoothA2dpCodecToAudioFormat(btCodecConfig.getCodecType())), Boolean.valueOf(changed));     // Catch: Throwable -> L8
        monitor-exit(this);
        return r9;
    L61:
        e = move-exception;
        Log.e(TAG, "Exception while getting status of " + device, e);     // Catch: Throwable -> L8
        goto L63
    L52:
        changed3 = false;
    L8:
        th = move-exception;
        throw th;
    }

    private void updateTwsPlusScoState(BluetoothDevice device, Integer state) {
        if (this.mScoClientDevices.containsKey(device) == false) goto L8;
        Integer prevState = this.mScoClientDevices.get(device);
        Log.i(TAG, "updateTwsPlusScoState: prevState: " + prevState + "state: " + state);
        if (state == prevState) goto L11;
        this.mScoClientDevices.remove(device);
        this.mScoClientDevices.put(device, state);
        return;
    L11:
        return;
    L8:
        this.mScoClientDevices.put(device, state);
    }

    private boolean isAudioPathUp() {
        boolean ret = false;
        this.mScoClientDevices.entrySet().iterator();
        Iterator<Integer> r2 = this.mScoClientDevices.values().iterator();
    L4:
        if (r2.hasNext() == false) goto L9;
        Integer value = r2.next();
        if (value.intValue() != 12) goto L4;
        ret = true;
    L9:
        Log.d(TAG, "isAudioPathUp returns" + ret);
        return ret;
    }

    private boolean checkAndUpdatTwsPlusScoState(Intent intent, Integer state) {
        BluetoothDevice device = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
        Log.i(TAG, "device:" + device);
        if (device != null) goto L6;
        Log.e(TAG, "checkAndUpdatTwsPlusScoState: device is null");
        return true;
    L6:
        return true;
    }

    private boolean isGroupDevice(BluetoothDevice device) {
        boolean ret = false;
        Log.i(TAG, "Bluetooth device type: 0");
        if (0 >= 0) goto L5;
    L7:
        Log.i(TAG, "isGroupDevice return " + ret);
        return ret;
    L5:
        if (0 > 15) goto L7;
        ret = true;
        goto L7
    }

    private void updateGroupScoState(BluetoothDevice device, Integer state) {
        if (this.mScoClientDevices.containsKey(device) == false) goto L8;
        Integer prevState = this.mScoClientDevices.get(device);
        Log.i(TAG, "updateGroupScoState: prevState: " + prevState + "state: " + state);
        if (state == prevState) goto L11;
        this.mScoClientDevices.remove(device);
        this.mScoClientDevices.put(device, state);
        return;
    L11:
        return;
    L8:
        this.mScoClientDevices.put(device, state);
    }

    private boolean checkAndUpdateGroupScoState(Intent intent, Integer state) {
        boolean ret = true;
        BluetoothDevice device = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
        Log.i(TAG, "device:" + device);
        if (device != null) goto L7;
        Log.e(TAG, "checkAndUpdateGroupScoState: device is null");
        return true;
    L7:
        if (isGroupDevice(device) == true) goto L9;
    L17:
        Log.i(TAG, "checkAndUpdateGroupScoState returns " + ret);
        return ret;
    L9:
        if (state.intValue() == 12) goto L11;
        updateGroupScoState(device, state);
        if (isAudioPathUp() == false) goto L17;
        Log.i(TAG, "not good to tear down audio-path");
        ret = false;
        goto L17
    L11:
        if (isAudioPathUp() == false) goto L13;
        Log.i(TAG, "No need to bringup audio-path");
        ret = false;
    L13:
        updateGroupScoState(device, state);
        goto L17
    }

    synchronized Pair<Integer, Boolean> getCodecWithFallback(BluetoothDevice device, int profile, boolean isLeOutput, String source) {
        monitor-enter(this);
        if (profile == 2) goto L16;
        if (isLeOutput == true) goto L7;
    L10:
        Pair<Integer, Boolean> r0 = new Pair(0, false);     // Catch: Throwable -> L13
        monitor-exit(this);
        return r0;
    L7:
        if (profile == 22) goto L16;
        if (profile != 26) goto L10;
    L16:
        Pair<Integer, Boolean> codecAndChanged = getCodec(device, profile);     // Catch: Throwable -> L13
        if (((Integer) codecAndChanged.first).intValue() != 0) goto L29;
        EventLogger r2 = AudioService.sDeviceLogger;     // Catch: Throwable -> L13
        StringBuilder r4 = new StringBuilder();     // Catch: Throwable -> L13
        r4.append("getCodec DEFAULT from ");     // Catch: Throwable -> L13
        r4.append(source);     // Catch: Throwable -> L13
        r4.append(" fallback to ");     // Catch: Throwable -> L13
        if (profile != 2) goto L21;
        String r5 = "SBC";
    L22:
        r4.append(r5);     // Catch: Throwable -> L13
        r2.enqueue(new EventLogger.StringEvent(r4.toString()));     // Catch: Throwable -> L13
        if (profile != 2) goto L25;
        int r1 = AudioFormat.SBC;
    L26:
        Pair<Integer, Boolean> r3 = new Pair(Integer.valueOf(r1), true);     // Catch: Throwable -> L13
        monitor-exit(this);
        return r3;
    L25:
        r1 = 721420288;
        goto L26
    L21:
        r5 = "LC3";
        goto L22
    L29:
        monitor-exit(this);
        return codecAndChanged;
    L13:
        th = move-exception;
        throw th;
    }

    synchronized void onReceiveBtEvent(Intent intent) {
        monitor-enter(this);
        String action = intent.getAction();     // Catch: Throwable -> L12
        if (action.equals("android.bluetooth.headset.profile.action.ACTIVE_DEVICE_CHANGED") == false) goto L18;
        BluetoothDevice btDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE", BluetoothDevice.class);     // Catch: Throwable -> L12
        if (btDevice == null) goto L15;
        if (isProfilePoxyConnected(1) == true) goto L15;
        AudioService.sDeviceLogger.enqueue(new EventLogger.StringEvent("onReceiveBtEvent ACTION_ACTIVE_DEVICE_CHANGED received with null profile proxy for device: " + btDevice).printLog(TAG));     // Catch: Throwable -> L12
        monitor-exit(this);
        return;
    L15:
        onSetBtScoActiveDevice(btDevice, false);     // Catch: Throwable -> L12
    L24:
        monitor-exit(this);
        return;
    L18:
        if (action.equals("android.bluetooth.headset.profile.action.AUDIO_STATE_CHANGED") == false) goto L24;
        int btState = intent.getIntExtra("android.bluetooth.profile.extra.STATE", -1);     // Catch: Throwable -> L12
        Log.i(TAG, "receiveBtEvent ACTION_AUDIO_STATE_CHANGED: " + btState);     // Catch: Throwable -> L12
        if (checkAndUpdatTwsPlusScoState(intent, Integer.valueOf(btState)) == false) goto L24;
        if (checkAndUpdateGroupScoState(intent, Integer.valueOf(btState)) == false) goto L24;
        onScoAudioStateChanged(btState);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    }

    boolean isBluetoothAudioNotConnectedToEarbud() {
        Log.d(TAG, "isBluetoothAudioConnectedToEarbud returns: true");
        return true;
    }

    private synchronized void onScoAudioStateChanged(int state) {
        monitor-enter(this);
        boolean broadcast = false;
        int scoAudioState = -1;
        Log.i(TAG, "onScoAudioStateChanged  state: " + state + ", mScoAudioState: " + this.mScoAudioState);     // Catch: Throwable -> L12
        switch(state) {
            case 10: goto L26;
            case 11: goto L21;
            case 12: goto L7;
            default: goto L41;
        };     // Catch: Throwable -> L12
    L7:
        scoAudioState = 1;
        if (this.mScoAudioState == 3) goto L15;
        if (this.mScoAudioState == 4) goto L15;
        this.mScoAudioState = 2;     // Catch: Throwable -> L12
    L18:
        if (this.mDeviceBroker.isScoManagedByAudio() == true) goto L41;
        this.mDeviceBroker.setBluetoothScoOn(true, "BtHelper.onScoAudioStateChanged, state: " + state);     // Catch: Throwable -> L12
    L15:
        if (this.mDeviceBroker.isBluetoothScoRequested() == false) goto L18;
        broadcast = true;
    L41:
        if (broadcast == false) goto L43;
        Log.i(TAG, "onScoAudioStateChanged  broadcasting state: " + scoAudioState);     // Catch: Throwable -> L12
        broadcastScoConnectionState(scoAudioState);     // Catch: Throwable -> L12
        Intent newIntent = new Intent("android.media.SCO_AUDIO_STATE_CHANGED");     // Catch: Throwable -> L12
        newIntent.putExtra("android.media.extra.SCO_AUDIO_STATE", scoAudioState);     // Catch: Throwable -> L12
        sendStickyBroadcastToAll(newIntent);     // Catch: Throwable -> L12
    L43:
        monitor-exit(this);
        return;
    L21:
        if (this.mScoAudioState == 3) goto L41;
        if (this.mScoAudioState == 4) goto L41;
        this.mScoAudioState = 2;     // Catch: Throwable -> L12
        goto L41
    L26:
        if (this.mDeviceBroker.isScoManagedByAudio() == true) goto L28;
        this.mDeviceBroker.setBluetoothScoOn(false, "BtHelper.onScoAudioStateChanged, state: " + state);     // Catch: Throwable -> L12
    L28:
        scoAudioState = 0;
        if (this.mScoAudioState != 1) goto L38;
        if (this.mBluetoothHeadset == null) goto L38;
        if (this.mBluetoothHeadsetDevice == null) goto L38;
        if (connectBluetoothScoAudioHelper(this.mBluetoothHeadset, this.mBluetoothHeadsetDevice, this.mScoAudioMode) == false) goto L38;
        this.mScoAudioState = 3;     // Catch: Throwable -> L12
        scoAudioState = 2;
        broadcast = true;
    L38:
        if (this.mScoAudioState == 2) goto L40;
        broadcast = true;
    L40:
        this.mScoAudioState = 0;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    }

    synchronized boolean isBluetoothScoOn() {
        monitor-enter(this);
        boolean r1 = false;
        if (this.mBluetoothHeadset != null) goto L6;
    L20:
        monitor-exit(this);
        return false;
    L6:
        if (this.mBluetoothHeadsetDevice == null) goto L20;
    L10:
        if (this.mBluetoothHeadset.getAudioState(this.mBluetoothHeadsetDevice) != 12) goto L12;
        r1 = true;
    L12:
        monitor-exit(this);
        return r1;
    L16:
        e = move-exception;
        Log.e(TAG, "Exception while getting audio state of " + this.mBluetoothHeadsetDevice, e);     // Catch: Throwable -> L14
        return false;
    L14:
        th = move-exception;
        throw th;
    }

    boolean isBluetoothScoRequestedInternally() {
        if (this.mScoAudioState != 3) goto L5;
        return true;
    L5:
        if (this.mScoAudioState == 1) goto L10;
        return false;
    L10:
        return true;
    }

    boolean isAudioConnected() {
        if (this.mBluetoothHeadset != null) goto L5;
        return false;
    L5:
        if (this.mBluetoothHeadsetDevice != null) goto L8;
        return false;
    L8:
        return this.mBluetoothHeadset.isAudioConnected(this.mBluetoothHeadsetDevice);
    }

    synchronized boolean startBluetoothSco(int scoAudioMode, String eventSource) {
        monitor-enter(this);
        AudioService.sDeviceLogger.enqueue(new EventLogger.StringEvent(eventSource));     // Catch: Throwable -> L6
        boolean r0 = requestScoState(12, scoAudioMode);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    synchronized boolean stopBluetoothSco(String eventSource) {
        monitor-enter(this);
        AudioService.sDeviceLogger.enqueue(new EventLogger.StringEvent(eventSource));     // Catch: Throwable -> L6
        boolean r0 = requestScoState(10, 0);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    synchronized void setLeAudioVolume(int index, int maxIndex, int streamType) {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.mLeAudio != null) goto L11;
        Log.i(TAG, "setLeAudioVolume: null mLeAudio");     // Catch: Throwable -> L8
        monitor-exit(this);
        return;
    L11:
        int volume = (int) Math.round((((double) index) * 255.0d) / ((double) maxIndex));     // Catch: Throwable -> L8
        Log.i(TAG, "setLeAudioVolume: calling mLeAudio.setVolume idx=" + index + " volume=" + volume);     // Catch: Throwable -> L8
        AudioService.sVolumeLogger.enqueue(new AudioServiceEvents.VolumeEvent(10, streamType, index, maxIndex, null));     // Catch: Throwable -> L8
        this.mLeAudio.setVolume(volume);     // Catch: Throwable -> L8 Exception -> L14
    L17:
        monitor-exit(this);
        return;
    L14:
        e = move-exception;
        Log.e(TAG, "Exception while setting LE volume", e);     // Catch: Throwable -> L8
        goto L17
    }

    synchronized void setHearingAidVolume(int index, int streamType, boolean isHeadAidConnected) {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.mHearingAid != null) goto L10;
        Log.i(TAG, "setHearingAidVolume: null mHearingAid");     // Catch: Throwable -> L8
        monitor-exit(this);
        return;
    L10:
        int gainDB = (int) AudioSystem.getStreamVolumeDB(streamType, index / 10, 134217728);     // Catch: Throwable -> L8
        if (gainDB >= (-128)) goto L13;
        gainDB = -128;
    L13:
        Log.i(TAG, "setHearingAidVolume: calling mHearingAid.setVolume idx=" + index + " gain=" + gainDB);     // Catch: Throwable -> L8
        if (isHeadAidConnected == false) goto L24;
        AudioService.sVolumeLogger.enqueue(new AudioServiceEvents.VolumeEvent(3, index, gainDB));     // Catch: Throwable -> L8
    L24:
        this.mHearingAid.setVolume(gainDB);     // Catch: Throwable -> L8 Exception -> L18
    L20:
        monitor-exit(this);
        return;
    L18:
        e = move-exception;
        Log.i(TAG, "Exception while setting hearing aid volume", e);     // Catch: Throwable -> L8
        goto L20
    }

    void onBroadcastScoConnectionState(int state) {
        if (state != this.mScoConnectionState) goto L5;
        return;
    L5:
        Intent newIntent = new Intent("android.media.ACTION_SCO_AUDIO_STATE_UPDATED");
        newIntent.putExtra("android.media.extra.SCO_AUDIO_STATE", state);
        newIntent.putExtra("android.media.extra.SCO_AUDIO_PREVIOUS_STATE", this.mScoConnectionState);
        sendStickyBroadcastToAll(newIntent);
        this.mScoConnectionState = state;
    }

    void resetBluetoothSco() {
        Log.i(TAG, "In resetBluetoothSco(), calling clearAllScoClients()");
        this.mScoAudioState = 0;
        broadcastScoConnectionState(0);
        this.mDeviceBroker.clearA2dpSuspended(false);
        this.mDeviceBroker.clearLeAudioSuspended(false);
        this.mScoClientDevices.clear();
        this.mDeviceBroker.setBluetoothScoOn(false, "resetBluetoothSco");
    }

    synchronized void onBtProfileDisconnected(int profile) {
        monitor-enter(this);
        AudioService.sDeviceLogger.enqueue(new EventLogger.StringEvent("BT profile " + BluetoothProfile.getProfileName(profile) + " disconnected").printLog(TAG));     // Catch: Throwable -> L6
        switch(profile) {
            case 1: goto L21;
            case 2: goto L20;
            case 11: goto L22;
            case 21: goto L18;
            case 22: goto L10;
            case 26: goto L8;
            default: goto L5;
        };     // Catch: Throwable -> L6
    L5:
        Log.e(TAG, "onBtProfileDisconnected: Not a valid profile to disconnect " + BluetoothProfile.getProfileName(profile));     // Catch: Throwable -> L6
        goto L22
    L8:
        this.mLeAudioBroadcastCodec = 0;     // Catch: Throwable -> L6
        goto L22
    L18:
        this.mHearingAid = null;     // Catch: Throwable -> L6
        goto L22
    L20:
        mA2dp = null;     // Catch: Throwable -> L6
        this.mA2dpCodecConfig = null;     // Catch: Throwable -> L6
        goto L22
    L21:
        this.mBluetoothHeadset = null;     // Catch: Throwable -> L6
        goto L22
    L10:
        if (this.mLeAudio != null) goto L12;
    L17:
        this.mLeAudio = null;     // Catch: Throwable -> L6
        this.mLeAudioCallback = null;     // Catch: Throwable -> L6
        this.mLeAudioCodecConfig = null;     // Catch: Throwable -> L6
        goto L22
    L12:
        if (this.mLeAudioCallback == null) goto L17;
        this.mLeAudio.unregisterCallback(this.mLeAudioCallback);     // Catch: Throwable -> L6 Exception -> L15
    L15:
        e = move-exception;
        Log.e(TAG, "Exception while unregistering callback for LE audio", e);     // Catch: Throwable -> L6
    L22:
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    synchronized void onBtProfileConnected(int profile, BluetoothProfile proxy) {
        monitor-enter(this);
        AudioService.sDeviceLogger.enqueue(new EventLogger.StringEvent("BT profile " + BluetoothProfile.getProfileName(profile) + " connected to proxy " + proxy).printLog(TAG));     // Catch: Throwable -> L8
        if (proxy != null) goto L10;
        Log.e(TAG, "onBtProfileConnected: null proxy for profile: " + profile);     // Catch: Throwable -> L8
        monitor-exit(this);
        return;
    L10:
        switch(profile) {
            case 1: goto L79;
            case 2: goto L41;
            case 11: goto L38;
            case 21: goto L33;
            case 22: goto L15;
            case 26: goto L38;
            default: goto L11;
        };
    L11:
        Log.e(TAG, "onBtProfileConnected: Not a valid profile to connect " + BluetoothProfile.getProfileName(profile));     // Catch: Throwable -> L8
        monitor-exit(this);
        return;
    L38:
        monitor-exit(this);
        return;
    L79:
        onHeadsetProfileConnected((BluetoothHeadset) proxy);     // Catch: Throwable -> L8
        monitor-exit(this);
        return;
    L15:
        if (((BluetoothLeAudio) proxy).equals(this.mLeAudio) == false) goto L19;
        monitor-exit(this);
        return;
    L19:
        if (this.mLeAudio != null) goto L21;
    L26:
        this.mLeAudio = (BluetoothLeAudio) proxy;     // Catch: Throwable -> L8
        this.mLeAudioCallback = new MyLeAudioCallback(this);     // Catch: Throwable -> L8
        this.mLeAudio.registerCallback(this.mContext.getMainExecutor(), this.mLeAudioCallback);     // Catch: Throwable -> L8 Exception -> L29
    L45:
        BluetoothAdapter adapter = BluetoothAdapter.getDefaultAdapter();     // Catch: Throwable -> L8
        if (adapter != null) goto L50;
        Log.e(TAG, "onBtProfileConnected: Null BluetoothAdapter when connecting profile: " + BluetoothProfile.getProfileName(profile));     // Catch: Throwable -> L8
        monitor-exit(this);
        return;
    L50:
        List<BluetoothDevice> activeDevices = adapter.getActiveDevices(profile);     // Catch: Throwable -> L8
        if (activeDevices.isEmpty() == true) goto L77;
        if (activeDevices.get(0) == null) goto L77;
        BluetoothDevice device = activeDevices.get(0);     // Catch: Throwable -> L8
        switch(profile) {
            case 2: goto L74;
            case 21: goto L73;
            case 22: goto L58;
            default: goto L57;
        };     // Catch: Throwable -> L8
    L57:
        Log.wtf(TAG, "Invalid profile! onBtProfileConnected");     // Catch: Throwable -> L8
    L75:
        monitor-exit(this);
        return;
    L58:
        int groupId = this.mLeAudio.getGroupId(device);     // Catch: Throwable -> L8
        BluetoothLeAudioCodecStatus btLeCodecStatus = null;
        btLeCodecStatus = this.mLeAudio.getCodecStatus(groupId);     // Catch: Throwable -> L8 Exception -> L62
    L64:
        if (btLeCodecStatus != null) goto L66;
        Log.i(TAG, "onBtProfileConnected null LE codec status for groupId: " + groupId + ", device: " + device);     // Catch: Throwable -> L8
        goto L75
    L66:
        List<BluetoothLeAudioCodecConfig> outputCodecConfigs = btLeCodecStatus.getOutputCodecSelectableCapabilities();     // Catch: Throwable -> L8
        if (outputCodecConfigs.isEmpty() == true) goto L69;
        BluetoothProfileConnectionInfo bpci = BluetoothProfileConnectionInfo.createLeAudioInfo(false, true);     // Catch: Throwable -> L8
        postBluetoothActiveDevice(device, bpci);     // Catch: Throwable -> L8
    L69:
        List<BluetoothLeAudioCodecConfig> inputCodecConfigs = btLeCodecStatus.getInputCodecSelectableCapabilities();     // Catch: Throwable -> L8
        if (inputCodecConfigs.isEmpty() == true) goto L75;
        BluetoothProfileConnectionInfo bpci2 = BluetoothProfileConnectionInfo.createLeAudioInfo(false, false);     // Catch: Throwable -> L8
        postBluetoothActiveDevice(device, bpci2);     // Catch: Throwable -> L8
        goto L75
    L62:
        e = move-exception;
        Log.e(TAG, "Exception while getting status of " + device, e);     // Catch: Throwable -> L8
        goto L64
    L73:
        BluetoothProfileConnectionInfo bpci3 = BluetoothProfileConnectionInfo.createHearingAidInfo(false);     // Catch: Throwable -> L8
        postBluetoothActiveDevice(device, bpci3);     // Catch: Throwable -> L8
        goto L75
    L74:
        BluetoothProfileConnectionInfo bpci4 = BluetoothProfileConnectionInfo.createA2dpInfo(false, -1);     // Catch: Throwable -> L8
        postBluetoothActiveDevice(device, bpci4);     // Catch: Throwable -> L8
    L77:
        monitor-exit(this);
        return;
    L29:
        e = move-exception;
        this.mLeAudioCallback = null;     // Catch: Throwable -> L8
        Log.e(TAG, "Exception while registering callback for LE audio", e);     // Catch: Throwable -> L8
        goto L45
    L21:
        if (this.mLeAudioCallback == null) goto L26;
        this.mLeAudio.unregisterCallback(this.mLeAudioCallback);     // Catch: Throwable -> L8 Exception -> L24
    L24:
        e = move-exception;
        Log.e(TAG, "Exception while unregistering callback for LE audio", e);     // Catch: Throwable -> L8
        goto L26
    L33:
        if (((BluetoothHearingAid) proxy).equals(this.mHearingAid) == false) goto L36;
        monitor-exit(this);
        return;
    L36:
        this.mHearingAid = (BluetoothHearingAid) proxy;     // Catch: Throwable -> L8
        goto L45
    L41:
        if (((BluetoothA2dp) proxy).equals(mA2dp) == false) goto L44;
        monitor-exit(this);
        return;
    L44:
        mA2dp = (BluetoothA2dp) proxy;     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        throw th;
    }

    private void postBluetoothActiveDevice(BluetoothDevice device, BluetoothProfileConnectionInfo bpci) {
        AudioDeviceBroker.BtDeviceChangedData data = new AudioDeviceBroker.BtDeviceChangedData(device, null, bpci, "mBluetoothProfileServiceListener");
        AudioDeviceBroker.BtDeviceInfo info = AudioDeviceBroker.createBtDeviceInfo(data, device, 2);
        this.mDeviceBroker.postBluetoothActiveDevice(info, 0);
    }

    synchronized boolean isProfilePoxyConnected(int profile) {
        monitor-enter(this);
        boolean r0 = false;
        switch(profile) {
            case 1: goto L25;
            case 2: goto L20;
            case 21: goto L15;
            case 22: goto L8;
            default: goto L5;
        };
    L5:
        monitor-exit(this);
        return true;
    L8:
        if (this.mLeAudio == null) goto L10;
        r0 = true;
    L10:
        monitor-exit(this);
        return r0;
    L15:
        if (this.mHearingAid == null) goto L17;
        r0 = true;
    L17:
        monitor-exit(this);
        return r0;
    L20:
        if (mA2dp == null) goto L22;
        r0 = true;
    L22:
        monitor-exit(this);
        return r0;
    L25:
        if (this.mBluetoothHeadset == null) goto L27;
        r0 = true;
    L27:
        monitor-exit(this);
        return r0;
    L12:
        th = move-exception;
        throw th;
    }

    private synchronized void onHeadsetProfileConnected(BluetoothHeadset headset) {
        monitor-enter(this);
        this.mDeviceBroker.handleCancelFailureToConnectToBtHeadsetService();     // Catch: Throwable -> L12
        this.mBluetoothHeadset = headset;     // Catch: Throwable -> L12
        BluetoothAdapter adapter = BluetoothAdapter.getDefaultAdapter();     // Catch: Throwable -> L12
        if (adapter == null) goto L15;
        List<BluetoothDevice> activeDevices = adapter.getActiveDevices(1);     // Catch: Throwable -> L12
        Iterator<BluetoothDevice> r4 = activeDevices.iterator();     // Catch: Throwable -> L12
    L7:
        if (r4.hasNext() == false) goto L16;
        BluetoothDevice device = r4.next();     // Catch: Throwable -> L12
        if (device == null) goto L7;
        onSetBtScoActiveDevice(device, false);     // Catch: Throwable -> L12
    L16:
        checkScoAudioState();     // Catch: Throwable -> L12
        if (this.mScoAudioState != 1) goto L20;
    L23:
        boolean status = false;
        if (this.mBluetoothHeadsetDevice != null) goto L27;
    L35:
        if (status == true) goto L37;
        this.mScoAudioState = 0;     // Catch: Throwable -> L12
        broadcastScoConnectionState(0);     // Catch: Throwable -> L12
    L37:
        monitor-exit(this);
        return;
    L27:
        switch(this.mScoAudioState) {
            case 1: goto L32;
            case 4: goto L29;
            default: goto L35;
        };     // Catch: Throwable -> L12
    L29:
        status = disconnectBluetoothScoAudioHelper(this.mBluetoothHeadset, this.mBluetoothHeadsetDevice, this.mScoAudioMode);     // Catch: Throwable -> L12
        if (status == false) goto L35;
        this.mScoAudioState = 5;     // Catch: Throwable -> L12
        goto L35
    L32:
        status = connectBluetoothScoAudioHelper(this.mBluetoothHeadset, this.mBluetoothHeadsetDevice, this.mScoAudioMode);     // Catch: Throwable -> L12
        if (status == false) goto L35;
        this.mScoAudioState = 3;     // Catch: Throwable -> L12
        goto L35
    L20:
        if (this.mScoAudioState == 4) goto L23;
        monitor-exit(this);
        return;
    L15:
        Log.e(TAG, "onHeadsetProfileConnected: Null BluetoothAdapter");     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    }

    private void broadcastScoConnectionState(int state) {
        this.mDeviceBroker.postBroadcastScoConnectionState(state);
    }

    AudioDeviceAttributes getHeadsetAudioDevice() {
        if (this.mBluetoothHeadsetDevice != null) goto L7;
        return null;
    L7:
        return getHeadsetAudioDevice(this.mBluetoothHeadsetDevice);
    }

    private AudioDeviceAttributes getHeadsetAudioDevice(BluetoothDevice btDevice) {
        AudioDeviceAttributes deviceAttr = this.mResolvedScoAudioDevices.get(btDevice);
        if (deviceAttr == null) goto L6;
        return deviceAttr;
    L6:
        return btHeadsetDeviceToAudioDevice(btDevice);
    }

    AudioDeviceAttributes getHeadsetAudioDummyDevice() {
        if (this.mBluetoothHeadsetDummyDevice != null) goto L7;
        return null;
    L7:
        return btHeadsetDeviceToAudioDevice(this.mBluetoothHeadsetDummyDevice);
    }

    private static AudioDeviceAttributes btHeadsetDeviceToAudioDevice(BluetoothDevice btDevice) {
        if (btDevice == null) goto L4;
        String address = btDevice.getAddress();
        String name = "";
        if (address.equals("00:00:00:00:00:00") == true) goto L9;
        name = getName(btDevice);
    L9:
        if (BluetoothAdapter.checkBluetoothAddress(address) == true) goto L12;
        address = "";
    L12:
        if ("00:00:00:00:00:00".equals(address) == false) goto L14;
        BluetoothClass btClass = null;
    L15:
        int nativeType = 16;
        if (btClass != null) goto L18;
    L22:
        StringBuilder r5 = new StringBuilder();
        r5.append("btHeadsetDeviceToAudioDevice btDevice: ");
        r5.append(btDevice);
        r5.append(" btClass: ");
        if (btClass != null) goto L25;
        Object r6 = "Unknown";
    L26:
        r5.append(r6);
        r5.append(" nativeType: ");
        r5.append(nativeType);
        r5.append(" address: ");
        r5.append(address);
        Log.i(TAG, r5.toString());
        return new AudioDeviceAttributes(nativeType, address, name);
    L25:
        r6 = btClass;
        goto L26
    L18:
        switch(btClass.getDeviceClass()) {
            case 1028: goto L21;
            case 1032: goto L21;
            case 1056: goto L20;
            default: goto L22;
        };
    L20:
        nativeType = 64;
        goto L22
    L21:
        nativeType = 32;
        goto L22
    L14:
        btClass = btDevice.getBluetoothClass();
        goto L15
    L4:
        return new AudioDeviceAttributes(16, "");
    }

    private boolean handleBtScoActiveDeviceChange(BluetoothDevice btDevice, boolean isActive, boolean deviceSwitch) {
        if (btDevice != null) goto L5;
        return true;
    L5:
        String address = btDevice.getAddress();
        String dummyAddress = "00:00:00:00:00:00";
        if ("00:00:00:00:00:00".equals(address) == true) goto L9;
        btDevice.getBluetoothClass();
    L9:
        boolean result = false;
        AudioDeviceAttributes audioDevice = null;
        String name = getName(btDevice);
        boolean r11 = false;
        if (isActive == false) goto L12;
        audioDevice = btHeadsetDeviceToAudioDevice(btDevice);
        result = this.mDeviceBroker.handleDeviceConnection(audioDevice, true, btDevice, false);
        boolean result2 = false;
    L20:
        if (this.mDeviceBroker.handleDeviceConnection(new AudioDeviceAttributes(-2147483640, address, name), isActive, btDevice, deviceSwitch) == false) goto L23;
        if (result == false) goto L23;
        result2 = true;
    L23:
        if (result2 == false) goto L27;
        if (isActive == false) goto L26;
        this.mResolvedScoAudioDevices.put(btDevice, audioDevice);
        goto L27
    L26:
        this.mResolvedScoAudioDevices.remove(btDevice);
    L27:
        return result2;
    L12:
        AudioDeviceAttributes ada = this.mResolvedScoAudioDevices.get(btDevice);
        if (ada == null) goto L15;
        result = this.mDeviceBroker.handleDeviceConnection(ada, false, btDevice, deviceSwitch);
        result2 = false;
        goto L20
    L15:
        int[] outDeviceTypes = {16, 32, 64};
        int r14 = outDeviceTypes.length;
        int r15 = 0;
    L16:
        if (r15 >= r14) goto L18;
        int outDeviceType = outDeviceTypes[r15];
        result = result | this.mDeviceBroker.handleDeviceConnection(new AudioDeviceAttributes(outDeviceType, address, name), false, btDevice, deviceSwitch);
        r15 = r15 + 1;
        r11 = false;
        dummyAddress = dummyAddress;
        goto L16
    L18:
        result2 = r11;
        goto L20
    }

    private String getAnonymizedAddress(BluetoothDevice btDevice) {
        if (btDevice != null) goto L5;
        return "(null)";
    L5:
        return btDevice.getAnonymizedAddress();
    }

    void onSetBtScoActiveDevice(BluetoothDevice btDevice, boolean deviceSwitch) {
        Log.i(TAG, "onSetBtScoActiveDevice: " + getAnonymizedAddress(this.mBluetoothHeadsetDevice) + " -> " + getAnonymizedAddress(btDevice) + ", deviceSwitch: " + deviceSwitch);
        BluetoothDevice previousActiveDevice = this.mBluetoothHeadsetDevice;
        if (Objects.equals(btDevice, previousActiveDevice) == false) goto L5;
        return;
    L5:
        BluetoothAdapter adapter = BluetoothAdapter.getDefaultAdapter();
        if (adapter != null) goto L9;
        Log.i(TAG, "adapter is null, returning from setBtScoActiveDevice");
        return;
    L9:
        this.mBluetoothHeadsetDummyDevice = adapter.getRemoteDevice("00:00:00:00:00:00");
        if (this.mBluetoothHeadsetDevice != null) goto L16;
        if (btDevice == null) goto L16;
        if (handleBtScoActiveDeviceChange(this.mBluetoothHeadsetDummyDevice, true, false) == true) goto L16;
        Log.e(TAG, "onSetBtScoActiveDevice() failed to add new device " + btDevice);
        btDevice = null;
    L16:
        if (this.mBluetoothHeadsetDevice == null) goto L22;
        if (btDevice != null) goto L22;
        if (handleBtScoActiveDeviceChange(this.mBluetoothHeadsetDummyDevice, false, false) == true) goto L22;
        Log.w(TAG, "onSetBtScoActiveDevice() failed to remove previous device " + previousActiveDevice);
    L22:
        if (this.mBluetoothHeadsetDevice == null) goto L25;
        if (btDevice == null) goto L25;
        this.mDeviceBroker.postUpdateCommunicationRouteClient(this.mDeviceBroker.bluetoothScoRequestOwnerAttributionSource(), "onSetBtScoActiveDevice", 500);
    L25:
        this.mBluetoothHeadsetDevice = btDevice;
        if (this.mBluetoothHeadsetDevice != null) goto L29;
        this.mBluetoothHeadsetDummyDevice = null;
        Log.i(TAG, "In setBtScoActiveDevice(), calling resetBluetoothSco()");
        resetBluetoothSco();
        return;
    }

    private synchronized boolean requestScoState(int state, int scoAudioMode) {
        monitor-enter(this);
        Log.i(TAG, "In requestScoState(), state: " + state + ", scoAudioMode: " + scoAudioMode);     // Catch: Throwable -> L8
        checkScoAudioState();     // Catch: Throwable -> L8
        if (state != 12) goto L53;
        if (this.mScoAudioState == 3) goto L11;
        broadcastScoConnectionState(2);     // Catch: Throwable -> L8
    L11:
        switch(this.mScoAudioState) {
            case 0: goto L19;
            case 1: goto L12;
            case 2: goto L18;
            case 3: goto L75;
            case 4: goto L16;
            case 5: goto L15;
            default: goto L12;
        };     // Catch: Throwable -> L8
    L12:
        Log.w(TAG, "requestScoState: failed to connect in state " + this.mScoAudioState + ", scoAudioMode=" + scoAudioMode);     // Catch: Throwable -> L8
        broadcastScoConnectionState(0);     // Catch: Throwable -> L8
        monitor-exit(this);
        return false;
    L15:
        this.mScoAudioState = 1;     // Catch: Throwable -> L8
        goto L75
    L16:
        this.mScoAudioState = 3;     // Catch: Throwable -> L8
        broadcastScoConnectionState(1);     // Catch: Throwable -> L8
        goto L75
    L18:
        broadcastScoConnectionState(1);     // Catch: Throwable -> L8
        goto L75
    L19:
        this.mScoAudioMode = scoAudioMode;     // Catch: Throwable -> L8
        if (scoAudioMode != (-1)) goto L29;
        this.mScoAudioMode = 0;     // Catch: Throwable -> L8
        if (this.mBluetoothHeadsetDevice == null) goto L29;
        this.mScoAudioMode = Settings.Global.getInt(this.mDeviceBroker.getContentResolver(), "bluetooth_sco_channel_" + this.mBluetoothHeadsetDevice.getAddress(), 0);     // Catch: Throwable -> L8
        if (this.mScoAudioMode <= 2) goto L26;
    L27:
        this.mScoAudioMode = 0;     // Catch: Throwable -> L8
        goto L29
    L26:
        if (this.mScoAudioMode < 0) goto L27;
    L29:
        if (this.mBluetoothHeadset != null) goto L37;
        if (getBluetoothHeadset() == false) goto L33;
        this.mScoAudioState = 1;     // Catch: Throwable -> L8
        goto L75
    L33:
        Log.w(TAG, "requestScoState: getBluetoothHeadset failed during connection, mScoAudioMode=" + this.mScoAudioMode);     // Catch: Throwable -> L8
        broadcastScoConnectionState(0);     // Catch: Throwable -> L8
        monitor-exit(this);
        return false;
    L37:
        if (this.mBluetoothHeadsetDevice != null) goto L47;
        boolean mVoipLeaWarEnabled = SystemProperties.getBoolean("persist.enable.bluetooth.voipleawar", false);     // Catch: Throwable -> L8
        if (mVoipLeaWarEnabled == true) goto L41;
    L43:
        Log.w(TAG, "requestScoState: no active device while connecting, mScoAudioMode=" + this.mScoAudioMode);     // Catch: Throwable -> L8
        broadcastScoConnectionState(0);     // Catch: Throwable -> L8
        monitor-exit(this);
        return false;
    L41:
        if (this.mBluetoothHeadsetDummyDevice == null) goto L43;
        Log.w(TAG, "requestScoState: dummy device is active while connecting, mScoAudioMode=" + this.mScoAudioMode);     // Catch: Throwable -> L8
    L47:
        if (connectBluetoothScoAudioHelper(this.mBluetoothHeadset, this.mBluetoothHeadsetDevice, this.mScoAudioMode) == false) goto L49;
        this.mScoAudioState = 3;     // Catch: Throwable -> L8
        goto L75
    L49:
        Log.w(TAG, "requestScoState: connect to " + getAnonymizedAddress(this.mBluetoothHeadsetDevice) + " failed, mScoAudioMode=" + this.mScoAudioMode);     // Catch: Throwable -> L8
        broadcastScoConnectionState(0);     // Catch: Throwable -> L8
        monitor-exit(this);
        return false;
    L75:
        monitor-exit(this);
        return true;
    L53:
        if (state != 10) goto L75;
        switch(this.mScoAudioState) {
            case 1: goto L74;
            case 2: goto L56;
            case 3: goto L60;
            default: goto L56;
        };     // Catch: Throwable -> L8
    L56:
        Log.w(TAG, "requestScoState: failed to disconnect in state " + this.mScoAudioState + ", scoAudioMode=" + scoAudioMode);     // Catch: Throwable -> L8
        broadcastScoConnectionState(0);     // Catch: Throwable -> L8
        monitor-exit(this);
        return false;
    L74:
        this.mScoAudioState = 0;     // Catch: Throwable -> L8
        broadcastScoConnectionState(0);     // Catch: Throwable -> L8
        goto L75
    L60:
        if (this.mBluetoothHeadset != null) goto L68;
        if (getBluetoothHeadset() == false) goto L64;
        this.mScoAudioState = 4;     // Catch: Throwable -> L8
        goto L75
    L64:
        Log.w(TAG, "requestScoState: getBluetoothHeadset failed during disconnection, mScoAudioMode=" + this.mScoAudioMode);     // Catch: Throwable -> L8
        this.mScoAudioState = 0;     // Catch: Throwable -> L8
        broadcastScoConnectionState(0);     // Catch: Throwable -> L8
        monitor-exit(this);
        return false;
    L68:
        if (this.mBluetoothHeadsetDevice != null) goto L71;
        this.mScoAudioState = 0;     // Catch: Throwable -> L8
        broadcastScoConnectionState(0);     // Catch: Throwable -> L8
        goto L75
    L71:
        if (disconnectBluetoothScoAudioHelper(this.mBluetoothHeadset, this.mBluetoothHeadsetDevice, this.mScoAudioMode) == false) goto L73;
        this.mScoAudioState = 5;     // Catch: Throwable -> L8
        goto L75
    L73:
        this.mScoAudioState = 0;     // Catch: Throwable -> L8
        broadcastScoConnectionState(0);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        throw th;
    }

    private void sendStickyBroadcastToAll(Intent intent) {
        intent.addFlags(268435456);
        long ident = Binder.clearCallingIdentity();
        this.mDeviceBroker.getContext().sendStickyBroadcastAsUser(intent, UserHandle.ALL);     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(ident);
        return;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    }

    private static boolean disconnectBluetoothScoAudioHelper(BluetoothHeadset bluetoothHeadset, BluetoothDevice device, int scoAudioMode) {
        Log.i(TAG, "In disconnectBluetoothScoAudioHelper(), scoAudioMode: " + scoAudioMode + ", bluetoothHeadset: " + bluetoothHeadset + ", BluetoothDevice: " + device);
        switch(scoAudioMode) {
            case 0: goto L8;
            case 1: goto L4;
            case 2: goto L6;
            default: goto L4;
        };
    L4:
        return false;
    L6:
        Log.i(TAG, "In disconnectBluetoothScoAudioHelper(), calling stopVoiceRecognition()");
        return bluetoothHeadset.stopVoiceRecognition(device);
    L8:
        Log.i(TAG, "In disconnectBluetoothScoAudioHelper(), calling stopScoUsingVirtualVoiceCall()");
        return bluetoothHeadset.stopScoUsingVirtualVoiceCall();
    }

    private static boolean connectBluetoothScoAudioHelper(BluetoothHeadset bluetoothHeadset, BluetoothDevice device, int scoAudioMode) {
        Log.i(TAG, "In connectBluetoothScoAudioHelper(), scoAudioMode: " + scoAudioMode + ", bluetoothHeadset: " + bluetoothHeadset + ", BluetoothDevice: " + device);
        switch(scoAudioMode) {
            case 0: goto L8;
            case 1: goto L4;
            case 2: goto L6;
            default: goto L4;
        };
    L4:
        return false;
    L6:
        Log.i(TAG, "In connectBluetoothScoAudioHelper(), calling startVoiceRecognition()");
        return bluetoothHeadset.startVoiceRecognition(device);
    L8:
        Log.i(TAG, "In connectBluetoothScoAudioHelper(), calling startScoUsingVirtualVoiceCall()");
        return bluetoothHeadset.startScoUsingVirtualVoiceCall();
    }

    private synchronized void checkScoAudioState() {
        /*  JADX ERROR: Simple mode code generation failed
            java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
            	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:100)
            	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:106)
            	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:302)
            	at java.base/java.util.Objects.checkIndex(Objects.java:365)
            	at java.base/java.util.ArrayList.get(ArrayList.java:428)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:354)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            */
        /*
            this = this;
            monitor-enter(r4)
            android.bluetooth.BluetoothHeadset r0 = r4.mBluetoothHeadset     // Catch: java.lang.Throwable -> L1d java.lang.Exception -> L1f
            if (r0 == 0) goto L21
            android.bluetooth.BluetoothDevice r0 = r4.mBluetoothHeadsetDevice     // Catch: java.lang.Throwable -> L1d java.lang.Exception -> L1f
            if (r0 == 0) goto L21
            int r0 = r4.mScoAudioState     // Catch: java.lang.Throwable -> L1d java.lang.Exception -> L1f
            if (r0 != 0) goto L21
            android.bluetooth.BluetoothHeadset r0 = r4.mBluetoothHeadset     // Catch: java.lang.Throwable -> L1d java.lang.Exception -> L1f
            android.bluetooth.BluetoothDevice r1 = r4.mBluetoothHeadsetDevice     // Catch: java.lang.Throwable -> L1d java.lang.Exception -> L1f
            int r0 = r0.getAudioState(r1)     // Catch: java.lang.Throwable -> L1d java.lang.Exception -> L1f
            r1 = 10
            if (r0 == r1) goto L21
            r0 = 2
            r4.mScoAudioState = r0     // Catch: java.lang.Throwable -> L1d java.lang.Exception -> L1f
            goto L21
        L1d:
            r0 = move-exception
            goto L55
        L1f:
            r0 = move-exception
            goto L22
        L21:
            goto L3b
        L22:
            java.lang.String r1 = "AS.BtHelper"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L1d
            r2.<init>()     // Catch: java.lang.Throwable -> L1d
            java.lang.String r3 = "Exception while getting audio state of "
            r2.append(r3)     // Catch: java.lang.Throwable -> L1d
            android.bluetooth.BluetoothDevice r3 = r4.mBluetoothHeadsetDevice     // Catch: java.lang.Throwable -> L1d
            r2.append(r3)     // Catch: java.lang.Throwable -> L1d
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L1d
            android.util.Log.e(r1, r2, r0)     // Catch: java.lang.Throwable -> L1d
        L3b:
            java.lang.String r0 = "AS.BtHelper"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L1d
            r1.<init>()     // Catch: java.lang.Throwable -> L1d
            java.lang.String r2 = "In checkScoAudioState(), mScoAudioState: "
            r1.append(r2)     // Catch: java.lang.Throwable -> L1d
            int r2 = r4.mScoAudioState     // Catch: java.lang.Throwable -> L1d
            r1.append(r2)     // Catch: java.lang.Throwable -> L1d
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L1d
            android.util.Log.i(r0, r1)     // Catch: java.lang.Throwable -> L1d
            monitor-exit(r4)
            return
        L55:
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L1d
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.server.audio.BtHelper.checkScoAudioState():void");
    }

    private boolean getBluetoothHeadset() {
        boolean result = false;
        BluetoothAdapter adapter = BluetoothAdapter.getDefaultAdapter();
        if (adapter == null) goto L5;
        result = adapter.getProfileProxy(this.mDeviceBroker.getContext(), this.mBluetoothProfileServiceListener, 1);
    L5:
        AudioDeviceBroker r2 = this.mDeviceBroker;
        if (result == false) goto L8;
        int r3 = 3000;
    L9:
        r2.handleFailureToConnectToBtHeadsetService(r3);
        return result;
    L8:
        r3 = 0;
        goto L9
    }

    synchronized int getLeAudioDeviceGroupId(BluetoothDevice device) {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (this.mLeAudio == null) goto L12;
        if (device == null) goto L12;
        int r0 = this.mLeAudio.getGroupId(device);     // Catch: Throwable -> L10
        monitor-exit(this);
        return r0;
    L12:
        monitor-exit(this);
        return -1;
    }

    synchronized List<Pair<String, String>> getLeAudioGroupAddresses(int groupId) {
        monitor-enter(this);
        List<Pair<String, String>> addresses = new ArrayList();     // Catch: Throwable -> L17
        BluetoothAdapter adapter = BluetoothAdapter.getDefaultAdapter();     // Catch: Throwable -> L17
        if (adapter != null) goto L6;
    L22:
        monitor-exit(this);
        return addresses;
    L6:
        if (this.mLeAudio == null) goto L22;
        List<BluetoothDevice> activeDevices = adapter.getActiveDevices(22);     // Catch: Throwable -> L17
        Iterator<BluetoothDevice> r3 = activeDevices.iterator();     // Catch: Throwable -> L17
    L10:
        if (r3.hasNext() == false) goto L20;
        BluetoothDevice device = r3.next();     // Catch: Throwable -> L17
        if (device == null) goto L10;
        if (this.mLeAudio.getGroupId(device) != groupId) goto L10;
        addresses.add(new Pair(device.getAddress(), device.getIdentityAddress()));     // Catch: Throwable -> L17
        goto L10
    L20:
        monitor-exit(this);
        return addresses;
    L17:
        th = move-exception;
        throw th;
    }

    public static String bluetoothCodecToEncodingString(int btCodecType) {
        switch(btCodecType) {
            case 0: goto L15;
            case 1: goto L13;
            case 2: goto L11;
            case 3: goto L9;
            case 4: goto L7;
            case 5: goto L4;
            case 6: goto L5;
            default: goto L4;
        };
    L5:
        return "ENCODING_OPUS";
    L7:
        return "ENCODING_LDAC";
    L9:
        return "ENCODING_APTX_HD";
    L11:
        return "ENCODING_APTX";
    L13:
        return "ENCODING_AAC";
    L15:
        return "ENCODING_SBC";
    L4:
        return "ENCODING_BT_CODEC_TYPE(" + btCodecType + ")";
    }

    static int getProfileFromType(int deviceType) {
        if (AudioSystem.isBluetoothA2dpOutDevice(deviceType) == false) goto L7;
        return 2;
    L7:
        if (AudioSystem.isBluetoothScoDevice(deviceType) == false) goto L11;
        return 1;
    L11:
        if (AudioSystem.isBluetoothLeDevice(deviceType) == false) goto L14;
        return 22;
    L14:
        return 0;
    }

    static int getTypeFromProfile(int profile, boolean isLeOutput) {
        switch(profile) {
            case 1: goto L18;
            case 2: goto L16;
            case 11: goto L14;
            case 21: goto L12;
            case 22: goto L7;
            case 26: goto L5;
            default: goto L4;
        };
    L5:
        return 536870914;
    L7:
        if (isLeOutput == false) goto L10;
        return 536870912;
    L10:
        return -1610612736;
    L12:
        return 134217728;
    L14:
        return AudioDevice.IN_BLUETOOTH_A2DP;
    L16:
        return 128;
    L18:
        return 16;
    L4:
        throw new IllegalArgumentException("Invalid profile " + profile);
    }

    static Bundle getPreferredAudioProfiles(String address) {
        BluetoothAdapter adapter = BluetoothAdapter.getDefaultAdapter();
        return adapter.getPreferredAudioProfiles(adapter.getRemoteDevice(address));
    }

    static BluetoothDevice getBluetoothDevice(String address) {
        BluetoothAdapter adapter = BluetoothAdapter.getDefaultAdapter();
        if (adapter != null) goto L5;
        return null;
    L5:
        if (BluetoothAdapter.checkBluetoothAddress(address) == true) goto L8;
        return null;
    L8:
        return adapter.getRemoteDevice(address);
    }

    static int getBtDeviceCategory(String address) {
        BluetoothDevice device = getBluetoothDevice(address);
        if (device != null) goto L5;
        return 0;
    L5:
        byte[] deviceType = device.getMetadata(17);
        if (deviceType != null) goto L8;
        return 0;
    L8:
        String deviceCategory = new String(deviceType);
        switch(deviceCategory.hashCode()) {
            case -1834993054: goto L30;
            case -1085510111: goto L27;
            case -672479864: goto L24;
            case -343869473: goto L21;
            case 83350703: goto L18;
            case 104438316: goto L15;
            case 2011237026: goto L12;
            default: goto L32;
        };
    L32:
        byte r4 = -1;
    L33:
        switch(r4) {
            case 0: goto L49;
            case 1: goto L48;
            case 2: goto L47;
            case 3: goto L47;
            case 4: goto L46;
            case 5: goto L45;
            default: goto L34;
        };
    L34:
        BluetoothClass deviceClass = device.getBluetoothClass();
        if (deviceClass != null) goto L38;
        return 0;
    L38:
        switch(deviceClass.getDeviceClass()) {
            case 1028: goto L44;
            case 1044: goto L43;
            case 1048: goto L44;
            case 1052: goto L43;
            case 1064: goto L41;
            case 1084: goto L43;
            case 1796: goto L40;
            default: goto L39;
        };
    L39:
        return 0;
    L40:
        return 5;
    L41:
        return 7;
    L43:
        return 2;
    L44:
        return 3;
    L45:
        return 5;
    L46:
        return 2;
    L47:
        return 3;
    L48:
        return 4;
    L49:
        return 6;
    L12:
        if (deviceCategory.equals(DEVICE_TYPE_CARKIT) == false) goto L32;
        r4 = 1;
        goto L33
    L15:
        if (deviceCategory.equals("Untethered Headset") == false) goto L32;
        r4 = 3;
        goto L33
    L18:
        if (deviceCategory.equals("Watch") == false) goto L32;
        r4 = 5;
        goto L33
    L21:
        if (deviceCategory.equals(DEVICE_TYPE_SPEAKER) == false) goto L32;
        r4 = 4;
        goto L33
    L24:
        if (deviceCategory.equals(DEVICE_TYPE_HEARING_AID) == false) goto L32;
        r4 = 0;
        goto L33
    L27:
        if (deviceCategory.equals("Default") == false) goto L32;
        r4 = 6;
        goto L33
    L30:
        if (deviceCategory.equals(DEVICE_TYPE_HEADSET) == false) goto L32;
        r4 = 2;
        goto L33
    }

    public static void onNotifyPreferredAudioProfileApplied(BluetoothDevice btDevice) {
        BluetoothAdapter.getDefaultAdapter().notifyActiveDeviceChangeApplied(btDevice);
    }

    public static String btDeviceClassToString(int btDeviceClass) {
        switch(btDeviceClass) {
            case 1024: goto L41;
            case 1028: goto L39;
            case 1032: goto L37;
            case 1036: goto L35;
            case 1040: goto L33;
            case 1044: goto L31;
            case 1048: goto L29;
            case 1052: goto L27;
            case 1056: goto L25;
            case 1060: goto L23;
            case 1064: goto L21;
            case 1068: goto L19;
            case 1072: goto L17;
            case 1076: goto L15;
            case 1080: goto L13;
            case 1084: goto L11;
            case 1088: goto L9;
            case 1092: goto L7;
            case 1096: goto L5;
            default: goto L4;
        };
    L5:
        return "AUDIO_VIDEO_VIDEO_GAMING_TOY";
    L7:
        return "AUDIO_VIDEO_RESERVED_0x0444";
    L9:
        return "AUDIO_VIDEO_VIDEO_CONFERENCING";
    L11:
        return "AUDIO_VIDEO_VIDEO_DISPLAY_AND_LOUDSPEAKER";
    L13:
        return "AUDIO_VIDEO_VIDEO_MONITOR";
    L15:
        return "AUDIO_VIDEO_CAMCORDER";
    L17:
        return "AUDIO_VIDEO_VIDEO_CAMERA";
    L19:
        return "AUDIO_VIDEO_VCR";
    L21:
        return "AUDIO_VIDEO_HIFI_AUDIO";
    L23:
        return "AUDIO_VIDEO_SET_TOP_BOX";
    L25:
        return "AUDIO_VIDEO_CAR_AUDIO";
    L27:
        return "AUDIO_VIDEO_PORTABLE_AUDIO";
    L29:
        return "AUDIO_VIDEO_HEADPHONES";
    L31:
        return "AUDIO_VIDEO_LOUDSPEAKER";
    L33:
        return "AUDIO_VIDEO_MICROPHONE";
    L35:
        return "AUDIO_VIDEO_RESERVED_0x040C";
    L37:
        return "AUDIO_VIDEO_HANDSFREE";
    L39:
        return "AUDIO_VIDEO_WEARABLE_HEADSET";
    L41:
        return "AUDIO_VIDEO_UNCATEGORIZED";
    L4:
        return TextUtils.formatSimple("0x%04x", new Object[]{Integer.valueOf(btDeviceClass)});
    }

    void dump(PrintWriter pw, String prefix) {
        pw.println("\n" + prefix + "mBluetoothHeadset: " + this.mBluetoothHeadset);
        StringBuilder r0 = new StringBuilder();
        r0.append(prefix);
        r0.append("mBluetoothHeadsetDevice: ");
        r0.append(this.mBluetoothHeadsetDevice);
        pw.println(r0.toString());
        if (this.mBluetoothHeadsetDevice == null) goto L7;
        BluetoothClass bluetoothClass = this.mBluetoothHeadsetDevice.getBluetoothClass();
        if (bluetoothClass == null) goto L7;
        pw.println(prefix + "mBluetoothHeadsetDevice.DeviceClass: " + btDeviceClassToString(bluetoothClass.getDeviceClass()));
    L7:
        pw.println(prefix + "mScoAudioState: " + scoAudioStateToString(this.mScoAudioState));
        pw.println(prefix + "mScoAudioMode: " + scoAudioModeToString(this.mScoAudioMode));
        pw.println("\n" + prefix + "mHearingAid: " + this.mHearingAid);
        pw.println("\n" + prefix + "mLeAudio: " + this.mLeAudio);
        StringBuilder r1 = new StringBuilder();
        r1.append(prefix);
        r1.append("mA2dp: ");
        r1.append(mA2dp);
        pw.println(r1.toString());
        pw.println(prefix + "mAvrcpAbsVolSupported: " + this.mAvrcpAbsVolSupported);
    }
}
