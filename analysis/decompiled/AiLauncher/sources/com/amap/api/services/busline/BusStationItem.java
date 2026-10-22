package com.amap.api.services.busline;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.route.Doorway;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class BusStationItem implements Parcelable {
    public static final Parcelable.Creator<BusStationItem> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private String f17285a;

    /* renamed from: b, reason: collision with root package name */
    private String f17286b;

    /* renamed from: c, reason: collision with root package name */
    private LatLonPoint f17287c;

    /* renamed from: d, reason: collision with root package name */
    private String f17288d;

    /* renamed from: e, reason: collision with root package name */
    private String f17289e;

    /* renamed from: f, reason: collision with root package name */
    private Doorway f17290f;

    /* renamed from: g, reason: collision with root package name */
    private Doorway f17291g;

    /* renamed from: h, reason: collision with root package name */
    private List<BusLineItem> f17292h;

    public static class a implements Parcelable.Creator<BusStationItem> {
        @Override // android.os.Parcelable.Creator
        public BusStationItem createFromParcel(Parcel parcel) {
            return new BusStationItem(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ BusStationItem[] newArray(int i10) {
            return null;
        }
    }

    public /* synthetic */ BusStationItem(Parcel parcel, a aVar) {
        this(parcel);
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
        BusStationItem busStationItem = (BusStationItem) obj;
        String str = this.f17285a;
        if (str == null) {
            if (busStationItem.f17285a != null) {
                return false;
            }
        } else if (!str.equals(busStationItem.f17285a)) {
            return false;
        }
        return true;
    }

    public String getAdCode() {
        return this.f17289e;
    }

    public List<BusLineItem> getBusLineItems() {
        return this.f17292h;
    }

    public String getBusStationId() {
        return this.f17285a;
    }

    public String getBusStationName() {
        return this.f17286b;
    }

    public String getCityCode() {
        return this.f17288d;
    }

    public Doorway getEntrance() {
        return this.f17290f;
    }

    public Doorway getExit() {
        return this.f17291g;
    }

    public LatLonPoint getLatLonPoint() {
        return this.f17287c;
    }

    public int hashCode() {
        String str = this.f17285a;
        return (str == null ? 0 : str.hashCode()) + 31;
    }

    public void setAdCode(String str) {
        this.f17289e = str;
    }

    public void setBusLineItems(List<BusLineItem> list) {
        this.f17292h = list;
    }

    public void setBusStationId(String str) {
        this.f17285a = str;
    }

    public void setBusStationName(String str) {
        this.f17286b = str;
    }

    public void setCityCode(String str) {
        this.f17288d = str;
    }

    public void setEntrance(Doorway doorway) {
        this.f17290f = doorway;
    }

    public void setExit(Doorway doorway) {
        this.f17291g = doorway;
    }

    public void setLatLonPoint(LatLonPoint latLonPoint) {
        this.f17287c = latLonPoint;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("BusStationName: ");
        sb2.append(this.f17286b);
        sb2.append(" LatLonPoint: ");
        sb2.append(this.f17287c.toString());
        sb2.append(" BusLines: ");
        List<BusLineItem> list = this.f17292h;
        StringBuffer stringBuffer = new StringBuffer();
        if (list != null) {
            for (int i10 = 0; i10 < list.size(); i10++) {
                stringBuffer.append(list.get(i10).getBusLineName());
                if (i10 < list.size() - 1) {
                    stringBuffer.append("|");
                }
            }
        }
        sb2.append(stringBuffer.toString());
        sb2.append(" CityCode: ");
        sb2.append(this.f17288d);
        sb2.append(" AdCode: ");
        sb2.append(this.f17289e);
        return sb2.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f17286b);
        parcel.writeString(this.f17285a);
        parcel.writeValue(this.f17287c);
        parcel.writeString(this.f17288d);
        parcel.writeString(this.f17289e);
        parcel.writeParcelable(this.f17290f, i10);
        parcel.writeParcelable(this.f17291g, i10);
        parcel.writeList(this.f17292h);
    }

    public BusStationItem() {
        this.f17292h = new ArrayList();
    }

    private BusStationItem(Parcel parcel) {
        this.f17292h = new ArrayList();
        this.f17286b = parcel.readString();
        this.f17285a = parcel.readString();
        this.f17287c = (LatLonPoint) parcel.readValue(LatLonPoint.class.getClassLoader());
        this.f17288d = parcel.readString();
        this.f17289e = parcel.readString();
        this.f17290f = (Doorway) parcel.readParcelable(Doorway.class.getClassLoader());
        this.f17291g = (Doorway) parcel.readParcelable(Doorway.class.getClassLoader());
        this.f17292h = parcel.readArrayList(BusLineItem.class.getClassLoader());
    }
}
