package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class TimeInfosElement implements Parcelable {
    public static final Parcelable.Creator<TimeInfosElement> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    int f17948a;

    /* renamed from: b, reason: collision with root package name */
    float f17949b;

    /* renamed from: c, reason: collision with root package name */
    float f17950c;

    /* renamed from: d, reason: collision with root package name */
    int f17951d;

    /* renamed from: e, reason: collision with root package name */
    private List<TMC> f17952e;

    public static class a implements Parcelable.Creator<TimeInfosElement> {
        @Override // android.os.Parcelable.Creator
        public TimeInfosElement createFromParcel(Parcel parcel) {
            return new TimeInfosElement(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ TimeInfosElement[] newArray(int i10) {
            return null;
        }
    }

    public TimeInfosElement(Parcel parcel) {
        this.f17952e = new ArrayList();
        this.f17948a = parcel.readInt();
        this.f17949b = parcel.readFloat();
        this.f17950c = parcel.readFloat();
        this.f17951d = parcel.readInt();
        this.f17952e = parcel.createTypedArrayList(TMC.CREATOR);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public float getDuration() {
        return this.f17949b;
    }

    public int getPathindex() {
        return this.f17948a;
    }

    public int getRestriction() {
        return this.f17951d;
    }

    public List<TMC> getTMCs() {
        return this.f17952e;
    }

    public float getTolls() {
        return this.f17950c;
    }

    public void setDuration(float f10) {
        this.f17949b = f10;
    }

    public void setPathindex(int i10) {
        this.f17948a = i10;
    }

    public void setRestriction(int i10) {
        this.f17951d = i10;
    }

    public void setTMCs(List<TMC> list) {
        this.f17952e = list;
    }

    public void setTolls(float f10) {
        this.f17950c = f10;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f17948a);
        parcel.writeFloat(this.f17949b);
        parcel.writeFloat(this.f17950c);
        parcel.writeInt(this.f17951d);
        parcel.writeTypedList(this.f17952e);
    }

    public TimeInfosElement() {
        this.f17952e = new ArrayList();
    }
}
