package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import io.reactivex.disposables.Disposable;

/* JADX INFO: loaded from: classes9.dex */
public final class n implements com.bytedance.android.scope.o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Disposable f131645a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f131646b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public r2 f131647c;

    public n() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    public final void a() {
        this.f131646b = 0;
        Disposable r100 = this.f131645a;
        if (r100 == null) goto L5;
        r100.dispose();
    L5:
        this.f131645a = null;
        r2 r101 = this.f131647c;
        if (r101 == null) goto L9;
        r101.onEnd();
        return;
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
        a();
    }
}
