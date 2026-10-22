package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;

/* JADX INFO: loaded from: classes28.dex */
public class Doorway implements Parcelable {
    public static final Parcelable.Creator<Doorway> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f29073a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private LatLonPoint f29074b;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    public Doorway() {
    }

    public LatLonPoint getLatLonPoint() {
        return this.f29074b;
    }

    public String getName() {
        return this.f29073a;
    }

    public Doorway(Parcel r100) {
        this.f29073a = r100.readString();
        this.f29074b = (LatLonPoint) r100.readParcelable(LatLonPoint.class.getClassLoader());
    }

    public void setLatLonPoint(LatLonPoint r100) {
        this.f29074b = r100;
    }

    public void setName(String r100) {
        this.f29073a = r100;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeString(this.f29073a);
        r100.writeParcelable(this.f29074b, r101);
    }
}
