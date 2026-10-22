package com.bytedance.applet.base;

import f2.j;

/* JADX INFO: loaded from: classes14.dex */
public final class b implements f09.a.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g2.c f191456a;

    @Override // f09.a.b
    public final void onAllActivityDestroyed() {
        this.f191456a.onAllActivityDestroyed();
    }

    @Override // f09.a.b
    public final void onAppBackground() {
        this.f191456a.onAppBackground();
    }

    @Override // f09.a.b
    public final void onAppForeground() {
        this.f191456a.onAppForeground();
    }

    public b(j r100) {
        this.f191456a = r100;
    }
}
