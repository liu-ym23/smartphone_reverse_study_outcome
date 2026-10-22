package com.amap.api.services.geocoder;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;

/* JADX INFO: loaded from: classes28.dex */
public final class StreetNumber implements Parcelable {
    public static final Parcelable.Creator<StreetNumber> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f28951a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f28952b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private LatLonPoint f28953c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f28954d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f28955e;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    public StreetNumber() {
    }

    public final String getDirection() {
        return this.f28954d;
    }

    public final float getDistance() {
        return this.f28955e;
    }

    public final LatLonPoint getLatLonPoint() {
        return this.f28953c;
    }

    public final String getNumber() {
        return this.f28952b;
    }

    public final String getStreet() {
        return this.f28951a;
    }

    private StreetNumber(Parcel r100) {
        this.f28951a = r100.readString();
        this.f28952b = r100.readString();
        this.f28953c = (LatLonPoint) r100.readValue(LatLonPoint.class.getClassLoader());
        this.f28954d = r100.readString();
        this.f28955e = r100.readFloat();
    }

    public final void setDirection(String r100) {
        this.f28954d = r100;
    }

    public final void setDistance(float r100) {
        this.f28955e = r100;
    }

    public final void setLatLonPoint(LatLonPoint r100) {
        this.f28953c = r100;
    }

    public final void setNumber(String r100) {
        this.f28952b = r100;
    }

    public final void setStreet(String r100) {
        this.f28951a = r100;
    }

    public /* synthetic */ StreetNumber(Parcel r100, byte r101) {
        this(r100);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        r100.writeString(this.f28951a);
        r100.writeString(this.f28952b);
        r100.writeValue(this.f28953c);
        r100.writeString(this.f28954d);
        r100.writeFloat(this.f28955e);
    }
}
