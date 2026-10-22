package com.baidu.mapapi.search.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.core.TaxiInfo;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class DrivingRouteResult extends SearchResult implements Parcelable {
    public static final Parcelable.Creator<DrivingRouteResult> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private List<DrivingRouteLine> f7477a;

    /* renamed from: b, reason: collision with root package name */
    private List<TaxiInfo> f7478b;

    /* renamed from: c, reason: collision with root package name */
    private TaxiInfo f7479c;

    /* renamed from: d, reason: collision with root package name */
    private SuggestAddrInfo f7480d;

    public static class a implements Parcelable.Creator<DrivingRouteResult> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public DrivingRouteResult createFromParcel(Parcel parcel) {
            return new DrivingRouteResult(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public DrivingRouteResult[] newArray(int i4) {
            return new DrivingRouteResult[i4];
        }
    }

    public DrivingRouteResult() {
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<DrivingRouteLine> getRouteLines() {
        return this.f7477a;
    }

    public SuggestAddrInfo getSuggestAddrInfo() {
        return this.f7480d;
    }

    @Deprecated
    public TaxiInfo getTaxiInfo() {
        return this.f7479c;
    }

    public List<TaxiInfo> getTaxiInfos() {
        return this.f7478b;
    }

    public void setRouteLines(List<DrivingRouteLine> list) {
        this.f7477a = list;
    }

    public void setSuggestAddrInfo(SuggestAddrInfo suggestAddrInfo) {
        this.f7480d = suggestAddrInfo;
    }

    public void setTaxiInfos(List<TaxiInfo> list) {
        this.f7478b = list;
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeTypedList(this.f7477a);
        parcel.writeTypedList(this.f7478b);
        parcel.writeParcelable(this.f7480d, 1);
    }

    public DrivingRouteResult(Parcel parcel) {
        ArrayList arrayList = new ArrayList();
        this.f7477a = arrayList;
        parcel.readTypedList(arrayList, DrivingRouteLine.CREATOR);
        ArrayList arrayList2 = new ArrayList();
        this.f7478b = arrayList2;
        parcel.readTypedList(arrayList2, TaxiInfo.CREATOR);
        this.f7480d = (SuggestAddrInfo) parcel.readParcelable(SuggestAddrInfo.class.getClassLoader());
    }
}
