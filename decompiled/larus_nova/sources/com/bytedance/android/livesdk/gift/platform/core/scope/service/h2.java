package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import com.ss.android.socialbase.appdownloader.util.parser.zip.UnixStat;

/* JADX INFO: loaded from: classes9.dex */
public final class h2 implements m97.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ GiftResourceFileCacheService f131579a;

    public h2(GiftResourceFileCacheService r100) {
        this.f131579a = r100;
    }

    @Override // m97.b
    public final void onEvent(int r100, String r101) {
        int r102 = r100 & UnixStat.PERM_MASK;
        if (r102 != 512) goto L14;
        if (r101 != null) goto L6;
    L9:
        boolean r103 = true;
    L10:
        if (r103 == true) goto L15;
        if (r102 != 512) goto L16;
        this.f131579a.f131396c.remove(r101);
        return;
    L16:
        return;
    L15:
        return;
    L6:
        if (r101.length() == 0) goto L9;
        r103 = false;
        goto L10
    }
}
