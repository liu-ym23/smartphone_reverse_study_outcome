package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes28.dex */
public class DrivePath extends Path {
    public static final Parcelable.Creator<DrivePath> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f29075a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f29076b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float f29077c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f29078d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private List<DriveStep> f29079e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f29080f;

    @Override // com.amap.api.services.route.Path, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    public DrivePath() {
        this.f29079e = new ArrayList();
    }

    public int getRestriction() {
        return this.f29080f;
    }

    public List<DriveStep> getSteps() {
        return this.f29079e;
    }

    public String getStrategy() {
        return this.f29075a;
    }

    public float getTollDistance() {
        return this.f29077c;
    }

    public float getTolls() {
        return this.f29076b;
    }

    public int getTotalTrafficlights() {
        return this.f29078d;
    }

    public DrivePath(Parcel r100) {
        super(r100);
        this.f29079e = new ArrayList();
        this.f29075a = r100.readString();
        this.f29076b = r100.readFloat();
        this.f29077c = r100.readFloat();
        this.f29079e = r100.createTypedArrayList(DriveStep.CREATOR);
        this.f29078d = r100.readInt();
    }

    public void setRestriction(int r100) {
        this.f29080f = r100;
    }

    public void setSteps(List<DriveStep> r100) {
        this.f29079e = r100;
    }

    public void setStrategy(String r100) {
        this.f29075a = r100;
    }

    public void setTollDistance(float r100) {
        this.f29077c = r100;
    }

    public void setTolls(float r100) {
        this.f29076b = r100;
    }

    public void setTotalTrafficlights(int r100) {
        this.f29078d = r100;
    }

    @Override // com.amap.api.services.route.Path, android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        super.writeToParcel(r100, r101);
        r100.writeString(this.f29075a);
        r100.writeFloat(this.f29076b);
        r100.writeFloat(this.f29077c);
        r100.writeTypedList(this.f29079e);
        r100.writeInt(this.f29078d);
    }
}
