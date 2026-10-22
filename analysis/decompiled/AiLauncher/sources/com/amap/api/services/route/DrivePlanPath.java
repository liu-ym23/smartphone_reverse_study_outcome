package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class DrivePlanPath implements Parcelable {
    public static final Parcelable.Creator<DrivePlanPath> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    float f17711a;

    /* renamed from: b, reason: collision with root package name */
    int f17712b;

    /* renamed from: c, reason: collision with root package name */
    private List<DrivePlanStep> f17713c;

    public static class a implements Parcelable.Creator<DrivePlanPath> {
        @Override // android.os.Parcelable.Creator
        public DrivePlanPath createFromParcel(Parcel parcel) {
            return new DrivePlanPath(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ DrivePlanPath[] newArray(int i10) {
            return null;
        }
    }

    public DrivePlanPath(Parcel parcel) {
        this.f17713c = new ArrayList();
        this.f17711a = parcel.readFloat();
        this.f17712b = parcel.readInt();
        this.f17713c = parcel.createTypedArrayList(DrivePlanStep.CREATOR);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public float getDistance() {
        return this.f17711a;
    }

    public List<DrivePlanStep> getSteps() {
        return this.f17713c;
    }

    public float getTrafficLights() {
        return this.f17712b;
    }

    public void setDistance(float f10) {
        this.f17711a = f10;
    }

    public void setSteps(List<DrivePlanStep> list) {
        this.f17713c = list;
    }

    public void setTrafficLights(int i10) {
        this.f17712b = i10;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeFloat(this.f17711a);
        parcel.writeInt(this.f17712b);
        parcel.writeTypedList(this.f17713c);
    }

    public DrivePlanPath() {
        this.f17713c = new ArrayList();
    }
}
