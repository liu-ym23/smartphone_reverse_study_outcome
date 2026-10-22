package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes28.dex */
public class TimeInfosElement implements Parcelable {
    public static final Parcelable.Creator<TimeInfosElement> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f29217a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    float f29218b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    float f29219c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f29220d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private List<TMC> f29221e;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    public TimeInfosElement() {
        this.f29221e = new ArrayList();
    }

    public float getDuration() {
        return this.f29218b;
    }

    public int getPathindex() {
        return this.f29217a;
    }

    public int getRestriction() {
        return this.f29220d;
    }

    public List<TMC> getTMCs() {
        return this.f29221e;
    }

    public float getTolls() {
        return this.f29219c;
    }

    public TimeInfosElement(Parcel r100) {
        this.f29221e = new ArrayList();
        this.f29217a = r100.readInt();
        this.f29218b = r100.readFloat();
        this.f29219c = r100.readFloat();
        this.f29220d = r100.readInt();
        this.f29221e = r100.createTypedArrayList(TMC.CREATOR);
    }

    public void setDuration(float r100) {
        this.f29218b = r100;
    }

    public void setPathindex(int r100) {
        this.f29217a = r100;
    }

    public void setRestriction(int r100) {
        this.f29220d = r100;
    }

    public void setTMCs(List<TMC> r100) {
        this.f29221e = r100;
    }

    public void setTolls(float r100) {
        this.f29219c = r100;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeInt(this.f29217a);
        r100.writeFloat(this.f29218b);
        r100.writeFloat(this.f29219c);
        r100.writeInt(this.f29220d);
        r100.writeTypedList(this.f29221e);
    }
}
