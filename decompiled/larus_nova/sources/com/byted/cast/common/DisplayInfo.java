package com.byted.cast.common;

import com.byted.cast.linkcommon.cybergarage.upnp.device.ST;
import com.facebook.keyframes.model.KFImage;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes39.dex */
public class DisplayInfo {
    public static final String key = "display";

    @SerializedName("deviceID")
    private String mDeviceID;

    @SerializedName(KFImage.FEATURES_JSON_FIELD)
    private int mFeatures;

    @SerializedName("refreshRate")
    private int mFps;

    @SerializedName("height")
    private int mHeight;

    @SerializedName("width")
    private int mWidth;

    @SerializedName(ST.UUID_DEVICE)
    private String uuid;

    public DisplayInfo() {
        this.mWidth = -1;
        this.mHeight = -1;
        this.mFps = 60;
        this.mDeviceID = "";
        this.mFeatures = 1;
    }

    public String getDeviceID() {
        return this.mDeviceID;
    }

    public int getFeatures() {
        return this.mFeatures;
    }

    public int getFps() {
        return this.mFps;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public DisplayInfo(int r100, int r101, int r102, int r103, String r104) {
        this.mWidth = r100;
        this.mHeight = r101;
        this.mFps = r102;
        this.mFeatures = r103;
        this.mDeviceID = r104;
    }
}
