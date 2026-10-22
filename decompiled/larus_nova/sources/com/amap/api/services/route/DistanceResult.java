package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* JADX INFO: loaded from: classes28.dex */
public class DistanceResult implements Parcelable {
    public static final Parcelable.Creator<DistanceResult> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private DistanceSearch.DistanceQuery f29063a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<DistanceItem> f29064b;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    public DistanceResult() {
        this.f29064b = null;
    }

    public DistanceSearch.DistanceQuery getDistanceQuery() {
        return this.f29063a;
    }

    public List<DistanceItem> getDistanceResults() {
        return this.f29064b;
    }

    public DistanceResult(Parcel r100) {
        this.f29064b = null;
        this.f29064b = r100.createTypedArrayList(DistanceItem.CREATOR);
    }

    public void setDistanceQuery(DistanceSearch.DistanceQuery r100) {
        this.f29063a = r100;
    }

    public void setDistanceResults(List<DistanceItem> r100) {
        this.f29064b = r100;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeTypedList(this.f29064b);
    }
}
