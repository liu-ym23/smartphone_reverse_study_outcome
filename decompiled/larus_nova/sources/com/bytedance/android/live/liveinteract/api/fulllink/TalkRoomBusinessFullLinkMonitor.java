package com.bytedance.android.live.liveinteract.api.fulllink;

import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.chatroom.model.LinkApplyType;
import com.bytedance.android.live.liveinteract.api.trace.MultiTraceData$TraceBusiness;
import com.bytedance.android.live.liveinteract.api.trace.MultiTraceData$TraceEvent;
import com.bytedance.android.live.liveinteract.multianchor.model.b;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.h;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.j;
import com.bytedance.android.live.liveinteract.plantform.permission.model.BaseCheckException;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.livesdk.chatroom.model.interact.e1;
import com.bytedance.android.livesdk.chatroom.model.interact.v1;
import com.bytedance.android.livesdk.link.model.bridge.h1;
import com.bytedance.android.livesdk.link.model.bridge.z0;
import com.bytedance.android.livesdk.link.model.u5;
import com.bytedance.android.livesdk.message.linker.g;
import com.bytedance.android.livesdk.message.linker.k;
import com.bytedance.android.livesdk.message.linker.l;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.minigame.SeiMessageConst;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import mz0.e;
import nd0.c;
import nd0.f;
import org.json.JSONObject;
import r27.a;
import yh6.d;

/* JADX INFO: loaded from: classes46.dex */
public final class TalkRoomBusinessFullLinkMonitor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final TalkRoomBusinessFullLinkMonitor f71456a = null;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/live/liveinteract/api/fulllink/TalkRoomBusinessFullLinkMonitor$WrdsStatusType;", "", "", "code", "I", "getCode", "()I", "", "msg", "Ljava/lang/String;", "getMsg", "()Ljava/lang/String;", "Success", "BackLog", "Timeout", "Exception", "liveinteract-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum WrdsStatusType extends Enum<WrdsStatusType> {
        public static final WrdsStatusType BackLog = null;
        public static final WrdsStatusType Exception = null;
        public static final WrdsStatusType Success = null;
        public static final WrdsStatusType Timeout = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ WrdsStatusType[] f71457a = null;
        private final int code;
        private final String msg;

        static {
            WrdsStatusType r100 = new WrdsStatusType("Success", 0, 0, "check wrds success");
            Success = r100;
            WrdsStatusType r101 = new WrdsStatusType("BackLog", 1, 1, "message backlog");
            BackLog = r101;
            WrdsStatusType r102 = new WrdsStatusType("Timeout", 2, 2, "waiting timeout");
            Timeout = r102;
            WrdsStatusType r103 = new WrdsStatusType("Exception", 3, 3, "something exception");
            Exception = r103;
            f71457a = new WrdsStatusType[]{r100, r101, r102, r103};
        }

        public static WrdsStatusType valueOf(String r100) {
            return (WrdsStatusType) a.a(WrdsStatusType.class, r100);
        }

        public static WrdsStatusType[] values() {
            return (WrdsStatusType[]) f71457a.clone();
        }

        public final int getCode() {
            return this.code;
        }

        public final String getMsg() {
            return this.msg;
        }

