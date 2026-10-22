package com.amap.api.maps.model;

import com.autonavi.amap.mapcore.IPoint;

/* JADX INFO: loaded from: classes28.dex */
public class MultiPointItem {
    private String customerId;
    private IPoint iPoint;
    private LatLng latLng;
    private Object object;
    private String snippet;
    private String title;

    private MultiPointItem() {
        this.customerId = null;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public String getCustomerId() {
        return this.customerId;
    }

    public IPoint getIPoint() {
        return this.iPoint;
    }

    public LatLng getLatLng() {
        return this.latLng;
    }

    public Object getObject() {
        return this.object;
    }

    public String getSnippet() {
        return this.snippet;
    }

    public String getTitle() {
        return this.title;
    }

    public MultiPointItem(LatLng r100) {
        this.customerId = null;
        this.latLng = r100;
    }

    public boolean equals(Object r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if ((r100 instanceof MultiPointItem) == true) goto L8;
        return false;
    L8:
        if (this.customerId == null) goto L14;
        MultiPointItem r101 = (MultiPointItem) r100;
        if (r101.getCustomerId() == null) goto L14;
        return this.customerId.equals(r101.getCustomerId());
    L14:
        return super.equals(r100);
    }

    public void setCustomerId(String r100) {
        this.customerId = r100;
    }

    public void setIPoint(IPoint r100) {
        this.iPoint = r100;
    }

    public void setLatLng(LatLng r100) {
        this.latLng = r100;
    }

    public void setObject(Object r100) {
        this.object = r100;
    }

    public void setSnippet(String r100) {
        this.snippet = r100;
    }

    public void setTitle(String r100) {
        this.title = r100;
    }
}
