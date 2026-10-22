package com.bytedance.android.livesdk.jsbridge.methods;

import com.bytedance.android.live.base.model.user.IBaseUser;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/* JADX INFO: loaded from: classes9.dex */
public final class x1 implements Observer<IBaseUser> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f142239a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ z1 f142240b;

    @Override // io.reactivex.Observer
    public final void onComplete() {
    }

    @Override // io.reactivex.Observer
    public final void onError(Throwable r100) {
        if (this.f142239a == false) goto L5;
        this.f142240b.finishWithResult(new z1.b(2));
        return;
    L5:
        this.f142240b.finishWithFailure(r100);
    }

    @Override // io.reactivex.Observer
    public final void onNext(IBaseUser r100) {
        if (this.f142239a == false) goto L5;
        this.f142240b.finishWithResult(new z1.b(1));
        return;
    L5:
        this.f142240b.finishWithSuccess();
    }

    @Override // io.reactivex.Observer
    public final void onSubscribe(Disposable r100) {
        this.f142240b.f142258a = r100;
    }

    public x1(z1 r100, boolean r101) {
        this.f142240b = r100;
        this.f142239a = r101;
    }
}
