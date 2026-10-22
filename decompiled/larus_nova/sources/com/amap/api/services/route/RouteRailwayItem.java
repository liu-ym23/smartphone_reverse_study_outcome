package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes28.dex */
public class RouteRailwayItem extends Railway {
    public static final Parcelable.Creator<RouteRailwayItem> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f29144a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f29145b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float f29146c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f29147d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private RailwayStationItem f29148e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private RailwayStationItem f29149f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private List<RailwayStationItem> f29150g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private List<Railway> f29151h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private List<RailwaySpace> f29152i;

    @Override // com.amap.api.services.route.Railway, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    public RouteRailwayItem() {
        this.f29150g = new ArrayList();
        this.f29151h = new ArrayList();
        this.f29152i = new ArrayList();
    }

    public List<Railway> getAlters() {
        return this.f29151h;
    }

    public RailwayStationItem getArrivalstop() {
        return this.f29149f;
    }

    public RailwayStationItem getDeparturestop() {
        return this.f29148e;
    }

    public float getDistance() {
        return this.f29146c;
    }

    public List<RailwaySpace> getSpaces() {
        return this.f29152i;
    }

    public String getTime() {
        return this.f29144a;
    }

    public String getTrip() {
        return this.f29145b;
    }

    public String getType() {
        return this.f29147d;
    }

    public List<RailwayStationItem> getViastops() {
        return this.f29150g;
    }

    public RouteRailwayItem(Parcel r100) {
        super(r100);
        this.f29150g = new ArrayList();
        this.f29151h = new ArrayList();
        this.f29152i = new ArrayList();
        this.f29144a = r100.readString();
        this.f29145b = r100.readString();
        this.f29146c = r100.readFloat();
        this.f29147d = r100.readString();
        this.f29148e = (RailwayStationItem) r100.readParcelable(RailwayStationItem.class.getClassLoader());
        this.f29149f = (RailwayStationItem) r100.readParcelable(RailwayStationItem.class.getClassLoader());
        this.f29150g = r100.createTypedArrayList(RailwayStationItem.CREATOR);
        this.f29151h = r100.createTypedArrayList(Railway.CREATOR);
        this.f29152i = r100.createTypedArrayList(RailwaySpace.CREATOR);
    }

    public void setAlters(List<Railway> r100) {
        this.f29151h = r100;
    }

    public void setArrivalstop(RailwayStationItem r100) {
        this.f29149f = r100;
    }

    public void setDeparturestop(RailwayStationItem r100) {
        this.f29148e = r100;
    }

    public void setDistance(float r100) {
        this.f29146c = r100;
    }

    public void setSpaces(List<RailwaySpace> r100) {
        this.f29152i = r100;
    }

    public void setTime(String r100) {
        this.f29144a = r100;
    }

    public void setTrip(String r100) {
        this.f29145b = r100;
    }

    public void setType(String r100) {
        this.f29147d = r100;
    }

    public void setViastops(List<RailwayStationItem> r100) {
        this.f29150g = r100;
    }

    @Override // com.amap.api.services.route.Railway, android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        super.writeToParcel(r100, r101);
        r100.writeString(this.f29144a);
        r100.writeString(this.f29145b);
        r100.writeFloat(this.f29146c);
        r100.writeString(this.f29147d);
        r100.writeParcelable(this.f29148e, r101);
        r100.writeParcelable(this.f29149f, r101);
        r100.writeTypedList(this.f29150g);
        r100.writeTypedList(this.f29151h);
        r100.writeTypedList(this.f29152i);
    }
}
