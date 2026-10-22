package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo;

import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class p0 implements com.bytedance.android.scope.o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompositeDisposable f128396a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final yz0.k f128397b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final i12.e f128398c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final uz1.a f128399d;

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
        this.f128396a.clear();
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
        com.bytedance.android.live.profit.privilege.a r100 = yt0.c.i();
        if (r100 == null) goto L6;
        this.f128396a.add(RxUtilKt.h(r100.getPayGrade().a().subscribeOn(Schedulers.io())).subscribe(new o0(this)));
        return;
    }

    public p0(yz0.k r100, i12.e r101, uz1.a r102) {
        Intrinsics.checkNotNullParameter(r100, "roomDataService");
        Intrinsics.checkNotNullParameter(r101, "scope");
        Intrinsics.checkNotNullParameter(r102, "giftMVIFacade");
        this.f128397b = r100;
        this.f128398c = r101;
        this.f128399d = r102;
        this.f128396a = new CompositeDisposable();
    }
}
