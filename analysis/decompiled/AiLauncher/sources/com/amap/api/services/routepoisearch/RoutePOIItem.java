package com.amap.api.services.routepoisearch;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;

/* loaded from: classes.dex */
public class RoutePOIItem implements Parcelable {
    public static final Parcelable.Creator<RoutePOIItem> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private String f17992a;

    /* renamed from: b, reason: collision with root package name */
    private String f17993b;

    /* renamed from: c, reason: collision with root package name */
    private LatLonPoint f17994c;

    /* renamed from: d, reason: collision with root package name */
    private float f17995d;

    /* renamed from: e, reason: collision with root package name */
    private float f17996e;

    /* renamed from: f, reason: collision with root package name */
    private String f17997f;

    public static class a implements Parcelable.Creator<RoutePOIItem> {
        @Override // android.os.Parcelable.Creator
        public RoutePOIItem createFromParcel(Parcel parcel) {
            return new RoutePOIItem(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public RoutePOIItem[] newArray(int i10) {
            return new RoutePOIItem[i10];
        }
    }

    public RoutePOIItem() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getCPID() {
        return this.f17997f;
    }

    public float getDistance() {
        return this.f17995d;
    }

    public float getDuration() {
        return this.f17996e;
    }

    public String getID() {
        return this.f17992a;
    }

    public LatLonPoint getPoint() {
        return this.f17994c;
    }

    public String getTitle() {
        return this.f17993b;
    }

    public void setCPID(String str) {
        this.f17997f = str;
    }

    public void setDistance(float f10) {
        this.f17995d = f10;
    }

    public void setDuration(float f10) {
        this.f17996e = f10;
    }

    public void setID(String str) {
        this.f17992a = str;
    }

    public void setPoint(LatLonPoint latLonPoint) {
        this.f17994c = latLonPoint;
    }

    public void setTitle(String str) {
        this.f17993b = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f17992a);
        parcel.writeString(this.f17993b);
        parcel.writeParcelable(this.f17994c, i10);
        parcel.writeFloat(this.f17995d);
        parcel.writeFloat(this.f17996e);
        parcel.writeString(this.f17997f);
    }

    public RoutePOIItem(Parcel parcel) {
        this.f17992a = parcel.readString();
        this.f17993b = parcel.readString();
        this.f17994c = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
        this.f17995d = parcel.readFloat();
        this.f17996e = parcel.readFloat();
        this.f17997f = parcel.readString();
    }
}
