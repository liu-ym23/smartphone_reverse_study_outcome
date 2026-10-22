package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import io.reactivex.disposables.Disposable;

/* JADX INFO: loaded from: classes9.dex */
public final class m3 implements com.bytedance.android.scope.o, dy0.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f131643a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Disposable f131644b;

    public m3() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
        Disposable r100 = this.f131644b;
        if (r100 == null) goto L5;
        r100.dispose();
    L5:
        this.f131644b = null;
    }
}
