package com.amap.api.maps;

import android.view.View;

/* JADX INFO: loaded from: classes28.dex */
public class InfoWindowParams {
    public static final int INFOWINDOW_TYPE_IMAGE = 1;
    public static final int INFOWINDOW_TYPE_VIEW = 2;
    private View infoContent;
    private View infoWindow;
    private int infoWindowType;
    private int mInfoWindowUpdateTime;

    public long getInfoWindowUpdateTime() {
        return this.mInfoWindowUpdateTime;
    }

    public InfoWindowParams() {
        this.infoWindowType = 2;
    }

    public View getInfoContents() {
        return this.infoContent;
    }

    public View getInfoWindow() {
        return this.infoWindow;
    }

    public int getInfoWindowType() {
        return this.infoWindowType;
    }

    public void setInfoContent(View r100) {
        this.infoContent = r100;
    }

    public void setInfoWindow(View r100) {
        this.infoWindow = r100;
    }

    public void setInfoWindowType(int r100) {
        this.infoWindowType = r100;
    }

    public void setInfoWindowUpdateTime(int r100) {
        this.mInfoWindowUpdateTime = r100;
    }
}
