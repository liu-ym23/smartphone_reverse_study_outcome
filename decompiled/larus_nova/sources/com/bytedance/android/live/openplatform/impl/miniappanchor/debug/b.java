package com.bytedance.android.live.openplatform.impl.miniappanchor.debug;

import com.bytedance.android.live.broadcastgame.api.opengame.qrcode.IQRCodeService;

/* JADX INFO: loaded from: classes46.dex */
public final class b implements IQRCodeService.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DebugMenuDialog f84361a;

    public b(DebugMenuDialog r100) {
        this.f84361a = r100;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.opengame.qrcode.IQRCodeService.b
    public final boolean b(int r100) {
        return this.f84361a.f84345b.b(r100);
    }

    @Override // com.bytedance.android.live.broadcastgame.api.opengame.qrcode.IQRCodeService.b
    public final boolean c(String r100) {
        return this.f84361a.f84345b.c(r100);
    }
}
