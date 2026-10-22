package com.amap.api.maps.model;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes28.dex */
public final class ArcOptions extends BaseOptions implements Parcelable, Cloneable {
    public static final ArcOptionsCreator CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    String f28643a;
    private LatLng endpoint;
    private boolean isVisible;
    private LatLng passedpoint;
    private LatLng startpoint;
    private int strokeColor;
    private float strokeWidth;
    private float zIndex;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new ArcOptionsCreator();
    }

    public ArcOptions() {
        this.strokeWidth = 10.0f;
        this.strokeColor = -16777216;
        this.zIndex = 0.0f;
        this.isVisible = true;
        this.type = "ArcOptions";
    }

    public ArcOptions clone() {
        super.clone();     // Catch: CloneNotSupportedException -> L4
    L6:
        ArcOptions r100 = new ArcOptions();
        r100.f28643a = this.f28643a;
        r100.startpoint = this.startpoint;
        r100.passedpoint = this.passedpoint;
        r100.endpoint = this.endpoint;
        r100.strokeWidth = this.strokeWidth;
        r100.strokeColor = this.strokeColor;
        r100.zIndex = this.zIndex;
        r100.isVisible = this.isVisible;
        return r100;
    L4:
        e = move-exception;
        e.printStackTrace();
        goto L6
    }

    public LatLng getEnd() {
        return this.endpoint;
    }

    public LatLng getPassed() {
        return this.passedpoint;
    }

    public LatLng getStart() {
        return this.startpoint;
    }

    public int getStrokeColor() {
        return this.strokeColor;
    }

    public float getStrokeWidth() {
        return this.strokeWidth;
    }

    public float getZIndex() {
        return this.zIndex;
    }

    public boolean isVisible() {
        return this.isVisible;
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m8021clone() throws CloneNotSupportedException {
        return clone();
    }

    public ArcOptions strokeColor(int r100) {
        this.strokeColor = r100;
        return this;
    }

    public ArcOptions strokeWidth(float r100) {
        this.strokeWidth = r100;
        return this;
    }

    public ArcOptions visible(boolean r100) {
        this.isVisible = r100;
        return this;
    }

    public ArcOptions zIndex(float r100) {
        this.zIndex = r100;
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        Bundle r102 = new Bundle();
        LatLng r103 = this.startpoint;
        if (r103 == null) goto L5;
        r102.putDouble("startlat", r103.latitude);
        r102.putDouble("startlng", this.startpoint.longitude);
    L5:
        LatLng r104 = this.passedpoint;
        if (r104 == null) goto L8;
        r102.putDouble("passedlat", r104.latitude);
        r102.putDouble("passedlng", this.passedpoint.longitude);
    L8:
        LatLng r105 = this.endpoint;
        if (r105 == null) goto L11;
        r102.putDouble("endlat", r105.latitude);
        r102.putDouble("endlng", this.endpoint.longitude);
    L11:
        r100.writeBundle(r102);
        r100.writeFloat(this.strokeWidth);
        r100.writeInt(this.strokeColor);
        r100.writeFloat(this.zIndex);
        r100.writeByte(this.isVisible ? 1 : 0);
        r100.writeString(this.f28643a);
    }

    public ArcOptions point(LatLng r100, LatLng r101, LatLng r102) {
        this.startpoint = r100;
        this.passedpoint = r101;
        this.endpoint = r102;
        return this;
    }
}
