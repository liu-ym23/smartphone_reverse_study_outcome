package com.amap.api.maps.model;

/* JADX INFO: loaded from: classes28.dex */
public class NaviPara {
    public static final int DRIVING_AVOID_CONGESTION = 4;
    public static final int DRIVING_DEFAULT = 0;
    public static final int DRIVING_NO_HIGHWAY = 3;
    public static final int DRIVING_NO_HIGHWAY_AVOID_CONGESTION = 6;
    public static final int DRIVING_NO_HIGHWAY_AVOID_SHORT_MONEY = 5;
    public static final int DRIVING_NO_HIGHWAY_SAVE_MONEY_AVOID_CONGESTION = 8;
    public static final int DRIVING_SAVE_MONEY = 1;
    public static final int DRIVING_SAVE_MONEY_AVOID_CONGESTION = 7;
    public static final int DRIVING_SHORT_DISTANCE = 2;
    private LatLng latLng;
    private int naviStyle;

    public NaviPara() {
        this.naviStyle = 0;
    }

    public int getNaviStyle() {
        return this.naviStyle;
    }

    public LatLng getTargetPoint() {
        return this.latLng;
    }

    public void setNaviStyle(int r100) {
        if (r100 >= 0) goto L4;
        return;
    L4:
        if (r100 >= 9) goto L8;
        this.naviStyle = r100;
        return;
    }

    public void setTargetPoint(LatLng r100) {
        this.latLng = r100;
    }
}
