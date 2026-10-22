package com.bytedance.android.live.liveinteract.plantform.utils;

import android.text.TextUtils;
import com.bytedance.android.live.base.exception.ApiException;
import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.core.monitor.LiveSlardarMonitor;
import com.bytedance.android.live.core.network.CustomApiServerException;
import com.bytedance.android.live.core.setting.b6;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.plantform.permission.model.BaseCheckException;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.message.model.ReplyType;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.interact.data.LinkConstant;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.larksuite.component.card.plugin.ReportCardMonitorPlugin;
import com.ss.android.lark.search.dto.UserGroupScene;
import com.ss.ttvideoengine.ITTVideoEngineEventSource;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes46.dex */
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f77572a = 0;

    public x() {
    }

    @JvmStatic
    public static final void J() {
        t0("start_capture_audio_when_pause", new LinkedHashMap());
    }

    @JvmStatic
    public static final void L() {
        t0("check_link_permission_success", new LinkedHashMap());
    }

    @JvmStatic
    public static final void M() {
        t0("silence_by_anchor_on_background", new LinkedHashMap());
    }

    @JvmStatic
    public static final void j0() {
        t0("rtc_not_release", new HashMap());
    }

    static {
    }

    @JvmStatic
    public static final void C0(TalkRoomOperate r100) {
        Intrinsics.checkNotNullParameter(r100, WikiFolderPushPlugin.OPT);
        LinkedHashMap r101 = new LinkedHashMap();
        r101.put(WikiFolderPushPlugin.OPT, r100.getOperate());
        r101.put("talk_room_admin_enable", Boolean.valueOf(vm2.d.x0()));
        com.bytedance.android.livesdk.sharedpref.e<Boolean> r102 = b6.f65238i;
        r101.put("video_talk_admin_support", r102.getValue());
        r101.put("audio_talk_admin_support", r102.getValue());
        r101.put("intimate_chat_admin_support", r102.getValue());
        t0("talk_room_admin_operate_exception", r101);
    }

    public static void G(String r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        LinkedHashMap r101 = new LinkedHashMap();
        r101.put("activity", r100);
        t0("dialog_exception", r101);
    }

    @JvmStatic
    public static final void K(BaseCheckException r100) {
        Intrinsics.checkNotNullParameter(r100, com.bytedance.android.ec.core.event.a.KEY_EXCEPTION);
        LinkedHashMap r101 = new LinkedHashMap();
        r101.put("operate_type", r100.getOperateType());
        r101.put("check_type", r100.getCheckType().name());
        String r102 = r100.getMessage();
        String r103 = "";
        if (r102 != null) goto L5;
        r102 = "";
    L5:
        r101.put("error_msg", r102);
        Throwable r104 = r100.getCause();
        if (r104 != null) goto L8;
    L20:
        t0("check_link_permission_failed", r101);
        return;
    L8:
        if ((r104 instanceof CustomApiServerException) == false) goto L11;
        CustomApiServerException r105 = (CustomApiServerException) r104;
        r101.put("url", r105.getUrl());
        r101.put("xTtLogId", r105.getXTtLogId());
    L11:
        if ((r104 instanceof ApiServerException) == false) goto L18;
        String r106 = r104.getMessage();
        if (r106 == null) goto L16;
        r103 = r106;
    L16:
        r101.put("cause_msg", r103);
    L18:
        if ((r104 instanceof ApiException) == false) goto L20;
        r101.put("error_code", Integer.valueOf(((ApiException) r104).getErrorCode()));
        goto L20
    }

    @JvmStatic
    public static final void O(boolean r100) {
        LinkedHashMap r101 = new LinkedHashMap();
        r101.put("use_single_view", Boolean.valueOf(r100));
        t0("live_core_single_view", r101);
    }

    @JvmStatic
    public static final void R(int r100) {
        LinkedHashMap r101 = new LinkedHashMap();
        r101.put("list_status", Integer.valueOf(r100));
        t0("on_pause_mute_error", r101);
    }

    @JvmStatic
    public static final void a(Map<String, Object> r100) {
        IInteractService r101 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r101 == null) goto L30;
        int r102 = r101.getLinkMode();
        if (r102 != 0) goto L7;
        String r103 = "none";
    L29:
        r100.put("link_type", r103);
        goto L30
    L7:
        if (r102 != 2) goto L9;
        ((com.bytedance.android.live.liveinteract.service.f) r101.getInteractAudienceService()).getClass();
        com.bytedance.android.live.liveinteract.api.data.a r104 = com.bytedance.android.live.liveinteract.api.data.a.a();
        if (r104.f71435c == false) goto L27;
        r100.put("paid_count", Integer.valueOf(r104.f71433a));
        r100.put("limit_time", Integer.valueOf(r104.f71434b));
    L27:
        r103 = "video_audience";
        goto L29
    L9:
        if (r102 != 4) goto L11;
        r103 = "cross_room";
        goto L29
    L11:
        if (r102 != 8) goto L13;
        r103 = "audio_talk";
        goto L29
    L13:
        if (r102 != 32) goto L15;
        com.bytedance.android.live.liveinteract.api.data.a r105 = r101.getVideoTalkService().j();
        if (r105.f71435c == false) goto L21;
        r100.put("paid_count", Integer.valueOf(r105.f71433a));
        r100.put("limit_time", Integer.valueOf(r105.f71434b));
    L21:
        r103 = LinkConstant.VIDEO_TALK;
        goto L29
    L15:
        if (r102 == 64) goto L17;
        r103 = "other:" + r101.getLinkMode();
        goto L29
    L17:
        r103 = "multi_anchor";
    L30:
        String r106 = ((IMiddlewareUserService) jc1.k.n(IMiddlewareUserService.class)).user().n();
        com.bytedance.live.datacontext.m<IRoom> r107 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r107 == null) goto L35;
        IRoom r108 = r107.getValue();
        if (r108 == null) goto L35;
        String r109 = r108.getOwnerUserIdString();
    L36:
        boolean r110 = ((IMiddlewareUserService) jc1.k.n(IMiddlewareUserService.class)).user().c();
        boolean r111 = ((IMiddlewareUserService) jc1.k.n(IMiddlewareUserService.class)).user().isAdmin();
        if (Intrinsics.areEqual(r106, r109) == false) goto L39;
        String r112 = "anchor";
    L44:
        r100.put("role", r112);
        r100.put("self_id", r106);
        r100.put("scene", Integer.valueOf(((IInteractService) jc1.k.n(IInteractService.class)).getCurrentScene()));
        Object r113 = ((IInteractService) jc1.k.n(IInteractService.class)).getCurrentPlayModes();
        if (r113 != null) goto L47;
        r113 = "null";
    L47:
        r100.put("play_modes", r113);
        return;
    L39:
        if (r110 == false) goto L41;
        r112 = "talkRoomAdmin";
        goto L44
    L41:
        if (r111 == false) goto L43;
        r112 = UserGroupScene.DEFAULT_NAME_SPACE;
        goto L44
    L43:
        r112 = "guest";
    L35:
        r109 = null;
        goto L36
    }

    public static void g(String r100) {
        Intrinsics.checkNotNullParameter(r100, "reason");
        LinkedHashMap r101 = new LinkedHashMap();
        r101.put("reason", r100);
        t0("digit_avatar_recognition_fail", r101);
    }

    @JvmStatic
    public static final void m0(tf0.i r100) {
        Intrinsics.checkNotNullParameter(r100, "dataHolder");
        HashMap r101 = new HashMap();
        if ((r100 instanceof tc0.c) == false) goto L9;
        hd0.c r102 = hd0.c.f();
        if (r102 == null) goto L7;
        int r103 = r102.f484576g;
    L8:
        r101.put("link_mode", Integer.valueOf(r103));
        goto L9
    L7:
        r103 = 0;
    L9:
        u0("rtc_turn_on", r101, r100);
    }

    @JvmStatic
    public static final void w(String r100) {
        Intrinsics.checkNotNullParameter(r100, "targetId");
        LinkedHashMap r101 = new LinkedHashMap();
        r101.put("target_user_id", r100);
        t0("kickout_when_rtc_user_lost", r101);
    }

    @JvmStatic
    public static final void z0(long r100) {
        LinkedHashMap r101 = new LinkedHashMap();
        r101.put("duration", Long.valueOf(r100));
        t0("start_link_mic_success", r101);
    }

    @JvmStatic
    public static final void A(tc0.c r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "dataHolder");
        Intrinsics.checkNotNullParameter(r101, "reason");
        HashMap r102 = new HashMap();
        r102.put("reason", r101);
        u0("livecore_stop", r102, r100);
    }

    @JvmStatic
    public static final void B(int r100, long r101) {
        int r102 = r100 + 10;
        if (vm2.g.a() == false) goto L5;
        r102 = r102 + 100;
    L5:
        LiveSlardarMonitor.monitorStatusAndDuration("ttlive_audience_link_first_frame_status", r102, r101);
    }

    @JvmStatic
    public static final void C(Throwable r100, boolean r101) {
        LinkedHashMap r102 = new LinkedHashMap();
        a(r102);
        X(r100, r102);
        if (r101 == false) goto L6;
        t0("audience_link_settings_error", r102);
        return;
    L6:
        r102.put(ReportCardMonitorPlugin.EVENT_NAME, "audience_link_settings_error");
        com.bytedance.android.livesdk.log.b0.o().j("ttlive_link", r102);
    }

    @JvmStatic
    public static final void I(int r100, long r101) {
        LiveSlardarMonitor.monitorStatusAndDuration("ttlive_audience_link_first_frame_status", r100, r101);
    }

    @JvmStatic
    public static final void P(Integer r100, String r101) {
        LinkedHashMap r102 = new LinkedHashMap();
        if (r100 == null) goto L5;
        int r103 = r100.intValue();
    L6:
        r102.put("open_panel_type", Integer.valueOf(r103));
        if (r101 != null) goto L9;
        r101 = "";
    L9:
        r102.put("platform_activity_id", r101);
        t0("open_panel_for_schema", r102);
        return;
    L5:
        r103 = 0;
        goto L6
    }

    @JvmStatic
    public static final void X(Throwable r100, Map<String, Object> r101) {
        Intrinsics.checkNotNullParameter(r101, "extra");
        if (r100 != null) goto L5;
        return;
    L5:
        if ((r100 instanceof CustomApiServerException) == false) goto L8;
        CustomApiServerException r102 = (CustomApiServerException) r100;
        r101.put("url", r102.getUrl());
        r101.put("xTtLogId", r102.getXTtLogId());
    L8:
        if ((r100 instanceof ApiServerException) == false) goto L16;
        ApiServerException r103 = (ApiServerException) r100;
        if (TextUtils.isEmpty(r103.getErrorMsg()) == true) goto L16;
        r101.put("error_code", Integer.valueOf(r103.getErrorCode()));
        String r104 = r103.getErrorMsg();
        if (r104 != null) goto L14;
        r104 = "";
    L14:
        r101.put("error_msg", r104);
        return;
    L16:
        if ((r100 instanceof ApiException) == false) goto L21;
        r101.put("error_code", Integer.valueOf(((ApiException) r100).getErrorCode()));
        String r105 = r100.getMessage();
        if (r105 == null) goto L29;
        r101.put("error_msg", r105);
        return;
    L29:
        return;
    L21:
        if ((r100 instanceof Exception) == false) goto L25;
        r101.put("error_code", -1);
        String r106 = r100.getMessage();
        if (r106 == null) goto L31;
        r101.put("error_msg", r106);
        return;
    L31:
        return;
    L25:
        r101.put("error_code", -1);
        r101.put("error_msg", r100.toString());
    }

    @JvmStatic
    public static final void Y(String r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "targetId");
        LinkedHashMap r102 = new LinkedHashMap();
        r102.put("target_user_id", r100);
        r102.put("duration", Long.valueOf(r101));
        t0("permit_audience_success", r102);
    }

    @JvmStatic
    public static final void a0(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, WikiFolderPushPlugin.OPT);
        Intrinsics.checkNotNullParameter(r101, "traceStr");
        LinkedHashMap r102 = new LinkedHashMap();
        r102.put(WikiFolderPushPlugin.OPT, r100);
        r102.put("trace", r101);
        v0("other_thread_invocation", r102);
    }

    @JvmStatic
    public static final void b(long r100, int r101) {
        LinkedHashMap r102 = new LinkedHashMap();
        r102.put("msg_id", Long.valueOf(r100));
        r102.put("reply_type", Integer.valueOf(r101));
        t0("anchor_receive_reply_msg", r102);
    }

    @JvmStatic
    public static final void c(String r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "fromUserId");
        LinkedHashMap r102 = new LinkedHashMap();
        r102.put("msg_id", Long.valueOf(r101));
        r102.put("from_user_id", r100);
        t0("anchor_receive_auto_join_msg", r102);
    }

    @JvmStatic
    public static final void e0(tf0.i r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "dataHolder");
        HashMap r102 = new HashMap();
        a(r102);
        if (r101 <= 0) goto L6;
        long r103 = System.currentTimeMillis() - r101;
        r102.put("duration", Long.valueOf(r103));
        com.bytedance.android.live.liveinteract.api.utils.g.m("rtc_turn_off_success", r102, r100, r103);
        return;
    L6:
        com.bytedance.android.live.liveinteract.api.utils.g.n("rtc_turn_off_success", r102, r100, false);
    }

    @JvmStatic
    public static final void f(long r100, String r101) {
        LinkedHashMap r102 = new LinkedHashMap();
        r102.put("duration", Long.valueOf(r100));
        if (r101 == null) goto L5;
        r102.put("req_from", r101);
    L5:
        t0("cancel_apply_success", r102);
    }

    public static void i(String r100, Exception r101) {
        Intrinsics.checkNotNullParameter(r100, "mode");
        Intrinsics.checkNotNullParameter(r101, "e");
        LinkedHashMap r102 = new LinkedHashMap();
        r102.put("mode", r100);
        r102.put(com.bytedance.android.ec.core.event.a.KEY_EXCEPTION, r101.toString());
        t0("digit_avatar_video_show_mode_switch_fail", r102);
    }

    public static void i0(tf0.i r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "dataHolder");
        HashMap r102 = new HashMap();
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        r102.put("reason", r101);
        u0("rtc_mute_local_video", r102, r100);
    }

    @JvmStatic
    public static final void j(Throwable r100, boolean r101) {
        LinkedHashMap r102 = new LinkedHashMap();
        X(r100, r102);
        if (r101 == false) goto L5;
        v0("fetch_interact_emoji_list_failed", r102);
        return;
    L5:
        v0("fetch_emoji_list_failed", r102);
    }

    @JvmStatic
    public static final void l(long r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "reqFrom");
        LinkedHashMap r102 = new LinkedHashMap();
        r102.put("duration", Long.valueOf(r100));
        r102.put("req_from", r101);
        t0("finish_link_mic_success", r102);
    }

    @JvmStatic
    public static final void n(long r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "fromUserId");
        LinkedHashMap r102 = new LinkedHashMap();
        r102.put("msg_id", Long.valueOf(r100));
        r102.put("from_user_id", r101);
        t0("guest_receive_invite_msg", r102);
    }

    @JvmStatic
    public static final void o(long r100, int r101) {
        LinkedHashMap r102 = new LinkedHashMap();
        r102.put("msg_id", Long.valueOf(r100));
        r102.put("control_type", Integer.valueOf(r101));
        t0("guest_receive_kickout_msg", r102);
    }

    @JvmStatic
    public static final void p(long r100, String r101) {
        LinkedHashMap r102 = new LinkedHashMap();
        r102.put("msg_id", Long.valueOf(r100));
        if (r101 != null) goto L5;
        String r103 = "null";
    L6:
        r102.put("rtc_ext_info", r103);
        if (r101 != null) goto L9;
    L12:
        boolean r104 = true;
    L13:
        if (r104 == false) goto L16;
        t0("guest_receive_permit_msg_error", r102);
        return;
    L16:
        t0("guest_receive_permit_msg", r102);
        return;
    L9:
        if (r101.length() == 0) goto L12;
        r104 = false;
        goto L13
    L5:
        r103 = r101;
        goto L6
    }

    @JvmStatic
    public static final void p0(String r100, tf0.i r101) {
        Intrinsics.checkNotNullParameter(r100, "linkmicId");
        Intrinsics.checkNotNullParameter(r101, "dataHolder");
        HashMap r102 = new HashMap();
        r102.put("guest_linkmic_id", r100);
        a(r102);
        com.bytedance.android.live.liveinteract.api.utils.g.n("rtc_user_join", r102, r101, false);
    }

    @JvmStatic
    public static final void q0(String r100, tf0.i r101) {
        Intrinsics.checkNotNullParameter(r100, "linkmicId");
        Intrinsics.checkNotNullParameter(r101, "dataHolder");
        HashMap r102 = new HashMap();
        r102.put("guest_linkmic_id", r100);
        a(r102);
        com.bytedance.android.live.liveinteract.api.utils.g.o("rtc_user_leave", r102, r101);
    }

    @JvmStatic
    public static final void r0(Throwable r100, boolean r101) {
        LinkedHashMap r102 = new LinkedHashMap();
        X(r100, r102);
        if (r101 == false) goto L5;
        v0("send_interact_emoji_failed", r102);
        return;
    L5:
        v0("send_emoji_failed", r102);
    }

    @JvmStatic
    public static final void s0(long r100, com.bytedance.android.live.liveinteract.videotalk.emoji.model.j r101) {
        if (r101 != null) goto L4;
        return;
    L4:
        LinkedHashMap r102 = new LinkedHashMap();
        r102.put("msg_id", Long.valueOf(r100));
        r102.put("emoji_id", Long.valueOf(r101.getEmojiId()));
        r102.put("is_random_emoji", Boolean.valueOf(r101.isRandomEmoji()));
        if (r101.isInteractEmoji() == false) goto L7;
        v0("send_interact_emoji_success", r102);
        return;
    L7:
        v0("send_emoji_success", r102);
    }

    public static void t0(String r100, Map r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "extra");
        a(r101);
        com.bytedance.android.live.liveinteract.api.utils.g.n(r100, r101, tc0.c.h(), false);
    }

    @JvmStatic
    public static final void u(Throwable r100, long r101) {
        LinkedHashMap r102 = new LinkedHashMap();
        X(r100, r102);
        r102.put("duration", Long.valueOf(r101));
        t0("join_channel_failed", r102);
    }

    @JvmStatic
    public static final void v0(String r100, Map<String, Object> r101) {
        a(r101);
        tc0.c r102 = tc0.c.h();
        String r103 = com.bytedance.android.live.liveinteract.api.utils.g.f71512a;
        r101.put("event", r100);
        r101.put("channel_id", Long.valueOf(r102.getChannelId()));
        r101.put("interact_id", r102.f545349f);
        com.bytedance.android.livesdk.user.e r104 = ((IMiddlewareUserService) jc1.k.f(IMiddlewareUserService.class)).user();
        Room r105 = com.bytedance.android.live.liveinteract.api.utils.m.i().getCurrentRoom();
        if (r105 == null) goto L6;
        if (r104 == null) goto L6;
        r101.put("room_id", r105.getIdStr());
        r101.put("anchor_id", r105.getOwnerUserIdString());
    L6:
        LiveSlardarMonitor.monitorStatus("ttlive_interact_other_event_api_all", 0, r101);
        com.bytedance.android.livesdk.log.b0.o().j("ttlive_link", r101);
    }

    @JvmStatic
    public static final void x(boolean r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "singerId");
        LinkedHashMap r102 = new LinkedHashMap();
        r102.put("singerId", r101);
        if (r100 == false) goto L5;
        t0("ktv_stop_capture_on_start", r102);
        return;
    L5:
        t0("ktv_stop_capture_on_start_failed", r102);
    }

    @JvmStatic
    public static final void y0(Throwable r100, long r101) {
        LinkedHashMap r102 = new LinkedHashMap();
        r102.put("duration", Long.valueOf(r101));
        X(r100, r102);
        t0("start_link_mic_failed", r102);
    }

    @JvmStatic
    public static final void z(long r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "reqFrom");
        LinkedHashMap r102 = new LinkedHashMap();
        r102.put("duration", Long.valueOf(r100));
        r102.put("req_from", r101);
        t0("leave_channel_success", r102);
    }

    public static void D(String r100, boolean r101, Throwable r102) {
        Intrinsics.checkNotNullParameter(r100, "toUid");
        LinkedHashMap r103 = new LinkedHashMap();
        r103.put("toUid", r100.toString());
        r103.put("isEnlarge", String.valueOf(r101));
        if (r102 == null) goto L5;
        X(r102, r103);
        t0("c_position_invite_error", r103);
        return;
    L5:
        t0("c_position_invite_success", r103);
    }

    public static void E(String r100, boolean r101, Throwable r102) {
        LinkedHashMap r103 = new LinkedHashMap();
        r103.put("toUid", String.valueOf(r100));
        r103.put("agree", String.valueOf(r101));
        if (r102 == null) goto L5;
        X(r102, r103);
        t0("c_position_reply_error", r103);
        return;
    L5:
        t0("c_position_reply_success", r103);
    }

    @JvmStatic
    public static final void E0(String r100, Throwable r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "targetId");
        Intrinsics.checkNotNullParameter(r102, "reason");
        LinkedHashMap r103 = new LinkedHashMap();
        r103.put("target_user_id", r100);
        r103.put("reason", r102);
        X(r101, r103);
        t0("unsilence_audience_failed", r103);
    }

    @JvmStatic
    public static final void F(Throwable r100, long r101, String r102) {
        Intrinsics.checkNotNullParameter(r102, "anchorId");
        LinkedHashMap r103 = new LinkedHashMap();
        r103.put("room_id", Long.valueOf(r101));
        r103.put("anchor_id", r102);
        X(r100, r103);
        t0("check_apply_failed", r103);
    }

    public static void F0(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "serverState");
        Intrinsics.checkNotNullParameter(r101, "uiState");
        Intrinsics.checkNotNullParameter(r102, "switchInfo");
        LinkedHashMap r103 = new LinkedHashMap();
        r103.put("current_server_state", r100);
        r103.put("current_ui_state", r101);
        r103.put("switch_info", r102);
        t0("video_talk_layout_switch_error", r103);
    }

    @JvmStatic
    public static final void H(Throwable r100, long r101, String r102) {
        Intrinsics.checkNotNullParameter(r102, "anchorId");
        LinkedHashMap r103 = new LinkedHashMap();
        r103.put("room_id", Long.valueOf(r101));
        r103.put("anchor_id", r102);
        X(r100, r103);
        t0("fetch_list_failed", r103);
    }

    @JvmStatic
    public static final void Q(long r100, boolean r101, boolean r102) {
        LinkedHashMap r103 = new LinkedHashMap();
        a(r103);
        r103.put("is_attach", Boolean.valueOf(r101));
        r103.put("is_panel_fetch", Boolean.valueOf(r102));
        r103.put("list_size", Long.valueOf(r100));
        r103.put(ReportCardMonitorPlugin.EVENT_NAME, "waiting_list_request");
        com.bytedance.android.livesdk.log.b0.o().j("ttlive_link", r103);
    }

    @JvmStatic
    public static final void Z(String r100, Throwable r101, long r102) {
        Intrinsics.checkNotNullParameter(r100, "targetId");
        LinkedHashMap r103 = new LinkedHashMap();
        r103.put("target_user_id", r100);
        r103.put("duration", Long.valueOf(r102));
        X(r101, r103);
        t0("permit_audience_failed", r103);
    }

    @JvmStatic
    public static final void c0(String r100, String r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "targetId");
        LinkedHashMap r103 = new LinkedHashMap();
        r103.put("target_user_id", r100);
        if (r101 == null) goto L5;
        r103.put("list_data", r101);
    L5:
        if (r102 == false) goto L7;
        String r104 = "resume_last_silence_success_but_unSilence";
    L8:
        t0(r104, r103);
        return;
    L7:
        r104 = "resume_last_silence_success";
        goto L8
    }

    @JvmStatic
    public static final void d0(long r100, String r101, tf0.i r102) {
        Intrinsics.checkNotNullParameter(r102, "dataHolder");
        HashMap r103 = new HashMap();
        r103.put("error_code", Long.valueOf(r100));
        if (r101 == null) goto L5;
        r103.put("error_msg", r101);
    L5:
        a(r103);
        com.bytedance.android.live.liveinteract.api.utils.g.n("rtc_turn_off_failed", r103, r102, true);
    }

    @JvmStatic
    public static final void e(Throwable r100, long r101, String r102) {
        LinkedHashMap r103 = new LinkedHashMap();
        r103.put("duration", Long.valueOf(r101));
        if (r102 == null) goto L5;
        r103.put("req_from", r102);
    L5:
        X(r100, r103);
        t0("cancel_apply_failed", r103);
    }

    @JvmStatic
    public static final void f0(long r100, String r101, tf0.i r102) {
        Intrinsics.checkNotNullParameter(r102, "dataHolder");
        HashMap r103 = new HashMap();
        r103.put("error_code", Long.valueOf(r100));
        if (r101 == null) goto L5;
        r103.put("error_msg", r101);
    L5:
        a(r103);
        com.bytedance.android.live.liveinteract.api.utils.g.n("rtc_on_error", r103, r102, true);
    }

    @JvmStatic
    public static final void g0(String r100, tf0.i r101, long r102) {
        Intrinsics.checkNotNullParameter(r100, "linkmicId");
        Intrinsics.checkNotNullParameter(r101, "dataHolder");
        HashMap r103 = new HashMap();
        r103.put("guest_linkmic_id", r100);
        if (r102 <= 0) goto L5;
        com.bytedance.android.live.liveinteract.api.utils.g.m("rtc_first_audio_frame", r103, r101, System.currentTimeMillis() - r102);
        return;
    L5:
        com.bytedance.android.live.liveinteract.api.utils.g.n("rtc_first_audio_frame", r103, r101, false);
    }

    public static void h(boolean r100, boolean r101, String r102) {
        Intrinsics.checkNotNullParameter(r102, "extraInfo");
        LinkedHashMap r103 = new LinkedHashMap();
        r103.put("support", Boolean.valueOf(r100));
        r103.put(IPerformanceManager.Params.is_anchor, Boolean.valueOf(r101));
        r103.put("extra_info", r102);
        t0("digit_avatar_support_video_avatar", r103);
    }

    @JvmStatic
    public static final void k(Throwable r100, long r101, String r102) {
        Intrinsics.checkNotNullParameter(r102, "reqFrom");
        LinkedHashMap r103 = new LinkedHashMap();
        X(r100, r103);
        r103.put("duration", Long.valueOf(r101));
        r103.put("req_from", r102);
        t0("finish_link_mic_failed", r103);
    }

    @JvmStatic
    public static final void k0(String r100, tf0.i r101, Boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "linkmicId");
        Intrinsics.checkNotNullParameter(r101, "dataHolder");
        HashMap r103 = new HashMap();
        r103.put("guest_linkmic_id", r100);
        if (r102 == null) goto L6;
        String r104 = String.valueOf(r102.booleanValue());
        if (r104 == null) goto L6;
    L7:
        r103.put(ITTVideoEngineEventSource.KEY_MUTE, r104);
        a(r103);
        com.bytedance.android.live.liveinteract.api.utils.g.n("rtc_remote_mute_audio", r103, r101, true);
        return;
    L6:
        r104 = "";
        goto L7
    }

    @JvmStatic
    public static final void l0(String r100, tf0.i r101, Boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "linkmicId");
        Intrinsics.checkNotNullParameter(r101, "dataHolder");
        HashMap r103 = new HashMap();
        r103.put("guest_linkmic_id", r100);
        if (r102 == null) goto L6;
        String r104 = String.valueOf(r102.booleanValue());
        if (r104 == null) goto L6;
    L7:
        r103.put(ITTVideoEngineEventSource.KEY_MUTE, r104);
        a(r103);
        com.bytedance.android.live.liveinteract.api.utils.g.n("rtc_remote_mute_video", r103, r101, true);
        return;
    L6:
        r104 = "";
        goto L7
    }

    @JvmStatic
    public static final void n0(long r100, String r101, tf0.i r102) {
        Intrinsics.checkNotNullParameter(r102, "dataHolder");
        HashMap r103 = new HashMap();
        r103.put("error_code", Long.valueOf(r100));
        if (r101 == null) goto L5;
        r103.put("error_msg", r101);
    L5:
        a(r103);
        com.bytedance.android.live.liveinteract.api.utils.g.n("rtc_turn_on_failed", r103, r102, true);
    }

    @JvmStatic
    public static final void o0(tf0.i r100, long r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "dataHolder");
        HashMap r103 = new HashMap();
        r103.put(LocationMonitorConst.IS_BACKGROUND, Boolean.valueOf(!r102));
        a(r103);
        if (r101 <= 0) goto L6;
        long r104 = System.currentTimeMillis() - r101;
        r103.put("duration", Long.valueOf(r104));
        com.bytedance.android.live.liveinteract.api.utils.g.m("rtc_turn_on_success", r103, r100, r104);
        return;
    L6:
        com.bytedance.android.live.liveinteract.api.utils.g.n("rtc_turn_on_success", r103, r100, false);
    }

    @JvmStatic
    public static final void q(String r100, int r101, long r102) {
        Intrinsics.checkNotNullParameter(r100, "invitorUserId");
        LinkedHashMap r103 = new LinkedHashMap();
        r103.put("invitor_user_id", r100);
        if (r101 != ReplyType.Agree.ordinal()) goto L6;
        String r104 = "agree";
    L9:
        r103.put("reply_type", r104);
        r103.put("duration", Long.valueOf(r102));
        t0("guest_reply_success", r103);
        return;
    L6:
        if (r101 != ReplyType.Reject.ordinal()) goto L8;
        r104 = "reject";
        goto L9
    L8:
        r104 = "none";
        goto L9
    }

    @JvmStatic
    public static final void s(String r100, long r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "targetId");
        LinkedHashMap r103 = new LinkedHashMap();
        r103.put("target_user_id", r100);
        r103.put("duration", Long.valueOf(r101));
        if (r102 == null) goto L5;
        r103.put("request_params", r102);
    L5:
        t0("invite_audience_success", r103);
    }

    public static void u0(String r100, Map r101, tf0.i r102) {
        a(r101);
        com.bytedance.android.live.liveinteract.api.utils.g.n(r100, r101, r102, true);
    }

    @JvmStatic
    public static final void x0(String r100, Throwable r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "targetId");
        Intrinsics.checkNotNullParameter(r102, "reason");
        LinkedHashMap r103 = new LinkedHashMap();
        r103.put("target_user_id", r100);
        r103.put("reason", r102);
        X(r101, r103);
        t0("silence_audience_failed", r103);
    }

    @JvmStatic
    public static final void A0(int r100, int r101, Throwable r102, Integer r103) {
        LinkedHashMap r104 = new LinkedHashMap();
        X(r102, r104);
        r104.put("from_scene", Integer.valueOf(r100));
        r104.put("to_scene", Integer.valueOf(r101));
        if (r103 == null) goto L5;
        r104.put("to_play_mode", Integer.valueOf(r103.intValue()));
    L5:
        t0("switch_scene_failed", r104);
    }

    @JvmStatic
    public static final void B0(int r100, int r101, Integer r102, List<Integer> r103) {
        LinkedHashMap r104 = new LinkedHashMap();
        r104.put("from_scene", Integer.valueOf(r100));
        r104.put("to_scene", Integer.valueOf(r101));
        if (r102 == null) goto L5;
        r104.put("to_play_mode", Integer.valueOf(r102.intValue()));
    L5:
        if (r103 == null) goto L7;
        r104.put("new_play_modes", r103.toString());
    L7:
        t0("switch_scene_success", r104);
    }

    @JvmStatic
    public static final void D0(String r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "targetId");
        Intrinsics.checkNotNullParameter(r101, "reason");
        LinkedHashMap r104 = new LinkedHashMap();
        r104.put("target_user_id", r100.toString());
        r104.put("reason", r101);
        if (r102 == null) goto L5;
        r104.put("list_data", r102);
    L5:
        if (r103 == null) goto L7;
        r104.put("list_data_link_room_fight", r103);
    L7:
        t0("unsilence_audience_success", r104);
    }

    @JvmStatic
    public static final void N(boolean r100, long r101, long r102, Throwable r103) {
        LinkedHashMap r104 = new LinkedHashMap();
        r104.put("success", Boolean.valueOf(r100));
        r104.put("to_position", Long.valueOf(r101));
        r104.put("duration", Long.valueOf(r102));
        if (r103 == null) goto L5;
        X(r103, r104);
    L5:
        t0("update_linker_position", r104);
    }

    @JvmStatic
    public static final void V(Long r100, String r101, String r102, Integer r103) {
        Intrinsics.checkNotNullParameter(r101, "userId");
        LinkedHashMap r104 = new LinkedHashMap();
        r104.put(ReportCardMonitorPlugin.EVENT_NAME, "linker_update_msg");
        r104.put("msg_id", String.valueOf(r100));
        r104.put("target_user_id", r101);
        if (r102 == null) goto L5;
        r104.put("msg_content", r102);
    L5:
        if (r103 == null) goto L7;
        r104.put("list_size", Integer.valueOf(r103.intValue()));
    L7:
        a(r104);
        com.bytedance.android.livesdk.log.b0.o().j("ttlive_link", r104);
    }

    @JvmStatic
    public static final void h0(String r100, tf0.i r101, long r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "linkmicId");
        Intrinsics.checkNotNullParameter(r101, "dataHolder");
        Intrinsics.checkNotNullParameter(r103, "viewInfo");
        HashMap r104 = new HashMap();
        r104.put("guest_linkmic_id", r100);
        r104.put("viewInfo", r103);
        a(r104);
        if (r102 <= 0) goto L5;
        com.bytedance.android.live.liveinteract.api.utils.g.m("rtc_first_frame", r104, r101, System.currentTimeMillis() - r102);
        return;
    L5:
        com.bytedance.android.live.liveinteract.api.utils.g.n("rtc_first_frame", r104, r101, false);
    }

    @JvmStatic
    public static final void r(String r100, int r101, Throwable r102, long r103) {
        Intrinsics.checkNotNullParameter(r100, "invitorUserId");
        LinkedHashMap r104 = new LinkedHashMap();
        r104.put("invitor_user_id", r100);
        if (r101 != ReplyType.Agree.ordinal()) goto L6;
        String r105 = "agree";
    L9:
        r104.put("reply_type", r105);
        r104.put("duration", Long.valueOf(r103));
        X(r102, r104);
        t0("guest_reply_failed", r104);
        return;
    L6:
        if (r101 != ReplyType.Reject.ordinal()) goto L8;
        r105 = "reject";
        goto L9
    L8:
        r105 = "none";
        goto L9
    }

    @JvmStatic
    public static final void t(String r100, Throwable r101, long r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "targetId");
        LinkedHashMap r104 = new LinkedHashMap();
        r104.put("target_user_id", r100);
        r104.put("duration", Long.valueOf(r102));
        if (r103 == null) goto L5;
        r104.put("request_params", r103);
    L5:
        X(r101, r104);
        t0("invite_audience_failed", r104);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmStatic
    public static final void v(long r100, String r101, Long r102, String r103) {
        LinkedHashMap r104 = new LinkedHashMap();
        r104.put("duration", Long.valueOf(r100));
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        r104.put("token", r101);
        if (r102 == null) goto L8;
        long r105 = r102.longValue();
    L9:
        r104.put("VERSION", Long.valueOf(r105));
        if (r103 == null) goto L12;
        r104.put("list_data", r103);
    L12:
        t0("join_channel_success", r104);
        LinkedHashMap r106 = new LinkedHashMap();
        r106.put("interact_emoji_enable", Boolean.valueOf(!((Boolean) vm2.d.f556016y.getValue(null, vm2.d.f555776a[22])).booleanValue()));
        com.bytedance.tools.kcp.spongepreference.runtime.a r107 = com.bytedance.android.livesdk.sharedpref.d.f158346n;
        KProperty<?>[] r108 = com.bytedance.android.livesdk.sharedpref.d.f158327a;
        r106.put("video_talk_support", Boolean.valueOf(((Boolean) r107.getValue(null, r108[12])).booleanValue()));
        r106.put("audio_talk_support", Boolean.valueOf(((Boolean) com.bytedance.android.livesdk.sharedpref.d.f158347o.getValue(null, r108[13])).booleanValue()));
        v0("update_dynamic_emoji_switch", r106);
        return;
    L8:
        r105 = -1;
        goto L9
    }

    @JvmStatic
    public static final void w0(String r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "targetId");
        Intrinsics.checkNotNullParameter(r101, "reason");
        LinkedHashMap r104 = new LinkedHashMap();
        r104.put("target_user_id", r100);
        r104.put("reason", r101);
        if (r102 == null) goto L5;
        r104.put("list_data", r102);
    L5:
        if (r103 == null) goto L7;
        r104.put("list_data_link_room_fight", r103);
    L7:
        t0("silence_audience_success", r104);
    }

    @JvmStatic
    public static final void y(Throwable r100, long r101, String r102, Boolean r103) {
        Intrinsics.checkNotNullParameter(r102, "reqFrom");
        LinkedHashMap r104 = new LinkedHashMap();
        X(r100, r104);
        r104.put("duration", Long.valueOf(r101));
        r104.put("req_from", r102);
        if (Intrinsics.areEqual(r103, Boolean.TRUE) == false) goto L5;
        r104.put("is_rtc_error", r103);
    L5:
        t0("leave_channel_failed", r104);
    }

    public static void S(Long r100, String r101, Integer r102, boolean r103, String r104) {
        Intrinsics.checkNotNullParameter(r104, "subffix");
        LinkedHashMap r105 = new LinkedHashMap();
        if (r103 == false) goto L5;
        StringBuilder r106 = new StringBuilder("timer_push_msg");
    L6:
        r106.append(r104);
        r105.put(ReportCardMonitorPlugin.EVENT_NAME, r106.toString());
        r105.put("msg_id", String.valueOf(r100));
        if (r101 != null) goto L9;
        r101 = "null";
    L9:
        r105.put("msg_content", r101);
        Object r107 = r102;
        if (r102 != null) goto L12;
        r107 = "0";
    L12:
        r105.put("list_size", r107);
        a(r105);
        com.bytedance.android.livesdk.log.b0.o().j("ttlive_link", r105);
        return;
    L5:
        r106 = new StringBuilder("linked_list_change_msg");
        goto L6
    }

    @JvmStatic
    public static final void T(Long r100, String r101, String r102, String r103, Integer r104, boolean r105) {
        Intrinsics.checkNotNullParameter(r101, "userId");
        LinkedHashMap r106 = new LinkedHashMap();
        r106.put("msg_id", String.valueOf(r100));
        r106.put("target_user_id", r101);
        if (r102 == null) goto L5;
        r106.put("msg_content", r102);
    L5:
        if (r104 == null) goto L7;
        r106.put("list_size", Integer.valueOf(r104.intValue()));
    L7:
        if (r103 == null) goto L11;
        r106.put("error_msg", r103);
        t0("linker_enter_msg_error", r106);
        return;
    L11:
        if (r105 == false) goto L13;
        t0("linker_enter_msg", r106);
        return;
    L13:
        r106.put(ReportCardMonitorPlugin.EVENT_NAME, "linker_enter_msg");
        a(r106);
        com.bytedance.android.livesdk.log.b0.o().j("ttlive_link", r106);
    }

    public static void d(boolean r100, String r101, long r102, long r103, long r104, long r110) {
        Intrinsics.checkNotNullParameter(r101, "refreshInfo");
        LinkedHashMap r105 = new LinkedHashMap();
        r105.put("refresh_info", r101);
        r105.put("msg_elapse", Long.valueOf(r102));
        r105.put("request_elapse", Long.valueOf(r103));
        r105.put("mute_elapse", Long.valueOf(r104));
        r105.put("background_elapse", Long.valueOf(r110));
        if (r100 == false) goto L5;
        t0("auto_silence_when_mute", r105);
        return;
    L5:
        t0("auto_silence_when_mute_failed", r105);
    }

    public static void W(Long r100, String r101, String r102, String r103, Integer r104, boolean r105, int r106) {
        if ((r106 & 2) == 0) goto L6;
        r101 = "";
    L6:
        if ((r106 & 8) == 0) goto L9;
        r103 = null;
    L9:
        if ((r106 & 16) == 0) goto L12;
        r104 = null;
    L12:
        if ((r106 & 32) == 0) goto L14;
        r105 = false;
    L14:
        Intrinsics.checkNotNullParameter(r101, "userId");
        Intrinsics.checkNotNullParameter(r102, "errorMsg");
        LinkedHashMap r107 = new LinkedHashMap();
        r107.put("msg_id", String.valueOf(r100));
        r107.put("target_user_id", r101);
        if (r103 == null) goto L17;
        r107.put("msg_content", r103);
    L17:
        if (r104 == null) goto L19;
        r107.put("list_size", Integer.valueOf(r104.intValue()));
    L19:
        r107.put("error_msg", r102);
        if (r105 == false) goto L22;
        a(r107);
        r107.put(ReportCardMonitorPlugin.EVENT_NAME, "linker_update_msg_error");
        com.bytedance.android.livesdk.log.b0.o().f("ttlive_link", r107);
        return;
    L22:
        t0("linker_update_msg_error", r107);
    }

    public static void b0(boolean r100, int r101, long r102, long r103, long r104, long r110, boolean r111) {
        LinkedHashMap r105 = new LinkedHashMap();
        r105.put("list_status", Integer.valueOf(r101));
        r105.put("msg_elapse", Long.valueOf(r102));
        r105.put("request_elapse", Long.valueOf(r103));
        r105.put("mute_elapse", Long.valueOf(r104));
        r105.put("background_elapse", Long.valueOf(r110));
        if (r100 == false) goto L7;
        if (r111 == false) goto L6;
        t0("reset_mute_when_version_list_silence", r105);
        return;
    L6:
        t0("reset_mute_when_list_silence", r105);
        return;
    L7:
        t0("reset_mute_when_list_silence_failed", r105);
    }

    @JvmStatic
    public static final void m(long r100, int r101, int r102, int r103, int r104, int r105, String r106) {
        Intrinsics.checkNotNullParameter(r106, "fromSource");
        LinkedHashMap r107 = new LinkedHashMap();
        r107.put("silence_stats", Integer.valueOf(r101));
        r107.put("duration", Long.valueOf(r100));
        r107.put("link_type", Integer.valueOf(r102));
        r107.put("position", Integer.valueOf(r103));
        r107.put(ILiveRoomPlayFragmentConstant.LINK_MIC_APPLY_SOURCE, String.valueOf(r104));
        r107.put(ILiveRoomPlayFragmentConstant.LINK_MIC_APPLY_TYPE, Integer.valueOf(r105));
        r107.put("apply_from_source", r106);
        t0("guest_apply_success", r107);
    }

    public static void U(Long r100, String r101, String r102, String r103, Integer r104, boolean r105, String r106, int r110) {
        if ((r110 & 2) == 0) goto L6;
        r101 = "";
    L6:
        if ((r110 & 4) == 0) goto L9;
        r102 = null;
    L9:
        if ((r110 & 8) == 0) goto L12;
        r103 = null;
    L12:
        if ((r110 & 16) == 0) goto L15;
        r104 = null;
    L15:
        if ((r110 & 32) == 0) goto L18;
        r105 = false;
    L18:
        if ((r110 & 64) == 0) goto L20;
        r106 = "";
    L20:
        Intrinsics.checkNotNullParameter(r101, "userId");
        Intrinsics.checkNotNullParameter(r106, "subffix");
        LinkedHashMap r111 = new LinkedHashMap();
        if (r100 == null) goto L23;
        long r107 = r100.longValue();
    L24:
        r111.put("msg_id", Long.valueOf(r107));
        r111.put("target_user_id", r101);
        if (r102 == null) goto L27;
        r111.put("msg_content", r102);
    L27:
        if (r104 == null) goto L30;
        r111.put("list_size", Integer.valueOf(r104.intValue()));
    L30:
        if (r103 == null) goto L35;
        r111.put("error_msg", r103);
        if (r105 == false) goto L34;
        r111.put(ReportCardMonitorPlugin.EVENT_NAME, "linker_leave_msg" + r106);
        a(r111);
        com.bytedance.android.livesdk.log.b0.o().f("ttlive_link", r111);
        return;
    L34:
        t0("linker_leave_msg_error" + r106, r111);
        return;
    L35:
        r111.put(ReportCardMonitorPlugin.EVENT_NAME, "linker_leave_msg");
        a(r111);
        com.bytedance.android.livesdk.log.b0.o().j("ttlive_link", r111);
        return;
    L23:
        r107 = 0;
        goto L24
    }
}
