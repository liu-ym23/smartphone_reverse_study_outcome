package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class BusPath extends Path implements Parcelable {
    public static final Parcelable.Creator<BusPath> CREATOR = new a();

    /* renamed from: d, reason: collision with root package name */
    private float f17635d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f17636e;

    /* renamed from: f, reason: collision with root package name */
    private float f17637f;

    /* renamed from: g, reason: collision with root package name */
    private float f17638g;

    /* renamed from: h, reason: collision with root package name */
    private List<BusStep> f17639h;

    public static class a implements Parcelable.Creator<BusPath> {
        @Override // android.os.Parcelable.Creator
        public BusPath createFromParcel(Parcel parcel) {
            return new BusPath(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ BusPath[] newArray(int i10) {
            return null;
        }
    }

    public BusPath(Parcel parcel) {
        super(parcel);
        this.f17639h = new ArrayList();
        this.f17635d = parcel.readFloat();
        boolean[] zArr = new boolean[1];
        parcel.readBooleanArray(zArr);
        this.f17636e = zArr[0];
        this.f17637f = parcel.readFloat();
        this.f17638g = parcel.readFloat();
        this.f17639h = parcel.createTypedArrayList(BusStep.CREATOR);
    }

    @Override // com.amap.api.services.route.Path, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public float getBusDistance() {
        return this.f17638g;
    }

    public float getCost() {
        return this.f17635d;
    }

    public List<BusStep> getSteps() {
        return this.f17639h;
    }

    public float getWalkDistance() {
        return this.f17637f;
    }

    public boolean isNightBus() {
        return this.f17636e;
    }

    public void setBusDistance(float f10) {
        this.f17638g = f10;
    }

    public void setCost(float f10) {
        this.f17635d = f10;
    }

    public void setNightBus(boolean z10) {
        this.f17636e = z10;
    }

    public void setSteps(List<BusStep> list) {
        this.f17639h = list;
    }

    public void setWalkDistance(float f10) {
        this.f17637f = f10;
    }

    @Override // com.amap.api.services.route.Path, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        super.writeToParcel(parcel, i10);
        parcel.writeFloat(this.f17635d);
        parcel.writeBooleanArray(new boolean[]{this.f17636e});
        parcel.writeFloat(this.f17637f);
        parcel.writeFloat(this.f17638g);
        parcel.writeTypedList(this.f17639h);
    }

    public BusPath() {
        this.f17639h = new ArrayList();
    }
}
