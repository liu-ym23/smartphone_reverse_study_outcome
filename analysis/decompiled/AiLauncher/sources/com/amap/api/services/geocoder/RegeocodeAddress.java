package com.amap.api.services.geocoder;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.road.Crossroad;
import com.amap.api.services.road.Road;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class RegeocodeAddress implements Parcelable {
    public static final Parcelable.Creator<RegeocodeAddress> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private String f17444a;

    /* renamed from: b, reason: collision with root package name */
    private String f17445b;

    /* renamed from: c, reason: collision with root package name */
    private String f17446c;

    /* renamed from: d, reason: collision with root package name */
    private String f17447d;

    /* renamed from: e, reason: collision with root package name */
    private String f17448e;

    /* renamed from: f, reason: collision with root package name */
    private String f17449f;

    /* renamed from: g, reason: collision with root package name */
    private String f17450g;

    /* renamed from: h, reason: collision with root package name */
    private StreetNumber f17451h;

    /* renamed from: i, reason: collision with root package name */
    private String f17452i;

    /* renamed from: j, reason: collision with root package name */
    private String f17453j;

    /* renamed from: k, reason: collision with root package name */
    private String f17454k;

    /* renamed from: l, reason: collision with root package name */
    private List<RegeocodeRoad> f17455l;

    /* renamed from: m, reason: collision with root package name */
    private List<Crossroad> f17456m;

    /* renamed from: n, reason: collision with root package name */
    private List<PoiItem> f17457n;

    /* renamed from: o, reason: collision with root package name */
    private List<BusinessArea> f17458o;

    /* renamed from: p, reason: collision with root package name */
    private List<AoiItem> f17459p;

    /* renamed from: q, reason: collision with root package name */
    private String f17460q;

    /* renamed from: r, reason: collision with root package name */
    private String f17461r;

    public static class a implements Parcelable.Creator<RegeocodeAddress> {
        @Override // android.os.Parcelable.Creator
        public RegeocodeAddress createFromParcel(Parcel parcel) {
            return new RegeocodeAddress(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ RegeocodeAddress[] newArray(int i10) {
            return null;
        }
    }

    public /* synthetic */ RegeocodeAddress(Parcel parcel, a aVar) {
        this(parcel);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAdCode() {
        return this.f17453j;
    }

    public List<AoiItem> getAois() {
        return this.f17459p;
    }

    public String getBuilding() {
        return this.f17450g;
    }

    public List<BusinessArea> getBusinessAreas() {
        return this.f17458o;
    }

    public String getCity() {
        return this.f17446c;
    }

    public String getCityCode() {
        return this.f17452i;
    }

    public String getCountry() {
        return this.f17460q;
    }

    public String getCountryCode() {
        return this.f17461r;
    }

    public List<Crossroad> getCrossroads() {
        return this.f17456m;
    }

    public String getDistrict() {
        return this.f17447d;
    }

    public String getFormatAddress() {
        return this.f17444a;
    }

    public String getNeighborhood() {
        return this.f17449f;
    }

    public List<PoiItem> getPois() {
        return this.f17457n;
    }

    public String getProvince() {
        return this.f17445b;
    }

    public List<RegeocodeRoad> getRoads() {
        return this.f17455l;
    }

    public StreetNumber getStreetNumber() {
        return this.f17451h;
    }

    public String getTowncode() {
        return this.f17454k;
    }

    public String getTownship() {
        return this.f17448e;
    }

    public void setAdCode(String str) {
        this.f17453j = str;
    }

    public void setAois(List<AoiItem> list) {
        this.f17459p = list;
    }

    public void setBuilding(String str) {
        this.f17450g = str;
    }

    public void setBusinessAreas(List<BusinessArea> list) {
        this.f17458o = list;
    }

    public void setCity(String str) {
        this.f17446c = str;
    }

    public void setCityCode(String str) {
        this.f17452i = str;
    }

    public void setCountry(String str) {
        this.f17460q = str;
    }

    public void setCountryCode(String str) {
        this.f17461r = str;
    }

    public void setCrossroads(List<Crossroad> list) {
        this.f17456m = list;
    }

    public void setDistrict(String str) {
        this.f17447d = str;
    }

    public void setFormatAddress(String str) {
        this.f17444a = str;
    }

    public void setNeighborhood(String str) {
        this.f17449f = str;
    }

    public void setPois(List<PoiItem> list) {
        this.f17457n = list;
    }

    public void setProvince(String str) {
        this.f17445b = str;
    }

    public void setRoads(List<RegeocodeRoad> list) {
        this.f17455l = list;
    }

    public void setStreetNumber(StreetNumber streetNumber) {
        this.f17451h = streetNumber;
    }

    public void setTowncode(String str) {
        this.f17454k = str;
    }

    public void setTownship(String str) {
        this.f17448e = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f17444a);
        parcel.writeString(this.f17445b);
        parcel.writeString(this.f17446c);
        parcel.writeString(this.f17447d);
        parcel.writeString(this.f17448e);
        parcel.writeString(this.f17449f);
        parcel.writeString(this.f17450g);
        parcel.writeValue(this.f17451h);
        parcel.writeList(this.f17455l);
        parcel.writeList(this.f17456m);
        parcel.writeList(this.f17457n);
        parcel.writeString(this.f17452i);
        parcel.writeString(this.f17453j);
        parcel.writeList(this.f17458o);
        parcel.writeList(this.f17459p);
        parcel.writeString(this.f17454k);
        parcel.writeString(this.f17460q);
        parcel.writeString(this.f17461r);
    }

    public RegeocodeAddress() {
        this.f17455l = new ArrayList();
        this.f17456m = new ArrayList();
        this.f17457n = new ArrayList();
        this.f17458o = new ArrayList();
        this.f17459p = new ArrayList();
    }

    private RegeocodeAddress(Parcel parcel) {
        this.f17455l = new ArrayList();
        this.f17456m = new ArrayList();
        this.f17457n = new ArrayList();
        this.f17458o = new ArrayList();
        this.f17459p = new ArrayList();
        this.f17444a = parcel.readString();
        this.f17445b = parcel.readString();
        this.f17446c = parcel.readString();
        this.f17447d = parcel.readString();
        this.f17448e = parcel.readString();
        this.f17449f = parcel.readString();
        this.f17450g = parcel.readString();
        this.f17451h = (StreetNumber) parcel.readValue(StreetNumber.class.getClassLoader());
        this.f17455l = parcel.readArrayList(Road.class.getClassLoader());
        this.f17456m = parcel.readArrayList(Crossroad.class.getClassLoader());
        this.f17457n = parcel.readArrayList(PoiItem.class.getClassLoader());
        this.f17452i = parcel.readString();
        this.f17453j = parcel.readString();
        this.f17458o = parcel.readArrayList(BusinessArea.class.getClassLoader());
        this.f17459p = parcel.readArrayList(AoiItem.class.getClassLoader());
        this.f17454k = parcel.readString();
        this.f17460q = parcel.readString();
        this.f17461r = parcel.readString();
    }
}
