package com.bytedance.android.shopping.anchorv3.utils;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.common.utility.StringUtils;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f165312a = 0;

    public l() {
    }

    static {
    }

    public static String a(String r100, Map r101) {
        Intrinsics.checkNotNullParameter(r101, "options");
        if (TextUtils.isEmpty(r100) == false) goto L18;
        JSONObject r102 = new JSONObject();
    L20:
        Iterator r103 = r101.entrySet().iterator();     // Catch: Exception -> L14
    L11:
        if (r103.hasNext() == false) goto L17;
        Map.Entry r104 = (Map.Entry) r103.next();     // Catch: Exception -> L14
        r102.put((String) r104.getKey(), r104.getValue());     // Catch: Exception -> L14
    L17:
        return r102.toString();
    L14:
        e = move-exception;
        ECExceptionMonitor.f(e, "V1LogUtil");
        goto L17
    L18:
        r102 = new JSONObject(r100);     // Catch: Exception -> L7
    L7:
        e = move-exception;
        ECExceptionMonitor.f(e, "V1LogUtil");
        r102 = new JSONObject();
        goto L20
    }

    public static JSONObject b(String r100, String r101, String r102, Long r103) {
        Intrinsics.checkNotNullParameter(r100, "logExtra");
        Intrinsics.checkNotNullParameter(r101, "adExtraData");
        JSONObject r104 = new JSONObject();
        if (TextUtils.isEmpty(r100) == true) goto L6;
        r104.put("log_extra", r100);
    L6:
        if (TextUtils.isEmpty(r101) == true) goto L12;
        r104.put("ad_extra_data", r101);
        if (r102 == null) goto L10;
        r104.put("refer", r102);
    L10:
        if (r103 == null) goto L12;
        r103.longValue();
        r104.put("duration", r103.longValue());
    L12:
        r104.put("is_ad_event", "1");
        r104.put("is_ad", "1");
        String r105 = com.bytedance.android.ec.sdk.helper.n.f48128a.getNetworkAccessType(ECAppInfoService.f48114e.getApplicationContext());
        if ((!StringUtils.isEmpty(r105)) == true) goto L16;
        r105 = null;
    L16:
        if (r105 == null) goto L18;
        r104.put("nt", r105);
    L18:
        return r104;
    }

    public static void c(String r100, String r110, long r111, JSONObject r112) {
        Intrinsics.checkNotNullParameter(r100, "label");
        Intrinsics.checkNotNullParameter(r110, "value");
        Intrinsics.checkNotNullParameter(r112, "extra");
        Context r101 = ECAppInfoService.f48114e.getApplicationContext();
        if (r101 != null) goto L5;
        return;
    L5:
        com.bytedance.android.ec.sdk.helper.g.f48122a.b(r101, com.bytedance.android.ec.core.event.a.VALUE_LUBAN_TAG, r100, r110, r111, r112);
    }

    public static void d(String r100, String r110, long r111, JSONObject r112) {
        Intrinsics.checkNotNullParameter(r100, "label");
        Intrinsics.checkNotNullParameter(r110, "value");
        Intrinsics.checkNotNullParameter(r112, "extra");
        Context r101 = ECAppInfoService.f48114e.getApplicationContext();
        if (r101 != null) goto L5;
        return;
    L5:
        com.bytedance.android.ec.sdk.helper.g.f48122a.b(r101, "shop_ad", r100, r110, r111, r112);
    }
}
