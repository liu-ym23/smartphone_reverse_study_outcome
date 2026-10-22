package com.bytedance.android.live.livepkaudience.emoji.panel;

import android.view.View;
import com.bytedance.android.live.core.setting.b6;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.larus.nova.R;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class h extends g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f81982b;

    @Override // com.bytedance.android.live.livepkaudience.emoji.panel.g
    public final int c() {
        com.bytedance.android.live.livepkaudience.vm.c.A0.getClass();
        com.bytedance.android.live.livepkaudience.vm.c r100 = com.bytedance.android.live.livepkaudience.vm.c.a.a();
        if (r100 == null) goto L9;
        if (r100.a() == true) goto L9;
        return R.drawable.ttlive_icon_talk_camera_closed_cool;
    L9:
        if (this.f81982b == false) goto L12;
        return R.drawable.ttlive_icon_talk_camera_closed;
    L12:
        return R.drawable.ttlive_icon_talk_open_camera;
    }

    @Override // com.bytedance.android.live.livepkaudience.emoji.panel.g
    public final String d() {
        if (b6.f65236h.getValue().booleanValue() == false) goto L5;
    L8:
        com.bytedance.android.live.livepkaudience.vm.c.A0.getClass();
        com.bytedance.android.live.livepkaudience.vm.c r100 = com.bytedance.android.live.livepkaudience.vm.c.a.a();
        if (r100 == null) goto L15;
        if (r100.a() == true) goto L15;
        return s1.B(R.string.ttlive_interact_camera_beclosed);
    L15:
        if (this.f81982b == false) goto L19;
        return s1.B(R.string.ttlive_interact_close_camera);
    L19:
        return s1.B(R.string.ttlive_interact_open_camera);
    L5:
        if (this.f81982b == true) goto L8;
        return s1.B(R.string.ttlive_interact_open_camera);
    }

    @Override // com.bytedance.android.live.livepkaudience.emoji.panel.g
    public final void e(View r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        com.bytedance.android.live.livepkaudience.vm.c.A0.getClass();
        com.bytedance.android.live.livepkaudience.vm.c r101 = com.bytedance.android.live.livepkaudience.vm.c.a.a();
        if (r101 != null) goto L5;
    L8:
        f r102 = this.f81981a;
        if (r102 == null) goto L12;
        r102.x5(!this.f81982b, false);
        return;
    L12:
        return;
    L5:
        if (r101.a() == true) goto L8;
        f2.b(R.string.ttlive_interact_anchor_close_camera, 0);
    }

    public h(f r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "action");
        super(r100);
        this.f81982b = r101;
    }
}
