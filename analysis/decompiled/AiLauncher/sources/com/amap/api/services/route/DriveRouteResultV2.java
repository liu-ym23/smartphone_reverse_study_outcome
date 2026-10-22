package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.route.RouteSearchV2;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class DriveRouteResultV2 extends RouteResult implements Parcelable {
    public static final Parcelable.Creator<DriveRouteResultV2> CREATOR = new a();

    /* renamed from: c, reason: collision with root package name */
    private float f17725c;

    /* renamed from: d, reason: collision with root package name */
    private List<DrivePathV2> f17726d;

    /* renamed from: e, reason: collision with root package name */
    private RouteSearchV2.DriveRouteQuery f17727e;

    public static class a implements Parcelable.Creator<DriveRouteResultV2> {
        @Override // android.os.Parcelable.Creator
        public DriveRouteResultV2 createFromParcel(Parcel parcel) {
            return new DriveRouteResultV2(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public DriveRouteResultV2[] newArray(int i10) {
            return new DriveRouteResultV2[i10];
        }
    }

    public DriveRouteResultV2(Parcel parcel) {
        super(parcel);
        this.f17726d = new ArrayList();
        this.f17725c = parcel.readFloat();
        this.f17726d = parcel.createTypedArrayList(DrivePathV2.CREATOR);
        this.f17727e = (RouteSearchV2.DriveRouteQuery) parcel.readParcelable(RouteSearchV2.DriveRouteQuery.class.getClassLoader());
    }

    @Override // com.amap.api.services.route.RouteResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public RouteSearchV2.DriveRouteQuery getDriveQuery() {
        return this.f17727e;
    }

    public List<DrivePathV2> getPaths() {
        return this.f17726d;
    }

    public float getTaxiCost() {
        return this.f17725c;
    }

    public void setDriveQuery(RouteSearchV2.DriveRouteQuery driveRouteQuery) {
        this.f17727e = driveRouteQuery;
    }

    public void setPaths(List<DrivePathV2> list) {
        this.f17726d = list;
    }

    public void setTaxiCost(float f10) {
        this.f17725c = f10;
    }

    @Override // com.amap.api.services.route.RouteResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        super.writeToParcel(parcel, i10);
        parcel.writeFloat(this.f17725c);
        parcel.writeTypedList(this.f17726d);
        parcel.writeParcelable(this.f17727e, i10);
    }

    public DriveRouteResultV2() {
        this.f17726d = new ArrayList();
    }
}
