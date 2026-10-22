package com.bytedance.android.gamecp.business;

import com.bytedance.android.livesdk.schema.AudienceGamePromoteDetailActionHandler;
import com.bytedance.android.livesdkapi.depend.log.LogFilterName;
import com.bytedance.live.datacontext.DataContext;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f55949a = 0;

    public h0() {
    }

    static {
    }

    public static Map a(int r100, boolean r101) {
        HashMap r102 = new HashMap();
        DataContext r103 = com.bytedance.live.datacontext.d.d(GamePromoteTrackViewModel.class);
        if ((r103 instanceof GamePromoteTrackViewModel) == true) goto L5;
        r103 = null;
    L5:
        GamePromoteTrackViewModel r104 = (GamePromoteTrackViewModel) r103;
        if (r100 == 0) goto L123;
        String r105 = "";
        if (r100 == 1) goto L60;
        if (r100 != 2) goto L128;
        r102.put(AudienceGamePromoteDetailActionHandler.PARA_PROMOTER_SCENE, "official");
        if (r104 == null) goto L16;
        String r106 = r104.getOfficialEnterFrom();
        if (r106 == null) goto L16;
    L17:
        r102.put("official_enter_from", r106);
        if (r104 == null) goto L21;
        String r107 = r104.getGcLaunchFrom();
        if (r107 == null) goto L21;
    L22:
        r102.put("launch_from", r107);
        if (r104 == null) goto L26;
        String r108 = r104.getGcLocation();
        if (r108 == null) goto L26;
    L27:
        r102.put("location", r108);
        if (r104 == null) goto L31;
        String r109 = r104.getGcScene();
        if (r109 == null) goto L31;
    L32:
        r102.put("scene", r109);
        if (r104 == null) goto L36;
        String r110 = r104.getEnterFrom();
        if (r110 == null) goto L36;
    L37:
        r102.put("enter_from", r110);
        if (r104 == null) goto L41;
        String r111 = r104.getAdPlanId();
        if (r111 == null) goto L41;
    L42:
        r102.put("ad_plan_id", r111);
        if (r104 == null) goto L46;
        String r112 = r104.isOtherChannel();
        if (r112 == null) goto L46;
    L47:
        r102.put("is_other_channel", r112);
        if (r104 == null) goto L51;
        String r113 = r104.getAdLogExtra();
        if (r113 == null) goto L51;
    L52:
        r102.put("log_extra", r113);
        if (r104 == null) goto L58;
        String r114 = r104.getAdValue();
        if (r114 == null) goto L58;
        r105 = r114;
    L58:
        r102.put("value", r105);
        return r102;
    L51:
        r113 = "";
    L46:
        r112 = "";
    L41:
        r111 = "";
    L36:
        r110 = "";
    L31:
        r109 = "";
    L26:
        r108 = "";
    L21:
        r107 = "";
    L16:
        r106 = "";
        goto L17
    L128:
        return r102;
    L60:
        if (r101 == false) goto L82;
        if (r104 == null) goto L64;
        String r115 = r104.getPromoteId();
        if (r115 == null) goto L64;
    L65:
        r102.put("author_id", r115);
        if (r104 == null) goto L69;
        String r116 = r104.getShootWay();
        if (r116 == null) goto L69;
    L70:
        r102.put(com.bytedance.android.ec.core.event.a.KEY_SHOOT_WAY, r116);
        if (r104 == null) goto L74;
        String r117 = r104.getCreationId();
        if (r117 == null) goto L74;
    L75:
        r102.put("creation_id", r117);
        if (r104 == null) goto L81;
        String r118 = r104.getEnterFrom();
        if (r118 == null) goto L81;
        r105 = r118;
    L81:
        r102.put("enter_from", r105);
        r102.put(AudienceGamePromoteDetailActionHandler.PARA_PROMOTER_SCENE, "video");
        return r102;
    L74:
        r117 = "";
    L69:
        r116 = "";
    L64:
        r115 = "";
        goto L65
    L82:
        if (r104 == null) goto L85;
        String r119 = r104.getPromoteId();
        if (r119 == null) goto L85;
    L86:
        r102.put("author_id", r119);
        if (r104 == null) goto L90;
        String r120 = r104.getVideoEnterFromMerge();
        if (r120 == null) goto L90;
    L91:
        r102.put("enter_from", r120);
        if (r104 == null) goto L95;
        String r121 = r104.getLogPb();
        if (r121 == null) goto L95;
    L96:
        r102.put("log_pb", r121);
        if (r104 == null) goto L100;
        String r122 = r104.getVideoId();
        if (r122 == null) goto L100;
    L101:
        r102.put("group_id", r122);
        if (r104 == null) goto L105;
        String r123 = r104.getEnterMethod();
        if (r123 == null) goto L105;
    L106:
        r102.put("enter_method", r123);
        if (r104 == null) goto L110;
        String r124 = r104.getEntranceFrom();
        if (r124 == null) goto L110;
    L111:
        r102.put("game_promote_entrance_from", r124);
        r102.put(AudienceGamePromoteDetailActionHandler.PARA_PROMOTER_SCENE, "video");
        if (r104 == null) goto L115;
        String r125 = r104.getAdPlanId();
        if (r125 == null) goto L115;
    L116:
        r102.put("ad_plan_id", r125);
        if (r104 == null) goto L122;
        String r126 = r104.isFromAd();
        if (r126 == null) goto L122;
        r105 = r126;
    L122:
        r102.put("is_from_ad", r105);
        return r102;
    L115:
        r125 = "";
    L110:
        r124 = "";
    L105:
        r123 = "";
    L100:
        r122 = "";
    L95:
        r121 = "";
    L90:
        r120 = "";
    L85:
        r119 = "";
        goto L86
    L123:
        int r127 = com.bytedance.android.gamecp.common.track.b.f56775a;
        return com.bytedance.android.gamecp.common.track.b.d(new String[]{LogFilterName.ROOM, LogFilterName.PAGE_SOURCE_LOG, LogFilterName.LIVE_AD_LOG});
    }

    public static void b(String r100, Map r101, int r110, boolean r111, Map r112) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "logMap");
        DataContext r102 = com.bytedance.live.datacontext.d.d(GamePromoteTrackViewModel.class);
        HashMap<String, String> r103 = null;
        if ((r102 instanceof GamePromoteTrackViewModel) == true) goto L5;
        r102 = null;
    L5:
        GamePromoteTrackViewModel r104 = (GamePromoteTrackViewModel) r102;
        if (r104 == null) goto L8;
        r103 = r104.getReportParams();
    L8:
        HashMap r105 = new HashMap();
        if (r103 == null) goto L14;
        if ((!r103.isEmpty()) != true) goto L14;
        r105.putAll(r103);
    L14:
        if ((!r101.isEmpty()) == false) goto L16;
        r105.putAll(r101);
    L16:
        if (r110 != 0) goto L18;
        r105.put(AudienceGamePromoteDetailActionHandler.PARA_PROMOTER_SCENE, "live");
        int r106 = com.bytedance.android.gamecp.common.track.b.f56775a;
        com.bytedance.android.gamecp.common.track.b.g(r100, r105, new String[]{LogFilterName.ROOM, LogFilterName.PAGE_SOURCE_LOG, LogFilterName.LIVE_AD_LOG});
        return;
    L18:
        if (r110 != 1) goto L20;
        String r113 = (String) r105.get("enter_from");
        if (r113 == null) goto L34;
        r105.put("game_promote_enter_from", r113);
    L34:
        r105.remove("anchor_id");
        r105.remove("room_id");
        r105.remove("live_type");
        r105.remove("function_type");
        r105.putAll(a(1, r111));
        if (r112 != null) goto L37;
    L39:
        com.bytedance.android.gamecp.common.track.b.g(r100, r105, new String[0]);
        return;
    L37:
        if ((!r112.isEmpty()) != true) goto L39;
        r105.putAll(r112);
        goto L39
    L20:
        if (r110 != 2) goto L44;
        String r114 = (String) r105.get("enter_from");
        if (r114 == null) goto L25;
        r105.put("game_promote_enter_from", r114);
    L25:
        r105.remove("anchor_id");
        r105.remove("room_id");
        r105.remove("live_type");
        r105.remove("function_type");
        r105.putAll(a(2, false));
        if (r112 != null) goto L28;
    L30:
        com.bytedance.android.gamecp.common.track.b.g(r100, r105, new String[0]);
        return;
    L28:
        if ((!r112.isEmpty()) != true) goto L30;
        r105.putAll(r112);
        goto L30
    }

    public static /* synthetic */ void c(String r100, Map r101, int r102, boolean r103, int r104) {
        if ((r104 & 4) == 0) goto L6;
        r102 = 0;
    L6:
        if ((r104 & 8) == 0) goto L8;
        r103 = false;
    L8:
        b(r100, r101, r102, r103, null);
    }
}
