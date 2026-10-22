package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes28.dex */
public class RailwaySpace implements Parcelable {
    public static final Parcelable.Creator<RailwaySpace> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f29113a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f29114b;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    public String getCode() {
        return this.f29113a;
    }

    public float getCost() {
        return this.f29114b;
    }

    public RailwaySpace(Parcel r100) {
        this.f29113a = r100.readString();
        this.f29114b = r100.readFloat();
    }

    public RailwaySpace(String r100, float r101) {
        this.f29113a = r100;
        this.f29114b = r101;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeString(this.f29113a);
        r100.writeFloat(this.f29114b);
    }
}
