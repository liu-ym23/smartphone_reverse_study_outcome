package com.stone.playersdk;

import android.content.Context;
import android.net.Uri;
import android.view.Surface;
import hf.b;
import hf.c;
import hf.d;
import java.io.FileDescriptor;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class a implements IPlayer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d f18198a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public PlayerType f18199b;

    public a(Context r10, PlayerType r11, gf.a r12) {
        this.f18199b = r11;
        if (r11 != PlayerType.MEDIA_PLAYER) goto L6;
        this.f18198a = new c(r10, r12);
        return;
    L6:
        if (r11 != PlayerType.EXO_PLAYER) goto L9;
        this.f18198a = new hf.a(r10, r12);
        return;
    L9:
        if (r11 != PlayerType.IJK_PLAYER) goto L14;
        this.f18198a = new b(r10, r12);
        return;
    }

    @Override // com.stone.playersdk.IPlayer
    public long getCurrentPosition() {
        return this.f18198a.getCurrentPosition();
    }

    @Override // com.stone.playersdk.IPlayer
    public long getDuration() {
        return this.f18198a.getDuration();
    }

    @Override // com.stone.playersdk.IPlayer
    public boolean isPlaying() {
        return this.f18198a.isPlaying();
    }

    @Override // com.stone.playersdk.IPlayer
    public void pause() {
        this.f18198a.pause();
    }

    @Override // com.stone.playersdk.IPlayer
    public void prepareAsync() {
        this.f18198a.prepareAsync();
    }

    @Override // com.stone.playersdk.IPlayer
    public void release() {
        this.f18198a.release();
    }

    @Override // com.stone.playersdk.IPlayer
    public void seekTo(long r10) {
        this.f18198a.seekTo(r10);
    }

    @Override // com.stone.playersdk.IPlayer
    public void setDataSource(String r10) {
        this.f18198a.setDataSource(r10);
    }

    @Override // com.stone.playersdk.IPlayer
    public void setOnErrorListener(IPlayer.OnErrorListener r10) {
        this.f18198a.setOnErrorListener(r10);
    }

    @Override // com.stone.playersdk.IPlayer
    public void setOnLocalProxyCacheListener(IPlayer.OnLocalProxyCacheListener r10) {
        this.f18198a.setOnLocalProxyCacheListener(r10);
    }

    @Override // com.stone.playersdk.IPlayer
    public void setOnPreparedListener(IPlayer.OnPreparedListener r10) {
        this.f18198a.setOnPreparedListener(r10);
    }

    @Override // com.stone.playersdk.IPlayer
    public void setOnVideoSizeChangedListener(IPlayer.OnVideoSizeChangedListener r10) {
        this.f18198a.setOnVideoSizeChangedListener(r10);
    }

    @Override // com.stone.playersdk.IPlayer
    public void setOriginUrl(String r10) {
        this.f18198a.setOriginUrl(r10);
    }

    @Override // com.stone.playersdk.IPlayer
    public void setSpeed(float r10) {
        this.f18198a.setSpeed(r10);
    }

    @Override // com.stone.playersdk.IPlayer
    public void setSurface(Surface r10) {
        this.f18198a.setSurface(r10);
    }

    @Override // com.stone.playersdk.IPlayer
    public void setVolume(float r10, float r11) {
        this.f18198a.setVolume(r10, r11);
    }

    @Override // com.stone.playersdk.IPlayer
    public void start() {
        this.f18198a.start();
    }

    @Override // com.stone.playersdk.IPlayer
    public void startLocalProxy(String r10, HashMap r11) {
        this.f18198a.startLocalProxy(r10, r11);
    }

    @Override // com.stone.playersdk.IPlayer
    public void stop() {
        this.f18198a.stop();
    }

    @Override // com.stone.playersdk.IPlayer
    public void setDataSource(FileDescriptor r10) {
        this.f18198a.setDataSource(r10);
    }

    @Override // com.stone.playersdk.IPlayer
    public void setDataSource(Context r10, Uri r11) {
        this.f18198a.setDataSource(r10, r11);
    }

    @Override // com.stone.playersdk.IPlayer
    public void setDataSource(Context r10, Uri r11, Map r12) {
        this.f18198a.setDataSource(r10, r11, r12);
    }

    @Override // com.stone.playersdk.IPlayer
    public void setDataSource(FileDescriptor r10, long r11, long r12) {
        this.f18198a.setDataSource(r10, r11, r12);
    }
}
