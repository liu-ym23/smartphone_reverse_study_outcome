package com.baidu.platform.core.route;

import com.baidu.mapapi.http.wrapper.annotation.BodyData;
import com.baidu.mapapi.search.route.PlanNode;
import com.baidu.mapapi.search.route.WalkingRoutePlanOption;
import com.stepos.activeview.utils.Constants;

/* loaded from: classes.dex */
public class h extends com.baidu.platform.base.c {
    public h(WalkingRoutePlanOption walkingRoutePlanOption) {
        a(walkingRoutePlanOption);
    }

    private void a(WalkingRoutePlanOption walkingRoutePlanOption) {
        this.f8580d.a("qt", "walkplan");
        this.f8580d.a(Constants.JSON_KEY_SN, a(walkingRoutePlanOption.mFrom));
        this.f8580d.a("en", a(walkingRoutePlanOption.mTo));
        PlanNode planNode = walkingRoutePlanOption.mFrom;
        if (planNode != null) {
            this.f8580d.a("sc", planNode.getCity());
        }
        PlanNode planNode2 = walkingRoutePlanOption.mTo;
        if (planNode2 != null) {
            this.f8580d.a("ec", planNode2.getCity());
        }
        this.f8580d.a("ie", "utf-8");
        this.f8580d.a("lrn", "20");
        this.f8580d.a(Constants.JSON_KEY_VERSION, "6");
        this.f8580d.a("rp_format", BodyData.TYPE_JSON);
        this.f8580d.a("rp_filter", "mobile");
        this.f8580d.a("spath_type", "1");
        this.f8580d.a("with_indoor_navi", "1");
    }

    @Override // com.baidu.platform.base.c
    public String a(com.baidu.platform.domain.b bVar) {
        return bVar.i();
    }
}
