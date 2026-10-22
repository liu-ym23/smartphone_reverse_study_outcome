package com.android.server.media;

import android.R;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioDeviceAttributes;
import android.media.AudioDeviceCallback;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.media.MediaRoute2Info;
import android.media.audiopolicy.AudioProductStrategy;
import android.os.Handler;
import android.os.Looper;
import android.os.UserHandle;
import android.text.TextUtils;
import android.util.Slog;
import android.util.SparseArray;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
final class AudioManagerRouteController implements DeviceRouteController {
    private static final SparseArray<SystemRouteInfo> AUDIO_DEVICE_INFO_TYPE_TO_ROUTE_INFO = null;
    private static final AudioAttributes MEDIA_USAGE_AUDIO_ATTRIBUTES = null;
    private static final String TAG = "MR2SystemProvider";
    private static AudioManagerRouteController mInstance;
    private final AudioDeviceCallback mAudioDeviceCallback;
    private final AudioManager mAudioManager;
    private final BluetoothDeviceRoutesManager mBluetoothRouteController;
    private final int mBuiltInSpeakerSuitabilityStatus;
    private final Context mContext;
    private final Handler mHandler;
    private final CopyOnWriteArrayList<DeviceRouteController.OnDeviceRouteChangedListener> mOnDeviceRouteChangedListeners;
    private final AudioManager.OnDevicesForAttributesChangedListener mOnDevicesForAttributesChangedListener;
    private final Map<String, MediaRoute2InfoHolder> mRouteIdToAvailableDeviceRoutes;
    private MediaRoute2Info mSelectedRoute;
    private boolean mStarted;
    private final AudioProductStrategy mStrategyForMedia;

    private class AudioDeviceCallbackImpl extends AudioDeviceCallback {
        final /* synthetic */ AudioManagerRouteController this$0;

        /* synthetic */ AudioDeviceCallbackImpl(AudioManagerRouteController r1, AudioManagerRouteControllerIA r2) {
            this(r1);
        }

        private AudioDeviceCallbackImpl(AudioManagerRouteController r1) {
            this.this$0 = r1;
        }

        @Override // android.media.AudioDeviceCallback
        public void onAudioDevicesAdded(AudioDeviceInfo[] addedDevices) {
            int r0 = addedDevices.length;
            int r1 = 0;
        L4:
            if (r1 >= r0) goto L12;
            AudioDeviceInfo deviceInfo = addedDevices[r1];
            if (AudioManagerRouteController.m5504$$Nest$sfgetAUDIO_DEVICE_INFO_TYPE_TO_ROUTE_INFO().contains(deviceInfo.getType()) == true) goto L7;
            r1 = r1 + 1;
            goto L4
        L7:
            AudioManagerRouteController.m5501$$Nest$fgetmAudioManager(this.this$0).removePreferredDeviceForStrategy(AudioManagerRouteController.m5502$$Nest$fgetmStrategyForMedia(this.this$0));
            AudioManagerRouteController.m5503$$Nest$mrebuildAvailableRoutesAndNotify(this.this$0);
            return;
        }

        @Override // android.media.AudioDeviceCallback
        public void onAudioDevicesRemoved(AudioDeviceInfo[] removedDevices) {
            int r0 = removedDevices.length;
            int r1 = 0;
        L4:
            if (r1 >= r0) goto L12;
            AudioDeviceInfo deviceInfo = removedDevices[r1];
            if (AudioManagerRouteController.m5504$$Nest$sfgetAUDIO_DEVICE_INFO_TYPE_TO_ROUTE_INFO().contains(deviceInfo.getType()) == true) goto L7;
            r1 = r1 + 1;
            goto L4
        L7:
            AudioManagerRouteController.m5503$$Nest$mrebuildAvailableRoutesAndNotify(this.this$0);
            return;
        }
    }

    private static class MediaRoute2InfoHolder {
        public final int mAudioDeviceInfoType;
        public final boolean mCorrespondsToInactiveBluetoothRoute;
        public final MediaRoute2Info mMediaRoute2Info;

        public static MediaRoute2InfoHolder createForAudioManagerRoute(MediaRoute2Info mediaRoute2Info, int audioDeviceInfoType) {
            return new MediaRoute2InfoHolder(mediaRoute2Info, audioDeviceInfoType, false);
        }

