package com.android.server.audio;

import android.app.PendingIntent;
import android.bluetooth.BluetoothDevice;
import android.content.ContentResolver;
import android.content.Context;
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
import android.media.IControlStreamDispatcher;
import android.net.Uri;
import android.os.Binder;
import android.os.Handler;
import android.os.Vibrator;
import android.prometheus.ext.core.ExtLoader;
import android.prometheus.ext.core.ReflectionUtils;
import android.util.Log;
import android.util.SparseIntArray;
import com.android.server.utils.EventLogger;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public class AudioServiceExt {
    private static final String TAG = "AS.AudioServiceExt";
    protected Handler mAudioHandler;
    protected AudioSystemAdapter mAudioSystem;
    protected final AudioService mBase;
    protected ContentResolver mContentResolver;
    protected Context mContext;
    protected ControlStreamHelper mControlStreamHelper;
    protected MediaFocusControlExt mFocusControlExt;
    protected Object mForceControlStreamLock;
    protected MediaFocusControl mMediaFocusControl;
    protected final ReflectionUtils mReflectionUtils;

    public static AudioServiceExt get(AudioService base) {
        return (AudioServiceExt) ExtLoader.get(AudioServiceExt.class, base);
    }

    public AudioServiceExt(AudioService base) {
        this.mBase = base;
        this.mReflectionUtils = new ReflectionUtils(this.mBase);
    }

    public AudioServiceExt(Object base) {
        this((AudioService) base);
    }

    public synchronized void initReflectionValues() {
        monitor-enter(this);
        this.mAudioSystem = (AudioSystemAdapter) this.mReflectionUtils.getFieldValue("mAudioSystem");     // Catch: Throwable -> L7
        this.mForceControlStreamLock = this.mReflectionUtils.getFieldValue("mForceControlStreamLock");     // Catch: Throwable -> L7
        this.mContentResolver = (ContentResolver) this.mReflectionUtils.getFieldValue("mContentResolver");     // Catch: Throwable -> L7
        this.mContext = (Context) this.mReflectionUtils.getFieldValue("mContext");     // Catch: Throwable -> L7
        this.mAudioHandler = (Handler) this.mReflectionUtils.getFieldValue("mAudioHandler");     // Catch: Throwable -> L7
        this.mMediaFocusControl = (MediaFocusControl) this.mReflectionUtils.getFieldValue("mMediaFocusControl");     // Catch: Throwable -> L7
        if (this.mMediaFocusControl == null) goto L9;
        ReflectionUtils mfcReflectionUtils = new ReflectionUtils(this.mMediaFocusControl);     // Catch: Throwable -> L7
        this.mFocusControlExt = (MediaFocusControlExt) mfcReflectionUtils.getFieldValue("mFocusControlExt");     // Catch: Throwable -> L7
    L9:
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    protected synchronized boolean getUserSelectedVolumeControlStream() {
        monitor-enter(this);
        boolean r0 = ((Boolean) this.mReflectionUtils.getFieldValue("mUserSelectedVolumeControlStream")).booleanValue();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    protected synchronized int getVolumeControlStream() {
        monitor-enter(this);
        int r0 = ((Integer) this.mReflectionUtils.getFieldValue("mVolumeControlStream")).intValue();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    protected synchronized Vibrator getVibrator() {
        monitor-enter(this);
        Vibrator r0 = (Vibrator) this.mReflectionUtils.getFieldValue("mVibrator");     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    protected synchronized boolean wasStreamActiveRecently(int stream, int delay_ms) {
        monitor-enter(this);
        boolean r0 = ((Boolean) this.mReflectionUtils.invokeMethodWithCache("wasStreamActiveRecently", new Class[]{Integer.TYPE, Integer.TYPE}, new Object[]{Integer.valueOf(stream), Integer.valueOf(delay_ms)})).booleanValue();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    protected synchronized int getActiveStreamType(int suggestedStreamType) {
        monitor-enter(this);
        int r0 = ((Integer) this.mReflectionUtils.invokeMethodWithCache("getActiveStreamType", new Class[]{Integer.TYPE}, new Object[]{Integer.valueOf(suggestedStreamType)})).intValue();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    protected synchronized boolean isStreamMutedByRingerOrZenMode(int stream) {
        monitor-enter(this);
        boolean r0 = ((Boolean) this.mReflectionUtils.invokeMethodWithCache("isStreamMutedByRingerOrZenMode", new Class[]{Integer.TYPE}, new Object[]{Integer.valueOf(stream)})).booleanValue();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    protected synchronized boolean isA2dpAbsoluteVolumeDevice(int deviceType) {
        monitor-enter(this);
        boolean r0 = ((Boolean) this.mReflectionUtils.invokeMethodWithCache("isA2dpAbsoluteVolumeDevice", new Class[]{Integer.TYPE}, new Object[]{Integer.valueOf(deviceType)})).booleanValue();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    protected synchronized void setRingerMode(int ringerMode, String tag, boolean force) {
        monitor-enter(this);
        this.mReflectionUtils.invokeMethodWithCache("setRingerMode", new Class[]{Integer.TYPE, String.class, Boolean.TYPE}, new Object[]{Integer.valueOf(ringerMode), tag, Boolean.valueOf(force)});     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public void AudioService_onStart() {
    }

    public void AudioService_onSystemReady() {
    }

    public int[] AudioService_getExtraStreams() {
        return null;
    }

    public int[] AudioService_getExtraStepsResId() {
        return null;
    }

    public int[] AudioService_getExtraResId() {
        return null;
    }

    public Optional<Integer> AudioService_getMinVolume(int streamType) {
        return Optional.empty();
    }

    public boolean suppressAdjustment_onBegin_earlyReturn(int resolvedStream, int flags, boolean isMute) {
        return false;
    }

    public void AudioService_beforeUpdateStreamVolumeAlias() {
    }

    public boolean setStreamVolume_afterCheckingVolumeAdjustmentAllowedByDnd_earlyReturn(int streamType, int index, int flags, AudioDeviceAttributes ada, String callingPackage, String caller, String attributionTag, int uid, boolean canChangeMuteAndUpdateController, int streamTypeAlias) {
        return false;
    }

    public boolean muteRingerModeStreams_shouldStreamNotBeZero(SparseIntArray sStreamVolumeAlias, int streamType) {
        if (sStreamVolumeAlias.get(streamType, -1) != 2) goto L5;
    L8:
        return true;
    L5:
        if (sStreamVolumeAlias.get(streamType, -1) == 5) goto L8;
        return false;
    }

    public void onPlaybackConfigChange_onEnd(List<AudioPlaybackConfiguration> configs) {
    }

    public void onRecordingConfigChange_onEnd(List<AudioRecordingConfiguration> configs) {
    }

    public Optional<Integer> getActiveStreamType_onPlatformVoice_afterUseRingStreamType(int sStreamOverrideDelayMs) {
        if (wasStreamActiveRecently(5, sStreamOverrideDelayMs) == false) goto L7;
        Log.v(TAG, "getActiveStreamType: Forcing STREAM_NOTIFICATION stream active");
        return Optional.of(5);
    L7:
        return Optional.empty();
    }

    public Optional<Integer> getActiveStreamType_onPlatformVoice_useOtherStreamType_onStart(int sStreamOverrideDelayMs) {
        return Optional.empty();
    }

    public Optional<Integer> getActiveStreamType_onPlatformVoice_beforeUseDefaultStreamType(int sStreamOverrideDelayMs) {
        return Optional.empty();
    }

    public Optional<Integer> getActiveStreamType_onDefault_useDefeaultStreamType_afterCall(int sStreamOverrideDelayMs) {
        return Optional.empty();
    }

    public Optional<Integer> getActiveStreamType_onDefault_useDefeaultStreamType_onEnd(int sStreamOverrideDelayMs) {
        return Optional.empty();
    }

    public void SettingsObserver_onEnd(ContentObserver observer) {
    }

    public boolean SettingsObserver_onChange_onBegin_earlyReturn(boolean selfChange, Uri uri) {
        return false;
    }

    public int getControlStreamType_onEnd() {
        return -1;
    }

    public void onControlStreamInputsChanged(String reason) {
        if (this.mControlStreamHelper == null) goto L6;
        this.mControlStreamHelper.onControlStreamInputsChanged(reason);
        return;
    }

    public boolean registerControlStreamCallback_onEnd(IControlStreamDispatcher csd) {
        if (checkModifyAudioRoutingPermission("registerControlStreamCallback") == true) goto L6;
        return false;
    L6:
        if (this.mControlStreamHelper != null) goto L8;
        return false;
    L8:
        return this.mControlStreamHelper.registerControlStreamCallback(csd);
    }

    public boolean unregisterControlStreamCallback_onEnd(IControlStreamDispatcher csd) {
        if (checkModifyAudioRoutingPermission("unregisterControlStreamCallback") == true) goto L6;
        return false;
    L6:
        if (this.mControlStreamHelper != null) goto L8;
        return false;
    L8:
        return this.mControlStreamHelper.unregisterControlStreamCallback(csd);
    }

    public FocusOwnerInfo getCurrentAudioFocusOwner() {
        return null;
    }

    public void registerAudioPlaybackObserver(IAudioPlaybackEventDispatcher observer, AudioPlaybackFilter filter) {
    }

    public void unregisterAudioPlaybackObserver(IAudioPlaybackEventDispatcher observer) {
    }

    public void registerAudioPlaybackPendingIntent(PendingIntent pendingIntent, AudioPlaybackFilter filter) {
    }

    public void unregisterAudioPlaybackPendingIntent(PendingIntent pendingIntent) {
    }

    public List<AudioPlaybackConfiguration> queryAudioPlaybackConfigurations(AudioPlaybackFilter filter) {
        return Collections.emptyList();
    }

    public void registerAudioRecordingObserver(IAudioRecordingEventDispatcher observer, AudioRecordingFilter filter) {
    }

    public void unregisterAudioRecordingObserver(IAudioRecordingEventDispatcher observer) {
    }

    public void registerAudioRecordingPendingIntent(PendingIntent pendingIntent, AudioRecordingFilter filter) {
    }

    public void unregisterAudioRecordingPendingIntent(PendingIntent pendingIntent) {
    }

    public List<AudioRecordingConfiguration> queryAudioRecordingConfigurations(AudioRecordingFilter filter) {
        return Collections.emptyList();
    }

    protected boolean checkModifyAudioRoutingPermission(String methodName) {
        int pid = Binder.getCallingPid();
        int uid = Binder.getCallingUid();
        if (this.mContext != null) goto L5;
    L9:
        Log.w(TAG, "MODIFY_AUDIO_ROUTING Permission Denial: " + methodName + " from pid=" + pid + ", uid=" + uid);
        return false;
    L5:
        if (this.mContext.checkPermission("android.permission.MODIFY_AUDIO_ROUTING", pid, uid) != 0) goto L9;
        return true;
    }

    protected void enforceModifyAudioRoutingPermission(String methodName) {
        if (checkModifyAudioRoutingPermission(methodName) == false) goto L6;
        return;
    L6:
        throw new SecurityException("MODIFY_AUDIO_ROUTING permission denied for " + methodName);
    }

    public void queueOnBluetoothActiveDeviceChanged_onBefore(AudioDeviceBroker.BtDeviceChangedData data) {
    }

    public int handleBluetoothActiveDeviceChanged_getDelayMs(BluetoothDevice newDevice, BluetoothDevice previousDevice, BluetoothProfileConnectionInfo info) {
        return 0;
    }

    public String getMediaMetricsValueByDirection(int direction) {
        return null;
    }

    public void setAbsoluteVolumeForDevice(int streamType, int index, int device) {
    }

    public int setStreamVolume_rewriteStreamType(int streamType, int device, String callingPackage) {
        return streamType;
    }

    public void setIndex_onEnd(int streamType, int index, int device, String caller) {
    }

    public void setAssistantFdxActive(boolean active) {
    }

    public int setStreamVolumeIndex_capIndex(int streamType, int index, boolean muted, int device) {
        return index;
    }

    public void setScoVolume() {
    }

    public void onUpdateAudioMode_afterSetMode(int mode, int pid, int uid, AtomicInteger modeOwnerInDeviceBroker, int requesterPid, String requesterPackage, int requestedMode, EventLogger modeLogger) {
    }
}
