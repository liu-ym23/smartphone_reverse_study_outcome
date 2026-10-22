package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class WalkPath extends Path implements Parcelable {
    public static final Parcelable.Creator<WalkPath> CREATOR = new a();

    /* renamed from: d, reason: collision with root package name */
    private List<WalkStep> f17978d;

    public static class a implements Parcelable.Creator<WalkPath> {
        @Override // android.os.Parcelable.Creator
        public WalkPath createFromParcel(Parcel parcel) {
            return new WalkPath(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ WalkPath[] newArray(int i10) {
            return null;
        }
    }

    public WalkPath(Parcel parcel) {
        super(parcel);
        this.f17978d = new ArrayList();
        this.f17978d = parcel.createTypedArrayList(WalkStep.CREATOR);
    }

    @Override // com.amap.api.services.route.Path, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<WalkStep> getSteps() {
        return this.f17978d;
    }

    public void setSteps(List<WalkStep> list) {
        this.f17978d = list;
    }

    @Override // com.amap.api.services.route.Path, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        super.writeToParcel(parcel, i10);
        parcel.writeTypedList(this.f17978d);
    }

    public WalkPath() {
        this.f17978d = new ArrayList();
    }
}
