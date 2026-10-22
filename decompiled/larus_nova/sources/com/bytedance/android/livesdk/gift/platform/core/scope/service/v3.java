package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import com.bytedance.android.livesdk.revenue.service.effect.RevStickerPanel;

/* JADX INFO: loaded from: classes9.dex */
public final class v3<T1, T2> implements ttc.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ w3 f131816a;

    public v3(w3 r100) {
        this.f131816a = r100;
    }

    @Override // ttc.a
    public final void accept(Object r100, Object r101) {
        Throwable r102 = (Throwable) r101;
        w3 r103 = this.f131816a;
        com.bytedance.android.livesdk.revenue.service.effect.c r104 = r103.f131834a.f131879g;
        RevStickerPanel r105 = RevStickerPanel.EFFECT_ATMOSPHERE;
        com.bytedance.android.livesdk.revenue.service.effect.c.a.a(r104, r105, (yp2.b) r100, r103.f131835b, 8);
    }
}
