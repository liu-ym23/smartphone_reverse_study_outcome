package com.bytedance.android.live.liveinteract.voicechat.emoji.panel;

import android.view.View;
import com.bytedance.android.live.core.utils.s1;
import com.larus.nova.R;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class i0 extends g {
    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.g
    public final int d() {
        return R.drawable.ttlive_icon_invite_ktv_group;
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.g
    public final String j() {
        return s1.B(R.string.ttlive_broadcast_toolbar_ktv_group_invite);
    }

    public i0(q0 r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        super(r100);
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.g
    public final void k(View r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        this.f80221e.M();
    }
}
