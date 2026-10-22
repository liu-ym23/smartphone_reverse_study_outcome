package com.bytedance.android.live.liveinteract.revenue.linkroomfight.dynamic;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.android.live.liveinteract.revenue.linkroomfight.core.LinkRoomFightContext;
import com.bytedance.android.live.liveinteract.revenue.linkroomfight.random.AbsRoomBattleRandonMatchVM;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.android.livesdkapi.config.FastStartLiveConfig;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import ih0.h;
import jc1.k;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c¢\u0006\u0004\b!\u0010\"J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0014\u0010\u0006\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0004H\u0002J\u001a\u0010\u000f\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u0010\u001a\u00020\u0002H\u0016R\"\u0010\u0011\u001a\u00020\u00078\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0019\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0019\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 ¨\u0006#"}, d2 = {"Lcom/bytedance/android/live/liveinteract/revenue/linkroomfight/dynamic/DynamicRoomBattleRandomMatchVM;", "Lcom/bytedance/android/live/liveinteract/revenue/linkroomfight/random/AbsRoomBattleRandonMatchVM;", "", "onMatchStart", "", "from", "onMatchEnd", "", "isMatching", "operatorUserId", "onGetMatchInfo", "Lcom/google/gson/JsonObject;", "updateExtraInfo", "Lih0/h;", "updateCallback", "handleLynxCmd", LiveCommonConstants.REASON_ON_DEDTROY, "mIsMatching", "Z", "getMIsMatching$liveinteract_impl_saasRelease", "()Z", "setMIsMatching$liveinteract_impl_saasRelease", "(Z)V", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "getDataCenter", "()Lcom/bytedance/ies/sdk/widgets/DataCenter;", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "room", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "getRoom", "()Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "<init>", "(Lcom/bytedance/ies/sdk/widgets/DataCenter;Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;)V", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class DynamicRoomBattleRandomMatchVM extends AbsRoomBattleRandonMatchVM {
    private final DataCenter dataCenter;
    private boolean mIsMatching;
    private final IRoom room;

    private final void onMatchStart() {
        if (this.mIsMatching == true) goto L35;
        DataCenter r100 = this.dataCenter;
        if (r100 == null) goto L7;
        r100.put("cmd_show_self_waiting_behavior", MapsKt.mapOf(new Pair[]{TuplesKt.to(FastStartLiveConfig.PLAY_MODE, "room_battle"), TuplesKt.to("ringing", Boolean.TRUE)}));
    L7:
        int r101 = com.bytedance.android.live.liveinteract.e.f72771a;
        pp1.c r110 = new pp1.c("跨房匹配中", null, com.bytedance.android.live.liveinteract.e.a(0, null).toString(), 10, null, null, 1, (int) 14, null, 0, 7986);
        DataCenter r102 = this.dataCenter;
        if (r102 == null) goto L12;
        Boolean r103 = (Boolean) r102.get("cmd_multi_scene_game_behavior_shown");
        if (r103 == null) goto L12;
        boolean r104 = r103.booleanValue();
    L13:
        DataCenter r105 = this.dataCenter;
        if (r105 == null) goto L18;
        Boolean r106 = (Boolean) r105.get("cmd_multi_interact_behavior_shown");
        if (r106 == null) goto L18;
        boolean r111 = r106.booleanValue();
    L19:
        DataCenter r107 = this.dataCenter;
        if (r107 == null) goto L24;
        Boolean r108 = (Boolean) r107.get("cmd_multi_room_link_behavior_shown");
        if (r108 == null) goto L24;
        r108.booleanValue();
    L24:
        if (r104 == false) goto L28;
        DataCenter r109 = this.dataCenter;
        if (r109 == null) goto L35;
        r109.put("cmd_show_self_bubble_on_scene_game", r110);
        goto L35
    L28:
        if (r111 == false) goto L32;
        DataCenter r112 = this.dataCenter;
        if (r112 == null) goto L35;
        r112.put("cmd_show_self_bubble_on_openplatform_behavior", r110);
        goto L35
    L32:
        DataCenter r113 = this.dataCenter;
        if (r113 == null) goto L35;
        r113.put("cmd_show_self_bubble_on_more", r110);
    L18:
        r111 = false;
    L12:
        r104 = false;
    L35:
        this.mIsMatching = true;
    }

    @Override // com.bytedance.android.live.liveinteract.revenue.linkroomfight.random.AbsRoomBattleRandonMatchVM
    public void onDestroy() {
        onMatchEnd(LiveCommonConstants.REASON_ON_DEDTROY);
    }

    public final DataCenter getDataCenter() {
        return this.dataCenter;
    }

    public final boolean getMIsMatching$liveinteract_impl_saasRelease() {
        return this.mIsMatching;
    }

    public final IRoom getRoom() {
        return this.room;
    }

    private final void onMatchEnd(String r100) {
        ALogger.i("DynamicRoomBattleRandomMatchVM", "onMatchEnd from: " + r100);
        DataCenter r101 = this.dataCenter;
        if (r101 == null) goto L5;
        r101.put("cmd_show_self_waiting_behavior", MapsKt.mapOf(new Pair[]{TuplesKt.to(FastStartLiveConfig.PLAY_MODE, "room_battle"), TuplesKt.to("ringing", Boolean.FALSE)}));
    L5:
        this.mIsMatching = false;
    }

    public final void setMIsMatching$liveinteract_impl_saasRelease(boolean r100) {
        this.mIsMatching = r100;
    }

    public DynamicRoomBattleRandomMatchVM(DataCenter r100, IRoom r101) {
        this.dataCenter = r100;
        this.room = r101;
    }

    private final void onGetMatchInfo(boolean r100, String r101) {
        this.mIsMatching = r100;
        IMiddlewareUserService r102 = (IMiddlewareUserService) k.f(IMiddlewareUserService.class);
        if (r102 == null) goto L8;
        com.bytedance.android.livesdk.user.e r103 = r102.user();
        if (r103 == null) goto L8;
        String r104 = r103.n();
        if (r104 == null) goto L8;
    L9:
        if (r100 == true) goto L11;
    L12:
        DataCenter r105 = this.dataCenter;
        if (r105 == null) goto L17;
        r105.put("cmd_show_self_waiting_behavior", MapsKt.mapOf(new Pair[]{TuplesKt.to(FastStartLiveConfig.PLAY_MODE, "room_battle"), TuplesKt.to("ringing", Boolean.valueOf(r100))}));
        return;
    L17:
        return;
    L11:
        if (Intrinsics.areEqual(r104, r101) == true) goto L12;
        return;
    L8:
        r104 = "";
        goto L9
    }

    @Override // com.bytedance.android.live.liveinteract.revenue.linkroomfight.random.AbsRoomBattleRandonMatchVM
    public void handleLynxCmd(JsonObject r100, h r101) {
        Intrinsics.checkNotNullParameter(r100, "updateExtraInfo");
        JsonElement r102 = r100.get("type");
        if (r102 == null) goto L5;
        String r103 = r102.getAsString();
    L6:
        if (r103 != null) goto L9;
        return;
    L9:
        switch(r103.hashCode()) {
            case -1529565272: goto L53;
            case -1326754011: goto L48;
            case -563217108: goto L45;
            case -302323862: goto L42;
            case -282943616: goto L39;
            case -27011313: goto L36;
            case 645106545: goto L24;
            case 675037128: goto L21;
            case 781465000: goto L18;
            case 1277826251: goto L15;
            case 1945793889: goto L12;
            default: goto L72;
        };
    L72:
        return;
    L12:
        if (r103.equals("end_match") == false) goto L56;
        onMatchEnd("handleLynxCmd");
        return;
    L56:
        return;
    L15:
        if (r103.equals("result_invite_cross_room_link") == false) goto L58;
    L49:
        com.bytedance.android.live.liveinteract.revenue.linkroomfight.core.b r104 = LinkRoomFightContext.Companion.a();
        if (r104 == null) goto L68;
        r104.Ui(r103, r100, r101);
        return;
    L68:
        return;
    L58:
        return;
    L18:
        if (r103.equals("result_reply_cross_room_link") == true) goto L49;
        return;
    L21:
        if (r103.equals("result_invite_room_battle") == true) goto L49;
        return;
    L24:
        if (r103.equals("get_match_info") == false) goto L61;
        JsonElement r105 = r100.get("isMatching");
        if (r105 == null) goto L28;
        boolean r106 = r105.getAsBoolean();
    L29:
        JsonElement r107 = r100.get("operatorUserId");
        if (r107 == null) goto L33;
        String r108 = r107.getAsString();
        if (r108 == null) goto L33;
    L34:
        onGetMatchInfo(r106, r108);
        return;
    L33:
        r108 = "";
        goto L34
    L28:
        r106 = false;
        goto L29
    L61:
        return;
    L36:
        if (r103.equals("show_feedback_reply_room_battle") == true) goto L49;
        return;
    L39:
        if (r103.equals("check_invite_cross_room_link") == true) goto L49;
        return;
    L42:
        if (r103.equals(NewBroadcastMonitor.STAGE.LIFECYCLE) == true) goto L49;
        return;
    L45:
        if (r103.equals("result_cancel_invite_cross_room_link") == true) goto L49;
        return;
    L48:
        if (r103.equals("result_reply_room_battle") == true) goto L49;
        return;
    L53:
        if (r103.equals("start_match") == false) goto L70;
        onMatchStart();
        return;
    L70:
        return;
    L5:
        r103 = null;
        goto L6
    }

    public static /* synthetic */ void onMatchEnd$default(DynamicRoomBattleRandomMatchVM r100, String r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L5;
        r101 = null;
    L5:
        r100.onMatchEnd(r101);
    }
}
