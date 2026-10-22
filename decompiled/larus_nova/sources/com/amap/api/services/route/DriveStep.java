package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes28.dex */
public class DriveStep implements Parcelable {
    public static final Parcelable.Creator<DriveStep> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f29095a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f29096b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f29097c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f29098d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f29099e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float f29100f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f29101g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private float f29102h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private List<LatLonPoint> f29103i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f29104j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private String f29105k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private List<RouteSearchCity> f29106l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private List<TMC> f29107m;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    public DriveStep() {
        this.f29103i = new ArrayList();
        this.f29106l = new ArrayList();
        this.f29107m = new ArrayList();
    }

    public String getAction() {
        return this.f29104j;
    }

    public String getAssistantAction() {
        return this.f29105k;
    }

    public float getDistance() {
        return this.f29098d;
    }

    public float getDuration() {
        return this.f29102h;
    }

    public String getInstruction() {
        return this.f29095a;
    }

    public String getOrientation() {
        return this.f29096b;
    }

    public List<LatLonPoint> getPolyline() {
        return this.f29103i;
    }

    public String getRoad() {
        return this.f29097c;
    }

    public List<RouteSearchCity> getRouteSearchCityList() {
        return this.f29106l;
    }

    public List<TMC> getTMCs() {
        return this.f29107m;
    }

    public float getTollDistance() {
        return this.f29100f;
    }

    public String getTollRoad() {
        return this.f29101g;
    }

    public float getTolls() {
        return this.f29099e;
    }

    public DriveStep(Parcel r100) {
        this.f29103i = new ArrayList();
        this.f29106l = new ArrayList();
        this.f29107m = new ArrayList();
        this.f29095a = r100.readString();
        this.f29096b = r100.readString();
        this.f29097c = r100.readString();
        this.f29098d = r100.readFloat();
        this.f29099e = r100.readFloat();
        this.f29100f = r100.readFloat();
        this.f29101g = r100.readString();
        this.f29102h = r100.readFloat();
        this.f29103i = r100.createTypedArrayList(LatLonPoint.CREATOR);
        this.f29104j = r100.readString();
        this.f29105k = r100.readString();
        this.f29106l = r100.createTypedArrayList(RouteSearchCity.CREATOR);
        this.f29107m = r100.createTypedArrayList(TMC.CREATOR);
    }

    public void setAction(String r100) {
        this.f29104j = r100;
    }

    public void setAssistantAction(String r100) {
        this.f29105k = r100;
    }

    public void setDistance(float r100) {
        this.f29098d = r100;
    }

    public void setDuration(float r100) {
        this.f29102h = r100;
    }

    public void setInstruction(String r100) {
        this.f29095a = r100;
    }

    public void setOrientation(String r100) {
        this.f29096b = r100;
    }

    public void setPolyline(List<LatLonPoint> r100) {
        this.f29103i = r100;
    }

    public void setRoad(String r100) {
        this.f29097c = r100;
    }

    public void setRouteSearchCityList(List<RouteSearchCity> r100) {
        this.f29106l = r100;
    }

    public void setTMCs(List<TMC> r100) {
        this.f29107m = r100;
    }

    public void setTollDistance(float r100) {
        this.f29100f = r100;
    }

    public void setTollRoad(String r100) {
        this.f29101g = r100;
    }

    public void setTolls(float r100) {
        this.f29099e = r100;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeString(this.f29095a);
        r100.writeString(this.f29096b);
        r100.writeString(this.f29097c);
        r100.writeFloat(this.f29098d);
        r100.writeFloat(this.f29099e);
        r100.writeFloat(this.f29100f);
        r100.writeString(this.f29101g);
        r100.writeFloat(this.f29102h);
        r100.writeTypedList(this.f29103i);
        r100.writeString(this.f29104j);
        r100.writeString(this.f29105k);
        r100.writeTypedList(this.f29106l);
        r100.writeTypedList(this.f29107m);
    }
}
