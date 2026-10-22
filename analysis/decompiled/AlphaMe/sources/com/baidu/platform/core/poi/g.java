package com.baidu.platform.core.poi;

import android.text.TextUtils;
import ch.qos.logback.core.joran.action.Action;
import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.http.wrapper.annotation.BodyData;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.LatLngBounds;
import com.baidu.mapapi.search.base.InputLanguageType;
import com.baidu.mapapi.search.base.LanguageType;
import com.baidu.mapapi.search.poi.PoiBoundSearchOption;
import com.baidu.mapapi.search.poi.PoiCitySearchOption;
import com.baidu.mapapi.search.poi.PoiFilter;
import com.baidu.mapapi.search.poi.PoiNearbySearchOption;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;
import com.baidu.platform.comapi.map.MapController;

/* loaded from: classes.dex */
public class g extends com.baidu.platform.base.c {
    public g(PoiNearbySearchOption poiNearbySearchOption) {
        a(poiNearbySearchOption);
    }

    private void a(PoiNearbySearchOption poiNearbySearchOption) {
        PoiFilter poiFilter;
        if (poiNearbySearchOption == null) {
            return;
        }
        this.f8580d.a("query", poiNearbySearchOption.mKeyword);
        if (poiNearbySearchOption.mLanguageType == LanguageType.LanguageTypeEnglish) {
            this.f8580d.a("language", "en");
        }
        InputLanguageType inputLanguageType = poiNearbySearchOption.mInputLanguageType;
        if (inputLanguageType != null) {
            this.f8580d.a("from_language", inputLanguageType.getValue());
        }
        LatLng latLng = poiNearbySearchOption.mLocation;
        if (latLng != null) {
            LatLng latLng2 = new LatLng(latLng.latitude, latLng.longitude);
            if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
                latLng2 = CoordTrans.gcjToBaidu(latLng2);
            }
            if (latLng2 != null) {
                this.f8580d.a(MapController.LOCATION_LAYER_TAG, latLng2.latitude + "," + latLng2.longitude);
            }
        }
        this.f8580d.a("photo_show", poiNearbySearchOption.isShowPhoto() ? "true" : "false");
        this.f8580d.a("radius", poiNearbySearchOption.mRadius + "");
        this.f8580d.a("output", BodyData.TYPE_JSON);
        this.f8580d.a("extensions_adcode", poiNearbySearchOption.isExtendAdcode() ? "true" : "false");
        this.f8580d.a("page_num", poiNearbySearchOption.mPageNum + "");
        this.f8580d.a("page_size", poiNearbySearchOption.mPageCapacity + "");
        this.f8580d.a(Action.SCOPE_ATTRIBUTE, poiNearbySearchOption.mScope + "");
        this.f8580d.a("tag", poiNearbySearchOption.mTag);
        if (poiNearbySearchOption.mRadiusLimit) {
            this.f8580d.a("radius_limit", "true");
        } else {
            this.f8580d.a("radius_limit", "false");
        }
        if (poiNearbySearchOption.mScope == 2 && (poiFilter = poiNearbySearchOption.mPoiFilter) != null && !TextUtils.isEmpty(poiFilter.toString())) {
            this.f8580d.a("filter", poiNearbySearchOption.mPoiFilter.toString());
        }
        if (poiNearbySearchOption.isExtendChildPoi()) {
            this.f8580d.a("extensions_child_poi", "true");
        } else {
            this.f8580d.a("extensions_child_poi", "false");
        }
        this.f8579c = poiNearbySearchOption.getCustomExtra();
    }

    public g(PoiCitySearchOption poiCitySearchOption) {
        a(poiCitySearchOption);
    }

    public g(PoiBoundSearchOption poiBoundSearchOption) {
        a(poiBoundSearchOption);
    }

    private void a(PoiCitySearchOption poiCitySearchOption) {
        PoiFilter poiFilter;
        if (poiCitySearchOption == null) {
            return;
        }
        this.f8580d.a("query", poiCitySearchOption.mKeyword);
        if (poiCitySearchOption.mLanguageType == LanguageType.LanguageTypeEnglish) {
            this.f8580d.a("language", "en");
        }
        InputLanguageType inputLanguageType = poiCitySearchOption.mInputLanguageType;
        if (inputLanguageType != null) {
            this.f8580d.a("from_language", inputLanguageType.getValue());
        }
        this.f8580d.a("photo_show", poiCitySearchOption.isShowPhoto() ? "true" : "false");
        this.f8580d.a("region", poiCitySearchOption.mCity);
        this.f8580d.a("output", BodyData.TYPE_JSON);
        this.f8580d.a("extensions_adcode", poiCitySearchOption.isExtendAdcode() ? "true" : "false");
        this.f8580d.a("page_num", poiCitySearchOption.mPageNum + "");
        this.f8580d.a("page_size", poiCitySearchOption.mPageCapacity + "");
        this.f8580d.a(Action.SCOPE_ATTRIBUTE, poiCitySearchOption.mScope + "");
        this.f8580d.a("tag", poiCitySearchOption.mTag);
        if (poiCitySearchOption.getCenter() != null) {
            LatLng latLng = new LatLng(poiCitySearchOption.getCenter().latitude, poiCitySearchOption.getCenter().longitude);
            if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
                latLng = CoordTrans.gcjToBaidu(latLng);
            }
            if (latLng != null) {
                this.f8580d.a("center", latLng.latitude + "," + latLng.longitude);
            }
        }
        if (poiCitySearchOption.getViewBound() != null && poiCitySearchOption.getViewBound().southwest != null && poiCitySearchOption.getViewBound().northeast != null) {
            LatLng latLng2 = new LatLng(poiCitySearchOption.getViewBound().southwest.latitude, poiCitySearchOption.getViewBound().southwest.longitude);
            LatLng latLng3 = new LatLng(poiCitySearchOption.getViewBound().northeast.latitude, poiCitySearchOption.getViewBound().northeast.longitude);
            if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
                latLng2 = CoordTrans.gcjToBaidu(latLng2);
                latLng3 = CoordTrans.gcjToBaidu(latLng3);
            }
            if (latLng2 != null && latLng3 != null) {
                this.f8580d.a("view_bound", latLng2.latitude + "," + latLng2.longitude + "," + latLng3.latitude + "," + latLng3.longitude);
            }
        }
        if (poiCitySearchOption.getSearchBound() != null && poiCitySearchOption.getSearchBound().southwest != null && poiCitySearchOption.getSearchBound().northeast != null) {
            LatLng latLng4 = new LatLng(poiCitySearchOption.getSearchBound().southwest.latitude, poiCitySearchOption.getSearchBound().southwest.longitude);
            LatLng latLng5 = new LatLng(poiCitySearchOption.getSearchBound().northeast.latitude, poiCitySearchOption.getSearchBound().northeast.longitude);
            if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
                latLng4 = CoordTrans.gcjToBaidu(latLng4);
                latLng5 = CoordTrans.gcjToBaidu(latLng5);
            }
            if (latLng4 != null && latLng5 != null) {
                this.f8580d.a("search_bound", latLng4.latitude + "," + latLng4.longitude + "," + latLng5.latitude + "," + latLng5.longitude);
            }
        }
        if (poiCitySearchOption.getFilterDistance() > 0) {
            this.f8580d.a("view_distance", poiCitySearchOption.getFilterDistance() + "");
        }
        if (poiCitySearchOption.mIsCityLimit) {
            this.f8580d.a("city_limit", "true");
        } else {
            this.f8580d.a("city_limit", "false");
        }
        if (poiCitySearchOption.mScope == 2 && (poiFilter = poiCitySearchOption.mPoiFilter) != null && !TextUtils.isEmpty(poiFilter.toString())) {
            this.f8580d.a("filter", poiCitySearchOption.mPoiFilter.toString());
        }
        if (poiCitySearchOption.isExtendChildPoi()) {
            this.f8580d.a("extensions_child_poi", "true");
        } else {
            this.f8580d.a("extensions_child_poi", "false");
        }
        this.f8579c = poiCitySearchOption.getCustomExtra();
    }

    private void a(PoiBoundSearchOption poiBoundSearchOption) {
        PoiFilter poiFilter;
        LatLng latLng;
        if (poiBoundSearchOption == null) {
            return;
        }
        this.f8580d.a("query", poiBoundSearchOption.mKeyword);
        if (poiBoundSearchOption.mLanguageType == LanguageType.LanguageTypeEnglish) {
            this.f8580d.a("language", "en");
        }
        InputLanguageType inputLanguageType = poiBoundSearchOption.mInputLanguageType;
        if (inputLanguageType != null) {
            this.f8580d.a("from_language", inputLanguageType.getValue());
        }
        this.f8580d.a("photo_show", poiBoundSearchOption.isShowPhoto() ? "true" : "false");
        this.f8580d.a("tag", poiBoundSearchOption.mTag);
        LatLngBounds latLngBounds = poiBoundSearchOption.mBound;
        if (latLngBounds != null && (latLng = latLngBounds.southwest) != null && latLngBounds.northeast != null) {
            LatLng latLng2 = new LatLng(latLng.latitude, latLng.longitude);
            LatLng latLng3 = poiBoundSearchOption.mBound.northeast;
            LatLng latLng4 = new LatLng(latLng3.latitude, latLng3.longitude);
            if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
                latLng2 = CoordTrans.gcjToBaidu(latLng2);
                latLng4 = CoordTrans.gcjToBaidu(latLng4);
            }
            if (latLng2 != null && latLng4 != null) {
                this.f8580d.a("bounds", latLng2.latitude + "," + latLng2.longitude + "," + latLng4.latitude + "," + latLng4.longitude);
            }
        }
        this.f8580d.a("output", BodyData.TYPE_JSON);
        this.f8580d.a("extensions_adcode", poiBoundSearchOption.isExtendAdcode() ? "true" : "false");
        this.f8580d.a(Action.SCOPE_ATTRIBUTE, poiBoundSearchOption.mScope + "");
        this.f8580d.a("page_num", poiBoundSearchOption.mPageNum + "");
        this.f8580d.a("page_size", poiBoundSearchOption.mPageCapacity + "");
        if (poiBoundSearchOption.mScope == 2 && (poiFilter = poiBoundSearchOption.mPoiFilter) != null && !TextUtils.isEmpty(poiFilter.toString())) {
            this.f8580d.a("filter", poiBoundSearchOption.mPoiFilter.toString());
        }
        if (poiBoundSearchOption.isExtendChildPoi()) {
            this.f8580d.a("extensions_child_poi", "true");
        } else {
            this.f8580d.a("extensions_child_poi", "false");
        }
        this.f8579c = poiBoundSearchOption.getCustomExtra();
    }

    @Override // com.baidu.platform.base.c
    public String a(com.baidu.platform.domain.b bVar) {
        return bVar.u();
    }
}
