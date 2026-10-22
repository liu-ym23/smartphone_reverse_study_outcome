package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo;

import io.reactivex.disposables.CompositeDisposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class c0 implements com.bytedance.android.scope.o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompositeDisposable f128310a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.android.livesdk.gift.platform.core.giftlist.i f128311b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final i0 f128312c;

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
        this.f128310a.clear();
    }

    public c0(com.bytedance.android.livesdk.gift.platform.core.giftlist.i r100, i0 r101) {
        Intrinsics.checkNotNullParameter(r100, "giftListRepository");
        Intrinsics.checkNotNullParameter(r101, "giftReceiverService");
        this.f128311b = r100;
        this.f128312c = r101;
        this.f128310a = new CompositeDisposable();
    }
}
