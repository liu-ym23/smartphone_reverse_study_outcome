package com.bytedance.android.livesdk.gift.platform.business.config;

import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.model.l2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public class e implements m {
    public e() {
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.config.m
    public final boolean a(boolean r100, boolean r101, boolean r102) {
        if (r100 == false) goto L7;
        if (r101 == true) goto L6;
        if (r102 == false) goto L7;
    L6:
        return false;
    L7:
        return true;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.config.m
    public final void g() {
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.config.m
    public boolean h() {
        return false;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.config.m
    public boolean j(boolean r100) {
        return false;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.config.m
    public final pz1.e d(l2 r100) {
        Intrinsics.checkNotNullParameter(r100, "prop");
        return new pz1.e(r100);
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.config.m
    public final com.bytedance.android.livesdk.gift.platform.business.dialog.ui.panel.a l(h1 r100) {
        Intrinsics.checkNotNullParameter(r100, PbRequest.SwitchType.GIFT);
        return new com.bytedance.android.livesdk.gift.platform.business.dialog.ui.panel.a(r100);
    }
}
