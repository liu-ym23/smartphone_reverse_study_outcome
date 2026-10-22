package com.baidu.platform.core.route;

import androidx.room.AbstractC0351g;
import ch.qos.logback.core.pattern.color.ANSIConstants;
import com.baidu.mapapi.http.wrapper.annotation.BodyData;
import com.baidu.mapapi.search.route.DrivingRoutePlanOption;
import com.baidu.mapapi.search.route.PlanNode;
import com.stepos.activeview.utils.Constants;
import com.stepos.alphame.utils.Consts;
import java.util.List;

/* loaded from: classes.dex */
public class d extends com.baidu.platform.base.c {
    public d(DrivingRoutePlanOption drivingRoutePlanOption) {
        a(drivingRoutePlanOption);
    }

    private void a(DrivingRoutePlanOption drivingRoutePlanOption) {
        this.f8580d.a("qt", "cars");
        this.f8580d.a("sy", drivingRoutePlanOption.mPolicy.getInt() + "");
        this.f8580d.a("ie", "utf-8");
        this.f8580d.a("lrn", "20");
        this.f8580d.a(Constants.JSON_KEY_VERSION, "6");
        this.f8580d.a("extinfo", ANSIConstants.GREEN_FG);
        this.f8580d.a("mrs", "1");
        this.f8580d.a("rp_format", BodyData.TYPE_JSON);
        this.f8580d.a("rp_filter", "mobile");
        this.f8580d.a("route_traffic", drivingRoutePlanOption.mtrafficPolicy.getInt() + "");
        this.f8580d.a(Constants.JSON_KEY_SN, a(drivingRoutePlanOption.mFrom));
        this.f8580d.a("en", a(drivingRoutePlanOption.mTo));
        String str = drivingRoutePlanOption.mCityName;
        if (str != null) {
            this.f8580d.a("c", str);
        }
        PlanNode planNode = drivingRoutePlanOption.mFrom;
        if (planNode != null) {
            this.f8580d.a("sc", planNode.getCity());
        }
        PlanNode planNode2 = drivingRoutePlanOption.mTo;
        if (planNode2 != null) {
            this.f8580d.a("ec", planNode2.getCity());
        }
        List<PlanNode> list = drivingRoutePlanOption.mWayPoints;
        String str2 = new String();
        String str3 = new String();
        if (list != null) {
            for (int i4 = 0; i4 < list.size(); i4++) {
                PlanNode planNode3 = list.get(i4);
                if (planNode3 != null) {
                    StringBuilder sbS = B0.g.s(str2);
                    sbS.append(a(planNode3));
                    str2 = sbS.toString();
                    StringBuilder sbS2 = B0.g.s(str3);
                    sbS2.append(planNode3.getCity());
                    str3 = sbS2.toString();
                    if (i4 != list.size() - 1) {
                        str2 = AbstractC0351g.p(str2, Consts.SPLITTER_DETAIL);
                        str3 = AbstractC0351g.p(str3, Consts.SPLITTER_DETAIL);
                    }
                }
            }
            this.f8580d.a("wp", str2);
            this.f8580d.a("wpc", str3);
        }
    }

    @Override // com.baidu.platform.base.c
    public String a(com.baidu.platform.domain.b bVar) {
        return bVar.a();
    }
}
