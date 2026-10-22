package com.amap.api.col.s;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.amap.api.services.busline.BusLineResult;
import com.amap.api.services.busline.BusLineSearch;
import com.amap.api.services.busline.BusStationResult;
import com.amap.api.services.busline.BusStationSearch;
import com.amap.api.services.cloud.CloudItemDetail;
import com.amap.api.services.cloud.CloudResult;
import com.amap.api.services.cloud.CloudSearch;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.district.DistrictResult;
import com.amap.api.services.district.DistrictSearch;
import com.amap.api.services.geocoder.GeocodeResult;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.amap.api.services.geocoder.RegeocodeResult;
import com.amap.api.services.help.Inputtips;
import com.amap.api.services.nearby.NearbySearch;
import com.amap.api.services.nearby.NearbySearchResult;
import com.amap.api.services.poisearch.PoiResult;
import com.amap.api.services.poisearch.PoiSearch;
import com.amap.api.services.route.BusRouteResult;
import com.amap.api.services.route.DistanceResult;
import com.amap.api.services.route.DistanceSearch;
import com.amap.api.services.route.DriveRoutePlanResult;
import com.amap.api.services.route.DriveRouteResult;
import com.amap.api.services.route.RideRouteResult;
import com.amap.api.services.route.RouteSearch;
import com.amap.api.services.route.TruckRouteRestult;
import com.amap.api.services.route.WalkRouteResult;
import com.amap.api.services.routepoisearch.RoutePOISearch;
import com.amap.api.services.routepoisearch.RoutePOISearchResult;
import com.amap.api.services.share.ShareSearch;
import com.amap.api.services.weather.LocalWeatherForecastResult;
import com.amap.api.services.weather.LocalWeatherLiveResult;
import com.amap.api.services.weather.WeatherSearch;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes28.dex */
public final class s extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static s f26616a;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public BusLineResult f26617a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public BusLineSearch.OnBusLineSearchListener f26618b;

        public a() {
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public BusStationResult f26619a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public BusStationSearch.OnBusStationSearchListener f26620b;

        public b() {
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public CloudItemDetail f26621a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public CloudSearch.OnCloudSearchListener f26622b;

        public c() {
        }
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public CloudResult f26623a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public CloudSearch.OnCloudSearchListener f26624b;

        public d() {
        }
    }

    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public GeocodeResult f26625a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public GeocodeSearch.OnGeocodeSearchListener f26626b;

        public e() {
        }
    }

    public static class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public List<NearbySearch.NearbyListener> f26627a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public NearbySearchResult f26628b;

        public f() {
        }
    }

    public static class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public PoiItem f26629a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public PoiSearch.OnPoiSearchListener f26630b;

        public g() {
        }
    }

    public static class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public PoiResult f26631a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public PoiSearch.OnPoiSearchListener f26632b;

        public h() {
        }
    }

    public static class i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public RegeocodeResult f26633a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public GeocodeSearch.OnGeocodeSearchListener f26634b;

        public i() {
        }
    }

    public static class j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public RoutePOISearchResult f26635a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public RoutePOISearch.OnRoutePOISearchListener f26636b;

        public j() {
        }
    }

    public static class k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public LocalWeatherForecastResult f26637a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public WeatherSearch.OnWeatherSearchListener f26638b;

        public k() {
        }
    }

    public static class l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public LocalWeatherLiveResult f26639a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public WeatherSearch.OnWeatherSearchListener f26640b;

        public l() {
        }
    }

    public static synchronized s a() {
        monitor-enter(s.class);
    L16:
        th = move-exception;
        throw th;
    L5:
        if (f26616a == null) goto L7;
    L13:
        s r100 = f26616a;     // Catch: Throwable -> L16
        monitor-exit(s.class);
        return r100;
    L7:
        if (Looper.myLooper() != null) goto L9;
    L12:
        f26616a = new s(Looper.getMainLooper());     // Catch: Throwable -> L16
        goto L13
    L9:
        if (Looper.myLooper() != Looper.getMainLooper()) goto L12;
        f26616a = new s();     // Catch: Throwable -> L16
        goto L13
    }

    public s() {
    }

    private s(Looper r100) {
        super(r100);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // android.os.Handler
    public final void handleMessage(Message r100) {
    L214:
        th = move-exception;
        com.amap.api.col.s.i.a(th, "MessageHandler", "handleMessage");
        return;
    L3:
        BusLineResult r101 = null;
        NearbySearchResult r102 = null;
        BusStationResult r103 = null;
        ArrayList r104 = null;
        switch(r100.arg1) {
            case 1: goto L183;
            case 2: goto L167;
            case 3: goto L158;
            case 4: goto L154;
            case 5: goto L147;
            case 6: goto L129;
            case 7: goto L120;
            case 8: goto L110;
            case 9: goto L95;
            case 10: goto L85;
            case 11: goto L69;
            case 12: goto L57;
            case 13: goto L37;
            case 14: goto L29;
            case 15: goto L278;
            case 16: goto L21;
            case 17: goto L13;
            case 18: goto L6;
            default: goto L278;
        };
    L6:
        RouteSearch.OnRoutePlanSearchListener r105 = (RouteSearch.OnRoutePlanSearchListener) r100.obj;     // Catch: Throwable -> L214
        if (r105 != null) goto L9;
        return;
    L9:
        if (r100.what != 105) goto L272;
        Bundle r106 = r100.getData();     // Catch: Throwable -> L214
        if (r106 == null) goto L273;
        int r107 = r106.getInt("errorCode");     // Catch: Throwable -> L214
        r105.onDriveRoutePlanSearched((DriveRoutePlanResult) r100.getData().getParcelable("result"), r107);     // Catch: Throwable -> L214
        return;
    L273:
        return;
    L272:
        return;
    L13:
        RouteSearch.OnTruckRouteSearchListener r108 = (RouteSearch.OnTruckRouteSearchListener) r100.obj;     // Catch: Throwable -> L214
        if (r108 != null) goto L16;
        return;
    L16:
        if (r100.what != 104) goto L222;
        Bundle r109 = r100.getData();     // Catch: Throwable -> L214
        if (r109 == null) goto L223;
        int r110 = r109.getInt("errorCode");     // Catch: Throwable -> L214
        r108.onTruckRouteSearched((TruckRouteRestult) r100.getData().getParcelable("result"), r110);     // Catch: Throwable -> L214
        return;
    L223:
        return;
    L222:
        return;
    L21:
        DistanceSearch.OnDistanceSearchListener r111 = (DistanceSearch.OnDistanceSearchListener) r100.obj;     // Catch: Throwable -> L214
        if (r111 != null) goto L24;
        return;
    L24:
        if (r100.what != 400) goto L225;
        Bundle r112 = r100.getData();     // Catch: Throwable -> L214
        if (r112 == null) goto L226;
        int r113 = r112.getInt("errorCode");     // Catch: Throwable -> L214
        r111.onDistanceSearched((DistanceResult) r100.getData().getParcelable("result"), r113);     // Catch: Throwable -> L214
        return;
    L226:
        return;
    L225:
        return;
    L29:
        j r114 = (j) r100.obj;     // Catch: Throwable -> L214
        if (r114 == null) goto L227;
        RoutePOISearch.OnRoutePOISearchListener r115 = r114.f26636b;     // Catch: Throwable -> L214
        if (r115 == null) goto L228;
        Bundle r116 = r100.getData();     // Catch: Throwable -> L214
        if (r116 == null) goto L229;
        int r117 = r116.getInt("errorCode");     // Catch: Throwable -> L214
        r115.onRoutePoiSearched(r114.f26635a, r117);     // Catch: Throwable -> L214
        return;
    L229:
        return;
    L228:
        return;
    L227:
        return;
    L37:
        int r118 = r100.what;     // Catch: Throwable -> L214
        if (r118 != 1301) goto L48;
        l r119 = (l) r100.obj;     // Catch: Throwable -> L214
        if (r119 == null) goto L231;
        WeatherSearch.OnWeatherSearchListener r120 = r119.f26640b;     // Catch: Throwable -> L214
        if (r120 == null) goto L232;
        Bundle r121 = r100.getData();     // Catch: Throwable -> L214
        if (r121 == null) goto L230;
        int r122 = r121.getInt("errorCode");     // Catch: Throwable -> L214
        r120.onWeatherLiveSearched(r119.f26639a, r122);     // Catch: Throwable -> L214
        return;
    L230:
        return;
    L232:
        return;
    L231:
        return;
    L48:
        if (r118 != 1302) goto L233;
        k r123 = (k) r100.obj;     // Catch: Throwable -> L214
        if (r123 == null) goto L234;
        WeatherSearch.OnWeatherSearchListener r124 = r123.f26638b;     // Catch: Throwable -> L214
        if (r124 == null) goto L235;
        Bundle r125 = r100.getData();     // Catch: Throwable -> L214
        if (r125 == null) goto L236;
        int r126 = r125.getInt("errorCode");     // Catch: Throwable -> L214
        r124.onWeatherForecastSearched(r123.f26637a, r126);     // Catch: Throwable -> L214
        return;
    L236:
        return;
    L235:
        return;
    L234:
        return;
    L233:
        return;
    L57:
        int r127 = r100.what;     // Catch: Throwable -> L214
        if (r127 != 700) goto L64;
        d r128 = (d) r100.obj;     // Catch: Throwable -> L214
        if (r128 == null) goto L237;
        r128.f26624b.onCloudSearched(r128.f26623a, r100.arg2);     // Catch: Throwable -> L214
        return;
    L237:
        return;
    L64:
        if (r127 != 701) goto L238;
        c r129 = (c) r100.obj;     // Catch: Throwable -> L214
        if (r129 == null) goto L239;
        r129.f26622b.onCloudItemDetailSearched(r129.f26621a, r100.arg2);     // Catch: Throwable -> L214
        return;
    L239:
        return;
    L238:
        return;
    L69:
        int r130 = r100.arg2;     // Catch: Throwable -> L214
        ShareSearch.OnShareSearchListener r131 = (ShareSearch.OnShareSearchListener) r100.obj;     // Catch: Throwable -> L214
        String r132 = r100.getData().getString("shareurlkey");     // Catch: Throwable -> L214
        if (r131 != null) goto L72;
        return;
    L72:
        switch(r100.what) {
            case 1100: goto L83;
            case 1101: goto L81;
            case 1102: goto L80;
            case 1103: goto L78;
            case 1104: goto L76;
            case 1105: goto L74;
            default: goto L241;
        };     // Catch: Throwable -> L214
    L74:
        r131.onWalkRouteShareUrlSearched(r132, r130);     // Catch: Throwable -> L214
        return;
    L76:
        r131.onDrivingRouteShareUrlSearched(r132, r130);     // Catch: Throwable -> L214
        return;
    L78:
        r131.onBusRouteShareUrlSearched(r132, r130);     // Catch: Throwable -> L214
        return;
    L80:
        r131.onNaviShareUrlSearched(r132, r130);     // Catch: Throwable -> L214
        return;
    L81:
        r131.onLocationShareUrlSearched(r132, r130);     // Catch: Throwable -> L214
        return;
    L83:
        r131.onPoiShareUrlSearched(r132, r130);     // Catch: Throwable -> L214
        return;
    L241:
        return;
    L85:
        List r133 = (List) r100.obj;     // Catch: Throwable -> L214
        if (r133 != null) goto L88;
        return;
    L88:
        if (r133.size() == 0) goto L243;
        Iterator r134 = r133.iterator();     // Catch: Throwable -> L214
    L92:
        if (r134.hasNext() == false) goto L244;
        ((NearbySearch.NearbyListener) r134.next()).onNearbyInfoUploaded(r100.what);     // Catch: Throwable -> L214
        goto L92
    L244:
        return;
    L243:
        return;
    L95:
        f r135 = (f) r100.obj;     // Catch: Throwable -> L214
        if (r135 == null) goto L109;
        List<NearbySearch.NearbyListener> r136 = r135.f26627a;     // Catch: Throwable -> L214
        if (r136 != null) goto L100;
        return;
    L100:
        if (r136.size() != 0) goto L103;
        return;
    L103:
        if (r100.what != 1000) goto L105;
        r102 = r135.f26628b;     // Catch: Throwable -> L214
    L105:
        Iterator<NearbySearch.NearbyListener> r137 = r136.iterator();     // Catch: Throwable -> L214
    L107:
        if (r137.hasNext() == false) goto L247;
        r137.next().onNearbyInfoSearched(r102, r100.what);     // Catch: Throwable -> L214
        goto L107
    L247:
        return;
    L109:
        return;
    L110:
        List r138 = (List) r100.obj;     // Catch: Throwable -> L214
        if (r138 != null) goto L113;
        return;
    L113:
        if (r138.size() == 0) goto L248;
        Iterator r139 = r138.iterator();     // Catch: Throwable -> L214
    L117:
        if (r139.hasNext() == false) goto L249;
        ((NearbySearch.NearbyListener) r139.next()).onUserInfoCleared(r100.what);     // Catch: Throwable -> L214
        goto L117
    L249:
        return;
    L248:
        return;
    L120:
        b r140 = (b) r100.obj;     // Catch: Throwable -> L214
        if (r140 == null) goto L250;
        BusStationSearch.OnBusStationSearchListener r141 = r140.f26620b;     // Catch: Throwable -> L214
        if (r141 == null) goto L251;
        int r142 = r100.what;     // Catch: Throwable -> L214
        if (r142 != 1000) goto L127;
        r103 = r140.f26619a;     // Catch: Throwable -> L214
    L127:
        r141.onBusStationSearched(r103, r142);     // Catch: Throwable -> L214
        return;
    L251:
        return;
    L250:
        return;
    L129:
        int r143 = r100.what;     // Catch: Throwable -> L214
        if (r143 != 600) goto L140;
        h r144 = (h) r100.obj;     // Catch: Throwable -> L214
        if (r144 == null) goto L253;
        PoiSearch.OnPoiSearchListener r145 = r144.f26632b;     // Catch: Throwable -> L214
        if (r145 == null) goto L254;
        Bundle r146 = r100.getData();     // Catch: Throwable -> L214
        if (r146 == null) goto L252;
        int r147 = r146.getInt("errorCode");     // Catch: Throwable -> L214
        r145.onPoiSearched(r144.f26631a, r147);     // Catch: Throwable -> L214
        return;
    L252:
        return;
    L254:
        return;
    L253:
        return;
    L140:
        if (r143 != 602) goto L255;
        g r148 = (g) r100.obj;     // Catch: Throwable -> L214
        if (r148 == null) goto L256;
        PoiSearch.OnPoiSearchListener r149 = r148.f26630b;     // Catch: Throwable -> L214
        Bundle r150 = r100.getData();     // Catch: Throwable -> L214
        if (r150 == null) goto L257;
        int r151 = r150.getInt("errorCode");     // Catch: Throwable -> L214
        r149.onPoiItemSearched(r148.f26629a, r151);     // Catch: Throwable -> L214
        return;
    L257:
        return;
    L256:
        return;
    L255:
        return;
    L147:
        Inputtips.InputtipsListener r152 = (Inputtips.InputtipsListener) r100.obj;     // Catch: Throwable -> L214
        if (r152 != null) goto L150;
        return;
    L150:
        if (r100.what != 1000) goto L152;
        r104 = r100.getData().getParcelableArrayList("result");     // Catch: Throwable -> L214
    L152:
        r152.onGetInputtips(r104, r100.what);     // Catch: Throwable -> L214
        return;
    L154:
        DistrictSearch.OnDistrictSearchListener r153 = (DistrictSearch.OnDistrictSearchListener) r100.obj;     // Catch: Throwable -> L214
        if (r153 == null) goto L259;
        r153.onDistrictSearched((DistrictResult) r100.getData().getParcelable("result"));     // Catch: Throwable -> L214
        return;
    L259:
        return;
    L158:
        a r154 = (a) r100.obj;     // Catch: Throwable -> L214
        if (r154 == null) goto L260;
        BusLineSearch.OnBusLineSearchListener r155 = r154.f26618b;     // Catch: Throwable -> L214
        if (r155 == null) goto L261;
        int r156 = r100.what;     // Catch: Throwable -> L214
        if (r156 != 1000) goto L165;
        r101 = r154.f26617a;     // Catch: Throwable -> L214
    L165:
        r155.onBusLineSearched(r101, r156);     // Catch: Throwable -> L214
        return;
    L261:
        return;
    L260:
        return;
    L167:
        int r157 = r100.what;     // Catch: Throwable -> L214
        if (r157 != 201) goto L176;
        i r158 = (i) r100.obj;     // Catch: Throwable -> L214
        if (r158 == null) goto L262;
        GeocodeSearch.OnGeocodeSearchListener r159 = r158.f26634b;     // Catch: Throwable -> L214
        if (r159 == null) goto L263;
        r159.onRegeocodeSearched(r158.f26633a, r100.arg2);     // Catch: Throwable -> L214
        return;
    L263:
        return;
    L262:
        return;
    L176:
        if (r157 != 200) goto L264;
        e r160 = (e) r100.obj;     // Catch: Throwable -> L214
        if (r160 == null) goto L265;
        GeocodeSearch.OnGeocodeSearchListener r161 = r160.f26626b;     // Catch: Throwable -> L214
        if (r161 == null) goto L266;
        r161.onGeocodeSearched(r160.f26625a, r100.arg2);     // Catch: Throwable -> L214
        return;
    L266:
        return;
    L265:
        return;
    L264:
        return;
    L183:
        RouteSearch.OnRouteSearchListener r162 = (RouteSearch.OnRouteSearchListener) r100.obj;     // Catch: Throwable -> L214
        if (r162 == null) goto L275;
        int r163 = r100.what;     // Catch: Throwable -> L214
        if (r163 != 100) goto L192;
        Bundle r164 = r100.getData();     // Catch: Throwable -> L214
        if (r164 == null) goto L267;
        int r165 = r164.getInt("errorCode");     // Catch: Throwable -> L214
        r162.onBusRouteSearched((BusRouteResult) r100.getData().getParcelable("result"), r165);     // Catch: Throwable -> L214
        return;
    L267:
        return;
    L192:
        if (r163 != 101) goto L198;
        Bundle r166 = r100.getData();     // Catch: Throwable -> L214
        if (r166 == null) goto L268;
        int r167 = r166.getInt("errorCode");     // Catch: Throwable -> L214
        r162.onDriveRouteSearched((DriveRouteResult) r100.getData().getParcelable("result"), r167);     // Catch: Throwable -> L214
        return;
    L268:
        return;
    L198:
        if (r163 != 102) goto L204;
        Bundle r168 = r100.getData();     // Catch: Throwable -> L214
        if (r168 == null) goto L269;
        int r169 = r168.getInt("errorCode");     // Catch: Throwable -> L214
        r162.onWalkRouteSearched((WalkRouteResult) r100.getData().getParcelable("result"), r169);     // Catch: Throwable -> L214
        return;
    L269:
        return;
    L204:
        if (r163 != 103) goto L209;
        Bundle r170 = r100.getData();     // Catch: Throwable -> L214
        if (r170 == null) goto L270;
        int r171 = r170.getInt("errorCode");     // Catch: Throwable -> L214
        r162.onRideRouteSearched((RideRouteResult) r100.getData().getParcelable("result"), r171);     // Catch: Throwable -> L214
        return;
    L270:
        return;
    L209:
        if (r163 != 104) goto L276;
        Bundle r172 = r100.getData();     // Catch: Throwable -> L214
        if (r172 == null) goto L277;
        int r173 = r172.getInt("errorCode");     // Catch: Throwable -> L214
        r162.onRideRouteSearched((RideRouteResult) r100.getData().getParcelable("result"), r173);     // Catch: Throwable -> L214
        return;
    L277:
        return;
    L276:
        return;
    L275:
        return;
    }
}
