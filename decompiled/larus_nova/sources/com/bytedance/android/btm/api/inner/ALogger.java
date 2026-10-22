package com.bytedance.android.btm.api.inner;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes3.dex */
public final class ALogger {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f41993a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f41994b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final cd.c f41995c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ALogger f41996d = null;

    static {
        f41993a = new KProperty[]{Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(ALogger.class), "aLogWriter", "getALogWriter()Lcom/bytedance/android/btm/api/inner/IALogWriter;"))};
        f41996d = new ALogger();
        f41994b = "";
        f41995c = new cd.c(ALogger$aLogWriter$2.INSTANCE);
    }

    public ALogger() {
    }

    public static void c(ALogger r100, String r101, Function0 r102) {
        r100.getClass();
        r100.b("api_".concat(r101), false, r102);
    }

    public static void d(ALogger r100, String r101, Function0 r102) {
        r100.getClass();
        r100.b("event_".concat(r101), false, r102);
    }

    public static void e(ALogger r100, String r101, Function0 r102) {
        r100.getClass();
        r100.b("layer1_" + r101, false, r102);
    }

    public static void f(ALogger r100, String r101, Function0 r102) {
        r100.getClass();
        r100.b("layer2_" + r101, false, r102);
    }

    public static void g(ALogger r100, String r101, Function0 r102) {
        r100.getClass();
        r100.b("layer3_" + r101, false, r102);
    }

    public static void j(ALogger r100, String r101, Function0 r102) {
        r100.getClass();
        r100.b("page_" + r101, false, r102);
    }

    public static void k(ALogger r100, String r101, Function0 r102) {
        r100.getClass();
        r100.b("pageshow_".concat(r101), false, r102);
    }

    public static void l(ALogger r100, String r101, Function0 r102) {
        r100.getClass();
        r100.b("unknown_".concat(r101), false, r102);
    }

    public static void m(ALogger r100, String r101, Function0 r102) {
        r100.getClass();
        r100.b("utils_" + r101, false, r102);
    }

    public static void n(ALogger r100, String r101, Function0 r102) {
        r100.getClass();
        r100.o("BTMSDK_DevTool_".concat(r101), false, r102, null);
    }

    public final void a(String r100, boolean r101, Function0<? extends Object> r102) {
        o("BTMSDK_BCM_" + r100, r101, r102, null);
    }

    public final void b(String r100, boolean r101, Function0<? extends Object> r102) {
        o("BTMSDK_BTM_" + r100, r101, r102, null);
    }

    public final void h(String r100, boolean r101, Integer r102, Function0<? extends Object> r103) {
        o("BTMSDK_BTM_monitor_" + r100, r101, r103, r102);
    }

    public final void o(String r100, boolean r101, Function0<? extends Object> r102, Integer r103) {
        if (f41994b.length() <= 0) goto L5;
        boolean r104 = true;
    L6:
        if (r104 == false) goto L10;
        b r105 = (b) f41995c.getValue(this, f41993a[0]);
        if (r105 == null) goto L14;
        r105.b(r100 + '_' + f41994b, r101, r102, r103);
        return;
    L14:
        return;
    L10:
        b r106 = (b) f41995c.getValue(this, f41993a[0]);
        if (r106 == null) goto L16;
        r106.b(r100, r101, r102, r103);
        return;
    L16:
        return;
    L5:
        r104 = false;
        goto L6
    }

    public static /* synthetic */ void i(ALogger r100, String r101, boolean r102, Function0 r103, int r104) {
        if ((r104 & 2) == 0) goto L5;
        r102 = false;
    L5:
        r100.h(r101, r102, null, r103);
    }
}
