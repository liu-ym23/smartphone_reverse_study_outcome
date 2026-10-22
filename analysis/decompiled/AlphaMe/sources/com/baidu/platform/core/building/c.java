package com.baidu.platform.core.building;

import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.http.wrapper.annotation.BodyData;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.building.BuildingSearchOption;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;
import com.stepos.alphame.suggest.AppSuggestStorable;

/* loaded from: classes.dex */
public class c extends com.baidu.platform.base.c {
    public c(BuildingSearchOption buildingSearchOption) {
        a(buildingSearchOption);
    }

    private void a(BuildingSearchOption buildingSearchOption) {
        if (buildingSearchOption == null) {
            return;
        }
        LatLng latLng = buildingSearchOption.getLatLng();
        if (latLng != null) {
            if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
                latLng = CoordTrans.gcjToBaidu(latLng);
            }
            this.f8580d.a(AppSuggestStorable.COLUMN_LATITUDE, latLng.latitude + "");
            this.f8580d.a(AppSuggestStorable.COLUMN_LONGITUDE, latLng.longitude + "");
        }
        this.f8580d.a("coord_type", "bd09ll");
        this.f8580d.a("from", "android_map_sdk");
        this.f8580d.a("output", BodyData.TYPE_JSON);
        this.f8580d.a("data_set", "building");
    }

    @Override // com.baidu.platform.base.c
    public String a(com.baidu.platform.domain.b bVar) {
        return bVar.e();
    }
}
