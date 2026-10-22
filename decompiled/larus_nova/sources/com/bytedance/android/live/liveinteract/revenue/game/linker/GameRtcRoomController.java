package com.bytedance.android.live.liveinteract.revenue.game.linker;

import am2.x;
import ch0.e;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.utils.m;
import com.bytedance.android.live.liveinteract.plantform.base.i;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.livesdk.chatroom.model.interact.GameBarrageRtcInfo;
import com.bytedance.android.livesdk.chatroom.t;
import com.bytedance.android.livesdk.chatroom.widget.j1;
import com.bytedance.android.livesdk.link.model.bridge.g2;
import com.bytedance.android.livesdk.link.model.bridge.v1;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedStreamIndex;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.live.LiveWrappedMixedStreamVideoType;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type.LiveWrappedRoomProfile;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.live.datacontext.j;
import com.bytedance.live.livelink.kmp.api.base.event.EventCategory;
import com.lynx.xelement.viewpager.childitem.LynxViewpagerItem;
import com.ss.android.downloadlib.constants.EventConstants;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import jc1.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import vb6.g;
import vlc.d;
import vlc.l;

/* JADX INFO: loaded from: classes46.dex */
public abstract class GameRtcRoomController implements c {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ int f78359m = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f78360a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f78361b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f78362c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public li6.c f78363d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f78364e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public d f78365f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f78366g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final HashSet<String> f78367h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Set<String> f78368i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public List<e> f78369j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f78370k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final j1 f78371l;

    public static final class a {
    }

    public static final class b extends vb6.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GameRtcRoomController f78372a;

        @Override // vb6.a, vb6.f
        public final void H1() {
            StringBuilder r100 = new StringBuilder("onLinkSuccess, gameRtcExtInfo: ");
            v1 r101 = tc0.c.h().f545357n;
            if (r101 == null) goto L7;
            GameBarrageRtcInfo r102 = r101.getGameBarrageRtcInfo();
            if (r102 == null) goto L7;
            String r103 = r102.getRtcExtInfo();
        L8:
            r100.append(r103);
            ALogger.i("GameRtcRoomController", r100.toString());
            v1 r104 = tc0.c.h().f545357n;
            if (r104 == null) goto L26;
            GameBarrageRtcInfo r105 = r104.getGameBarrageRtcInfo();
            if (r105 == null) goto L27;
            cg6.a r106 = this.f78372a.d();
            if (r106 == null) goto L28;
            g r107 = r106.O5();
            if (r107 == null) goto L29;
            yb6.e r108 = r107.j();
            if (r108 == null) goto L30;
            ei6.a r109 = r108.Z0();
            if (r109 == null) goto L31;
            li6.a r110 = r109.e();
            if (r110 == null) goto L32;
            li6.c r111 = r110.b(r105.getRtcExtInfo());
            if (r111 == null) goto L33;
            GameRtcRoomController r112 = this.f78372a;
            long r113 = r105.getLinkerId();
            r112.getClass();
            Intrinsics.checkNotNullParameter(r111, "rtcExtInfo");
            ALogger.i("GameRtcRoomController", "onLinkSuccess");
            r112.g(r113, r111, "onLinkSuccess");
            return;
        L33:
            return;
        L32:
            return;
        L31:
            return;
        L30:
            return;
        L29:
            return;
        L28:
            return;
        L27:
            return;
        L26:
            return;
        L7:
            r103 = null;
            goto L8
        }

        @Override // vb6.a, vb6.f
        public final void M1() {
            ALogger.i("GameRtcRoomController", "onEndSuccess");
            GameRtcRoomController r100 = this.f78372a;
            r100.getClass();
            ALogger.i("GameRtcRoomController", "onLinkEnd");
            if (r100.f78361b == true) goto L5;
            return;
        L5:
            if (je0.d.D() == false) goto L7;
            String r101 = "退出聊天室";
        L8:
            r100.h("onLinkEnd", r101);
            return;
        L7:
            r101 = "嘉宾下麦";
            goto L8
        }

