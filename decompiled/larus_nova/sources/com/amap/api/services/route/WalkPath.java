package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes28.dex */
public class WalkPath extends Path {
    public static final Parcelable.Creator<WalkPath> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<WalkStep> f29247a;

    @Override // com.amap.api.services.route.Path, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    public WalkPath() {
        this.f29247a = new ArrayList();
    }

    public List<WalkStep> getSteps() {
        return this.f29247a;
    }

    public WalkPath(Parcel r100) {
        super(r100);
        this.f29247a = new ArrayList();
        this.f29247a = r100.createTypedArrayList(WalkStep.CREATOR);
    }

    public void setSteps(List<WalkStep> r100) {
        this.f29247a = r100;
    }

    @Override // com.amap.api.services.route.Path, android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        super.writeToParcel(r100, r101);
        r100.writeTypedList(this.f29247a);
    }
}
