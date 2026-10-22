package com.byted.mgl.merge.service.model;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: classes43.dex */
public class BdpLocatePointStyle {
    public Bitmap locationIcon;
    public int radiusFillColor;
    public boolean showMyLocation;
    public int strokeColor;
    public float strokeWidth;

    public BdpLocatePointStyle() {
    }

    public int getRadiusFillColor() {
        return this.radiusFillColor;
    }

    public int getStrokeColor() {
        return this.strokeColor;
    }

    public float getStrokeWidth() {
        return this.strokeWidth;
    }

    public Bitmap getlocationIcon() {
        return this.locationIcon;
    }

    public boolean isShowMyLocation() {
        return this.showMyLocation;
    }

    public BdpLocatePointStyle locationIcon(Bitmap r100) {
        this.locationIcon = r100;
        return this;
    }

    public BdpLocatePointStyle radiusFillColor(int r100) {
        this.radiusFillColor = r100;
        return this;
    }

    public BdpLocatePointStyle showMyLocation(boolean r100) {
        this.showMyLocation = r100;
        return this;
    }

    public BdpLocatePointStyle strokeColor(int r100) {
        this.strokeColor = r100;
        return this;
    }

    public BdpLocatePointStyle strokeWidth(float r100) {
        this.strokeWidth = r100;
        return this;
    }

    public BdpLocatePointStyle(Bitmap r100, int r101, float r102, int r103, boolean r104) {
        this.locationIcon = r100;
        this.strokeColor = r101;
        this.strokeWidth = r102;
        this.radiusFillColor = r103;
        this.showMyLocation = r104;
    }
}
