package com.byted.cast.mediacommon.render;

import android.view.Surface;
import com.byted.cast.mediacommon.render.parameters.AudioParameter;
import com.byted.cast.mediacommon.render.parameters.MediaParameter;
import com.byted.cast.mediacommon.render.parameters.VideoParameter;

/* JADX INFO: loaded from: classes39.dex */
public interface IMediaRender {

    /* JADX INFO: renamed from: com.byted.cast.mediacommon.render.IMediaRender$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static MediaRenderState $default$getAudioState(IMediaRender r100, int r101) {
            return null;
        }

        public static Object $default$getParameter(IMediaRender r100, MediaParameter r101) {
            return null;
        }

        public static MediaRenderState $default$getVideoState(IMediaRender r100, int r101) {
            return null;
        }

        public static void $default$init(IMediaRender r100, String r101) {
        }

        public static void $default$sendAVStream(IMediaRender r100, byte[] r101) {
        }

        public static void $default$sendAudioPacket(IMediaRender r100, int r101, byte[] r102, long r103) {
        }

        public static void $default$sendVideoPacket(IMediaRender r100, int r101, byte[] r102, long r103) {
        }

        public static void $default$setAudioFrameListener(IMediaRender r100, IAudioFrameListener r101) {
        }

        public static void $default$setAudioParameter(IMediaRender r100, int r101, AudioParameter r102) {
        }

        public static void $default$setParameter(IMediaRender r100, MediaParameter r101, Object r102) {
        }

        public static void $default$setSurface(IMediaRender r100, int r101, Surface r102) {
        }

        public static void $default$setVideoFrameListener(IMediaRender r100, IVideoFrameListener r101) {
        }

        public static void $default$setVideoParameter(IMediaRender r100, int r101, VideoParameter r102) {
        }

        public static boolean $default$startAudioPlayer(IMediaRender r100, int r101) {
            return false;
        }

        public static void $default$startUrl(IMediaRender r100, int r101, String r102) {
        }

        public static boolean $default$startVideoPlayer(IMediaRender r100, int r101) {
            return false;
        }

        public static boolean $default$stopAudioPlayer(IMediaRender r100, int r101) {
            return false;
        }

        public static void $default$stopUrl(IMediaRender r100) {
        }

        public static boolean $default$stopVideoPlayer(IMediaRender r100, int r101) {
            return false;
        }
    }

    MediaRenderState getAudioState(int r100);

    Object getParameter(MediaParameter r100);

    MediaRenderState getVideoState(int r100);

    void init(String r100);

    void sendAVStream(byte[] r100);

    void sendAudioPacket(int r100, byte[] r101, long r102);

    void sendVideoPacket(int r100, byte[] r101, long r102);

    void setAudioFrameListener(IAudioFrameListener r100);

    void setAudioParameter(int r100, AudioParameter r101);

    void setParameter(MediaParameter r100, Object r101);

    void setSurface(int r100, Surface r101);

    void setVideoFrameListener(IVideoFrameListener r100);

    void setVideoParameter(int r100, VideoParameter r101);

    boolean startAudioPlayer(int r100);

    void startUrl(int r100, String r101);

    boolean startVideoPlayer(int r100);

    boolean stopAudioPlayer(int r100);

    void stopUrl();

    boolean stopVideoPlayer(int r100);
}
