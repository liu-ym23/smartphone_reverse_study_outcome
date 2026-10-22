package com.amap.api.col.jmsl;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.route.RouteSearch;
import com.amap.api.services.route.WalkRouteResult;

/* renamed from: com.amap.api.col.jmsl.z0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1630z0 extends Q1<RouteSearch.WalkRouteQuery, WalkRouteResult> {
    public C1630z0(Context context, RouteSearch.WalkRouteQuery walkRouteQuery) {
        super(context, walkRouteQuery);
    }

    @Override // com.amap.api.col.jmsl.I1
    public Object f(String str) throws AMapException {
        return C1531a0.P(str);
    }

    @Override // com.amap.api.col.jmsl.s7
    public String getURL() {
        return T2.c(this.f16099B) + "/direction/walking?";
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.amap.api.col.jmsl.Q1
    public String n() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("key=");
        stringBuffer.append(C1567j0.n(this.f16099B));
        stringBuffer.append("&origin=");
        stringBuffer.append(C1631z1.e(((RouteSearch.WalkRouteQuery) this.f16103z).getFromAndTo().getFrom()));
        stringBuffer.append("&destination=");
        stringBuffer.append(C1631z1.e(((RouteSearch.WalkRouteQuery) this.f16103z).getFromAndTo().getTo()));
        stringBuffer.append("&multipath=0");
        stringBuffer.append("&output=json");
        stringBuffer.append("&geometry=false");
        if (TextUtils.isEmpty(((RouteSearch.WalkRouteQuery) this.f16103z).getExtensions())) {
            stringBuffer.append("&extensions=base");
        } else {
            stringBuffer.append("&extensions=");
            stringBuffer.append(((RouteSearch.WalkRouteQuery) this.f16103z).getExtensions());
        }
        return stringBuffer.toString();
    }
}
