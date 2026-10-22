package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo;

import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.RefreshMostlyUsedTabPinTopStatus;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes9.dex */
public final class b0<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f128304a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f128305b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f128306c;

    public b0(int r100, int r101, long r102) {
        this.f128304a = r100;
        this.f128305b = r101;
        this.f128306c = r102;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        int r102 = 1;
        if (this.f128304a != 1) goto L5;
        r102 = 2;
    L5:
        uz1.a r103 = com.bytedance.android.livesdk.gift.platform.core.utils.b0.b();
        if (r103 == null) goto L8;
        r103.a(new RefreshMostlyUsedTabPinTopStatus(r102, this.f128305b));
    L8:
        com.bytedance.android.livesdk.gift.platform.core.b0.f130471a.e(this.f128304a, this.f128306c, null, r101);
    }
}
