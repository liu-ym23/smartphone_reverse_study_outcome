package com.byted.cast.common.bean;

import com.alibaba.gaiax.template.animation.GXPropAnimationSet;
import com.byted.cast.common.source.ServiceInfo;
import com.google.gson.annotations.SerializedName;
import com.ss.android.vesdk.VERecordData;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes39.dex */
public class MediaInfo {

    @SerializedName("danmaku")
    private DanmakuBean danmaku;

    @SerializedName("dramaBeans")
    private List<DramaBean> dramaBeans;

    @SerializedName("dramaId")
    private String dramaId;
    public HashMap<String, String> extraParam;

    @SerializedName(GXPropAnimationSet.GXPropLoopMode.KEY_LOOP_MODE)
    private int loopMode;

    @SerializedName("resolution")
    private String resolution;

    @SerializedName("resolutionMode")
    private int resolutionMode;
    public ServiceInfo serviceInfo;

    @SerializedName("shuffle")
    private int shuffle;

    @SerializedName("skip")
    private int skip;

    @SerializedName("speed")
    private float speed;

    @SerializedName(VERecordData.SPEEDS)
    private List<Float> speeds;

    @SerializedName("stretch")
    private int stretch;

    @SerializedName("subtitle")
    private Subtitle subtitle;

    @SerializedName("vid")
    private String vid;

    public String toString() {
        return "MediaInfo{vid=" + this.vid + ", dramaId='" + this.dramaId + "', loopMode='" + this.loopMode + "', shuffle='" + this.shuffle + "', speed='" + this.speed + "', danmaku='" + this.danmaku + "', resolution='" + this.resolution + "', stretch='" + this.stretch + "', dramaBeans=" + this.dramaBeans + ", skip=" + this.skip + ", speeds=" + this.speeds + ", subtitle=" + this.subtitle + ", serviceInfo=" + this.serviceInfo + ", extraParam=" + this.extraParam + ", resolutionMode=" + this.resolutionMode + '}';
    }

    public MediaInfo() {
        this.speed = 1.0f;
    }

    public DanmakuBean getDanmaku() {
        return this.danmaku;
    }

    public List<DramaBean> getDramaBeans() {
        return this.dramaBeans;
    }

    public String getDramaId() {
        return this.dramaId;
    }

    public HashMap<String, String> getExtraParam() {
        return this.extraParam;
    }

    public int getLoopMode() {
        return this.loopMode;
    }

    public String getResolution() {
        return this.resolution;
    }

    public int getResolutionMode() {
        return this.resolutionMode;
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

    public List<Float> getSpeeds() {
        return this.speeds;
    }

    public int getStretch() {
        return this.stretch;
    }

    public Subtitle getSubtitle() {
        return this.subtitle;
    }

    public String getVid() {
        return this.vid;
    }

    public void setDanmaku(DanmakuBean r100) {
        this.danmaku = r100;
    }

    public void setDramaBeans(List<DramaBean> r100) {
        this.dramaBeans = r100;
    }

    public void setDramaId(String r100) {
        this.dramaId = r100;
    }

    public void setExtraParam(HashMap<String, String> r100) {
        this.extraParam = r100;
    }

    public void setLoopMode(int r100) {
        this.loopMode = r100;
    }

    public void setResolution(String r100) {
        this.resolution = r100;
    }

    public void setResolutionMode(int r100) {
        this.resolutionMode = r100;
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

    public void setSpeeds(List<Float> r100) {
        this.speeds = r100;
    }

    public void setStretch(int r100) {
        this.stretch = r100;
    }

    public void setSubtitle(Subtitle r100) {
        this.subtitle = r100;
    }

    public void setVid(String r100) {
        this.vid = r100;
    }
}
