package com.bytedance.android.live.broadcastgame.api.interactgame;

import com.bytedance.android.live.broadcastgame.api.AnchorGameContext;
import com.bytedance.android.live.broadcastgame.api.model.InteractID;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.livehostapi.foundation.IHostPlugin;
import com.bytedance.android.livesdk.config.ud0;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.ss.android.downloadlib.constants.EventConstants;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes45.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f59316a = 0;

    public n() {
    }

    public static String l(long r100, boolean r101, boolean r102) {
        if (r102 == false) goto L5;
        return "self_bind";
    L5:
        if (r101 == false) goto L9;
        return "search";
    L9:
        if (r100 != 2) goto L12;
        return "recently";
    L12:
        if (r100 != 3) goto L15;
        return "recommend";
    L15:
        if (r100 != 4) goto L17;
        return IHostPlugin.ENTER_FROM_LINKMIC_TYPE;
    L17:
        return "other";
    }

    public static void k() {
        u.l().sendLog("livesdk_live_function_panel_search_click", MapsKt.mutableMapOf(new Pair[]{new Pair(ILiveRoomPlayFragmentConstant.MALL_ENTRANCE_TYPE, "search_icon")}), new Object[]{Room.class});
    }

    static {
    }

    public static void j(boolean r100) {
        if (r100 == false) goto L4;
        u.l().sendLog("livesdk_live_function_panel_program_search", new LinkedHashMap(), new Object[]{Room.class});
        return;
    L4:
        u.l().b("livesdk_live_takepage_function_panel_program_search");
    }

    public static String m(InteractID r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$toProgramType");
        int r101 = m.f59315a[r100.ordinal()];
        if (r101 != 1) goto L5;
        return "little_plugin";
    L5:
        if (r101 != 2) goto L7;
        return "little_program";
    L7:
        if (r101 != 3) goto L9;
        return "little_game_sonic";
    L9:
        if (r101 == 4) goto L11;
        return "unknown type";
    L11:
        return "little_game";
    }

    public static void a(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "appId");
        Intrinsics.checkNotNullParameter(r101, "gameName");
        Intrinsics.checkNotNullParameter(r102, "clickPosition");
        u.l().sendLog("livesdk_live_game_anchor_function_page_click", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("game_app_id", r100), TuplesKt.to(EventConstants.ExtraJson.GAME_NAME, r101), TuplesKt.to(BdpAppEventConstant.PARAMS_CLICK_POSITION, r102)}), new Object[]{Room.class});
    }

    public static void c(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "programName");
        Intrinsics.checkNotNullParameter(r101, "programId");
        Intrinsics.checkNotNullParameter(r102, "gameAmount");
        u.l().sendLog("livesdk_live_program_consume_list_click", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(ILiveRoomPlayFragmentConstant.PROGRAM_ID, r101), TuplesKt.to("program_name", r100), TuplesKt.to("game_amount", r102)}), new Object[]{Room.class});
    }

    public static void e(long r100, String r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r101, "contentName");
        Intrinsics.checkNotNullParameter("game", "source");
        Pair[] r103 = new Pair[4];
        r103[0] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_CONTENT_ID, String.valueOf(r100));
        r103[1] = TuplesKt.to("content_name", r101);
        r103[2] = TuplesKt.to("source", "game");
        if (r102 == false) goto L5;
        String r104 = "cancel";
    L6:
        r103[3] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_BUTTON_TYPE, r104);
        Map<String, String> r105 = MapsKt.mutableMapOf(r103);
        u.l().sendLog("livesdk_game_screen_share_icon_click", r105, new Object[]{Room.class, com.bytedance.android.live.broadcastgame.api.c.class});
        return;
    L5:
        r104 = "share";
        goto L6
    }

    public static void f(long r100, String r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r101, "contentName");
        Intrinsics.checkNotNullParameter("game", "source");
        Pair[] r103 = new Pair[4];
        r103[0] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_CONTENT_ID, String.valueOf(r100));
        r103[1] = TuplesKt.to("content_name", r101);
        r103[2] = TuplesKt.to("source", "game");
        if (r102 == false) goto L5;
        String r104 = "cancel";
    L6:
        r103[3] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_BUTTON_TYPE, r104);
        Map<String, String> r105 = MapsKt.mutableMapOf(r103);
        u.l().sendLog("livesdk_game_screen_share_icon_show", r105, new Object[]{Room.class, com.bytedance.android.live.broadcastgame.api.c.class});
        return;
    L5:
        r104 = "share";
        goto L6
    }

    public static void h(String r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "programName");
        Intrinsics.checkNotNullParameter(r101, "programId");
        Intrinsics.checkNotNullParameter(r102, "userId");
        Intrinsics.checkNotNullParameter(r103, "selectType");
        u.l().sendLog("livesdk_live_program_pay_panel_click", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(ILiveRoomPlayFragmentConstant.PROGRAM_ID, r101), TuplesKt.to("program_name", r100), TuplesKt.to("user_id", r102), TuplesKt.to(PickerReporterConstants.KEY.TYPE, r103)}), new Object[]{Room.class});
    }

    public static void b(String r100, String r101, String r102, String r103, String r104) {
        Intrinsics.checkNotNullParameter(r100, "programNameNow");
        Intrinsics.checkNotNullParameter(r101, "programIdNow");
        Intrinsics.checkNotNullParameter(r102, "programNameNext");
        Intrinsics.checkNotNullParameter(r103, "programIdNext");
        Intrinsics.checkNotNullParameter(r104, ReportConstant.COMMON_ACTION_TYPE);
        u.l().sendLog("livesdk_live_program_change_click", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("program_id_now", r101), TuplesKt.to("program_name_now", r100), TuplesKt.to("program_id_next", r103), TuplesKt.to("program_name_next", r102), TuplesKt.to("action_type", r104)}), new Object[]{Room.class});
    }

    public static void g(String r100, String r101, boolean r102, String r103, Integer r104) {
        Intrinsics.checkNotNullParameter(r100, "mpId");
        Intrinsics.checkNotNullParameter(r101, "enterPosition");
        com.bytedance.android.livesdk.log.g r105 = u.l();
        Pair[] r106 = new Pair[9];
        r106[0] = TuplesKt.to(BdpAppEventConstant.PARAMS_MP_ID, r100);
        boolean r107 = true;
        r106[1] = TuplesKt.to(BdpAppEventConstant.PARAMS_FOR_SPECIAL, BdpAppEventConstant.MICRO_APP);
        r106[2] = TuplesKt.to("scene", "023009");
        r106[3] = TuplesKt.to("launch_from", "live");
        r106[4] = TuplesKt.to("location", "preview");
        r106[5] = TuplesKt.to(BdpAppEventConstant.PARAMS_ENTER_POSITION, r101);
        r106[6] = TuplesKt.to("entrance_form", "solid_entrance");
        r106[7] = TuplesKt.to("enter_from_merge", "live_take_page");
        if (r102 == false) goto L5;
        String r108 = "in_live";
    L6:
        r106[8] = TuplesKt.to("live_status", r108);
        Map r109 = MapsKt.mutableMapOf(r106);
        if (r103 != null) goto L9;
    L12:
        if (r107 == true) goto L14;
        r109.put("recommend_reason", r103);
    L14:
        if (r104 == null) goto L16;
        r104.intValue();
        r109.put("bind_mp_order", String.valueOf(r104.intValue()));
    L16:
        Unit r110 = Unit.INSTANCE;
        r105.e(BdpAppEventConstant.EVENT_MP_SHOW, r109, new Object[0]);
        return;
    L9:
        if (StringsKt.isBlank(r103) == true) goto L12;
        r107 = false;
        goto L12
    L5:
        r108 = "before_live";
        goto L6
    }

    public static void i(String r100, String r101, String r102, long r103, int r104, String r105) {
        Intrinsics.checkNotNullParameter(r100, "programName");
        Intrinsics.checkNotNullParameter(r101, "programId");
        Intrinsics.checkNotNullParameter(r102, "gameId");
        Intrinsics.checkNotNullParameter(r105, "gameCategory");
        Pair[] r106 = new Pair[8];
        r106[0] = TuplesKt.to(ILiveRoomPlayFragmentConstant.PROGRAM_ID, r101);
        r106[1] = TuplesKt.to("program_name", r100);
        r106[2] = TuplesKt.to("game_id", r102);
        r106[3] = TuplesKt.to("duration", String.valueOf(r103));
        r106[4] = TuplesKt.to("status", String.valueOf(r104));
        AnchorGameContext.Companion.getClass();
        AnchorGameContext r107 = AnchorGameContext.a.a();
        if (r107 == null) goto L8;
        com.bytedance.live.datacontext.m<String> r108 = r107.getClickIconSourceType();
        if (r108 == null) goto L8;
        String r109 = r108.getValue();
        if (r109 == null) goto L8;
    L9:
        r106[5] = TuplesKt.to("source_type", r109);
        r106[6] = TuplesKt.to("source", ((IInteractService) jc1.k.n(IInteractService.class)).getCurrentSwitchSceneSource());
        r106[7] = TuplesKt.to(BdpAppEventConstant.PARAMS_GAME_CATEGORY, r105);
        Map<String, String> r110 = MapsKt.mutableMapOf(r106);
        AnchorGameContext r111 = AnchorGameContext.a.a();
        if (r111 == null) goto L16;
        com.bytedance.live.datacontext.n<String> r112 = r111.getGuideActivityName();
        if (r112 == null) goto L16;
        String r113 = r112.getValue();
        if (r113 == null) goto L16;
        r110.put("activity_name", r113);
    L16:
        u.l().sendLog("livesdk_live_program_loading_duration", r110, new Object[]{Room.class});
        return;
    L8:
        r109 = "normal";
        goto L9
    }

    public static void d(boolean r110, String r111, String r112, InteractID r210, long r211, boolean r212, String r213, Integer r214, String r215, String r216, Integer r217) {
        Intrinsics.checkNotNullParameter(r111, "programId");
        Intrinsics.checkNotNullParameter(r112, "programName");
        Intrinsics.checkNotNullParameter(r210, "interactID");
        boolean r100 = true;
        if (ud0.f121363a.getValue().booleanValue() == true) goto L22;
        InteractID.Companion.getClass();
        Intrinsics.checkNotNullParameter(r210, "$this$isManagedByOpenPlatform");
        if (r210 != InteractID.OpenGame) goto L7;
    L14:
        boolean r101 = true;
    L15:
        if (r101 == true) goto L22;
        Intrinsics.checkNotNullParameter(r210, "$this$isOldGameType");
        if (r210 != InteractID.EffectGame) goto L19;
        boolean r102 = true;
    L20:
        if (r102 == true) goto L22;
        return;
    L19:
        r102 = false;
        goto L20
    L7:
        if (r210 == InteractID.OpenMicroApp) goto L14;
        if (r210 == InteractID.SonicMiniGame) goto L14;
        if (r210 == InteractID.OpenMicroGame) goto L14;
        r101 = false;
    L22:
        Map<String, String> r103 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(ILiveRoomPlayFragmentConstant.PROGRAM_ID, r111), TuplesKt.to("program_name", r112), TuplesKt.to("program_type", m(r210)), TuplesKt.to("mp_position", l(r211, r212, false)), TuplesKt.to("enter_from", r215), TuplesKt.to("params_array", r216), TuplesKt.to("play_status", String.valueOf(r217))});
        if (r110 == false) goto L25;
        u.l().sendLog("livesdk_live_function_panel_program_click", r103, new Object[]{Room.class});
    L26:
        String r104 = l(r211, r212, false);
        Intrinsics.checkNotNullParameter(r111, "mpId");
        Intrinsics.checkNotNullParameter(r104, "enterPosition");
        com.bytedance.android.livesdk.log.g r105 = u.l();
        Pair[] r106 = new Pair[9];
        r106[0] = TuplesKt.to(BdpAppEventConstant.PARAMS_MP_ID, r111);
        r106[1] = TuplesKt.to(BdpAppEventConstant.PARAMS_FOR_SPECIAL, BdpAppEventConstant.MICRO_APP);
        r106[2] = TuplesKt.to("scene", "023009");
        r106[3] = TuplesKt.to("launch_from", "live");
        r106[4] = TuplesKt.to("location", "preview");
        r106[5] = TuplesKt.to(BdpAppEventConstant.PARAMS_ENTER_POSITION, r104);
        r106[6] = TuplesKt.to("entrance_form", "solid_entrance");
        r106[7] = TuplesKt.to("enter_from_merge", "live_take_page");
        if (r110 == false) goto L29;
        String r107 = "in_live";
    L30:
        r106[8] = TuplesKt.to("live_status", r107);
        Map r108 = MapsKt.mutableMapOf(r106);
        if (r213 != null) goto L33;
    L36:
        if (r100 == true) goto L38;
        r108.put("recommend_reason", r213);
    L38:
        if (r214 == null) goto L40;
        r214.intValue();
        r108.put("bind_mp_order", String.valueOf(r214.intValue()));
    L40:
        Unit r109 = Unit.INSTANCE;
        r105.e(BdpAppEventConstant.EVENT_MP_CLICK, r108, new Object[0]);
        return;
    L33:
        if (StringsKt.isBlank(r213) == true) goto L36;
        r100 = false;
        goto L36
    L29:
        r107 = "before_live";
        goto L30
    L25:
        u.l().sendLog("livesdk_live_takepage_function_panel_program_click", r103, new Object[0]);
        goto L26
    }
}
