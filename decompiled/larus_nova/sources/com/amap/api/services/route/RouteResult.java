package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;

/* JADX INFO: loaded from: classes28.dex */
public class RouteResult implements Parcelable {
    public static final Parcelable.Creator<RouteResult> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private LatLonPoint f29153a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private LatLonPoint f29154b;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    public RouteResult() {
    }

    public LatLonPoint getStartPos() {
        return this.f29153a;
    }

    public LatLonPoint getTargetPos() {
        return this.f29154b;
    }

    public RouteResult(Parcel r100) {
        this.f29153a = (LatLonPoint) r100.readParcelable(LatLonPoint.class.getClassLoader());
        this.f29154b = (LatLonPoint) r100.readParcelable(LatLonPoint.class.getClassLoader());
    }

    public void setStartPos(LatLonPoint r100) {
        this.f29153a = r100;
    }

    public void setTargetPos(LatLonPoint r100) {
        this.f29154b = r100;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeParcelable(this.f29153a, r101);
        r100.writeParcelable(this.f29154b, r101);
    }
}
