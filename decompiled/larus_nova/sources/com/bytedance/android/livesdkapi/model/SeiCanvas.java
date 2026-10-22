package com.bytedance.android.livesdkapi.model;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes12.dex */
public class SeiCanvas {

    @SerializedName("background")
    private String background;

    @SerializedName("height")
    private int height;

    @SerializedName("width")
    private int width;

    public SeiCanvas() {
    }

    public String toString() {
        return "SeiCanvas{background='" + this.background + "', height=" + this.height + ", width=" + this.width + '}';
    }

    public String getBackground() {
        return this.background;
    }

    public int getHeight() {
        return this.height;
    }

    public int getWidth() {
        return this.width;
    }

    public void setBackground(String r100) {
        this.background = r100;
    }

    public void setHeight(int r100) {
        this.height = r100;
    }

    public void setWidth(int r100) {
        this.width = r100;
    }
}
