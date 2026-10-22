package com.amap.api.services.geocoder;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;

/* loaded from: classes.dex */
public final class RegeocodeRoad implements Parcelable {
    public static final Parcelable.Creator<RegeocodeRoad> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private String f17470a;

    /* renamed from: b, reason: collision with root package name */
    private String f17471b;

    /* renamed from: c, reason: collision with root package name */
    private float f17472c;

    /* renamed from: d, reason: collision with root package name */
    private String f17473d;

    /* renamed from: e, reason: collision with root package name */
    private LatLonPoint f17474e;

    public static class a implements Parcelable.Creator<RegeocodeRoad> {
        @Override // android.os.Parcelable.Creator
        public RegeocodeRoad createFromParcel(Parcel parcel) {
            return new RegeocodeRoad(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ RegeocodeRoad[] newArray(int i10) {
            return null;
        }
    }

    public /* synthetic */ RegeocodeRoad(Parcel parcel, a aVar) {
        this(parcel);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getDirection() {
        return this.f17473d;
    }

    public float getDistance() {
        return this.f17472c;
    }

    public String getId() {
        return this.f17470a;
    }

    public LatLonPoint getLatLngPoint() {
        return this.f17474e;
    }

    public String getName() {
        return this.f17471b;
    }

    public void setDirection(String str) {
        this.f17473d = str;
    }

    public void setDistance(float f10) {
        this.f17472c = f10;
    }

    public void setId(String str) {
        this.f17470a = str;
    }

    public void setLatLngPoint(LatLonPoint latLonPoint) {
        this.f17474e = latLonPoint;
    }

    public void setName(String str) {
        this.f17471b = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f17470a);
        parcel.writeString(this.f17471b);
        parcel.writeFloat(this.f17472c);
        parcel.writeString(this.f17473d);
        parcel.writeValue(this.f17474e);
    }

    public RegeocodeRoad() {
    }

    private RegeocodeRoad(Parcel parcel) {
        this.f17470a = parcel.readString();
        this.f17471b = parcel.readString();
        this.f17472c = parcel.readFloat();
        this.f17473d = parcel.readString();
        this.f17474e = (LatLonPoint) parcel.readValue(LatLonPoint.class.getClassLoader());
    }
}
