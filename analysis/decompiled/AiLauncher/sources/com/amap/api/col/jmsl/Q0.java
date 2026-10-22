package com.amap.api.col.jmsl;

import android.content.Context;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.nearby.NearbyInfo;
import com.amap.api.services.nearby.NearbySearch;
import com.amap.api.services.nearby.NearbySearchResult;
import com.autonavi.aps.amapapi.config.Const;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class Q0 extends Q1<NearbySearch.NearbyQuery, NearbySearchResult> {

    /* renamed from: E, reason: collision with root package name */
    public Context f16295E;

    /* renamed from: F, reason: collision with root package name */
    public NearbySearch.NearbyQuery f16296F;

    public Q0(Context context, NearbySearch.NearbyQuery nearbyQuery) {
        super(context, nearbyQuery);
        this.f16295E = context;
        this.f16296F = nearbyQuery;
    }

    @Override // com.amap.api.col.jmsl.I1
    public Object f(String str) throws AMapException {
        try {
            JSONObject jSONObject = new JSONObject(str);
            boolean z10 = true;
            if (this.f16296F.getType() != 1) {
                z10 = false;
            }
            ArrayList<NearbyInfo> arrayListB = C1531a0.b(jSONObject, z10);
            NearbySearchResult nearbySearchResult = new NearbySearchResult();
            nearbySearchResult.setNearbyInfoList(arrayListB);
            return nearbySearchResult;
        } catch (JSONException e10) {
            C1631z1.o(e10, "NearbySearchHandler", "paseJSON");
            return null;
        }
    }

    @Override // com.amap.api.col.jmsl.s7
    public String getURL() {
        return T2.g(this.f16295E) + "/nearby/around";
    }

    @Override // com.amap.api.col.jmsl.Q1
    public String n() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("key=");
        stringBuffer.append(C1567j0.n(this.f16295E));
        LatLonPoint centerPoint = this.f16296F.getCenterPoint();
        if (centerPoint != null) {
            stringBuffer.append("&center=");
            stringBuffer.append(centerPoint.getLongitude());
            stringBuffer.append(Const.STR_MART_COMMA);
            stringBuffer.append(centerPoint.getLatitude());
        }
        stringBuffer.append("&radius=");
        stringBuffer.append(this.f16296F.getRadius());
        stringBuffer.append("&limit=30");
        stringBuffer.append("&searchtype=");
        stringBuffer.append(this.f16296F.getType());
        stringBuffer.append("&timerange=");
        stringBuffer.append(this.f16296F.getTimeRange());
        return stringBuffer.toString();
    }
}
