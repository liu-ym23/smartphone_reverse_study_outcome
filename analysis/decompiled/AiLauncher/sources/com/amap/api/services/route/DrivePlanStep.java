package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class DrivePlanStep implements Parcelable {
    public static final Parcelable.Creator<DrivePlanStep> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private String f17714a;

    /* renamed from: b, reason: collision with root package name */
    private String f17715b;

    /* renamed from: c, reason: collision with root package name */
    private float f17716c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f17717d;

    /* renamed from: e, reason: collision with root package name */
    private List<LatLonPoint> f17718e;

    public static class a implements Parcelable.Creator<DrivePlanStep> {
        @Override // android.os.Parcelable.Creator
        public DrivePlanStep createFromParcel(Parcel parcel) {
            return new DrivePlanStep(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ DrivePlanStep[] newArray(int i10) {
            return null;
        }
    }

    public DrivePlanStep(Parcel parcel) {
        this.f17718e = new ArrayList();
        this.f17714a = parcel.readString();
        this.f17715b = parcel.readString();
        this.f17716c = parcel.readFloat();
        this.f17717d = parcel.readInt() == 1;
        this.f17716c = parcel.readFloat();
        this.f17718e = parcel.createTypedArrayList(LatLonPoint.CREATOR);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAdCode() {
        return this.f17715b;
    }

    public float getDistance() {
        return this.f17716c;
    }

    public List<LatLonPoint> getPolyline() {
        return this.f17718e;
    }

    public String getRoad() {
        return this.f17714a;
    }

    public boolean getToll() {
        return this.f17717d;
    }

    public void setAdCode(String str) {
        this.f17715b = str;
    }

    public void setDistance(float f10) {
        this.f17716c = f10;
    }

    public void setPolyline(List<LatLonPoint> list) {
        this.f17718e = list;
    }

    public void setRoad(String str) {
        this.f17714a = str;
    }

    public void setToll(boolean z10) {
        this.f17717d = z10;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f17714a);
        parcel.writeString(this.f17715b);
        parcel.writeFloat(this.f17716c);
        parcel.writeInt(this.f17717d ? 1 : 0);
        parcel.writeFloat(this.f17716c);
        parcel.writeTypedList(this.f17718e);
    }

    public DrivePlanStep() {
        this.f17718e = new ArrayList();
    }
}
