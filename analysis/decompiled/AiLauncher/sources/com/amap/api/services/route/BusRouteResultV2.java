package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.route.RouteSearchV2;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class BusRouteResultV2 extends RouteResult implements Parcelable {
    public static final Parcelable.Creator<BusRouteResultV2> CREATOR = new a();

    /* renamed from: c, reason: collision with root package name */
    private float f17648c;

    /* renamed from: d, reason: collision with root package name */
    private List<BusPathV2> f17649d;

    /* renamed from: e, reason: collision with root package name */
    private RouteSearchV2.BusRouteQuery f17650e;

    /* renamed from: f, reason: collision with root package name */
    private float f17651f;

    public static class a implements Parcelable.Creator<BusRouteResultV2> {
        @Override // android.os.Parcelable.Creator
        public BusRouteResultV2 createFromParcel(Parcel parcel) {
            return new BusRouteResultV2(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public BusRouteResultV2[] newArray(int i10) {
            return new BusRouteResultV2[i10];
        }
    }

    public BusRouteResultV2(Parcel parcel) {
        super(parcel);
        this.f17649d = new ArrayList();
        this.f17648c = parcel.readFloat();
        this.f17649d = parcel.createTypedArrayList(BusPathV2.CREATOR);
        this.f17650e = (RouteSearchV2.BusRouteQuery) parcel.readParcelable(RouteSearchV2.BusRouteQuery.class.getClassLoader());
        this.f17651f = parcel.readFloat();
    }

    @Override // com.amap.api.services.route.RouteResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public RouteSearchV2.BusRouteQuery getBusQuery() {
        return this.f17650e;
    }

    public float getDistance() {
        return this.f17651f;
    }

    public List<BusPathV2> getPaths() {
        return this.f17649d;
    }

    public float getTaxiCost() {
        return this.f17648c;
    }

    public void setBusQuery(RouteSearchV2.BusRouteQuery busRouteQuery) {
        this.f17650e = busRouteQuery;
    }

    public void setDistance(float f10) {
        this.f17651f = f10;
    }

    public void setPaths(List<BusPathV2> list) {
        this.f17649d = list;
    }

    public void setTaxiCost(float f10) {
        this.f17648c = f10;
    }

    @Override // com.amap.api.services.route.RouteResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        super.writeToParcel(parcel, i10);
        parcel.writeFloat(this.f17648c);
        parcel.writeTypedList(this.f17649d);
        parcel.writeParcelable(this.f17650e, i10);
        parcel.writeFloat(this.f17651f);
    }

    public BusRouteResultV2() {
        this.f17649d = new ArrayList();
    }
}
