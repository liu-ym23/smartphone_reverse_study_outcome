package com.bef.effectsdk;

import android.media.MediaPlayer;
import fna.g;
import gna.a;

/* JADX INFO: loaded from: classes3.dex */
public class AudioPlayer {
    public static final String TAG = null;
    private String mFilename;
    private boolean mIsPrepared;
    private MediaPlayer mMediaPlayer;
    private long mNativePtr;

    private native void nativeOnCompletion(long r100);

    private native void nativeOnError(long r100, int r101, int r102);

    private native void nativeOnInfo(long r100, int r101, int r102);

    private native void nativeOnPrepared(long r100);

    public int init() {
        this.mIsPrepared = false;
        MediaPlayer r100 = this.mMediaPlayer;
        if (r100 == null) goto L5;
        INVOKEVIRTUAL_com_bef_effectsdk_AudioPlayer_com_obric_performance_power_monitor_audio_MediaPlayerLancet_stop(r100);
        this.mMediaPlayer.release();
    L5:
        MediaPlayer r101 = new MediaPlayer();
        this.mMediaPlayer = r101;
        r101.setOnInfoListener(new AnonymousClass1(this));
        this.mMediaPlayer.setOnErrorListener(new AnonymousClass2(this));
        this.mMediaPlayer.setOnPreparedListener(new AnonymousClass3(this));
        this.mMediaPlayer.setOnCompletionListener(new AnonymousClass4(this));
        return 0;
    }

    static {
        TAG = "AudioPlayer";
    }

    public float getCurrentPlayTime() {
        MediaPlayer r100 = this.mMediaPlayer;
        if (r100 != null) goto L7;
        return 0.0f;
    L7:
        return r100.getCurrentPosition() / 1000.0f;
    }

    public float getTotalPlayTime() {
        MediaPlayer r100 = this.mMediaPlayer;
        if (r100 != null) goto L7;
        return 0.0f;
    L7:
        return r100.getDuration() / 1000.0f;
    }

    public boolean isPlaying() {
        MediaPlayer r100 = this.mMediaPlayer;
        if (r100 != null) goto L6;
        return false;
    L6:
        if (this.mIsPrepared == true) goto L13;
        return false;
    L13:
        return r100.isPlaying();
    L10:
        e = move-exception;
        e.printStackTrace();
        e.toString();
        return false;
    }

    public boolean pause() {
        MediaPlayer r100 = this.mMediaPlayer;
        if (r100 != null) goto L6;
        return false;
    L6:
        if (this.mIsPrepared == true) goto L8;
        return false;
    L8:
        INVOKEVIRTUAL_com_bef_effectsdk_AudioPlayer_com_obric_performance_power_monitor_audio_MediaPlayerLancet_pause(r100);
        return true;
    }

    public int release() {
        MediaPlayer r100 = this.mMediaPlayer;
        if (r100 == null) goto L13;
        INVOKEVIRTUAL_com_bef_effectsdk_AudioPlayer_com_obric_performance_power_monitor_audio_MediaPlayerLancet_stop(r100);     // Catch: Exception -> L6
        this.mMediaPlayer.release();     // Catch: Exception -> L6
    L8:
        this.mMediaPlayer = null;
        return 0;
    L6:
        e = move-exception;
        e.printStackTrace();
        e.toString();
        goto L8
    L13:
        return 0;
    }

    public boolean resume() {
        MediaPlayer r100 = this.mMediaPlayer;
        if (r100 != null) goto L6;
        return false;
    L6:
        if (this.mIsPrepared == true) goto L8;
        return false;
    L8:
        INVOKEVIRTUAL_com_bef_effectsdk_AudioPlayer_com_obric_performance_power_monitor_audio_MediaPlayerLancet_start(r100);
        return true;
    }

    public void startPlay() {
        MediaPlayer r100 = this.mMediaPlayer;
        if (r100 != null) goto L13;
        return;
    L13:
    L10:
        e = move-exception;
        e.printStackTrace();
        e.toString();
        return;
    L6:
        if (this.mIsPrepared == true) goto L8;
        r100.prepare();     // Catch: Exception -> L10
        this.mIsPrepared = true;     // Catch: Exception -> L10
    L8:
        INVOKEVIRTUAL_com_bef_effectsdk_AudioPlayer_com_obric_performance_power_monitor_audio_MediaPlayerLancet_start(this.mMediaPlayer);     // Catch: Exception -> L10
    }

