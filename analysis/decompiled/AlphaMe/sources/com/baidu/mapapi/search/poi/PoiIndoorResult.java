package com.baidu.mapapi.search.poi;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.search.core.SearchResult;
import java.util.List;

/* loaded from: classes.dex */
public class PoiIndoorResult extends SearchResult implements Parcelable {
    public static final Parcelable.Creator<PoiIndoorResult> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private List<PoiIndoorInfo> f7420a;
    public int pageNum;
    public int poiNum;

    public static class a implements Parcelable.Creator<PoiIndoorResult> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PoiIndoorResult createFromParcel(Parcel parcel) {
            return new PoiIndoorResult(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PoiIndoorResult[] newArray(int i4) {
            return new PoiIndoorResult[i4];
        }
    }

    public PoiIndoorResult() {
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<PoiIndoorInfo> getArrayPoiInfo() {
        return this.f7420a;
    }

    public int getPageNum() {
        return this.pageNum;
    }

    public int getPoiNum() {
        return this.poiNum;
    }

    @Deprecated
    public List<PoiIndoorInfo> getmArrayPoiInfo() {
        return this.f7420a;
    }

    public void setArrayPoiInfo(List<PoiIndoorInfo> list) {
        this.f7420a = list;
    }

    public void setPageNum(int i4) {
        this.pageNum = i4;
    }

    public void setPoiNum(int i4) {
        this.poiNum = i4;
    }

    @Deprecated
    public void setmArrayPoiInfo(List<PoiIndoorInfo> list) {
        this.f7420a = list;
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeInt(this.poiNum);
        parcel.writeInt(this.pageNum);
    }

    public PoiIndoorResult(SearchResult.ERRORNO errorno) {
        super(errorno);
    }

    public PoiIndoorResult(Parcel parcel) {
        super(parcel);
        this.poiNum = parcel.readInt();
        this.pageNum = parcel.readInt();
    }
}
