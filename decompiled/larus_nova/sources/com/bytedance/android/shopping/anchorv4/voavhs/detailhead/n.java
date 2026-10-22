package com.bytedance.android.shopping.anchorv4.voavhs.detailhead;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.List;

/* JADX INFO: loaded from: classes13.dex */
public final class n implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AnchorV4DetailSkuPropertiesFragment f168243a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ List f168244b;

    public n(AnchorV4DetailSkuPropertiesFragment r100, List r101) {
        this.f168243a = r100;
        this.f168244b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ExpandableLinearLayoutV4 r100 = this.f168243a.f168188j;     // Catch: Throwable -> L6
        if (r100 == null) goto L9;
        r100.b();     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
