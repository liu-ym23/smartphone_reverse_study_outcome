package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class Path implements Parcelable {
    public static final Parcelable.Creator<Path> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private float f17757a;

    /* renamed from: b, reason: collision with root package name */
    private long f17758b;

    /* renamed from: c, reason: collision with root package name */
    private List<LatLonPoint> f17759c;

    public static class a implements Parcelable.Creator<Path> {
        @Override // android.os.Parcelable.Creator
        public Path createFromParcel(Parcel parcel) {
            return new Path(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ Path[] newArray(int i10) {
            return null;
        }
    }

    public Path(Parcel parcel) {
        this.f17759c = new ArrayList();
        this.f17757a = parcel.readFloat();
        this.f17758b = parcel.readLong();
        this.f17759c = parcel.createTypedArrayList(LatLonPoint.CREATOR);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public float getDistance() {
        return this.f17757a;
    }

    public long getDuration() {
        return this.f17758b;
    }

    public List<LatLonPoint> getPolyline() {
        return this.f17759c;
    }

    public void setDistance(float f10) {
        this.f17757a = f10;
    }

    public void setDuration(long j10) {
        this.f17758b = j10;
    }

    public void setPolyline(List<LatLonPoint> list) {
        this.f17759c = list;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeFloat(this.f17757a);
        parcel.writeLong(this.f17758b);
        parcel.writeTypedList(this.f17759c);
    }

    public Path() {
        this.f17759c = new ArrayList();
    }
}
