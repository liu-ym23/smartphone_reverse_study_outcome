package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class RouteSearchCity extends SearchCity implements Parcelable {
    public static final Parcelable.Creator<RouteSearchCity> CREATOR = new a();

    /* renamed from: d, reason: collision with root package name */
    List<District> f17854d;

    public static class a implements Parcelable.Creator<RouteSearchCity> {
        @Override // android.os.Parcelable.Creator
        public RouteSearchCity createFromParcel(Parcel parcel) {
            return new RouteSearchCity(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ RouteSearchCity[] newArray(int i10) {
            return null;
        }
    }

    public RouteSearchCity(Parcel parcel) {
        super(parcel);
        this.f17854d = new ArrayList();
        this.f17854d = parcel.createTypedArrayList(District.CREATOR);
    }

    @Override // com.amap.api.services.route.SearchCity, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<District> getDistricts() {
        return this.f17854d;
    }

    public void setDistricts(List<District> list) {
        this.f17854d = list;
    }

    @Override // com.amap.api.services.route.SearchCity, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        super.writeToParcel(parcel, i10);
        parcel.writeTypedList(this.f17854d);
    }

    public RouteSearchCity() {
        this.f17854d = new ArrayList();
    }
}
