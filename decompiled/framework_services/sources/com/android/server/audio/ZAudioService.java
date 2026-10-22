package com.android.server.audio;

import android.media.AudioSystem;
import android.media.IAudioRecordChangedDispatcher;
import android.media.zte.IZAudioService;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import com.android.server.pm.PackageManagerService;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/* JADX INFO: loaded from: classes.dex */
public class ZAudioService {
    private static final String SETTING_AI_VOICE = "set_AI_voice";
    private static final String TAG = "AS.ZAudioService";
    private ZAudioClientDispatcher mAudioClientDispatcher;
    private ZAudioRecordingNotifier mAudioRecordingNotifier;
    private final AudioService mAudioService;
    private ZDtsSceneManager mDtsSceneManager;
    private final Handler mHandler;
    private final SettingsAdapter mSettings;
    private ZAudioMonitor mZAudioMonitor;
    private IZAudioService mZAudioService;

    public static /* synthetic */ boolean $r8$lambda$NrVHBouzhDvYfdxAObwyo09YP9I(Integer r0) {
        return lambda$getActiveUidsForStream$0(r0);
    }

    public ZAudioService(AudioService audioService, SettingsAdapter settings) {
        this.mAudioService = audioService;
        HandlerThread thread = new HandlerThread("ZAudioService");
        thread.start();
        this.mSettings = settings;
        this.mHandler = thread.getThreadHandler();
        this.mAudioClientDispatcher = new ZAudioServiceClientDispatcher(this.mHandler);
        initNativeService();
    }

    public synchronized void reset() {
        monitor-enter(this);
        this.mHandler.removeCallbacksAndMessages(null);     // Catch: Throwable -> L6
        initNativeService();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    private void updateAIVoiceSetting() {
        int aiVoiceValue = this.mSettings.getGlobalInt(this.mAudioService.mContext.getContentResolver(), SETTING_AI_VOICE, 1);
        StringBuilder r1 = new StringBuilder();
        r1.append("set_AI_voice=");
        if (aiVoiceValue != 1) goto L5;
        String r2 = "true";
    L6:
        r1.append(r2);
        String aiVoiceParam = r1.toString();
        AudioSystem.setParameters(aiVoiceParam);
        Log.d(TAG, "Updated AI voice setting: " + aiVoiceParam);
        return;
    L5:
        r2 = "false";
        goto L6
    }

    private synchronized void initNativeService() {
        monitor-enter(this);
        this.mZAudioService = AudioSystem.getZAudioService();     // Catch: Throwable -> L6 Exception -> L8
        if (this.mZAudioService == null) goto L11;
        this.mAudioClientDispatcher.reset();     // Catch: Throwable -> L6 Exception -> L8
        this.mZAudioMonitor = new ZAudioMonitor(this.mAudioClientDispatcher, this.mZAudioService);     // Catch: Throwable -> L6 Exception -> L8
        this.mDtsSceneManager = new ZDtsSceneManager(this, this.mAudioService.mContext, this.mHandler);     // Catch: Throwable -> L6 Exception -> L8
        this.mAudioRecordingNotifier = new ZAudioRecordingNotifier(this, this.mAudioService.mContext, this.mHandler);     // Catch: Throwable -> L6 Exception -> L8
        updateAIVoiceSetting();     // Catch: Throwable -> L6 Exception -> L8
    L14:
        monitor-exit(this);
        return;
    L11:
        throw new NullPointerException("Failed get native ZAudioService");     // Catch: Throwable -> L6 Exception -> L8
    L8:
        e = move-exception;
        Log.e(TAG, "initNativeZAudioService failed, error:", e);     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        throw th;
    }

    public SettingsAdapter getSettings() {
        return this.mSettings;
    }

    synchronized void setAudioClientDispatcher(ZAudioClientDispatcher dispatcher) {
        monitor-enter(this);
        this.mAudioClientDispatcher = dispatcher;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public IZAudioService getNativeService() {
        return this.mZAudioService;
    }

    public ZAudioClientDispatcher getAudioClientDispatcher() {
        return this.mAudioClientDispatcher;
    }

    List<Integer> getActiveUidsForStream(int streamType) {
        return getActiveUidsForStream(streamType, true, false);
    }

    public List<Integer> getActiveUidsForStream(int streamType, boolean excludeSystem, boolean excludeNav) {
        final Set<Integer> activeUids = new HashSet();
        Stream<Integer> allUids = this.mZAudioMonitor.getActiveUidsForStream(streamType).stream();
        if (excludeSystem == false) goto L5;
        allUids = allUids.filter(new ZAudioService$$ExternalSyntheticLambda0());
    L5:
        allUids.forEach(new ZAudioService$$ExternalSyntheticLambda1(activeUids));
        String logMessage = "getActiveUidsForStream: stream:" + streamType + " uids:" + ((String) activeUids.stream().map(new ZAudioService$$ExternalSyntheticLambda2()).collect(Collectors.joining(", ")));
        Log.i(TAG, logMessage);
        return new ArrayList(activeUids);
    }

    private static /* synthetic */ boolean lambda$getActiveUidsForStream$0(Integer uid) {
        if (uid.intValue() <= 10000) goto L5;
        return true;
    L5:
        return false;
    }

    public String getPackageNameForUid(int uid) {
        if (uid >= 10000) goto L17;
        Log.v(TAG, "uid " + uid + " is system uid");
        return PackageManagerService.PLATFORM_PACKAGE_NAME;
    L17:
        String[] packages = this.mAudioService.mContext.getPackageManager().getPackagesForUid(uid);     // Catch: Exception -> L12
        if (packages != null) goto L9;
        return "";
    L9:
        if (packages.length <= 0) goto L20;
        String packageName = packages[0];     // Catch: Exception -> L12
        return packageName;
    L20:
        return "";
    L12:
        e = move-exception;
        Log.e(TAG, "failed to retrieve package name for uid " + uid + " Error: " + e);
        return "";
    }

    public void registerAudioRecordChangedDispatcher(IAudioRecordChangedDispatcher dispatcher) {
        this.mAudioRecordingNotifier.registerAudioRecordChangedDispatcher(dispatcher);
    }

    public void unregisterAudioRecordChangedDispatcher(IAudioRecordChangedDispatcher dispatcher) {
        this.mAudioRecordingNotifier.unregisterAudioRecordChangedDispatcher(dispatcher);
    }

    public synchronized boolean isDtsSupported(String packageName) {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.mDtsSceneManager != null) goto L8;
        monitor-exit(this);
        return false;
    L8:
        boolean r0 = this.mDtsSceneManager.isDtsSupported(packageName);     // Catch: Throwable -> L11
        monitor-exit(this);
        return r0;
    }

    public synchronized void dump(PrintWriter pw) {
        monitor-enter(this);
        this.mZAudioMonitor.dump(pw);     // Catch: Throwable -> L6
        this.mDtsSceneManager.dump(pw);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }
}
