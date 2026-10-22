package com.android.server.audio;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothProfile;
import android.content.Intent;
import android.hardware.audio.common.V2_0.AudioDevice;
import android.media.AudioDescriptor;
import android.media.AudioDeviceAttributes;
import android.media.AudioDeviceInfo;
import android.media.AudioDevicePort;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioPort;
import android.media.AudioProfile;
import android.media.AudioRoutesInfo;
import android.media.AudioSystem;
import android.media.IAudioRoutesObserver;
import android.media.ICapturePresetDevicesRoleDispatcher;
import android.media.IStrategyNonDefaultDevicesDispatcher;
import android.media.IStrategyPreferredDevicesDispatcher;
import android.media.MediaMetrics;
import android.media.Utils;
import android.media.audiopolicy.AudioProductStrategy;
import android.media.permission.ClearCallingIdentityContext;
import android.media.permission.SafeCloseable;
import android.os.Binder;
import android.os.Bundle;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.os.SystemProperties;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.Log;
import android.util.Pair;
import android.util.Slog;
import com.android.server.location.StarLocation;
import com.android.server.utils.EventLogger;
import com.google.android.collect.Sets;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Stream;

/* JADX INFO: loaded from: classes.dex */
public class AudioDeviceInventory {
    private static final Set<Integer> BECOMING_NOISY_INTENT_DEVICES_SET = null;
    static final int BT_CONFIG_CHANGE_MUTE_DELAY_MS = 500;
    static final int[] CAPTURE_PRESETS = null;
    private static final String CONNECT_INTENT_KEY_ADDRESS = "address";
    private static final String CONNECT_INTENT_KEY_PORT_NAME = "portName";
    private static final String CONNECT_INTENT_KEY_STATE = "state";
    static final Set<Integer> DEVICE_OVERRIDE_A2DP_ROUTE_ON_PLUG_SET = null;
    private static final int MAX_DEVICE_INVENTORY_ENTRIES = 0;
    private static final int MAX_SETTINGS_LENGTH_PER_STRING = 32768;
    private static final String SETTING_DEVICE_SEPARATOR = "\\|";
    private static final String SETTING_DEVICE_SEPARATOR_CHAR = "|";
    private static final String TAG = "AS.AudioDeviceInventory";
    private static final String mMetricsId = "audio.device.";
    private final ArrayMap<Integer, String> mApmConnectedDevices;
    private final ArrayMap<Pair<Integer, Integer>, List<AudioDeviceAttributes>> mAppliedPresetRoles;
    private final ArrayMap<Pair<Integer, Integer>, List<AudioDeviceAttributes>> mAppliedPresetRolesInt;
    private final ArrayMap<Pair<Integer, Integer>, List<AudioDeviceAttributes>> mAppliedStrategyRoles;
    private final ArrayMap<Pair<Integer, Integer>, List<AudioDeviceAttributes>> mAppliedStrategyRolesInt;
    private final AudioSystemAdapter mAudioSystem;
    final boolean mBluetoothDualModeEnabled;
    private final LinkedHashMap<String, DeviceInfo> mConnectedDevices;
    final AudioRoutesInfo mCurAudioRoutes;
    final RemoteCallbackList<ICapturePresetDevicesRoleDispatcher> mDevRoleCapturePresetDispatchers;
    private AudioDeviceBroker mDeviceBroker;
    private final LinkedHashMap<Pair<Integer, String>, AdiDeviceState> mDeviceInventory;
    private final Object mDeviceInventoryLock;
    private final Object mDevicesLock;
    final RemoteCallbackList<IStrategyNonDefaultDevicesDispatcher> mNonDefDevDispatchers;
    private final ArrayMap<Integer, List<AudioDeviceAttributes>> mNonDefaultDevices;
    final RemoteCallbackList<IStrategyPreferredDevicesDispatcher> mPrefDevDispatchers;
    private final ArrayMap<Integer, List<AudioDeviceAttributes>> mPreferredDevices;
    private final ArrayMap<Integer, List<AudioDeviceAttributes>> mPreferredDevicesForCapturePreset;
    final RemoteCallbackList<IAudioRoutesObserver> mRoutesObservers;
    final List<AudioProductStrategy> mStrategies;

    interface AudioSystemInterface {
        int deviceRoleAction(int r1, int r2, List<AudioDeviceAttributes> r3);
    }

    static class DeviceInfo {
        List<AudioDescriptor> mAudioDescriptors;
        List<AudioProfile> mAudioProfiles;
        final String mDeviceAddress;
        int mDeviceCodecFormat;
        String mDeviceIdentityAddress;
        final String mDeviceName;
        final int mDeviceType;
        ArraySet<String> mDisabledModes;
        final int mGroupId;
        String mPeerDeviceAddress;
        String mPeerIdentityDeviceAddress;

        /* JADX INFO: renamed from: -$$Nest$smmakeDeviceListKey, reason: not valid java name */
        static /* bridge */ /* synthetic */ String m1966$$Nest$smmakeDeviceListKey(int r0, String r1) {
            return makeDeviceListKey(r0, r1);
        }

        DeviceInfo(int deviceType, String deviceName, String address, String identityAddress, int codecFormat, int groupId, String peerAddress, String peerIdentityAddress, List<AudioProfile> profiles, List<AudioDescriptor> descriptors) {
            this.mDisabledModes = new ArraySet(0);
            this.mDeviceType = deviceType;
            this.mDeviceName = TextUtils.emptyIfNull(deviceName);
            this.mDeviceAddress = TextUtils.emptyIfNull(address);
            this.mDeviceIdentityAddress = TextUtils.emptyIfNull(identityAddress);
            if (this.mDeviceIdentityAddress.isEmpty() == false) goto L5;
            this.mDeviceIdentityAddress = this.mDeviceAddress;
        L5:
            this.mDeviceCodecFormat = codecFormat;
            this.mGroupId = groupId;
            this.mPeerDeviceAddress = TextUtils.emptyIfNull(peerAddress);
            this.mPeerIdentityDeviceAddress = TextUtils.emptyIfNull(peerIdentityAddress);
            this.mAudioProfiles = profiles;
            this.mAudioDescriptors = descriptors;
        }

        DeviceInfo(int deviceType, String deviceName, String address, String identityAddress, int codecFormat, int groupId, String peerAddress, String peerIdentityAddress) {
            this(deviceType, deviceName, address, identityAddress, codecFormat, groupId, peerAddress, peerIdentityAddress, new ArrayList(), new ArrayList());
        }

        DeviceInfo(int deviceType, String deviceName, String address) {
            this(deviceType, deviceName, address, null, 0);
        }

        DeviceInfo(int deviceType, String deviceName, String address, List<AudioProfile> profiles, List<AudioDescriptor> descriptors) {
            this(deviceType, deviceName, address, null, 0, -1, null, null, profiles, descriptors);
        }

        DeviceInfo(int deviceType, String deviceName, String address, String identityAddress, int codecFormat) {
            this(deviceType, deviceName, address, identityAddress, codecFormat, -1, null, null);
        }

        void setModeDisabled(String mode) {
            this.mDisabledModes.add(mode);
        }

        void setModeEnabled(String mode) {
            this.mDisabledModes.remove(mode);
        }

        boolean isModeEnabled(String mode) {
            return !this.mDisabledModes.contains(mode);
        }

        boolean isOutputOnlyModeEnabled() {
            return isModeEnabled("audio_mode_output_only");
        }

        boolean isDuplexModeEnabled() {
            return isModeEnabled("audio_mode_duplex");
        }

        public String toString() {
            return "[DeviceInfo: type:0x" + Integer.toHexString(this.mDeviceType) + " (" + AudioSystem.getDeviceName(this.mDeviceType) + ") name:" + this.mDeviceName + " addr:" + Utils.anonymizeBluetoothAddress(this.mDeviceType, this.mDeviceAddress) + " identity addr:" + Utils.anonymizeBluetoothAddress(this.mDeviceType, this.mDeviceIdentityAddress) + " codec: " + Integer.toHexString(this.mDeviceCodecFormat) + " group:" + this.mGroupId + " peer addr:" + Utils.anonymizeBluetoothAddress(this.mDeviceType, this.mPeerDeviceAddress) + " peer identity addr:" + Utils.anonymizeBluetoothAddress(this.mDeviceType, this.mPeerIdentityDeviceAddress) + " disabled modes: " + this.mDisabledModes + "]";
        }

        String getKey() {
            return makeDeviceListKey(this.mDeviceType, this.mDeviceAddress);
        }

        private static String makeDeviceListKey(int device, String deviceAddress) {
            return "0x" + Integer.toHexString(device) + ":" + deviceAddress;
        }
    }

    static class WiredDeviceConnectionState {
        public final AudioDeviceAttributes mAttributes;
        public final String mCaller;
        public boolean mForTest;
        public final int mState;

        WiredDeviceConnectionState(AudioDeviceAttributes attributes, int state, String caller) {
            this.mForTest = false;
            this.mAttributes = attributes;
            this.mState = state;
            this.mCaller = caller;
        }
    }

    public static /* synthetic */ void $r8$lambda$0Wu0DddoQ0DvExkD6QqdHwFT7N4(PrintWriter r0, String r1, Pair r2, List r3) {
        lambda$dump$11(r0, r1, r2, r3);
    }

