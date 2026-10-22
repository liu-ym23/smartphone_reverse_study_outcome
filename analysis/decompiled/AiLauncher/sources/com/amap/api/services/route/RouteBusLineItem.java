package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.busline.BusLineItem;
import com.amap.api.services.busline.BusStationItem;
import com.amap.api.services.core.LatLonPoint;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class RouteBusLineItem extends BusLineItem implements Parcelable {
    public static final Parcelable.Creator<RouteBusLineItem> CREATOR = new a();

    /* renamed from: p, reason: collision with root package name */
    private BusStationItem f17786p;

    /* renamed from: q, reason: collision with root package name */
    private BusStationItem f17787q;

    /* renamed from: r, reason: collision with root package name */
    private List<LatLonPoint> f17788r;

    /* renamed from: s, reason: collision with root package name */
    private int f17789s;

    /* renamed from: t, reason: collision with root package name */
    private List<BusStationItem> f17790t;

    /* renamed from: u, reason: collision with root package name */
    private float f17791u;

    public static class a implements Parcelable.Creator<RouteBusLineItem> {
        @Override // android.os.Parcelable.Creator
        public RouteBusLineItem createFromParcel(Parcel parcel) {
            return new RouteBusLineItem(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ RouteBusLineItem[] newArray(int i10) {
            return null;
        }
    }

    public RouteBusLineItem(Parcel parcel) {
        super(parcel);
        this.f17788r = new ArrayList();
        this.f17790t = new ArrayList();
        this.f17786p = (BusStationItem) parcel.readParcelable(BusStationItem.class.getClassLoader());
        this.f17787q = (BusStationItem) parcel.readParcelable(BusStationItem.class.getClassLoader());
        this.f17788r = parcel.createTypedArrayList(LatLonPoint.CREATOR);
        this.f17789s = parcel.readInt();
        this.f17790t = parcel.createTypedArrayList(BusStationItem.CREATOR);
        this.f17791u = parcel.readFloat();
    }

    @Override // com.amap.api.services.busline.BusLineItem, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.amap.api.services.busline.BusLineItem
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj) || getClass() != obj.getClass()) {
            return false;
        }
        RouteBusLineItem routeBusLineItem = (RouteBusLineItem) obj;
        BusStationItem busStationItem = this.f17787q;
        if (busStationItem == null) {
            if (routeBusLineItem.f17787q != null) {
                return false;
            }
        } else if (!busStationItem.equals(routeBusLineItem.f17787q)) {
            return false;
        }
        BusStationItem busStationItem2 = this.f17786p;
        if (busStationItem2 == null) {
            if (routeBusLineItem.f17786p != null) {
                return false;
            }
        } else if (!busStationItem2.equals(routeBusLineItem.f17786p)) {
            return false;
        }
        return true;
    }

    public BusStationItem getArrivalBusStation() {
        return this.f17787q;
    }

    public BusStationItem getDepartureBusStation() {
        return this.f17786p;
    }

    public float getDuration() {
        return this.f17791u;
    }

    public int getPassStationNum() {
        return this.f17789s;
    }

    public List<BusStationItem> getPassStations() {
        return this.f17790t;
    }

    public List<LatLonPoint> getPolyline() {
        return this.f17788r;
    }

    @Override // com.amap.api.services.busline.BusLineItem
    public int hashCode() {
        int iHashCode = super.hashCode() * 31;
        BusStationItem busStationItem = this.f17787q;
        int iHashCode2 = (iHashCode + (busStationItem == null ? 0 : busStationItem.hashCode())) * 31;
        BusStationItem busStationItem2 = this.f17786p;
        return iHashCode2 + (busStationItem2 != null ? busStationItem2.hashCode() : 0);
    }

    public void setArrivalBusStation(BusStationItem busStationItem) {
        this.f17787q = busStationItem;
    }

    public void setDepartureBusStation(BusStationItem busStationItem) {
        this.f17786p = busStationItem;
    }

    public void setDuration(float f10) {
        this.f17791u = f10;
    }

    public void setPassStationNum(int i10) {
        this.f17789s = i10;
    }

    public void setPassStations(List<BusStationItem> list) {
        this.f17790t = list;
    }

    public void setPolyline(List<LatLonPoint> list) {
        this.f17788r = list;
    }

    @Override // com.amap.api.services.busline.BusLineItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        super.writeToParcel(parcel, i10);
        parcel.writeParcelable(this.f17786p, i10);
        parcel.writeParcelable(this.f17787q, i10);
        parcel.writeTypedList(this.f17788r);
        parcel.writeInt(this.f17789s);
        parcel.writeTypedList(this.f17790t);
        parcel.writeFloat(this.f17791u);
    }

    public RouteBusLineItem() {
        this.f17788r = new ArrayList();
        this.f17790t = new ArrayList();
    }
}
