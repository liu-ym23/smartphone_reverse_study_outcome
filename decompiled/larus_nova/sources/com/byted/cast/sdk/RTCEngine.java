package com.byted.cast.sdk;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.media.projection.MediaProjection;
import android.opengl.GLSurfaceView;
import android.os.Build;
import android.view.Surface;
import com.byted.cast.common.ContextManager;
import com.byted.cast.common.Logger;
import com.byted.cast.common.api.IAudioDataListener;
import com.byted.cast.common.api.ILibraryLoader;
import com.byted.cast.common.api.ILogger;
import com.byted.cast.common.api.ISinkDataListener;
import com.byted.cast.common.api.ISurfaceListener;
import com.byted.cast.common.bean.State;
import com.byted.cast.engine.VoipEngine;
import com.byted.cast.mediacommon.IMediaRecorder;
import com.byted.cast.mediacommon.MediaSetting;
import com.byted.cast.sdk.core.RTCEngineImpl;
import com.byted.cast.sdk.utils.Utils;
import java.util.TimeZone;
import r27.a;

/* JADX INFO: loaded from: classes43.dex */
public abstract class RTCEngine {
    public static final int INFO_SET_BITRATE_KPS = 400003;
    static boolean isSource;

    public static final enum ConnectState extends Enum<ConnectState> {
        private static final /* synthetic */ ConnectState[] $VALUES = null;
        public static final ConnectState CLOSE = null;
        public static final ConnectState CONNECTED = null;
        public static final ConnectState CONNECTING = null;
        public static final ConnectState CONNECT_FAILED = null;
        public static final ConnectState DISCONNECTED = null;
        public static final ConnectState ERROR = null;
        public static final ConnectState RECONNECTED = null;
        public static final ConnectState RECONNECTING = null;
        public static final ConnectState RECONNECT_FAILED = null;

        static {
            ConnectState r100 = new ConnectState("CLOSE", 0);
            CLOSE = r100;
            ConnectState r101 = new ConnectState("CONNECTING", 1);
            CONNECTING = r101;
            ConnectState r102 = new ConnectState("CONNECTED", 2);
            CONNECTED = r102;
            ConnectState r103 = new ConnectState("CONNECT_FAILED", 3);
            CONNECT_FAILED = r103;
            ConnectState r104 = new ConnectState(State.DISCONNECTED, 4);
            DISCONNECTED = r104;
            ConnectState r105 = new ConnectState("RECONNECTING", 5);
            RECONNECTING = r105;
            ConnectState r110 = new ConnectState("RECONNECTED", 6);
            RECONNECTED = r110;
            ConnectState r111 = new ConnectState("RECONNECT_FAILED", 7);
            RECONNECT_FAILED = r111;
            ConnectState r112 = new ConnectState("ERROR", 8);
            ERROR = r112;
            $VALUES = new ConnectState[]{r100, r101, r102, r103, r104, r105, r110, r111, r112};
        }

        public static ConnectState[] values() {
            return (ConnectState[]) $VALUES.clone();
        }

        public static ConnectState valueOf(String r100) {
            return (ConnectState) a.a(ConnectState.class, r100);
        }

