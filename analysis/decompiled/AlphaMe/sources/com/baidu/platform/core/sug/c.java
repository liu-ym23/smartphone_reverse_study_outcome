package com.baidu.platform.core.sug;

import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.http.wrapper.annotation.BodyData;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.base.LanguageType;
import com.baidu.mapapi.search.sug.SuggestionSearchOption;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;
import com.baidu.platform.comapi.map.MapController;

/* loaded from: classes.dex */
public class c extends com.baidu.platform.base.c {
    public c(SuggestionSearchOption suggestionSearchOption) {
        a(suggestionSearchOption);
    }

    private void a(SuggestionSearchOption suggestionSearchOption) {
        this.f8580d.a("query", suggestionSearchOption.mKeyword);
        this.f8580d.a("region", suggestionSearchOption.mCity);
        LatLng latLng = suggestionSearchOption.mLocation;
        if (latLng != null) {
            LatLng latLng2 = new LatLng(latLng.latitude, latLng.longitude);
            if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
                latLng2 = CoordTrans.gcjToBaidu(latLng2);
            }
            this.f8580d.a(MapController.LOCATION_LAYER_TAG, latLng2.latitude + "," + latLng2.longitude);
        }
        if (suggestionSearchOption.mCityLimit.booleanValue()) {
            this.f8580d.a("city_limit", "true");
        } else {
            this.f8580d.a("city_limit", "false");
        }
        if (suggestionSearchOption.mLanguageType == LanguageType.LanguageTypeEnglish) {
            this.f8580d.a("language", "en");
        }
        if (suggestionSearchOption.mHotWord) {
            this.f8580d.a("hotword", "true");
        } else {
            this.f8580d.a("hotword", "false");
        }
        this.f8580d.a("from", "android_map_sdk");
        this.f8580d.a("output", BodyData.TYPE_JSON);
        this.f8580d.a("extensions_adcode", suggestionSearchOption.isExtendAdcode() ? "true" : "false");
    }

    @Override // com.baidu.platform.base.c
    public String a(com.baidu.platform.domain.b bVar) {
        return bVar.l();
    }
}
