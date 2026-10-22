package com.amap.api.maps.model;

import android.graphics.Color;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes28.dex */
public class MyLocationStyle implements Parcelable {
    public static final MyLocationStyleCreator CREATOR = null;
    public static final String ERROR_CODE = "errorCode";
    public static final String ERROR_INFO = "errorInfo";
    public static final String LOCATION_TYPE = "locationType";
    public static final int LOCATION_TYPE_FOLLOW = 2;
    public static final int LOCATION_TYPE_FOLLOW_NO_CENTER = 6;
    public static final int LOCATION_TYPE_LOCATE = 1;
    public static final int LOCATION_TYPE_LOCATION_ROTATE = 4;
    public static final int LOCATION_TYPE_LOCATION_ROTATE_NO_CENTER = 5;
    public static final int LOCATION_TYPE_MAP_ROTATE = 3;
    public static final int LOCATION_TYPE_MAP_ROTATE_NO_CENTER = 7;
    public static final int LOCATION_TYPE_SHOW = 0;
    private long interval;
    private float mAnchorU;
    private float mAnchorV;
    private int mLocationType;
    private BitmapDescriptor mMyLocationIcon;
    private int mRadiusFillColor;
    private int mStrokeColor;
    private float mStrokeWidth;
    private boolean myLocationVisible;
    private int zIndex;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new MyLocationStyleCreator();
    }

    public MyLocationStyle() {
        this.mAnchorU = 0.5f;
        this.mAnchorV = 0.5f;
        this.mRadiusFillColor = Color.argb(100, 0, 0, 180);
        this.mStrokeColor = Color.argb(255, 0, 0, 220);
        this.mStrokeWidth = 1.0f;
        this.mLocationType = 4;
        this.interval = 2000;
        this.zIndex = 0;
        this.myLocationVisible = true;
    }

    public float getAnchorU() {
        return this.mAnchorU;
    }

    public float getAnchorV() {
        return this.mAnchorV;
    }

    public long getInterval() {
        return this.interval;
    }

    public BitmapDescriptor getMyLocationIcon() {
        return this.mMyLocationIcon;
    }

    public int getMyLocationType() {
        return this.mLocationType;
    }

    public int getRadiusFillColor() {
        return this.mRadiusFillColor;
    }

    public int getStrokeColor() {
        return this.mStrokeColor;
    }

    public float getStrokeWidth() {
        return this.mStrokeWidth;
    }

    public int getZIndex() {
        return this.zIndex;
    }

    public boolean isMyLocationShowing() {
        return this.myLocationVisible;
    }

    public MyLocationStyle interval(long r100) {
        this.interval = r100;
        return this;
    }

    public MyLocationStyle myLocationIcon(BitmapDescriptor r100) {
        this.mMyLocationIcon = r100;
        return this;
    }

    public MyLocationStyle myLocationType(int r100) {
        this.mLocationType = r100;
        return this;
    }

    public MyLocationStyle radiusFillColor(int r100) {
        this.mRadiusFillColor = r100;
        return this;
    }

    public void setZIndex(int r100) {
        this.zIndex = r100;
    }

    public MyLocationStyle showMyLocation(boolean r100) {
        this.myLocationVisible = r100;
        return this;
    }

    public MyLocationStyle strokeColor(int r100) {
        this.mStrokeColor = r100;
        return this;
    }

    public MyLocationStyle strokeWidth(float r100) {
        this.mStrokeWidth = r100;
        return this;
    }

    public MyLocationStyle anchor(float r100, float r101) {
        this.mAnchorU = r100;
        this.mAnchorV = r101;
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeParcelable(this.mMyLocationIcon, r101);
        r100.writeFloat(this.mAnchorU);
        r100.writeFloat(this.mAnchorV);
        r100.writeInt(this.mRadiusFillColor);
        r100.writeInt(this.mStrokeColor);
        r100.writeFloat(this.mStrokeWidth);
        r100.writeInt(this.mLocationType);
        r100.writeLong(this.interval);
        r100.writeInt(this.zIndex);
        r100.writeBooleanArray(new boolean[]{this.myLocationVisible});
    }
}
