package com.bytedance.android.live.liveinteract.api.fulllink;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.liveinteract.api.trace.MultiTraceData$TraceBusiness;
import com.bytedance.android.live.liveinteract.api.trace.MultiTraceData$TraceEvent;
import com.bytedance.android.live.liveinteract.plantform.base.i;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.permission.model.OperateType;
import com.bytedance.android.livesdk.chatroom.interact.model.v;
import com.bytedance.android.livesdk.chatroom.model.interact.e1;
import com.bytedance.android.livesdk.chatroom.model.interact.j0;
import com.bytedance.android.livesdk.chatroom.model.interact.t2;
import com.bytedance.android.livesdk.link.model.bridge.u1;
import com.bytedance.android.livesdk.link.model.bridge.v1;
import com.bytedance.android.livesdk.link.model.bridge.z0;
import com.bytedance.android.livesdk.multilink.base.model.ReplyType;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.live.livelink.kmp.api.core.mixer.MixStreamType;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.monitor.cloudmessage.consts.CloudControlInf;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import gd0.n;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import jc1.k;
import jy0.d;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt;
import nd0.c;
import nd0.e;
import org.json.JSONObject;
import r27.a;
import tc0.b;

/* JADX INFO: loaded from: classes46.dex */
public final class InteractLinkFullLinkMonitor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Set<Long> f71446a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, Long> f71447b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static long f71448c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static long f71449d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static long f71450e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static boolean f71451f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static boolean f71452g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static b f71453h;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/liveinteract/api/fulllink/InteractLinkFullLinkMonitor$LinkSource;", "", "", "des", "Ljava/lang/String;", "getDes", "()Ljava/lang/String;", "APPLY", "APPLY_AUTO", "REPLY", "JOIN", "UNKNOWN", "liveinteract-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum LinkSource extends Enum<LinkSource> {
        public static final LinkSource APPLY = null;
        public static final LinkSource APPLY_AUTO = null;
        public static final LinkSource JOIN = null;
        public static final LinkSource REPLY = null;
        public static final LinkSource UNKNOWN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ LinkSource[] f71454a = null;
        private final String des;

        static {
            LinkSource r100 = new LinkSource("APPLY", 0, e1.REPLY_ACTION_APPLY);
            APPLY = r100;
            LinkSource r101 = new LinkSource("APPLY_AUTO", 1, "apply_auto");
            APPLY_AUTO = r101;
            LinkSource r102 = new LinkSource("REPLY", 2, "reply");
            REPLY = r102;
            LinkSource r103 = new LinkSource("JOIN", 3, "join");
            JOIN = r103;
            LinkSource r104 = new LinkSource("UNKNOWN", 4, "unknown");
            UNKNOWN = r104;
            f71454a = new LinkSource[]{r100, r101, r102, r103, r104};
        }

        public static LinkSource valueOf(String r100) {
            return (LinkSource) a.a(LinkSource.class, r100);
        }

        public static LinkSource[] values() {
            return (LinkSource[]) f71454a.clone();
        }

        public final String getDes() {
            return this.des;
        }

