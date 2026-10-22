package com.amap.api.services.poisearch;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;

/* loaded from: classes.dex */
public class SubPoiItemV2 implements Parcelable {
    public static final Parcelable.Creator<SubPoiItemV2> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private String f17606a;

    /* renamed from: b, reason: collision with root package name */
    private String f17607b;

    /* renamed from: c, reason: collision with root package name */
    private LatLonPoint f17608c;

    /* renamed from: d, reason: collision with root package name */
    private String f17609d;

    /* renamed from: e, reason: collision with root package name */
    private String f17610e;

    /* renamed from: f, reason: collision with root package name */
    private String f17611f;

    public static class a implements Parcelable.Creator<SubPoiItemV2> {
        @Override // android.os.Parcelable.Creator
        public SubPoiItemV2 createFromParcel(Parcel parcel) {
            return new SubPoiItemV2(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ SubPoiItemV2[] newArray(int i10) {
            return null;
        }
    }

    public SubPoiItemV2(String str, LatLonPoint latLonPoint, String str2, String str3) {
        this.f17606a = str;
        this.f17608c = latLonPoint;
        this.f17607b = str2;
        this.f17609d = str3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public LatLonPoint getLatLonPoint() {
        return this.f17608c;
    }

    public String getPoiId() {
        return this.f17606a;
    }

    public String getSnippet() {
        return this.f17609d;
    }

    public String getSubTypeDes() {
        return this.f17610e;
    }

    public String getTitle() {
        return this.f17607b;
    }

    public String getTypeCode() {
        return this.f17611f;
    }

    public void setLatLonPoint(LatLonPoint latLonPoint) {
        this.f17608c = latLonPoint;
    }

    public void setPoiId(String str) {
        this.f17606a = str;
    }

    public void setSnippet(String str) {
        this.f17609d = str;
    }

    public void setSubTypeDes(String str) {
        this.f17610e = str;
    }

    public void setTitle(String str) {
        this.f17607b = str;
    }

    public void setTypeCode(String str) {
        this.f17611f = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f17606a);
        parcel.writeString(this.f17607b);
        parcel.writeValue(this.f17608c);
        parcel.writeString(this.f17609d);
        parcel.writeString(this.f17610e);
        parcel.writeString(this.f17611f);
    }

    public SubPoiItemV2(Parcel parcel) {
        this.f17606a = parcel.readString();
        this.f17607b = parcel.readString();
        this.f17608c = (LatLonPoint) parcel.readValue(LatLonPoint.class.getClassLoader());
        this.f17609d = parcel.readString();
        this.f17610e = parcel.readString();
        this.f17611f = parcel.readString();
    }
}
