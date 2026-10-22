package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes28.dex */
public class WalkRouteResult extends RouteResult {
    public static final Parcelable.Creator<WalkRouteResult> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<WalkPath> f29248a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private RouteSearch.WalkRouteQuery f29249b;

    @Override // com.amap.api.services.route.RouteResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    public WalkRouteResult() {
        this.f29248a = new ArrayList();
    }

    public List<WalkPath> getPaths() {
        return this.f29248a;
    }

    public RouteSearch.WalkRouteQuery getWalkQuery() {
        return this.f29249b;
    }

    public WalkRouteResult(Parcel r100) {
        super(r100);
        this.f29248a = new ArrayList();
        this.f29248a = r100.createTypedArrayList(WalkPath.CREATOR);
        this.f29249b = (RouteSearch.WalkRouteQuery) r100.readParcelable(RouteSearch.WalkRouteQuery.class.getClassLoader());
    }

    public void setPaths(List<WalkPath> r100) {
        this.f29248a = r100;
    }

    public void setWalkQuery(RouteSearch.WalkRouteQuery r100) {
        this.f29249b = r100;
    }

    @Override // com.amap.api.services.route.RouteResult, android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        super.writeToParcel(r100, r101);
        r100.writeTypedList(this.f29248a);
        r100.writeParcelable(this.f29249b, r101);
    }
}
