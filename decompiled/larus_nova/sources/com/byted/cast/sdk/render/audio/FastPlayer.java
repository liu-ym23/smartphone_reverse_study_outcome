package com.byted.cast.sdk.render.audio;

import com.byted.cast.sdk.RTCAudioProfile;
import com.byted.cast.sdk.log.Logger;
import com.byted.cast.sdk.log.LoggerManager;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public class FastPlayer {
    private static final String TAG = "FastPlayer";
    private long enginehandle;
    private byte[] mAudioBuffer;
    private IAudioFrameReader mAudioFrameReader;
    private Runnable mAudioPlayRunnable;
    private volatile boolean mIsLoopExit;
    private volatile boolean mIsPlayStarted;
    private Logger mLogger;
    private String mMirrorId;
    private Thread mPlayThread;

    public interface IAudioFrameReader {
        int readAudioFrame(byte[] r100);
    }

    public static /* synthetic */ void access$001(String r100) {
        System.loadLibrary(r100);
    }

    private native long native_setup();

    private native int native_start(long r100);

    private native void native_stop(long r100);

    private native int native_write(long r100, byte[] r101, int r102);

    static {
        INVOKESTATIC_com_byted_cast_sdk_render_audio_FastPlayer_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("oboeplayer_jni");
    }

    public void stop() {
        if (this.mIsPlayStarted == true) goto L5;
        return;
    L5:
        this.mIsLoopExit = true;
        this.mPlayThread.interrupt();     // Catch: InterruptedException -> L8
        ThreadMethodProxy.join(this.mPlayThread, 1000);     // Catch: InterruptedException -> L8
    L10:
        native_stop(this.enginehandle);
        this.mIsPlayStarted = false;
        this.mLogger.d(TAG, "FastPlayer stop success !");
        return;
    L8:
        e = move-exception;
        this.mLogger.e(TAG, e.getMessage());
        goto L10
    }

    public boolean isStarted() {
        return this.mIsPlayStarted;
    }

    @JvmStatic
    public static void INVOKESTATIC_com_byted_cast_sdk_render_audio_FastPlayer_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(String r100) {
        Intrinsics.checkNotNullParameter(r100, "libName");
        FLogger r101 = FLogger.f375446a;
        r101.i("Librarian_loadLib", "loadLibrary start libName -> " + r100);
        com.bytedance.librarian.a.c(r100);
        r101.i("Librarian_loadLib", "loadLibrary success by librarian -> " + r100);
    }

    public static /* synthetic */ boolean access$000(FastPlayer r100) {
        return r100.mIsLoopExit;
    }

    public static /* synthetic */ byte[] access$100(FastPlayer r100) {
        return r100.mAudioBuffer;
    }

    public static /* synthetic */ IAudioFrameReader access$200(FastPlayer r100) {
        return r100.mAudioFrameReader;
    }

    private boolean playback(byte[] r100) {
        return playback(r100, 0, r100.length);
    }

    public FastPlayer(IAudioFrameReader r100, String r101) {
        this.enginehandle = 0;
        this.mIsLoopExit = false;
        this.mIsPlayStarted = false;
        this.mAudioPlayRunnable = new AnonymousClass1(this);
        this.mMirrorId = r101;
        this.mLogger = LoggerManager.getLogger(r101);
        this.mAudioFrameReader = r100;
        if (this.enginehandle != 0) goto L6;
        this.enginehandle = native_setup();
        return;
    }

    public static /* synthetic */ boolean access$300(FastPlayer r100, byte[] r101) {
        return r100.playback(r101);
    }

    private boolean playback(byte[] r100, int r101, int r102) {
        if (this.mIsPlayStarted == true) goto L6;
        this.mLogger.e(TAG, "Player not started !");
        return false;
    L6:
        native_write(this.enginehandle, r100, r102);
        return true;
    }

    public boolean start(int r100, int r101, int r102, int r103) {
        if (this.mIsPlayStarted == false) goto L5;
        return false;
    L5:
        native_start(this.enginehandle);
        this.mAudioBuffer = new byte[RTCAudioProfile.getFrameSize(r101)];
        this.mIsLoopExit = false;
        PthreadThreadV2 r104 = new PthreadThreadV2(this.mAudioPlayRunnable, "FastPlayerThread");
        this.mPlayThread = r104;
        ThreadMethodProxy.setPriority(r104, 10);
        ThreadMethodProxy.start(this.mPlayThread);
        this.mIsPlayStarted = true;
        this.mLogger.d(TAG, "FastPlayer start success: " + r101 + ", " + r102 + ", " + r103);
        return true;
    }
}
