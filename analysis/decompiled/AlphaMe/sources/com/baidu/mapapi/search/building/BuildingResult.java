package com.baidu.mapapi.search.building;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.search.core.BuildingInfo;
import com.baidu.mapapi.search.core.SearchResult;
import com.stepos.alphame.awareness.AwarenessDataItem;
import java.util.List;

/* loaded from: classes.dex */
public class BuildingResult extends SearchResult implements Parcelable {
    public static final Parcelable.Creator<BuildingResult> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private List<BuildingInfo> f7241a;

    /* renamed from: b, reason: collision with root package name */
    private int f7242b;

    /* renamed from: c, reason: collision with root package name */
    private double f7243c;

    public static class a implements Parcelable.Creator<BuildingResult> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public BuildingResult createFromParcel(Parcel parcel) {
            return new BuildingResult(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public BuildingResult[] newArray(int i4) {
            return new BuildingResult[i4];
        }
    }

    public BuildingResult() {
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<BuildingInfo> getBuildingList() {
        return this.f7241a;
    }

    public double getDistance() {
        return this.f7243c;
    }

    public int getRelation() {
        return this.f7242b;
    }

    public void setBuildingList(List<BuildingInfo> list) {
        this.f7241a = list;
    }

    public void setDistance(double d4) {
        this.f7243c = d4;
    }

    public void setRelation(int i4) {
        this.f7242b = i4;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("BuidingResult: ");
        List<BuildingInfo> list = this.f7241a;
        if (list == null || list.isEmpty()) {
            stringBuffer.append("null");
        } else {
            for (int i4 = 0; i4 < this.f7241a.size(); i4++) {
                stringBuffer.append(AwarenessDataItem.PERMISSION_SPLITTER);
                stringBuffer.append(i4);
                stringBuffer.append(AwarenessDataItem.PERMISSION_SPLITTER);
                BuildingInfo buildingInfo = this.f7241a.get(i4);
                if (buildingInfo == null) {
                    stringBuffer.append("null");
                } else {
                    stringBuffer.append(buildingInfo.toString());
                }
            }
        }
        return stringBuffer.toString();
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeTypedList(this.f7241a);
    }

    public BuildingResult(Parcel parcel) {
        this.f7241a = parcel.createTypedArrayList(BuildingInfo.CREATOR);
    }
}
