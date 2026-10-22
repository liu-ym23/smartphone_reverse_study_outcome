package com.bytedance.android.ec.core.address;

import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f43738a = 0;

    public static String f() {
        kc.a r100 = BtmSDK.getBcmChainByFinder$default(BtmSDK.INSTANCE, null, 1, false, 4, null);
        if (r100 == null) goto L9;
        List<kc.a.C6534a> r101 = r100.f502353a;
        if (r101 == null) goto L9;
        kc.a.C6534a r102 = (kc.a.C6534a) CollectionsKt.firstOrNull(r101);
        if (r102 == null) goto L9;
        return r102.f502356c;
    L9:
        return null;
    }

    public static long j() {
        return System.currentTimeMillis() / ((long) 1000);
    }

    static {
    }

    public static String b(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$getAddressId");
        return r100.optString("id");
    }

    public static String c(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$getAddressInfo");
        return b(r100) + '_' + e(r100) + '_' + d(r100);
    }

    public static String d(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$getAddressStrategy");
        JSONObject r101 = r100.optJSONObject("extra");
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.optString(BdpAppEventConstant.PARAMS_STRATEGY_NAME);
    }

    public static Integer e(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$getAddressType");
        Integer r101 = Integer.valueOf(r100.optInt("address_type", -1));
        if (r101.intValue() <= 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == true) goto L10;
        return null;
    L10:
        return r101;
    L5:
        r102 = false;
        goto L6
    }

    public static wi.a g(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$getLocation");
        JSONObject r101 = r100.optJSONObject("poi_info");
        if (r101 == null) goto L7;
        JSONObject r102 = r101.optJSONObject("coordinate");
        if (r102 == null) goto L7;
        return new wi.a(r102.optDouble("latitude"), r102.optDouble("longitude"));
    L7:
        return null;
    }

    public static float a(wi.a r110, wi.a r111) {
        if (r110 == null) goto L8;
        if (r111 == null) goto L8;
        double r100 = r110.f559729b;     // Catch: Throwable -> L6
        double r101 = r110.f559728a;     // Catch: Throwable -> L6
        double r102 = r100 * 0.01745329251994329d;     // Catch: Throwable -> L6
        double r103 = r101 * 0.01745329251994329d;     // Catch: Throwable -> L6
        double r104 = r111.f559729b * 0.01745329251994329d;     // Catch: Throwable -> L6
        double r112 = r111.f559728a * 0.01745329251994329d;     // Catch: Throwable -> L6
        double r105 = Math.sin(r102);     // Catch: Throwable -> L6
        double r106 = Math.sin(r103);     // Catch: Throwable -> L6
        double r107 = Math.cos(r102);     // Catch: Throwable -> L6
        double r108 = Math.cos(r103);     // Catch: Throwable -> L6
        double r113 = Math.sin(r104);     // Catch: Throwable -> L6
        double r114 = Math.sin(r112);     // Catch: Throwable -> L6
        double r109 = Math.cos(r104);     // Catch: Throwable -> L6
        double r115 = Math.cos(r112);     // Catch: Throwable -> L6
        double r116 = (r107 * r108) - (r109 * r115);     // Catch: Throwable -> L6
        double r117 = (r108 * r105) - (r115 * r113);     // Catch: Throwable -> L6
        double r118 = r106 - r114;     // Catch: Throwable -> L6
        return (float) (Math.asin(Math.sqrt(((r116 * r116) + (r117 * r117)) + (r118 * r118)) / 2.0d) * 1.27420015798544E7d);
    L6:
        th = move-exception;
        ECExceptionMonitor.e(th);
    L9:
        return 0.0f;
    L8:
        int r119 = AddressSDKLog.f43665a;
        AddressSDKLog.a("坐标异常 first=" + String.valueOf(r110) + " second=" + String.valueOf(r111), false);
        goto L9
    }

    public static boolean i(JSONObject r100, JSONObject r101) {
        Integer r102 = null;
        if (r101 == null) goto L5;
        String r103 = b(r101);
    L6:
        if (r101 == null) goto L9;
        r102 = e(r101);
    L9:
        return h(r100, r103, r102);
    L5:
        r103 = null;
        goto L6
    }

    public static String k(String r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        if (r101 != null) goto L6;
        return "";
    L6:
        return r100 + com.alipay.sdk.m.n.a.f25612h + c(r101);
    }

    public static boolean h(JSONObject r100, String r101, Integer r102) {
        Integer r103 = null;
        if (r100 == null) goto L5;
        String r104 = b(r100);
    L6:
        if (r100 == null) goto L8;
        r103 = e(r100);
    L8:
        if (r104 != null) goto L10;
    L15:
        return false;
    L10:
        if (Intrinsics.areEqual(r104, r101) == false) goto L15;
        if (r103 == null) goto L15;
        if (Intrinsics.areEqual(r103, r102) == false) goto L15;
        return true;
    L5:
        r104 = null;
        goto L6
    }
}
