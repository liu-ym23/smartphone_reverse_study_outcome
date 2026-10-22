package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior;

import android.view.View;
import com.bytedance.android.livehostapi.foundation.IHostPlugin;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.config.ud0;
import com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.ChatChannelUtils;
import com.bytedance.android.livesdk.interactivity.api.comment.event.OpenInputSource;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class s2 implements com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public DataCenter f117363a;

    public s2() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Bh(ToolbarButton r100) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Mr(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r100) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void R9(View r100, DataCenter r101) {
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

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final boolean showRedDot() {
        DataCenter r100 = this.f117363a;
        if (r100 != null) goto L6;
        r100 = null;
    L6:
        RoomContext.Companion.getClass();
        RoomContext r101 = RoomContext.a.a(r100, 0);
        if (r101 == null) goto L13;
        if (r101.isBroadcastMedia() != true) goto L13;
        return false;
    L13:
        return com.bytedance.android.livesdk.sharedpref.b.f158143f0.getValue().booleanValue();
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r110) {
        HashMap r111 = new HashMap();
        if (ud0.f121363a.getValue().booleanValue() == false) goto L14;
        r111.put(MonitorConstants.EXTRA_DOWNLOAD_PAGE, IHostPlugin.ENTER_FROM_LINKMIC_TYPE);
        RoomContext.a r100 = RoomContext.Companion;
        DataCenter r101 = this.f117363a;
        if (r101 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mDataCenter");
    L7:
        r100.getClass();
        RoomContext r102 = RoomContext.a.a(r101, 0);
        if (r102 != null) goto L10;
    L12:
        String r103 = "0";
    L13:
        r111.put("live_status", r103);
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_anchor_comment_click", r111, new Object[]{Room.class, am2.x.class});
    L18:
        RoomContext.a r112 = RoomContext.Companion;
        DataCenter r104 = this.f117363a;
        if (r104 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("mDataCenter");
    L21:
        RoomContext r113 = RoomContext.a.c(r112, r104, 0, 2);
        DataCenter r105 = this.f117363a;
        if (r105 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("mDataCenter");
    L25:
        if (ChatChannelUtils.k(r113, r105) == false) goto L28;
        u22.m r114 = new u22.m();
        r114.f548441l = OpenInputSource.AnchorInteractivityPanel;
        r114.f548442m = 1;
    L31:
        DataCenter r106 = this.f117363a;
        if (r106 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("mDataCenter");
    L34:
        r106.put("cmd_wanna_send_message", r114);
        com.bytedance.android.livesdk.sharedpref.e<Boolean> r115 = com.bytedance.android.livesdk.sharedpref.b.f158143f0;
        Boolean r107 = Boolean.FALSE;
        r115.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r115, r107);
        DataCenter r116 = this.f117363a;
        if (r116 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("mDataCenter");
    L37:
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3.m(r116).b(ToolbarButton.MORE, new pp1.j(false));
        return;
    L28:
        if (com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.q.b(r113) == false) goto L30;
        r114 = new u22.m();
        r114.f548441l = OpenInputSource.AnchorInteractivityPanel;
        r114.f548442m = 2;
        goto L31
    L30:
        r114 = new u22.m();
        r114.f548441l = OpenInputSource.AnchorInteractivityPanel;
        goto L31
    L10:
        if (r102.getMediaReviewStatus().getValue().intValue() < 5) goto L12;
        r103 = "1";
        goto L13
    L14:
        com.bytedance.android.livesdk.log.g r117 = com.bytedance.android.livesdk.log.u.l();
        DataCenter r108 = this.f117363a;
        if (r108 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("mDataCenter");
    L17:
        r117.sendLog("livesdk_anchor_comment_click", com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.f4.a(r108, null), new Object[]{Room.class});
        goto L18
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void p4(View r100, DataCenter r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "dataCenter");
        this.f117363a = r101;
    }
}
