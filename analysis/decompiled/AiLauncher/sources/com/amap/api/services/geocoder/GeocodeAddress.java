package com.amap.api.services.geocoder;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;

/* loaded from: classes.dex */
public final class GeocodeAddress implements Parcelable {
    public static final Parcelable.Creator<GeocodeAddress> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private String f17426a;

    /* renamed from: b, reason: collision with root package name */
    private String f17427b;

    /* renamed from: c, reason: collision with root package name */
    private String f17428c;

    /* renamed from: d, reason: collision with root package name */
    private String f17429d;

    /* renamed from: e, reason: collision with root package name */
    private String f17430e;

    /* renamed from: f, reason: collision with root package name */
    private String f17431f;

    /* renamed from: g, reason: collision with root package name */
    private String f17432g;

    /* renamed from: h, reason: collision with root package name */
    private String f17433h;

    /* renamed from: i, reason: collision with root package name */
    private LatLonPoint f17434i;

    /* renamed from: j, reason: collision with root package name */
    private String f17435j;

    /* renamed from: k, reason: collision with root package name */
    private String f17436k;

    /* renamed from: l, reason: collision with root package name */
    private String f17437l;

    public static class a implements Parcelable.Creator<GeocodeAddress> {
        @Override // android.os.Parcelable.Creator
        public GeocodeAddress createFromParcel(Parcel parcel) {
            return new GeocodeAddress(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ GeocodeAddress[] newArray(int i10) {
            return null;
        }
    }

    public /* synthetic */ GeocodeAddress(Parcel parcel, a aVar) {
        this(parcel);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAdcode() {
        return this.f17433h;
    }

    public String getBuilding() {
        return this.f17432g;
    }

    public String getCity() {
        return this.f17428c;
    }

    public String getCountry() {
        return this.f17436k;
    }

    public String getDistrict() {
        return this.f17429d;
    }

    public String getFormatAddress() {
        return this.f17426a;
    }

    public LatLonPoint getLatLonPoint() {
        return this.f17434i;
    }

    public String getLevel() {
        return this.f17435j;
    }

    public String getNeighborhood() {
        return this.f17431f;
    }

    public String getPostcode() {
        return this.f17437l;
    }

    public String getProvince() {
        return this.f17427b;
    }

    public String getTownship() {
        return this.f17430e;
    }

    public void setAdcode(String str) {
        this.f17433h = str;
    }

    public void setBuilding(String str) {
        this.f17432g = str;
    }

    public void setCity(String str) {
        this.f17428c = str;
    }

    public void setCountry(String str) {
        this.f17436k = str;
    }

    public void setDistrict(String str) {
        this.f17429d = str;
    }

    public void setFormatAddress(String str) {
        this.f17426a = str;
    }

    public void setLatLonPoint(LatLonPoint latLonPoint) {
        this.f17434i = latLonPoint;
    }

    public void setLevel(String str) {
        this.f17435j = str;
    }

    public void setNeighborhood(String str) {
        this.f17431f = str;
    }

    public void setPostcode(String str) {
        this.f17437l = str;
    }

    public void setProvince(String str) {
        this.f17427b = str;
    }

    public void setTownship(String str) {
        this.f17430e = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f17426a);
        parcel.writeString(this.f17427b);
        parcel.writeString(this.f17428c);
        parcel.writeString(this.f17429d);
        parcel.writeString(this.f17430e);
        parcel.writeString(this.f17431f);
        parcel.writeString(this.f17432g);
        parcel.writeString(this.f17433h);
        parcel.writeValue(this.f17434i);
        parcel.writeString(this.f17435j);
        parcel.writeString(this.f17436k);
        parcel.writeString(this.f17437l);
    }

    public GeocodeAddress() {
    }

    private GeocodeAddress(Parcel parcel) {
        this.f17426a = parcel.readString();
        this.f17427b = parcel.readString();
        this.f17428c = parcel.readString();
        this.f17429d = parcel.readString();
        this.f17430e = parcel.readString();
        this.f17431f = parcel.readString();
        this.f17432g = parcel.readString();
        this.f17433h = parcel.readString();
        this.f17434i = (LatLonPoint) parcel.readValue(LatLonPoint.class.getClassLoader());
        this.f17435j = parcel.readString();
        this.f17436k = parcel.readString();
        this.f17437l = parcel.readString();
    }
}
