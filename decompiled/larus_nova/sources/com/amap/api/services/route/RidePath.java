package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes28.dex */
public class RidePath extends Path {
    public static final Parcelable.Creator<RidePath> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<RideStep> f29123a;

    @Override // com.amap.api.services.route.Path, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    public RidePath() {
        this.f29123a = new ArrayList();
    }

    public List<RideStep> getSteps() {
        return this.f29123a;
    }

    public RidePath(Parcel r100) {
        super(r100);
        this.f29123a = new ArrayList();
        this.f29123a = r100.createTypedArrayList(RideStep.CREATOR);
    }

    public void setSteps(List<RideStep> r100) {
        this.f29123a = r100;
    }

    @Override // com.amap.api.services.route.Path, android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        super.writeToParcel(r100, r101);
        r100.writeTypedList(this.f29123a);
    }
}
