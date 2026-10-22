package com.amap.api.services.geocoder;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;

/* JADX INFO: loaded from: classes28.dex */
public final class RegeocodeRoad implements Parcelable {
    public static final Parcelable.Creator<RegeocodeRoad> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f28946a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f28947b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float f28948c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f28949d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private LatLonPoint f28950e;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    public RegeocodeRoad() {
    }

    public final String getDirection() {
        return this.f28949d;
    }

    public final float getDistance() {
        return this.f28948c;
    }

    public final String getId() {
        return this.f28946a;
    }

    public final LatLonPoint getLatLngPoint() {
        return this.f28950e;
    }

    public final String getName() {
        return this.f28947b;
    }

    private RegeocodeRoad(Parcel r100) {
        this.f28946a = r100.readString();
        this.f28947b = r100.readString();
        this.f28948c = r100.readFloat();
        this.f28949d = r100.readString();
        this.f28950e = (LatLonPoint) r100.readValue(LatLonPoint.class.getClassLoader());
    }

    public final void setDirection(String r100) {
        this.f28949d = r100;
    }

    public final void setDistance(float r100) {
        this.f28948c = r100;
    }

    public final void setId(String r100) {
        this.f28946a = r100;
    }

    public final void setLatLngPoint(LatLonPoint r100) {
        this.f28950e = r100;
    }

    public final void setName(String r100) {
        this.f28947b = r100;
    }

    public /* synthetic */ RegeocodeRoad(Parcel r100, byte r101) {
        this(r100);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        r100.writeString(this.f28946a);
        r100.writeString(this.f28947b);
        r100.writeFloat(this.f28948c);
        r100.writeString(this.f28949d);
        r100.writeValue(this.f28950e);
    }
}