        private ConnectState(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final enum ExitReason extends Enum<ExitReason> {
        private static final /* synthetic */ ExitReason[] $VALUES = null;
        public static final ExitReason REASON_DISCONNECT = null;
        public static final ExitReason REASON_FATAL_ERROR = null;
        public static final ExitReason REASON_HEART_BEAT_ERROR = null;
        public static final ExitReason REASON_KICK_OUT = null;
        public static final ExitReason REASON_NETWORK_ERROR = null;
        public static final ExitReason REASON_RECEIVE_SIGNAL_FAILED = null;
        public static final ExitReason REASON_RECONNECT_FAILED = null;
        public static final ExitReason REASON_WIFI_DISCONNECTED = null;

        static {
            ExitReason r100 = new ExitReason("REASON_DISCONNECT", 0);
            REASON_DISCONNECT = r100;
            ExitReason r101 = new ExitReason("REASON_NETWORK_ERROR", 1);
            REASON_NETWORK_ERROR = r101;
            ExitReason r102 = new ExitReason("REASON_KICK_OUT", 2);
            REASON_KICK_OUT = r102;
            ExitReason r103 = new ExitReason("REASON_FATAL_ERROR", 3);
            REASON_FATAL_ERROR = r103;
            ExitReason r104 = new ExitReason("REASON_HEART_BEAT_ERROR", 4);
            REASON_HEART_BEAT_ERROR = r104;
            ExitReason r105 = new ExitReason("REASON_RECONNECT_FAILED", 5);
            REASON_RECONNECT_FAILED = r105;
            ExitReason r110 = new ExitReason("REASON_RECEIVE_SIGNAL_FAILED", 6);
            REASON_RECEIVE_SIGNAL_FAILED = r110;
            ExitReason r111 = new ExitReason("REASON_WIFI_DISCONNECTED", 7);
            REASON_WIFI_DISCONNECTED = r111;
            $VALUES = new ExitReason[]{r100, r101, r102, r103, r104, r105, r110, r111};
        }

        public static ExitReason[] values() {
            return (ExitReason[]) $VALUES.clone();
        }

        public static ExitReason valueOf(String r100) {
            return (ExitReason) a.a(ExitReason.class, r100);
        }

        private ExitReason(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final enum RuntimeEnv extends Enum<RuntimeEnv> {
        private static final /* synthetic */ RuntimeEnv[] $VALUES = null;
        public static final RuntimeEnv CUSTOM = null;
        public static final RuntimeEnv ONLINE = null;
        public static final RuntimeEnv TESTING = null;

        static {
            RuntimeEnv r100 = new RuntimeEnv("TESTING", 0);
            TESTING = r100;
            RuntimeEnv r101 = new RuntimeEnv("ONLINE", 1);
            ONLINE = r101;
            RuntimeEnv r102 = new RuntimeEnv("CUSTOM", 2);
            CUSTOM = r102;
            $VALUES = new RuntimeEnv[]{r100, r101, r102};
        }

        public static RuntimeEnv[] values() {
            return (RuntimeEnv[]) $VALUES.clone();
        }

        public static RuntimeEnv valueOf(String r100) {
            return (RuntimeEnv) a.a(RuntimeEnv.class, r100);
        }

        private RuntimeEnv(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final enum VideoFormat extends Enum<VideoFormat> {
        private static final /* synthetic */ VideoFormat[] $VALUES = null;
        public static final VideoFormat VIDEO_FORMAT_ABGR = null;
        public static final VideoFormat VIDEO_FORMAT_ARGB = null;
        public static final VideoFormat VIDEO_FORMAT_BGR24 = null;
        public static final VideoFormat VIDEO_FORMAT_BGRA = null;
        public static final VideoFormat VIDEO_FORMAT_ES_H264 = null;
        public static final VideoFormat VIDEO_FORMAT_ES_H265 = null;
        public static final VideoFormat VIDEO_FORMAT_I420 = null;
        public static final VideoFormat VIDEO_FORMAT_NV12 = null;
        public static final VideoFormat VIDEO_FORMAT_NV21 = null;
        public static final VideoFormat VIDEO_FORMAT_RGB24 = null;
        public static final VideoFormat VIDEO_FORMAT_RGB565 = null;
        public static final VideoFormat VIDEO_FORMAT_RGBA = null;
        public static final VideoFormat VIDEO_FORMAT_YUV422P = null;
        public static final VideoFormat VIDEO_FORMAT_YUYV422 = null;
        public static final VideoFormat VIDEO_FORMAT_YVYU422 = null;

        static {
            VideoFormat r100 = new VideoFormat("VIDEO_FORMAT_NV12", 0);
            VIDEO_FORMAT_NV12 = r100;
            VideoFormat r101 = new VideoFormat("VIDEO_FORMAT_NV21", 1);
            VIDEO_FORMAT_NV21 = r101;
            VideoFormat r102 = new VideoFormat("VIDEO_FORMAT_I420", 2);
            VIDEO_FORMAT_I420 = r102;
            VideoFormat r103 = new VideoFormat("VIDEO_FORMAT_YUYV422", 3);
            VIDEO_FORMAT_YUYV422 = r103;
            VideoFormat r104 = new VideoFormat("VIDEO_FORMAT_YVYU422", 4);
            VIDEO_FORMAT_YVYU422 = r104;
            VideoFormat r105 = new VideoFormat("VIDEO_FORMAT_YUV422P", 5);
            VIDEO_FORMAT_YUV422P = r105;
            VideoFormat r110 = new VideoFormat("VIDEO_FORMAT_RGB565", 6);
            VIDEO_FORMAT_RGB565 = r110;
            VideoFormat r111 = new VideoFormat("VIDEO_FORMAT_RGB24", 7);
            VIDEO_FORMAT_RGB24 = r111;
            VideoFormat r112 = new VideoFormat("VIDEO_FORMAT_BGR24", 8);
            VIDEO_FORMAT_BGR24 = r112;
            VideoFormat r113 = new VideoFormat("VIDEO_FORMAT_ARGB", 9);
            VIDEO_FORMAT_ARGB = r113;
            VideoFormat r114 = new VideoFormat("VIDEO_FORMAT_RGBA", 10);
            VIDEO_FORMAT_RGBA = r114;
            VideoFormat r115 = new VideoFormat("VIDEO_FORMAT_ABGR", 11);
            VIDEO_FORMAT_ABGR = r115;
            VideoFormat r106 = new VideoFormat("VIDEO_FORMAT_BGRA", 12);
            VIDEO_FORMAT_BGRA = r106;
            VideoFormat r107 = new VideoFormat("VIDEO_FORMAT_ES_H264", 13);
            VIDEO_FORMAT_ES_H264 = r107;
            VideoFormat r108 = new VideoFormat("VIDEO_FORMAT_ES_H265", 14);
            VIDEO_FORMAT_ES_H265 = r108;
            $VALUES = new VideoFormat[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108};
        }

        public static VideoFormat[] values() {
            return (VideoFormat[]) $VALUES.clone();
        }

        public static VideoFormat valueOf(String r100) {
            return (VideoFormat) a.a(VideoFormat.class, r100);
        }

        private VideoFormat(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static String version() {
        return "7.30.1.12";
    }

    public abstract void castCancel();

    public abstract void castRequest();

    public abstract void changeSurfaceFillType(int r100);

    public abstract void connect(String r100, int r101, String r102, String r103);

    public abstract void decodeInput(String r100, long r101);

    public abstract void decodeOutput(String r100, long r101);

    public abstract void destroy();

    public abstract void disconnect();

    public abstract void dumpMediaData(int r100, int r101);

    public abstract void enableSetMaxFps(boolean r100);

    public abstract int getAudioSessionId(String r100);

    public abstract RTCStatistics getStatistics();

    public abstract boolean inputExternalAudioFrame(byte[] r100, int r101);

    public abstract boolean inputExternalScreenFrame(byte[] r100, int r101, int r102, MediaSetting.VideoFormat r103, int r104);

    public abstract boolean inputExternalVideoFrame(byte[] r100, int r101, int r102, MediaSetting.VideoFormat r103, int r104);

    public abstract void kickOutSource(String r100);

    public abstract void onScreenRecordRequestResult(int r100, int r101, Intent r102);

    public abstract void prepareVideoEncoder();

    public abstract void reinit(Context r100, RTCSetting r101, GLSurfaceView r102, IRTCEngineEventListener r103, boolean r104);

    public abstract void removePreviewSurface(Surface r100);

    public abstract void render(String r100, long r101);

    public abstract void requestIDR();

    public abstract void requestIdrFromSource(String r100);

    public abstract void requestScreenRecord(Activity r100, int r101);

    public abstract void sendData(int r100, byte[] r101, long r102, long r103, long r104, long r105);

    public abstract void sendMetaData(String r100);

    public abstract void sendMetaData(String r100, String r101);

    public abstract void setApplication(Application r100);

    public abstract void setAudioDataListener(Boolean r100, IAudioDataListener r101);

    public abstract void setAudioDropPolicyByMs(int r100, int r101);

    public abstract void setAudioEnable(boolean r100);

    public abstract void setAudioMaxDelayByMs(int r100);

    public abstract void setAudioMix(Boolean r100);

    public abstract void setAudioMixScale(int r100);

    public abstract void setAudioProfile(RTCAudioProfile r100);

    public abstract void setAudioVolume(float r100, float r101);

    public abstract void setCallbackToMirror(boolean r100);

    public abstract void setCaptureSource(RTCSetting.VIDEO_SOURCE_TYPE r100);

    public abstract void setCastControl(int r100, int r101);

    public abstract void setCastToken(String r100);

    public abstract void setEncoderWH(int r100, int r101, boolean r102);

    public abstract void setFlashEnable(boolean r100);

    public abstract void setInputPreviewSurface(Surface r100);

    public abstract void setInputSurfaceListener(ISurfaceListener r100);

    public abstract void setJitterMode(int r100);

    public abstract void setMediaProjection(MediaProjection r100);

    public abstract void setPinCode(String r100);

    public abstract void setPlayerVolume(String r100, float r101);

    public abstract void setRandomPortEnabled(boolean r100);

    public abstract void setRecorderNeedResize(boolean r100);

    public abstract void setRestartCapture();

    public abstract void setScreenProfile(RTCScreenProfile r100);

    public abstract void setSendPause(boolean r100);

    public abstract void setSinkDataListener(Boolean r100, Boolean r101, ISinkDataListener r102);

    public abstract void setSinkFeatures(int r100);

    public abstract void setTransType(RTCSetting.TRANS_TYPE r100, RTCSetting.TRANS_TYPE r101);

    public abstract void setVideoCodecID(RTCSetting.VCODEC_ID r100);

    public abstract void setVideoProfile(RTCVideoProfile r100);

    public abstract void setVideoQP(RTCScreenProfile r100, boolean r101);

    public abstract void setVideoQP(RTCVideoProfile r100, boolean r101);

    public abstract void setVideoSourceType(RTCSetting.VIDEO_SOURCE_TYPE r100);

    public abstract void setVideoSurface(String r100, Surface r101);

    public abstract void setVirtualDisplayFlag(int r100);

    public abstract void setVirtualDisplayName(String r100);

    public abstract void setVirtualDisplayWH(int r100, int r101);

    public abstract int sinkInitAndJoinRoom(String r100, String r101, String r102, String r103);

    public abstract int sourceInitAndJoinRoom(String r100, String r101, String r102, String r103);

    public abstract void startScreenRecord();

    public abstract void stopScreenRecord();

    public abstract void switchCamera(String r100);

    public RTCEngine() {
    }

    public static void deinit(ContextManager.CastContext r100) {
        VoipEngine.deinitialize(r100);
    }

    public static ExitReason valueOf(int r100) {
        switch(r100) {
            case 0: goto L20;
            case 1: goto L18;
            case 2: goto L16;
            case 3: goto L14;
            case 4: goto L12;
            case 5: goto L10;
            case 6: goto L8;
            case 7: goto L6;
            default: goto L4;
        };
    L4:
        return ExitReason.REASON_FATAL_ERROR;
    L6:
        return ExitReason.REASON_WIFI_DISCONNECTED;
    L8:
        return ExitReason.REASON_RECEIVE_SIGNAL_FAILED;
    L10:
        return ExitReason.REASON_RECONNECT_FAILED;
    L12:
        return ExitReason.REASON_HEART_BEAT_ERROR;
    L14:
        return ExitReason.REASON_FATAL_ERROR;
    L16:
        return ExitReason.REASON_KICK_OUT;
    L18:
        return ExitReason.REASON_NETWORK_ERROR;
    L20:
        return ExitReason.REASON_DISCONNECT;
    }

    public static void setFileLogEnabled(ContextManager.CastContext r100, boolean r101) {
        VoipEngine.setFileLogEnabled(r100, r101);
    }

    public static void setLibraryLoader(ContextManager.CastContext r100, ILibraryLoader r101) {
        VoipEngine.setLibraryLoader(r100, r101);
    }

    public static boolean setLogLevel(ContextManager.CastContext r100, int r101) {
        Logger.setLogLevel(r101);
        ContextManager.getLogger(r100).setLogLevel(r101);
        com.byted.cast.sdk.utils.Logger.setLogLevel(r101);
        if (isSource == false) goto L6;
        IMediaRecorder.CC.setLogLevel(r101);
    L6:
        return VoipEngine.setLogLevel(r100, r101);
    }

    public static void setLogger(ContextManager.CastContext r100, ILogger r101) {
        Logger.setLogger(r101);
        com.byted.cast.sdk.utils.Logger.setLogger(r101);
        if (isSource == false) goto L5;
        IMediaRecorder.CC.setLogger(r101);
    L5:
        VoipEngine.setLogger(r100, r101);
    }

    public static void init(Context r100, ContextManager.CastContext r110, boolean r111) {
        isSource = r111;
        init(r100, r110, RuntimeEnv.ONLINE, "", 3230, Utils.getScreenSize(r100).x, Utils.getScreenSize(r100).y, 30, r111);
    }

    public static RTCEngine create(Context r100, ContextManager.CastContext r101, RTCSetting r102, IRTCEngineEventListener r110, boolean r111) {
        return new RTCEngineImpl(r100, r101, r102, r110, r111);
    }

    private static RTCEngine create(Context r100, ContextManager.CastContext r101, RTCSetting r110, GLSurfaceView r111, IRTCEngineEventListener r112, boolean r113) {
        return new RTCEngineImpl(r100, r101, r110, r111, r112, r113);
    }

    public static void init(Context r110, ContextManager.CastContext r111, RuntimeEnv r112, String r113, int r114, int r115, int r116, int r117, boolean r118) {
        init(r110, r111, r112, r113, r114, r115, r116, r117, r118, true);
    }

    public void sendData(int r100, byte[] r101, long r102, long r103, long r104, long r105, int r110, int r111, String r112) {
        sendData(r100, r101, r102, r103, r104, r105);
    }

    public static void init(Context r110, ContextManager.CastContext r111, RuntimeEnv r112, String r113, int r114, int r115, int r116, int r117, boolean r118, boolean r210) {
        init(r110, r111, r112, r113, r114, r115, r116, r117, r118, r210, false);
    }

    public static void init(Context r110, ContextManager.CastContext r111, RuntimeEnv r112, String r113, int r114, int r115, int r116, int r117, boolean r118, boolean r119, boolean r210) {
        VoipEngine.DeviceParams r100 = new VoipEngine.DeviceParams();
        r100.deviceId = Utils.getDeviceId(r110);
        r100.sdkVersion = "7.30.1.12";
        r100.f33723app = Utils.getAppName(r110);
        r100.appVersion = Utils.getAppVersion(r110);
        r100.appPackage = Utils.getPackageName(r110);
        r100.f33724os = "Android";
        r100.osVersion = Utils.osVersion();
        r100.deviceModel = Build.MODEL;
        r100.cpuType = Build.CPU_ABI;
        r100.timeZone = TimeZone.getDefault().getID();
        r100.width = r115;
        r100.height = r116;
        r100.fps = r117;
        VoipEngine.initialize(r110, r111, r112, r100, r113, "", r114, r118, r119, r210);
    }
}
