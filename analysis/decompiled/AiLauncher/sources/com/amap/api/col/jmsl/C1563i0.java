package com.amap.api.col.jmsl;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.route.RouteSearch;
import com.amap.api.services.route.TruckRouteRestult;

/* renamed from: com.amap.api.col.jmsl.i0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1563i0 extends Q1<RouteSearch.TruckRouteQuery, TruckRouteRestult> {
    public C1563i0(Context context, RouteSearch.TruckRouteQuery truckRouteQuery) {
        super(context, truckRouteQuery);
    }

    @Override // com.amap.api.col.jmsl.I1
    public Object f(String str) throws AMapException {
        return C1531a0.N(str);
    }

    @Override // com.amap.api.col.jmsl.s7
    public String getURL() {
        return T2.d(this.f16099B) + "/direction/truck?";
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.amap.api.col.jmsl.Q1
    public String n() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("key=");
        stringBuffer.append(C1567j0.n(this.f16099B));
        if (((RouteSearch.TruckRouteQuery) this.f16103z).getFromAndTo() != null) {
            stringBuffer.append("&origin=");
            stringBuffer.append(C1631z1.e(((RouteSearch.TruckRouteQuery) this.f16103z).getFromAndTo().getFrom()));
            if (!C1531a0.m(((RouteSearch.TruckRouteQuery) this.f16103z).getFromAndTo().getStartPoiID())) {
                stringBuffer.append("&originid=");
                stringBuffer.append(((RouteSearch.TruckRouteQuery) this.f16103z).getFromAndTo().getStartPoiID());
            }
            stringBuffer.append("&destination=");
            stringBuffer.append(C1631z1.e(((RouteSearch.TruckRouteQuery) this.f16103z).getFromAndTo().getTo()));
            if (!C1531a0.m(((RouteSearch.TruckRouteQuery) this.f16103z).getFromAndTo().getDestinationPoiID())) {
                stringBuffer.append("&destinationid=");
                stringBuffer.append(((RouteSearch.TruckRouteQuery) this.f16103z).getFromAndTo().getDestinationPoiID());
            }
            if (!C1531a0.m(((RouteSearch.TruckRouteQuery) this.f16103z).getFromAndTo().getOriginType())) {
                stringBuffer.append("&origintype=");
                stringBuffer.append(((RouteSearch.TruckRouteQuery) this.f16103z).getFromAndTo().getOriginType());
            }
            if (!C1531a0.m(((RouteSearch.TruckRouteQuery) this.f16103z).getFromAndTo().getDestinationType())) {
                stringBuffer.append("&destinationtype=");
                stringBuffer.append(((RouteSearch.TruckRouteQuery) this.f16103z).getFromAndTo().getDestinationType());
            }
            if (!C1531a0.m(((RouteSearch.TruckRouteQuery) this.f16103z).getFromAndTo().getPlateProvince())) {
                stringBuffer.append("&province=");
                stringBuffer.append(((RouteSearch.TruckRouteQuery) this.f16103z).getFromAndTo().getPlateProvince());
            }
            if (!C1531a0.m(((RouteSearch.TruckRouteQuery) this.f16103z).getFromAndTo().getPlateNumber())) {
                stringBuffer.append("&number=");
                stringBuffer.append(((RouteSearch.TruckRouteQuery) this.f16103z).getFromAndTo().getPlateNumber());
            }
        }
        stringBuffer.append("&strategy=");
        stringBuffer.append(((RouteSearch.TruckRouteQuery) this.f16103z).getMode());
        if (((RouteSearch.TruckRouteQuery) this.f16103z).hasPassPoint()) {
            stringBuffer.append("&waypoints=");
            stringBuffer.append(((RouteSearch.TruckRouteQuery) this.f16103z).getPassedPointStr());
        }
        stringBuffer.append("&size=");
        stringBuffer.append(((RouteSearch.TruckRouteQuery) this.f16103z).getTruckSize());
        stringBuffer.append("&height=");
        stringBuffer.append(((RouteSearch.TruckRouteQuery) this.f16103z).getTruckHeight());
        stringBuffer.append("&width=");
        stringBuffer.append(((RouteSearch.TruckRouteQuery) this.f16103z).getTruckWidth());
        stringBuffer.append("&load=");
        stringBuffer.append(((RouteSearch.TruckRouteQuery) this.f16103z).getTruckLoad());
        stringBuffer.append("&weight=");
        stringBuffer.append(((RouteSearch.TruckRouteQuery) this.f16103z).getTruckWeight());
        stringBuffer.append("&axis=");
        stringBuffer.append(((RouteSearch.TruckRouteQuery) this.f16103z).getTruckAxis());
        if (TextUtils.isEmpty(((RouteSearch.TruckRouteQuery) this.f16103z).getExtensions())) {
            stringBuffer.append("&extensions=base");
        } else {
            stringBuffer.append("&extensions=");
            stringBuffer.append(((RouteSearch.TruckRouteQuery) this.f16103z).getExtensions());
        }
        stringBuffer.append("&output=json");
        return stringBuffer.toString();
    }
}
