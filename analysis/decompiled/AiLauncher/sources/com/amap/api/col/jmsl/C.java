package com.amap.api.col.jmsl;

import android.content.Context;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.route.RideRouteResultV2;
import com.amap.api.services.route.RouteSearchV2;

/* loaded from: classes.dex */
public class C extends Q1<RouteSearchV2.RideRouteQuery, RideRouteResultV2> {
    public C(Context context, RouteSearchV2.RideRouteQuery rideRouteQuery) {
        super(context, rideRouteQuery);
    }

    @Override // com.amap.api.col.jmsl.I1
    public Object f(String str) throws AMapException {
        return C1531a0.L(str);
    }

    @Override // com.amap.api.col.jmsl.s7
    public String getURL() {
        return T2.e(this.f16099B) + "/direction/bicycling?";
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.amap.api.col.jmsl.Q1
    public String n() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("key=");
        stringBuffer.append(C1567j0.n(this.f16099B));
        stringBuffer.append("&origin=");
        stringBuffer.append(C1631z1.e(((RouteSearchV2.RideRouteQuery) this.f16103z).getFromAndTo().getFrom()));
        stringBuffer.append("&destination=");
        stringBuffer.append(C1631z1.e(((RouteSearchV2.RideRouteQuery) this.f16103z).getFromAndTo().getTo()));
        stringBuffer.append("&alternative_route=");
        stringBuffer.append(((RouteSearchV2.RideRouteQuery) this.f16103z).getAlternativeRoute());
        stringBuffer.append("&output=json");
        stringBuffer.append("&show_fields=");
        stringBuffer.append(C1631z1.d(((RouteSearchV2.RideRouteQuery) this.f16103z).getShowFields()));
        return stringBuffer.toString();
    }
}
