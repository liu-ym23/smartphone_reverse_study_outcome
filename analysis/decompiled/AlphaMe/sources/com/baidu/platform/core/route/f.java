package com.baidu.platform.core.route;

import com.baidu.mapapi.http.wrapper.annotation.BodyData;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.search.route.IndoorRoutePlanOption;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.stepos.activeview.utils.Constants;
import com.stepos.alphame.awareness.AwarenessDataItem;
import com.stepos.alphame.utils.Consts;

/* loaded from: classes.dex */
public class f extends com.baidu.platform.base.c {
    public f(IndoorRoutePlanOption indoorRoutePlanOption) {
        a(indoorRoutePlanOption);
    }

    private void a(IndoorRoutePlanOption indoorRoutePlanOption) {
        this.f8580d.a("qt", "indoornavi");
        this.f8580d.a("rp_format", BodyData.TYPE_JSON);
        this.f8580d.a(Constants.JSON_KEY_VERSION, "1");
        GeoPoint geoPointLl2mc = CoordUtil.ll2mc(indoorRoutePlanOption.mFrom.getLocation());
        if (geoPointLl2mc != null) {
            StringBuilder sbV = B0.g.v(String.format("%f,%f", Double.valueOf(geoPointLl2mc.getLongitudeE6()), Double.valueOf(geoPointLl2mc.getLatitudeE6())), Consts.SPLITTER_DETAIL);
            sbV.append(indoorRoutePlanOption.mFrom.getFloor());
            this.f8580d.a(Constants.JSON_KEY_SN, sbV.toString().replaceAll(AwarenessDataItem.PERMISSION_SPLITTER, ""));
        }
        GeoPoint geoPointLl2mc2 = CoordUtil.ll2mc(indoorRoutePlanOption.mTo.getLocation());
        if (geoPointLl2mc2 != null) {
            StringBuilder sbV2 = B0.g.v(String.format("%f,%f", Double.valueOf(geoPointLl2mc2.getLongitudeE6()), Double.valueOf(geoPointLl2mc2.getLatitudeE6())), Consts.SPLITTER_DETAIL);
            sbV2.append(indoorRoutePlanOption.mTo.getFloor());
            this.f8580d.a("en", sbV2.toString().replaceAll(AwarenessDataItem.PERMISSION_SPLITTER, ""));
        }
    }

    @Override // com.baidu.platform.base.c
    public String a(com.baidu.platform.domain.b bVar) {
        return bVar.q();
    }
}
