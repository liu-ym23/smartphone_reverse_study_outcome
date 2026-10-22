package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes28.dex */
public class BusRouteResult extends RouteResult {
    public static final Parcelable.Creator<BusRouteResult> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f29048a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<BusPath> f29049b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private RouteSearch.BusRouteQuery f29050c;

    @Override // com.amap.api.services.route.RouteResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    public BusRouteResult() {
        this.f29049b = new ArrayList();
    }

    public RouteSearch.BusRouteQuery getBusQuery() {
        return this.f29050c;
    }

    public List<BusPath> getPaths() {
        return this.f29049b;
    }

    public float getTaxiCost() {
        return this.f29048a;
    }

    public BusRouteResult(Parcel r100) {
        super(r100);
        this.f29049b = new ArrayList();
        this.f29048a = r100.readFloat();
        this.f29049b = r100.createTypedArrayList(BusPath.CREATOR);
        this.f29050c = (RouteSearch.BusRouteQuery) r100.readParcelable(RouteSearch.BusRouteQuery.class.getClassLoader());
    }

    public void setBusQuery(RouteSearch.BusRouteQuery r100) {
        this.f29050c = r100;
    }

    public void setPaths(List<BusPath> r100) {
        this.f29049b = r100;
    }

    public void setTaxiCost(float r100) {
        this.f29048a = r100;
    }

    @Override // com.amap.api.services.route.RouteResult, android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        super.writeToParcel(r100, r101);
        r100.writeFloat(this.f29048a);
        r100.writeTypedList(this.f29049b);
        r100.writeParcelable(this.f29050c, r101);
    }
}
