package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class w3 implements com.bytedance.android.livesdk.revenue.service.effect.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ z3 f131834a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.livesdk.revenue.service.effect.f f131835b;

    @Override // com.bytedance.android.livesdk.revenue.service.effect.e
    public final void onFail() {
    }

    @Override // com.bytedance.android.livesdk.revenue.service.effect.e
    public final void onStart() {
    }

    @Override // com.bytedance.android.livesdk.revenue.service.effect.e
    public final void a(com.bytedance.android.livesdk.revenue.service.effect.i r100) {
        Intrinsics.checkNotNullParameter(r100, "response");
        Single r101 = this.f131834a.f131879g.Y7(r100);
        if (r101 == null) goto L10;
        Single r102 = r101.observeOn(AndroidSchedulers.mainThread());
        if (r102 == null) goto L11;
        Disposable r103 = r102.subscribe(new v3(this));
        if (r103 == null) goto L12;
        RxUtilKt.c(r103, this.f131834a.f131873a);
        return;
    L12:
        return;
    L11:
        return;
    }

    public w3(z3 r100, com.bytedance.android.livesdk.revenue.service.effect.f r101) {
        this.f131834a = r100;
        this.f131835b = r101;
    }
}
