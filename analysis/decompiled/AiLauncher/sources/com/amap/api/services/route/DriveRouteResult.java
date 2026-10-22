package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.route.RouteSearch;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class DriveRouteResult extends RouteResult implements Parcelable {
    public static final Parcelable.Creator<DriveRouteResult> CREATOR = new a();

    /* renamed from: c, reason: collision with root package name */
    private float f17722c;

    /* renamed from: d, reason: collision with root package name */
    private List<DrivePath> f17723d;

    /* renamed from: e, reason: collision with root package name */
    private RouteSearch.DriveRouteQuery f17724e;

    public static class a implements Parcelable.Creator<DriveRouteResult> {
        @Override // android.os.Parcelable.Creator
        public DriveRouteResult createFromParcel(Parcel parcel) {
            return new DriveRouteResult(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public DriveRouteResult[] newArray(int i10) {
            return new DriveRouteResult[i10];
        }
    }

    public DriveRouteResult(Parcel parcel) {
        super(parcel);
        this.f17723d = new ArrayList();
        this.f17722c = parcel.readFloat();
        this.f17723d = parcel.createTypedArrayList(DrivePath.CREATOR);
        this.f17724e = (RouteSearch.DriveRouteQuery) parcel.readParcelable(RouteSearch.DriveRouteQuery.class.getClassLoader());
    }

    @Override // com.amap.api.services.route.RouteResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public RouteSearch.DriveRouteQuery getDriveQuery() {
        return this.f17724e;
    }

    public List<DrivePath> getPaths() {
        return this.f17723d;
    }

    public float getTaxiCost() {
        return this.f17722c;
    }

    public void setDriveQuery(RouteSearch.DriveRouteQuery driveRouteQuery) {
        this.f17724e = driveRouteQuery;
    }

    public void setPaths(List<DrivePath> list) {
        this.f17723d = list;
    }

    public void setTaxiCost(float f10) {
        this.f17722c = f10;
    }

    @Override // com.amap.api.services.route.RouteResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        super.writeToParcel(parcel, i10);
        parcel.writeFloat(this.f17722c);
        parcel.writeTypedList(this.f17723d);
        parcel.writeParcelable(this.f17724e, i10);
    }

    public DriveRouteResult() {
        this.f17723d = new ArrayList();
    }
}
