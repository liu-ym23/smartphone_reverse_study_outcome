package com.byted.cast.common.api;

import com.byted.cast.common.source.ServiceInfo;

/* JADX INFO: loaded from: classes39.dex */
public class MirrorInfo {
    public static final int AUDIO_SOURCE_CAMERA = 2;
    public static final int AUDIO_SOURCE_MIC = 0;
    public static final int AUDIO_SOURCE_REMOTE_SUBMIX = 3;
    public static final int AUDIO_SOURCE_SYS = 1;
    public static final int BITRATE_HIGH = 4;
    public static final int BITRATE_LOW = 6;
    public static final int BITRATE_MIDDLE = 5;
    public static final int CAMERA_BACK = 1;
    public static final int CAMERA_FRONT = 0;
    public static final int CODEC_H264 = 0;
    public static final int CODEC_H265 = 1;
    public static final int CODEC_LOSSLESS = 2;
    public static final int RESOLUTION_AUTO = 3;
    public static final int RESOLUTION_HIGH = 1;
    public static final int RESOLUTION_HIGH_2K = 4;
    public static final int RESOLUTION_HIGH_4K = 5;
    public static final int RESOLUTION_MIDDLE = 2;
    public static final int VIDEO_SOURCE_TYPE_CAMERA = 1;
    public static final int VIDEO_SOURCE_TYPE_EXTERNAL_SURFACE = 2;
    public static final int VIDEO_SOURCE_TYPE_SCREEN = 0;
    private boolean audioEnable;
    private int audioSrc;
    private int bitRateLevel;
    private int bitrate;
    private int cameraId;
    private int captureAudioWay;
    private int codecId;
    private boolean customAudioEnable;
    private boolean enableAudioMix;
    private boolean enableEncodeSizeToScreen;
    private boolean enableSetMaxFps;
    private int encodeHeight;
    private int encodeWidth;
    private int fps;
    private String httpServerRoot;
    private boolean isAutoBitrate;
    private int resolutionLevel;
    private String screenCode;
    private int serverMode;
    private int serverType;
    private ServiceInfo serviceInfo;
    private int videoSrc;
    private int videoTransportType;
    private int virtualDisplayFlag;
    private int virtualDisplayHeight;
    private String virtualDisplayName;
    private int virtualDisplayWidth;

    public String toString() {
        return "PlayerInfo{, serviceInfo=" + this.serviceInfo + ", resolutionLevel=" + this.resolutionLevel + ", bitRateLevel=" + this.bitRateLevel + ", audioEnable=" + this.audioEnable + ", audioSrc=" + this.audioSrc + ", videoSrc=" + this.videoSrc + ", cameraId=" + this.cameraId + ", isAutoBitrate=" + this.isAutoBitrate + ", screenCode='" + this.screenCode + "', customAudioEnable=" + this.customAudioEnable + ", fps=" + this.fps + ", serverType=" + this.serverType + ", serverMode=" + this.serverMode + ", virtualDisplayName=" + this.virtualDisplayName + ", virtualDisplayFlag=" + this.virtualDisplayFlag + ", virtualDisplayWidth=" + this.virtualDisplayWidth + ", virtualDisplayHeight=" + this.virtualDisplayHeight + '}';
    }

    public MirrorInfo() {
        this.resolutionLevel = -1;
        this.bitRateLevel = -1;
        this.audioEnable = true;
        this.audioSrc = 1;
        this.videoSrc = 0;
        this.cameraId = 0;
        this.fps = 30;
        this.serverType = 0;
        this.serverMode = 0;
        this.virtualDisplayName = "";
        this.virtualDisplayFlag = -1;
        this.virtualDisplayWidth = -1;
        this.virtualDisplayHeight = -1;
        this.enableEncodeSizeToScreen = false;
        this.enableSetMaxFps = true;
        this.videoTransportType = -1;
        this.encodeWidth = -1;
        this.encodeHeight = -1;
        this.httpServerRoot = "";
        this.captureAudioWay = 0;
        this.bitrate = -1;
        this.codecId = 0;
        this.enableAudioMix = false;
    }

    public int getAudioSource() {
        return this.audioSrc;
    }

    public int getBitRateLevel() {
        return this.bitRateLevel;
    }

    public int getBitrate() {
        return this.bitrate;
    }

