package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class DriveStep implements Parcelable {
    public static final Parcelable.Creator<DriveStep> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private String f17728a;

    /* renamed from: b, reason: collision with root package name */
    private String f17729b;

    /* renamed from: c, reason: collision with root package name */
    private String f17730c;

    /* renamed from: d, reason: collision with root package name */
    private float f17731d;

    /* renamed from: e, reason: collision with root package name */
    private float f17732e;

    /* renamed from: f, reason: collision with root package name */
    private float f17733f;

    /* renamed from: g, reason: collision with root package name */
    private String f17734g;

    /* renamed from: h, reason: collision with root package name */
    private float f17735h;

    /* renamed from: i, reason: collision with root package name */
    private List<LatLonPoint> f17736i;

    /* renamed from: j, reason: collision with root package name */
    private String f17737j;

    /* renamed from: k, reason: collision with root package name */
    private String f17738k;

    /* renamed from: l, reason: collision with root package name */
    private List<RouteSearchCity> f17739l;

    /* renamed from: m, reason: collision with root package name */
    private List<TMC> f17740m;

    public static class a implements Parcelable.Creator<DriveStep> {
        @Override // android.os.Parcelable.Creator
        public DriveStep createFromParcel(Parcel parcel) {
            return new DriveStep(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ DriveStep[] newArray(int i10) {
            return null;
        }
    }

    public DriveStep(Parcel parcel) {
        this.f17736i = new ArrayList();
        this.f17739l = new ArrayList();
        this.f17740m = new ArrayList();
        this.f17728a = parcel.readString();
        this.f17729b = parcel.readString();
        this.f17730c = parcel.readString();
        this.f17731d = parcel.readFloat();
        this.f17732e = parcel.readFloat();
        this.f17733f = parcel.readFloat();
        this.f17734g = parcel.readString();
        this.f17735h = parcel.readFloat();
        this.f17736i = parcel.createTypedArrayList(LatLonPoint.CREATOR);
        this.f17737j = parcel.readString();
        this.f17738k = parcel.readString();
        this.f17739l = parcel.createTypedArrayList(RouteSearchCity.CREATOR);
        this.f17740m = parcel.createTypedArrayList(TMC.CREATOR);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAction() {
        return this.f17737j;
    }

    public String getAssistantAction() {
        return this.f17738k;
    }

    public float getDistance() {
        return this.f17731d;
    }

    public float getDuration() {
        return this.f17735h;
    }

    public String getInstruction() {
        return this.f17728a;
    }

    public String getOrientation() {
        return this.f17729b;
    }

    public List<LatLonPoint> getPolyline() {
        return this.f17736i;
    }

    public String getRoad() {
        return this.f17730c;
    }

    public List<RouteSearchCity> getRouteSearchCityList() {
        return this.f17739l;
    }

    public List<TMC> getTMCs() {
        return this.f17740m;
    }

    public float getTollDistance() {
        return this.f17733f;
    }

    public String getTollRoad() {
        return this.f17734g;
    }

    public float getTolls() {
        return this.f17732e;
    }

    public void setAction(String str) {
        this.f17737j = str;
    }

    public void setAssistantAction(String str) {
        this.f17738k = str;
    }

    public void setDistance(float f10) {
        this.f17731d = f10;
    }

    public void setDuration(float f10) {
        this.f17735h = f10;
    }

    public void setInstruction(String str) {
        this.f17728a = str;
    }

    public void setOrientation(String str) {
        this.f17729b = str;
    }

    public void setPolyline(List<LatLonPoint> list) {
        this.f17736i = list;
    }

    public void setRoad(String str) {
        this.f17730c = str;
    }

    public void setRouteSearchCityList(List<RouteSearchCity> list) {
        this.f17739l = list;
    }

    public void setTMCs(List<TMC> list) {
        this.f17740m = list;
    }

    public void setTollDistance(float f10) {
        this.f17733f = f10;
    }

    public void setTollRoad(String str) {
        this.f17734g = str;
    }

    public void setTolls(float f10) {
        this.f17732e = f10;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f17728a);
        parcel.writeString(this.f17729b);
        parcel.writeString(this.f17730c);
        parcel.writeFloat(this.f17731d);
        parcel.writeFloat(this.f17732e);
        parcel.writeFloat(this.f17733f);
        parcel.writeString(this.f17734g);
        parcel.writeFloat(this.f17735h);
        parcel.writeTypedList(this.f17736i);
        parcel.writeString(this.f17737j);
        parcel.writeString(this.f17738k);
        parcel.writeTypedList(this.f17739l);
        parcel.writeTypedList(this.f17740m);
    }

    public DriveStep() {
        this.f17736i = new ArrayList();
        this.f17739l = new ArrayList();
        this.f17740m = new ArrayList();
    }
}
