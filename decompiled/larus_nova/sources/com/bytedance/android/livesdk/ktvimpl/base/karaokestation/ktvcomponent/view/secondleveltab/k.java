package com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvcomponent.view.secondleveltab;

import com.bytedance.android.live.ktv.common.model.api.z0;
import com.bytedance.android.livesdk.message.model.KtvMusic;

/* JADX INFO: loaded from: classes10.dex */
public final class k implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d f142714a;

    public k(com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r100) {
        this.f142714a = r100;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvcomponent.view.secondleveltab.e
    public final void a(z0 r100) {
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r101 = this.f142714a;
        if (r101 == null) goto L9;
        if (r100 == null) goto L6;
        KtvMusic r102 = r100.b();
    L7:
        r101.removeWantSingSong(r102);
        return;
    L6:
        r102 = null;
        goto L7
    }
}
