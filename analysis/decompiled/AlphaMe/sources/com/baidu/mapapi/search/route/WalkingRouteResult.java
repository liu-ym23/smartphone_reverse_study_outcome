package com.baidu.mapapi.search.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.core.TaxiInfo;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class WalkingRouteResult extends SearchResult implements Parcelable {
    public static final Parcelable.Creator<WalkingRouteResult> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private List<WalkingRouteLine> f7561a;

    /* renamed from: b, reason: collision with root package name */
    private TaxiInfo f7562b;

    /* renamed from: c, reason: collision with root package name */
    private SuggestAddrInfo f7563c;

    public static class a implements Parcelable.Creator<WalkingRouteResult> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public WalkingRouteResult createFromParcel(Parcel parcel) {
            return new WalkingRouteResult(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public WalkingRouteResult[] newArray(int i4) {
            return new WalkingRouteResult[i4];
        }
    }

    public WalkingRouteResult() {
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<WalkingRouteLine> getRouteLines() {
        return this.f7561a;
    }

    public SuggestAddrInfo getSuggestAddrInfo() {
        return this.f7563c;
    }

    public TaxiInfo getTaxiInfo() {
        return this.f7562b;
    }

    public void setRouteLines(List<WalkingRouteLine> list) {
        this.f7561a = list;
    }

    public void setSuggestAddrInfo(SuggestAddrInfo suggestAddrInfo) {
        this.f7563c = suggestAddrInfo;
    }

    public void setTaxiInfo(TaxiInfo taxiInfo) {
        this.f7562b = taxiInfo;
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeList(this.f7561a);
        parcel.writeParcelable(this.f7562b, 1);
        parcel.writeParcelable(this.f7563c, 1);
    }

    public WalkingRouteResult(Parcel parcel) {
        ArrayList arrayList = new ArrayList();
        this.f7561a = arrayList;
        parcel.readList(arrayList, WalkingRouteLine.class.getClassLoader());
        this.f7562b = (TaxiInfo) parcel.readParcelable(TaxiInfo.class.getClassLoader());
        this.f7563c = (SuggestAddrInfo) parcel.readParcelable(SuggestAddrInfo.class.getClassLoader());
    }
}
