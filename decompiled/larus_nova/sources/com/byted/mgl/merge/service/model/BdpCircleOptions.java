package com.byted.mgl.merge.service.model;

/* JADX INFO: loaded from: classes43.dex */
public class BdpCircleOptions {
    public BdpLatLng center;
    public int fillColor;
    public double radius;
    public int strokeColor;
    public double strokeWidth;

    public BdpCircleOptions() {
    }

    public BdpLatLng getCenter() {
        return this.center;
    }

    public BdpCircleOptions center(BdpLatLng r100) {
        this.center = r100;
        return this;
    }

    public BdpCircleOptions fillColor(int r100) {
        this.fillColor = r100;
        return this;
    }

    public BdpCircleOptions radius(double r100) {
        this.radius = r100;
        return this;
    }

    public BdpCircleOptions strokeColor(int r100) {
        this.strokeColor = r100;
        return this;
    }

    public BdpCircleOptions strokeWidth(double r100) {
        this.strokeWidth = r100;
        return this;
    }
}
