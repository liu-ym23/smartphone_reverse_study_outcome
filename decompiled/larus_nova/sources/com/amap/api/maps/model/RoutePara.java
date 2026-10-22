package com.amap.api.maps.model;

/* JADX INFO: loaded from: classes28.dex */
public class RoutePara {
    private int drivingRouteStyle;
    private String endName;
    private LatLng endPoint;
    private String startName;
    private LatLng startPoint;
    private int transitRouteStyle;

    public RoutePara() {
        this.drivingRouteStyle = 0;
        this.transitRouteStyle = 0;
    }

    public int getDrivingRouteStyle() {
        return this.drivingRouteStyle;
    }

    public String getEndName() {
        return this.endName;
    }

    public LatLng getEndPoint() {
        return this.endPoint;
    }

    public String getStartName() {
        return this.startName;
    }

    public LatLng getStartPoint() {
        return this.startPoint;
    }

    public int getTransitRouteStyle() {
        return this.transitRouteStyle;
    }

    public void setDrivingRouteStyle(int r100) {
        if (r100 >= 0) goto L4;
        return;
    L4:
        if (r100 >= 9) goto L8;
        this.drivingRouteStyle = r100;
        return;
    }

    public void setEndName(String r100) {
        this.endName = r100;
    }

    public void setEndPoint(LatLng r100) {
        this.endPoint = r100;
    }

    public void setStartName(String r100) {
        this.startName = r100;
    }

    public void setStartPoint(LatLng r100) {
        this.startPoint = r100;
    }

    public void setTransitRouteStyle(int r100) {
        if (r100 >= 0) goto L4;
        return;
    L4:
        if (r100 >= 6) goto L8;
        this.transitRouteStyle = r100;
        return;
    }
}
