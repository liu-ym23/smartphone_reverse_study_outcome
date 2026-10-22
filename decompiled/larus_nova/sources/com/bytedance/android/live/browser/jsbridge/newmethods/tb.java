package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.text.TextUtils;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.utils.JsonUtil;
import com.bytedance.android.live.core.utils.screen.FoldScreenUtils;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.openplatform.api.minigame.IOpenPlatformMgAnchorService;
import com.bytedance.android.live.openplatform.api.minigame.IOpenPlatformMgAudienceService;
import com.bytedance.android.live.room.IMiddlewareRoomService;
import com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness;
import com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.interactivity.api.IGroupLiveService;
import com.bytedance.android.livesdk.log.filter.PadFoldDeviceSendFilter;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.depend.model.live.IAnchorTogetherLive;
import com.bytedance.android.livesdkapi.depend.model.live.IGroupLiveData;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomOthersData;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Permission;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "sendLogV3")
public final class tb extends com.bytedance.ies.web.jsbridge2.g<JSONObject, Object> {
    public tb() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.g
    public final /* bridge */ /* synthetic */ Object invoke(JSONObject r100, CallContext r101) throws Exception {
        return j(r100, r101);
    }

    public final Object j(JSONObject r210, CallContext r211) throws Exception {
        String r100 = r210.optString("eventName");
        if (TextUtils.isEmpty(r100) == false) goto L6;
        JSONObject r101 = new JSONObject();
        r101.put("code", 0);
        r101.put("msg", "eventName is null");
        return r101;
    L6:
        JSONObject r102 = r210.optJSONObject("params");
        xs2.b.a().post(new jd0.l(r100, JsonUtil.copyJson2(r102)));
        HashMap r103 = new HashMap();
        if (r102 == null) goto L12;
        Iterator<String> r104 = r102.keys();
    L10:
        if (r104.hasNext() == false) goto L12;
        String r110 = r104.next();
        String r111 = r102.optString(r110);
        r104.remove();
        r103.put(r110, r111);
    L12:
        r103.remove("addClientPublicParam");
        com.bytedance.android.live.liveinteract.api.utils.i.a(r103);
        int r105 = l30.g.f507222a;
        Intrinsics.checkNotNullParameter(r103, "args");
        com.bytedance.android.livesdk.chatroom.o r106 = com.bytedance.android.livesdk.chatroom.utils.o3.f();
        if (r106 == null) goto L15;
        Boolean r107 = r106.isVSRoom();
    L16:
        Boolean r112 = Boolean.TRUE;
        if (Intrinsics.areEqual(r107, r112) == false) goto L42;
        com.bytedance.android.livesdk.log.filter.o r108 = com.bytedance.android.livesdk.log.j0.l().c(IRoom.class);
        if ((r108 instanceof com.bytedance.android.livesdk.log.filter.u) == true) goto L21;
        r108 = null;
    L21:
        com.bytedance.android.livesdk.log.filter.u r109 = (com.bytedance.android.livesdk.log.filter.u) r108;
        if (r109 == null) goto L24;
        Map<String, String> r113 = r109.getMap();
    L25:
        if (r113 == null) goto L42;
        String r114 = r113.get("vs_episode_sub_type");
        if (r114 != null) goto L29;
        r114 = "";
    L29:
        l30.g.a(r103, "vs_episode_sub_type", r114);
        l30.g.a(r103, "request_id", r113.get("request_id"));
        l30.g.a(r103, "log_pb", r113.get("log_pb"));
        l30.g.a(r103, "video_id", r113.get("video_id"));
        l30.g.a(r103, "vs_season_id", r113.get("vs_season_id"));
        l30.g.a(r103, "vs_content_id", r113.get("vs_content_id"));
        com.bytedance.android.livesdk.chatroom.o r115 = com.bytedance.android.livesdk.chatroom.utils.o3.f();
        if (r115 == null) goto L32;
        Boolean r116 = r115.isVSRoom();
    L34:
        if (Intrinsics.areEqual(r116, r112) == false) goto L36;
        String r117 = "1";
    L37:
        l30.g.a(r103, "is_vs", r117);
        l30.g.a(r103, "vs_episode_id", r113.get("vs_episode_id"));
        l30.g.a(r103, "vs_ep_group_id", r113.get("vs_ep_group_id"));
        l30.g.a(r103, "vs_episode_stage", r113.get("vs_episode_stage"));
        if (com.bytedance.android.livesdk.utils.e5.n() == false) goto L40;
        String r118 = "landscape";
    L41:
        l30.g.a(r103, "vs_screen_type", r118);
        l30.g.a(r103, "vs_is_portraid_content", r113.get("vs_is_portraid_content"));
        goto L42
    L40:
        r118 = "portrait";
        goto L41
    L36:
        r117 = "0";
        goto L37
    L32:
        r116 = null;
        goto L34
    L24:
        r113 = null;
    L42:
        int r119 = l30.a.f507208a;
        Intrinsics.checkNotNullParameter(r103, "args");
        MiddlewareRoomContext.a r120 = MiddlewareRoomContext.Companion;
        long r121 = 0;
        MiddlewareRoomContext r122 = MiddlewareRoomContext.a.c(r120, null, 0, 3);
        if (r122 == null) goto L55;
        com.bytedance.live.datacontext.m<Room> r123 = r122.getRoom();
        if (r123 == null) goto L55;
        Room r124 = r123.getValue();
        if (r124 == null) goto L55;
        RoomOthersData r125 = r124.others;
        if (r125 == null) goto L55;
        IGroupLiveData r126 = r125.getGroupData();
        if (r126 == null) goto L55;
        if (r126.isCurrentGroupLive() != true) goto L55;
        r103.put("is_grouped_lived", "1");
    L56:
        MiddlewareRoomContext r127 = MiddlewareRoomContext.a.c(r120, null, 0, 3);
        if (r127 == null) goto L69;
        com.bytedance.live.datacontext.m<Room> r128 = r127.getRoom();
        if (r128 == null) goto L69;
        Room r129 = r128.getValue();
        if (r129 == null) goto L69;
        RoomOthersData r130 = r129.others;
        if (r130 == null) goto L69;
        IAnchorTogetherLive r131 = r130.getAnchorTogetherLive();
        if (r131 == null) goto L69;
        if (r131.getLiveTogetherStatus() != 1) goto L69;
        r103.put("is_group_co_rec", "1");
    L70:
        MiddlewareRoomContext r132 = MiddlewareRoomContext.a.c(r120, null, 0, 3);
        if (r132 == null) goto L79;
        com.bytedance.live.datacontext.m<Room> r133 = r132.getRoom();
        if (r133 == null) goto L79;
        Room r134 = r133.getValue();
        if (r134 == null) goto L79;
        User r135 = r134.mo8271getOwner();
        if (r135 == null) goto L79;
        String r136 = r135.getIdString();
    L80:
        IGroupLiveService r137 = (IGroupLiveService) jc1.k.f(IGroupLiveService.class);
        if (r137 != null) goto L83;
        DataCenter r138 = null;
        int r139 = 3;
    L102:
        MiddlewareRoomContext r140 = MiddlewareRoomContext.a.c(r120, r138, r121, r139);
        if (r140 == null) goto L113;
        com.bytedance.live.datacontext.m<Room> r141 = r140.getRoom();
        if (r141 == null) goto L113;
        Room r142 = r141.getValue();
        if (r142 == null) goto L113;
        RoomOthersData r143 = r142.others;
        if (r143 == null) goto L113;
        IGroupLiveData r144 = r143.getGroupData();
        if (r144 == null) goto L113;
        int r145 = r144.getGroupLiveMode();
    L114:
        r103.put("group_live_mode", String.valueOf(r145));
        IGroupLiveService r146 = (IGroupLiveService) jc1.k.f(IGroupLiveService.class);
        if (r146 == null) goto L128;
        String r147 = r146.getAnchorIdBeforeJump();
        if (r147 == null) goto L128;
        if (r147.length() <= 0) goto L121;
        boolean r148 = true;
    L122:
        if (r148 == false) goto L128;
        if ((!Intrinsics.areEqual(r147, "0")) == false) goto L128;
        if ((!Intrinsics.areEqual(r136, r147)) == false) goto L128;
        Object r149 = "1";
    L129:
        r103.put("is_link_screen_co_rec", r149);
        com.bytedance.android.livesdk.log.filter.o r150 = com.bytedance.android.livesdk.log.j0.l().c(am2.x.class);
        if ((r150 instanceof com.bytedance.android.livesdk.log.filter.t) == true) goto L132;
        r150 = null;
    L132:
        com.bytedance.android.livesdk.log.filter.t r151 = (com.bytedance.android.livesdk.log.filter.t) r150;
        if (r151 == null) goto L145;
        String r152 = r151.D();
        if (r152 == null) goto L145;
        if (r152.length() <= 0) goto L139;
        boolean r153 = true;
    L140:
        if (r153 == true) goto L143;
        r152 = null;
    L143:
        if (r152 == null) goto L145;
        r103.put("group_member_id", r152);
        goto L145
    L139:
        r153 = false;
    L145:
        IOpenPlatformMgAnchorService r154 = (IOpenPlatformMgAnchorService) jc1.k.f(IOpenPlatformMgAnchorService.class);
        if (r154 == null) goto L148;
        r154.injectMgParams(r103);
    L148:
        IOpenPlatformMgAudienceService r155 = (IOpenPlatformMgAudienceService) jc1.k.f(IOpenPlatformMgAudienceService.class);
        if (r155 == null) goto L152;
        r155.injectMgParams(r103);
    L152:
        if (com.bytedance.android.livesdk.w0.f160649a.getValue().booleanValue() == false) goto L179;
        int r156 = l30.e.f507220a;
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r103, "args");
        if (r100.hashCode() != (-1837102167)) goto L179;
        if (r100.equals("livesdk_fans_club_join_success") == false) goto L179;
        CharSequence r157 = (CharSequence) r103.get(ILiveRoomPlayFragmentConstant.EXTRA_LIVE_RECOMMEND_INFO);
        if (r157 != null) goto L161;
    L164:
        boolean r158 = true;
    L165:
        if (r158 == false) goto L179;
        com.bytedance.android.livesdk.log.filter.o r159 = com.bytedance.android.livesdk.log.j0.l().c(am2.x.class);
        if (r159 == null) goto L179;
        String r160 = r159.getMap().get(ILiveRoomPlayFragmentConstant.EXTRA_LIVE_RECOMMEND_INFO);
        if (r160 != null) goto L172;
    L175:
        boolean r161 = true;
    L176:
        if (r161 == true) goto L179;
        r103.put(ILiveRoomPlayFragmentConstant.EXTRA_LIVE_RECOMMEND_INFO, r160);
        goto L179
    L172:
        if (r160.length() == 0) goto L175;
        r161 = false;
        goto L176
    L161:
        if (r157.length() == 0) goto L164;
        r158 = false;
    L179:
        com.bytedance.android.live.incentive.et.c r162 = (com.bytedance.android.live.incentive.et.c) qa0.c.f532212b.getService(com.bytedance.android.live.incentive.et.c.class);
        if (r162 == null) goto L183;
        r162.j(r100, r103);
    L183:
        if (r103.containsKey("addClientParamForGuestBattle") == true) goto L185;
    L187:
        r103.remove("addClientParamForGuestBattle");
        if (r103.containsKey("addClientParamForSelfDiscipline") == true) goto L190;
    L197:
        r103.put("sdk_version", String.valueOf(com.bytedance.android.livesdk.paas.c.b()));
        r103.put(com.bytedance.android.ec.core.event.a.KEY_PARAM_LIVE_PLATFROM, "live");
        r103.put("room_orientation", com.bytedance.android.livesdk.log.j0.f153362d);
        if (TextUtils.equals(r100, "page_view") == false) goto L212;
        if (r103.containsKey("btm") == false) goto L212;
        if (TextUtils.equals((CharSequence) r103.get("btm"), "a1.b7411.c0.d0") == false) goto L212;
        IMiddlewareHostBusiness r163 = (IMiddlewareHostBusiness) jc1.k.f(IMiddlewareHostBusiness.class);
        if (r163 == null) goto L212;
        Map<String, String> r164 = r163.getEcomExtraLogParams(r100, r103, r211.f249269d);
        if (r164 == null) goto L212;
        Iterator<Map.Entry<String, String>> r165 = r164.entrySet().iterator();
    L209:
        if (r165.hasNext() == false) goto L212;
        Map.Entry<String, String> r166 = r165.next();
        r103.put(r166.getKey(), r166.getValue());
    L212:
        if (r103.containsKey("btm") == false) goto L221;
        if (r103.containsKey("btm_show_id") == true) goto L221;
        IMiddlewareHostBusiness r167 = (IMiddlewareHostBusiness) jc1.k.f(IMiddlewareHostBusiness.class);
        if (r167 == null) goto L221;
        Map<String, String> r168 = r167.obtainEventParams(r103, r211.f249269d);
        if (r168 == null) goto L221;
        r103.putAll(r168);
    L221:
        if (r103.containsKey("btm") == true) goto L224;
        com.bytedance.android.livesdk.log.filter.g.f153296b.L9(r100, r103);
    L224:
        if (r103.containsKey("explain_product_id") == true) goto L226;
        com.bytedance.android.livesdk.log.filter.j0.f153300a.L9(r100, r103);
    L226:
        IMiddlewareRoomService r169 = (IMiddlewareRoomService) jc1.k.f(IMiddlewareRoomService.class);
        if (r169 == null) goto L253;
        ((PadFoldDeviceSendFilter) r169.getPadFoldDeviceSendFilter()).getClass();
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r103, "params");
        if (PadFoldDeviceSendFilter.c(r100) == false) goto L253;
        if (PadConfigUtils.a() == false) goto L233;
        Object r170 = "1";
    L234:
        r103.put("is_pad", r170);
        if (FoldScreenUtils.f() == false) goto L237;
        Object r171 = "1";
    L238:
        r103.put("is_fold_screen", r171);
        if (FoldScreenUtils.f66393a != null) goto L241;
        FoldScreenUtils.f66393a = (IMiddleWareHostContext) jc1.k.f(IMiddleWareHostContext.class);
    L241:
        IMiddleWareHostContext r172 = FoldScreenUtils.f66393a;
        if (r172 == null) goto L244;
        int r173 = r172.getFoldType();
    L245:
        r103.put("fold_type", String.valueOf(r173));
        ce1.d r174 = ce1.e.f23443a;
        if (r174 != null) goto L248;
    L250:
        Object r175 = "0";
    L251:
        r103.put("is_pad_landscape", r175);
        r103.put("fold_position", PadFoldDeviceSendFilter.b());
        int r176 = com.bytedance.android.live.core.utils.s1.y();
        int r177 = com.bytedance.android.live.core.utils.s1.w();
        StringBuilder r178 = new StringBuilder();
        r178.append(r176);
        r178.append(Permission.EXECUTE);
        r178.append(r177);
        r103.put("app_available_size", r178.toString());
        r103.put("app_aspect_ratio", PadFoldDeviceSendFilter.a(r176, r177));
        goto L253
    L248:
        if (r174.e() != true) goto L250;
        r175 = "1";
        goto L251
    L244:
        r173 = -1;
        goto L245
    L237:
        r171 = "0";
        goto L238
    L233:
        r170 = "0";
    L253:
        if (r211.f249271f == false) goto L255;
        r103.put("is_open_anniex", "1");
    L257:
        if (r100.startsWith("livesdk_replay_video") == false) goto L259;
        pm1.f.f().f(null, r100, r103, new Object[0]);
        int r179 = 1;
    L260:
        JSONObject r180 = new JSONObject();
        r180.put("code", r179);
        r180.put("msg", "SUCCESS");
        return r180;
    L259:
        r179 = 1;
        com.bytedance.android.livesdk.log.j0.l().sendLog(r100, r103, new Object[]{am2.x.class, Room.class});
        goto L260
    L255:
        r103.put("is_open_anniex", "0");
        goto L257
    L190:
        if (TextUtils.equals((CharSequence) r103.get("addClientParamForSelfDiscipline"), "1") == false) goto L197;
        IInteractService r181 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r181 == null) goto L196;
        kj0.b r182 = r181.getSelfDisciplineService();
        if (r182 == null) goto L196;
        r182.addExtraLog(r103);
    L196:
        r103.remove("addClientParamForSelfDiscipline");
        goto L197
    L185:
        if (TextUtils.equals((CharSequence) r103.get("addClientParamForGuestBattle"), "1") == false) goto L187;
        com.bytedance.android.live.liveinteract.utils.w.b(r103);
        goto L187
    L121:
        r148 = false;
    L128:
        r149 = "0";
    L113:
        r145 = 0;
        goto L114
    L83:
        if (r137.getAnchorIdBeforeJump().length() <= 0) goto L85;
        boolean r183 = true;
    L86:
        if (r183 == true) goto L88;
    L94:
        boolean r184 = false;
    L95:
        if (r184 == true) goto L98;
        r137 = null;
    L98:
        if (r137 == null) goto L100;
        r103.put("throw_user_id", r137.getAnchorIdBeforeJump());
        r103.put("throw_room_id", String.valueOf(r137.getRoomIdBeforeJump()));
        r103.put("link_screen_request_id", r137.getRequestIdBeforeJump());
    L100:
        r138 = null;
        r139 = 3;
        r121 = 0;
        goto L102
    L88:
        if ((!Intrinsics.areEqual(r137.getAnchorIdBeforeJump(), "0")) == false) goto L94;
        if (r137.getRoomIdBeforeJump() <= 0) goto L94;
        if ((!Intrinsics.areEqual(r136, r137.getAnchorIdBeforeJump())) == false) goto L94;
        r184 = true;
        goto L95
    L85:
        r183 = false;
    L79:
        r136 = null;
    L69:
        r103.put("is_group_co_rec", "0");
    L55:
        r103.put("is_grouped_lived", "0");
        goto L56
    L15:
        r107 = null;
        goto L16
    }
}
