package com.amap.api.services.district;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.col.jmsl.C1631z1;

/* loaded from: classes.dex */
public class DistrictSearchQuery implements Parcelable, Cloneable {
    public static final Parcelable.Creator<DistrictSearchQuery> CREATOR = new a();
    public static final String KEYWORDS_BUSINESS = "biz_area";
    public static final String KEYWORDS_CITY = "city";
    public static final String KEYWORDS_COUNTRY = "country";
    public static final String KEYWORDS_DISTRICT = "district";
    public static final String KEYWORDS_PROVINCE = "province";

    /* renamed from: a, reason: collision with root package name */
    private int f17409a;

    /* renamed from: b, reason: collision with root package name */
    private int f17410b;

    /* renamed from: c, reason: collision with root package name */
    private String f17411c;

    /* renamed from: d, reason: collision with root package name */
    private String f17412d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f17413e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f17414f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f17415g;

    /* renamed from: h, reason: collision with root package name */
    private int f17416h;

    public static class a implements Parcelable.Creator<DistrictSearchQuery> {
        @Override // android.os.Parcelable.Creator
        public DistrictSearchQuery createFromParcel(Parcel parcel) {
            DistrictSearchQuery districtSearchQuery = new DistrictSearchQuery();
            districtSearchQuery.setKeywords(parcel.readString());
            districtSearchQuery.setKeywordsLevel(parcel.readString());
            districtSearchQuery.setPageNum(parcel.readInt());
            districtSearchQuery.setPageSize(parcel.readInt());
            districtSearchQuery.setShowChild(parcel.readByte() == 1);
            districtSearchQuery.setShowBoundary(parcel.readByte() == 1);
            districtSearchQuery.setShowBusinessArea(parcel.readByte() == 1);
            districtSearchQuery.setSubDistrict(parcel.readInt());
            return districtSearchQuery;
        }

        @Override // android.os.Parcelable.Creator
        public DistrictSearchQuery[] newArray(int i10) {
            return new DistrictSearchQuery[i10];
        }
    }

    public DistrictSearchQuery() {
        this.f17409a = 1;
        this.f17410b = 20;
        this.f17413e = true;
        this.f17414f = false;
        this.f17415g = false;
        this.f17416h = 1;
    }

    public boolean checkKeyWords() {
        String str = this.f17411c;
        return (str == null || str.trim().equalsIgnoreCase("")) ? false : true;
    }

    public boolean checkLevels() {
        String str = this.f17412d;
        if (str == null) {
            return false;
        }
        return str.trim().equals("country") || this.f17412d.trim().equals("province") || this.f17412d.trim().equals("city") || this.f17412d.trim().equals("district") || this.f17412d.trim().equals(KEYWORDS_BUSINESS);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        DistrictSearchQuery districtSearchQuery = (DistrictSearchQuery) obj;
        if (this.f17415g != districtSearchQuery.f17415g) {
            return false;
        }
        String str = this.f17411c;
        if (str == null) {
            if (districtSearchQuery.f17411c != null) {
                return false;
            }
        } else if (!str.equals(districtSearchQuery.f17411c)) {
            return false;
        }
        return this.f17409a == districtSearchQuery.f17409a && this.f17410b == districtSearchQuery.f17410b && this.f17413e == districtSearchQuery.f17413e && this.f17416h == districtSearchQuery.f17416h;
    }

    public String getKeywords() {
        return this.f17411c;
    }

    public String getKeywordsLevel() {
        return this.f17412d;
    }

    public int getPageNum() {
        int i10 = this.f17409a;
        if (i10 < 1) {
            return 1;
        }
        return i10;
    }

    public int getPageSize() {
        return this.f17410b;
    }

    public int getSubDistrict() {
        return this.f17416h;
    }

    public int hashCode() {
        int i10 = ((this.f17415g ? 1231 : 1237) + 31) * 31;
        String str = this.f17411c;
        int iHashCode = (i10 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f17412d;
        return ((((((((iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.f17409a) * 31) + this.f17410b) * 31) + (this.f17413e ? 1231 : 1237)) * 31) + this.f17416h;
    }

    public boolean isShowBoundary() {
        return this.f17415g;
    }

    public boolean isShowBusinessArea() {
        return this.f17414f;
    }

    public boolean isShowChild() {
        return this.f17413e;
    }

    public void setKeywords(String str) {
        this.f17411c = str;
    }

    public void setKeywordsLevel(String str) {
        this.f17412d = str;
    }

    public void setPageNum(int i10) {
        this.f17409a = i10;
    }

    public void setPageSize(int i10) {
        this.f17410b = i10;
    }

    public void setShowBoundary(boolean z10) {
        this.f17415g = z10;
    }

    public void setShowBusinessArea(boolean z10) {
        this.f17414f = z10;
    }

    public void setShowChild(boolean z10) {
        this.f17413e = z10;
    }

    public void setSubDistrict(int i10) {
        this.f17416h = i10;
    }

    public boolean weakEquals(DistrictSearchQuery districtSearchQuery) {
        if (this == districtSearchQuery) {
            return true;
        }
        if (districtSearchQuery == null) {
            return false;
        }
        String str = this.f17411c;
        if (str == null) {
            if (districtSearchQuery.f17411c != null) {
                return false;
            }
        } else if (!str.equals(districtSearchQuery.f17411c)) {
            return false;
        }
        return this.f17410b == districtSearchQuery.f17410b && this.f17413e == districtSearchQuery.f17413e && this.f17415g == districtSearchQuery.f17415g && this.f17416h == districtSearchQuery.f17416h;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f17411c);
        parcel.writeString(this.f17412d);
        parcel.writeInt(this.f17409a);
        parcel.writeInt(this.f17410b);
        parcel.writeByte(this.f17413e ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f17415g ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f17414f ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.f17416h);
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public DistrictSearchQuery m23clone() throws CloneNotSupportedException {
        try {
            super.clone();
        } catch (CloneNotSupportedException e10) {
            C1631z1.o(e10, "DistrictSearchQuery", "clone");
        }
        DistrictSearchQuery districtSearchQuery = new DistrictSearchQuery();
        districtSearchQuery.setKeywords(this.f17411c);
        districtSearchQuery.setKeywordsLevel(this.f17412d);
        districtSearchQuery.setPageNum(this.f17409a);
        districtSearchQuery.setPageSize(this.f17410b);
        districtSearchQuery.setShowChild(this.f17413e);
        districtSearchQuery.setSubDistrict(this.f17416h);
        districtSearchQuery.setShowBoundary(this.f17415g);
        districtSearchQuery.setShowBusinessArea(this.f17414f);
        return districtSearchQuery;
    }

    public DistrictSearchQuery(String str, String str2, int i10) {
        this.f17410b = 20;
        this.f17413e = true;
        this.f17414f = false;
        this.f17415g = false;
        this.f17416h = 1;
        this.f17411c = str;
        this.f17412d = str2;
        this.f17409a = i10;
    }

    public DistrictSearchQuery(String str, String str2, int i10, boolean z10, int i11) {
        this(str, str2, i10);
        this.f17413e = z10;
        this.f17410b = i11;
    }
}
