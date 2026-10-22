package com.bytedance.android.livesdk.interactivity.api.publicscreen.utils;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.interactivity.api.settings.config.m0;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.rxbus.RxBusAbility;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class PublicScreenStyleHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f133611a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f133612b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f133613c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f133614d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f133615e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final float f133616f = 0.0f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final float f133617g = 0.0f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final com.bytedance.android.livesdk.sharedpref.e<Boolean> f133618h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final com.bytedance.android.livesdk.sharedpref.e<Boolean> f133619i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Lazy f133620j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static long f133621k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static int f133622l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static boolean f133623m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static boolean f133624n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final com.bytedance.android.livesdk.sharedpref.e<Integer> f133625o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final com.bytedance.android.livesdk.sharedpref.e<Integer> f133626p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static int f133627q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static int f133628r;

    public static final m0 b() {
        return (m0) f133620j.getValue();
    }

    static {
        f133611a = UtilityKotlinExtentionsKt.i(60);
        f133612b = UtilityKotlinExtentionsKt.i(3);
        f133613c = UtilityKotlinExtentionsKt.i(3);
        f133614d = UtilityKotlinExtentionsKt.i(4);
        f133615e = UtilityKotlinExtentionsKt.i(5);
        f133616f = UtilityKotlinExtentionsKt.h(3);
        f133617g = UtilityKotlinExtentionsKt.h(4);
        Boolean r100 = Boolean.TRUE;
        f133618h = new com.bytedance.android.livesdk.sharedpref.e("live_public_screen_config_start_live_red_dot", r100);
        f133619i = new com.bytedance.android.livesdk.sharedpref.e("live_public_scree_config_toolbar_red_dot", r100);
        f133620j = LazyKt.lazy(PublicScreenStyleHelper$psOptConfig$2.INSTANCE);
        Class r101 = Integer.TYPE;
        com.bytedance.android.livesdk.sharedpref.e<Integer> r102 = new com.bytedance.android.livesdk.sharedpref.e("public_screen_font_size_level", r101);
        f133625o = r102;
        com.bytedance.android.livesdk.sharedpref.e<Integer> r103 = new com.bytedance.android.livesdk.sharedpref.e("public_screen_height_level", r101);
        f133626p = r103;
        Integer r104 = r102.getValue();
        if (r104 == null) goto L5;
        int r105 = r104.intValue();
    L6:
        boolean r106 = true;
        int r107 = 0;
        if (r105 < 0) goto L11;
        if (2 < r105) goto L11;
        boolean r108 = true;
    L12:
        if (r108 == true) goto L15;
        r105 = 0;
    L15:
        f133627q = r105;
        Integer r109 = r103.getValue();
        if (r109 == null) goto L18;
        int r110 = r109.intValue();
    L19:
        if (r110 < 0) goto L23;
        if (2 < r110) goto L23;
    L24:
        if (r106 == false) goto L26;
        r107 = r110;
    L26:
        f133628r = r107;
        return;
    L23:
        r106 = false;
        goto L24
    L18:
        r110 = b().b();
    L11:
        r108 = false;
        goto L12
    L5:
        r105 = b().a();
        goto L6
    }

    @JvmStatic
    public static final int a() {
        if (f133624n == false) goto L14;
        int r100 = f133627q;
        if (r100 >= 0) goto L8;
    L10:
        boolean r101 = false;
    L11:
        if (r101 == true) goto L13;
        return 0;
    L13:
        return r100;
    L8:
        if (2 < r100) goto L10;
        r101 = true;
        goto L11
    L14:
        return 0;
    }

    @JvmStatic
    public static final int c() {
        if (f133624n == false) goto L14;
        int r100 = f133628r;
        if (r100 >= 0) goto L8;
    L10:
        boolean r101 = false;
    L11:
        if (r101 == true) goto L13;
        return 0;
    L13:
        return r100;
    L8:
        if (2 < r100) goto L10;
        r101 = true;
        goto L11
    L14:
        return 0;
    }

    @JvmStatic
    public static final void f(int r100) {
        if (r100 >= 0) goto L5;
    L7:
        boolean r101 = false;
    L8:
        if (r101 == false) goto L11;
        com.bytedance.android.livesdk.sharedpref.e<Integer> r102 = f133626p;
        Integer r103 = Integer.valueOf(r100);
        r102.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r102, r103);
        f133628r = r100;
        return;
    L11:
        return;
    L5:
        if (2 < r100) goto L7;
        r101 = true;
        goto L8
    }

    @JvmStatic
    public static final void d(boolean r100, LiveMode r101) {
        if (r100 == true) goto L4;
    L8:
        boolean r102 = false;
    L9:
        f133624n = r102;
        return;
    L4:
        if (r101 != LiveMode.VIDEO) goto L8;
        if (b().c() == false) goto L8;
        r102 = true;
        goto L9
    }

    @JvmStatic
    public static final void e(DataCenter r100, String r110) {
        Intrinsics.checkNotNullParameter(r110, "source");
        ALogger.i("PublicScreenOptHelper", "request adjust height. source: ".concat(r110));
        f133622l++;
        long r101 = System.currentTimeMillis();
        long r102 = f133621k;
        if (r102 > 0) goto L6;
        f133621k = r101;
    L13:
        RxBusAbility.INSTANCE.getRxBus(r100).post(new o42.c(false, true, r110));
        return;
    L6:
        if ((r101 - r102) < 1000) goto L13;
        f133621k = r101;
        if (f133622l > 20) goto L10;
    L12:
        f133622l = 0;
        goto L13
    L10:
        if (f133623m == true) goto L12;
        f133623m = true;
        SafetyGuard.a(null, null, "request adjust public screen height exception");
        goto L12
    }
}
