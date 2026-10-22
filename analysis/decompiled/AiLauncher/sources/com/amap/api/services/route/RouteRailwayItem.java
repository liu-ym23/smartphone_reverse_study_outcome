package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class RouteRailwayItem extends Railway implements Parcelable {
    public static final Parcelable.Creator<RouteRailwayItem> CREATOR = new a();

    /* renamed from: c, reason: collision with root package name */
    private String f17796c;

    /* renamed from: d, reason: collision with root package name */
    private String f17797d;

    /* renamed from: e, reason: collision with root package name */
    private float f17798e;

    /* renamed from: f, reason: collision with root package name */
    private String f17799f;

    /* renamed from: g, reason: collision with root package name */
    private RailwayStationItem f17800g;

    /* renamed from: h, reason: collision with root package name */
    private RailwayStationItem f17801h;

    /* renamed from: i, reason: collision with root package name */
    private List<RailwayStationItem> f17802i;

    /* renamed from: j, reason: collision with root package name */
    private List<Railway> f17803j;

    /* renamed from: k, reason: collision with root package name */
    private List<RailwaySpace> f17804k;

    public static class a implements Parcelable.Creator<RouteRailwayItem> {
        @Override // android.os.Parcelable.Creator
        public RouteRailwayItem createFromParcel(Parcel parcel) {
            return new RouteRailwayItem(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public RouteRailwayItem[] newArray(int i10) {
            return new RouteRailwayItem[i10];
        }
    }

    public RouteRailwayItem() {
        this.f17802i = new ArrayList();
        this.f17803j = new ArrayList();
        this.f17804k = new ArrayList();
    }

    @Override // com.amap.api.services.route.Railway, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<Railway> getAlters() {
        return this.f17803j;
    }

    public RailwayStationItem getArrivalstop() {
        return this.f17801h;
    }

    public RailwayStationItem getDeparturestop() {
        return this.f17800g;
    }

    public float getDistance() {
        return this.f17798e;
    }

    public List<RailwaySpace> getSpaces() {
        return this.f17804k;
    }

    public String getTime() {
        return this.f17796c;
    }

    public String getTrip() {
        return this.f17797d;
    }

    public String getType() {
        return this.f17799f;
    }

    public List<RailwayStationItem> getViastops() {
        return this.f17802i;
    }

    public void setAlters(List<Railway> list) {
        this.f17803j = list;
    }

    public void setArrivalstop(RailwayStationItem railwayStationItem) {
        this.f17801h = railwayStationItem;
    }

    public void setDeparturestop(RailwayStationItem railwayStationItem) {
        this.f17800g = railwayStationItem;
    }

    public void setDistance(float f10) {
        this.f17798e = f10;
    }

    public void setSpaces(List<RailwaySpace> list) {
        this.f17804k = list;
    }

    public void setTime(String str) {
        this.f17796c = str;
    }

    public void setTrip(String str) {
        this.f17797d = str;
    }

    public void setType(String str) {
        this.f17799f = str;
    }

    public void setViastops(List<RailwayStationItem> list) {
        this.f17802i = list;
    }

    @Override // com.amap.api.services.route.Railway, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        super.writeToParcel(parcel, i10);
        parcel.writeString(this.f17796c);
        parcel.writeString(this.f17797d);
        parcel.writeFloat(this.f17798e);
        parcel.writeString(this.f17799f);
        parcel.writeParcelable(this.f17800g, i10);
        parcel.writeParcelable(this.f17801h, i10);
        parcel.writeTypedList(this.f17802i);
        parcel.writeTypedList(this.f17803j);
        parcel.writeTypedList(this.f17804k);
    }

    public RouteRailwayItem(Parcel parcel) {
        super(parcel);
        this.f17802i = new ArrayList();
        this.f17803j = new ArrayList();
        this.f17804k = new ArrayList();
        this.f17796c = parcel.readString();
        this.f17797d = parcel.readString();
        this.f17798e = parcel.readFloat();
        this.f17799f = parcel.readString();
        this.f17800g = (RailwayStationItem) parcel.readParcelable(RailwayStationItem.class.getClassLoader());
        this.f17801h = (RailwayStationItem) parcel.readParcelable(RailwayStationItem.class.getClassLoader());
        this.f17802i = parcel.createTypedArrayList(RailwayStationItem.CREATOR);
        this.f17803j = parcel.createTypedArrayList(Railway.CREATOR);
        this.f17804k = parcel.createTypedArrayList(RailwaySpace.CREATOR);
    }
}
