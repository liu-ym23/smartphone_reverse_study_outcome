package com.amap.api.services.geocoder;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;

/* loaded from: classes.dex */
public final class StreetNumber implements Parcelable {
    public static final Parcelable.Creator<StreetNumber> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private String f17475a;

    /* renamed from: b, reason: collision with root package name */
    private String f17476b;

    /* renamed from: c, reason: collision with root package name */
    private LatLonPoint f17477c;

    /* renamed from: d, reason: collision with root package name */
    private String f17478d;

    /* renamed from: e, reason: collision with root package name */
    private float f17479e;

    public static class a implements Parcelable.Creator<StreetNumber> {
        @Override // android.os.Parcelable.Creator
        public StreetNumber createFromParcel(Parcel parcel) {
            return new StreetNumber(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ StreetNumber[] newArray(int i10) {
            return null;
        }
    }

    public /* synthetic */ StreetNumber(Parcel parcel, a aVar) {
        this(parcel);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getDirection() {
        return this.f17478d;
    }

    public float getDistance() {
        return this.f17479e;
    }

    public LatLonPoint getLatLonPoint() {
        return this.f17477c;
    }

    public String getNumber() {
        return this.f17476b;
    }

    public String getStreet() {
        return this.f17475a;
    }

    public void setDirection(String str) {
        this.f17478d = str;
    }

    public void setDistance(float f10) {
        this.f17479e = f10;
    }

    public void setLatLonPoint(LatLonPoint latLonPoint) {
        this.f17477c = latLonPoint;
    }

    public void setNumber(String str) {
        this.f17476b = str;
    }

    public void setStreet(String str) {
        this.f17475a = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f17475a);
        parcel.writeString(this.f17476b);
        parcel.writeValue(this.f17477c);
        parcel.writeString(this.f17478d);
        parcel.writeFloat(this.f17479e);
    }

    public StreetNumber() {
    }

    private StreetNumber(Parcel parcel) {
        this.f17475a = parcel.readString();
        this.f17476b = parcel.readString();
        this.f17477c = (LatLonPoint) parcel.readValue(LatLonPoint.class.getClassLoader());
        this.f17478d = parcel.readString();
        this.f17479e = parcel.readFloat();
    }
}
