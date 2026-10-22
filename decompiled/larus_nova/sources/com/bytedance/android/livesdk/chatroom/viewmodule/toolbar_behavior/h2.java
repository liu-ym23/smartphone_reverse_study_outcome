package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior;

import android.view.View;
import com.bytedance.android.live.broadcast.api.IMiddlewareBroadcastService;
import com.bytedance.android.live.broadcast.api.model.AnchorVideoResolutionManager;
import com.bytedance.android.live.cloudgrouplive.model.CloudGroupLivePipelineStatus;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.config.LiveAnchorOneOffKeys;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.nova.R;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class h2 implements com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public DataCenter f117204a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Room f117205b;

    public h2() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Bh(ToolbarButton r100) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Mr(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r100) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void SY(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r100) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Y6() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void dv(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.e r100) {
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

    public static boolean a() {
        IInteractService r100 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r100 == null) goto L7;
        z30.b r101 = r100.getCloudGroupLiveService();
        if (r101 == null) goto L7;
        CloudGroupLivePipelineStatus r102 = r101.b();
    L9:
        if (r102 != CloudGroupLivePipelineStatus.START) goto L11;
        return true;
    L11:
        return false;
    L7:
        r102 = null;
        goto L9
    }

    public final boolean b() {
        DataCenter r100 = this.f117204a;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("dataCenter");
    L5:
        Integer r101 = (Integer) r100.get("data_link_state", 0);
        boolean r102 = gd0.v.a(r101.intValue(), 4);
        boolean r103 = gd0.v.a(r101.intValue(), 64);
        r101.intValue();
        boolean r104 = ((com.bytedance.android.live.liveinteract.service.f) ((IInteractService) jc1.k.n(IInteractService.class)).getInteractAudienceService()).P();
        if (gd0.v.a(r101.intValue(), 32) == false) goto L8;
    L11:
        boolean r105 = true;
    L12:
        if (r102 == true) goto L16;
        if (r103 == true) goto L16;
        if (r104 == true) goto L16;
        if (r105 == true) goto L16;
        return false;
    L16:
        return true;
    L8:
        if (gd0.v.a(r101.intValue(), 8) == true) goto L11;
        r105 = false;
        goto L12
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final boolean showRedDot() {
        return !com.bytedance.android.livesdk.sharedpref.b.f158205r2.getValue().getDot_in_room_used();
    }

    public final void c(String r100) {
        com.bytedance.android.livesdk.log.g r101 = com.bytedance.android.livesdk.log.u.l();
        Pair[] r102 = new Pair[4];
        Room r103 = this.f117205b;
        String r104 = null;
        if (r103 == null) goto L5;
        LiveMode r105 = r103.getStreamType();
    L6:
        int r106 = com.bytedance.android.live.core.utils.h1.f66189a;
        r102[0] = TuplesKt.to("live_type", com.bytedance.android.live.core.utils.i1.a(r105));
        Room r107 = this.f117205b;
        if (r107 == null) goto L9;
        r104 = r107.getOwnerUserIdString();
    L9:
        r102[1] = TuplesKt.to("anchor_id", r104);
        r102[2] = TuplesKt.to(MonitorConstants.EXTRA_DOWNLOAD_PAGE, "live_take_detail");
        r102[3] = TuplesKt.to("show_type", "icon");
        r101.sendLog(r100, MapsKt.mapOf(r102), new Object[]{Room.class});
        return;
    L5:
        r105 = null;
        goto L6
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (b() == false) goto L9;
        com.bytedance.android.live.core.utils.f2.b(R.string.ttlive_live_cannot_switch, 0);
        return;
    L9:
        if (((IMiddlewareBroadcastService) jc1.k.n(IMiddlewareBroadcastService.class)).isPlayingGame() == false) goto L13;
        com.bytedance.android.live.core.utils.f2.b(R.string.ttlive_live_gaming_cannot_switch, 0);
        return;
    L13:
        if (a() == false) goto L16;
        com.bytedance.android.live.core.utils.f2.b(R.string.ttlive_live_cannot_switch_when_cloud_group_live, 0);
        return;
    L16:
        com.bytedance.android.livesdk.sharedpref.e<LiveAnchorOneOffKeys> r101 = com.bytedance.android.livesdk.sharedpref.b.f158205r2;
        com.bytedance.android.livesdk.sharedpref.f.d(r101, LiveAnchorOneOffKeys.copy$default(r101.getValue(), false, true, false, 5, null));
        c("livesdk_anchor_definition_setting_button");
        AnchorVideoResolutionManager.l(r100.getContext(), this.f117205b);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void R9(View r100, DataCenter r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "dataCenter");
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3.f(r101).h(ToolbarButton.IN_ROOM_RESOLUTION.extended());
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void p4(View r100, DataCenter r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "dataCenter");
        this.f117204a = r101;
        IRoom r102 = com.bytedance.android.live.core.utils.z.b(r101).f66427a;
        View r103 = null;
        if ((r102 instanceof Room) == true) goto L5;
        r102 = null;
    L5:
        this.f117205b = (Room) r102;
        if (AnchorVideoResolutionManager.f59011c.length() != 0) goto L8;
        boolean r104 = true;
    L9:
        if (r104 == false) goto L12;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3.f(r101).i(ToolbarButton.IN_ROOM_RESOLUTION.extended());
        return;
    L12:
        c("livesdk_anchor_definition_setting_button_show");
        if (b() == false) goto L17;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3.f(r101).l(ToolbarButton.IN_ROOM_RESOLUTION.extended(), com.bytedance.android.live.core.utils.s1.B(R.string.ttlive_live_cannot_switch));
        return;
    L17:
        if (((IMiddlewareBroadcastService) jc1.k.n(IMiddlewareBroadcastService.class)).isPlayingGame() == false) goto L21;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3.f(r101).l(ToolbarButton.IN_ROOM_RESOLUTION.extended(), com.bytedance.android.live.core.utils.s1.B(R.string.ttlive_live_gaming_cannot_switch));
        return;
    L21:
        if (a() == false) goto L24;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3.f(r101).l(ToolbarButton.IN_ROOM_RESOLUTION.extended(), com.bytedance.android.live.core.utils.s1.B(R.string.ttlive_live_cannot_switch_when_cloud_group_live));
        return;
    L24:
        View r105 = r100.findViewById(R.id.icon);
        if ((r105 instanceof View) == false) goto L28;
        r103 = r105;
    L28:
        if (r103 == null) goto L56;
        String r106 = AnchorVideoResolutionManager.f59011c;
        int r107 = r106.hashCode();
        if (r107 == 3324) goto L51;
        if (r107 == 3448) goto L48;
        if (r107 != 3665) goto L36;
        r106.equals(PlayerResolution.SDKKEY.SD);
    L53:
        int r108 = R.drawable.ttlive_icon_toolbar_resolution_sd;
    L54:
        r103.setBackgroundResource(r108);
        return;
    L36:
        if (r107 == 115761) goto L44;
        if (r107 != 3005871) goto L53;
        if (r106.equals("auto") == false) goto L53;
        r108 = R.drawable.ttlive_icon_toolbar_resolution_auto;
        goto L54
    L44:
        if (r106.equals(PlayerResolution.SDKKEY.UHD) == false) goto L53;
        r108 = R.drawable.ttlive_icon_toolbar_resolution_uhd;
        goto L54
    L48:
        if (r106.equals(PlayerResolution.SDKKEY.LD) == false) goto L53;
        r108 = R.drawable.ttlive_icon_toolbar_resolution_ld;
        goto L54
    L51:
        if (r106.equals(PlayerResolution.SDKKEY.HD) == false) goto L53;
        r108 = R.drawable.ttlive_icon_toolbar_resolution_hd;
        goto L54
    L56:
        return;
    L8:
        r104 = false;
        goto L9
    }
}
