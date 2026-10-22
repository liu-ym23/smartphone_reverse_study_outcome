package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class BusStepV2 implements Parcelable {
    public static final Parcelable.Creator<BusStepV2> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private RouteBusWalkItem f17658a;

    /* renamed from: b, reason: collision with root package name */
    private List<RouteBusLineItem> f17659b;

    /* renamed from: c, reason: collision with root package name */
    private Doorway f17660c;

    /* renamed from: d, reason: collision with root package name */
    private Doorway f17661d;

    /* renamed from: e, reason: collision with root package name */
    private RouteRailwayItem f17662e;

    /* renamed from: f, reason: collision with root package name */
    private TaxiItemV2 f17663f;

    public static class a implements Parcelable.Creator<BusStepV2> {
        @Override // android.os.Parcelable.Creator
        public BusStepV2 createFromParcel(Parcel parcel) {
            return new BusStepV2(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ BusStepV2[] newArray(int i10) {
            return null;
        }
    }

    public BusStepV2(Parcel parcel) {
        this.f17659b = new ArrayList();
        this.f17658a = (RouteBusWalkItem) parcel.readParcelable(RouteBusWalkItem.class.getClassLoader());
        this.f17659b = parcel.createTypedArrayList(RouteBusLineItem.CREATOR);
        this.f17660c = (Doorway) parcel.readParcelable(Doorway.class.getClassLoader());
        this.f17661d = (Doorway) parcel.readParcelable(Doorway.class.getClassLoader());
        this.f17662e = (RouteRailwayItem) parcel.readParcelable(RouteRailwayItem.class.getClassLoader());
        this.f17663f = (TaxiItemV2) parcel.readParcelable(TaxiItem.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Deprecated
    public RouteBusLineItem getBusLine() {
        List<RouteBusLineItem> list = this.f17659b;
        if (list == null || list.size() == 0) {
            return null;
        }
        return this.f17659b.get(0);
    }

    public List<RouteBusLineItem> getBusLines() {
        return this.f17659b;
    }

    public Doorway getEntrance() {
        return this.f17660c;
    }

    public Doorway getExit() {
        return this.f17661d;
    }

    public RouteRailwayItem getRailway() {
        return this.f17662e;
    }

    public TaxiItemV2 getTaxi() {
        return this.f17663f;
    }

    public RouteBusWalkItem getWalk() {
        return this.f17658a;
    }

    @Deprecated
    public void setBusLine(RouteBusLineItem routeBusLineItem) {
        List<RouteBusLineItem> list = this.f17659b;
        if (list == null) {
            return;
        }
        if (list.size() == 0) {
            this.f17659b.add(routeBusLineItem);
        }
        this.f17659b.set(0, routeBusLineItem);
    }

    public void setBusLines(List<RouteBusLineItem> list) {
        this.f17659b = list;
    }

    public void setEntrance(Doorway doorway) {
        this.f17660c = doorway;
    }

    public void setExit(Doorway doorway) {
        this.f17661d = doorway;
    }

    public void setRailway(RouteRailwayItem routeRailwayItem) {
        this.f17662e = routeRailwayItem;
    }

    public void setTaxi(TaxiItemV2 taxiItemV2) {
        this.f17663f = taxiItemV2;
    }

    public void setWalk(RouteBusWalkItem routeBusWalkItem) {
        this.f17658a = routeBusWalkItem;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeParcelable(this.f17658a, i10);
        parcel.writeTypedList(this.f17659b);
        parcel.writeParcelable(this.f17660c, i10);
        parcel.writeParcelable(this.f17661d, i10);
        parcel.writeParcelable(this.f17662e, i10);
        parcel.writeParcelable(this.f17663f, i10);
    }

    public BusStepV2() {
        this.f17659b = new ArrayList();
    }
}
