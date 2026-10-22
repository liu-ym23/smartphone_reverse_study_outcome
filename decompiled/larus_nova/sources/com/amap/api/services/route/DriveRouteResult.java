package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes28.dex */
public class DriveRouteResult extends RouteResult {
    public static final Parcelable.Creator<DriveRouteResult> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f29092a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<DrivePath> f29093b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private RouteSearch.DriveRouteQuery f29094c;

    @Override // com.amap.api.services.route.RouteResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    public DriveRouteResult() {
        this.f29093b = new ArrayList();
    }

    public RouteSearch.DriveRouteQuery getDriveQuery() {
        return this.f29094c;
    }

    public List<DrivePath> getPaths() {
        return this.f29093b;
    }

    public float getTaxiCost() {
        return this.f29092a;
    }

    public DriveRouteResult(Parcel r100) {
        super(r100);
        this.f29093b = new ArrayList();
        this.f29092a = r100.readFloat();
        this.f29093b = r100.createTypedArrayList(DrivePath.CREATOR);
        this.f29094c = (RouteSearch.DriveRouteQuery) r100.readParcelable(RouteSearch.DriveRouteQuery.class.getClassLoader());
    }

    public void setDriveQuery(RouteSearch.DriveRouteQuery r100) {
        this.f29094c = r100;
    }

    public void setPaths(List<DrivePath> r100) {
        this.f29093b = r100;
    }

    public void setTaxiCost(float r100) {
        this.f29092a = r100;
    }

    @Override // com.amap.api.services.route.RouteResult, android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        super.writeToParcel(r100, r101);
        r100.writeFloat(this.f29092a);
        r100.writeTypedList(this.f29093b);
        r100.writeParcelable(this.f29094c, r101);
    }
}
