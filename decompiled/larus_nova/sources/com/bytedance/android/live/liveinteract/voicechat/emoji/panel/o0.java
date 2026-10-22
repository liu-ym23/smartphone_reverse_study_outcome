package com.bytedance.android.live.liveinteract.voicechat.emoji.panel;

import android.view.View;
import com.bytedance.android.live.core.setting.b6;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.larus.nova.R;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class o0 extends g {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f80237f;

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.g
    public final int d() {
        if (b6.f65236h.getValue().booleanValue() == true) goto L7;
        return R.drawable.ttlive_icon_talk_camera_closed_cool;
    L7:
        if (this.f80237f == false) goto L10;
        return R.drawable.ttlive_icon_talk_camera_closed;
    L10:
        return R.drawable.ttlive_icon_talk_open_camera;
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.g
    public final String j() {
        if (b6.f65236h.getValue().booleanValue() == true) goto L9;
        if (this.f80237f == true) goto L9;
        return s1.B(R.string.ttlive_interact_camera_beclosed);
    L9:
        if (this.f80237f == false) goto L13;
        return s1.B(R.string.ttlive_interact_close_camera);
    L13:
        return s1.B(R.string.ttlive_interact_open_camera);
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.g
    public final void k(View r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        if (b6.f65236h.getValue().booleanValue() == true) goto L6;
        f2.b(R.string.ttlive_interact_anchor_close_camera, 0);
        return;
    L6:
        q0 r101 = this.f80221e;
        if (r101 == null) goto L10;
        r101.b(!this.f80237f);
        return;
    }

    public o0(q0 r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "action");
        super(r100);
        this.f80237f = r101;
    }
}
