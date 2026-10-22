package com.bef.effectsdk.algorithm;

/* JADX INFO: loaded from: classes39.dex */
public class ObjectInfo {
    private int bbox_bottom;
    private int bbox_left;
    private int bbox_right;
    private int bbox_top;
    private int label;

    public ObjectInfo() {
        this.label = -1;
        this.bbox_left = -1;
        this.bbox_top = -1;
        this.bbox_right = -1;
        this.bbox_bottom = -1;
    }

    public int getBBoxBottom() {
        return this.bbox_bottom;
    }

    public int getBBoxLeft() {
        return this.bbox_left;
    }

    public int getBBoxRight() {
        return this.bbox_right;
    }

    public int getBboxTop() {
        return this.bbox_top;
    }

    public int getLabel() {
        return this.label;
    }

    public void logData() {
    }

    public void setLabel(int r100) {
        this.label = r100;
    }

    public void setBBox(int r100, int r101, int r102, int r103) {
        this.bbox_left = r100;
        this.bbox_top = r101;
        this.bbox_right = r102;
        this.bbox_bottom = r103;
    }

    public ObjectInfo(int r100, int r101, int r102, int r103, int r104) {
        this.label = r100;
        this.bbox_left = r101;
        this.bbox_top = r102;
        this.bbox_right = r103;
        this.bbox_bottom = r104;
    }
}
