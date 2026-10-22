package com.bytedance.android.live.liveinteract.voicechat.emoji.panel;

import android.view.View;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.chatroom.model.interact.ThemedCompetitionRole;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.larus.nova.R;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class w0 extends g {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f80256f;

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.g
    public final int d() {
        return 0;
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.g
    public final String j() {
        if (this.f80256f != ThemedCompetitionRole.PERFORMER.getValue()) goto L6;
        return s1.B(R.string.ttlive_live_interact_reset_performing);
    L6:
        return s1.B(R.string.ttlive_live_interact_set_performing);
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.g
    public final void a(HSImageView r100) {
        Intrinsics.checkNotNullParameter(r100, "icon");
        int r101 = qy.a.f535172a;
        ImageUtil.loadRoundImage(r100, qy.a.b("", CollectionsKt.arrayListOf(new String[]{LiveCommonConstants.assembleTosObjectUrl(com.bytedance.android.live.liveinteract.videotalk.themecompetition.d.f79751a)})));
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.g
    public final void k(View r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        if (this.f80256f != ThemedCompetitionRole.CONTESTANT.getValue()) goto L5;
        boolean r101 = true;
    L6:
        this.f80221e.l(r101);
        return;
    L5:
        r101 = false;
        goto L6
    }

    public w0(q0 r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "action");
        super(r100);
        this.f80256f = r101;
    }
}
