package com.bytedance.android.live.liveinteract.voicechat.emoji.panel;

import android.view.View;
import com.bytedance.kmp.live.livelink.api.model.VideoShowMode;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class l extends g {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final m f80225f;

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.g
    public final int b() {
        return 1;
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.g
    public final int d() {
        return 0;
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.g
    public final String j() {
        return "";
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.g
    public final Object c() {
        return this.f80225f;
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.g
    public final void k(View r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        Object r101 = r100.getTag();
        if (r101 == null) goto L9;
        VideoShowMode r102 = (VideoShowMode) r101;
        if (r102 == this.f80225f.f80233b) goto L10;
        this.f80221e.L(this, r102);
        return;
    L10:
        return;
    L9:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.kmp.live.livelink.api.model.VideoShowMode");
    }

    public l(q0 r100, m r101) {
        Intrinsics.checkNotNullParameter(r100, "action");
        Intrinsics.checkNotNullParameter(r101, "extra");
        super(r100);
        this.f80225f = r101;
    }
}
