package com.bytedance.android.live.liveinteract.voicechat.emoji.panel;

import android.view.View;
import com.bytedance.android.live.core.utils.s1;
import com.larus.nova.R;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class o extends g {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f80236f;

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.g
    public final int d() {
        if (this.f80236f == false) goto L5;
        return R.drawable.ttlive_icon_voice_room_1_v_8_enlarge;
    L5:
        return R.drawable.ttlive_icon_voice_room_1_v_8_cancel_enlarge;
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.g
    public final String j() {
        if (this.f80236f == false) goto L6;
        return s1.B(R.string.ttlive_voice_room_enlarge_c_position);
    L6:
        return s1.B(R.string.ttlive_voice_room_cancel_enlarge_c_position);
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.g
    public final void k(View r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        this.f80221e.w0(this.f80236f);
    }

    public o(q0 r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "action");
        super(r100);
        this.f80236f = r101;
    }
}
