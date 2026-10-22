package com.amap.api.maps.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes28.dex */
public class ColorLatLng {
    private int color;
    private List<LatLng> latLngs;

    public int hashCode() {
        return Objects.hash(new Object[]{this.latLngs, Integer.valueOf(this.color)});
    }

    public String toString() {
        return "ColorLatLng{latLngs=" + this.latLngs + ", color=" + this.color + '}';
    }

    public int getColor() {
        return this.color;
    }

    public List<LatLng> getLatLngs() {
        return this.latLngs;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L17:
        return false;
    L8:
        if (getClass() != r100.getClass()) goto L17;
        ColorLatLng r101 = (ColorLatLng) r100;
        if (this.color == r101.color) goto L13;
    L15:
        return false;
    L13:
        if (Objects.equals(this.latLngs, r101.latLngs) == false) goto L15;
        return true;
    }

    public ColorLatLng(List<LatLng> r100, int r101) {
        ArrayList r102 = new ArrayList();
        this.latLngs = r102;
        r102.clear();
        this.latLngs.addAll(r100);
        this.color = r101;
    }
}