        public WrdsStatusType(String r100, int r101, int r102, String r103) {
            super(r100, r101);
            this.code = r102;
            this.msg = r103;
        }
    }

    public TalkRoomBusinessFullLinkMonitor() {
    }

    static {
        f71456a = new TalkRoomBusinessFullLinkMonitor();
    }

    public static void V() {
        JSONObject r100 = new JSONObject();
        c.o(c.f518746a, LinkMonitorData.LinkPermissionCheckMonitorData, r100, 0, null, false, 28);
    }

    public static void h0() {
        JSONObject r100 = new JSONObject();
        r100.put("exception_msg", ExceptionsKt.stackTraceToString(new Exception()));
        c.o(c.f518746a, LinkMonitorData.RealOnCreateException, r100, 0, null, false, 28);
    }

    public static void R(boolean r100) {
        if (r100 == false) goto L4;
        int r101 = 1;
    L5:
        JSONObject r102 = new JSONObject();
        r102.put("show_notification", r100);
        c.o(c.f518746a, LinkMonitorData.LinkOnlineFloatWindowStatusBarNotification, r102, r101, null, false, 24);
        return;
    L4:
        r101 = 2;
        goto L5
    }

    public static void U(BaseCheckException r100) {
        Intrinsics.checkNotNullParameter(r100, com.bytedance.android.ec.core.event.a.KEY_EXCEPTION);
        JSONObject r101 = new JSONObject();
        switch(f.f518748a[r100.getOperateType().ordinal()]) {
            case 1: goto L13;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L8;
            case 7: goto L7;
            case 8: goto L6;
            default: goto L5;
        };
    L6:
        String r102 = "universal_anim_for_saas";
    L14:
        r101.put("operate_type", r102);
        int r103 = f.f518749b[r100.getCheckType().ordinal()];
        if (r103 != 1) goto L17;
        String r104 = "login_check";
    L30:
        r101.put("check_type", r104);
        c r105 = c.f518746a;
        Throwable r106 = r100.getCause();
        r105.getClass();
        Pair r107 = c.t(r106, r101);
        c.o(r105, LinkMonitorData.LinkPermissionCheckMonitorData, r101, ((Number) r107.getFirst()).intValue(), (String) r107.getSecond(), false, 16);
        return;
    L17:
        if (r103 != 2) goto L19;
        r104 = "android_permission_check";
        goto L30
    L19:
        if (r103 != 3) goto L21;
        r104 = "video_short_plugin_check";
        goto L30
    L21:
        if (r103 != 4) goto L23;
        r104 = "interact_plugin_check";
        goto L30
    L23:
        if (r103 == 5) goto L25;
        r104 = "unknown: " + r100.getCheckType();
        goto L30
    L25:
        r104 = "server_permission_check";
        goto L30
    L7:
        r102 = KtvSubElement.MIDI;
        goto L14
    L8:
        r102 = "pre_reply";
        goto L14
    L9:
        r102 = "join";
        goto L14
    L10:
        r102 = "resume";
        goto L14
    L11:
        r102 = "pre_apply";
        goto L14
    L12:
        r102 = "reply";
        goto L14
    L13:
        r102 = e1.REPLY_ACTION_APPLY;
        goto L14
    L5:
        throw new NoWhenBranchMatchedException();
    }

    public static void a0(Map r100) {
        Intrinsics.checkNotNullParameter(r100, "extraParams");
        JSONObject r101 = new JSONObject();
        Iterator r102 = r100.entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        Map.Entry r103 = (Map.Entry) r102.next();
        r101.put((String) r103.getKey(), r103.getValue());
        goto L4
    L6:
        c.o(c.f518746a, LinkMonitorData.BusinessPanelAction, r101, 0, null, false, 28);
    }

    public static void b0(HashMap r100) {
        Intrinsics.checkNotNullParameter(r100, "logMap");
        JSONObject r101 = new JSONObject();
        Iterator r102 = r100.entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        Map.Entry r103 = (Map.Entry) r102.next();
        r101.put((String) r103.getKey(), r103.getValue());
        goto L4
    L6:
        c.o(c.f518746a, LinkMonitorData.MultiLinkScopeError, r101, 0, null, true, 12);
    }

    public static void e(String r100) {
        Intrinsics.checkNotNullParameter(r100, "sei");
        JSONObject r101 = new JSONObject();
        r101.put("sei", r100);
        c.o(c.f518746a, LinkMonitorData.AudioSubtitleSeiErrorMonitorData, r101, 0, null, false, 28);
    }

    public static void g0(String r100) {
        Intrinsics.checkNotNullParameter(r100, "failReason");
        JSONObject r101 = new JSONObject();
        r101.put("success", 0);
        r101.put("reason", r100);
        c.o(c.f518746a, LinkMonitorData.AnchorPreCheckActionMonitorData, r101, 1, r100, false, 16);
    }

    public static long h(long r100) {
        if (r100 <= 0) goto L8;
        i97.a r101 = i97.a.f488802a;
        if (r100 < System.currentTimeMillis()) goto L7;
        return 0;
    L7:
        return System.currentTimeMillis() - r100;
    L8:
        return 0;
    }

    public static void i0(h1 r100) {
        Intrinsics.checkNotNullParameter(r100, "linkerMessage");
        JSONObject r101 = new JSONObject();
        Intrinsics.checkNotNullParameter(r100, "$this$messageId");
        r101.put("msg_id", r100.getMessageId3());
        r101.put("big_event_type", "switch_backup_stream");
        u5 r102 = r100.getAnchorStreamSwitchContent();
        if (r102 == null) goto L5;
        r101.put("is_use_backup_stream", r102.isUseBackUp());
    L5:
        c.o(c.f518746a, LinkMonitorData.ReceiveBigEventMsgMonitorData, r101, 0, null, false, 28);
    }

    public static void k(String r100) {
        Intrinsics.checkNotNullParameter(r100, "reason");
        JSONObject r101 = new JSONObject();
        r101.put("reason", r100);
        c.o(c.f518746a, LinkMonitorData.AvatarRecognitionFailMonitorData, r101, 0, null, false, 28);
    }

    public static void l0(b r100) {
        JSONObject r101 = new JSONObject();
        String r102 = null;
        if (r100 == null) goto L5;
        Long r103 = d.a(r100);
    L6:
        r101.put("msg_id", r103);
        if (r100 == null) goto L9;
        Intrinsics.checkNotNullParameter(r100, "$this$fromUserId");
        r102 = r100.get_fromUserId();
    L9:
        r101.put("from_user_id", r102);
        c.o(c.f518746a, LinkMonitorData.ReceiveInviteMsgMonitorData, r101, 0, null, false, 28);
        return;
    L5:
        r103 = null;
        goto L6
    }

    public static void m(List r100) {
        Intrinsics.checkNotNullParameter(r100, "modes");
        JSONObject r101 = new JSONObject();
        r101.put("modes", r100.toString());
        c.o(c.f518746a, LinkMonitorData.AvatarSupportedVideoShowModeMonitorData, r101, 0, null, false, 28);
    }

    public static void m0(long r100) {
        JSONObject r101 = new JSONObject();
        r101.put("msg_id", r100);
        r101.put("banner_type", "guest_kick_out");
        c.o(c.f518746a, LinkMonitorData.BannerMsgMonitorData, r101, 0, null, false, 28);
    }

    public static void n0(b r100) {
        JSONObject r101 = new JSONObject();
        if (r100 == null) goto L5;
        Long r102 = d.a(r100);
    L6:
        r101.put("msg_id", r102);
        c.o(c.f518746a, LinkMonitorData.ReceivePermitMsgMonitorData, r101, 0, null, false, 28);
        return;
    L5:
        r102 = null;
        goto L6
    }

    public static void o0(z0 r100) {
        JSONObject r101 = new JSONObject();
        if (r100 == null) goto L5;
        Intrinsics.checkNotNullParameter(r100, "$this$messageIdExt");
        long r102 = r100.getMessageId2();
    L6:
        r101.put("msg_id", r102);
        pd0.b r103 = pd0.b.f528640a;
        if (r100 == null) goto L9;
        int r104 = r100.getReplyType();
    L10:
        r101.put("reply_type", pd0.b.i(r104));
        if (r100 == null) goto L14;
        String r105 = r100.getReplyPrompts();
        if (r105 == null) goto L14;
    L15:
        r101.put("reply_prompts", r105);
        c.o(c.f518746a, LinkMonitorData.ReceiveReplyMsgMonitorData, r101, 0, null, false, 28);
        return;
    L14:
        r105 = "";
        goto L15
    L9:
        r104 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public static void p(String r100) {
        Intrinsics.checkNotNullParameter(r100, "kickOutUserIds");
        JSONObject r101 = new JSONObject();
        r101.put("kick_out_user_ids", r100);
        c.o(c.f518746a, LinkMonitorData.EnlargeCloseStartApiMonitorData, r101, 0, null, false, 28);
    }

    public static void p0(long r100) {
        JSONObject r101 = new JSONObject();
        r101.put("msg_id", r100);
        r101.put("banner_type", "guest_sys_kick_out");
        c.o(c.f518746a, LinkMonitorData.BannerMsgMonitorData, r101, 0, null, false, 28);
    }

    public static void r0(int r100) {
        JSONObject r101 = new JSONObject();
        r101.put("status_code", r100);
        e<?> r102 = mz0.d.b(LogCommon.PAGE_SOURCE_LOG);
        String r103 = "";
        if (r102 == null) goto L8;
        Map<String, String> r104 = ((com.bytedance.android.live.revenue.platform.log.impl.filterimpl.a) r102).getMap();
        if (r104 == null) goto L8;
        String r105 = r104.get("enter_from_merge");
        if (r105 == null) goto L8;
    L9:
        r101.put("enter_from_merge", r105);
        if (r102 == null) goto L17;
        Map<String, String> r106 = ((com.bytedance.android.live.revenue.platform.log.impl.filterimpl.a) r102).getMap();
        if (r106 == null) goto L17;
        String r107 = r106.get("enter_method");
        if (r107 == null) goto L17;
        r103 = r107;
    L17:
        r101.put("enter_method", r103);
        c.o(c.f518746a, LinkMonitorData.InnerDrawWRDSPreloadMonitorData, r101, r100, null, false, 24);
        return;
    L8:
        r105 = "";
        goto L9
    }

    public static void x(String r100) {
        Intrinsics.checkNotNullParameter(r100, "requestPage");
        JSONObject r101 = new JSONObject();
        r101.put("request_page", r100);
        c.o(c.f518746a, LinkMonitorData.FastMatchActionMonitorData, r101, 0, null, false, 28);
    }

    public static void x0(long r100) {
        JSONObject r101 = new JSONObject();
        r101.put("status", "open");
        r101.put("source_room_id", r100);
        c.o(c.f518746a, LinkMonitorData.LinkmicApplyFloatWindowData, r101, 0, null, false, 28);
    }

    public static void C(long r100, Throwable r101) {
        JSONObject r102 = new JSONObject();
        Y(LinkMonitorData.InviteListApiMonitorData, h(r100), r101, r102);
    }

    public static void D(long r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "logId");
        JSONObject r102 = new JSONObject();
        Z(LinkMonitorData.InviteListApiMonitorData, h(r100), r101, r102);
    }

    public static void E(long r100, Throwable r101) {
        JSONObject r102 = new JSONObject();
        Y(LinkMonitorData.WaitingListApiMonitorData, h(r100), r101, r102);
    }

    public static void F(long r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "logId");
        JSONObject r102 = new JSONObject();
        Z(LinkMonitorData.WaitingListApiMonitorData, h(r100), r101, r102);
    }

    public static void M(Throwable r100, long r101) {
        JSONObject r102 = new JSONObject();
        Y(LinkMonitorData.JoinChannelApiMonitorData, h(r101), r100, r102);
    }

    public static void N(ExtraResponse r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "response");
        JSONObject r102 = new JSONObject();
        Z(LinkMonitorData.JoinChannelApiMonitorData, h(r101), r100.logId, r102);
    }

    public static void Q(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "settingContent");
        Intrinsics.checkNotNullParameter(r101, "source");
        JSONObject r102 = new JSONObject();
        r102.put("setting_content", r100);
        r102.put("source", r101);
        c.o(c.f518746a, LinkMonitorData.LinkMicSettingUpdateMonitorData, r102, 0, null, false, 28);
    }

    public static void T(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, com.bytedance.android.ec.core.event.a.KEY_STATUS_MSG);
        JSONObject r102 = new JSONObject();
        r102.put("reason", r100);
        c.o(c.f518746a, LinkMonitorData.LinkOnlineFloatWindowStatusChanged, r102, r101, r100, false, 16);
    }

    public static void a(long r100, JSONObject r110) {
        Intrinsics.checkNotNullParameter(r110, "extra");
        r110.put("msg_id", r100);
        c.o(c.f518746a, LinkMonitorData.AnchorReceiveEnlargeGuestUiChangeMessage, r110, 0, null, false, 28);
        int r101 = rd0.a.f537202a;
        rd0.a.b(MultiTraceData$TraceBusiness.ChatRoom, MultiTraceData$TraceEvent.OpenEnlargeGuest, "receiveEnlargeGuestUIChangeMessage", 0, null, r110, 88);
    }

    public static void e0(boolean r100, boolean r101) {
        JSONObject r102 = new JSONObject();
        r102.put("is_paidlive", r100);
        r102.put("has_ticket", r101);
        c.o(c.f518746a, LinkMonitorData.PaidLiveApplyNoTicketMonitorData, r102, 0, null, false, 28);
    }

    public static void f(String r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "interactId");
        JSONObject r102 = new JSONObject();
        r102.put("interactId", r100);
        r102.put("duration", h(r101));
        c.o(c.f518746a, LinkMonitorData.AutoJoinChannelData, r102, 0, null, false, 28);
    }

    public static void g(String r100, String r110) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r110, "msg");
        JSONObject r101 = new JSONObject();
        r101.put("tag", r100);
        r101.put("msg", r110);
        c.o(c.f518746a, LinkMonitorData.AVSecurityMonitorData, r101, 0, null, false, 28);
    }

    public static void j(boolean r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r101, "extra");
        if (r100 == false) goto L5;
        String r102 = "anchor";
    L6:
        r101.put("role", r102);
        c.o(c.f518746a, LinkMonitorData.CommonWMUpdateLiveCoreAndRtcInfo, r101, 0, null, false, 28);
        return;
    L5:
        r102 = "guest";
        goto L6
    }

    public static void j0(long r100, k r110) {
        JSONObject r101 = new JSONObject();
        r101.put("msg_id", r100);
        if (r110 == null) goto L5;
        String r102 = l.a(r110);
    L6:
        r101.put("from_user_id", r102);
        int r103 = rd0.a.f537202a;
        rd0.a.b(MultiTraceData$TraceBusiness.ChatRoom, MultiTraceData$TraceEvent.OpenEnlargeGuest, "receiveEnlargeGuestInviteMessage", 0, null, r101, 88);
        c.o(c.f518746a, LinkMonitorData.ReceiveEnlargeInviteMsgMonitorData, r101, 0, null, false, 28);
        return;
    L5:
        r102 = null;
        goto L6
    }

    public static void k0(long r100, g r110) {
        Intrinsics.checkNotNullParameter(r110, "enlargeReplyContent");
        JSONObject r101 = new JSONObject();
        r101.put("msg_id", r100);
        pd0.b r102 = pd0.b.f528640a;
        r101.put("reply_type", pd0.b.i(r110.getReplyType()));
        r101.put("reply_prompts", r110.getReplyPrompts());
        c.o(c.f518746a, LinkMonitorData.ReceiveEnlargeReplyMsgMonitorData, r101, 0, null, false, 28);
    }

    public static void n(String r100, Exception r110) {
        Intrinsics.checkNotNullParameter(r100, "mode");
        Intrinsics.checkNotNullParameter(r110, "e");
        JSONObject r101 = new JSONObject();
        r101.put("mode", r100);
        r101.put(com.bytedance.android.ec.core.event.a.KEY_EXCEPTION, r110.toString());
        c.o(c.f518746a, LinkMonitorData.AvatarVideoShowModeSwitchFailMonitorData, r101, 0, null, false, 28);
    }

    public static void s0(long r100, int r101) {
        JSONObject r102 = new JSONObject();
        r102.put("duration", r100);
        c.o(c.f518746a, LinkMonitorData.ANCHOR_ZERO_LINK_DURATION_WHEN_CONNECTION_OVER, r102, r101, null, false, 24);
    }

    public static void v(String r100, boolean r101) {
        JSONObject r102 = new JSONObject();
        r102.put("target_user_id", r100);
        if (r101 == false) goto L5;
        String r103 = "accept";
    L6:
        r102.put("reply_type", r103);
        c.o(c.f518746a, LinkMonitorData.EnlargeReplyStartApiMonitorData, r102, 0, null, false, 28);
        return;
    L5:
        r103 = "reject";
        goto L6
    }

    public static void z(long r100, Throwable r101) {
        JSONObject r102 = new JSONObject();
        Y(LinkMonitorData.InteractListApiMonitorData, h(r100), r101, r102);
    }

    public static void A(long r100, String r101, Throwable r102) {
        Intrinsics.checkNotNullParameter(r101, "reqFrom");
        JSONObject r103 = new JSONObject();
        r103.put("req_from", r101);
        Y(LinkMonitorData.FinishApiMonitorData, h(r100), r102, r103);
    }

    public static void B(long r100, String r101, ExtraResponse r102) {
        Intrinsics.checkNotNullParameter(r101, "reqFrom");
        Intrinsics.checkNotNullParameter(r102, "response");
        JSONObject r103 = new JSONObject();
        r103.put("req_from", r101);
        Z(LinkMonitorData.FinishApiMonitorData, h(r100), r102.logId, r103);
    }

    public static void B0(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "targetLayoutConfig");
        Intrinsics.checkNotNullParameter(r102, "switchType");
        if (nd0.e.b() != true) goto L5;
    L8:
        JSONObject r103 = new JSONObject();
        r103.put("target_layout_config", r100);
        r103.put("origin_layout_config", r101);
        r103.put("switch_type", r102);
        c.o(c.f518746a, LinkMonitorData.CommonWindowSwitchUILayout, r103, 0, null, false, 28);
        return;
    L5:
        if (nd0.e.c() == true) goto L8;
        jy0.b.d("ttlive_link", "trySwitchLayout, targetLayoutConfig = " + r100 + ", originLayoutConfig = " + r101 + ", switchType = " + r102);
    }

    public static void D0(long r100, long r101, Throwable r102) {
        JSONObject r103 = new JSONObject();
        r103.put("target_position", r100);
        Y(LinkMonitorData.UpdatePositionApiMonitorData, h(r101), r102, r103);
    }

    public static void E0(long r100, long r101, String r102) {
        Intrinsics.checkNotNullParameter(r102, "logId");
        JSONObject r103 = new JSONObject();
        r103.put("target_position", r100);
        Z(LinkMonitorData.UpdatePositionApiMonitorData, h(r101), r102, r103);
    }

    public static void b(int r100, long r101, Throwable r102) {
        JSONObject r103 = new JSONObject();
        r103.put("action", r100);
        Y(LinkMonitorData.ApplyStashData, h(r101), r102, r103);
    }

    public static void c0(String r100, int r101, int r110) {
        Intrinsics.checkNotNullParameter(r100, "openSource");
        JSONObject r102 = new JSONObject();
        r102.put(ILiveRoomPlayFragmentConstant.EXTRA_OPEN_SOURCE, r100);
        pd0.b r103 = pd0.b.f528640a;
        r102.put("target_scene", pd0.b.e(r101));
        r102.put("target_ui_layout", pd0.b.f(r110));
        int r104 = rd0.a.f537202a;
        rd0.a.b(MultiTraceData$TraceBusiness.ChatRoom, MultiTraceData$TraceEvent.OpenChatRoom, "openAction", 0, null, r102, 88);
        c.o(c.f518746a, LinkMonitorData.OpenChatRoomActionMonitorData, r102, 0, null, false, 28);
    }

    public static void l(boolean r100, boolean r101, String r110) {
        Intrinsics.checkNotNullParameter(r110, "extraInfo");
        JSONObject r102 = new JSONObject();
        r102.put("support", r100);
        r102.put(IPerformanceManager.Params.is_anchor, r101);
        r102.put("extra_info", r110);
        c.o(c.f518746a, LinkMonitorData.AvatarSupportVideoAvatarMonitorData, r102, 0, null, false, 28);
    }

    public static void o(String r100, long r101, Throwable r102) {
        Intrinsics.checkNotNullParameter(r100, "kickOutUserIds");
        JSONObject r103 = new JSONObject();
        r103.put("kick_out_user_ids", r100);
        Y(LinkMonitorData.EnlargeCloseApiMonitorData, h(r101), r102, r103);
    }

    public static void q(String r100, long r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "kickOutUserIds");
        Intrinsics.checkNotNullParameter(r102, "logId");
        JSONObject r103 = new JSONObject();
        r103.put("kick_out_user_ids", r100);
        Z(LinkMonitorData.EnlargeCloseApiMonitorData, h(r101), r102, r103);
    }

    public static void q0(int r100, long r101, String r110) {
        Intrinsics.checkNotNullParameter(r110, ReportConstant.COMMON_ACTION_TYPE);
        JSONObject r102 = new JSONObject();
        r102.put("duration", r101);
        r102.put("status_code", r100);
        r102.put("action_type", r110);
        c.o(c.f518746a, LinkMonitorData.BackendSpendTimeMonitorData, r102, r100, null, false, 24);
    }

    public static void s(String r100, boolean r101, long r110) {
        Intrinsics.checkNotNullParameter(r100, "targetUserId");
        JSONObject r102 = new JSONObject();
        r102.put("target_user_id", r100);
        if (r101 == false) goto L5;
        String r103 = "enlarge";
    L6:
        r102.put("invite_type", r103);
        r102.put("operate_type", r110);
        c.o(c.f518746a, LinkMonitorData.EnlargeInviteStartApiMonitorData, r102, 0, null, false, 28);
        return;
    L5:
        r103 = "reduce";
        goto L6
    }

    public static void A0(h1 r100, long r101, long r110, WrdsStatusType r111) {
        Intrinsics.checkNotNullParameter(r100, "linkerMessage");
        Intrinsics.checkNotNullParameter(r111, "wrdsStatusType");
        if (nd0.e.b() == true) goto L7;
        if (nd0.e.c() == true) goto L7;
        return;
    L7:
        if (r111 == WrdsStatusType.Success) goto L11;
        JSONObject r102 = new JSONObject();
        r102.put("duration", h(r110));
        Intrinsics.checkNotNullParameter(r100, "$this$messageId");
        r102.put("msg_id", r100.getMessageId3());
        r102.put("wrds_version", r101);
        r102.put(SeiMessageConst.MSG_TYPE, r100.getType2());
        r102.put("from_source", "for_linker_msg");
        c.o(c.f518746a, LinkMonitorData.WRDSForMsgMonitorData, r102, r111.getCode(), r111.getMsg(), false, 16);
        return;
    }

    public static void C0(String r100, int r101, long r102, Throwable r103) {
        Intrinsics.checkNotNullParameter(r100, "toUserId");
        JSONObject r104 = new JSONObject();
        r104.put(com.bytedance.android.ec.core.event.a.KEY_TO_USER_ID, r100);
        pd0.b r105 = pd0.b.f528640a;
        r104.put("target_link_type", pd0.b.g(r101));
        Y(LinkMonitorData.UpdateLinkTypeApplyApiMonitorData, h(r102), r103, r104);
    }

    public static void K(String r100, String r101, Throwable r102, long r103) {
        Intrinsics.checkNotNullParameter(r100, "toUserId");
        Intrinsics.checkNotNullParameter(r101, "secToUserId");
        JSONObject r104 = new JSONObject();
        r104.put(com.bytedance.android.ec.core.event.a.KEY_TO_USER_ID, r100);
        r104.put("sec_to_user_id", r101);
        Y(LinkMonitorData.InviteApiMonitorData, h(r103), r102, r104);
    }

    public static void L(String r100, String r101, ExtraResponse r102, long r103) {
        Intrinsics.checkNotNullParameter(r100, "toUserId");
        Intrinsics.checkNotNullParameter(r101, "secToUserId");
        Intrinsics.checkNotNullParameter(r102, "response");
        JSONObject r104 = new JSONObject();
        r104.put(com.bytedance.android.ec.core.event.a.KEY_TO_USER_ID, r100);
        r104.put("sec_to_user_id", r101);
        Z(LinkMonitorData.InviteApiMonitorData, h(r103), r102.logId, r104);
    }

    public static void O(String r100, String r101, long r102, Throwable r103) {
        Intrinsics.checkNotNullParameter(r100, "userId");
        JSONObject r104 = new JSONObject();
        r104.put("user_id", r100);
        r104.put("sec_user_id", r101);
        Y(LinkMonitorData.KickOutApiMonitorData, h(r102), r103, r104);
    }

    public static void P(String r100, String r101, long r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "userId");
        Intrinsics.checkNotNullParameter(r103, "logId");
        JSONObject r104 = new JSONObject();
        r104.put("user_id", r100);
        r104.put("sec_user_id", r101);
        Z(LinkMonitorData.KickOutApiMonitorData, h(r102), r103, r104);
    }

    public static void S(int r100, String r101, boolean r110, Exception r111) {
        Intrinsics.checkNotNullParameter(r101, com.bytedance.android.ec.core.event.a.KEY_STATUS_MSG);
        JSONObject r102 = new JSONObject();
        r102.put("is_setting_open", r110);
        if (r111 == null) goto L5;
        r102.put("exception_msg", r111.getMessage());
    L5:
        c.o(c.f518746a, LinkMonitorData.LinkOnlineFloatWindowRTCBackUpEvent, r102, r100, r101, false, 16);
    }

    public static void W(long r100, int r101, long r102, Throwable r103) {
        JSONObject r104 = new JSONObject();
        r104.put("target_position", r100);
        pd0.b r105 = pd0.b.f528640a;
        r104.put("position_status", pd0.b.h(r101));
        Y(LinkMonitorData.LockPositionApiMonitorData, h(r102), r103, r104);
    }

    public static void X(long r100, int r101, long r102, String r103) {
        Intrinsics.checkNotNullParameter(r103, "logId");
        JSONObject r104 = new JSONObject();
        r104.put("target_position", r100);
        pd0.b r105 = pd0.b.f528640a;
        r104.put("position_status", pd0.b.h(r101));
        Z(LinkMonitorData.LockPositionApiMonitorData, h(r102), r103, r104);
    }

    public static void Y(LinkMonitorData r100, long r110, Throwable r111, JSONObject r112) {
        Intrinsics.checkNotNullParameter(r100, "linkMonitorData");
        Intrinsics.checkNotNullParameter(r112, "extra");
        c.r(c.f518746a, r100, null, r110, r111, r112, 34);
    }

    public static void Z(LinkMonitorData r100, long r110, String r111, JSONObject r112) {
        Intrinsics.checkNotNullParameter(r100, "linkMonitorData");
        Intrinsics.checkNotNullParameter(r111, "logId");
        Intrinsics.checkNotNullParameter(r112, "extra");
        c.s(c.f518746a, r100, null, r110, r111, r112, 98);
    }

    public static void c(int r100, long r101, ExtraResponse r102, String r103) {
        Intrinsics.checkNotNullParameter(r103, "logId");
        JSONObject r104 = new JSONObject();
        r104.put("action", r100);
        LinkMonitorData r105 = LinkMonitorData.ApplyStashData;
        long r106 = h(r101);
        if (r102 == null) goto L8;
        String r107 = r102.logId;
        if (r107 == null) goto L8;
        r103 = r107;
    L8:
        Z(r105, r106, r103, r104);
    }

    public static /* synthetic */ void d(TalkRoomBusinessFullLinkMonitor r100, int r101, long r102, ExtraResponse r103) {
        r100.getClass();
        c(r101, r102, r103, "");
    }

    public static void f0(String r100, String r101, long r102, ExtraResponse r103) {
        Intrinsics.checkNotNullParameter(r103, "response");
        JSONObject r104 = new JSONObject();
        r104.put("target_user_id", r100);
        r104.put("target_sec_user_id", r101);
        Z(LinkMonitorData.PermitApiMonitorData, h(r102), r103.logId, r104);
    }

    public static void i(int r100, long r101, h r110, String r111) {
        Intrinsics.checkNotNullParameter(r110, "request");
        JSONObject r102 = new JSONObject();
        r102.put("duration", r101);
        r102.put("ui_layout", r110.f75650a);
        r102.put("to_ui_layout", r110.f75650a);
        if (r111 != null) goto L5;
    L6:
        j r112 = r110.f75652c;
        Intrinsics.checkNotNullParameter(r112, "$this$sbToString");
        r102.put("trace_info", r112.f75663a.toString());
    L8:
        if (r100 != (-1)) goto L10;
    L11:
        c.o(c.f518746a, LinkMonitorData.CommonWMLayoutConfigLoadMonitorData, r102, r100, null, false, 24);
    L13:
        if (nd0.e.b() != true) goto L15;
        return;
    L15:
        if (nd0.e.c() == true) goto L19;
        c.o(c.f518746a, LinkMonitorData.CommonWMLayoutConfigLoadMonitorDataWithSampling, r102, r100, null, false, 24);
        return;
    L19:
        return;
    L10:
        if (r100 != 101) goto L13;
    L5:
        if (r102.put("trace_info", r111) != null) goto L8;
        goto L6
    }

    public static void t0(long r100, int r101, long r102, Throwable r103) {
        JSONObject r104 = new JSONObject();
        r104.put("emoji_id", r100);
        pd0.b r105 = pd0.b.f528640a;
        r104.put("emoji_type", pd0.b.b(r101));
        Y(LinkMonitorData.SendEmojiApiMonitorData, h(r102), r103, r104);
    }

    public static void u(String r100, boolean r101, long r110, Throwable r111) {
        Intrinsics.checkNotNullParameter(r100, "targetUserId");
        JSONObject r102 = new JSONObject();
        r102.put("target_user_id", r100);
        if (r101 == false) goto L5;
        String r103 = "accept";
    L6:
        r102.put("reply_type", r103);
        c.f518746a.getClass();
        Pair r104 = c.t(r111, r102);
        int r105 = rd0.a.f537202a;
        rd0.a.b(MultiTraceData$TraceBusiness.ChatRoom, MultiTraceData$TraceEvent.OpenEnlargeGuest, "replyEnlargeGuest", ((Number) r104.getFirst()).intValue(), (String) r104.getSecond(), r102, 64);
        Y(LinkMonitorData.EnlargeReplyApiMonitorData, h(r110), r111, r102);
        return;
    L5:
        r103 = "reject";
        goto L6
    }

    public static void u0(long r100, int r101, long r102, String r103) {
        Intrinsics.checkNotNullParameter(r103, "logId");
        JSONObject r104 = new JSONObject();
        r104.put("emoji_id", r100);
        pd0.b r105 = pd0.b.f528640a;
        r104.put("emoji_type", pd0.b.b(r101));
        Z(LinkMonitorData.SendEmojiApiMonitorData, h(r102), r103, r104);
    }

    public static void v0(long r100, String r101, long r102, Throwable r103) {
        Intrinsics.checkNotNullParameter(r101, "positionName");
        JSONObject r104 = new JSONObject();
        r104.put("target_position", r100);
        r104.put("target_position_name", r101);
        Y(LinkMonitorData.SetPositionAttributeApiMonitorData, h(r102), r103, r104);
    }

    public static void w(String r100, boolean r101, long r110, String r111) {
        Intrinsics.checkNotNullParameter(r100, "targetUserId");
        Intrinsics.checkNotNullParameter(r111, "logId");
        JSONObject r102 = new JSONObject();
        r102.put("target_user_id", r100);
        if (r101 == false) goto L5;
        String r103 = "accept";
    L6:
        r102.put("reply_type", r103);
        int r104 = rd0.a.f537202a;
        rd0.a.b(MultiTraceData$TraceBusiness.ChatRoom, MultiTraceData$TraceEvent.OpenEnlargeGuest, "replyEnlargeGuest", 0, null, r102, 88);
        Z(LinkMonitorData.EnlargeReplyApiMonitorData, h(r110), r111, r102);
        return;
    L5:
        r103 = "reject";
        goto L6
    }

    public static void w0(long r100, String r101, long r102, String r103) {
        Intrinsics.checkNotNullParameter(r101, "positionName");
        Intrinsics.checkNotNullParameter(r103, "logId");
        JSONObject r104 = new JSONObject();
        r104.put("target_position", r100);
        r104.put("target_position_name", r101);
        Z(LinkMonitorData.SetPositionAttributeApiMonitorData, h(r102), r103, r104);
    }

    public static void G(int r100, LinkApplyType r101, int r102, Throwable r103, long r104) {
        Intrinsics.checkNotNullParameter(r101, "applyType");
        JSONObject r105 = new JSONObject();
        r105.put("apply_position", r100);
        pd0.b r106 = pd0.b.f528640a;
        r105.put(ILiveRoomPlayFragmentConstant.LINK_MIC_APPLY_TYPE, pd0.b.d(r101));
        r105.put("target_link_type", pd0.b.g(r102));
        Y(LinkMonitorData.ApplyApiMonitorData, h(r104), r103, r105);
    }

    public static void H(int r100, LinkApplyType r101, int r102, ExtraResponse r103, long r104) {
        Intrinsics.checkNotNullParameter(r101, "applyType");
        Intrinsics.checkNotNullParameter(r103, "response");
        JSONObject r105 = new JSONObject();
        r105.put("position", r100);
        pd0.b r106 = pd0.b.f528640a;
        r105.put(ILiveRoomPlayFragmentConstant.LINK_MIC_APPLY_TYPE, pd0.b.d(r101));
        r105.put("target_link_type", pd0.b.g(r102));
        Z(LinkMonitorData.ApplyApiMonitorData, h(r104), r103.logId, r105);
    }

    public static void I(String r100, int r101, int r102, Throwable r103, long r104) {
        Intrinsics.checkNotNullParameter(r100, "secToUserId");
        JSONObject r105 = new JSONObject();
        r105.put("sec_to_user_id", r100);
        pd0.b r106 = pd0.b.f528640a;
        r105.put("target_reply_type", pd0.b.i(r101));
        r105.put("target_link_type", pd0.b.g(r102));
        Y(LinkMonitorData.ReplyApiMonitorData, h(r104), r103, r105);
    }

    public static void J(String r100, int r101, int r102, ExtraResponse r103, long r104) {
        Intrinsics.checkNotNullParameter(r100, "secToUserId");
        Intrinsics.checkNotNullParameter(r103, "response");
        JSONObject r105 = new JSONObject();
        r105.put("sec_to_user_id", r100);
        pd0.b r106 = pd0.b.f528640a;
        r105.put("target_reply_type", pd0.b.i(r101));
        r105.put("target_link_type", pd0.b.g(r102));
        Z(LinkMonitorData.ReplyApiMonitorData, h(r104), r103.logId, r105);
    }

    public static void d0(String r100, Map r101, Throwable r110, Integer r111, String r112) {
        Intrinsics.checkNotNullParameter(r100, "step");
        Intrinsics.checkNotNullParameter(r101, "extraParams");
        JSONObject r102 = new JSONObject();
        Iterator r103 = r101.entrySet().iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        Map.Entry r104 = (Map.Entry) r103.next();
        r102.put((String) r104.getKey(), r104.getValue());
        goto L4
    L6:
        c.f518746a.getClass();
        Pair r105 = c.t(r110, r102);
        if (r111 == null) goto L9;
        int r113 = r111.intValue();
    L10:
        int r106 = r113;
        if (r112 != null) goto L13;
        r112 = (String) r105.getSecond();
    L13:
        int r107 = rd0.a.f537202a;
        MultiTraceData$TraceBusiness r108 = MultiTraceData$TraceBusiness.ChatRoom;
        MultiTraceData$TraceEvent r109 = MultiTraceData$TraceEvent.OPEN_LINKED_PANEL;
        rd0.a.b(r108, r109, r100, r106, r112, r102, 64);
        return;
    L9:
        r113 = ((Number) r105.getFirst()).intValue();
        goto L10
    }

    public static void r(String r100, boolean r101, long r110, long r111, Throwable r112) {
        Intrinsics.checkNotNullParameter(r100, "targetUserId");
        JSONObject r102 = new JSONObject();
        r102.put("target_user_id", r100);
        if (r101 == false) goto L5;
        String r103 = "enlarge";
    L6:
        r102.put("invite_type", r103);
        r102.put("operate_type", r110);
        c.f518746a.getClass();
        Pair r104 = c.t(r112, r102);
        int r105 = rd0.a.f537202a;
        rd0.a.b(MultiTraceData$TraceBusiness.ChatRoom, MultiTraceData$TraceEvent.OpenEnlargeGuest, "enlargeGuestInvite", ((Number) r104.getFirst()).intValue(), (String) r104.getSecond(), r102, 64);
        Y(LinkMonitorData.EnlargeInviteApiMonitorData, h(r111), r112, r102);
        return;
    L5:
        r103 = "reduce";
        goto L6
    }

    public static void t(String r100, boolean r101, long r110, long r111, String r112) {
        Intrinsics.checkNotNullParameter(r100, "targetUserId");
        Intrinsics.checkNotNullParameter(r112, "logId");
        JSONObject r102 = new JSONObject();
        r102.put("target_user_id", r100);
        if (r101 == false) goto L5;
        String r103 = "enlarge";
    L6:
        r102.put("invite_type", r103);
        r102.put("operate_type", r110);
        int r104 = rd0.a.f537202a;
        rd0.a.b(MultiTraceData$TraceBusiness.ChatRoom, MultiTraceData$TraceEvent.OpenEnlargeGuest, "enlargeGuestInvite", 0, null, r102, 88);
        Z(LinkMonitorData.EnlargeInviteApiMonitorData, h(r111), r112, r102);
        return;
    L5:
        r103 = "reduce";
        goto L6
    }

    public static void y(int r100, int r101, int r102, long r103, Throwable r104) {
        JSONObject r105 = new JSONObject();
        r105.put("target_scene", r100);
        pd0.b r106 = pd0.b.f528640a;
        r105.put("emoji_type", pd0.b.b(r101));
        r105.put("category", pd0.b.a(r102));
        Y(LinkMonitorData.ListEmojisApiMonitorData, h(r103), r104, r105);
    }

    public static void z0(int r100, int r110, int r111, long r112, ExtraResponse r113) {
        Intrinsics.checkNotNullParameter(r113, "response");
        int r101 = ((IInteractService) jc1.k.n(IInteractService.class)).getCurrentUiLayout();
        JSONObject r102 = new JSONObject();
        pd0.b r103 = pd0.b.f528640a;
        r102.put("from_scene", pd0.b.e(r100));
        r102.put("to_scene", pd0.b.e(r110));
        r102.put("from_ui_layout", pd0.b.f(r101));
        r102.put("to_ui_layout", pd0.b.f(r111));
        int r104 = rd0.a.f537202a;
        rd0.a.b(MultiTraceData$TraceBusiness.ChatRoom, MultiTraceData$TraceEvent.SwitchScene, "switchScene", 0, null, r102, 88);
        TalkRoomBusinessFullLinkMonitor r105 = f71456a;
        LinkMonitorData r114 = LinkMonitorData.SwitchSceneApiMonitorData;
        r105.getClass();
        Z(r114, h(r112), r113.logId, r102);
        InteractLinkFullLinkMonitor.t0("switch_scene_success", ((v1) r113.data).getLiveCoreExtInfo(), ((v1) r113.data).getRtcExtInfo(), ((v1) r113.data).getMultiLiveCoreInfo(), ((v1) r113.data).getMultiRtcInfo());
    }

    public static void y0(int r100, int r101, int r110, String r111, long r112, Throwable r113) {
        Intrinsics.checkNotNullParameter(r111, "reason");
        int r114 = ((IInteractService) jc1.k.n(IInteractService.class)).getCurrentUiLayout();
        JSONObject r102 = new JSONObject();
        pd0.b r103 = pd0.b.f528640a;
        r102.put("from_scene", pd0.b.e(r100));
        r102.put("to_scene", pd0.b.e(r101));
        r102.put("from_ui_layout", pd0.b.f(r114));
        r102.put("to_ui_layout", pd0.b.f(r110));
        c.f518746a.getClass();
        Pair r104 = c.t(r113, r102);
        int r105 = rd0.a.f537202a;
        rd0.a.b(MultiTraceData$TraceBusiness.ChatRoom, MultiTraceData$TraceEvent.SwitchScene, "switchScene", ((Number) r104.getFirst()).intValue(), (String) r104.getSecond(), r102, 64);
        Y(LinkMonitorData.SwitchSceneApiMonitorData, h(r112), r113, r102);
    }
}
