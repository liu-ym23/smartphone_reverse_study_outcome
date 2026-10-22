package com.bytedance.android.annie;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.MutableContextWrapper;
import android.os.Looper;
import android.view.accessibility.AccessibilityManager;
import com.bytedance.android.annie.bridge.method.abs.GetAppInfoResultModel;
import com.bytedance.android.annie.log.LogLevel;
import com.bytedance.android.annie.ng.g;
import com.bytedance.android.annie.param.j;
import com.bytedance.android.annie.param.k;
import com.bytedance.android.annie.param.m;
import com.bytedance.android.annie.service.setting.AnnieConfigSettingKeys;
import com.bytedance.android.annie.util.w;
import com.bytedance.android.annie.util.x;
import com.bytedance.android.annie.util.y;
import com.bytedance.android.livesdkapi.performance.IPerformanceStrategyManager;
import com.bytedance.ies.bullet.flow.FlowContainerLoaderSwitch;
import com.bytedance.mt.protector.impl.UriProtector;
import kotlin.Deprecated;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import p9.f;

/* JADX INFO: loaded from: classes43.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f38389a = 0;

    static {
    }

    @Deprecated(message = "直播业务专用，其他请使用Annie.getService()", replaceWith = @ReplaceWith(expression = "Annie.getService(clazz,bizKey)", imports = {"com.bytedance.android.annie.Annie"}))
    @JvmStatic
    public static final <T extends com.bytedance.android.annie.service.a> T b(Class<? extends T> r100) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        return (T) c(r100);
    }

    @Deprecated(message = "直播业务专用，其他请使用Annie.registerService()", replaceWith = @ReplaceWith(expression = "Annie.registerService(clazz,obj,bizKey)", imports = {"com.bytedance.android.annie.Annie"}))
    @JvmStatic
    public static final void d(Class r100, m r101) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        Intrinsics.checkNotNullParameter(r101, "service");
        e(r100, r101, false, 12);
    }

    public static com.bytedance.android.annie.service.a c(Class r100) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        Intrinsics.checkNotNullParameter("webcast", "bizKey");
        if (Intrinsics.areEqual("webcast", "webcast") == false) goto L7;
        return Annie.getService(r100, "webcast");
    L7:
        throw new IllegalArgumentException("直播的bizKey必须为webcast");
    }

    public static void f(k r100) {
        Intrinsics.checkNotNullParameter(r100, "globalPropsParams");
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L19
        int r102 = w.f40078a;     // Catch: Throwable -> L19
        Application r103 = g.a();     // Catch: Throwable -> L19
        int r104 = 1;
        int r105 = 0;
        if (r103 == null) goto L10;
        Object r106 = r103.getSystemService("accessibility");     // Catch: Throwable -> L19
        Intrinsics.checkNotNull(r106, "null cannot be cast to non-null type android.view.accessibility.AccessibilityManager");     // Catch: Throwable -> L19
        AccessibilityManager r107 = (AccessibilityManager) r106;     // Catch: Throwable -> L19
        if (r107.isEnabled() == false) goto L10;
        if (r107.isTouchExplorationEnabled() == false) goto L10;
        boolean r108 = true;
    L11:
        if (r108 == true) goto L14;
        r104 = 0;
    L14:
        r100.S0(r104);     // Catch: Throwable -> L19
        Application r109 = g.a();     // Catch: Throwable -> L19
        if (r109 == null) goto L17;
        Object r110 = r109.getSystemService("activity");     // Catch: Throwable -> L19
        Intrinsics.checkNotNull(r110, "null cannot be cast to non-null type android.app.ActivityManager");     // Catch: Throwable -> L19
        r105 = ((ActivityManager) r110).getDeviceConfigurationInfo().reqGlEsVersion;     // Catch: Throwable -> L19
    L17:
        r100.z1(r105);     // Catch: Throwable -> L19
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L19
        return;
    L10:
        r108 = false;
    L19:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    public static void e(Class r100, com.bytedance.android.annie.service.a r101, boolean r102, int r103) {
        if ((r103 & 4) == 0) goto L5;
        String r104 = "webcast";
    L7:
        if ((r103 & 8) == 0) goto L9;
        r102 = false;
    L9:
        Intrinsics.checkNotNullParameter(r100, "clazz");
        Intrinsics.checkNotNullParameter(r101, "service");
        Intrinsics.checkNotNullParameter(r104, "bizKey");
        if (Intrinsics.areEqual(r104, "webcast") == false) goto L16;
        if (r102 == false) goto L13;
        Annie.registerService$default(r100, r101, null, 4, null);
    L13:
        Annie.registerService(r100, r101, r104);
        return;
    L16:
        throw new IllegalArgumentException("直播的bizKey必须为webcast");
    L5:
        r104 = null;
        goto L7
    }

    @JvmStatic
    public static final k a(Context r110, String r111, boolean r112, String r113, String r210) {
        Intrinsics.checkNotNullParameter(r210, "bizKey");
        int r100 = x8.a.f562881a;
        StringBuilder r101 = new StringBuilder("GlobalPropsCacheManager has cache = ");
        j r102 = j.f39705b;
        r101.append(r102.b());
        x8.a.d("AnnieEnv", r101.toString(), false);
        k r103 = r102.a();
        String r104 = "";
        if (r103 != null) goto L5;
    L6:
        r103 = new k(null);
        f r105 = (f) Annie.getService$default(f.class, null, 2, null);
        r105.C1(r103);
        x8.a.d("AnnieEnv", "the class of IFinalGlobalPropsParamsService is default = " + (r105 instanceof p9.b), false);
        f(r103);
    L7:
        k r106 = r103;
        if ((r110 instanceof Activity) == false) goto L28;
        if (AnnieConfigSettingKeys.AVOID_WORKER_THREAD_INVOKE_DECORVIEW.a().booleanValue() == true) goto L71;
    L26:
        int r107 = g7.a.f480179a;
        Activity r108 = (Activity) r110;
        r106.c2(g7.a.b(r108, r108.getApplicationContext()));
    L61:
        r106.S1(AnnieConfigSettingKeys.IS_OVERSEA.a().booleanValue() ? 1 : 0);
        r106.l1(x.b());
        Pair[] r109 = new Pair[5];
        y8.a r114 = y8.a.f566652a;
        r109[0] = TuplesKt.to("memory_rest", Double.valueOf(r114.d(r110)));
        r109[1] = TuplesKt.to(IPerformanceStrategyManager.KEY_FLOAT_TEMPERATURE, Float.valueOf(r114.a(r110)));
        r109[2] = TuplesKt.to("network_quality", r114.b());
        r109[3] = TuplesKt.to("fps", Float.valueOf(y8.a.c()));
        float r115 = ((y8.c) Annie.getService$default(y8.c.class, null, 2, null)).v0();
        if (r115 >= 0) goto L64;
        r115 = 60.0f;
    L64:
        r109[4] = TuplesKt.to("fpsMin", Float.valueOf(r115));
        r106.a1(MapsKt.mapOf(r109));
        if (r111 == null) goto L67;
        r106.X1(y.a(r111));
    L67:
        ((p9.g) Annie.getService$default(p9.g.class, null, 2, null)).i0(r106);
        int r116 = x8.a.f562881a;
        x8.a.d("AnnieEnv", "appendLiveCommonGlobalParams from ".concat(Annie.getService$default(i9.d.class, null, 2, null).getClass().getName()), false);
        ((i9.d) Annie.getService$default(i9.d.class, null, 2, null)).O(r106, r110, r111, r112, r113);
        return r106;
    L71:
        Result.Companion r117 = Result.Companion;     // Catch: Throwable -> L17
        if (r111 == null) goto L15;
        r104 = r111;
    L15:
        Object r118 = Result.m9449constructorimpl(UriProtector.parse(r104).getAuthority());     // Catch: Throwable -> L17
    L20:
        if (Result.m9455isFailureimpl(r118) == false) goto L23;
        r118 = null;
    L23:
        if (Intrinsics.areEqual(r118, "webcast_lynxview") == false) goto L26;
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L61;
    L17:
        th = move-exception;
        Result.Companion r119 = Result.Companion;
        r118 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L20
    L28:
        if ((r110 instanceof MutableContextWrapper) == false) goto L61;
        if (FlowContainerLoaderSwitch.INSTANCE.enableAnnieXFlowLoader() == false) goto L61;
        if (AnnieConfigSettingKeys.AVOID_WORKER_THREAD_INVOKE_DECORVIEW.a().booleanValue() == true) goto L69;
    L48:
        int r120 = g7.a.f480179a;
        Context r121 = ((MutableContextWrapper) r110).getApplicationContext();
        Intrinsics.checkNotNullParameter(r121, "applicationContext");
    L58:
        e = move-exception;
        b8.a r122 = b8.a.f17992a;
        b8.a.a(new b8.b("getSafeArea", LogLevel.ERROR, e, null, 8), true);
        GetAppInfoResultModel.GetAppInfoSafeArea r123 = null;
    L60:
        r106.c2(r123);
        goto L61
    L50:
        if (r121.getResources().getConfiguration().orientation != 2) goto L52;
        boolean r124 = true;
    L53:
        int r125 = g7.a.f(g7.a.d(r121), r121);     // Catch: Exception -> L58
        int r126 = g7.a.f(i16.c.f487996a.h(r121), r121);     // Catch: Exception -> L58
        if (r124 == false) goto L56;
        r123 = new GetAppInfoResultModel.GetAppInfoSafeArea();     // Catch: Exception -> L58
        r123.setMarginLeft(Integer.valueOf(r125));     // Catch: Exception -> L58
        r123.setMarginRight(Integer.valueOf(r126));     // Catch: Exception -> L58
        r123.setMarginTop(0);     // Catch: Exception -> L58
        r123.setMarginBottom(0);     // Catch: Exception -> L58
    L73:
        goto L60
    L56:
        r123 = new GetAppInfoResultModel.GetAppInfoSafeArea();     // Catch: Exception -> L58
        r123.setMarginTop(Integer.valueOf(r125));     // Catch: Exception -> L58
        r123.setMarginBottom(Integer.valueOf(r126));     // Catch: Exception -> L58
        r123.setMarginRight(0);     // Catch: Exception -> L58
        r123.setMarginLeft(0);     // Catch: Exception -> L58
        goto L73
    L52:
        r124 = false;
        goto L53
    L69:
        Result.Companion r127 = Result.Companion;     // Catch: Throwable -> L39
        if (r111 == null) goto L37;
        r104 = r111;
    L37:
        Object r128 = Result.m9449constructorimpl(UriProtector.parse(r104).getAuthority());     // Catch: Throwable -> L39
    L42:
        if (Result.m9455isFailureimpl(r128) == false) goto L45;
        r128 = null;
    L45:
        if (Intrinsics.areEqual(r128, "webcast_lynxview") == false) goto L48;
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L61;
    L39:
        th = move-exception;
        Result.Companion r129 = Result.Companion;
        r128 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L42
    L5:
        if (Intrinsics.areEqual(r103.f(), "") == false) goto L7;
        goto L6
    }
}
