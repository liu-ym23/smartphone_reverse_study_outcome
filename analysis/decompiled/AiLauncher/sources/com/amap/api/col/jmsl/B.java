package com.amap.api.col.jmsl;

import android.content.Context;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.route.DriveRouteResultV2;
import com.amap.api.services.route.RouteSearchV2;

/* loaded from: classes.dex */
public class B extends Q1<RouteSearchV2.DriveRouteQuery, DriveRouteResultV2> {
    public B(Context context, RouteSearchV2.DriveRouteQuery driveRouteQuery) {
        super(context, driveRouteQuery);
    }

    @Override // com.amap.api.col.jmsl.I1
    public Object f(String str) throws AMapException {
        return C1531a0.v(str);
    }

    @Override // com.amap.api.col.jmsl.s7
    public String getURL() {
        return T2.e(this.f16099B) + "/direction/driving?";
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.amap.api.col.jmsl.Q1
    public String n() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("key=");
        stringBuffer.append(C1567j0.n(this.f16099B));
        if (((RouteSearchV2.DriveRouteQuery) this.f16103z).getFromAndTo() != null) {
            stringBuffer.append("&origin=");
            stringBuffer.append(C1631z1.e(((RouteSearchV2.DriveRouteQuery) this.f16103z).getFromAndTo().getFrom()));
            if (!C1531a0.m(((RouteSearchV2.DriveRouteQuery) this.f16103z).getFromAndTo().getStartPoiID())) {
                stringBuffer.append("&origin_id=");
                stringBuffer.append(((RouteSearchV2.DriveRouteQuery) this.f16103z).getFromAndTo().getStartPoiID());
            }
            stringBuffer.append("&destination=");
            stringBuffer.append(C1631z1.e(((RouteSearchV2.DriveRouteQuery) this.f16103z).getFromAndTo().getTo()));
            if (!C1531a0.m(((RouteSearchV2.DriveRouteQuery) this.f16103z).getFromAndTo().getDestinationPoiID())) {
                stringBuffer.append("&destination_id=");
                stringBuffer.append(((RouteSearchV2.DriveRouteQuery) this.f16103z).getFromAndTo().getDestinationPoiID());
            }
            if (!C1531a0.m(((RouteSearchV2.DriveRouteQuery) this.f16103z).getFromAndTo().getOriginType())) {
                stringBuffer.append("&origin_type=");
                stringBuffer.append(((RouteSearchV2.DriveRouteQuery) this.f16103z).getFromAndTo().getOriginType());
            }
            if (!C1531a0.m(((RouteSearchV2.DriveRouteQuery) this.f16103z).getFromAndTo().getPlateNumber())) {
                stringBuffer.append("&plate=");
                stringBuffer.append(((RouteSearchV2.DriveRouteQuery) this.f16103z).getFromAndTo().getPlateNumber());
            }
        }
        stringBuffer.append("&strategy=");
        stringBuffer.append("" + ((RouteSearchV2.DriveRouteQuery) this.f16103z).getMode().getValue());
        int showFields = ((RouteSearchV2.DriveRouteQuery) this.f16103z).getShowFields();
        stringBuffer.append("&show_fields=");
        stringBuffer.append(C1631z1.d(showFields));
        RouteSearchV2.NewEnergy newEnergy = ((RouteSearchV2.DriveRouteQuery) this.f16103z).getNewEnergy();
        if (newEnergy != null) {
            stringBuffer.append(newEnergy.buildParam());
            stringBuffer.append("&force_new_version=");
            stringBuffer.append("true");
        }
        stringBuffer.append("&ferry=");
        stringBuffer.append(!((RouteSearchV2.DriveRouteQuery) this.f16103z).isUseFerry() ? 1 : 0);
        stringBuffer.append("&cartype=");
        stringBuffer.append("" + ((RouteSearchV2.DriveRouteQuery) this.f16103z).getCarType());
        if (((RouteSearchV2.DriveRouteQuery) this.f16103z).hasPassPoint()) {
            stringBuffer.append("&waypoints=");
            stringBuffer.append(((RouteSearchV2.DriveRouteQuery) this.f16103z).getPassedPointStr());
        }
        if (((RouteSearchV2.DriveRouteQuery) this.f16103z).hasAvoidpolygons()) {
            stringBuffer.append("&avoidpolygons=");
            stringBuffer.append(((RouteSearchV2.DriveRouteQuery) this.f16103z).getAvoidpolygonsStr());
        }
        if (((RouteSearchV2.DriveRouteQuery) this.f16103z).hasAvoidRoad()) {
            stringBuffer.append("&avoidroad=");
            stringBuffer.append(m(((RouteSearchV2.DriveRouteQuery) this.f16103z).getAvoidRoad()));
        }
        stringBuffer.append("&output=json");
        stringBuffer.append("&geometry=false");
        if (((RouteSearchV2.DriveRouteQuery) this.f16103z).getExclude() != null) {
            stringBuffer.append("&exclude=");
            stringBuffer.append(((RouteSearchV2.DriveRouteQuery) this.f16103z).getExclude());
        }
        return stringBuffer.toString();
    }
}
