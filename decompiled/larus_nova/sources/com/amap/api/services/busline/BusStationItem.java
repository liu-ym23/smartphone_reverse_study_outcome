package com.amap.api.services.busline;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes28.dex */
public class BusStationItem implements Parcelable {
    public static final Parcelable.Creator<BusStationItem> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f28782a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f28783b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private LatLonPoint f28784c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f28785d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f28786e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private List<BusLineItem> f28787f;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    public int hashCode() {
        String r100 = this.f28782a;
        if (r100 != null) goto L5;
        int r101 = 0;
    L7:
        return r101 + 31;
    L5:
        r101 = r100.hashCode();
        goto L7
    }

    public String toString() {
        return "BusStationName: " + this.f28783b + " LatLonPoint: " + this.f28784c.toString() + " BusLines: " + a(this.f28787f) + " CityCode: " + this.f28785d + " AdCode: " + this.f28786e;
    }

    public BusStationItem() {
        this.f28787f = new ArrayList();
    }

    public String getAdCode() {
        return this.f28786e;
    }

    public List<BusLineItem> getBusLineItems() {
        return this.f28787f;
    }

    public String getBusStationId() {
        return this.f28782a;
    }

    public String getBusStationName() {
        return this.f28783b;
    }

    public String getCityCode() {
        return this.f28785d;
    }

    public LatLonPoint getLatLonPoint() {
        return this.f28784c;
    }

    private BusStationItem(Parcel r100) {
        this.f28787f = new ArrayList();
        this.f28783b = r100.readString();
        this.f28782a = r100.readString();
        this.f28784c = (LatLonPoint) r100.readValue(LatLonPoint.class.getClassLoader());
        this.f28785d = r100.readString();
        this.f28786e = r100.readString();
        this.f28787f = r100.readArrayList(BusLineItem.class.getClassLoader());
    }

    private static String a(List<BusLineItem> r100) {
        StringBuffer r101 = new StringBuffer();
        if (r100 == null) goto L12;
        int r102 = 0;
    L6:
        if (r102 >= r100.size()) goto L12;
        r101.append(((BusLineItem) ListProtector.get(r100, r102)).getBusLineName());
        if (r102 >= (r100.size() - 1)) goto L10;
        r101.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
    L10:
        r102 = r102 + 1;
    L12:
        return r101.toString();
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
        BusStationItem r101 = (BusStationItem) r100;
        String r102 = this.f28782a;
        if (r102 != null) goto L17;
        if (r101.f28782a == null) goto L19;
        return false;
    L19:
        return true;
    L17:
        if (r102.equals(r101.f28782a) == true) goto L19;
        return false;
    }

    public void setAdCode(String r100) {
        this.f28786e = r100;
    }

    public void setBusLineItems(List<BusLineItem> r100) {
        this.f28787f = r100;
    }

    public void setBusStationId(String r100) {
        this.f28782a = r100;
    }

    public void setBusStationName(String r100) {
        this.f28783b = r100;
    }

    public void setCityCode(String r100) {
        this.f28785d = r100;
    }

    public void setLatLonPoint(LatLonPoint r100) {
        this.f28784c = r100;
    }

    public /* synthetic */ BusStationItem(Parcel r100, byte r101) {
        this(r100);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeString(this.f28783b);
        r100.writeString(this.f28782a);
        r100.writeValue(this.f28784c);
        r100.writeString(this.f28785d);
        r100.writeString(this.f28786e);
        r100.writeList(this.f28787f);
    }
}
