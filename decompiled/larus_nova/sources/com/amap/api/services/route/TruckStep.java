package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;
import java.util.List;

/* JADX INFO: loaded from: classes28.dex */
public class TruckStep implements Parcelable {
    public static final Parcelable.Creator<TruckStep> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f29234a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f29235b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f29236c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f29237d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f29238e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float f29239f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f29240g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private float f29241h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private List<LatLonPoint> f29242i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f29243j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private String f29244k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private List<RouteSearchCity> f29245l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private List<TMC> f29246m;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    public TruckStep() {
    }

    public String getAction() {
        return this.f29243j;
    }

    public String getAssistantAction() {
        return this.f29244k;
    }

    public float getDistance() {
        return this.f29238e;
    }

    public float getDuration() {
        return this.f29241h;
    }

    public String getInstruction() {
        return this.f29234a;
    }

    public String getOrientation() {
        return this.f29235b;
    }

    public List<LatLonPoint> getPolyline() {
        return this.f29242i;
    }

    public String getRoad() {
        return this.f29236c;
    }

    public List<RouteSearchCity> getRouteSearchCityList() {
        return this.f29245l;
    }

    public List<TMC> getTMCs() {
        return this.f29246m;
    }

    public float getTollDistance() {
        return this.f29239f;
    }

    public String getTollRoad() {
        return this.f29240g;
    }

    public float getTolls() {
        return this.f29237d;
    }

    public TruckStep(Parcel r100) {
        this.f29234a = r100.readString();
        this.f29235b = r100.readString();
        this.f29236c = r100.readString();
        this.f29237d = r100.readFloat();
        this.f29238e = r100.readFloat();
        this.f29239f = r100.readFloat();
        this.f29240g = r100.readString();
        this.f29241h = r100.readFloat();
        this.f29242i = r100.createTypedArrayList(LatLonPoint.CREATOR);
        this.f29243j = r100.readString();
        this.f29244k = r100.readString();
        this.f29245l = r100.createTypedArrayList(RouteSearchCity.CREATOR);
        this.f29246m = r100.createTypedArrayList(TMC.CREATOR);
    }

    public void setAction(String r100) {
        this.f29243j = r100;
    }

    public void setAssistantAction(String r100) {
        this.f29244k = r100;
    }

    public void setDistance(float r100) {
        this.f29238e = r100;
    }

    public void setDuration(float r100) {
        this.f29241h = r100;
    }

    public void setInstruction(String r100) {
        this.f29234a = r100;
    }

    public void setOrientation(String r100) {
        this.f29235b = r100;
    }

    public void setPolyline(List<LatLonPoint> r100) {
        this.f29242i = r100;
    }

    public void setRoad(String r100) {
        this.f29236c = r100;
    }

    public void setRouteSearchCityList(List<RouteSearchCity> r100) {
        this.f29245l = r100;
    }

    public void setTMCs(List<TMC> r100) {
        this.f29246m = r100;
    }

    public void setTollDistance(float r100) {
        this.f29239f = r100;
    }

    public void setTollRoad(String r100) {
        this.f29240g = r100;
    }

    public void setTolls(float r100) {
        this.f29237d = r100;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeString(this.f29234a);
        r100.writeString(this.f29235b);
        r100.writeString(this.f29236c);
        r100.writeFloat(this.f29237d);
        r100.writeFloat(this.f29238e);
        r100.writeFloat(this.f29239f);
        r100.writeString(this.f29240g);
        r100.writeFloat(this.f29241h);
        r100.writeTypedList(this.f29242i);
        r100.writeString(this.f29243j);
        r100.writeString(this.f29244k);
        r100.writeTypedList(this.f29245l);
        r100.writeTypedList(this.f29246m);
    }
}
