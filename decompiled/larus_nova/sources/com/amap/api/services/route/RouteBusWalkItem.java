package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;

/* JADX INFO: loaded from: classes28.dex */
public class RouteBusWalkItem extends WalkPath {
    public static final Parcelable.Creator<RouteBusWalkItem> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private LatLonPoint f29140a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private LatLonPoint f29141b;

    @Override // com.amap.api.services.route.WalkPath, com.amap.api.services.route.Path, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    public RouteBusWalkItem() {
    }

    public LatLonPoint getDestination() {
        return this.f29141b;
    }

    public LatLonPoint getOrigin() {
        return this.f29140a;
    }

    public RouteBusWalkItem(Parcel r100) {
        super(r100);
        this.f29140a = (LatLonPoint) r100.readParcelable(LatLonPoint.class.getClassLoader());
        this.f29141b = (LatLonPoint) r100.readParcelable(LatLonPoint.class.getClassLoader());
    }

    public void setDestination(LatLonPoint r100) {
        this.f29141b = r100;
    }

    public void setOrigin(LatLonPoint r100) {
        this.f29140a = r100;
    }

    @Override // com.amap.api.services.route.WalkPath, com.amap.api.services.route.Path, android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        super.writeToParcel(r100, r101);
        r100.writeParcelable(this.f29140a, r101);
        r100.writeParcelable(this.f29141b, r101);
    }
}
