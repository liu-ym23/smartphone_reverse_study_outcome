package com.android.server.companion.virtual.audio;

import android.companion.virtual.audio.IAudioConfigChangedCallback;
import android.companion.virtual.audio.IAudioRoutingCallback;
import android.content.AttributionSource;
import android.content.Context;
import android.media.AudioManager;
import android.media.AudioPlaybackConfiguration;
import android.media.AudioRecordingConfiguration;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import android.util.ArraySet;
import android.util.Slog;
import com.android.modules.expresslog.Counter;
import com.android.server.ISmtResourceControl;
import com.android.server.companion.virtual.GenericWindowPolicyController;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class VirtualAudioController implements AudioPlaybackDetector.AudioPlaybackCallback, AudioRecordingDetector.AudioRecordingCallback, GenericWindowPolicyController.RunningAppsChangedListener {
    private static final String TAG = "VirtualAudioController";
    private static final int UPDATE_REROUTING_APPS_DELAY_MS = 2000;
    private final AudioPlaybackDetector mAudioPlaybackDetector;
    private final AudioRecordingDetector mAudioRecordingDetector;
    private final Object mCallbackLock;
    private IAudioConfigChangedCallback mConfigChangedCallback;
    private final Context mContext;
    private GenericWindowPolicyController mGenericWindowPolicyController;
    private final Handler mHandler;
    private final Object mLock;
    private ArraySet<Integer> mPlayingAppUids;
    private IAudioRoutingCallback mRoutingCallback;
    private final ArraySet<Integer> mRunningAppUids;
    private final Runnable mUpdateAudioRoutingRunnable;

    /* JADX INFO: renamed from: $r8$lambda$2renwhGRq9_GYv6w8-uObz8LLcc, reason: not valid java name */
    public static /* synthetic */ void m3034$r8$lambda$2renwhGRq9_GYv6w8uObz8LLcc(VirtualAudioController r0) {
        r0.notifyAppsNeedingAudioRoutingChanged();
    }

    public VirtualAudioController(Context context, AttributionSource attributionSource) {
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mUpdateAudioRoutingRunnable = new VirtualAudioController$$ExternalSyntheticLambda0(this);
        this.mLock = new Object();
        this.mRunningAppUids = new ArraySet();
        this.mPlayingAppUids = new ArraySet();
        this.mCallbackLock = new Object();
        this.mContext = context;
        this.mAudioPlaybackDetector = new AudioPlaybackDetector(context);
        this.mAudioRecordingDetector = new AudioRecordingDetector(context);
        Counter.logIncrementWithUid("virtual_devices.value_virtual_audio_created_count", attributionSource.getUid());
    }

    public void startListening(GenericWindowPolicyController genericWindowPolicyController, IAudioRoutingCallback routingCallback, IAudioConfigChangedCallback configChangedCallback) {
        this.mGenericWindowPolicyController = genericWindowPolicyController;
        this.mGenericWindowPolicyController.registerRunningAppsChangedListener(this);
        Object r0 = this.mCallbackLock;
        monitor-enter(r0);
        this.mRoutingCallback = routingCallback;     // Catch: Throwable -> L16
        this.mConfigChangedCallback = configChangedCallback;     // Catch: Throwable -> L16
        monitor-exit(r0);     // Catch: Throwable -> L16
        Object r1 = this.mLock;
        monitor-enter(r1);
        this.mRunningAppUids.clear();     // Catch: Throwable -> L13
        this.mPlayingAppUids.clear();     // Catch: Throwable -> L13
        monitor-exit(r1);     // Catch: Throwable -> L13
        if (configChangedCallback == null) goto L23;
        this.mAudioPlaybackDetector.register(this);
        this.mAudioRecordingDetector.register(this);
        return;
    L23:
        return;
    L13:
        th = move-exception;
        throw th;
    L16:
        th = move-exception;
        throw th;
    }

    public void stopListening() {
        if (this.mHandler.hasCallbacks(this.mUpdateAudioRoutingRunnable) == false) goto L5;
        this.mHandler.removeCallbacks(this.mUpdateAudioRoutingRunnable);
    L5:
        this.mAudioPlaybackDetector.unregister();
        this.mAudioRecordingDetector.unregister();
        if (this.mGenericWindowPolicyController == null) goto L8;
        this.mGenericWindowPolicyController.unregisterRunningAppsChangedListener(this);
        this.mGenericWindowPolicyController = null;
    L8:
        Object r0 = this.mCallbackLock;
        monitor-enter(r0);
        this.mRoutingCallback = null;     // Catch: Throwable -> L13
        this.mConfigChangedCallback = null;     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.companion.virtual.GenericWindowPolicyController.RunningAppsChangedListener
    public void onRunningAppsChanged(ArraySet<Integer> runningUids) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mRunningAppUids.equals(runningUids) == false) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        this.mRunningAppUids.clear();     // Catch: Throwable -> L8
        this.mRunningAppUids.addAll(runningUids);     // Catch: Throwable -> L8
        ArraySet<Integer> oldPlayingAppUids = this.mPlayingAppUids;     // Catch: Throwable -> L8
        AudioManager audioManager = (AudioManager) this.mContext.getSystemService(AudioManager.class);     // Catch: Throwable -> L8
        List<AudioPlaybackConfiguration> configs = audioManager.getActivePlaybackConfigurations();     // Catch: Throwable -> L8
        this.mPlayingAppUids = findPlayingAppUids(configs, this.mRunningAppUids);     // Catch: Throwable -> L8
        if (this.mPlayingAppUids.isEmpty() == true) goto L16;
        Slog.i(TAG, "Audio is playing, do not change rerouted apps");     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L16:
        if (oldPlayingAppUids.isEmpty() == true) goto L24;
        Slog.i(TAG, "The last playing app removed, delay change rerouted apps");     // Catch: Throwable -> L8
        if (this.mHandler.hasCallbacks(this.mUpdateAudioRoutingRunnable) == false) goto L20;
        this.mHandler.removeCallbacks(this.mUpdateAudioRoutingRunnable);     // Catch: Throwable -> L8
    L20:
        this.mHandler.postDelayed(this.mUpdateAudioRoutingRunnable, ISmtResourceControl.LAUNCH_CPUSET_EFFECTIVE_TIME);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L24:
        monitor-exit(r0);     // Catch: Throwable -> L8
        notifyAppsNeedingAudioRoutingChanged();
    }

    @Override // com.android.server.companion.virtual.audio.AudioPlaybackDetector.AudioPlaybackCallback
    public void onPlaybackConfigChanged(List<AudioPlaybackConfiguration> configs) {
        updatePlayingApplications(configs);
        Object r0 = this.mLock;
        monitor-enter(r0);
        List<AudioPlaybackConfiguration> audioPlaybackConfigurations = findPlaybackConfigurations(configs, this.mRunningAppUids);     // Catch: Throwable -> L20
        monitor-exit(r0);     // Catch: Throwable -> L20
        Object r2 = this.mCallbackLock;
        monitor-enter(r2);
    L12:
        th = move-exception;
        throw th;
    L9:
        if (this.mConfigChangedCallback != null) goto L23;
    L16:
        monitor-exit(r2);     // Catch: Throwable -> L12
        return;
    L23:
        this.mConfigChangedCallback.onPlaybackConfigChanged(audioPlaybackConfigurations);     // Catch: Throwable -> L12 RemoteException -> L14
    L14:
        e = move-exception;
        Slog.e(TAG, "RemoteException when calling onPlaybackConfigChanged", e);     // Catch: Throwable -> L12
    L20:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.companion.virtual.audio.AudioRecordingDetector.AudioRecordingCallback
    public void onRecordingConfigChanged(List<AudioRecordingConfiguration> configs) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        List<AudioRecordingConfiguration> audioRecordingConfigurations = findRecordingConfigurations(configs, this.mRunningAppUids);     // Catch: Throwable -> L20
        monitor-exit(r0);     // Catch: Throwable -> L20
        Object r2 = this.mCallbackLock;
        monitor-enter(r2);
    L12:
        th = move-exception;
        throw th;
    L9:
        if (this.mConfigChangedCallback != null) goto L27;
    L16:
        monitor-exit(r2);     // Catch: Throwable -> L12
        return;
    L27:
        this.mConfigChangedCallback.onRecordingConfigChanged(audioRecordingConfigurations);     // Catch: Throwable -> L12 RemoteException -> L14
    L14:
        e = move-exception;
        Slog.e(TAG, "RemoteException when calling onRecordingConfigChanged", e);     // Catch: Throwable -> L12
    L20:
        th = move-exception;
        throw th;
    }

    private void updatePlayingApplications(List<AudioPlaybackConfiguration> configs) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        ArraySet<Integer> playingAppUids = findPlayingAppUids(configs, this.mRunningAppUids);     // Catch: Throwable -> L8
        if (this.mPlayingAppUids.equals(playingAppUids) == false) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        this.mPlayingAppUids = playingAppUids;     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        notifyAppsNeedingAudioRoutingChanged();
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private void notifyAppsNeedingAudioRoutingChanged() {
        if (this.mHandler.hasCallbacks(this.mUpdateAudioRoutingRunnable) == false) goto L5;
        this.mHandler.removeCallbacks(this.mUpdateAudioRoutingRunnable);
    L5:
        Object r0 = this.mLock;
        monitor-enter(r0);
        int[] runningUids = new int[this.mRunningAppUids.size()];     // Catch: Throwable -> L11
        int i = 0;
    L9:
        if (i >= this.mRunningAppUids.size()) goto L14;
        runningUids[i] = this.mRunningAppUids.valueAt(i).intValue();     // Catch: Throwable -> L11
        i = i + 1;     // Catch: Throwable -> L11
        goto L9
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L11
        Object r2 = this.mCallbackLock;
        monitor-enter(r2);
    L21:
        th = move-exception;
        throw th;
    L18:
        if (this.mRoutingCallback != null) goto L35;
    L25:
        monitor-exit(r2);     // Catch: Throwable -> L21
        return;
    L35:
        this.mRoutingCallback.onAppsNeedingAudioRoutingChanged(runningUids);     // Catch: Throwable -> L21 RemoteException -> L23
    L23:
        e = move-exception;
        Slog.e(TAG, "RemoteException when calling updateReroutingApps", e);     // Catch: Throwable -> L21
    L11:
        th = move-exception;
        throw th;
    }

    private static ArraySet<Integer> findPlayingAppUids(List<AudioPlaybackConfiguration> configs, ArraySet<Integer> runningAppUids) {
        ArraySet<Integer> playingAppUids = new ArraySet();
        Iterator<AudioPlaybackConfiguration> r1 = configs.iterator();
    L4:
        if (r1.hasNext() == false) goto L11;
        AudioPlaybackConfiguration config = r1.next();
        if (runningAppUids.contains(Integer.valueOf(config.getClientUid())) == false) goto L4;
        if (config.getPlayerState() != 2) goto L4;
        playingAppUids.add(Integer.valueOf(config.getClientUid()));
        goto L4
    L11:
        return playingAppUids;
    }

    private static List<AudioPlaybackConfiguration> findPlaybackConfigurations(List<AudioPlaybackConfiguration> configs, ArraySet<Integer> runningAppUids) {
        List<AudioPlaybackConfiguration> runningConfigs = new ArrayList();
        Iterator<AudioPlaybackConfiguration> r1 = configs.iterator();
    L4:
        if (r1.hasNext() == false) goto L9;
        AudioPlaybackConfiguration config = r1.next();
        if (runningAppUids.contains(Integer.valueOf(config.getClientUid())) == false) goto L4;
        runningConfigs.add(config);
        goto L4
    L9:
        return runningConfigs;
    }

    private static List<AudioRecordingConfiguration> findRecordingConfigurations(List<AudioRecordingConfiguration> configs, ArraySet<Integer> runningAppUids) {
        List<AudioRecordingConfiguration> runningConfigs = new ArrayList();
        Iterator<AudioRecordingConfiguration> r1 = configs.iterator();
    L4:
        if (r1.hasNext() == false) goto L9;
        AudioRecordingConfiguration config = r1.next();
        if (runningAppUids.contains(Integer.valueOf(config.getClientUid())) == false) goto L4;
        runningConfigs.add(config);
        goto L4
    L9:
        return runningConfigs;
    }

    boolean hasPendingRunnable() {
        return this.mHandler.hasCallbacks(this.mUpdateAudioRoutingRunnable);
    }

    void addPlayingAppsForTesting(int appUid) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mPlayingAppUids.add(Integer.valueOf(appUid));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
