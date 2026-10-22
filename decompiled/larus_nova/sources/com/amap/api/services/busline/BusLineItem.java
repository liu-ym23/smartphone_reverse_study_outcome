package com.amap.api.services.busline;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.col.s.i;
import com.amap.api.services.core.LatLonPoint;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* JADX INFO: loaded from: classes28.dex */
public class BusLineItem implements Parcelable {
    public static final Parcelable.Creator<BusLineItem> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f28754a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f28755b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f28756c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f28757d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private List<LatLonPoint> f28758e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private List<LatLonPoint> f28759f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f28760g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f28761h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f28762i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Date f28763j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private Date f28764k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private String f28765l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private float f28766m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private float f28767n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private List<BusStationItem> f28768o;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    public Date getFirstBusTime() {
        Date r100 = this.f28763j;
        if (r100 != null) goto L7;
        return null;
    L7:
        return (Date) r100.clone();
    }

    public Date getLastBusTime() {
        Date r100 = this.f28764k;
        if (r100 != null) goto L7;
        return null;
    L7:
        return (Date) r100.clone();
    }

    public int hashCode() {
        String r100 = this.f28760g;
        if (r100 != null) goto L5;
        int r101 = 0;
    L7:
        return r101 + 31;
    L5:
        r101 = r100.hashCode();
        goto L7
    }

    public String toString() {
        return this.f28755b + " " + i.a(this.f28763j) + "-" + i.a(this.f28764k);
    }

    public BusLineItem() {
        this.f28758e = new ArrayList();
        this.f28759f = new ArrayList();
        this.f28768o = new ArrayList();
    }

    public float getBasicPrice() {
        return this.f28766m;
    }

    public List<LatLonPoint> getBounds() {
        return this.f28759f;
    }

    public String getBusCompany() {
        return this.f28765l;
    }

    public String getBusLineId() {
        return this.f28760g;
    }

    public String getBusLineName() {
        return this.f28755b;
    }

    public String getBusLineType() {
        return this.f28756c;
    }

    public List<BusStationItem> getBusStations() {
        return this.f28768o;
    }

    public String getCityCode() {
        return this.f28757d;
    }

    public List<LatLonPoint> getDirectionsCoordinates() {
        return this.f28758e;
    }

    public float getDistance() {
        return this.f28754a;
    }

    public String getOriginatingStation() {
        return this.f28761h;
    }

    public String getTerminalStation() {
        return this.f28762i;
    }

    public float getTotalPrice() {
        return this.f28767n;
    }

    public BusLineItem(Parcel r100) {
        this.f28758e = new ArrayList();
        this.f28759f = new ArrayList();
        this.f28768o = new ArrayList();
        this.f28754a = r100.readFloat();
        this.f28755b = r100.readString();
        this.f28756c = r100.readString();
        this.f28757d = r100.readString();
        this.f28758e = r100.readArrayList(LatLonPoint.class.getClassLoader());
        this.f28759f = r100.readArrayList(LatLonPoint.class.getClassLoader());
        this.f28760g = r100.readString();
        this.f28761h = r100.readString();
        this.f28762i = r100.readString();
        this.f28763j = i.e(r100.readString());
        this.f28764k = i.e(r100.readString());
        this.f28765l = r100.readString();
        this.f28766m = r100.readFloat();
        this.f28767n = r100.readFloat();
        this.f28768o = r100.readArrayList(BusStationItem.class.getClassLoader());
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L9;
        return false;
    L9:
        if (getClass() == r100.getClass()) goto L11;
        return false;
    L11:
        BusLineItem r101 = (BusLineItem) r100;
        String r102 = this.f28760g;
        if (r102 != null) goto L17;
        if (r101.f28760g == null) goto L19;
        return false;
    L19:
        return true;
    L17:
        if (r102.equals(r101.f28760g) == true) goto L19;
        return false;
    }

    public void setBasicPrice(float r100) {
        this.f28766m = r100;
    }

    public void setBounds(List<LatLonPoint> r100) {
        this.f28759f = r100;
    }

    public void setBusCompany(String r100) {
        this.f28765l = r100;
    }

    public void setBusLineId(String r100) {
        this.f28760g = r100;
    }

    public void setBusLineName(String r100) {
        this.f28755b = r100;
    }

    public void setBusLineType(String r100) {
        this.f28756c = r100;
    }

    public void setBusStations(List<BusStationItem> r100) {
        this.f28768o = r100;
    }

    public void setCityCode(String r100) {
        this.f28757d = r100;
    }

    public void setDirectionsCoordinates(List<LatLonPoint> r100) {
        this.f28758e = r100;
    }

    public void setDistance(float r100) {
        this.f28754a = r100;
    }

    public void setFirstBusTime(Date r100) {
        if (r100 != null) goto L5;
        this.f28763j = null;
        return;
    L5:
        this.f28763j = (Date) r100.clone();
    }

    public void setLastBusTime(Date r100) {
        if (r100 != null) goto L5;
        this.f28764k = null;
        return;
    L5:
        this.f28764k = (Date) r100.clone();
    }

    public void setOriginatingStation(String r100) {
        this.f28761h = r100;
    }

    public void setTerminalStation(String r100) {
        this.f28762i = r100;
    }

    public void setTotalPrice(float r100) {
        this.f28767n = r100;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeFloat(this.f28754a);
        r100.writeString(this.f28755b);
        r100.writeString(this.f28756c);
        r100.writeString(this.f28757d);
        r100.writeList(this.f28758e);
        r100.writeList(this.f28759f);
        r100.writeString(this.f28760g);
        r100.writeString(this.f28761h);
        r100.writeString(this.f28762i);
        r100.writeString(i.a(this.f28763j));
        r100.writeString(i.a(this.f28764k));
        r100.writeString(this.f28765l);
        r100.writeFloat(this.f28766m);
        r100.writeFloat(this.f28767n);
        r100.writeList(this.f28768o);
    }
}
