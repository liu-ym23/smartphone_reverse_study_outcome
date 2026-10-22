package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.route.RouteSearch;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class BusRouteResult extends RouteResult implements Parcelable {
    public static final Parcelable.Creator<BusRouteResult> CREATOR = new a();

    /* renamed from: c, reason: collision with root package name */
    private float f17645c;

    /* renamed from: d, reason: collision with root package name */
    private List<BusPath> f17646d;

    /* renamed from: e, reason: collision with root package name */
    private RouteSearch.BusRouteQuery f17647e;

    public static class a implements Parcelable.Creator<BusRouteResult> {
        @Override // android.os.Parcelable.Creator
        public BusRouteResult createFromParcel(Parcel parcel) {
            return new BusRouteResult(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public BusRouteResult[] newArray(int i10) {
            return new BusRouteResult[i10];
        }
    }

    public BusRouteResult(Parcel parcel) {
        super(parcel);
        this.f17646d = new ArrayList();
        this.f17645c = parcel.readFloat();
        this.f17646d = parcel.createTypedArrayList(BusPath.CREATOR);
        this.f17647e = (RouteSearch.BusRouteQuery) parcel.readParcelable(RouteSearch.BusRouteQuery.class.getClassLoader());
    }

    @Override // com.amap.api.services.route.RouteResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public RouteSearch.BusRouteQuery getBusQuery() {
        return this.f17647e;
    }

    public List<BusPath> getPaths() {
        return this.f17646d;
    }

    public float getTaxiCost() {
        return this.f17645c;
    }

    public void setBusQuery(RouteSearch.BusRouteQuery busRouteQuery) {
        this.f17647e = busRouteQuery;
    }

    public void setPaths(List<BusPath> list) {
        this.f17646d = list;
    }

    public void setTaxiCost(float f10) {
        this.f17645c = f10;
    }

    @Override // com.amap.api.services.route.RouteResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        super.writeToParcel(parcel, i10);
        parcel.writeFloat(this.f17645c);
        parcel.writeTypedList(this.f17646d);
        parcel.writeParcelable(this.f17647e, i10);
    }

    public BusRouteResult() {
        this.f17646d = new ArrayList();
    }
}
