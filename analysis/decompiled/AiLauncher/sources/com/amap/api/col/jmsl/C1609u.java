package com.amap.api.col.jmsl;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.route.DriveRouteResult;
import com.amap.api.services.route.RouteSearch;

/* renamed from: com.amap.api.col.jmsl.u, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1609u extends Q1<RouteSearch.DriveRouteQuery, DriveRouteResult> {
    public C1609u(Context context, RouteSearch.DriveRouteQuery driveRouteQuery) {
        super(context, driveRouteQuery);
    }

    @Override // com.amap.api.col.jmsl.I1
    public Object f(String str) throws AMapException {
        return C1531a0.o(str);
    }

    @Override // com.amap.api.col.jmsl.s7
    public String getURL() {
        return T2.c(this.f16099B) + "/direction/driving?";
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.amap.api.col.jmsl.Q1
    public String n() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("key=");
        stringBuffer.append(C1567j0.n(this.f16099B));
        if (((RouteSearch.DriveRouteQuery) this.f16103z).getFromAndTo() != null) {
            stringBuffer.append("&origin=");
            stringBuffer.append(C1631z1.e(((RouteSearch.DriveRouteQuery) this.f16103z).getFromAndTo().getFrom()));
            if (!C1531a0.m(((RouteSearch.DriveRouteQuery) this.f16103z).getFromAndTo().getStartPoiID())) {
                stringBuffer.append("&originid=");
                stringBuffer.append(((RouteSearch.DriveRouteQuery) this.f16103z).getFromAndTo().getStartPoiID());
            }
            stringBuffer.append("&destination=");
            stringBuffer.append(C1631z1.e(((RouteSearch.DriveRouteQuery) this.f16103z).getFromAndTo().getTo()));
            if (!C1531a0.m(((RouteSearch.DriveRouteQuery) this.f16103z).getFromAndTo().getDestinationPoiID())) {
                stringBuffer.append("&destinationid=");
                stringBuffer.append(((RouteSearch.DriveRouteQuery) this.f16103z).getFromAndTo().getDestinationPoiID());
            }
            if (!C1531a0.m(((RouteSearch.DriveRouteQuery) this.f16103z).getFromAndTo().getOriginType())) {
                stringBuffer.append("&origintype=");
                stringBuffer.append(((RouteSearch.DriveRouteQuery) this.f16103z).getFromAndTo().getOriginType());
            }
            if (!C1531a0.m(((RouteSearch.DriveRouteQuery) this.f16103z).getFromAndTo().getDestinationType())) {
                stringBuffer.append("&destinationtype=");
                stringBuffer.append(((RouteSearch.DriveRouteQuery) this.f16103z).getFromAndTo().getDestinationType());
            }
            if (!C1531a0.m(((RouteSearch.DriveRouteQuery) this.f16103z).getFromAndTo().getPlateProvince())) {
                stringBuffer.append("&province=");
                stringBuffer.append(((RouteSearch.DriveRouteQuery) this.f16103z).getFromAndTo().getPlateProvince());
            }
            if (!C1531a0.m(((RouteSearch.DriveRouteQuery) this.f16103z).getFromAndTo().getPlateNumber())) {
                stringBuffer.append("&number=");
                stringBuffer.append(((RouteSearch.DriveRouteQuery) this.f16103z).getFromAndTo().getPlateNumber());
            }
        }
        stringBuffer.append("&strategy=");
        stringBuffer.append("" + ((RouteSearch.DriveRouteQuery) this.f16103z).getMode());
        if (TextUtils.isEmpty(((RouteSearch.DriveRouteQuery) this.f16103z).getExtensions())) {
            stringBuffer.append("&extensions=base");
        } else {
            stringBuffer.append("&extensions=");
            stringBuffer.append(((RouteSearch.DriveRouteQuery) this.f16103z).getExtensions());
        }
        stringBuffer.append("&ferry=");
        stringBuffer.append(!((RouteSearch.DriveRouteQuery) this.f16103z).isUseFerry() ? 1 : 0);
        stringBuffer.append("&cartype=");
        stringBuffer.append("" + ((RouteSearch.DriveRouteQuery) this.f16103z).getCarType());
        if (((RouteSearch.DriveRouteQuery) this.f16103z).hasPassPoint()) {
            stringBuffer.append("&waypoints=");
            stringBuffer.append(((RouteSearch.DriveRouteQuery) this.f16103z).getPassedPointStr());
        }
        if (((RouteSearch.DriveRouteQuery) this.f16103z).hasAvoidpolygons()) {
            stringBuffer.append("&avoidpolygons=");
            stringBuffer.append(((RouteSearch.DriveRouteQuery) this.f16103z).getAvoidpolygonsStr());
        }
        if (((RouteSearch.DriveRouteQuery) this.f16103z).hasAvoidRoad()) {
            stringBuffer.append("&avoidroad=");
            stringBuffer.append(m(((RouteSearch.DriveRouteQuery) this.f16103z).getAvoidRoad()));
        }
        stringBuffer.append("&output=json");
        stringBuffer.append("&geometry=false");
        if (((RouteSearch.DriveRouteQuery) this.f16103z).getExclude() != null) {
            stringBuffer.append("&exclude=");
            stringBuffer.append(((RouteSearch.DriveRouteQuery) this.f16103z).getExclude());
        }
        return stringBuffer.toString();
    }
}
