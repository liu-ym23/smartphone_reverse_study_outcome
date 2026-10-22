package com.amap.api.maps.model;

/* JADX INFO: loaded from: classes28.dex */
public class MyTrafficStyle {
    private int congestedColor;
    private int extremelySmoothColor;
    private float ratio;
    private int seriousCongestedColor;
    private int slowColor;
    private int smoothColor;
    private int trafficRoadBackgroundColor;

    public MyTrafficStyle() {
        this.extremelySmoothColor = -15229099;
        this.smoothColor = -16735735;
        this.slowColor = -35576;
        this.congestedColor = -1441006;
        this.seriousCongestedColor = -7208950;
        this.ratio = 0.8f;
        this.trafficRoadBackgroundColor = -1;
    }

    public int getCongestedColor() {
        return this.congestedColor;
    }

    public int getExtremelySmoothColor() {
        return this.extremelySmoothColor;
    }

    public float getRatio() {
        return this.ratio;
    }

    public int getSeriousCongestedColor() {
        return this.seriousCongestedColor;
    }

    public int getSlowColor() {
        return this.slowColor;
    }

    public int getSmoothColor() {
        return this.smoothColor;
    }

    public int getTrafficRoadBackgroundColor() {
        return this.trafficRoadBackgroundColor;
    }

    public void setCongestedColor(int r100) {
        this.congestedColor = r100;
    }

    public void setExtremelySmoothColor(int r100) {
        this.extremelySmoothColor = r100;
    }

    public void setRatio(float r100) {
        this.ratio = r100;
    }

    public void setSeriousCongestedColor(int r100) {
        this.seriousCongestedColor = r100;
    }

    public void setSlowColor(int r100) {
        this.slowColor = r100;
    }

    public void setSmoothColor(int r100) {
        this.smoothColor = r100;
    }

    public void setTrafficRoadBackgroundColor(int r100) {
        this.trafficRoadBackgroundColor = r100;
    }
}