        public LinkSource(String r100, int r101, String r102) {
            super(r100, r101);
            this.des = r102;
        }
    }

    static {
        f71446a = new LinkedHashSet();
        f71447b = new LinkedHashMap();
    }

    @JvmStatic
    public static final void A() {
        JSONObject r100 = new JSONObject();
        a(r100);
        if (f71451f == false) goto L6;
        i97.a r101 = i97.a.f488802a;
        long r102 = System.currentTimeMillis() - f71448c;
        r100.put("duration", r102);
        jy0.b.a("ttlive_multi_advance_link", "advance apply link server set up duration " + r102);
        c.o(c.f518746a, LinkMonitorData.ApplyJoinChannelSuccess, r100, 0, null, false, 28);
        return;
    L6:
        if (f71452g == false) goto L10;
        i97.a r103 = i97.a.f488802a;
        long r104 = System.currentTimeMillis() - f71449d;
        r100.put("duration", r104);
        jy0.b.a("ttlive_multi_advance_link", "advance reply link server set up duration " + r104);
        c.o(c.f518746a, LinkMonitorData.ReplyJoinChannelSuccess, r100, 0, null, false, 28);
        return;
    }

    @JvmStatic
    public static final void B() {
        i97.a r100 = i97.a.f488802a;
        System.currentTimeMillis();
        JSONObject r101 = new JSONObject();
        c.o(c.f518746a, LinkMonitorData.LiveCoreAudioCaptureStarted, r101, 0, null, false, 28);
    }

    @JvmStatic
    public static final void C() {
        if (f71450e != 0) goto L5;
        return;
    L5:
        JSONObject r100 = new JSONObject();
        i97.a r101 = i97.a.f488802a;
        r100.put("duration", System.currentTimeMillis() - f71450e);
        f71450e = 0;
        c.o(c.f518746a, LinkMonitorData.LiveCoreVideoCaptureFirstFrame, r100, 0, null, false, 28);
    }

    @JvmStatic
    public static final void F() {
        i97.a r100 = i97.a.f488802a;
        f71450e = System.currentTimeMillis();
        JSONObject r101 = new JSONObject();
        c.o(c.f518746a, LinkMonitorData.LiveCoreVideoCaptureStarted, r101, 0, null, false, 28);
    }

    @JvmStatic
    public static final void c0() {
        JSONObject r100 = new JSONObject();
        a(r100);
        if (f71451f == false) goto L6;
        int r101 = rd0.a.f537202a;
        rd0.a.b(MultiTraceData$TraceBusiness.MultiLink, MultiTraceData$TraceEvent.AudienceApplyLink, "startRtc", 0, null, r100, 88);
    L8:
        c.o(c.f518746a, LinkMonitorData.StartRtc, r100, 0, null, false, 28);
        return;
    L6:
        if (f71452g == false) goto L8;
        int r102 = rd0.a.f537202a;
        rd0.a.b(MultiTraceData$TraceBusiness.MultiLink, MultiTraceData$TraceEvent.InviteAudienceLink, "startRtc", 0, null, r100, 88);
        goto L8
    }

    @JvmStatic
    public static final void h0() {
        JSONObject r100 = new JSONObject();
        int r101 = rd0.a.f537202a;
        rd0.a.b(MultiTraceData$TraceBusiness.MultiLink, MultiTraceData$TraceEvent.CloseLink, "stopRtc", 0, null, r100, 88);
        c.o(c.f518746a, LinkMonitorData.StopRtc, r100, 0, null, false, 28);
    }

    @JvmStatic
    public static final void p() {
        JSONObject r100 = new JSONObject();
        a(r100);
        if (f71451f == false) goto L7;
        MultiTraceData$TraceEvent r101 = MultiTraceData$TraceEvent.AudienceApplyLink;
    L5:
        MultiTraceData$TraceEvent r102 = r101;
        if (r102 == null) goto L12;
        int r103 = rd0.a.f537202a;
        rd0.a.b(MultiTraceData$TraceBusiness.MultiLink, r102, "start_join_channel", 0, null, r100, 88);
    L12:
        c.s(c.f518746a, LinkMonitorData.StartJoinChannel, null, 0, "", r100, 98);
        return;
    L7:
        if (f71452g == false) goto L9;
        r101 = MultiTraceData$TraceEvent.InviteAudienceLink;
        goto L5
    L9:
        r101 = null;
        goto L5
    }

    @JvmStatic
    public static final void z() {
        JSONObject r100 = new JSONObject();
        a(r100);
        if (f71451f == false) goto L6;
        i97.a r101 = i97.a.f488802a;
        long r102 = System.currentTimeMillis() - f71448c;
        r100.put("duration", r102);
        jy0.b.a("ttlive_multi_advance_link", "advance apply link rtc set up duration " + r102);
        c.o(c.f518746a, LinkMonitorData.ApplyRTCSetupSuccess, r100, 0, null, false, 28);
        return;
    L6:
        if (f71452g == false) goto L10;
        i97.a r103 = i97.a.f488802a;
        long r104 = System.currentTimeMillis() - f71449d;
        r100.put("duration", r104);
        jy0.b.a("ttlive_multi_advance_link", "advance reply link rtc set up duration " + r104);
        c.o(c.f518746a, LinkMonitorData.ReplyRTCSetupSuccess, r100, 0, null, false, 28);
        return;
    }

    @JvmStatic
    public static final void J(com.bytedance.android.live.liveinteract.multianchor.model.b r100) {
        JSONObject r101 = new JSONObject();
        String r102 = null;
        if (r100 == null) goto L5;
        Intrinsics.checkNotNullParameter(r100, "$this$messageIdExt");
        Long r103 = Long.valueOf(r100.getMessageId2());
    L6:
        r101.put("msg_id", r103);
        if (r100 == null) goto L9;
        Intrinsics.checkNotNullParameter(r100, "$this$fromUserId");
        r102 = r100.get_fromUserId();
    L9:
        r101.put("from_user_id", r102);
        c.o(c.f518746a, LinkMonitorData.AdminFirstInviteMessage, r101, 0, null, false, 28);
        return;
    L5:
        r103 = null;
        goto L6
    }

    @JvmStatic
    public static final void K(z0 r100) {
        JSONObject r101 = new JSONObject();
        Long r102 = null;
        if (r100 == null) goto L5;
        Intrinsics.checkNotNullParameter(r100, "$this$messageIdExt");
        Long r103 = Long.valueOf(r100.getMessageId2());
    L6:
        r101.put("msg_id", r103);
        if (r100 == null) goto L9;
        Intrinsics.checkNotNullParameter(r100, "$this$fromUserId");
        String r104 = r100.get_fromUserId();
    L10:
        r101.put("from_user_id", r104);
        if (r100 == null) goto L13;
        Integer r105 = Integer.valueOf(r100.getReplyType());
    L14:
        r101.put("reply_type", r105);
        if (r100 != null) goto L17;
    L25:
        Map<String, Long> r106 = f71447b;
        if (r100 == null) goto L29;
        Intrinsics.checkNotNullParameter(r100, "$this$fromUserId");
        String r107 = r100.get_fromUserId();
        if (r107 == null) goto L29;
    L30:
        i97.a r108 = i97.a.f488802a;
        r106.put(r107, Long.valueOf(System.currentTimeMillis()));
    L31:
        c.o(c.f518746a, LinkMonitorData.ReplyMessage, r101, 0, null, false, 28);
        return;
    L29:
        r107 = "";
        goto L30
    L17:
        if (r100.getReplyType() != ReplyType.Reject.ordinal()) goto L25;
        Set<Long> r109 = f71446a;
        Intrinsics.checkNotNullParameter(r100, "$this$fromUserId");
        String r110 = r100.get_fromUserId();
        if (r110 == null) goto L21;
        r102 = StringsKt.toLongOrNull(r110);
    L21:
        if (r109 == null) goto L24;
        TypeIntrinsics.asMutableCollection(r109).remove(r102);
        goto L31
    L24:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
    L13:
        r105 = null;
        goto L14
    L9:
        r104 = null;
        goto L10
    L5:
        r103 = null;
        goto L6
    }

    @JvmStatic
    public static final void L(String r100) {
        Intrinsics.checkNotNullParameter(r100, "linkMicId");
        JSONObject r101 = new JSONObject();
        r101.put(ILiveRoomPlayFragmentConstant.EXTRA_LINK_USER_ID, h(r100));
        r101.put("link_mic_id", r100);
        c.o(c.f518746a, LinkMonitorData.RTCFirstAudioFrame, r101, 0, null, false, 28);
    }

    @JvmStatic
    public static final void M(String r100) {
        Intrinsics.checkNotNullParameter(r100, "linkMicId");
        JSONObject r101 = new JSONObject();
        r101.put(ILiveRoomPlayFragmentConstant.EXTRA_LINK_USER_ID, h(r100));
        r101.put("link_mic_id", r100);
        c.o(c.f518746a, LinkMonitorData.RTCFirstVideoFrame, r101, 0, null, false, 28);
    }

    @JvmStatic
    public static final void O(String r100) {
        JSONObject r101 = new JSONObject();
        c.o(c.f518746a, LinkMonitorData.RTCConnectionLost, r101, 0, String.valueOf(r100), false, 20);
        int r102 = rd0.a.f537202a;
        rd0.a.b(MultiTraceData$TraceBusiness.MultiLink, MultiTraceData$TraceEvent.RtcLinkError, "rtc_connection_lost", 0, String.valueOf(r100), r101, 72);
    }

    @JvmStatic
    public static final void Q(String r110) {
        Intrinsics.checkNotNullParameter(r110, "linkMicId");
        JSONObject r100 = new JSONObject();
        String r101 = h(r110);
        r100.put("link_mic_id", r110);
        r100.put(ILiveRoomPlayFragmentConstant.EXTRA_LINK_USER_ID, r101);
        Set<Long> r102 = f71446a;
        if (CollectionsKt.contains(r102, StringsKt.toLongOrNull(r101)) == false) goto L12;
        Long r103 = StringsKt.toLongOrNull(r101);
        if (r102 == null) goto L11;
        TypeIntrinsics.asMutableCollection(r102).remove(r103);
        r100.put("link_source", "invite");
        Map<String, Long> r104 = f71447b;
        Long r105 = (Long) ((LinkedHashMap) r104).get(r101);
        if (r105 == null) goto L9;
        long r106 = r105.longValue();
        i97.a r107 = i97.a.f488802a;
        long r108 = System.currentTimeMillis() - r106;
        JSONObject r111 = new JSONObject();
        r111.put(ILiveRoomPlayFragmentConstant.EXTRA_LINK_USER_ID, r101);
        r111.put("duration", r108);
        c.o(c.f518746a, LinkMonitorData.InviteLinkSuccess, r111, 0, null, false, 28);
    L9:
        r104.remove(r101);
        goto L12
    L11:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
    L12:
        c.o(c.f518746a, LinkMonitorData.RTCUserJoined, r100, 0, null, false, 28);
    }

    @JvmStatic
    public static final void S(int r100) {
        if (e.b() == true) goto L6;
        int r101 = rd0.b.f537203a;
        if (hd0.c.f().h() == true) goto L6;
        return;
    L6:
        JSONObject r102 = new JSONObject();
        r102.put("signal_type", r100);
        c.s(c.f518746a, LinkMonitorData.StartSendSignaling, null, 0, "", r102, 98);
    }

    @JvmStatic
    public static final void V(String r100) {
        Intrinsics.checkNotNullParameter(r100, "toUserId");
        JSONObject r101 = new JSONObject();
        r101.put(com.bytedance.android.ec.core.event.a.KEY_TO_USER_ID, r100);
        c.s(c.f518746a, LinkMonitorData.StartSilence, null, 0, "", r101, 98);
    }

    public static void a(JSONObject r100) {
        if (f71451f == false) goto L6;
        LinkSource r101 = LinkSource.APPLY;
    L9:
        r100.put("link_source", r101.getDes());
        return;
    L6:
        if (f71452g == false) goto L8;
        r101 = LinkSource.REPLY;
        goto L9
    L8:
        r101 = LinkSource.JOIN;
        goto L9
    }

    @JvmStatic
    public static final void e0(long r100) {
        JSONObject r101 = new JSONObject();
        a(r101);
        r101.put("duration", r100);
        if (f71451f == false) goto L6;
        int r102 = rd0.a.f537202a;
        rd0.a.b(MultiTraceData$TraceBusiness.MultiLink, MultiTraceData$TraceEvent.AudienceApplyLink, "startRtcSuccess", 0, null, r101, 88);
    L8:
        c.o(c.f518746a, LinkMonitorData.RTCStartSuccess, r101, 0, null, false, 28);
        return;
    L6:
        if (f71452g == false) goto L8;
        int r103 = rd0.a.f537202a;
        rd0.a.b(MultiTraceData$TraceBusiness.MultiLink, MultiTraceData$TraceEvent.InviteAudienceLink, "startRtcSuccess", 0, null, r101, 88);
        goto L8
    }

    @JvmStatic
    public static final void g0(String r100) {
        JSONObject r101 = new JSONObject();
        r101.put("rtc_ext_info", r100);
        c.o(c.f518746a, LinkMonitorData.StopForwardRoom, r101, 0, null, false, 28);
    }

    public static String h(String r100) {
        Intrinsics.checkNotNullParameter(r100, "interactId");
        i<? extends ILinkPlayerInfoBridge> r101 = ((n) k.n(n.class)).getLinkUserInfoCenter();
        if (r101 == null) goto L8;
        IBaseUser r102 = r101.U4(r100);
        if (r102 == null) goto L8;
        String r103 = r102.getIdString();
        if (r103 == null) goto L8;
        return r103;
    L8:
        return "";
    }

    @JvmStatic
    public static final void j0(long r100) {
        JSONObject r101 = new JSONObject();
        r101.put("duration", r100);
        int r102 = rd0.a.f537202a;
        rd0.a.b(MultiTraceData$TraceBusiness.MultiLink, MultiTraceData$TraceEvent.CloseLink, "stopRtcSuccess", 0, null, r101, 88);
        c.o(c.f518746a, LinkMonitorData.RTCStopSuccess, r101, 0, null, false, 28);
    }

    public static void k(long r110) {
        if (r110 > 0) goto L5;
        return;
    L5:
        if (r110 > 15000) goto L20;
        JSONObject r100 = new JSONObject();
        r100.put("duration", r110);
        a(r100);
        if (f71451f == false) goto L12;
        MultiTraceData$TraceEvent r111 = MultiTraceData$TraceEvent.AudienceApplyLink;
    L10:
        MultiTraceData$TraceEvent r101 = r111;
        if (r101 == null) goto L17;
        int r112 = rd0.a.f537202a;
        rd0.a.b(MultiTraceData$TraceBusiness.MultiLink, r101, "init_live_core", 0, null, r100, 88);
    L17:
        c.o(c.f518746a, LinkMonitorData.InitLiveClient, r100, 0, null, false, 28);
        return;
    L12:
        if (f71452g == false) goto L14;
        r111 = MultiTraceData$TraceEvent.InviteAudienceLink;
        goto L10
    L14:
        r111 = null;
        goto L10
    }

    @JvmStatic
    public static final void m0(String r100) {
        JSONObject r101 = new JSONObject();
        r101.put("trace_null_client", "client = null");
        r101.put("req_src", r100);
        c.o(c.f518746a, LinkMonitorData.StopForwardRoom, r101, 0, null, false, 28);
    }

    @JvmStatic
    public static final void n0(String r100) {
        Intrinsics.checkNotNullParameter(r100, "toUserId");
        JSONObject r101 = new JSONObject();
        r101.put(com.bytedance.android.ec.core.event.a.KEY_TO_USER_ID, r100);
        c.s(c.f518746a, LinkMonitorData.StartUnSilence, null, 0, "", r101, 98);
    }

    @JvmStatic
    public static final void s(String r100) {
        Intrinsics.checkNotNullParameter(r100, "toUserId");
        JSONObject r101 = new JSONObject();
        r101.put(com.bytedance.android.ec.core.event.a.KEY_TO_USER_ID, r100);
        c.s(c.f518746a, LinkMonitorData.StartKickOut, null, 0, "", r101, 98);
    }

    public static void u0(String r100) {
        JSONObject r101 = new JSONObject();
        r101.put("rtc_ext_info", r100);
        c.o(c.f518746a, LinkMonitorData.UpdateRtcExtInfo, r101, 0, null, false, 28);
    }

    @JvmStatic
    public static final void v(String r100) {
        JSONObject r101 = new JSONObject();
        r101.put("request_source", r100);
        a(r101);
        int r102 = rd0.a.f537202a;
        rd0.a.b(MultiTraceData$TraceBusiness.MultiLink, MultiTraceData$TraceEvent.CloseLink, "start_leave", 0, ExceptionsKt.stackTraceToString(new Throwable()), r101, 64);
        c.s(c.f518746a, LinkMonitorData.StartLeave, null, 0, "", r101, 98);
    }

    public static /* synthetic */ void E(String r100, int r101) {
        if ((r101 & 1) == 0) goto L5;
        LinkSource r102 = LinkSource.UNKNOWN;
    L7:
        if ((r101 & 2) == 0) goto L9;
        r100 = "null";
    L9:
        D(r102, r100, 0, false);
        return;
    L5:
        r102 = null;
        goto L7
    }

    @JvmStatic
    public static final void G(String r100, String r101) {
        JSONObject r102 = new JSONObject();
        r102.put(com.bytedance.android.ec.core.event.a.KEY_TO_USER_ID, r100);
        r102.put("sec_to_user_id", r101);
        c.s(c.f518746a, LinkMonitorData.StartPermit, null, 0, "", r102, 98);
    }

    @JvmStatic
    public static final void N(String r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "linkMicId");
        JSONObject r102 = new JSONObject();
        r102.put(ILiveRoomPlayFragmentConstant.EXTRA_LINK_USER_ID, h(r100));
        r102.put("link_mic_id", r100);
        r102.put("duration", r101);
        c.o(c.f518746a, LinkMonitorData.RTCFirstVideoFrameRender, r102, 0, null, false, 28);
    }

    @JvmStatic
    public static final void P(int r100, String r101) {
        JSONObject r102 = new JSONObject();
        int r103 = rd0.a.f537202a;
        rd0.a.b(MultiTraceData$TraceBusiness.MultiLink, MultiTraceData$TraceEvent.RtcLinkError, "rtcError", r100, r101, r102, 64);
        c.o(c.f518746a, LinkMonitorData.RTCError, r102, r100, String.valueOf(r101), false, 16);
    }

    @JvmStatic
    public static final void R(String r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "linkMicId");
        JSONObject r102 = new JSONObject();
        String r103 = h(r100);
        r102.put("link_mic_id", r100);
        r102.put(ILiveRoomPlayFragmentConstant.EXTRA_LINK_USER_ID, r103);
        r102.put("duration", r101);
        c.o(c.f518746a, LinkMonitorData.RTCUserLeaved, r102, 0, null, false, 28);
    }

    public static void Y(int r100, String r101) {
        JSONObject r102 = new JSONObject();
        c r103 = c.f518746a;
        LinkMonitorData r104 = LinkMonitorData.LiveCoreAudioCaptureFailed;
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        c.o(r103, r104, r102, r100, r101, false, 16);
    }

    @JvmStatic
    public static final void a0(String r100, String r101) {
        JSONObject r102 = new JSONObject();
        r102.put(CloudControlInf.STAT, r100);
        r102.put("params", r101);
        c.o(c.f518746a, LinkMonitorData.RTCForwardRoomFailed, r102, -1, r100, false, 16);
    }

    @JvmStatic
    public static final void d0(int r100, String r101) {
        JSONObject r102 = new JSONObject();
        a(r102);
        if (f71451f == false) goto L6;
        int r103 = rd0.a.f537202a;
        rd0.a.b(MultiTraceData$TraceBusiness.MultiLink, MultiTraceData$TraceEvent.AudienceApplyLink, "startRtcFailed", r100, r101, r102, 64);
    L8:
        c.o(c.f518746a, LinkMonitorData.RTCStartFailed, r102, r100, String.valueOf(r101), false, 16);
        return;
    L6:
        if (f71452g == false) goto L8;
        int r104 = rd0.a.f537202a;
        rd0.a.b(MultiTraceData$TraceBusiness.MultiLink, MultiTraceData$TraceEvent.InviteAudienceLink, "startRtcFailed", r100, r101, r102, 64);
        goto L8
    }

    @JvmStatic
    public static final void f(int r100, int r101) {
        JSONObject r102 = new JSONObject();
        r102.put("link_type", r101);
        r102.put(ILiveRoomPlayFragmentConstant.EXTRA_OPERATION_TYPE, r100);
        if (r100 != OperateType.APPLY.ordinal()) goto L6;
        int r103 = rd0.a.f537202a;
        rd0.a.b(MultiTraceData$TraceBusiness.MultiLink, MultiTraceData$TraceEvent.AudienceApplyLink, "checkLinkPermission", 0, null, r102, 88);
    L8:
        c.o(c.f518746a, LinkMonitorData.CheckLinkPermission, r102, 0, null, false, 28);
        return;
    L6:
        if (r100 != OperateType.REPLY.ordinal()) goto L8;
        int r104 = rd0.a.f537202a;
        rd0.a.b(MultiTraceData$TraceBusiness.MultiLink, MultiTraceData$TraceEvent.InviteAudienceLink, "checkLinkPermission", 0, null, r102, 88);
        goto L8
    }

    @JvmStatic
    public static final void f0(int r100, String r110) {
        f71450e = 0;
        JSONObject r101 = new JSONObject();
        c r102 = c.f518746a;
        LinkMonitorData r103 = LinkMonitorData.LiveCoreVideoCaptureFailed;
        if (r110 != null) goto L5;
        r110 = "";
    L5:
        c.o(r102, r103, r101, r100, r110, false, 16);
    }

    @JvmStatic
    public static final void i0(long r100, String r110) {
        JSONObject r101 = new JSONObject();
        int r102 = rd0.a.f537202a;
        int r103 = (int) r100;
        rd0.a.b(MultiTraceData$TraceBusiness.MultiLink, MultiTraceData$TraceEvent.CloseLink, "stopRtcFailed", r103, String.valueOf(r110), r101, 64);
        c.o(c.f518746a, LinkMonitorData.RTCStopFailed, r101, r103, String.valueOf(r110), false, 16);
    }

    @JvmStatic
    public static final void k0(boolean r100, String r101) {
        JSONObject r102 = new JSONObject();
        r102.put("enable", r100);
        if (r101 != null) goto L5;
    L7:
        r102.put("reason", ExceptionsKt.stackTraceToString(new Throwable()));
    L8:
        c.o(c.f518746a, LinkMonitorData.SwitchAudio, r102, 0, null, false, 28);
        return;
    L5:
        if ((!StringsKt.isBlank(r101)) != true) goto L7;
        r102.put("reason", r101);
        goto L8
    }

    @JvmStatic
    public static final void l0(MixStreamType r100, MixStreamType r101) {
        JSONObject r102 = new JSONObject();
        r102.put("from", r100);
        r102.put(RemoteMessageConst.TO, r101);
        c.o(c.f518746a, LinkMonitorData.SwitchMixType, r102, 0, null, false, 28);
    }

    @JvmStatic
    public static final void m(String r100, String r101) {
        JSONObject r102 = new JSONObject();
        r102.put(com.bytedance.android.ec.core.event.a.KEY_TO_USER_ID, r100);
        r102.put("sec_to_user_id", r101);
        c.s(c.f518746a, LinkMonitorData.StartInviteAudience, null, 0, "", r102, 98);
    }

    @JvmStatic
    public static final void q(long r110, Throwable r111) {
        JSONObject r100 = new JSONObject();
        a(r100);
        c r101 = c.f518746a;
        r101.getClass();
        Pair r102 = c.t(r111, r100);
        if (f71451f == false) goto L6;
        int r103 = rd0.a.f537202a;
        rd0.a.b(MultiTraceData$TraceBusiness.MultiLink, MultiTraceData$TraceEvent.AudienceApplyLink, "joinChannel", ((Number) r102.getFirst()).intValue(), (String) r102.getSecond(), r100, 64);
    L8:
        c.r(r101, LinkMonitorData.JoinChannel, null, r110, r111, r100, 34);
        return;
    L6:
        if (f71452g == false) goto L8;
        int r104 = rd0.a.f537202a;
        rd0.a.b(MultiTraceData$TraceBusiness.MultiLink, MultiTraceData$TraceEvent.InviteAudienceLink, "joinChannel", ((Number) r102.getFirst()).intValue(), (String) r102.getSecond(), r100, 64);
        goto L8
    }

    @JvmStatic
    public static final void q0(int r100, String r110) {
        Intrinsics.checkNotNullParameter(r110, "targetUserId");
        JSONObject r101 = new JSONObject();
        r101.put("link_type", r100);
        r101.put(com.bytedance.android.ec.core.event.a.KEY_TO_USER_ID, r110);
        c.s(c.f518746a, LinkMonitorData.StartUpdateLinkType, null, 0, "", r101, 98);
    }

    @JvmStatic
    public static final void T(int r100, long r110, Throwable r111) {
        if (e.b() == true) goto L6;
        int r101 = rd0.b.f537203a;
        if (hd0.c.f().h() == true) goto L6;
        return;
    L6:
        JSONObject r102 = new JSONObject();
        r102.put("signal_type", r100);
        c.r(c.f518746a, LinkMonitorData.SendSignaling, null, r110, r111, r102, 34);
    }

    @JvmStatic
    public static final void U(int r100, long r110, String r111) {
        Intrinsics.checkNotNullParameter(r111, "logId");
        if (e.b() == true) goto L6;
        int r101 = rd0.b.f537203a;
        if (hd0.c.f().h() == true) goto L6;
        return;
    L6:
        JSONObject r102 = new JSONObject();
        r102.put("signal_type", r100);
        c.s(c.f518746a, LinkMonitorData.SendSignaling, null, r110, r111, r102, 98);
    }

    @JvmStatic
    public static final void W(String r100, long r110, Throwable r111) {
        Intrinsics.checkNotNullParameter(r100, "toUserId");
        JSONObject r101 = new JSONObject();
        r101.put(com.bytedance.android.ec.core.event.a.KEY_TO_USER_ID, r100);
        c.r(c.f518746a, LinkMonitorData.Silence, null, r110, r111, r101, 34);
    }

    @JvmStatic
    public static final void X(String r100, long r110, String r111) {
        Intrinsics.checkNotNullParameter(r100, "toUserId");
        Intrinsics.checkNotNullParameter(r111, "logId");
        JSONObject r101 = new JSONObject();
        r101.put(com.bytedance.android.ec.core.event.a.KEY_TO_USER_ID, r100);
        c.s(c.f518746a, LinkMonitorData.Silence, null, r110, r111, r101, 98);
    }

    @JvmStatic
    public static final void Z(String r100, String r101, String r102) {
        JSONObject r103 = new JSONObject();
        r103.put("to_room_id", r100);
        r103.put("rtc_ext_info", r101);
        r103.put("remote_rtc_ext_info", r102);
        c.o(c.f518746a, LinkMonitorData.StartForwardRoom, r103, 0, null, false, 28);
    }

    @JvmStatic
    public static final void b(int r100, int r110, String r111) {
        Intrinsics.checkNotNullParameter(r111, "applySource");
        f71451f = true;
        f71452g = false;
        JSONObject r101 = new JSONObject();
        r101.put("apply_position", r100);
        r101.put("apply_link_type", r110);
        r101.put(ILiveRoomPlayFragmentConstant.LINK_MIC_APPLY_SOURCE, r111);
        c.s(c.f518746a, LinkMonitorData.StartApply, null, 0, "", r101, 98);
    }

    @JvmStatic
    public static final void b0(Object r100, Object r101, long r102) {
        JSONObject r103 = new JSONObject();
        r103.put(CloudControlInf.STAT, String.valueOf(r100));
        r103.put("params", String.valueOf(r101));
        r103.put("duration", r102);
        c.o(c.f518746a, LinkMonitorData.RTCForwardRoomSuccess, r103, 0, null, false, 28);
    }

    @JvmStatic
    public static final void e(int r100, int r101, Throwable r110) {
        JSONObject r102 = new JSONObject();
        f71451f = false;
        f71452g = false;
        r102.put(ILiveRoomPlayFragmentConstant.EXTRA_OPERATION_TYPE, r100);
        r102.put("link_type", r101);
        c r103 = c.f518746a;
        r103.getClass();
        Pair r111 = c.t(r110, r102);
        if (r100 != OperateType.APPLY.ordinal()) goto L6;
        int r104 = rd0.a.f537202a;
        rd0.a.b(MultiTraceData$TraceBusiness.MultiLink, MultiTraceData$TraceEvent.AudienceApplyLink, "checkLinkPermission", ((Number) r111.getFirst()).intValue(), (String) r111.getSecond(), r102, 64);
    L8:
        c.o(r103, LinkMonitorData.CheckLinkPermission, r102, ((Number) r111.getFirst()).intValue(), (String) r111.getSecond(), false, 16);
        return;
    L6:
        if (r100 != OperateType.REPLY.ordinal()) goto L8;
        int r105 = rd0.a.f537202a;
        rd0.a.b(MultiTraceData$TraceBusiness.MultiLink, MultiTraceData$TraceEvent.InviteAudienceLink, "checkLinkPermission", ((Number) r111.getFirst()).intValue(), (String) r111.getSecond(), r102, 64);
        goto L8
    }

    @JvmStatic
    public static final void i(String r100, int r110, String r111) {
        Intrinsics.checkNotNullParameter(r100, "supportedScene");
        Intrinsics.checkNotNullParameter(r111, "openSource");
        JSONObject r101 = new JSONObject();
        r101.put("supported_scene", r100);
        r101.put("request_scene", r110);
        r101.put(ILiveRoomPlayFragmentConstant.EXTRA_OPEN_SOURCE, r111);
        int r102 = rd0.a.f537202a;
        rd0.a.b(MultiTraceData$TraceBusiness.ChatRoom, MultiTraceData$TraceEvent.OpenChatRoom, "startInit", 0, null, r101, 88);
        c.s(c.f518746a, LinkMonitorData.StartInit, null, 0, "", r101, 98);
        Intrinsics.checkNotNullParameter("ttlive_link", "tag");
        d.a(3, "ttlive_link", ThreadMethodProxy.currentThread().getStackTrace());
    }

    @JvmStatic
    public static final void o0(String r100, long r110, Throwable r111) {
        Intrinsics.checkNotNullParameter(r100, "toUserId");
        JSONObject r101 = new JSONObject();
        r101.put(com.bytedance.android.ec.core.event.a.KEY_TO_USER_ID, r100);
        c.r(c.f518746a, LinkMonitorData.UnSilence, null, r110, r111, r101, 34);
    }

    @JvmStatic
    public static final void p0(String r100, long r110, String r111) {
        Intrinsics.checkNotNullParameter(r100, "toUserId");
        Intrinsics.checkNotNullParameter(r111, "logId");
        JSONObject r101 = new JSONObject();
        r101.put(com.bytedance.android.ec.core.event.a.KEY_TO_USER_ID, r100);
        c.s(c.f518746a, LinkMonitorData.UnSilence, null, r110, r111, r101, 98);
    }

    @JvmStatic
    public static final void t(String r100, long r110, Throwable r111) {
        Intrinsics.checkNotNullParameter(r100, "toUserId");
        JSONObject r101 = new JSONObject();
        r101.put(com.bytedance.android.ec.core.event.a.KEY_TO_USER_ID, r100);
        c.r(c.f518746a, LinkMonitorData.KickOut, null, r110, r111, r101, 34);
    }

    @JvmStatic
    public static final void u(String r100, long r110, String r111) {
        Intrinsics.checkNotNullParameter(r100, "toUserId");
        Intrinsics.checkNotNullParameter(r111, "logId");
        JSONObject r101 = new JSONObject();
        r101.put(com.bytedance.android.ec.core.event.a.KEY_TO_USER_ID, r100);
        c.s(c.f518746a, LinkMonitorData.KickOut, null, r110, r111, r101, 98);
    }

    @JvmStatic
    public static final void w(String r100, long r110, Throwable r111) {
        JSONObject r101 = new JSONObject();
        r101.put("request_source", r100);
        c r102 = c.f518746a;
        r102.getClass();
        Pair r103 = c.t(r111, r101);
        int r104 = rd0.a.f537202a;
        rd0.a.b(MultiTraceData$TraceBusiness.MultiLink, MultiTraceData$TraceEvent.CloseLink, "leaveChannel", ((Number) r103.getFirst()).intValue(), (String) r103.getSecond(), r101, 64);
        c.r(r102, LinkMonitorData.Leave, null, r110, r111, r101, 34);
    }

    @JvmStatic
    public static final void x(String r100, long r110, String r111) {
        Intrinsics.checkNotNullParameter(r111, "logId");
        JSONObject r101 = new JSONObject();
        a(r101);
        r101.put("request_source", r100);
        int r102 = rd0.a.f537202a;
        rd0.a.b(MultiTraceData$TraceBusiness.MultiLink, MultiTraceData$TraceEvent.CloseLink, "leaveChannel", 0, ExceptionsKt.stackTraceToString(new Throwable()), r101, 64);
        c.s(c.f518746a, LinkMonitorData.Leave, null, r110, r111, r101, 98);
    }

    @JvmStatic
    public static final void D(LinkSource r110, String r111, long r112, boolean r113) {
        Intrinsics.checkNotNullParameter(r110, "linkType");
        Intrinsics.checkNotNullParameter(r111, "linkOptInfo");
        if (r110 == LinkSource.UNKNOWN) goto L7;
        if (r112 <= 0) goto L7;
    L12:
        JSONObject r100 = new JSONObject();
        r100.put("link_source", r110.getDes());
        r100.put("duration", r112);
        r100.put("link_opt_info", r111);
        if (r113 == false) goto L15;
        String r114 = "LinkSuccessFirstFrame";
    L16:
        int r115 = nd0.d.f518747a[r110.ordinal()];
        if (r115 != 1) goto L19;
    L28:
        c r101 = c.f518746a;
        if (r113 == false) goto L31;
        LinkMonitorData r116 = LinkMonitorData.LinkSuccessFirstFrame;
    L32:
        c.o(r101, r116, r100, 0, null, false, 28);
        int r117 = rd0.a.f537202a;
        rd0.a.b(MultiTraceData$TraceBusiness.MultiLink, MultiTraceData$TraceEvent.AudienceApplyLink, r114, 0, null, r100, 88);
    L33:
        f71448c = 0;
        f71449d = 0;
        f71451f = false;
        f71452g = false;
        return;
    L31:
        r116 = LinkMonitorData.ApplyLinkSuccess;
        goto L32
    L19:
        if (r115 == 2) goto L28;
        if (r115 != 3) goto L33;
        c r102 = c.f518746a;
        if (r113 == false) goto L26;
        LinkMonitorData r118 = LinkMonitorData.LinkSuccessFirstFrame;
    L27:
        c.o(r102, r118, r100, 0, null, false, 28);
        int r119 = rd0.a.f537202a;
        rd0.a.b(MultiTraceData$TraceBusiness.MultiLink, MultiTraceData$TraceEvent.InviteAudienceLink, r114, 0, null, r100, 88);
        goto L33
    L26:
        r118 = LinkMonitorData.ReplyLinkSuccess;
        goto L27
    L15:
        r114 = "LinkSuccess";
    L7:
        if (f71451f == false) goto L10;
        i97.a r120 = i97.a.f488802a;
        r112 = System.currentTimeMillis() - f71448c;
        r110 = LinkSource.APPLY;
        goto L12
    L10:
        if (f71452g == false) goto L12;
        i97.a r121 = i97.a.f488802a;
        r112 = System.currentTimeMillis() - f71449d;
        r110 = LinkSource.REPLY;
        goto L12
    }

    @JvmStatic
    public static final void H(String r100, String r101, long r110, Throwable r111) {
        JSONObject r102 = new JSONObject();
        r102.put(com.bytedance.android.ec.core.event.a.KEY_TO_USER_ID, r100);
        r102.put("sec_to_user_id", r101);
        c.r(c.f518746a, LinkMonitorData.Permit, null, r110, r111, r102, 34);
    }

    @JvmStatic
    public static final void g(String r100, String r110, long r111, Throwable r112) {
        Intrinsics.checkNotNullParameter(r110, "reason");
        JSONObject r101 = new JSONObject();
        r101.put("request_source", r100);
        r101.put("reason", r110);
        c.r(c.f518746a, LinkMonitorData.CheckLinkers, null, r111, r112, r101, 34);
    }

    @JvmStatic
    public static final void n(String r100, String r110, long r111, Throwable r112) {
        Intrinsics.checkNotNullParameter(r110, "secToUserId");
        JSONObject r101 = new JSONObject();
        r101.put(com.bytedance.android.ec.core.event.a.KEY_TO_USER_ID, r100);
        r101.put("sec_to_user_id", r110);
        Set<Long> r113 = f71446a;
        if (r100 == null) goto L5;
        Long r102 = StringsKt.toLongOrNull(r100);
    L6:
        if (r113 == null) goto L10;
        TypeIntrinsics.asMutableCollection(r113).remove(r102);
        c r103 = c.f518746a;
        r103.getClass();
        Pair r114 = c.t(r112, r101);
        int r104 = rd0.a.f537202a;
        rd0.a.b(MultiTraceData$TraceBusiness.MultiLink, MultiTraceData$TraceEvent.InviteAudienceLink, "invite", ((Number) r114.getFirst()).intValue(), (String) r114.getSecond(), r101, 64);
        c.r(r103, LinkMonitorData.InviteAudience, null, r111, r112, r101, 34);
        return;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
    L5:
        r102 = null;
        goto L6
    }

    @JvmStatic
    public static final void r0(int r100, String r110, long r111, Throwable r112) {
        Intrinsics.checkNotNullParameter(r110, "targetUserId");
        JSONObject r101 = new JSONObject();
        r101.put("link_type", r100);
        r101.put(com.bytedance.android.ec.core.event.a.KEY_TO_USER_ID, r110);
        c.r(c.f518746a, LinkMonitorData.UpdateLinkType, null, r111, r112, r101, 34);
    }

    @JvmStatic
    public static final void s0(int r100, String r110, long r111, String r112) {
        Intrinsics.checkNotNullParameter(r110, "targetUserId");
        Intrinsics.checkNotNullParameter(r112, "logId");
        JSONObject r101 = new JSONObject();
        r101.put("link_type", r100);
        r101.put(com.bytedance.android.ec.core.event.a.KEY_TO_USER_ID, r110);
        c.s(c.f518746a, LinkMonitorData.UpdateLinkType, null, r111, r112, r101, 98);
    }

    @JvmStatic
    public static final void I(String r100, String r110, long r111, String r112, t2 r113) {
        Intrinsics.checkNotNullParameter(r112, "logId");
        Intrinsics.checkNotNullParameter(r113, "response");
        b r101 = f71453h;
        if (r101 == null) goto L5;
        r101.Jm(r113.getRemoteLinkerSessionId());
    L5:
        JSONObject r102 = new JSONObject();
        r102.put(com.bytedance.android.ec.core.event.a.KEY_TO_USER_ID, r100);
        r102.put("sec_to_user_id", r110);
        c.s(c.f518746a, LinkMonitorData.Permit, null, r111, r112, r102, 98);
    }

    @JvmStatic
    public static final void c(int r100, int r110, String r111, long r112, Throwable r113) {
        Intrinsics.checkNotNullParameter(r111, "applySource");
        JSONObject r101 = new JSONObject();
        f71451f = false;
        r101.put("apply_position", r100);
        r101.put("apply_link_type", r110);
        r101.put(ILiveRoomPlayFragmentConstant.LINK_MIC_APPLY_SOURCE, r111);
        c r102 = c.f518746a;
        r102.getClass();
        Pair r114 = c.t(r113, r101);
        int r115 = rd0.a.f537202a;
        rd0.a.b(MultiTraceData$TraceBusiness.MultiLink, MultiTraceData$TraceEvent.AudienceApplyLink, e1.REPLY_ACTION_APPLY, ((Number) r114.getFirst()).intValue(), (String) r114.getSecond(), r101, 64);
        c.r(r102, LinkMonitorData.Apply, null, r112, r113, r101, 34);
    }

    @JvmStatic
    public static final void j(String r100, int r110, long r111, Throwable r112, String r113) {
        Intrinsics.checkNotNullParameter(r100, "supportedScene");
        Intrinsics.checkNotNullParameter(r113, "openSource");
        JSONObject r101 = new JSONObject();
        r101.put("supported_scene", r100);
        r101.put("request_scene", r110);
        r101.put(ILiveRoomPlayFragmentConstant.EXTRA_OPEN_SOURCE, r113);
        c r102 = c.f518746a;
        r102.getClass();
        Pair r114 = c.t(r112, r101);
        int r115 = rd0.a.f537202a;
        rd0.a.b(MultiTraceData$TraceBusiness.ChatRoom, MultiTraceData$TraceEvent.OpenChatRoom, "init", ((Number) r114.getFirst()).intValue(), (String) r114.getSecond(), r101, 64);
        c.r(r102, LinkMonitorData.Init, null, r111, r112, r101, 34);
    }

    @JvmStatic
    public static final void o(String r100, String r110, long r111, String r112, v r113) {
        Intrinsics.checkNotNullParameter(r112, "logId");
        Intrinsics.checkNotNullParameter(r113, "response");
        b r101 = f71453h;
        if (r101 == null) goto L5;
        r101.Jm(r113.getRemoteLinkerSessionId());
    L5:
        JSONObject r114 = new JSONObject();
        r114.put(com.bytedance.android.ec.core.event.a.KEY_TO_USER_ID, r100);
        r114.put("sec_to_user_id", r110);
        int r102 = rd0.a.f537202a;
        rd0.a.b(MultiTraceData$TraceBusiness.MultiLink, MultiTraceData$TraceEvent.InviteAudienceLink, "invite", 0, null, r114, 80);
        c.s(c.f518746a, LinkMonitorData.InviteAudience, null, r111, r112, r114, 98);
    }

    @JvmStatic
    public static final void r(String r110, Long r111, String r112, long r113, String r114) {
        Intrinsics.checkNotNullParameter(r114, "logId");
        if (r113 > 0) goto L5;
        return;
    L5:
        JSONObject r100 = new JSONObject();
        r100.put("token", r110);
        r100.put("list_version", r111);
        r100.put("list_data", r112);
        a(r100);
        if (f71451f == false) goto L9;
        int r101 = rd0.a.f537202a;
        rd0.a.b(MultiTraceData$TraceBusiness.MultiLink, MultiTraceData$TraceEvent.AudienceApplyLink, "joinChannel", 0, null, r100, 88);
    L11:
        c.s(c.f518746a, LinkMonitorData.JoinChannel, null, r113, r114, r100, 98);
        return;
    L9:
        if (f71452g == false) goto L11;
        int r102 = rd0.a.f537202a;
        rd0.a.b(MultiTraceData$TraceBusiness.MultiLink, MultiTraceData$TraceEvent.InviteAudienceLink, "joinChannel", 0, null, r100, 88);
        goto L11
    }

    @JvmStatic
    public static final void t0(String r100, String r101, String r110, u1 r111, v1 r112) {
        Intrinsics.checkNotNullParameter(r100, "fromSource");
        JSONObject r102 = new JSONObject();
        r102.put("from_source", r100);
        if (r101 == null) goto L5;
        r102.put("live_core_ext_info_from_server", r101);
    L5:
        if (r111 == null) goto L7;
        r102.put("multi_live_core_ext_info_from_server", GsonProtectorUtils.toJson(l97.a.f508113a, r111));
    L7:
        if (r110 == null) goto L9;
        r102.put("rtc_ext_info_from_server", r110);
    L9:
        if (r112 == null) goto L11;
        r102.put("multi_rtc_ext_info_from_server", GsonProtectorUtils.toJson(l97.a.f508113a, r112));
    L11:
        c.o(c.f518746a, LinkMonitorData.UpdateLiveCoreAndRtcExtInfoFromServer, r102, 0, null, false, 28);
    }

    public static void y(int r100, Boolean r101, Boolean r102, int r110, int r111) {
        JSONObject r103 = new JSONObject();
        r103.put("diff_count", r100);
        r103.put("video_capture_is_open", r101);
        r103.put("audio_capture_is_open", r102);
        r103.put("silence_status", r110);
        r103.put("link_type", r111);
        c.o(c.f518746a, LinkMonitorData.LinkSecurityCheckCountLog, r103, 0, null, false, 28);
    }

    @JvmStatic
    public static final void d(int r110, int r111, String r112, int r113, int r114, long r210, String r211) {
        Intrinsics.checkNotNullParameter(r112, "applySource");
        Intrinsics.checkNotNullParameter(r211, "logId");
        JSONObject r100 = new JSONObject();
        r100.put("apply_position", r110);
        r100.put("apply_link_type", r111);
        r100.put(ILiveRoomPlayFragmentConstant.LINK_MIC_APPLY_SOURCE, r112);
        r100.put("is_auto_join", r113);
        r100.put("is_auto_join_full", r114);
        int r101 = rd0.a.f537202a;
        rd0.a.b(MultiTraceData$TraceBusiness.MultiLink, MultiTraceData$TraceEvent.AudienceApplyLink, e1.REPLY_ACTION_APPLY, 0, null, r100, 80);
        c.s(c.f518746a, LinkMonitorData.Apply, null, r210, r211, r100, 98);
    }

    @JvmStatic
    public static final void l(String r110, int r111, int r112, j0 r210, long r211, String r212, String r213) {
        Intrinsics.checkNotNullParameter(r110, "supportedScene");
        Intrinsics.checkNotNullParameter(r210, "initResult");
        Intrinsics.checkNotNullParameter(r212, "logId");
        Intrinsics.checkNotNullParameter(r213, "openSource");
        b r100 = f71453h;
        if (r100 == null) goto L5;
        r100.Ah(r210.getLinkerSessionId());
    L5:
        JSONObject r101 = new JSONObject();
        r101.put("response_scene", r112);
        r101.put("supported_scene", r110);
        r101.put("request_scene", r111);
        r101.put(ILiveRoomPlayFragmentConstant.EXTRA_OPEN_SOURCE, r213);
        int r102 = rd0.a.f537202a;
        rd0.a.b(MultiTraceData$TraceBusiness.ChatRoom, MultiTraceData$TraceEvent.OpenChatRoom, "init", 0, null, r101, 88);
        c.s(c.f518746a, LinkMonitorData.Init, null, r211, r212, r101, 98);
        t0("init_success", r210.getLiveCoreExtInfo(), r210.getRtcExtInfo(), r210.getMultiLiveCoreInfo(), r210.getMultiRtcInfo());
    }
}
