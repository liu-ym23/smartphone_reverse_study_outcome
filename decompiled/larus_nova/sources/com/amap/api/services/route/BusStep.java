package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes28.dex */
public class BusStep implements Parcelable {
    public static final Parcelable.Creator<BusStep> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private RouteBusWalkItem f29051a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<RouteBusLineItem> f29052b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Doorway f29053c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Doorway f29054d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private RouteRailwayItem f29055e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private TaxiItem f29056f;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    public RouteBusLineItem getBusLine() {
        List<RouteBusLineItem> r100 = this.f29052b;
        if (r100 != null) goto L5;
        return null;
    L5:
        if (r100.size() != 0) goto L8;
        return null;
    L8:
        return (RouteBusLineItem) ListProtector.get(this.f29052b, 0);
    }

    public BusStep() {
        this.f29052b = new ArrayList();
    }

    public List<RouteBusLineItem> getBusLines() {
        return this.f29052b;
    }

    public Doorway getEntrance() {
        return this.f29053c;
    }

    public Doorway getExit() {
        return this.f29054d;
    }

    public RouteRailwayItem getRailway() {
        return this.f29055e;
    }

    public TaxiItem getTaxi() {
        return this.f29056f;
    }

    public RouteBusWalkItem getWalk() {
        return this.f29051a;
    }

    public BusStep(Parcel r100) {
        this.f29052b = new ArrayList();
        this.f29051a = (RouteBusWalkItem) r100.readParcelable(RouteBusWalkItem.class.getClassLoader());
        this.f29052b = r100.createTypedArrayList(RouteBusLineItem.CREATOR);
        this.f29053c = (Doorway) r100.readParcelable(Doorway.class.getClassLoader());
        this.f29054d = (Doorway) r100.readParcelable(Doorway.class.getClassLoader());
        this.f29055e = (RouteRailwayItem) r100.readParcelable(RouteRailwayItem.class.getClassLoader());
        this.f29056f = (TaxiItem) r100.readParcelable(TaxiItem.class.getClassLoader());
    }

    public void setBusLine(RouteBusLineItem r100) {
        List<RouteBusLineItem> r101 = this.f29052b;
        if (r101 != null) goto L6;
        return;
    L6:
        if (r101.size() != 0) goto L8;
        this.f29052b.add(r100);
    L8:
        ListProtector.set(this.f29052b, 0, r100);
    }

    public void setBusLines(List<RouteBusLineItem> r100) {
        this.f29052b = r100;
    }

    public void setEntrance(Doorway r100) {
        this.f29053c = r100;
    }

    public void setExit(Doorway r100) {
        this.f29054d = r100;
    }

    public void setRailway(RouteRailwayItem r100) {
        this.f29055e = r100;
    }

    public void setTaxi(TaxiItem r100) {
        this.f29056f = r100;
    }

    public void setWalk(RouteBusWalkItem r100) {
        this.f29051a = r100;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeParcelable(this.f29051a, r101);
        r100.writeTypedList(this.f29052b);
        r100.writeParcelable(this.f29053c, r101);
        r100.writeParcelable(this.f29054d, r101);
        r100.writeParcelable(this.f29055e, r101);
        r100.writeParcelable(this.f29056f, r101);
    }
}
