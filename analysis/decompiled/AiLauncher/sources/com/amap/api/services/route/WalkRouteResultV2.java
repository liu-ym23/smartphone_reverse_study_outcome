package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.route.RouteSearchV2;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class WalkRouteResultV2 extends RouteResult implements Parcelable {
    public static final Parcelable.Creator<WalkRouteResultV2> CREATOR = new a();

    /* renamed from: c, reason: collision with root package name */
    private List<WalkPath> f17981c;

    /* renamed from: d, reason: collision with root package name */
    private RouteSearchV2.WalkRouteQuery f17982d;

    public static class a implements Parcelable.Creator<WalkRouteResultV2> {
        @Override // android.os.Parcelable.Creator
        public WalkRouteResultV2 createFromParcel(Parcel parcel) {
            return new WalkRouteResultV2(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public WalkRouteResultV2[] newArray(int i10) {
            return new WalkRouteResultV2[i10];
        }
    }

    public WalkRouteResultV2(Parcel parcel) {
        super(parcel);
        this.f17981c = new ArrayList();
        this.f17981c = parcel.createTypedArrayList(WalkPath.CREATOR);
        this.f17982d = (RouteSearchV2.WalkRouteQuery) parcel.readParcelable(RouteSearchV2.WalkRouteQuery.class.getClassLoader());
    }

    @Override // com.amap.api.services.route.RouteResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<WalkPath> getPaths() {
        return this.f17981c;
    }

    public RouteSearchV2.WalkRouteQuery getWalkQuery() {
        return this.f17982d;
    }

    public void setPaths(List<WalkPath> list) {
        this.f17981c = list;
    }

    public void setWalkQuery(RouteSearchV2.WalkRouteQuery walkRouteQuery) {
        this.f17982d = walkRouteQuery;
    }

    @Override // com.amap.api.services.route.RouteResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        super.writeToParcel(parcel, i10);
        parcel.writeTypedList(this.f17981c);
        parcel.writeParcelable(this.f17982d, i10);
    }

    public WalkRouteResultV2() {
        this.f17981c = new ArrayList();
    }
}
