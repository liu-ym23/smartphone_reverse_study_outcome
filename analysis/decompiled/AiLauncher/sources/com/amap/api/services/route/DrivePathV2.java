package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class DrivePathV2 extends Path implements Parcelable {
    public static final Parcelable.Creator<DrivePathV2> CREATOR = new a();

    /* renamed from: d, reason: collision with root package name */
    private String f17705d;

    /* renamed from: e, reason: collision with root package name */
    private List<DriveStepV2> f17706e;

    /* renamed from: f, reason: collision with root package name */
    private int f17707f;

    /* renamed from: g, reason: collision with root package name */
    private Cost f17708g;

    /* renamed from: h, reason: collision with root package name */
    private ElecConsumeInfo f17709h;

    /* renamed from: i, reason: collision with root package name */
    private List<ChargeStationInfo> f17710i;

    public static class a implements Parcelable.Creator<DrivePathV2> {
        @Override // android.os.Parcelable.Creator
        public DrivePathV2 createFromParcel(Parcel parcel) {
            return new DrivePathV2(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ DrivePathV2[] newArray(int i10) {
            return null;
        }
    }

    public DrivePathV2(Parcel parcel) {
        super(parcel);
        this.f17706e = new ArrayList();
        this.f17710i = new ArrayList();
        this.f17705d = parcel.readString();
        this.f17706e = parcel.createTypedArrayList(DriveStepV2.CREATOR);
    }

    @Override // com.amap.api.services.route.Path, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<ChargeStationInfo> getChargeStationInfo() {
        return this.f17710i;
    }

    public Cost getCost() {
        return this.f17708g;
    }

    public ElecConsumeInfo getElecConsumeInfo() {
        return this.f17709h;
    }

    public int getRestriction() {
        return this.f17707f;
    }

    public List<DriveStepV2> getSteps() {
        return this.f17706e;
    }

    public String getStrategy() {
        return this.f17705d;
    }

    public void setChargeStationInfo(List<ChargeStationInfo> list) {
        this.f17710i = list;
    }

    public void setCost(Cost cost) {
        this.f17708g = cost;
    }

    public void setElecConsumeInfo(ElecConsumeInfo elecConsumeInfo) {
        this.f17709h = elecConsumeInfo;
    }

    public void setRestriction(int i10) {
        this.f17707f = i10;
    }

    public void setSteps(List<DriveStepV2> list) {
        this.f17706e = list;
    }

    public void setStrategy(String str) {
        this.f17705d = str;
    }

    @Override // com.amap.api.services.route.Path, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        super.writeToParcel(parcel, i10);
        parcel.writeTypedList(this.f17706e);
    }

    public DrivePathV2() {
        this.f17706e = new ArrayList();
        this.f17710i = new ArrayList();
    }
}
