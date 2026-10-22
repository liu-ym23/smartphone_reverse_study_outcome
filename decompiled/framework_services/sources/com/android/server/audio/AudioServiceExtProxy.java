package com.android.server.audio;

import android.app.PendingIntent;
import android.bluetooth.BluetoothDevice;
import android.database.ContentObserver;
import android.media.AudioDeviceAttributes;
import android.media.AudioPlaybackConfiguration;
import android.media.AudioPlaybackFilter;
import android.media.AudioRecordingConfiguration;
import android.media.AudioRecordingFilter;
import android.media.BluetoothProfileConnectionInfo;
import android.media.FocusOwnerInfo;
import android.media.IAudioPlaybackEventDispatcher;
import android.media.IAudioRecordingEventDispatcher;
import android.media.IAudioServiceExtension;
import android.media.IControlStreamDispatcher;
import android.net.Uri;
import android.prometheus.ext.core.ExtLoader;
import android.util.Log;
import android.util.SparseIntArray;
import com.android.server.utils.EventLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public class AudioServiceExtProxy extends IAudioServiceExtension.Stub {
    private static final String TAG = "AS.AudioServiceExtProxy";
    private List<AudioServiceExt> mAudioServiceExts;
    private AudioService mBase;

    public static /* synthetic */ int $r8$lambda$K0eQhbyNfCFhhayldnlDuzbfoo8(Integer r0) {
        return lambda$AudioService_getDefaultResId$2(r0);
    }

    public static /* synthetic */ int $r8$lambda$VePWCIrezFw_IKIt4DCK12spRlA(Integer r0) {
        return lambda$AudioService_getStreams$0(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$_v4CCvuuG176-9ri2wsHmbvy8SE, reason: not valid java name */
    public static /* synthetic */ int m2132$r8$lambda$_v4CCvuuG1769ri2wsHmbvy8SE(Integer r0) {
        return lambda$AudioService_getStepsResId$1(r0);
    }

    public static AudioServiceExtProxy get(AudioService base) {
        return new AudioServiceExtProxy(base);
    }

    public AudioServiceExtProxy(AudioService base) {
        this.mAudioServiceExts = ExtLoader.getAll(AudioServiceExt.class, base);
        this.mBase = base;
    }

    public int getControlStreamType() {
        return getControlStreamType_onEnd();
    }

    public void registerControlStreamCallback(IControlStreamDispatcher csd) {
        registerControlStreamCallback_onEnd(csd);
    }

    public void unregisterControlStreamCallback(IControlStreamDispatcher csd) {
        unregisterControlStreamCallback_onEnd(csd);
    }

    public FocusOwnerInfo getCurrentAudioFocusOwner() {
        if (this.mAudioServiceExts == null) goto L11;
        Iterator<AudioServiceExt> r0 = this.mAudioServiceExts.iterator();
    L6:
        if (r0.hasNext() == false) goto L16;
        AudioServiceExt ext = r0.next();
        FocusOwnerInfo info = ext.getCurrentAudioFocusOwner();
        if (info == null) goto L6;
        return info;
    L16:
        return null;
    L11:
        return null;
    }

    public void registerAudioPlaybackObserver(IAudioPlaybackEventDispatcher observer, AudioPlaybackFilter filter) {
        if (this.mAudioServiceExts == null) goto L8;
        Iterator<AudioServiceExt> r0 = this.mAudioServiceExts.iterator();
    L6:
        if (r0.hasNext() == false) goto L10;
        AudioServiceExt ext = r0.next();
        ext.registerAudioPlaybackObserver(observer, filter);
        goto L6
    L10:
        return;
    }

    public void unregisterAudioPlaybackObserver(IAudioPlaybackEventDispatcher observer) {
        if (this.mAudioServiceExts == null) goto L8;
        Iterator<AudioServiceExt> r0 = this.mAudioServiceExts.iterator();
    L6:
        if (r0.hasNext() == false) goto L10;
        AudioServiceExt ext = r0.next();
        ext.unregisterAudioPlaybackObserver(observer);
        goto L6
    L10:
        return;
    }

    public void registerAudioPlaybackPendingIntent(PendingIntent pendingIntent, AudioPlaybackFilter filter) {
        if (this.mAudioServiceExts == null) goto L8;
        Iterator<AudioServiceExt> r0 = this.mAudioServiceExts.iterator();
    L6:
        if (r0.hasNext() == false) goto L10;
        AudioServiceExt ext = r0.next();
        ext.registerAudioPlaybackPendingIntent(pendingIntent, filter);
        goto L6
    L10:
        return;
    }

    public void unregisterAudioPlaybackPendingIntent(PendingIntent pendingIntent) {
        if (this.mAudioServiceExts == null) goto L8;
        Iterator<AudioServiceExt> r0 = this.mAudioServiceExts.iterator();
    L6:
        if (r0.hasNext() == false) goto L10;
        AudioServiceExt ext = r0.next();
        ext.unregisterAudioPlaybackPendingIntent(pendingIntent);
        goto L6
    L10:
        return;
    }

    public List<AudioPlaybackConfiguration> queryAudioPlaybackConfigurations(AudioPlaybackFilter filter) {
        if (this.mAudioServiceExts == null) goto L14;
        Iterator<AudioServiceExt> r0 = this.mAudioServiceExts.iterator();
    L6:
        if (r0.hasNext() == false) goto L14;
        AudioServiceExt ext = r0.next();
        List<AudioPlaybackConfiguration> configs = ext.queryAudioPlaybackConfigurations(filter);
        if (configs == null) goto L6;
        if (configs.isEmpty() == true) goto L6;
        return configs;
    L14:
        return new ArrayList();
    }

    public void registerAudioRecordingObserver(IAudioRecordingEventDispatcher observer, AudioRecordingFilter filter) {
        if (this.mAudioServiceExts == null) goto L8;
        Iterator<AudioServiceExt> r0 = this.mAudioServiceExts.iterator();
    L6:
        if (r0.hasNext() == false) goto L10;
        AudioServiceExt ext = r0.next();
        ext.registerAudioRecordingObserver(observer, filter);
        goto L6
    L10:
        return;
    }

    public void unregisterAudioRecordingObserver(IAudioRecordingEventDispatcher observer) {
        if (this.mAudioServiceExts == null) goto L8;
        Iterator<AudioServiceExt> r0 = this.mAudioServiceExts.iterator();
    L6:
        if (r0.hasNext() == false) goto L10;
        AudioServiceExt ext = r0.next();
        ext.unregisterAudioRecordingObserver(observer);
        goto L6
    L10:
        return;
    }

    public void registerAudioRecordingPendingIntent(PendingIntent pendingIntent, AudioRecordingFilter filter) {
        if (this.mAudioServiceExts == null) goto L8;
        Iterator<AudioServiceExt> r0 = this.mAudioServiceExts.iterator();
    L6:
        if (r0.hasNext() == false) goto L10;
        AudioServiceExt ext = r0.next();
        ext.registerAudioRecordingPendingIntent(pendingIntent, filter);
        goto L6
    L10:
        return;
    }

    public void unregisterAudioRecordingPendingIntent(PendingIntent pendingIntent) {
        if (this.mAudioServiceExts == null) goto L8;
        Iterator<AudioServiceExt> r0 = this.mAudioServiceExts.iterator();
    L6:
        if (r0.hasNext() == false) goto L10;
        AudioServiceExt ext = r0.next();
        ext.unregisterAudioRecordingPendingIntent(pendingIntent);
        goto L6
    L10:
        return;
    }

    public List<AudioRecordingConfiguration> queryAudioRecordingConfigurations(AudioRecordingFilter filter) {
        if (this.mAudioServiceExts == null) goto L14;
        Iterator<AudioServiceExt> r0 = this.mAudioServiceExts.iterator();
    L6:
        if (r0.hasNext() == false) goto L14;
        AudioServiceExt ext = r0.next();
        List<AudioRecordingConfiguration> configs = ext.queryAudioRecordingConfigurations(filter);
        if (configs == null) goto L6;
        if (configs.isEmpty() == true) goto L6;
        return configs;
    L14:
        return new ArrayList();
    }

    public void AudioService_onStart() {
        if (this.mAudioServiceExts == null) goto L8;
        Iterator<AudioServiceExt> r0 = this.mAudioServiceExts.iterator();
    L6:
        if (r0.hasNext() == false) goto L10;
        AudioServiceExt ext = r0.next();
        ext.AudioService_onStart();
        goto L6
    L10:
        return;
    }

    public void AudioService_onSystemReady() {
        if (this.mAudioServiceExts == null) goto L8;
        Iterator<AudioServiceExt> r0 = this.mAudioServiceExts.iterator();
    L6:
        if (r0.hasNext() == false) goto L10;
        AudioServiceExt ext = r0.next();
        ext.AudioService_onSystemReady();
        goto L6
    L10:
        return;
    }

    private void addIntArrayIntoList(ArrayList<Integer> list, int[] array) {
        int r0 = array.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        int i = array[r1];
        list.add(Integer.valueOf(i));
        r1 = r1 + 1;
        goto L3
    }

    public int[] AudioService_getStreams(int[] defaultStreams) {
        if (this.mAudioServiceExts != null) goto L5;
        return defaultStreams;
    L5:
        ArrayList<Integer> newStreams = new ArrayList();
        addIntArrayIntoList(newStreams, defaultStreams);
        Iterator<AudioServiceExt> r1 = this.mAudioServiceExts.iterator();
    L7:
        if (r1.hasNext() == false) goto L13;
        AudioServiceExt ext = r1.next();
        int[] streams = ext.AudioService_getExtraStreams();
        if (streams == null) goto L7;
        addIntArrayIntoList(newStreams, streams);
        goto L7
    L13:
        return newStreams.stream().mapToInt(new AudioServiceExtProxy$$ExternalSyntheticLambda2()).toArray();
    }

    private static /* synthetic */ int lambda$AudioService_getStreams$0(Integer i) {
        return i.intValue();
    }

    public int[] AudioService_getStepsResId(int[] defaultStepsResId) {
        if (this.mAudioServiceExts != null) goto L5;
        return defaultStepsResId;
    L5:
        ArrayList<Integer> newStepsResId = new ArrayList();
        addIntArrayIntoList(newStepsResId, defaultStepsResId);
        Iterator<AudioServiceExt> r1 = this.mAudioServiceExts.iterator();
    L7:
        if (r1.hasNext() == false) goto L13;
        AudioServiceExt ext = r1.next();
        int[] stepsResId = ext.AudioService_getExtraStepsResId();
        if (stepsResId == null) goto L7;
        addIntArrayIntoList(newStepsResId, stepsResId);
        goto L7
    L13:
        return newStepsResId.stream().mapToInt(new AudioServiceExtProxy$$ExternalSyntheticLambda1()).toArray();
    }

    private static /* synthetic */ int lambda$AudioService_getStepsResId$1(Integer i) {
        return i.intValue();
    }

    public int[] AudioService_getDefaultResId(int[] defaultResId) {
        if (this.mAudioServiceExts != null) goto L5;
        return defaultResId;
    L5:
        ArrayList<Integer> newResId = new ArrayList();
        addIntArrayIntoList(newResId, defaultResId);
        Iterator<AudioServiceExt> r1 = this.mAudioServiceExts.iterator();
    L7:
        if (r1.hasNext() == false) goto L13;
        AudioServiceExt ext = r1.next();
        int[] resId = ext.AudioService_getExtraResId();
        if (resId == null) goto L7;
        addIntArrayIntoList(newResId, resId);
        goto L7
    L13:
        return newResId.stream().mapToInt(new AudioServiceExtProxy$$ExternalSyntheticLambda0()).toArray();
    }

    private static /* synthetic */ int lambda$AudioService_getDefaultResId$2(Integer i) {
        return i.intValue();
    }

    public int AudioService_getMinVolume(int streamType, int defaultMinVol) {
        if (this.mAudioServiceExts == null) goto L12;
        Iterator<AudioServiceExt> r0 = this.mAudioServiceExts.iterator();
    L6:
        if (r0.hasNext() == false) goto L12;
        AudioServiceExt ext = r0.next();
        Optional<Integer> minVol = ext.AudioService_getMinVolume(streamType);
        if (minVol.isPresent() == false) goto L6;
        return minVol.get().intValue();
    L12:
        return defaultMinVol;
    }

    public void initReflectionValues() {
        if (this.mAudioServiceExts == null) goto L8;
        Iterator<AudioServiceExt> r0 = this.mAudioServiceExts.iterator();
    L6:
        if (r0.hasNext() == false) goto L10;
        AudioServiceExt ext = r0.next();
        ext.initReflectionValues();
        goto L6
    L10:
        return;
    }

    public boolean suppressAdjustment_onBegin_earlyReturn(int resolvedStream, int flags, boolean isMute) {
        if (this.mAudioServiceExts == null) goto L12;
        Iterator<AudioServiceExt> r0 = this.mAudioServiceExts.iterator();
    L6:
        if (r0.hasNext() == false) goto L17;
        AudioServiceExt ext = r0.next();
        if (ext.suppressAdjustment_onBegin_earlyReturn(resolvedStream, flags, isMute) == false) goto L6;
        return true;
    L17:
        return false;
    L12:
        return false;
    }

    public void AudioService_beforeUpdateStreamVolumeAlias() {
        if (this.mAudioServiceExts == null) goto L8;
        Iterator<AudioServiceExt> r0 = this.mAudioServiceExts.iterator();
    L6:
        if (r0.hasNext() == false) goto L10;
        AudioServiceExt ext = r0.next();
        ext.AudioService_beforeUpdateStreamVolumeAlias();
        goto L6
    L10:
        return;
    }

    public boolean setStreamVolume_afterCheckingVolumeAdjustmentAllowedByDnd_earlyReturn(int streamType, int index, int flags, AudioDeviceAttributes ada, String callingPackage, String caller, String attributionTag, int uid, boolean canChangeMuteAndUpdateController, int streamTypeAlias) {
        if (this.mAudioServiceExts == null) goto L12;
        Iterator<AudioServiceExt> r0 = this.mAudioServiceExts.iterator();
    L6:
        if (r0.hasNext() == false) goto L17;
        AudioServiceExt ext = r0.next();
        if (ext.setStreamVolume_afterCheckingVolumeAdjustmentAllowedByDnd_earlyReturn(streamType, index, flags, ada, callingPackage, caller, attributionTag, uid, canChangeMuteAndUpdateController, streamTypeAlias) == false) goto L6;
        return true;
    L17:
        return false;
    L12:
        return false;
    }

    public boolean muteRingerModeStreams_shouldStreamNotBeZero(SparseIntArray sStreamVolumeAlias, int streamType) {
        if (sStreamVolumeAlias.get(streamType, -1) != 2) goto L5;
    L8:
        boolean defaultMute = true;
    L10:
        if (this.mAudioServiceExts == null) goto L18;
        Iterator<AudioServiceExt> r1 = this.mAudioServiceExts.iterator();
    L13:
        if (r1.hasNext() == false) goto L18;
        AudioServiceExt ext = r1.next();
        if (ext.muteRingerModeStreams_shouldStreamNotBeZero(sStreamVolumeAlias, streamType) == false) goto L13;
        return true;
    L18:
        return defaultMute;
    L5:
        if (sStreamVolumeAlias.get(streamType, -1) == 5) goto L8;
        defaultMute = false;
        goto L10
    }

    public void onPlaybackConfigChange_onEnd(List<AudioPlaybackConfiguration> configs) {
        if (this.mAudioServiceExts == null) goto L8;
        Iterator<AudioServiceExt> r0 = this.mAudioServiceExts.iterator();
    L6:
        if (r0.hasNext() == false) goto L10;
        AudioServiceExt ext = r0.next();
        ext.onPlaybackConfigChange_onEnd(configs);
        goto L6
    L10:
        return;
    }

    public void onRecordingConfigChange_onEnd(List<AudioRecordingConfiguration> configs) {
        if (this.mAudioServiceExts == null) goto L8;
        Iterator<AudioServiceExt> r0 = this.mAudioServiceExts.iterator();
    L6:
        if (r0.hasNext() == false) goto L10;
        AudioServiceExt ext = r0.next();
        ext.onRecordingConfigChange_onEnd(configs);
        goto L6
    L10:
        return;
    }

    public Optional<Integer> getActiveStreamType_onPlatformVoice_afterUseRingStreamType(int sStreamOverrideDelayMs) {
        Optional<Integer> defaultStreamType = Optional.empty();
        if (this.mBase.wasStreamActiveRecently(5, sStreamOverrideDelayMs) == false) goto L6;
        Log.v(TAG, "getActiveStreamType: Forcing STREAM_NOTIFICATION stream active");
        defaultStreamType = Optional.of(5);
    L6:
        if (this.mAudioServiceExts == null) goto L14;
        Iterator<AudioServiceExt> r1 = this.mAudioServiceExts.iterator();
    L9:
        if (r1.hasNext() == false) goto L14;
        AudioServiceExt ext = r1.next();
        Optional<Integer> streamType = ext.getActiveStreamType_onPlatformVoice_afterUseRingStreamType(sStreamOverrideDelayMs);
        if (streamType.isPresent() == false) goto L9;
        return streamType;
    L14:
        return defaultStreamType;
    }

    public Optional<Integer> getActiveStreamType_onPlatformVoice_useOtherStreamType_onStart(int sStreamOverrideDelayMs) {
        if (this.mAudioServiceExts == null) goto L12;
        Iterator<AudioServiceExt> r0 = this.mAudioServiceExts.iterator();
    L6:
        if (r0.hasNext() == false) goto L12;
        AudioServiceExt ext = r0.next();
        Optional<Integer> streamType = ext.getActiveStreamType_onPlatformVoice_useOtherStreamType_onStart(sStreamOverrideDelayMs);
        if (streamType.isPresent() == false) goto L6;
        return streamType;
    L12:
        return Optional.empty();
    }

    public Optional<Integer> getActiveStreamType_onPlatformVoice_beforeUseDefaultStreamType(int sStreamOverrideDelayMs) {
        if (this.mAudioServiceExts == null) goto L12;
        Iterator<AudioServiceExt> r0 = this.mAudioServiceExts.iterator();
    L6:
        if (r0.hasNext() == false) goto L12;
        AudioServiceExt ext = r0.next();
        Optional<Integer> streamType = ext.getActiveStreamType_onPlatformVoice_beforeUseDefaultStreamType(sStreamOverrideDelayMs);
        if (streamType.isPresent() == false) goto L6;
        return streamType;
    L12:
        return Optional.empty();
    }

    public Optional<Integer> getActiveStreamType_onDefault_useDefeaultStreamType_afterCall(int sStreamOverrideDelayMs) {
        if (this.mAudioServiceExts == null) goto L12;
        Iterator<AudioServiceExt> r0 = this.mAudioServiceExts.iterator();
    L6:
        if (r0.hasNext() == false) goto L12;
        AudioServiceExt ext = r0.next();
        Optional<Integer> streamType = ext.getActiveStreamType_onDefault_useDefeaultStreamType_afterCall(sStreamOverrideDelayMs);
        if (streamType.isPresent() == false) goto L6;
        return streamType;
    L12:
        return Optional.empty();
    }

    public Optional<Integer> getActiveStreamType_onDefault_useDefeaultStreamType_onEnd(int sStreamOverrideDelayMs) {
        if (this.mAudioServiceExts == null) goto L12;
        Iterator<AudioServiceExt> r0 = this.mAudioServiceExts.iterator();
    L6:
        if (r0.hasNext() == false) goto L12;
        AudioServiceExt ext = r0.next();
        Optional<Integer> streamType = ext.getActiveStreamType_onDefault_useDefeaultStreamType_onEnd(sStreamOverrideDelayMs);
        if (streamType.isPresent() == false) goto L6;
        return streamType;
    L12:
        return Optional.empty();
    }

    public void SettingsObserver_onEnd(ContentObserver observer) {
        if (this.mAudioServiceExts == null) goto L8;
        Iterator<AudioServiceExt> r0 = this.mAudioServiceExts.iterator();
    L6:
        if (r0.hasNext() == false) goto L10;
        AudioServiceExt ext = r0.next();
        ext.SettingsObserver_onEnd(observer);
        goto L6
    L10:
        return;
    }

    public boolean SettingsObserver_onChange_onBegin_earlyReturn(boolean selfChange, Uri uri) {
        if (this.mAudioServiceExts == null) goto L12;
        Iterator<AudioServiceExt> r0 = this.mAudioServiceExts.iterator();
    L6:
        if (r0.hasNext() == false) goto L17;
        AudioServiceExt ext = r0.next();
        if (ext.SettingsObserver_onChange_onBegin_earlyReturn(selfChange, uri) == false) goto L6;
        return true;
    L17:
        return false;
    L12:
        return false;
    }

    public int getControlStreamType_onEnd() {
        if (this.mAudioServiceExts == null) goto L11;
        Iterator<AudioServiceExt> r0 = this.mAudioServiceExts.iterator();
    L6:
        if (r0.hasNext() == false) goto L11;
        AudioServiceExt ext = r0.next();
        int streamType = ext.getControlStreamType_onEnd();
        if (streamType == (-1)) goto L6;
        return streamType;
    L11:
        return -1;
    }

    public void onControlStreamInputsChanged(String reason) {
        if (this.mAudioServiceExts == null) goto L8;
        Iterator<AudioServiceExt> r0 = this.mAudioServiceExts.iterator();
    L6:
        if (r0.hasNext() == false) goto L10;
        AudioServiceExt ext = r0.next();
        ext.onControlStreamInputsChanged(reason);
        goto L6
    L10:
        return;
    }

    public boolean registerControlStreamCallback_onEnd(IControlStreamDispatcher csd) {
        if (this.mAudioServiceExts == null) goto L12;
        Iterator<AudioServiceExt> r0 = this.mAudioServiceExts.iterator();
    L6:
        if (r0.hasNext() == false) goto L17;
        AudioServiceExt ext = r0.next();
        if (ext.registerControlStreamCallback_onEnd(csd) == false) goto L6;
        return true;
    L17:
        return false;
    L12:
        return false;
    }

    public boolean unregisterControlStreamCallback_onEnd(IControlStreamDispatcher csd) {
        if (this.mAudioServiceExts == null) goto L12;
        Iterator<AudioServiceExt> r0 = this.mAudioServiceExts.iterator();
    L6:
        if (r0.hasNext() == false) goto L17;
        AudioServiceExt ext = r0.next();
        if (ext.unregisterControlStreamCallback_onEnd(csd) == false) goto L6;
        return true;
    L17:
        return false;
    L12:
        return false;
    }

    public void queueOnBluetoothActiveDeviceChanged_onBefore(AudioDeviceBroker.BtDeviceChangedData data) {
        if (this.mAudioServiceExts == null) goto L8;
        Iterator<AudioServiceExt> r0 = this.mAudioServiceExts.iterator();
    L6:
        if (r0.hasNext() == false) goto L10;
        AudioServiceExt ext = r0.next();
        ext.queueOnBluetoothActiveDeviceChanged_onBefore(data);
        goto L6
    L10:
        return;
    }

    public int handleBluetoothActiveDeviceChanged_getDelayMs(BluetoothDevice newDevice, BluetoothDevice previousDevice, BluetoothProfileConnectionInfo info) {
        if (this.mAudioServiceExts == null) goto L11;
        Iterator<AudioServiceExt> r0 = this.mAudioServiceExts.iterator();
    L6:
        if (r0.hasNext() == false) goto L16;
        AudioServiceExt ext = r0.next();
        int delayMs = ext.handleBluetoothActiveDeviceChanged_getDelayMs(newDevice, previousDevice, info);
        if (delayMs == 0) goto L6;
        return delayMs;
    L16:
        return 0;
    L11:
        return 0;
    }

    public int setStreamVolumeIndex_capIndex(int streamType, int index, boolean muted, int device) {
        if (this.mAudioServiceExts == null) goto L11;
        Iterator<AudioServiceExt> r0 = this.mAudioServiceExts.iterator();
    L6:
        if (r0.hasNext() == false) goto L11;
        AudioServiceExt ext = r0.next();
        int cappedIndex = ext.setStreamVolumeIndex_capIndex(streamType, index, muted, device);
        if (cappedIndex == index) goto L6;
        return cappedIndex;
    L11:
        return index;
    }

    public String getMediaMetricsValueByDirection(int direction) {
        if (this.mAudioServiceExts == null) goto L11;
        Iterator<AudioServiceExt> r0 = this.mAudioServiceExts.iterator();
    L6:
        if (r0.hasNext() == false) goto L16;
        AudioServiceExt ext = r0.next();
        String value = ext.getMediaMetricsValueByDirection(direction);
        if (value == null) goto L6;
        return value;
    L16:
        return "UNKNOWN";
    L11:
        return "UNKNOWN";
    }

    public void setAbsoluteVolumeForDevice(int streamType, int index, int device) {
        if (this.mAudioServiceExts == null) goto L8;
        Iterator<AudioServiceExt> r0 = this.mAudioServiceExts.iterator();
    L6:
        if (r0.hasNext() == false) goto L10;
        AudioServiceExt ext = r0.next();
        ext.setAbsoluteVolumeForDevice(streamType, index, device);
        goto L6
    L10:
        return;
    }

    public int setStreamVolume_rewriteStreamType(int streamType, int device, String callingPackage) {
        if (this.mAudioServiceExts == null) goto L11;
        Iterator<AudioServiceExt> r0 = this.mAudioServiceExts.iterator();
    L6:
        if (r0.hasNext() == false) goto L11;
        AudioServiceExt ext = r0.next();
        int rewritten = ext.setStreamVolume_rewriteStreamType(streamType, device, callingPackage);
        if (rewritten == streamType) goto L6;
        return rewritten;
    L11:
        return streamType;
    }

    public void setIndex_onEnd(int streamType, int index, int device, String caller) {
        if (this.mAudioServiceExts == null) goto L8;
        Iterator<AudioServiceExt> r0 = this.mAudioServiceExts.iterator();
    L6:
        if (r0.hasNext() == false) goto L10;
        AudioServiceExt ext = r0.next();
        ext.setIndex_onEnd(streamType, index, device, caller);
        goto L6
    L10:
        return;
    }

    public void setScoVolume() {
        if (this.mAudioServiceExts == null) goto L8;
        Iterator<AudioServiceExt> r0 = this.mAudioServiceExts.iterator();
    L6:
        if (r0.hasNext() == false) goto L10;
        AudioServiceExt ext = r0.next();
        ext.setScoVolume();
        goto L6
    L10:
        return;
    }

    public void setAssistantFdxActive(boolean active) {
        if (this.mAudioServiceExts == null) goto L8;
        Iterator<AudioServiceExt> r0 = this.mAudioServiceExts.iterator();
    L6:
        if (r0.hasNext() == false) goto L10;
        AudioServiceExt ext = r0.next();
        ext.setAssistantFdxActive(active);
        goto L6
    L10:
        return;
    }

    public void onUpdateAudioMode_afterSetMode(int mode, int pid, int uid, AtomicInteger modeOwnerInDeviceBroker, int requesterPid, String requesterPackage, int requestedMode, EventLogger modeLogger) {
        if (this.mAudioServiceExts == null) goto L8;
        Iterator<AudioServiceExt> r0 = this.mAudioServiceExts.iterator();
    L6:
        if (r0.hasNext() == false) goto L10;
        AudioServiceExt ext = r0.next();
        ext.onUpdateAudioMode_afterSetMode(mode, pid, uid, modeOwnerInDeviceBroker, requesterPid, requesterPackage, requestedMode, modeLogger);
        goto L6
    L10:
        return;
    }
}
