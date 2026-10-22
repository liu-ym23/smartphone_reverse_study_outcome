package com.amap.api.services.geocoder;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;

/* JADX INFO: loaded from: classes28.dex */
public final class GeocodeAddress implements Parcelable {
    public static final Parcelable.Creator<GeocodeAddress> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f28902a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f28903b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f28904c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f28905d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f28906e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f28907f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f28908g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f28909h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private LatLonPoint f28910i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f28911j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private String f28912k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private String f28913l;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    public GeocodeAddress() {
    }

    public final String getAdcode() {
        return this.f28909h;
    }

    public final String getBuilding() {
        return this.f28908g;
    }

    public final String getCity() {
        return this.f28904c;
    }

    public final String getCountry() {
        return this.f28912k;
    }

    public final String getDistrict() {
        return this.f28905d;
    }

    public final String getFormatAddress() {
        return this.f28902a;
    }

    public final LatLonPoint getLatLonPoint() {
        return this.f28910i;
    }

    public final String getLevel() {
        return this.f28911j;
    }

    public final String getNeighborhood() {
        return this.f28907f;
    }

    public final String getPostcode() {
        return this.f28913l;
    }

    public final String getProvince() {
        return this.f28903b;
    }

    public final String getTownship() {
        return this.f28906e;
    }

    private GeocodeAddress(Parcel r100) {
        this.f28902a = r100.readString();
        this.f28903b = r100.readString();
        this.f28904c = r100.readString();
        this.f28905d = r100.readString();
        this.f28906e = r100.readString();
        this.f28907f = r100.readString();
        this.f28908g = r100.readString();
        this.f28909h = r100.readString();
        this.f28910i = (LatLonPoint) r100.readValue(LatLonPoint.class.getClassLoader());
        this.f28911j = r100.readString();
        this.f28912k = r100.readString();
        this.f28913l = r100.readString();
    }

    public final void setAdcode(String r100) {
        this.f28909h = r100;
    }

    public final void setBuilding(String r100) {
        this.f28908g = r100;
    }

    public final void setCity(String r100) {
        this.f28904c = r100;
    }

    public final void setCountry(String r100) {
        this.f28912k = r100;
    }

    public final void setDistrict(String r100) {
        this.f28905d = r100;
    }

    public final void setFormatAddress(String r100) {
        this.f28902a = r100;
    }

    public final void setLatLonPoint(LatLonPoint r100) {
        this.f28910i = r100;
    }

    public final void setLevel(String r100) {
        this.f28911j = r100;
    }

    public final void setNeighborhood(String r100) {
        this.f28907f = r100;
    }

    public final void setPostcode(String r100) {
        this.f28913l = r100;
    }

    public final void setProvince(String r100) {
        this.f28903b = r100;
    }

    public final void setTownship(String r100) {
        this.f28906e = r100;
    }

    public /* synthetic */ GeocodeAddress(Parcel r100, byte r101) {
        this(r100);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        r100.writeString(this.f28902a);
        r100.writeString(this.f28903b);
        r100.writeString(this.f28904c);
        r100.writeString(this.f28905d);
        r100.writeString(this.f28906e);
        r100.writeString(this.f28907f);
        r100.writeString(this.f28908g);
        r100.writeString(this.f28909h);
        r100.writeValue(this.f28910i);
        r100.writeString(this.f28911j);
        r100.writeString(this.f28912k);
        r100.writeString(this.f28913l);
    }
}
