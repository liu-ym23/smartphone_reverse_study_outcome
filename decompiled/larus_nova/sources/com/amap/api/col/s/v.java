package com.amap.api.col.s;

import android.content.Context;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.nearby.UploadInfo;

/* JADX INFO: loaded from: classes28.dex */
public final class v extends b<UploadInfo, Integer> {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Context f26645j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private UploadInfo f26646k;

    @Override // com.amap.api.col.s.b, com.amap.api.col.s.a
    public final String a() {
        StringBuffer r100 = new StringBuffer("key=");
        r100.append(bi.f(this.f26645j));
        r100.append("&userid=");
        r100.append(this.f26646k.getUserID());
        LatLonPoint r101 = this.f26646k.getPoint();
        int r102 = (int) (r101.getLongitude() * 1000000.0d);
        int r103 = (int) (r101.getLatitude() * 1000000.0d);
        r100.append("&location=");
        r100.append(r102 / 1000000.0f);
        r100.append(",");
        r100.append(r103 / 1000000.0f);
        r100.append("&coordtype=");
        r100.append(this.f26646k.getCoordType());
        return r100.toString();
    }

    @Override // com.amap.api.col.s.cy
    public final String h() {
        return h.c() + "/nearby/data/create";
    }

    @Override // com.amap.api.col.s.b, com.amap.api.col.s.a
    public final /* synthetic */ Object a(String r100) throws AMapException {
        return 0;
    }

    public v(Context r100, UploadInfo r101) {
        super(r100, r101);
        this.f26645j = r100;
        this.f26646k = r101;
    }
}