    public static /* synthetic */ int $r8$lambda$3JpQuW0fEkXN_dz7ArFEKHhVVVU(Integer r0) {
        return lambda$configureHdmiPlugIntent$39(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$3qr9rBJSnntGMIibQ9guvdVgf-k, reason: not valid java name */
    public static /* synthetic */ void m1948$r8$lambda$3qr9rBJSnntGMIibQ9guvdVgfk(PrintWriter r0, String r1, Integer r2, List r3) {
        lambda$dump$4(r0, r1, r2, r3);
    }

    /* JADX INFO: renamed from: $r8$lambda$7Ru-9dr9yi6cTykRb5FCHwwlb48, reason: not valid java name */
    public static /* synthetic */ int m1949$r8$lambda$7Ru9dr9yi6cTykRb5FCHwwlb48(AudioDeviceInventory r0, int r1, int r2, List r3) {
        return r0.lambda$clearDevicesRoleForStrategy$25(r1, r2, r3);
    }

    public static /* synthetic */ void $r8$lambda$AsNutghOnnqfRUT6rpHFpybZrH8(int r0, ArraySet r1, DeviceInfo r2) {
        lambda$disconnectLeAudio$36(r0, r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$DyWpUTH-InKbOjBNbJelhoGy6No, reason: not valid java name */
    public static /* synthetic */ void m1950$r8$lambda$DyWpUTHInKbOjBNbJelhoGy6No(ArraySet r0, DeviceInfo r1) {
        lambda$disconnectA2dpSink$32(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$Fj4RB4f-vyJVGmRzBjIeM7QkxY0, reason: not valid java name */
    public static /* synthetic */ AdiDeviceState m1951$r8$lambda$Fj4RB4fvyJVGmRzBjIeM7QkxY0(AdiDeviceState r0, AdiDeviceState r1) {
        return lambda$addOrUpdateDeviceSAStateInInventory$0(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$GiQeq_GwW5_ihd-5JQyF4n6GjNo, reason: not valid java name */
    public static /* synthetic */ boolean m1952$r8$lambda$GiQeq_GwW5_ihd5JQyF4n6GjNo(AudioDeviceInventory r0, DeviceInfo r1) {
        return r0.lambda$isCurrentDeviceConnected$38(r1);
    }

    public static /* synthetic */ void $r8$lambda$KMmbLCKyIVVmOEbRcwb2c5mUT88(AudioDeviceInventory r0, int r1, String r2) {
        r0.lambda$disconnectA2dp$31(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$KilBp2uKyUFQmXixg5Lud5vHNZE(PrintWriter r0, String r1, Pair r2, List r3) {
        lambda$dump$9(r0, r1, r2, r3);
    }

    public static /* synthetic */ int $r8$lambda$M8Y_GTscMoYhbtX6sAeAgchIhNY(AudioDeviceInventory r0, int r1, int r2, List r3) {
        return r0.lambda$setDevicesRoleForStrategy$23(r1, r2, r3);
    }

    public static /* synthetic */ int $r8$lambda$MVfpEx3HdZZ2Yl46fqtd4OkmY2M(AudioDeviceInventory r0, int r1, int r2, List r3) {
        return r0.lambda$purgeDevicesRoles_l$26(r1, r2, r3);
    }

    public static /* synthetic */ int $r8$lambda$NGcpIyRmlGpMhFvy8CK7ZRM5syo(AudioDeviceInventory r0, int r1, int r2, List r3) {
        return r0.lambda$addDevicesRoleForCapturePresetInt$16(r1, r2, r3);
    }

    /* JADX INFO: renamed from: $r8$lambda$Ni-7vZ6LfHwRAgAae8hqI8JZ-sc, reason: not valid java name */
    public static /* synthetic */ int m1953$r8$lambda$Ni7vZ6LfHwRAgAae8hqI8JZsc(AudioDeviceInventory r0, int r1, int r2, List r3) {
        return r0.lambda$addDevicesRoleForStrategy$21(r1, r2, r3);
    }

    /* JADX INFO: renamed from: $r8$lambda$NvZl-72QdIlDvWAoW5diECSsJ2E, reason: not valid java name */
    public static /* synthetic */ void m1954$r8$lambda$NvZl72QdIlDvWAoW5diECSsJ2E(AudioDeviceInventory r0, int r1, String r2) {
        r0.lambda$disconnectHearingAid$35(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$OdrMd3MT6ZlRe1Jp8S9FY9k9jbQ(AudioDeviceInventory r0, Integer r1, List r2) {
        r0.lambda$reapplyExternalDevicesRoles$14(r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$QQ2y-cFLpsalbjv_wnQ2dadr_a0, reason: not valid java name */
    public static /* synthetic */ AdiDeviceState m1955$r8$lambda$QQ2ycFLpsalbjv_wnQ2dadr_a0(AtomicBoolean r0, AdiDeviceState r1, AdiDeviceState r2) {
        return lambda$addOrUpdateAudioDeviceCategoryInInventory$1(r0, r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$QQrEKBO50Y59ImKNVdO-4QnMa7w, reason: not valid java name */
    public static /* synthetic */ int m1956$r8$lambda$QQrEKBO50Y59ImKNVdO4QnMa7w(AudioDeviceInventory r0, int r1, int r2, List r3) {
        return r0.lambda$setDevicesRoleForStrategy$24(r1, r2, r3);
    }

    /* JADX INFO: renamed from: $r8$lambda$TybcgZqThcPh-9RWiv5k7nTIxRM, reason: not valid java name */
    public static /* synthetic */ void m1957$r8$lambda$TybcgZqThcPh9RWiv5k7nTIxRM(AudioDeviceInventory r0, int r1, int r2, Pair r3) {
        r0.lambda$disconnectLeAudio$37(r1, r2, r3);
    }

    public static /* synthetic */ int $r8$lambda$VZrNAjreNSJ_VzC43TliU3phDdI(AudioDeviceInventory r0, int r1, int r2, List r3) {
        return r0.lambda$setDevicesRoleForCapturePreset$18(r1, r2, r3);
    }

    public static /* synthetic */ void $r8$lambda$WmaFiyuLvCqQClVdfDzP5w2wRyQ(PrintWriter r0, String r1, Pair r2, List r3) {
        lambda$dump$8(r0, r1, r2, r3);
    }

    /* JADX INFO: renamed from: $r8$lambda$XxehrWeMU3Y-uL-bY5GB6XlK84A, reason: not valid java name */
    public static /* synthetic */ int m1958$r8$lambda$XxehrWeMU3YuLbY5GB6XlK84A(AudioDeviceInventory r0, int r1, int r2, List r3) {
        return r0.lambda$removeDevicesRoleForCapturePresetInt$17(r1, r2, r3);
    }

    public static /* synthetic */ void $r8$lambda$Y97du0_fRV1Cami185QrZFQiYxg(ArraySet r0, DeviceInfo r1) {
        lambda$disconnectHearingAid$34(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$Zc09Axx1WmpzDRhhp3_QnrTQ9UE(ArraySet r0, DeviceInfo r1) {
        lambda$disconnectA2dp$30(r0, r1);
    }

    public static /* synthetic */ int $r8$lambda$aU_7GbpLfAxmss3qY1sQNzpyQN0(AudioDeviceInventory r0, int r1, int r2, List r3) {
        return r0.lambda$setDevicesRoleForCapturePreset$19(r1, r2, r3);
    }

    public static /* synthetic */ void $r8$lambda$b6DmpzgIgcV9GiOgI4G0KMJJpCk(PrintWriter r0, String r1, String r2, DeviceInfo r3) {
        lambda$dump$5(r0, r1, r2, r3);
    }

    /* JADX INFO: renamed from: $r8$lambda$cbRc7PCkdQ1d1Dios-De8H9mY8A, reason: not valid java name */
    public static /* synthetic */ void m1959$r8$lambda$cbRc7PCkdQ1d1DiosDe8H9mY8A(AudioDeviceInventory r0, Integer r1, List r2) {
        r0.lambda$reapplyExternalDevicesRoles$12(r1, r2);
    }

    public static /* synthetic */ int $r8$lambda$eTIciBIrIBohyfHVo_SpWowlIFo(AudioDeviceInventory r0, int r1, int r2, List r3) {
        return r0.lambda$removeDevicesRoleForStrategy$22(r1, r2, r3);
    }

    /* JADX INFO: renamed from: $r8$lambda$h_z-NM9CPm1APoDUGWIGGnGojvc, reason: not valid java name */
    public static /* synthetic */ void m1960$r8$lambda$h_zNM9CPm1APoDUGWIGGnGojvc(PrintWriter r0, Integer r1) {
        lambda$dump$2(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$kD-2oVR0646zwr9QgXHELH-31e4, reason: not valid java name */
    public static /* synthetic */ void m1961$r8$lambda$kD2oVR0646zwr9QgXHELH31e4(PrintWriter r0, String r1, Pair r2, List r3) {
        lambda$dump$10(r0, r1, r2, r3);
    }

    /* JADX INFO: renamed from: $r8$lambda$kzao3eyMm5COSl8jNw-irWsdGW4, reason: not valid java name */
    public static /* synthetic */ void m1962$r8$lambda$kzao3eyMm5COSl8jNwirWsdGW4(PrintWriter r0, String r1, Integer r2, List r3) {
        lambda$dump$3(r0, r1, r2, r3);
    }

    /* JADX INFO: renamed from: $r8$lambda$lADSeRxuJ2VLR7M7dTO-RWjMjzE, reason: not valid java name */
    public static /* synthetic */ void m1963$r8$lambda$lADSeRxuJ2VLR7M7dTORWjMjzE(PrintWriter r0, String r1, Integer r2, List r3) {
        lambda$dump$7(r0, r1, r2, r3);
    }

    public static /* synthetic */ void $r8$lambda$lJYVBLK82t56_QmmxAqaDxd7xJI(PrintWriter r0, String r1, Integer r2, String r3) {
        lambda$dump$6(r0, r1, r2, r3);
    }

    public static /* synthetic */ boolean $r8$lambda$m1jZvhV5_g0DXAaMGaIUycMZ_MA(AudioDeviceAttributes r0, AudioDeviceInfo r1) {
        return lambda$purgeRoles$28(r0, r1);
    }

    public static /* synthetic */ int $r8$lambda$npd0RnVVySh6v54qvNpaXxxZ4VI(AudioDeviceInventory r0, int r1, int r2, List r3) {
        return r0.lambda$clearDevicesRoleForCapturePreset$20(r1, r2, r3);
    }

    public static /* synthetic */ void $r8$lambda$oqrdAiylfg0f1D8LjYpib2rajGc(AudioDeviceInventory r0, String r1) {
        r0.lambda$disconnectA2dpSink$33(r1);
    }

    public static /* synthetic */ boolean $r8$lambda$q_o3SyyCekiSrCL5hOcPO8gfRCI(AudioDeviceAttributes r0, AudioDeviceInfo r1) {
        return lambda$purgeRoles$29(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$u-8GH9DcPTZOZ9Aa2Zd9hNaoCwg, reason: not valid java name */
    public static /* synthetic */ boolean m1964$r8$lambda$u8GH9DcPTZOZ9Aa2Zd9hNaoCwg(DeviceInfo r0, int r1) {
        return lambda$onToggleHdmi$15(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$vDJjZx3YLThQhD2bB-1H8i8-VOo, reason: not valid java name */
    public static /* synthetic */ void m1965$r8$lambda$vDJjZx3YLThQhD2bB1H8i8VOo(AudioDeviceInventory r0, Integer r1, List r2) {
        r0.lambda$reapplyExternalDevicesRoles$13(r1, r2);
    }

    public static /* synthetic */ int $r8$lambda$w0mhWBgDP8f1DzVhlvU3GbZmOlg(AudioDeviceInventory r0, int r1, int r2, List r3) {
        return r0.lambda$purgeDevicesRoles_l$27(r1, r2, r3);
    }

    static {
        MAX_DEVICE_INVENTORY_ENTRIES = 32768 / AdiDeviceState.getPeristedMaxSize();
        DEVICE_OVERRIDE_A2DP_ROUTE_ON_PLUG_SET = new HashSet();
        DEVICE_OVERRIDE_A2DP_ROUTE_ON_PLUG_SET.add(4);
        DEVICE_OVERRIDE_A2DP_ROUTE_ON_PLUG_SET.add(8);
        DEVICE_OVERRIDE_A2DP_ROUTE_ON_PLUG_SET.add(131072);
        DEVICE_OVERRIDE_A2DP_ROUTE_ON_PLUG_SET.addAll(AudioSystem.DEVICE_OUT_ALL_USB_SET);
        CAPTURE_PRESETS = new int[]{1, 5, 6, 7, 9, 10, 1999};
        BECOMING_NOISY_INTENT_DEVICES_SET = new HashSet();
        BECOMING_NOISY_INTENT_DEVICES_SET.add(4);
        BECOMING_NOISY_INTENT_DEVICES_SET.add(8);
        BECOMING_NOISY_INTENT_DEVICES_SET.add(1024);
        BECOMING_NOISY_INTENT_DEVICES_SET.add(2048);
        BECOMING_NOISY_INTENT_DEVICES_SET.add(131072);
        BECOMING_NOISY_INTENT_DEVICES_SET.add(134217728);
        BECOMING_NOISY_INTENT_DEVICES_SET.add(536870912);
        BECOMING_NOISY_INTENT_DEVICES_SET.add(536870914);
        BECOMING_NOISY_INTENT_DEVICES_SET.addAll(AudioSystem.DEVICE_OUT_ALL_A2DP_SET);
        BECOMING_NOISY_INTENT_DEVICES_SET.addAll(AudioSystem.DEVICE_OUT_ALL_USB_SET);
        BECOMING_NOISY_INTENT_DEVICES_SET.addAll(AudioSystem.DEVICE_OUT_ALL_BLE_SET);
    }

    Collection<AdiDeviceState> getImmutableDeviceInventory() {
        Object r0 = this.mDeviceInventoryLock;
        monitor-enter(r0);
        List<AdiDeviceState> newList = new ArrayList(this.mDeviceInventory.values());     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return newList;
    L7:
        th = move-exception;
        throw th;
    }

    void addOrUpdateDeviceSAStateInInventory(AdiDeviceState deviceState, boolean syncInventory) {
        Object r0 = this.mDeviceInventoryLock;
        monitor-enter(r0);
        this.mDeviceInventory.merge(deviceState.getDeviceId(), deviceState, new AudioDeviceInventory$$ExternalSyntheticLambda23());     // Catch: Throwable -> L9
        checkDeviceInventorySize_l();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        if (syncInventory == false) goto L14;
        this.mDeviceBroker.postSynchronizeAdiDevicesInInventory(deviceState);
        return;
    L14:
        return;
    L9:
        th = move-exception;
        throw th;
    }

    private static /* synthetic */ AdiDeviceState lambda$addOrUpdateDeviceSAStateInInventory$0(AdiDeviceState oldState, AdiDeviceState newState) {
        oldState.setHasHeadTracker(newState.hasHeadTracker());
        oldState.setHeadTrackerEnabled(newState.isHeadTrackerEnabled());
        oldState.setSAEnabled(newState.isSAEnabled());
        return oldState;
    }

    void addAudioDeviceInInventoryIfNeeded(int deviceType, String address, String peerAddress, int category, boolean userDefined) {
        if (AudioSystem.isBluetoothOutDevice(deviceType) == true) goto L5;
        return;
    L5:
        Object r0 = this.mDeviceInventoryLock;
        monitor-enter(r0);
        AdiDeviceState ads = findBtDeviceStateForAddress(address, deviceType);     // Catch: Throwable -> L11
        if (ads != null) goto L13;
        if (peerAddress == null) goto L13;
        ads = findBtDeviceStateForAddress(peerAddress, deviceType);     // Catch: Throwable -> L11
    L13:
        if (ads != null) goto L15;
        AdiDeviceState ads2 = new AdiDeviceState(AudioDeviceInfo.convertInternalDeviceToDeviceType(deviceType), deviceType, address);     // Catch: Throwable -> L11
        ads2.setAudioDeviceCategory(category);     // Catch: Throwable -> L11
        this.mDeviceInventory.put(ads2.getDeviceId(), ads2);     // Catch: Throwable -> L11
        checkDeviceInventorySize_l();     // Catch: Throwable -> L11
        this.mDeviceBroker.postUpdatedAdiDeviceState(ads2, true);     // Catch: Throwable -> L11
        this.mDeviceBroker.postPersistAudioDeviceSettings();     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L15:
        if (ads.getAudioDeviceCategory() == category) goto L19;
        if (userDefined == true) goto L18;
        if (category == 0) goto L19;
    L18:
        ads.setAudioDeviceCategory(category);     // Catch: Throwable -> L11
        this.mDeviceBroker.postUpdatedAdiDeviceState(ads, false);     // Catch: Throwable -> L11
        this.mDeviceBroker.postPersistAudioDeviceSettings();     // Catch: Throwable -> L11
    L19:
        this.mDeviceBroker.postSynchronizeAdiDevicesInInventory(ads);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    void addOrUpdateAudioDeviceCategoryInInventory(AdiDeviceState deviceState, boolean syncInventory) {
        final AtomicBoolean updatedCategory = new AtomicBoolean(false);
        Object r2 = this.mDeviceInventoryLock;
        monitor-enter(r2);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (deviceState.updateAudioDeviceCategory() == false) goto L9;
        updatedCategory.set(true);     // Catch: Throwable -> L7
    L9:
        AdiDeviceState deviceState2 = this.mDeviceInventory.merge(deviceState.getDeviceId(), deviceState, new AudioDeviceInventory$$ExternalSyntheticLambda7(updatedCategory));     // Catch: Throwable -> L7
        checkDeviceInventorySize_l();     // Catch: Throwable -> L7
        monitor-exit(r2);     // Catch: Throwable -> L7
        if (updatedCategory.get() == false) goto L14;
        this.mDeviceBroker.postUpdatedAdiDeviceState(deviceState2, false);
    L14:
        if (syncInventory == false) goto L21;
        this.mDeviceBroker.postSynchronizeAdiDevicesInInventory(deviceState2);
        return;
    }

    private static /* synthetic */ AdiDeviceState lambda$addOrUpdateAudioDeviceCategoryInInventory$1(AtomicBoolean updatedCategory, AdiDeviceState oldState, AdiDeviceState newState) {
        if (oldState.getAudioDeviceCategory() == newState.getAudioDeviceCategory()) goto L5;
        oldState.setAudioDeviceCategory(newState.getAudioDeviceCategory());
        updatedCategory.set(true);
    L5:
        return oldState;
    }

    void addAudioDeviceWithCategoryInInventoryIfNeeded(String address, int btAudioDeviceCategory) {
        addAudioDeviceInInventoryIfNeeded(536870912, address, "", btAudioDeviceCategory, true);
        addAudioDeviceInInventoryIfNeeded(128, address, "", btAudioDeviceCategory, true);
    }

    int getAndUpdateBtAdiDeviceStateCategoryForAddress(String address) {
        int btCategory = 0;
        boolean bleCategoryFound = false;
        AdiDeviceState deviceState = findBtDeviceStateForAddress(address, 536870912);
        if (deviceState == null) goto L5;
        addOrUpdateAudioDeviceCategoryInInventory(deviceState, true);
        btCategory = deviceState.getAudioDeviceCategory();
        bleCategoryFound = true;
    L5:
        AdiDeviceState deviceState2 = findBtDeviceStateForAddress(address, 128);
        if (deviceState2 == null) goto L13;
        addOrUpdateAudioDeviceCategoryInInventory(deviceState2, true);
        int a2dpCategory = deviceState2.getAudioDeviceCategory();
        if (bleCategoryFound == false) goto L12;
        if (a2dpCategory == btCategory) goto L12;
        Log.w(TAG, "Found different audio device category for A2DP and BLE profiles with address " + address);
    L12:
        return a2dpCategory;
    L13:
        return btCategory;
    }

    boolean isBluetoothAudioDeviceCategoryFixed(String address) {
        AdiDeviceState deviceState = findBtDeviceStateForAddress(address, 536870912);
        if (deviceState != null) goto L5;
        AdiDeviceState deviceState2 = findBtDeviceStateForAddress(address, 128);
        if (deviceState2 != null) goto L9;
        return false;
    L9:
        return deviceState2.isBtDeviceCategoryFixed();
    L5:
        return deviceState.isBtDeviceCategoryFixed();
    }

    void onSynchronizeAdiDevicesInInventory(AdiDeviceState updatedDevice) {
        Object r0 = this.mDevicesLock;
        monitor-enter(r0);
        Object r1 = this.mDeviceInventoryLock;     // Catch: Throwable -> L17
        monitor-enter(r1);     // Catch: Throwable -> L17
        if (updatedDevice == null) goto L10;
        onSynchronizeAdiDeviceInInventory_l(updatedDevice);     // Catch: Throwable -> L8
    L14:
        monitor-exit(r1);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L17
        return;
    L10:
        Iterator<AdiDeviceState> r2 = this.mDeviceInventory.values().iterator();     // Catch: Throwable -> L8
    L12:
        if (r2.hasNext() == false) goto L14;
        AdiDeviceState ads = r2.next();     // Catch: Throwable -> L8
        onSynchronizeAdiDeviceInInventory_l(ads);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        throw th;     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        throw th;
    }

    void onSynchronizeAdiDeviceInInventory_l(AdiDeviceState updatedDevice) {
        if (synchronizeBleDeviceInInventory(updatedDevice) == false) goto L5;
    L6:
        this.mDeviceBroker.postPersistAudioDeviceSettings();
        return;
    L5:
        if (synchronizeDeviceProfilesInInventory(updatedDevice) == true) goto L6;
    }

    private void checkDeviceInventorySize_l() {
        if (this.mDeviceInventory.size() <= MAX_DEVICE_INVENTORY_ENTRIES) goto L8;
        Iterator<Map.Entry<Pair<Integer, String>, AdiDeviceState>> iterator = this.mDeviceInventory.entrySet().iterator();
        if (iterator.hasNext() == false) goto L9;
        iterator.next();
        iterator.remove();
        return;
    L9:
        return;
    }

    private boolean synchronizeBleDeviceInInventory(AdiDeviceState updatedDevice) {
        Iterator<DeviceInfo> r0 = this.mConnectedDevices.values().iterator();
    L4:
        if (r0.hasNext() == false) goto L39;
        DeviceInfo di = r0.next();
        if (di.mDeviceType != updatedDevice.getInternalDeviceType()) goto L4;
        if (di.mDeviceAddress.equals(updatedDevice.getDeviceAddress()) == false) goto L24;
        Iterator<AdiDeviceState> r3 = this.mDeviceInventory.values().iterator();
    L12:
        if (r3.hasNext() == false) goto L24;
        AdiDeviceState ads2 = r3.next();
        if (di.mDeviceType != ads2.getInternalDeviceType()) goto L12;
        if (di.mPeerDeviceAddress.equals(ads2.getDeviceAddress()) == false) goto L12;
        if (this.mDeviceBroker.isSADevice(updatedDevice) != this.mDeviceBroker.isSADevice(ads2)) goto L21;
        ads2.setHasHeadTracker(updatedDevice.hasHeadTracker());
        ads2.setHeadTrackerEnabled(updatedDevice.isHeadTrackerEnabled());
        ads2.setSAEnabled(updatedDevice.isSAEnabled());
    L21:
        ads2.setAudioDeviceCategory(updatedDevice.getAudioDeviceCategory());
        this.mDeviceBroker.postUpdatedAdiDeviceState(ads2, false);
        AudioService.sDeviceLogger.enqueue(new EventLogger.StringEvent("synchronizeBleDeviceInInventory synced device pair ads1=" + updatedDevice + " ads2=" + ads2).printLog(TAG));
        return true;
    L24:
        if (di.mPeerDeviceAddress.equals(updatedDevice.getDeviceAddress()) == false) goto L4;
        Iterator<AdiDeviceState> r4 = this.mDeviceInventory.values().iterator();
    L27:
        if (r4.hasNext() == false) goto L4;
        AdiDeviceState ads3 = r4.next();
        if (di.mDeviceType != ads3.getInternalDeviceType()) goto L27;
        if (di.mDeviceAddress.equals(ads3.getDeviceAddress()) == false) goto L27;
        if (this.mDeviceBroker.isSADevice(updatedDevice) != this.mDeviceBroker.isSADevice(ads3)) goto L36;
        ads3.setHasHeadTracker(updatedDevice.hasHeadTracker());
        ads3.setHeadTrackerEnabled(updatedDevice.isHeadTrackerEnabled());
        ads3.setSAEnabled(updatedDevice.isSAEnabled());
    L36:
        ads3.setAudioDeviceCategory(updatedDevice.getAudioDeviceCategory());
        this.mDeviceBroker.postUpdatedAdiDeviceState(ads3, false);
        AudioService.sDeviceLogger.enqueue(new EventLogger.StringEvent("synchronizeBleDeviceInInventory synced device pair ads1=" + updatedDevice + " peer ads2=" + ads3).printLog(TAG));
        return true;
    L39:
        return false;
    }

    private boolean synchronizeDeviceProfilesInInventory(AdiDeviceState updatedDevice) {
        Iterator<AdiDeviceState> r0 = this.mDeviceInventory.values().iterator();
    L4:
        if (r0.hasNext() == false) goto L12;
        AdiDeviceState ads = r0.next();
        if (updatedDevice.getInternalDeviceType() == ads.getInternalDeviceType()) goto L4;
        if (updatedDevice.getDeviceAddress().equals(ads.getDeviceAddress()) == false) goto L4;
        ads.setAudioDeviceCategory(updatedDevice.getAudioDeviceCategory());
        this.mDeviceBroker.postUpdatedAdiDeviceState(ads, false);
        AudioService.sDeviceLogger.enqueue(new EventLogger.StringEvent("synchronizeDeviceProfilesInInventory synced device pair ads1=" + updatedDevice + " ads2=" + ads).printLog(TAG));
        return true;
    L12:
        return false;
    }

    public AdiDeviceState findBtDeviceStateForAddress(String address, int deviceType) {
        if (AudioSystem.isBluetoothA2dpOutDevice(deviceType) == false) goto L6;
        Set<Integer> deviceSet = AudioSystem.DEVICE_OUT_ALL_A2DP_SET;
    L14:
        Object r2 = this.mDeviceInventoryLock;
        monitor-enter(r2);
        Iterator<Integer> r3 = deviceSet.iterator();     // Catch: Throwable -> L23
    L18:
        if (r3.hasNext() == false) goto L26;
        Integer internalType = r3.next();     // Catch: Throwable -> L23
        AdiDeviceState deviceState = this.mDeviceInventory.get(new Pair(internalType, address));     // Catch: Throwable -> L23
        if (deviceState == null) goto L18;
        monitor-exit(r2);     // Catch: Throwable -> L23
        return deviceState;
    L26:
        monitor-exit(r2);     // Catch: Throwable -> L23
        return null;
    L23:
        th = move-exception;
        throw th;
    L6:
        if (AudioSystem.isBluetoothLeOutDevice(deviceType) == false) goto L9;
        deviceSet = AudioSystem.DEVICE_OUT_ALL_BLE_SET;
        goto L14
    L9:
        if (AudioSystem.isBluetoothScoOutDevice(deviceType) == false) goto L12;
        deviceSet = AudioSystem.DEVICE_OUT_ALL_SCO_SET;
        goto L14
    L12:
        if (deviceType != 134217728) goto L30;
        Set<Integer> deviceSet2 = new HashSet();
        deviceSet2.add(134217728);
        deviceSet = deviceSet2;
        goto L14
    L30:
        return null;
    }

    AdiDeviceState findDeviceStateForAudioDeviceAttributes(AudioDeviceAttributes ada, int canonicalDeviceType) {
        boolean isWireless = AudioSystem.isBluetoothDevice(ada.getInternalType());
        Object r1 = this.mDeviceInventoryLock;
        monitor-enter(r1);
        Iterator<AdiDeviceState> r2 = this.mDeviceInventory.values().iterator();     // Catch: Throwable -> L13
    L6:
        if (r2.hasNext() == false) goto L18;
        AdiDeviceState deviceState = r2.next();     // Catch: Throwable -> L13
        if (deviceState.getDeviceType() != canonicalDeviceType) goto L6;
        if (isWireless == false) goto L15;
        if (ada.getAddress().equals(deviceState.getDeviceAddress()) == false) goto L6;
    L15:
        monitor-exit(r1);     // Catch: Throwable -> L13
        return deviceState;
    L18:
        monitor-exit(r1);     // Catch: Throwable -> L13
        return null;
    L13:
        th = move-exception;
        throw th;
    }

    void clearDeviceInventory() {
        Object r0 = this.mDeviceInventoryLock;
        monitor-enter(r0);
        this.mDeviceInventory.clear();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    Collection<DeviceInfo> getConnectedDevices() {
        Object r0 = this.mDevicesLock;
        monitor-enter(r0);
        Collection<DeviceInfo> r1 = this.mConnectedDevices.values();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    AudioDeviceInventory(AudioDeviceBroker broker) {
        this(broker, AudioSystemAdapter.getDefaultAdapter());
    }

    AudioDeviceInventory(AudioSystemAdapter audioSystem) {
        this(null, audioSystem);
    }

    private AudioDeviceInventory(AudioDeviceBroker broker, AudioSystemAdapter audioSystem) {
        this.mDevicesLock = new Object();
        this.mDeviceInventoryLock = new Object();
        this.mDeviceInventory = new LinkedHashMap();
        this.mConnectedDevices = new AnonymousClass1(this);
        this.mApmConnectedDevices = new ArrayMap();
        this.mPreferredDevices = new ArrayMap();
        this.mNonDefaultDevices = new ArrayMap();
        this.mPreferredDevicesForCapturePreset = new ArrayMap();
        this.mCurAudioRoutes = new AudioRoutesInfo();
        this.mRoutesObservers = new RemoteCallbackList();
        this.mPrefDevDispatchers = new RemoteCallbackList();
        this.mNonDefDevDispatchers = new RemoteCallbackList();
        this.mDevRoleCapturePresetDispatchers = new RemoteCallbackList();
        this.mAppliedStrategyRoles = new ArrayMap();
        this.mAppliedStrategyRolesInt = new ArrayMap();
        this.mAppliedPresetRoles = new ArrayMap();
        this.mAppliedPresetRolesInt = new ArrayMap();
        this.mDeviceBroker = broker;
        this.mAudioSystem = audioSystem;
        this.mStrategies = AudioProductStrategy.getAudioProductStrategies();
        this.mBluetoothDualModeEnabled = SystemProperties.getBoolean("persist.bluetooth.enable_dual_mode_audio", false);
    }

    void setDeviceBroker(AudioDeviceBroker broker) {
        this.mDeviceBroker = broker;
    }

    void dump(final PrintWriter pw, final String prefix) {
        pw.println("\n" + prefix + "BECOMING_NOISY_INTENT_DEVICES_SET=");
        BECOMING_NOISY_INTENT_DEVICES_SET.forEach(new AudioDeviceInventory$$ExternalSyntheticLambda12(pw));
        pw.println("\n" + prefix + "Preferred devices for strategy:");
        this.mPreferredDevices.forEach(new AudioDeviceInventory$$ExternalSyntheticLambda13(pw, prefix));
        pw.println("\n" + prefix + "Non-default devices for strategy:");
        this.mNonDefaultDevices.forEach(new AudioDeviceInventory$$ExternalSyntheticLambda14(pw, prefix));
        pw.println("\n" + prefix + "Connected devices:");
        this.mConnectedDevices.forEach(new AudioDeviceInventory$$ExternalSyntheticLambda15(pw, prefix));
        pw.println("\n" + prefix + "APM Connected device (A2DP sink only):");
        this.mApmConnectedDevices.forEach(new AudioDeviceInventory$$ExternalSyntheticLambda16(pw, prefix));
        pw.println("\n" + prefix + "Preferred devices for capture preset:");
        this.mPreferredDevicesForCapturePreset.forEach(new AudioDeviceInventory$$ExternalSyntheticLambda17(pw, prefix));
        pw.println("\n" + prefix + "Applied devices roles for strategies (from API):");
        this.mAppliedStrategyRoles.forEach(new AudioDeviceInventory$$ExternalSyntheticLambda18(pw, prefix));
        pw.println("\n" + prefix + "Applied devices roles for strategies (internal):");
        this.mAppliedStrategyRolesInt.forEach(new AudioDeviceInventory$$ExternalSyntheticLambda19(pw, prefix));
        pw.println("\n" + prefix + "Applied devices roles for presets (from API):");
        this.mAppliedPresetRoles.forEach(new AudioDeviceInventory$$ExternalSyntheticLambda20(pw, prefix));
        pw.println("\n" + prefix + "Applied devices roles for presets (internal:");
        this.mAppliedPresetRolesInt.forEach(new AudioDeviceInventory$$ExternalSyntheticLambda21(pw, prefix));
        pw.println("\ndevices:\n");
        Object r0 = this.mDeviceInventoryLock;
        monitor-enter(r0);
        Iterator<AdiDeviceState> r1 = this.mDeviceInventory.values().iterator();     // Catch: Throwable -> L8
    L6:
        if (r1.hasNext() == false) goto L10;
        AdiDeviceState device = r1.next();     // Catch: Throwable -> L8
        pw.println("\t" + device + "\n");     // Catch: Throwable -> L8
        goto L6
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private static /* synthetic */ void lambda$dump$2(PrintWriter pw, Integer device) {
        pw.print(" 0x" + Integer.toHexString(device.intValue()));
    }

    private static /* synthetic */ void lambda$dump$3(PrintWriter pw, String prefix, Integer strategy, List device) {
        pw.println("  " + prefix + "strategy:" + strategy + " device:" + device);
    }

    private static /* synthetic */ void lambda$dump$4(PrintWriter pw, String prefix, Integer strategy, List device) {
        pw.println("  " + prefix + "strategy:" + strategy + " device:" + device);
    }

    private static /* synthetic */ void lambda$dump$5(PrintWriter pw, String prefix, String key, DeviceInfo deviceInfo) {
        pw.println("  " + prefix + deviceInfo.toString());
    }

    private static /* synthetic */ void lambda$dump$6(PrintWriter pw, String prefix, Integer keyType, String valueAddress) {
        pw.println("  " + prefix + " type:0x" + Integer.toHexString(keyType.intValue()) + " (" + AudioSystem.getDeviceName(keyType.intValue()) + ") addr:" + Utils.anonymizeBluetoothAddress(keyType.intValue(), valueAddress));
    }

    private static /* synthetic */ void lambda$dump$7(PrintWriter pw, String prefix, Integer capturePreset, List devices) {
        pw.println("  " + prefix + "capturePreset:" + capturePreset + " devices:" + devices);
    }

    private static /* synthetic */ void lambda$dump$8(PrintWriter pw, String prefix, Pair key, List devices) {
        pw.println("  " + prefix + "strategy: " + key.first + " role:" + key.second + " devices:" + devices);
    }

    private static /* synthetic */ void lambda$dump$9(PrintWriter pw, String prefix, Pair key, List devices) {
        pw.println("  " + prefix + "strategy: " + key.first + " role:" + key.second + " devices:" + devices);
    }

    private static /* synthetic */ void lambda$dump$10(PrintWriter pw, String prefix, Pair key, List devices) {
        pw.println("  " + prefix + "preset: " + key.first + " role:" + key.second + " devices:" + devices);
    }

    private static /* synthetic */ void lambda$dump$11(PrintWriter pw, String prefix, Pair key, List devices) {
        pw.println("  " + prefix + "preset: " + key.first + " role:" + key.second + " devices:" + devices);
    }

    void onRestoreDevices() {
        Object r0 = this.mDevicesLock;
        monitor-enter(r0);
        new ArrayList(0);     // Catch: Throwable -> L8
        Iterator<DeviceInfo> r3 = this.mConnectedDevices.values().iterator();     // Catch: Throwable -> L8
    L6:
        if (r3.hasNext() == false) goto L10;
        DeviceInfo di = r3.next();     // Catch: Throwable -> L8
        this.mAudioSystem.setDeviceConnectionState(new AudioDeviceAttributes(di.mDeviceType, di.mDeviceAddress, di.mDeviceName), 1, di.mDeviceCodecFormat, false);     // Catch: Throwable -> L8
        goto L6
    L10:
        this.mAppliedStrategyRolesInt.clear();     // Catch: Throwable -> L8
        this.mAppliedPresetRolesInt.clear();     // Catch: Throwable -> L8
        applyConnectedDevicesRoles_l();     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        reapplyExternalDevicesRoles();
        return;
    L8:
        th = move-exception;
        throw th;
    }

    void reapplyExternalDevicesRoles() {
        Object r0 = this.mDevicesLock;
        monitor-enter(r0);
        this.mAppliedStrategyRoles.clear();     // Catch: Throwable -> L7
        this.mAppliedPresetRoles.clear();     // Catch: Throwable -> L7
        this.mPreferredDevices.forEach(new AudioDeviceInventory$$ExternalSyntheticLambda37(this));     // Catch: Throwable -> L7
        this.mNonDefaultDevices.forEach(new AudioDeviceInventory$$ExternalSyntheticLambda38(this));     // Catch: Throwable -> L7
        this.mPreferredDevicesForCapturePreset.forEach(new AudioDeviceInventory$$ExternalSyntheticLambda39(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$reapplyExternalDevicesRoles$12(Integer strategy, List devices) {
        setPreferredDevicesForStrategy(strategy.intValue(), devices);
    }

    private /* synthetic */ void lambda$reapplyExternalDevicesRoles$13(Integer strategy, List devices) {
        addDevicesRoleForStrategy(strategy.intValue(), 2, devices, false);
    }

    private /* synthetic */ void lambda$reapplyExternalDevicesRoles$14(Integer capturePreset, List devices) {
        setDevicesRoleForCapturePreset(capturePreset.intValue(), 1, devices);
    }

    public void onSetBtActiveDevice(AudioDeviceBroker.BtDeviceInfo btInfo, int codec, int streamType) {
        Log.d(TAG, "onSetBtActiveDevice btDevice=" + btInfo.mDevice + " profile=" + BluetoothProfile.getProfileName(btInfo.mProfile) + " state=" + BluetoothProfile.getConnectionStateName(btInfo.mState) + " isDeviceSwitch=" + btInfo.mIsDeviceSwitch);
        String address = btInfo.mDevice.getAddress();
        if (BluetoothAdapter.checkBluetoothAddress(address) == true) goto L5;
        address = "";
    L5:
        AudioService.sDeviceLogger.enqueue(new EventLogger.StringEvent("BT connected:" + btInfo + " codec=" + AudioSystem.audioFormatToString(codec)));
        MediaMetrics.Item r1 = new MediaMetrics.Item("audio.device.onSetBtActiveDevice").set(MediaMetrics.Property.STATUS, Integer.valueOf(btInfo.mProfile)).set(MediaMetrics.Property.DEVICE, AudioSystem.getDeviceName(btInfo.mAudioSystemDevice)).set(MediaMetrics.Property.ADDRESS, address).set(MediaMetrics.Property.ENCODING, AudioSystem.audioFormatToString(codec)).set(MediaMetrics.Property.EVENT, "onSetBtActiveDevice").set(MediaMetrics.Property.STREAM_TYPE, AudioSystem.streamToString(streamType));
        MediaMetrics.Key r2 = MediaMetrics.Property.STATE;
        if (btInfo.mState != 2) goto L8;
        String r3 = "connected";
    L9:
        r1.set(r2, r3).record();
        Object r4 = this.mDevicesLock;
        monitor-enter(r4);
        String key = DeviceInfo.m1966$$Nest$smmakeDeviceListKey(btInfo.mAudioSystemDevice, address);     // Catch: Throwable -> L19
        DeviceInfo di = this.mConnectedDevices.get(key);     // Catch: Throwable -> L19
        boolean switchToAvailable = true;
        if (di == null) goto L14;
        boolean isConnected = true;
    L15:
        if (isConnected == true) goto L17;
    L21:
        boolean switchToUnavailable = false;
    L23:
        if (isConnected == false) goto L25;
    L27:
        switchToAvailable = false;
    L29:
        switch(btInfo.mProfile) {
            case 1: goto L52;
            case 2: goto L44;
            case 11: goto L40;
            case 21: goto L36;
            case 22: goto L32;
            case 26: goto L32;
            default: goto L31;
        };     // Catch: Throwable -> L19
    L32:
        if (switchToUnavailable == false) goto L34;
        makeLeAudioDeviceUnavailableNow(address, btInfo.mAudioSystemDevice, di.mDeviceCodecFormat, btInfo.mIsDeviceSwitch);     // Catch: Throwable -> L19
    L57:
        monitor-exit(r4);     // Catch: Throwable -> L19
        return;
    L34:
        if (switchToAvailable == false) goto L57;
        makeLeAudioDeviceAvailable(btInfo, streamType, codec, "onSetBtActiveDevice");     // Catch: Throwable -> L19
        goto L57
    L36:
        if (switchToUnavailable == false) goto L38;
        makeHearingAidDeviceUnavailable(address, btInfo.mIsDeviceSwitch);     // Catch: Throwable -> L19
        goto L57
    L38:
        if (switchToAvailable == false) goto L57;
        makeHearingAidDeviceAvailable(address, BtHelper.getName(btInfo.mDevice), streamType, "onSetBtActiveDevice");     // Catch: Throwable -> L19
        goto L57
    L40:
        if (switchToUnavailable == false) goto L42;
        makeA2dpSrcUnavailable(address);     // Catch: Throwable -> L19
        goto L57
    L42:
        if (switchToAvailable == false) goto L57;
        makeA2dpSrcAvailable(address, codec);     // Catch: Throwable -> L19
        goto L57
    L44:
        if (switchToUnavailable == false) goto L46;
        makeA2dpDeviceUnavailableNow(address, di.mDeviceCodecFormat, btInfo.mIsDeviceSwitch);     // Catch: Throwable -> L19
        goto L57
    L46:
        if (switchToAvailable == false) goto L57;
        if (btInfo.mVolume == (-1)) goto L50;
        this.mDeviceBroker.postSetVolumeIndexOnDevice(3, btInfo.mVolume * 10, btInfo.mAudioSystemDevice, "onSetBtActiveDevice");     // Catch: Throwable -> L19
    L50:
        makeA2dpDeviceAvailable(btInfo, codec, "onSetBtActiveDevice");     // Catch: Throwable -> L19
        goto L57
    L31:
        throw new IllegalArgumentException("Invalid profile " + BluetoothProfile.getProfileName(btInfo.mProfile));     // Catch: Throwable -> L19
    L52:
        if (this.mDeviceBroker.isScoManagedByAudio() == false) goto L57;
        if (switchToUnavailable == false) goto L55;
        this.mDeviceBroker.onSetBtScoActiveDevice(null, btInfo.mIsDeviceSwitch);     // Catch: Throwable -> L19
        goto L57
    L55:
        if (switchToAvailable == false) goto L57;
        this.mDeviceBroker.onSetBtScoActiveDevice(btInfo.mDevice, false);     // Catch: Throwable -> L19
        goto L57
    L25:
        if (btInfo.mState != 2) goto L27;
    L17:
        if (btInfo.mState == 2) goto L21;
        switchToUnavailable = true;
        goto L23
    L14:
        isConnected = false;
    L19:
        th = move-exception;
        throw th;
    L8:
        r3 = "disconnected";
        goto L9
    }

    int onBluetoothDeviceConfigChange(AudioDeviceBroker.BtDeviceInfo btInfo, int codec, boolean codecChanged, int event) {
        MediaMetrics.Item mmi = new MediaMetrics.Item("audio.device.onBluetoothDeviceConfigChange").set(MediaMetrics.Property.EVENT, BtHelper.deviceEventToString(event));
        BluetoothDevice btDevice = btInfo.mDevice;
        if (btDevice != null) goto L6;
        mmi.set(MediaMetrics.Property.EARLY_RETURN, "btDevice null").record();
        return 0;
    L6:
        Log.d(TAG, "onBluetoothDeviceConfigChange btDevice=" + btDevice);
        int volume = btInfo.mVolume;
        String address = btDevice.getAddress();
        if (BluetoothAdapter.checkBluetoothAddress(address) == true) goto L9;
        String address2 = "";
    L10:
        AudioService.sDeviceLogger.enqueue(new EventLogger.StringEvent("onBluetoothDeviceConfigChange addr=" + address2 + " event=" + BtHelper.deviceEventToString(event)));
        int deviceType = BtHelper.getTypeFromProfile(btInfo.mProfile, btInfo.mIsLeOutput);
        Object r10 = this.mDevicesLock;
        monitor-enter(r10);
    L17:
        th = move-exception;
        throw th;
    L13:
        if (this.mDeviceBroker.hasScheduledA2dpConnection(btDevice, btInfo.mProfile) == false) goto L19;
        AudioService.sDeviceLogger.enqueue(new EventLogger.StringEvent("A2dp config change ignored (scheduled connection change)").printLog(TAG));     // Catch: Throwable -> L17
        mmi.set(MediaMetrics.Property.EARLY_RETURN, "A2dp config change ignored").record();     // Catch: Throwable -> L17
        monitor-exit(r10);     // Catch: Throwable -> L17
        return 0;
    L19:
        String key = DeviceInfo.m1966$$Nest$smmakeDeviceListKey(deviceType, address2);     // Catch: Throwable -> L17
        DeviceInfo di = this.mConnectedDevices.get(key);     // Catch: Throwable -> L17
        if (di != null) goto L24;
        Log.e(TAG, "invalid null DeviceInfo in onBluetoothDeviceConfigChange");     // Catch: Throwable -> L17
        mmi.set(MediaMetrics.Property.EARLY_RETURN, "null DeviceInfo").record();     // Catch: Throwable -> L17
        monitor-exit(r10);     // Catch: Throwable -> L17
        return 0;
    L24:
        mmi.set(MediaMetrics.Property.ADDRESS, address2).set(MediaMetrics.Property.ENCODING, AudioSystem.audioFormatToString(codec)).set(MediaMetrics.Property.INDEX, Integer.valueOf(volume)).set(MediaMetrics.Property.NAME, di.mDeviceName);     // Catch: Throwable -> L17
        if (event != 0) goto L43;
        if (btInfo.mProfile == 2) goto L34;
        if (btInfo.mProfile == 22) goto L34;
        if (btInfo.mProfile == 26) goto L34;
    L40:
        if (codecChanged == true) goto L43;
        updateBluetoothPreferredModes_l(btDevice);     // Catch: Throwable -> L17
    L34:
        if (codecChanged == false) goto L36;
        di.mDeviceCodecFormat = codec;     // Catch: Throwable -> L17
        this.mConnectedDevices.replace(key, di);     // Catch: Throwable -> L17
    L36:
        int res = this.mAudioSystem.handleDeviceConfigChange(btInfo.mAudioSystemDevice, address2, BtHelper.getName(btDevice), codec);     // Catch: Throwable -> L17
        if (res == 0) goto L39;
        AudioService.sDeviceLogger.enqueue(new EventLogger.StringEvent("APM handleDeviceConfigChange failed for A2DP device addr=" + address2 + " codec=" + AudioSystem.audioFormatToString(codec)).printLog(TAG));     // Catch: Throwable -> L17
        setBluetoothActiveDevice(new AudioDeviceBroker.BtDeviceInfo(btInfo, 0));     // Catch: Throwable -> L17
        goto L40
    L39:
        AudioService.sDeviceLogger.enqueue(new EventLogger.StringEvent("APM handleDeviceConfigChange success for A2DP device addr=" + address2 + " codec=" + AudioSystem.audioFormatToString(codec)).printLog(TAG));     // Catch: Throwable -> L17
    L43:
        monitor-exit(r10);     // Catch: Throwable -> L17
        mmi.record();
        return 0;
    L9:
        address2 = address;
        goto L10
    }

    void onMakeA2dpDeviceUnavailableNow(String address, int a2dpCodec) {
        Object r0 = this.mDevicesLock;
        monitor-enter(r0);
        makeA2dpDeviceUnavailableNow(address, a2dpCodec, false);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    void onMakeLeAudioDeviceUnavailableNow(String address, int device, int codec) {
        Object r0 = this.mDevicesLock;
        monitor-enter(r0);
        makeLeAudioDeviceUnavailableNow(address, device, codec, false);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    void onMakeHearingAidDeviceUnavailableNow(String address) {
        Object r0 = this.mDevicesLock;
        monitor-enter(r0);
        makeHearingAidDeviceUnavailable(address, false);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    void onUpdateLeAudioGroupAddresses(int groupId) {
        Object r0 = this.mDevicesLock;
        monitor-enter(r0);
        List<Pair<String, String>> addresses = new ArrayList();     // Catch: Throwable -> L12
        Iterator<DeviceInfo> r2 = this.mConnectedDevices.values().iterator();     // Catch: Throwable -> L12
    L6:
        if (r2.hasNext() == false) goto L37;
        DeviceInfo di = r2.next();     // Catch: Throwable -> L12
        if (di.mGroupId != groupId) goto L6;
        if (addresses.isEmpty() == false) goto L15;
        addresses = this.mDeviceBroker.getLeAudioGroupAddresses(groupId);     // Catch: Throwable -> L12
    L15:
        if (di.mPeerDeviceAddress.equals("") == false) goto L25;
        Iterator<Pair<String, String>> r4 = addresses.iterator();     // Catch: Throwable -> L12
    L18:
        if (r4.hasNext() == false) goto L28;
        Pair<String, String> addr = r4.next();     // Catch: Throwable -> L12
        if (di.mDeviceAddress.equals(addr.first) == true) goto L18;
        di.mPeerDeviceAddress = TextUtils.emptyIfNull((String) addr.first);     // Catch: Throwable -> L12
        di.mPeerIdentityDeviceAddress = TextUtils.emptyIfNull((String) addr.second);     // Catch: Throwable -> L12
    L28:
        if (di.mDeviceIdentityAddress.equals("") == false) goto L6;
        Iterator<Pair<String, String>> r5 = addresses.iterator();     // Catch: Throwable -> L12
    L31:
        if (r5.hasNext() == false) goto L6;
        Pair<String, String> addr2 = r5.next();     // Catch: Throwable -> L12
        if (di.mDeviceAddress.equals(addr2.first) == false) goto L31;
        di.mDeviceIdentityAddress = TextUtils.emptyIfNull((String) addr2.second);     // Catch: Throwable -> L12
        goto L6
    L25:
        if (addresses.contains(new Pair(di.mPeerDeviceAddress, di.mPeerIdentityDeviceAddress)) == true) goto L28;
        di.mPeerDeviceAddress = "";     // Catch: Throwable -> L12
        di.mPeerIdentityDeviceAddress = "";     // Catch: Throwable -> L12
        goto L28
    L37:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    void onReportNewRoutes() {
        int n = this.mRoutesObservers.beginBroadcast();
        if (n <= 0) goto L18;
        new MediaMetrics.Item("audio.device.onReportNewRoutes").set(MediaMetrics.Property.OBSERVERS, Integer.valueOf(n)).record();
        AudioRoutesInfo r1 = this.mCurAudioRoutes;
        monitor-enter(r1);
        AudioRoutesInfo routes = new AudioRoutesInfo(this.mCurAudioRoutes);     // Catch: Throwable -> L15
        monitor-exit(r1);     // Catch: Throwable -> L15
    L8:
        if (n <= 0) goto L18;
        n = n - 1;
        IAudioRoutesObserver obs = this.mRoutesObservers.getBroadcastItem(n);
        obs.dispatchAudioRoutesChanged(routes);     // Catch: RemoteException -> L12
    L12:
        e = move-exception;
        Log.e(TAG, "onReportNewRoutes", e);
    L15:
        th = move-exception;
        throw th;
    L18:
        this.mRoutesObservers.finishBroadcast();
        this.mDeviceBroker.postObserveDevicesForAllStreams();
    }

    void onSetWiredDeviceConnectionState(WiredDeviceConnectionState wdcs) {
        int type = wdcs.mAttributes.getInternalType();
        AudioService.sDeviceLogger.enqueue(new AudioServiceEvents.WiredDevConnectEvent(wdcs));
        MediaMetrics.Item r0 = new MediaMetrics.Item("audio.device.onSetWiredDeviceConnectionState").set(MediaMetrics.Property.ADDRESS, wdcs.mAttributes.getAddress()).set(MediaMetrics.Property.DEVICE, AudioSystem.getDeviceName(type));
        MediaMetrics.Key r2 = MediaMetrics.Property.STATE;
        if (wdcs.mState != 0) goto L5;
        String r3 = "disconnected";
    L6:
        MediaMetrics.Item mmi = r0.set(r2, r3);
        if (wdcs.mState == 0) goto L9;
    L17:
        AudioDeviceInfo info = null;
    L18:
        Object r5 = this.mDevicesLock;
        monitor-enter(r5);
    L25:
        th = th;
    L60:
        monitor-exit(r5);     // Catch: Throwable -> L38
        throw th;
    L21:
        if (wdcs.mState == 0) goto L23;
    L27:
        AudioDeviceAttributes r7 = wdcs.mAttributes;     // Catch: Throwable -> L25
        if (wdcs.mState != 1) goto L30;
        boolean r8 = true;
    L31:
        if (handleDeviceConnection(r7, r8, wdcs.mForTest, null, false) == true) goto L41;
        mmi.set(MediaMetrics.Property.EARLY_RETURN, "change of connection state failed").record();     // Catch: Throwable -> L38
        monitor-exit(r5);     // Catch: Throwable -> L38
        return;
    L41:
        if (wdcs.mState == 0) goto L47;
        if (DEVICE_OVERRIDE_A2DP_ROUTE_ON_PLUG_SET.contains(Integer.valueOf(type)) == false) goto L45;
        this.mDeviceBroker.setBluetoothA2dpOnInt(false, false, "onSetWiredDeviceConnectionState state not DISCONNECTED");     // Catch: Throwable -> L38
    L45:
        this.mDeviceBroker.checkMusicActive(type, wdcs.mCaller);     // Catch: Throwable -> L38
    L47:
        if (type != 1024) goto L50;
        this.mDeviceBroker.checkVolumeCecOnHdmiConnection(wdcs.mState, wdcs.mCaller);     // Catch: Throwable -> L38
    L50:
        if (wdcs.mState == 0) goto L52;
    L56:
        sendDeviceConnectionIntent(type, wdcs.mState, wdcs.mAttributes.getAddress(), wdcs.mAttributes.getName());     // Catch: Throwable -> L38
        updateAudioRoutes(type, wdcs.mState);     // Catch: Throwable -> L38
        monitor-exit(r5);     // Catch: Throwable -> L38
        mmi.record();
        return;
    L52:
        if (AudioSystem.DEVICE_OUT_ALL_USB_SET.contains(Integer.valueOf(wdcs.mAttributes.getInternalType())) == false) goto L56;
        if (info == null) goto L55;
        this.mDeviceBroker.dispatchPreferredMixerAttributesChangedCausedByDeviceRemoved(info);     // Catch: Throwable -> L38
        goto L56
    L55:
        Log.e(TAG, "Didn't find AudioDeviceInfo to notify preferred mixer attributes change for type=" + wdcs.mAttributes.getType());     // Catch: Throwable -> L38
        goto L56
    L30:
        r8 = false;
        goto L31
    L23:
        if (DEVICE_OVERRIDE_A2DP_ROUTE_ON_PLUG_SET.contains(Integer.valueOf(type)) == false) goto L27;
        this.mDeviceBroker.setBluetoothA2dpOnInt(true, false, "onSetWiredDeviceConnectionState state DISCONNECTED");     // Catch: Throwable -> L25
    L38:
        th = th;
        goto L60
    L9:
        if (AudioSystem.DEVICE_OUT_ALL_USB_SET.contains(Integer.valueOf(wdcs.mAttributes.getInternalType())) == false) goto L17;
        AudioDeviceInfo[] r4 = AudioManager.getDevicesStatic(2);
        int r6 = r4.length;
        int r9 = 0;
    L12:
        if (r9 >= r6) goto L17;
        AudioDeviceInfo deviceInfo = r4[r9];
        if (deviceInfo.getInternalType() == wdcs.mAttributes.getInternalType()) goto L15;
        r9 = r9 + 1;
        goto L12
    L15:
        info = deviceInfo;
        goto L18
    L5:
        r3 = "connected";
        goto L6
    }

    void onToggleHdmi() {
        int[] hdmiDevices = {1024, 262144, 262145};
        Object r2 = this.mDevicesLock;
        monitor-enter(r2);
        Iterator<DeviceInfo> r0 = this.mConnectedDevices.values().iterator();     // Catch: Throwable -> L10
    L6:
        if (r0.hasNext() == false) goto L13;
        final DeviceInfo di = r0.next();     // Catch: Throwable -> L10
        boolean isHdmiDevice = Arrays.stream(hdmiDevices).anyMatch(new AudioDeviceInventory$$ExternalSyntheticLambda11(di));     // Catch: Throwable -> L10
        if (isHdmiDevice == false) goto L6;
        MediaMetrics.Item mmi = new MediaMetrics.Item("audio.device.onToggleHdmi").set(MediaMetrics.Property.DEVICE, AudioSystem.getDeviceName(di.mDeviceType));     // Catch: Throwable -> L10
        AudioDeviceAttributes ada = new AudioDeviceAttributes(2, AudioDeviceInfo.convertInternalDeviceToDeviceType(di.mDeviceType), di.mDeviceAddress, di.mDeviceName, di.mAudioProfiles, di.mAudioDescriptors);     // Catch: Throwable -> L10
        setWiredDeviceConnectionState(ada, 0, "onToggleHdmi");     // Catch: Throwable -> L10
        setWiredDeviceConnectionState(ada, 1, "onToggleHdmi");     // Catch: Throwable -> L10
        mmi.record();     // Catch: Throwable -> L10
        goto L6
    L13:
        monitor-exit(r2);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    private static /* synthetic */ boolean lambda$onToggleHdmi$15(DeviceInfo di, int device) {
        if (device != di.mDeviceType) goto L5;
        return true;
    L5:
        return false;
    }

    private void saveSetPreferredDevices(int strategy, List<AudioDeviceAttributes> devices) {
        this.mPreferredDevices.put(Integer.valueOf(strategy), devices);
        List<AudioDeviceAttributes> nonDefaultDevices = this.mNonDefaultDevices.get(Integer.valueOf(strategy));
        if (nonDefaultDevices == null) goto L9;
        nonDefaultDevices.removeAll(devices);
        if (nonDefaultDevices.isEmpty() == false) goto L7;
        this.mNonDefaultDevices.remove(Integer.valueOf(strategy));
    L8:
        dispatchNonDefaultDevice(strategy, nonDefaultDevices);
        goto L9
    L7:
        this.mNonDefaultDevices.put(Integer.valueOf(strategy), nonDefaultDevices);
    L9:
        dispatchPreferredDevice(strategy, devices);
    }

    private void saveRemovePreferredDevices(int strategy) {
        this.mPreferredDevices.remove(Integer.valueOf(strategy));
        dispatchPreferredDevice(strategy, new ArrayList());
    }

    private void saveSetDeviceAsNonDefault(int strategy, AudioDeviceAttributes device) {
        List<AudioDeviceAttributes> nonDefaultDevices = this.mNonDefaultDevices.get(Integer.valueOf(strategy));
        if (nonDefaultDevices != null) goto L6;
        nonDefaultDevices = new ArrayList();
    L6:
        if (nonDefaultDevices.contains(device) == true) goto L8;
        nonDefaultDevices.add(device);
    L8:
        this.mNonDefaultDevices.put(Integer.valueOf(strategy), nonDefaultDevices);
        dispatchNonDefaultDevice(strategy, nonDefaultDevices);
        List<AudioDeviceAttributes> preferredDevices = this.mPreferredDevices.get(Integer.valueOf(strategy));
        if (preferredDevices == null) goto L12;
        preferredDevices.remove(device);
        this.mPreferredDevices.put(Integer.valueOf(strategy), preferredDevices);
        dispatchPreferredDevice(strategy, preferredDevices);
        return;
    }

    private void saveRemoveDeviceAsNonDefault(int strategy, AudioDeviceAttributes device) {
        List<AudioDeviceAttributes> nonDefaultDevices = this.mNonDefaultDevices.get(Integer.valueOf(strategy));
        if (nonDefaultDevices == null) goto L6;
        nonDefaultDevices.remove(device);
        this.mNonDefaultDevices.put(Integer.valueOf(strategy), nonDefaultDevices);
        dispatchNonDefaultDevice(strategy, nonDefaultDevices);
        return;
    }

    private void saveSetPreferredDevicesForCapturePreset(int capturePreset, List<AudioDeviceAttributes> devices) {
        this.mPreferredDevicesForCapturePreset.put(Integer.valueOf(capturePreset), devices);
        dispatchDevicesRoleForCapturePreset(capturePreset, 1, devices);
    }

    private void saveClearPreferredDevicesForCapturePreset(int capturePreset) {
        this.mPreferredDevicesForCapturePreset.remove(Integer.valueOf(capturePreset));
        dispatchDevicesRoleForCapturePreset(capturePreset, 1, new ArrayList());
    }

    int setPreferredDevicesForStrategyAndSave(int strategy, List<AudioDeviceAttributes> devices) {
        Object r0 = this.mDevicesLock;
        monitor-enter(r0);
        SafeCloseable ignored = ClearCallingIdentityContext.create();     // Catch: Throwable -> L14
        int status = setPreferredDevicesForStrategy(strategy, devices);     // Catch: Throwable -> L9
        if (status != 0) goto L12;
        saveSetPreferredDevices(strategy, devices);     // Catch: Throwable -> L9
    L12:
        if (ignored == null) goto L16;
        ignored.close();     // Catch: Throwable -> L14
    L16:
        monitor-exit(r0);     // Catch: Throwable -> L14
        return status;
    L9:
        th = move-exception;
        if (ignored != null) goto L29;
    L24:
        throw th;     // Catch: Throwable -> L14
    L29:
        ignored.close();     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    }

    int setPreferredDevicesForStrategy(int strategy, List<AudioDeviceAttributes> devices) {
        return setDevicesRoleForStrategy(strategy, 1, devices, false);
    }

    int setPreferredDevicesForStrategyInt(int strategy, List<AudioDeviceAttributes> devices) {
        return setDevicesRoleForStrategy(strategy, 1, devices, true);
    }

    int removePreferredDevicesForStrategyAndSave(int strategy) {
        Object r0 = this.mDevicesLock;
        monitor-enter(r0);
        SafeCloseable ignored = ClearCallingIdentityContext.create();     // Catch: Throwable -> L14
        int status = removePreferredDevicesForStrategy(strategy);     // Catch: Throwable -> L9
        if (status != 0) goto L12;
        saveRemovePreferredDevices(strategy);     // Catch: Throwable -> L9
    L12:
        if (ignored == null) goto L16;
        ignored.close();     // Catch: Throwable -> L14
    L16:
        monitor-exit(r0);     // Catch: Throwable -> L14
        return status;
    L9:
        th = move-exception;
        if (ignored != null) goto L29;
    L24:
        throw th;     // Catch: Throwable -> L14
    L29:
        ignored.close();     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    }

    int removePreferredDevicesForStrategy(int strategy) {
        return clearDevicesRoleForStrategy(strategy, 1, false);
    }

    int removePreferredDevicesForStrategyInt(int strategy) {
        return clearDevicesRoleForStrategy(strategy, 1, true);
    }

    int setDeviceAsNonDefaultForStrategyAndSave(int strategy, AudioDeviceAttributes device) {
        Object r1 = this.mDevicesLock;
        monitor-enter(r1);
        SafeCloseable ignored = ClearCallingIdentityContext.create();     // Catch: Throwable -> L13
        List<AudioDeviceAttributes> devices = new ArrayList();     // Catch: Throwable -> L9
        devices.add(device);     // Catch: Throwable -> L9
        int status = addDevicesRoleForStrategy(strategy, 2, devices, false);     // Catch: Throwable -> L9
        if (status != 0) goto L11;
        saveSetDeviceAsNonDefault(strategy, device);     // Catch: Throwable -> L9
    L11:
        if (ignored == null) goto L15;
        ignored.close();     // Catch: Throwable -> L13
    L15:
        monitor-exit(r1);     // Catch: Throwable -> L13
        return status;
    L9:
        th = move-exception;
        if (ignored != null) goto L29;
    L23:
        throw th;     // Catch: Throwable -> L13
    L29:
        ignored.close();     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    }

    int removeDeviceAsNonDefaultForStrategyAndSave(int strategy, AudioDeviceAttributes device) {
        Object r1 = this.mDevicesLock;
        monitor-enter(r1);
        SafeCloseable ignored = ClearCallingIdentityContext.create();     // Catch: Throwable -> L13
        List<AudioDeviceAttributes> devices = new ArrayList();     // Catch: Throwable -> L9
        devices.add(device);     // Catch: Throwable -> L9
        int status = removeDevicesRoleForStrategy(strategy, 2, devices, false);     // Catch: Throwable -> L9
        if (status != 0) goto L11;
        saveRemoveDeviceAsNonDefault(strategy, device);     // Catch: Throwable -> L9
    L11:
        if (ignored == null) goto L15;
        ignored.close();     // Catch: Throwable -> L13
    L15:
        monitor-exit(r1);     // Catch: Throwable -> L13
        return status;
    L9:
        th = move-exception;
        if (ignored != null) goto L29;
    L23:
        throw th;     // Catch: Throwable -> L13
    L29:
        ignored.close();     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    }

    void registerStrategyPreferredDevicesDispatcher(IStrategyPreferredDevicesDispatcher dispatcher, boolean isPrivileged) {
        this.mPrefDevDispatchers.register(dispatcher, Boolean.valueOf(isPrivileged));
    }

    void unregisterStrategyPreferredDevicesDispatcher(IStrategyPreferredDevicesDispatcher dispatcher) {
        this.mPrefDevDispatchers.unregister(dispatcher);
    }

    void registerStrategyNonDefaultDevicesDispatcher(IStrategyNonDefaultDevicesDispatcher dispatcher, boolean isPrivileged) {
        this.mNonDefDevDispatchers.register(dispatcher, Boolean.valueOf(isPrivileged));
    }

    void unregisterStrategyNonDefaultDevicesDispatcher(IStrategyNonDefaultDevicesDispatcher dispatcher) {
        this.mNonDefDevDispatchers.unregister(dispatcher);
    }

    int setPreferredDevicesForCapturePresetAndSave(int capturePreset, List<AudioDeviceAttributes> devices) {
        Object r0 = this.mDevicesLock;
        monitor-enter(r0);
        SafeCloseable ignored = ClearCallingIdentityContext.create();     // Catch: Throwable -> L14
        int status = setPreferredDevicesForCapturePreset(capturePreset, devices);     // Catch: Throwable -> L9
        if (status != 0) goto L12;
        saveSetPreferredDevicesForCapturePreset(capturePreset, devices);     // Catch: Throwable -> L9
    L12:
        if (ignored == null) goto L16;
        ignored.close();     // Catch: Throwable -> L14
    L16:
        monitor-exit(r0);     // Catch: Throwable -> L14
        return status;
    L9:
        th = move-exception;
        if (ignored != null) goto L29;
    L24:
        throw th;     // Catch: Throwable -> L14
    L29:
        ignored.close();     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    }

    private int setPreferredDevicesForCapturePreset(int capturePreset, List<AudioDeviceAttributes> devices) {
        return setDevicesRoleForCapturePreset(capturePreset, 1, devices);
    }

    int clearPreferredDevicesForCapturePresetAndSave(int capturePreset) {
        Object r0 = this.mDevicesLock;
        monitor-enter(r0);
        SafeCloseable ignored = ClearCallingIdentityContext.create();     // Catch: Throwable -> L14
        int status = clearPreferredDevicesForCapturePreset(capturePreset);     // Catch: Throwable -> L9
        if (status != 0) goto L12;
        saveClearPreferredDevicesForCapturePreset(capturePreset);     // Catch: Throwable -> L9
    L12:
        if (ignored == null) goto L16;
        ignored.close();     // Catch: Throwable -> L14
    L16:
        monitor-exit(r0);     // Catch: Throwable -> L14
        return status;
    L9:
        th = move-exception;
        if (ignored != null) goto L29;
    L24:
        throw th;     // Catch: Throwable -> L14
    L29:
        ignored.close();     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    }

    private int clearPreferredDevicesForCapturePreset(int capturePreset) {
        return clearDevicesRoleForCapturePreset(capturePreset, 1);
    }

    private int addDevicesRoleForCapturePresetInt(int capturePreset, int role, List<AudioDeviceAttributes> devices) {
        return addDevicesRole(this.mAppliedPresetRolesInt, new AudioDeviceInventory$$ExternalSyntheticLambda22(this), capturePreset, role, devices);
    }

    private /* synthetic */ int lambda$addDevicesRoleForCapturePresetInt$16(int p, int r, List d) {
        return this.mAudioSystem.addDevicesRoleForCapturePreset(p, r, d);
    }

    private int removeDevicesRoleForCapturePresetInt(int capturePreset, int role, List<AudioDeviceAttributes> devices) {
        return removeDevicesRole(this.mAppliedPresetRolesInt, new AudioDeviceInventory$$ExternalSyntheticLambda28(this), capturePreset, role, devices);
    }

    private /* synthetic */ int lambda$removeDevicesRoleForCapturePresetInt$17(int p, int r, List d) {
        return this.mAudioSystem.removeDevicesRoleForCapturePreset(p, r, d);
    }

    private int setDevicesRoleForCapturePreset(int capturePreset, int role, List<AudioDeviceAttributes> devices) {
        return setDevicesRole(this.mAppliedPresetRoles, new AudioDeviceInventory$$ExternalSyntheticLambda5(this), new AudioDeviceInventory$$ExternalSyntheticLambda6(this), capturePreset, role, devices);
    }

    private /* synthetic */ int lambda$setDevicesRoleForCapturePreset$18(int p, int r, List d) {
        return this.mAudioSystem.setDevicesRoleForCapturePreset(p, r, d);
    }

    private /* synthetic */ int lambda$setDevicesRoleForCapturePreset$19(int p, int r, List d) {
        return this.mAudioSystem.clearDevicesRoleForCapturePreset(p, r);
    }

    private int clearDevicesRoleForCapturePreset(int capturePreset, int role) {
        return clearDevicesRole(this.mAppliedPresetRoles, new AudioDeviceInventory$$ExternalSyntheticLambda10(this), capturePreset, role);
    }

    private /* synthetic */ int lambda$clearDevicesRoleForCapturePreset$20(int p, int r, List d) {
        return this.mAudioSystem.clearDevicesRoleForCapturePreset(p, r);
    }

    void registerCapturePresetDevicesRoleDispatcher(ICapturePresetDevicesRoleDispatcher dispatcher, boolean isPrivileged) {
        this.mDevRoleCapturePresetDispatchers.register(dispatcher, Boolean.valueOf(isPrivileged));
    }

    void unregisterCapturePresetDevicesRoleDispatcher(ICapturePresetDevicesRoleDispatcher dispatcher) {
        this.mDevRoleCapturePresetDispatchers.unregister(dispatcher);
    }

    private int addDevicesRoleForStrategy(int strategy, int role, List<AudioDeviceAttributes> devices, boolean internal) {
        if (internal == false) goto L5;
        ArrayMap<Pair<Integer, Integer>, List<AudioDeviceAttributes>> r0 = this.mAppliedStrategyRolesInt;
    L4:
        ArrayMap<Pair<Integer, Integer>, List<AudioDeviceAttributes>> r2 = r0;
        return addDevicesRole(r2, new AudioDeviceInventory$$ExternalSyntheticLambda36(this), strategy, role, devices);
    L5:
        r0 = this.mAppliedStrategyRoles;
        goto L4
    }

    private /* synthetic */ int lambda$addDevicesRoleForStrategy$21(int s, int r, List d) {
        return this.mAudioSystem.setDevicesRoleForStrategy(s, r, d);
    }

    private int removeDevicesRoleForStrategy(int strategy, int role, List<AudioDeviceAttributes> devices, boolean internal) {
        if (internal == false) goto L5;
        ArrayMap<Pair<Integer, Integer>, List<AudioDeviceAttributes>> r0 = this.mAppliedStrategyRolesInt;
    L4:
        ArrayMap<Pair<Integer, Integer>, List<AudioDeviceAttributes>> r2 = r0;
        return removeDevicesRole(r2, new AudioDeviceInventory$$ExternalSyntheticLambda4(this), strategy, role, devices);
    L5:
        r0 = this.mAppliedStrategyRoles;
        goto L4
    }

    private /* synthetic */ int lambda$removeDevicesRoleForStrategy$22(int s, int r, List d) {
        return this.mAudioSystem.removeDevicesRoleForStrategy(s, r, d);
    }

    private int setDevicesRoleForStrategy(int strategy, int role, List<AudioDeviceAttributes> devices, boolean internal) {
        if (internal == false) goto L5;
        ArrayMap<Pair<Integer, Integer>, List<AudioDeviceAttributes>> r0 = this.mAppliedStrategyRolesInt;
    L4:
        ArrayMap<Pair<Integer, Integer>, List<AudioDeviceAttributes>> r2 = r0;
        return setDevicesRole(r2, new AudioDeviceInventory$$ExternalSyntheticLambda2(this), new AudioDeviceInventory$$ExternalSyntheticLambda3(this), strategy, role, devices);
    L5:
        r0 = this.mAppliedStrategyRoles;
        goto L4
    }

    private /* synthetic */ int lambda$setDevicesRoleForStrategy$23(int s, int r, List d) {
        return this.mAudioSystem.setDevicesRoleForStrategy(s, r, d);
    }

    private /* synthetic */ int lambda$setDevicesRoleForStrategy$24(int s, int r, List d) {
        return this.mAudioSystem.clearDevicesRoleForStrategy(s, r);
    }

    private int clearDevicesRoleForStrategy(int strategy, int role, boolean internal) {
        if (internal == false) goto L4;
        ArrayMap<Pair<Integer, Integer>, List<AudioDeviceAttributes>> r0 = this.mAppliedStrategyRolesInt;
    L6:
        return clearDevicesRole(r0, new AudioDeviceInventory$$ExternalSyntheticLambda25(this), strategy, role);
    L4:
        r0 = this.mAppliedStrategyRoles;
        goto L6
    }

    private /* synthetic */ int lambda$clearDevicesRoleForStrategy$25(int s, int r, List d) {
        return this.mAudioSystem.clearDevicesRoleForStrategy(s, r);
    }

    private int addDevicesRole(ArrayMap<Pair<Integer, Integer>, List<AudioDeviceAttributes>> rolesMap, AudioSystemInterface asi, int useCase, int role, List<AudioDeviceAttributes> devices) {
        monitor-enter(rolesMap);
        Pair<Integer, Integer> key = new Pair(Integer.valueOf(useCase), Integer.valueOf(role));     // Catch: Throwable -> L11
        List<AudioDeviceAttributes> roleDevices = new ArrayList();     // Catch: Throwable -> L11
        List<AudioDeviceAttributes> appliedDevices = new ArrayList();     // Catch: Throwable -> L11
        if (rolesMap.containsKey(key) == false) goto L15;
        roleDevices = rolesMap.get(key);     // Catch: Throwable -> L11
        Iterator<AudioDeviceAttributes> r3 = devices.iterator();     // Catch: Throwable -> L11
    L7:
        if (r3.hasNext() == false) goto L17;
        AudioDeviceAttributes device = r3.next();     // Catch: Throwable -> L11
        if (roleDevices.contains(device) == true) goto L7;
        appliedDevices.add(device);     // Catch: Throwable -> L11
    L17:
        if (appliedDevices.isEmpty() == false) goto L21;
        monitor-exit(rolesMap);     // Catch: Throwable -> L11
        return 0;
    L21:
        int status = asi.deviceRoleAction(useCase, role, appliedDevices);     // Catch: Throwable -> L11
        if (status != 0) goto L24;
        roleDevices.addAll(appliedDevices);     // Catch: Throwable -> L11
        rolesMap.put(key, roleDevices);     // Catch: Throwable -> L11
    L24:
        monitor-exit(rolesMap);     // Catch: Throwable -> L11
        return status;
    L15:
        appliedDevices.addAll(devices);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    private int removeDevicesRole(ArrayMap<Pair<Integer, Integer>, List<AudioDeviceAttributes>> rolesMap, AudioSystemInterface asi, int useCase, int role, List<AudioDeviceAttributes> devices) {
        monitor-enter(rolesMap);
        Pair<Integer, Integer> key = new Pair(Integer.valueOf(useCase), Integer.valueOf(role));     // Catch: Throwable -> L8
        if (rolesMap.containsKey(key) == true) goto L10;
        monitor-exit(rolesMap);     // Catch: Throwable -> L8
        return -2;
    L10:
        List<AudioDeviceAttributes> roleDevices = rolesMap.get(key);     // Catch: Throwable -> L8
        List<AudioDeviceAttributes> appliedDevices = new ArrayList();     // Catch: Throwable -> L8
        Iterator<AudioDeviceAttributes> r3 = devices.iterator();     // Catch: Throwable -> L8
    L12:
        if (r3.hasNext() == false) goto L18;
        AudioDeviceAttributes device = r3.next();     // Catch: Throwable -> L8
        if (roleDevices.contains(device) == false) goto L12;
        appliedDevices.add(device);     // Catch: Throwable -> L8
        goto L12
    L18:
        if (appliedDevices.isEmpty() == false) goto L22;
        monitor-exit(rolesMap);     // Catch: Throwable -> L8
        return 0;
    L22:
        int status = asi.deviceRoleAction(useCase, role, appliedDevices);     // Catch: Throwable -> L8
        if (status != 0) goto L28;
        roleDevices.removeAll(appliedDevices);     // Catch: Throwable -> L8
        if (roleDevices.isEmpty() == false) goto L27;
        rolesMap.remove(key);     // Catch: Throwable -> L8
        goto L28
    L27:
        rolesMap.put(key, roleDevices);     // Catch: Throwable -> L8
    L28:
        monitor-exit(rolesMap);     // Catch: Throwable -> L8
        return status;
    L8:
        th = move-exception;
        throw th;
    }

    private static boolean devicesListEqual(List<AudioDeviceAttributes> list1, List<AudioDeviceAttributes> list2) {
        if (list1.size() == list2.size()) goto L5;
        return false;
    L5:
        Iterator<AudioDeviceAttributes> r0 = list1.iterator();
    L7:
        if (r0.hasNext() == false) goto L18;
        AudioDeviceAttributes d1 = r0.next();
        boolean found = false;
        Iterator<AudioDeviceAttributes> r4 = list2.iterator();
    L10:
        if (r4.hasNext() == false) goto L15;
        AudioDeviceAttributes d2 = r4.next();
        if (d1.equalTypeAddress(d2) == false) goto L10;
        found = true;
    L15:
        if (found == true) goto L7;
        return false;
    L18:
        return true;
    }

    private int setDevicesRole(ArrayMap<Pair<Integer, Integer>, List<AudioDeviceAttributes>> rolesMap, AudioSystemInterface addOp, AudioSystemInterface clearOp, int useCase, int role, List<AudioDeviceAttributes> devices) {
        monitor-enter(rolesMap);
        Pair<Integer, Integer> key = new Pair(Integer.valueOf(useCase), Integer.valueOf(role));     // Catch: Throwable -> L9
        if (rolesMap.containsKey(key) == false) goto L12;
        if (devicesListEqual(devices, rolesMap.get(key)) == false) goto L16;
        monitor-exit(rolesMap);     // Catch: Throwable -> L9
        return 0;
    L16:
        if (devices.isEmpty() == false) goto L20;
        int status = clearOp.deviceRoleAction(useCase, role, null);     // Catch: Throwable -> L9
        if (status != 0) goto L23;
        rolesMap.remove(key);     // Catch: Throwable -> L9
    L23:
        monitor-exit(rolesMap);     // Catch: Throwable -> L9
        return status;
    L20:
        status = addOp.deviceRoleAction(useCase, role, devices);     // Catch: Throwable -> L9
        if (status != 0) goto L23;
        rolesMap.put(key, new ArrayList(devices));     // Catch: Throwable -> L9
        goto L23
    L12:
        if (devices.isEmpty() == false) goto L16;
        monitor-exit(rolesMap);     // Catch: Throwable -> L9
        return 0;
    L9:
        th = move-exception;
        throw th;
    }

    private int clearDevicesRole(ArrayMap<Pair<Integer, Integer>, List<AudioDeviceAttributes>> rolesMap, AudioSystemInterface asi, int useCase, int role) {
        monitor-enter(rolesMap);
        Pair<Integer, Integer> key = new Pair(Integer.valueOf(useCase), Integer.valueOf(role));     // Catch: Throwable -> L8
        if (rolesMap.containsKey(key) == true) goto L10;
        monitor-exit(rolesMap);     // Catch: Throwable -> L8
        return -2;
    L10:
        int status = asi.deviceRoleAction(useCase, role, null);     // Catch: Throwable -> L8
        if (status != 0) goto L13;
        rolesMap.remove(key);     // Catch: Throwable -> L8
    L13:
        monitor-exit(rolesMap);     // Catch: Throwable -> L8
        return status;
    L8:
        th = move-exception;
        throw th;
    }

    private void purgeDevicesRoles_l() {
        purgeRoles(this.mAppliedStrategyRolesInt, new AudioDeviceInventory$$ExternalSyntheticLambda26(this));
        purgeRoles(this.mAppliedPresetRolesInt, new AudioDeviceInventory$$ExternalSyntheticLambda27(this));
        reapplyExternalDevicesRoles();
    }

    private /* synthetic */ int lambda$purgeDevicesRoles_l$26(int s, int r, List d) {
        return this.mAudioSystem.removeDevicesRoleForStrategy(s, r, d);
    }

    private /* synthetic */ int lambda$purgeDevicesRoles_l$27(int p, int r, List d) {
        return this.mAudioSystem.removeDevicesRoleForCapturePreset(p, r, d);
    }

    private void purgeRoles(ArrayMap<Pair<Integer, Integer>, List<AudioDeviceAttributes>> rolesMap, AudioSystemInterface asi) {
        monitor-enter(rolesMap);
        AudioDeviceInfo[] connectedDevices = AudioManager.getDevicesStatic(3);     // Catch: Throwable -> L13
        Iterator<Map.Entry<Pair<Integer, Integer>, List<AudioDeviceAttributes>>> itRole = rolesMap.entrySet().iterator();     // Catch: Throwable -> L13
    L6:
        if (itRole.hasNext() == false) goto L21;
        Map.Entry<Pair<Integer, Integer>, List<AudioDeviceAttributes>> entry = itRole.next();     // Catch: Throwable -> L13
        Pair<Integer, Integer> keyRole = entry.getKey();     // Catch: Throwable -> L13
        Iterator<AudioDeviceAttributes> itDev = rolesMap.get(keyRole).iterator();     // Catch: Throwable -> L13
    L9:
        if (itDev.hasNext() == false) goto L17;
        final AudioDeviceAttributes ada = itDev.next();     // Catch: Throwable -> L13
        AudioDeviceInfo device = (AudioDeviceInfo) Stream.of(connectedDevices).filter(new AudioDeviceInventory$$ExternalSyntheticLambda32(ada)).filter(new AudioDeviceInventory$$ExternalSyntheticLambda33(ada)).findFirst().orElse(null);     // Catch: Throwable -> L13
        if (device != null) goto L9;
        Slog.i(TAG, "purgeRoles() removing device: " + ada.toString() + ", for strategy: " + keyRole.first + " and role: " + keyRole.second);     // Catch: Throwable -> L13
        asi.deviceRoleAction(((Integer) keyRole.first).intValue(), ((Integer) keyRole.second).intValue(), Arrays.asList(new AudioDeviceAttributes[]{ada}));     // Catch: Throwable -> L13
        itDev.remove();     // Catch: Throwable -> L13
        goto L9
    L17:
        if (rolesMap.get(keyRole).isEmpty() == false) goto L6;
        itRole.remove();     // Catch: Throwable -> L13
        goto L6
    L21:
        monitor-exit(rolesMap);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        throw th;
    }

    private static /* synthetic */ boolean lambda$purgeRoles$28(AudioDeviceAttributes ada, AudioDeviceInfo d) {
        if (d.getInternalType() != ada.getInternalType()) goto L5;
        return true;
    L5:
        return false;
    }

    private static /* synthetic */ boolean lambda$purgeRoles$29(AudioDeviceAttributes ada, AudioDeviceInfo d) {
        if (AudioSystem.isBluetoothDevice(d.getInternalType()) == true) goto L5;
    L8:
        return true;
    L5:
        if (d.getAddress().equals(ada.getAddress()) == true) goto L8;
        return false;
    }

    public boolean isDeviceConnected(AudioDeviceAttributes device) {
        String key = DeviceInfo.m1966$$Nest$smmakeDeviceListKey(device.getInternalType(), device.getAddress());
        Object r1 = this.mDevicesLock;
        monitor-enter(r1);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.mConnectedDevices.get(key) == null) goto L7;
        boolean r2 = true;
    L8:
        monitor-exit(r1);     // Catch: Throwable -> L10
        return r2;
    L7:
        r2 = false;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 18, insn: 0x0198: MOVE (r10 I:??[OBJECT, ARRAY]) = (r18 I:??[OBJECT, ARRAY] A[D('mmi' android.media.MediaMetrics$Item)]), block:B:42:0x0196 */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v15 */
    /* JADX WARN: Type inference failed for: r11v16 */
    /* JADX WARN: Type inference failed for: r11v17 */
    /* JADX WARN: Type inference failed for: r11v18 */
    /* JADX WARN: Type inference failed for: r11v2 */
    /* JADX WARN: Type inference failed for: r11v3 */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    boolean handleDeviceConnection(AudioDeviceAttributes r22, boolean r23, boolean r24, BluetoothDevice r25, boolean r26) {
        int r11 = r22.getInternalType();
        String r13 = r22.getAddress();
        String r12 = r22.getName();
        Slog.i(TAG, "handleDeviceConnection(" + r23 + " dev:" + Integer.toHexString(r11) + " address:" + r13 + " name:" + r12 + ", deviceSwitch: " + r26 + ")");
        MediaMetrics.Item r0 = new MediaMetrics.Item("audio.device.handleDeviceConnection").set(MediaMetrics.Property.ADDRESS, r13).set(MediaMetrics.Property.DEVICE, AudioSystem.getDeviceName(r11));
        MediaMetrics.Key r2 = MediaMetrics.Property.MODE;
        if (r23 == false) goto L5;
        String r3 = "connect";
    L6:
        MediaMetrics.Item r4 = r0.set(r2, r3).set(MediaMetrics.Property.NAME, r12);
        Object r5 = this.mDevicesLock;
        monitor-enter(r5);
        String r1 = DeviceInfo.m1966$$Nest$smmakeDeviceListKey(r11, r13);     // Catch: Throwable -> L97
        Slog.i(TAG, "deviceKey:" + r1);     // Catch: Throwable -> L97
        DeviceInfo r6 = this.mConnectedDevices.get(r1);     // Catch: Throwable -> L97
        if (r6 == null) goto L11;
        boolean r14 = true;
    L12:
        Slog.i(TAG, "deviceInfo:" + r6 + " is(already)Connected:" + r14);     // Catch: Throwable -> L97
        if (r23 == r14) goto L106;
        if (r23 == false) goto L57;
        if (r14 == true) goto L57;
        if (r24 == false) goto L104;
        int r7 = 0;
    L32:
        if (r7 == 0) goto L47;
        r4.set(MediaMetrics.Property.EARLY_RETURN, "not connecting device 0x" + Integer.toHexString(r11) + " due to command error " + r7).set(MediaMetrics.Property.STATE, "disconnected").record();     // Catch: Throwable -> L41
        AudioService.sDeviceLogger.enqueue(new EventLogger.StringEvent("APM failed to make available device 0x" + Integer.toHexString(r11) + "addr=" + r13 + " error=" + r7).printSlog(1, TAG));     // Catch: Throwable -> L41
        monitor-exit(r5);     // Catch: Throwable -> L41
        return false;
    L43:
        th = th;
        ?? r15 = r5;
    L99:
        monitor-exit(r15);     // Catch: Throwable -> L79
        throw th;
    L45:
        th = th;
        r15 = r5;
        goto L99
    L47:
        MediaMetrics.Item r18 = r4;
        DeviceInfo r20 = r6;
        int r8 = 0;
        if (r11 == 1024) goto L55;
        if (r11 == 262144) goto L55;
        if (r11 == 262145) goto L55;
        this.mConnectedDevices.put(r1, new DeviceInfo(r11, r12, r13));     // Catch: Throwable -> L41
    L56:
        this.mDeviceBroker.postAccessoryPlugMediaUnmute(r11);     // Catch: Throwable -> L41
        boolean r19 = true;
    L62:
        if (r19 == true) goto L101;
        Object r16 = r5;
        Log.w(TAG, "handleDeviceConnection() failed, deviceKey=" + r1 + ", deviceSpec=" + r20 + ", connect=" + r23);     // Catch: Throwable -> L79
        r18.set(MediaMetrics.Property.STATE, "disconnected").record();     // Catch: Throwable -> L79
    L95:
        monitor-exit(r16);     // Catch: Throwable -> L79
        return r19;
    L101:
    L90:
        th = th;
        Object r17 = r5;
    L89:
        r15 = r17;
        goto L99
    L64:
        if (AudioSystem.isBluetoothScoDevice(r11) == false) goto L92;
        if (r23 == false) goto L67;
        BluetoothDevice r9 = r25;
    L68:
        updateBluetoothPreferredModes_l(r9);     // Catch: Throwable -> L90
        if (r23 == true) goto L110;
        purgeDevicesRoles_l();     // Catch: Throwable -> L41
        int r10 = r11;
        String r21 = r13;
        r16 = r5;
    L76:
        EventLogger r27 = AudioService.sDeviceLogger;     // Catch: Throwable -> L79
        StringBuilder r28 = new StringBuilder();     // Catch: Throwable -> L79
        r28.append("SCO ");     // Catch: Throwable -> L79
        if (AudioSystem.isInputDevice(r10) == false) goto L81;
        String r29 = StarLocation.KEY_LOCATION_SOURCE;
    L82:
        r28.append(r29);     // Catch: Throwable -> L79
        r28.append(" device addr=");     // Catch: Throwable -> L79
        r28.append(r21);     // Catch: Throwable -> L79
        if (r23 == false) goto L85;
        String r30 = " now available";
    L86:
        r28.append(r30);     // Catch: Throwable -> L79
        r27.enqueue(new EventLogger.StringEvent(r28.toString()).printSlog(r8, TAG));     // Catch: Throwable -> L79
    L93:
        r18.set(MediaMetrics.Property.STATE, "connected").record();     // Catch: Throwable -> L79
        goto L95
    L85:
        r30 = " made unavailable";
        goto L86
    L81:
        r29 = "sink";
        goto L82
    L110:
        r16 = r5;
        int r31 = r11;
        r21 = r13;
        addAudioDeviceInInventoryIfNeeded(r31 == true ? 1 : 0, r21, "", BtHelper.getBtDeviceCategory(r13), false);     // Catch: Throwable -> L79
        r10 = r31;
    L87:
        th = th;
        r17 = r5;
        goto L89
    L67:
        r9 = null;
        goto L68
    L92:
        r18 = r18;
        r16 = r5;
    L55:
        this.mConnectedDevices.put(r1, new DeviceInfo(r11, r12, r13, r22.getAudioProfiles(), r22.getAudioDescriptors()));     // Catch: Throwable -> L41
        goto L56
    L104:
        r7 = this.mAudioSystem.setDeviceConnectionState(r22, 1, 0, false);     // Catch: Throwable -> L45
    L57:
        r18 = r4;
        r19 = false;
        r20 = r6;
        boolean r110 = r14;
        r8 = 0;
        if (r23 == true) goto L62;
        if (r110 == false) goto L62;
        this.mAudioSystem.setDeviceConnectionState(r22, 0, 0, r26);     // Catch: Throwable -> L41
        this.mConnectedDevices.remove(r1);     // Catch: Throwable -> L41
        r19 = true;
    L41:
        th = th;
        r15 = r5;
        goto L99
    L106:
        StringBuilder r111 = new StringBuilder();     // Catch: Throwable -> L17
        r111.append("handleDeviceConnection() deviceInfo=");     // Catch: Throwable -> L17
        r111.append(r6);     // Catch: Throwable -> L17
        r111.append(" is already ");     // Catch: Throwable -> L17
        if (r23 == false) goto L19;
        String r112 = "";
    L20:
        r111.append(r112);     // Catch: Throwable -> L17
        r111.append("connected");     // Catch: Throwable -> L17
        Log.i(TAG, r111.toString());     // Catch: Throwable -> L17
        MediaMetrics.Key r32 = MediaMetrics.Property.STATE;     // Catch: Throwable -> L17
        if (r23 == false) goto L23;
        String r113 = "connect";
    L24:
        r4.set(r32, r113).record();     // Catch: Throwable -> L17
        monitor-exit(r5);     // Catch: Throwable -> L17
        return true;
    L23:
        r113 = "disconnect";
        goto L24
    L19:
        r112 = "dis";
    L17:
        th = th;
        r15 = r5;
        goto L99
    L11:
        r14 = false;
    L97:
        th = th;
        r15 = r5;
    L79:
        th = th;
        r15 = r11;
        goto L99
    L5:
        r3 = "disconnect";
        goto L6
    }

    private void disconnectA2dp() {
        Object r0 = this.mDevicesLock;
        monitor-enter(r0);
        final ArraySet<String> toRemove = new ArraySet();     // Catch: Throwable -> L7
        this.mConnectedDevices.values().forEach(new AudioDeviceInventory$$ExternalSyntheticLambda8(toRemove));     // Catch: Throwable -> L7
        new MediaMetrics.Item("audio.device.disconnectA2dp").set(MediaMetrics.Property.EVENT, "disconnectA2dp").record();     // Catch: Throwable -> L7
        if (toRemove.size() <= 0) goto L9;
        final int delay = checkSendBecomingNoisyIntentInt(128, 0, 0);     // Catch: Throwable -> L7
        toRemove.stream().forEach(new AudioDeviceInventory$$ExternalSyntheticLambda9(this, delay));     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private static /* synthetic */ void lambda$disconnectA2dp$30(ArraySet toRemove, DeviceInfo deviceInfo) {
        if (deviceInfo.mDeviceType != 128) goto L6;
        toRemove.add(deviceInfo.mDeviceAddress);
        return;
    }

    private /* synthetic */ void lambda$disconnectA2dp$31(int delay, String deviceAddress) {
        makeA2dpDeviceUnavailableLater(deviceAddress, delay);
    }

    private void disconnectA2dpSink() {
        Object r0 = this.mDevicesLock;
        monitor-enter(r0);
        final ArraySet<String> toRemove = new ArraySet();     // Catch: Throwable -> L7
        this.mConnectedDevices.values().forEach(new AudioDeviceInventory$$ExternalSyntheticLambda30(toRemove));     // Catch: Throwable -> L7
        new MediaMetrics.Item("audio.device.disconnectA2dpSink").set(MediaMetrics.Property.EVENT, "disconnectA2dpSink").record();     // Catch: Throwable -> L7
        toRemove.stream().forEach(new AudioDeviceInventory$$ExternalSyntheticLambda31(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private static /* synthetic */ void lambda$disconnectA2dpSink$32(ArraySet toRemove, DeviceInfo deviceInfo) {
        if (deviceInfo.mDeviceType != (-2147352576)) goto L6;
        toRemove.add(deviceInfo.mDeviceAddress);
        return;
    }

    private /* synthetic */ void lambda$disconnectA2dpSink$33(String deviceAddress) {
        makeA2dpSrcUnavailable(deviceAddress);
    }

    private void disconnectHearingAid() {
        Object r0 = this.mDevicesLock;
        monitor-enter(r0);
        final ArraySet<String> toRemove = new ArraySet();     // Catch: Throwable -> L7
        this.mConnectedDevices.values().forEach(new AudioDeviceInventory$$ExternalSyntheticLambda34(toRemove));     // Catch: Throwable -> L7
        new MediaMetrics.Item("audio.device.disconnectHearingAid").set(MediaMetrics.Property.EVENT, "disconnectHearingAid").record();     // Catch: Throwable -> L7
        if (toRemove.size() <= 0) goto L9;
        final int delay = checkSendBecomingNoisyIntentInt(134217728, 0, 0);     // Catch: Throwable -> L7
        toRemove.stream().forEach(new AudioDeviceInventory$$ExternalSyntheticLambda35(this, delay));     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private static /* synthetic */ void lambda$disconnectHearingAid$34(ArraySet toRemove, DeviceInfo deviceInfo) {
        if (deviceInfo.mDeviceType != 134217728) goto L6;
        toRemove.add(deviceInfo.mDeviceAddress);
        return;
    }

    private /* synthetic */ void lambda$disconnectHearingAid$35(int delay, String deviceAddress) {
        makeHearingAidDeviceUnavailableLater(deviceAddress, delay);
    }

    void onBtProfileDisconnected(int profile) {
        switch(profile) {
            case 1: goto L9;
            case 2: goto L8;
            case 11: goto L7;
            case 21: goto L6;
            case 22: goto L5;
            case 26: goto L4;
            default: goto L3;
        };
    L3:
        Log.e(TAG, "onBtProfileDisconnected: Not a valid profile to disconnect " + BluetoothProfile.getProfileName(profile));
        return;
    L4:
        disconnectLeAudioBroadcast();
        return;
    L5:
        disconnectLeAudioUnicast();
        return;
    L6:
        disconnectHearingAid();
        return;
    L7:
        disconnectA2dpSink();
        return;
    L8:
        disconnectA2dp();
        return;
    L9:
        disconnectHeadset();
    }

    void disconnectLeAudio(final int device) {
        Object r0 = this.mDevicesLock;
        monitor-enter(r0);
        final ArraySet<Pair<String, Integer>> toRemove = new ArraySet();     // Catch: Throwable -> L9
        this.mConnectedDevices.values().forEach(new AudioDeviceInventory$$ExternalSyntheticLambda0(device, toRemove));     // Catch: Throwable -> L9
        new MediaMetrics.Item("audio.device.disconnectLeAudio").set(MediaMetrics.Property.EVENT, "disconnectLeAudio").record();     // Catch: Throwable -> L9
        if (toRemove.size() > 0) goto L7;
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L7:
        if (device == (-1610612736)) goto L11;
        final int delay = checkSendBecomingNoisyIntentInt(device, 0, 0);     // Catch: Throwable -> L9
    L12:
        toRemove.stream().forEach(new AudioDeviceInventory$$ExternalSyntheticLambda1(this, device, delay));     // Catch: Throwable -> L9
        goto L13
    L11:
        delay = 0;
    L9:
        th = move-exception;
        throw th;
    }

    private static /* synthetic */ void lambda$disconnectLeAudio$36(int device, ArraySet toRemove, DeviceInfo deviceInfo) {
        if (deviceInfo.mDeviceType != device) goto L6;
        toRemove.add(new Pair(deviceInfo.mDeviceAddress, Integer.valueOf(deviceInfo.mDeviceCodecFormat)));
        return;
    }

    private /* synthetic */ void lambda$disconnectLeAudio$37(int device, int delay, Pair entry) {
        makeLeAudioDeviceUnavailableLater((String) entry.first, device, ((Integer) entry.second).intValue(), delay);
    }

    void disconnectLeAudioUnicast() {
        disconnectLeAudio(536870912);
        disconnectLeAudio(-1610612736);
    }

    void disconnectLeAudioBroadcast() {
        disconnectLeAudio(536870914);
    }

    private void disconnectHeadset() {
        boolean disconnect = false;
        Object r1 = this.mDevicesLock;
        monitor-enter(r1);
        Iterator<DeviceInfo> r2 = this.mConnectedDevices.values().iterator();     // Catch: Throwable -> L11
    L6:
        if (r2.hasNext() == false) goto L13;
        DeviceInfo di = r2.next();     // Catch: Throwable -> L11
        if (AudioSystem.isBluetoothScoDevice(di.mDeviceType) == false) goto L6;
        disconnect = true;
    L13:
        monitor-exit(r1);     // Catch: Throwable -> L11
        if (disconnect == false) goto L23;
        this.mDeviceBroker.onSetBtScoActiveDevice(null, false);
        return;
    L23:
        return;
    L11:
        th = move-exception;
        throw th;
    }

    int checkSendBecomingNoisyIntent(int device, int state, int musicDevice) {
        Object r0 = this.mDevicesLock;
        monitor-enter(r0);
        int r1 = checkSendBecomingNoisyIntentInt(device, state, musicDevice);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    AudioRoutesInfo startWatchingRoutes(IAudioRoutesObserver observer) {
        AudioRoutesInfo r0 = this.mCurAudioRoutes;
        monitor-enter(r0);
        AudioRoutesInfo routes = new AudioRoutesInfo(this.mCurAudioRoutes);     // Catch: Throwable -> L7
        this.mRoutesObservers.register(observer);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return routes;
    L7:
        th = move-exception;
        throw th;
    }

    AudioRoutesInfo getCurAudioRoutes() {
        return this.mCurAudioRoutes;
    }

    public int setBluetoothActiveDevice(AudioDeviceBroker.BtDeviceInfo info) {
        Object r0 = this.mDevicesLock;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (info.mSupprNoisy == false) goto L7;
    L26:
        int delay = 0;
    L27:
        Log.i(TAG, "setBluetoothActiveDevice " + info.toString() + " delay(ms): " + delay);     // Catch: Throwable -> L11
        this.mDeviceBroker.postBluetoothActiveDevice(info, delay);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return delay;
    L7:
        if (info.mProfile == 22) goto L14;
        if (info.mProfile == 26) goto L14;
    L16:
        if (info.mProfile == 21) goto L20;
        if (info.mProfile != 2) goto L26;
    L20:
        if (info.mIsDeviceSwitch == true) goto L26;
        if (info.mState != 2) goto L24;
        int asState = 1;
    L25:
        delay = checkSendBecomingNoisyIntentInt(info.mAudioSystemDevice, asState, info.mMusicDevice);     // Catch: Throwable -> L11
        goto L27
    L24:
        asState = 0;
    L14:
        if (info.mIsLeOutput == true) goto L20;
        goto L16
    }

    int setWiredDeviceConnectionState(AudioDeviceAttributes attributes, int state, String caller) {
        Object r0 = this.mDevicesLock;
        monitor-enter(r0);
        int delay = checkSendBecomingNoisyIntentInt(attributes.getInternalType(), state, 0);     // Catch: Throwable -> L7
        this.mDeviceBroker.postSetWiredDeviceConnectionState(new WiredDeviceConnectionState(attributes, state, caller), delay);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return delay;
    L7:
        th = move-exception;
        throw th;
    }

    void setTestDeviceConnectionState(AudioDeviceAttributes device, int state) {
        WiredDeviceConnectionState connection = new WiredDeviceConnectionState(device, state, "com.android.server.audio");
        connection.mForTest = true;
        onSetWiredDeviceConnectionState(connection);
    }

    private void makeA2dpDeviceAvailable(AudioDeviceBroker.BtDeviceInfo btInfo, int codec, String eventSource) {
        String address = btInfo.mDevice.getAddress();
        String name = BtHelper.getName(btInfo.mDevice);
        this.mDeviceBroker.setBluetoothA2dpOnInt(true, true, eventSource);
        AudioDeviceAttributes ada = new AudioDeviceAttributes(128, address, name);
        int res = this.mAudioSystem.setDeviceConnectionState(ada, 1, codec, false);
        if (res == 0) goto L8;
        AudioService.sDeviceLogger.enqueue(new EventLogger.StringEvent("APM failed to make available A2DP device addr=" + Utils.anonymizeBluetoothAddress(address) + " error=" + res).printSlog(1, TAG));
        if (res == 100) goto L9;
        return;
    L9:
        this.mDeviceBroker.clearA2dpSuspended(true);
        DeviceInfo di = new DeviceInfo(128, name, address, btInfo.mDevice.getIdentityAddress(), codec);
        String diKey = di.getKey();
        this.mConnectedDevices.put(diKey, di);
        this.mApmConnectedDevices.put(128, diKey);
        this.mDeviceBroker.postAccessoryPlugMediaUnmute(128);
        setCurrentAudioRouteNameIfPossible(name, true);
        updateBluetoothPreferredModes_l(btInfo.mDevice);
        addAudioDeviceInInventoryIfNeeded(128, address, "", BtHelper.getBtDeviceCategory(address), false);
        return;
    L8:
        AudioService.sDeviceLogger.enqueue(new EventLogger.StringEvent("A2DP sink device addr=" + Utils.anonymizeBluetoothAddress(address) + " now available").printSlog(0, TAG));
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void applyConnectedDevicesRoles_l() {
        if (this.mBluetoothDualModeEnabled == true) goto L5;
        return;
    L5:
        DeviceInfo leOutDevice = getFirstConnectedDeviceOfTypes(AudioSystem.DEVICE_OUT_ALL_BLE_SET);
        DeviceInfo leInDevice = getFirstConnectedDeviceOfTypes(AudioSystem.DEVICE_IN_ALL_BLE_SET);
        DeviceInfo a2dpDevice = getFirstConnectedDeviceOfTypes(AudioSystem.DEVICE_OUT_ALL_A2DP_SET);
        DeviceInfo scoOutDevice = getFirstConnectedDeviceOfTypes(AudioSystem.DEVICE_OUT_ALL_SCO_SET);
        DeviceInfo scoInDevice = getFirstConnectedDeviceOfTypes(AudioSystem.DEVICE_IN_ALL_SCO_SET);
        if (leOutDevice != null) goto L8;
    L10:
        boolean disableA2dp = false;
    L11:
        if (leOutDevice != null) goto L13;
    L14:
        if (leInDevice != null) goto L16;
    L18:
        boolean disableSco = false;
    L19:
        AudioDeviceAttributes communicationDevice = null;
        if (this.mDeviceBroker.mActiveCommunicationDevice != null) goto L23;
    L28:
        Log.i(TAG, "applyConnectedDevicesRoles_l\n - leOutDevice: " + leOutDevice + "\n - leInDevice: " + leInDevice + "\n - a2dpDevice: " + a2dpDevice + "\n - scoOutDevice: " + scoOutDevice + "\n - scoInDevice: " + scoInDevice + "\n - disableA2dp: " + disableA2dp + ", disableSco: " + disableSco);
        Iterator<DeviceInfo> r10 = this.mConnectedDevices.values().iterator();
    L30:
        if (r10.hasNext() == false) goto L108;
        DeviceInfo di = r10.next();
        if (AudioSystem.isBluetoothDevice(di.mDeviceType) == false) goto L30;
        boolean r17 = true;
        AudioDeviceAttributes ada = new AudioDeviceAttributes(di.mDeviceType, di.mDeviceAddress, di.mDeviceName);
        Log.i(TAG, "  + checking Device: " + ada);
        if (ada.equalTypeAddress(communicationDevice) == true) goto L30;
        if (AudioSystem.isBluetoothOutDevice(di.mDeviceType) == false) goto L84;
        Iterator<AudioProductStrategy> r6 = this.mStrategies.iterator();
    L41:
        if (r6.hasNext() == false) goto L83;
        AudioProductStrategy strategy = r6.next();
        DeviceInfo leOutDevice2 = leOutDevice;
        if (strategy.getId() != this.mDeviceBroker.mCommunicationStrategyId) goto L57;
        if (AudioSystem.isBluetoothScoDevice(di.mDeviceType) == false) goto L54;
        if (disableSco == false) goto L48;
    L51:
        boolean disable = r17;
    L78:
        StringBuilder r15 = new StringBuilder();
        DeviceInfo leInDevice2 = leInDevice;
        r15.append("     - strategy: ");
        r15.append(strategy.getId());
        r15.append(", disable: ");
        r15.append(disable);
        Log.i(TAG, r15.toString());
        if (disable == false) goto L81;
        int r2 = strategy.getId();
        int r16 = r17;
        AudioDeviceAttributes[] r1 = new AudioDeviceAttributes[r16];
        r1[0] = ada;
        addDevicesRoleForStrategy(r2, 2, Arrays.asList(r1), r16);
    L82:
        leInDevice = leInDevice2;
        leOutDevice = leOutDevice2;
        a2dpDevice = a2dpDevice;
        r17 = true;
        goto L41
    L81:
        int r18 = r17;
        int r3 = strategy.getId();
        AudioDeviceAttributes[] r4 = new AudioDeviceAttributes[r18];
        r4[0] = ada;
        removeDevicesRoleForStrategy(r3, 2, Arrays.asList(r4), r18);
        goto L82
    L48:
        if (di.isDuplexModeEnabled() == false) goto L51;
        disable = false;
        goto L78
    L54:
        if (AudioSystem.isBluetoothLeDevice(di.mDeviceType) == false) goto L77;
        disable = !di.isDuplexModeEnabled();
    L77:
        disable = false;
        goto L78
    L57:
        if (AudioSystem.isBluetoothA2dpOutDevice(di.mDeviceType) == false) goto L66;
        if (disableA2dp == false) goto L60;
    L63:
        disable = r17;
        goto L78
    L60:
        if (di.isOutputOnlyModeEnabled() == false) goto L63;
        disable = false;
        goto L78
    L66:
        if (AudioSystem.isBluetoothScoDevice(di.mDeviceType) == false) goto L75;
        if (disableSco == false) goto L69;
    L72:
        disable = r17;
        goto L78
    L69:
        if (di.isOutputOnlyModeEnabled() == false) goto L72;
        disable = false;
        goto L78
    L75:
        if (AudioSystem.isBluetoothLeDevice(di.mDeviceType) == false) goto L77;
        disable = !di.isOutputOnlyModeEnabled();
        goto L78
    L83:
        DeviceInfo leOutDevice3 = leOutDevice;
        DeviceInfo leInDevice3 = leInDevice;
        DeviceInfo a2dpDevice2 = a2dpDevice;
    L86:
        if (AudioSystem.isBluetoothInDevice(di.mDeviceType) == false) goto L107;
        int[] r5 = CAPTURE_PRESETS;
        int r7 = r5.length;
        int r8 = 0;
    L89:
        if (r8 >= r7) goto L107;
        int capturePreset = r5[r8];
        boolean disable2 = false;
        int[] r19 = r5;
        if (AudioSystem.isBluetoothScoDevice(di.mDeviceType) == false) goto L100;
        if (disableSco == false) goto L94;
    L97:
        boolean r9 = true;
    L98:
        disable2 = r9;
    L102:
        StringBuilder r11 = new StringBuilder();
        int r21 = r7;
        r11.append("      - capturePreset: ");
        r11.append(capturePreset);
        r11.append(", disable: ");
        r11.append(disable2);
        Log.i(TAG, r11.toString());
        if (disable2 == false) goto L105;
        addDevicesRoleForCapturePresetInt(capturePreset, 2, Arrays.asList(new AudioDeviceAttributes[]{ada}));
    L106:
        r8 = r8 + 1;
        r5 = r19;
        r7 = r21;
        goto L89
    L105:
        removeDevicesRoleForCapturePresetInt(capturePreset, 2, Arrays.asList(new AudioDeviceAttributes[]{ada}));
        goto L106
    L94:
        if (di.isDuplexModeEnabled() == false) goto L97;
        r9 = false;
        goto L98
    L100:
        if (AudioSystem.isBluetoothLeDevice(di.mDeviceType) == false) goto L102;
        disable2 = !di.isDuplexModeEnabled();
    L107:
        leInDevice = leInDevice3;
        leOutDevice = leOutDevice3;
        a2dpDevice = a2dpDevice2;
        goto L30
    L84:
        leOutDevice3 = leOutDevice;
        leInDevice3 = leInDevice;
        a2dpDevice2 = a2dpDevice;
        goto L86
    L108:
        return;
    L23:
        if (this.mDeviceBroker.isInCommunication() == false) goto L28;
        if (this.mDeviceBroker.mActiveCommunicationDevice == null) goto L28;
        communicationDevice = new AudioDeviceAttributes(this.mDeviceBroker.mActiveCommunicationDevice);
        goto L28
    L16:
        if (leInDevice.isDuplexModeEnabled() == false) goto L18;
    L17:
        disableSco = true;
        goto L19
    L13:
        if (leOutDevice.isDuplexModeEnabled() == true) goto L17;
    L8:
        if (leOutDevice.isOutputOnlyModeEnabled() == false) goto L10;
        disableA2dp = true;
        goto L11
    }

    void applyConnectedDevicesRoles() {
        Object r0 = this.mDevicesLock;
        monitor-enter(r0);
        applyConnectedDevicesRoles_l();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    int checkProfileIsConnected(int profile) {
        switch(profile) {
            case 1: goto L13;
            case 2: goto L10;
            case 22: goto L5;
            case 26: goto L5;
            default: goto L22;
        };
    L22:
        return 0;
    L5:
        if (getFirstConnectedDeviceOfTypes(AudioSystem.DEVICE_OUT_ALL_BLE_SET) == null) goto L7;
    L8:
        return profile;
    L7:
        if (getFirstConnectedDeviceOfTypes(AudioSystem.DEVICE_IN_ALL_BLE_SET) != null) goto L8;
        return 0;
    L10:
        if (getFirstConnectedDeviceOfTypes(AudioSystem.DEVICE_OUT_ALL_A2DP_SET) == null) goto L20;
        return profile;
    L20:
        return 0;
    L13:
        if (getFirstConnectedDeviceOfTypes(AudioSystem.DEVICE_OUT_ALL_SCO_SET) == null) goto L15;
    L19:
        return profile;
    L15:
        if (getFirstConnectedDeviceOfTypes(AudioSystem.DEVICE_IN_ALL_SCO_SET) != null) goto L19;
        return 0;
    }

    private void updateBluetoothPreferredModes_l(BluetoothDevice connectedDevice) {
        if (this.mBluetoothDualModeEnabled == true) goto L5;
        return;
    L5:
        HashSet<String> processedAddresses = new HashSet(0);
        Iterator<DeviceInfo> r1 = this.mConnectedDevices.values().iterator();
    L7:
        if (r1.hasNext() == false) goto L38;
        DeviceInfo di = r1.next();
        if (AudioSystem.isBluetoothDevice(di.mDeviceType) == false) goto L7;
        if (processedAddresses.contains(di.mDeviceAddress) == true) goto L7;
        Bundle preferredProfiles = BtHelper.getPreferredAudioProfiles(di.mDeviceAddress);
        Log.i(TAG, "updateBluetoothPreferredModes_l processing device address: " + di.mDeviceAddress + ", preferredProfiles: " + preferredProfiles);
        Iterator<DeviceInfo> r4 = this.mConnectedDevices.values().iterator();
    L15:
        if (r4.hasNext() == false) goto L37;
        DeviceInfo di2 = r4.next();
        if (AudioSystem.isBluetoothDevice(di2.mDeviceType) == false) goto L15;
        if (di.mDeviceAddress.equals(di2.mDeviceAddress) == false) goto L15;
        int profile = BtHelper.getProfileFromType(di2.mDeviceType);
        if (profile == 0) goto L15;
        int preferredProfile = checkProfileIsConnected(preferredProfiles.getInt("audio_mode_duplex"));
        if (preferredProfile == profile) goto L29;
        if (preferredProfile == 0) goto L29;
        di2.setModeDisabled("audio_mode_duplex");
    L30:
        int preferredProfile2 = checkProfileIsConnected(preferredProfiles.getInt("audio_mode_output_only"));
        if (preferredProfile2 == profile) goto L35;
        if (preferredProfile2 == 0) goto L35;
        di2.setModeDisabled("audio_mode_output_only");
    L35:
        di2.setModeEnabled("audio_mode_output_only");
    L29:
        di2.setModeEnabled("audio_mode_duplex");
        goto L30
    L37:
        processedAddresses.add(di.mDeviceAddress);
        goto L7
    L38:
        applyConnectedDevicesRoles_l();
        if (connectedDevice == null) goto L62;
        this.mDeviceBroker.postNotifyPreferredAudioProfileApplied(connectedDevice);
        return;
    }

    private void makeA2dpDeviceUnavailableNow(String address, int codec, boolean deviceSwitch) {
        MediaMetrics.Item mmi = new MediaMetrics.Item("audio.device.a2dp." + address).set(MediaMetrics.Property.ENCODING, AudioSystem.audioFormatToString(codec)).set(MediaMetrics.Property.EVENT, "makeA2dpDeviceUnavailableNow");
        if (address != null) goto L6;
        mmi.set(MediaMetrics.Property.EARLY_RETURN, "address null").record();
        return;
    L6:
        String deviceToRemoveKey = DeviceInfo.m1966$$Nest$smmakeDeviceListKey(128, address);
        this.mConnectedDevices.remove(deviceToRemoveKey);
        if (deviceToRemoveKey.equals(this.mApmConnectedDevices.get(128)) == true) goto L10;
        AudioService.sDeviceLogger.enqueue(new EventLogger.StringEvent("A2DP device " + Utils.anonymizeBluetoothAddress(address) + " made unavailable, was not used").printSlog(0, TAG));
        mmi.set(MediaMetrics.Property.EARLY_RETURN, "A2DP device made unavailable, was not used").record();
        AudioDeviceAttributes ada = new AudioDeviceAttributes(128, address);
        Log.d(TAG, "made not used A2DP device addr=" + address + " unavailable in APM, status=" + this.mAudioSystem.setDeviceConnectionState(ada, 0, codec, deviceSwitch));
        return;
    L10:
        this.mDeviceBroker.clearAvrcpAbsoluteVolumeSupported();
        AudioDeviceAttributes ada2 = new AudioDeviceAttributes(128, address);
        int res = this.mAudioSystem.setDeviceConnectionState(ada2, 0, codec, deviceSwitch);
        if (res == 0) goto L13;
        AudioService.sDeviceLogger.enqueue(new EventLogger.StringEvent("APM failed to make unavailable A2DP device addr=" + Utils.anonymizeBluetoothAddress(address) + " error=" + res).printSlog(1, TAG));
    L14:
        this.mApmConnectedDevices.remove(128);
        setCurrentAudioRouteNameIfPossible(null, true);
        mmi.record();
        updateBluetoothPreferredModes_l(null);
        purgeDevicesRoles_l();
        return;
    L13:
        AudioService.sDeviceLogger.enqueue(new EventLogger.StringEvent("A2DP device addr=" + Utils.anonymizeBluetoothAddress(address) + " made unavailable, deviceSwitch: " + deviceSwitch).printSlog(0, TAG));
        goto L14
    }

    private void makeA2dpDeviceUnavailableLater(String address, int delayMs) {
        this.mDeviceBroker.setA2dpSuspended(true, true, "makeA2dpDeviceUnavailableLater");
        String deviceKey = DeviceInfo.m1966$$Nest$smmakeDeviceListKey(128, address);
        DeviceInfo deviceInfo = this.mConnectedDevices.get(deviceKey);
        if (deviceInfo == null) goto L5;
        int a2dpCodec = deviceInfo.mDeviceCodecFormat;
    L6:
        this.mConnectedDevices.remove(deviceKey);
        this.mDeviceBroker.setA2dpTimeout(address, a2dpCodec, delayMs);
        return;
    L5:
        a2dpCodec = 0;
        goto L6
    }

    private void makeLeAudioUnavailableLater(String address, int delayMs, int codec, int device) {
        String deviceKey = DeviceInfo.m1966$$Nest$smmakeDeviceListKey(device, address);
        this.mConnectedDevices.remove(deviceKey);
        this.mDeviceBroker.setLeAudioTimeout(address, device, codec, delayMs);
    }

    private void makeA2dpSrcAvailable(String address, int a2dpCodec) {
        int res = this.mAudioSystem.setDeviceConnectionState(new AudioDeviceAttributes(AudioDevice.IN_BLUETOOTH_A2DP, address), 1, a2dpCodec, false);
        if (res == 0) goto L5;
        AudioService.sDeviceLogger.enqueue(new EventLogger.StringEvent("APM failed to make available A2DP source device addr=" + Utils.anonymizeBluetoothAddress(address) + " error=" + res).printSlog(1, TAG));
    L6:
        this.mConnectedDevices.put(DeviceInfo.m1966$$Nest$smmakeDeviceListKey(AudioDevice.IN_BLUETOOTH_A2DP, address), new DeviceInfo(AudioDevice.IN_BLUETOOTH_A2DP, "", address));
        return;
    L5:
        AudioService.sDeviceLogger.enqueue(new EventLogger.StringEvent("A2DP source device addr=" + Utils.anonymizeBluetoothAddress(address) + " now available").printSlog(0, TAG));
        goto L6
    }

    private void makeA2dpSrcUnavailable(String address) {
        String deviceKey = DeviceInfo.m1966$$Nest$smmakeDeviceListKey(AudioDevice.IN_BLUETOOTH_A2DP, address);
        DeviceInfo deviceInfo = this.mConnectedDevices.get(deviceKey);
        if (deviceInfo == null) goto L5;
        int a2dpCodec = deviceInfo.mDeviceCodecFormat;
    L6:
        AudioDeviceAttributes ada = new AudioDeviceAttributes(AudioDevice.IN_BLUETOOTH_A2DP, address);
        this.mAudioSystem.setDeviceConnectionState(ada, 0, a2dpCodec, false);
        this.mConnectedDevices.remove(DeviceInfo.m1966$$Nest$smmakeDeviceListKey(AudioDevice.IN_BLUETOOTH_A2DP, address));
        return;
    L5:
        a2dpCodec = 0;
        goto L6
    }

    private void makeHearingAidDeviceAvailable(String address, String name, int streamType, String eventSource) {
        int hearingAidVolIndex = this.mDeviceBroker.getVolumeForDeviceIgnoreMute(streamType, 134217728);
        this.mDeviceBroker.postSetHearingAidVolumeIndex(hearingAidVolIndex, streamType);
        this.mDeviceBroker.setBluetoothA2dpOnInt(true, false, eventSource);
        AudioDeviceAttributes ada = new AudioDeviceAttributes(134217728, address, name);
        this.mAudioSystem.setDeviceConnectionState(ada, 1, 0, false);
        AudioService.sDeviceLogger.enqueueAndSlog("HearingAid made available addr=" + address, 0, TAG);
        this.mConnectedDevices.put(DeviceInfo.m1966$$Nest$smmakeDeviceListKey(134217728, address), new DeviceInfo(134217728, name, address));
        this.mDeviceBroker.postAccessoryPlugMediaUnmute(134217728);
        this.mDeviceBroker.postApplyVolumeOnDevice(streamType, 134217728, "makeHearingAidDeviceAvailable");
        setCurrentAudioRouteNameIfPossible(name, false);
        addAudioDeviceInInventoryIfNeeded(134217728, address, "", BtHelper.getBtDeviceCategory(address), false);
        MediaMetrics.Item r0 = new MediaMetrics.Item("audio.device.makeHearingAidDeviceAvailable");
        MediaMetrics.Key r1 = MediaMetrics.Property.ADDRESS;
        if (address == null) goto L5;
        String r2 = address;
    L6:
        r0.set(r1, r2).set(MediaMetrics.Property.DEVICE, AudioSystem.getDeviceName(134217728)).set(MediaMetrics.Property.NAME, name).set(MediaMetrics.Property.STREAM_TYPE, AudioSystem.streamToString(streamType)).record();
        return;
    L5:
        r2 = "";
        goto L6
    }

    private void makeHearingAidDeviceUnavailable(String address, boolean deviceSwitch) {
        AudioDeviceAttributes ada = new AudioDeviceAttributes(134217728, address);
        this.mAudioSystem.setDeviceConnectionState(ada, 0, 0, deviceSwitch);
        this.mConnectedDevices.remove(DeviceInfo.m1966$$Nest$smmakeDeviceListKey(134217728, address));
        setCurrentAudioRouteNameIfPossible(null, false);
        MediaMetrics.Item r2 = new MediaMetrics.Item("audio.device.makeHearingAidDeviceUnavailable");
        MediaMetrics.Key r3 = MediaMetrics.Property.ADDRESS;
        if (address == null) goto L5;
        String r4 = address;
    L6:
        r2.set(r3, r4).set(MediaMetrics.Property.DEVICE, AudioSystem.getDeviceName(134217728)).record();
        return;
    L5:
        r4 = "";
        goto L6
    }

    private void makeHearingAidDeviceUnavailableLater(String address, int delayMs) {
        this.mConnectedDevices.remove(DeviceInfo.m1966$$Nest$smmakeDeviceListKey(134217728, address));
        this.mDeviceBroker.setHearingAidTimeout(address, delayMs);
    }

    boolean isHearingAidConnected() {
        if (getFirstConnectedDeviceOfTypes(Sets.newHashSet(new Integer[]{134217728})) == null) goto L5;
        return true;
    L5:
        return false;
    }

    private DeviceInfo getFirstConnectedDeviceOfTypes(Set<Integer> internalTypes) {
        List<DeviceInfo> devices = getConnectedDevicesOfTypes(internalTypes);
        if (devices.isEmpty() == false) goto L6;
        return null;
    L6:
        return devices.get(0);
    }

    AudioDeviceAttributes getFirstConnectedDeviceAttributesOfTypes(Set<Integer> internalTypes) {
        DeviceInfo di = getFirstConnectedDeviceOfTypes(internalTypes);
        if (di != null) goto L6;
        return null;
    L6:
        return new AudioDeviceAttributes(di.mDeviceType, di.mDeviceAddress, di.mDeviceName);
    }

    private List<DeviceInfo> getConnectedDevicesOfTypes(Set<Integer> internalTypes) {
        ArrayList<DeviceInfo> devices = new ArrayList();
        Object r1 = this.mDevicesLock;
        monitor-enter(r1);
        Iterator<DeviceInfo> r2 = this.mConnectedDevices.values().iterator();     // Catch: Throwable -> L10
    L6:
        if (r2.hasNext() == false) goto L13;
        DeviceInfo di = r2.next();     // Catch: Throwable -> L10
        if (internalTypes.contains(Integer.valueOf(di.mDeviceType)) == false) goto L6;
        devices.add(di);     // Catch: Throwable -> L10
        goto L6
    L13:
        monitor-exit(r1);     // Catch: Throwable -> L10
        return devices;
    L10:
        th = move-exception;
        throw th;
    }

    AudioDeviceAttributes getDeviceOfType(int type) {
        DeviceInfo di = getFirstConnectedDeviceOfTypes(Sets.newHashSet(new Integer[]{Integer.valueOf(type)}));
        if (di != null) goto L6;
        return null;
    L6:
        return new AudioDeviceAttributes(di.mDeviceType, di.mDeviceAddress, di.mDeviceName);
    }

    private void makeLeAudioDeviceAvailable(AudioDeviceBroker.BtDeviceInfo btInfo, int streamType, int codec, String eventSource) {
        if (btInfo.mVolume != (-1)) goto L5;
        int r1 = -1;
    L6:
        int volumeIndex = r1;
        int device = btInfo.mAudioSystemDevice;
        if (device == 0) goto L39;
        String address = btInfo.mDevice.getAddress();
        String name = BtHelper.getName(btInfo.mDevice);
        int groupId = this.mDeviceBroker.getLeAudioDeviceGroupId(btInfo.mDevice);
        if (groupId == (-1)) goto L19;
        List<Pair<String, String>> addresses = this.mDeviceBroker.getLeAudioGroupAddresses(groupId);
        if (addresses.size() <= 1) goto L19;
        Iterator<Pair<String, String>> r12 = addresses.iterator();
    L14:
        if (r12.hasNext() == false) goto L19;
        Pair<String, String> addr = r12.next();
        if (((String) addr.first).equals(address) == true) goto L14;
        String peerAddress = (String) addr.first;
        String peerIdentityAddress = (String) addr.second;
        String peerAddress2 = peerAddress;
        String peerIdentityAddress2 = peerIdentityAddress;
    L21:
        if (device == 536870914) goto L23;
    L25:
        String name2 = name;
    L26:
        this.mDeviceBroker.setBluetoothA2dpOnInt(true, false, eventSource);
        AudioDeviceAttributes ada = new AudioDeviceAttributes(device, address, name2);
        int res = this.mAudioSystem.setDeviceConnectionState(ada, 1, codec, false);
        if (res == 0) goto L29;
        AudioService.sDeviceLogger.enqueueAndSlog("APM failed to make available LE Audio device addr=" + address + " error=" + res, 1, TAG);
    L34:
        this.mDeviceBroker.clearLeAudioSuspended(true);
        this.mConnectedDevices.put(DeviceInfo.m1966$$Nest$smmakeDeviceListKey(device, address), new DeviceInfo(device, name2, address, btInfo.mDevice.getIdentityAddress(), codec, groupId, peerAddress2, peerIdentityAddress2));
        if (btInfo.mIsLeOutput == false) goto L37;
        this.mDeviceBroker.postAccessoryPlugMediaUnmute(device);
        setCurrentAudioRouteNameIfPossible(name2, false);
    L37:
        addAudioDeviceInInventoryIfNeeded(device, address, peerAddress2, BtHelper.getBtDeviceCategory(address), false);
        goto L39
    L29:
        EventLogger r3 = AudioService.sDeviceLogger;
        StringBuilder r8 = new StringBuilder();
        r8.append("LE Audio ");
        if (AudioSystem.isInputDevice(device) == false) goto L32;
        String r2 = StarLocation.KEY_LOCATION_SOURCE;
    L33:
        r8.append(r2);
        r8.append(" device addr=");
        r8.append(Utils.anonymizeBluetoothAddress(address));
        r8.append(" now available");
        r3.enqueue(new EventLogger.StringEvent(r8.toString()).printSlog(0, TAG));
        goto L34
    L32:
        r2 = "sink";
        goto L33
    L23:
        if (name.equals("") == false) goto L25;
        name2 = "Broadcast";
    L19:
        peerAddress2 = "";
        peerIdentityAddress2 = "";
    L39:
        if (btInfo.mIsLeOutput == true) goto L41;
    L47:
        updateBluetoothPreferredModes_l(btInfo.mDevice);
        return;
    L41:
        if (streamType != (-1)) goto L43;
        return;
    L43:
        if (volumeIndex != (-1)) goto L45;
        int leAudioVolIndex = this.mDeviceBroker.getVolumeForDeviceIgnoreMute(streamType, device);
    L46:
        int maxIndex = this.mDeviceBroker.getMaxVssVolumeForStream(streamType);
        this.mDeviceBroker.postSetLeAudioVolumeIndex(leAudioVolIndex, maxIndex, streamType);
        this.mDeviceBroker.postSetVolumeIndexOnDevice(streamType, leAudioVolIndex, device, "makeLeAudioDeviceAvailable");
        goto L47
    L45:
        leAudioVolIndex = volumeIndex;
        goto L46
    L5:
        r1 = btInfo.mVolume * 10;
        goto L6
    }

    private void makeLeAudioDeviceUnavailableNow(String address, int device, int codec, boolean deviceSwitch) {
        if (device == 0) goto L15;
        AudioDeviceAttributes ada = new AudioDeviceAttributes(device, address);
        int res = this.mAudioSystem.setDeviceConnectionState(ada, 0, codec, deviceSwitch);
        String r4 = "sink";
        if (res == 0) goto L10;
        EventLogger r6 = AudioService.sDeviceLogger;
        StringBuilder r8 = new StringBuilder();
        r8.append("APM failed to make unavailable LE Audio ");
        if (AudioSystem.isInputDevice(device) == false) goto L9;
        r4 = StarLocation.KEY_LOCATION_SOURCE;
    L9:
        r8.append(r4);
        r8.append(" device addr=");
        r8.append(address);
        r8.append(" error=");
        r8.append(res);
        r6.enqueue(new EventLogger.StringEvent(r8.toString()).printSlog(1, TAG));
    L14:
        this.mConnectedDevices.remove(DeviceInfo.m1966$$Nest$smmakeDeviceListKey(device, address));
        goto L15
    L10:
        EventLogger r7 = AudioService.sDeviceLogger;
        StringBuilder r9 = new StringBuilder();
        r9.append("LE Audio ");
        if (AudioSystem.isInputDevice(device) == false) goto L13;
        r4 = StarLocation.KEY_LOCATION_SOURCE;
    L13:
        r9.append(r4);
        r9.append("device addr=");
        r9.append(Utils.anonymizeBluetoothAddress(address));
        r9.append(" made unavailable, deviceSwitch: ");
        r9.append(deviceSwitch);
        r7.enqueue(new EventLogger.StringEvent(r9.toString()).printSlog(0, TAG));
    L15:
        setCurrentAudioRouteNameIfPossible(null, false);
        updateBluetoothPreferredModes_l(null);
        purgeDevicesRoles_l();
    }

    private void makeLeAudioDeviceUnavailableLater(String address, int device, int codec, int delayMs) {
        this.mDeviceBroker.setLeAudioSuspended(true, true, "makeLeAudioDeviceUnavailableLater");
        this.mConnectedDevices.remove(DeviceInfo.m1966$$Nest$smmakeDeviceListKey(device, address));
        this.mDeviceBroker.setLeAudioTimeout(address, device, codec, delayMs);
    }

    private void setCurrentAudioRouteNameIfPossible(String name, boolean fromA2dp) {
        AudioRoutesInfo r0 = this.mCurAudioRoutes;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (TextUtils.equals(this.mCurAudioRoutes.bluetoothName, name) == false) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        if (name == null) goto L12;
    L13:
        this.mCurAudioRoutes.bluetoothName = name;     // Catch: Throwable -> L8
        this.mDeviceBroker.postReportNewRoutes(fromA2dp);     // Catch: Throwable -> L8
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L12:
        if (isCurrentDeviceConnected() == true) goto L14;
        goto L13
    }

    private boolean isCurrentDeviceConnected() {
        return this.mConnectedDevices.values().stream().anyMatch(new AudioDeviceInventory$$ExternalSyntheticLambda24(this));
    }

    private /* synthetic */ boolean lambda$isCurrentDeviceConnected$38(DeviceInfo deviceInfo) {
        return TextUtils.equals(deviceInfo.mDeviceName, this.mCurAudioRoutes.bluetoothName);
    }

    private int checkSendBecomingNoisyIntentInt(int device, int state, int musicDevice) {
        MediaMetrics.Item r0 = new MediaMetrics.Item("audio.device.checkSendBecomingNoisyIntentInt").set(MediaMetrics.Property.DEVICE, AudioSystem.getDeviceName(device));
        MediaMetrics.Key r1 = MediaMetrics.Property.STATE;
        if (state != 1) goto L5;
        String r2 = "connected";
    L6:
        MediaMetrics.Item mmi = r0.set(r1, r2);
        if (state == 0) goto L11;
        Log.i(TAG, "not sending NOISY: state=" + state);
        mmi.set(MediaMetrics.Property.DELAY_MS, 0).record();
        return 0;
    L11:
        if (BECOMING_NOISY_INTENT_DEVICES_SET.contains(Integer.valueOf(device)) == true) goto L14;
        Log.i(TAG, "not sending NOISY: device=0x" + Integer.toHexString(device) + " not in set " + BECOMING_NOISY_INTENT_DEVICES_SET);
        mmi.set(MediaMetrics.Property.DELAY_MS, 0).record();
        return 0;
    L14:
        int delay = 0;
        Set<Integer> devices = new HashSet();
        Iterator<DeviceInfo> r5 = this.mConnectedDevices.values().iterator();
    L16:
        if (r5.hasNext() == false) goto L24;
        DeviceInfo di = r5.next();
        if (AudioSystem.isInputDevice(di.mDeviceType) == true) goto L16;
        if (BECOMING_NOISY_INTENT_DEVICES_SET.contains(Integer.valueOf(di.mDeviceType)) == false) goto L16;
        devices.add(Integer.valueOf(di.mDeviceType));
        Log.i(TAG, "NOISY: adding 0x" + Integer.toHexString(di.mDeviceType));
        goto L16
    L24:
        if (musicDevice != 0) goto L26;
        musicDevice = this.mDeviceBroker.getDeviceForStream(3);
        Log.i(TAG, "NOISY: musicDevice changing from NONE to 0x" + Integer.toHexString(musicDevice));
    L26:
        boolean inCommunication = this.mDeviceBroker.isInCommunication();
        boolean singleAudioDeviceType = AudioSystem.isSingleAudioDeviceType(devices, device);
        boolean hasMediaDynamicPolicy = this.mDeviceBroker.hasMediaDynamicPolicy();
        if (device == musicDevice) goto L29;
        if (inCommunication == true) goto L29;
    L40:
        Log.i(TAG, "not sending NOISY: device:0x" + Integer.toHexString(device) + " musicDevice:0x" + Integer.toHexString(musicDevice) + " inComm:" + inCommunication + " mediaPolicy:" + hasMediaDynamicPolicy + " singleDevice:" + singleAudioDeviceType);
    L41:
        mmi.set(MediaMetrics.Property.DELAY_MS, Integer.valueOf(delay)).record();
        return delay;
    L29:
        if (singleAudioDeviceType == false) goto L40;
        if (hasMediaDynamicPolicy == true) goto L40;
        if (musicDevice == 32768) goto L40;
        if (this.mAudioSystem.isStreamActive(3, 0) == false) goto L36;
    L39:
        this.mDeviceBroker.postBroadcastBecomingNoisy();
        delay = SystemProperties.getInt("audio.sys.noisy.broadcast.delay", 700);
        goto L41
    L36:
        if (this.mDeviceBroker.hasAudioFocusUsers() == true) goto L39;
        AudioService.sDeviceLogger.enqueue(new EventLogger.StringEvent("dropping ACTION_AUDIO_BECOMING_NOISY").printLog(TAG));
        mmi.set(MediaMetrics.Property.DELAY_MS, 0).record();
        return 0;
    L5:
        r2 = "disconnected";
        goto L6
    }

    private void sendDeviceConnectionIntent(int device, int state, String address, String deviceName) {
        Slog.i(TAG, "sendDeviceConnectionIntent(dev:0x" + Integer.toHexString(device) + " state:0x" + Integer.toHexString(state) + " address:" + address + " name:" + deviceName + ");");
        Intent intent = new Intent();
        int r1 = 0;
        switch(device) {
            case -2113929216: goto L14;
            case 4: goto L12;
            case 8: goto L11;
            case 1024: goto L10;
            case 131072: goto L11;
            case 262144: goto L10;
            case 262145: goto L10;
            case 67108864: goto L5;
            default: goto L17;
        };
    L5:
        intent.setAction("android.intent.action.HEADSET_PLUG");
        if (AudioSystem.getDeviceConnectionState(AudioDevice.IN_USB_HEADSET, "") != 1) goto L9;
        r1 = 1;
    L9:
        intent.putExtra("microphone", r1);
        goto L17
    L10:
        configureHdmiPlugIntent(intent, state);
        goto L17
    L11:
        intent.setAction("android.intent.action.HEADSET_PLUG");
        intent.putExtra("microphone", 0);
        goto L17
    L12:
        intent.setAction("android.intent.action.HEADSET_PLUG");
        intent.putExtra("microphone", 1);
        goto L17
    L14:
        if (AudioSystem.getDeviceConnectionState(67108864, "") != 1) goto L26;
        intent.setAction("android.intent.action.HEADSET_PLUG");
        intent.putExtra("microphone", 1);
        goto L17
    L26:
        return;
    L17:
        if (intent.getAction() != null) goto L19;
        return;
    L19:
        intent.putExtra("state", state);
        intent.putExtra(CONNECT_INTENT_KEY_ADDRESS, address);
        intent.putExtra(CONNECT_INTENT_KEY_PORT_NAME, deviceName);
        intent.addFlags(1073741824);
        long ident = Binder.clearCallingIdentity();
        this.mDeviceBroker.broadcastStickyIntentToCurrentProfileGroup(intent);     // Catch: Throwable -> L23
        Binder.restoreCallingIdentity(ident);
        return;
    L23:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    }

    private void updateAudioRoutes(int device, int state) {
        int connType = 0;
        switch(device) {
            case 4: goto L9;
            case 8: goto L8;
            case 1024: goto L7;
            case 4096: goto L6;
            case 16384: goto L5;
            case 131072: goto L8;
            case 262144: goto L7;
            case 262145: goto L7;
            case 67108864: goto L5;
            default: goto L10;
        };
    L5:
        connType = 16;
        goto L10
    L6:
        connType = 4;
        goto L10
    L7:
        connType = 8;
        goto L10
    L8:
        connType = 2;
        goto L10
    L9:
        connType = 1;
    L10:
        AudioRoutesInfo r1 = this.mCurAudioRoutes;
        monitor-enter(r1);
        if (connType != 0) goto L17;
        monitor-exit(r1);     // Catch: Throwable -> L15
        return;
    L17:
        int newConn = this.mCurAudioRoutes.mainType;     // Catch: Throwable -> L15
        if (state == 0) goto L20;
        int newConn2 = newConn | connType;     // Catch: Throwable -> L15
    L22:
        if (newConn2 == this.mCurAudioRoutes.mainType) goto L24;
        this.mCurAudioRoutes.mainType = newConn2;     // Catch: Throwable -> L15
        this.mDeviceBroker.postReportNewRoutes(false);     // Catch: Throwable -> L15
    L24:
        monitor-exit(r1);     // Catch: Throwable -> L15
        return;
    L20:
        newConn2 = newConn & (~connType);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    }

    private void configureHdmiPlugIntent(Intent intent, int state) {
        intent.setAction("android.media.action.HDMI_AUDIO_PLUG");
        intent.putExtra("android.media.extra.AUDIO_PLUG_STATE", state);
        if (state == 1) goto L5;
        return;
    L5:
        ArrayList<AudioPort> ports = new ArrayList();
        int[] portGeneration = new int[1];
        int status = AudioSystem.listAudioPorts(ports, portGeneration);
        if (status == 0) goto L9;
        Log.e(TAG, "listAudioPorts error " + status + " in configureHdmiPlugIntent");
        return;
    L9:
        Iterator<AudioPort> r6 = ports.iterator();
    L11:
        if (r6.hasNext() == false) goto L38;
        AudioPort r7 = r6.next();
        if ((r7 instanceof AudioDevicePort) == false) goto L11;
        AudioDevicePort devicePort = (AudioDevicePort) r7;
        if (devicePort.type() == 1024) goto L22;
        if (devicePort.type() == 262144) goto L22;
        if (devicePort.type() != 262145) goto L11;
    L22:
        int[] formats = AudioFormat.filterPublicFormats(devicePort.formats());
        int r11 = 0;
        if (formats.length <= 0) goto L31;
        ArrayList<Integer> encodingList = new ArrayList(1);
        int r12 = formats.length;
        int r13 = 0;
    L25:
        if (r13 >= r12) goto L30;
        int format = formats[r13];
        if (format == 0) goto L29;
        encodingList.add(Integer.valueOf(format));
    L29:
        r13 = r13 + 1;
        goto L25
    L30:
        int[] encodingArray = encodingList.stream().mapToInt(new AudioDeviceInventory$$ExternalSyntheticLambda29()).toArray();
        intent.putExtra("android.media.extra.ENCODINGS", encodingArray);
    L31:
        int maxChannels = 0;
        int[] r14 = devicePort.channelMasks();
        int r15 = r14.length;
    L32:
        if (r11 >= r15) goto L37;
        int mask = r14[r11];
        int channelCount = AudioFormat.channelCountFromOutChannelMask(mask);
        if (channelCount <= maxChannels) goto L36;
        maxChannels = channelCount;
    L36:
        r11 = r11 + 1;
        goto L32
    L37:
        intent.putExtra("android.media.extra.MAX_CHANNEL_COUNT", maxChannels);
        goto L11
    }

    private static /* synthetic */ int lambda$configureHdmiPlugIntent$39(Integer i) {
        return i.intValue();
    }

    private void dispatchPreferredDevice(int strategy, List<AudioDeviceAttributes> devices) {
        int nbDispatchers = this.mPrefDevDispatchers.beginBroadcast();
        int i = 0;
    L3:
        if (i >= nbDispatchers) goto L13;
        if (((Boolean) this.mPrefDevDispatchers.getBroadcastCookie(i)).booleanValue() == true) goto L9;
        devices = this.mDeviceBroker.anonymizeAudioDeviceAttributesListUnchecked(devices);     // Catch: RemoteException -> L7
    L9:
        this.mPrefDevDispatchers.getBroadcastItem(i).dispatchPrefDevicesChanged(strategy, devices);     // Catch: RemoteException -> L7
    L12:
        i = i + 1;
    L7:
        e = move-exception;
        Log.e(TAG, "dispatchPreferredDevice ", e);
        goto L12
    L13:
        this.mPrefDevDispatchers.finishBroadcast();
    }

    private void dispatchNonDefaultDevice(int strategy, List<AudioDeviceAttributes> devices) {
        int nbDispatchers = this.mNonDefDevDispatchers.beginBroadcast();
        int i = 0;
    L3:
        if (i >= nbDispatchers) goto L13;
        if (((Boolean) this.mNonDefDevDispatchers.getBroadcastCookie(i)).booleanValue() == true) goto L9;
        devices = this.mDeviceBroker.anonymizeAudioDeviceAttributesListUnchecked(devices);     // Catch: RemoteException -> L7
    L9:
        this.mNonDefDevDispatchers.getBroadcastItem(i).dispatchNonDefDevicesChanged(strategy, devices);     // Catch: RemoteException -> L7
    L12:
        i = i + 1;
    L7:
        e = move-exception;
        Log.e(TAG, "dispatchNonDefaultDevice ", e);
        goto L12
    L13:
        this.mNonDefDevDispatchers.finishBroadcast();
    }

    private void dispatchDevicesRoleForCapturePreset(int capturePreset, int role, List<AudioDeviceAttributes> devices) {
        int nbDispatchers = this.mDevRoleCapturePresetDispatchers.beginBroadcast();
        int i = 0;
    L3:
        if (i >= nbDispatchers) goto L13;
        if (((Boolean) this.mDevRoleCapturePresetDispatchers.getBroadcastCookie(i)).booleanValue() == true) goto L9;
        devices = this.mDeviceBroker.anonymizeAudioDeviceAttributesListUnchecked(devices);     // Catch: RemoteException -> L7
    L9:
        this.mDevRoleCapturePresetDispatchers.getBroadcastItem(i).dispatchDevicesRoleChanged(capturePreset, role, devices);     // Catch: RemoteException -> L7
    L12:
        i = i + 1;
    L7:
        e = move-exception;
        Log.e(TAG, "dispatchDevicesRoleForCapturePreset ", e);
        goto L12
    L13:
        this.mDevRoleCapturePresetDispatchers.finishBroadcast();
    }

    List<String> getDeviceIdentityAddresses(AudioDeviceAttributes device) {
        List<String> addresses = new ArrayList();
        String key = DeviceInfo.m1966$$Nest$smmakeDeviceListKey(device.getInternalType(), device.getAddress());
        Object r2 = this.mDevicesLock;
        monitor-enter(r2);
        DeviceInfo di = this.mConnectedDevices.get(key);     // Catch: Throwable -> L9
        if (di != null) goto L7;
    L16:
        monitor-exit(r2);     // Catch: Throwable -> L9
        return addresses;
    L7:
        if (di.mDeviceIdentityAddress.isEmpty() == true) goto L12;
        addresses.add(di.mDeviceIdentityAddress);     // Catch: Throwable -> L9
    L12:
        if (di.mPeerIdentityDeviceAddress.isEmpty() == true) goto L16;
        if (di.mPeerIdentityDeviceAddress.equals(di.mDeviceIdentityAddress) == true) goto L16;
        addresses.add(di.mPeerIdentityDeviceAddress);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    String getDeviceSettings() {
        Object r1 = this.mDeviceInventoryLock;
        monitor-enter(r1);
        int deviceCatalogSize = this.mDeviceInventory.size();     // Catch: Throwable -> L7
        StringBuilder settingsBuilder = new StringBuilder(AdiDeviceState.getPeristedMaxSize() * deviceCatalogSize);     // Catch: Throwable -> L7
        Iterator<AdiDeviceState> iterator = this.mDeviceInventory.values().iterator();     // Catch: Throwable -> L7
        if (iterator.hasNext() == false) goto L10;
        settingsBuilder.append(iterator.next().toPersistableString());     // Catch: Throwable -> L7
    L10:
        if (iterator.hasNext() == false) goto L12;
        settingsBuilder.append(SETTING_DEVICE_SEPARATOR_CHAR);     // Catch: Throwable -> L7
        settingsBuilder.append(iterator.next().toPersistableString());     // Catch: Throwable -> L7
        goto L10
    L12:
        String r4 = settingsBuilder.toString();     // Catch: Throwable -> L7
        monitor-exit(r1);     // Catch: Throwable -> L7
        return r4;
    L7:
        th = move-exception;
        throw th;
    }

    void setDeviceSettings(String settings) {
        clearDeviceInventory();
        settings.getClass();
        String[] devSettings = TextUtils.split(settings, SETTING_DEVICE_SEPARATOR);
        int r1 = devSettings.length;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L8;
        String setting = devSettings[r3];
        AdiDeviceState devState = AdiDeviceState.fromPersistedString(setting);
        if (devState == null) goto L7;
        addOrUpdateDeviceSAStateInInventory(devState, false);
        addOrUpdateAudioDeviceCategoryInInventory(devState, false);
    L7:
        r3 = r3 + 1;
        goto L3
    }

    public boolean isA2dpDeviceConnected(BluetoothDevice device) {
        Iterator<DeviceInfo> r0 = getConnectedDevicesOfTypes(Sets.newHashSet(new Integer[]{128})).iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        DeviceInfo di = r0.next();
        if (di.mDeviceAddress.equals(device.getAddress()) == false) goto L4;
        return true;
    L10:
        return false;
    }
}
