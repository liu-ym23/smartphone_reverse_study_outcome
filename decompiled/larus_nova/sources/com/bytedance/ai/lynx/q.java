package com.bytedance.ai.lynx;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.util.LruCache;
import android.view.View;
import com.bytedance.ai.model.AppletRuntimeManager;
import com.dtf.face.config.IConstValues;
import com.ivy.ivykit.api.plugin.IIvyLynxRuntimeService;
import com.larus.utils.logger.FLogger;
import com.lynx.tasm.LynxEnv;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final q f36678a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, Object> f36679b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ConcurrentHashMap<String, Map<String, Object>> f36680c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final LruCache<String, Map<String, Object>> f36681d = null;

    public q() {
    }

    public final synchronized void a() {
        monitor-enter(this);
        f36681d.evictAll();     // Catch: Throwable -> L6
        f36680c.clear();     // Catch: Throwable -> L6
        ((LinkedHashMap) f36679b).clear();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    static {
        f36678a = new q();
        f36679b = new LinkedHashMap();
        f36680c = new ConcurrentHashMap();
        f36681d = new LruCache(1024);
    }

    public static Map b() {
        h2.a r100 = f2.b.f475099c;
        if (r100 == null) goto L9;
        LinkedHashMap r101 = new LinkedHashMap();
        r101.put("channel", r100.f483569h);
        r101.put("aid", Integer.valueOf(r100.f483565d));
        r101.put("appName", r100.f483564c);
        r101.put("appVersion", r100.f483566e);
        r101.put("updateVersionCode", r100.f483570i);
        String r102 = r100.f483563b;
        if (r102 != null) goto L7;
        r102 = "";
    L7:
        r101.put("deviceId", r102);
        r101.put("isOversea", Boolean.valueOf(r100.f483571j));
        return r101;
    L9:
        return new LinkedHashMap();
    }

    public static Map e() {
        Map<String, Object> r100 = f36679b;
        if ((!r100.isEmpty()) == false) goto L5;
        return r100;
    L5:
        h2.a r101 = f2.b.f475099c;
        if (r101 == null) goto L8;
        Context r102 = r101.f483562a;
    L9:
        if (r102 == null) goto L11;
        LinkedHashMap r103 = new LinkedHashMap();
        String r104 = Build.MODEL;
        r103.put("deviceModel", r104);
        r103.put("os", "android");
        r103.put("osVersion", Build.VERSION.RELEASE);
        IIvyLynxRuntimeService.Companion r105 = IIvyLynxRuntimeService.f278333a;
        r103.put("language", r105.getLanguage());
        r103.put("deviceBrand", Build.BRAND);
        r103.put("density", Float.valueOf(r105.c(r102)));
        r103.put(IConstValues.DEVICE_TYPE, r104);
        r103.put("useXBridge3", Boolean.TRUE);
        r103.put("usePiperData", Boolean.FALSE);
        r100.putAll(r103);
    L11:
        return r100;
    L8:
        r102 = null;
        goto L9
    }

    public static Map c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "bid");
        String r101 = String.valueOf(r100);
        if (f2.b.a() == false) goto L19;
        ConcurrentHashMap<String, Map<String, Object>> r102 = f36680c;
        Map<String, Object> r103 = r102.get(r101);
        if (r103 != null) goto L17;
        q r104 = f36678a;
        monitor-enter(r104);
        LinkedHashMap r105 = new LinkedHashMap();     // Catch: Throwable -> L13
        com.bytedance.ai.utils.g.f37637a.i("AppletLynxView", "getCommonGlobalProps withoutCache");     // Catch: Throwable -> L13
        r105.putAll(e());     // Catch: Throwable -> L13
        r105.putAll(b());     // Catch: Throwable -> L13
        r105.putAll(d(r100));     // Catch: Throwable -> L13
        LinkedHashMap r106 = new LinkedHashMap();     // Catch: Throwable -> L13
        r106.put("lynxSdkVersion", LynxEnv.inst().getLynxVersion());     // Catch: Throwable -> L13
        r105.putAll(r106);     // Catch: Throwable -> L13
        monitor-exit(r104);
        r103 = r102.putIfAbsent(r101, r105);
        if (r103 != null) goto L17;
        r103 = r105;
    L13:
        th = move-exception;
        throw th;
    L17:
        return r103;
    L19:
        return new LinkedHashMap();
    }

    public static Map d(String r110) {
        com.bytedance.ai.utils.g r100 = com.bytedance.ai.utils.g.f37637a;
        r100.i("AppletLynxView", "getCommonPageProps by provider bid:" + r110);
        LinkedHashMap r111 = new LinkedHashMap();
        h2.a r101 = f2.b.f475099c;
        if (r101 == null) goto L26;
        Context r102 = r101.f483562a;
        if (r102 == null) goto L26;
        IIvyLynxRuntimeService.Companion r103 = IIvyLynxRuntimeService.f278333a;
        r111.putAll(r103.a(r102));
        Pair<Integer, Integer> r104 = r103.b(r102);
        int r105 = 0;
        if (r104 == null) goto L9;
        int r106 = r104.getFirst().intValue();
    L10:
        if (r104 == null) goto L12;
        int r107 = r104.getSecond().intValue();
    L13:
        int r108 = com.bytedance.ai.utils.o.f37679a;
        int r109 = com.bytedance.ai.utils.o.d(s4.a.b(r102, false), r102);
        if (r102.getResources().getConfiguration().orientation != 2) goto L16;
        r105 = 1;
    L16:
        if (r106 == 0) goto L18;
        if (r107 == 0) goto L18;
    L23:
        int r112 = com.bytedance.ai.utils.o.d(r106, r102);
        int r113 = com.bytedance.ai.utils.o.d(r107, r102);
        r111.put("screenWidth", Integer.valueOf(r112));
        r111.put("screenHeight", Integer.valueOf(r113));
        r111.put("screenWidthPx", Integer.valueOf(r106));
        r111.put("screenHeightPx", Integer.valueOf(r107));
        r111.put("statusBarHeight", Integer.valueOf(r109));
        r111.put("topHeight", Integer.valueOf(r109));
        r111.put("isLandscape", Integer.valueOf(r105));
        r111.put("appTheme", t2.a.a(r102));
        if (r106 != 0) goto L26;
        r100.e("AppletLynxView", "getScreenWidth exp, is by application");
    L18:
        r100.i("AppletLynxView", "getScreenSize by application exp width:" + r106 + ", height: " + r107);
        s4.f r114 = s4.f.f540533a;
        int r115 = s4.f.b(r102);
        int r116 = s4.f.a(r102);
        if (r105 == 0) goto L21;
        int r117 = Math.max(r115, r116);
        r107 = Math.min(r115, r116);
    L22:
        r106 = r117;
        goto L23
    L21:
        r117 = Math.min(r115, r116);
        r107 = Math.max(r115, r116);
        goto L22
    L12:
        r107 = 0;
        goto L13
    L9:
        r106 = 0;
    L26:
        return r111;
    }

    public static Map f(Context r110) {
        if (r110 != null) goto L6;
    L15:
        Activity r100 = null;
    L17:
        if (r100 == null) goto L60;
        com.bytedance.ai.utils.g r101 = com.bytedance.ai.utils.g.f37637a;
        r101.d("AppletLynxView", "===getPageGlobalPropsByActivity: " + r100.hashCode());
        StringBuilder r102 = new StringBuilder();
        r102.append(r100.hashCode());
        r102.append('_');
        int r103 = 1;
        boolean r104 = true;
        if (r100.getResources().getConfiguration().orientation != 2) goto L21;
        boolean r105 = true;
    L22:
        r102.append(r105);
        String r106 = r102.toString();
        LruCache<String, Map<String, Object>> r107 = f36681d;
        if (r107.get(r106) == null) goto L25;
        Map<String, Object> r108 = r107.get(r106);
        r101 = r101;
    L57:
        if (r108.get("screenWidth") != null) goto L59;
        r101.i("AppletLynxView", "getScreenWidth exp, is by cache :" + r104);
    L59:
        return r108;
    L25:
        LinkedHashMap r109 = new LinkedHashMap();
        IIvyLynxRuntimeService.Companion r111 = IIvyLynxRuntimeService.f278333a;
        Pair<Integer, Integer> r112 = r111.b(r100);
        if (r112 == null) goto L28;
        int r113 = r112.getFirst().intValue();
    L29:
        if (r112 == null) goto L31;
        int r114 = r112.getSecond().intValue();
    L33:
        if (r100.getResources().getConfiguration().orientation == 2) goto L36;
        r103 = 0;
    L36:
        int r115 = r111.getStatusBarHeight(r100);
        Rect r116 = new Rect();
        View r117 = r100.getWindow().getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L41;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r118 = ThreadMethodProxy.currentThread();
        if (r118 == com.larus.home.impl.utils.c.f346341a) goto L41;
        com.larus.home.impl.utils.c.a(r118, "getDecorView");
    L41:
        r117.getWindowVisibleDisplayFrame(r116);
        int r119 = r117.getHeight();
        int r120 = r116.top;
        int r121 = r116.bottom;
        if (r119 != 0) goto L45;
        if (r120 != 0) goto L45;
        r121 = r121 + r115;
    L45:
        if (r113 == 0) goto L47;
        if (r114 == 0) goto L47;
    L51:
        int r122 = com.bytedance.ai.utils.o.d(r113, r100);
        r109.put("screenWidth", Integer.valueOf(r122));
        r109.put("contentWidth", Integer.valueOf(r122));
        r109.put("screenHeight", Integer.valueOf(com.bytedance.ai.utils.o.d(r114, r100)));
        r109.put("screenWidthPx", Integer.valueOf(r113));
        r109.put("screenHeightPx", Integer.valueOf(r114));
        r109.put("screenOrientation", Integer.valueOf(r103));
        int r123 = Math.max(r114 - r121, 0);
        int r124 = Math.max((r114 - r123) - r115, 0);
        double r125 = r115;
        r109.put("statusBarHeight", Integer.valueOf(com.bytedance.ai.utils.o.d(r125, r100)));
        int r126 = com.bytedance.ai.utils.o.d(r125, r100);
        r109.put("topHeight", Integer.valueOf(r126));
        int r127 = com.bytedance.ai.utils.o.d(r123, r100);
        r109.put("bottomHeight", Integer.valueOf(r127));
        int r128 = com.bytedance.ai.utils.o.d(r124, r100);
        r109.put("contentHeight", Integer.valueOf(r128));
        r109.put("safeAreaHeight", Integer.valueOf(r128));
        if (r103 == 0) goto L54;
        LinkedHashMap r129 = new LinkedHashMap();
        r129.put("marginTop", 0);
        r129.put("marginBottom", 0);
        r129.put("marginLeft", Integer.valueOf(r126));
        r129.put("marginRight", Integer.valueOf(r127));
        r109.put("safeArea", r129);
    L55:
        r109.put("appTheme", t2.a.a(r100));
        r107.put(r106, r109);
        r108 = r109;
        r104 = false;
        goto L57
    L54:
        LinkedHashMap r130 = new LinkedHashMap();
        r130.put("marginTop", Integer.valueOf(r126));
        r130.put("marginBottom", Integer.valueOf(r127));
        r130.put("marginLeft", 0);
        r130.put("marginRight", 0);
        r109.put("safeArea", r130);
    L47:
        r101.i("AppletLynxView", "getScreenSize exp width:" + r113 + ", height: " + r114);
        s4.f r131 = s4.f.f540533a;
        int r132 = s4.f.b(r100);
        int r133 = s4.f.a(r100);
        if (r103 == 0) goto L50;
        r113 = Math.max(r132, r133);
        r114 = Math.min(r132, r133);
        goto L51
    L50:
        r113 = Math.min(r132, r133);
        r114 = Math.max(r132, r133);
        goto L51
    L31:
        r114 = 0;
        goto L33
    L28:
        r113 = 0;
        goto L29
    L21:
        r105 = false;
        goto L22
    L60:
        com.bytedance.ai.utils.g.f37637a.i("AppletLynxView", "===getPageGlobalPropsByActivity: activity is null");
        return null;
    L6:
        if ((r110 instanceof Activity) == false) goto L8;
        r100 = (Activity) r110;
        goto L17
    L8:
        AppletRuntimeManager.INSTANCE.getClass();
        g2.b r134 = AppletRuntimeManager.f36749d;
        if (r134 == null) goto L12;
        r100 = r134.currentActivity();
        if (r100 != null) goto L17;
    L12:
        g2.b r135 = AppletRuntimeManager.f36749d;
        if (r135 == null) goto L15;
        r100 = r135.O();
        goto L17
    }
}
