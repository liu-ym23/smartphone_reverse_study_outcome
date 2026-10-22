package com.android.server.audio;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.media.zte.IZAudioService;
import android.os.Handler;
import android.os.RemoteException;
import android.os.SystemProperties;
import android.os.UserHandle;
import android.util.Log;
import com.android.server.utils.EventLogger;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Stream;

/* JADX INFO: loaded from: classes.dex */
public class ZDtsSceneManager implements ZAudioPlaybackListener {
    private static final int DEFAULT_AUDIO_DELAY = 0;
    static final String DTS_INTENT_TARGET = "com.dts.dtsxultra";
    static final String DTS_INTENT_TARGET_RC = "com.dts.dtsxultra.activities.SRSConfigReceiver";
    static final String DTS_SCENE_INTENT_NAME = "cn.nubia.action.AUDIO_SCENE";
    static final String EXTRA_SCENE = "scene";
    static final int LOG_NB_EVENTS_ZTE_DTS_SCENE = 10;
    private static final int MSG_UPDATE_DTS_SCENE = 200;
    private static final int MSG_UPDATE_VIDEO_PARAM = 201;
    static final int SCENE_CURRENT = -2;
    static final int SCENE_GAME = 2;
    private static final int SCENE_INIT = -1;
    static final int SCENE_MUSIC = 0;
    private static final int[] SCORE_TABLE = null;
    private static final String TAG = "ZA.ZDtsSceneManager";
    private final Context mContext;
    AtomicBoolean mCruuentVideoActive;
    private int mCurrentScene;
    private final EventLogger mEventLogger;
    private final HashSet<String> mGameList;
    private final Handler mHandler;
    private final HashSet<String> mMusicList;
    private final HashSet<String> mVideoList;
    private final ZAudioService mZAudioService;

