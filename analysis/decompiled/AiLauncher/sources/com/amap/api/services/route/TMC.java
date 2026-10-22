package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class TMC implements Parcelable {
    public static final Parcelable.Creator<TMC> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private int f17929a;

    /* renamed from: b, reason: collision with root package name */
    private String f17930b;

    /* renamed from: c, reason: collision with root package name */
    private List<LatLonPoint> f17931c;

    public static class a implements Parcelable.Creator<TMC> {
        @Override // android.os.Parcelable.Creator
        public TMC createFromParcel(Parcel parcel) {
            return new TMC(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ TMC[] newArray(int i10) {
            return null;
        }
    }

    public TMC(Parcel parcel) {
        this.f17931c = new ArrayList();
        this.f17929a = parcel.readInt();
        this.f17930b = parcel.readString();
        this.f17931c = parcel.createTypedArrayList(LatLonPoint.CREATOR);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getDistance() {
        return this.f17929a;
    }

    public List<LatLonPoint> getPolyline() {
        return this.f17931c;
    }

    public String getStatus() {
        return this.f17930b;
    }

    public void setDistance(int i10) {
        this.f17929a = i10;
    }

    public void setPolyline(List<LatLonPoint> list) {
        this.f17931c = list;
    }

    public void setStatus(String str) {
        this.f17930b = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f17929a);
        parcel.writeString(this.f17930b);
        parcel.writeTypedList(this.f17931c);
    }

    public TMC() {
        this.f17931c = new ArrayList();
    }
}
