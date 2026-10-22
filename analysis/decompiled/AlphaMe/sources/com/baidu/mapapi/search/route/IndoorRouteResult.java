package com.baidu.mapapi.search.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.search.core.SearchResult;
import java.util.List;

/* loaded from: classes.dex */
public class IndoorRouteResult extends SearchResult {
    public static final Parcelable.Creator<IndoorRouteResult> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private List<IndoorRouteLine> f7494a;

    public static class a implements Parcelable.Creator<IndoorRouteResult> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public IndoorRouteResult createFromParcel(Parcel parcel) {
            return new IndoorRouteResult(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public IndoorRouteResult[] newArray(int i4) {
            return new IndoorRouteResult[i4];
        }
    }

    public IndoorRouteResult() {
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<IndoorRouteLine> getRouteLines() {
        return this.f7494a;
    }

    public void setRouteLines(List<IndoorRouteLine> list) {
        this.f7494a = list;
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeTypedList(this.f7494a);
    }

    public IndoorRouteResult(Parcel parcel) {
        super(parcel);
        this.f7494a = parcel.createTypedArrayList(IndoorRouteLine.CREATOR);
    }
}
