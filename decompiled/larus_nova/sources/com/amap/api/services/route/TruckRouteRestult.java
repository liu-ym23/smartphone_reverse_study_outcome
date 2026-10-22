package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;
import java.util.List;

/* JADX INFO: loaded from: classes28.dex */
public class TruckRouteRestult implements Parcelable {
    public static final Parcelable.Creator<TruckRouteRestult> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private RouteSearch.TruckRouteQuery f29230a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<TruckPath> f29231b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private LatLonPoint f29232c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private LatLonPoint f29233d;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    public TruckRouteRestult() {
    }

    public List<TruckPath> getPaths() {
        return this.f29231b;
    }

    public LatLonPoint getStartPos() {
        return this.f29232c;
    }

    public LatLonPoint getTargetPos() {
        return this.f29233d;
    }

    public RouteSearch.TruckRouteQuery getTruckQuery() {
        return this.f29230a;
    }

    public TruckRouteRestult(Parcel r100) {
        this.f29231b = r100.createTypedArrayList(TruckPath.CREATOR);
        this.f29232c = (LatLonPoint) r100.readParcelable(LatLonPoint.class.getClassLoader());
        this.f29233d = (LatLonPoint) r100.readParcelable(LatLonPoint.class.getClassLoader());
    }

    public void setPaths(List<TruckPath> r100) {
        this.f29231b = r100;
    }

    public void setStartPos(LatLonPoint r100) {
        this.f29232c = r100;
    }

    public void setTargetPos(LatLonPoint r100) {
        this.f29233d = r100;
    }

    public void setTruckQuery(RouteSearch.TruckRouteQuery r100) {
        this.f29230a = r100;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeTypedList(this.f29231b);
        r100.writeParcelable(this.f29232c, r101);
        r100.writeParcelable(this.f29233d, r101);
    }
}
