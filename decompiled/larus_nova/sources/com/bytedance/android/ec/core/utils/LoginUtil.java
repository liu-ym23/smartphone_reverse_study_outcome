package com.bytedance.android.ec.core.utils;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.android.ttcjpaysdk.integrated.sign.counter.activity.SignCounterLaunchArgs;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes43.dex */
public final class LoginUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, String> f45533a = null;

    static {
        f45533a = MapsKt.mapOf(new Pair[]{TuplesKt.to("action_buy", "product_detail_buynow"), TuplesKt.to("action_sku", com.bytedance.android.ec.core.event.a.VALUE_SKU_NAME), TuplesKt.to("action_add_to_cart", "product_detail_addcart"), TuplesKt.to("action_enter_cart", "product_detail_clickcart"), TuplesKt.to("action_im", "product_detail_services"), TuplesKt.to("logistics_and_coupon_coupon_event_id", "product_detail_discount")});
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r102 = Class.forName("com.bytedance.bdturing.reflect.VersionUtils");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("com.bytedance.bdturing.reflect.VersionUtils");     // Catch: Throwable -> L8
    L7:
        return r102;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("com.bytedance.bdturing.reflect.VersionUtils");
    L12:
        throw th;
    L34:
        Class<?> r103 = Class.forName("com.bytedance.bdturing.reflect.VersionUtils");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("com.bytedance.bdturing.reflect.VersionUtils");     // Catch: Throwable -> L17
    L16:
        return r103;
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("com.bytedance.bdturing.reflect.VersionUtils");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("com.bytedance.bdturing.reflect.VersionUtils");
    }

    public static void f(Context r100, Function0 r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "callBack");
        Activity r102 = p.f45663a.getActivity(r100);
        if (r102 == null) goto L6;
        c(r102, "", "", r101);
        return;
    }

    public static void e(Context r100, String r101, Function0 r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "source");
        Intrinsics.checkNotNullParameter(r102, "callBack");
        Activity r103 = p.f45663a.getActivity(r100);
        if (r103 == null) goto L6;
        b(r103, "", "", r101, r102, null);
        return;
    }

    public static void c(Activity r100, String r101, String r102, Function0 r110) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "enterFrom");
        Intrinsics.checkNotNullParameter(r102, "enterMethod");
        Intrinsics.checkNotNullParameter(r110, "callBack");
        b(r100, r101, r102, "", r110, null);
    }

    public static void g(Activity r100, String r101, String r102, Function0 r103) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "enterFrom");
        Intrinsics.checkNotNullParameter("livesdk_click_product", "enterMethod");
        Intrinsics.checkNotNullParameter(r102, "source");
        Intrinsics.checkNotNullParameter(r103, "callBack");
        b(r100, r101, "livesdk_click_product", r102, r103, null);
    }

    public static void d(Activity r100, String r101, String r102, Function0 r110, Function0 r111) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "enterFrom");
        Intrinsics.checkNotNullParameter(r102, "enterMethod");
        Intrinsics.checkNotNullParameter(r110, "callBack");
        Intrinsics.checkNotNullParameter(r111, "errorCallback");
        b(r100, r101, r102, "", r110, r111);
    }

    public static void b(Activity r100, String r101, String r110, String r111, final Function0 r112, final Function0 r113) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "enterFrom");
        Intrinsics.checkNotNullParameter(r110, "enterMethod");
        Intrinsics.checkNotNullParameter(r111, "source");
        Intrinsics.checkNotNullParameter(r112, "callBack");
        com.bytedance.android.ec.sdk.helper.r r102 = com.bytedance.android.ec.sdk.helper.r.f48132a;
        if (r102.isLogin() == false) goto L5;
        r112.invoke();
        return;
    L5:
        r102.d(r100, r101, r110, r111, new LoginUtil$checkLogin$3(r112), new LoginUtil$checkLogin$4(r113));
    }

    public static void h(Activity r110, String r111, String r112, Bundle r113, String r114, final Function0 r115, final Function0 r210) {
        Intrinsics.checkNotNullParameter(r110, "activity");
        Intrinsics.checkNotNullParameter(r111, "enterFrom");
        Intrinsics.checkNotNullParameter(r112, "enterMethod");
        Intrinsics.checkNotNullParameter(r114, "ecSceneID");
        Intrinsics.checkNotNullParameter("goods_detail", SignCounterLaunchArgs.EXTRA_SCENE_TYPE);
        Intrinsics.checkNotNullParameter(r115, "callBack");
        Intrinsics.checkNotNullParameter(r210, "errorCallback");
        boolean r116 = false;
        Result.Companion r117 = Result.Companion;     // Catch: Throwable -> L8
        boolean r100 = com.bytedance.android.ec.sdk.helper.r.f48132a.c(r114);     // Catch: Throwable -> L8
        boolean r118 = Intrinsics.areEqual(a().getDeclaredMethod("loginVerifyAvailable", new Class[0]).invoke(Unit.INSTANCE, new Object[0]), Boolean.TRUE);     // Catch: Throwable -> L8
        Lazy r119 = ECAppInfoService.f48110a;     // Catch: Throwable -> L8
        if (we.a.f559330a == false) goto L12;
        if (r118 == false) goto L12;
        if (r100 == false) goto L12;
        r116 = true;
    L12:
        if (r116 == false) goto L14;
        r115.invoke();
        return;
    L14:
        Lazy r101 = ECAppInfoService.f48110a;
        if (we.a.f559330a == false) goto L17;
        String r102 = "livesdk_click_product";
    L18:
        Intrinsics.checkNotNullParameter(r110, "activity");
        Intrinsics.checkNotNullParameter(r111, "enterFrom");
        Intrinsics.checkNotNullParameter(r102, "enterMethod");
        Intrinsics.checkNotNullParameter(r115, "callBack");
        com.bytedance.android.ec.sdk.helper.r r103 = com.bytedance.android.ec.sdk.helper.r.f48132a;
        if (r103.isLogin() == false) goto L21;
        r115.invoke();
        return;
    L21:
        String r104 = r102;
        r103.e(r110, r111, r104, r113, new LoginUtil$checkLogin$5(r115), new LoginUtil$checkLogin$6(r210));
        return;
    L17:
        r102 = r112;
    L8:
        th = move-exception;
        Result.Companion r120 = Result.Companion;
        Throwable r105 = Result.m9452exceptionOrNullimpl(Result.m9449constructorimpl(ResultKt.createFailure(th)));
        if (r105 == null) goto L12;
        ECExceptionMonitor.e(r105);
        goto L12
    }
}
