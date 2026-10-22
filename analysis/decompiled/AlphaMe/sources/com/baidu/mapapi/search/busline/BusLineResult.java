package com.baidu.mapapi.search.busline;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.search.core.RouteNode;
import com.baidu.mapapi.search.core.RouteStep;
import com.baidu.mapapi.search.core.SearchResult;
import java.util.Date;
import java.util.List;

/* loaded from: classes.dex */
public class BusLineResult extends SearchResult implements Parcelable {
    public static final Parcelable.Creator<BusLineResult> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private String f7246a;

    /* renamed from: b, reason: collision with root package name */
    private String f7247b;

    /* renamed from: c, reason: collision with root package name */
    private String f7248c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f7249d;

    /* renamed from: e, reason: collision with root package name */
    private Date f7250e;

    /* renamed from: f, reason: collision with root package name */
    private Date f7251f;

    /* renamed from: g, reason: collision with root package name */
    private String f7252g;

    /* renamed from: h, reason: collision with root package name */
    private List<BusStation> f7253h;

    /* renamed from: i, reason: collision with root package name */
    private List<BusStep> f7254i;

    /* renamed from: j, reason: collision with root package name */
    private float f7255j;

    /* renamed from: k, reason: collision with root package name */
    private float f7256k;

    /* renamed from: l, reason: collision with root package name */
    private String f7257l;

    public static class BusStation extends RouteNode {
    }

    public static class BusStep extends RouteStep {
    }

    public static class a implements Parcelable.Creator<BusLineResult> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public BusLineResult[] newArray(int i4) {
            return new BusLineResult[i4];
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public BusLineResult createFromParcel(Parcel parcel) {
            return new BusLineResult(parcel);
        }
    }

    public BusLineResult() {
        this.f7246a = null;
        this.f7247b = null;
        this.f7253h = null;
        this.f7254i = null;
        this.f7257l = null;
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public float getBasePrice() {
        return this.f7255j;
    }

    public String getBusCompany() {
        return this.f7246a;
    }

    public String getBusLineName() {
        return this.f7247b;
    }

    public Date getEndTime() {
        return this.f7251f;
    }

    public String getLineDirection() {
        return this.f7257l;
    }

    public float getMaxPrice() {
        return this.f7256k;
    }

    public String getRawName() {
        return this.f7248c;
    }

    public Date getStartTime() {
        return this.f7250e;
    }

    public List<BusStation> getStations() {
        return this.f7253h;
    }

    public List<BusStep> getSteps() {
        return this.f7254i;
    }

    public String getUid() {
        return this.f7252g;
    }

    public boolean isMonthTicket() {
        return this.f7249d;
    }

    public void setBasePrice(float f4) {
        this.f7255j = f4;
    }

    public void setBusCompany(String str) {
        this.f7246a = str;
    }

    public void setBusLineName(String str) {
        this.f7247b = str;
    }

    public void setEndTime(Date date) {
        this.f7251f = date;
    }

    public void setLineDirection(String str) {
        this.f7257l = str;
    }

    public void setMaxPrice(float f4) {
        this.f7256k = f4;
    }

    public void setMonthTicket(boolean z4) {
        this.f7249d = z4;
    }

    public void setRawName(String str) {
        this.f7248c = str;
    }

    public void setStartTime(Date date) {
        this.f7250e = date;
    }

    public void setStations(List<BusStation> list) {
        this.f7253h = list;
    }

    public void setSteps(List<BusStep> list) {
        this.f7254i = list;
    }

    public void setUid(String str) {
        this.f7252g = str;
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeString(this.f7246a);
        parcel.writeString(this.f7247b);
        parcel.writeValue(Boolean.valueOf(this.f7249d));
        parcel.writeValue(this.f7250e);
        parcel.writeValue(this.f7251f);
        parcel.writeString(this.f7252g);
        parcel.writeList(this.f7253h);
        parcel.writeList(this.f7254i);
        parcel.writeString(this.f7248c);
        parcel.writeString(this.f7257l);
        parcel.writeFloat(this.f7256k);
        parcel.writeFloat(this.f7255j);
    }

    public BusLineResult(Parcel parcel) {
        this.f7246a = null;
        this.f7247b = null;
        this.f7253h = null;
        this.f7254i = null;
        this.f7257l = null;
        this.f7246a = parcel.readString();
        this.f7247b = parcel.readString();
        this.f7249d = ((Boolean) parcel.readValue(Boolean.class.getClassLoader())).booleanValue();
        this.f7250e = (Date) parcel.readValue(Date.class.getClassLoader());
        this.f7251f = (Date) parcel.readValue(Date.class.getClassLoader());
        this.f7252g = parcel.readString();
        this.f7253h = parcel.readArrayList(BusStation.class.getClassLoader());
        this.f7254i = parcel.readArrayList(RouteStep.class.getClassLoader());
        this.f7248c = parcel.readString();
        this.f7257l = parcel.readString();
        this.f7256k = parcel.readFloat();
        this.f7255j = parcel.readFloat();
    }
}
