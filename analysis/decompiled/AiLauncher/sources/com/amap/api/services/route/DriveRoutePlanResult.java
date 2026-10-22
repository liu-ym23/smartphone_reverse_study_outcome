package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.route.RouteSearch;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class DriveRoutePlanResult extends RoutePlanResult implements Parcelable {
    public static final Parcelable.Creator<DriveRoutePlanResult> CREATOR = new a();

    /* renamed from: c, reason: collision with root package name */
    private List<DrivePlanPath> f17719c;

    /* renamed from: d, reason: collision with root package name */
    private List<TimeInfo> f17720d;

    /* renamed from: e, reason: collision with root package name */
    private RouteSearch.DrivePlanQuery f17721e;

    public static class a implements Parcelable.Creator<DriveRoutePlanResult> {
        @Override // android.os.Parcelable.Creator
        public DriveRoutePlanResult createFromParcel(Parcel parcel) {
            return new DriveRoutePlanResult(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public DriveRoutePlanResult[] newArray(int i10) {
            return new DriveRoutePlanResult[i10];
        }
    }

    public DriveRoutePlanResult(Parcel parcel) {
        super(parcel);
        this.f17719c = new ArrayList();
        this.f17720d = new ArrayList();
        this.f17719c = parcel.createTypedArrayList(DrivePlanPath.CREATOR);
        this.f17720d = parcel.createTypedArrayList(TimeInfo.CREATOR);
        this.f17721e = (RouteSearch.DrivePlanQuery) parcel.readParcelable(RouteSearch.DrivePlanQuery.class.getClassLoader());
    }

    @Override // com.amap.api.services.route.RoutePlanResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<DrivePlanPath> getPaths() {
        return this.f17719c;
    }

    public List<TimeInfo> getTimeInfos() {
        return this.f17720d;
    }

    public void setDrivePlanQuery(RouteSearch.DrivePlanQuery drivePlanQuery) {
        this.f17721e = drivePlanQuery;
        RouteSearch.FromAndTo fromAndTo = drivePlanQuery.getFromAndTo();
        if (fromAndTo != null) {
            setStartPos(fromAndTo.getFrom());
            setTargetPos(fromAndTo.getTo());
        }
    }

    public void setPaths(List<DrivePlanPath> list) {
        this.f17719c = list;
    }

    public void setTimeInfos(List<TimeInfo> list) {
        this.f17720d = list;
    }

    @Override // com.amap.api.services.route.RoutePlanResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        super.writeToParcel(parcel, i10);
        parcel.writeTypedList(this.f17719c);
        parcel.writeTypedList(this.f17720d);
        parcel.writeParcelable(this.f17721e, i10);
    }

    public DriveRoutePlanResult() {
        this.f17719c = new ArrayList();
        this.f17720d = new ArrayList();
    }
}
