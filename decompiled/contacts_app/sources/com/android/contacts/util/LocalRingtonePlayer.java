package com.android.contacts.util;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class LocalRingtonePlayer {
    private AudioManager mAudioManager;
    private MediaPlayer.OnCompletionListener mCompletionListener;
    private Context mContext;
    private volatile MediaPlayer mPlayer;
    private volatile MediaPlayer mPreparingPlayer;
    private int mStreamType;
    private volatile Uri mUri;

    static /* synthetic */ MediaPlayer access$000(LocalRingtonePlayer r0) {
        return r0.mPlayer;
    }

    static /* synthetic */ MediaPlayer access$002(LocalRingtonePlayer r0, MediaPlayer r1) {
        r0.mPlayer = r1;
        return r1;
    }

    static /* synthetic */ MediaPlayer access$100(LocalRingtonePlayer r0) {
        return r0.mPreparingPlayer;
    }

    static /* synthetic */ MediaPlayer access$102(LocalRingtonePlayer r0, MediaPlayer r1) {
        r0.mPreparingPlayer = r1;
        return r1;
    }

    static /* synthetic */ int access$200(LocalRingtonePlayer r0) {
        return r0.mStreamType;
    }

    static /* synthetic */ AudioManager access$300(LocalRingtonePlayer r0) {
        return r0.mAudioManager;
    }

    static /* synthetic */ void access$400(LocalRingtonePlayer r0, MediaPlayer r1) {
        r0.destroyPlayerSafe(r1);
    }

    public LocalRingtonePlayer(Context r2, Uri r3) {
        this.mStreamType = 2;
        this.mContext = r2;
        this.mAudioManager = (AudioManager) r2.getSystemService("audio");
        this.mUri = r3;
    }

    public synchronized void setCompletionListener(MediaPlayer.OnCompletionListener r1) {
        monitor-enter(this);
        this.mCompletionListener = r1;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void setStreamType(int r1) {
        monitor-enter(this);
        this.mStreamType = r1;     // Catch: Throwable -> L6
        setUri(this.mUri);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public void setUri(Uri r1) {
        stop();
        if (r1 != null) goto L12;
        monitor-enter(this);
        this.mUri = null;     // Catch: Throwable -> L9
        monitor-exit(this);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    L12:
        monitor-enter(this);
        this.mUri = r1;     // Catch: Throwable -> L16
        monitor-exit(this);     // Catch: Throwable -> L16
        return;
    L16:
        th = move-exception;
        throw th;
    }

    public synchronized Uri getUri() {
        monitor-enter(this);
        Uri r0 = this.mUri;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized boolean isRingtoneNone() {
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L4:
        if (this.mUri == null) goto L9;
        if (Uri.EMPTY.equals(this.mUri) == true) goto L9;
        boolean r0 = false;
    L10:
        monitor-exit(this);
        return r0;
    L9:
        r0 = true;
        goto L10
    }

    public void play() {
        monitor-enter(this);
        Uri r0 = this.mUri;     // Catch: Throwable -> L43
        MediaPlayer r1 = this.mPlayer;     // Catch: Throwable -> L43
        MediaPlayer.OnCompletionListener r2 = this.mCompletionListener;     // Catch: Throwable -> L43
        monitor-exit(this);     // Catch: Throwable -> L43
        if (r1 != null) goto L48;
        if (r0 != null) goto L24;
        return;
    L24:
        MediaPlayer r3 = new MediaPlayer();
        r3.setDataSource(this.mContext, r0);     // Catch: Exception -> L36 IOException -> L38 SecurityException -> L40
        r3.setAudioStreamType(this.mStreamType);     // Catch: Exception -> L36 IOException -> L38 SecurityException -> L40
        r3.setOnCompletionListener(r2);     // Catch: Exception -> L36 IOException -> L38 SecurityException -> L40
        r3.setOnPreparedListener(new AnonymousClass1(this));     // Catch: Exception -> L36 IOException -> L38 SecurityException -> L40
        r3.setOnErrorListener(new AnonymousClass2(this));     // Catch: Exception -> L36 IOException -> L38 SecurityException -> L40
        r3.prepareAsync();     // Catch: Exception -> L36 IOException -> L38 SecurityException -> L40
        monitor-enter(this);     // Catch: Exception -> L36 IOException -> L38 SecurityException -> L40
    L33:
        th = move-exception;
        throw th;     // Catch: Exception -> L36 IOException -> L38 SecurityException -> L40
    L28:
        if (this.mPreparingPlayer == null) goto L30;
        this.mPreparingPlayer.release();     // Catch: Throwable -> L33
    L30:
        this.mPreparingPlayer = r3;     // Catch: Throwable -> L33
        monitor-exit(this);     // Catch: Throwable -> L33
        return;
    L38:
        e = move-exception;
        r3.release();
        e.printStackTrace();
        return;
    L40:
        e = move-exception;
        r3.release();
        e.printStackTrace();
        return;
    L36:
        e = move-exception;
        r3.release();
        e.printStackTrace();
        return;
    L48:
    L10:
        e = move-exception;
        destroyPlayerSafe(r1);
        monitor-enter(this);
    L19:
        th = move-exception;
        throw th;
    L14:
        if (this.mPlayer != r1) goto L16;
        this.mPlayer = null;     // Catch: Throwable -> L19
    L16:
        e.printStackTrace();
        return;
    L7:
        if (r1.isPlaying() == true) goto L56;
        r1.start();     // Catch: IllegalStateException -> L10
        return;
    L56:
        return;
    L43:
        th = move-exception;
        throw th;
    }

    public void stop() {
        monitor-enter(this);
        MediaPlayer r0 = this.mPlayer;     // Catch: Throwable -> L10
        this.mPlayer = null;     // Catch: Throwable -> L10
        MediaPlayer r2 = this.mPreparingPlayer;     // Catch: Throwable -> L10
        this.mPreparingPlayer = null;     // Catch: Throwable -> L10
        monitor-exit(this);     // Catch: Throwable -> L10
        if (r0 == null) goto L7;
        destroyPlayerSafe(r0);
    L7:
        if (r2 == null) goto L15;
        destroyPlayerSafe(r2);
        return;
    L15:
        return;
    L10:
        th = move-exception;
        throw th;
    }

    private void destroyPlayerSafe(MediaPlayer r1) {
        if (r1 == null) goto L10;
        r1.reset();     // Catch: IllegalStateException -> L5
        r1.release();     // Catch: IllegalStateException -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    public boolean isPlaying() {
        monitor-enter(this);
        MediaPlayer r0 = this.mPlayer;     // Catch: Throwable -> L21
        monitor-exit(this);     // Catch: Throwable -> L21
        if (r0 != null) goto L28;
        return false;
    L28:
        return r0.isPlaying();
    L8:
        e = move-exception;
        destroyPlayerSafe(r0);
        monitor-enter(this);
    L16:
        th = move-exception;
        throw th;
    L12:
        if (this.mPlayer != r0) goto L14;
        this.mPlayer = null;     // Catch: Throwable -> L16
    L14:
        e.printStackTrace();
        return false;
    L21:
        th = move-exception;
        throw th;
    }
}
