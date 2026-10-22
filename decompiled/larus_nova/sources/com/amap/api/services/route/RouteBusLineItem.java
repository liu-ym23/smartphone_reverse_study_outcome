package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.busline.BusLineItem;
import com.amap.api.services.busline.BusStationItem;
import com.amap.api.services.core.LatLonPoint;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes28.dex */
public class RouteBusLineItem extends BusLineItem {
    public static final Parcelable.Creator<RouteBusLineItem> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private BusStationItem f29134a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private BusStationItem f29135b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private List<LatLonPoint> f29136c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f29137d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private List<BusStationItem> f29138e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float f29139f;

    @Override // com.amap.api.services.busline.BusLineItem, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    public RouteBusLineItem() {
        this.f29136c = new ArrayList();
        this.f29138e = new ArrayList();
    }

    @Override // com.amap.api.services.busline.BusLineItem
    public int hashCode() {
        int r100 = super.hashCode() * 31;
        BusStationItem r101 = this.f29135b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        BusStationItem r105 = this.f29134a;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return r104 + r102;
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public BusStationItem getArrivalBusStation() {
        return this.f29135b;
    }

    public BusStationItem getDepartureBusStation() {
        return this.f29134a;
    }

    public float getDuration() {
        return this.f29139f;
    }

    public int getPassStationNum() {
        return this.f29137d;
    }

    public List<BusStationItem> getPassStations() {
        return this.f29138e;
    }

    public List<LatLonPoint> getPolyline() {
        return this.f29136c;
    }

    public RouteBusLineItem(Parcel r100) {
        super(r100);
        this.f29136c = new ArrayList();
        this.f29138e = new ArrayList();
        this.f29134a = (BusStationItem) r100.readParcelable(BusStationItem.class.getClassLoader());
        this.f29135b = (BusStationItem) r100.readParcelable(BusStationItem.class.getClassLoader());
        this.f29136c = r100.createTypedArrayList(LatLonPoint.CREATOR);
        this.f29137d = r100.readInt();
        this.f29138e = r100.createTypedArrayList(BusStationItem.CREATOR);
        this.f29139f = r100.readFloat();
    }

    @Override // com.amap.api.services.busline.BusLineItem
    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (super.equals(r100) == true) goto L9;
        return false;
    L9:
        if (getClass() == r100.getClass()) goto L11;
        return false;
    L11:
        RouteBusLineItem r101 = (RouteBusLineItem) r100;
        BusStationItem r102 = this.f29135b;
        if (r102 != null) goto L17;
        if (r101.f29135b == null) goto L19;
        return false;
    L19:
        BusStationItem r103 = this.f29134a;
        if (r103 != null) goto L25;
        if (r101.f29134a == null) goto L27;
        return false;
    L27:
        return true;
    L25:
        if (r103.equals(r101.f29134a) == true) goto L27;
        return false;
    L17:
        if (r102.equals(r101.f29135b) == true) goto L19;
        return false;
    }

    public void setArrivalBusStation(BusStationItem r100) {
        this.f29135b = r100;
    }

    public void setDepartureBusStation(BusStationItem r100) {
        this.f29134a = r100;
    }

    public void setDuration(float r100) {
        this.f29139f = r100;
    }

    public void setPassStationNum(int r100) {
        this.f29137d = r100;
    }

    public void setPassStations(List<BusStationItem> r100) {
        this.f29138e = r100;
    }

    public void setPolyline(List<LatLonPoint> r100) {
        this.f29136c = r100;
    }

    @Override // com.amap.api.services.busline.BusLineItem, android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        super.writeToParcel(r100, r101);
        r100.writeParcelable(this.f29134a, r101);
        r100.writeParcelable(this.f29135b, r101);
        r100.writeTypedList(this.f29136c);
        r100.writeInt(this.f29137d);
        r100.writeTypedList(this.f29138e);
        r100.writeFloat(this.f29139f);
    }
}
