package com.baidu.vi;

import android.media.MediaPlayer;

/* loaded from: classes.dex */
public class AudioFilePlayer {

    /* renamed from: a, reason: collision with root package name */
    private MediaPlayer f9459a = new MediaPlayer();

    private AudioFilePlayer() {
    }

    private native boolean onErrorOccured(long j4, int i4);

    private native void onPlayCompleted(long j4);
}
