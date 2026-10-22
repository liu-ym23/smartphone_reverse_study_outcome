package com.bytedance.android.live.liveinteract.voicechat.emoji.panel;

import android.view.View;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.revenue.fight.TeamFightContext;
import com.larus.nova.R;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class z0 extends g {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f80263f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f80264g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f80265h;

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.g
    public final int d() {
        int r100 = li0.d.c(this.f80265h);
        if (TeamFightContext.Companion.d() == false) goto L9;
        if (r100 != 1) goto L7;
        return R.drawable.ttlive_icon_team_fight_camp_red2blue_enable;
    L7:
        return R.drawable.ttlive_icon_team_fight_camp_blue2red_enable;
    L9:
        if (r100 != 2) goto L11;
        return R.drawable.ttlive_icon_team_fight_camp_blue2red_unable;
    L11:
        return R.drawable.ttlive_icon_team_fight_camp_red2blue_unable;
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.g
    public final String j() {
        if (li0.d.c(this.f80265h) != 1) goto L6;
        return s1.B(R.string.ttlive_chat_room_panel_item_blue_camp_hit);
    L6:
        return s1.B(R.string.ttlive_chat_room_panel_item_red_camp_hit);
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.g
    public final void k(View r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        if (TeamFightContext.Companion.d() == false) goto L5;
        this.f80221e.e5(this.f80264g, this.f80263f, 0, this.f80265h);
        return;
    L5:
        f2.c(s1.B(R.string.ttlive_chat_room_panel_item_team_fight_camp_unable_hit), 0);
    }

    public z0(q0 r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "action");
        Intrinsics.checkNotNullParameter(r101, "userId");
        super(r100);
        this.f80265h = r101;
        this.f80263f = -1;
        int r102 = 2;
        if (li0.d.c(r101) != 1) goto L5;
        int r103 = 2;
    L6:
        this.f80263f = r103;
        if (r101.length() != 0) goto L9;
        boolean r104 = true;
    L10:
        if (r104 == true) goto L13;
        r102 = 1;
    L13:
        this.f80264g = r102;
        if (TeamFightContext.Companion.d() == false) goto L16;
        int r105 = s1.h(R.color.ttlive_chat_room_panel_item_text_enable_color);
    L17:
        this.f80220d = r105;
        return;
    L16:
        r105 = s1.h(R.color.ttlive_chat_room_panel_item_text_unable_color);
        goto L17
    L9:
        r104 = false;
        goto L10
    L5:
        r103 = 1;
        goto L6
    }
}
