package com.amap.api.col.jmsl;

import android.content.Context;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.nearby.UploadInfo;
import com.autonavi.aps.amapapi.config.Const;

/* loaded from: classes.dex */
public class Y0 extends Q1<UploadInfo, Integer> {

    /* renamed from: E, reason: collision with root package name */
    public Context f16482E;

    /* renamed from: F, reason: collision with root package name */
    public UploadInfo f16483F;

    public Y0(Context context, UploadInfo uploadInfo) {
        super(context, uploadInfo);
        this.f16482E = context;
        this.f16483F = uploadInfo;
    }

    @Override // com.amap.api.col.jmsl.I1
    public Object f(String str) throws AMapException {
        return 0;
    }

    @Override // com.amap.api.col.jmsl.s7
    public String getURL() {
        return T2.g(this.f16482E) + "/nearby/data/create";
    }

    @Override // com.amap.api.col.jmsl.Q1
    public String n() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("key=");
        stringBuffer.append(C1567j0.n(this.f16482E));
        stringBuffer.append("&userid=");
        stringBuffer.append(this.f16483F.getUserID());
        LatLonPoint point = this.f16483F.getPoint();
        int longitude = (int) (point.getLongitude() * 1000000.0d);
        int latitude = (int) (point.getLatitude() * 1000000.0d);
        stringBuffer.append("&location=");
        stringBuffer.append(longitude / 1000000.0f);
        stringBuffer.append(Const.STR_MART_COMMA);
        stringBuffer.append(latitude / 1000000.0f);
        stringBuffer.append("&coordtype=");
        stringBuffer.append(this.f16483F.getCoordType());
        return stringBuffer.toString();
    }
}