        public static MediaRoute2InfoHolder createForInactiveBluetoothRoute(MediaRoute2Info mediaRoute2Info) {
            return new MediaRoute2InfoHolder(mediaRoute2Info, 0, true);
        }

        private MediaRoute2InfoHolder(MediaRoute2Info mediaRoute2Info, int audioDeviceInfoType, boolean correspondsToInactiveBluetoothRoute) {
            this.mMediaRoute2Info = mediaRoute2Info;
            this.mAudioDeviceInfoType = audioDeviceInfoType;
            this.mCorrespondsToInactiveBluetoothRoute = correspondsToInactiveBluetoothRoute;
        }

        public MediaRoute2InfoHolder copyWithVolumeInfo(int musicVolume, int musicMaxVolume, boolean isVolumeFixed) {
            MediaRoute2Info.Builder r0 = new MediaRoute2Info.Builder(this.mMediaRoute2Info);
            if (isVolumeFixed == false) goto L5;
            int r1 = 0;
        L6:
            MediaRoute2Info routeInfoWithVolumeInfo = r0.setVolumeHandling(r1).setVolume(musicVolume).setVolumeMax(musicMaxVolume).build();
            return new MediaRoute2InfoHolder(routeInfoWithVolumeInfo, this.mAudioDeviceInfoType, this.mCorrespondsToInactiveBluetoothRoute);
        L5:
            r1 = 1;
            goto L6
        }
    }

    private static class SystemRouteInfo {
        public final String mDefaultRouteId;
        public final int mMediaRoute2InfoType;
        public final int mNameResource;

        /* synthetic */ SystemRouteInfo(int r1, String r2, int r3, AudioManagerRouteControllerIA r4) {
            this(r1, r2, r3);
        }

