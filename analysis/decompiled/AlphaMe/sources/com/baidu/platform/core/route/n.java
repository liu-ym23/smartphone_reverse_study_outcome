package com.baidu.platform.core.route;

import com.baidu.mapapi.http.wrapper.annotation.BodyData;
import com.baidu.mapapi.search.route.TransitRoutePlanOption;
import com.stepos.activeview.utils.Constants;

/* loaded from: classes.dex */
public class n extends com.baidu.platform.base.c {
    public n(TransitRoutePlanOption transitRoutePlanOption) {
        a(transitRoutePlanOption);
    }

    private void a(TransitRoutePlanOption transitRoutePlanOption) {
        this.f8580d.a("qt", "bus");
        this.f8580d.a("sy", transitRoutePlanOption.mPolicy.getInt() + "");
        this.f8580d.a("ie", "utf-8");
        this.f8580d.a("lrn", "20");
        this.f8580d.a(Constants.JSON_KEY_VERSION, "3");
        this.f8580d.a("rp_format", BodyData.TYPE_JSON);
        this.f8580d.a("rp_filter", "mobile");
        this.f8580d.a("ic_info", "2");
        this.f8580d.a("exptype", "depall");
        this.f8580d.a(Constants.JSON_KEY_SN, a(transitRoutePlanOption.mFrom));
        this.f8580d.a("en", a(transitRoutePlanOption.mTo));
        String str = transitRoutePlanOption.mCityName;
        if (str != null) {
            this.f8580d.a("c", str);
        }
        if (TransitRoutePlanOption.TransitPolicy.EBUS_NO_SUBWAY == transitRoutePlanOption.mPolicy) {
            this.f8580d.a("f", "[0,2,4,7,5,8,9,10,11]");
        }
    }

    @Override // com.baidu.platform.base.c
    public String a(com.baidu.platform.domain.b bVar) {
        return bVar.w();
    }
}
