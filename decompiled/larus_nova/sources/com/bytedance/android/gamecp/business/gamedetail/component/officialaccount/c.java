package com.bytedance.android.gamecp.business.gamedetail.component.officialaccount;

import com.bytedance.android.ec.slice.SliceInitService;
import com.bytedance.android.gamecp.business.gamedetail.base.track.GameDetailTrackV2;
import com.bytedance.android.gamecp.business.gamedetail.legacy.viewmodel.AudienceGamePromoteDetailViewModel;
import com.bytedance.android.gamecp.business.h0;
import com.bytedance.android.gamecp.common.track.GamecpTracker;
import com.bytedance.android.gamecp.host_api.util.gson.GsonHelper;
import com.bytedance.android.livesdk.schema.AudienceGamePromoteDetailActionHandler;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class c {
    public static final String a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "followUserId");
        Map<String, String> r101 = b(r100);
        return GsonProtectorUtils.toJson(GsonHelper.get(), r101);
    }

    public static final Map<String, String> b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "followUserId");
        HashMap<String, String> r101 = GamecpTracker.f56755a;
        com.bytedance.android.gamecp.common.track.filter.d r102 = GamecpTracker.h(zu.a.class);
        String r103 = null;
        JsonElement r104 = null;
        r104 = null;
        if ((r102 instanceof com.bytedance.android.gamecp.common.track.filter.b) == true) goto L5;
        r102 = null;
    L5:
        com.bytedance.android.gamecp.common.track.filter.b r105 = (com.bytedance.android.gamecp.common.track.filter.b) r102;
        HashMap r106 = new HashMap();
        AudienceGamePromoteDetailViewModel r107 = GameDetailTrackV2.f53492a;
        int r108 = h0.f55949a;
        AudienceGamePromoteDetailViewModel r109 = GameDetailTrackV2.f53492a;
        if (r109 == null) goto L8;
        int r110 = r109.getPromoteScene();
    L9:
        r106.putAll(h0.a(r110, false));
        if (r105 == null) goto L12;
        String r111 = r105.f();
    L13:
        r106.put(AudienceGamePromoteDetailActionHandler.PARA_PROMOTER_SCENE, r111);
        if (r105 == null) goto L16;
        String r112 = r105.g();
    L17:
        r106.put("promote_sub_scene", r112);
        if (r105 != null) goto L36;
    L34:
        r106.put("game_promote_activity_id", r103);
        r106.put(com.bytedance.android.ec.core.event.a.KEY_TO_USER_ID, r100);
        r106.put("enter_from", "promote_detail_account_banner");
        r106.put(MonitorConstants.EXTRA_DOWNLOAD_PAGE, "promote_detail_account_banner");
        return r106;
    L36:
        JsonParser r113 = GsonHelper.a.f57436d;     // Catch: Exception -> L31
        Map<String, String> r114 = r105.f56801a;     // Catch: Exception -> L31
        if (r114 == null) goto L23;
        String r115 = r114.get("promote_scene_sub");     // Catch: Exception -> L31
        if (r115 == null) goto L23;
    L24:
        JsonElement r116 = r113.parse(r115);     // Catch: Exception -> L31
        if (r116 == null) goto L29;
        JsonObject r117 = r116.getAsJsonObject();     // Catch: Exception -> L31
        if (r117 == null) goto L29;
        r104 = r117.get("activity_id");     // Catch: Exception -> L31
    L29:
        String r118 = com.bytedance.android.gamecp.common.track.filter.b.e(r104);     // Catch: Exception -> L31
    L33:
        r103 = r118;
    L23:
        r115 = SliceInitService.DEFAULT_SWITCH;
    L31:
        e = move-exception;
        yr.c.b("BizInfoFilter", e.toString());
        r118 = "";
        goto L33
    L16:
        r112 = null;
        goto L17
    L12:
        r111 = null;
        goto L13
    L8:
        r110 = 0;
        goto L9
    }
}
