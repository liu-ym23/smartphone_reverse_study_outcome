package com.amap.api.services.district;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.col.s.i;

/* JADX INFO: loaded from: classes28.dex */
public class DistrictSearchQuery implements Parcelable, Cloneable {
    public static final Parcelable.Creator<DistrictSearchQuery> CREATOR = null;
    public static final String KEYWORDS_BUSINESS = "biz_area";
    public static final String KEYWORDS_CITY = "city";
    public static final String KEYWORDS_COUNTRY = "country";
    public static final String KEYWORDS_DISTRICT = "district";
    public static final String KEYWORDS_PROVINCE = "province";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f28887a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f28888b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f28889c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f28890d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f28891e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f28892f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f28893g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f28894h;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    public boolean checkKeyWords() {
        String r100 = this.f28889c;
        if (r100 != null) goto L6;
        return false;
    L6:
        if (r100.trim().equalsIgnoreCase("") == false) goto L8;
        return false;
    L8:
        return true;
    }

    public boolean checkLevels() {
        String r100 = this.f28890d;
        if (r100 != null) goto L6;
        return false;
    L6:
        if (r100.trim().equals(KEYWORDS_COUNTRY) == false) goto L8;
        return true;
    L8:
        if (this.f28890d.trim().equals("province") == false) goto L10;
        return true;
    L10:
        if (this.f28890d.trim().equals("city") == false) goto L12;
        return true;
    L12:
        if (this.f28890d.trim().equals(KEYWORDS_DISTRICT) == false) goto L14;
        return true;
    L14:
        if (this.f28890d.trim().equals(KEYWORDS_BUSINESS) == true) goto L22;
        return false;
    L22:
        return true;
    }

    public int getPageNum() {
        int r100 = this.f28887a;
        if (r100 > 0) goto L6;
        return 1;
    L6:
        return r100;
    }

    public int hashCode() {
        int r100 = 1231;
        if (this.f28893g == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = (r101 + 31) * 31;
        String r103 = this.f28889c;
        int r104 = 0;
        if (r103 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r102 + r105) * 31;
        String r107 = this.f28890d;
        if (r107 == null) goto L14;
        r104 = r107.hashCode();
    L14:
        int r108 = (((((r106 + r104) * 31) + this.f28887a) * 31) + this.f28888b) * 31;
        if (this.f28891e == true) goto L19;
        r100 = 1237;
    L19:
        return ((r108 + r100) * 31) + this.f28894h;
    L9:
        r105 = r103.hashCode();
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public DistrictSearchQuery() {
        this.f28887a = 1;
        this.f28888b = 20;
        this.f28891e = true;
        this.f28892f = false;
        this.f28893g = false;
        this.f28894h = 1;
    }

    public DistrictSearchQuery clone() {
        super.clone();     // Catch: CloneNotSupportedException -> L4
    L6:
        DistrictSearchQuery r100 = new DistrictSearchQuery();
        r100.setKeywords(this.f28889c);
        r100.setKeywordsLevel(this.f28890d);
        r100.setPageNum(this.f28887a);
        r100.setPageSize(this.f28888b);
        r100.setShowChild(this.f28891e);
        r100.setSubDistrict(this.f28894h);
        r100.setShowBoundary(this.f28893g);
        r100.setShowBusinessArea(this.f28892f);
        return r100;
    L4:
        e = move-exception;
        i.a(e, "DistrictSearchQuery", "clone");
        goto L6
    }

    public String getKeywords() {
        return this.f28889c;
    }

    public String getKeywordsLevel() {
        return this.f28890d;
    }

    public int getPageSize() {
        return this.f28888b;
    }

    public int getSubDistrict() {
        return this.f28894h;
    }

    public boolean isShowBoundary() {
        return this.f28893g;
    }

    public boolean isShowBusinessArea() {
        return this.f28892f;
    }

    public boolean isShowChild() {
        return this.f28891e;
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m8036clone() throws CloneNotSupportedException {
        return clone();
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L9;
        return false;
    L9:
        if (getClass() == r100.getClass()) goto L11;
        return false;
    L11:
        DistrictSearchQuery r101 = (DistrictSearchQuery) r100;
        if (this.f28893g == r101.f28893g) goto L14;
        return false;
    L14:
        String r102 = this.f28889c;
        if (r102 != null) goto L20;
        if (r101.f28889c == null) goto L23;
        return false;
    L23:
        if (this.f28887a == r101.f28887a) goto L26;
        return false;
    L26:
        if (this.f28888b == r101.f28888b) goto L29;
        return false;
    L29:
        if (this.f28891e == r101.f28891e) goto L32;
        return false;
    L32:
        if (this.f28894h == r101.f28894h) goto L34;
        return false;
    L34:
        return true;
    L20:
        if (r102.equals(r101.f28889c) == true) goto L23;
        return false;
    }

    public void setKeywords(String r100) {
        this.f28889c = r100;
    }

    public void setKeywordsLevel(String r100) {
        this.f28890d = r100;
    }

    public void setPageNum(int r100) {
        this.f28887a = r100;
    }

    public void setPageSize(int r100) {
        this.f28888b = r100;
    }

    public void setShowBoundary(boolean r100) {
        this.f28893g = r100;
    }

    public void setShowBusinessArea(boolean r100) {
        this.f28892f = r100;
    }

    public void setShowChild(boolean r100) {
        this.f28891e = r100;
    }

    public void setSubDistrict(int r100) {
        this.f28894h = r100;
    }

    public boolean weakEquals(DistrictSearchQuery r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
        return false;
    L8:
        String r101 = this.f28889c;
        if (r101 != null) goto L14;
        if (r100.f28889c == null) goto L17;
        return false;
    L17:
        if (this.f28888b == r100.f28888b) goto L20;
        return false;
    L20:
        if (this.f28891e == r100.f28891e) goto L23;
        return false;
    L23:
        if (this.f28893g == r100.f28893g) goto L26;
        return false;
    L26:
        if (this.f28894h == r100.f28894h) goto L28;
        return false;
    L28:
        return true;
    L14:
        if (r101.equals(r100.f28889c) == true) goto L17;
        return false;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeString(this.f28889c);
        r100.writeString(this.f28890d);
        r100.writeInt(this.f28887a);
        r100.writeInt(this.f28888b);
        r100.writeByte(this.f28891e ? 1 : 0);
        r100.writeByte(this.f28893g ? 1 : 0);
        r100.writeByte(this.f28892f ? 1 : 0);
        r100.writeInt(this.f28894h);
    }

    public DistrictSearchQuery(String r100, String r101, int r102) {
        this.f28888b = 20;
        this.f28891e = true;
        this.f28892f = false;
        this.f28893g = false;
        this.f28894h = 1;
        this.f28889c = r100;
        this.f28890d = r101;
        this.f28887a = r102;
    }

    public DistrictSearchQuery(String r100, String r101, int r102, boolean r103, int r104) {
        this(r100, r101, r102);
        this.f28891e = r103;
        this.f28888b = r104;
    }
}
