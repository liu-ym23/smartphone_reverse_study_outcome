package com.amap.api.services.district;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.AMapException;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes28.dex */
public final class DistrictResult implements Parcelable {
    public Parcelable.Creator<DistrictResult> CREATOR;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private DistrictSearchQuery f28881a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ArrayList<DistrictItem> f28882b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f28883c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private AMapException f28884d;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final int hashCode() {
        DistrictSearchQuery r100 = this.f28881a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = (r102 + 31) * 31;
        ArrayList<DistrictItem> r104 = this.f28882b;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "DistrictResult [mDisQuery=" + this.f28881a + ", mDistricts=" + this.f28882b + "]";
    }

    public DistrictResult() {
        this.f28882b = new ArrayList();
        this.CREATOR = new AnonymousClass1(this);
    }

    public final AMapException getAMapException() {
        return this.f28884d;
    }

    public final ArrayList<DistrictItem> getDistrict() {
        return this.f28882b;
    }

    public final int getPageCount() {
        return this.f28883c;
    }

    public final DistrictSearchQuery getQuery() {
        return this.f28881a;
    }

    public DistrictResult(Parcel r100) {
        this.f28882b = new ArrayList();
        this.CREATOR = new AnonymousClass1(this);
        this.f28881a = (DistrictSearchQuery) r100.readParcelable(DistrictSearchQuery.class.getClassLoader());
        this.f28882b = r100.createTypedArrayList(DistrictItem.CREATOR);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L9;
        return false;
    L9:
        if (DistrictResult.class == r100.getClass()) goto L11;
        return false;
    L11:
        DistrictResult r101 = (DistrictResult) r100;
        DistrictSearchQuery r102 = this.f28881a;
        if (r102 != null) goto L17;
        if (r101.f28881a == null) goto L19;
        return false;
    L19:
        ArrayList<DistrictItem> r103 = this.f28882b;
        if (r103 != null) goto L25;
        if (r101.f28882b == null) goto L27;
        return false;
    L27:
        return true;
    L25:
        if (r103.equals(r101.f28882b) == true) goto L27;
        return false;
    L17:
        if (r102.equals(r101.f28881a) == true) goto L19;
        return false;
    }

    public final void setAMapException(AMapException r100) {
        this.f28884d = r100;
    }

    public final void setDistrict(ArrayList<DistrictItem> r100) {
        this.f28882b = r100;
    }

    public final void setPageCount(int r100) {
        this.f28883c = r100;
    }

    public final void setQuery(DistrictSearchQuery r100) {
        this.f28881a = r100;
    }

    public DistrictResult(DistrictSearchQuery r100, ArrayList<DistrictItem> r101) {
        this.f28882b = new ArrayList();
        this.CREATOR = new AnonymousClass1(this);
        this.f28881a = r100;
        this.f28882b = r101;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        r100.writeParcelable(this.f28881a, r101);
        r100.writeTypedList(this.f28882b);
    }
}
