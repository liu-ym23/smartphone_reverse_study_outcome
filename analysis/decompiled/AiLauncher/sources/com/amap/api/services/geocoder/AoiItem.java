package com.amap.api.services.geocoder;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;

/* loaded from: classes.dex */
public class AoiItem implements Parcelable {
    public static final Parcelable.Creator<AoiItem> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private String f17417a;

    /* renamed from: b, reason: collision with root package name */
    private String f17418b;

    /* renamed from: c, reason: collision with root package name */
    private String f17419c;

    /* renamed from: d, reason: collision with root package name */
    private LatLonPoint f17420d;

    /* renamed from: e, reason: collision with root package name */
    private Float f17421e;

    /* renamed from: f, reason: collision with root package name */
    private float f17422f;

    /* renamed from: g, reason: collision with root package name */
    private String f17423g;

    public static class a implements Parcelable.Creator<AoiItem> {
        @Override // android.os.Parcelable.Creator
        public AoiItem createFromParcel(Parcel parcel) {
            return new AoiItem(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public AoiItem[] newArray(int i10) {
            return new AoiItem[i10];
        }
    }

    public AoiItem() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAdCode() {
        return this.f17419c;
    }

    public Float getAoiArea() {
        return this.f17421e;
    }

    public LatLonPoint getAoiCenterPoint() {
        return this.f17420d;
    }

    public String getAoiId() {
        return this.f17417a;
    }

    public String getAoiName() {
        return this.f17418b;
    }

    public float getDistance() {
        return this.f17422f;
    }

    public String getType() {
        return this.f17423g;
    }

    public void setAdcode(String str) {
        this.f17419c = str;
    }

    public void setArea(Float f10) {
        this.f17421e = f10;
    }

    public void setDistance(float f10) {
        this.f17422f = f10;
    }

    public void setId(String str) {
        this.f17417a = str;
    }

    public void setLocation(LatLonPoint latLonPoint) {
        this.f17420d = latLonPoint;
    }

    public void setName(String str) {
        this.f17418b = str;
    }

    public void setType(String str) {
        this.f17423g = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f17417a);
        parcel.writeString(this.f17418b);
        parcel.writeString(this.f17419c);
        parcel.writeParcelable(this.f17420d, i10);
        parcel.writeFloat(this.f17421e.floatValue());
        parcel.writeFloat(this.f17422f);
        parcel.writeString(this.f17423g);
    }

    public AoiItem(Parcel parcel) {
        this.f17417a = parcel.readString();
        this.f17418b = parcel.readString();
        this.f17419c = parcel.readString();
        this.f17420d = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
        this.f17421e = Float.valueOf(parcel.readFloat());
        this.f17422f = parcel.readFloat();
        this.f17423g = parcel.readString();
    }
}
