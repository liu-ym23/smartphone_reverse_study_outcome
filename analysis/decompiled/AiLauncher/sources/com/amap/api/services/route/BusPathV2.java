package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class BusPathV2 extends Path implements Parcelable {
    public static final Parcelable.Creator<BusPathV2> CREATOR = new a();

    /* renamed from: d, reason: collision with root package name */
    private float f17640d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f17641e;

    /* renamed from: f, reason: collision with root package name */
    private float f17642f;

    /* renamed from: g, reason: collision with root package name */
    private float f17643g;

    /* renamed from: h, reason: collision with root package name */
    private List<BusStepV2> f17644h;

    public static class a implements Parcelable.Creator<BusPathV2> {
        @Override // android.os.Parcelable.Creator
        public BusPathV2 createFromParcel(Parcel parcel) {
            return new BusPathV2(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ BusPathV2[] newArray(int i10) {
            return null;
        }
    }

    public BusPathV2(Parcel parcel) {
        super(parcel);
        this.f17644h = new ArrayList();
        this.f17640d = parcel.readFloat();
        boolean[] zArr = new boolean[1];
        parcel.readBooleanArray(zArr);
        this.f17641e = zArr[0];
        this.f17642f = parcel.readFloat();
        this.f17643g = parcel.readFloat();
        this.f17644h = parcel.createTypedArrayList(BusStepV2.CREATOR);
    }

    @Override // com.amap.api.services.route.Path, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public float getBusDistance() {
        return this.f17643g;
    }

    public float getCost() {
        return this.f17640d;
    }

    public List<BusStepV2> getSteps() {
        return this.f17644h;
    }

    public float getWalkDistance() {
        return this.f17642f;
    }

    public boolean isNightBus() {
        return this.f17641e;
    }

    public void setBusDistance(float f10) {
        this.f17643g = f10;
    }

    public void setCost(float f10) {
        this.f17640d = f10;
    }

    public void setNightBus(boolean z10) {
        this.f17641e = z10;
    }

    public void setSteps(List<BusStepV2> list) {
        this.f17644h = list;
    }

    public void setWalkDistance(float f10) {
        this.f17642f = f10;
    }

    @Override // com.amap.api.services.route.Path, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        super.writeToParcel(parcel, i10);
        parcel.writeFloat(this.f17640d);
        parcel.writeBooleanArray(new boolean[]{this.f17641e});
        parcel.writeFloat(this.f17642f);
        parcel.writeFloat(this.f17643g);
        parcel.writeTypedList(this.f17644h);
    }

    public BusPathV2() {
        this.f17644h = new ArrayList();
    }
}
