package com.baidu.mapapi.search.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.search.core.SearchResult;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class BikingRouteResult extends SearchResult implements Parcelable {
    public static final Parcelable.Creator<BikingRouteResult> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private List<BikingRouteLine> f7453a;

    /* renamed from: b, reason: collision with root package name */
    private SuggestAddrInfo f7454b;

    /* renamed from: c, reason: collision with root package name */
    private String f7455c = "";

    public static class a implements Parcelable.Creator<BikingRouteResult> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public BikingRouteResult createFromParcel(Parcel parcel) {
            return new BikingRouteResult(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public BikingRouteResult[] newArray(int i4) {
            return new BikingRouteResult[i4];
        }
    }

    public BikingRouteResult() {
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getMessage() {
        return this.f7455c;
    }

    public List<BikingRouteLine> getRouteLines() {
        return this.f7453a;
    }

    public SuggestAddrInfo getSuggestAddrInfo() {
        return this.f7454b;
    }

    public void setMessage(String str) {
        this.f7455c = str;
    }

    public void setRouteLines(List<BikingRouteLine> list) {
        this.f7453a = list;
    }

    public void setSuggestAddrInfo(SuggestAddrInfo suggestAddrInfo) {
        this.f7454b = suggestAddrInfo;
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeList(this.f7453a);
        parcel.writeParcelable(this.f7454b, 1);
    }

    public BikingRouteResult(Parcel parcel) {
        ArrayList arrayList = new ArrayList();
        this.f7453a = arrayList;
        parcel.readList(arrayList, BikingRouteLine.class.getClassLoader());
        this.f7454b = (SuggestAddrInfo) parcel.readParcelable(SuggestAddrInfo.class.getClassLoader());
    }
}
