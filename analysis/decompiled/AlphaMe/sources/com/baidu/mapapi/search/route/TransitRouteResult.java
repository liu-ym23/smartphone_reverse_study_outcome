package com.baidu.mapapi.search.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.core.TaxiInfo;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class TransitRouteResult extends SearchResult implements Parcelable {
    public static final Parcelable.Creator<TransitRouteResult> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private TaxiInfo f7551a;

    /* renamed from: b, reason: collision with root package name */
    private List<TransitRouteLine> f7552b;

    /* renamed from: c, reason: collision with root package name */
    private SuggestAddrInfo f7553c;

    public static class a implements Parcelable.Creator<TransitRouteResult> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public TransitRouteResult createFromParcel(Parcel parcel) {
            return new TransitRouteResult(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public TransitRouteResult[] newArray(int i4) {
            return new TransitRouteResult[i4];
        }
    }

    public TransitRouteResult() {
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<TransitRouteLine> getRouteLines() {
        return this.f7552b;
    }

    public SuggestAddrInfo getSuggestAddrInfo() {
        return this.f7553c;
    }

    public TaxiInfo getTaxiInfo() {
        return this.f7551a;
    }

    public void setRoutelines(List<TransitRouteLine> list) {
        this.f7552b = list;
    }

    public void setSuggestAddrInfo(SuggestAddrInfo suggestAddrInfo) {
        this.f7553c = suggestAddrInfo;
    }

    public void setTaxiInfo(TaxiInfo taxiInfo) {
        this.f7551a = taxiInfo;
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeParcelable(this.f7551a, 1);
        parcel.writeList(this.f7552b);
        parcel.writeParcelable(this.f7553c, 1);
    }

    public TransitRouteResult(Parcel parcel) {
        this.f7551a = (TaxiInfo) parcel.readParcelable(TaxiInfo.class.getClassLoader());
        ArrayList arrayList = new ArrayList();
        this.f7552b = arrayList;
        parcel.readList(arrayList, TransitRouteLine.class.getClassLoader());
        this.f7553c = (SuggestAddrInfo) parcel.readParcelable(SuggestAddrInfo.class.getClassLoader());
    }
}
