package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo;

import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.livesdk.gift.model.d3;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.RefreshMostlyUsedTabPinTopStatus;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes9.dex */
public final class a0<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f128297a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f128298b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f128299c;

    public a0(int r100, int r101, long r102) {
        this.f128297a = r100;
        this.f128298b = r101;
        this.f128299c = r102;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r110) {
        ExtraResponse r111 = (ExtraResponse) r110;
        uz1.a r100 = com.bytedance.android.livesdk.gift.platform.core.utils.b0.b();
        if (r100 == null) goto L5;
        r100.a(new RefreshMostlyUsedTabPinTopStatus((int) ((d3) r111.data).getSortStrategy(), this.f128297a));
    L5:
        com.bytedance.android.livesdk.gift.platform.core.b0.f130471a.e(this.f128298b, this.f128299c, Long.valueOf(((d3) r111.data).getSortStrategy()), null);
    }
}
