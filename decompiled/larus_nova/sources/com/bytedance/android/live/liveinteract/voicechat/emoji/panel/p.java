package com.bytedance.android.live.liveinteract.voicechat.emoji.panel;

import android.view.View;
import com.bytedance.android.live.core.utils.s1;
import com.larus.nova.R;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class p extends g {
    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.g
    public final int d() {
        return R.drawable.ttlive_icon_talk_room_match;
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.g
    public final String j() {
        if (vm2.i.g() == false) goto L6;
        return s1.B(R.string.ttlive_live_interact_random_match);
    L6:
        return s1.B(R.string.ttlive_live_interact_fastmatch);
    }

    public p(q0 r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        super(r100);
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.g
    public final void k(View r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        this.f80221e.s();
    }
}
