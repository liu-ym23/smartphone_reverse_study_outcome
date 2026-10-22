package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes28.dex */
public class BusPath extends Path {
    public static final Parcelable.Creator<BusPath> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f29043a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f29044b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float f29045c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f29046d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private List<BusStep> f29047e;

    @Override // com.amap.api.services.route.Path, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    public BusPath() {
        this.f29047e = new ArrayList();
    }

    public float getBusDistance() {
        return this.f29046d;
    }

    public float getCost() {
        return this.f29043a;
    }

    public List<BusStep> getSteps() {
        return this.f29047e;
    }

    public float getWalkDistance() {
        return this.f29045c;
    }

    public boolean isNightBus() {
        return this.f29044b;
    }

    public BusPath(Parcel r100) {
        super(r100);
        this.f29047e = new ArrayList();
        this.f29043a = r100.readFloat();
        boolean[] r101 = new boolean[1];
        r100.readBooleanArray(r101);
        this.f29044b = r101[0];
        this.f29045c = r100.readFloat();
        this.f29046d = r100.readFloat();
        this.f29047e = r100.createTypedArrayList(BusStep.CREATOR);
    }

    public void setBusDistance(float r100) {
        this.f29046d = r100;
    }

    public void setCost(float r100) {
        this.f29043a = r100;
    }

    public void setNightBus(boolean r100) {
        this.f29044b = r100;
    }

    public void setSteps(List<BusStep> r100) {
        this.f29047e = r100;
    }

    public void setWalkDistance(float r100) {
        this.f29045c = r100;
    }

    @Override // com.amap.api.services.route.Path, android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        super.writeToParcel(r100, r101);
        r100.writeFloat(this.f29043a);
        r100.writeBooleanArray(new boolean[]{this.f29044b});
        r100.writeFloat(this.f29045c);
        r100.writeFloat(this.f29046d);
        r100.writeTypedList(this.f29047e);
    }
}
