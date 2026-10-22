package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;
import java.util.List;

/* loaded from: classes.dex */
public class TruckStep implements Parcelable {
    public static final Parcelable.Creator<TruckStep> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private String f17965a;

    /* renamed from: b, reason: collision with root package name */
    private String f17966b;

    /* renamed from: c, reason: collision with root package name */
    private String f17967c;

    /* renamed from: d, reason: collision with root package name */
    private float f17968d;

    /* renamed from: e, reason: collision with root package name */
    private float f17969e;

    /* renamed from: f, reason: collision with root package name */
    private float f17970f;

    /* renamed from: g, reason: collision with root package name */
    private String f17971g;

    /* renamed from: h, reason: collision with root package name */
    private float f17972h;

    /* renamed from: i, reason: collision with root package name */
    private List<LatLonPoint> f17973i;

    /* renamed from: j, reason: collision with root package name */
    private String f17974j;

    /* renamed from: k, reason: collision with root package name */
    private String f17975k;

    /* renamed from: l, reason: collision with root package name */
    private List<RouteSearchCity> f17976l;

    /* renamed from: m, reason: collision with root package name */
    private List<TMC> f17977m;

    public static class a implements Parcelable.Creator<TruckStep> {
        @Override // android.os.Parcelable.Creator
        public TruckStep createFromParcel(Parcel parcel) {
            return new TruckStep(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public TruckStep[] newArray(int i10) {
            return new TruckStep[i10];
        }
    }

    public TruckStep() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAction() {
        return this.f17974j;
    }

    public String getAssistantAction() {
        return this.f17975k;
    }

    public float getDistance() {
        return this.f17969e;
    }

    public float getDuration() {
        return this.f17972h;
    }

    public String getInstruction() {
        return this.f17965a;
    }

    public String getOrientation() {
        return this.f17966b;
    }

    public List<LatLonPoint> getPolyline() {
        return this.f17973i;
    }

    public String getRoad() {
        return this.f17967c;
    }

    public List<RouteSearchCity> getRouteSearchCityList() {
        return this.f17976l;
    }

    public List<TMC> getTMCs() {
        return this.f17977m;
    }

    public float getTollDistance() {
        return this.f17970f;
    }

    public String getTollRoad() {
        return this.f17971g;
    }

    public float getTolls() {
        return this.f17968d;
    }

    public void setAction(String str) {
        this.f17974j = str;
    }

    public void setAssistantAction(String str) {
        this.f17975k = str;
    }

    public void setDistance(float f10) {
        this.f17969e = f10;
    }

    public void setDuration(float f10) {
        this.f17972h = f10;
    }

    public void setInstruction(String str) {
        this.f17965a = str;
    }

    public void setOrientation(String str) {
        this.f17966b = str;
    }

    public void setPolyline(List<LatLonPoint> list) {
        this.f17973i = list;
    }

    public void setRoad(String str) {
        this.f17967c = str;
    }

    public void setRouteSearchCityList(List<RouteSearchCity> list) {
        this.f17976l = list;
    }

    public void setTMCs(List<TMC> list) {
        this.f17977m = list;
    }

    public void setTollDistance(float f10) {
        this.f17970f = f10;
    }

    public void setTollRoad(String str) {
        this.f17971g = str;
    }

    public void setTolls(float f10) {
        this.f17968d = f10;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f17965a);
        parcel.writeString(this.f17966b);
        parcel.writeString(this.f17967c);
        parcel.writeFloat(this.f17968d);
        parcel.writeFloat(this.f17969e);
        parcel.writeFloat(this.f17970f);
        parcel.writeString(this.f17971g);
        parcel.writeFloat(this.f17972h);
        parcel.writeTypedList(this.f17973i);
        parcel.writeString(this.f17974j);
        parcel.writeString(this.f17975k);
        parcel.writeTypedList(this.f17976l);
        parcel.writeTypedList(this.f17977m);
    }

    public TruckStep(Parcel parcel) {
        this.f17965a = parcel.readString();
        this.f17966b = parcel.readString();
        this.f17967c = parcel.readString();
        this.f17968d = parcel.readFloat();
        this.f17969e = parcel.readFloat();
        this.f17970f = parcel.readFloat();
        this.f17971g = parcel.readString();
        this.f17972h = parcel.readFloat();
        this.f17973i = parcel.createTypedArrayList(LatLonPoint.CREATOR);
        this.f17974j = parcel.readString();
        this.f17975k = parcel.readString();
        this.f17976l = parcel.createTypedArrayList(RouteSearchCity.CREATOR);
        this.f17977m = parcel.createTypedArrayList(TMC.CREATOR);
    }
}
