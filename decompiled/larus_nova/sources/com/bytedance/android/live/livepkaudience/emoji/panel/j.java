package com.bytedance.android.live.livepkaudience.emoji.panel;

import android.view.View;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.utils.r2;
import com.larus.nova.R;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class j extends g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f81983b;

    @Override // com.bytedance.android.live.livepkaudience.emoji.panel.g
    public final int c() {
        return R.drawable.ttlive_icon_talk_room_profile;
    }

    @Override // com.bytedance.android.live.livepkaudience.emoji.panel.g
    public final String d() {
        if (r2.a(this.f81983b) == false) goto L6;
        return this.f81983b;
    L6:
        return s1.B(R.string.ttlive_live_radio_interact_show_profile);
    }

    @Override // com.bytedance.android.live.livepkaudience.emoji.panel.g
    public final void e(View r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        this.f81981a.g();
    }

    public j(f r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "action");
        Intrinsics.checkNotNullParameter(r101, "title");
        super(r100);
        this.f81983b = r101;
    }
}
