package com.amap.api.maps;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.maps.model.CameraPosition;

/* JADX INFO: loaded from: classes28.dex */
public class AMapOptions implements Parcelable {
    public static final AMapOptionsCreator CREATOR = null;
    public static final int LOGO_MARGIN_BOTTOM = 2;
    public static final int LOGO_MARGIN_LEFT = 0;
    public static final int LOGO_MARGIN_RIGHT = 1;
    public static final int LOGO_POSITION_BOTTOM_CENTER = 1;
    public static final int LOGO_POSITION_BOTTOM_LEFT = 0;
    public static final int LOGO_POSITION_BOTTOM_RIGHT = 2;
    public static final int ZOOM_POSITION_RIGHT_BOTTOM = 2;
    public static final int ZOOM_POSITION_RIGHT_CENTER = 1;
    private CameraPosition cameraPosition;
    private boolean isCompassEnabled;
    private boolean isRotateGesturesEnabled;
    private boolean isScaleControlsEnabled;
    private boolean isScrollGesturesEnabled;
    private boolean isTiltGesturesEnabled;
    private boolean isZOrderOnTop;
    private boolean isZoomEnabled;
    private boolean isZoomGesturesEnabled;
    private int logoPosition;
    private int mapType;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new AMapOptionsCreator();
    }

    public AMapOptions() {
        this.mapType = 1;
        this.isRotateGesturesEnabled = true;
        this.isScrollGesturesEnabled = true;
        this.isTiltGesturesEnabled = true;
        this.isZoomGesturesEnabled = true;
        this.isZoomEnabled = true;
        this.isZOrderOnTop = false;
        this.isCompassEnabled = false;
        this.isScaleControlsEnabled = false;
        this.logoPosition = 0;
    }

    public CameraPosition getCamera() {
        return this.cameraPosition;
    }

    public boolean getCompassEnabled() {
        return this.isCompassEnabled;
    }

    public int getLogoPosition() {
        return this.logoPosition;
    }

    public int getMapType() {
        return this.mapType;
    }

    public boolean getRotateGesturesEnabled() {
        return this.isRotateGesturesEnabled;
    }

    public boolean getScaleControlsEnabled() {
        return this.isScaleControlsEnabled;
    }

    public boolean getScrollGesturesEnabled() {
        return this.isScrollGesturesEnabled;
    }

    public boolean getTiltGesturesEnabled() {
        return this.isTiltGesturesEnabled;
    }

    public boolean getZOrderOnTop() {
        return this.isZOrderOnTop;
    }

    public boolean getZoomControlsEnabled() {
        return this.isZoomEnabled;
    }

    public boolean getZoomGesturesEnabled() {
        return this.isZoomGesturesEnabled;
    }

    public AMapOptions camera(CameraPosition r100) {
        this.cameraPosition = r100;
        return this;
    }

    public AMapOptions compassEnabled(boolean r100) {
        this.isCompassEnabled = r100;
        return this;
    }

    public AMapOptions logoPosition(int r100) {
        this.logoPosition = r100;
        return this;
    }

    public AMapOptions mapType(int r100) {
        this.mapType = r100;
        return this;
    }

    public AMapOptions rotateGesturesEnabled(boolean r100) {
        this.isRotateGesturesEnabled = r100;
        return this;
    }

    public AMapOptions scaleControlsEnabled(boolean r100) {
        this.isScaleControlsEnabled = r100;
        return this;
    }

    public AMapOptions scrollGesturesEnabled(boolean r100) {
        this.isScrollGesturesEnabled = r100;
        return this;
    }

    public AMapOptions tiltGesturesEnabled(boolean r100) {
        this.isTiltGesturesEnabled = r100;
        return this;
    }

    public AMapOptions zOrderOnTop(boolean r100) {
        this.isZOrderOnTop = r100;
        return this;
    }

    public AMapOptions zoomControlsEnabled(boolean r100) {
        this.isZoomEnabled = r100;
        return this;
    }

    public AMapOptions zoomGesturesEnabled(boolean r100) {
        this.isZoomGesturesEnabled = r100;
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeParcelable(this.cameraPosition, r101);
        r100.writeInt(this.mapType);
        r100.writeInt(this.logoPosition);
        r100.writeBooleanArray(new boolean[]{this.isRotateGesturesEnabled, this.isScrollGesturesEnabled, this.isTiltGesturesEnabled, this.isZoomGesturesEnabled, this.isZoomEnabled, this.isZOrderOnTop, this.isCompassEnabled, this.isScaleControlsEnabled});
    }
}
