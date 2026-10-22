package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes28.dex */
public class Path implements Parcelable {
    public static final Parcelable.Creator<Path> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f29108a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f29109b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private List<LatLonPoint> f29110c;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    public Path() {
        this.f29110c = new ArrayList();
    }

    public float getDistance() {
        return this.f29108a;
    }

    public long getDuration() {
        return this.f29109b;
    }

    public List<LatLonPoint> getPolyline() {
        return this.f29110c;
    }

    public Path(Parcel r100) {
        this.f29110c = new ArrayList();
        this.f29108a = r100.readFloat();
        this.f29109b = r100.readLong();
        this.f29110c = r100.createTypedArrayList(LatLonPoint.CREATOR);
    }

    public void setDistance(float r100) {
        this.f29108a = r100;
    }

    public void setDuration(long r100) {
        this.f29109b = r100;
    }

    public void setPolyline(List<LatLonPoint> r100) {
        this.f29110c = r100;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeFloat(this.f29108a);
        r100.writeLong(this.f29109b);
        r100.writeTypedList(this.f29110c);
    }
}