    public void stopPlay() {
        MediaPlayer r100 = this.mMediaPlayer;
        if (r100 != null) goto L6;
        return;
    L6:
        if (this.mIsPrepared == false) goto L15;
        INVOKEVIRTUAL_com_bef_effectsdk_AudioPlayer_com_obric_performance_power_monitor_audio_MediaPlayerLancet_stop(r100);     // Catch: Exception -> L9
        this.mMediaPlayer.release();     // Catch: Exception -> L9
    L11:
        this.mMediaPlayer = null;
        this.mIsPrepared = false;
        return;
    L9:
        e = move-exception;
        e.printStackTrace();
        e.toString();
        goto L11
    }

    public AudioPlayer() {
        this.mMediaPlayer = null;
        this.mIsPrepared = false;
        this.mFilename = null;
    }

    public static void INVOKEVIRTUAL_com_bef_effectsdk_AudioPlayer_com_obric_performance_power_monitor_audio_MediaPlayerLancet_pause(MediaPlayer r100) {
        if (g.d() == true) goto L6;
        r100.pause();
        return;
    L6:
        r100.pause();
        a.a(r100.hashCode());
    }

    public static void INVOKEVIRTUAL_com_bef_effectsdk_AudioPlayer_com_obric_performance_power_monitor_audio_MediaPlayerLancet_start(MediaPlayer r100) {
        if (g.d() == true) goto L6;
        r100.start();
        return;
    L6:
        r100.start();
        a.c(r100.hashCode());
    }

    public static void INVOKEVIRTUAL_com_bef_effectsdk_AudioPlayer_com_obric_performance_power_monitor_audio_MediaPlayerLancet_stop(MediaPlayer r100) {
        if (g.d() == true) goto L6;
        r100.stop();
        return;
    L6:
        r100.stop();
        a.a(r100.hashCode());
    }

    public static /* synthetic */ long access$000(AudioPlayer r100) {
        return r100.mNativePtr;
    }

    public static /* synthetic */ MediaPlayer access$200(AudioPlayer r100) {
        return r100.mMediaPlayer;
    }

    public boolean seek(int r100) {
        MediaPlayer r101 = this.mMediaPlayer;
        if (r101 != null) goto L6;
        return false;
    L6:
        if (this.mIsPrepared == true) goto L14;
        return false;
    L14:
        r101.seekTo(r100);     // Catch: Exception -> L10
        return true;
    L10:
        e = move-exception;
        e.printStackTrace();
        e.toString();
        return true;
    }

    public void setDataSource(String r100) {
        if (this.mMediaPlayer != null) goto L6;
        init();
    L6:
        if (r100.equals(this.mFilename) == true) goto L8;
    L18:
        this.mMediaPlayer.reset();     // Catch: Exception -> L14
        this.mMediaPlayer.setDataSource(r100);     // Catch: Exception -> L14
    L16:
        this.mFilename = r100;
        return;
    L14:
        e = move-exception;
        e.printStackTrace();
        e.toString();
        goto L16
    L8:
        if (this.mIsPrepared == false) goto L18;
        if (this.mMediaPlayer.isPlaying() == false) goto L18;
    }

    public boolean setLoop(boolean r100) {
        MediaPlayer r101 = this.mMediaPlayer;
        if (r101 != null) goto L6;
        return false;
    L6:
        r101.setLooping(r100);
        return true;
    }

    public void setNativePtr(long r100) {
        this.mNativePtr = r100;
    }

    public boolean setVolume(float r100) {
        MediaPlayer r101 = this.mMediaPlayer;
        if (r101 != null) goto L6;
        return false;
    L6:
        if (this.mIsPrepared == true) goto L8;
        return false;
    L8:
        r101.setVolume(r100, r100);
        return true;
    }

    public static /* synthetic */ MediaPlayer access$202(AudioPlayer r100, MediaPlayer r101) {
        r100.mMediaPlayer = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$402(AudioPlayer r100, boolean r101) {
        r100.mIsPrepared = r101;
        return r101;
    }

    public static /* synthetic */ void access$500(AudioPlayer r100, long r101) {
        r100.nativeOnPrepared(r101);
    }

    public static /* synthetic */ void access$600(AudioPlayer r100, long r101) {
        r100.nativeOnCompletion(r101);
    }

    public static /* synthetic */ void access$100(AudioPlayer r100, long r101, int r102, int r103) {
        r100.nativeOnInfo(r101, r102, r103);
    }

    public static /* synthetic */ void access$300(AudioPlayer r100, long r101, int r102, int r103) {
        r100.nativeOnError(r101, r102, r103);
    }
}
