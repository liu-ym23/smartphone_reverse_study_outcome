package com.bytedance.android.live.livepkaudience.emoji.panel;

import android.view.View;
import com.larus.nova.R;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class i extends g {
    @Override // com.bytedance.android.live.livepkaudience.emoji.panel.g
    public final int c() {
        return R.drawable.ttlive_icon_talk_room_control_change;
    }

    @Override // com.bytedance.android.live.livepkaudience.emoji.panel.g
    public final String d() {
        return "切换控制者";
    }

    public i(f r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        super(r100);
    }

    @Override // com.bytedance.android.live.livepkaudience.emoji.panel.g
    public final void e(View r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        this.f81981a.y5();
    }
}
