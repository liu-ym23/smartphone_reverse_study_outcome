package com.bytedance.android.ec.core.utils;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.Point;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import com.android.ttcjpaysdk.base.utils.CJPayGestureUtils;
import com.bytedance.android.ec.base.settings.SDKSettingsCacheManager;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.hybrid.hostapi.IECHybridKevaService;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.services.apm.api.EnsureManager;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class k1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f45626a = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f45627b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static int f45628c = -1;

    public static Context c() {
        return ECAppInfoService.f48114e.getApplicationContext();
    }

    public static int q() {
        if (f45628c != (-1)) goto L6;
        f45628c = p();
    L6:
        return f45628c;
    }

    public static int g() {
        Context r100 = c();
        if (r100 != null) goto L5;
        return 0;
    L5:
        Resources r101 = r100.getResources();
        int r102 = r101.getIdentifier(CJPayGestureUtils.IMMERSION_NAVIGATION_BAR_HEIGHT, "dimen", "android");
        if (r102 > 0) goto L8;
        return 0;
    L8:
        return r101.getDimensionPixelSize(r102);
    }

    public static int i() {
        Context r100 = c();
        if (r100 != null) goto L5;
        return 0;
    L5:
        WindowManager r101 = (WindowManager) r100.getSystemService(LiveEndPageData.TAG_WINDOW);
        if (r101 == null) goto L12;
        Display r102 = r101.getDefaultDisplay();
        Point r103 = new Point();
        if (r102 != null) goto L10;
        return 0;
    L10:
        r102.getSize(r103);
        return r103.y;
    L12:
        Resources r104 = r100.getResources();
        return WindowDisplayMetricsOverride.apply(r104, r104.getDisplayMetrics()).heightPixels;
    }

    public static int k() {
        float r100 = j(c());
        Resources r101 = Resources.getSystem();
        return (int) (r100 / WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()).density);
    }

    public static int l() {
        return m(c());
    }

    public static int o() {
        float r100 = m(c());
        Resources r101 = Resources.getSystem();
        return (int) (r100 / WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()).density);
    }

    public static int p() {
        Context r100 = c();
        if (r100 != null) goto L5;
        return 0;
    L5:
        Resources r101 = r100.getResources();
        int r102 = r101.getIdentifier("status_bar_height", "dimen", "android");
        if (r102 > 0) goto L8;
        return 0;
    L8:
        return r101.getDimensionPixelSize(r102);
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r103 = Class.forName(r100);     // Catch: Throwable -> L8
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
        Class<?> r104 = Class.forName(r100);     // Catch: Throwable -> L17
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

    public static View b(Window r100) {
        View r101 = r100.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == com.larus.home.impl.utils.c.f346341a) goto L7;
        com.larus.home.impl.utils.c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    public static int d(Context r100) {
        if (r100 != null) goto L6;
        return 0;
    L6:
        if ((r100 instanceof Activity) == false) goto L8;
        WindowManager r101 = ((Activity) r100).getWindowManager();
    L9:
        Display r102 = r101.getDefaultDisplay();
        DisplayMetrics r103 = new DisplayMetrics();
        a("android.view.Display").getMethod("getRealMetrics", new Class[]{DisplayMetrics.class}).invoke(r102, new Object[]{r103});     // Catch: Exception -> L12
        return r103.heightPixels;
    L12:
        e = move-exception;
        int r104 = j(r100);
        e.printStackTrace();
        return r104;
    L8:
        r101 = (WindowManager) r100.getSystemService(LiveEndPageData.TAG_WINDOW);
        goto L9
    }

    public static int e(Context r100) {
        Object r101 = null;
        if (r100 == null) goto L5;
        Activity r102 = t(r100);
    L6:
        if (r102 != null) goto L8;
        r102 = ECAppInfoService.f48114e.getCurrentActivity();
    L8:
        int r103 = 0;
        if (r102 != null) goto L11;
        return 0;
    L11:
        Lazy r104 = ECSettingKeys.f43616a;
        int r105 = com.bytedance.android.ec.base.settings.b.f42814a;
        Object r106 = Boolean.TRUE;
        Result.Companion r107 = Result.Companion;     // Catch: Throwable -> L180
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L180
        SDKSettingsCacheManager r108 = SDKSettingsCacheManager.f42812e;     // Catch: Throwable -> L180
        r108.getClass();     // Catch: Throwable -> L67
        Object r109 = SDKSettingsCacheManager.f42809b.get("ec_fix_content_frame_layout_npe");     // Catch: Throwable -> L67
        if (r109 != null) goto L19;
    L64:
        Object r110 = null;
    L65:
        Object r111 = Result.m9449constructorimpl(r110);     // Catch: Throwable -> L67
    L69:
        Throwable r112 = Result.m9452exceptionOrNullimpl(r111);     // Catch: Throwable -> L180
        if (r112 == null) goto L73;
        EnsureManager.ensureNotReachHere(r112);     // Catch: Throwable -> L180
    L73:
        if (Result.m9455isFailureimpl(r111) == false) goto L76;
        r111 = null;
    L76:
        if ((r111 instanceof Boolean) == true) goto L78;
        r111 = null;
    L78:
        Object r113 = (Boolean) r111;     // Catch: Throwable -> L180
        if (r113 != null) goto L85;
        r108.getClass();     // Catch: Throwable -> L180
        Object r114 = SDKSettingsCacheManager.f42808a.get("ec_fix_content_frame_layout_npe");     // Catch: Throwable -> L180
        if ((r114 instanceof Boolean) == true) goto L84;
        r114 = null;
    L84:
        r113 = (Boolean) r114;     // Catch: Throwable -> L180
    L85:
        if (r113 != null) goto L190;
        int r115 = com.bytedance.android.ec.base.settings.g.f42821a;     // Catch: Throwable -> L180
    L167:
        th = move-exception;
        Result.Companion r116 = Result.Companion;     // Catch: Throwable -> L180
        Object r117 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L180
    L169:
        Object r118 = r117;
        if (Result.m9452exceptionOrNullimpl(r118) != null) goto L215;
    L177:
        r113 = r118;
    L178:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L180
        SDKSettingsCacheManager.e("ec_fix_content_frame_layout_npe", r113);     // Catch: Throwable -> L180
        goto L190
    L215:
        r118 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("ec_fix_content_frame_layout_npe", Boolean.class, r106);     // Catch: Throwable -> L174
    L175:
        if (r118 != null) goto L177;
        r113 = r106;
    L174:
        r118 = r106;
        goto L175
    L223:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L141
        Object r119 = SDKSettingsCacheManager.f42809b.get("ec_fix_content_frame_layout_npe");     // Catch: Throwable -> L141
        if (r119 != null) goto L93;
    L138:
        Object r120 = null;
    L139:
        Object r121 = Result.m9449constructorimpl(r120);     // Catch: Throwable -> L141
    L143:
        Throwable r122 = Result.m9452exceptionOrNullimpl(r121);     // Catch: Throwable -> L167
        if (r122 == null) goto L147;
        EnsureManager.ensureNotReachHere(r122);     // Catch: Throwable -> L167
    L147:
        if (Result.m9455isFailureimpl(r121) == false) goto L150;
        r121 = null;
    L150:
        if ((r121 instanceof Boolean) == true) goto L152;
        r121 = null;
    L152:
        r118 = (Boolean) r121;     // Catch: Throwable -> L167
        if (r118 != null) goto L177;
        jj4.b r123 = jj4.b.f499326b;     // Catch: Throwable -> L167
        Object r124 = jj4.a.a("ec_fix_content_frame_layout_npe", Boolean.class, r106, false);     // Catch: Throwable -> L167
        if (r124 != null) goto L159;
        Intrinsics.throwNpe();     // Catch: Throwable -> L167
    L159:
        if ((r124 instanceof Boolean) == false) goto L162;
        r101 = r124;
    L162:
        Object r125 = (Boolean) r101;     // Catch: Throwable -> L167
        if (r125 != null) goto L165;
        r125 = r106;
    L165:
        r117 = Result.m9449constructorimpl(r125);     // Catch: Throwable -> L167
    L93:
        if ((r119 instanceof Boolean) == true) goto L95;
        Object r126 = null;
    L96:
        r120 = (Boolean) r126;     // Catch: Throwable -> L141
        if (r120 != null) goto L139;
        if ((r119 instanceof Number) == false) goto L126;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L108;
        Float r127 = Float.valueOf(((Number) r119).floatValue());     // Catch: Throwable -> L141
        if ((r127 instanceof Boolean) == true) goto L106;
        r127 = null;
    L106:
        r120 = (Boolean) r127;     // Catch: Throwable -> L141
        goto L139
    L108:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L114;
        Double r128 = Double.valueOf(((Number) r119).doubleValue());     // Catch: Throwable -> L141
        if ((r128 instanceof Boolean) == true) goto L112;
        r128 = null;
    L112:
        r120 = (Boolean) r128;     // Catch: Throwable -> L141
        goto L139
    L114:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L120;
        Integer r129 = Integer.valueOf(((Number) r119).intValue());     // Catch: Throwable -> L141
        if ((r129 instanceof Boolean) == true) goto L118;
        r129 = null;
    L118:
        r120 = (Boolean) r129;     // Catch: Throwable -> L141
        goto L139
    L120:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L126;
        Long r130 = Long.valueOf(((Number) r119).longValue());     // Catch: Throwable -> L141
        if ((r130 instanceof Boolean) == true) goto L124;
        r130 = null;
    L124:
        r120 = (Boolean) r130;     // Catch: Throwable -> L141
    L126:
        if ((r119 instanceof JSONObject) == false) goto L128;
    L213:
        Object r131 = SDKSettingsCacheManager.a().fromJson(r119.toString(), Boolean.class);     // Catch: Throwable -> L134
        if ((r131 instanceof Boolean) == true) goto L132;
        r131 = null;
    L132:
        Object r132 = Result.m9449constructorimpl((Boolean) r131);     // Catch: Throwable -> L134
    L136:
        r120 = r132;
        if (Result.m9455isFailureimpl(r120) == false) goto L139;
    L134:
        th = move-exception;
        Result.Companion r133 = Result.Companion;     // Catch: Throwable -> L141
        r132 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L141
        goto L136
    L128:
        if ((r119 instanceof JSONArray) == false) goto L138;
    L95:
        r126 = r119;
    L141:
        th = move-exception;
        Result.Companion r134 = Result.Companion;     // Catch: Throwable -> L167
        r121 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L167
    L190:
        if (((Boolean) r113).booleanValue() == false) goto L207;
        View r135 = r102.getWindow().peekDecorView();
        if ((r135 instanceof ViewGroup) == false) goto L205;
        ViewGroup r136 = (ViewGroup) r135;
        int r137 = 0;
    L196:
        if (r137 >= r136.getChildCount()) goto L205;
        View r138 = r136.getChildAt(r137);
        if (r138.getId() == (-1)) goto L204;
        if ("navigationBarBackground".equals(r102.getResources().getResourceEntryName(r138.getId())) == false) goto L204;
        r103 = r138.getHeight();     // Catch: Exception -> L208
    L204:
        r137 = r137 + 1;
    L205:
        return r103;
    L207:
        return f(r102);
    L19:
        if ((r109 instanceof Boolean) == true) goto L21;
        Object r139 = null;
    L22:
        r110 = (Boolean) r139;     // Catch: Throwable -> L67
        if (r110 != null) goto L65;
        if ((r109 instanceof Number) == false) goto L52;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L34;
        Float r140 = Float.valueOf(((Number) r109).floatValue());     // Catch: Throwable -> L67
        if ((r140 instanceof Boolean) == true) goto L32;
        r140 = null;
    L32:
        r110 = (Boolean) r140;     // Catch: Throwable -> L67
        goto L65
    L34:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L40;
        Double r141 = Double.valueOf(((Number) r109).doubleValue());     // Catch: Throwable -> L67
        if ((r141 instanceof Boolean) == true) goto L38;
        r141 = null;
    L38:
        r110 = (Boolean) r141;     // Catch: Throwable -> L67
        goto L65
    L40:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L46;
        Integer r142 = Integer.valueOf(((Number) r109).intValue());     // Catch: Throwable -> L67
        if ((r142 instanceof Boolean) == true) goto L44;
        r142 = null;
    L44:
        r110 = (Boolean) r142;     // Catch: Throwable -> L67
        goto L65
    L46:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L52;
        Long r143 = Long.valueOf(((Number) r109).longValue());     // Catch: Throwable -> L67
        if ((r143 instanceof Boolean) == true) goto L50;
        r143 = null;
    L50:
        r110 = (Boolean) r143;     // Catch: Throwable -> L67
    L52:
        if ((r109 instanceof JSONObject) == false) goto L54;
    L219:
        Object r144 = SDKSettingsCacheManager.a().fromJson(r109.toString(), Boolean.class);     // Catch: Throwable -> L60
        if ((r144 instanceof Boolean) == true) goto L58;
        r144 = null;
    L58:
        Object r145 = Result.m9449constructorimpl((Boolean) r144);     // Catch: Throwable -> L60
    L62:
        r110 = r145;
        if (Result.m9455isFailureimpl(r110) == false) goto L65;
    L60:
        th = move-exception;
        Result.Companion r146 = Result.Companion;     // Catch: Throwable -> L67
        r145 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L67
        goto L62
    L54:
        if ((r109 instanceof JSONArray) == false) goto L64;
    L21:
        r139 = r109;
    L67:
        th = move-exception;
        Result.Companion r147 = Result.Companion;     // Catch: Throwable -> L180
        r111 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L180
    L180:
        th = move-exception;
        Result.Companion r148 = Result.Companion;
        Object r149 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r150 = Result.m9452exceptionOrNullimpl(r149);
        if (r150 == null) goto L185;
        EnsureManager.ensureNotReachHere(r150);
    L185:
        if (Result.m9455isFailureimpl(r149) == true) goto L188;
        r106 = r149;
    L188:
        r113 = r106;
        goto L190
    L5:
        r102 = null;
        goto L6
    }

    public static int f(Activity r100) {
        ViewGroup r101 = (ViewGroup) b(r100.getWindow());
        int r102 = 0;
    L4:
        if (r102 >= r101.getChildCount()) goto L13;
        View r103 = r101.getChildAt(r102);
        if (r103.getId() == (-1)) goto L12;
        if (r100.getResources().getResourceEntryName(r103.getId()).equals("navigationBarBackground") == false) goto L12;
        return r103.getHeight();
    L12:
        r102 = r102 + 1;
        goto L4
    L13:
        return 0;
    }

    public static int h(Context r100) {
        if (s(t(r100)) == false) goto L22;
        boolean r101 = true;
        if (Settings.Secure.getInt(r100.getContentResolver(), "navigation_gesture_on", 0) == 0) goto L7;
        boolean r102 = true;
    L8:
        if (r102 == true) goto L22;
        Resources r103 = r100.getResources();
        int r104 = r103.getIdentifier("config_showNavigationBar", "bool", "android");
        if (r104 <= 0) goto L12;
        boolean r105 = r103.getBoolean(r104);
    L29:
        Class r106 = a("android.os.SystemProperties");     // Catch: Exception -> L19
        String r107 = (String) r106.getMethod(MonitorConstants.CONNECT_TYPE_GET, new Class[]{String.class}).invoke(r106, new Object[]{"qemu.hw.mainkeys"});     // Catch: Exception -> L19
        if ("1".equals(r107) == false) goto L16;
        r105 = false;
        goto L20
    L16:
        if ("0".equals(r107) == false) goto L20;
        r105 = true;
    L20:
        if (r105 == true) goto L22;
    L23:
        if (r101 == true) goto L25;
        return 0;
    L25:
        Resources r108 = r100.getResources();
        int r109 = r108.getIdentifier(CJPayGestureUtils.IMMERSION_NAVIGATION_BAR_HEIGHT, "dimen", "android");
        if (r109 > 0) goto L28;
        return 0;
    L28:
        return r108.getDimensionPixelSize(r109);
    L12:
        r105 = false;
        goto L29
    L7:
        r102 = false;
    L22:
        r101 = false;
        goto L23
    }

    public static int j(Context r100) {
        int r101 = f45627b;
        if (r101 <= 0) goto L6;
        return r101;
    L6:
        if (r100 != null) goto L8;
        return 0;
    L8:
        r(r100);
        int r102 = f45627b;
        if (r102 > 0) goto L11;
        return 0;
    L11:
        return r102;
    }

    public static int m(Context r100) {
        int r101 = f45626a;
        if (r101 <= 0) goto L6;
        return r101;
    L6:
        if (r100 != null) goto L8;
        return 0;
    L8:
        r(r100);
        int r102 = f45626a;
        if (r102 > 0) goto L11;
        return 0;
    L11:
        return r102;
    }

    public static int n(Context r100) {
        int r101 = 0;
        if (r100 != null) goto L5;
        return 0;
    L5:
        WindowManager r102 = (WindowManager) r100.getSystemService(LiveEndPageData.TAG_WINDOW);
        if (r102 == null) goto L10;
        Display r103 = r102.getDefaultDisplay();
        DisplayMetrics r104 = new DisplayMetrics();
        r103.getRealMetrics(r104);
        r101 = r104.widthPixels;
        int r105 = r104.heightPixels;
        if (r101 <= r105) goto L10;
        r101 = r105;
    L10:
        if (r101 == 0) goto L12;
        return r101;
    L12:
        return m(r100);
    }

    public static void r(Context r100) {
        if (r100 != null) goto L14;
        return;
    L14:
        WindowManager r101 = (WindowManager) r100.getSystemService(LiveEndPageData.TAG_WINDOW);     // Catch: Exception -> L12
        if (r101 == null) goto L10;
        Display r102 = r101.getDefaultDisplay();     // Catch: Exception -> L12
        Point r103 = new Point();     // Catch: Exception -> L12
        if (r102 != null) goto L9;
        return;
    L9:
        r102.getRealSize(r103);     // Catch: Exception -> L12
        f45627b = r103.y;     // Catch: Exception -> L12
        f45626a = r103.x;     // Catch: Exception -> L12
    L13:
        return;
    L10:
        Resources r104 = r100.getResources();     // Catch: Exception -> L12
        DisplayMetrics r105 = WindowDisplayMetricsOverride.apply(r104, r104.getDisplayMetrics());     // Catch: Exception -> L12
        f45627b = r105.heightPixels;     // Catch: Exception -> L12
        f45626a = r105.widthPixels;     // Catch: Exception -> L12
    }

    public static boolean s(Activity r100) {
        if (r100 == null) goto L10;
        Display r101 = r100.getWindowManager().getDefaultDisplay();
        DisplayMetrics r102 = new DisplayMetrics();
        r101.getRealMetrics(r102);
        int r103 = r102.heightPixels;
        int r104 = r102.widthPixels;
        DisplayMetrics r105 = new DisplayMetrics();
        r101.getMetrics(r105);
        int r106 = r105.heightPixels;
        if ((r104 - r105.widthPixels) <= 0) goto L7;
    L8:
        return true;
    L7:
        if ((r103 - r106) > 0) goto L8;
        return false;
    L10:
        return false;
    }

    public static Activity t(Context r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        if ((r100 instanceof Activity) == false) goto L10;
        return (Activity) r100;
    L10:
        if ((r100 instanceof ContextWrapper) == true) goto L12;
        return null;
    L12:
        return t(((ContextWrapper) r100).getBaseContext());
    }
}
