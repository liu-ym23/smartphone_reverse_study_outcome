package com.amap.api.fence;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class PoiItem implements Parcelable {
    public static final Parcelable.Creator<PoiItem> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private String f17095a;

    /* renamed from: b, reason: collision with root package name */
    private String f17096b;

    /* renamed from: c, reason: collision with root package name */
    private String f17097c;

    /* renamed from: d, reason: collision with root package name */
    private String f17098d;

    /* renamed from: e, reason: collision with root package name */
    private String f17099e;

    /* renamed from: f, reason: collision with root package name */
    private double f17100f;

    /* renamed from: g, reason: collision with root package name */
    private double f17101g;

    /* renamed from: h, reason: collision with root package name */
    private String f17102h;

    /* renamed from: i, reason: collision with root package name */
    private String f17103i;

    /* renamed from: j, reason: collision with root package name */
    private String f17104j;

    /* renamed from: k, reason: collision with root package name */
    private String f17105k;

    public static class a implements Parcelable.Creator<PoiItem> {
        @Override // android.os.Parcelable.Creator
        public PoiItem createFromParcel(Parcel parcel) {
            return new PoiItem(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public PoiItem[] newArray(int i10) {
            return new PoiItem[i10];
        }
    }

    public PoiItem() {
        this.f17095a = "";
        this.f17096b = "";
        this.f17097c = "";
        this.f17098d = "";
        this.f17099e = "";
        this.f17100f = 0.0d;
        this.f17101g = 0.0d;
        this.f17102h = "";
        this.f17103i = "";
        this.f17104j = "";
        this.f17105k = "";
    }

    public static Parcelable.Creator<PoiItem> getCreator() {
        return CREATOR;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAddress() {
        return this.f17099e;
    }

    public String getAdname() {
        return this.f17105k;
    }

    public String getCity() {
        return this.f17104j;
    }

    public double getLatitude() {
        return this.f17100f;
    }

    public double getLongitude() {
        return this.f17101g;
    }

    public String getPoiId() {
        return this.f17096b;
    }

    public String getPoiName() {
        return this.f17095a;
    }

    public String getPoiType() {
        return this.f17097c;
    }

    public String getProvince() {
        return this.f17103i;
    }

    public String getTel() {
        return this.f17102h;
    }

    public String getTypeCode() {
        return this.f17098d;
    }

    public void setAddress(String str) {
        this.f17099e = str;
    }

    public void setAdname(String str) {
        this.f17105k = str;
    }

    public void setCity(String str) {
        this.f17104j = str;
    }

    public void setLatitude(double d10) {
        this.f17100f = d10;
    }

    public void setLongitude(double d10) {
        this.f17101g = d10;
    }

    public void setPoiId(String str) {
        this.f17096b = str;
    }

    public void setPoiName(String str) {
        this.f17095a = str;
    }

    public void setPoiType(String str) {
        this.f17097c = str;
    }

    public void setProvince(String str) {
        this.f17103i = str;
    }

    public void setTel(String str) {
        this.f17102h = str;
    }

    public void setTypeCode(String str) {
        this.f17098d = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f17095a);
        parcel.writeString(this.f17096b);
        parcel.writeString(this.f17097c);
        parcel.writeString(this.f17098d);
        parcel.writeString(this.f17099e);
        parcel.writeDouble(this.f17100f);
        parcel.writeDouble(this.f17101g);
        parcel.writeString(this.f17102h);
        parcel.writeString(this.f17103i);
        parcel.writeString(this.f17104j);
        parcel.writeString(this.f17105k);
    }

    public PoiItem(Parcel parcel) {
        this.f17095a = "";
        this.f17096b = "";
        this.f17097c = "";
        this.f17098d = "";
        this.f17099e = "";
        this.f17100f = 0.0d;
        this.f17101g = 0.0d;
        this.f17102h = "";
        this.f17103i = "";
        this.f17104j = "";
        this.f17105k = "";
        this.f17095a = parcel.readString();
        this.f17096b = parcel.readString();
        this.f17097c = parcel.readString();
        this.f17098d = parcel.readString();
        this.f17099e = parcel.readString();
        this.f17100f = parcel.readDouble();
        this.f17101g = parcel.readDouble();
        this.f17102h = parcel.readString();
        this.f17103i = parcel.readString();
        this.f17104j = parcel.readString();
        this.f17105k = parcel.readString();
    }
}
