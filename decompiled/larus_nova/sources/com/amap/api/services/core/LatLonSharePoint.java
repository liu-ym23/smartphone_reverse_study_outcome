package com.amap.api.services.core;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes28.dex */
public class LatLonSharePoint extends LatLonPoint {
    public static final Parcelable.Creator<LatLonSharePoint> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f28838a;

    @Override // com.amap.api.services.core.LatLonPoint, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    @Override // com.amap.api.services.core.LatLonPoint
    public String toString() {
        return super.toString() + "," + this.f28838a;
    }

    @Override // com.amap.api.services.core.LatLonPoint
    public int hashCode() {
        int r100 = super.hashCode() * 31;
        String r101 = this.f28838a;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public String getSharePointName() {
        return this.f28838a;
    }

    public LatLonSharePoint(Parcel r100) {
        super(r100);
        this.f28838a = r100.readString();
    }

    @Override // com.amap.api.services.core.LatLonPoint
    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (super.equals(r100) == true) goto L9;
        return false;
    L9:
        if (getClass() == r100.getClass()) goto L11;
        return false;
    L11:
        LatLonSharePoint r101 = (LatLonSharePoint) r100;
        String r102 = this.f28838a;
        if (r102 != null) goto L17;
        if (r101.f28838a == null) goto L19;
        return false;
    L19:
        return true;
    L17:
        if (r102.equals(r101.f28838a) == true) goto L19;
        return false;
    }

    public void setSharePointName(String r100) {
        this.f28838a = r100;
    }

    @Override // com.amap.api.services.core.LatLonPoint, android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        super.writeToParcel(r100, r101);
        r100.writeString(this.f28838a);
    }

    public LatLonSharePoint(double r100, double r101, String r102) {
        super(r100, r101);
        this.f28838a = r102;
    }
}
