package com.baidu.mapapi.search.poi;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.search.core.CityInfo;
import com.baidu.mapapi.search.core.PoiInfo;
import com.baidu.mapapi.search.core.SearchResult;
import java.util.List;

/* loaded from: classes.dex */
public class PoiResult extends SearchResult implements Parcelable {
    public static final Parcelable.Creator<PoiResult> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private int f7424a;

    /* renamed from: b, reason: collision with root package name */
    private int f7425b;

    /* renamed from: c, reason: collision with root package name */
    private int f7426c;

    /* renamed from: d, reason: collision with root package name */
    private int f7427d;

    /* renamed from: e, reason: collision with root package name */
    private List<PoiInfo> f7428e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f7429f;

    /* renamed from: g, reason: collision with root package name */
    private List<PoiAddrInfo> f7430g;

    /* renamed from: h, reason: collision with root package name */
    private List<CityInfo> f7431h;

    /* renamed from: i, reason: collision with root package name */
    private String f7432i;

    /* renamed from: j, reason: collision with root package name */
    private String f7433j;

    public static class a implements Parcelable.Creator<PoiResult> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PoiResult createFromParcel(Parcel parcel) {
            return new PoiResult(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PoiResult[] newArray(int i4) {
            return new PoiResult[i4];
        }
    }

    public PoiResult() {
        this.f7424a = 0;
        this.f7425b = 0;
        this.f7426c = 0;
        this.f7427d = 0;
        this.f7429f = false;
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<PoiAddrInfo> getAllAddr() {
        return this.f7430g;
    }

    public List<PoiInfo> getAllPoi() {
        return this.f7428e;
    }

    public int getCurrentPageCapacity() {
        return this.f7426c;
    }

    public int getCurrentPageNum() {
        return this.f7424a;
    }

    public String getQueryType() {
        return this.f7433j;
    }

    public String getResultType() {
        return this.f7432i;
    }

    @Deprecated
    public List<CityInfo> getSuggestCityList() {
        return this.f7431h;
    }

    public int getTotalPageNum() {
        return this.f7425b;
    }

    public int getTotalPoiNum() {
        return this.f7427d;
    }

    public boolean isHasAddrInfo() {
        return this.f7429f;
    }

    public void setAddrInfo(List<PoiAddrInfo> list) {
        this.f7430g = list;
    }

    public void setCurrentPageCapacity(int i4) {
        this.f7426c = i4;
    }

    public void setCurrentPageNum(int i4) {
        this.f7424a = i4;
    }

    public void setHasAddrInfo(boolean z4) {
        this.f7429f = z4;
    }

    public void setPoiInfo(List<PoiInfo> list) {
        this.f7428e = list;
    }

    public void setQueryType(String str) {
        this.f7433j = str;
    }

    public void setResultType(String str) {
        this.f7432i = str;
    }

    @Deprecated
    public void setSuggestCityList(List<CityInfo> list) {
        this.f7431h = list;
    }

    public void setTotalPageNum(int i4) {
        this.f7425b = i4;
    }

    public void setTotalPoiNum(int i4) {
        this.f7427d = i4;
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeInt(this.f7424a);
        parcel.writeInt(this.f7425b);
        parcel.writeInt(this.f7426c);
        parcel.writeInt(this.f7427d);
        parcel.writeTypedList(this.f7428e);
        parcel.writeByte(this.f7429f ? (byte) 1 : (byte) 0);
        parcel.writeTypedList(this.f7431h);
        parcel.writeString(this.f7433j);
    }

    public PoiResult(SearchResult.ERRORNO errorno) {
        super(errorno);
        this.f7424a = 0;
        this.f7425b = 0;
        this.f7426c = 0;
        this.f7427d = 0;
        this.f7429f = false;
    }

    public PoiResult(Parcel parcel) {
        super(parcel);
        this.f7424a = 0;
        this.f7425b = 0;
        this.f7426c = 0;
        this.f7427d = 0;
        this.f7429f = false;
        this.f7424a = parcel.readInt();
        this.f7425b = parcel.readInt();
        this.f7426c = parcel.readInt();
        this.f7427d = parcel.readInt();
        this.f7428e = parcel.createTypedArrayList(PoiInfo.CREATOR);
        this.f7429f = parcel.readByte() != 0;
        this.f7431h = parcel.createTypedArrayList(CityInfo.CREATOR);
        this.f7433j = parcel.readString();
    }
}
