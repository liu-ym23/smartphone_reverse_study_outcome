package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes28.dex */
public class DrivePlanStep implements Parcelable {
    public static final Parcelable.Creator<DrivePlanStep> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f29084a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f29085b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float f29086c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f29087d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private List<LatLonPoint> f29088e;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    public DrivePlanStep() {
        this.f29088e = new ArrayList();
    }

    public String getAdCode() {
        return this.f29085b;
    }

    public float getDistance() {
        return this.f29086c;
    }

    public List<LatLonPoint> getPolyline() {
        return this.f29088e;
    }

    public String getRoad() {
        return this.f29084a;
    }

    public boolean getToll() {
        return this.f29087d;
    }

    public DrivePlanStep(Parcel r100) {
        this.f29088e = new ArrayList();
        this.f29084a = r100.readString();
        this.f29085b = r100.readString();
        this.f29086c = r100.readFloat();
        boolean r101 = true;
        if (r100.readInt() == 1) goto L6;
        r101 = false;
    L6:
        this.f29087d = r101;
        this.f29086c = r100.readFloat();
        this.f29088e = r100.createTypedArrayList(LatLonPoint.CREATOR);
    }

    public void setAdCode(String r100) {
        this.f29085b = r100;
    }

    public void setDistance(float r100) {
        this.f29086c = r100;
    }

    public void setPolyline(List<LatLonPoint> r100) {
        this.f29088e = r100;
    }

    public void setRoad(String r100) {
        this.f29084a = r100;
    }

    public void setToll(boolean r100) {
        this.f29087d = r100;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeString(this.f29084a);
        r100.writeString(this.f29085b);
        r100.writeFloat(this.f29086c);
        r100.writeInt(this.f29087d ? 1 : 0);
        r100.writeFloat(this.f29086c);
        r100.writeTypedList(this.f29088e);
    }
}
