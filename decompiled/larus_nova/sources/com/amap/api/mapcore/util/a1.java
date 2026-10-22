package com.amap.api.mapcore.util;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.text.TextUtils;
import com.amap.api.maps.LocationSource;
import com.autonavi.base.ae.gmap.glyph.ReflectUtil;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes28.dex */
public class a1 implements LocationSource {
    private Method A;
    private Method B;
    private Method C;
    private Method D;
    private Method E;
    private Method F;
    private Method G;
    private Method H;
    private Method I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private boolean f26825J;
    private long K;
    private InvocationHandler L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f26826a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private LocationSource.OnLocationChangedListener f26827b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Object f26828c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Object f26829d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Object f26830e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Method f26831f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Method f26832g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Method f26833h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Method f26834i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Method f26835j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private Method f26836k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private Method f26837l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private Method f26838m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private Method f26839n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private Method f26840o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private Method f26841p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private Method f26842q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private Method f26843r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private Method f26844s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private Method f26845t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private Method f26846u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private Method f26847v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private Method f26848w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private Method f26849x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private Method f26850y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private Method f26851z;

    public class a implements InvocationHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a1 f26852a;

        public a(a1 r100) {
            this.f26852a = r100;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object r100, Method r101, Object[] r102) throws Throwable {
            if (TextUtils.equals(r101.getName(), "onLocationChanged") == true) goto L5;
        L76:
            return null;
        L5:
            if (a1.a(this.f26852a) != null) goto L7;
            return null;
        L7:
            if (r102 != null) goto L10;
            return null;
        L10:
            if (r102.length == 1) goto L12;
            return null;
        L12:
            Object r103 = r102[0];
            Location r104 = (Location) r103;
            Bundle r105 = r104.getExtras();
            if (r105 != null) goto L15;
            r105 = new Bundle();
        L15:
            Object r106 = ReflectUtil.invokeMethod(r103, a1.b(this.f26852a), new Object[0]);
            if ((r106 instanceof Integer) == false) goto L18;
            r105.putInt("errorCode", ((Integer) r106).intValue());
        L18:
            Object r107 = ReflectUtil.invokeMethod(r103, a1.m(this.f26852a), new Object[0]);
            if ((r107 instanceof String) == false) goto L21;
            r105.putString("errorInfo", (String) r107);
        L21:
            Object r108 = ReflectUtil.invokeMethod(r103, a1.o(this.f26852a), new Object[0]);
            if ((r108 instanceof Integer) == false) goto L24;
            r105.putInt("locationType", ((Integer) r108).intValue());
        L24:
            Object r109 = ReflectUtil.invokeMethod(r103, a1.p(this.f26852a), new Object[0]);
            if ((r109 instanceof Float) == false) goto L27;
            r105.putFloat("Accuracy", ((Float) r109).floatValue());
        L27:
            Object r110 = ReflectUtil.invokeMethod(r103, a1.q(this.f26852a), new Object[0]);
            if ((r110 instanceof String) == false) goto L30;
            r105.putString("AdCode", (String) r110);
        L30:
            Object r111 = ReflectUtil.invokeMethod(r103, a1.r(this.f26852a), new Object[0]);
            if ((r111 instanceof String) == false) goto L33;
            r105.putString("Address", (String) r111);
        L33:
            Object r112 = ReflectUtil.invokeMethod(r103, a1.s(this.f26852a), new Object[0]);
            if ((r112 instanceof String) == false) goto L36;
            r105.putString("AoiName", (String) r112);
        L36:
            Object r113 = ReflectUtil.invokeMethod(r103, a1.t(this.f26852a), new Object[0]);
            if ((r113 instanceof String) == false) goto L39;
            r105.putString("City", (String) r113);
        L39:
            Object r114 = ReflectUtil.invokeMethod(r103, a1.u(this.f26852a), new Object[0]);
            if ((r114 instanceof String) == false) goto L42;
            r105.putString("CityCode", (String) r114);
        L42:
            Object r115 = ReflectUtil.invokeMethod(r103, a1.c(this.f26852a), new Object[0]);
            if ((r115 instanceof String) == false) goto L45;
            r105.putString("Country", (String) r115);
        L45:
            Object r116 = ReflectUtil.invokeMethod(r103, a1.d(this.f26852a), new Object[0]);
            if ((r116 instanceof String) == false) goto L48;
            r105.putString("District", (String) r116);
        L48:
            Object r117 = ReflectUtil.invokeMethod(r103, a1.e(this.f26852a), new Object[0]);
            if ((r117 instanceof String) == false) goto L51;
            r105.putString("Street", (String) r117);
        L51:
            Object r118 = ReflectUtil.invokeMethod(r103, a1.f(this.f26852a), new Object[0]);
            if ((r118 instanceof String) == false) goto L54;
            r105.putString("StreetNum", (String) r118);
        L54:
            Object r119 = ReflectUtil.invokeMethod(r103, a1.g(this.f26852a), new Object[0]);
            if ((r119 instanceof String) == false) goto L57;
            r105.putString("PoiName", (String) r119);
        L57:
            Object r120 = ReflectUtil.invokeMethod(r103, a1.h(this.f26852a), new Object[0]);
            if ((r120 instanceof String) == false) goto L60;
            r105.putString("Province", (String) r120);
        L60:
            Object r121 = ReflectUtil.invokeMethod(r103, a1.i(this.f26852a), new Object[0]);
            if ((r121 instanceof Float) == false) goto L63;
            r105.putFloat("Speed", ((Float) r121).floatValue());
        L63:
            Object r122 = ReflectUtil.invokeMethod(r103, a1.j(this.f26852a), new Object[0]);
            if ((r122 instanceof String) == false) goto L66;
            r105.putString("Floor", (String) r122);
        L66:
            Object r123 = ReflectUtil.invokeMethod(r103, a1.k(this.f26852a), new Object[0]);
            if ((r123 instanceof Float) == false) goto L69;
            r105.putFloat("Bearing", ((Float) r123).floatValue());
        L69:
            Object r124 = ReflectUtil.invokeMethod(r103, a1.l(this.f26852a), new Object[0]);
            if ((r124 instanceof String) == false) goto L72;
            r105.putString("BuildingId", (String) r124);
        L72:
            Object r125 = ReflectUtil.invokeMethod(r103, a1.n(this.f26852a), new Object[0]);
            if ((r125 instanceof Double) == false) goto L75;
            r105.putDouble("Altitude", ((Double) r125).doubleValue());
        L75:
            r104.setExtras(r105);
            a1.a(this.f26852a).onLocationChanged(r104);
            goto L76
        }
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    @Override // com.amap.api.maps.LocationSource
    public void deactivate() {
        this.f26827b = null;
        Object r100 = this.f26828c;
        if (r100 == null) goto L5;
        ReflectUtil.invokeMethod(r100, this.f26834i, new Object[0]);
        ReflectUtil.invokeMethod(this.f26828c, this.f26835j, new Object[0]);
    L5:
        this.f26828c = null;
    }

