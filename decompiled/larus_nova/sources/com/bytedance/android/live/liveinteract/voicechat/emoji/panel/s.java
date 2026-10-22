package com.bytedance.android.live.liveinteract.voicechat.emoji.panel;

import android.text.TextUtils;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.broadcast.api.IMiddlewareBroadcastService;
import com.bytedance.android.live.broadcastgame.api.interactgame.IAudienceGameDataService;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.LiveSlardarMonitor;
import com.bytedance.android.live.core.setting.b6;
import com.bytedance.android.live.core.utils.h1;
import com.bytedance.android.live.core.utils.i1;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.link.IMultiLinkServiceExternal;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.plantform.api.LinkApi;
import com.bytedance.android.live.liveinteract.plantform.model.ContributeShowResponse;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.live.room.IMiddlewareMicRoomService;
import com.bytedance.android.livesdk.chatroom.model.ILinkmicInteractEntrance;
import com.bytedance.android.livesdk.chatroom.model.j1;
import com.bytedance.android.livesdk.log.model.FollowLog;
import com.bytedance.android.livesdk.message.model.nd;
import com.bytedance.android.livesdk.utils.d5;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.depend.model.live.IOfficialChannelInfo;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.follow.IFollowPair;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.ss.android.downloadlib.constants.EventConstants;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class s extends q46.b<a> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f80238b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f80239c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f80240d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final CompositeDisposable f80241e;

    public interface a extends q46.a {
        void A2(List<? extends j1> r100);

        void B4();

        void G3(Throwable r100);

        void GN(IFollowPair r100);

        void U2(Throwable r100);

        void j8(Throwable r100);

        void j9(List<? extends ILinkmicInteractEntrance> r100);

        void q4(com.bytedance.android.live.liveinteract.voicechat.model.a r100);

        void ta(ContributeShowResponse.OwnerHonorInfo r100);

        void up(com.bytedance.android.live.liveinteract.videotalk.emoji.model.k r100);

        void za(Throwable r100);
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LinkApi.UpdateMcAction f80242a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f80243b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Function1 f80244c;

        public b(LinkApi.UpdateMcAction r100, String r101, Function1 r102) {
            this.f80242a = r100;
            this.f80243b = r101;
            this.f80244c = r102;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            com.bytedance.android.live.network.response.a r101 = (com.bytedance.android.live.network.response.a) r100;
            com.bytedance.live.datacontext.m<nd> r102 = com.bytedance.android.live.liveinteract.api.utils.m.d().q();
            if (r102 == null) goto L5;
            nd r103 = r102.getValue();
        L6:
            int r104 = t.f80249a[this.f80242a.ordinal()];
            int r105 = 1;
            if (r104 != 1) goto L9;
            if (r103 == null) goto L18;
            r105 = r103.f153673a;
        L18:
            if (r103 == null) goto L20;
            int r106 = r103.f153674b;
        L21:
            String r107 = this.f80243b;
            this.f80242a.ordinal();
            nd.b r108 = new nd.b(r105, r106, r107);
            com.bytedance.live.datacontext.m<nd> r109 = com.bytedance.android.live.liveinteract.api.utils.m.d().q();
            if (r109 == null) goto L24;
            r109.setValue(r108);
        L24:
            this.f80244c.invoke(r108);
            return;
        L20:
            r106 = 0;
            goto L21
        L9:
            if (r104 != 2) goto L14;
            if (r103 == null) goto L12;
            r105 = r103.f153673a;
            goto L18
        L12:
            r105 = -1;
            goto L18
        L14:
            throw new IllegalArgumentException("passed an error argument on action: " + this.f80242a.ordinal());
        L5:
            r103 = null;
            goto L6
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f80245a = null;

        static {
            f80245a = new c();
        }

        public c() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            ALogger.e("update_mc_status", "update_mc_status failed " + ((Throwable) r100));
        }
    }

    @Override // q46.b
    public final void detachView() {
        this.f531633a = null;
        this.f80241e.clear();
    }

    public s() {
        this.f80241e = new CompositeDisposable();
    }

    public final void d0(String r100, LinkApi.UpdateMcAction r110, Function1<? super nd.b, Unit> r111) {
        Intrinsics.checkNotNullParameter(r100, "userId");
        Intrinsics.checkNotNullParameter(r110, "action");
        Intrinsics.checkNotNullParameter(r111, "onSuccess");
        if (com.bytedance.android.live.liveinteract.api.utils.m.i() != null) goto L5;
        return;
    L5:
        LinkApi r101 = (LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class);
        com.bytedance.live.datacontext.m<IRoom> r102 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r102 == null) goto L10;
        IRoom r103 = r102.getValue();
        if (r103 == null) goto L10;
        long r104 = r103.getRoomId();
    L11:
        RxUtilKt.c(r101.updateMcStatus(r104, d5.c(r100), r100, r110.ordinal()).compose(RxUtil.rxSchedulerHelper()).subscribe(new b(r110, r100, r111), c.f80245a), this.f80241e);
        return;
    L10:
        r104 = 0;
        goto L11
    }

    public static void c0(IRoom r110, boolean r111, String r112, boolean r113) {
        Intrinsics.checkNotNullParameter(r110, "room");
        Intrinsics.checkNotNullParameter(r112, "userId");
        FollowLog r100 = new FollowLog("", r112.toString());
        IMiddlewareMicRoomService r101 = (IMiddlewareMicRoomService) jc1.k.f(IMiddlewareMicRoomService.class);
        String r102 = je0.d.b0();
        if (r101 != null) goto L5;
    L7:
        boolean r103 = false;
    L8:
        if (r101 == null) goto L13;
        if (r103 == false) goto L13;
        if (r101.isLoyalAudience() == false) goto L13;
        boolean r104 = true;
    L14:
        if (r103 == true) goto L16;
    L18:
        boolean r105 = false;
    L19:
        if (r103 == true) goto L21;
    L23:
        boolean r106 = false;
    L25:
        if (Intrinsics.areEqual(r110.getOwnerUserIdString(), r112) == false) goto L27;
        char r107 = 0;
    L40:
        if (r113 == true) goto L42;
        if (r103 == false) goto L69;
        if (r107 == 0) goto L55;
        if (r107 != 3) goto L69;
    L55:
        if (r107 != 0) goto L62;
        if (r105 == false) goto L58;
        r100.f153382a = "carousel_host_c_anchor";
    L85:
        HashMap r114 = new HashMap();
        if (r111 == false) goto L88;
        r114.put("growth_deepevent", String.valueOf(1));
    L88:
        String r108 = "0";
        if (Intrinsics.areEqual(r112, r110.getOwnerUserIdString()) == false) goto L91;
        Object r109 = "1";
    L92:
        r114.put(IPerformanceManager.Params.is_anchor, r109);
        if (r111 == true) goto L95;
    L99:
        if (r111 == false) goto L101;
        HashMap r115 = new HashMap();
        r115.put("follow_type", "follow");
        r115.put("type", "native");
        LiveSlardarMonitor.monitorStatus("ttlive_monitor_profile_follow", 0, r115);
    L101:
        r114.putAll(h1.a(r110));
        r114.put("live_type", i1.a(r110.getStreamType()));
        TalkRoomLogUtils.B0(r114, null, null, 6);
        if (r110.getAutoCover() == 0) goto L109;
        if (r110.getAutoCover() != 1) goto L106;
        String r116 = "autocover";
    L107:
        r114.put(ILiveRoomPlayFragmentConstant.EXTRA_COVER_TYPE, r116);
        goto L109
    L106:
        r116 = "other";
    L109:
        if (b6.X.getValue().booleanValue() == false) goto L111;
        Object r117 = "1";
    L112:
        r114.put("is_screen_clear", r117);
        IAudienceGameDataService r118 = (IAudienceGameDataService) jc1.k.f(IAudienceGameDataService.class);
        if (r118 == null) goto L115;
        r114.put("game_id", String.valueOf(r118.getCurrentGameId()));
        r114.put(EventConstants.ExtraJson.GAME_NAME, r118.getCurrentGameName());
    L115:
        r114.put("follow_source", "emoji_panel");
        r114.put("connection_type", ((IInteractService) jc1.k.n(IInteractService.class)).getLinkConnectionType());
        r114.put("anchor_cnt", ((IMultiLinkServiceExternal) jc1.k.n(IMultiLinkServiceExternal.class)).getLinkAnchorCountString());
        r114.put("is_emoji_panel", "1");
        if (r111 == false) goto L124;
        com.bytedance.live.datacontext.m<Boolean> r119 = com.bytedance.android.live.liveinteract.api.utils.m.i().isCleanMode();
        if (r119 != null) goto L120;
    L122:
        r114.put("if_clear_mode", r108);
        goto L124
    L120:
        if (r119.getValue().booleanValue() != true) goto L122;
        r108 = "1";
    L124:
        if (vm2.c.d() == false) goto L126;
        r114.put(com.bytedance.android.ec.core.event.a.KEY_TO_USER_ID, r112);
    L126:
        com.bytedance.android.livesdk.log.j0 r120 = com.bytedance.android.livesdk.log.j0.l();
        if (r111 == false) goto L129;
        String r121 = "livesdk_follow";
    L130:
        am2.x r122 = new am2.x();
        r122.f4349a = "live_interact";
        r122.f4350b = "live_detail";
        r120.sendLog(r121, r114, new Object[]{r100, am2.u.class, r122, IRoom.class, am2.n.f(), am2.q.class});
        return;
    L129:
        r121 = "livesdk_unfollow";
        goto L130
    L111:
        r117 = "0";
        goto L112
    L95:
        if (((IMiddlewareBroadcastService) va1.b.a.f553922a.a(IMiddlewareBroadcastService.class)).isPlayingGame() == false) goto L97;
        Object r123 = "1";
    L98:
        r114.put("is_gaming", r123);
        goto L99
    L97:
        r123 = "0";
        goto L98
    L91:
        r109 = "0";
        goto L92
    L58:
        if (r104 == false) goto L60;
        String r124 = "loyal_audience_c_anchor";
    L61:
        r100.f153382a = r124;
        goto L85
    L60:
        r124 = "carousel_audience_c_anchor";
        goto L61
    L62:
        if (r107 != 3) goto L85;
        if (r105 == false) goto L65;
        r100.f153382a = "carousel_host_c_official_id";
        goto L85
    L65:
        if (r104 == false) goto L67;
        String r125 = "loyal_audience_c_official_id";
    L68:
        r100.f153382a = r125;
        goto L85
    L67:
        r125 = "carousel_audience_c_official_id";
    L69:
        if (r107 == 1) goto L72;
        r100.f153382a = "live_audience_c_anchor";
        goto L85
    L72:
        if (r103 == false) goto L78;
        if (r106 == false) goto L78;
        if (r104 == false) goto L76;
        String r126 = "loyal_audience_c_carousel_host";
    L77:
        r100.f153382a = r126;
    L83:
        if (TextUtils.isEmpty(r126) == false) goto L85;
        r100.f153382a = "live_audience_c_audience";
        goto L85
    L76:
        r126 = "carousel_audience_c_carousel_host";
    L78:
        r100.f153382a = "live_audience_c_audience";
        if (r100.f153384c != null) goto L81;
        r126 = "live_audience_c_audience";
        goto L83
    L81:
        r126 = null;
        goto L83
    L42:
        if (r103 == false) goto L45;
        if (r106 == false) goto L45;
        r100.f153382a = "anchor_c_carousel_host";
    L48:
        CharSequence r127 = null;
    L50:
        if (TextUtils.isEmpty(r127) == false) goto L85;
        r100.f153382a = "live_anchor_c_audience";
    L45:
        r100.f153382a = "live_anchor_c_audience";
        if (r100.f153384c != null) goto L48;
        r127 = "live_anchor_c_audience";
        goto L50
    L27:
        if (r101 != null) goto L29;
    L39:
        r107 = 1;
        goto L40
    L29:
        if (r101.isMicRoom(r110) == false) goto L39;
        IOfficialChannelInfo r128 = r110.getOfficialChannelInfo();
        if (r128 == null) goto L39;
        IBaseUser r129 = r128.getChannelUser();
        if (r129 == null) goto L35;
        String r130 = r129.getIdString();
    L37:
        if (Intrinsics.areEqual(r130, r112) != true) goto L39;
        r107 = 3;
        goto L40
    L35:
        r130 = null;
        goto L37
    L21:
        if (((IInteractService) jc1.k.n(IInteractService.class)).isMicRoomHost(r112) == false) goto L23;
        r106 = true;
        goto L25
    L16:
        if (((IInteractService) jc1.k.n(IInteractService.class)).isMicRoomHost(r102) == false) goto L18;
        r105 = true;
    L13:
        r104 = false;
        goto L14
    L5:
        if (r101.isMicRoom(r110) == false) goto L7;
        r103 = true;
        goto L8
    }
}
