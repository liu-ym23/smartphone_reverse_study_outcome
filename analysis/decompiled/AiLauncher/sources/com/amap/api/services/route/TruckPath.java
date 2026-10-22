package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* loaded from: classes.dex */
public class TruckPath implements Parcelable {
    public static final Parcelable.Creator<TruckPath> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private float f17953a;

    /* renamed from: b, reason: collision with root package name */
    private long f17954b;

    /* renamed from: c, reason: collision with root package name */
    private String f17955c;

    /* renamed from: d, reason: collision with root package name */
    private float f17956d;

    /* renamed from: e, reason: collision with root package name */
    private float f17957e;

    /* renamed from: f, reason: collision with root package name */
    private int f17958f;

    /* renamed from: g, reason: collision with root package name */
    private int f17959g;

    /* renamed from: h, reason: collision with root package name */
    private List<TruckStep> f17960h;

    public static class a implements Parcelable.Creator<TruckPath> {
        @Override // android.os.Parcelable.Creator
        public TruckPath createFromParcel(Parcel parcel) {
            return new TruckPath(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public TruckPath[] newArray(int i10) {
            return new TruckPath[i10];
        }
    }

    public TruckPath() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public float getDistance() {
        return this.f17953a;
    }

    public long getDuration() {
        return this.f17954b;
    }

    public int getRestriction() {
        return this.f17959g;
    }

    public List<TruckStep> getSteps() {
        return this.f17960h;
    }

    public String getStrategy() {
        return this.f17955c;
    }

    public float getTollDistance() {
        return this.f17957e;
    }

    public float getTolls() {
        return this.f17956d;
    }

    public int getTotalTrafficlights() {
        return this.f17958f;
    }

    public void setDistance(float f10) {
        this.f17953a = f10;
    }

    public void setDuration(long j10) {
        this.f17954b = j10;
    }

    public void setRestriction(int i10) {
        this.f17959g = i10;
    }

    public void setSteps(List<TruckStep> list) {
        this.f17960h = list;
    }

    public void setStrategy(String str) {
        this.f17955c = str;
    }

    public void setTollDistance(float f10) {
        this.f17957e = f10;
    }

    public void setTolls(float f10) {
        this.f17956d = f10;
    }

    public void setTotalTrafficlights(int i10) {
        this.f17958f = i10;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeFloat(this.f17953a);
        parcel.writeLong(this.f17954b);
        parcel.writeString(this.f17955c);
        parcel.writeFloat(this.f17956d);
        parcel.writeFloat(this.f17957e);
        parcel.writeInt(this.f17958f);
        parcel.writeInt(this.f17959g);
        parcel.writeTypedList(this.f17960h);
    }

    public TruckPath(Parcel parcel) {
        this.f17953a = parcel.readFloat();
        this.f17954b = parcel.readLong();
        this.f17955c = parcel.readString();
        this.f17956d = parcel.readFloat();
        this.f17957e = parcel.readFloat();
        this.f17958f = parcel.readInt();
        this.f17959g = parcel.readInt();
        this.f17960h = parcel.createTypedArrayList(TruckStep.CREATOR);
    }
}