    private void a() {
        this.f26841p = ReflectUtil.getMethod("com.amap.api.location.AMapLocation", "getErrorCode", new Class[0]);     // Catch: Exception -> L43
        this.f26842q = ReflectUtil.getMethod("com.amap.api.location.AMapLocation", "getErrorInfo", new Class[0]);     // Catch: Exception -> L43
        this.f26843r = ReflectUtil.getMethod("com.amap.api.location.AMapLocation", "getLocationType", new Class[0]);     // Catch: Exception -> L43
        this.f26844s = ReflectUtil.getMethod("com.amap.api.location.AMapLocation", "getAccuracy", new Class[0]);     // Catch: Exception -> L43
        this.f26845t = ReflectUtil.getMethod("com.amap.api.location.AMapLocation", "getAdCode", new Class[0]);     // Catch: Exception -> L43
        this.f26846u = ReflectUtil.getMethod("com.amap.api.location.AMapLocation", "getAddress", new Class[0]);     // Catch: Exception -> L43
        this.f26847v = ReflectUtil.getMethod("com.amap.api.location.AMapLocation", "getAoiName", new Class[0]);     // Catch: Exception -> L43
        this.f26848w = ReflectUtil.getMethod("com.amap.api.location.AMapLocation", "getCity", new Class[0]);     // Catch: Exception -> L43
        this.f26849x = ReflectUtil.getMethod("com.amap.api.location.AMapLocation", "getCityCode", new Class[0]);     // Catch: Exception -> L43
        this.f26850y = ReflectUtil.getMethod("com.amap.api.location.AMapLocation", "getCountry", new Class[0]);     // Catch: Exception -> L43
        this.f26851z = ReflectUtil.getMethod("com.amap.api.location.AMapLocation", "getDistrict", new Class[0]);     // Catch: Exception -> L43
        this.A = ReflectUtil.getMethod("com.amap.api.location.AMapLocation", "getStreet", new Class[0]);     // Catch: Exception -> L43
        this.B = ReflectUtil.getMethod("com.amap.api.location.AMapLocation", "getStreetNum", new Class[0]);     // Catch: Exception -> L43
        this.C = ReflectUtil.getMethod("com.amap.api.location.AMapLocation", "getPoiName", new Class[0]);     // Catch: Exception -> L43
        this.D = ReflectUtil.getMethod("com.amap.api.location.AMapLocation", "getProvince", new Class[0]);     // Catch: Exception -> L43
        this.E = ReflectUtil.getMethod("com.amap.api.location.AMapLocation", "getSpeed", new Class[0]);     // Catch: Exception -> L43
        this.F = ReflectUtil.getMethod("com.amap.api.location.AMapLocation", "getFloor", new Class[0]);     // Catch: Exception -> L43
        this.G = ReflectUtil.getMethod("com.amap.api.location.AMapLocation", "getBearing", new Class[0]);     // Catch: Exception -> L43
        this.H = ReflectUtil.getMethod("com.amap.api.location.AMapLocation", "getBuildingId", new Class[0]);     // Catch: Exception -> L43
        this.I = ReflectUtil.getMethod("com.amap.api.location.AMapLocation", "getAltitude", new Class[0]);     // Catch: Exception -> L43
        return;
    L43:
        e = move-exception;
        e.printStackTrace();
    }

