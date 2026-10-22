package com.bytedance.android.live.browser.jsbridge;

import com.bytedance.android.annie.api.card.IHybridComponent;

/* JADX INFO: loaded from: classes45.dex */
public final class z implements p56.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ y6.c f64146a;

    @Override // p56.b
    public final String provideContainerID() {
        IHybridComponent r100 = this.f64146a.c();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.containerId();
    }

    public z(y6.c r100) {
        this.f64146a = r100;
    }
}
