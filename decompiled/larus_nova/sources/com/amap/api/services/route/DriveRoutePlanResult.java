package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes28.dex */
public class DriveRoutePlanResult extends RoutePlanResult {
    public static final Parcelable.Creator<DriveRoutePlanResult> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<DrivePlanPath> f29089a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<TimeInfo> f29090b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private RouteSearch.DrivePlanQuery f29091c;

    @Override // com.amap.api.services.route.RoutePlanResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    public DriveRoutePlanResult() {
        this.f29089a = new ArrayList();
        this.f29090b = new ArrayList();
    }

    public List<DrivePlanPath> getPaths() {
        return this.f29089a;
    }

    public List<TimeInfo> getTimeInfos() {
        return this.f29090b;
    }

    public DriveRoutePlanResult(Parcel r100) {
        super(r100);
        this.f29089a = new ArrayList();
        this.f29090b = new ArrayList();
        this.f29089a = r100.createTypedArrayList(DrivePlanPath.CREATOR);
        this.f29090b = r100.createTypedArrayList(TimeInfo.CREATOR);
        this.f29091c = (RouteSearch.DrivePlanQuery) r100.readParcelable(RouteSearch.DrivePlanQuery.class.getClassLoader());
    }

    public void setDrivePlanQuery(RouteSearch.DrivePlanQuery r100) {
        this.f29091c = r100;
        RouteSearch.FromAndTo r101 = r100.getFromAndTo();
        if (r101 == null) goto L6;
        setStartPos(r101.getFrom());
        setTargetPos(r101.getTo());
        return;
    }

    public void setPaths(List<DrivePlanPath> r100) {
        this.f29089a = r100;
    }

    public void setTimeInfos(List<TimeInfo> r100) {
        this.f29090b = r100;
    }

    @Override // com.amap.api.services.route.RoutePlanResult, android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        super.writeToParcel(r100, r101);
        r100.writeTypedList(this.f29089a);
        r100.writeTypedList(this.f29090b);
        r100.writeParcelable(this.f29091c, r101);
    }
}
