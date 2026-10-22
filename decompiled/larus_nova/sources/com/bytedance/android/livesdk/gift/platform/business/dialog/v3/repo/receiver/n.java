package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver;

import io.reactivex.disposables.Disposable;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes9.dex */
public final class n implements Disposable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f128493a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b0 f128494b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ b0 f128495c;

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        b0 r100 = this.f128494b;
        if (r100 == null) goto L7;
        Function0<Unit> r101 = r100.f128455b;
        if (r101 == null) goto L7;
        Unit r102 = r101.invoke();
    L7:
        b0 r103 = this.f128495c;
        if (r103 == null) goto L12;
        Function0<Unit> r104 = r103.f128455b;
        if (r104 == null) goto L12;
        Unit r105 = r104.invoke();
    L12:
        this.f128493a = true;
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        return this.f128493a;
    }

    public n(b0 r100, b0 r101) {
        this.f128494b = r100;
        this.f128495c = r101;
    }
}
