package com.amap.api.services.road;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;

/* loaded from: classes.dex */
public class Road implements Parcelable {
    public static final Parcelable.Creator<Road> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private String f17629a;

    /* renamed from: b, reason: collision with root package name */
    private String f17630b;

    /* renamed from: c, reason: collision with root package name */
    private String f17631c;

    /* renamed from: d, reason: collision with root package name */
    private float f17632d;

    /* renamed from: e, reason: collision with root package name */
    private String f17633e;

    /* renamed from: f, reason: collision with root package name */
    private LatLonPoint f17634f;

    public static class a implements Parcelable.Creator<Road> {
        @Override // android.os.Parcelable.Creator
        public Road createFromParcel(Parcel parcel) {
            return new Road(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ Road[] newArray(int i10) {
            return null;
        }
    }

    public Road() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public LatLonPoint getCenterPoint() {
        return this.f17634f;
    }

    public String getCityCode() {
        return this.f17631c;
    }

    public String getId() {
        return this.f17629a;
    }

    public String getName() {
        return this.f17630b;
    }

    public float getRoadWidth() {
        return this.f17632d;
    }

    public String getType() {
        return this.f17633e;
    }

    public void setCenterPoint(LatLonPoint latLonPoint) {
        this.f17634f = latLonPoint;
    }

    public void setCityCode(String str) {
        this.f17631c = str;
    }

    public void setId(String str) {
        this.f17629a = str;
    }

    public void setName(String str) {
        this.f17630b = str;
    }

    public void setRoadWidth(float f10) {
        this.f17632d = f10;
    }

    public void setType(String str) {
        this.f17633e = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f17629a);
        parcel.writeString(this.f17630b);
        parcel.writeString(this.f17631c);
        parcel.writeFloat(this.f17632d);
        parcel.writeString(this.f17633e);
        parcel.writeValue(this.f17634f);
    }

    public Road(String str, String str2) {
        this.f17629a = str;
        this.f17630b = str2;
    }

    public Road(Parcel parcel) {
        this.f17629a = parcel.readString();
        this.f17630b = parcel.readString();
        this.f17631c = parcel.readString();
        this.f17632d = parcel.readFloat();
        this.f17633e = parcel.readString();
        this.f17634f = (LatLonPoint) parcel.readValue(LatLonPoint.class.getClassLoader());
    }
}
