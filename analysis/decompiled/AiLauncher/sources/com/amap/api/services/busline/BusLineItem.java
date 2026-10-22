package com.amap.api.services.busline;

import O6.l;
import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.col.jmsl.C1631z1;
import com.amap.api.services.core.LatLonPoint;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* loaded from: classes.dex */
public class BusLineItem implements Parcelable {
    public static final Parcelable.Creator<BusLineItem> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private float f17257a;

    /* renamed from: b, reason: collision with root package name */
    private String f17258b;

    /* renamed from: c, reason: collision with root package name */
    private String f17259c;

    /* renamed from: d, reason: collision with root package name */
    private String f17260d;

    /* renamed from: e, reason: collision with root package name */
    private List<LatLonPoint> f17261e;

    /* renamed from: f, reason: collision with root package name */
    private List<LatLonPoint> f17262f;

    /* renamed from: g, reason: collision with root package name */
    private String f17263g;

    /* renamed from: h, reason: collision with root package name */
    private String f17264h;

    /* renamed from: i, reason: collision with root package name */
    private String f17265i;

    /* renamed from: j, reason: collision with root package name */
    private Date f17266j;

    /* renamed from: k, reason: collision with root package name */
    private Date f17267k;

    /* renamed from: l, reason: collision with root package name */
    private String f17268l;

    /* renamed from: m, reason: collision with root package name */
    private float f17269m;

    /* renamed from: n, reason: collision with root package name */
    private float f17270n;

    /* renamed from: o, reason: collision with root package name */
    private List<BusStationItem> f17271o;

    public static class a implements Parcelable.Creator<BusLineItem> {
        @Override // android.os.Parcelable.Creator
        public BusLineItem createFromParcel(Parcel parcel) {
            return new BusLineItem(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ BusLineItem[] newArray(int i10) {
            return null;
        }
    }

    public BusLineItem() {
        this.f17261e = new ArrayList();
        this.f17262f = new ArrayList();
        this.f17271o = new ArrayList();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        BusLineItem busLineItem = (BusLineItem) obj;
        String str = this.f17263g;
        if (str == null) {
            if (busLineItem.f17263g != null) {
                return false;
            }
        } else if (!str.equals(busLineItem.f17263g)) {
            return false;
        }
        return true;
    }

    public float getBasicPrice() {
        return this.f17269m;
    }

    public List<LatLonPoint> getBounds() {
        return this.f17262f;
    }

    public String getBusCompany() {
        return this.f17268l;
    }

    public String getBusLineId() {
        return this.f17263g;
    }

    public String getBusLineName() {
        return this.f17258b;
    }

    public String getBusLineType() {
        return this.f17259c;
    }

    public List<BusStationItem> getBusStations() {
        return this.f17271o;
    }

    public String getCityCode() {
        return this.f17260d;
    }

    public List<LatLonPoint> getDirectionsCoordinates() {
        return this.f17261e;
    }

    public float getDistance() {
        return this.f17257a;
    }

    public Date getFirstBusTime() {
        Date date = this.f17266j;
        if (date == null) {
            return null;
        }
        return (Date) date.clone();
    }

    public Date getLastBusTime() {
        Date date = this.f17267k;
        if (date == null) {
            return null;
        }
        return (Date) date.clone();
    }

    public String getOriginatingStation() {
        return this.f17264h;
    }

    public String getTerminalStation() {
        return this.f17265i;
    }

    public float getTotalPrice() {
        return this.f17270n;
    }

    public int hashCode() {
        String str = this.f17263g;
        return (str == null ? 0 : str.hashCode()) + 31;
    }

    public void setBasicPrice(float f10) {
        this.f17269m = f10;
    }

    public void setBounds(List<LatLonPoint> list) {
        this.f17262f = list;
    }

    public void setBusCompany(String str) {
        this.f17268l = str;
    }

    public void setBusLineId(String str) {
        this.f17263g = str;
    }

    public void setBusLineName(String str) {
        this.f17258b = str;
    }

    public void setBusLineType(String str) {
        this.f17259c = str;
    }

    public void setBusStations(List<BusStationItem> list) {
        this.f17271o = list;
    }

    public void setCityCode(String str) {
        this.f17260d = str;
    }

    public void setDirectionsCoordinates(List<LatLonPoint> list) {
        this.f17261e = list;
    }

    public void setDistance(float f10) {
        this.f17257a = f10;
    }

    public void setFirstBusTime(Date date) {
        if (date == null) {
            this.f17266j = null;
        } else {
            this.f17266j = (Date) date.clone();
        }
    }

    public void setLastBusTime(Date date) {
        if (date == null) {
            this.f17267k = null;
        } else {
            this.f17267k = (Date) date.clone();
        }
    }

    public void setOriginatingStation(String str) {
        this.f17264h = str;
    }

    public void setTerminalStation(String str) {
        this.f17265i = str;
    }

    public void setTotalPrice(float f10) {
        this.f17270n = f10;
    }

    public String toString() {
        return this.f17258b + " " + C1631z1.h(this.f17266j) + l.DATE_SEPARATOR + C1631z1.h(this.f17267k);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeFloat(this.f17257a);
        parcel.writeString(this.f17258b);
        parcel.writeString(this.f17259c);
        parcel.writeString(this.f17260d);
        parcel.writeList(this.f17261e);
        parcel.writeList(this.f17262f);
        parcel.writeString(this.f17263g);
        parcel.writeString(this.f17264h);
        parcel.writeString(this.f17265i);
        parcel.writeString(C1631z1.h(this.f17266j));
        parcel.writeString(C1631z1.h(this.f17267k));
        parcel.writeString(this.f17268l);
        parcel.writeFloat(this.f17269m);
        parcel.writeFloat(this.f17270n);
        parcel.writeList(this.f17271o);
    }

    public BusLineItem(Parcel parcel) {
        this.f17261e = new ArrayList();
        this.f17262f = new ArrayList();
        this.f17271o = new ArrayList();
        this.f17257a = parcel.readFloat();
        this.f17258b = parcel.readString();
        this.f17259c = parcel.readString();
        this.f17260d = parcel.readString();
        this.f17261e = parcel.readArrayList(LatLonPoint.class.getClassLoader());
        this.f17262f = parcel.readArrayList(LatLonPoint.class.getClassLoader());
        this.f17263g = parcel.readString();
        this.f17264h = parcel.readString();
        this.f17265i = parcel.readString();
        this.f17266j = C1631z1.t(parcel.readString());
        this.f17267k = C1631z1.t(parcel.readString());
        this.f17268l = parcel.readString();
        this.f17269m = parcel.readFloat();
        this.f17270n = parcel.readFloat();
        this.f17271o = parcel.readArrayList(BusStationItem.class.getClassLoader());
    }
}
