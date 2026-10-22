package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class BusStep implements Parcelable {
    public static final Parcelable.Creator<BusStep> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private RouteBusWalkItem f17652a;

    /* renamed from: b, reason: collision with root package name */
    private List<RouteBusLineItem> f17653b;

    /* renamed from: c, reason: collision with root package name */
    private Doorway f17654c;

    /* renamed from: d, reason: collision with root package name */
    private Doorway f17655d;

    /* renamed from: e, reason: collision with root package name */
    private RouteRailwayItem f17656e;

    /* renamed from: f, reason: collision with root package name */
    private TaxiItem f17657f;

    public static class a implements Parcelable.Creator<BusStep> {
        @Override // android.os.Parcelable.Creator
        public BusStep createFromParcel(Parcel parcel) {
            return new BusStep(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ BusStep[] newArray(int i10) {
            return null;
        }
    }

    public BusStep(Parcel parcel) {
        this.f17653b = new ArrayList();
        this.f17652a = (RouteBusWalkItem) parcel.readParcelable(RouteBusWalkItem.class.getClassLoader());
        this.f17653b = parcel.createTypedArrayList(RouteBusLineItem.CREATOR);
        this.f17654c = (Doorway) parcel.readParcelable(Doorway.class.getClassLoader());
        this.f17655d = (Doorway) parcel.readParcelable(Doorway.class.getClassLoader());
        this.f17656e = (RouteRailwayItem) parcel.readParcelable(RouteRailwayItem.class.getClassLoader());
        this.f17657f = (TaxiItem) parcel.readParcelable(TaxiItem.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Deprecated
    public RouteBusLineItem getBusLine() {
        List<RouteBusLineItem> list = this.f17653b;
        if (list == null || list.size() == 0) {
            return null;
        }
        return this.f17653b.get(0);
    }

    public List<RouteBusLineItem> getBusLines() {
        return this.f17653b;
    }

    public Doorway getEntrance() {
        return this.f17654c;
    }

    public Doorway getExit() {
        return this.f17655d;
    }

    public RouteRailwayItem getRailway() {
        return this.f17656e;
    }

    public TaxiItem getTaxi() {
        return this.f17657f;
    }

    public RouteBusWalkItem getWalk() {
        return this.f17652a;
    }

    @Deprecated
    public void setBusLine(RouteBusLineItem routeBusLineItem) {
        List<RouteBusLineItem> list = this.f17653b;
        if (list == null) {
            return;
        }
        if (list.size() == 0) {
            this.f17653b.add(routeBusLineItem);
        }
        this.f17653b.set(0, routeBusLineItem);
    }

    public void setBusLines(List<RouteBusLineItem> list) {
        this.f17653b = list;
    }

    public void setEntrance(Doorway doorway) {
        this.f17654c = doorway;
    }

    public void setExit(Doorway doorway) {
        this.f17655d = doorway;
    }

    public void setRailway(RouteRailwayItem routeRailwayItem) {
        this.f17656e = routeRailwayItem;
    }

    public void setTaxi(TaxiItem taxiItem) {
        this.f17657f = taxiItem;
    }

    public void setWalk(RouteBusWalkItem routeBusWalkItem) {
        this.f17652a = routeBusWalkItem;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeParcelable(this.f17652a, i10);
        parcel.writeTypedList(this.f17653b);
        parcel.writeParcelable(this.f17654c, i10);
        parcel.writeParcelable(this.f17655d, i10);
        parcel.writeParcelable(this.f17656e, i10);
        parcel.writeParcelable(this.f17657f, i10);
    }

    public BusStep() {
        this.f17653b = new ArrayList();
    }
}
