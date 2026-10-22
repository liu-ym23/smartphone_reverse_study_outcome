package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.route.DistanceSearch;
import java.util.List;

/* loaded from: classes.dex */
public class DistanceResult implements Parcelable {
    public static final Parcelable.Creator<DistanceResult> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private DistanceSearch.DistanceQuery f17687a;

    /* renamed from: b, reason: collision with root package name */
    private List<DistanceItem> f17688b;

    public static class a implements Parcelable.Creator<DistanceResult> {
        @Override // android.os.Parcelable.Creator
        public DistanceResult createFromParcel(Parcel parcel) {
            return new DistanceResult(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public DistanceResult[] newArray(int i10) {
            return new DistanceResult[i10];
        }
    }

    public DistanceResult() {
        this.f17688b = null;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public DistanceSearch.DistanceQuery getDistanceQuery() {
        return this.f17687a;
    }

    public List<DistanceItem> getDistanceResults() {
        return this.f17688b;
    }

    public void setDistanceQuery(DistanceSearch.DistanceQuery distanceQuery) {
        this.f17687a = distanceQuery;
    }

    public void setDistanceResults(List<DistanceItem> list) {
        this.f17688b = list;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeTypedList(this.f17688b);
    }

    public DistanceResult(Parcel parcel) {
        this.f17688b = null;
        this.f17688b = parcel.createTypedArrayList(DistanceItem.CREATOR);
    }
}
