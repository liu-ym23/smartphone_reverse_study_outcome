package com.amap.api.services.geocoder;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;

/* JADX INFO: loaded from: classes28.dex */
public class AoiItem implements Parcelable {
    public static final Parcelable.Creator<AoiItem> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f28895a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f28896b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f28897c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private LatLonPoint f28898d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Float f28899e;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    public AoiItem() {
    }

    public String getAdCode() {
        return this.f28897c;
    }

    public Float getAoiArea() {
        return this.f28899e;
    }

    public LatLonPoint getAoiCenterPoint() {
        return this.f28898d;
    }

    public String getAoiId() {
        return this.f28895a;
    }

    public String getAoiName() {
        return this.f28896b;
    }

    public AoiItem(Parcel r100) {
        this.f28895a = r100.readString();
        this.f28896b = r100.readString();
        this.f28897c = r100.readString();
        this.f28898d = (LatLonPoint) r100.readParcelable(LatLonPoint.class.getClassLoader());
        this.f28899e = Float.valueOf(r100.readFloat());
    }

    public void setAdcode(String r100) {
        this.f28897c = r100;
    }

    public void setArea(Float r100) {
        this.f28899e = r100;
    }

    public void setId(String r100) {
        this.f28895a = r100;
    }

    public void setLocation(LatLonPoint r100) {
        this.f28898d = r100;
    }

    public void setName(String r100) {
        this.f28896b = r100;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeString(this.f28895a);
        r100.writeString(this.f28896b);
        r100.writeString(this.f28897c);
        r100.writeParcelable(this.f28898d, r101);
        r100.writeFloat(this.f28899e.floatValue());
    }
}
