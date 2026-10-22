package com.baidu.platform.core.route;

import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.http.wrapper.annotation.BodyData;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.route.BikingRoutePlanOption;
import com.baidu.mapapi.search.route.PlanNode;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;
import com.stepos.alphame.utils.Consts;
import java.util.List;

/* loaded from: classes.dex */
public class b extends com.baidu.platform.base.c {
    public b(BikingRoutePlanOption bikingRoutePlanOption) {
        a(bikingRoutePlanOption);
    }

    private void a(BikingRoutePlanOption bikingRoutePlanOption) {
        this.f8580d.a("mode", "riding");
        PlanNode planNode = bikingRoutePlanOption.mFrom;
        PlanNode planNode2 = bikingRoutePlanOption.mTo;
        if (planNode == null || planNode2 == null) {
            return;
        }
        LatLng location = planNode.getLocation();
        if (location != null) {
            if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
                location = CoordTrans.gcjToBaidu(location);
            }
            if (location != null) {
                this.f8580d.a("origin", location.latitude + "," + location.longitude);
            }
        } else {
            this.f8580d.a("origin", planNode.getName());
            this.f8580d.a("origin_region", planNode.getCity());
        }
        if (planNode.getPoiId() != null && planNode.getPoiId().length() > 0) {
            this.f8580d.a("origin_uid", planNode.getPoiId());
        }
        LatLng location2 = planNode2.getLocation();
        if (location2 != null) {
            if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
                location2 = CoordTrans.gcjToBaidu(location2);
            }
            if (location2 != null) {
                this.f8580d.a("destination", location2.latitude + "," + location2.longitude);
            }
        } else {
            this.f8580d.a("destination", planNode2.getName());
            this.f8580d.a("destination_region", planNode2.getCity());
        }
        if (planNode2.getPoiId() != null && planNode2.getPoiId().length() > 0) {
            this.f8580d.a("destination_uid", planNode2.getPoiId());
        }
        int i4 = bikingRoutePlanOption.mRidingType;
        if (i4 == 1) {
            this.f8580d.a("riding_type", String.valueOf(i4));
        }
        List<PlanNode> wayPoints = bikingRoutePlanOption.getWayPoints();
        if (wayPoints != null) {
            StringBuilder sb = new StringBuilder();
            for (int i5 = 0; i5 < wayPoints.size(); i5++) {
                PlanNode planNode3 = wayPoints.get(i5);
                if (i5 == 0) {
                    sb.append(a(planNode3, this.f8580d));
                } else {
                    sb.append(Consts.SPLITTER_DETAIL);
                    sb.append(a(planNode3, this.f8580d));
                }
            }
            this.f8580d.a("waypoints", sb.toString());
        }
        this.f8580d.a("output", BodyData.TYPE_JSON);
        this.f8580d.a("from", "android_map_sdk");
        this.f8580d.a("road_prefer", bikingRoutePlanOption.mRoadPrefer);
    }

    private String a(PlanNode planNode, com.baidu.platform.util.a aVar) {
        if (planNode == null || aVar == null) {
            return "";
        }
        LatLng location = planNode.getLocation();
        String poiId = planNode.getPoiId() != null ? planNode.getPoiId() : "";
        if (location != null) {
            if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
                location = CoordTrans.gcjToBaidu(location);
            }
            if (location == null) {
                return "";
            }
            return location.latitude + "," + location.longitude + ";" + poiId;
        }
        String cityCode = planNode.getCityCode() != null ? planNode.getCityCode() : "";
        String cityName = planNode.getCityName() != null ? planNode.getCityName() : "";
        if (planNode.getName() == null || planNode.getName().length() <= 0) {
            return "";
        }
        return planNode.getName() + ";" + poiId + ";" + cityName + ";" + cityCode;
    }

    @Override // com.baidu.platform.base.c
    public String a(com.baidu.platform.domain.b bVar) {
        return bVar.b();
    }
}
