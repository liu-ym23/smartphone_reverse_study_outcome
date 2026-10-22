package com.bytedance.android.live.profit.scoreboard;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class ScoreboardApiClient implements com.bytedance.android.scope.o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f88798a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final yz0.k f88799b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.bytedance.android.livesdk.revenue.service.broadcast.a f88800c;

    public final ScoreboardApi a() {
        return (ScoreboardApi) this.f88798a.getValue();
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    public ScoreboardApiClient(yz0.k r100, com.bytedance.android.livesdk.revenue.service.broadcast.a r101) {
        Intrinsics.checkNotNullParameter(r100, "roomDataService");
        Intrinsics.checkNotNullParameter(r101, "gameService");
        this.f88799b = r100;
        this.f88800c = r101;
        this.f88798a = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new ScoreboardApiClient$api$2(this));
    }
}
