package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;

/* JADX INFO: loaded from: classes28.dex */
public class RoutePlanResult implements Parcelable {
    public static final Parcelable.Creator<RoutePlanResult> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private LatLonPoint f29142a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private LatLonPoint f29143b;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    public RoutePlanResult() {
    }

    public LatLonPoint getStartPos() {
        return this.f29142a;
    }

    public LatLonPoint getTargetPos() {
        return this.f29143b;
    }

    public RoutePlanResult(Parcel r100) {
        this.f29142a = (LatLonPoint) r100.readParcelable(LatLonPoint.class.getClassLoader());
        this.f29143b = (LatLonPoint) r100.readParcelable(LatLonPoint.class.getClassLoader());
    }

    public void setStartPos(LatLonPoint r100) {
        this.f29142a = r100;
    }

    public void setTargetPos(LatLonPoint r100) {
        this.f29143b = r100;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeParcelable(this.f29142a, r101);
        r100.writeParcelable(this.f29143b, r101);
    }
}
