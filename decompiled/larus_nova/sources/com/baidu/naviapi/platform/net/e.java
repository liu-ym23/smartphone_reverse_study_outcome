package com.baidu.naviapi.platform.net;

import android.text.TextUtils;
import androidx.camera.video.AudioStats;
import com.baidu.mshield.x6.EngineImpl;
import com.baidu.naviapi.okhttp.RequestEntity;
import com.baidu.naviapi.okhttp.log.BNLogUtil;
import com.baidu.naviapi.open.LocInfo;
import com.baidu.naviapi.open.RoutePlanParam;
import com.baidu.platform.comapi.location.CoordinateType;
import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: classes39.dex */
public class e extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f32683a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f32684b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f32685c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f32686d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.baidu.naviapi.platform.net.a f32687e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f32688f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f32689g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f32690h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f32691i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f32692j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f32693k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f32694l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f32695m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f32696n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f32697o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final String f32698p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final RoutePlanParam.RoutePlanType f32699q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final List<LocInfo.Point> f32700r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final int f32701s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final int f32702t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final int f32703u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int f32704v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final int f32705w;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f32706a = null;

        static {
            int[] r100 = new int[RoutePlanParam.RoutePlanType.values().length];
            f32706a = r100;
            r100[RoutePlanParam.RoutePlanType.RIDING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            f32706a[RoutePlanParam.RoutePlanType.DRIVING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            f32706a[RoutePlanParam.RoutePlanType.WALKING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    @Override // com.baidu.naviapi.platform.net.d
    public Map<String, String> d() {
        HashMap r100 = new HashMap();
        r100.put(PlayerResolution.SDKKEY.ORIGIN, this.f32683a);
        r100.put(com.bytedance.android.ec.core.event.a.KEY_DESTINATION, this.f32684b);
        r100.put("origin_uid", this.f32685c);
        r100.put("destination_uid", this.f32686d);
        r100.put("state", this.f32705w + "");
        r100.put("coord_type", this.f32688f);
        r100.put("ret_coordtype", this.f32689g);
        int r101 = a.f32706a[this.f32699q.ordinal()];
        if (r101 != 1) goto L5;
        r100.put("riding_type", this.f32702t + "");
        r100.put("riding_prefer", this.f32703u + "");
    L29:
        r100.put(EngineImpl.KEY_CUID, com.baidu.naviapi.platform.e.b().a());
        r100.put("timestamp", System.currentTimeMillis() + "");
        StringBuilder r102 = new StringBuilder("params ");
        r102.append(r100);
        BNLogUtil.logI("RoutePlanWrapper", r102.toString());
        r100.put("token", com.baidu.naviapi.platform.d.a("token"));
        return r100;
    L5:
        if (r101 != 2) goto L29;
        List<LocInfo.Point> r103 = this.f32700r;
        if (r103 != null) goto L10;
    L19:
        r100.put("tactics", this.f32690h + "");
        r100.put("origin_road_type", this.f32704v + "");
        r100.put("verbal_mode", this.f32698p);
        r100.put("special", this.f32701s + "");
        r100.put("radius", this.f32696n + "");
        r100.put("speed", this.f32697o + "");
        if (this.f32691i == false) goto L23;
        r100.put("cartype", this.f32692j + "");
        r100.put("plate_number", this.f32693k);
    L23:
        if (this.f32694l == (-1)) goto L26;
        r100.put("gps_direction", this.f32694l + "");
    L26:
        if (this.f32695m == (-1)) goto L29;
        r100.put("direction", this.f32695m + "");
        goto L29
    L10:
        if (r103.isEmpty() == true) goto L19;
        StringBuilder r104 = new StringBuilder();
        int r105 = 0;
    L13:
        if (r105 >= this.f32700r.size()) goto L18;
        r104.append(((LocInfo.Point) ListProtector.get(this.f32700r, r105)).getLat());
        r104.append(",");
        r104.append(((LocInfo.Point) ListProtector.get(this.f32700r, r105)).getLng());
        if (r105 == (this.f32700r.size() - 1)) goto L17;
        r104.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
    L17:
        r105 = r105 + 1;
        goto L13
    L18:
        r100.put("waypoints", r104.toString());
        goto L19
    }

    @Override // com.baidu.naviapi.platform.net.d
    public com.baidu.naviapi.platform.net.a b() {
        return this.f32687e;
    }

    @Override // com.baidu.naviapi.platform.net.d
    public RequestEntity.HttpMethod c() {
        return RequestEntity.HttpMethod.GET;
    }

    @Override // com.baidu.naviapi.platform.net.d
    public RoutePlanParam.RoutePlanType e() {
        return this.f32699q;
    }

    public e(RoutePlanParam r310, com.baidu.naviapi.platform.net.a r311) throws com.baidu.naviapi.platform.ex.b {
        this.f32694l = -1;
        this.f32695m = -1;
        this.f32696n = -1.0f;
        this.f32697o = -1.0f;
        RoutePlanParam.RoutePlanType r100 = r310.getRoutePlanType();
        double r101 = r310.getStart().getGeoPoint().getLat();
        double r102 = r310.getStart().getGeoPoint().getLng();
        double r103 = r310.getEnd().getGeoPoint().getLng();
        double r104 = r310.getEnd().getGeoPoint().getLat();
        this.f32705w = r310.getState();
        String r110 = r310.getVerbalMode();
        List<LocInfo.Point> r111 = r310.getVias();
        String r112 = r310.getSuid();
        String r113 = r310.getPlate();
        int r114 = r310.getSpecial();
        int r115 = r310.getRidingType();
        int r116 = r310.getPrefer();
        String r117 = r310.getEuid();
        String r118 = r310.geteName();
        String r119 = r310.getsName();
        int r120 = r310.getCoordType();
        if (r120 == 1) goto L10;
        if (r120 != 2) goto L6;
        String r121 = CoordinateType.BD09LL;
    L11:
        int r105 = r310.getReCoordType();
        if (r105 != 1) goto L14;
        String r106 = "wgs84";
    L21:
        int r107 = r310.getPrefer();
        int r108 = r310.getCarType();
        boolean r109 = r310.isAvoid();
        if (r101 == AudioStats.AUDIO_AMPLITUDE_NONE) goto L28;
        if (r102 == AudioStats.AUDIO_AMPLITUDE_NONE) goto L28;
        this.f32683a = String.format(Locale.getDefault(), "%.6f", new Object[]{Double.valueOf(r101)}) + "," + String.format(Locale.getDefault(), "%.6f", new Object[]{Double.valueOf(r102)});
    L31:
        if (r104 == AudioStats.AUDIO_AMPLITUDE_NONE) goto L37;
        if (r103 == AudioStats.AUDIO_AMPLITUDE_NONE) goto L37;
        this.f32684b = String.format(Locale.getDefault(), "%.6f", new Object[]{Double.valueOf(r104)}) + "," + String.format(Locale.getDefault(), "%.6f", new Object[]{Double.valueOf(r103)});
    L39:
        this.f32688f = r121;
        this.f32689g = r106;
        this.f32685c = r112;
        this.f32686d = r117;
        if (r311 == null) goto L51;
        this.f32687e = r311;
        this.f32699q = r100;
        this.f32698p = r110;
        this.f32690h = r107;
        this.f32691i = r109;
        if (r109 == true) goto L44;
    L48:
        this.f32692j = r108;
        this.f32693k = r113;
        this.f32700r = r111;
        this.f32701s = r114;
        this.f32702t = r115;
        this.f32703u = r116;
        this.f32704v = r310.getOriginRoadType();
        return;
    L44:
        if (TextUtils.isEmpty(r113) == false) goto L48;
        throw new com.baidu.naviapi.platform.ex.b("plate num is empty");
    L51:
        throw new com.baidu.naviapi.platform.ex.b("listener is null");
    L37:
        if (TextUtils.isEmpty(r118) == true) goto L53;
        this.f32684b = r118;
        goto L39
    L53:
        throw new com.baidu.naviapi.platform.ex.b();
    L28:
        if (TextUtils.isEmpty(r119) == true) goto L55;
        this.f32683a = r119;
        goto L31
    L55:
        throw new com.baidu.naviapi.platform.ex.b("start name cant be null.");
    L14:
        if (r105 != 2) goto L16;
        r106 = CoordinateType.BD09LL;
        goto L21
    L16:
        if (r105 == 4) goto L18;
        r106 = "gcj02";
        goto L21
    L18:
        r106 = CoordinateType.BD09MC;
        goto L21
    L6:
        if (r120 == 4) goto L8;
        r121 = "gcj02";
        goto L11
    L8:
        r121 = CoordinateType.BD09MC;
        goto L11
    L10:
        r121 = "wgs84";
        goto L11
    }
}
