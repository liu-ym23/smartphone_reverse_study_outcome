package com.baidu.naviapi.platform.net;

import android.util.Pair;
import com.baidu.mshield.x6.EngineImpl;
import com.baidu.naviapi.okhttp.RequestEntity;
import com.baidu.naviapi.okhttp.log.BNLogUtil;
import com.baidu.naviapi.open.RoutePlanParam;
import com.baidu.platform.comapi.location.CoordinateType;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes39.dex */
public class b extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f32678a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f32679b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f32680c;

    @Override // com.baidu.naviapi.platform.net.d
    public Map<String, String> d() {
        HashMap r100 = new HashMap();
        com.baidu.naviapi.platform.a r101 = com.baidu.naviapi.platform.a.f32640u;
        RoutePlanParam r102 = r101.c();
        int r103 = r102.getCoordType();
        int r104 = r102.getReCoordType();
        if (r103 == 1) goto L9;
        if (r103 == 2) goto L8;
        if (r103 == 4) goto L7;
        r100.put("coord_type", "gcj02");
    L11:
        if (r104 == 1) goto L17;
        if (r104 == 2) goto L16;
        if (r104 == 4) goto L15;
        r100.put("ret_coordtype", "gcj02");
    L18:
        r100.put("location_data", this.f32679b);
        r100.put("route_id", r101.b());
        r100.put("session_id", r101.d());
        r100.put("state", this.f32680c + "");
        r100.put("across_distance", r101.a() + "");
        Pair<Integer, Integer> r105 = r102.getGuidanceRange();
        r100.put("guidance_range", r105.first + "," + r105.second);
        r100.put(EngineImpl.KEY_CUID, com.baidu.naviapi.platform.e.b().a());
        r100.put("timestamp", System.currentTimeMillis() + "");
        StringBuilder r106 = new StringBuilder("post loc -> ");
        r106.append(r100);
        BNLogUtil.logI("LocRequestWrapper", r106.toString());
        r100.put("token", com.baidu.naviapi.platform.d.a("token"));
        return r100;
    L15:
        r100.put("ret_coordtype", CoordinateType.BD09MC);
        goto L18
    L16:
        r100.put("ret_coordtype", CoordinateType.BD09LL);
        goto L18
    L17:
        r100.put("ret_coordtype", "wgs84");
        goto L18
    L7:
        r100.put("coord_type", CoordinateType.BD09MC);
        goto L11
    L8:
        r100.put("coord_type", CoordinateType.BD09LL);
        goto L11
    L9:
        r100.put("coord_type", "wgs84");
        goto L11
    }

    @Override // com.baidu.naviapi.platform.net.d
    public RoutePlanParam.RoutePlanType e() {
        return com.baidu.naviapi.platform.a.f32640u.c().getRoutePlanType();
    }

    @Override // com.baidu.naviapi.platform.net.d
    public a b() {
        return this.f32678a;
    }

    @Override // com.baidu.naviapi.platform.net.d
    public RequestEntity.HttpMethod c() {
        return RequestEntity.HttpMethod.GET;
    }

    public b(String r100, int r101, a r102) throws com.baidu.naviapi.platform.ex.b {
        if (r102 == null) goto L7;
        this.f32678a = r102;
        this.f32679b = r100;
        this.f32680c = r101;
        return;
    L7:
        throw new com.baidu.naviapi.platform.ex.b("response cant be null.");
    }
}
