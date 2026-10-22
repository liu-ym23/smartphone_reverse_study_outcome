package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes28.dex */
public class TMC implements Parcelable {
    public static final Parcelable.Creator<TMC> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f29206a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f29207b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private List<LatLonPoint> f29208c;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    public TMC() {
        this.f29208c = new ArrayList();
    }

    public int getDistance() {
        return this.f29206a;
    }

    public List<LatLonPoint> getPolyline() {
        return this.f29208c;
    }

    public String getStatus() {
        return this.f29207b;
    }

    public TMC(Parcel r100) {
        this.f29208c = new ArrayList();
        this.f29206a = r100.readInt();
        this.f29207b = r100.readString();
        this.f29208c = r100.createTypedArrayList(LatLonPoint.CREATOR);
    }

    public void setDistance(int r100) {
        this.f29206a = r100;
    }

    public void setPolyline(List<LatLonPoint> r100) {
        this.f29208c = r100;
    }

    public void setStatus(String r100) {
        this.f29207b = r100;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeInt(this.f29206a);
        r100.writeString(this.f29207b);
        r100.writeTypedList(this.f29208c);
    }
}
