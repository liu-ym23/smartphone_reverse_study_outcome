package com.bytedance.android.livesdk.dislike.action;

import android.view.View;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.broadcast.api.IBroadcastService;
import com.bytedance.android.live.broadcastgame.api.AudienceGameContext;
import com.bytedance.android.live.core.utils.h1;
import com.bytedance.android.live.core.utils.i1;
import com.bytedance.android.live.link.ILinkServiceExternal;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.utils.VrUtils;
import com.bytedance.android.livesdk.chatroom.utils.k1;
import com.bytedance.android.livesdk.config.sr;
import com.bytedance.android.livesdk.dislike.ActionsManager;
import com.bytedance.android.livesdk.dispatch.utils.DispatchLogUtil;
import com.bytedance.android.livesdk.log.model.FollowLog;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.ss.android.downloadlib.constants.EventConstants;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.util.HashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class FollowAction extends OptionAction {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ActionsManager f122043e;

    @Override // com.bytedance.android.livesdk.dislike.action.OptionAction
    public final cz.c f() {
        return cz.c.g.f466001c;
    }

    public FollowAction(ActionsManager r100) {
        Intrinsics.checkNotNullParameter(r100, "actionsManager");
        super(r100);
        this.f122043e = r100;
    }

    @Override // com.bytedance.android.livesdk.dislike.action.OptionAction
    public final void a(View r110) {
        Intrinsics.checkNotNullParameter(r110, BaseSwitches.V);
        if (com.bytedance.android.livesdk.dispatch.utils.a.a() == false) goto L5;
        Lazy r111 = DispatchLogUtil.f122274a;
        DispatchLogUtil.d(0, DispatchLogUtil.InstanceType.FOLLOW);
        xs2.b.a().post(new mt1.a(0, this.f122048b, this.f122043e.f121952e, null, true, 8));
        return;
    L5:
        xs2.b.a().post(new mt1.a(0, this.f122048b, this.f122043e.f121952e, null, false, 24));
        com.bytedance.android.livesdk.log.filter.o r112 = com.bytedance.android.livesdk.log.u.l().c(am2.x.class);
        String r100 = "";
        if (r112.getMap().containsKey("enter_from_merge") == false) goto L8;
        String r101 = r112.getMap().get("enter_from_merge");
    L10:
        if (r112.getMap().containsKey("enter_method") == false) goto L12;
        String r102 = r112.getMap().get("enter_method");
    L14:
        if (r112.getMap().containsKey("action_type") == false) goto L16;
        String r103 = r112.getMap().get("action_type");
    L18:
        if (r112.getMap().containsKey("video_id") == false) goto L21;
        r100 = r112.getMap().get("video_id");
    L21:
        if (tb1.c.f545229a == false) goto L23;
        r101 = k1.c();
    L23:
        HashMap r113 = new HashMap();
        r113.put("enter_from_merge", r101);
        r113.put("enter_method", r102);
        r113.put("action_type", r103);
        r113.put("request_page", com.bytedance.android.ec.core.event.a.VALUE_LONG_CLICK);
        Room r104 = this.f122048b;
        if (r104 == null) goto L26;
        String r105 = r104.getOwnerUserIdString();
    L27:
        r113.put(com.bytedance.android.ec.core.event.a.KEY_TO_USER_ID, String.valueOf(r105));
        r113.put(MonitorConstants.EXTRA_DOWNLOAD_PAGE, "live_detail");
        r113.put("video_id", r100);
        String r106 = "0";
        if (((IBroadcastService) jc1.k.n(IBroadcastService.class)).isPlayingGame() == false) goto L30;
        Object r107 = "1";
    L31:
        r113.put("is_gaming", r107);
        Room r108 = this.f122048b;
        if (r108 == null) goto L34;
        LiveMode r109 = r108.getStreamType();
    L35:
        int r114 = h1.f66189a;
        r113.put("live_type", i1.a(r109));
        r113.put("is_vr_machine", VrUtils.o(this.f122043e.f121953f));
        if (com.bytedance.android.livesdk.sharedpref.b.V.getValue().booleanValue() == false) goto L38;
        Object r115 = "1";
    L39:
        r113.put("is_screen_clear", r115);
        r113.putAll(h1.a(this.f122048b));
        AudienceGameContext.Companion.getClass();
        AudienceGameContext r116 = AudienceGameContext.a.a();
        if (r116 == null) goto L44;
        com.bytedance.live.datacontext.n<com.bytedance.android.live.broadcastgame.api.model.r> r117 = r116.getCurrentGame();
        if (r117 == null) goto L44;
        com.bytedance.android.live.broadcastgame.api.model.r r118 = r117.getValue();
    L45:
        if (r118 == null) goto L47;
        Long r119 = Long.valueOf(r118.p());
    L48:
        r113.put("game_id", String.valueOf(r119));
        if (r118 == null) goto L51;
        String r120 = r118.q();
    L52:
        r113.put(EventConstants.ExtraJson.GAME_NAME, String.valueOf(r120));
        r113.put("connection_type", ((IInteractService) jc1.k.n(IInteractService.class)).getLinkConnectionType());
        r113.put("anchor_cnt", ((ILinkServiceExternal) jc1.k.n(ILinkServiceExternal.class)).getLinkAnchorCount());
        RoomContext r121 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r121 == null) goto L59;
        com.bytedance.live.datacontext.m<Boolean> r122 = r121.isCleanMode();
        if (r122 == null) goto L59;
        if (r122.getValue().booleanValue() != true) goto L59;
        r106 = "1";
    L59:
        r113.put("if_clear_mode", r106);
        com.bytedance.android.livesdk.log.filter.h.J(r113, FollowLog.Scene.LongPressPanel.getFollowEntrancePage(), "audience_to_anchor", "1");
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_follow", r113, new Object[]{am2.x.class, Room.class, am2.n.f(), am2.q.class});
        return;
    L51:
        r120 = null;
        goto L52
    L47:
        r119 = null;
    L44:
        r118 = null;
        goto L45
    L38:
        r115 = "0";
        goto L39
    L34:
        r109 = null;
        goto L35
    L30:
        r107 = "0";
        goto L31
    L26:
        r105 = null;
        goto L27
    L16:
        r103 = "";
        goto L18
    L12:
        r102 = "";
        goto L14
    L8:
        r101 = "";
        goto L10
    }

    @Override // com.bytedance.android.livesdk.dislike.action.OptionAction
    public final void d(Function1<? super Map<String, ? extends Object>, Unit> r100) {
        if (sr.f121247a.getValue().booleanValue() == true) goto L5;
        return;
    L5:
        Room r101 = this.f122048b;
        if (r101 == null) goto L8;
        User r102 = r101.mo8271getOwner();
    L9:
        com.bytedance.android.live.room.api.follow.b.c(r102, "FollowAction-onShow", this.f122048b, new FollowAction$onShow$1(this, r100));
        return;
    L8:
        r102 = null;
        goto L9
    }
}
