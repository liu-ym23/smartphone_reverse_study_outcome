package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.route.RouteSearch;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class WalkRouteResult extends RouteResult implements Parcelable {
    public static final Parcelable.Creator<WalkRouteResult> CREATOR = new a();

    /* renamed from: c, reason: collision with root package name */
    private List<WalkPath> f17979c;

    /* renamed from: d, reason: collision with root package name */
    private RouteSearch.WalkRouteQuery f17980d;

    public static class a implements Parcelable.Creator<WalkRouteResult> {
        @Override // android.os.Parcelable.Creator
        public WalkRouteResult createFromParcel(Parcel parcel) {
            return new WalkRouteResult(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public WalkRouteResult[] newArray(int i10) {
            return new WalkRouteResult[i10];
        }
    }

    public WalkRouteResult(Parcel parcel) {
        super(parcel);
        this.f17979c = new ArrayList();
        this.f17979c = parcel.createTypedArrayList(WalkPath.CREATOR);
        this.f17980d = (RouteSearch.WalkRouteQuery) parcel.readParcelable(RouteSearch.WalkRouteQuery.class.getClassLoader());
    }

    @Override // com.amap.api.services.route.RouteResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<WalkPath> getPaths() {
        return this.f17979c;
    }

    public RouteSearch.WalkRouteQuery getWalkQuery() {
        return this.f17980d;
    }

    public void setPaths(List<WalkPath> list) {
        this.f17979c = list;
    }

    public void setWalkQuery(RouteSearch.WalkRouteQuery walkRouteQuery) {
        this.f17980d = walkRouteQuery;
    }

    @Override // com.amap.api.services.route.RouteResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        super.writeToParcel(parcel, i10);
        parcel.writeTypedList(this.f17979c);
        parcel.writeParcelable(this.f17980d, i10);
    }

    public WalkRouteResult() {
        this.f17979c = new ArrayList();
    }
}
