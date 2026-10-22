package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;

/* loaded from: classes.dex */
public class RouteResult implements Parcelable {
    public static final Parcelable.Creator<RouteResult> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private LatLonPoint f17805a;

    /* renamed from: b, reason: collision with root package name */
    private LatLonPoint f17806b;

    public static class a implements Parcelable.Creator<RouteResult> {
        @Override // android.os.Parcelable.Creator
        public RouteResult createFromParcel(Parcel parcel) {
            return new RouteResult(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public RouteResult[] newArray(int i10) {
            return new RouteResult[i10];
        }
    }

    public RouteResult(Parcel parcel) {
        this.f17805a = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
        this.f17806b = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public LatLonPoint getStartPos() {
        return this.f17805a;
    }

    public LatLonPoint getTargetPos() {
        return this.f17806b;
    }

    public void setStartPos(LatLonPoint latLonPoint) {
        this.f17805a = latLonPoint;
    }

    public void setTargetPos(LatLonPoint latLonPoint) {
        this.f17806b = latLonPoint;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeParcelable(this.f17805a, i10);
        parcel.writeParcelable(this.f17806b, i10);
    }

    public RouteResult() {
    }
}
