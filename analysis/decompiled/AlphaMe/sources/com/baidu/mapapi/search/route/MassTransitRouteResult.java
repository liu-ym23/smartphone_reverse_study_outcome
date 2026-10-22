package com.baidu.mapapi.search.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.core.TaxiInfo;
import com.baidu.mapapi.search.core.TransitResultNode;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class MassTransitRouteResult extends SearchResult implements Parcelable {
    public static final Parcelable.Creator<MassTransitRouteResult> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private TransitResultNode f7520a;

    /* renamed from: b, reason: collision with root package name */
    private TransitResultNode f7521b;

    /* renamed from: c, reason: collision with root package name */
    private TaxiInfo f7522c;

    /* renamed from: d, reason: collision with root package name */
    private int f7523d;

    /* renamed from: e, reason: collision with root package name */
    private List<MassTransitRouteLine> f7524e;

    /* renamed from: f, reason: collision with root package name */
    private SuggestAddrInfo f7525f;

    public static class a implements Parcelable.Creator<MassTransitRouteResult> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public MassTransitRouteResult createFromParcel(Parcel parcel) {
            return new MassTransitRouteResult(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public MassTransitRouteResult[] newArray(int i4) {
            return new MassTransitRouteResult[i4];
        }
    }

    public MassTransitRouteResult() {
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public TransitResultNode getDestination() {
        return this.f7521b;
    }

    public TransitResultNode getOrigin() {
        return this.f7520a;
    }

    public List<MassTransitRouteLine> getRouteLines() {
        return this.f7524e;
    }

    public SuggestAddrInfo getSuggestAddrInfo() {
        return this.f7525f;
    }

    public TaxiInfo getTaxiInfo() {
        return this.f7522c;
    }

    public int getTotal() {
        return this.f7523d;
    }

    public void setDestination(TransitResultNode transitResultNode) {
        this.f7521b = transitResultNode;
    }

    public void setOrigin(TransitResultNode transitResultNode) {
        this.f7520a = transitResultNode;
    }

    public void setRoutelines(List<MassTransitRouteLine> list) {
        this.f7524e = list;
    }

    public void setSuggestAddrInfo(SuggestAddrInfo suggestAddrInfo) {
        this.f7525f = suggestAddrInfo;
    }

    public void setTaxiInfo(TaxiInfo taxiInfo) {
        this.f7522c = taxiInfo;
    }

    public void setTotal(int i4) {
        this.f7523d = i4;
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeParcelable(this.f7520a, 1);
        parcel.writeParcelable(this.f7521b, 1);
        parcel.writeParcelable(this.f7522c, 1);
        parcel.writeInt(this.f7523d);
        parcel.writeList(this.f7524e);
        parcel.writeParcelable(this.f7525f, 1);
    }

    public MassTransitRouteResult(Parcel parcel) {
        this.f7520a = (TransitResultNode) parcel.readParcelable(TransitResultNode.class.getClassLoader());
        this.f7521b = (TransitResultNode) parcel.readParcelable(TransitResultNode.class.getClassLoader());
        this.f7522c = (TaxiInfo) parcel.readParcelable(TaxiInfo.class.getClassLoader());
        this.f7523d = parcel.readInt();
        ArrayList arrayList = new ArrayList();
        this.f7524e = arrayList;
        parcel.readList(arrayList, MassTransitRouteLine.class.getClassLoader());
        this.f7525f = (SuggestAddrInfo) parcel.readParcelable(SuggestAddrInfo.class.getClassLoader());
    }
}