        private SystemRouteInfo(int mediaRoute2InfoType, String defaultRouteId, int nameResource) {
            this.mMediaRoute2InfoType = mediaRoute2InfoType;
            this.mDefaultRouteId = defaultRouteId;
            this.mNameResource = nameResource;
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$-_oU9yDXV1U3xDwofh4mPa-gfkY, reason: not valid java name */
    public static /* synthetic */ void m5496$r8$lambda$_oU9yDXV1U3xDwofh4mPagfkY(AudioManagerRouteController r0) {
        r0.rebuildAvailableRoutesAndNotify();
    }

    /* JADX INFO: renamed from: $r8$lambda$1zvgH30oLg-t46HD-ksi1UXLG7g, reason: not valid java name */
    public static /* synthetic */ void m5497$r8$lambda$1zvgH30oLgt46HDksi1UXLG7g(AudioManagerRouteController r0, MediaRoute2InfoHolder r1) {
        r0.lambda$updateAvailableRoutes$5(r1);
    }

    public static /* synthetic */ MediaRoute2Info $r8$lambda$8ZuofFIW5BsTfgvn45XuGVk0sNM(MediaRoute2InfoHolder r0) {
        return lambda$getAvailableRoutes$0(r0);
    }

    public static /* synthetic */ void $r8$lambda$J5U1lvxLi4aj5pKkgirjL76cyO4(AudioManagerRouteController r0, Runnable r1, String r2) {
        r0.lambda$transferTo$1(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$LXpYmtCm1iZqPmpoJRXA3ygviaY(AudioManagerRouteController r0) {
        r0.rebuildAvailableRoutesAndNotify();
    }

    public static /* synthetic */ void $r8$lambda$Tl1tJS2q4v9F2xTgvzHxh4XxbMk(AudioManagerRouteController r0, AudioDeviceAttributes r1) {
        r0.lambda$getTransferActionForRoute$3(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$gRSid8P0o7-_gK9-205II82t8Bo, reason: not valid java name */
    public static /* synthetic */ boolean m5498$r8$lambda$gRSid8P0o7_gK9205II82t8Bo(AudioManagerRouteController r0, MediaRoute2Info r1) {
        return r0.lambda$updateAvailableRoutes$4(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$gr3LU52lDiQLjP7tmD8Zc-CNrUU, reason: not valid java name */
    public static /* synthetic */ void m5499$r8$lambda$gr3LU52lDiQLjP7tmD8ZcCNrUU(AudioManagerRouteController r0, AudioAttributes r1, List r2) {
        r0.onDevicesForAttributesChangedListener(r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$qYi60g5OI8-fyWsoWy3MwrodxCI, reason: not valid java name */
    public static /* synthetic */ void m5500$r8$lambda$qYi60g5OI8fyWsoWy3MwrodxCI(AudioManagerRouteController r0, String r1) {
        r0.lambda$getTransferActionForRoute$2(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmAudioManager, reason: not valid java name */
    static /* bridge */ /* synthetic */ AudioManager m5501$$Nest$fgetmAudioManager(AudioManagerRouteController r0) {
        return r0.mAudioManager;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmStrategyForMedia, reason: not valid java name */
    static /* bridge */ /* synthetic */ AudioProductStrategy m5502$$Nest$fgetmStrategyForMedia(AudioManagerRouteController r0) {
        return r0.mStrategyForMedia;
    }

    /* JADX INFO: renamed from: -$$Nest$mrebuildAvailableRoutesAndNotify, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5503$$Nest$mrebuildAvailableRoutesAndNotify(AudioManagerRouteController r0) {
        r0.rebuildAvailableRoutesAndNotify();
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetAUDIO_DEVICE_INFO_TYPE_TO_ROUTE_INFO, reason: not valid java name */
    static /* bridge */ /* synthetic */ SparseArray m5504$$Nest$sfgetAUDIO_DEVICE_INFO_TYPE_TO_ROUTE_INFO() {
        return AUDIO_DEVICE_INFO_TYPE_TO_ROUTE_INFO;
    }

    static {
        MEDIA_USAGE_AUDIO_ATTRIBUTES = new AudioAttributes.Builder().setUsage(1).build();
        AUDIO_DEVICE_INFO_TYPE_TO_ROUTE_INFO = new SparseArray();
        AudioManagerRouteControllerIA r5 = null;
        AUDIO_DEVICE_INFO_TYPE_TO_ROUTE_INFO.put(2, new SystemRouteInfo(2, "ROUTE_ID_BUILTIN_SPEAKER", R.string.duration_minutes_shortest_past, r5));
        SparseArray<SystemRouteInfo> r0 = AUDIO_DEVICE_INFO_TYPE_TO_ROUTE_INFO;
        int r4 = R.string.duration_years_medium_past;
        r0.put(3, new SystemRouteInfo(3, "ROUTE_ID_WIRED_HEADSET", r4, r5));
        int r3 = 4;
        AUDIO_DEVICE_INFO_TYPE_TO_ROUTE_INFO.put(4, new SystemRouteInfo(r3, "ROUTE_ID_WIRED_HEADPHONES", r4, r5));
        SparseArray<SystemRouteInfo> r1 = AUDIO_DEVICE_INFO_TYPE_TO_ROUTE_INFO;
        int r6 = R.string.car_mode_disable_notification_message;
        r1.put(8, new SystemRouteInfo(8, "ROUTE_ID_BLUETOOTH_A2DP", r6, r5));
        SparseArray<SystemRouteInfo> r2 = AUDIO_DEVICE_INFO_TYPE_TO_ROUTE_INFO;
        int r7 = R.string.duration_years_medium_future;
        r2.put(9, new SystemRouteInfo(9, "ROUTE_ID_HDMI", r7, r5));
        SparseArray<SystemRouteInfo> r8 = AUDIO_DEVICE_INFO_TYPE_TO_ROUTE_INFO;
        int r9 = 13;
        int r10 = R.string.duration_years_medium;
        r8.put(13, new SystemRouteInfo(r9, "ROUTE_ID_DOCK", r10, r5));
        SparseArray<SystemRouteInfo> r11 = AUDIO_DEVICE_INFO_TYPE_TO_ROUTE_INFO;
        int r12 = R.string.duration_years_relative;
        r11.put(11, new SystemRouteInfo(11, "ROUTE_ID_USB_DEVICE", r12, r5));
        int r13 = 22;
        AUDIO_DEVICE_INFO_TYPE_TO_ROUTE_INFO.put(22, new SystemRouteInfo(r13, "ROUTE_ID_USB_HEADSET", r12, r5));
        int r14 = 10;
        AUDIO_DEVICE_INFO_TYPE_TO_ROUTE_INFO.put(10, new SystemRouteInfo(r14, "ROUTE_ID_HDMI_ARC", r7, r5));
        int r15 = 29;
        AUDIO_DEVICE_INFO_TYPE_TO_ROUTE_INFO.put(29, new SystemRouteInfo(r15, "ROUTE_ID_HDMI_EARC", r7, r5));
        int r16 = 23;
        AUDIO_DEVICE_INFO_TYPE_TO_ROUTE_INFO.put(23, new SystemRouteInfo(r16, "ROUTE_ID_HEARING_AID", r6, r5));
        int r17 = 26;
        AUDIO_DEVICE_INFO_TYPE_TO_ROUTE_INFO.put(26, new SystemRouteInfo(r17, "ROUTE_ID_BLE_HEADSET", r6, r5));
        AUDIO_DEVICE_INFO_TYPE_TO_ROUTE_INFO.put(27, new SystemRouteInfo(r17, "ROUTE_ID_BLE_SPEAKER", r6, r5));
        AUDIO_DEVICE_INFO_TYPE_TO_ROUTE_INFO.put(30, new SystemRouteInfo(r17, "ROUTE_ID_BLE_BROADCAST", r6, r5));
        int r18 = 6;
        AUDIO_DEVICE_INFO_TYPE_TO_ROUTE_INFO.put(6, new SystemRouteInfo(r18, "ROUTE_ID_LINE_DIGITAL", r7, r5));
        int r19 = 5;
        AUDIO_DEVICE_INFO_TYPE_TO_ROUTE_INFO.put(5, new SystemRouteInfo(r19, "ROUTE_ID_LINE_ANALOG", r7, r5));
        int r20 = 19;
        AUDIO_DEVICE_INFO_TYPE_TO_ROUTE_INFO.put(19, new SystemRouteInfo(r20, "ROUTE_ID_AUX_LINE", r7, r5));
        AUDIO_DEVICE_INFO_TYPE_TO_ROUTE_INFO.put(31, new SystemRouteInfo(r9, "ROUTE_ID_DOCK_ANALOG", r10, r5));
        int r21 = 32;
        AUDIO_DEVICE_INFO_TYPE_TO_ROUTE_INFO.put(32, new SystemRouteInfo(r21, "ROUTE_ID_MULTICHANNEL_SPEAKER_GROUP", r7, r5));
    }

    public static AudioManagerRouteController getInstance(Context context, AudioManager audioManager, Looper looper, AudioProductStrategy strategyForMedia, BluetoothAdapter btAdapter) {
        return new AudioManagerRouteController(context, audioManager, looper, strategyForMedia, btAdapter);
    }

    AudioManagerRouteController(Context context, AudioManager audioManager, Looper looper, AudioProductStrategy strategyForMedia, BluetoothAdapter btAdapter) {
        this.mOnDeviceRouteChangedListeners = new CopyOnWriteArrayList();
        this.mAudioDeviceCallback = new AudioDeviceCallbackImpl(this, null);
        this.mOnDevicesForAttributesChangedListener = new AudioManagerRouteController$$ExternalSyntheticLambda9(this);
        this.mRouteIdToAvailableDeviceRoutes = new HashMap();
        this.mStarted = false;
        context.getClass();
        this.mContext = context;
        audioManager.getClass();
        this.mAudioManager = audioManager;
        looper.getClass();
        this.mHandler = new Handler(looper);
        strategyForMedia.getClass();
        this.mStrategyForMedia = strategyForMedia;
        this.mBuiltInSpeakerSuitabilityStatus = DeviceRouteController.getBuiltInSpeakerSuitabilityStatus(this.mContext);
        this.mBluetoothRouteController = new BluetoothDeviceRoutesManager(this.mContext, this.mHandler, btAdapter, new AudioManagerRouteController$$ExternalSyntheticLambda10(this));
        rebuildAvailableRoutes();
    }

    public void registerRouteChangeListener(DeviceRouteController.OnDeviceRouteChangedListener onDeviceRouteChangedListener) {
        this.mOnDeviceRouteChangedListeners.add(onDeviceRouteChangedListener);
    }

    public void unregisterRouteChangeListener(DeviceRouteController.OnDeviceRouteChangedListener onDeviceRouteChangedListener) {
        this.mOnDeviceRouteChangedListeners.remove(onDeviceRouteChangedListener);
    }

    @Override // com.android.server.media.DeviceRouteController
    public void start(UserHandle mUser) {
        this.mBluetoothRouteController.start(mUser);
        this.mAudioManager.registerAudioDeviceCallback(this.mAudioDeviceCallback, this.mHandler);
        this.mAudioManager.addOnDevicesForAttributesChangedListener(AudioRoutingUtils.ATTRIBUTES_MEDIA, new android.os.HandlerExecutor(this.mHandler), this.mOnDevicesForAttributesChangedListener);
    }

    @Override // com.android.server.media.DeviceRouteController
    public void stop() {
        this.mAudioManager.removeOnDevicesForAttributesChangedListener(this.mOnDevicesForAttributesChangedListener);
        this.mAudioManager.unregisterAudioDeviceCallback(this.mAudioDeviceCallback);
        this.mBluetoothRouteController.stop();
        this.mHandler.removeCallbacksAndMessages(null);
    }

    @Override // com.android.server.media.DeviceRouteController
    public synchronized MediaRoute2Info getSelectedRoute() {
        monitor-enter(this);
        MediaRoute2Info r0 = this.mSelectedRoute;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.media.DeviceRouteController
    public synchronized List<MediaRoute2Info> getAvailableRoutes() {
        monitor-enter(this);
        List<MediaRoute2Info> r0 = this.mRouteIdToAvailableDeviceRoutes.values().stream().map(new AudioManagerRouteController$$ExternalSyntheticLambda7()).toList();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    private static /* synthetic */ MediaRoute2Info lambda$getAvailableRoutes$0(MediaRoute2InfoHolder it) {
        return it.mMediaRoute2Info;
    }

    @Override // com.android.server.media.DeviceRouteController
    public void transferTo(final String routeId) {
        if (routeId != null) goto L5;
        Slog.e(TAG, "Unexpected call to AudioPoliciesDeviceRouteController#transferTo(null)");
        return;
    L5:
        monitor-enter(this);
        MediaRoute2InfoHolder mediaRoute2InfoHolder = this.mRouteIdToAvailableDeviceRoutes.get(routeId);     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        if (mediaRoute2InfoHolder != null) goto L11;
        Slog.w(TAG, "transferTo: Ignoring transfer request to unknown route id : " + routeId);
        return;
    L11:
        final Runnable transferAction = getTransferActionForRoute(mediaRoute2InfoHolder);
        Runnable guardedTransferAction = new AudioManagerRouteController$$ExternalSyntheticLambda8(this, transferAction, routeId);
        this.mHandler.post(guardedTransferAction);
        return;
    L13:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$transferTo$1(Runnable transferAction, String routeId) {
        transferAction.run();     // Catch: Throwable -> L4
        return;
    L4:
        throwable = move-exception;
        Slog.e(TAG, "Unexpected exception while transferring to route id: " + routeId, throwable);
        this.mHandler.post(new AudioManagerRouteController$$ExternalSyntheticLambda6(this));
    }

    @Override // com.android.server.media.DeviceRouteController
    public boolean updateVolume(int volume) {
        rebuildAvailableRoutesAndNotify();
        return true;
    }

    private Runnable getTransferActionForRoute(MediaRoute2InfoHolder mediaRoute2InfoHolder) {
        if (mediaRoute2InfoHolder.mCorrespondsToInactiveBluetoothRoute == false) goto L6;
        final String deviceAddress = mediaRoute2InfoHolder.mMediaRoute2Info.getAddress();
        return new AudioManagerRouteController$$ExternalSyntheticLambda4(this, deviceAddress);
    L6:
        final AudioDeviceAttributes deviceAttributes = new AudioDeviceAttributes(2, mediaRoute2InfoHolder.mAudioDeviceInfoType, "");
        return new AudioManagerRouteController$$ExternalSyntheticLambda5(this, deviceAttributes);
    }

    private /* synthetic */ void lambda$getTransferActionForRoute$2(String deviceAddress) {
        this.mBluetoothRouteController.activateBluetoothDeviceWithAddress(deviceAddress);
        this.mAudioManager.removePreferredDeviceForStrategy(this.mStrategyForMedia);
    }

    private /* synthetic */ void lambda$getTransferActionForRoute$3(AudioDeviceAttributes deviceAttributes) {
        this.mAudioManager.setPreferredDeviceForStrategy(this.mStrategyForMedia, deviceAttributes);
    }

    private void onDevicesForAttributesChangedListener(AudioAttributes attributes, List<AudioDeviceAttributes> unusedAudioDeviceAttributes) {
        if (attributes.getUsage() != 1) goto L6;
        rebuildAvailableRoutesAndNotify();
        return;
    }

    private void rebuildAvailableRoutesAndNotify() {
        rebuildAvailableRoutes();
        Iterator<DeviceRouteController.OnDeviceRouteChangedListener> r0 = this.mOnDeviceRouteChangedListeners.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        DeviceRouteController.OnDeviceRouteChangedListener listener = r0.next();
        listener.onDeviceRouteChanged();
        goto L4
    }

    private void rebuildAvailableRoutes() {
        List<AudioDeviceAttributes> attributesOfSelectedOutputDevices = this.mAudioManager.getDevicesForAttributes(MEDIA_USAGE_AUDIO_ATTRIBUTES);
        if (attributesOfSelectedOutputDevices.isEmpty() == false) goto L5;
        Slog.e(TAG, "Unexpected empty list of output devices for media. Using built-in speakers.");
        int selectedDeviceAttributesType = 2;
    L9:
        updateAvailableRoutes(selectedDeviceAttributesType, this.mAudioManager.getDevices(2), this.mBluetoothRouteController.getAvailableBluetoothRoutes(), this.mAudioManager.getStreamVolume(3), this.mAudioManager.getStreamMaxVolume(3), this.mAudioManager.isVolumeFixed());
        return;
    L5:
        int selectedDeviceAttributesType2 = attributesOfSelectedOutputDevices.size();
        if (selectedDeviceAttributesType2 <= 1) goto L8;
        Slog.w(TAG, "AudioManager.getDevicesForAttributes returned more than one element. Using the first one.");
    L8:
        selectedDeviceAttributesType = attributesOfSelectedOutputDevices.get(0).getType();
        goto L9
    }

    private synchronized void updateAvailableRoutes(int selectedDeviceAttributesType, AudioDeviceInfo[] audioDeviceInfos, List<MediaRoute2Info> availableBluetoothRoutes, int musicVolume, int musicMaxVolume, boolean isVolumeFixed) {
        monitor-enter(this);
        this.mRouteIdToAvailableDeviceRoutes.clear();     // Catch: Throwable -> L10
        MediaRoute2InfoHolder newSelectedRouteHolder = null;
        int r1 = audioDeviceInfos.length;     // Catch: Throwable -> L10
        int r2 = 0;
    L4:
        if (r2 >= r1) goto L14;
        AudioDeviceInfo audioDeviceInfo = audioDeviceInfos[r2];     // Catch: Throwable -> L10
        MediaRoute2Info mediaRoute2Info = createMediaRoute2InfoFromAudioDeviceInfo(audioDeviceInfo);     // Catch: Throwable -> L10
        if (mediaRoute2Info == null) goto L12;
        int audioDeviceInfoType = audioDeviceInfo.getType();     // Catch: Throwable -> L10
        MediaRoute2InfoHolder newHolder = MediaRoute2InfoHolder.createForAudioManagerRoute(mediaRoute2Info, audioDeviceInfoType);     // Catch: Throwable -> L10
        this.mRouteIdToAvailableDeviceRoutes.put(mediaRoute2Info.getId(), newHolder);     // Catch: Throwable -> L10
        if (selectedDeviceAttributesType != audioDeviceInfoType) goto L12;
        newSelectedRouteHolder = newHolder;
    L12:
        r2 = r2 + 1;     // Catch: Throwable -> L10
        goto L4
    L14:
        if (this.mRouteIdToAvailableDeviceRoutes.isEmpty() == false) goto L16;
        Slog.e(TAG, "Ended up with an empty list of routes. Creating a placeholder route.");     // Catch: Throwable -> L10
        MediaRoute2InfoHolder placeholderRouteHolder = createPlaceholderBuiltinSpeakerRoute();     // Catch: Throwable -> L10
        String placeholderRouteId = placeholderRouteHolder.mMediaRoute2Info.getId();     // Catch: Throwable -> L10
        this.mRouteIdToAvailableDeviceRoutes.put(placeholderRouteId, placeholderRouteHolder);     // Catch: Throwable -> L10
    L16:
        if (newSelectedRouteHolder != null) goto L18;
        Slog.e(TAG, "Could not map this selected device attribute type to an available route: " + selectedDeviceAttributesType + ". Available types: " + Arrays.toString(Arrays.stream(audioDeviceInfos).map(new AudioManagerRouteController$$ExternalSyntheticLambda0()).toArray()));     // Catch: Throwable -> L10
        newSelectedRouteHolder = this.mRouteIdToAvailableDeviceRoutes.values().iterator().next();     // Catch: Throwable -> L10
    L18:
        MediaRoute2InfoHolder selectedRouteHolderWithUpdatedVolumeInfo = newSelectedRouteHolder.copyWithVolumeInfo(musicVolume, musicMaxVolume, isVolumeFixed);     // Catch: Throwable -> L10
        this.mRouteIdToAvailableDeviceRoutes.put(newSelectedRouteHolder.mMediaRoute2Info.getId(), selectedRouteHolderWithUpdatedVolumeInfo);     // Catch: Throwable -> L10
        this.mSelectedRoute = selectedRouteHolderWithUpdatedVolumeInfo.mMediaRoute2Info;     // Catch: Throwable -> L10
        availableBluetoothRoutes.stream().filter(new AudioManagerRouteController$$ExternalSyntheticLambda1(this)).map(new AudioManagerRouteController$$ExternalSyntheticLambda2()).forEach(new AudioManagerRouteController$$ExternalSyntheticLambda3(this));     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ boolean lambda$updateAvailableRoutes$4(MediaRoute2Info it) {
        return !this.mRouteIdToAvailableDeviceRoutes.containsKey(it.getId());
    }

    private /* synthetic */ void lambda$updateAvailableRoutes$5(MediaRoute2InfoHolder it) {
        this.mRouteIdToAvailableDeviceRoutes.put(it.mMediaRoute2Info.getId(), it);
    }

    private MediaRoute2InfoHolder createPlaceholderBuiltinSpeakerRoute() {
        return MediaRoute2InfoHolder.createForAudioManagerRoute(createMediaRoute2Info(null, 2, null, null), 2);
    }

    private MediaRoute2Info createMediaRoute2InfoFromAudioDeviceInfo(AudioDeviceInfo audioDeviceInfo) {
        String address = audioDeviceInfo.getAddress();
        String routeId = null;
        String deviceName = audioDeviceInfo.getPort().name();
        if (this.mBluetoothRouteController.containsBondedDeviceWithAddress(address) == false) goto L6;
        routeId = this.mBluetoothRouteController.getRouteIdForBluetoothAddress(address);
        deviceName = this.mBluetoothRouteController.getNameForBluetoothAddress(address);
    L6:
        return createMediaRoute2Info(routeId, audioDeviceInfo.getType(), deviceName, address);
    }

    private MediaRoute2Info createMediaRoute2Info(String routeId, int audioDeviceInfoType, CharSequence deviceName, String address) {
        SystemRouteInfo systemRouteInfo = AUDIO_DEVICE_INFO_TYPE_TO_ROUTE_INFO.get(audioDeviceInfoType);
        if (systemRouteInfo != null) goto L6;
        return null;
    L6:
        CharSequence humanReadableName = deviceName;
        if (TextUtils.isEmpty(humanReadableName) == false) goto L9;
        humanReadableName = this.mContext.getResources().getText(systemRouteInfo.mNameResource);
    L9:
        if (routeId != null) goto L11;
        routeId = systemRouteInfo.mDefaultRouteId;
    L11:
        MediaRoute2Info.Builder builder = new MediaRoute2Info.Builder(routeId, humanReadableName).setType(systemRouteInfo.mMediaRoute2InfoType).setAddress(address).setSystemRoute(true).addFeature("android.media.route.feature.LIVE_AUDIO").addFeature("android.media.route.feature.LOCAL_PLAYBACK").setConnectionState(2);
        if (systemRouteInfo.mMediaRoute2InfoType != 2) goto L15;
        builder.setSuitabilityStatus(this.mBuiltInSpeakerSuitabilityStatus);
    L15:
        return builder.build();
    }
}
