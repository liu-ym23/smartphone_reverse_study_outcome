package com.amap.api.services.help;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;

/* loaded from: classes.dex */
public class Tip implements Parcelable {
    public static final Parcelable.Creator<Tip> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private String f17486a;

    /* renamed from: b, reason: collision with root package name */
    private LatLonPoint f17487b;

    /* renamed from: c, reason: collision with root package name */
    private String f17488c;

    /* renamed from: d, reason: collision with root package name */
    private String f17489d;

    /* renamed from: e, reason: collision with root package name */
    private String f17490e;

    /* renamed from: f, reason: collision with root package name */
    private String f17491f;

    /* renamed from: g, reason: collision with root package name */
    private String f17492g;

    /* renamed from: h, reason: collision with root package name */
    private String f17493h;

    public static class a implements Parcelable.Creator<Tip> {
        @Override // android.os.Parcelable.Creator
        public Tip createFromParcel(Parcel parcel) {
            return new Tip(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ Tip[] newArray(int i10) {
            return null;
        }
    }

    public /* synthetic */ Tip(Parcel parcel, a aVar) {
        this(parcel);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAdcode() {
        return this.f17490e;
    }

    public String getAddress() {
        return this.f17491f;
    }

    public String getDistrict() {
        return this.f17489d;
    }

    public String getName() {
        return this.f17488c;
    }

    public String getPoiID() {
        return this.f17486a;
    }

    public LatLonPoint getPoint() {
        return this.f17487b;
    }

    public String getTypeCode() {
        return this.f17492g;
    }

    public void setAdcode(String str) {
        this.f17490e = str;
    }

    public void setAddress(String str) {
        this.f17491f = str;
    }

    public void setDistrict(String str) {
        this.f17489d = str;
    }

    public void setID(String str) {
        this.f17486a = str;
    }

    public void setName(String str) {
        this.f17488c = str;
    }

    public void setPostion(LatLonPoint latLonPoint) {
        this.f17487b = latLonPoint;
    }

    public void setTypeCode(String str) {
        this.f17492g = str;
    }

    public String toString() {
        return "name:" + this.f17488c + " district:" + this.f17489d + " adcode:" + this.f17490e;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f17488c);
        parcel.writeString(this.f17490e);
        parcel.writeString(this.f17489d);
        parcel.writeString(this.f17486a);
        parcel.writeValue(this.f17487b);
        parcel.writeString(this.f17491f);
        parcel.writeString(this.f17492g);
        parcel.writeString(this.f17493h);
    }

    public Tip() {
        this.f17493h = "";
    }

    private Tip(Parcel parcel) {
        this.f17493h = "";
        this.f17488c = parcel.readString();
        this.f17490e = parcel.readString();
        this.f17489d = parcel.readString();
        this.f17486a = parcel.readString();
        this.f17487b = (LatLonPoint) parcel.readValue(LatLonPoint.class.getClassLoader());
        this.f17491f = parcel.readString();
        this.f17492g = parcel.readString();
        this.f17493h = parcel.readString();
    }
}
