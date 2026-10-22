package com.baidu.mapapi.search.core;

import B0.g;
import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.model.LatLng;

/* loaded from: classes.dex */
public class RecommendStopInfo implements Parcelable {
    public static final Parcelable.Creator<RecommendStopInfo> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private String f7310a;

    /* renamed from: b, reason: collision with root package name */
    private LatLng f7311b;

    /* renamed from: c, reason: collision with root package name */
    private double f7312c;

    /* renamed from: d, reason: collision with root package name */
    private String f7313d;

    /* renamed from: e, reason: collision with root package name */
    private String f7314e;

    public static class a implements Parcelable.Creator<RecommendStopInfo> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public RecommendStopInfo createFromParcel(Parcel parcel) {
            return new RecommendStopInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public RecommendStopInfo[] newArray(int i4) {
            return new RecommendStopInfo[i4];
        }
    }

    public RecommendStopInfo() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAddress() {
        return this.f7314e;
    }

    public double getDistance() {
        return this.f7312c;
    }

    public String getId() {
        return this.f7313d;
    }

    public LatLng getLocation() {
        return this.f7311b;
    }

    public String getName() {
        return this.f7310a;
    }

    public void setAddress(String str) {
        this.f7314e = str;
    }

    public void setDistance(double d4) {
        this.f7312c = d4;
    }

    public void setId(String str) {
        this.f7313d = str;
    }

    public void setLocation(LatLng latLng) {
        this.f7311b = latLng;
    }

    public void setName(String str) {
        this.f7310a = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("RecommendStopInfo{mName='");
        sb.append(this.f7310a);
        sb.append("', mLocation=");
        sb.append(this.f7311b);
        sb.append(", mDistance=");
        sb.append(this.f7312c);
        sb.append(", mId='");
        sb.append(this.f7313d);
        sb.append("', mAddress='");
        return g.r(sb, this.f7314e, "'}");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeString(this.f7310a);
        parcel.writeParcelable(this.f7311b, i4);
        parcel.writeDouble(this.f7312c);
        parcel.writeString(this.f7314e);
        parcel.writeString(this.f7313d);
    }

    public RecommendStopInfo(Parcel parcel) {
        this.f7310a = parcel.readString();
        this.f7311b = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
        this.f7312c = parcel.readDouble();
        this.f7314e = parcel.readString();
        this.f7313d = parcel.readString();
    }
}
