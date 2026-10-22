package com.baidu.platform.core.route;

import android.text.TextUtils;
import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.http.wrapper.annotation.BodyData;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.base.LanguageType;
import com.baidu.mapapi.search.route.MassTransitRoutePlanOption;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;

/* loaded from: classes.dex */
public class j extends com.baidu.platform.base.c {
    public j(MassTransitRoutePlanOption massTransitRoutePlanOption) {
        a(massTransitRoutePlanOption);
    }

    private void a(MassTransitRoutePlanOption massTransitRoutePlanOption) {
        LatLng location = massTransitRoutePlanOption.mFrom.getLocation();
        if (location != null) {
            if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
                location = CoordTrans.gcjToBaidu(location);
            }
            this.f8580d.a("origin", location.latitude + "," + location.longitude);
        } else {
            this.f8580d.a("origin", massTransitRoutePlanOption.mFrom.getName());
        }
        if (massTransitRoutePlanOption.mFrom.getCity() != null) {
            this.f8580d.a("origin_region", massTransitRoutePlanOption.mFrom.getCity());
        }
        if (!TextUtils.isEmpty(massTransitRoutePlanOption.mFrom.getPoiId())) {
            this.f8580d.a("origin_uid", massTransitRoutePlanOption.mFrom.getPoiId());
        }
        LatLng location2 = massTransitRoutePlanOption.mTo.getLocation();
        if (location2 != null) {
            if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
                location2 = CoordTrans.gcjToBaidu(location2);
            }
            this.f8580d.a("destination", location2.latitude + "," + location2.longitude);
        } else {
            this.f8580d.a("destination", massTransitRoutePlanOption.mTo.getName());
        }
        if (massTransitRoutePlanOption.mTo.getCity() != null) {
            this.f8580d.a("destination_region", massTransitRoutePlanOption.mTo.getCity());
        }
        if (!TextUtils.isEmpty(massTransitRoutePlanOption.mTo.getPoiId())) {
            this.f8580d.a("destination_uid", massTransitRoutePlanOption.mTo.getPoiId());
        }
        this.f8580d.a("tactics_incity", massTransitRoutePlanOption.mTacticsIncity.getInt() + "");
        this.f8580d.a("tactics_intercity", massTransitRoutePlanOption.mTacticsIntercity.getInt() + "");
        this.f8580d.a("trans_type_intercity", massTransitRoutePlanOption.mTransTypeIntercity.getInt() + "");
        this.f8580d.a("page_index", massTransitRoutePlanOption.mPageIndex + "");
        this.f8580d.a("page_size", massTransitRoutePlanOption.mPageSize + "");
        this.f8580d.a("coord_type", massTransitRoutePlanOption.mCoordType);
        this.f8580d.a("output", BodyData.TYPE_JSON);
        this.f8580d.a("from", "android_map_sdk");
        this.f8580d.a("sub_version", "151100");
        if (massTransitRoutePlanOption.mLanguageType == LanguageType.LanguageTypeEnglish) {
            this.f8580d.a("language", "en");
        }
    }

    @Override // com.baidu.platform.base.c
    public String a(com.baidu.platform.domain.b bVar) {
        return bVar.n();
    }
}
