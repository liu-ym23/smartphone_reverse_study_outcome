package com.amap.api.services.district;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.AMapException;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class DistrictResult implements Parcelable {
    public Parcelable.Creator<DistrictResult> CREATOR;

    /* renamed from: a, reason: collision with root package name */
    private DistrictSearchQuery f17404a;

    /* renamed from: b, reason: collision with root package name */
    private ArrayList<DistrictItem> f17405b;

    /* renamed from: c, reason: collision with root package name */
    private int f17406c;

    /* renamed from: d, reason: collision with root package name */
    private AMapException f17407d;

    public class a implements Parcelable.Creator<DistrictResult> {
        public a(DistrictResult districtResult) {
        }

        @Override // android.os.Parcelable.Creator
        public DistrictResult createFromParcel(Parcel parcel) {
            return new DistrictResult(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public DistrictResult[] newArray(int i10) {
            return new DistrictResult[i10];
        }
    }

    public DistrictResult(DistrictSearchQuery districtSearchQuery, ArrayList<DistrictItem> arrayList) {
        this.f17405b = new ArrayList<>();
        this.CREATOR = new a(this);
        this.f17404a = districtSearchQuery;
        this.f17405b = arrayList;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || DistrictResult.class != obj.getClass()) {
            return false;
        }
        DistrictResult districtResult = (DistrictResult) obj;
        DistrictSearchQuery districtSearchQuery = this.f17404a;
        if (districtSearchQuery == null) {
            if (districtResult.f17404a != null) {
                return false;
            }
        } else if (!districtSearchQuery.equals(districtResult.f17404a)) {
            return false;
        }
        ArrayList<DistrictItem> arrayList = this.f17405b;
        if (arrayList == null) {
            if (districtResult.f17405b != null) {
                return false;
            }
        } else if (!arrayList.equals(districtResult.f17405b)) {
            return false;
        }
        return true;
    }

    public AMapException getAMapException() {
        return this.f17407d;
    }

    public ArrayList<DistrictItem> getDistrict() {
        return this.f17405b;
    }

    public int getPageCount() {
        return this.f17406c;
    }

    public DistrictSearchQuery getQuery() {
        return this.f17404a;
    }

    public int hashCode() {
        DistrictSearchQuery districtSearchQuery = this.f17404a;
        int iHashCode = ((districtSearchQuery == null ? 0 : districtSearchQuery.hashCode()) + 31) * 31;
        ArrayList<DistrictItem> arrayList = this.f17405b;
        return iHashCode + (arrayList != null ? arrayList.hashCode() : 0);
    }

    public void setAMapException(AMapException aMapException) {
        this.f17407d = aMapException;
    }

    public void setDistrict(ArrayList<DistrictItem> arrayList) {
        this.f17405b = arrayList;
    }

    public void setPageCount(int i10) {
        this.f17406c = i10;
    }

    public void setQuery(DistrictSearchQuery districtSearchQuery) {
        this.f17404a = districtSearchQuery;
    }

    public String toString() {
        return "DistrictResult [mDisQuery=" + this.f17404a + ", mDistricts=" + this.f17405b + "]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeParcelable(this.f17404a, i10);
        parcel.writeTypedList(this.f17405b);
    }

    public DistrictResult() {
        this.f17405b = new ArrayList<>();
        this.CREATOR = new a(this);
    }

    public DistrictResult(Parcel parcel) {
        this.f17405b = new ArrayList<>();
        this.CREATOR = new a(this);
        this.f17404a = (DistrictSearchQuery) parcel.readParcelable(DistrictSearchQuery.class.getClassLoader());
        this.f17405b = parcel.createTypedArrayList(DistrictItem.CREATOR);
    }
}
