package com.bytedance.android.livesdkapi.model;

import android.text.TextUtils;
import com.google.gson.annotations.SerializedName;
import com.monitor.cloudmessage.consts.CloudControlInf;

/* JADX INFO: loaded from: classes12.dex */
public class SeiRegion {
    public static final int STATE_CONNECTION_LOST = 1;
    public static final int STATE_NORMAL = 0;
    public static final int TYPE_AUDIO = 2;
    public static final int TYPE_PLACEHOLDER = 0;
    public static final int TYPE_VIDEO = 1;

    @SerializedName("account")
    private String account;

    @SerializedName("alpha")
    private int alpha;

    @SerializedName("h")
    private double height;

    @SerializedName("loading")
    public boolean isLocal;

    @SerializedName("is_visible")
    private boolean isVisible;

    @SerializedName("mute_audio")
    public int muteAudio;

    @SerializedName("p")
    public int position;

    @SerializedName(CloudControlInf.STAT)
    private int status;

    @SerializedName("talk")
    public int talk;

    @SerializedName("talk_volume")
    public int talkVolume;

    @SerializedName("type")
    private int type;

    @SerializedName("uid")
    private long uid;

    @SerializedName("uid_str")
    public String uidStr;

    @SerializedName("w")
    private double width;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @SerializedName("x")
    private double f162642x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @SerializedName("y")
    private double f162643y;

    @SerializedName("zorder")
    private int zOrder;

    public String getInteractId() {
        if (TextUtils.isEmpty(this.uidStr) == true) goto L10;
        if (isExceptionData(this.uidStr) == true) goto L10;
        return this.uidStr;
    L10:
        return String.valueOf(this.uid);
    }

    public boolean isMuteAudio() {
        if (this.muteAudio == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public boolean isTalking() {
        if (this.talk <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public SeiRegion() {
        this.isVisible = true;
        this.position = -2;
        this.isLocal = false;
    }

    public String getAccount() {
        return this.account;
    }

    public int getAlpha() {
        return this.alpha;
    }

    public double getHeight() {
        return this.height;
    }

    public int getStatus() {
        return this.status;
    }

    public int getTalk() {
        return this.talk;
    }

    public int getTalkVolume() {
        return this.talkVolume;
    }

    public int getType() {
        return this.type;
    }

    public long getUid() {
        return this.uid;
    }

    public double getWidth() {
        return this.width;
    }

    public double getX() {
        return this.f162642x;
    }

    public double getY() {
        return this.f162643y;
    }

    public int getzOrder() {
        return this.zOrder;
    }

    public boolean isVisible() {
        return this.isVisible;
    }

    private boolean isExceptionData(String r100) {
        if ("null".equals(r100) == false) goto L5;
        return true;
    L5:
        if ("nil".equals(r100) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public SeiRegion setAccount(long r100) {
        this.account = String.valueOf(r100);
        return this;
    }

    public SeiRegion setAlpha(int r100) {
        this.alpha = r100;
        return this;
    }

    public SeiRegion setHeight(double r100) {
        this.height = r100;
        return this;
    }

    public void setIsLocal(boolean r100) {
        this.isLocal = r100;
    }

    public void setMuteAudio(int r100) {
        this.muteAudio = r100;
    }

    public void setPosition(int r100) {
        this.position = r100;
    }

    public SeiRegion setStatus(int r100) {
        this.status = r100;
        return this;
    }

    public SeiRegion setTalk(int r100) {
        this.talk = r100;
        return this;
    }

    public void setTalkVolume(int r100) {
        this.talkVolume = r100;
    }

    public SeiRegion setType(int r100) {
        this.type = r100;
        return this;
    }

    public SeiRegion setUid(long r100) {
        this.uid = r100;
        return this;
    }

    public SeiRegion setUidStr(String r100) {
        this.uidStr = r100;
        return this;
    }

    public void setVisible(boolean r100) {
        this.isVisible = r100;
    }

    public SeiRegion setWidth(double r100) {
        this.width = r100;
        return this;
    }

    public SeiRegion setX(double r100) {
        this.f162642x = r100;
        return this;
    }

    public SeiRegion setY(double r100) {
        this.f162643y = r100;
        return this;
    }

    public SeiRegion setzOrder(int r100) {
        this.zOrder = r100;
        return this;
    }

    public SeiRegion setAccount(String r100) {
        this.account = r100;
        return this;
    }
}
