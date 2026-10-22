package com.amap.api.services.road;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes28.dex */
public final class Crossroad extends Road {
    public static final Parcelable.Creator<Crossroad> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f29031a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f29032b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f29033c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f29034d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f29035e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f29036f;

    @Override // com.amap.api.services.road.Road, android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    public Crossroad() {
    }

    public final String getDirection() {
        return this.f29032b;
    }

    public final float getDistance() {
        return this.f29031a;
    }

    public final String getFirstRoadId() {
        return this.f29033c;
    }

    public final String getFirstRoadName() {
        return this.f29034d;
    }

    public final String getSecondRoadId() {
        return this.f29035e;
    }

    public final String getSecondRoadName() {
        return this.f29036f;
    }

    private Crossroad(Parcel r100) {
        super(r100);
        this.f29031a = r100.readFloat();
        this.f29032b = r100.readString();
        this.f29033c = r100.readString();
        this.f29034d = r100.readString();
        this.f29035e = r100.readString();
        this.f29036f = r100.readString();
    }

    public final void setDirection(String r100) {
        this.f29032b = r100;
    }

    public final void setDistance(float r100) {
        this.f29031a = r100;
    }

    public final void setFirstRoadId(String r100) {
        this.f29033c = r100;
    }

    public final void setFirstRoadName(String r100) {
        this.f29034d = r100;
    }

    public final void setSecondRoadId(String r100) {
        this.f29035e = r100;
    }

    public final void setSecondRoadName(String r100) {
        this.f29036f = r100;
    }

    public /* synthetic */ Crossroad(Parcel r100, byte r101) {
        this(r100);
    }

    @Override // com.amap.api.services.road.Road, android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        super.writeToParcel(r100, r101);
        r100.writeFloat(this.f29031a);
        r100.writeString(this.f29032b);
        r100.writeString(this.f29033c);
        r100.writeString(this.f29034d);
        r100.writeString(this.f29035e);
        r100.writeString(this.f29036f);
    }
}
