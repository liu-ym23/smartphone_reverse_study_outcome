package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.route.RouteSearch;
import java.util.List;

/* loaded from: classes.dex */
public class TruckRouteRestult implements Parcelable {
    public static final Parcelable.Creator<TruckRouteRestult> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private RouteSearch.TruckRouteQuery f17961a;

    /* renamed from: b, reason: collision with root package name */
    private List<TruckPath> f17962b;

    /* renamed from: c, reason: collision with root package name */
    private LatLonPoint f17963c;

    /* renamed from: d, reason: collision with root package name */
    private LatLonPoint f17964d;

    public static class a implements Parcelable.Creator<TruckRouteRestult> {
        @Override // android.os.Parcelable.Creator
        public TruckRouteRestult createFromParcel(Parcel parcel) {
            return new TruckRouteRestult(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public TruckRouteRestult[] newArray(int i10) {
            return new TruckRouteRestult[i10];
        }
    }

    public TruckRouteRestult() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<TruckPath> getPaths() {
        return this.f17962b;
    }

    public LatLonPoint getStartPos() {
        return this.f17963c;
    }

    public LatLonPoint getTargetPos() {
        return this.f17964d;
    }

    public RouteSearch.TruckRouteQuery getTruckQuery() {
        return this.f17961a;
    }

    public void setPaths(List<TruckPath> list) {
        this.f17962b = list;
    }

    public void setStartPos(LatLonPoint latLonPoint) {
        this.f17963c = latLonPoint;
    }

    public void setTargetPos(LatLonPoint latLonPoint) {
        this.f17964d = latLonPoint;
    }

    public void setTruckQuery(RouteSearch.TruckRouteQuery truckRouteQuery) {
        this.f17961a = truckRouteQuery;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeTypedList(this.f17962b);
        parcel.writeParcelable(this.f17963c, i10);
        parcel.writeParcelable(this.f17964d, i10);
    }

    public TruckRouteRestult(Parcel parcel) {
        this.f17962b = parcel.createTypedArrayList(TruckPath.CREATOR);
        this.f17963c = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
        this.f17964d = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
    }
}
