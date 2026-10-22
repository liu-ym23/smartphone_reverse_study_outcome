package com.amap.api.services.geocoder;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.road.Crossroad;
import com.amap.api.services.road.Road;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes28.dex */
public final class RegeocodeAddress implements Parcelable {
    public static final Parcelable.Creator<RegeocodeAddress> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f28920a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f28921b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f28922c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f28923d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f28924e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f28925f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f28926g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private StreetNumber f28927h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f28928i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f28929j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private String f28930k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private List<RegeocodeRoad> f28931l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private List<Crossroad> f28932m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private List<PoiItem> f28933n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private List<BusinessArea> f28934o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private List<AoiItem> f28935p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private String f28936q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private String f28937r;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    public RegeocodeAddress() {
        this.f28931l = new ArrayList();
        this.f28932m = new ArrayList();
        this.f28933n = new ArrayList();
        this.f28934o = new ArrayList();
        this.f28935p = new ArrayList();
    }

    public final String getAdCode() {
        return this.f28929j;
    }

    public final List<AoiItem> getAois() {
        return this.f28935p;
    }

    public final String getBuilding() {
        return this.f28926g;
    }

    public final List<BusinessArea> getBusinessAreas() {
        return this.f28934o;
    }

    public final String getCity() {
        return this.f28922c;
    }

    public final String getCityCode() {
        return this.f28928i;
    }

    public final String getCountry() {
        return this.f28936q;
    }

    public final String getCountryCode() {
        return this.f28937r;
    }

    public final List<Crossroad> getCrossroads() {
        return this.f28932m;
    }

    public final String getDistrict() {
        return this.f28923d;
    }

    public final String getFormatAddress() {
        return this.f28920a;
    }

    public final String getNeighborhood() {
        return this.f28925f;
    }

    public final List<PoiItem> getPois() {
        return this.f28933n;
    }

    public final String getProvince() {
        return this.f28921b;
    }

    public final List<RegeocodeRoad> getRoads() {
        return this.f28931l;
    }

    public final StreetNumber getStreetNumber() {
        return this.f28927h;
    }

    public final String getTowncode() {
        return this.f28930k;
    }

    public final String getTownship() {
        return this.f28924e;
    }

    private RegeocodeAddress(Parcel r100) {
        this.f28931l = new ArrayList();
        this.f28932m = new ArrayList();
        this.f28933n = new ArrayList();
        this.f28934o = new ArrayList();
        this.f28935p = new ArrayList();
        this.f28920a = r100.readString();
        this.f28921b = r100.readString();
        this.f28922c = r100.readString();
        this.f28923d = r100.readString();
        this.f28924e = r100.readString();
        this.f28925f = r100.readString();
        this.f28926g = r100.readString();
        this.f28927h = (StreetNumber) r100.readValue(StreetNumber.class.getClassLoader());
        this.f28931l = r100.readArrayList(Road.class.getClassLoader());
        this.f28932m = r100.readArrayList(Crossroad.class.getClassLoader());
        this.f28933n = r100.readArrayList(PoiItem.class.getClassLoader());
        this.f28928i = r100.readString();
        this.f28929j = r100.readString();
        this.f28934o = r100.readArrayList(BusinessArea.class.getClassLoader());
        this.f28935p = r100.readArrayList(AoiItem.class.getClassLoader());
        this.f28930k = r100.readString();
        this.f28936q = r100.readString();
        this.f28937r = r100.readString();
    }

    public final void setAdCode(String r100) {
        this.f28929j = r100;
    }

    public final void setAois(List<AoiItem> r100) {
        this.f28935p = r100;
    }

    public final void setBuilding(String r100) {
        this.f28926g = r100;
    }

    public final void setBusinessAreas(List<BusinessArea> r100) {
        this.f28934o = r100;
    }

    public final void setCity(String r100) {
        this.f28922c = r100;
    }

    public final void setCityCode(String r100) {
        this.f28928i = r100;
    }

    public final void setCountry(String r100) {
        this.f28936q = r100;
    }

    public final void setCountryCode(String r100) {
        this.f28937r = r100;
    }

    public final void setCrossroads(List<Crossroad> r100) {
        this.f28932m = r100;
    }

    public final void setDistrict(String r100) {
        this.f28923d = r100;
    }

    public final void setFormatAddress(String r100) {
        this.f28920a = r100;
    }

    public final void setNeighborhood(String r100) {
        this.f28925f = r100;
    }

    public final void setPois(List<PoiItem> r100) {
        this.f28933n = r100;
    }

    public final void setProvince(String r100) {
        this.f28921b = r100;
    }

    public final void setRoads(List<RegeocodeRoad> r100) {
        this.f28931l = r100;
    }

    public final void setStreetNumber(StreetNumber r100) {
        this.f28927h = r100;
    }

    public final void setTowncode(String r100) {
        this.f28930k = r100;
    }

    public final void setTownship(String r100) {
        this.f28924e = r100;
    }

    public /* synthetic */ RegeocodeAddress(Parcel r100, byte r101) {
        this(r100);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        r100.writeString(this.f28920a);
        r100.writeString(this.f28921b);
        r100.writeString(this.f28922c);
        r100.writeString(this.f28923d);
        r100.writeString(this.f28924e);
        r100.writeString(this.f28925f);
        r100.writeString(this.f28926g);
        r100.writeValue(this.f28927h);
        r100.writeList(this.f28931l);
        r100.writeList(this.f28932m);
        r100.writeList(this.f28933n);
        r100.writeString(this.f28928i);
        r100.writeString(this.f28929j);
        r100.writeList(this.f28934o);
        r100.writeList(this.f28935p);
        r100.writeString(this.f28930k);
        r100.writeString(this.f28936q);
        r100.writeString(this.f28937r);
    }
}
