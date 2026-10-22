package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;

/* loaded from: classes.dex */
public class TaxiItem implements Parcelable {
    public static final Parcelable.Creator<TaxiItem> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private LatLonPoint f17932a;

    /* renamed from: b, reason: collision with root package name */
    private LatLonPoint f17933b;

    /* renamed from: c, reason: collision with root package name */
    private float f17934c;

    /* renamed from: d, reason: collision with root package name */
    private float f17935d;

    /* renamed from: e, reason: collision with root package name */
    private String f17936e;

    /* renamed from: f, reason: collision with root package name */
    private String f17937f;

    public static class a implements Parcelable.Creator<TaxiItem> {
        @Override // android.os.Parcelable.Creator
        public TaxiItem createFromParcel(Parcel parcel) {
            return new TaxiItem(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public TaxiItem[] newArray(int i10) {
            return new TaxiItem[i10];
        }
    }

    public TaxiItem() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public LatLonPoint getDestination() {
        return this.f17933b;
    }

    public float getDistance() {
        return this.f17934c;
    }

    public float getDuration() {
        return this.f17935d;
    }

    public LatLonPoint getOrigin() {
        return this.f17932a;
    }

    public String getmSname() {
        return this.f17936e;
    }

    public String getmTname() {
        return this.f17937f;
    }

    public void setDestination(LatLonPoint latLonPoint) {
        this.f17933b = latLonPoint;
    }

    public void setDistance(float f10) {
        this.f17934c = f10;
    }

    public void setDuration(float f10) {
        this.f17935d = f10;
    }

    public void setOrigin(LatLonPoint latLonPoint) {
        this.f17932a = latLonPoint;
    }

    public void setSname(String str) {
        this.f17936e = str;
    }

    public void setTname(String str) {
        this.f17937f = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeParcelable(this.f17932a, i10);
        parcel.writeParcelable(this.f17933b, i10);
        parcel.writeFloat(this.f17934c);
        parcel.writeFloat(this.f17935d);
        parcel.writeString(this.f17936e);
        parcel.writeString(this.f17937f);
    }

    public TaxiItem(Parcel parcel) {
        this.f17932a = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
        this.f17933b = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
        this.f17934c = parcel.readFloat();
        this.f17935d = parcel.readFloat();
        this.f17936e = parcel.readString();
        this.f17937f = parcel.readString();
    }
}
