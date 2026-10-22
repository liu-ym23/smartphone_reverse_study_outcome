package com.baidu.mapapi.search.recommendstop;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.search.core.RecommendStationStopInfo;
import com.baidu.mapapi.search.core.RecommendStopInfo;
import com.baidu.mapapi.search.core.SearchResult;
import com.stepos.alphame.awareness.AwarenessDataItem;
import java.util.List;

/* loaded from: classes.dex */
public class RecommendStopResult extends SearchResult implements Parcelable {
    public static final Parcelable.Creator<RecommendStopResult> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private List<RecommendStopInfo> f7437a;

    /* renamed from: b, reason: collision with root package name */
    private List<RecommendStationStopInfo> f7438b;

    public static class a implements Parcelable.Creator<RecommendStopResult> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public RecommendStopResult createFromParcel(Parcel parcel) {
            return new RecommendStopResult(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public RecommendStopResult[] newArray(int i4) {
            return new RecommendStopResult[i4];
        }
    }

    public RecommendStopResult() {
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<RecommendStopInfo> getRecommendStopInfoList() {
        return this.f7437a;
    }

    public List<RecommendStationStopInfo> getStationInfoList() {
        return this.f7438b;
    }

    public void setRecommendStopInfoList(List<RecommendStopInfo> list) {
        this.f7437a = list;
    }

    public void setStationInfoList(List<RecommendStationStopInfo> list) {
        this.f7438b = list;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("RecommendStopResult: ");
        List<RecommendStopInfo> list = this.f7437a;
        if (list == null || list.isEmpty()) {
            stringBuffer.append("null");
        } else {
            for (int i4 = 0; i4 < this.f7437a.size(); i4++) {
                stringBuffer.append(AwarenessDataItem.PERMISSION_SPLITTER);
                stringBuffer.append(i4);
                stringBuffer.append(AwarenessDataItem.PERMISSION_SPLITTER);
                RecommendStopInfo recommendStopInfo = this.f7437a.get(i4);
                if (recommendStopInfo == null) {
                    stringBuffer.append("null");
                } else {
                    stringBuffer.append(recommendStopInfo.toString());
                }
            }
        }
        return stringBuffer.toString();
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeTypedList(this.f7437a);
    }

    public RecommendStopResult(Parcel parcel) {
        super(parcel);
        this.f7437a = parcel.createTypedArrayList(RecommendStopInfo.CREATOR);
    }
}
