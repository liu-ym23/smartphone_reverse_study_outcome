package com.byted.mgl.merge.service.model;

import java.io.Serializable;

/* JADX INFO: loaded from: classes43.dex */
public class BdpLatLng implements Serializable {
    public double latitude;
    public double longitude;

    public BdpLatLng() {
    }

    public double getLatitude() {
        return this.latitude;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public void setLatitude(double r100) {
        this.latitude = r100;
    }

    public void setLongitude(double r100) {
        this.longitude = r100;
    }

    public BdpLatLng(double r100, double r101) {
        this.latitude = r100;
        this.longitude = r101;
    }
}
