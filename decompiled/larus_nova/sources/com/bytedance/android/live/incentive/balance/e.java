package com.bytedance.android.live.incentive.balance;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final UpdateReason f69337a;

    public e(UpdateReason r100) {
        RequestFrom r101 = RequestFrom.ExchangePanel;
        Intrinsics.checkNotNullParameter(r100, "updateReason");
        Intrinsics.checkNotNullParameter(r101, "requestFrom");
        this.f69337a = r100;
    }
}
