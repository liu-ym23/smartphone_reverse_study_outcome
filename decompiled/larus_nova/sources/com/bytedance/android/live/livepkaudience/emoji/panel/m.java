package com.bytedance.android.live.livepkaudience.emoji.panel;

import android.view.View;
import com.bytedance.android.live.core.utils.s1;
import com.larus.nova.R;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class m extends g {
    @Override // com.bytedance.android.live.livepkaudience.emoji.panel.g
    public final int c() {
        return R.drawable.ttlive_icon_talk_room_followed;
    }

    @Override // com.bytedance.android.live.livepkaudience.emoji.panel.g
    public final String d() {
        return s1.B(R.string.ttlive_has_followed);
    }

    public m(f r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        super(r100);
    }

    @Override // com.bytedance.android.live.livepkaudience.emoji.panel.g
    public final void e(View r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        this.f81981a.f();
    }
}
