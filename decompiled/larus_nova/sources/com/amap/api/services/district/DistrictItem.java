package com.amap.api.services.district;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes28.dex */
public final class DistrictItem implements Parcelable {
    public static final Parcelable.Creator<DistrictItem> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f28874a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f28875b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f28876c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private LatLonPoint f28877d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f28878e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private List<DistrictItem> f28879f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String[] f28880g;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    public final int hashCode() {
        String r100 = this.f28875b;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = (r102 + 31) * 31;
        LatLonPoint r104 = this.f28877d;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f28874a;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (((r106 + r108) * 31) + Arrays.hashCode(this.f28880g)) * 31;
        List<DistrictItem> r110 = this.f28879f;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f28878e;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.f28876c;
        if (r116 == null) goto L27;
        r101 = r116.hashCode();
    L27:
        return r115 + r101;
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "DistrictItem [mCitycode=" + this.f28874a + ", mAdcode=" + this.f28875b + ", mName=" + this.f28876c + ", mCenter=" + this.f28877d + ", mLevel=" + this.f28878e + ", mDistricts=" + this.f28879f + "]";
    }

    public DistrictItem() {
        this.f28879f = new ArrayList();
        this.f28880g = new String[0];
    }

    public final String[] districtBoundary() {
        return this.f28880g;
    }

    public final String getAdcode() {
        return this.f28875b;
    }

    public final LatLonPoint getCenter() {
        return this.f28877d;
    }

    public final String getCitycode() {
        return this.f28874a;
    }

    public final String getLevel() {
        return this.f28878e;
    }

    public final String getName() {
        return this.f28876c;
    }

    public final List<DistrictItem> getSubDistrict() {
        return this.f28879f;
    }

    public DistrictItem(Parcel r100) {
        this.f28879f = new ArrayList();
        this.f28880g = new String[0];
        this.f28874a = r100.readString();
        this.f28875b = r100.readString();
        this.f28876c = r100.readString();
        this.f28877d = (LatLonPoint) r100.readParcelable(LatLonPoint.class.getClassLoader());
        this.f28878e = r100.readString();
        this.f28879f = r100.createTypedArrayList(CREATOR);
        String[] r101 = new String[r100.readInt()];
        this.f28880g = r101;
        r100.readStringArray(r101);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L9;
        return false;
    L9:
        if (DistrictItem.class == r100.getClass()) goto L11;
        return false;
    L11:
        DistrictItem r101 = (DistrictItem) r100;
        String r102 = this.f28875b;
        if (r102 != null) goto L17;
        if (r101.f28875b == null) goto L19;
        return false;
    L19:
        LatLonPoint r103 = this.f28877d;
        if (r103 != null) goto L25;
        if (r101.f28877d == null) goto L27;
        return false;
    L27:
        String r104 = this.f28874a;
        if (r104 != null) goto L33;
        if (r101.f28874a == null) goto L36;
        return false;
    L36:
        if (Arrays.equals(this.f28880g, r101.f28880g) == true) goto L38;
        return false;
    L38:
        List<DistrictItem> r105 = this.f28879f;
        if (r105 != null) goto L44;
        if (r101.f28879f == null) goto L46;
        return false;
    L46:
        String r106 = this.f28878e;
        if (r106 != null) goto L52;
        if (r101.f28878e == null) goto L54;
        return false;
    L54:
        String r107 = this.f28876c;
        if (r107 != null) goto L60;
        if (r101.f28876c == null) goto L62;
        return false;
    L62:
        return true;
    L60:
        if (r107.equals(r101.f28876c) == true) goto L62;
        return false;
    L52:
        if (r106.equals(r101.f28878e) == true) goto L54;
        return false;
    L44:
        if (r105.equals(r101.f28879f) == true) goto L46;
        return false;
    L33:
        if (r104.equals(r101.f28874a) == true) goto L36;
        return false;
    L25:
        if (r103.equals(r101.f28877d) == true) goto L27;
        return false;
    L17:
        if (r102.equals(r101.f28875b) == true) goto L19;
        return false;
    }

    public final void setAdcode(String r100) {
        this.f28875b = r100;
    }

    public final void setCenter(LatLonPoint r100) {
        this.f28877d = r100;
    }

    public final void setCitycode(String r100) {
        this.f28874a = r100;
    }

    public final void setDistrictBoundary(String[] r100) {
        this.f28880g = r100;
    }

    public final void setLevel(String r100) {
        this.f28878e = r100;
    }

    public final void setName(String r100) {
        this.f28876c = r100;
    }

    public final void setSubDistrict(ArrayList<DistrictItem> r100) {
        this.f28879f = r100;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        r100.writeString(this.f28874a);
        r100.writeString(this.f28875b);
        r100.writeString(this.f28876c);
        r100.writeParcelable(this.f28877d, r101);
        r100.writeString(this.f28878e);
        r100.writeTypedList(this.f28879f);
        r100.writeInt(this.f28880g.length);
        r100.writeStringArray(this.f28880g);
    }

    public DistrictItem(String r100, String r101, String r102, LatLonPoint r103, String r104) {
        this.f28879f = new ArrayList();
        this.f28880g = new String[0];
        this.f28876c = r100;
        this.f28874a = r101;
        this.f28875b = r102;
        this.f28877d = r103;
        this.f28878e = r104;
    }
}
