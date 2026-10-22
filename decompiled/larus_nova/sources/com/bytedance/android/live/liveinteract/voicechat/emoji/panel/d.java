package com.bytedance.android.live.liveinteract.voicechat.emoji.panel;

import android.view.View;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.revenue.game.LinkMicGameContext;
import com.bytedance.android.live.liveinteract.videotalk.cposition.CPositionContext;
import com.bytedance.android.livesdk.model.MultiLinkEnlargeTipsConfig;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.nova.R;
import com.ss.android.download.api.constant.BaseConstants;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class d extends g {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f80200f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f80201g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f80202h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f80203i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final DataCenter f80204j;

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.g
    public final boolean l() {
        return false;
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.g
    public final int d() {
        if (this.f80203i == false) goto L5;
        return R.drawable.ttlive_ic_set_c_positon;
    L5:
        return R.drawable.ttlive_ic_unset_c_positon;
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.g
    public final String j() {
        if (CPositionContext.a.b(CPositionContext.Companion) == false) goto L17;
        com.bytedance.live.datacontext.m<IRoom> r100 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r100 == null) goto L13;
        IRoom r101 = r100.getValue();
        if (r101 == null) goto L13;
        if (r101.isLiveTypeAudio() != true) goto L13;
        com.bytedance.android.livesdk.sharedpref.e<MultiLinkEnlargeTipsConfig> r102 = com.bytedance.android.livesdk.sharedpref.c.f158257d;
        MultiLinkEnlargeTipsConfig r103 = r102.getValue();
        if (r103.getFirstShowTimestamp() != 0) goto L17;
        r103.setFirstShowTimestamp(System.currentTimeMillis());
        com.bytedance.android.livesdk.sharedpref.f.d(r102, r103);
    L13:
        com.bytedance.android.livesdk.sharedpref.e<MultiLinkEnlargeTipsConfig> r104 = com.bytedance.android.livesdk.sharedpref.c.f158254c;
        MultiLinkEnlargeTipsConfig r105 = r104.getValue();
        if (r105.getFirstShowTimestamp() != 0) goto L17;
        r105.setFirstShowTimestamp(System.currentTimeMillis());
        com.bytedance.android.livesdk.sharedpref.f.d(r104, r105);
    L17:
        if (this.f80203i == false) goto L20;
        return s1.B(R.string.ttlive_talk_room_set_c_position);
    L20:
        return s1.B(R.string.ttlive_talk_room_unset_c_position);
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.g
    public final String f() {
        return this.f80200f;
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.g
    public final int g() {
        return this.f80201g;
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.g
    public final int h() {
        return this.f80202h;
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.g
    public final void k(View r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        if (fj0.e.l() == false) goto L8;
        if (fj0.c.a() == true) goto L8;
        f2.b(R.string.ttlive_live_enlarge_user_paid_link_conflict, 0);
        return;
    L8:
        if (LinkMicGameContext.Companion.e() == false) goto L10;
        f2.b(R.string.ttlive_live_enlarge_user_conflict, 0);
        return;
    L10:
        this.f80221e.z0(this.f80203i, this.f80204j);
    }

    public d(q0 r100, boolean r101, DataCenter r102) {
        Intrinsics.checkNotNullParameter(r100, "action");
        super(r100);
        this.f80203i = r101;
        this.f80204j = r102;
        CPositionContext.a r103 = CPositionContext.Companion;
        r103.getClass();
        com.bytedance.live.datacontext.m<IRoom> r104 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        boolean r105 = true;
        if (r104 == null) goto L9;
        IRoom r106 = r104.getValue();
        if (r106 == null) goto L9;
        if (r106.isLiveTypeAudio() != true) goto L9;
        MultiLinkEnlargeTipsConfig r107 = com.bytedance.android.livesdk.sharedpref.c.f158257d.getValue();
    L11:
        if (r107.getFirstShowTimestamp() != 0) goto L13;
    L15:
        boolean r108 = false;
    L16:
        boolean r109 = r107.getHasClicked();
        com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.chatroom.viewmodel.e> r110 = com.bytedance.android.live.liveinteract.api.utils.m.i().getVideoTalkRoomSubScene();
        if (r110 == null) goto L23;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r111 = r110.getValue();
        if (r111 == null) goto L23;
        com.bytedance.android.livesdk.chatroom.viewmodel.j r112 = r111.t();
        if (r112 == null) goto L23;
        Integer r113 = Integer.valueOf(r112.f114798a);
    L24:
        String r114 = "";
        if (r113 != null) goto L28;
    L30:
        boolean r115 = CPositionContext.a.a("");
    L31:
        if (r115 == false) goto L35;
        if (r109 == true) goto L35;
        if (r108 == true) goto L35;
    L36:
        if (r105 == false) goto L38;
        r114 = s1.B(R.string.ttlive_talk_room_multi_enlarge_position_first_tips);
    L38:
        this.f80200f = r114;
        this.f80201g = -1;
        this.f80202h = R.drawable.ttlive_bg_action_item_tips;
        return;
    L35:
        r105 = false;
        goto L36
    L28:
        if (r113.intValue() != 8) goto L30;
        r115 = r103.c();
    L23:
        r113 = null;
        goto L24
    L13:
        if ((System.currentTimeMillis() - r107.getFirstShowTimestamp()) <= BaseConstants.Time.DAY) goto L15;
        r108 = true;
    L9:
        r107 = com.bytedance.android.livesdk.sharedpref.c.f158254c.getValue();
        goto L11
    }
}
