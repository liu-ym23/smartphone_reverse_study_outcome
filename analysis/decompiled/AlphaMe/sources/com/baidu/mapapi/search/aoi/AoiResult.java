package com.baidu.mapapi.search.aoi;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.search.core.AoiInfo;
import com.baidu.mapapi.search.core.SearchResult;
import com.stepos.alphame.awareness.AwarenessDataItem;
import java.util.List;

/* loaded from: classes.dex */
public class AoiResult extends SearchResult implements Parcelable {
    public static final Parcelable.Creator<AoiResult> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private List<AoiInfo> f7238a;

    public static class a implements Parcelable.Creator<AoiResult> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AoiResult createFromParcel(Parcel parcel) {
            return new AoiResult(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AoiResult[] newArray(int i4) {
            return new AoiResult[i4];
        }
    }

    public AoiResult() {
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<AoiInfo> getAoiList() {
        return this.f7238a;
    }

    public void setAoiList(List<AoiInfo> list) {
        this.f7238a = list;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("AoiResult: ");
        List<AoiInfo> list = this.f7238a;
        if (list == null || list.isEmpty()) {
            stringBuffer.append("null");
        } else {
            for (int i4 = 0; i4 < this.f7238a.size(); i4++) {
                stringBuffer.append(AwarenessDataItem.PERMISSION_SPLITTER);
                stringBuffer.append(i4);
                stringBuffer.append(AwarenessDataItem.PERMISSION_SPLITTER);
                AoiInfo aoiInfo = this.f7238a.get(i4);
                if (aoiInfo == null) {
                    stringBuffer.append("null");
                } else {
                    stringBuffer.append(aoiInfo.toString());
                }
            }
        }
        return stringBuffer.toString();
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeTypedList(this.f7238a);
    }

    public AoiResult(Parcel parcel) {
        this.f7238a = parcel.createTypedArrayList(AoiInfo.CREATOR);
    }
}