    /* JADX INFO: renamed from: $r8$lambda$2ua-PYjYktNTGuHesS7QPJtRkSw, reason: not valid java name */
    public static /* synthetic */ void m2229$r8$lambda$2uaPYjYktNTGuHesS7QPJtRkSw(ZDtsSceneManager r0, AtomicBoolean r1, String r2) {
        r0.lambda$calculateAndUpdateScene$0(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$5F_4KuQ9Zjm6zgoG9iPnOofiV7U(ZDtsSceneManager r0, AtomicBoolean r1) {
        r0.lambda$calculateAndUpdateScene$5(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$9qeXCIdEY-RJsKRU14FyhUs16L4, reason: not valid java name */
    public static /* synthetic */ Integer m2230$r8$lambda$9qeXCIdEYRJsKRU14FyhUs16L4(ZDtsSceneManager r0, String r1) {
        return r0.lambda$calculateAndUpdateScene$1(r1);
    }

    public static /* synthetic */ Integer $r8$lambda$N3eOn4h0jHsT5mZeqfDWeaOEOvQ(Integer r0, Integer r1) {
        return lambda$calculateAndUpdateScene$2(r0, r1);
    }

    public static /* synthetic */ Integer $r8$lambda$SNqxt2r1I0KTZe1UkRr4sGzJzcs(Integer r0, Integer r1) {
        return lambda$calculateAndUpdateScene$3(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$_SztQImpgy33V9Jyx-TqQ4xCaNM, reason: not valid java name */
    public static /* synthetic */ void m2231$r8$lambda$_SztQImpgy33V9JyxTqQ4xCaNM(ZDtsSceneManager r0, int r1) {
        r0.lambda$calculateAndUpdateScene$4(r1);
    }

    static {
        DEFAULT_AUDIO_DELAY = SystemProperties.getInt("debug.dts_scene_cast.delay", 300);
        SCORE_TABLE = new int[]{-2, 0, 0, 0, 2, 2, 0, 0};
    }

    public ZDtsSceneManager(ZAudioService service, Context context, Handler handler) throws RemoteException {
        this.mEventLogger = new EventLogger(10, "ZAudio service dts scene notify");
        this.mCruuentVideoActive = new AtomicBoolean(false);
        this.mContext = context;
        this.mHandler = handler;
        this.mCurrentScene = -1;
        this.mZAudioService = service;
        IZAudioService nService = service.getNativeService();
        this.mGameList = new HashSet(Arrays.asList(nService.getDtsListForCategory(0)));
        HashSet<String> videoList = new HashSet();
        videoList.addAll(Arrays.asList(nService.getDtsListForCategory(1)));
        videoList.addAll(Arrays.asList(nService.getDtsListForCategory(2)));
        this.mVideoList = videoList;
        this.mMusicList = new HashSet(List.of(new String[]{"com.changba", "com.netease.cloudmusic", "com.luna.music", "com.tencent.qqmusic", "com.kugou.android", "com.tencent.karaoke", "cn.kuwo.player", "cmccwm.mobilemusic", "com.spotify.music", "com.google.android.apps.youtube.music", "com.pandora.android", "com.amazon.mp3", "com.soundcloud.android", "com.apple.android.music", "com.clearchannel.iheartradio.controller", "com.audiomack", "com.shazam.android", "com.sec.android.app.music"}));
        service.getAudioClientDispatcher().registerAudioPlaybackListener(TAG, this);
    }

    public boolean isDtsSupported(String packageName) {
        if (this.mGameList.isEmpty() == false) goto L6;
        return false;
    L6:
        Stream r0 = this.mGameList.stream();
        packageName.getClass();
        return r0.anyMatch(new ZDtsSceneManager$$ExternalSyntheticLambda7(packageName));
    }

    private synchronized void calculateAndUpdateScene() {
        monitor-enter(this);
        List<Integer> uids = this.mZAudioService.getActiveUidsForStream(3, true, true);     // Catch: Throwable -> L11
        final AtomicBoolean hasVideo = new AtomicBoolean(false);     // Catch: Throwable -> L11
        Stream<Integer> r3 = uids.stream();     // Catch: Throwable -> L11
        final ZAudioService r4 = this.mZAudioService;     // Catch: Throwable -> L11
        r4.getClass();     // Catch: Throwable -> L11
        int index = ((Integer) r3.map(new ZDtsSceneManager$$ExternalSyntheticLambda0(r4)).peek(new ZDtsSceneManager$$ExternalSyntheticLambda1(this, hasVideo)).map(new ZDtsSceneManager$$ExternalSyntheticLambda2(this)).reduce(0, new ZDtsSceneManager$$ExternalSyntheticLambda3(), new ZDtsSceneManager$$ExternalSyntheticLambda4())).intValue();     // Catch: Throwable -> L11
        final int newScene = SCORE_TABLE[index];     // Catch: Throwable -> L11
        if (newScene != (-2)) goto L9;
        monitor-exit(this);
        return;
    L9:
        if (this.mHandler.hasMessages(200) == false) goto L14;
        this.mHandler.removeMessages(200);     // Catch: Throwable -> L11
    L14:
        if (this.mHandler.hasMessages(201) == false) goto L16;
        this.mHandler.removeMessages(201);     // Catch: Throwable -> L11
    L16:
        this.mHandler.postDelayed(new ZDtsSceneManager$$ExternalSyntheticLambda5(this, newScene), 200, DEFAULT_AUDIO_DELAY);     // Catch: Throwable -> L11
        this.mHandler.postDelayed(new ZDtsSceneManager$$ExternalSyntheticLambda6(this, hasVideo), 201, DEFAULT_AUDIO_DELAY);     // Catch: Throwable -> L11
        monitor-exit(this);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$calculateAndUpdateScene$0(AtomicBoolean hasVideo, String pkg) {
        if (isVideo(pkg) == false) goto L6;
        hasVideo.set(true);
        return;
    }

    private /* synthetic */ Integer lambda$calculateAndUpdateScene$1(String pkg) {
        if (isGame(pkg) == false) goto L7;
        return 0;
    L7:
        if (isMusic(pkg) == false) goto L11;
        return 1;
    L11:
        return 2;
    }

    private static /* synthetic */ Integer lambda$calculateAndUpdateScene$2(Integer acc, Integer type) {
        return Integer.valueOf(acc.intValue() | (1 << (2 - type.intValue())));
    }

    private static /* synthetic */ Integer lambda$calculateAndUpdateScene$3(Integer a, Integer b) {
        return Integer.valueOf(a.intValue() | b.intValue());
    }

    private /* synthetic */ void lambda$calculateAndUpdateScene$4(int newScene) {
        onUpdateScene(newScene);
    }

    private /* synthetic */ void lambda$calculateAndUpdateScene$5(AtomicBoolean hasVideo) {
        onUpdateVideoParam(hasVideo.get());
    }

    private void onUpdateScene(int scene) {
        Log.d(TAG, "mCurrentScene = " + this.mCurrentScene + " newScene = " + scene);
        if (this.mCurrentScene == scene) goto L6;
        this.mCurrentScene = scene;
        this.mEventLogger.enqueueAndLog("Broadcasting new scene:" + this.mCurrentScene, 0, TAG);
        Intent intent = new Intent(DTS_SCENE_INTENT_NAME);
        intent.setComponent(new ComponentName(DTS_INTENT_TARGET, DTS_INTENT_TARGET_RC));
        intent.putExtra(EXTRA_SCENE, this.mCurrentScene);
        this.mContext.sendBroadcastAsUser(intent, UserHandle.ALL);
        return;
    }

    private void onUpdateVideoParam(boolean hasVideo) {
        if (this.mCruuentVideoActive.compareAndSet(!hasVideo, hasVideo) == true) goto L4;
    }

    boolean isGame(String packageName) {
        Stream r0 = this.mGameList.stream();
        packageName.getClass();
        return r0.anyMatch(new ZDtsSceneManager$$ExternalSyntheticLambda7(packageName));
    }

    boolean isVideo(String packageName) {
        Stream r0 = this.mVideoList.stream();
        packageName.getClass();
        return r0.anyMatch(new ZDtsSceneManager$$ExternalSyntheticLambda7(packageName));
    }

    boolean isMusic(String packageName) {
        Stream r0 = this.mMusicList.stream();
        packageName.getClass();
        return r0.anyMatch(new ZDtsSceneManager$$ExternalSyntheticLambda7(packageName));
    }

    @Override // com.android.server.audio.ZAudioPlaybackListener
    public synchronized void onPlaybackChange(ZPlaybackClientInterface client) {
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (client.getStreamType() == 3) goto L8;
        monitor-exit(this);
        return;
    L8:
        int uid = client.getUid();     // Catch: Throwable -> L13
        if (uid >= 10000) goto L15;
        Log.d(TAG, "onPlaybackChangeIgnore system uid");     // Catch: Throwable -> L13
        monitor-exit(this);
        return;
    L15:
        calculateAndUpdateScene();     // Catch: Throwable -> L13
        monitor-exit(this);
    }

    public void dump(PrintWriter pw) {
        pw.println("\nDts Scene Manager:");
        pw.println("Scene : " + this.mCurrentScene);
        this.mEventLogger.dump(pw);
    }
}
