package com.baidu.mapapi.search.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.model.LatLng;

/* loaded from: classes.dex */
public class PlanNode implements Parcelable {
    public static final Parcelable.Creator<PlanNode> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private LatLng f7526a;

    /* renamed from: b, reason: collision with root package name */
    private String f7527b;

    /* renamed from: c, reason: collision with root package name */
    private String f7528c;

    /* renamed from: d, reason: collision with root package name */
    private String f7529d;

    /* renamed from: e, reason: collision with root package name */
    private String f7530e;

    /* renamed from: f, reason: collision with root package name */
    private String f7531f;

    /* renamed from: g, reason: collision with root package name */
    private String f7532g;

    /* renamed from: h, reason: collision with root package name */
    private String f7533h;

    public static class a implements Parcelable.Creator<PlanNode> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PlanNode createFromParcel(Parcel parcel) {
            return new PlanNode(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PlanNode[] newArray(int i4) {
            return new PlanNode[i4];
        }
    }

    public PlanNode(LatLng latLng, String str, String str2, String str3) {
        this.f7527b = null;
        this.f7530e = null;
        this.f7531f = null;
        this.f7532g = null;
        this.f7533h = null;
        this.f7526a = latLng;
        this.f7529d = str;
        this.f7528c = str2;
        if (str2 != null) {
            this.f7527b = str2;
        }
        if (str != null) {
            this.f7527b = str;
        }
        this.f7530e = str3;
    }

    public static PlanNode withCityCodeAndLocation(String str, LatLng latLng) {
        return new PlanNode(latLng, null, str, null);
    }

    public static PlanNode withCityCodeAndPlaceName(int i4, String str) {
        return new PlanNode(null, null, String.valueOf(i4), str);
    }

    public static PlanNode withCityCodeAndPlaceNameAndPoiId(int i4, String str, String str2) {
        return new PlanNode(null, null, String.valueOf(i4), str, str2);
    }

    public static PlanNode withCityNameAndPlaceName(String str, String str2) {
        return new PlanNode(null, str, null, str2);
    }

    public static PlanNode withCityNameAndPlaceNameAndPoiId(String str, String str2, String str3) {
        return new PlanNode(null, str, null, str2, str3);
    }

    public static PlanNode withLocation(LatLng latLng) {
        return new PlanNode(latLng, null, null, null);
    }

    public static PlanNode withLocationAndFloorAndBid(LatLng latLng, String str, String str2) {
        return new PlanNode(latLng, null, null, null, str, str2);
    }

    public static PlanNode withLocationAndPoiId(LatLng latLng, String str) {
        return new PlanNode(latLng, null, null, null, str);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getBid() {
        return this.f7532g;
    }

    public String getCity() {
        return this.f7527b;
    }

    public String getCityCode() {
        return this.f7528c;
    }

    public String getCityName() {
        return this.f7529d;
    }

    public String getFloor() {
        return this.f7533h;
    }

    public LatLng getLocation() {
        return this.f7526a;
    }

    public String getName() {
        return this.f7530e;
    }

    public String getPoiId() {
        return this.f7531f;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeValue(this.f7526a);
        parcel.writeString(this.f7527b);
        parcel.writeString(this.f7530e);
    }

    public PlanNode(LatLng latLng, String str, String str2, String str3, String str4, String str5) {
        this.f7527b = null;
        this.f7530e = null;
        this.f7531f = null;
        this.f7532g = null;
        this.f7533h = null;
        this.f7526a = latLng;
        this.f7529d = str;
        this.f7528c = str2;
        if (str2 != null) {
            this.f7527b = str2;
        }
        if (str != null) {
            this.f7527b = str;
        }
        this.f7530e = str3;
        this.f7533h = str4;
        this.f7532g = str5;
    }

    public PlanNode(LatLng latLng, String str, String str2, String str3, String str4) {
        this.f7527b = null;
        this.f7530e = null;
        this.f7531f = null;
        this.f7532g = null;
        this.f7533h = null;
        this.f7526a = latLng;
        this.f7529d = str;
        this.f7528c = str2;
        if (str2 != null) {
            this.f7527b = str2;
        }
        if (str != null) {
            this.f7527b = str;
        }
        this.f7530e = str3;
        this.f7531f = str4;
    }

    public PlanNode(Parcel parcel) {
        this.f7526a = null;
        this.f7527b = null;
        this.f7528c = null;
        this.f7529d = null;
        this.f7530e = null;
        this.f7531f = null;
        this.f7532g = null;
        this.f7533h = null;
        this.f7526a = (LatLng) parcel.readValue(LatLng.class.getClassLoader());
        this.f7527b = parcel.readString();
        this.f7530e = parcel.readString();
    }
}
