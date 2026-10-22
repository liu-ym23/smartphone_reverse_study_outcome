package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class RidePath extends Path implements Parcelable {
    public static final Parcelable.Creator<RidePath> CREATOR = new a();

    /* renamed from: d, reason: collision with root package name */
    private List<RideStep> f17772d;

    public static class a implements Parcelable.Creator<RidePath> {
        @Override // android.os.Parcelable.Creator
        public RidePath createFromParcel(Parcel parcel) {
            return new RidePath(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ RidePath[] newArray(int i10) {
            return null;
        }
    }

    public RidePath(Parcel parcel) {
        super(parcel);
        this.f17772d = new ArrayList();
        this.f17772d = parcel.createTypedArrayList(RideStep.CREATOR);
    }

    @Override // com.amap.api.services.route.Path, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<RideStep> getSteps() {
        return this.f17772d;
    }

    public void setSteps(List<RideStep> list) {
        this.f17772d = list;
    }

    @Override // com.amap.api.services.route.Path, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        super.writeToParcel(parcel, i10);
        parcel.writeTypedList(this.f17772d);
    }

    public RidePath() {
        this.f17772d = new ArrayList();
    }
}
