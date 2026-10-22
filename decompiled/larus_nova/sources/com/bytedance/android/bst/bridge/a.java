package com.bytedance.android.bst.bridge;

import android.view.View;
import com.bytedance.android.bst.api.ext.ExtKt;
import com.bytedance.android.bst.api.lynx.JsBridgeExposureData;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.larksuite.component.card.plugin.ReportCardMonitorPlugin;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import java.util.LinkedHashMap;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import uc.c;
import yc.b;

/* JADX INFO: loaded from: classes43.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f41932a = 0;

    static {
    }

    public static void a(JSONObject r110, View r111, Function3 r112) {
        if (r111 != null) goto L6;
        ExtKt.b("JsBridgeProvider", "sendBstExposure view is null!");
        r112.invoke(Boolean.FALSE, new LinkedHashMap(), "native view is null");
        return;
    L6:
        boolean r113 = true;
        JSONObject r100 = new JSONObject(JSONObjectProtectorUtils.getString(r110, "bst_data"));     // Catch: Exception -> L46
        String r101 = r100.optString("btm", "");     // Catch: Exception -> L46
        int r102 = r100.optInt(BdpAppEventConstant.PARAMS_UNIQUEID, 0);     // Catch: Exception -> L46
        String r103 = r100.optString("biz", "");     // Catch: Exception -> L46
        String r104 = r100.optString(DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, "");     // Catch: Exception -> L46
        JSONObject r114 = r100.optJSONObject("extra_info");     // Catch: Exception -> L46
        int r115 = r100.optInt("exposure_repeatedly", 0);     // Catch: Exception -> L46
        String r116 = r100.optString(ReportCardMonitorPlugin.EVENT_NAME, "");     // Catch: Exception -> L46
        Object r105 = r100.opt("card_id");     // Catch: Exception -> L46
        if (r105 == null) goto L12;
        String r106 = r105.toString();     // Catch: Exception -> L46
        if (r106 == null) goto L12;
        String r107 = r106;
    L14:
        if (r101.length() != 0) goto L16;
        boolean r108 = true;
    L17:
        if (r108 == true) goto L31;
        if (r102 <= 0) goto L31;
        if (r103.length() != 0) goto L22;
        boolean r109 = true;
    L23:
        if (r109 == true) goto L31;
        if (r104.length() != 0) goto L27;
        boolean r117 = true;
    L28:
        if (r117 == true) goto L31;
        if (r114 == null) goto L31;
        boolean r118 = true;
    L54:
        ExtKt.b("JsBridgeProvider", "isAvailable: " + r118);     // Catch: Exception -> L44
        if (r118 == true) goto L35;
    L48:
        if (r118 == false) goto L50;
        r112.invoke(Boolean.TRUE, new LinkedHashMap(), "");
        return;
    L50:
        r112.invoke(Boolean.FALSE, new LinkedHashMap(), "data is illegal");
        return;
    L35:
        if (r115 != 1) goto L37;
        boolean r119 = true;
    L38:
        if (r114 != null) goto L40;
        Intrinsics.throwNpe();     // Catch: Exception -> L44
    L40:
        new JsBridgeExposureData(r101, r102, r107, r103, r104, r119, r116, r114);     // Catch: Exception -> L44
        c r120 = (c) b.a(c.class);     // Catch: Exception -> L44
        if (r120 == null) goto L48;
        r120.a();     // Catch: Exception -> L44
        goto L48
    L37:
        r119 = false;
    L44:
        e = e;
        r113 = r118;
    L47:
        ExtKt.b("JsBridgeProvider", ExtKt.c(e));
        r118 = r113;
        goto L48
    L27:
        r117 = false;
        goto L28
    L22:
        r109 = false;
    L31:
        r118 = false;
        goto L54
    L16:
        r108 = false;
    L12:
        r107 = "";
    L46:
        e = e;
        goto L47
    }
}
