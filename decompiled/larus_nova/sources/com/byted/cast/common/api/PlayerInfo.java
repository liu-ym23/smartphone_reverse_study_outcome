package com.byted.cast.common.api;

import com.byted.cast.common.bean.DanmakuBean;
import com.byted.cast.common.bean.DramaBean;
import com.byted.cast.common.bean.MediaAssetBean;
import com.byted.cast.common.source.ServiceInfo;
import java.util.List;

/* JADX INFO: loaded from: classes39.dex */
public class PlayerInfo {
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
    public static final int MEDIA_TYPE_ARTICLE = 3;
    public static final int MEDIA_TYPE_AUDIO = 1;
    public static final int MEDIA_TYPE_IMAGE = 2;
    public static final int MEDIA_TYPE_MIRROR = 4;
    public static final int MEDIA_TYPE_VIDEO = 0;
    public static final int RESOLUTION_AUTO = 3;
    public static final int RESOLUTION_HIGH = 1;
    public static final int RESOLUTION_HIGH_2K = 4;
    public static final int RESOLUTION_HIGH_4K = 5;
    public static final int RESOLUTION_MIDDLE = 2;
    public static final int VIDEO_SOURCE_TYPE_CAMERA = 1;
    public static final int VIDEO_SOURCE_TYPE_EXTERNAL_SURFACE = 2;
    public static final int VIDEO_SOURCE_TYPE_SCREEN = 0;
    private String aesIV;
    private String aesKey;
    private boolean audioEnable;
    private int audioSrc;
    private int bitRateLevel;
    private int bitrate;
    private int cameraId;
    private int codecId;
    private boolean customAudioEnable;
    private DanmakuBean danmaku;
    private List<DramaBean> dramaBeans;
    private String extra;
    private boolean fakePlay;
    private int featureConfig;
    private int fps;
    private String header;
    private int inheritConfig;
    private boolean isAutoBitrate;
    private boolean isRedirectUrl;
    private String localPath;
    private int loopMode;
    private MediaAssetBean mediaAssetBean;
    private boolean mute;
    private int resolutionLevel;
    private String screenCode;
    private int serverMode;
    private int serverType;
    private ServiceInfo serviceInfo;
    private int shuffle;
    private int skip;
    private float speed;
    private String startDramaId;
    private long startPosition;
    private int stretch;
    private int tag;
    private int type;
    private String url;
    private boolean useBdLedService;
    private boolean useCustomizedService;
    private int videoSrc;

    public String toString() {
        return "PlayerInfo{url='" + this.url + "', dramaBeans='" + this.dramaBeans + "', localPath='" + this.localPath + "', mediaAssetBean=" + this.mediaAssetBean + ", serviceInfo=" + this.serviceInfo + ", type=" + this.type + ", startPosition=" + this.startPosition + ", speed=" + this.speed + ", header='" + this.header + "', aesKey='" + this.aesKey + "', aesIV='" + this.aesIV + "', tag=" + this.tag + ", startDramaId='" + this.startDramaId + "', resolutionLevel=" + this.resolutionLevel + ", bitRateLevel=" + this.bitRateLevel + ", audioEnable=" + this.audioEnable + ", audioSrc=" + this.audioSrc + ", videoSrc=" + this.videoSrc + ", cameraId=" + this.cameraId + ", isAutoBitrate=" + this.isAutoBitrate + ", screenCode='" + this.screenCode + "', customAudioEnable=" + this.customAudioEnable + ", fps=" + this.fps + ", serverType=" + this.serverType + ", serverMode=" + this.serverMode + ", extra=" + this.extra + ", danmaku=" + this.danmaku + ", useCustomizedService=" + this.useCustomizedService + ", useBdLedService=" + this.useBdLedService + ", isRedirectUrl=" + this.isRedirectUrl + ", loopMode=" + this.loopMode + ", shuffle=" + this.shuffle + ", stretch=" + this.stretch + ", mute=" + this.mute + ", skip=" + this.skip + ", inheritConfig=" + this.inheritConfig + ", fakePlay=" + this.fakePlay + ", featureConfig=" + this.featureConfig + '}';
    }

