package com.amap.api.services.geocoder;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;

/* JADX INFO: loaded from: classes28.dex */
public class BusinessArea implements Parcelable {
    public static final Parcelable.Creator<BusinessArea> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private LatLonPoint f28900a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f28901b;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    public BusinessArea() {
    }

    public LatLonPoint getCenterPoint() {
        return this.f28900a;
    }

    public String getName() {
        return this.f28901b;
    }

    public BusinessArea(Parcel r100) {
        this.f28900a = (LatLonPoint) r100.readParcelable(LatLonPoint.class.getClassLoader());
        this.f28901b = r100.readString();
    }

    public void setCenterPoint(LatLonPoint r100) {
        this.f28900a = r100;
    }

    public void setName(String r100) {
        this.f28901b = r100;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeParcelable(this.f28900a, r101);
        r100.writeString(this.f28901b);
    }
}
