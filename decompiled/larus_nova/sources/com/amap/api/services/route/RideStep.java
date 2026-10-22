package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes28.dex */
public class RideStep implements Parcelable {
    public static final Parcelable.Creator<RideStep> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f29126a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f29127b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f29128c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f29129d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f29130e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private List<LatLonPoint> f29131f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f29132g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f29133h;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    public RideStep() {
        this.f29131f = new ArrayList();
    }

    public String getAction() {
        return this.f29132g;
    }

    public String getAssistantAction() {
        return this.f29133h;
    }

    public float getDistance() {
        return this.f29129d;
    }

    public float getDuration() {
        return this.f29130e;
    }

    public String getInstruction() {
        return this.f29126a;
    }

    public String getOrientation() {
        return this.f29127b;
    }

    public List<LatLonPoint> getPolyline() {
        return this.f29131f;
    }

    public String getRoad() {
        return this.f29128c;
    }

    public RideStep(Parcel r100) {
        this.f29131f = new ArrayList();
        this.f29126a = r100.readString();
        this.f29127b = r100.readString();
        this.f29128c = r100.readString();
        this.f29129d = r100.readFloat();
        this.f29130e = r100.readFloat();
        this.f29131f = r100.createTypedArrayList(LatLonPoint.CREATOR);
        this.f29132g = r100.readString();
        this.f29133h = r100.readString();
    }

    public void setAction(String r100) {
        this.f29132g = r100;
    }

    public void setAssistantAction(String r100) {
        this.f29133h = r100;
    }

    public void setDistance(float r100) {
        this.f29129d = r100;
    }

    public void setDuration(float r100) {
        this.f29130e = r100;
    }

    public void setInstruction(String r100) {
        this.f29126a = r100;
    }

    public void setOrientation(String r100) {
        this.f29127b = r100;
    }

    public void setPolyline(List<LatLonPoint> r100) {
        this.f29131f = r100;
    }

    public void setRoad(String r100) {
        this.f29128c = r100;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeString(this.f29126a);
        r100.writeString(this.f29127b);
        r100.writeString(this.f29128c);
        r100.writeFloat(this.f29129d);
        r100.writeFloat(this.f29130e);
        r100.writeTypedList(this.f29131f);
        r100.writeString(this.f29132g);
        r100.writeString(this.f29133h);
    }
}
