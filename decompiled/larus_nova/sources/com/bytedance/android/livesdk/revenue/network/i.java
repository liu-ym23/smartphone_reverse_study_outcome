package com.bytedance.android.livesdk.revenue.network;

import com.bytedance.android.livehostapi.foundation.depend.LiveCall;
import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class i<T, R> implements c<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LiveCall<T> f157226a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<T, R> f157227b;

    public final R a() {
        T r100 = this.f157226a.execute();
        return this.f157227b.invoke(r100);
    }

    @Override // com.bytedance.android.livesdk.revenue.network.c
    public final void cancel() {
        this.f157226a.cancel();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public i(LiveCall<T> r100, Function1<? super T, ? extends R> r101) {
        Intrinsics.checkNotNullParameter(r100, PlayerResolution.SDKKEY.ORIGIN);
        Intrinsics.checkNotNullParameter(r101, "transformValue");
        this.f157226a = r100;
        this.f157227b = r101;
    }
}
