package com.baidu.platform.core.aoi;

import android.text.TextUtils;
import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.http.wrapper.annotation.BodyData;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.aoi.AoiSearchOption;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class c extends com.baidu.platform.base.c {
    public c(AoiSearchOption aoiSearchOption) {
        a(aoiSearchOption);
    }

    private void a(AoiSearchOption aoiSearchOption) {
        if (aoiSearchOption == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        ArrayList<LatLng> latLngList = aoiSearchOption.getLatLngList();
        if (latLngList != null && latLngList.size() > 0) {
            for (int i4 = 0; i4 < latLngList.size(); i4++) {
                LatLng latLngGcjToBaidu = latLngList.get(i4);
                if (latLngGcjToBaidu != null) {
                    if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
                        latLngGcjToBaidu = CoordTrans.gcjToBaidu(latLngGcjToBaidu);
                    }
                    sb.append(latLngGcjToBaidu.longitude);
                    sb.append(",");
                    sb.append(latLngGcjToBaidu.latitude);
                    if (latLngList.size() - 1 == i4) {
                        break;
                    } else {
                        sb.append(";");
                    }
                }
            }
        }
        String string = sb.toString();
        if (TextUtils.isEmpty(string)) {
            return;
        }
        this.f8580d.a("locations", string);
        this.f8580d.a("coordtype", "bd09ll");
        this.f8580d.a("from", "android_map_sdk");
        this.f8580d.a("output", BodyData.TYPE_JSON);
    }

    @Override // com.baidu.platform.base.c
    public String a(com.baidu.platform.domain.b bVar) {
        return bVar.t();
    }
}
