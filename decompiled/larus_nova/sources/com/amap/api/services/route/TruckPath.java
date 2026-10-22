package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* JADX INFO: loaded from: classes28.dex */
public class TruckPath implements Parcelable {
    public static final Parcelable.Creator<TruckPath> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f29222a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f29223b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f29224c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f29225d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f29226e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f29227f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f29228g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private List<TruckStep> f29229h;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    public TruckPath() {
    }

    public float getDistance() {
        return this.f29222a;
    }

    public long getDuration() {
        return this.f29223b;
    }

    public int getRestriction() {
        return this.f29228g;
    }

    public List<TruckStep> getSteps() {
        return this.f29229h;
    }

    public String getStrategy() {
        return this.f29224c;
    }

    public float getTollDistance() {
        return this.f29226e;
    }

    public float getTolls() {
        return this.f29225d;
    }

    public int getTotalTrafficlights() {
        return this.f29227f;
    }

    public TruckPath(Parcel r100) {
        this.f29222a = r100.readFloat();
        this.f29223b = r100.readLong();
        this.f29224c = r100.readString();
        this.f29225d = r100.readFloat();
        this.f29226e = r100.readFloat();
        this.f29227f = r100.readInt();
        this.f29228g = r100.readInt();
        this.f29229h = r100.createTypedArrayList(TruckStep.CREATOR);
    }

    public void setDistance(float r100) {
        this.f29222a = r100;
    }

    public void setDuration(long r100) {
        this.f29223b = r100;
    }

    public void setRestriction(int r100) {
        this.f29228g = r100;
    }

    public void setSteps(List<TruckStep> r100) {
        this.f29229h = r100;
    }

    public void setStrategy(String r100) {
        this.f29224c = r100;
    }

    public void setTollDistance(float r100) {
        this.f29226e = r100;
    }

    public void setTolls(float r100) {
        this.f29225d = r100;
    }

    public void setTotalTrafficlights(int r100) {
        this.f29227f = r100;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeFloat(this.f29222a);
        r100.writeLong(this.f29223b);
        r100.writeString(this.f29224c);
        r100.writeFloat(this.f29225d);
        r100.writeFloat(this.f29226e);
        r100.writeInt(this.f29227f);
        r100.writeInt(this.f29228g);
        r100.writeTypedList(this.f29229h);
    }
}
