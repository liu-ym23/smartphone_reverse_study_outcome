package com.bytedance.android.live.livepkaudience.seat;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class g implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SeatAnimTaskState f82241a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public d f82242b;

    public g() {
        this.f82241a = SeatAnimTaskState.IDLE;
        this.f82242b = new d();
    }

    @Override // com.bytedance.android.live.livepkaudience.seat.b
    public final void a(SeatAnimTaskState r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        this.f82241a = r100;
    }
}
