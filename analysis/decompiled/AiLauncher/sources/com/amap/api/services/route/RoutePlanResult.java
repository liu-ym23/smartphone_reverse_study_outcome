package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;

/* loaded from: classes.dex */
public class RoutePlanResult implements Parcelable {
    public static final Parcelable.Creator<RoutePlanResult> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private LatLonPoint f17794a;

    /* renamed from: b, reason: collision with root package name */
    private LatLonPoint f17795b;

    public static class a implements Parcelable.Creator<RoutePlanResult> {
        @Override // android.os.Parcelable.Creator
        public RoutePlanResult createFromParcel(Parcel parcel) {
            return new RoutePlanResult(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public RoutePlanResult[] newArray(int i10) {
            return new RoutePlanResult[i10];
        }
    }

    public RoutePlanResult(Parcel parcel) {
        this.f17794a = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
        this.f17795b = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public LatLonPoint getStartPos() {
        return this.f17794a;
    }

    public LatLonPoint getTargetPos() {
        return this.f17795b;
    }

    public void setStartPos(LatLonPoint latLonPoint) {
        this.f17794a = latLonPoint;
    }

    public void setTargetPos(LatLonPoint latLonPoint) {
        this.f17795b = latLonPoint;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeParcelable(this.f17794a, i10);
        parcel.writeParcelable(this.f17795b, i10);
    }

    public RoutePlanResult() {
    }
}
