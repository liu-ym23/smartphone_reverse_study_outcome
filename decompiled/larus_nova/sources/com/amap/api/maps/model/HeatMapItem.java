package com.amap.api.maps.model;

/* JADX INFO: loaded from: classes28.dex */
public class HeatMapItem {
    private LatLng center;
    private int[] indexes;
    private double intensity;

    public HeatMapItem() {
    }

    public LatLng getCenter() {
        return this.center;
    }

    public int[] getIndexes() {
        return this.indexes;
    }

    public double getIntensity() {
        return this.intensity;
    }

    public void setIndexes(int[] r100) {
        this.indexes = r100;
    }

    public void setIntensity(double r100) {
        this.intensity = r100;
    }

    public void setCenter(double r100, double r101) {
        this.center = new LatLng(r100, r101);
    }
}
