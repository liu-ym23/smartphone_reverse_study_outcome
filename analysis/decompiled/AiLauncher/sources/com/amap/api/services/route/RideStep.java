package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class RideStep implements Parcelable {
    public static final Parcelable.Creator<RideStep> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private String f17777a;

    /* renamed from: b, reason: collision with root package name */
    private String f17778b;

    /* renamed from: c, reason: collision with root package name */
    private String f17779c;

    /* renamed from: d, reason: collision with root package name */
    private float f17780d;

    /* renamed from: e, reason: collision with root package name */
    private float f17781e;

    /* renamed from: f, reason: collision with root package name */
    private List<LatLonPoint> f17782f;

    /* renamed from: g, reason: collision with root package name */
    private String f17783g;

    /* renamed from: h, reason: collision with root package name */
    private String f17784h;

    /* renamed from: i, reason: collision with root package name */
    private int f17785i;

    public static class a implements Parcelable.Creator<RideStep> {
        @Override // android.os.Parcelable.Creator
        public RideStep createFromParcel(Parcel parcel) {
            return new RideStep(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public RideStep[] newArray(int i10) {
            return new RideStep[i10];
        }
    }

    public RideStep() {
        this.f17782f = new ArrayList();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAction() {
        return this.f17783g;
    }

    public String getAssistantAction() {
        return this.f17784h;
    }

    public float getDistance() {
        return this.f17780d;
    }

    public float getDuration() {
        return this.f17781e;
    }

    public String getInstruction() {
        return this.f17777a;
    }

    public String getOrientation() {
        return this.f17778b;
    }

    public List<LatLonPoint> getPolyline() {
        return this.f17782f;
    }

    public String getRoad() {
        return this.f17779c;
    }

    public int getRoadType() {
        return this.f17785i;
    }

    public void setAction(String str) {
        this.f17783g = str;
    }

    public void setAssistantAction(String str) {
        this.f17784h = str;
    }

    public void setDistance(float f10) {
        this.f17780d = f10;
    }

    public void setDuration(float f10) {
        this.f17781e = f10;
    }

    public void setInstruction(String str) {
        this.f17777a = str;
    }

    public void setOrientation(String str) {
        this.f17778b = str;
    }

    public void setPolyline(List<LatLonPoint> list) {
        this.f17782f = list;
    }

    public void setRoad(String str) {
        this.f17779c = str;
    }

    public void setRoadType(int i10) {
        this.f17785i = i10;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f17777a);
        parcel.writeString(this.f17778b);
        parcel.writeString(this.f17779c);
        parcel.writeFloat(this.f17780d);
        parcel.writeFloat(this.f17781e);
        parcel.writeTypedList(this.f17782f);
        parcel.writeString(this.f17783g);
        parcel.writeString(this.f17784h);
    }

    public RideStep(Parcel parcel) {
        this.f17782f = new ArrayList();
        this.f17777a = parcel.readString();
        this.f17778b = parcel.readString();
        this.f17779c = parcel.readString();
        this.f17780d = parcel.readFloat();
        this.f17781e = parcel.readFloat();
        this.f17782f = parcel.createTypedArrayList(LatLonPoint.CREATOR);
        this.f17783g = parcel.readString();
        this.f17784h = parcel.readString();
    }
}
