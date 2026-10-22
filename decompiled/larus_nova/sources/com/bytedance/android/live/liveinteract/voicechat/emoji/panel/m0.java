package com.bytedance.android.live.liveinteract.voicechat.emoji.panel;

import android.view.View;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class m0 extends g {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f80235f;

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.g
    public final int b() {
        return 2;
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
    public final void k(View r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.g
    public final String e() {
        return this.f80235f;
    }

    public m0(q0 r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "action");
        Intrinsics.checkNotNullParameter(r101, "url");
        super(r100);
        this.f80235f = r101;
    }
}
