package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;

/* loaded from: classes.dex */
public class Doorway implements Parcelable {
    public static final Parcelable.Creator<Doorway> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private String f17697a;

    /* renamed from: b, reason: collision with root package name */
    private LatLonPoint f17698b;

    public static class a implements Parcelable.Creator<Doorway> {
        @Override // android.os.Parcelable.Creator
        public Doorway createFromParcel(Parcel parcel) {
            return new Doorway(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ Doorway[] newArray(int i10) {
            return null;
        }
    }

    public Doorway(Parcel parcel) {
        this.f17697a = parcel.readString();
        this.f17698b = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public LatLonPoint getLatLonPoint() {
        return this.f17698b;
    }

    public String getName() {
        return this.f17697a;
    }

    public void setLatLonPoint(LatLonPoint latLonPoint) {
        this.f17698b = latLonPoint;
    }

    public void setName(String str) {
        this.f17697a = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f17697a);
        parcel.writeParcelable(this.f17698b, i10);
    }

    public Doorway() {
    }
}
