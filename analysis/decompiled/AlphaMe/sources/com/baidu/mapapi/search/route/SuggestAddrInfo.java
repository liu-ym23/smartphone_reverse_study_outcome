package com.baidu.mapapi.search.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.search.core.CityInfo;
import com.baidu.mapapi.search.core.PoiInfo;
import java.util.List;

/* loaded from: classes.dex */
public class SuggestAddrInfo implements Parcelable {
    public static final Parcelable.Creator<SuggestAddrInfo> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private List<PoiInfo> f7536a;

    /* renamed from: b, reason: collision with root package name */
    private List<PoiInfo> f7537b;

    /* renamed from: c, reason: collision with root package name */
    private List<List<PoiInfo>> f7538c;

    /* renamed from: d, reason: collision with root package name */
    private List<CityInfo> f7539d;

    /* renamed from: e, reason: collision with root package name */
    private List<CityInfo> f7540e;

    /* renamed from: f, reason: collision with root package name */
    private List<List<CityInfo>> f7541f;

    public static class a implements Parcelable.Creator<SuggestAddrInfo> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public SuggestAddrInfo[] newArray(int i4) {
            return new SuggestAddrInfo[i4];
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public SuggestAddrInfo createFromParcel(Parcel parcel) {
            return new SuggestAddrInfo(parcel);
        }
    }

    public SuggestAddrInfo() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<CityInfo> getSuggestEndCity() {
        return this.f7540e;
    }

    public List<PoiInfo> getSuggestEndNode() {
        return this.f7537b;
    }

    public List<CityInfo> getSuggestStartCity() {
        return this.f7539d;
    }

    public List<PoiInfo> getSuggestStartNode() {
        return this.f7536a;
    }

    public List<List<CityInfo>> getSuggestWpCity() {
        return this.f7541f;
    }

    public List<List<PoiInfo>> getSuggestWpNode() {
        return this.f7538c;
    }

    public void setSuggestEndCity(List<CityInfo> list) {
        this.f7540e = list;
    }

    public void setSuggestEndNode(List<PoiInfo> list) {
        this.f7537b = list;
    }

    public void setSuggestStartCity(List<CityInfo> list) {
        this.f7539d = list;
    }

    public void setSuggestStartNode(List<PoiInfo> list) {
        this.f7536a = list;
    }

    public void setSuggestWpCity(List<List<CityInfo>> list) {
        this.f7541f = list;
    }

    public void setSuggestWpNode(List<List<PoiInfo>> list) {
        this.f7538c = list;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeList(this.f7536a);
        parcel.writeList(this.f7537b);
        parcel.writeList(this.f7538c);
        parcel.writeList(this.f7539d);
        parcel.writeList(this.f7540e);
        parcel.writeList(this.f7541f);
    }

    public SuggestAddrInfo(Parcel parcel) {
        this.f7536a = parcel.readArrayList(PoiInfo.class.getClassLoader());
        this.f7537b = parcel.readArrayList(PoiInfo.class.getClassLoader());
        this.f7538c = parcel.readArrayList(PoiInfo.class.getClassLoader());
        this.f7539d = parcel.readArrayList(CityInfo.class.getClassLoader());
        this.f7540e = parcel.readArrayList(CityInfo.class.getClassLoader());
        this.f7541f = parcel.readArrayList(CityInfo.class.getClassLoader());
    }
}
