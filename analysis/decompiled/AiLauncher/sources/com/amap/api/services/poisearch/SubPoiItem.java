package com.amap.api.services.poisearch;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;

/* loaded from: classes.dex */
public class SubPoiItem implements Parcelable {
    public static final Parcelable.Creator<SubPoiItem> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private String f17599a;

    /* renamed from: b, reason: collision with root package name */
    private String f17600b;

    /* renamed from: c, reason: collision with root package name */
    private String f17601c;

    /* renamed from: d, reason: collision with root package name */
    private int f17602d;

    /* renamed from: e, reason: collision with root package name */
    private LatLonPoint f17603e;

    /* renamed from: f, reason: collision with root package name */
    private String f17604f;

    /* renamed from: g, reason: collision with root package name */
    private String f17605g;

    public static class a implements Parcelable.Creator<SubPoiItem> {
        @Override // android.os.Parcelable.Creator
        public SubPoiItem createFromParcel(Parcel parcel) {
            return new SubPoiItem(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ SubPoiItem[] newArray(int i10) {
            return null;
        }
    }

    public SubPoiItem(String str, LatLonPoint latLonPoint, String str2, String str3) {
        this.f17599a = str;
        this.f17603e = latLonPoint;
        this.f17600b = str2;
        this.f17604f = str3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getDistance() {
        return this.f17602d;
    }

    public LatLonPoint getLatLonPoint() {
        return this.f17603e;
    }

    public String getPoiId() {
        return this.f17599a;
    }

    public String getSnippet() {
        return this.f17604f;
    }

    public String getSubName() {
        return this.f17601c;
    }

    public String getSubTypeDes() {
        return this.f17605g;
    }

    public String getTitle() {
        return this.f17600b;
    }

    public void setDistance(int i10) {
        this.f17602d = i10;
    }

    public void setLatLonPoint(LatLonPoint latLonPoint) {
        this.f17603e = latLonPoint;
    }

    public void setPoiId(String str) {
        this.f17599a = str;
    }

    public void setSnippet(String str) {
        this.f17604f = str;
    }

    public void setSubName(String str) {
        this.f17601c = str;
    }

    public void setSubTypeDes(String str) {
        this.f17605g = str;
    }

    public void setTitle(String str) {
        this.f17600b = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f17599a);
        parcel.writeString(this.f17600b);
        parcel.writeString(this.f17601c);
        parcel.writeInt(this.f17602d);
        parcel.writeValue(this.f17603e);
        parcel.writeString(this.f17604f);
        parcel.writeString(this.f17605g);
    }

    public SubPoiItem(Parcel parcel) {
        this.f17599a = parcel.readString();
        this.f17600b = parcel.readString();
        this.f17601c = parcel.readString();
        this.f17602d = parcel.readInt();
        this.f17603e = (LatLonPoint) parcel.readValue(LatLonPoint.class.getClassLoader());
        this.f17604f = parcel.readString();
        this.f17605g = parcel.readString();
    }
}
