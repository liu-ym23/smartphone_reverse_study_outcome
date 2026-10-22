package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes28.dex */
public class DrivePlanPath implements Parcelable {
    public static final Parcelable.Creator<DrivePlanPath> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    float f29081a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f29082b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private List<DrivePlanStep> f29083c;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    public float getTrafficLights() {
        return this.f29082b;
    }

    public DrivePlanPath() {
        this.f29083c = new ArrayList();
    }

    public float getDistance() {
        return this.f29081a;
    }

    public List<DrivePlanStep> getSteps() {
        return this.f29083c;
    }

    public DrivePlanPath(Parcel r100) {
        this.f29083c = new ArrayList();
        this.f29081a = r100.readFloat();
        this.f29082b = r100.readInt();
        this.f29083c = r100.createTypedArrayList(DrivePlanStep.CREATOR);
    }

    public void setDistance(float r100) {
        this.f29081a = r100;
    }

    public void setSteps(List<DrivePlanStep> r100) {
        this.f29083c = r100;
    }

    public void setTrafficLights(int r100) {
        this.f29082b = r100;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeFloat(this.f29081a);
        r100.writeInt(this.f29082b);
        r100.writeTypedList(this.f29083c);
    }
}