    private void b() {
        this.f26831f = ReflectUtil.getMethod("com.amap.api.location.AMapLocationClient", "setLocationListener", new Class[]{INVOKESTATIC_com_amap_api_mapcore_util_a1_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.amap.api.location.AMapLocationListener")});     // Catch: Exception -> L13
        this.f26832g = ReflectUtil.getMethod("com.amap.api.location.AMapLocationClient", "setLocationOption", new Class[]{INVOKESTATIC_com_amap_api_mapcore_util_a1_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.amap.api.location.AMapLocationClientOption")});     // Catch: Exception -> L13
        this.f26833h = ReflectUtil.getMethod("com.amap.api.location.AMapLocationClient", "startLocation", new Class[0]);     // Catch: Exception -> L13
        this.f26834i = ReflectUtil.getMethod("com.amap.api.location.AMapLocationClient", "stopLocation", new Class[0]);     // Catch: Exception -> L13
        this.f26835j = ReflectUtil.getMethod("com.amap.api.location.AMapLocationClient", LiveCommonConstants.REASON_ON_DEDTROY, new Class[0]);     // Catch: Exception -> L13
        return;
    L13:
        e = move-exception;
        e.printStackTrace();
    }

    private void c() {
        this.f26836k = ReflectUtil.getMethod("com.amap.api.location.AMapLocationClientOption", "setInterval", new Class[]{Long.TYPE});     // Catch: Exception -> L13
        Class r100 = Boolean.TYPE;     // Catch: Exception -> L13
        this.f26837l = ReflectUtil.getMethod("com.amap.api.location.AMapLocationClientOption", "setOnceLocation", new Class[]{r100});     // Catch: Exception -> L13
        this.f26838m = ReflectUtil.getMethod("com.amap.api.location.AMapLocationClientOption", "setLocationMode", new Class[]{INVOKESTATIC_com_amap_api_mapcore_util_a1_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.amap.api.location.AMapLocationClientOption$AMapLocationMode")});     // Catch: Exception -> L13
        this.f26839n = ReflectUtil.getMethod("com.amap.api.location.AMapLocationClientOption", "setNeedAddress", new Class[]{r100});     // Catch: Exception -> L13
        this.f26840o = ReflectUtil.getMethod("com.amap.api.location.AMapLocationClientOption", "getInterval", new Class[0]);     // Catch: Exception -> L13
        return;
    L13:
        e = move-exception;
        e.printStackTrace();
    }

    public a1(Context r100) {
        this.f26825J = false;
        this.K = 2000;
        this.L = new a(this);
        this.f26826a = r100;
        b();
        c();
        a();
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_amap_api_mapcore_util_a1_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class r103 = access$000(r100);     // Catch: Throwable -> L8
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r103;
    L8:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class r104 = access$000(r100);     // Catch: Throwable -> L17
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r104;
    L17:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r100);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r100);
    }

    private void a(boolean r100) {
        if (this.f26829d == null) goto L15;
        Object r101 = this.f26828c;
        if (r101 == null) goto L15;
        ReflectUtil.invokeMethod(r101, this.f26835j, new Object[0]);     // Catch: Exception -> L13
        this.f26828c = ReflectUtil.newInstance("com.amap.api.location.AMapLocationClient", new Class[]{Context.class}, new Object[]{this.f26826a});     // Catch: Exception -> L13
        Object r102 = Proxy.newProxyInstance(getClass().getClassLoader(), new Class[]{INVOKESTATIC_com_amap_api_mapcore_util_a1_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.amap.api.location.AMapLocationListener")}, this.L);     // Catch: Exception -> L13
        this.f26830e = r102;     // Catch: Exception -> L13
        ReflectUtil.invokeMethod(this.f26828c, this.f26831f, new Object[]{r102});     // Catch: Exception -> L13
        ReflectUtil.invokeMethod(this.f26829d, this.f26837l, new Object[]{Boolean.valueOf(r100)});     // Catch: Exception -> L13
        ReflectUtil.invokeMethod(this.f26829d, this.f26839n, new Object[]{Boolean.FALSE});     // Catch: Exception -> L13
        if (r100 == true) goto L11;
        ReflectUtil.invokeMethod(this.f26829d, this.f26836k, new Object[]{Long.valueOf(this.K)});     // Catch: Exception -> L13
    L11:
        ReflectUtil.invokeMethod(this.f26828c, this.f26832g, new Object[]{this.f26829d});     // Catch: Exception -> L13
        ReflectUtil.invokeMethod(this.f26828c, this.f26833h, new Object[0]);     // Catch: Exception -> L13
    L13:
        e = move-exception;
        e.printStackTrace();
    L15:
        this.f26825J = r100;
    }

    public static /* synthetic */ Method b(a1 r100) {
        return r100.f26841p;
    }

    public static /* synthetic */ Method c(a1 r100) {
        return r100.f26850y;
    }

    public static /* synthetic */ Method d(a1 r100) {
        return r100.f26851z;
    }

    public static /* synthetic */ Method e(a1 r100) {
        return r100.A;
    }

    public static /* synthetic */ Method f(a1 r100) {
        return r100.B;
    }

    public static /* synthetic */ Method g(a1 r100) {
        return r100.C;
    }

    public static /* synthetic */ Method h(a1 r100) {
        return r100.D;
    }

    public static /* synthetic */ Method i(a1 r100) {
        return r100.E;
    }

    public static /* synthetic */ Method j(a1 r100) {
        return r100.F;
    }

    public static /* synthetic */ Method k(a1 r100) {
        return r100.G;
    }

    public static /* synthetic */ Method l(a1 r100) {
        return r100.H;
    }

    public static /* synthetic */ Method m(a1 r100) {
        return r100.f26842q;
    }

    public static /* synthetic */ Method n(a1 r100) {
        return r100.I;
    }

    public static /* synthetic */ Method o(a1 r100) {
        return r100.f26843r;
    }

    public static /* synthetic */ Method p(a1 r100) {
        return r100.f26844s;
    }

    public static /* synthetic */ Method q(a1 r100) {
        return r100.f26845t;
    }

    public static /* synthetic */ Method r(a1 r100) {
        return r100.f26846u;
    }

    public static /* synthetic */ Method s(a1 r100) {
        return r100.f26847v;
    }

    public static /* synthetic */ Method t(a1 r100) {
        return r100.f26848w;
    }

    public static /* synthetic */ Method u(a1 r100) {
        return r100.f26849x;
    }

    @Override // com.amap.api.maps.LocationSource
    public void activate(LocationSource.OnLocationChangedListener r100) {
        this.f26827b = r100;
        if (u5.a(this.f26826a, w3.b()).f28191a == u5.e.f28083b) goto L6;
        return;
    L6:
        if (this.f26828c == null) goto L17;
        return;
    L17:
        Object r101 = ReflectUtil.newInstance("com.amap.api.location.AMapLocationClient", new Class[]{Context.class}, new Object[]{this.f26826a});     // Catch: Exception -> L14
        this.f26828c = r101;     // Catch: Exception -> L14
        if (r101 != null) goto L12;
        return;
    L12:
        this.f26829d = ReflectUtil.newInstance("com.amap.api.location.AMapLocationClientOption", null, null);     // Catch: Exception -> L14
        Object r102 = Proxy.newProxyInstance(getClass().getClassLoader(), new Class[]{INVOKESTATIC_com_amap_api_mapcore_util_a1_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.amap.api.location.AMapLocationListener")}, this.L);     // Catch: Exception -> L14
        this.f26830e = r102;     // Catch: Exception -> L14
        ReflectUtil.invokeMethod(this.f26828c, this.f26831f, new Object[]{r102});     // Catch: Exception -> L14
        ReflectUtil.invokeMethod(this.f26829d, this.f26836k, new Object[]{Long.valueOf(this.K)});     // Catch: Exception -> L14
        ReflectUtil.invokeMethod(this.f26829d, this.f26837l, new Object[]{Boolean.valueOf(this.f26825J)});     // Catch: Exception -> L14
        ReflectUtil.invokeMethod(this.f26829d, this.f26838m, new Object[]{ReflectUtil.getField("com.amap.api.location.AMapLocationClientOption$AMapLocationMode", null, "Hight_Accuracy")});     // Catch: Exception -> L14
        ReflectUtil.invokeMethod(this.f26829d, this.f26839n, new Object[]{Boolean.FALSE});     // Catch: Exception -> L14
        ReflectUtil.invokeMethod(this.f26828c, this.f26832g, new Object[]{this.f26829d});     // Catch: Exception -> L14
        ReflectUtil.invokeMethod(this.f26828c, this.f26833h, new Object[0]);     // Catch: Exception -> L14
        return;
    L14:
        e = move-exception;
        e.printStackTrace();
    }

    public void a(long r100) {
        Object r101 = this.f26829d;
        if (r101 != null) goto L5;
    L11:
        this.K = r100;
        return;
    L5:
        if (this.f26828c == null) goto L11;
        Object r102 = ReflectUtil.invokeMethod(r101, this.f26840o, new Object[0]);
        if ((r102 instanceof Long) == false) goto L11;
        if (((Long) r102).longValue() == r100) goto L11;
        ReflectUtil.invokeMethod(this.f26829d, this.f26836k, new Object[]{Long.valueOf(r100)});
        ReflectUtil.invokeMethod(this.f26828c, this.f26832g, new Object[]{this.f26829d});
        goto L11
    }

    public void a(int r100) {
        if (r100 == 1) goto L7;
        if (r100 == 0) goto L7;
        a(false);
        return;
    L7:
        a(true);
    }

    public static /* synthetic */ LocationSource.OnLocationChangedListener a(a1 r100) {
        return r100.f26827b;
    }
}
