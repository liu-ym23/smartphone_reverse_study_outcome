package com.amap.api.col.s;

import android.content.Context;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.nearby.NearbyInfo;
import com.amap.api.services.nearby.NearbySearch;
import com.amap.api.services.nearby.NearbySearchResult;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
public final class u extends b<NearbySearch.NearbyQuery, NearbySearchResult> {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Context f26643j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private NearbySearch.NearbyQuery f26644k;

    @Override // com.amap.api.col.s.b, com.amap.api.col.s.a
    public final String a() {
        StringBuffer r100 = new StringBuffer("key=");
        r100.append(bi.f(this.f26643j));
        LatLonPoint r101 = this.f26644k.getCenterPoint();
        if (r101 == null) goto L5;
        r100.append("&center=");
        r100.append(r101.getLongitude());
        r100.append(",");
        r100.append(r101.getLatitude());
    L5:
        r100.append("&radius=");
        r100.append(this.f26644k.getRadius());
        r100.append("&limit=30&searchtype=");
        r100.append(this.f26644k.getType());
        r100.append("&timerange=");
        r100.append(this.f26644k.getTimeRange());
        return r100.toString();
    }

    @Override // com.amap.api.col.s.cy
    public final String h() {
        return h.c() + "/nearby/around";
    }

    private NearbySearchResult c(String r100) throws AMapException {
        JSONObject r101 = new JSONObject(r100);     // Catch: JSONException -> L8
        boolean r102 = true;
        if (this.f26644k.getType() == 1) goto L6;
        r102 = false;
    L6:
        ArrayList<NearbyInfo> r103 = p.a(r101, r102);     // Catch: JSONException -> L8
        NearbySearchResult r104 = new NearbySearchResult();     // Catch: JSONException -> L8
        r104.setNearbyInfoList(r103);     // Catch: JSONException -> L8
        return r104;
    L8:
        e = move-exception;
        i.a(e, "NearbySearchHandler", "paseJSON");
        return null;
    }

    @Override // com.amap.api.col.s.b, com.amap.api.col.s.a
    public final /* synthetic */ Object a(String r100) throws AMapException {
        return c(r100);
    }

    public u(Context r100, NearbySearch.NearbyQuery r101) {
        super(r100, r101);
        this.f26643j = r100;
        this.f26644k = r101;
    }
}
