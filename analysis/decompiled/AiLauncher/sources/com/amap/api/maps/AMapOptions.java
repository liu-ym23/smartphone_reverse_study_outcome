package com.amap.api.maps;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.maps.model.CameraPosition;

/* loaded from: classes.dex */
public class AMapOptions implements Parcelable {
    public static final AMapOptionsCreator CREATOR = new AMapOptionsCreator();
    private CameraPosition cameraPosition;
    private int mapType = 1;
    private boolean isRotateGesturesEnabled = true;
    private boolean isScrollGesturesEnabled = true;
    private boolean isTiltGesturesEnabled = true;
    private boolean isZoomGesturesEnabled = true;
    private boolean isZoomEnabled = true;
    private boolean isZOrderOnTop = false;
    private boolean isCompassEnabled = false;
    private boolean isScaleControlsEnabled = false;
    private int logoPosition = 0;

    public AMapOptions camera(CameraPosition cameraPosition) {
        this.cameraPosition = cameraPosition;
        return this;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public CameraPosition getCamera() {
        return this.cameraPosition;
    }

    public int getMapType() {
        return this.mapType;
    }

    public boolean getRotateGesturesEnabled() {
        return this.isRotateGesturesEnabled;
    }

    public boolean getScrollGesturesEnabled() {
        return this.isScrollGesturesEnabled;
    }

    public boolean getTiltGesturesEnabled() {
        return this.isTiltGesturesEnabled;
    }

    public boolean getZoomGesturesEnabled() {
        return this.isZoomGesturesEnabled;
    }

    public AMapOptions mapType(int i10) {
        this.mapType = i10;
        return this;
    }

    public AMapOptions rotateGesturesEnabled(boolean z10) {
        this.isRotateGesturesEnabled = z10;
        return this;
    }

    public AMapOptions scrollGesturesEnabled(boolean z10) {
        this.isScrollGesturesEnabled = z10;
        return this;
    }

    public AMapOptions tiltGesturesEnabled(boolean z10) {
        this.isTiltGesturesEnabled = z10;
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeParcelable(this.cameraPosition, i10);
        parcel.writeInt(this.mapType);
        parcel.writeBooleanArray(new boolean[]{this.isRotateGesturesEnabled, this.isScrollGesturesEnabled, this.isTiltGesturesEnabled, this.isZoomGesturesEnabled, this.isZoomEnabled, this.isZOrderOnTop, this.isCompassEnabled});
    }

    public AMapOptions zoomGesturesEnabled(boolean z10) {
        this.isZoomGesturesEnabled = z10;
        return this;
    }
}
