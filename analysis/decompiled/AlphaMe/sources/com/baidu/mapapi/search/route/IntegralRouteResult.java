package com.baidu.mapapi.search.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.search.core.SearchResult;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class IntegralRouteResult extends SearchResult implements Parcelable {
    public static final Parcelable.Creator<IntegralRouteResult> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private List<WalkingRouteLine> f7495a;

    /* renamed from: b, reason: collision with root package name */
    private List<IndoorRouteLine> f7496b;

    public static class a implements Parcelable.Creator<IntegralRouteResult> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public IntegralRouteResult createFromParcel(Parcel parcel) {
            return new IntegralRouteResult(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public IntegralRouteResult[] newArray(int i4) {
            return new IntegralRouteResult[i4];
        }
    }

    public IntegralRouteResult() {
    }

    public List<IndoorRouteLine> getIndoorRouteLines() {
        return this.f7496b;
    }

    public List<WalkingRouteLine> getRouteLines() {
        return this.f7495a;
    }

    public void setIndoorRouteLines(List<IndoorRouteLine> list) {
        this.f7496b = list;
    }

    public void setRouteLines(List<WalkingRouteLine> list) {
        this.f7495a = list;
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeList(this.f7495a);
        parcel.writeTypedList(this.f7496b);
    }

    public IntegralRouteResult(Parcel parcel) {
        super(parcel);
        ArrayList arrayList = new ArrayList();
        this.f7495a = arrayList;
        parcel.readList(arrayList, WalkingRouteLine.class.getClassLoader());
        ArrayList arrayList2 = new ArrayList();
        this.f7496b = arrayList2;
        parcel.readList(arrayList2, IndoorRouteLine.class.getClassLoader());
    }
}
