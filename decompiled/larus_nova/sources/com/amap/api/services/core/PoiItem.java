package com.amap.api.services.core;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.poisearch.IndoorData;
import com.amap.api.services.poisearch.Photo;
import com.amap.api.services.poisearch.PoiItemExtension;
import com.amap.api.services.poisearch.SubPoiItem;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes28.dex */
public class PoiItem implements Parcelable {
    public static final Parcelable.Creator<PoiItem> CREATOR = null;
    private String A;
    private String B;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f28839a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f28840b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f28841c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f28842d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f28843e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f28844f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final LatLonPoint f28845g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final String f28846h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final String f28847i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private LatLonPoint f28848j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private LatLonPoint f28849k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private String f28850l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private String f28851m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private String f28852n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private String f28853o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private String f28854p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private String f28855q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private String f28856r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f28857s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private IndoorData f28858t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private String f28859u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private String f28860v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private String f28861w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private List<SubPoiItem> f28862x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private List<Photo> f28863y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private PoiItemExtension f28864z;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    public int hashCode() {
        String r100 = this.f28839a;
        if (r100 != null) goto L5;
        int r101 = 0;
    L7:
        return r101 + 31;
    L5:
        r101 = r100.hashCode();
        goto L7
    }

    public String getAdCode() {
        return this.f28841c;
    }

    public String getAdName() {
        return this.f28856r;
    }

    public String getBusinessArea() {
        return this.f28860v;
    }

    public String getCityCode() {
        return this.f28842d;
    }

    public String getCityName() {
        return this.f28855q;
    }

    public String getDirection() {
        return this.f28853o;
    }

    public int getDistance() {
        return this.f28844f;
    }

    public String getEmail() {
        return this.f28852n;
    }

    public LatLonPoint getEnter() {
        return this.f28848j;
    }

    public LatLonPoint getExit() {
        return this.f28849k;
    }

    public IndoorData getIndoorData() {
        return this.f28858t;
    }

    public LatLonPoint getLatLonPoint() {
        return this.f28845g;
    }

    public String getParkingType() {
        return this.f28861w;
    }

    public List<Photo> getPhotos() {
        return this.f28863y;
    }

    public PoiItemExtension getPoiExtension() {
        return this.f28864z;
    }

    public String getPoiId() {
        return this.f28839a;
    }

    public String getPostcode() {
        return this.f28851m;
    }

    public String getProvinceCode() {
        return this.f28859u;
    }

    public String getProvinceName() {
        return this.f28854p;
    }

    public String getShopID() {
        return this.B;
    }

    public String getSnippet() {
        return this.f28847i;
    }

    public List<SubPoiItem> getSubPois() {
        return this.f28862x;
    }

    public String getTel() {
        return this.f28840b;
    }

    public String getTitle() {
        return this.f28846h;
    }

    public String getTypeCode() {
        return this.A;
    }

    public String getTypeDes() {
        return this.f28843e;
    }

    public String getWebsite() {
        return this.f28850l;
    }

    public boolean isIndoorMap() {
        return this.f28857s;
    }

    public String toString() {
        return this.f28846h;
    }

    public PoiItem(Parcel r100) {
        this.f28843e = "";
        this.f28844f = -1;
        this.f28862x = new ArrayList();
        this.f28863y = new ArrayList();
        this.f28839a = r100.readString();
        this.f28841c = r100.readString();
        this.f28840b = r100.readString();
        this.f28843e = r100.readString();
        this.f28844f = r100.readInt();
        this.f28845g = (LatLonPoint) r100.readValue(LatLonPoint.class.getClassLoader());
        this.f28846h = r100.readString();
        this.f28847i = r100.readString();
        this.f28842d = r100.readString();
        this.f28848j = (LatLonPoint) r100.readValue(LatLonPoint.class.getClassLoader());
        this.f28849k = (LatLonPoint) r100.readValue(LatLonPoint.class.getClassLoader());
        this.f28850l = r100.readString();
        this.f28851m = r100.readString();
        this.f28852n = r100.readString();
        boolean[] r101 = new boolean[1];
        r100.readBooleanArray(r101);
        this.f28857s = r101[0];
        this.f28853o = r100.readString();
        this.f28854p = r100.readString();
        this.f28855q = r100.readString();
        this.f28856r = r100.readString();
        this.f28859u = r100.readString();
        this.f28860v = r100.readString();
        this.f28861w = r100.readString();
        this.f28862x = r100.readArrayList(SubPoiItem.class.getClassLoader());
        this.f28858t = (IndoorData) r100.readValue(IndoorData.class.getClassLoader());
        this.f28863y = r100.createTypedArrayList(Photo.CREATOR);
        this.f28864z = (PoiItemExtension) r100.readParcelable(PoiItemExtension.class.getClassLoader());
        this.A = r100.readString();
        this.B = r100.readString();
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
        PoiItem r101 = (PoiItem) r100;
        String r102 = this.f28839a;
        if (r102 != null) goto L17;
        if (r101.f28839a == null) goto L19;
        return false;
    L19:
        return true;
    L17:
        if (r102.equals(r101.f28839a) == true) goto L19;
        return false;
    }

