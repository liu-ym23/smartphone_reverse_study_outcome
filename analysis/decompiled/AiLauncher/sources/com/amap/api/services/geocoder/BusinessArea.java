package com.amap.api.services.geocoder;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;

/* loaded from: classes.dex */
public class BusinessArea implements Parcelable {
    public static final Parcelable.Creator<BusinessArea> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private LatLonPoint f17424a;

    /* renamed from: b, reason: collision with root package name */
    private String f17425b;

    public static class a implements Parcelable.Creator<BusinessArea> {
        @Override // android.os.Parcelable.Creator
        public BusinessArea createFromParcel(Parcel parcel) {
            return new BusinessArea(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public BusinessArea[] newArray(int i10) {
            return new BusinessArea[i10];
        }
    }

    public BusinessArea() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public LatLonPoint getCenterPoint() {
        return this.f17424a;
    }

    public String getName() {
        return this.f17425b;
    }

    public void setCenterPoint(LatLonPoint latLonPoint) {
        this.f17424a = latLonPoint;
    }

    public void setName(String str) {
        this.f17425b = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeParcelable(this.f17424a, i10);
        parcel.writeString(this.f17425b);
    }

    public BusinessArea(Parcel parcel) {
        this.f17424a = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
        this.f17425b = parcel.readString();
    }
}
