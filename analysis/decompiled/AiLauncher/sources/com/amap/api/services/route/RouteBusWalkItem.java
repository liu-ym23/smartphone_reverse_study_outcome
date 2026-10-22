package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;

/* loaded from: classes.dex */
public class RouteBusWalkItem extends WalkPath implements Parcelable {
    public static final Parcelable.Creator<RouteBusWalkItem> CREATOR = new a();

    /* renamed from: e, reason: collision with root package name */
    private LatLonPoint f17792e;

    /* renamed from: f, reason: collision with root package name */
    private LatLonPoint f17793f;

    public static class a implements Parcelable.Creator<RouteBusWalkItem> {
        @Override // android.os.Parcelable.Creator
        public RouteBusWalkItem createFromParcel(Parcel parcel) {
            return new RouteBusWalkItem(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ RouteBusWalkItem[] newArray(int i10) {
            return null;
        }
    }

    public RouteBusWalkItem(Parcel parcel) {
        super(parcel);
        this.f17792e = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
        this.f17793f = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
    }

    @Override // com.amap.api.services.route.WalkPath, com.amap.api.services.route.Path, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public LatLonPoint getDestination() {
        return this.f17793f;
    }

    public LatLonPoint getOrigin() {
        return this.f17792e;
    }

    public void setDestination(LatLonPoint latLonPoint) {
        this.f17793f = latLonPoint;
    }

    public void setOrigin(LatLonPoint latLonPoint) {
        this.f17792e = latLonPoint;
    }

    @Override // com.amap.api.services.route.WalkPath, com.amap.api.services.route.Path, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        super.writeToParcel(parcel, i10);
        parcel.writeParcelable(this.f17792e, i10);
        parcel.writeParcelable(this.f17793f, i10);
    }

    public RouteBusWalkItem() {
    }
}
