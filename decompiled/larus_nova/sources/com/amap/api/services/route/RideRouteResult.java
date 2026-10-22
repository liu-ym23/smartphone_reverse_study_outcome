package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes28.dex */
public class RideRouteResult extends RouteResult {
    public static final Parcelable.Creator<RideRouteResult> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<RidePath> f29124a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private RouteSearch.RideRouteQuery f29125b;

    @Override // com.amap.api.services.route.RouteResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    public RideRouteResult() {
        this.f29124a = new ArrayList();
    }

    public List<RidePath> getPaths() {
        return this.f29124a;
    }

    public RouteSearch.RideRouteQuery getRideQuery() {
        return this.f29125b;
    }

    public RideRouteResult(Parcel r100) {
        super(r100);
        this.f29124a = new ArrayList();
        this.f29124a = r100.createTypedArrayList(RidePath.CREATOR);
        this.f29125b = (RouteSearch.RideRouteQuery) r100.readParcelable(RouteSearch.RideRouteQuery.class.getClassLoader());
    }

    public void setPaths(List<RidePath> r100) {
        this.f29124a = r100;
    }

    public void setRideQuery(RouteSearch.RideRouteQuery r100) {
        this.f29125b = r100;
    }

    @Override // com.amap.api.services.route.RouteResult, android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        super.writeToParcel(r100, r101);
        r100.writeTypedList(this.f29124a);
        r100.writeParcelable(this.f29125b, r101);
    }
}
