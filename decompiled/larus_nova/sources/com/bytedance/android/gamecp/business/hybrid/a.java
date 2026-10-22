package com.bytedance.android.gamecp.business.hybrid;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.android.annie.api.container.HybridDialog;
import com.bytedance.android.gamecp.common.utils.c1;
import com.bytedance.android.livesdk.schema.AudienceGamePromoteDetailActionHandler;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import wu.a3;
import wu.o2;
import xr.s;
import y6.c;

/* JADX INFO: loaded from: classes44.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f55974a = 0;

    /* JADX INFO: renamed from: com.bytedance.android.gamecp.business.hybrid.a$a, reason: collision with other inner class name */
    public static final class C0902a implements IHybridComponent.a {
        public C0902a() {
        }

        @Override // com.bytedance.android.annie.api.card.IHybridComponent.a
        public final void onJSBridgeCreated(c r100) {
            Intrinsics.checkNotNullParameter(r100, "manager");
            jw.c r101 = (jw.c) s.a(jw.c.class);
            if (r101 == null) goto L6;
            r101.onJSBridgeCreated(r100);
            return;
        }
    }

    public static final class b extends b7.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f55975a;

        public b(String r100) {
            this.f55975a = r100;
        }

        @Override // b7.a, b7.b
        public final boolean onFallback(int r100, String r101) {
            Intrinsics.checkNotNullParameter(r101, "errorMessage");
            yr.c.b("GamePromoteHybrid", "showHybridDialog#onFallback errorCode = " + r100 + "，errorMessage = " + r101);
            return TextUtils.isEmpty(this.f55975a);
        }
    }

    static {
    }

    public static void e(Context r110, Map r111) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, "params");
        String r100 = o2.f561362a.getValue();
        Uri r112 = UriProtector.parse(r100);     // Catch: Exception -> L34
        HashMap r113 = new HashMap();     // Catch: Exception -> L34
        String r114 = (String) r111.get("game_id");     // Catch: Exception -> L34
        String r115 = "";
        if (r114 != null) goto L7;
        r114 = "";
    L7:
        r113.put("game_id", r114);     // Catch: Exception -> L34
        String r101 = (String) r111.get("prop_id");     // Catch: Exception -> L34
        if (r101 != null) goto L10;
        r101 = "";
    L10:
        r113.put("prop_id", r101);     // Catch: Exception -> L34
        String r102 = (String) r111.get("video_id");     // Catch: Exception -> L34
        if (r102 != null) goto L13;
        r102 = "";
    L13:
        r113.put("video_id", r102);     // Catch: Exception -> L34
        String r103 = (String) r111.get("room_id");     // Catch: Exception -> L34
        if (r103 != null) goto L16;
        r103 = "";
    L16:
        r113.put("room_id", r103);     // Catch: Exception -> L34
        String r104 = (String) r111.get(AudienceGamePromoteDetailActionHandler.PARA_PROMOTER_ID);     // Catch: Exception -> L34
        if (r104 != null) goto L19;
        r104 = "";
    L19:
        r113.put(AudienceGamePromoteDetailActionHandler.PARA_PROMOTER_ID, r104);     // Catch: Exception -> L34
        String r105 = (String) r111.get("prop_enter_from");     // Catch: Exception -> L34
        if (r105 != null) goto L22;
        r105 = "";
    L22:
        r113.put("prop_enter_from", r105);     // Catch: Exception -> L34
        String r106 = (String) r111.get("all_props_from");     // Catch: Exception -> L34
        if (r106 != null) goto L25;
        r106 = "";
    L25:
        r113.put("all_props_from", r106);     // Catch: Exception -> L34
        String r107 = (String) r111.get("scene");     // Catch: Exception -> L34
        if (r107 != null) goto L28;
        r107 = "";
    L28:
        r113.put("scene", r107);     // Catch: Exception -> L34
        String r116 = (String) r111.get("route_params");     // Catch: Exception -> L34
        if (r116 == null) goto L32;
        r115 = r116;
    L32:
        r113.put("route_params", r115);     // Catch: Exception -> L34
        String r117 = c1.c(r100, r113);     // Catch: Exception -> L34
        String r108 = UriProtector.getQueryParameter(r112, "fallback_url");     // Catch: Exception -> L34
        a(r110, UriProtector.parse(r117).buildUpon().appendQueryParameter("hybrid_type", "lynx").build(), r108);     // Catch: Exception -> L34
        return;
    L34:
        e = move-exception;
        yr.c.b("GamePromoteHybrid", e.toString());
    }

    public static void a(Context r100, Uri r101, String r102) {
        Uri r103 = c1.a(r101);
        String r104 = UriProtector.getQueryParameter(r103, "gamecp_detail_page_pad_adapt");
        if (r104 != null) goto L6;
        r104 = "1";
    L6:
        if (Intrinsics.areEqual(r104, "1") == true) goto L8;
    L10:
        HybridDialog r105 = com.bytedance.android.gamecp.host_api.a.b().getBrowserService().showHybridDialog(r100, r103, new b(r102));
        if (r105 == null) goto L14;
        r105.setJSBridgeListener(new C0902a());
        return;
    L14:
        return;
    L8:
        if (a3.f561279a.getValue().booleanValue() == false) goto L10;
        iw.a.a(r100);
        goto L10
    }

    public static void b(Context r100, String r101, Map r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "params");
    L9:
        e = move-exception;
        yr.c.b("GamePromoteHybrid", e.toString());
        return;
    L4:
        if (TextUtils.isEmpty(r101) == false) goto L7;
        yr.c.b("GamePromoteHybrid", "lynxScheme is null...");     // Catch: Exception -> L9
        return;
    L7:
        Uri r103 = UriProtector.parse(r101);     // Catch: Exception -> L9
        String r104 = c1.c(r101, r102);     // Catch: Exception -> L9
        String r105 = UriProtector.getQueryParameter(r103, "fallback_url");     // Catch: Exception -> L9
        a(r100, UriProtector.parse(r104).buildUpon().appendQueryParameter("hybrid_type", "lynx").build(), r105);     // Catch: Exception -> L9
    }

    public static void c(Context r100, String r101, Map r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
    L13:
        e = move-exception;
        yr.c.b("GamePromoteHybrid", e.toString());
        return;
    L4:
        if (TextUtils.isEmpty(r101) == false) goto L7;
        yr.c.b("GamePromoteHybrid", "lynxScheme is null...");     // Catch: Exception -> L13
        return;
    L7:
        Uri r103 = UriProtector.parse(r101);     // Catch: Exception -> L13
        String r104 = UriProtector.getQueryParameter(r103, "fallback_url");     // Catch: Exception -> L13
        Uri.Builder r105 = r103.buildUpon();     // Catch: Exception -> L13
        Iterator r106 = ((LinkedHashMap) r102).entrySet().iterator();     // Catch: Exception -> L13
    L9:
        if (r106.hasNext() == false) goto L11;
        Map.Entry r107 = (Map.Entry) r106.next();     // Catch: Exception -> L13
        r105.appendQueryParameter((String) r107.getKey(), (String) r107.getValue());     // Catch: Exception -> L13
        goto L9
    L11:
        a(r100, r105.appendQueryParameter("hybrid_type", "lynx").build(), r104);     // Catch: Exception -> L13
    }

    public static void d(Context r100, String r101, Map r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "params");
    L14:
        e = move-exception;
        yr.c.b("GamePromoteHybrid", e.toString());
        return;
    L4:
        if (TextUtils.isEmpty(r101) == false) goto L7;
        yr.c.b("GamePromoteHybrid", "lynxScheme is null...");     // Catch: Exception -> L14
        return;
    L7:
        if (r101 == null) goto L18;
        String r103 = c1.b(r101, r102);     // Catch: Exception -> L14
        String r104 = UriProtector.getQueryParameter(UriProtector.parse(r103), "fallback_url");     // Catch: Exception -> L14
        if (r104 == null) goto L11;
        String r105 = c1.b(r104, r102);     // Catch: Exception -> L14
    L12:
        a(r100, UriProtector.parse(r103).buildUpon().appendQueryParameter("hybrid_type", "lynx").build(), r105);     // Catch: Exception -> L14
        return;
    L11:
        r105 = null;
        goto L12
    }
}
