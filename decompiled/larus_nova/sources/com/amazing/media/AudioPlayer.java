package com.amazing.media;

import android.media.MediaPlayer;
import fna.g;
import gna.a;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public class AudioPlayer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public MediaPlayer f29331a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f29332b;

    public void destroy() {
        MediaPlayer r100 = this.f29331a;
        if (r100 != null) goto L5;
        return;
    L5:
        if (g.d() == true) goto L7;
        r100.stop();
    L8:
        this.f29331a.release();
        this.f29331a = null;
        return;
    L7:
        r100.stop();
        a.a(r100.hashCode());
        goto L8
    }

    public boolean isPlaying() {
        return this.f29331a.isPlaying();
    }

    public void pause() {
        MediaPlayer r100 = this.f29331a;
        if (g.d() == true) goto L5;
        r100.pause();
        return;
    L5:
        r100.pause();
        a.a(r100.hashCode());
    }

    public void play() {
        this.f29331a.reset();
        if (prepare() == false) goto L9;
        MediaPlayer r100 = this.f29331a;
        if (g.d() == true) goto L7;
        r100.start();
        return;
    L7:
        r100.start();
        a.c(r100.hashCode());
        return;
    }

    public boolean prepare() {
        this.f29331a.setDataSource(this.f29332b);     // Catch: IOException -> L5
        this.f29331a.setAudioStreamType(3);     // Catch: IOException -> L5
        this.f29331a.prepare();     // Catch: IOException -> L5
        return true;
    L5:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    public void resume() {
        MediaPlayer r100 = this.f29331a;
        if (g.d() == true) goto L5;
        r100.start();
        return;
    L5:
        r100.start();
        a.c(r100.hashCode());
    }

    public void stop() {
        MediaPlayer r100 = this.f29331a;
        if (g.d() == true) goto L5;
        r100.stop();
        return;
    L5:
        r100.stop();
        a.a(r100.hashCode());
    }

    public AudioPlayer(String r100) {
        this.f29331a = new MediaPlayer();
        this.f29332b = r100;
    }

    public void setLoop(boolean r100) {
        this.f29331a.setLooping(r100);
    }
}
