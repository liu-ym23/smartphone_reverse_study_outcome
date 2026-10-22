package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class TaxiItemV2 implements Parcelable {
    public static final Parcelable.Creator<TaxiItemV2> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private LatLonPoint f17938a;

    /* renamed from: b, reason: collision with root package name */
    private LatLonPoint f17939b;

    /* renamed from: c, reason: collision with root package name */
    private float f17940c;

    /* renamed from: d, reason: collision with root package name */
    private float f17941d;

    /* renamed from: e, reason: collision with root package name */
    private String f17942e;

    /* renamed from: f, reason: collision with root package name */
    private String f17943f;

    /* renamed from: g, reason: collision with root package name */
    private float f17944g;

    /* renamed from: h, reason: collision with root package name */
    private List<LatLonPoint> f17945h;

    public static class a implements Parcelable.Creator<TaxiItemV2> {
        @Override // android.os.Parcelable.Creator
        public TaxiItemV2 createFromParcel(Parcel parcel) {
            return new TaxiItemV2(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public TaxiItemV2[] newArray(int i10) {
            return new TaxiItemV2[i10];
        }
    }

    public TaxiItemV2() {
        this.f17945h = new ArrayList();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public LatLonPoint getDestination() {
        return this.f17939b;
    }

    public float getDistance() {
        return this.f17940c;
    }

    public float getDuration() {
        return this.f17941d;
    }

    public LatLonPoint getOrigin() {
        return this.f17938a;
    }

    public List<LatLonPoint> getPolyline() {
        return this.f17945h;
    }

    public float getPrice() {
        return this.f17944g;
    }

    public String getmSname() {
        return this.f17942e;
    }

    public String getmTname() {
        return this.f17943f;
    }

    public void setDestination(LatLonPoint latLonPoint) {
        this.f17939b = latLonPoint;
    }

    public void setDistance(float f10) {
        this.f17940c = f10;
    }

    public void setDuration(float f10) {
        this.f17941d = f10;
    }

    public void setOrigin(LatLonPoint latLonPoint) {
        this.f17938a = latLonPoint;
    }

    public void setPolyline(List<LatLonPoint> list) {
        this.f17945h = list;
    }

    public void setPrice(float f10) {
        this.f17944g = f10;
    }

    public void setSname(String str) {
        this.f17942e = str;
    }

    public void setTname(String str) {
        this.f17943f = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeParcelable(this.f17938a, i10);
        parcel.writeParcelable(this.f17939b, i10);
        parcel.writeFloat(this.f17940c);
        parcel.writeFloat(this.f17941d);
        parcel.writeString(this.f17942e);
        parcel.writeString(this.f17943f);
        parcel.writeFloat(this.f17944g);
        parcel.writeTypedList(this.f17945h);
    }

    public TaxiItemV2(Parcel parcel) {
        this.f17945h = new ArrayList();
        this.f17938a = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
        this.f17939b = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
        this.f17940c = parcel.readFloat();
        this.f17941d = parcel.readFloat();
        this.f17942e = parcel.readString();
        this.f17943f = parcel.readString();
        this.f17944g = parcel.readFloat();
        this.f17945h = parcel.createTypedArrayList(LatLonPoint.CREATOR);
    }
}
