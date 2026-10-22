package com.bytedance.android.livesdk.gecko;

import com.bytedance.geckox.listener.GeckoUpdateListener;
import com.bytedance.geckox.model.UpdatePackage;

/* JADX INFO: loaded from: classes8.dex */
public final class g extends f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final xo2.c.a f125803b;

    public g(GeckoUpdateListener r100, xo2.c.a r101) {
        super(r100);
        this.f125803b = r101;
    }

    @Override // com.bytedance.geckox.listener.GeckoUpdateListener
    public final void onDownloadProgress(UpdatePackage r100, long r101, long r110) {
        super.onDownloadProgress(r100, r101, r110);
        xo2.c.a r102 = this.f125803b;
        if (r102 == null) goto L6;
        r102.a(r100, r101, r110);
        return;
    }
}