    public int getCameraId() {
        return this.cameraId;
    }

    public int getCaptureAudioWay() {
        return this.captureAudioWay;
    }

    public int getCodecId() {
        return this.codecId;
    }

    public int getEncodeHeight() {
        return this.encodeHeight;
    }

    public int getEncodeWidth() {
        return this.encodeWidth;
    }

    public int getFps() {
        return this.fps;
    }

    public String getHttpServerRoot() {
        return this.httpServerRoot;
    }

    public int getResolutionLevel() {
        return this.resolutionLevel;
    }

    public String getScreenCode() {
        return this.screenCode;
    }

    public int getServerMode() {
        return this.serverMode;
    }

    public int getServerType() {
        return this.serverType;
    }

    public ServiceInfo getServiceInfo() {
        return this.serviceInfo;
    }

    public int getVideoSrc() {
        return this.videoSrc;
    }

    public int getVideoTransportType() {
        return this.videoTransportType;
    }

    public int getVirtualDisplayFlag() {
        return this.virtualDisplayFlag;
    }

    public int getVirtualDisplayHeight() {
        return this.virtualDisplayHeight;
    }

    public String getVirtualDisplayName() {
        return this.virtualDisplayName;
    }

    public int getVirtualDisplayWidth() {
        return this.virtualDisplayWidth;
    }

    public boolean isAudioEnable() {
        return this.audioEnable;
    }

    public boolean isAutoBitrate() {
        return this.isAutoBitrate;
    }

    public boolean isCustomAudioEnable() {
        return this.customAudioEnable;
    }

    public boolean isEnableAudioMix() {
        return this.enableAudioMix;
    }

    public boolean isEnableSetMaxFps() {
        return this.enableSetMaxFps;
    }

    public boolean isEncodeSizeToScreen() {
        return this.enableEncodeSizeToScreen;
    }

    public void enableAudioMix(boolean r100) {
        this.enableAudioMix = r100;
    }

    public void enableEncodeSizeToScreen(boolean r100) {
        this.enableEncodeSizeToScreen = r100;
    }

    public void enableSetMaxFps(boolean r100) {
        this.enableSetMaxFps = r100;
    }

    public void setAudioEnable(boolean r100) {
        this.audioEnable = r100;
    }

    public void setAudioSource(int r100) {
        this.audioSrc = r100;
    }

    public void setAutoBitrate(boolean r100) {
        this.isAutoBitrate = r100;
    }

    public void setBitRateLevel(int r100) {
        this.bitRateLevel = r100;
    }

    public void setBitrate(int r100) {
        this.bitrate = r100;
    }

    public void setCameraId(int r100) {
        this.cameraId = r100;
    }

    public void setCaptureAudioWay(int r100) {
        this.captureAudioWay = r100;
    }

    public void setCodecId(int r100) {
        this.codecId = r100;
    }

    public void setCustomAudioEnable(boolean r100) {
        this.customAudioEnable = r100;
    }

    public void setEncodeHeight(int r100) {
        this.encodeHeight = r100;
    }

    public void setEncodeWidth(int r100) {
        this.encodeWidth = r100;
    }

    public void setFps(int r100) {
        this.fps = r100;
    }

    public void setHttpServerRoot(String r100) {
        this.httpServerRoot = r100;
    }

    public void setResolutionLevel(int r100) {
        this.resolutionLevel = r100;
    }

    public void setScreenCode(String r100) {
        this.screenCode = r100;
    }

    public void setServerMode(int r100) {
        this.serverMode = r100;
    }

    public void setServerType(int r100) {
        this.serverType = r100;
    }

    public void setServiceInfo(ServiceInfo r100) {
        this.serviceInfo = r100;
    }

    public void setVideoSrc(int r100) {
        this.videoSrc = r100;
    }

    public void setVideoTransportType(int r100) {
        this.videoTransportType = r100;
    }

    public void setVirtualDisplayFlag(int r100) {
        this.virtualDisplayFlag = r100;
    }

    public void setVirtualDisplayHeight(int r100) {
        this.virtualDisplayHeight = r100;
    }

    public void setVirtualDisplayName(String r100) {
        this.virtualDisplayName = r100;
    }

    public void setVirtualDisplayWidth(int r100) {
        this.virtualDisplayWidth = r100;
    }
}
