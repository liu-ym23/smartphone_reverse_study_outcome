package com.autonavi.aps.amapapi.filters;

import com.amap.api.location.AMapLocation;
import com.autonavi.aps.amapapi.config.Const;

/* loaded from: classes.dex */
public class FilterEntity {

    /* renamed from: a, reason: collision with root package name */
    double f18235a;

    /* renamed from: b, reason: collision with root package name */
    double f18236b;

    /* renamed from: c, reason: collision with root package name */
    long f18237c;

    /* renamed from: d, reason: collision with root package name */
    float f18238d;

    /* renamed from: e, reason: collision with root package name */
    float f18239e;

    /* renamed from: f, reason: collision with root package name */
    int f18240f;

    /* renamed from: g, reason: collision with root package name */
    String f18241g;

    public FilterEntity(AMapLocation aMapLocation, int i10) {
        this.f18235a = aMapLocation.getLatitude();
        this.f18236b = aMapLocation.getLongitude();
        this.f18237c = aMapLocation.getTime();
        this.f18238d = aMapLocation.getAccuracy();
        this.f18239e = aMapLocation.getSpeed();
        this.f18240f = i10;
        this.f18241g = aMapLocation.getProvider();
    }

    public boolean equals(Object obj) {
        try {
            if (!(obj instanceof FilterEntity)) {
                return false;
            }
            FilterEntity filterEntity = (FilterEntity) obj;
            if (this.f18235a == filterEntity.f18235a && this.f18236b == filterEntity.f18236b) {
                return this.f18240f == filterEntity.f18240f;
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    public int hashCode() {
        return Double.valueOf(this.f18235a).hashCode() + Double.valueOf(this.f18236b).hashCode() + this.f18240f;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.f18235a);
        stringBuffer.append(Const.STR_MART_COMMA);
        stringBuffer.append(this.f18236b);
        stringBuffer.append(Const.STR_MART_COMMA);
        stringBuffer.append(this.f18238d);
        stringBuffer.append(Const.STR_MART_COMMA);
        stringBuffer.append(this.f18237c);
        stringBuffer.append(Const.STR_MART_COMMA);
        stringBuffer.append(this.f18239e);
        stringBuffer.append(Const.STR_MART_COMMA);
        stringBuffer.append(this.f18240f);
        stringBuffer.append(Const.STR_MART_COMMA);
        stringBuffer.append(this.f18241g);
        return stringBuffer.toString();
    }
}
