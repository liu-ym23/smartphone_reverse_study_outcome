package com.baidu.platform.core.geocode;

import android.text.TextUtils;
import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.base.LanguageType;
import com.baidu.mapapi.search.geocode.ReverseGeoCodeOption;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;
import com.baidu.platform.comapi.map.MapController;

/* loaded from: classes.dex */
public class e extends com.baidu.platform.base.c {
    public e(ReverseGeoCodeOption reverseGeoCodeOption) {
        a(reverseGeoCodeOption);
    }

    private void a(ReverseGeoCodeOption reverseGeoCodeOption) {
        if (reverseGeoCodeOption.getLocation() != null) {
            LatLng latLng = new LatLng(reverseGeoCodeOption.getLocation().latitude, reverseGeoCodeOption.getLocation().longitude);
            if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
                latLng = CoordTrans.gcjToBaidu(latLng);
            }
            this.f8580d.a(MapController.LOCATION_LAYER_TAG, latLng.latitude + "," + latLng.longitude);
        }
        if (reverseGeoCodeOption.getLanguage() == LanguageType.LanguageTypeEnglish) {
            this.f8580d.a("language", "en");
        } else {
            this.f8580d.a("language", "zh-CN");
        }
        this.f8580d.a("coordtype", "bd09ll");
        this.f8580d.a("page_index", String.valueOf(reverseGeoCodeOption.getPageNum()));
        this.f8580d.a("page_size", String.valueOf(reverseGeoCodeOption.getPageSize()));
        this.f8580d.a("pois", "1");
        this.f8580d.a("extensions_poi", "1");
        this.f8580d.a("extensions_town", "true");
        if (reverseGeoCodeOption.getExtensionsRoad()) {
            this.f8580d.a("extensions_road", "true");
        } else {
            this.f8580d.a("extensions_road", "false");
        }
        String poiType = reverseGeoCodeOption.getPoiType();
        if (!TextUtils.isEmpty(poiType)) {
            this.f8580d.a("poi_types", poiType);
        }
        this.f8580d.a("output", "jsonaes");
        this.f8580d.a("from", "android_map_sdk");
        this.f8580d.a("latest_admin", String.valueOf(reverseGeoCodeOption.getLatestAdmin()));
        this.f8580d.a("radius", String.valueOf(reverseGeoCodeOption.getRadius()));
    }

    @Override // com.baidu.platform.base.c
    public String a(com.baidu.platform.domain.b bVar) {
        return bVar.s();
    }
}