        @Override // vb6.a, vb6.f
        public final void ra() {
            ALogger.i("GameRtcRoomController", "onLinkServiceDetach");
            GameRtcRoomController r100 = this.f78372a;
            r100.getClass();
            ALogger.i("GameRtcRoomController", "onLinkEnd");
            if (r100.f78361b == true) goto L5;
            return;
        L5:
            if (je0.d.D() == false) goto L7;
            String r101 = "退出聊天室";
        L8:
            r100.h("onLinkEnd", r101);
            return;
        L7:
            r101 = "嘉宾下麦";
            goto L8
        }

        public b(GameRtcRoomController r100) {
            this.f78372a = r100;
        }
    }

    static {
    }

    public void j(String r100, String r101, boolean r102) {
    }

    @Override // com.bytedance.android.live.liveinteract.revenue.game.linker.c
    public void attach() {
        ALogger.i("GameRtcRoomController", LynxViewpagerItem.BIND_ON_ATTACH);
        t r100 = m.b();
        if (r100 == null) goto L7;
        j<d> r101 = r100.getMessageManager();
        if (r101 == null) goto L7;
        d r102 = r101.getValue();
    L8:
        this.f78365f = r102;
        if (r102 == null) goto L11;
        r102.addMessageListener(MessageType.LINK_MIC.getIntType(), (l) this.f78370k.getValue());
    L11:
        d r103 = this.f78365f;
        if (r103 == null) goto L14;
        r103.addMessageListener(MessageType.ANCHOR_LINK_GAME_VOICE_MESSAGE.getKey(), (l) this.f78370k.getValue());
    L14:
        cg6.a r104 = d();
        if (r104 == null) goto L20;
        g r105 = r104.O5();
        if (r105 == null) goto L21;
        r105.X0(new b(this), true);
        return;
    L21:
        return;
    L20:
        return;
    L7:
        r102 = null;
        goto L8
    }

    public final String c() {
        li6.c r100 = this.f78363d;
        if (r100 == null) goto L7;
        li6.b r101 = r100.f509384c;
        if (r101 == null) goto L7;
        String r102 = r101.f509375b;
    L9:
        return String.valueOf(r102);
    L7:
        r102 = null;
        goto L9
    }

    public final cg6.a d() {
        return (cg6.a) this.f78371l.getScopeServiceOrNullInMultiLinkRoom(cg6.a.class);
    }

    @Override // com.bytedance.android.live.liveinteract.revenue.game.linker.c
    public void detach() {
        ALogger.i("GameRtcRoomController", "detach");
        d r100 = this.f78365f;
        if (r100 == null) goto L6;
        r100.removeMessageListener((l) this.f78370k.getValue());
    L6:
        if (this.f78361b == false) goto L9;
        h("linkmicClose", "退出聊天室");
        return;
    }

    public final void k() {
        if (this.f78361b == false) goto L6;
        h("onGameUnload", "主播关玩法");
        return;
    }

    public void l() {
        ALogger.i("GameRtcRoomController", "onJoinGameRtcRoomSuccess");
        List<e> r100 = this.f78369j;
        if (r100 == null) goto L5;
        n(r100, "onJoinGameRtcRoomSuccess");
    L5:
        String r101 = qi0.c.f533088b;
        long r102 = this.f78364e;
        qi0.c.f533088b = qi0.c.i();
        qi0.c.f533089c = qi0.c.j();
        LinkedHashMap r103 = new LinkedHashMap();
        r103.put("link_id", String.valueOf(r102));
        r103.put("game_id", qi0.c.i());
        r103.put(EventConstants.ExtraJson.GAME_NAME, qi0.c.j());
        r103.put("user_id", gh0.a.c());
        if (je0.d.r() == false) goto L8;
        String r104 = "anchor";
    L9:
        r103.put("user_type", r104);
        ALogger.i("LinkMicGameLogUtil", "onBarrageMatchGameStart: " + r103);
        j0.l().sendLog("livesdk_barrage_match_game_start", r103, new Object[]{IRoom.class, x.class});
        return;
    L8:
        r104 = "guest";
        goto L9
    }

    public void m() {
        ALogger.i("GameRtcRoomController", "onleaveGameRtcRoom");
        Iterator<String> r100 = this.f78368i.iterator();
    L4:
        if (r100.hasNext() == false) goto L14;
        String r101 = r100.next();
        cg6.a r102 = d();
        if (r102 == null) goto L4;
        hg6.g r103 = r102.getRtcManager();
        if (r103 == null) goto L4;
        ei6.a r104 = r103.V0();
        if (r104 == null) goto L4;
        gi6.e r105 = r104.getEventManager();
        if (r105 == null) goto L4;
        r105.c(r101);
        goto L4
    L14:
        this.f78368i.clear();
        this.f78361b = false;
        this.f78362c = null;
        f();
    }

    public static String b() {
        return e(je0.d.a());
    }

    public final void f() {
        if (je0.d.D() == false) goto L14;
        cg6.a r100 = d();
        if (r100 == null) goto L15;
        hg6.g r101 = r100.getRtcManager();
        if (r101 == null) goto L16;
        ei6.a r102 = r101.V0();
        if (r102 == null) goto L17;
        ALogger.i("GameRtcRoomController", "invalidateSei");
        vi6.a r103 = r102.v();
        if (r103 == null) goto L18;
        r103.f();
        return;
    L18:
        return;
    L17:
        return;
    L16:
        return;
    L15:
        return;
    }

    public GameRtcRoomController(j1 r100) {
        Intrinsics.checkNotNullParameter(r100, "outerScopeProvider");
        this.f78371l = r100;
        this.f78367h = new HashSet();
        this.f78368i = new LinkedHashSet();
        this.f78370k = LazyKt.lazy(new GameRtcRoomController$mOnMessageListener$2(this));
    }

    public static String e(String r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        IInteractService r101 = (IInteractService) k.f(IInteractService.class);
        if (r101 == null) goto L19;
        i<ILinkPlayerInfoBridge> r102 = r101.getLinkUserInfoCenter();
        if (r102 == null) goto L19;
        ILinkPlayerInfoBridge r103 = (ILinkPlayerInfoBridge) r102.a5(r100, null);
        if (r103 == null) goto L19;
        String r104 = r103.getInteractId();
        if (r104 == null) goto L19;
        if (r104.length() <= 0) goto L16;
        boolean r105 = true;
    L17:
        if (r105 == false) goto L19;
        return r104;
    L16:
        r105 = false;
    L19:
        Map<Long, ? extends g2> r106 = tc0.c.h().f545358o;
        if (r106 == null) goto L37;
        Iterator<Map.Entry<Long, ? extends g2>> r107 = r106.entrySet().iterator();
    L23:
        if (r107.hasNext() == false) goto L37;
        List<com.bytedance.android.livesdk.link.model.bridge.k> r108 = r107.next().getValue().getLinkedUsers();
        if (r108 == null) goto L23;
        Iterator<T> r109 = r108.iterator();
    L28:
        if (r109.hasNext() == false) goto L23;
        com.bytedance.android.livesdk.link.model.bridge.k r110 = (com.bytedance.android.livesdk.link.model.bridge.k) r109.next();
        IBaseUser r111 = r110.getUser();
        if (r111 == null) goto L32;
        String r112 = r111.getIdString();
    L34:
        if (Intrinsics.areEqual(r112, r100) == false) goto L28;
        return r110.getInteractId();
    L32:
        r112 = null;
    L37:
        return null;
    }

    @Override // com.bytedance.android.live.liveinteract.revenue.game.linker.c
    public void a(boolean r100) {
        ALogger.i("GameRtcRoomController", "onIsXplayRunningChange: " + r100);
        this.f78360a = r100;
    }

    public final void h(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "source");
        if (this.f78361b == true) goto L5;
        return;
    L5:
        ALogger.i("GameRtcRoomController", "leaveGameRtcRoom, source: " + r100 + ", endReason: " + r101);
        this.f78361b = false;
        this.f78362c = null;
        this.f78367h.clear();
        String r102 = qi0.c.f533088b;
        long r103 = this.f78364e;
        Intrinsics.checkNotNullParameter(r101, "endReason");
        LinkedHashMap r104 = new LinkedHashMap();
        r104.put("link_id", String.valueOf(r103));
        r104.put("game_id", qi0.c.i());
        r104.put(EventConstants.ExtraJson.GAME_NAME, qi0.c.j());
        r104.put("user_id", gh0.a.c());
        if (je0.d.r() == false) goto L8;
        String r105 = "anchor";
    L9:
        r104.put("user_type", r105);
        r104.put("end_reason", r101);
        ALogger.i("LinkMicGameLogUtil", "onBarrageMatchGameEnd: " + r104);
        j0.l().sendLog("livesdk_barrage_match_game_end", r104, new Object[]{IRoom.class, x.class});
        cg6.a r106 = d();
        if (r106 == null) goto L14;
        hg6.g r107 = r106.getRtcManager();
        if (r107 == null) goto L14;
        ei6.a r108 = r107.V0();
    L15:
        if (r108 != null) goto L18;
        ALogger.e("GameRtcRoomController", "leaveGameRtcRoom return, cause: Client is null");
        return;
    L18:
        cg6.a r109 = d();
        if (r109 == null) goto L27;
        hg6.g r110 = r109.getRtcManager();
        if (r110 == null) goto L27;
        ei6.a r111 = r110.V0();
        if (r111 == null) goto L27;
        ui6.d r112 = r111.l();
        if (r112 == null) goto L27;
        mi6.a r113 = r112.b();
    L28:
        if (r113 != null) goto L31;
        ALogger.i("GameRtcRoomController", "leaveGameRtcRoom return, cause: Client#rtcEngine is null");
        return;
    L31:
        cg6.a r114 = d();
        if (r114 == null) goto L51;
        hg6.g r115 = r114.getRtcManager();
        if (r115 == null) goto L51;
        ei6.a r116 = r115.V0();
        if (r116 == null) goto L51;
        si6.b r117 = r116.b();
        if (r117 == null) goto L40;
        r117.h(c(), String.valueOf(this));
    L40:
        ti6.d r118 = r116.p();
        if (r118 == null) goto L43;
        r118.a(c(), null);
    L43:
        ri6.b r119 = r116.r();
        if (r119 == null) goto L47;
        r119.c(false);
    L47:
        if (je0.d.D() == true) goto L51;
        ri6.b r120 = r116.r();
        if (r120 == null) goto L51;
        r120.D(bj6.a.b(r116), LiveWrappedStreamIndex.STREAM_INDEX_MAIN, String.valueOf(b()), 100);
    L51:
        m();
        return;
    L27:
        r113 = null;
    L14:
        r108 = null;
        goto L15
    L8:
        r105 = "guest";
        goto L9
    }

    public final void n(List<e> r110, String r111) {
        Intrinsics.checkNotNullParameter(r110, "mergeDataList");
        Intrinsics.checkNotNullParameter(r111, "source");
        this.f78369j = r110;
        if (this.f78361b == false) goto L22;
        ALogger.d("GameRtcRoomController", "updateCrossRoomSilenceState, source: ".concat(r111));
        Iterator<T> r112 = r110.iterator();
    L6:
        if (r112.hasNext() == false) goto L32;
        ILinkPlayerInfoBridge r100 = ((e) r112.next()).f23724a;
        Intrinsics.checkNotNullParameter(r100, "linkPlayerInfo");
        Intrinsics.checkNotNullParameter(r111, "reason");
        if (r100.getRoomLinkSilenceStatus() != 1) goto L10;
        boolean r101 = true;
    L11:
        String r102 = r100.getInteractId();
        if (r102 == null) goto L6;
        if (r101 == false) goto L18;
        Intrinsics.checkNotNullParameter(r102, "interactId");
        if (this.f78367h.contains(r102) == true) goto L18;
        ALogger.i("GameRtcRoomController", "checkAndDoMuteRemoteAVStream, interactId: " + r102 + ", currentSilence: true, reason: " + r111);
        i(r102, true, r111);
    L18:
        if (r101 == true) goto L6;
        Intrinsics.checkNotNullParameter(r102, "interactId");
        if (this.f78367h.contains(r102) == false) goto L6;
        ALogger.i("GameRtcRoomController", "checkAndDoMuteRemoteAVStream, interactId: " + r102 + ", currentSilence: false, reason: " + r111);
        i(r102, false, r111);
        goto L6
    L10:
        r101 = false;
        goto L11
    L32:
        return;
    }

    public final void g(long r110, li6.c r111, String r112) {
        Intrinsics.checkNotNullParameter(r111, "rtcExtInfo");
        Intrinsics.checkNotNullParameter(r112, "source");
        StringBuilder r100 = new StringBuilder("joinGameRtcRoom, source: ");
        r100.append(r112);
        r100.append(", linkerId: ");
        r100.append(r110);
        r100.append(", rtcRoomId: ");
        li6.b r113 = r111.f509384c;
        String r101 = null;
        if (r113 == null) goto L5;
        String r114 = r113.f509375b;
    L6:
        r100.append(r114);
        r100.append(", rtcUserId: ");
        li6.b r115 = r111.f509384c;
        if (r115 == null) goto L9;
        String r116 = r115.f509378e;
    L10:
        r100.append(r116);
        ALogger.i("GameRtcRoomController", r100.toString());
        cg6.a r117 = d();
        if (r117 == null) goto L15;
        hg6.g r118 = r117.getRtcManager();
        if (r118 == null) goto L15;
        ei6.a r119 = r118.V0();
    L16:
        if (r119 != null) goto L19;
        ALogger.e("GameRtcRoomController", "joinGameRtcRoom failed, cause: Client is null");
        return;
    L19:
        cg6.a r120 = d();
        if (r120 == null) goto L28;
        hg6.g r121 = r120.getRtcManager();
        if (r121 == null) goto L28;
        ei6.a r122 = r121.V0();
        if (r122 == null) goto L28;
        ui6.d r123 = r122.l();
        if (r123 == null) goto L28;
        mi6.a r124 = r123.b();
    L29:
        if (r124 != null) goto L32;
        ALogger.e("GameRtcRoomController", "joinGameRtcRoom failed, cause: Client#rtcEngine is null");
        return;
    L32:
        cg6.a r125 = d();
        if (r125 == null) goto L37;
        hg6.g r126 = r125.getRtcManager();
        if (r126 == null) goto L37;
        ei6.a r127 = r126.V0();
    L39:
        if (r127 == null) goto L58;
        cg6.a r128 = d();
        if (r128 == null) goto L49;
        hg6.g r129 = r128.getRtcManager();
        if (r129 == null) goto L49;
        ei6.a r130 = r129.V0();
        if (r130 == null) goto L49;
        ui6.d r131 = r130.l();
        if (r131 == null) goto L49;
        mi6.a r132 = r131.b();
    L50:
        if (r132 == null) goto L58;
        cg6.a r133 = d();
        if (r133 == null) goto L58;
        hg6.g r134 = r133.getRtcManager();
        if (r134 == null) goto L58;
        if (r134.isEngineOn() != true) goto L58;
        boolean r135 = true;
    L59:
        if (r135 == true) goto L63;
        ALogger.e("GameRtcRoomController", "joinGameRtcRoom failed, cause: MultiLink#isLinkMicRtcEngineOn is false");
        return;
    L63:
        if (this.f78361b == false) goto L73;
        String r136 = this.f78362c;
        li6.b r102 = r111.f509384c;
        if (r102 == null) goto L67;
        String r103 = r102.f509375b;
    L69:
        if (Intrinsics.areEqual(r136, r103) == false) goto L72;
        ALogger.i("GameRtcRoomController", "joinGameRtcRoom return, cause: already join");
        return;
    L72:
        h("joinGameRtcRoom", "加入新的主主连线");
        goto L73
    L67:
        r103 = null;
    L73:
        cg6.a r137 = d();
        if (r137 == null) goto L123;
        hg6.g r138 = r137.getRtcManager();
        if (r138 == null) goto L124;
        ei6.a r139 = r138.V0();
        if (r139 == null) goto L125;
        this.f78364e = r110;
        this.f78367h.clear();
        yf2.d r140 = new yf2.d(LiveWrappedRoomProfile.LIVE, false, false, true, false);
        gi6.e r141 = r139.getEventManager();
        if (r141 == null) goto L84;
        String r142 = r141.a(EventCategory.RTC_ROOM_EVENT, null, new GameRtcRoomController$initRTCRoomEventObserver$1(this));
        if (r142 == null) goto L84;
        this.f78368i.add(r142);
    L84:
        gi6.e r143 = r139.getEventManager();
        if (r143 == null) goto L89;
        String r144 = r143.a(EventCategory.RTC_ROOM_EVENT_EX, null, new GameRtcRoomController$initRTCRoomEventObserver$2(this));
        if (r144 == null) goto L89;
        this.f78368i.add(r144);
    L89:
        this.f78363d = r111;
        si6.b r104 = r139.b();
        if (r104 == null) goto L106;
        li6.b r145 = r111.f509384c;
        if (r145 == null) goto L94;
        String r146 = r145.f509375b;
    L95:
        String r105 = String.valueOf(r146);
        li6.b r147 = r111.f509384c;
        if (r147 == null) goto L98;
        String r148 = r147.f509377d;
    L99:
        String r106 = String.valueOf(r148);
        li6.b r149 = r111.f509384c;
        if (r149 == null) goto L104;
        String r150 = r149.f509378e;
        if (r150 == null) goto L104;
    L105:
        r104.e(r105, r106, new yf2.e(r150, ""), true, r140);
    L104:
        r150 = "";
        goto L105
    L98:
        r148 = null;
        goto L99
    L94:
        r146 = null;
    L106:
        ri6.b r151 = r139.r();
        if (r151 == null) goto L113;
        li6.b r152 = r111.f509384c;
        if (r152 == null) goto L111;
        String r153 = r152.f509375b;
    L112:
        String r154 = String.valueOf(r153);
        LiveWrappedStreamIndex r107 = LiveWrappedStreamIndex.STREAM_INDEX_3RD;
        zf2.d r108 = new zf2.d();
        r108.f571699a = true;
        r108.f571701c = false;
        r108.f571700b = false;
        Unit r109 = Unit.INSTANCE;
        r151.r(r154, r107, r108);
        goto L113
    L111:
        r153 = null;
    L113:
        ti6.d r155 = r139.p();
        if (r155 == null) goto L119;
        li6.b r156 = r111.f509384c;
        if (r156 == null) goto L118;
        r101 = r156.f509375b;
    L118:
        r155.a(String.valueOf(r101), new ti6.i(bj6.a.b(r139), LiveWrappedMixedStreamVideoType.MIXED_STREAM_VIDEO_TYPE_3RD));
    L119:
        ri6.b r157 = r139.r();
        if (r157 == null) goto L126;
        r157.c(true);
        return;
    L126:
        return;
    L125:
        return;
    L124:
        return;
    L123:
        return;
    L49:
        r132 = null;
    L58:
        r135 = false;
    L37:
        r127 = null;
    L28:
        r124 = null;
    L15:
        r119 = null;
        goto L16
    L9:
        r116 = null;
        goto L10
    L5:
        r114 = null;
        goto L6
    }

    public final void i(String r100, boolean r110, String r111) {
        Intrinsics.checkNotNullParameter(r100, "interactId");
        Intrinsics.checkNotNullParameter(r111, "reason");
        ALogger.i("GameRtcRoomController", "muteGameRtcRoomRemoteAudioStream, interactId: " + r100 + ", mute: " + r110 + ", reason: " + r111);
        cg6.a r101 = d();
        if (r101 == null) goto L7;
        hg6.g r102 = r101.getRtcManager();
        if (r102 == null) goto L7;
        ei6.a r103 = r102.V0();
    L8:
        if (r103 != null) goto L11;
        ALogger.w("GameRtcRoomController", "muteGameRtcRoomRemoteAudioStream return, cause: client is null");
        return;
    L11:
        if (r110 == false) goto L13;
        this.f78367h.add(r100);
    L14:
        ri6.b r104 = r103.r();
        if (r104 == null) goto L18;
        r104.l(c(), LiveWrappedStreamIndex.STREAM_INDEX_3RD, r100, r110, r111);
        return;
    L18:
        return;
    L13:
        this.f78367h.remove(r100);
    L7:
        r103 = null;
        goto L8
    }
}
