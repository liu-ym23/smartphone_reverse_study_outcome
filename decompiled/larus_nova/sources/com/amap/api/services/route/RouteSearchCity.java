package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes28.dex */
public class RouteSearchCity extends SearchCity {
    public static final Parcelable.Creator<RouteSearchCity> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    List<District> f29202a;

    @Override // com.amap.api.services.route.SearchCity, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    public RouteSearchCity() {
        this.f29202a = new ArrayList();
    }

    public List<District> getDistricts() {
        return this.f29202a;
    }

    public RouteSearchCity(Parcel r100) {
        super(r100);
        this.f29202a = new ArrayList();
        this.f29202a = r100.createTypedArrayList(District.CREATOR);
    }

    public void setDistricts(List<District> r100) {
        this.f29202a = r100;
    }

    @Override // com.amap.api.services.route.SearchCity, android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        super.writeToParcel(r100, r101);
        r100.writeTypedList(this.f29202a);
    }
}
