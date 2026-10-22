package com.android.server.audio;

import android.app.compat.CompatChanges;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothProfile;
import android.content.AttributionSource;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.hardware.audio.common.V2_0.AudioDevice;
import android.media.AudioAttributes;
import android.media.AudioDeviceAttributes;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.media.AudioPlaybackConfiguration;
import android.media.AudioRecordingConfiguration;
import android.media.AudioRoutesInfo;
import android.media.AudioSystem;
import android.media.BluetoothProfileConnectionInfo;
import android.media.IAudioRoutesObserver;
import android.media.ICapturePresetDevicesRoleDispatcher;
import android.media.ICommunicationDeviceDispatcher;
import android.media.IStrategyNonDefaultDevicesDispatcher;
import android.media.IStrategyPreferredDevicesDispatcher;
import android.media.MediaMetrics;
import android.media.audiopolicy.AudioProductStrategy;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.PowerManager;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.os.SystemClock;
import android.os.SystemProperties;
import android.os.UserHandle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.util.PrintWriterPrinter;
import com.android.server.input.KeyboardMetricsCollector;
import com.android.server.slice.SliceClientPermissions;
import com.android.server.utils.EventLogger;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public class AudioDeviceBroker {
    private static final long BROKER_WAKELOCK_TIMEOUT_MS = 5000;
    static final int BTA2DP_DOCK_TIMEOUT_MS = 8000;
    private static final int BTA2DP_MUTE_CHECK_DELAY_MS = 100;
    static final int BT_HEADSET_CNCT_TIMEOUT_MS = 3000;
    private static final int CHECK_CLIENT_STATE_DELAY_MS = 6000;
    private static final Set<Integer> MESSAGES_MUTE_MUSIC = null;
    private static final int MSG_BROADCAST_AUDIO_BECOMING_NOISY = 12;
    private static final int MSG_BT_HEADSET_CNCT_FAILED = 9;
    private static final int MSG_CHECK_COMMUNICATION_ROUTE_CLIENT_STATE = 56;
    private static final int MSG_CHECK_MUTE_MUSIC = 35;
    private static final int MSG_IIL_BTLEAUDIO_TIMEOUT = 49;
    private static final int MSG_IIL_SET_FORCE_USE = 4;
    private static final int MSG_II_SET_HEARING_AID_VOLUME = 14;
    private static final int MSG_II_SET_LE_AUDIO_OUT_VOLUME = 46;
    private static final int MSG_IL_BTA2DP_TIMEOUT = 10;
    private static final int MSG_IL_BT_HEARING_AID_TIMEOUT = 61;
    private static final int MSG_IL_BT_SERVICE_CONNECTED_PROFILE = 23;
    private static final int MSG_IL_UPDATED_ADI_DEVICE_STATE = 59;
    private static final int MSG_I_BROADCAST_BT_CONNECTION_STATE = 3;
    private static final int MSG_I_BT_SERVICE_DISCONNECTED_PROFILE = 22;
    private static final int MSG_I_SET_AVRCP_ABSOLUTE_VOLUME = 15;
    private static final int MSG_I_UPDATE_LE_AUDIO_GROUP_ADDRESSES = 57;
    private static final int MSG_L_BLUETOOTH_DEVICE_CONFIG_CHANGE = 11;
    private static final int MSG_L_BT_ACTIVE_DEVICE_CHANGE_EXT = 45;
    private static final int MSG_L_COMMUNICATION_ROUTE_CLIENT_DIED = 34;
    private static final int MSG_L_HEARING_AID_DEVICE_CONNECTION_CHANGE_EXT = 31;
    private static final int MSG_L_NOTIFY_PREFERRED_AUDIOPROFILE_APPLIED = 52;
    private static final int MSG_L_RECEIVED_BT_EVENT = 55;
    private static final int MSG_L_SET_BT_ACTIVE_DEVICE = 7;
    private static final int MSG_L_SET_COMMUNICATION_DEVICE_FOR_CLIENT = 42;
    private static final int MSG_L_SET_FORCE_BT_A2DP_USE = 5;
    private static final int MSG_L_SET_FORCE_BT_A2DP_USE_NO_MUTE = 60;
    private static final int MSG_L_SET_MODE_OWNER = 16;
    private static final int MSG_L_SET_MODE_OWNER_SIGNAL = 17;
    private static final int MSG_L_SET_WIRED_DEVICE_CONNECTION_STATE = 2;
    private static final int MSG_L_SYNCHRONIZE_ADI_DEVICES_IN_INVENTORY = 58;
    private static final int MSG_L_UPDATE_COMMUNICATION_ROUTE_CLIENT = 43;
    private static final int MSG_PERSIST_AUDIO_DEVICE_SETTINGS = 54;
    private static final int MSG_REPORT_NEW_ROUTES = 13;
    private static final int MSG_REPORT_NEW_ROUTES_A2DP = 36;
    private static final int MSG_RESTORE_DEVICES = 1;
    private static final int MSG_TOGGLE_HDMI = 6;
    private static final int SENDMSG_NOOP = 1;
    private static final int SENDMSG_QUEUE = 2;
    private static final int SENDMSG_REPLACE = 0;
    private static final long SET_COMMUNICATION_DEVICE_TIMEOUT_MS = 3000;
    private static final String TAG = "AS.AudioDeviceBroker";
    public static final long USE_SET_COMMUNICATION_DEVICE = 243827847;
    private static final int[] VALID_COMMUNICATION_DEVICE_TYPES = null;
    private static long sLastDeviceConnectMsgTime;
    private static final Object sLastDeviceConnectionMsgTimeLock = null;
    protected final AudioDeviceBrokerExt mADBExt;
    private int mAccessibilityStrategyId;
    AudioDeviceInfo mActiveCommunicationDevice;
    private AudioModeInfo mAudioModeOwner;
    private final AudioService mAudioService;
    private final AudioSystemAdapter mAudioSystem;
    private AtomicBoolean mBluetoothA2dpEnabled;
    private boolean mBluetoothA2dpSuspendedApplied;
    private boolean mBluetoothA2dpSuspendedExt;
    private boolean mBluetoothA2dpSuspendedInt;
    private final Object mBluetoothAudioStateLock;
    private boolean mBluetoothLeSuspendedApplied;
    private boolean mBluetoothLeSuspendedExt;
    private boolean mBluetoothLeSuspendedInt;
    private boolean mBluetoothScoOn;
    private boolean mBluetoothScoOnApplied;
    private PowerManager.WakeLock mBrokerEventWakeLock;
    private BrokerHandler mBrokerHandler;
    private BrokerThread mBrokerThread;
    private String mBtHeadsetName;
    private final BtHelper mBtHelper;
    final RemoteCallbackList<ICommunicationDeviceDispatcher> mCommDevDispatchers;
    private final Object mCommunicationDeviceLock;
    private int mCommunicationDeviceUpdateCount;
    private final LinkedList<CommunicationRouteClient> mCommunicationRouteClients;
    int mCommunicationStrategyId;
    private final Context mContext;
    int mCurCommunicationPortId;
    private final AudioDeviceInventory mDeviceInventory;
    private final Object mDeviceStateLock;
    private final HashMap<Integer, Integer> mDuplexCommunicationDevices;
    private boolean mHasNrecEnabled;
    private boolean mHasSwbAptXEnabled;
    private boolean mHasSwbLc3Enabled;
    private boolean mHasWbsEnabled;
    private AtomicBoolean mMusicMuted;
    private AudioDeviceAttributes mPreferredCommunicationDevice;
    private final boolean mScoManagedByAudio;
    final Object mSetModeLock;
    private final SystemServerAdapter mSystemServer;

    static final class AudioModeInfo {
        final int mMode;
        final int mPid;
        final int mUid;

        AudioModeInfo(int mode, int pid, int uid) {
            this.mMode = mode;
            this.mPid = pid;
            this.mUid = uid;
        }

        public String toString() {
            return "AudioModeInfo: mMode=" + AudioSystem.modeToString(this.mMode) + ", mPid=" + this.mPid + ", mUid=" + this.mUid;
        }
    }

    static final class BleVolumeInfo {
        final int mIndex;
        final int mMaxIndex;
        final int mStreamType;

        BleVolumeInfo(int index, int maxIndex, int streamType) {
            this.mIndex = index;
            this.mMaxIndex = maxIndex;
            this.mStreamType = streamType;
        }
    }

    private class BrokerHandler extends Handler {
        final /* synthetic */ AudioDeviceBroker this$0;

        /* synthetic */ BrokerHandler(AudioDeviceBroker r1, AudioDeviceBrokerIA r2) {
            this(r1);
        }

        private BrokerHandler(AudioDeviceBroker r1) {
            this.this$0 = r1;
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            int muteCheckDelayMs = 100;
            int forcedUsage = 10;
            boolean r4 = true;
            switch(msg.what) {
                case 1: goto L338;
                case 2: goto L330;
                case 3: goto L322;
                case 4: goto L321;
                case 5: goto L317;
                case 6: goto L308;
                case 7: goto L268;
                case 8: goto L4;
                case 9: goto L253;
                case 10: goto L245;
                case 11: goto L237;
                case 12: goto L236;
                case 13: goto L228;
                case 14: goto L220;
                case 15: goto L212;
                case 16: goto L192;
                case 17: goto L192;
                case 18: goto L4;
                case 19: goto L4;
                case 20: goto L4;
                case 21: goto L4;
                case 22: goto L177;
                case 23: goto L162;
                case 24: goto L4;
                case 25: goto L4;
                case 26: goto L4;
                case 27: goto L4;
                case 28: goto L4;
                case 29: goto L4;
                case 30: goto L4;
                case 31: goto L4;
                case 32: goto L4;
                case 33: goto L4;
                case 34: goto L147;
                case 35: goto L146;
                case 36: goto L228;
                case 37: goto L4;
                case 38: goto L4;
                case 39: goto L4;
                case 40: goto L4;
                case 41: goto L4;
                case 42: goto L119;
                case 43: goto L104;
                case 44: goto L4;
                case 45: goto L93;
                case 46: goto L85;
                case 47: goto L4;
                case 48: goto L4;
                case 49: goto L77;
                case 50: goto L4;
                case 51: goto L4;
                case 52: goto L76;
                case 53: goto L4;
                case 54: goto L75;
                case 55: goto L60;
                case 56: goto L48;
                case 57: goto L33;
                case 58: goto L18;
                case 59: goto L13;
                case 60: goto L317;
                case 61: goto L5;
                default: goto L4;
            };
        L4:
            Log.wtf(AudioDeviceBroker.TAG, "Invalid message " + msg.what);
        L358:
            if (AudioDeviceBroker.m1946$$Nest$sfgetMESSAGES_MUTE_MUSIC().contains(Integer.valueOf(msg.what)) == false) goto L361;
            AudioDeviceBroker.m1944$$Nest$msendMsg(this.this$0, 35, 0, muteCheckDelayMs);
        L361:
            if (AudioDeviceBroker.m1947$$Nest$smisMessageHandledUnderWakelock(msg.what) == false) goto L444;
            AudioDeviceBroker.m1925$$Nest$fgetmBrokerEventWakeLock(this.this$0).release();     // Catch: Exception -> L364
            return;
        L364:
            e = move-exception;
            Log.e(AudioDeviceBroker.TAG, "Exception releasing wakelock", e);
            return;
        L444:
            return;
        L5:
            Object r1 = AudioDeviceBroker.m1930$$Nest$fgetmDeviceStateLock(this.this$0);
            monitor-enter(r1);
            AudioDeviceBroker.m1929$$Nest$fgetmDeviceInventory(this.this$0).onMakeHearingAidDeviceUnavailableNow((String) msg.obj);     // Catch: Throwable -> L10
            monitor-exit(r1);     // Catch: Throwable -> L10
        L10:
            th = move-exception;
            throw th;
        L13:
            AudioService r2 = AudioDeviceBroker.m1921$$Nest$fgetmAudioService(this.this$0);
            AdiDeviceState r3 = (AdiDeviceState) msg.obj;
            if (msg.arg1 == 1) goto L17;
            r4 = false;
        L17:
            r2.onUpdatedAdiDeviceState(r3, r4);
            goto L358
        L18:
            Object r5 = this.this$0.mSetModeLock;
            monitor-enter(r5);
            Object r6 = AudioDeviceBroker.m1930$$Nest$fgetmDeviceStateLock(this.this$0);     // Catch: Throwable -> L26
            monitor-enter(r6);     // Catch: Throwable -> L26
            AudioDeviceBroker.m1929$$Nest$fgetmDeviceInventory(this.this$0).onSynchronizeAdiDevicesInInventory((AdiDeviceState) msg.obj);     // Catch: Throwable -> L28
            monitor-exit(r6);     // Catch: Throwable -> L28
            monitor-exit(r5);     // Catch: Throwable -> L26
            goto L358
        L28:
            th = move-exception;
            throw th;     // Catch: Throwable -> L26
        L26:
            th = move-exception;
            throw th;
        L33:
            Object r7 = this.this$0.mSetModeLock;
            monitor-enter(r7);
            Object r8 = AudioDeviceBroker.m1930$$Nest$fgetmDeviceStateLock(this.this$0);     // Catch: Throwable -> L41
            monitor-enter(r8);     // Catch: Throwable -> L41
            AudioDeviceBroker.m1929$$Nest$fgetmDeviceInventory(this.this$0).onUpdateLeAudioGroupAddresses(msg.arg1);     // Catch: Throwable -> L43
            monitor-exit(r8);     // Catch: Throwable -> L43
            monitor-exit(r7);     // Catch: Throwable -> L41
            goto L358
        L43:
            th = move-exception;
            throw th;     // Catch: Throwable -> L41
        L41:
            th = move-exception;
            throw th;
        L48:
            Object r9 = AudioDeviceBroker.m1930$$Nest$fgetmDeviceStateLock(this.this$0);
            monitor-enter(r9);
            AudioDeviceBroker r10 = this.this$0;     // Catch: Throwable -> L57
            int r11 = msg.arg1;     // Catch: Throwable -> L57
            if (msg.arg2 == 1) goto L54;
            r4 = false;
        L54:
            r10.onCheckCommunicationRouteClientState(r11, r4);     // Catch: Throwable -> L57
            monitor-exit(r9);     // Catch: Throwable -> L57
        L57:
            th = move-exception;
            throw th;
        L60:
            Object r12 = this.this$0.mSetModeLock;
            monitor-enter(r12);
            Object r13 = AudioDeviceBroker.m1930$$Nest$fgetmDeviceStateLock(this.this$0);     // Catch: Throwable -> L68
            monitor-enter(r13);     // Catch: Throwable -> L68
            AudioDeviceBroker.m1939$$Nest$monReceiveBtEvent(this.this$0, (Intent) msg.obj);     // Catch: Throwable -> L70
            monitor-exit(r13);     // Catch: Throwable -> L70
            monitor-exit(r12);     // Catch: Throwable -> L68
            goto L358
        L70:
            th = move-exception;
            throw th;     // Catch: Throwable -> L68
        L68:
            th = move-exception;
            throw th;
        L75:
            this.this$0.onPersistAudioDeviceSettings();
            goto L358
        L76:
            BluetoothDevice btDevice = (BluetoothDevice) msg.obj;
            BtHelper.onNotifyPreferredAudioProfileApplied(btDevice);
            goto L358
        L77:
            Object r14 = AudioDeviceBroker.m1930$$Nest$fgetmDeviceStateLock(this.this$0);
            monitor-enter(r14);
            AudioDeviceBroker.m1929$$Nest$fgetmDeviceInventory(this.this$0).onMakeLeAudioDeviceUnavailableNow((String) msg.obj, msg.arg1, msg.arg2);     // Catch: Throwable -> L82
            monitor-exit(r14);     // Catch: Throwable -> L82
        L82:
            th = move-exception;
            throw th;
        L85:
            BleVolumeInfo info = (BleVolumeInfo) msg.obj;
            Object r15 = AudioDeviceBroker.m1930$$Nest$fgetmDeviceStateLock(this.this$0);
            monitor-enter(r15);
            AudioDeviceBroker.m1926$$Nest$fgetmBtHelper(this.this$0).setLeAudioVolume(info.mIndex, info.mMaxIndex, info.mStreamType);     // Catch: Throwable -> L90
            monitor-exit(r15);     // Catch: Throwable -> L90
        L90:
            th = move-exception;
            throw th;
        L93:
            BtDeviceInfo btInfo = (BtDeviceInfo) msg.obj;
            if (btInfo.mDevice == null) goto L358;
            AudioService.sDeviceLogger.enqueue(new EventLogger.StringEvent("msg: MSG_L_BT_ACTIVE_DEVICE_CHANGE_EXT " + btInfo).printLog(AudioDeviceBroker.TAG));
            Object r16 = AudioDeviceBroker.m1930$$Nest$fgetmDeviceStateLock(this.this$0);
            monitor-enter(r16);
            AudioDeviceBroker.m1929$$Nest$fgetmDeviceInventory(this.this$0).setBluetoothActiveDevice(btInfo);     // Catch: Throwable -> L101
            monitor-exit(r16);     // Catch: Throwable -> L101
        L101:
            th = move-exception;
            throw th;
        L104:
            Object r17 = this.this$0.mSetModeLock;
            monitor-enter(r17);
            Object r18 = AudioDeviceBroker.m1930$$Nest$fgetmDeviceStateLock(this.this$0);     // Catch: Throwable -> L112
            monitor-enter(r18);     // Catch: Throwable -> L112
            UpdateCommRouteClientInfo info2 = (UpdateCommRouteClientInfo) msg.obj;     // Catch: Throwable -> L114
            AudioDeviceBroker.m1942$$Nest$monUpdateCommunicationRouteClient(this.this$0, info2.attributionSource, info2.eventSource);     // Catch: Throwable -> L114
            monitor-exit(r18);     // Catch: Throwable -> L114
            monitor-exit(r17);     // Catch: Throwable -> L112
            goto L358
        L114:
            th = move-exception;
            throw th;     // Catch: Throwable -> L112
        L112:
            th = move-exception;
            throw th;
        L119:
            CommunicationDeviceInfo deviceInfo = (CommunicationDeviceInfo) msg.obj;
            Object r19 = this.this$0.mSetModeLock;
            monitor-enter(r19);
            Object r20 = AudioDeviceBroker.m1930$$Nest$fgetmDeviceStateLock(this.this$0);     // Catch: Throwable -> L139
            monitor-enter(r20);     // Catch: Throwable -> L139
            this.this$0.onSetCommunicationDeviceForClient(deviceInfo);     // Catch: Throwable -> L141
            monitor-exit(r20);     // Catch: Throwable -> L141
            monitor-exit(r19);     // Catch: Throwable -> L139
            Object r21 = AudioDeviceBroker.m1927$$Nest$fgetmCommunicationDeviceLock(this.this$0);
            monitor-enter(r21);
        L131:
            th = move-exception;
            throw th;
        L129:
            if (AudioDeviceBroker.m1928$$Nest$fgetmCommunicationDeviceUpdateCount(this.this$0) <= 0) goto L133;
            AudioDeviceBroker r22 = this.this$0;     // Catch: Throwable -> L131
            AudioDeviceBroker.m1934$$Nest$fputmCommunicationDeviceUpdateCount(r22, AudioDeviceBroker.m1928$$Nest$fgetmCommunicationDeviceUpdateCount(r22) - 1);     // Catch: Throwable -> L131
        L134:
            AudioDeviceBroker.m1927$$Nest$fgetmCommunicationDeviceLock(this.this$0).notify();     // Catch: Throwable -> L131
            monitor-exit(r21);     // Catch: Throwable -> L131
            goto L358
        L133:
            Log.e(AudioDeviceBroker.TAG, "mCommunicationDeviceUpdateCount already 0 in MSG_L_SET_COMMUNICATION_DEVICE_FOR_CLIENT");     // Catch: Throwable -> L131
            goto L134
        L141:
            th = move-exception;
            throw th;     // Catch: Throwable -> L139
        L139:
            th = move-exception;
            throw th;
        L146:
            AudioDeviceBroker.m1936$$Nest$mcheckMessagesMuteMusic(this.this$0, 0);
            goto L358
        L147:
            Object r23 = this.this$0.mSetModeLock;
            monitor-enter(r23);
            Object r24 = AudioDeviceBroker.m1930$$Nest$fgetmDeviceStateLock(this.this$0);     // Catch: Throwable -> L155
            monitor-enter(r24);     // Catch: Throwable -> L155
            AudioDeviceBroker.m1938$$Nest$monCommunicationRouteClientDied(this.this$0, (CommunicationRouteClient) msg.obj);     // Catch: Throwable -> L157
            monitor-exit(r24);     // Catch: Throwable -> L157
            monitor-exit(r23);     // Catch: Throwable -> L155
            goto L358
        L157:
            th = move-exception;
            throw th;     // Catch: Throwable -> L155
        L155:
            th = move-exception;
            throw th;
        L162:
            Object r25 = this.this$0.mSetModeLock;
            monitor-enter(r25);
            Object r26 = AudioDeviceBroker.m1930$$Nest$fgetmDeviceStateLock(this.this$0);     // Catch: Throwable -> L170
            monitor-enter(r26);     // Catch: Throwable -> L170
            AudioDeviceBroker.m1926$$Nest$fgetmBtHelper(this.this$0).onBtProfileConnected(msg.arg1, (BluetoothProfile) msg.obj);     // Catch: Throwable -> L172
            monitor-exit(r26);     // Catch: Throwable -> L172
            monitor-exit(r25);     // Catch: Throwable -> L170
            goto L358
        L172:
            th = move-exception;
            throw th;     // Catch: Throwable -> L170
        L170:
            th = move-exception;
            throw th;
        L177:
            Object r27 = this.this$0.mSetModeLock;
            monitor-enter(r27);
            Object r28 = AudioDeviceBroker.m1930$$Nest$fgetmDeviceStateLock(this.this$0);     // Catch: Throwable -> L185
            monitor-enter(r28);     // Catch: Throwable -> L185
            AudioDeviceBroker.m1926$$Nest$fgetmBtHelper(this.this$0).onBtProfileDisconnected(msg.arg1);     // Catch: Throwable -> L187
            AudioDeviceBroker.m1929$$Nest$fgetmDeviceInventory(this.this$0).onBtProfileDisconnected(msg.arg1);     // Catch: Throwable -> L187
            monitor-exit(r28);     // Catch: Throwable -> L187
            monitor-exit(r27);     // Catch: Throwable -> L185
            goto L358
        L187:
            th = move-exception;
            throw th;     // Catch: Throwable -> L185
        L185:
            th = move-exception;
            throw th;
        L192:
            Object r29 = this.this$0.mSetModeLock;
            monitor-enter(r29);
            Object r30 = AudioDeviceBroker.m1930$$Nest$fgetmDeviceStateLock(this.this$0);     // Catch: Throwable -> L206
            monitor-enter(r30);     // Catch: Throwable -> L206
            AudioDeviceBroker.m1932$$Nest$fputmAudioModeOwner(this.this$0, (AudioModeInfo) msg.obj);     // Catch: Throwable -> L199
            if (AudioDeviceBroker.m1920$$Nest$fgetmAudioModeOwner(this.this$0).mMode == 1) goto L201;
            AudioDeviceBroker.m1942$$Nest$monUpdateCommunicationRouteClient(this.this$0, this.this$0.bluetoothScoRequestOwnerAttributionSource(), "setNewModeOwner");     // Catch: Throwable -> L199
        L201:
            monitor-exit(r30);     // Catch: Throwable -> L199
            monitor-exit(r29);     // Catch: Throwable -> L206
            if (msg.what != 17) goto L358;
            AudioDeviceBroker.m1921$$Nest$fgetmAudioService(this.this$0).decrementAudioModeResetCount();
            goto L358
        L199:
            th = move-exception;
            throw th;     // Catch: Throwable -> L206
        L206:
            th = move-exception;
            throw th;
        L212:
            Object r31 = AudioDeviceBroker.m1930$$Nest$fgetmDeviceStateLock(this.this$0);
            monitor-enter(r31);
            AudioDeviceBroker.m1926$$Nest$fgetmBtHelper(this.this$0).setAvrcpAbsoluteVolumeIndex(msg.arg1);     // Catch: Throwable -> L217
            monitor-exit(r31);     // Catch: Throwable -> L217
        L217:
            th = move-exception;
            throw th;
        L220:
            Object r32 = AudioDeviceBroker.m1930$$Nest$fgetmDeviceStateLock(this.this$0);
            monitor-enter(r32);
            AudioDeviceBroker.m1926$$Nest$fgetmBtHelper(this.this$0).setHearingAidVolume(msg.arg1, msg.arg2, AudioDeviceBroker.m1929$$Nest$fgetmDeviceInventory(this.this$0).isHearingAidConnected());     // Catch: Throwable -> L225
            monitor-exit(r32);     // Catch: Throwable -> L225
        L225:
            th = move-exception;
            throw th;
        L228:
            Object r33 = AudioDeviceBroker.m1930$$Nest$fgetmDeviceStateLock(this.this$0);
            monitor-enter(r33);
            AudioDeviceBroker.m1929$$Nest$fgetmDeviceInventory(this.this$0).onReportNewRoutes();     // Catch: Throwable -> L233
            monitor-exit(r33);     // Catch: Throwable -> L233
        L233:
            th = move-exception;
            throw th;
        L236:
            AudioDeviceBroker.m1940$$Nest$monSendBecomingNoisyIntent(this.this$0);
            goto L358
        L237:
            BtDeviceInfo btInfo2 = (BtDeviceInfo) msg.obj;
            Pair<Integer, Boolean> codecAndChanged = AudioDeviceBroker.m1926$$Nest$fgetmBtHelper(this.this$0).getCodecWithFallback(btInfo2.mDevice, btInfo2.mProfile, btInfo2.mIsLeOutput, "MSG_L_BLUETOOTH_DEVICE_CONFIG_CHANGE");
            Object r34 = AudioDeviceBroker.m1930$$Nest$fgetmDeviceStateLock(this.this$0);
            monitor-enter(r34);
            muteCheckDelayMs = 100 + AudioDeviceBroker.m1929$$Nest$fgetmDeviceInventory(this.this$0).onBluetoothDeviceConfigChange(btInfo2, ((Integer) codecAndChanged.first).intValue(), ((Boolean) codecAndChanged.second).booleanValue(), 0);     // Catch: Throwable -> L242
            monitor-exit(r34);     // Catch: Throwable -> L242
        L242:
            th = move-exception;
            throw th;
        L245:
            Object r35 = AudioDeviceBroker.m1930$$Nest$fgetmDeviceStateLock(this.this$0);
            monitor-enter(r35);
            AudioDeviceBroker.m1929$$Nest$fgetmDeviceInventory(this.this$0).onMakeA2dpDeviceUnavailableNow((String) msg.obj, msg.arg1);     // Catch: Throwable -> L250
            monitor-exit(r35);     // Catch: Throwable -> L250
        L250:
            th = move-exception;
            throw th;
        L253:
            Object r36 = this.this$0.mSetModeLock;
            monitor-enter(r36);
            Object r37 = AudioDeviceBroker.m1930$$Nest$fgetmDeviceStateLock(this.this$0);     // Catch: Throwable -> L261
            monitor-enter(r37);     // Catch: Throwable -> L261
            AudioDeviceBroker.m1926$$Nest$fgetmBtHelper(this.this$0).resetBluetoothSco();     // Catch: Throwable -> L263
            monitor-exit(r37);     // Catch: Throwable -> L263
            monitor-exit(r36);     // Catch: Throwable -> L261
            goto L358
        L263:
            th = move-exception;
            throw th;     // Catch: Throwable -> L261
        L261:
            th = move-exception;
            throw th;
        L268:
            BtDeviceInfo btInfo3 = (BtDeviceInfo) msg.obj;
            if (btInfo3.mState == 2) goto L271;
        L273:
            Pair<Integer, Boolean> codecAndChanged2 = AudioDeviceBroker.m1926$$Nest$fgetmBtHelper(this.this$0).getCodecWithFallback(btInfo3.mDevice, btInfo3.mProfile, btInfo3.mIsLeOutput, "MSG_L_SET_BT_ACTIVE_DEVICE");
            Object r38 = this.this$0.mSetModeLock;
            monitor-enter(r38);
            Object r39 = AudioDeviceBroker.m1930$$Nest$fgetmDeviceStateLock(this.this$0);     // Catch: Throwable -> L302
            monitor-enter(r39);     // Catch: Throwable -> L302
            AudioDeviceInventory r40 = AudioDeviceBroker.m1929$$Nest$fgetmDeviceInventory(this.this$0);     // Catch: Throwable -> L283
            int r41 = ((Integer) codecAndChanged2.first).intValue();     // Catch: Throwable -> L283
            if (btInfo3.mProfile != 22) goto L285;
            if (btInfo3.mIsLeOutput == true) goto L285;
            int r110 = -1;
        L286:
            r40.onSetBtActiveDevice(btInfo3, r41, r110);     // Catch: Throwable -> L283
            if (btInfo3.mProfile != 22) goto L289;
        L294:
            AudioDeviceBroker.m1935$$Nest$mcheckCommunicationRouteClientsDevices(this.this$0);     // Catch: Throwable -> L283
            if (btInfo3.mState != 2) goto L297;
        L298:
            AudioDeviceBroker.m1942$$Nest$monUpdateCommunicationRouteClient(this.this$0, this.this$0.bluetoothScoRequestOwnerAttributionSource(), "setBluetoothActiveDevice");     // Catch: Throwable -> L283
        L299:
            monitor-exit(r39);     // Catch: Throwable -> L283
            monitor-exit(r38);     // Catch: Throwable -> L302
            goto L358
        L297:
            if (btInfo3.mIsDeviceSwitch == true) goto L299;
        L289:
            if (btInfo3.mProfile == 21) goto L294;
            if (AudioDeviceBroker.m1931$$Nest$fgetmScoManagedByAudio(this.this$0) == false) goto L299;
            if (btInfo3.mProfile != 1) goto L299;
        L285:
            r110 = AudioDeviceBroker.m1921$$Nest$fgetmAudioService(this.this$0).getBluetoothContextualVolumeStream();     // Catch: Throwable -> L283
        L283:
            th = move-exception;
            throw th;     // Catch: Throwable -> L302
        L302:
            th = move-exception;
            throw th;
        L271:
            if (AudioDeviceBroker.m1926$$Nest$fgetmBtHelper(this.this$0).isProfilePoxyConnected(btInfo3.mProfile) == true) goto L273;
            AudioService.sDeviceLogger.enqueue(new EventLogger.StringEvent("msg: MSG_L_SET_BT_ACTIVE_DEVICE received with null profile proxy: " + btInfo3).printLog(AudioDeviceBroker.TAG));
            goto L358
        L308:
            Object r42 = AudioDeviceBroker.m1930$$Nest$fgetmDeviceStateLock(this.this$0);
            monitor-enter(r42);
            AudioDeviceBroker.m1929$$Nest$fgetmDeviceInventory(this.this$0).onToggleHdmi();     // Catch: Throwable -> L313
            monitor-exit(r42);     // Catch: Throwable -> L313
        L313:
            th = move-exception;
            throw th;
        L321:
            AudioDeviceBroker.m1941$$Nest$monSetForceUse(this.this$0, msg.arg1, msg.arg2, false, (String) msg.obj);
            goto L358
        L322:
            Object r43 = AudioDeviceBroker.m1930$$Nest$fgetmDeviceStateLock(this.this$0);
            monitor-enter(r43);
            AudioDeviceBroker.m1926$$Nest$fgetmBtHelper(this.this$0).onBroadcastScoConnectionState(msg.arg1);     // Catch: Throwable -> L327
            monitor-exit(r43);     // Catch: Throwable -> L327
        L327:
            th = move-exception;
            throw th;
        L330:
            Object r44 = AudioDeviceBroker.m1930$$Nest$fgetmDeviceStateLock(this.this$0);
            monitor-enter(r44);
            AudioDeviceBroker.m1929$$Nest$fgetmDeviceInventory(this.this$0).onSetWiredDeviceConnectionState((AudioDeviceInventory.WiredDeviceConnectionState) msg.obj);     // Catch: Throwable -> L335
            monitor-exit(r44);     // Catch: Throwable -> L335
        L335:
            th = move-exception;
            throw th;
        L338:
            Object r45 = this.this$0.mSetModeLock;
            monitor-enter(r45);
            Object r46 = AudioDeviceBroker.m1930$$Nest$fgetmDeviceStateLock(this.this$0);     // Catch: Throwable -> L367
            monitor-enter(r46);     // Catch: Throwable -> L367
            AudioDeviceBroker.m1937$$Nest$minitRoutingStrategyIds(this.this$0);     // Catch: Throwable -> L369
            this.this$0.updateActiveCommunicationDevice();     // Catch: Throwable -> L369
            AudioDeviceBroker.m1929$$Nest$fgetmDeviceInventory(this.this$0).onRestoreDevices();     // Catch: Throwable -> L369
            Object r47 = AudioDeviceBroker.m1924$$Nest$fgetmBluetoothAudioStateLock(this.this$0);     // Catch: Throwable -> L369
            monitor-enter(r47);     // Catch: Throwable -> L369
            AudioDeviceBroker.m1943$$Nest$mreapplyAudioHalBluetoothState(this.this$0);     // Catch: Throwable -> L347
            if (AudioDeviceBroker.m1923$$Nest$fgetmBluetoothA2dpSuspendedApplied(this.this$0) == true) goto L349;
            AudioSystem.setParameters("A2dpSuspended=true");     // Catch: Throwable -> L347
            AudioSystem.setParameters("A2dpSuspended=false");     // Catch: Throwable -> L347
        L349:
            monitor-exit(r47);     // Catch: Throwable -> L347
        L351:
            if (this.this$0.getBluetoothA2dpEnabled() == false) goto L354;
            forcedUsage = 0;
        L354:
            this.this$0.setForceUse_Async(1, forcedUsage, "MSG_RESTORE_DEVICES");     // Catch: Throwable -> L369
            AudioDeviceBroker.m1945$$Nest$mupdateCommunicationRoute(this.this$0, "MSG_RESTORE_DEVICES");     // Catch: Throwable -> L369
            monitor-exit(r46);     // Catch: Throwable -> L369
            monitor-exit(r45);     // Catch: Throwable -> L367
        L347:
            th = move-exception;
            throw th;     // Catch: Throwable -> L369
        L369:
            th = move-exception;
            throw th;     // Catch: Throwable -> L367
        L367:
            th = move-exception;
            throw th;
        L317:
            if (AudioDeviceBroker.m1922$$Nest$fgetmBluetoothA2dpEnabled(this.this$0).get() == false) goto L320;
            forcedUsage = 0;
        L320:
            AudioDeviceBroker.m1941$$Nest$monSetForceUse(this.this$0, 1, forcedUsage, true, (String) msg.obj);
            goto L358
        }
    }

    private class BrokerThread extends Thread {
        final /* synthetic */ AudioDeviceBroker this$0;

        BrokerThread(AudioDeviceBroker r1) {
            this.this$0 = r1;
            super("AudioDeviceBroker");
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Looper.prepare();
            AudioDeviceBroker r0 = this.this$0;
            monitor-enter(r0);
            AudioDeviceBroker.m1933$$Nest$fputmBrokerHandler(this.this$0, new BrokerHandler(this.this$0, null));     // Catch: Throwable -> L8
            this.this$0.notify();     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            Looper.loop();
            return;
        L8:
            th = move-exception;
            throw th;
        }
    }

    static final class BtDeviceChangedData {
        final String mEventSource;
        final BluetoothProfileConnectionInfo mInfo;
        final BluetoothDevice mNewDevice;
        final BluetoothDevice mPreviousDevice;

        BtDeviceChangedData(BluetoothDevice newDevice, BluetoothDevice previousDevice, BluetoothProfileConnectionInfo info, String eventSource) {
            this.mNewDevice = newDevice;
            this.mPreviousDevice = previousDevice;
            this.mInfo = info;
            this.mEventSource = eventSource;
        }

        public String toString() {
            return "BtDeviceChangedData profile=" + BluetoothProfile.getProfileName(this.mInfo.getProfile()) + ", switch device: [" + this.mPreviousDevice + "] -> [" + this.mNewDevice + "]";
        }
    }

    static final class BtDeviceInfo {
        final int mAudioSystemDevice;
        final BluetoothDevice mDevice;
        final String mEventSource;
        final boolean mIsDeviceSwitch;
        final boolean mIsLeOutput;
        final int mMusicDevice;
        final int mProfile;
        final int mState;
        final boolean mSupprNoisy;
        final int mVolume;

        BtDeviceInfo(BtDeviceChangedData d, BluetoothDevice device, int state, int audioDevice, int codec) {
            this.mDevice = device;
            this.mState = state;
            this.mProfile = d.mInfo.getProfile();
            this.mSupprNoisy = d.mInfo.isSuppressNoisyIntent();
            this.mVolume = d.mInfo.getVolume();
            this.mIsLeOutput = d.mInfo.isLeOutput();
            this.mEventSource = d.mEventSource;
            this.mAudioSystemDevice = audioDevice;
            this.mMusicDevice = 0;
            this.mIsDeviceSwitch = false;
        }

        BtDeviceInfo(BluetoothDevice device, int profile) {
            this.mDevice = device;
            this.mProfile = profile;
            this.mEventSource = "";
            this.mMusicDevice = 0;
            this.mAudioSystemDevice = 0;
            this.mState = 0;
            this.mSupprNoisy = false;
            this.mVolume = -1;
            this.mIsLeOutput = false;
            this.mIsDeviceSwitch = false;
        }

        BtDeviceInfo(BluetoothDevice device, int profile, int state, int musicDevice, int audioSystemDevice) {
            this.mDevice = device;
            this.mProfile = profile;
            this.mEventSource = "";
            this.mMusicDevice = musicDevice;
            this.mAudioSystemDevice = audioSystemDevice;
            this.mState = state;
            this.mSupprNoisy = false;
            this.mVolume = -1;
            this.mIsLeOutput = false;
            this.mIsDeviceSwitch = false;
        }

        BtDeviceInfo(BtDeviceInfo src, int state) {
            this.mDevice = src.mDevice;
            this.mState = state;
            this.mProfile = src.mProfile;
            this.mSupprNoisy = src.mSupprNoisy;
            this.mVolume = src.mVolume;
            this.mIsLeOutput = src.mIsLeOutput;
            this.mEventSource = src.mEventSource;
            this.mAudioSystemDevice = src.mAudioSystemDevice;
            this.mMusicDevice = src.mMusicDevice;
            this.mIsDeviceSwitch = false;
        }

        public boolean equals(Object o) {
            if (o != null) goto L6;
            return false;
        L6:
            if (this != o) goto L9;
            return true;
        L9:
            if ((o instanceof BtDeviceInfo) == true) goto L11;
            return false;
        L11:
            if (this.mProfile == ((BtDeviceInfo) o).mProfile) goto L13;
            return false;
        L13:
            if (this.mDevice.equals(((BtDeviceInfo) o).mDevice) == true) goto L16;
            return false;
        L16:
            return true;
        }

        public int hashCode() {
            return Objects.hash(new Object[]{Integer.valueOf(this.mProfile), this.mDevice});
        }

        public String toString() {
            return "BtDeviceInfo: device=" + this.mDevice.toString() + " state=" + this.mState + " prof=" + this.mProfile + " supprNoisy=" + this.mSupprNoisy + " volume=" + this.mVolume + " isLeOutput=" + this.mIsLeOutput + " eventSource=" + this.mEventSource + " audioSystemDevice=" + this.mAudioSystemDevice + " musicDevice=" + this.mMusicDevice + " isDeviceSwitch=" + this.mIsDeviceSwitch;
        }
    }

    static final class CommunicationDeviceInfo {
        final AttributionSource mAttributionSource;
        final IBinder mCb;
        final AudioDeviceAttributes mDevice;
        final String mEventSource;
        final boolean mIsPrivileged;
        final boolean mOn;
        final int mScoAudioMode;

        CommunicationDeviceInfo(IBinder cb, AttributionSource attributionSource, AudioDeviceAttributes device, boolean on, int scoAudioMode, String eventSource, boolean isPrivileged) {
            this.mCb = cb;
            this.mAttributionSource = attributionSource;
            this.mDevice = device;
            this.mOn = on;
            this.mScoAudioMode = scoAudioMode;
            this.mIsPrivileged = isPrivileged;
            this.mEventSource = eventSource;
        }

        public boolean equals(Object o) {
            if (o != null) goto L6;
            return false;
        L6:
            if (this != o) goto L9;
            return true;
        L9:
            if ((o instanceof CommunicationDeviceInfo) == true) goto L12;
            return false;
        L12:
            if (this.mCb.equals(((CommunicationDeviceInfo) o).mCb) == true) goto L14;
            return false;
        L14:
            if (this.mAttributionSource.equals(((CommunicationDeviceInfo) o).mAttributionSource) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return Objects.hash(new Object[]{Integer.valueOf(this.mCb.hashCode()), this.mAttributionSource});
        }

        public String toString() {
            StringBuilder r0 = new StringBuilder();
            r0.append("CommunicationDeviceInfo mCb=");
            r0.append(this.mCb.toString());
            r0.append(" mAttributionSource=");
            r0.append(this.mAttributionSource.toString());
            r0.append(" mDevice=[");
            if (this.mDevice == null) goto L5;
            String r1 = this.mDevice.toString();
        L6:
            r0.append(r1);
            r0.append("] mOn=");
            r0.append(this.mOn);
            r0.append(" mScoAudioMode=");
            r0.append(this.mScoAudioMode);
            r0.append(" mIsPrivileged=");
            r0.append(this.mIsPrivileged);
            r0.append(" mEventSource=");
            r0.append(this.mEventSource);
            return r0.toString();
        L5:
            r1 = "null";
            goto L6
        }
    }

    private class CommunicationRouteClient implements IBinder.DeathRecipient {
        private final AttributionSource mAttributionSource;
        private final IBinder mCb;
        private AudioDeviceAttributes mDevice;
        private boolean mDisabled;
        private final boolean mIsPrivileged;
        private boolean mPlaybackActive;
        private boolean mRecordingActive;
        final /* synthetic */ AudioDeviceBroker this$0;

        CommunicationRouteClient(AudioDeviceBroker r3, IBinder cb, AttributionSource attributionSource, AudioDeviceAttributes device, boolean isPrivileged) {
            this.this$0 = r3;
            this.mCb = cb;
            this.mAttributionSource = attributionSource;
            this.mDevice = device;
            this.mIsPrivileged = isPrivileged;
            this.mPlaybackActive = AudioDeviceBroker.m1921$$Nest$fgetmAudioService(r3).isPlaybackActiveForUid(attributionSource.getUid());
            this.mRecordingActive = AudioDeviceBroker.m1921$$Nest$fgetmAudioService(r3).isRecordingActiveForUid(attributionSource.getUid());
            this.mDisabled = false;
        }

        public boolean registerDeathRecipient() {
            this.mCb.linkToDeath(this, 0);     // Catch: RemoteException -> L5
            return true;
        L6:
            Log.w(AudioDeviceBroker.TAG, "CommunicationRouteClient could not link to " + this.mCb + " binder death");
            return false;
        }

        public void unregisterDeathRecipient() {
            this.mCb.unlinkToDeath(this, 0);     // Catch: NoSuchElementException -> L4
            return;
        L5:
            Log.w(AudioDeviceBroker.TAG, "CommunicationRouteClient could not unlink to " + this.mCb + " binder death");
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            this.this$0.postCommunicationRouteClientDied(this);
        }

        IBinder getBinder() {
            return this.mCb;
        }

        AttributionSource getAttributionSource() {
            return this.mAttributionSource;
        }

        int getUid() {
            return this.mAttributionSource.getUid();
        }

        boolean isPrivileged() {
            return this.mIsPrivileged;
        }

        void setDevice(AudioDeviceAttributes device) {
            this.mDevice = device;
        }

        AudioDeviceAttributes getDevice() {
            return this.mDevice;
        }

        public void setPlaybackActive(boolean active) {
            this.mPlaybackActive = active;
        }

        public void setRecordingActive(boolean active) {
            this.mRecordingActive = active;
        }

        public boolean isActive() {
            if (this.mDisabled == false) goto L5;
        L11:
            return false;
        L5:
            if (this.mIsPrivileged == false) goto L7;
        L10:
            return true;
        L7:
            if (this.mRecordingActive == true) goto L10;
            if (this.mPlaybackActive == false) goto L11;
            goto L10
        }

        public void setDisabled(boolean disabled) {
            this.mDisabled = disabled;
        }

        public boolean isDisabled() {
            return this.mDisabled;
        }

        public String toString() {
            return "[CommunicationRouteClient: mAttributionSource: " + this.mAttributionSource + " mDevice: " + this.mDevice.toString() + " mIsPrivileged: " + this.mIsPrivileged + " mPlaybackActive: " + this.mPlaybackActive + " mRecordingActive: " + this.mRecordingActive + " mDisabled: " + this.mDisabled + "]";
        }
    }

    private static final class UpdateCommRouteClientInfo {
        public final AttributionSource attributionSource;
        public final String eventSource;

        UpdateCommRouteClientInfo(AttributionSource attributionSource, String eventSource) {
            this.attributionSource = attributionSource;
            this.eventSource = eventSource;
        }
    }

    public static /* synthetic */ boolean $r8$lambda$NuuXgpWv0cQMQbxhwMmp9JIoxUs(int r0, AudioDeviceInfo r1) {
        return lambda$getCommunicationDeviceOfType$0(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$byBKOKNpI8Je1SWRlfdci7or4xA(PrintWriter r0, String r1, CommunicationRouteClient r2) {
        lambda$dump$1(r0, r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmAudioModeOwner, reason: not valid java name */
    static /* bridge */ /* synthetic */ AudioModeInfo m1920$$Nest$fgetmAudioModeOwner(AudioDeviceBroker r0) {
        return r0.mAudioModeOwner;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmAudioService, reason: not valid java name */
    static /* bridge */ /* synthetic */ AudioService m1921$$Nest$fgetmAudioService(AudioDeviceBroker r0) {
        return r0.mAudioService;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmBluetoothA2dpEnabled, reason: not valid java name */
    static /* bridge */ /* synthetic */ AtomicBoolean m1922$$Nest$fgetmBluetoothA2dpEnabled(AudioDeviceBroker r0) {
        return r0.mBluetoothA2dpEnabled;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmBluetoothA2dpSuspendedApplied, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m1923$$Nest$fgetmBluetoothA2dpSuspendedApplied(AudioDeviceBroker r0) {
        return r0.mBluetoothA2dpSuspendedApplied;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmBluetoothAudioStateLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m1924$$Nest$fgetmBluetoothAudioStateLock(AudioDeviceBroker r0) {
        return r0.mBluetoothAudioStateLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmBrokerEventWakeLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ PowerManager.WakeLock m1925$$Nest$fgetmBrokerEventWakeLock(AudioDeviceBroker r0) {
        return r0.mBrokerEventWakeLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmBtHelper, reason: not valid java name */
    static /* bridge */ /* synthetic */ BtHelper m1926$$Nest$fgetmBtHelper(AudioDeviceBroker r0) {
        return r0.mBtHelper;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmCommunicationDeviceLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m1927$$Nest$fgetmCommunicationDeviceLock(AudioDeviceBroker r0) {
        return r0.mCommunicationDeviceLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmCommunicationDeviceUpdateCount, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m1928$$Nest$fgetmCommunicationDeviceUpdateCount(AudioDeviceBroker r0) {
        return r0.mCommunicationDeviceUpdateCount;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmDeviceInventory, reason: not valid java name */
    static /* bridge */ /* synthetic */ AudioDeviceInventory m1929$$Nest$fgetmDeviceInventory(AudioDeviceBroker r0) {
        return r0.mDeviceInventory;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmDeviceStateLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m1930$$Nest$fgetmDeviceStateLock(AudioDeviceBroker r0) {
        return r0.mDeviceStateLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmScoManagedByAudio, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m1931$$Nest$fgetmScoManagedByAudio(AudioDeviceBroker r0) {
        return r0.mScoManagedByAudio;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmAudioModeOwner, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1932$$Nest$fputmAudioModeOwner(AudioDeviceBroker r0, AudioModeInfo r1) {
        r0.mAudioModeOwner = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmBrokerHandler, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1933$$Nest$fputmBrokerHandler(AudioDeviceBroker r0, BrokerHandler r1) {
        r0.mBrokerHandler = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmCommunicationDeviceUpdateCount, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1934$$Nest$fputmCommunicationDeviceUpdateCount(AudioDeviceBroker r0, int r1) {
        r0.mCommunicationDeviceUpdateCount = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$mcheckCommunicationRouteClientsDevices, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1935$$Nest$mcheckCommunicationRouteClientsDevices(AudioDeviceBroker r0) {
        r0.checkCommunicationRouteClientsDevices();
    }

    /* JADX INFO: renamed from: -$$Nest$mcheckMessagesMuteMusic, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1936$$Nest$mcheckMessagesMuteMusic(AudioDeviceBroker r0, int r1) {
        r0.checkMessagesMuteMusic(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$minitRoutingStrategyIds, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1937$$Nest$minitRoutingStrategyIds(AudioDeviceBroker r0) {
        r0.initRoutingStrategyIds();
    }

    /* JADX INFO: renamed from: -$$Nest$monCommunicationRouteClientDied, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1938$$Nest$monCommunicationRouteClientDied(AudioDeviceBroker r0, CommunicationRouteClient r1) {
        r0.onCommunicationRouteClientDied(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$monReceiveBtEvent, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1939$$Nest$monReceiveBtEvent(AudioDeviceBroker r0, Intent r1) {
        r0.onReceiveBtEvent(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$monSendBecomingNoisyIntent, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1940$$Nest$monSendBecomingNoisyIntent(AudioDeviceBroker r0) {
        r0.onSendBecomingNoisyIntent();
    }

    /* JADX INFO: renamed from: -$$Nest$monSetForceUse, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1941$$Nest$monSetForceUse(AudioDeviceBroker r0, int r1, int r2, boolean r3, String r4) {
        r0.onSetForceUse(r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: -$$Nest$monUpdateCommunicationRouteClient, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1942$$Nest$monUpdateCommunicationRouteClient(AudioDeviceBroker r0, AttributionSource r1, String r2) {
        r0.onUpdateCommunicationRouteClient(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mreapplyAudioHalBluetoothState, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1943$$Nest$mreapplyAudioHalBluetoothState(AudioDeviceBroker r0) {
        r0.reapplyAudioHalBluetoothState();
    }

    /* JADX INFO: renamed from: -$$Nest$msendMsg, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1944$$Nest$msendMsg(AudioDeviceBroker r0, int r1, int r2, int r3) {
        r0.sendMsg(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateCommunicationRoute, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1945$$Nest$mupdateCommunicationRoute(AudioDeviceBroker r0, String r1) {
        r0.updateCommunicationRoute(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetMESSAGES_MUTE_MUSIC, reason: not valid java name */
    static /* bridge */ /* synthetic */ Set m1946$$Nest$sfgetMESSAGES_MUTE_MUSIC() {
        return MESSAGES_MUTE_MUSIC;
    }

    /* JADX INFO: renamed from: -$$Nest$smisMessageHandledUnderWakelock, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m1947$$Nest$smisMessageHandledUnderWakelock(int r0) {
        return isMessageHandledUnderWakelock(r0);
    }

    static {
        sLastDeviceConnectionMsgTimeLock = new Object();
        sLastDeviceConnectMsgTime = 0;
        VALID_COMMUNICATION_DEVICE_TYPES = new int[]{2, 7, 3, 22, 1, 4, 23, 26, 11, 27, 5, 9, 19, 21};
        MESSAGES_MUTE_MUSIC = new HashSet();
        MESSAGES_MUTE_MUSIC.add(7);
        MESSAGES_MUTE_MUSIC.add(11);
        MESSAGES_MUTE_MUSIC.add(5);
    }

    boolean isScoManagedByAudio() {
        return this.mScoManagedByAudio;
    }

    AudioDeviceBroker(Context context, AudioService service, AudioSystemAdapter audioSystem) {
        this.mCommunicationStrategyId = -1;
        this.mAccessibilityStrategyId = -1;
        this.mDeviceStateLock = new Object();
        this.mBluetoothA2dpEnabled = new AtomicBoolean(false);
        this.mSetModeLock = new Object();
        this.mAudioModeOwner = new AudioModeInfo(0, 0, 0);
        this.mCommunicationDeviceLock = new Object();
        this.mCommunicationDeviceUpdateCount = 0;
        this.mBluetoothAudioStateLock = new Object();
        this.mCommDevDispatchers = new RemoteCallbackList();
        this.mCurCommunicationPortId = -1;
        this.mMusicMuted = new AtomicBoolean(false);
        this.mCommunicationRouteClients = new LinkedList();
        this.mDuplexCommunicationDevices = new HashMap(Map.of(536870912, -1610612736, 4, Integer.valueOf(AudioDevice.IN_WIRED_HEADSET), 67108864, Integer.valueOf(AudioDevice.IN_USB_HEADSET), 16, -2147483640, 32, -2147483640, 64, -2147483640));
        this.mContext = context;
        this.mAudioService = service;
        this.mBtHelper = new BtHelper(this, context);
        this.mDeviceInventory = new AudioDeviceInventory(this);
        this.mSystemServer = SystemServerAdapter.getDefaultAdapter(this.mContext);
        this.mAudioSystem = audioSystem;
        this.mScoManagedByAudio = false;
        this.mADBExt = AudioDeviceBrokerExt.get(this);
        init();
    }

    AudioDeviceBroker(Context context, AudioService service, AudioDeviceInventory mockDeviceInventory, SystemServerAdapter mockSystemServer, AudioSystemAdapter audioSystem) {
        this.mCommunicationStrategyId = -1;
        this.mAccessibilityStrategyId = -1;
        this.mDeviceStateLock = new Object();
        this.mBluetoothA2dpEnabled = new AtomicBoolean(false);
        this.mSetModeLock = new Object();
        this.mAudioModeOwner = new AudioModeInfo(0, 0, 0);
        this.mCommunicationDeviceLock = new Object();
        this.mCommunicationDeviceUpdateCount = 0;
        this.mBluetoothAudioStateLock = new Object();
        this.mCommDevDispatchers = new RemoteCallbackList();
        this.mCurCommunicationPortId = -1;
        this.mMusicMuted = new AtomicBoolean(false);
        this.mCommunicationRouteClients = new LinkedList();
        this.mDuplexCommunicationDevices = new HashMap(Map.of(536870912, -1610612736, 4, Integer.valueOf(AudioDevice.IN_WIRED_HEADSET), 67108864, Integer.valueOf(AudioDevice.IN_USB_HEADSET), 16, -2147483640, 32, -2147483640, 64, -2147483640));
        this.mContext = context;
        this.mAudioService = service;
        this.mBtHelper = new BtHelper(this, context);
        this.mDeviceInventory = mockDeviceInventory;
        this.mSystemServer = mockSystemServer;
        this.mAudioSystem = audioSystem;
        this.mScoManagedByAudio = false;
        this.mADBExt = AudioDeviceBrokerExt.get(this);
        init();
    }

    private void initRoutingStrategyIds() {
        List<AudioProductStrategy> strategies = AudioProductStrategy.getAudioProductStrategies();
        this.mCommunicationStrategyId = -1;
        this.mAccessibilityStrategyId = -1;
        Iterator<AudioProductStrategy> r2 = strategies.iterator();
    L4:
        if (r2.hasNext() == false) goto L16;
        AudioProductStrategy strategy = r2.next();
        if (this.mCommunicationStrategyId != (-1)) goto L11;
        if (strategy.getAudioAttributesForLegacyStreamType(0) == null) goto L11;
        this.mCommunicationStrategyId = strategy.getId();
    L11:
        if (this.mAccessibilityStrategyId != (-1)) goto L4;
        if (strategy.getAudioAttributesForLegacyStreamType(10) == null) goto L4;
        this.mAccessibilityStrategyId = strategy.getId();
        goto L4
    }

    private void init() {
        this.mADBExt.init_onBegin(this.mAudioService, this.mBtHelper);
        setupMessaging(this.mContext);
        initScoParams();
        initAudioHalBluetoothState();
        initRoutingStrategyIds();
        this.mPreferredCommunicationDevice = null;
        updateActiveCommunicationDevice();
        this.mSystemServer.registerUserStartedReceiver(this.mContext);
    }

    Context getContext() {
        return this.mContext;
    }

    void onSystemReady() {
        Object r0 = this.mSetModeLock;
        monitor-enter(r0);
        Object r1 = this.mDeviceStateLock;     // Catch: Throwable -> L10
        monitor-enter(r1);     // Catch: Throwable -> L10
        this.mAudioModeOwner = this.mAudioService.getAudioModeOwner();     // Catch: Throwable -> L12
        this.mBtHelper.onSystemReady();     // Catch: Throwable -> L12
        monitor-exit(r1);     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L12:
        th = move-exception;
        throw th;     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    void onAudioServerDied() {
        sendMsgNoDelay(1, 0);
    }

    void setForceUse_Async(int useCase, int config, String eventSource) {
        sendIILMsgNoDelay(4, 2, useCase, config, eventSource);
    }

    void toggleHdmiIfConnected_Async() {
        sendMsgNoDelay(6, 2);
    }

    private void onReceiveBtEvent(Intent intent) {
        this.mBtHelper.onReceiveBtEvent(intent);
    }

    void onSetBtScoActiveDevice(BluetoothDevice btDevice, boolean deviceSwitch) {
        this.mBtHelper.onSetBtScoActiveDevice(btDevice, deviceSwitch);
    }

    void setBluetoothA2dpOn_Async(boolean on, String source) {
        boolean wasOn = this.mBluetoothA2dpEnabled.getAndSet(on);
        if (wasOn != on) goto L5;
        int r1 = 60;
    L6:
        sendLMsgNoDelay(r1, 0, source);
        return;
    L5:
        r1 = 5;
        goto L6
    }

    void setSpeakerphoneOn(IBinder cb, AttributionSource attributionSource, boolean on, boolean isPrivileged, String eventSource) {
        Log.v(TAG, "setSpeakerphoneOn, on: " + on + " uid: " + attributionSource.getUid());
        postSetCommunicationDeviceForClient(new CommunicationDeviceInfo(cb, attributionSource, new AudioDeviceAttributes(2, ""), on, -1, eventSource, isPrivileged));
    }

    boolean setCommunicationDevice(IBinder cb, AttributionSource attributionSource, AudioDeviceInfo device, boolean isPrivileged, String eventSource) {
        Log.v(TAG, "setCommunicationDevice, device: " + device + ", uid: " + attributionSource.getUid());
        if (device != null) goto L17;
        Object r2 = this.mDeviceStateLock;
        monitor-enter(r2);
        CommunicationRouteClient client = getCommunicationRouteClientForUid(attributionSource.getUid());     // Catch: Throwable -> L10
        if (client != null) goto L13;
        monitor-exit(r2);     // Catch: Throwable -> L10
        return false;
    L13:
        monitor-exit(r2);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    L17:
        Object r3 = this.mCommunicationDeviceLock;
        monitor-enter(r3);
        this.mCommunicationDeviceUpdateCount++;     // Catch: Throwable -> L22
        if (device == null) goto L24;
        AudioDeviceAttributes r4 = new AudioDeviceAttributes(device);     // Catch: Throwable -> L22
    L25:
        AudioDeviceAttributes deviceAttr = r4;
        if (device == null) goto L28;
        boolean r9 = true;
    L29:
        CommunicationDeviceInfo deviceInfo = new CommunicationDeviceInfo(cb, attributionSource, deviceAttr, r9, -1, eventSource, isPrivileged);     // Catch: Throwable -> L22
        postSetCommunicationDeviceForClient(deviceInfo);     // Catch: Throwable -> L22
        monitor-exit(r3);     // Catch: Throwable -> L22
        return true;
    L28:
        r9 = false;
        goto L29
    L24:
        r4 = null;
    L22:
        th = move-exception;
        throw th;
    }

    void onSetCommunicationDeviceForClient(CommunicationDeviceInfo deviceInfo) {
        Log.v(TAG, "onSetCommunicationDeviceForClient: " + deviceInfo);
        if (deviceInfo.mOn == true) goto L12;
        CommunicationRouteClient client = getCommunicationRouteClientForUid(deviceInfo.mAttributionSource.getUid());
        if (client != null) goto L7;
        return;
    L7:
        if (deviceInfo.mDevice == null) goto L12;
        if (deviceInfo.mDevice.equals(client.getDevice()) == true) goto L12;
        return;
    L12:
        if (deviceInfo.mOn == false) goto L14;
        AudioDeviceAttributes r0 = deviceInfo.mDevice;
    L15:
        AudioDeviceAttributes device = r0;
        setCommunicationRouteForClient(deviceInfo.mCb, deviceInfo.mAttributionSource, device, deviceInfo.mScoAudioMode, deviceInfo.mIsPrivileged, deviceInfo.mEventSource);
        return;
    L14:
        r0 = null;
        goto L15
    }

    private boolean shouldStartScoForAttributionSource(AttributionSource attributionSource) {
        if (attributionSource != null) goto L5;
        return true;
    L5:
        int uid = attributionSource.getUid();
        if (UserHandle.isSameApp(uid, 1002) == false) goto L8;
    L14:
        return false;
    L8:
        if (UserHandle.isSameApp(uid, 1001) == true) goto L14;
        if (UserHandle.isSameApp(uid, 1000) == true) goto L12;
        return true;
    L12:
        if ("com.android.server.telecom".equals(attributionSource.getPackageName()) == true) goto L14;
        return true;
    }

    void setCommunicationRouteForClient(IBinder cb, AttributionSource attributionSource, AudioDeviceAttributes device, int scoAudioMode, boolean isPrivileged, String eventSource) {
        long startTimeMs = System.currentTimeMillis();
        Log.v(TAG, "setCommunicationRouteForClient: device: " + device + ", eventSource: " + eventSource);
        AudioService.sDeviceLogger.enqueue(new EventLogger.StringEvent("setCommunicationRouteForClient for uid: " + attributionSource.getUid() + " device: " + device + " isPrivileged: " + isPrivileged + " from API: " + eventSource).printLog(TAG));
        AttributionSource previousBtScoRequesterAS = bluetoothScoRequestOwnerAttributionSource();
        AudioDeviceAttributes prevClientDevice = null;
        boolean prevPrivileged = false;
        CommunicationRouteClient client = getCommunicationRouteClientForUid(attributionSource.getUid());
        if (client == null) goto L5;
        prevClientDevice = client.getDevice();
        prevPrivileged = client.isPrivileged();
    L5:
        if (device == null) goto L9;
        CommunicationRouteClient client2 = addCommunicationRouteClient(cb, attributionSource, device, isPrivileged);
        if (client2 != null) goto L10;
        Log.w(TAG, "setCommunicationRouteForClient: could not add client for uid: " + attributionSource.getUid() + " and device: " + device);
    L10:
        if (client2 != null) goto L12;
        return;
    L12:
        AttributionSource btScoRequesterAS = bluetoothScoRequestOwnerAttributionSource();
        if (btScoRequesterAS == null) goto L15;
        boolean isBtScoRequested = true;
    L16:
        if (previousBtScoRequesterAS == null) goto L18;
        boolean wasBtScoRequested = true;
    L20:
        if (this.mScoManagedByAudio == true) goto L22;
        if (isBtScoRequested == false) goto L65;
        if (wasBtScoRequested == false) goto L58;
        if (isBluetoothScoActive() == false) goto L58;
        if (this.mBtHelper.isBluetoothScoRequestedInternally() == false) goto L58;
        int newDeviceType = 0;
    L66:
        if (isBtScoRequested == true) goto L69;
        if (wasBtScoRequested == false) goto L69;
        this.mBtHelper.stopBluetoothSco(eventSource);
    L69:
        this.mAudioService.postUpdateContextualVolumes();
        updateCommunicationRoute(eventSource);
        if (prevClientDevice == null) goto L72;
        int oldDeviceType = prevClientDevice.getInternalType();
    L73:
        if (device == null) goto L75;
        int deviceType = device.getInternalType();
    L76:
        CommunicationRouteClient newClient = getCommunicationRouteClientForUid(attributionSource.getUid());
        if (newClient == null) goto L79;
        AudioDeviceAttributes newDevice = newClient.getDevice();
    L80:
        if (newDevice == null) goto L83;
        newDeviceType = newDevice.getInternalType();
    L83:
        new MediaMetrics.Item("audio.device.setCommunicationRouteForClient").setUid(attributionSource.getUid()).set(MediaMetrics.Property.EVENT, eventSource).set(MediaMetrics.Property.START_TIME_MS, Long.valueOf(startTimeMs)).set(MediaMetrics.Property.REQUESTED_DEVICE, Integer.valueOf(deviceType)).set(MediaMetrics.Property.OLD_DEVICE, Integer.valueOf(oldDeviceType)).set(MediaMetrics.Property.NEW_DEVICE, Integer.valueOf(newDeviceType)).set(MediaMetrics.Property.MODE, AudioSystem.modeToString(this.mAudioModeOwner.mMode)).set(MediaMetrics.Property.MODE_OWNER_UID, Integer.valueOf(this.mAudioModeOwner.mUid)).record();
        return;
    L79:
        newDevice = null;
        goto L80
    L75:
        deviceType = newDeviceType;
        goto L76
    L72:
        oldDeviceType = newDeviceType;
    L58:
        if (this.mBtHelper.startBluetoothSco(scoAudioMode, eventSource) == true) goto L64;
        Log.w(TAG, "setCommunicationRouteForClient: failure to start BT SCO for uid: " + attributionSource.getUid());
        if (prevClientDevice == null) goto L62;
        addCommunicationRouteClient(cb, attributionSource, prevClientDevice, prevPrivileged);
    L63:
        newDeviceType = 0;
        postBroadcastScoConnectionState(0);
        goto L69
    L62:
        removeCommunicationRouteClient(cb, true);
        goto L63
    L64:
        newDeviceType = 0;
        goto L69
    L65:
        newDeviceType = 0;
        goto L66
    L22:
        if (isBtScoRequested == false) goto L43;
        if (wasBtScoRequested == false) goto L29;
        if (isBluetoothScoActive() == false) goto L29;
        if (this.mBtHelper.isBluetoothScoRequestedInternally() == true) goto L43;
    L29:
        if (shouldStartScoForAttributionSource(btScoRequesterAS) == false) goto L39;
        boolean scoStarted = this.mBtHelper.startBluetoothSco(scoAudioMode, eventSource);
        if (scoStarted == true) goto L38;
        Log.w(TAG, "setCommunicationRouteForClient: failure to start BT SCO for uid: " + attributionSource.getUid());
        if (prevClientDevice == null) goto L35;
        addCommunicationRouteClient(cb, attributionSource, prevClientDevice, prevPrivileged);
    L36:
        postBroadcastScoConnectionState(0);
        goto L38
    L35:
        removeCommunicationRouteClient(cb, true);
    L38:
        boolean scoStarted2 = scoStarted;
    L40:
        if (scoStarted2 == false) goto L42;
        setBluetoothScoOn(true, "setCommunicationRouteForClient");
    L42:
        newDeviceType = 0;
        goto L69
    L39:
        scoStarted2 = true;
    L43:
        if (isBtScoRequested == true) goto L42;
        if (wasBtScoRequested == false) goto L42;
        if (shouldStartScoForAttributionSource(previousBtScoRequesterAS) == false) goto L48;
        this.mBtHelper.stopBluetoothSco(eventSource);
    L48:
        newDeviceType = 0;
        setBluetoothScoOn(false, "setCommunicationRouteForClient");
        goto L69
    L18:
        wasBtScoRequested = false;
        goto L20
    L15:
        isBtScoRequested = false;
        goto L16
    L9:
        client2 = removeCommunicationRouteClient(cb, true);
        goto L10
    }

    private CommunicationRouteClient topCommunicationRouteClient() {
        Iterator<CommunicationRouteClient> r0 = this.mCommunicationRouteClients.iterator();
    L4:
        if (r0.hasNext() == false) goto L12;
        CommunicationRouteClient crc = r0.next();
        if (crc.getUid() != this.mAudioModeOwner.mUid) goto L4;
        if (crc.isDisabled() == true) goto L4;
        return crc;
    L12:
        if (this.mCommunicationRouteClients.isEmpty() == false) goto L14;
        return null;
    L14:
        if (this.mAudioModeOwner.mPid == 0) goto L16;
        return null;
    L16:
        if (this.mCommunicationRouteClients.get(0).isActive() == true) goto L18;
        return null;
    L18:
        return this.mCommunicationRouteClients.get(0);
    }

    private AudioDeviceAttributes requestedCommunicationDevice() {
        CommunicationRouteClient crc = topCommunicationRouteClient();
        if (crc == null) goto L5;
        AudioDeviceAttributes device = crc.getDevice();
    L6:
        Log.v(TAG, "requestedCommunicationDevice: " + device + " mAudioModeOwner: " + this.mAudioModeOwner.toString());
        return device;
    L5:
        device = null;
        goto L6
    }

    static boolean isValidCommunicationDevice(AudioDeviceInfo device) {
        device.getClass();
        if (device.isSink() == true) goto L5;
    L7:
        return false;
    L5:
        if (isValidCommunicationDeviceType(device.getType()) == false) goto L7;
        return true;
    }

    private static boolean isValidCommunicationDeviceType(int deviceType) {
        int[] r0 = VALID_COMMUNICATION_DEVICE_TYPES;
        int r1 = r0.length;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L9;
        int type = r0[r3];
        if (deviceType == type) goto L6;
        r3 = r3 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    void postCheckCommunicationRouteClientState(int r8, boolean r9, int r10) {
        CommunicationRouteClient r5 = getCommunicationRouteClientForUid(r8);
        if (r5 == null) goto L6;
        sendMsgForCheckClientState(56, 0, r8, r9 ? 1 : 0, r5, r10);
        return;
    }

    void onCheckCommunicationRouteClientState(int uid, boolean wasActive) {
        CommunicationRouteClient client = getCommunicationRouteClientForUid(uid);
        if (client != null) goto L5;
        return;
    L5:
        updateCommunicationRouteClientState(client, wasActive);
    }

    void updateCommunicationRouteClientState(CommunicationRouteClient client, boolean wasActive) {
        client.setPlaybackActive(this.mAudioService.isPlaybackActiveForUid(client.getUid()));
        client.setRecordingActive(this.mAudioService.isRecordingActiveForUid(client.getUid()));
        if (wasActive == client.isActive()) goto L9;
        if (wasActive == false) goto L6;
        AttributionSource r0 = client.getAttributionSource();
    L7:
        postUpdateCommunicationRouteClient(r0, "updateCommunicationRouteClientState");
        return;
    L6:
        r0 = null;
        goto L7
    }

    void setForceCommunicationClientStateAndDelayedCheck(CommunicationRouteClient client, boolean forcePlaybackActive, boolean forceRecordingActive) {
        if (client != null) goto L5;
        return;
    L5:
        if (forcePlaybackActive == false) goto L7;
        client.setPlaybackActive(true);
    L7:
        if (forceRecordingActive == false) goto L9;
        client.setRecordingActive(true);
    L9:
        postCheckCommunicationRouteClientState(client.getUid(), client.isActive(), 6000);
    }

    static List<AudioDeviceInfo> getAvailableCommunicationDevices() {
        ArrayList<AudioDeviceInfo> commDevices = new ArrayList();
        AudioDeviceInfo[] allDevices = AudioManager.getDevicesStatic(2);
        int r2 = allDevices.length;
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L8;
        AudioDeviceInfo device = allDevices[r3];
        if (isValidCommunicationDevice(device) == false) goto L7;
        commDevices.add(device);
    L7:
        r3 = r3 + 1;
        goto L3
    L8:
        return commDevices;
    }

    private AudioDeviceInfo getCommunicationDeviceOfType(final int type) {
        return getAvailableCommunicationDevices().stream().filter(new AudioDeviceBroker$$ExternalSyntheticLambda1(type)).findFirst().orElse(null);
    }

    private static /* synthetic */ boolean lambda$getCommunicationDeviceOfType$0(int type, AudioDeviceInfo d) {
        if (d.getType() != type) goto L5;
        return true;
    L5:
        return false;
    }

    AudioDeviceInfo getCommunicationDevice() {
        Object r0 = this.mCommunicationDeviceLock;
        monitor-enter(r0);
        long start = System.currentTimeMillis();     // Catch: Throwable -> L10
        long elapsed = 0;
    L6:
        if (this.mCommunicationDeviceUpdateCount <= 0) goto L17;
        this.mCommunicationDeviceLock.wait(3000 - elapsed);     // Catch: Throwable -> L10 InterruptedException -> L12
    L14:
        elapsed = System.currentTimeMillis() - start;     // Catch: Throwable -> L10
        if (elapsed < 3000) goto L6;
        Log.e(TAG, "Timeout waiting for communication device update.");     // Catch: Throwable -> L10
        this.mCommunicationDeviceUpdateCount = 0;     // Catch: Throwable -> L10
        goto L17
    L13:
        Log.w(TAG, "Interrupted while waiting for communication device update.");     // Catch: Throwable -> L10
    L17:
        monitor-exit(r0);     // Catch: Throwable -> L10
        Object r1 = this.mDeviceStateLock;
        monitor-enter(r1);
        AudioDeviceInfo r2 = getCommunicationDeviceInt();     // Catch: Throwable -> L23
        monitor-exit(r1);     // Catch: Throwable -> L23
        return r2;
    L23:
        th = move-exception;
        throw th;
    L10:
        th = move-exception;
        throw th;
    }

    private AudioDeviceInfo getCommunicationDeviceInt() {
        updateActiveCommunicationDevice();
        AudioDeviceInfo device = this.mActiveCommunicationDevice;
        if (device != null) goto L5;
    L7:
        if (device != null) goto L9;
    L10:
        AudioDeviceInfo device2 = getCommunicationDeviceOfType(1);
        if (device2 != null) goto L17;
        List<AudioDeviceInfo> commDevices = getAvailableCommunicationDevices();
        if (commDevices.isEmpty() == false) goto L15;
        return device2;
    L15:
        return commDevices.get(0);
    L17:
        return device2;
    L9:
        if (isValidCommunicationDevice(device) == false) goto L10;
        return device;
    L5:
        if (device.getType() != 13) goto L7;
        device = getCommunicationDeviceOfType(2);
        goto L7
    }

    void updateActiveCommunicationDevice() {
        AudioDeviceAttributes device = preferredCommunicationDevice();
        if (device != null) goto L12;
        AudioAttributes attr = AudioProductStrategy.getAudioAttributesForStrategyWithLegacyStreamType(0);
        List<AudioDeviceAttributes> devices = this.mAudioSystem.getDevicesForAttributes(attr, false);
        if (devices.isEmpty() == true) goto L7;
        device = devices.get(0);
        goto L12
    L7:
        if (this.mAudioService.isPlatformVoice() == false) goto L9;
        Log.w(TAG, "updateActiveCommunicationDevice(): no device for phone strategy");
    L9:
        this.mActiveCommunicationDevice = null;
        return;
    L12:
        this.mActiveCommunicationDevice = AudioManager.getDeviceInfoFromTypeAndAddress(device.getType(), device.getAddress());
        this.mADBExt.updateActiveCommunicationDevice_onEnd();
    }

    private boolean isDeviceRequestedForCommunication(int deviceType) {
        Object r0 = this.mDeviceStateLock;
        monitor-enter(r0);
        AudioDeviceAttributes device = requestedCommunicationDevice();     // Catch: Throwable -> L9
        if (device != null) goto L7;
    L11:
        boolean r2 = false;
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r2;
    L7:
        if (device.getType() != deviceType) goto L11;
        r2 = true;
    L9:
        th = move-exception;
        throw th;
    }

    private boolean isDeviceOnForCommunication(int deviceType) {
        Object r0 = this.mDeviceStateLock;
        monitor-enter(r0);
        AudioDeviceAttributes device = preferredCommunicationDevice();     // Catch: Throwable -> L9
        if (device != null) goto L7;
    L11:
        boolean r2 = false;
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r2;
    L7:
        if (device.getType() != deviceType) goto L11;
        r2 = true;
    L9:
        th = move-exception;
        throw th;
    }

    private boolean isDeviceActiveForCommunication(int deviceType) {
        if (this.mActiveCommunicationDevice != null) goto L5;
    L11:
        return false;
    L5:
        if (this.mActiveCommunicationDevice.getType() != deviceType) goto L11;
        if (this.mPreferredCommunicationDevice == null) goto L11;
        if (this.mPreferredCommunicationDevice.getType() != deviceType) goto L11;
        return true;
    }

    boolean isSpeakerphoneOn() {
        return isDeviceOnForCommunication(2);
    }

    private boolean isSpeakerphoneActive() {
        return isDeviceActiveForCommunication(2);
    }

    boolean isBluetoothScoRequested() {
        return isDeviceRequestedForCommunication(7);
    }

    AttributionSource bluetoothScoRequestOwnerAttributionSource() {
        if (isBluetoothScoRequested() == true) goto L5;
        return null;
    L5:
        CommunicationRouteClient crc = topCommunicationRouteClient();
        if (crc != null) goto L9;
        return null;
    L9:
        return crc.getAttributionSource();
    }

    private static int safeUidFromAttributionSource(AttributionSource attributionSource) {
        if (attributionSource != null) goto L6;
        return -1;
    L6:
        return attributionSource.getUid();
    }

    boolean isBluetoothLeAudioRequested() {
        if (isDeviceRequestedForCommunication(26) == false) goto L5;
    L8:
        return true;
    L5:
        if (isDeviceRequestedForCommunication(27) == true) goto L8;
        return false;
    }

    boolean isBluetoothScoOn() {
        boolean mVoipLeaWarEnabled = SystemProperties.getBoolean("persist.enable.bluetooth.voipleawar", false);
        if (isDeviceOnForCommunication(7) == true) goto L13;
        if (mVoipLeaWarEnabled == true) goto L6;
        return false;
    L6:
        if (isBluetoothScoRequested() == true) goto L8;
        return false;
    L8:
        if (this.mActiveCommunicationDevice != null) goto L10;
        return false;
    L10:
        if (this.mActiveCommunicationDevice.getType() == 26) goto L13;
        return false;
    L13:
        return true;
    }

    private boolean isBluetoothScoActive() {
        return isDeviceActiveForCommunication(7);
    }

    private boolean isBluetoothBleHeadsetActive() {
        return isDeviceActiveForCommunication(26);
    }

    private boolean isBluetoothBleSpeakerActive() {
        return isDeviceActiveForCommunication(27);
    }

    boolean isDeviceConnected(AudioDeviceAttributes device) {
        Object r0 = this.mDeviceStateLock;
        monitor-enter(r0);
        boolean r1 = this.mDeviceInventory.isDeviceConnected(device);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    void setWiredDeviceConnectionState(AudioDeviceAttributes attributes, int state, String caller) {
        Object r0 = this.mDeviceStateLock;
        monitor-enter(r0);
        this.mDeviceInventory.setWiredDeviceConnectionState(attributes, state, caller);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    void setTestDeviceConnectionState(AudioDeviceAttributes device, int state) {
        Object r0 = this.mDeviceStateLock;
        monitor-enter(r0);
        this.mDeviceInventory.setTestDeviceConnectionState(device, state);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    static BtDeviceInfo createBtDeviceInfo(BtDeviceChangedData d, BluetoothDevice device, int state) {
        int audioDevice = BtHelper.getTypeFromProfile(d.mInfo.getProfile(), d.mInfo.isLeOutput());
        return new BtDeviceInfo(d, device, state, audioDevice, 0);
    }

    private void btMediaMetricRecord(BluetoothDevice device, String state, BtDeviceChangedData data) {
        String name = TextUtils.emptyIfNull(device.getName());
        new MediaMetrics.Item("audio.device.queueOnBluetoothActiveDeviceChanged").set(MediaMetrics.Property.STATE, state).set(MediaMetrics.Property.STATUS, Integer.valueOf(data.mInfo.getProfile())).set(MediaMetrics.Property.NAME, name).record();
    }

    void queueOnBluetoothActiveDeviceChanged(BtDeviceChangedData data) {
        if (data.mPreviousDevice != null) goto L5;
    L14:
        Object r0 = this.mDeviceStateLock;
        monitor-enter(r0);
    L19:
        th = move-exception;
        throw th;
    L17:
        if (data.mPreviousDevice == null) goto L22;
        btMediaMetricRecord(data.mPreviousDevice, "disconnected", data);     // Catch: Throwable -> L19
        sendLMsgNoDelay(45, 2, createBtDeviceInfo(data, data.mPreviousDevice, 0));     // Catch: Throwable -> L19
    L22:
        if (data.mNewDevice == null) goto L24;
        btMediaMetricRecord(data.mNewDevice, "connected", data);     // Catch: Throwable -> L19
        sendLMsgNoDelay(45, 2, createBtDeviceInfo(data, data.mNewDevice, 2));     // Catch: Throwable -> L19
    L24:
        monitor-exit(r0);     // Catch: Throwable -> L19
        return;
    L5:
        if (data.mPreviousDevice.equals(data.mNewDevice) == false) goto L14;
        String name = TextUtils.emptyIfNull(data.mNewDevice.getName());
        new MediaMetrics.Item("audio.device.queueOnBluetoothActiveDeviceChanged_update").set(MediaMetrics.Property.NAME, name).set(MediaMetrics.Property.STATUS, Integer.valueOf(data.mInfo.getProfile())).record();
        Object r2 = this.mDeviceStateLock;
        monitor-enter(r2);
        postBluetoothDeviceConfigChange(createBtDeviceInfo(data, data.mNewDevice, 2));     // Catch: Throwable -> L11
        monitor-exit(r2);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    private void initAudioHalBluetoothState() {
        Object r0 = this.mBluetoothAudioStateLock;
        monitor-enter(r0);
        this.mBluetoothScoOnApplied = false;     // Catch: Throwable -> L8
        this.mBluetoothA2dpSuspendedApplied = false;     // Catch: Throwable -> L8
        this.mBluetoothLeSuspendedApplied = false;     // Catch: Throwable -> L8
        reapplyAudioHalBluetoothState();     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private void initScoParams() {
        Object r0 = this.mBluetoothAudioStateLock;
        monitor-enter(r0);
        this.mHasSwbLc3Enabled = false;     // Catch: Throwable -> L8
        this.mHasSwbAptXEnabled = false;     // Catch: Throwable -> L8
        this.mBtHeadsetName = "";     // Catch: Throwable -> L8
        this.mHasNrecEnabled = false;     // Catch: Throwable -> L8
        this.mHasWbsEnabled = false;     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    void setSwbParameters(String keyValuePairs) {
        Object r0 = this.mBluetoothAudioStateLock;
        monitor-enter(r0);
        Log.i(TAG, "received " + keyValuePairs);     // Catch: Throwable -> L14
        String[] kvpairs = keyValuePairs.split(";");     // Catch: Throwable -> L14
        int r2 = kvpairs.length;     // Catch: Throwable -> L14
        int r4 = 0;
    L6:
        if (r4 >= r2) goto L24;
        String pair = kvpairs[r4];     // Catch: Throwable -> L14
        String[] kv = pair.split("=");     // Catch: Throwable -> L14
        boolean r8 = true;
        if (kv[0].equals("bt_lc3_swb") == false) goto L17;
        if (kv[1].equals("on") == true) goto L13;
        r8 = false;
    L13:
        this.mHasSwbLc3Enabled = r8;     // Catch: Throwable -> L14
    L23:
        r4 = r4 + 1;     // Catch: Throwable -> L14
        goto L6
    L17:
        if (kv[0].equals("bt_swb") == false) goto L23;
        if (kv[1].equals("0") == true) goto L22;
        r8 = false;
    L22:
        this.mHasSwbAptXEnabled = r8;     // Catch: Throwable -> L14
        goto L23
    L24:
        monitor-exit(r0);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        throw th;
    }

    void setScoParameters(String name, boolean hasNrecEnabled, boolean hasWbsEnabled) {
        Object r0 = this.mBluetoothAudioStateLock;
        monitor-enter(r0);
        Log.i(TAG, "received btHeadsetName=" + name + ";hasNrecEnabled=" + hasNrecEnabled + ";hasWbsEnabled=" + hasWbsEnabled + ";");     // Catch: Throwable -> L7
        this.mBtHeadsetName = name;     // Catch: Throwable -> L7
        this.mHasNrecEnabled = hasNrecEnabled;     // Catch: Throwable -> L7
        this.mHasWbsEnabled = hasWbsEnabled;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void updateAudioHalBluetoothState() {
        boolean r5 = false;
        if (this.mBluetoothScoOn == this.mBluetoothScoOnApplied) goto L42;
        Log.v(TAG, "updateAudioHalBluetoothState() mBluetoothScoOn: " + this.mBluetoothScoOn + ", mBluetoothScoOnApplied: " + this.mBluetoothScoOnApplied);
        if (this.mBluetoothScoOn == true) goto L7;
        AudioSystem.setParameters("BT_SCO=off");
    L40:
        this.mBluetoothScoOnApplied = this.mBluetoothScoOn;
        goto L42
    L7:
        if (this.mBluetoothA2dpSuspendedApplied == true) goto L9;
        AudioSystem.setParameters("A2dpSuspended=true");
        this.mBluetoothA2dpSuspendedApplied = true;
    L9:
        boolean mVoipLeaWarEnabled = SystemProperties.getBoolean("persist.enable.bluetooth.voipleawar", false);
        if (mVoipLeaWarEnabled == true) goto L12;
    L14:
        boolean isLeVoIPOngoing = false;
    L15:
        if (isLeVoIPOngoing == false) goto L18;
        Log.v(TAG, "skip set LeAudioSuspended to true when LEA VoIP was ongoing");
    L20:
        StringBuilder r7 = new StringBuilder();
        r7.append("bt_lc3_swb=");
        String r9 = "off";
        if (this.mHasSwbLc3Enabled == false) goto L23;
        String r8 = "on";
    L24:
        r7.append(r8);
        AudioSystem.setParameters(r7.toString());
        StringBuilder r10 = new StringBuilder();
        r10.append("bt_swb=");
        if (this.mHasSwbAptXEnabled == false) goto L27;
        String r11 = "0";
    L28:
        r10.append(r11);
        AudioSystem.setParameters(r10.toString());
        StringBuilder r12 = new StringBuilder();
        r12.append("bt_headset_name=");
        r12.append(this.mBtHeadsetName);
        r12.append(";bt_headset_nrec=");
        if (this.mHasNrecEnabled == false) goto L31;
        String r13 = "on";
    L32:
        r12.append(r13);
        r12.append(";bt_wbs=");
        if (this.mHasWbsEnabled == false) goto L35;
        r9 = "on";
    L35:
        r12.append(r9);
        AudioSystem.setParameters(r12.toString());
        if (isLeVoIPOngoing == true) goto L40;
        AudioSystem.setParameters("BT_SCO=on");
        goto L40
    L31:
        r13 = "off";
        goto L32
    L27:
        r11 = "65535";
        goto L28
    L23:
        r8 = "off";
        goto L24
    L18:
        if (this.mBluetoothLeSuspendedApplied == true) goto L20;
        AudioSystem.setParameters("LeAudioSuspended=true");
        this.mBluetoothLeSuspendedApplied = true;
        goto L20
    L12:
        if (this.mBtHelper.isAudioConnected() == true) goto L14;
        isLeVoIPOngoing = true;
    L42:
        if (this.mBluetoothScoOnApplied == false) goto L44;
        return;
    L44:
        if (this.mBluetoothA2dpSuspendedExt == false) goto L46;
    L49:
        boolean r0 = true;
    L51:
        if (r0 == this.mBluetoothA2dpSuspendedApplied) goto L64;
        Log.v(TAG, "updateAudioHalBluetoothState() mBluetoothA2dpSuspendedExt: " + this.mBluetoothA2dpSuspendedExt + ", mBluetoothA2dpSuspendedInt: " + this.mBluetoothA2dpSuspendedInt + ", mBluetoothA2dpSuspendedApplied: " + this.mBluetoothA2dpSuspendedApplied);
        if (this.mBluetoothA2dpSuspendedExt == false) goto L55;
    L58:
        boolean r1 = true;
    L59:
        this.mBluetoothA2dpSuspendedApplied = r1;
        if (this.mBluetoothA2dpSuspendedApplied == false) goto L62;
        AudioSystem.setParameters("A2dpSuspended=true");
        goto L64
    L62:
        AudioSystem.setParameters("A2dpSuspended=false");
        goto L64
    L55:
        if (this.mBluetoothA2dpSuspendedInt == true) goto L58;
        r1 = false;
    L64:
        if (this.mBluetoothLeSuspendedExt == false) goto L66;
    L69:
        boolean r2 = true;
    L71:
        if (r2 == this.mBluetoothLeSuspendedApplied) goto L83;
        Log.v(TAG, "updateAudioHalBluetoothState() mBluetoothLeSuspendedExt: " + this.mBluetoothLeSuspendedExt + ", mBluetoothLeSuspendedInt: " + this.mBluetoothLeSuspendedInt + ", mBluetoothLeSuspendedApplied: " + this.mBluetoothLeSuspendedApplied);
        if (this.mBluetoothLeSuspendedExt == false) goto L75;
    L76:
        r5 = true;
    L77:
        this.mBluetoothLeSuspendedApplied = r5;
        if (this.mBluetoothLeSuspendedApplied == false) goto L80;
        AudioSystem.setParameters("LeAudioSuspended=true");
        return;
    L80:
        AudioSystem.setParameters("LeAudioSuspended=false");
        return;
    L75:
        if (this.mBluetoothLeSuspendedInt == false) goto L77;
    L83:
        return;
    L66:
        if (this.mBluetoothLeSuspendedInt == true) goto L69;
        r2 = false;
        goto L71
    L46:
        if (this.mBluetoothA2dpSuspendedInt == true) goto L49;
        r0 = false;
        goto L51
    }

    private void reapplyAudioHalBluetoothState() {
        Log.v(TAG, "reapplyAudioHalBluetoothState() mBluetoothScoOnApplied: " + this.mBluetoothScoOnApplied + ", mBluetoothA2dpSuspendedApplied: " + this.mBluetoothA2dpSuspendedApplied + ", mBluetoothLeSuspendedApplied: " + this.mBluetoothLeSuspendedApplied);
        if (this.mBluetoothScoOnApplied == false) goto L20;
        AudioSystem.setParameters("A2dpSuspended=true");
        AudioSystem.setParameters("LeAudioSuspended=true");
        StringBuilder r0 = new StringBuilder();
        r0.append("bt_lc3_swb=");
        String r2 = "off";
        if (this.mHasSwbLc3Enabled == false) goto L7;
        String r1 = "on";
    L8:
        r0.append(r1);
        AudioSystem.setParameters(r0.toString());
        StringBuilder r3 = new StringBuilder();
        r3.append("bt_swb=");
        if (this.mHasSwbAptXEnabled == false) goto L11;
        String r4 = "0";
    L12:
        r3.append(r4);
        AudioSystem.setParameters(r3.toString());
        StringBuilder r5 = new StringBuilder();
        r5.append("bt_headset_name=");
        r5.append(this.mBtHeadsetName);
        r5.append(";bt_headset_nrec=");
        if (this.mHasNrecEnabled == false) goto L15;
        String r6 = "on";
    L16:
        r5.append(r6);
        r5.append(";bt_wbs=");
        if (this.mHasWbsEnabled == false) goto L19;
        r2 = "on";
    L19:
        r5.append(r2);
        AudioSystem.setParameters(r5.toString());
        AudioSystem.setParameters("BT_SCO=on");
        this.mBluetoothA2dpSuspendedApplied = true;
        this.mBluetoothLeSuspendedApplied = true;
        return;
    L15:
        r6 = "off";
        goto L16
    L11:
        r4 = "65535";
        goto L12
    L7:
        r1 = "off";
        goto L8
    L20:
        AudioSystem.setParameters("BT_SCO=off");
        if (this.mBluetoothA2dpSuspendedApplied == false) goto L23;
        AudioSystem.setParameters("A2dpSuspended=true");
    L25:
        if (this.mBluetoothLeSuspendedApplied == false) goto L27;
        AudioSystem.setParameters("LeAudioSuspended=true");
        return;
    L27:
        AudioSystem.setParameters("LeAudioSuspended=false");
        return;
    L23:
        AudioSystem.setParameters("A2dpSuspended=false");
        goto L25
    }

    public void setBluetoothScoOnExternal(boolean on, String eventSource) {
        Object r0 = this.mDeviceStateLock;
        monitor-enter(r0);
        Log.d(TAG, "setBluetoothScoOnExternal begin");     // Catch: Throwable -> L7
        setBluetoothScoOn(on, eventSource);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    void setBluetoothScoOn(boolean on, String eventSource) {
        boolean mVoipLeaWarEnabled = SystemProperties.getBoolean("persist.enable.bluetooth.voipleawar", false);
        Object r1 = this.mBluetoothAudioStateLock;
        monitor-enter(r1);
        AttributionSource btScoRequesterAS = bluetoothScoRequestOwnerAttributionSource();     // Catch: Throwable -> L10
        Log.i(TAG, "setBluetoothScoOn: " + on + ", mBluetoothScoOn: " + this.mBluetoothScoOn + ", btScoRequesterUId: " + safeUidFromAttributionSource(btScoRequesterAS) + ", from: " + eventSource);     // Catch: Throwable -> L10
        this.mBluetoothScoOn = on;     // Catch: Throwable -> L10
        if (mVoipLeaWarEnabled == false) goto L12;
        if (on == false) goto L12;
        if (this.mBtHelper.isBluetoothScoOn() == true) goto L12;
        Log.v(TAG, "skip updateAudioHalBluetoothState if SCO is not on");     // Catch: Throwable -> L10
    L14:
        if (this.mScoManagedByAudio == true) goto L16;
        postUpdateCommunicationRouteClient(btScoRequesterAS, eventSource);     // Catch: Throwable -> L10
    L16:
        monitor-exit(r1);     // Catch: Throwable -> L10
        return;
    L12:
        updateAudioHalBluetoothState();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    void setA2dpSuspended(boolean enable, boolean internal, String eventSource) {
        Object r0 = this.mBluetoothAudioStateLock;
        monitor-enter(r0);
        Log.v(TAG, "setA2dpSuspended source: " + eventSource + ", enable: " + enable + ", internal: " + internal + ", mBluetoothA2dpSuspendedInt: " + this.mBluetoothA2dpSuspendedInt + ", mBluetoothA2dpSuspendedExt: " + this.mBluetoothA2dpSuspendedExt);     // Catch: Throwable -> L7
        if (internal == false) goto L9;
        this.mBluetoothA2dpSuspendedInt = enable;     // Catch: Throwable -> L7
    L10:
        updateAudioHalBluetoothState();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L9:
        this.mBluetoothA2dpSuspendedExt = enable;     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        throw th;
    }

    void clearA2dpSuspended(boolean internalOnly) {
        Log.v(TAG, "clearA2dpSuspended, internalOnly: " + internalOnly);
        Object r0 = this.mBluetoothAudioStateLock;
        monitor-enter(r0);
        this.mBluetoothA2dpSuspendedInt = false;     // Catch: Throwable -> L8
        if (internalOnly == true) goto L10;
        this.mBluetoothA2dpSuspendedExt = false;     // Catch: Throwable -> L8
    L10:
        updateAudioHalBluetoothState();     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    void setLeAudioSuspended(boolean enable, boolean internal, String eventSource) {
        Object r0 = this.mBluetoothAudioStateLock;
        monitor-enter(r0);
        Log.v(TAG, "setLeAudioSuspended source: " + eventSource + ", enable: " + enable + ", internal: " + internal + ", mBluetoothLeSuspendedInt: " + this.mBluetoothA2dpSuspendedInt + ", mBluetoothLeSuspendedExt: " + this.mBluetoothA2dpSuspendedExt);     // Catch: Throwable -> L7
        if (internal == false) goto L9;
        this.mBluetoothLeSuspendedInt = enable;     // Catch: Throwable -> L7
    L10:
        updateAudioHalBluetoothState();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L9:
        this.mBluetoothLeSuspendedExt = enable;     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        throw th;
    }

    void clearLeAudioSuspended(boolean internalOnly) {
        Log.v(TAG, "clearLeAudioSuspended, internalOnly: " + internalOnly);
        Object r0 = this.mBluetoothAudioStateLock;
        monitor-enter(r0);
        this.mBluetoothLeSuspendedInt = false;     // Catch: Throwable -> L8
        if (internalOnly == true) goto L10;
        this.mBluetoothLeSuspendedExt = false;     // Catch: Throwable -> L8
    L10:
        updateAudioHalBluetoothState();     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    AudioRoutesInfo startWatchingRoutes(IAudioRoutesObserver observer) {
        Object r0 = this.mDeviceStateLock;
        monitor-enter(r0);
        AudioRoutesInfo r1 = this.mDeviceInventory.startWatchingRoutes(observer);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    AudioRoutesInfo getCurAudioRoutes() {
        Object r0 = this.mDeviceStateLock;
        monitor-enter(r0);
        AudioRoutesInfo r1 = this.mDeviceInventory.getCurAudioRoutes();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    boolean isBluetoothA2dpOn() {
        return this.mBluetoothA2dpEnabled.get();
    }

    void postSetAvrcpAbsoluteVolumeIndex(int index) {
        sendIMsgNoDelay(15, 0, index);
    }

    void postSetHearingAidVolumeIndex(int index, int streamType) {
        sendIIMsgNoDelay(14, 0, index, streamType);
    }

    void postSetLeAudioVolumeIndex(int index, int maxIndex, int streamType) {
        BleVolumeInfo info = new BleVolumeInfo(index, maxIndex, streamType);
        sendLMsgNoDelay(46, 0, info);
    }

    void postSetModeOwner(int mode, int pid, int uid, boolean signal) {
        if (signal == false) goto L4;
        int r0 = 17;
    L5:
        sendLMsgNoDelay(r0, 0, new AudioModeInfo(mode, pid, uid));
        return;
    L4:
        r0 = 16;
        goto L5
    }

    void postBluetoothDeviceConfigChange(BtDeviceInfo info) {
        sendLMsgNoDelay(11, 2, info);
    }

    void startBluetoothScoForClient(IBinder cb, AttributionSource attributionSource, int scoAudioMode, boolean isPrivileged, String eventSource) {
        Log.v(TAG, "startBluetoothScoForClient, uid: " + attributionSource.getUid());
        postSetCommunicationDeviceForClient(new CommunicationDeviceInfo(cb, attributionSource, new AudioDeviceAttributes(16, ""), true, scoAudioMode, eventSource, isPrivileged));
    }

    void stopBluetoothScoForClient(IBinder cb, AttributionSource attributionSource, boolean isPrivileged, String eventSource) {
        Log.v(TAG, "stopBluetoothScoForClient, uid: " + attributionSource.getUid());
        postSetCommunicationDeviceForClient(new CommunicationDeviceInfo(cb, attributionSource, new AudioDeviceAttributes(16, ""), false, -1, eventSource, isPrivileged));
    }

    int setPreferredDevicesForStrategySync(int strategy, List<AudioDeviceAttributes> devices) {
        return this.mDeviceInventory.setPreferredDevicesForStrategyAndSave(strategy, devices);
    }

    int removePreferredDevicesForStrategySync(int strategy) {
        return this.mDeviceInventory.removePreferredDevicesForStrategyAndSave(strategy);
    }

    int setDeviceAsNonDefaultForStrategySync(int strategy, AudioDeviceAttributes device) {
        return this.mDeviceInventory.setDeviceAsNonDefaultForStrategyAndSave(strategy, device);
    }

    int removeDeviceAsNonDefaultForStrategySync(int strategy, AudioDeviceAttributes device) {
        return this.mDeviceInventory.removeDeviceAsNonDefaultForStrategyAndSave(strategy, device);
    }

    void registerStrategyPreferredDevicesDispatcher(IStrategyPreferredDevicesDispatcher dispatcher, boolean isPrivileged) {
        this.mDeviceInventory.registerStrategyPreferredDevicesDispatcher(dispatcher, isPrivileged);
    }

    void unregisterStrategyPreferredDevicesDispatcher(IStrategyPreferredDevicesDispatcher dispatcher) {
        this.mDeviceInventory.unregisterStrategyPreferredDevicesDispatcher(dispatcher);
    }

    void registerStrategyNonDefaultDevicesDispatcher(IStrategyNonDefaultDevicesDispatcher dispatcher, boolean isPrivileged) {
        this.mDeviceInventory.registerStrategyNonDefaultDevicesDispatcher(dispatcher, isPrivileged);
    }

    void unregisterStrategyNonDefaultDevicesDispatcher(IStrategyNonDefaultDevicesDispatcher dispatcher) {
        this.mDeviceInventory.unregisterStrategyNonDefaultDevicesDispatcher(dispatcher);
    }

    int setPreferredDevicesForCapturePresetSync(int capturePreset, List<AudioDeviceAttributes> devices) {
        return this.mDeviceInventory.setPreferredDevicesForCapturePresetAndSave(capturePreset, devices);
    }

    int clearPreferredDevicesForCapturePresetSync(int capturePreset) {
        return this.mDeviceInventory.clearPreferredDevicesForCapturePresetAndSave(capturePreset);
    }

    void registerCapturePresetDevicesRoleDispatcher(ICapturePresetDevicesRoleDispatcher dispatcher, boolean isPrivileged) {
        this.mDeviceInventory.registerCapturePresetDevicesRoleDispatcher(dispatcher, isPrivileged);
    }

    void unregisterCapturePresetDevicesRoleDispatcher(ICapturePresetDevicesRoleDispatcher dispatcher) {
        this.mDeviceInventory.unregisterCapturePresetDevicesRoleDispatcher(dispatcher);
    }

    List<AudioDeviceAttributes> anonymizeAudioDeviceAttributesListUnchecked(List<AudioDeviceAttributes> devices) {
        return this.mAudioService.anonymizeAudioDeviceAttributesListUnchecked(devices);
    }

    void registerCommunicationDeviceDispatcher(ICommunicationDeviceDispatcher dispatcher) {
        this.mCommDevDispatchers.register(dispatcher);
    }

    void unregisterCommunicationDeviceDispatcher(ICommunicationDeviceDispatcher dispatcher) {
        this.mCommDevDispatchers.unregister(dispatcher);
    }

    private void dispatchCommunicationDevice() {
        AudioDeviceInfo device = getCommunicationDeviceInt();
        if (device == null) goto L5;
        int portId = device.getId();
    L7:
        if (portId != this.mCurCommunicationPortId) goto L9;
        return;
    L9:
        this.mCurCommunicationPortId = portId;
        int btCommDeviceActiveType = 0;
        if (isBluetoothScoActive() == false) goto L13;
        btCommDeviceActiveType = 1;
    L18:
        this.mAudioService.postBtCommDeviceActive(btCommDeviceActiveType);
        int nbDispatchers = this.mCommDevDispatchers.beginBroadcast();
        int i = 0;
    L19:
        if (i >= nbDispatchers) goto L25;
        this.mCommDevDispatchers.getBroadcastItem(i).dispatchCommunicationDeviceChanged(portId);     // Catch: RemoteException -> L22
    L24:
        i = i + 1;
    L22:
        e = move-exception;
        Log.e(TAG, "dispatchCommunicationDevice error", e);
        goto L24
    L25:
        this.mCommDevDispatchers.finishBroadcast();
        return;
    L13:
        if (isBluetoothBleHeadsetActive() == false) goto L16;
        btCommDeviceActiveType = 2;
        goto L18
    L16:
        if (isBluetoothBleSpeakerActive() == false) goto L18;
        btCommDeviceActiveType = 4;
        goto L18
    L5:
        portId = 0;
        goto L7
    }

    void postAccessoryPlugMediaUnmute(int device) {
        this.mAudioService.postAccessoryPlugMediaUnmute(device);
    }

    int getVolumeForDeviceIgnoreMute(int streamType, int device) {
        return this.mAudioService.getVolumeForDeviceIgnoreMute(streamType, device);
    }

    int getMaxVssVolumeForStream(int streamType) {
        return this.mAudioService.getMaxVssVolumeForStream(streamType);
    }

    int getDeviceForStream(int streamType) {
        return this.mAudioService.getDeviceForStream(streamType);
    }

    void postApplyVolumeOnDevice(int streamType, int device, String caller) {
        this.mAudioService.postApplyVolumeOnDevice(streamType, device, caller);
    }

    void postSetVolumeIndexOnDevice(int streamType, int vssVolIndex, int device, String caller) {
        this.mAudioService.postSetVolumeIndexOnDevice(streamType, vssVolIndex, device, caller);
    }

    void postObserveDevicesForAllStreams() {
        this.mAudioService.postObserveDevicesForAllStreams();
    }

    boolean isInCommunication() {
        return this.mAudioService.isInCommunication();
    }

    boolean hasMediaDynamicPolicy() {
        return this.mAudioService.hasMediaDynamicPolicy();
    }

    ContentResolver getContentResolver() {
        return this.mAudioService.getContentResolver();
    }

    void checkMusicActive(int deviceType, String caller) {
        this.mAudioService.checkMusicActive(deviceType, caller);
    }

    void checkVolumeCecOnHdmiConnection(int state, String caller) {
        this.mAudioService.postCheckVolumeCecOnHdmiConnection(state, caller);
    }

    boolean hasAudioFocusUsers() {
        return this.mAudioService.hasAudioFocusUsers();
    }

    void postInitSpatializerHeadTrackingSensors() {
        this.mAudioService.postInitSpatializerHeadTrackingSensors();
    }

    void postBroadcastScoConnectionState(int state) {
        sendIMsgNoDelay(3, 2, state);
    }

    void postBroadcastBecomingNoisy() {
        sendMsgNoDelay(12, 0);
    }

    void postBluetoothActiveDevice(BtDeviceInfo info, int delay) {
        sendLMsg(7, 2, info, delay);
    }

    void postSetWiredDeviceConnectionState(AudioDeviceInventory.WiredDeviceConnectionState connectionState, int delay) {
        sendLMsg(2, 2, connectionState, delay);
    }

    void postBtProfileDisconnected(int profile) {
        sendIMsgNoDelay(22, 2, profile);
    }

    void postBtProfileConnected(int profile, BluetoothProfile proxy) {
        sendILMsgNoDelay(23, 2, profile, proxy);
    }

    void postCommunicationRouteClientDied(CommunicationRouteClient client) {
        sendLMsgNoDelay(34, 2, client);
    }

    void postUpdateCommunicationRouteClient(AttributionSource attributionSource, String eventSource) {
        sendLMsgNoDelay(43, 2, new UpdateCommRouteClientInfo(attributionSource, eventSource));
    }

    void postUpdateCommunicationRouteClient(AttributionSource attributionSource, String eventSource, int delay) {
        sendLMsg(43, 2, new UpdateCommRouteClientInfo(attributionSource, eventSource), delay);
    }

    void postSetCommunicationDeviceForClient(CommunicationDeviceInfo info) {
        sendLMsgNoDelay(42, 2, info);
    }

    void postNotifyPreferredAudioProfileApplied(BluetoothDevice btDevice) {
        sendLMsgNoDelay(52, 2, btDevice);
    }

    void postReceiveBtEvent(Intent intent) {
        sendLMsgNoDelay(55, 2, intent);
    }

    void postUpdateLeAudioGroupAddresses(int groupId) {
        sendIMsgNoDelay(57, 2, groupId);
    }

    void postSynchronizeAdiDevicesInInventory(AdiDeviceState deviceState) {
        sendLMsgNoDelay(58, 2, deviceState);
    }

    void postUpdatedAdiDeviceState(AdiDeviceState r3, boolean r4) {
        sendILMsgNoDelay(59, 2, r4 ? 1 : 0, r3);
    }

    void setBluetoothA2dpOnInt(boolean on, boolean fromA2dp, String source) {
        String eventSource = "setBluetoothA2dpOn(" + on + ") from u/pid:" + Binder.getCallingUid() + SliceClientPermissions.SliceAuthority.DELIMITER + Binder.getCallingPid() + " src:" + source;
        this.mBluetoothA2dpEnabled.set(on);
        if (on == false) goto L5;
        int r1 = 0;
    L6:
        onSetForceUse(1, r1, fromA2dp, eventSource);
        return;
    L5:
        r1 = 10;
        goto L6
    }

    boolean handleDeviceConnection(AudioDeviceAttributes attributes, boolean connect, BluetoothDevice btDevice, boolean deviceSwitch) {
        Object r1 = this.mDeviceStateLock;
        monitor-enter(r1);
        boolean status = this.mDeviceInventory.handleDeviceConnection(attributes, connect, false, btDevice, deviceSwitch);     // Catch: Throwable -> L11
        if (isValidCommunicationDeviceType(attributes.getType()) == false) goto L9;
    L13:
        checkCommunicationRouteClientsDevices();     // Catch: Throwable -> L11
        if (connect == true) goto L17;
        if (deviceSwitch == false) goto L17;
    L18:
        monitor-exit(r1);     // Catch: Throwable -> L11
        return status;
    L17:
        onUpdateCommunicationRouteClient(bluetoothScoRequestOwnerAttributionSource(), "handleDeviceConnection");     // Catch: Throwable -> L11
        goto L18
    L9:
        if (this.mDuplexCommunicationDevices.containsValue(Integer.valueOf(attributes.getInternalType())) == false) goto L18;
    L20:
        th = move-exception;
        Throwable r9 = th;
    L22:
        monitor-exit(r1);     // Catch: Throwable -> L11
        throw r9;
    L11:
        th = move-exception;
        r9 = th;
        goto L22
    }

    void handleFailureToConnectToBtHeadsetService(int delay) {
        sendMsg(9, 0, delay);
    }

    void handleCancelFailureToConnectToBtHeadsetService() {
        this.mBrokerHandler.removeMessages(9);
    }

    void postReportNewRoutes(boolean fromA2dp) {
        if (fromA2dp == false) goto L4;
        int r0 = 36;
    L5:
        sendMsgNoDelay(r0, 1);
        return;
    L4:
        r0 = 13;
        goto L5
    }

    boolean hasScheduledA2dpConnection(BluetoothDevice btDevice, int profile) {
        BtDeviceInfo devInfoToCheck = new BtDeviceInfo(btDevice, profile);
        return this.mBrokerHandler.hasEqualMessages(7, devInfoToCheck);
    }

    void setA2dpTimeout(String address, int a2dpCodec, int delayMs) {
        sendILMsg(10, 2, a2dpCodec, address, delayMs);
    }

    void setLeAudioTimeout(String address, int device, int codec, int delayMs) {
        sendIILMsg(49, 2, device, codec, address, delayMs);
    }

    void setHearingAidTimeout(String address, int delayMs) {
        sendLMsg(61, 2, address, delayMs);
    }

    void setAvrcpAbsoluteVolumeSupported(boolean supported) {
        Object r0 = this.mDeviceStateLock;
        monitor-enter(r0);
        this.mBtHelper.setAvrcpAbsoluteVolumeSupported(supported);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    void clearAvrcpAbsoluteVolumeSupported() {
        setAvrcpAbsoluteVolumeSupported(false);
        this.mAudioService.setAvrcpAbsoluteVolumeSupported(false);
    }

    boolean getBluetoothA2dpEnabled() {
        return this.mBluetoothA2dpEnabled.get();
    }

    int getLeAudioDeviceGroupId(BluetoothDevice device) {
        return this.mBtHelper.getLeAudioDeviceGroupId(device);
    }

    List<Pair<String, String>> getLeAudioGroupAddresses(int groupId) {
        return this.mBtHelper.getLeAudioGroupAddresses(groupId);
    }

    void broadcastStickyIntentToCurrentProfileGroup(Intent intent) {
        this.mSystemServer.broadcastStickyIntentToCurrentProfileGroup(intent);
    }

    void dump(final PrintWriter pw, final String prefix) {
        if (this.mBrokerHandler == null) goto L5;
        pw.println(prefix + "Message handler (watch for unhandled messages):");
        this.mBrokerHandler.dump(new PrintWriterPrinter(pw), prefix + "  ");
    L6:
        this.mDeviceInventory.dump(pw, prefix);
        pw.println("\n" + prefix + "Communication route clients:");
        this.mCommunicationRouteClients.forEach(new AudioDeviceBroker$$ExternalSyntheticLambda0(pw, prefix));
        pw.println("\n" + prefix + "Computed Preferred communication device: " + preferredCommunicationDevice());
        pw.println("\n" + prefix + "Applied Preferred communication device: " + this.mPreferredCommunicationDevice);
        StringBuilder r0 = new StringBuilder();
        r0.append(prefix);
        r0.append("Active communication device: ");
        if (this.mActiveCommunicationDevice != null) goto L9;
        String r2 = KeyboardMetricsCollector.DEFAULT_LANGUAGE_TAG;
    L10:
        r0.append(r2);
        pw.println(r0.toString());
        pw.println(prefix + "mCommunicationStrategyId: " + this.mCommunicationStrategyId);
        pw.println(prefix + "mAccessibilityStrategyId: " + this.mAccessibilityStrategyId);
        pw.println("\n" + prefix + "mAudioModeOwner: " + this.mAudioModeOwner);
        pw.println("\n" + prefix + "mScoManagedByAudio: " + this.mScoManagedByAudio);
        pw.println("\n" + prefix + "Bluetooth SCO on, requested: " + this.mBluetoothScoOn + ", applied: " + this.mBluetoothScoOnApplied);
        pw.println("\n" + prefix + "Bluetooth A2DP suspended, requested ext: " + this.mBluetoothA2dpSuspendedExt + ", requested int: " + this.mBluetoothA2dpSuspendedInt + ", applied " + this.mBluetoothA2dpSuspendedApplied);
        pw.println("\n" + prefix + "Bluetooth LE Audio suspended, requested ext: " + this.mBluetoothLeSuspendedExt + ", requested int: " + this.mBluetoothLeSuspendedInt + ", applied " + this.mBluetoothLeSuspendedApplied);
        this.mBtHelper.dump(pw, prefix);
        return;
    L9:
        r2 = new AudioDeviceAttributes(this.mActiveCommunicationDevice);
        goto L10
    L5:
        pw.println("Message handler is null");
        goto L6
    }

    private static /* synthetic */ void lambda$dump$1(PrintWriter pw, String prefix, CommunicationRouteClient cl) {
        pw.println("  " + prefix + cl.toString());
    }

    private void onSetForceUse(int useCase, int config, boolean fromA2dp, String eventSource) {
        if (useCase != 1) goto L5;
        postReportNewRoutes(fromA2dp);
    L5:
        AudioService.sForceUseLogger.enqueue(new AudioServiceEvents.ForceUseEvent(useCase, config, eventSource));
        new MediaMetrics.Item("audio.forceUse." + AudioSystem.forceUseUsageToString(useCase)).set(MediaMetrics.Property.EVENT, "onSetForceUse").set(MediaMetrics.Property.FORCE_USE_DUE_TO, eventSource).set(MediaMetrics.Property.FORCE_USE_MODE, AudioSystem.forceUseConfigToString(config)).record();
        Log.v(TAG, "onSetForceUse(useCase<" + useCase + ">, config<" + config + ">, fromA2dp<" + fromA2dp + ">, eventSource<" + eventSource + ">)");
        this.mAudioSystem.setForceUse(useCase, config);
    }

    private void onSendBecomingNoisyIntent() {
        AudioService.sDeviceLogger.enqueue(new EventLogger.StringEvent("broadcast ACTION_AUDIO_BECOMING_NOISY").printLog(TAG));
        this.mSystemServer.sendDeviceBecomingNoisyIntent();
    }

    private void setupMessaging(Context ctxt) {
        PowerManager pm = (PowerManager) ctxt.getSystemService("power");
        this.mBrokerEventWakeLock = pm.newWakeLock(1, "handleAudioDeviceEvent");
        this.mBrokerThread = new BrokerThread(this);
        this.mBrokerThread.start();
        waitForBrokerHandlerCreation();
    }

    private void waitForBrokerHandlerCreation() {
        monitor-enter(this);
    L15:
    L7:
        th = move-exception;
        throw th;
    L4:
        if (this.mBrokerHandler != null) goto L11;
        wait();     // Catch: Throwable -> L7 InterruptedException -> L9
    L10:
        Log.e(TAG, "Interruption while waiting on BrokerHandler");     // Catch: Throwable -> L7
        goto L15
    L11:
        monitor-exit(this);     // Catch: Throwable -> L7
    }

    private static boolean isMessageHandledUnderWakelock(int msgId) {
        switch(msgId) {
            case 2: goto L5;
            case 6: goto L5;
            case 7: goto L5;
            case 10: goto L5;
            case 11: goto L5;
            case 31: goto L5;
            case 35: goto L5;
            case 49: goto L5;
            case 61: goto L5;
            default: goto L3;
        };
    L3:
        return false;
    L5:
        return true;
    }

    private void sendMsg(int msg, int existingMsgPolicy, int delay) {
        sendIILMsg(msg, existingMsgPolicy, 0, 0, null, delay);
    }

    private void sendILMsg(int msg, int existingMsgPolicy, int arg, Object obj, int delay) {
        sendIILMsg(msg, existingMsgPolicy, arg, 0, obj, delay);
    }

    private void sendLMsg(int msg, int existingMsgPolicy, Object obj, int delay) {
        sendIILMsg(msg, existingMsgPolicy, 0, 0, obj, delay);
    }

    private void sendMsgNoDelay(int msg, int existingMsgPolicy) {
        sendIILMsg(msg, existingMsgPolicy, 0, 0, null, 0);
    }

    private void sendIMsgNoDelay(int msg, int existingMsgPolicy, int arg) {
        sendIILMsg(msg, existingMsgPolicy, arg, 0, null, 0);
    }

    private void sendIIMsgNoDelay(int msg, int existingMsgPolicy, int arg1, int arg2) {
        sendIILMsg(msg, existingMsgPolicy, arg1, arg2, null, 0);
    }

    private void sendILMsgNoDelay(int msg, int existingMsgPolicy, int arg, Object obj) {
        sendIILMsg(msg, existingMsgPolicy, arg, 0, obj, 0);
    }

    private void sendLMsgNoDelay(int msg, int existingMsgPolicy, Object obj) {
        sendIILMsg(msg, existingMsgPolicy, 0, 0, obj, 0);
    }

    private void sendIILMsgNoDelay(int msg, int existingMsgPolicy, int arg1, int arg2, Object obj) {
        sendIILMsg(msg, existingMsgPolicy, arg1, arg2, obj, 0);
    }

    private void sendIILMsg(int msg, int existingMsgPolicy, int arg1, int arg2, Object obj, int delay) {
        if (existingMsgPolicy != 0) goto L5;
        this.mBrokerHandler.removeMessages(msg);
    L10:
        if (isMessageHandledUnderWakelock(msg) == false) goto L22;
        long identity = Binder.clearCallingIdentity();
        this.mBrokerEventWakeLock.acquire(BROKER_WAKELOCK_TIMEOUT_MS);     // Catch: Throwable -> L14 Exception -> L16
    L13:
        Binder.restoreCallingIdentity(identity);
        goto L22
    L16:
        e = move-exception;
        Log.e(TAG, "Exception acquiring wakelock", e);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    L22:
        if (MESSAGES_MUTE_MUSIC.contains(Integer.valueOf(msg)) == false) goto L24;
        checkMessagesMuteMusic(msg);
    L24:
        Object r0 = sLastDeviceConnectionMsgTimeLock;
        monitor-enter(r0);
        long time = SystemClock.uptimeMillis() + ((long) delay);     // Catch: Throwable -> L32
        switch(msg) {
            case 2: goto L30;
            case 7: goto L30;
            case 10: goto L30;
            case 11: goto L30;
            case 49: goto L30;
            case 61: goto L30;
            default: goto L35;
        };     // Catch: Throwable -> L32
    L35:
        this.mBrokerHandler.sendMessageAtTime(this.mBrokerHandler.obtainMessage(msg, arg1, arg2, obj), time);     // Catch: Throwable -> L32
        monitor-exit(r0);     // Catch: Throwable -> L32
        return;
    L30:
        if (sLastDeviceConnectMsgTime < time) goto L34;
        time = sLastDeviceConnectMsgTime + 30;     // Catch: Throwable -> L32
    L34:
        sLastDeviceConnectMsgTime = time;     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        throw th;
    L5:
        if (existingMsgPolicy != 1) goto L10;
        if (this.mBrokerHandler.hasMessages(msg) == false) goto L10;
    }

    private void removeMsgForCheckClientState(int uid) {
        CommunicationRouteClient crc = getCommunicationRouteClientForUid(uid);
        if (crc == null) goto L6;
        this.mBrokerHandler.removeEqualMessages(56, crc);
        return;
    }

    private void sendMsgForCheckClientState(int msg, int existingMsgPolicy, int arg1, int arg2, Object obj, int delay) {
        if (existingMsgPolicy != 0) goto L5;
        if (obj == null) goto L5;
        this.mBrokerHandler.removeEqualMessages(msg, obj);
    L5:
        long time = SystemClock.uptimeMillis() + ((long) delay);
        this.mBrokerHandler.sendMessageAtTime(this.mBrokerHandler.obtainMessage(msg, arg1, arg2, obj), time);
    }

    private static <T> boolean hasIntersection(Set<T> a, Set<T> b) {
        Iterator<T> r0 = a.iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        T e = r0.next();
        if (b.contains(e) == false) goto L4;
        return true;
    L10:
        return false;
    }

    boolean messageMutesMusic(int message) {
        if (message != 0) goto L6;
        return false;
    L6:
        if (message == 7) goto L10;
        if (message == 11) goto L10;
        return true;
    L10:
        if (AudioSystem.isStreamActive(3, 0) == true) goto L12;
        return true;
    L12:
        if (hasIntersection(AudioDeviceInventory.DEVICE_OVERRIDE_A2DP_ROUTE_ON_PLUG_SET, this.mAudioService.getDeviceSetForStream(3)) == false) goto L17;
        return false;
    L17:
        return true;
    }

    private void checkMessagesMuteMusic(int message) {
        boolean mute = messageMutesMusic(message);
        if (mute == true) goto L14;
        Iterator<Integer> r1 = MESSAGES_MUTE_MUSIC.iterator();
    L6:
        if (r1.hasNext() == false) goto L14;
        int msg = r1.next().intValue();
        if (this.mBrokerHandler.hasMessages(msg) == false) goto L6;
        if (messageMutesMusic(msg) == false) goto L6;
        mute = true;
    L14:
        if (mute == this.mMusicMuted.getAndSet(mute)) goto L23;
        this.mAudioService.setMusicMute(mute);
        return;
    }

    private void onCommunicationRouteClientDied(CommunicationRouteClient client) {
        if (client != null) goto L4;
        return;
    L4:
        Log.w(TAG, "Communication client died");
        setCommunicationRouteForClient(client.getBinder(), client.getAttributionSource(), null, -1, client.isPrivileged(), "onCommunicationRouteClientDied");
    }

    private AudioDeviceAttributes preferredCommunicationDevice() {
        boolean btSCoOn = this.mBtHelper.isBluetoothScoOn();
        Object r1 = this.mBluetoothAudioStateLock;
        monitor-enter(r1);
        if (btSCoOn == true) goto L11;
    L8:
        th = move-exception;
        throw th;
    L6:
        if (this.mScoManagedByAudio == true) goto L11;
    L13:
        boolean r2 = false;
    L14:
        boolean btSCoOn2 = r2;
        monitor-exit(r1);     // Catch: Throwable -> L8
        if (btSCoOn2 == false) goto L20;
        AudioDeviceAttributes device = this.mBtHelper.getHeadsetAudioDummyDevice();
        if (device == null) goto L20;
        return device;
    L20:
        AudioDeviceAttributes device2 = requestedCommunicationDevice();
        if (device2 != null) goto L23;
        return null;
    L23:
        if (device2.getType() == 7) goto L32;
        return device2;
    L32:
        return null;
    L11:
        if (this.mBluetoothScoOn == false) goto L13;
        r2 = true;
        goto L14
    }

    private void updateCommunicationRoute(String eventSource) {
        AudioDeviceAttributes preferredCommunicationDevice = preferredCommunicationDevice();
        Log.v(TAG, "updateCommunicationRoute, preferredCommunicationDevice: " + preferredCommunicationDevice + " eventSource: " + eventSource);
        AudioService.sDeviceLogger.enqueue(new EventLogger.StringEvent("updateCommunicationRoute, preferredCommunicationDevice: " + preferredCommunicationDevice + " eventSource: " + eventSource));
        if (preferredCommunicationDevice != null) goto L23;
        AudioDeviceAttributes defaultDevice = getDefaultCommunicationDevice();
        boolean mVoipLeaWarEnabled = SystemProperties.getBoolean("persist.enable.bluetooth.voipleawar", false);
        Log.v(TAG, "onUpdateCommunicationRoute, voipLeaEnabled " + mVoipLeaWarEnabled);
        if (mVoipLeaWarEnabled == false) goto L19;
        AudioDeviceAttributes requestedDevice = requestedCommunicationDevice();
        if (defaultDevice != null) goto L9;
    L10:
        if (requestedDevice != null) goto L12;
    L14:
        if (defaultDevice == null) goto L19;
        if (requestedDevice != null) goto L19;
        if (defaultDevice.getType() != 26) goto L19;
        Log.w(TAG, "onUpdateCommunicationRoute, clear default BLE device");
        defaultDevice = null;
        goto L19
    L12:
        if (requestedDevice.getType() != 7) goto L14;
        Log.w(TAG, "onUpdateCommunicationRoute, set it to active BLE device");
        defaultDevice = this.mDeviceInventory.getDeviceOfType(536870912);
        goto L19
    L9:
        if (defaultDevice.getType() != 26) goto L14;
    L19:
        if (defaultDevice == null) goto L21;
        this.mDeviceInventory.setPreferredDevicesForStrategyInt(this.mCommunicationStrategyId, Arrays.asList(new AudioDeviceAttributes[]{defaultDevice}));
        this.mDeviceInventory.setPreferredDevicesForStrategyInt(this.mAccessibilityStrategyId, Arrays.asList(new AudioDeviceAttributes[]{defaultDevice}));
    L22:
        this.mDeviceInventory.applyConnectedDevicesRoles();
        this.mDeviceInventory.reapplyExternalDevicesRoles();
    L24:
        onUpdatePhoneStrategyDevice(preferredCommunicationDevice);
        return;
    L21:
        this.mDeviceInventory.removePreferredDevicesForStrategyInt(this.mCommunicationStrategyId);
        this.mDeviceInventory.removePreferredDevicesForStrategyInt(this.mAccessibilityStrategyId);
        goto L22
    L23:
        this.mDeviceInventory.setPreferredDevicesForStrategyInt(this.mCommunicationStrategyId, Arrays.asList(new AudioDeviceAttributes[]{preferredCommunicationDevice}));
        this.mDeviceInventory.setPreferredDevicesForStrategyInt(this.mAccessibilityStrategyId, Arrays.asList(new AudioDeviceAttributes[]{preferredCommunicationDevice}));
        goto L24
    }

    private void checkCommunicationRouteClientsDevices() {
        Iterator<CommunicationRouteClient> r0 = this.mCommunicationRouteClients.iterator();
    L4:
        if (r0.hasNext() == false) goto L39;
        CommunicationRouteClient crc = r0.next();
        int deviceType = crc.getDevice().getInternalType();
        if (deviceType == 1) goto L4;
        if (deviceType == 2) goto L4;
        if (deviceType == 16777216) goto L4;
        Set<Integer> inDeviceSet = null;
        if (AudioSystem.isBluetoothScoOutDevice(deviceType) == false) goto L15;
        Set<Integer> outDeviceSet = AudioSystem.DEVICE_OUT_ALL_SCO_SET;
        inDeviceSet = AudioSystem.DEVICE_IN_ALL_SCO_SET;
    L18:
        AudioDeviceAttributes outAda = this.mDeviceInventory.getFirstConnectedDeviceAttributesOfTypes(outDeviceSet);
        if (inDeviceSet != null) goto L21;
        AudioDeviceAttributes inAda = null;
    L23:
        if (outAda == null) goto L29;
        if (inDeviceSet == null) goto L28;
        if (inAda == null) goto L29;
        if (inAda.getAddress().equals(outAda.getAddress()) == false) goto L29;
    L28:
        boolean fullyConnected = true;
    L31:
        if (fullyConnected == true) goto L32;
        if (crc.isDisabled() == true) goto L4;
        crc.setDisabled(true);
        Log.v(TAG, "checkCommunicationRouteClientsDevices, disabling client: " + crc);
        goto L4
    L32:
        crc.setDevice(outAda);
        if (crc.isDisabled() == false) goto L4;
        crc.setDisabled(false);
        Log.v(TAG, "checkCommunicationRouteClientsDevices, enabling client: " + crc);
    L29:
        fullyConnected = false;
        goto L31
    L21:
        inAda = this.mDeviceInventory.getFirstConnectedDeviceAttributesOfTypes(inDeviceSet);
        goto L23
    L15:
        outDeviceSet = new HashSet();
        outDeviceSet.add(Integer.valueOf(deviceType));
        if (this.mDuplexCommunicationDevices.containsKey(Integer.valueOf(deviceType)) == false) goto L18;
        inDeviceSet = new HashSet();
        inDeviceSet.add(this.mDuplexCommunicationDevices.get(Integer.valueOf(deviceType)));
        goto L18
    }

    private void onUpdateCommunicationRouteClient(AttributionSource previousBtScoRequesterAS, String eventSource) {
        CommunicationRouteClient crc = topCommunicationRouteClient();
        Log.v(TAG, "onUpdateCommunicationRouteClient, crc: " + crc + " previous BT SCO Requester UID: " + safeUidFromAttributionSource(previousBtScoRequesterAS) + " eventSource: " + eventSource);
        if (crc == null) goto L6;
        setCommunicationRouteForClient(crc.getBinder(), crc.getAttributionSource(), crc.getDevice(), -1, crc.isPrivileged(), eventSource);
        return;
    L6:
        if (previousBtScoRequesterAS == null) goto L8;
        boolean wasScoRequested = true;
    L10:
        if (isBluetoothScoRequested() == true) goto L19;
        if (wasScoRequested == false) goto L19;
        if (this.mScoManagedByAudio == true) goto L15;
        this.mBtHelper.stopBluetoothSco(eventSource);
        goto L19
    L15:
        if (shouldStartScoForAttributionSource(previousBtScoRequesterAS) == false) goto L17;
        this.mBtHelper.stopBluetoothSco(eventSource);
    L17:
        setBluetoothScoOn(false, eventSource);
    L19:
        updateCommunicationRoute(eventSource);
        return;
    L8:
        wasScoRequested = false;
        goto L10
    }

    private void onUpdatePhoneStrategyDevice(AudioDeviceAttributes device) {
        boolean wasSpeakerphoneActive = isSpeakerphoneActive();
        this.mPreferredCommunicationDevice = device;
        updateActiveCommunicationDevice();
        if (wasSpeakerphoneActive != isSpeakerphoneActive()) goto L10;
    L8:
        dispatchCommunicationDevice();
        this.mAudioService.postUpdateRingerModeServiceInt();
        return;
    L10:
        this.mContext.sendBroadcastAsUser(new Intent("android.media.action.SPEAKERPHONE_STATE_CHANGED").setFlags(1073741824), UserHandle.ALL);     // Catch: Exception -> L6
    L6:
        e = move-exception;
        Log.w(TAG, "failed to broadcast ACTION_SPEAKERPHONE_STATE_CHANGED: " + e);
        goto L8
    }

    private CommunicationRouteClient removeCommunicationRouteClient(IBinder cb, boolean unregister) {
        Iterator<CommunicationRouteClient> r0 = this.mCommunicationRouteClients.iterator();
    L4:
        if (r0.hasNext() == false) goto L12;
        CommunicationRouteClient cl = r0.next();
        if (cl.getBinder() != cb) goto L4;
        if (unregister == false) goto L9;
        cl.unregisterDeathRecipient();
    L9:
        removeMsgForCheckClientState(cl.getUid());
        this.mCommunicationRouteClients.remove(cl);
        return cl;
    L12:
        return null;
    }

    private CommunicationRouteClient addCommunicationRouteClient(IBinder cb, AttributionSource attributionSource, AudioDeviceAttributes device, boolean isPrivileged) {
        removeCommunicationRouteClient(cb, true);
        CommunicationRouteClient client = new CommunicationRouteClient(this, cb, attributionSource, device, isPrivileged);
        if (client.registerDeathRecipient() == false) goto L8;
        this.mCommunicationRouteClients.add(0, client);
        if (client.isActive() == true) goto L7;
        setForceCommunicationClientStateAndDelayedCheck(client, !this.mAudioService.isPlaybackActiveForUid(client.getUid()), !this.mAudioService.isRecordingActiveForUid(client.getUid()));
    L7:
        return client;
    L8:
        return null;
    }

    private CommunicationRouteClient getCommunicationRouteClientForUid(int uid) {
        Iterator<CommunicationRouteClient> r0 = this.mCommunicationRouteClients.iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        CommunicationRouteClient cl = r0.next();
        if (cl.getUid() != uid) goto L4;
        return cl;
    L9:
        return null;
    }

    private boolean communnicationDeviceLeAudioCompatOn() {
        if (this.mAudioModeOwner.mMode == 3) goto L5;
    L9:
        return false;
    L5:
        if (CompatChanges.isChangeEnabled(USE_SET_COMMUNICATION_DEVICE, this.mAudioModeOwner.mUid) == true) goto L9;
        if (this.mAudioModeOwner.mUid == 1000) goto L9;
        return true;
    }

    private boolean communnicationDeviceHaCompatOn() {
        if (this.mAudioModeOwner.mMode == 3) goto L5;
    L7:
        return false;
    L5:
        if (this.mAudioModeOwner.mUid == 1000) goto L7;
        return true;
    }

    AudioDeviceAttributes getDefaultCommunicationDevice() {
        AudioDeviceAttributes device = null;
        if (communnicationDeviceHaCompatOn() == false) goto L5;
        device = this.mDeviceInventory.getDeviceOfType(134217728);
    L5:
        if (device == null) goto L7;
        return device;
    L7:
        if (communnicationDeviceLeAudioCompatOn() == false) goto L11;
        AudioDeviceAttributes device2 = this.mDeviceInventory.getDeviceOfType(536870912);
        return device2;
    L11:
        return device;
    }

    void updateCommunicationRouteClientsActivity(List<AudioPlaybackConfiguration> playbackConfigs, List<AudioRecordingConfiguration> recordConfigs) {
        Object r0 = this.mSetModeLock;
        monitor-enter(r0);
        Object r1 = this.mDeviceStateLock;     // Catch: Throwable -> L46
        monitor-enter(r1);     // Catch: Throwable -> L46
        Iterator<CommunicationRouteClient> r2 = this.mCommunicationRouteClients.iterator();     // Catch: Throwable -> L19
    L8:
        if (r2.hasNext() == false) goto L43;
        CommunicationRouteClient crc = r2.next();     // Catch: Throwable -> L19
        boolean wasActive = crc.isActive();     // Catch: Throwable -> L19
        boolean updateClientState = false;
        boolean r6 = true;
        if (playbackConfigs == null) goto L22;
        crc.setPlaybackActive(false);     // Catch: Throwable -> L19
        Iterator<AudioPlaybackConfiguration> r8 = playbackConfigs.iterator();     // Catch: Throwable -> L19
    L13:
        if (r8.hasNext() == false) goto L22;
        AudioPlaybackConfiguration config = r8.next();     // Catch: Throwable -> L19
        if (config.getClientUid() != crc.getUid()) goto L13;
        if (config.isActive() == false) goto L13;
        crc.setPlaybackActive(true);     // Catch: Throwable -> L19
        updateClientState = true;
    L22:
        if (recordConfigs == null) goto L32;
        crc.setRecordingActive(false);     // Catch: Throwable -> L19
        Iterator<AudioRecordingConfiguration> r9 = recordConfigs.iterator();     // Catch: Throwable -> L19
    L25:
        if (r9.hasNext() == false) goto L32;
        AudioRecordingConfiguration config2 = r9.next();     // Catch: Throwable -> L19
        if (config2.getClientUid() != crc.getUid()) goto L25;
        if (config2.isClientSilenced() == true) goto L25;
        crc.setRecordingActive(true);     // Catch: Throwable -> L19
        updateClientState = true;
    L32:
        if (updateClientState == false) goto L34;
        removeMsgForCheckClientState(crc.getUid());     // Catch: Throwable -> L19
        updateCommunicationRouteClientState(crc, wasActive);     // Catch: Throwable -> L19
        goto L8
    L34:
        if (wasActive == false) goto L8;
        if (playbackConfigs == null) goto L37;
        boolean r10 = true;
    L38:
        if (recordConfigs != null) goto L41;
        r6 = false;
    L41:
        setForceCommunicationClientStateAndDelayedCheck(crc, r10, r6);     // Catch: Throwable -> L19
        goto L8
    L37:
        r10 = false;
        goto L38
    L43:
        monitor-exit(r1);     // Catch: Throwable -> L19
        monitor-exit(r0);     // Catch: Throwable -> L46
        return;
    L19:
        th = move-exception;
        throw th;     // Catch: Throwable -> L46
    L46:
        th = move-exception;
        throw th;
    }

    List<String> getDeviceIdentityAddresses(AudioDeviceAttributes device) {
        Object r0 = this.mDeviceStateLock;
        monitor-enter(r0);
        List<String> r1 = this.mDeviceInventory.getDeviceIdentityAddresses(device);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    void dispatchPreferredMixerAttributesChangedCausedByDeviceRemoved(AudioDeviceInfo info) {
        this.mAudioService.dispatchPreferredMixerAttributesChanged(new AudioAttributes.Builder().setUsage(1).build(), info.getId(), null);
    }

    public void postPersistAudioDeviceSettings() {
        sendMsg(54, 0, 1000);
    }

    void onPersistAudioDeviceSettings() {
        String deviceSettings = this.mDeviceInventory.getDeviceSettings();
        Log.v(TAG, "onPersistAudioDeviceSettings AdiDeviceState: " + deviceSettings);
        String currentSettings = readDeviceSettings();
        if (deviceSettings.equals(currentSettings) == false) goto L5;
        return;
    L5:
        SettingsAdapter settingsAdapter = this.mAudioService.getSettings();
        if (settingsAdapter != null) goto L18;
        Log.e(TAG, "No settings adapter when saving AdiDeviceState: " + deviceSettings);
        return;
    L18:
        boolean res = settingsAdapter.putSecureStringForUser(this.mAudioService.getContentResolver(), "audio_device_inventory", deviceSettings, -2);     // Catch: IllegalArgumentException -> L13
        if (res == true) goto L20;
        Log.e(TAG, "error saving AdiDeviceState: " + deviceSettings);     // Catch: IllegalArgumentException -> L13
        return;
    L20:
        return;
    L13:
        e = move-exception;
        Log.e(TAG, "error saving AdiDeviceState: " + deviceSettings, e);
    }

    private String readDeviceSettings() {
        SettingsAdapter settingsAdapter = this.mAudioService.getSettings();
        ContentResolver contentResolver = this.mAudioService.getContentResolver();
        if (settingsAdapter == null) goto L8;
        if (contentResolver == null) goto L8;
        return settingsAdapter.getSecureStringForUser(contentResolver, "audio_device_inventory", -2);
    L8:
        Log.e(TAG, "No settings adapter or content resolver to read device settings", new Exception("readDeviceSettings_NPE"));
        return "";
    }

    void onReadAudioDeviceSettings() {
        SettingsAdapter settingsAdapter = this.mAudioService.getSettings();
        ContentResolver contentResolver = this.mAudioService.getContentResolver();
        String settings = readDeviceSettings();
        if (settings != null) goto L15;
        Log.i(TAG, "reading AdiDeviceState from legacy keyspatial_audio_enabled");
        settings = settingsAdapter.getSecureStringForUser(contentResolver, "spatial_audio_enabled", -2);
        if (settings != null) goto L8;
        Log.i(TAG, "no AdiDeviceState stored with legacy key");
        goto L15
    L8:
        if (settings.equals("") == true) goto L15;
        if (settingsAdapter.putSecureStringForUser(contentResolver, "spatial_audio_enabled", "", -2) == true) goto L13;
        Log.w(TAG, "cannot erase the legacy AdiDeviceState with key spatial_audio_enabled");
    L13:
        if (settingsAdapter.putSecureStringForUser(contentResolver, "audio_device_inventory", settings, -2) == true) goto L15;
        Log.e(TAG, "error updating the new AdiDeviceState with key audio_device_inventory");
    L15:
        if (settings != null) goto L17;
        return;
    L17:
        if (settings.equals("") == true) goto L21;
        setDeviceSettings(settings);
        return;
    }

    void setDeviceSettings(String settings) {
        this.mDeviceInventory.setDeviceSettings(settings);
    }

    String getDeviceSettings() {
        return this.mDeviceInventory.getDeviceSettings();
    }

    Collection<AdiDeviceState> getImmutableDeviceInventory() {
        return this.mDeviceInventory.getImmutableDeviceInventory();
    }

    void addOrUpdateDeviceSAStateInInventory(AdiDeviceState deviceState, boolean syncInventory) {
        this.mDeviceInventory.addOrUpdateDeviceSAStateInInventory(deviceState, syncInventory);
    }

    void addOrUpdateBtAudioDeviceCategoryInInventory(AdiDeviceState deviceState, boolean syncInventory) {
        this.mDeviceInventory.addOrUpdateAudioDeviceCategoryInInventory(deviceState, syncInventory);
    }

    AdiDeviceState findDeviceStateForAudioDeviceAttributes(AudioDeviceAttributes ada, int canonicalType) {
        return this.mDeviceInventory.findDeviceStateForAudioDeviceAttributes(ada, canonicalType);
    }

    AdiDeviceState findBtDeviceStateForAddress(String address, int deviceType) {
        return this.mDeviceInventory.findBtDeviceStateForAddress(address, deviceType);
    }

    void addAudioDeviceWithCategoryInInventoryIfNeeded(String address, int btAudioDeviceCategory) {
        this.mDeviceInventory.addAudioDeviceWithCategoryInInventoryIfNeeded(address, btAudioDeviceCategory);
    }

    int getAndUpdateBtAdiDeviceStateCategoryForAddress(String address) {
        return this.mDeviceInventory.getAndUpdateBtAdiDeviceStateCategoryForAddress(address);
    }

    boolean isBluetoothAudioDeviceCategoryFixed(String address) {
        return this.mDeviceInventory.isBluetoothAudioDeviceCategoryFixed(address);
    }

    boolean isSADevice(AdiDeviceState deviceState) {
        return this.mAudioService.isSADevice(deviceState);
    }

    void clearDeviceInventory() {
        this.mDeviceInventory.clearDeviceInventory();
    }
}
