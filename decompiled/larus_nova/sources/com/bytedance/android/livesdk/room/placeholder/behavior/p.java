package com.bytedance.android.livesdk.room.placeholder.behavior;

import android.content.Context;
import android.view.View;
import com.bytedance.android.live.broadcastgame.api.interactgame.GameDataReportHelper;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ExtendedToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.x3;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3;
import com.bytedance.android.livesdk.gameguess.toolbar.ToolbarPredictorTempAreaBehavior;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.message.model.TempStateAreaReachMessage;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.ss.android.downloadlib.constants.EventConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class p implements c0.b, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final y f157769a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final x3 f157770b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ExtendedToolbarButton f157771c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final DataCenter f157772d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f157773e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Context f157774f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f157775g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f157776h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f157777i;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Bh(ToolbarButton r100) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Mr(s r100) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void SY(s r100) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Y6() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ com.bytedance.android.livesdk.reddot.a h7() {
        return null;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void onHide(boolean r100) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void setAlpha(float r100) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ boolean showRedDot() {
        return false;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.n
    public final void onShow() {
        y r100 = this.f157769a;
        if (r100 == null) goto L6;
        r100.onShow();
    L6:
        if (this.f157773e != TempStateAreaReachMessage.ELEM_TYPE.PREDICTOR.getType()) goto L20;
        DataCenter r101 = this.f157772d;
        if (r101 == null) goto L21;
        Boolean r102 = null;
        Room r103 = (Room) r101.get("data_room", null);
        if (r103 == null) goto L22;
        com.bytedance.android.livesdk.log.g r104 = u.l();
        Pair[] r105 = new Pair[4];
        r105[0] = TuplesKt.to("anchor_id", r103.getOwnerUserIdString());
        r105[1] = TuplesKt.to("room_id", String.valueOf(r103.getRoomId()));
        r105[2] = TuplesKt.to("enter_from", "more");
        DataCenter r106 = this.f157772d;
        if (r106 == null) goto L15;
        r102 = (Boolean) r106.get("data_is_portrait", Boolean.TRUE);
    L15:
        if (Intrinsics.areEqual(r102, Boolean.TRUE) == false) goto L17;
        String r107 = "0";
    L18:
        r105[3] = TuplesKt.to("liveroom_orientation", r107);
        r104.sendLog("livesdk_user_prediction_main_entrance_show", MapsKt.mapOf(r105), new Object[0]);
        return;
    L17:
        r107 = "1";
        goto L18
    L22:
        return;
    L21:
        return;
    }

    public final Context getContext() {
        return this.f157774f;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void dv(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.e r100) {
        Intrinsics.checkNotNullParameter(r100, "command");
        y r101 = this.f157769a;
        if (r101 == null) goto L6;
        r101.dv(r100);
        return;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r110) {
        y r100 = this.f157769a;
        if (r100 == null) goto L5;
        boolean r101 = r100.b80();
    L6:
        if (r101 == true) goto L10;
        y r111 = this.f157769a;
        if (r111 == null) goto L37;
        r111.yl();
        return;
    L37:
        return;
    L10:
        long r102 = this.f157773e;
        Object r112 = null;
        if (r102 != TempStateAreaReachMessage.ELEM_TYPE.OPEN_GAME.getType()) goto L17;
        int r103 = GameDataReportHelper.f59290a;
        String r104 = this.f157777i;
        long r105 = this.f157776h;
        Intrinsics.checkNotNullParameter(r104, "elemName");
        com.bytedance.android.livesdk.log.g r106 = u.l();
        Pair[] r113 = new Pair[6];
        r113[0] = TuplesKt.to(EventConstants.ExtraJson.GAME_NAME, r104);
        r113[1] = TuplesKt.to("game_id", String.valueOf(r105));
        com.bytedance.android.livesdk.user.f r107 = ((IUserService) jc1.k.n(IUserService.class)).user();
        if (r107 == null) goto L15;
        r112 = r107.n();
    L15:
        r113[2] = TuplesKt.to("user_id", r112);
        r113[3] = TuplesKt.to("source_type", "more");
        r113[4] = TuplesKt.to("user_type", "user");
        r113[5] = TuplesKt.to("source", ((IInteractService) jc1.k.n(IInteractService.class)).getCurrentSwitchSceneSource());
        r106.sendLog("livesdk_live_game_click", MapsKt.mapOf(r113), new Object[]{Room.class});
    L30:
        y r108 = this.f157769a;
        if (r108 == null) goto L33;
        r108.onClick(r110);
    L33:
        DataCenter r114 = this.f157772d;
        if (r114 == null) goto L39;
        r114.put("cmd_live_toolbarmore_dialog_dismiss", new Object());
        return;
    L39:
        return;
    L17:
        if (r102 != TempStateAreaReachMessage.ELEM_TYPE.PREDICTOR.getType()) goto L30;
        DataCenter r109 = this.f157772d;
        if (r109 == null) goto L30;
        Room r115 = (Room) r109.get("data_room", null);
        if (r115 == null) goto L30;
        com.bytedance.android.livesdk.log.g r116 = u.l();
        Pair[] r117 = new Pair[4];
        r117[0] = TuplesKt.to("anchor_id", r115.getOwnerUserIdString());
        r117[1] = TuplesKt.to("room_id", String.valueOf(r115.getRoomId()));
        r117[2] = TuplesKt.to("enter_from", "more");
        DataCenter r118 = this.f157772d;
        if (r118 == null) goto L26;
        r112 = (Boolean) r118.get("data_is_portrait", Boolean.TRUE);
    L26:
        if (Intrinsics.areEqual(r112, Boolean.TRUE) == false) goto L28;
        String r119 = "0";
    L29:
        r117[3] = TuplesKt.to("liveroom_orientation", r119);
        r116.sendLog("livesdk_user_prediction_main_entrance_click", MapsKt.mapOf(r117), new Object[0]);
        goto L30
    L28:
        r119 = "1";
        goto L29
    L5:
        r101 = false;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void R9(View r100, DataCenter r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "dataCenter");
        y r102 = this.f157769a;
        if (r102 == null) goto L6;
        r102.R9(r100, r101);
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void p4(View r100, DataCenter r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "dataCenter");
        y r102 = this.f157769a;
        if (r102 == null) goto L6;
        r102.p4(r100, r101);
        return;
    }

    public p(DataCenter r100, long r101, Context r102, boolean r103, long r104, long r105, String r110) {
        Intrinsics.checkNotNullParameter(r100, "dataCenter");
        Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r110, "elemName");
        this.f157772d = r100;
        this.f157773e = r101;
        this.f157774f = r102;
        this.f157775g = r104;
        this.f157776h = r105;
        this.f157777i = r110;
        c0.b r106 = null;
        if (r103 == false) goto L7;
        x3 r107 = y3.f(r100);
        if ((r107 instanceof x3) == true) goto L11;
        r107 = null;
    L11:
        this.f157770b = r107;
        if (r101 != TempStateAreaReachMessage.ELEM_TYPE.OPEN_GAME.getType()) goto L16;
        if (r107 == null) goto L18;
        c0.b r108 = r107.s(ToolbarButton.OPEN_PLATFORM_LYNX_GAME.extended());
    L20:
        if ((r108 instanceof y) == false) goto L23;
        r106 = r108;
    L23:
        this.f157769a = (y) r106;
        return;
    L18:
        r108 = null;
        goto L20
    L16:
        if (r101 != TempStateAreaReachMessage.ELEM_TYPE.PREDICTOR.getType()) goto L18;
        r108 = new ToolbarPredictorTempAreaBehavior();
        goto L20
    L7:
        c0 r109 = y3.i(r100);
        if ((r109 instanceof x3) == true) goto L10;
        r109 = null;
    L10:
        r107 = (x3) r109;
        goto L11
    }
}
