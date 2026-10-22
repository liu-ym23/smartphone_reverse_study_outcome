package com.amap.api.fence;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.location.DPoint;
import java.util.List;

/* JADX INFO: loaded from: classes28.dex */
public class DistrictItem implements Parcelable {
    public static final Parcelable.Creator<DistrictItem> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f26655a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f26656b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f26657c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private List<DPoint> f26658d;

    static {
        CREATOR = new AnonymousClass1();
    }

    public DistrictItem() {
        this.f26655a = "";
        this.f26656b = null;
        this.f26657c = null;
        this.f26658d = null;
    }

    public DistrictItem(Parcel r100) {
        this.f26655a = "";
        this.f26656b = null;
        this.f26657c = null;
        this.f26658d = null;
        this.f26655a = r100.readString();
        this.f26656b = r100.readString();
        this.f26657c = r100.readString();
        this.f26658d = r100.createTypedArrayList(DPoint.CREATOR);
    }

    public static Parcelable.Creator<DistrictItem> getCreator() {
        return CREATOR;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAdcode() {
        return this.f26657c;
    }

    public String getCitycode() {
        return this.f26656b;
    }

    public String getDistrictName() {
        return this.f26655a;
    }

    public List<DPoint> getPolyline() {
        return this.f26658d;
    }

    public void setAdcode(String r100) {
        this.f26657c = r100;
    }

    public void setCitycode(String r100) {
        this.f26656b = r100;
    }

    public void setDistrictName(String r100) {
        this.f26655a = r100;
    }

    public void setPolyline(List<DPoint> r100) {
        this.f26658d = r100;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeString(this.f26655a);
        r100.writeString(this.f26656b);
        r100.writeString(this.f26657c);
        r100.writeTypedList(this.f26658d);
    }
}
