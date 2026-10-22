package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.disposables.Disposable;

/* JADX INFO: loaded from: classes9.dex */
public final class y0 implements Disposable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f131841a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ a1 f131842b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Observer f131843c;

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        this.f131842b.f131450c.removeObserver("data_link_state", this.f131843c);
        this.f131841a = true;
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        return this.f131841a;
    }

    public y0(a1 r100, z0 r101) {
        this.f131842b = r100;
        this.f131843c = r101;
    }
}
