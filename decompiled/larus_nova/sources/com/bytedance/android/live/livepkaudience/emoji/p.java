package com.bytedance.android.live.livepkaudience.emoji;

import android.text.TextUtils;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.base.model.user.o0;
import com.bytedance.android.live.broadcast.api.IBroadcastService;
import com.bytedance.android.live.core.monitor.LiveSlardarMonitor;
import com.bytedance.android.live.core.setting.e0;
import com.bytedance.android.live.core.utils.h1;
import com.bytedance.android.live.core.utils.i1;
import com.bytedance.android.live.link.ILinkServiceExternal;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.videotalk.emoji.model.TalkRoomEmojiListResponse;
import com.bytedance.android.live.room.IMicRoomService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.log.model.FollowLog;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.depend.model.follow.FollowPair;
import com.bytedance.android.livesdkapi.depend.model.live.OfficialChannelInfo;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import io.reactivex.disposables.CompositeDisposable;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class p extends q46.b<a> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f81967b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f81968c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f81969d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final CompositeDisposable f81970e;

    public interface a extends q46.a {
        void M40(FollowPair r100);

        void U2(Throwable r100);

        void j8(Throwable r100);

        void kH(TalkRoomEmojiListResponse r100);

        void q4(com.bytedance.android.live.liveinteract.voicechat.model.a r100);

        void za(Throwable r100);
    }

    @Override // q46.b
    public final void detachView() {
        this.f531633a = null;
        this.f81970e.clear();
    }

    public p() {
        this.f81970e = new CompositeDisposable();
    }

    public static void c0(Room r110, boolean r111, String r112, boolean r210) {
        Intrinsics.checkNotNullParameter(r110, "room");
        String r100 = "0";
        if (r112 != null) goto L5;
        String r101 = "0";
    L6:
        String r102 = "";
        FollowLog r103 = new FollowLog("", r101);
        IMicRoomService r104 = (IMicRoomService) jc1.k.f(IMicRoomService.class);
        String r105 = dl0.n.d();
        if (r104 != null) goto L9;
    L11:
        boolean r106 = false;
    L12:
        if (r104 == null) goto L17;
        if (r106 == false) goto L17;
        if (r104.isLoyalAudience() == false) goto L17;
        boolean r113 = true;
    L18:
        if (r106 == true) goto L20;
    L22:
        boolean r107 = false;
    L23:
        if (r106 == true) goto L25;
    L27:
        boolean r114 = false;
    L28:
        User r115 = r110.mo8271getOwner();
        if (r115 == null) goto L31;
        String r116 = r115.getIdStr();
    L33:
        if (Intrinsics.areEqual(r116, r101) == false) goto L35;
        char r108 = 0;
    L51:
        if (r210 == true) goto L53;
        if (r106 == false) goto L80;
        if (r108 == 0) goto L66;
        if (r108 != 3) goto L80;
    L66:
        if (r108 != 0) goto L73;
        if (r107 == false) goto L69;
        r103.f153382a = "carousel_host_c_anchor";
    L96:
        r103.f153382a = "pk_with_audience";
        HashMap r109 = new HashMap();
        if (r111 == false) goto L100;
        r109.put("growth_deepevent", String.valueOf(1));
    L100:
        if (((ILinkServiceExternal) jc1.k.n(ILinkServiceExternal.class)).getPkService().getPkState() != 1) goto L102;
        boolean r117 = true;
    L103:
        if (r117 == false) goto L105;
        r102 = String.valueOf(((ILinkServiceExternal) jc1.k.n(ILinkServiceExternal.class)).getMultiDataHolder().getPkId());
    L105:
        r109.put("pk_id", r102);
        if (r117 == false) goto L108;
        Object r118 = "1";
    L109:
        r109.put("is_in_pk", r118);
        o0.a r119 = o0.f58946a;
        User r120 = r110.mo8271getOwner();
        if (r120 == null) goto L112;
        String r121 = r120.getIdStr();
    L113:
        r119.getClass();
        if (o0.a.a(r101, r121) == false) goto L116;
        Object r122 = "1";
    L117:
        r109.put(IPerformanceManager.Params.is_anchor, r122);
        if (r111 == true) goto L120;
    L124:
        if (r111 == false) goto L126;
        HashMap r123 = new HashMap();
        r123.put("follow_type", "follow");
        r123.put("type", "native");
        LiveSlardarMonitor.monitorStatus("ttlive_monitor_profile_follow", 0, r123);
    L126:
        r109.putAll(h1.a(r110));
        r109.put("live_type", i1.a(r110.getStreamType()));
        el0.j.k(r109);
        if (r110.getAutoCover() == 0) goto L134;
        if (r110.getAutoCover() != 1) goto L131;
        String r124 = "autocover";
    L132:
        r109.put(ILiveRoomPlayFragmentConstant.EXTRA_COVER_TYPE, r124);
        goto L134
    L131:
        r124 = "other";
    L134:
        if (com.bytedance.android.livesdk.sharedpref.b.V.getValue().booleanValue() == false) goto L136;
        Object r125 = "1";
    L137:
        r109.put("is_screen_clear", r125);
        r109.put("follow_source", "emoji_panel");
        r109.put("connection_type", ((IInteractService) jc1.k.n(IInteractService.class)).getLinkConnectionType());
        r109.put("anchor_cnt", ((ILinkServiceExternal) jc1.k.n(ILinkServiceExternal.class)).getAnchorCount());
        r109.put("is_emoji_panel", "1");
        ILinkServiceExternal r126 = (ILinkServiceExternal) jc1.k.f(ILinkServiceExternal.class);
        if (r126 == null) goto L142;
        lc0.d r127 = r126.getPkService();
        if (r127 == null) goto L142;
        HashMap<String, String> r128 = r127.getFollowExtraParams(r101);
    L143:
        if (r128 == null) goto L145;
        r109.putAll(r128);
    L145:
        if (r111 == false) goto L155;
        RoomContext r129 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r129 == null) goto L153;
        com.bytedance.live.datacontext.m<Boolean> r130 = r129.isCleanMode();
        if (r130 == null) goto L153;
        if (r130.getValue().booleanValue() != true) goto L153;
        r100 = "1";
    L153:
        r109.put("if_clear_mode", r100);
    L155:
        if (e0.f65285a.getValue().booleanValue() == false) goto L157;
        r109.put(com.bytedance.android.ec.core.event.a.KEY_TO_USER_ID, r101);
    L157:
        com.bytedance.android.livesdk.log.g r131 = com.bytedance.android.livesdk.log.u.l();
        if (r111 == false) goto L160;
        String r132 = "livesdk_follow";
    L161:
        am2.x r133 = new am2.x();
        r133.f4349a = "live_interact";
        r133.f4350b = "live_detail";
        r131.sendLog(r132, r109, new Object[]{r103, am2.u.class, r133, Room.class, am2.n.f(), am2.q.class});
        return;
    L160:
        r132 = "livesdk_unfollow";
    L142:
        r128 = null;
        goto L143
    L136:
        r125 = "0";
        goto L137
    L120:
        if (((IBroadcastService) jc1.k.n(IBroadcastService.class)).isPlayingGame() == false) goto L122;
        Object r134 = "1";
    L123:
        r109.put("is_gaming", r134);
        goto L124
    L122:
        r134 = "0";
        goto L123
    L116:
        r122 = "0";
        goto L117
    L112:
        r121 = null;
        goto L113
    L108:
        r118 = "0";
        goto L109
    L102:
        r117 = false;
        goto L103
    L69:
        if (r113 == false) goto L71;
        String r135 = "loyal_audience_c_anchor";
    L72:
        r103.f153382a = r135;
        goto L96
    L71:
        r135 = "carousel_audience_c_anchor";
        goto L72
    L73:
        if (r108 != 3) goto L96;
        if (r107 == false) goto L76;
        r103.f153382a = "carousel_host_c_official_id";
        goto L96
    L76:
        if (r113 == false) goto L78;
        String r136 = "loyal_audience_c_official_id";
    L79:
        r103.f153382a = r136;
        goto L96
    L78:
        r136 = "carousel_audience_c_official_id";
    L80:
        if (r108 == 1) goto L83;
        r103.f153382a = "live_audience_c_anchor";
        goto L96
    L83:
        if (r106 == false) goto L89;
        if (r114 == false) goto L89;
        if (r113 == false) goto L87;
        String r137 = "loyal_audience_c_carousel_host";
    L88:
        r103.f153382a = r137;
    L94:
        if (TextUtils.isEmpty(r137) == false) goto L96;
        r103.f153382a = "live_audience_c_audience";
        goto L96
    L87:
        r137 = "carousel_audience_c_carousel_host";
    L89:
        r103.f153382a = "live_audience_c_audience";
        if (r103.f153384c != null) goto L92;
        r137 = "live_audience_c_audience";
        goto L94
    L92:
        r137 = null;
        goto L94
    L53:
        if (r106 == false) goto L56;
        if (r114 == false) goto L56;
        r103.f153382a = "anchor_c_carousel_host";
    L59:
        CharSequence r138 = null;
    L61:
        if (TextUtils.isEmpty(r138) == false) goto L96;
        r103.f153382a = "live_anchor_c_audience";
    L56:
        r103.f153382a = "live_anchor_c_audience";
        if (r103.f153384c != null) goto L59;
        r138 = "live_anchor_c_audience";
        goto L61
    L35:
        if (r104 != null) goto L37;
    L50:
        r108 = 1;
        goto L51
    L37:
        if (r104.isMicRoom(r110) == false) goto L50;
        OfficialChannelInfo r139 = r110.officialChannelInfo;
        if (r139 == null) goto L50;
        IBaseUser r140 = r139.getChannelUser();
        if ((r140 instanceof User) == true) goto L43;
        r140 = null;
    L43:
        User r141 = (User) r140;
        if (r141 == null) goto L46;
        String r142 = r141.getIdStr();
    L48:
        if (Intrinsics.areEqual(r142, r101) != true) goto L50;
        r108 = 3;
        goto L51
    L46:
        r142 = null;
        goto L48
    L31:
        r116 = null;
        goto L33
    L25:
        if (((IInteractService) jc1.k.n(IInteractService.class)).isMicRoomHost(r101) == false) goto L27;
        r114 = true;
        goto L28
    L20:
        if (((IInteractService) jc1.k.n(IInteractService.class)).isMicRoomHost(r105) == false) goto L22;
        r107 = true;
    L17:
        r113 = false;
        goto L18
    L9:
        if (r104.isMicRoom(r110) == false) goto L11;
        r106 = true;
        goto L12
    L5:
        r101 = r112;
        goto L6
    }
}