    public void setAdCode(String r100) {
        this.f28841c = r100;
    }

    public void setAdName(String r100) {
        this.f28856r = r100;
    }

    public void setBusinessArea(String r100) {
        this.f28860v = r100;
    }

    public void setCityCode(String r100) {
        this.f28842d = r100;
    }

    public void setCityName(String r100) {
        this.f28855q = r100;
    }

    public void setDirection(String r100) {
        this.f28853o = r100;
    }

    public void setDistance(int r100) {
        this.f28844f = r100;
    }

    public void setEmail(String r100) {
        this.f28852n = r100;
    }

    public void setEnter(LatLonPoint r100) {
        this.f28848j = r100;
    }

    public void setExit(LatLonPoint r100) {
        this.f28849k = r100;
    }

    public void setIndoorDate(IndoorData r100) {
        this.f28858t = r100;
    }

    public void setIndoorMap(boolean r100) {
        this.f28857s = r100;
    }

    public void setParkingType(String r100) {
        this.f28861w = r100;
    }

    public void setPhotos(List<Photo> r100) {
        this.f28863y = r100;
    }

    public void setPoiExtension(PoiItemExtension r100) {
        this.f28864z = r100;
    }

    public void setPostcode(String r100) {
        this.f28851m = r100;
    }

    public void setProvinceCode(String r100) {
        this.f28859u = r100;
    }

    public void setProvinceName(String r100) {
        this.f28854p = r100;
    }

    public void setShopID(String r100) {
        this.B = r100;
    }

    public void setSubPois(List<SubPoiItem> r100) {
        this.f28862x = r100;
    }

    public void setTel(String r100) {
        this.f28840b = r100;
    }

    public void setTypeCode(String r100) {
        this.A = r100;
    }

    public void setTypeDes(String r100) {
        this.f28843e = r100;
    }

    public void setWebsite(String r100) {
        this.f28850l = r100;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeString(this.f28839a);
        r100.writeString(this.f28841c);
        r100.writeString(this.f28840b);
        r100.writeString(this.f28843e);
        r100.writeInt(this.f28844f);
        r100.writeValue(this.f28845g);
        r100.writeString(this.f28846h);
        r100.writeString(this.f28847i);
        r100.writeString(this.f28842d);
        r100.writeValue(this.f28848j);
        r100.writeValue(this.f28849k);
        r100.writeString(this.f28850l);
        r100.writeString(this.f28851m);
        r100.writeString(this.f28852n);
        r100.writeBooleanArray(new boolean[]{this.f28857s});
        r100.writeString(this.f28853o);
        r100.writeString(this.f28854p);
        r100.writeString(this.f28855q);
        r100.writeString(this.f28856r);
        r100.writeString(this.f28859u);
        r100.writeString(this.f28860v);
        r100.writeString(this.f28861w);
        r100.writeList(this.f28862x);
        r100.writeValue(this.f28858t);
        r100.writeTypedList(this.f28863y);
        r100.writeParcelable(this.f28864z, r101);
        r100.writeString(this.A);
        r100.writeString(this.B);
    }

    public PoiItem(String r100, LatLonPoint r101, String r102, String r103) {
        this.f28843e = "";
        this.f28844f = -1;
        this.f28862x = new ArrayList();
        this.f28863y = new ArrayList();
        this.f28839a = r100;
        this.f28845g = r101;
        this.f28846h = r102;
        this.f28847i = r103;
    }
}
