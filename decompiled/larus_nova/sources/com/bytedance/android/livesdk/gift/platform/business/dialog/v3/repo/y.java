package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo;

import com.bytedance.android.live.network.response.ExtraResponse;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes9.dex */
public final class y<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c0 f128580a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f128581b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f128582c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f128583d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f128584e;

    public y(c0 r100, long r101, long r102, int r103, int r104) {
        this.f128580a = r100;
        this.f128581b = r101;
        this.f128582c = r102;
        this.f128583d = r103;
        this.f128584e = r104;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r110) {
        ExtraResponse r111 = (ExtraResponse) r110;
        c0 r112 = this.f128580a;
        long r100 = this.f128581b;
        int r101 = this.f128583d;
        int r102 = this.f128584e;
        r112.f128311b.N(r100, r102, r101, r112.f128312c.a());
        com.bytedance.android.livesdk.gift.platform.core.b0.f130471a.d(this.f128581b, this.f128582c, this.f128583d, null);
    }
}
