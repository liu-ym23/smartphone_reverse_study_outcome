package com.bytedance.android.live.broadcastgame.opengame.openapi;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.broadcastgame.opengame.runtime.BootInfoService;
import com.bytedance.android.live.broadcastgame.opengame.runtime.PluginContext;
import com.bytedance.android.live.broadcastgame.opengame.service.TrackMiniGameService;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.profit.scoreboard.LinkMode;
import com.bytedance.android.live.profit.scoreboard.m1;
import com.bytedance.android.live.revlink.api.ILinkService;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import java.util.Queue;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
public final class b1 extends BaseOpenMethod<JSONObject> {

    public static final class a implements m1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b1 f60373a;

        public a(b1 r100) {
            this.f60373a = r100;
        }

        @Override // com.bytedance.android.live.profit.scoreboard.m1
        public final void onSuccess(String r100) {
            Intrinsics.checkNotNullParameter(r100, "counterId");
            b1 r101 = this.f60373a;
            JSONObject r102 = new JSONObject();
            r102.put("counter_id", r100);
            Unit r103 = Unit.INSTANCE;
            r101.r(r102);
            this.f60373a.f60306d.f60807k.a();
        }

        @Override // com.bytedance.android.live.profit.scoreboard.m1
        public final void onFailed(int r100, String r101) {
            Intrinsics.checkNotNullParameter(r101, "errorMsg");
            BaseOpenMethod.p(this.f60373a, r100, r101, null, 12);
        }
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.openapi.BaseOpenMethod
    public final String getMethodName() {
        return "startCounter";
    }

    public b1(PluginContext r100, Queue<Long> r101) {
        Intrinsics.checkNotNullParameter(r100, "pluginContext");
        super(r100, r101);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public void call2(JSONObject r210, CallContext r211) {
        Intrinsics.checkNotNullParameter(r210, "params");
        Intrinsics.checkNotNullParameter(r211, PerfLog.PARAM_KEY_CONTEXT_ID);
        int r100 = r210.optInt("duration", 0);
        r210.optLong("other_room_id", 0);
        JSONObject r101 = r210.optJSONObject("counter_settings");
        String r110 = r210.optString("prev_counter_id", "0");
        int r102 = r210.optInt("link_mode", 0);
        if (r102 == 1) goto L7;
        if (r102 == 2) goto L6;
        LinkMode r103 = LinkMode.UN_KNOW;
    L9:
        if (r101 == null) goto L11;
    L14:
        a r111 = new a(this);
        RoomContext r104 = RoomContext.a.c(RoomContext.Companion, this.f60306d.f60805i, 0, 2);
        if (r104 == null) goto L21;
        com.bytedance.live.datacontext.m<Room> r105 = r104.getRoom();
        if (r105 == null) goto L21;
        Room r106 = r105.getValue();
        if (r106 == null) goto L21;
        String r107 = r106.getOwnerUserIdString();
    L22:
        String r108 = ((IUserService) jc1.k.n(IUserService.class)).user().b().getIdString();
        if ((!Intrinsics.areEqual(((IInteractService) jc1.k.n(IInteractService.class)).getCurrentSwitchSceneSource(), "accepted_tool_invited")) == false) goto L40;
        TrackMiniGameService.a r109 = TrackMiniGameService.f60990g;
        String r112 = String.valueOf(this.f60306d.f60809m.f61075a);
        boolean r113 = this.f60306d.f60811o;
        String r114 = String.valueOf(r107);
        String r115 = String.valueOf(this.f60306d.f60809m.f61082h);
        PluginContext r116 = this.f60306d;
        String r117 = r116.f60809m.b(r116.f60811o);
        String r118 = ((BootInfoService) this.f60306d.o(BootInfoService.class)).e();
        PluginContext r119 = this.f60306d;
        if (r119 == null) goto L29;
        com.bytedance.android.live.broadcastgame.opengame.t r120 = r119.f60809m;
        if (r120 == null) goto L29;
        String r212 = r120.f61083i;
    L30:
        r109.getClass();
        Intrinsics.checkNotNullParameter(r112, "roomId");
        Intrinsics.checkNotNullParameter(r114, "anchorId");
        Intrinsics.checkNotNullParameter(r108, "userId");
        Intrinsics.checkNotNullParameter(r115, "gameId");
        Intrinsics.checkNotNullParameter(r117, "gameName");
        Intrinsics.checkNotNullParameter(r118, "gameCategory");
        if (Intrinsics.areEqual(((IInteractService) jc1.k.n(IInteractService.class)).getCurrentSwitchSceneSource(), "accepted_tool_invited") == false) goto L33;
        String r121 = "invited";
    L34:
        String r213 = r121;
        com.bytedance.android.livesdk.log.g r122 = com.bytedance.android.livesdk.log.u.l();
        Boolean r214 = Boolean.valueOf(r113);
        boolean r123 = com.bytedance.android.live.revenue.core.util.h.f91037a;
        kc0.e r124 = ((ILinkService) com.bytedance.android.live.revenue.core.util.h.d(ILinkService.class)).getRevLinkControlService();
        if (r124 == null) goto L37;
        Map<String, String> r215 = r124.h();
    L38:
        r122.sendLog("livesdk_game_half_screen_click", TrackMiniGameService.a.a(r114, r108, r115, r117, r118, r112, r214, r212, r213, r215), new Object[]{am2.x.class, Room.class});
        goto L40
    L37:
        r215 = null;
        goto L38
    L33:
        r121 = "self_start";
    L29:
        r212 = null;
    L40:
        if (r101 == 0) goto L43;
        com.bytedance.android.live.profit.scoreboard.c r125 = (com.bytedance.android.live.profit.scoreboard.c) GsonProtectorUtils.fromJson(GsonHelper.get(), r101.toString(), com.bytedance.android.live.profit.scoreboard.c.class);
        boolean r126 = com.bytedance.android.live.revenue.core.util.h.f91037a;
        ((com.bytedance.android.live.profit.scoreboard.h) com.bytedance.android.live.revenue.core.util.h.d(com.bytedance.android.live.profit.scoreboard.h.class)).S(this.f60306d.f60809m.f61083i, r103, r100, r125, "0", r111);
    L43:
        if ((!Intrinsics.areEqual(r110, "0")) == false) goto L46;
        boolean r127 = com.bytedance.android.live.revenue.core.util.h.f91037a;
        ((com.bytedance.android.live.profit.scoreboard.h) com.bytedance.android.live.revenue.core.util.h.d(com.bytedance.android.live.profit.scoreboard.h.class)).S(this.f60306d.f60809m.f61083i, LinkMode.UN_KNOW, r100, null, r110, r111);
        return;
    L46:
        return;
    L21:
        r107 = null;
        goto L22
    L11:
        if (Intrinsics.areEqual(r110, "0") == false) goto L14;
        BaseOpenMethod.p(this, -1, "counter_settings is null and prev_counter_id = 0", null, 12);
        return;
    L6:
        r103 = LinkMode.TWIN;
        goto L9
    L7:
        r103 = LinkMode.SINGlE;
        goto L9
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.openapi.BaseOpenMethod
    public /* bridge */ /* synthetic */ void call(JSONObject r100, CallContext r101) {
        call2(r100, r101);
    }
}
