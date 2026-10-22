package com.bytedance.android.livesdk.jsbridge.methods;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class h1 implements km3.g.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d1 f142126a;

    public h1(d1 r100) {
        this.f142126a = r100;
    }

    @Override // km3.g.a
    public final void onClose() {
        d1 r100 = this.f142126a;
        Disposable r101 = r100.f142067d;
        if (r101 == null) goto L6;
        CompositeDisposable r102 = r100.f142066c;
        Intrinsics.checkNotNull(r101);
        r102.remove(r101);
        r100.f142067d = null;
        return;
    }
}
