package com.byted.cast.render;

import android.view.Surface;
import com.byted.cast.mediacommon.render.IAudioFrameListener;
import com.byted.cast.mediacommon.render.IMediaRender;
import com.byted.cast.mediacommon.render.IVideoFrameListener;
import com.byted.cast.mediacommon.render.MediaRenderState;
import com.byted.cast.mediacommon.render.parameters.AudioParameter;
import com.byted.cast.mediacommon.render.parameters.MediaParameter;
import com.byted.cast.mediacommon.render.parameters.VideoParameter;
import com.byted.cast.render.imp.MediaRenderImp;

/* JADX INFO: loaded from: classes43.dex */
public class MediaRender implements IMediaRender {
    private MediaRenderImp imp;

    @Override // com.byted.cast.mediacommon.render.IMediaRender
    public void stopUrl() {
        this.imp.stopUrl();
    }

    public MediaRender() {
        this.imp = null;
    }

    @Override // com.byted.cast.mediacommon.render.IMediaRender
    public MediaRenderState getAudioState(int r100) {
        return this.imp.getAudioState(r100);
    }

    @Override // com.byted.cast.mediacommon.render.IMediaRender
    public Object getParameter(MediaParameter r100) {
        return this.imp.getParameter(r100);
    }

    @Override // com.byted.cast.mediacommon.render.IMediaRender
    public MediaRenderState getVideoState(int r100) {
        return this.imp.getVideoState(r100);
    }

    @Override // com.byted.cast.mediacommon.render.IMediaRender
    public void init(String r100) {
        if (this.imp != null) goto L6;
        this.imp = new MediaRenderImp(r100);
        return;
    }

    @Override // com.byted.cast.mediacommon.render.IMediaRender
    public void sendAVStream(byte[] r100) {
        this.imp.sendAVStream(r100);
    }

    @Override // com.byted.cast.mediacommon.render.IMediaRender
    public void setAudioFrameListener(IAudioFrameListener r100) {
        this.imp.setAudioFrameListener(r100);
    }

    @Override // com.byted.cast.mediacommon.render.IMediaRender
    public void setVideoFrameListener(IVideoFrameListener r100) {
        this.imp.setVideoFrameListener(r100);
    }

    @Override // com.byted.cast.mediacommon.render.IMediaRender
    public boolean startAudioPlayer(int r100) {
        return this.imp.startAudioPlayer(r100);
    }

    @Override // com.byted.cast.mediacommon.render.IMediaRender
    public boolean startVideoPlayer(int r100) {
        return this.imp.startVideoPlayer(r100);
    }

    @Override // com.byted.cast.mediacommon.render.IMediaRender
    public boolean stopAudioPlayer(int r100) {
        return this.imp.stopAudioPlayer(r100);
    }

    @Override // com.byted.cast.mediacommon.render.IMediaRender
    public boolean stopVideoPlayer(int r100) {
        return this.imp.stopVideoPlayer(r100);
    }

    @Override // com.byted.cast.mediacommon.render.IMediaRender
    public void setAudioParameter(int r100, AudioParameter r101) {
        this.imp.setAudioParameter(r100, r101);
    }

    @Override // com.byted.cast.mediacommon.render.IMediaRender
    public void setParameter(MediaParameter r100, Object r101) {
        this.imp.setParameter(r100, r101);
    }

    @Override // com.byted.cast.mediacommon.render.IMediaRender
    public void setSurface(int r100, Surface r101) {
        this.imp.setSurface(r100, r101);
    }

    @Override // com.byted.cast.mediacommon.render.IMediaRender
    public void setVideoParameter(int r100, VideoParameter r101) {
        this.imp.setVideoParameter(r100, r101);
    }

    @Override // com.byted.cast.mediacommon.render.IMediaRender
    public void startUrl(int r100, String r101) {
        this.imp.startUrl(r100, r101);
    }

    @Override // com.byted.cast.mediacommon.render.IMediaRender
    public void sendAudioPacket(int r100, byte[] r101, long r102) {
        this.imp.sendAudioPacket(r100, r101, r102);
    }

    @Override // com.byted.cast.mediacommon.render.IMediaRender
    public void sendVideoPacket(int r100, byte[] r101, long r102) {
        this.imp.sendVideoPacket(r100, r101, r102);
    }
}
