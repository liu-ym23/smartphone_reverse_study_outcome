package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.route.RouteSearch;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class RideRouteResult extends RouteResult implements Parcelable {
    public static final Parcelable.Creator<RideRouteResult> CREATOR = new a();

    /* renamed from: c, reason: collision with root package name */
    private List<RidePath> f17773c;

    /* renamed from: d, reason: collision with root package name */
    private RouteSearch.RideRouteQuery f17774d;

    public static class a implements Parcelable.Creator<RideRouteResult> {
        @Override // android.os.Parcelable.Creator
        public RideRouteResult createFromParcel(Parcel parcel) {
            return new RideRouteResult(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public RideRouteResult[] newArray(int i10) {
            return new RideRouteResult[i10];
        }
    }

    public RideRouteResult(Parcel parcel) {
        super(parcel);
        this.f17773c = new ArrayList();
        this.f17773c = parcel.createTypedArrayList(RidePath.CREATOR);
        this.f17774d = (RouteSearch.RideRouteQuery) parcel.readParcelable(RouteSearch.RideRouteQuery.class.getClassLoader());
    }

    @Override // com.amap.api.services.route.RouteResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<RidePath> getPaths() {
        return this.f17773c;
    }

    public RouteSearch.RideRouteQuery getRideQuery() {
        return this.f17774d;
    }

    public void setPaths(List<RidePath> list) {
        this.f17773c = list;
    }

    public void setRideQuery(RouteSearch.RideRouteQuery rideRouteQuery) {
        this.f17774d = rideRouteQuery;
    }

    @Override // com.amap.api.services.route.RouteResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        super.writeToParcel(parcel, i10);
        parcel.writeTypedList(this.f17773c);
        parcel.writeParcelable(this.f17774d, i10);
    }

    public RideRouteResult() {
        this.f17773c = new ArrayList();
    }
}
