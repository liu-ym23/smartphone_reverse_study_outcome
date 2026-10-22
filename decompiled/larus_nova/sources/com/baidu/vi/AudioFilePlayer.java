package com.baidu.vi;

import android.media.MediaPlayer;

/* JADX INFO: loaded from: classes39.dex */
public class AudioFilePlayer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private MediaPlayer f33548a;

    private native boolean onErrorOccured(long r100, int r101);

    private native void onPlayCompleted(long r100);

    private AudioFilePlayer() {
        this.f33548a = new MediaPlayer();
    }
}
