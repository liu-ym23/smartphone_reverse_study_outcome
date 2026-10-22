package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo;

import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.RefreshGiftMostlyUsedStatus;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes9.dex */
public final class z<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c0 f128585a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f128586b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f128587c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f128588d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ long f128589e;

    public z(c0 r100, long r101, int r102, int r103, long r104) {
        this.f128585a = r100;
        this.f128586b = r101;
        this.f128587c = r102;
        this.f128588d = r103;
        this.f128589e = r104;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        c0 r102 = this.f128585a;
        long r103 = this.f128586b;
        int r104 = this.f128587c;
        int r105 = this.f128588d;
        r102.getClass();
        uz1.a r106 = com.bytedance.android.livesdk.gift.platform.core.utils.b0.b();
        if (r106 == null) goto L5;
        r106.a(new RefreshGiftMostlyUsedStatus(r103, r104, r105, false));
    L5:
        com.bytedance.android.livesdk.gift.platform.core.b0.f130471a.d(this.f128586b, this.f128589e, this.f128587c, r101);
    }
}
