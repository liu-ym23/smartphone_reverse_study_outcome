package com.baidu.platform.core.recommendstop;

import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.http.wrapper.annotation.BodyData;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.recommendstop.RecommendStopSearchOption;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;
import com.baidu.platform.comapi.map.MapController;

/* loaded from: classes.dex */
public class c extends com.baidu.platform.base.c {
    public c(RecommendStopSearchOption recommendStopSearchOption) {
        a(recommendStopSearchOption);
    }

    private void a(RecommendStopSearchOption recommendStopSearchOption) {
        if (recommendStopSearchOption != null && recommendStopSearchOption.mLocation != null) {
            LatLng latLng = new LatLng(recommendStopSearchOption.getLocation().latitude, recommendStopSearchOption.getLocation().longitude);
            if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
                latLng = CoordTrans.gcjToBaidu(latLng);
            }
            this.f8580d.a(MapController.LOCATION_LAYER_TAG, latLng.longitude + "," + latLng.latitude);
            this.f8580d.a("station_info", recommendStopSearchOption.isNeedStationInfo() ? "1" : "0");
        }
        this.f8580d.a("coordtype", "bd09ll");
        this.f8580d.a("from", "android_map_sdk");
        this.f8580d.a("output", BodyData.TYPE_JSON);
    }

    @Override // com.baidu.platform.base.c
    public String a(com.baidu.platform.domain.b bVar) {
        return bVar.d();
    }
}
