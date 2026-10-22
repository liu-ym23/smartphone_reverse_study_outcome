package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import io.reactivex.disposables.Disposable;

/* JADX INFO: loaded from: classes9.dex */
public final class d0 implements com.bytedance.android.scope.o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f131494a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f131495b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Disposable f131496c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Disposable f131497d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public r2 f131498e;

    public d0() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    public final void a() {
        this.f131495b = 0;
        Disposable r100 = this.f131497d;
        if (r100 == null) goto L5;
        r100.dispose();
    L5:
        this.f131497d = null;
        this.f131494a = null;
        r2 r101 = this.f131498e;
        if (r101 == null) goto L9;
        r101.onEnd();
        return;
    }

    public final void c() {
        Disposable r100 = this.f131496c;
        if (r100 == null) goto L5;
        r100.dispose();
    L5:
        this.f131496c = null;
        r2 r101 = this.f131498e;
        if (r101 == null) goto L9;
        r101.onEnd();
        return;
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
        c();
        a();
    }
}
