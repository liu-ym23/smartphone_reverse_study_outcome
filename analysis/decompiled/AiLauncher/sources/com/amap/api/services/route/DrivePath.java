package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class DrivePath extends Path implements Parcelable {
    public static final Parcelable.Creator<DrivePath> CREATOR = new a();

    /* renamed from: d, reason: collision with root package name */
    private String f17699d;

    /* renamed from: e, reason: collision with root package name */
    private float f17700e;

    /* renamed from: f, reason: collision with root package name */
    private float f17701f;

    /* renamed from: g, reason: collision with root package name */
    private int f17702g;

    /* renamed from: h, reason: collision with root package name */
    private List<DriveStep> f17703h;

    /* renamed from: i, reason: collision with root package name */
    private int f17704i;

    public static class a implements Parcelable.Creator<DrivePath> {
        @Override // android.os.Parcelable.Creator
        public DrivePath createFromParcel(Parcel parcel) {
            return new DrivePath(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ DrivePath[] newArray(int i10) {
            return null;
        }
    }

    public DrivePath(Parcel parcel) {
        super(parcel);
        this.f17703h = new ArrayList();
        this.f17699d = parcel.readString();
        this.f17700e = parcel.readFloat();
        this.f17701f = parcel.readFloat();
        this.f17703h = parcel.createTypedArrayList(DriveStep.CREATOR);
        this.f17702g = parcel.readInt();
    }

    @Override // com.amap.api.services.route.Path, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getRestriction() {
        return this.f17704i;
    }

    public List<DriveStep> getSteps() {
        return this.f17703h;
    }

    public String getStrategy() {
        return this.f17699d;
    }

    public float getTollDistance() {
        return this.f17701f;
    }

    public float getTolls() {
        return this.f17700e;
    }

    public int getTotalTrafficlights() {
        return this.f17702g;
    }

    public void setRestriction(int i10) {
        this.f17704i = i10;
    }

    public void setSteps(List<DriveStep> list) {
        this.f17703h = list;
    }

    public void setStrategy(String str) {
        this.f17699d = str;
    }

    public void setTollDistance(float f10) {
        this.f17701f = f10;
    }

    public void setTolls(float f10) {
        this.f17700e = f10;
    }

    public void setTotalTrafficlights(int i10) {
        this.f17702g = i10;
    }

    @Override // com.amap.api.services.route.Path, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        super.writeToParcel(parcel, i10);
        parcel.writeString(this.f17699d);
        parcel.writeFloat(this.f17700e);
        parcel.writeFloat(this.f17701f);
        parcel.writeTypedList(this.f17703h);
        parcel.writeInt(this.f17702g);
    }

    public DrivePath() {
        this.f17703h = new ArrayList();
    }
}
