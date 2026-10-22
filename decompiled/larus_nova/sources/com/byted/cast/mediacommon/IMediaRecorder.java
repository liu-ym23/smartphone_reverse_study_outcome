package com.byted.cast.mediacommon;

import android.media.projection.MediaProjection;
import android.view.Surface;
import com.byted.cast.common.CastLogger;
import com.byted.cast.common.CastMonitor;
import com.byted.cast.common.api.ILogger;
import com.byted.cast.common.api.ISurfaceListener;
import com.byted.cast.mediacommon.utils.Logger;
import java.util.Objects;

/* JADX INFO: loaded from: classes39.dex */
public interface IMediaRecorder {

    /* JADX INFO: renamed from: com.byted.cast.mediacommon.IMediaRecorder$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$addMediaRecorderCallback(IMediaRecorder r100, IMediaRecorderCallback r101) {
        }

        public static void $default$addSurface(IMediaRecorder r100, Surface r101, MediaSetting.FILL_TYPE r102, boolean r103) {
        }

        public static void $default$changeSurfaceFillType(IMediaRecorder r100, MediaSetting.FILL_TYPE r101) {
        }

        public static void $default$enableAudioMix(IMediaRecorder r100, boolean r101) {
        }

        public static void $default$enableSetMaxFps(IMediaRecorder r100, boolean r101) {
        }

        public static Surface $default$getInputSurface(IMediaRecorder r100) {
            return null;
        }

        public static boolean $default$getPicture(IMediaRecorder r100, String r101) {
            return false;
        }

        public static void $default$insertFrame(IMediaRecorder r100) {
        }

        public static void $default$pause(IMediaRecorder r100) {
        }

        public static void $default$prepareVideoEncoder(IMediaRecorder r100) {
        }

        public static void $default$reStart(IMediaRecorder r100) {
        }

        public static void $default$release(IMediaRecorder r100) {
        }

        public static void $default$removeMediaRecorderCallback(IMediaRecorder r100, IMediaRecorderCallback r101) {
        }

        public static void $default$removeSurface(IMediaRecorder r100, Surface r101) {
        }

        public static void $default$requestIDR(IMediaRecorder r100) {
        }

        public static void $default$requestMediaRecord(IMediaRecorder r100) {
        }

        public static void $default$resume(IMediaRecorder r100) {
        }

        public static void $default$sendAudioFrame(IMediaRecorder r100, byte[] r101, int r102, int r103, int r104, int r105, long r106) {
        }

        public static void $default$sendVideoFrame(IMediaRecorder r100, byte[] r101, int r102, int r103, MediaSetting.VideoFormat r104, long r105) {
        }

        public static void $default$setAudioCert(IMediaRecorder r100, Object r101) {
        }

        public static void $default$setAudioEnable(IMediaRecorder r100, boolean r101) {
        }

        public static void $default$setAudioMixScale(IMediaRecorder r100, int r101) {
        }

        public static void $default$setAudioSource(IMediaRecorder r100, int r101) {
        }

        public static void $default$setAudioStopCert(IMediaRecorder r100, Object r101) {
        }

        public static void $default$setBitrateKps(IMediaRecorder r100, int r101) {
        }

        public static void $default$setCaptureSource(IMediaRecorder r100, MediaSetting.VIDEO_SOURCE_TYPE r101) {
        }

        public static void $default$setDisplay(IMediaRecorder r100, int r101, int r102, int r103, int r104) {
        }

        public static void $default$setFlashEnable(IMediaRecorder r100, boolean r101) {
        }

        public static void $default$setFps(IMediaRecorder r100, int r101) {
        }

        public static void $default$setInputSurfaceListener(IMediaRecorder r100, ISurfaceListener r101) {
        }

        public static void $default$setMediaProjection(IMediaRecorder r100, MediaProjection r101) {
        }

        public static void $default$setPreviewSurface(IMediaRecorder r100, Surface r101) {
        }

        public static void $default$setResizeScreen(IMediaRecorder r100, boolean r101) {
        }

        public static void $default$setSeparateAudio(IMediaRecorder r100, boolean r101) {
        }

        public static void $default$setVideoCodecID(IMediaRecorder r100, MediaSetting.VCODEC_ID r101) {
        }

        public static void $default$setVideoQP(IMediaRecorder r100, VideoProfile r101) {
        }

        public static void $default$setVirtualDisplayFlag(IMediaRecorder r100, int r101) {
        }

        public static void $default$setVirtualDisplayName(IMediaRecorder r100, String r101) {
        }

        public static void $default$setVirtualDisplayWH(IMediaRecorder r100, int r101, int r102) {
        }

        public static boolean $default$start(IMediaRecorder r100) {
            return true;
        }

        public static void $default$startSaveRecorder(IMediaRecorder r100, String r101) {
        }

        public static void $default$stop(IMediaRecorder r100) {
        }

        public static void $default$stopSaveRecorder(IMediaRecorder r100) {
        }

        public static void $default$switchCamera(IMediaRecorder r100, String r101) {
        }

        public static String getVersion() {
            return BuildConfig.VERSION_NAME;
        }

        public static void addLoggerCallback(CastLogger r100) {
            Logger.i("ByteMediaRecorder", "addLoggerCallback: " + r100);
            Logger.addLogger(r100);
        }

        public static void addMonitorCallback(CastMonitor r100) {
            Logger.i("ByteMediaRecorder", "addMonitorCallback: " + r100);
            MediaMonitor.addMonitor(r100);
        }

        public static void removeLoggerCallback(CastLogger r100) {
            Logger.i("ByteMediaRecorder", "removeLoggerCallback: " + r100);
            Logger.removeLogger(r100);
        }

        public static void removeMonitorCallback(CastMonitor r100) {
            Logger.i("ByteMediaRecorder", "removeMonitorCallback: " + r100);
            MediaMonitor.removeMonitor(r100);
        }

        public static void setLogLevel(int r100) {
            Logger.setLogLevel(r100);
        }

        public static void setLogger(ILogger r100) {
            Objects.toString(r100);
            Logger.setLogger(r100);
        }

        public static void $default$sendVideoFrame(IMediaRecorder r100, byte[] r101, int r102, int r103, MediaSetting.VideoFormat r104, long r105, String r106) {
            StringBuilder r107 = new StringBuilder("sendVideoFrame with sei: seiLen=");
            if (r106 != null) goto L5;
            int r108 = 0;
        L6:
            r107.append(r108);
            r107.append(" width=");
            r107.append(r102);
            r107.append(" height=");
            r107.append(r103);
            r107.append(" ts=");
            r107.append(r105);
            Logger.i("IMediaRecorder", r107.toString());
            r100.sendVideoFrame(r101, r102, r103, r104, r105);
            return;
        L5:
            r108 = r106.length();
            goto L6
        }
    }

    void addMediaRecorderCallback(IMediaRecorderCallback r100);

    void addSurface(Surface r100, MediaSetting.FILL_TYPE r101, boolean r102);

    void changeSurfaceFillType(MediaSetting.FILL_TYPE r100);

    void enableAudioMix(boolean r100);

    void enableSetMaxFps(boolean r100);

    Surface getInputSurface();

    boolean getPicture(String r100);

    void insertFrame();

    void pause();

    void prepareVideoEncoder();

    void reStart();

    void release();

    void removeMediaRecorderCallback(IMediaRecorderCallback r100);

    void removeSurface(Surface r100);

    void requestIDR();

    void requestMediaRecord();

    void resume();

    void sendAudioFrame(byte[] r100, int r101, int r102, int r103, int r104, long r105);

    void sendVideoFrame(byte[] r100, int r101, int r102, MediaSetting.VideoFormat r103, long r104);

    void sendVideoFrame(byte[] r100, int r101, int r102, MediaSetting.VideoFormat r103, long r104, String r105);

    void setAudioCert(Object r100);

    void setAudioEnable(boolean r100);

    void setAudioMixScale(int r100);

    void setAudioSource(int r100);

    void setAudioStopCert(Object r100);

    void setBitrateKps(int r100);

    void setCaptureSource(MediaSetting.VIDEO_SOURCE_TYPE r100);

    void setDisplay(int r100, int r101, int r102, int r103);

    void setFlashEnable(boolean r100);

    void setFps(int r100);

    void setInputSurfaceListener(ISurfaceListener r100);

    void setMediaProjection(MediaProjection r100);

    void setPreviewSurface(Surface r100);

    void setResizeScreen(boolean r100);

    void setSeparateAudio(boolean r100);

    void setVideoCodecID(MediaSetting.VCODEC_ID r100);

    void setVideoQP(VideoProfile r100);

    void setVirtualDisplayFlag(int r100);

    void setVirtualDisplayName(String r100);

    void setVirtualDisplayWH(int r100, int r101);

    boolean start();

    void startSaveRecorder(String r100);

    void stop();

    void stopSaveRecorder();

    void switchCamera(String r100);
}
