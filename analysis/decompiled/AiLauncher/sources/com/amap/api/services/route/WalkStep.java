package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class WalkStep implements Parcelable {
    public static final Parcelable.Creator<WalkStep> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private String f17983a;

    /* renamed from: b, reason: collision with root package name */
    private String f17984b;

    /* renamed from: c, reason: collision with root package name */
    private String f17985c;

    /* renamed from: d, reason: collision with root package name */
    private float f17986d;

    /* renamed from: e, reason: collision with root package name */
    private float f17987e;

    /* renamed from: f, reason: collision with root package name */
    private List<LatLonPoint> f17988f;

    /* renamed from: g, reason: collision with root package name */
    private String f17989g;

    /* renamed from: h, reason: collision with root package name */
    private String f17990h;

    /* renamed from: i, reason: collision with root package name */
    private int f17991i;

    public static class a implements Parcelable.Creator<WalkStep> {
        @Override // android.os.Parcelable.Creator
        public WalkStep createFromParcel(Parcel parcel) {
            return new WalkStep(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ WalkStep[] newArray(int i10) {
            return null;
        }
    }

    public WalkStep(Parcel parcel) {
        this.f17988f = new ArrayList();
        this.f17983a = parcel.readString();
        this.f17984b = parcel.readString();
        this.f17985c = parcel.readString();
        this.f17986d = parcel.readFloat();
        this.f17987e = parcel.readFloat();
        this.f17988f = parcel.createTypedArrayList(LatLonPoint.CREATOR);
        this.f17989g = parcel.readString();
        this.f17990h = parcel.readString();
        this.f17991i = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAction() {
        return this.f17989g;
    }

    public String getAssistantAction() {
        return this.f17990h;
    }

    public float getDistance() {
        return this.f17986d;
    }

    public float getDuration() {
        return this.f17987e;
    }

    public String getInstruction() {
        return this.f17983a;
    }

    public String getOrientation() {
        return this.f17984b;
    }

    public List<LatLonPoint> getPolyline() {
        return this.f17988f;
    }

    public String getRoad() {
        return this.f17985c;
    }

    public int getRoadType() {
        return this.f17991i;
    }

    public void setAction(String str) {
        this.f17989g = str;
    }

    public void setAssistantAction(String str) {
        this.f17990h = str;
    }

    public void setDistance(float f10) {
        this.f17986d = f10;
    }

    public void setDuration(float f10) {
        this.f17987e = f10;
    }

    public void setInstruction(String str) {
        this.f17983a = str;
    }

    public void setOrientation(String str) {
        this.f17984b = str;
    }

    public void setPolyline(List<LatLonPoint> list) {
        this.f17988f = list;
    }

    public void setRoad(String str) {
        this.f17985c = str;
    }

    public void setRoadType(int i10) {
        this.f17991i = i10;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f17983a);
        parcel.writeString(this.f17984b);
        parcel.writeString(this.f17985c);
        parcel.writeFloat(this.f17986d);
        parcel.writeFloat(this.f17987e);
        parcel.writeTypedList(this.f17988f);
        parcel.writeString(this.f17989g);
        parcel.writeString(this.f17990h);
        parcel.writeInt(this.f17991i);
    }

    public WalkStep() {
        this.f17988f = new ArrayList();
    }
}
