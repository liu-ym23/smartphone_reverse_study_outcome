package com.baidu.mapapi.search.poi;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.search.core.PoiDetailInfo;
import com.baidu.mapapi.search.core.SearchResult;
import com.stepos.alphame.awareness.AwarenessDataItem;
import java.util.List;

/* loaded from: classes.dex */
public class PoiDetailSearchResult extends SearchResult implements Parcelable {
    public static final Parcelable.Creator<PoiDetailSearchResult> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private List<PoiDetailInfo> f7403a;

    public static class a implements Parcelable.Creator<PoiDetailSearchResult> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PoiDetailSearchResult createFromParcel(Parcel parcel) {
            return new PoiDetailSearchResult(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PoiDetailSearchResult[] newArray(int i4) {
            return new PoiDetailSearchResult[i4];
        }
    }

    public PoiDetailSearchResult() {
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<PoiDetailInfo> getPoiDetailInfoList() {
        return this.f7403a;
    }

    public void setPoiDetailInfoList(List<PoiDetailInfo> list) {
        this.f7403a = list;
    }

    public String toString() {
        List<PoiDetailInfo> list = this.f7403a;
        if (list == null || list.isEmpty()) {
            return "PoiDetailSearchResult is null";
        }
        StringBuffer stringBuffer = new StringBuffer("PoiDetailSearchResult:");
        for (int i4 = 0; i4 < this.f7403a.size(); i4++) {
            stringBuffer.append(AwarenessDataItem.PERMISSION_SPLITTER);
            stringBuffer.append(i4);
            stringBuffer.append(AwarenessDataItem.PERMISSION_SPLITTER);
            PoiDetailInfo poiDetailInfo = this.f7403a.get(i4);
            if (poiDetailInfo != null) {
                stringBuffer.append(poiDetailInfo.toString());
            } else {
                stringBuffer.append("null");
            }
        }
        return stringBuffer.toString();
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeTypedList(this.f7403a);
    }

    public PoiDetailSearchResult(SearchResult.ERRORNO errorno) {
        super(errorno);
    }

    public PoiDetailSearchResult(Parcel parcel) {
        super(parcel);
        this.f7403a = parcel.createTypedArrayList(PoiDetailInfo.CREATOR);
    }
}
