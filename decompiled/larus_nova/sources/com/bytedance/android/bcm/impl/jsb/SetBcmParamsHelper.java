package com.bytedance.android.bcm.impl.jsb;

import com.bytedance.android.bcm.api.b;
import com.bytedance.android.bcm.api.model.BcmParams;
import com.bytedance.android.btm.api.inner.ALogger;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.crash.dumper.Scraps;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class SetBcmParamsHelper {
    static {
    }

    public static boolean a(PageFinder r100, final Map r101) {
        ALogger.c(ALogger.f41996d, "FE_setBcmParams", new SetBcmParamsHelper$handle$1(r101));
        if (r100.isEmpty() == false) goto L5;
        return false;
    L5:
        Object r102 = r101.get("param_type");
        Object r103 = null;
        if ((r102 instanceof String) == true) goto L8;
        r102 = null;
    L8:
        String r104 = (String) r102;
        Object r105 = r101.get(HiAnalyticsConstant.BI_KEY_UPDATE_TYPE);
        if ((r105 instanceof String) == true) goto L11;
        r105 = null;
    L11:
        String r106 = (String) r105;
        Object r107 = r101.get("content");
        if ((r107 instanceof Map) == false) goto L15;
        r103 = r107;
    L15:
        Map r108 = (Map) r103;
        if (r104 != null) goto L18;
    L21:
        boolean r109 = true;
    L22:
        if (r109 == true) goto L54;
        if (r106 != null) goto L25;
    L28:
        boolean r110 = true;
    L29:
        if (r110 == true) goto L54;
        if (r108 != null) goto L32;
    L35:
        boolean r111 = true;
    L36:
        if (r111 == true) goto L54;
        boolean r112 = Intrinsics.areEqual(r104, Scraps.INNER_UNIT);
        boolean r113 = Intrinsics.areEqual(r106, "append");
        JSONObject r114 = new JSONObject(r108);     // Catch: Exception -> L52
        Iterator<String> r115 = r114.keys();     // Catch: Exception -> L52
    L40:
        if (r115.hasNext() == false) goto L51;
        String r116 = r115.next().toString();     // Catch: Exception -> L52
        JSONObject r117 = r114.optJSONObject(r116);     // Catch: Exception -> L52
        if (r112 == true) goto L44;
        if (r113 == true) goto L48;
        b.e(r100, r116, new BcmParams().merge(r117));     // Catch: Exception -> L52
        goto L40
    L48:
        b.f41761a.appendPageParams(r100, r116, new BcmParams().merge(r117));     // Catch: Exception -> L52
        goto L40
    L44:
        if (r113 == true) goto L45;
        b.f41761a.setUnitParams(r100, r116, new BcmParams().merge(r117));     // Catch: Exception -> L52
        goto L40
    L45:
        b.f41761a.appendUnitParams(r100, r116, new BcmParams().merge(r117));     // Catch: Exception -> L52
        goto L40
    L51:
        return true;
    L52:
        e = move-exception;
        e.printStackTrace();
        goto L54
    L32:
        if (r108.isEmpty() == true) goto L35;
        r111 = false;
        goto L36
    L25:
        if (r106.length() == 0) goto L28;
        r110 = false;
    L54:
        return false;
    L18:
        if (r104.length() == 0) goto L21;
        r109 = false;
        goto L22
    }

    public static boolean b(PageFinder r100, final Map r101) {
        ALogger.c(ALogger.f41996d, "FE_setBcmParams", new SetBcmParamsHelper$handleV2$1(r101));
        if (r100.isEmpty() == false) goto L5;
        return false;
    L5:
        Object r102 = r101.get("bcm");
        Object r103 = r101.get("clear_old_value");
        if ((r103 instanceof Boolean) == true) goto L8;
        r103 = null;
    L8:
        Boolean r104 = (Boolean) r103;
        if (r104 == null) goto L11;
        boolean r105 = r104.booleanValue();
    L13:
        if ((r102 instanceof Map) == true) goto L15;
        Object r106 = null;
    L16:
        Map<String, ? extends Object> r107 = (Map) r106;
        if (r107 == null) goto L21;
        BcmParams r108 = new BcmParams().merge(r107);
        if (r108 == null) goto L21;
    L35:
        if (r105 == false) goto L30;
        b.e(r100, "ecom_entrance", r108);     // Catch: Exception -> L28
    L34:
        return true;
    L30:
        b.f41761a.appendPageParams(r100, "ecom_entrance", r108);     // Catch: Exception -> L28
    L28:
        e = move-exception;
        e.printStackTrace();
        return false;
    L21:
        BcmParams r109 = new BcmParams();
        if ((r102 instanceof JSONObject) == true) goto L24;
        r102 = null;
    L24:
        r108 = r109.merge((JSONObject) r102);
        goto L35
    L15:
        r106 = r102;
        goto L16
    L11:
        r105 = true;
        goto L13
    }
}
