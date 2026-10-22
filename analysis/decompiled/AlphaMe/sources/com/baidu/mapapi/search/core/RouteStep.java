package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.model.LatLng;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class RouteStep implements Parcelable {
    public static final Parcelable.Creator<RouteStep> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    int f7328a;

    /* renamed from: b, reason: collision with root package name */
    int f7329b;

    /* renamed from: c, reason: collision with root package name */
    String f7330c;

    /* renamed from: d, reason: collision with root package name */
    int f7331d;
    protected List<LatLng> mWayPoints;

    public static class a implements Parcelable.Creator<RouteStep> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public RouteStep createFromParcel(Parcel parcel) {
            return new RouteStep(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public RouteStep[] newArray(int i4) {
            return new RouteStep[i4];
        }
    }

    public RouteStep() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getDistance() {
        return this.f7328a;
    }

    public int getDuration() {
        return this.f7329b;
    }

    public String getName() {
        return this.f7330c;
    }

    public int getTransType() {
        return this.f7331d;
    }

    public List<LatLng> getWayPoints() {
        return this.mWayPoints;
    }

    public void setDistance(int i4) {
        this.f7328a = i4;
    }

    public void setDuration(int i4) {
        this.f7329b = i4;
    }

    public void setName(String str) {
        this.f7330c = str;
    }

    public void setTransType(int i4) {
        this.f7331d = i4;
    }

    public void setWayPoints(List<LatLng> list) {
        this.mWayPoints = list;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeInt(this.f7328a);
        parcel.writeInt(this.f7329b);
        parcel.writeInt(this.f7331d);
        parcel.writeString(this.f7330c);
        parcel.writeList(this.mWayPoints);
    }

    public RouteStep(Parcel parcel) {
        this.f7328a = parcel.readInt();
        this.f7329b = parcel.readInt();
        this.f7331d = parcel.readInt();
        this.f7330c = parcel.readString();
        ArrayList arrayList = new ArrayList();
        this.mWayPoints = arrayList;
        parcel.readList(arrayList, LatLng.class.getClassLoader());
        if (this.mWayPoints.size() == 0) {
            this.mWayPoints = null;
        }
    }
}
