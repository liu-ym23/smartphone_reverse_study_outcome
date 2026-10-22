package com.amap.api.services.district;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public final class DistrictItem implements Parcelable {
    public static final Parcelable.Creator<DistrictItem> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private String f17397a;

    /* renamed from: b, reason: collision with root package name */
    private String f17398b;

    /* renamed from: c, reason: collision with root package name */
    private String f17399c;

    /* renamed from: d, reason: collision with root package name */
    private LatLonPoint f17400d;

    /* renamed from: e, reason: collision with root package name */
    private String f17401e;

    /* renamed from: f, reason: collision with root package name */
    private List<DistrictItem> f17402f;

    /* renamed from: g, reason: collision with root package name */
    private String[] f17403g;

    public static class a implements Parcelable.Creator<DistrictItem> {
        @Override // android.os.Parcelable.Creator
        public DistrictItem createFromParcel(Parcel parcel) {
            return new DistrictItem(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public DistrictItem[] newArray(int i10) {
            return new DistrictItem[i10];
        }
    }

    public DistrictItem() {
        this.f17402f = new ArrayList();
        this.f17403g = new String[0];
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String[] districtBoundary() {
        return this.f17403g;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || DistrictItem.class != obj.getClass()) {
            return false;
        }
        DistrictItem districtItem = (DistrictItem) obj;
        String str = this.f17398b;
        if (str == null) {
            if (districtItem.f17398b != null) {
                return false;
            }
        } else if (!str.equals(districtItem.f17398b)) {
            return false;
        }
        LatLonPoint latLonPoint = this.f17400d;
        if (latLonPoint == null) {
            if (districtItem.f17400d != null) {
                return false;
            }
        } else if (!latLonPoint.equals(districtItem.f17400d)) {
            return false;
        }
        String str2 = this.f17397a;
        if (str2 == null) {
            if (districtItem.f17397a != null) {
                return false;
            }
        } else if (!str2.equals(districtItem.f17397a)) {
            return false;
        }
        if (!Arrays.equals(this.f17403g, districtItem.f17403g)) {
            return false;
        }
        List<DistrictItem> list = this.f17402f;
        if (list == null) {
            if (districtItem.f17402f != null) {
                return false;
            }
        } else if (!list.equals(districtItem.f17402f)) {
            return false;
        }
        String str3 = this.f17401e;
        if (str3 == null) {
            if (districtItem.f17401e != null) {
                return false;
            }
        } else if (!str3.equals(districtItem.f17401e)) {
            return false;
        }
        String str4 = this.f17399c;
        if (str4 == null) {
            if (districtItem.f17399c != null) {
                return false;
            }
        } else if (!str4.equals(districtItem.f17399c)) {
            return false;
        }
        return true;
    }

    public String getAdcode() {
        return this.f17398b;
    }

    public LatLonPoint getCenter() {
        return this.f17400d;
    }

    public String getCitycode() {
        return this.f17397a;
    }

    public String getLevel() {
        return this.f17401e;
    }

    public String getName() {
        return this.f17399c;
    }

    public List<DistrictItem> getSubDistrict() {
        return this.f17402f;
    }

    public int hashCode() {
        String str = this.f17398b;
        int iHashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
        LatLonPoint latLonPoint = this.f17400d;
        int iHashCode2 = (iHashCode + (latLonPoint == null ? 0 : latLonPoint.hashCode())) * 31;
        String str2 = this.f17397a;
        int iHashCode3 = (((iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31) + Arrays.hashCode(this.f17403g)) * 31;
        List<DistrictItem> list = this.f17402f;
        int iHashCode4 = (iHashCode3 + (list == null ? 0 : list.hashCode())) * 31;
        String str3 = this.f17401e;
        int iHashCode5 = (iHashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.f17399c;
        return iHashCode5 + (str4 != null ? str4.hashCode() : 0);
    }

    public void setAdcode(String str) {
        this.f17398b = str;
    }

    public void setCenter(LatLonPoint latLonPoint) {
        this.f17400d = latLonPoint;
    }

    public void setCitycode(String str) {
        this.f17397a = str;
    }

    public void setDistrictBoundary(String[] strArr) {
        this.f17403g = strArr;
    }

    public void setLevel(String str) {
        this.f17401e = str;
    }

    public void setName(String str) {
        this.f17399c = str;
    }

    public void setSubDistrict(ArrayList<DistrictItem> arrayList) {
        this.f17402f = arrayList;
    }

    public String toString() {
        return "DistrictItem [mCitycode=" + this.f17397a + ", mAdcode=" + this.f17398b + ", mName=" + this.f17399c + ", mCenter=" + this.f17400d + ", mLevel=" + this.f17401e + ", mDistricts=" + this.f17402f + "]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f17397a);
        parcel.writeString(this.f17398b);
        parcel.writeString(this.f17399c);
        parcel.writeParcelable(this.f17400d, i10);
        parcel.writeString(this.f17401e);
        parcel.writeTypedList(this.f17402f);
        parcel.writeInt(this.f17403g.length);
        parcel.writeStringArray(this.f17403g);
    }

    public DistrictItem(String str, String str2, String str3, LatLonPoint latLonPoint, String str4) {
        this.f17402f = new ArrayList();
        this.f17403g = new String[0];
        this.f17399c = str;
        this.f17397a = str2;
        this.f17398b = str3;
        this.f17400d = latLonPoint;
        this.f17401e = str4;
    }

    public DistrictItem(Parcel parcel) {
        this.f17402f = new ArrayList();
        this.f17403g = new String[0];
        this.f17397a = parcel.readString();
        this.f17398b = parcel.readString();
        this.f17399c = parcel.readString();
        this.f17400d = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
        this.f17401e = parcel.readString();
        this.f17402f = parcel.createTypedArrayList(CREATOR);
        int i10 = parcel.readInt();
        if (i10 <= 0 || i10 > 52428800) {
            return;
        }
        String[] strArr = new String[i10];
        this.f17403g = strArr;
        parcel.readStringArray(strArr);
    }
}
