package com.bytedance.android.live.revenue.platform.container.impl;

import io.reactivex.disposables.CompositeDisposable;

/* JADX INFO: loaded from: classes47.dex */
public final class i0 implements com.bytedance.platform.aio.channel.b.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CompositeDisposable f91282a;

    @Override // com.bytedance.platform.aio.channel.b.a
    public final void b(boolean r100) {
    }

    @Override // com.bytedance.platform.aio.channel.b.a
    public final void a() {
        this.f91282a.dispose();
    }

    public i0(CompositeDisposable r100) {
        this.f91282a = r100;
    }
}
