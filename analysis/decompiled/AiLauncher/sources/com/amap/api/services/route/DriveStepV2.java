package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class DriveStepV2 implements Parcelable {
    public static final Parcelable.Creator<DriveStepV2> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private String f17741a;

    /* renamed from: b, reason: collision with root package name */
    private String f17742b;

    /* renamed from: c, reason: collision with root package name */
    private String f17743c;

    /* renamed from: d, reason: collision with root package name */
    private List<LatLonPoint> f17744d;

    /* renamed from: e, reason: collision with root package name */
    private List<RouteSearchCity> f17745e;

    /* renamed from: f, reason: collision with root package name */
    private List<TMC> f17746f;

    /* renamed from: g, reason: collision with root package name */
    private int f17747g;

    /* renamed from: h, reason: collision with root package name */
    private Cost f17748h;

    /* renamed from: i, reason: collision with root package name */
    private Navi f17749i;

    public static class a implements Parcelable.Creator<DriveStepV2> {
        @Override // android.os.Parcelable.Creator
        public DriveStepV2 createFromParcel(Parcel parcel) {
            return new DriveStepV2(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ DriveStepV2[] newArray(int i10) {
            return null;
        }
    }

    public DriveStepV2(Parcel parcel) {
        this.f17744d = new ArrayList();
        this.f17745e = new ArrayList();
        this.f17746f = new ArrayList();
        this.f17747g = -1;
        this.f17741a = parcel.readString();
        this.f17742b = parcel.readString();
        this.f17743c = parcel.readString();
        this.f17744d = parcel.createTypedArrayList(LatLonPoint.CREATOR);
        this.f17745e = parcel.createTypedArrayList(RouteSearchCity.CREATOR);
        this.f17746f = parcel.createTypedArrayList(TMC.CREATOR);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Cost getCostDetail() {
        return this.f17748h;
    }

    public String getInstruction() {
        return this.f17741a;
    }

    public Navi getNavi() {
        return this.f17749i;
    }

    public String getOrientation() {
        return this.f17742b;
    }

    public List<LatLonPoint> getPolyline() {
        return this.f17744d;
    }

    public String getRoad() {
        return this.f17743c;
    }

    public List<RouteSearchCity> getRouteSearchCityList() {
        return this.f17745e;
    }

    public int getStepDistance() {
        return this.f17747g;
    }

    public List<TMC> getTMCs() {
        return this.f17746f;
    }

    public void setCostDetail(Cost cost) {
        this.f17748h = cost;
    }

    public void setInstruction(String str) {
        this.f17741a = str;
    }

    public void setNavi(Navi navi) {
        this.f17749i = navi;
    }

    public void setOrientation(String str) {
        this.f17742b = str;
    }

    public void setPolyline(List<LatLonPoint> list) {
        this.f17744d = list;
    }

    public void setRoad(String str) {
        this.f17743c = str;
    }

    public void setRouteSearchCityList(List<RouteSearchCity> list) {
        this.f17745e = list;
    }

    public void setStepDistance(int i10) {
        this.f17747g = i10;
    }

    public void setTMCs(List<TMC> list) {
        this.f17746f = list;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f17741a);
        parcel.writeString(this.f17742b);
        parcel.writeString(this.f17743c);
        parcel.writeTypedList(this.f17744d);
        parcel.writeTypedList(this.f17745e);
        parcel.writeTypedList(this.f17746f);
    }

    public DriveStepV2() {
        this.f17744d = new ArrayList();
        this.f17745e = new ArrayList();
        this.f17746f = new ArrayList();
        this.f17747g = -1;
    }
}