    public PlayerInfo() {
        this.speed = 1.0f;
        this.resolutionLevel = -1;
        this.bitRateLevel = -1;
        this.audioEnable = true;
        this.audioSrc = 1;
        this.videoSrc = 0;
        this.cameraId = 0;
        this.fps = 30;
        this.serverType = 0;
        this.serverMode = 0;
        this.bitrate = -1;
        this.codecId = 0;
    }

    public String getAesIV() {
        return this.aesIV;
    }

    public String getAesKey() {
        return this.aesKey;
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

    public int getCodecId() {
        return this.codecId;
    }

    public DanmakuBean getDanmaku() {
        return this.danmaku;
    }

    public List<DramaBean> getDramaBeans() {
        return this.dramaBeans;
    }

    public String getExtra() {
        return this.extra;
    }

    public int getFeatureConfig() {
        return this.featureConfig;
    }

    public int getFps() {
        return this.fps;
    }

    public String getHeader() {
        return this.header;
    }

    public int getInheritConfig() {
        return this.inheritConfig;
    }

    public String getLocalPath() {
        return this.localPath;
    }

    public int getLoopMode() {
        return this.loopMode;
    }

    public MediaAssetBean getMetaDataBean() {
        return this.mediaAssetBean;
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

    public int getShuffle() {
        return this.shuffle;
    }

    public int getSkip() {
        return this.skip;
    }

    public float getSpeed() {
        return this.speed;
    }

    public String getStartDramaId() {
        return this.startDramaId;
    }

    public long getStartPosition() {
        return this.startPosition;
    }

    public int getStretch() {
        return this.stretch;
    }

    public int getTag() {
        return this.tag;
    }

    public int getType() {
        return this.type;
    }

    public String getUrl() {
        return this.url;
    }

    public int getVideoSrc() {
        return this.videoSrc;
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

    public boolean isFakePlay() {
        return this.fakePlay;
    }

    public boolean isMute() {
        return this.mute;
    }

    public boolean isRedirectUrl() {
        return this.isRedirectUrl;
    }

    public boolean isUseBdLedService() {
        return this.useBdLedService;
    }

    public boolean isUseCustomizedService() {
        return this.useCustomizedService;
    }

    public void setAesIV(String r100) {
        this.aesIV = r100;
    }

    public void setAesKey(String r100) {
        this.aesKey = r100;
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

    public void setCodecId(int r100) {
        this.codecId = r100;
    }

    public void setCustomAudioEnable(boolean r100) {
        this.customAudioEnable = r100;
    }

    public void setDanmaku(DanmakuBean r100) {
        this.danmaku = r100;
    }

    public void setDramaBeans(List<DramaBean> r100) {
        this.dramaBeans = r100;
    }

    public void setExtra(String r100) {
        this.extra = r100;
    }

    public void setFakePlay(boolean r100) {
        this.fakePlay = r100;
    }

    public void setFeatureConfig(int r100) {
        this.featureConfig = r100;
    }

    public void setFps(int r100) {
        this.fps = r100;
    }

    public void setHeader(String r100) {
        this.header = r100;
    }

    public void setInheritConfig(int r100) {
        this.inheritConfig = r100;
    }

    public void setLocalPath(String r100) {
        this.localPath = r100;
    }

    public void setLoopMode(int r100) {
        this.loopMode = r100;
    }

    public void setMetaDataBean(MediaAssetBean r100) {
        this.mediaAssetBean = r100;
    }

    public void setMute(boolean r100) {
        this.mute = r100;
    }

    public void setRedirectUrl(boolean r100) {
        this.isRedirectUrl = r100;
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

    public void setShuffle(int r100) {
        this.shuffle = r100;
    }

    public void setSkip(int r100) {
        this.skip = r100;
    }

    public void setSpeed(float r100) {
        this.speed = r100;
    }

    public void setStartDramaId(String r100) {
        this.startDramaId = r100;
    }

    public void setStretch(int r100) {
        this.stretch = r100;
    }

    public void setType(int r100) {
        this.type = r100;
    }

    public void setUrl(String r100) {
        this.url = r100;
    }

    public void setUseBdLedService(boolean r100) {
        this.useBdLedService = r100;
    }

    public void setUseCustomizedService(boolean r100) {
        this.useCustomizedService = r100;
    }

    public void setVideoSrc(int r100) {
        this.videoSrc = r100;
    }

    public void setStartPosition(long r100, int r101) {
        this.startPosition = r100;
        this.tag = r101;
    }
}
