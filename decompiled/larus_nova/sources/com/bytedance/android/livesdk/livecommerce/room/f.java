package com.bytedance.android.livesdk.livecommerce.room;

import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.adapter.api.IAdapterService;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.ec.core.monitor.l;
import com.bytedance.android.ec.core.monitor.o;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.ec.host.api.core.api.IECRouterService;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.bytedance.android.livesdk.livecommerce.utils.EComABUtils;
import com.bytedance.android.ui.ec.widget.dialog.ECAlertDialog;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import java.util.HashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public final class f {
    public static Context a() {
        return ECAppInfoService.f48114e.getApplicationContext();
    }

    public static boolean c(Boolean r100) {
        if (hh2.f.f() == true) goto L5;
        return false;
    L5:
        if (EComABUtils.shouldHideSaasAnchorEntrance() == true) goto L7;
        return false;
    L7:
        if (r100.booleanValue() == false) goto L13;
        return true;
    L13:
        return false;
    }

    public static void b(Context r110, String r111) {
        xh.a r100 = xh.c.a("Live");
        String r101 = "open_schema_".concat("");
        xh.b.e r102 = new xh.b.e();
        r102.a(r111);
        Unit r103 = Unit.INSTANCE;
        xh.b r104 = new xh.b();
        JSONObject r105 = null;
        r104.c(null);
        r104.b(r101);
        r104.a(r102);
        r100.f(4, r104);
        boolean r106 = true;
        if (r111.startsWith("sslocal://webcast_lynxview") == false) goto L5;
    L19:
        Bundle r107 = new Bundle();
        if (ECAppInfoService.f48114e.isLocalTest() == false) goto L22;
    L23:
        int r108 = RoomContextController.f151593h;
        r107.putString("vmsdk_contextProvider", com.bytedance.android.ec.adapter.api.state.b.a(RoomContextController.a.a().L()).toString());
        r107.putString("vmsdk_scene", "live");
    L24:
        ECLiveHybridUtil.j(r110, r111, r107, false, false, false, null, null);
        int r109 = com.bytedance.android.ec.core.monitor.j.f45161a;
        Intrinsics.checkNotNullParameter(r111, "orderUrl");
        if (StringsKt.contains$default(r111, "fe_lynx_commerce_buynow", false, 2, null) == true) goto L32;
        if (StringsKt.contains$default(r111, "ecommerce_buynow_aweme", false, 2, null) == true) goto L32;
        if (StringsKt.contains$default(r111, "ecommerce_buynow_huoshan", false, 2, null) == true) goto L32;
    L62:
        Lazy r112 = ECAppInfoService.f48110a;
        if (we.a.f559330a == false) goto L71;
        if (r106 == true) goto L72;
        int r113 = ECSdk.f48106a;
        IECRouterService r114 = (IECRouterService) ECSdk.a(IECRouterService.class);
        Uri r115 = UriProtector.parse(r111);
        if (r114 != null) goto L68;
        return;
    L68:
        if (r114.match(r115, false) == false) goto L74;
        r114.open(r110, r115, false, false);
        return;
    L74:
        return;
    L72:
        return;
    L71:
        return;
    L32:
        if (a2.b(r111) == false) goto L62;
        Uri r116 = UriProtector.parse(r111);
        if (Intrinsics.areEqual(UriProtector.getQueryParameter(r116, "is_cart_order"), "1") == true) goto L62;
        String r117 = UriProtector.getQueryParameter(r116, com.bytedance.android.ec.core.event.a.KEY_RIFLE_MEGA_OBJECT);
        if (r117 == null) goto L40;
        HashMap<String, JSONObject> r118 = com.bytedance.android.ec.core.hybrid.utils.j.f44312a;
        r105 = com.bytedance.android.ec.core.hybrid.utils.j.i(r117);
    L40:
        if (r105 != null) goto L42;
    L43:
        UriProtector.getQueryParameter(r116, com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO);
    L44:
        if (r105 == null) goto L47;
        String r119 = r105.optString(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO);
        if (r119 == null) goto L47;
    L48:
        if (r105 == null) goto L51;
        String r120 = r105.optString(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO);
        if (r120 == null) goto L51;
    L52:
        int r121 = l.f45163a;
        l.a(r111, "", "order_page", CollectionsKt.listOf(new l.a[]{new l.a("id", "presence"), new l.a(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO, "is_json_string"), new l.a(com.bytedance.android.ec.core.event.a.KEY_COMBO_ID, "presence"), new l.a("combo_num", "valid_number"), new l.a(com.bytedance.android.ec.core.event.a.KEY_ORIGIN_TYPE, "presence"), new l.a(com.bytedance.android.ec.core.event.a.KEY_ORIGIN_ID, "presence")}));
        if (a2.b(r119) == false) goto L62;
        if (r120 != null) goto L56;
    L59:
        boolean r122 = true;
    L60:
        if (r122 == false) goto L62;
        com.bytedance.android.ec.core.monitor.d.c(null, "order_page", r111, "dependency_cid_log_extra", "extra", "cid非空时log_extra字段为空", 1);
        goto L62
    L56:
        if (r120.length() == 0) goto L59;
        r122 = false;
    L51:
        r120 = UriProtector.getQueryParameter(r116, "log_extra");
    L47:
        r119 = UriProtector.getQueryParameter(r116, "cid");
        goto L48
    L42:
        if (r105.optString(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO) != null) goto L44;
    L22:
        if (ECSettingKeys.l() == false) goto L24;
    L5:
        if (r111.startsWith("sslocal://webcast_webview") == true) goto L19;
        int r123 = ECSdk.f48106a;
        IAdapterService r124 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r124 != null) goto L10;
        return;
    L10:
        o r125 = (o) ECSdk.a(o.class);
        if (r125 == null) goto L14;
        int r126 = RoomContextController.f151593h;
        r125.b(r110, r111, com.bytedance.android.ec.adapter.api.state.b.a(RoomContextController.a.a().L()).toString());
    L14:
        if (r111.startsWith("sslocal://buy_now/") == false) goto L16;
    L17:
        HashMap<String, JSONObject> r127 = com.bytedance.android.ec.core.hybrid.utils.j.f44312a;
        r111 = com.bytedance.android.ec.core.hybrid.utils.j.b(r111, false, "", false);
    L18:
        r106 = r124.handleSchemaWithLive(r110, UriProtector.parse(r111), true, null);
        goto L62
    L16:
        if (r111.startsWith("sslocal://buy_now?") == false) goto L18;
        goto L17
    }

    public static void d(final String r100, final Map<String, String> r101) {
        hh2.g r102 = hh2.f.f485165a.f485167a;
        if (r102 == null) goto L5;
        String r103 = r102.f();
    L7:
        if (TextUtils.isEmpty(r103) == true) goto L9;
        r100 = r103 + r100;
    L9:
        Single.fromCallable(new e(r100, r101)).subscribeOn(Schedulers.io()).subscribe();
        return;
    L5:
        r103 = null;
        goto L7
    }

    public static void e(final String r100, final Map<String, String> r101, final String r102, final PageFinder r103) {
        hh2.g r104 = hh2.f.f485165a.f485167a;
        if (r104 == null) goto L5;
        String r105 = r104.f();
    L7:
        if (TextUtils.isEmpty(r105) == true) goto L9;
        r100 = r105 + r100;
    L9:
        Single.fromCallable(new d(r100, r101, r102, r103)).subscribeOn(Schedulers.io()).subscribe();
        return;
    L5:
        r105 = null;
        goto L7
    }

    public static ECAlertDialog f(Context r100, int r101, int r102, int r103, DialogInterface.OnClickListener r104, DialogInterface.OnClickListener r105) {
        ECAlertDialog r106 = new ECAlertDialog(r100);
        if (r101 == 0) goto L5;
        r106.setTitle(th.a.g(r100, r101));
    L5:
        if (r102 == 0) goto L7;
        r106.setMessage(th.a.g(r100, r102));
    L7:
        r106.setDialogCancelable(false);
        r106.setPositiveButton(th.a.g(r100, r103), r104);
        r106.setNegativeButton(th.a.g(r100, R.string.ec_cancel), r105);
        if (DialogLancet.shouldBlockDialogShow(r106) == false) goto L14;
        DialogLancet.handleBlockedDialogShow(r106);
    L12:
        return r106;
    L14:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L13
    L11:
        DialogLancet.beforeDialogShow(r106);
        r106.show();
        DialogLancet.afterDialogShow(r106);
        goto L12
    }
}
