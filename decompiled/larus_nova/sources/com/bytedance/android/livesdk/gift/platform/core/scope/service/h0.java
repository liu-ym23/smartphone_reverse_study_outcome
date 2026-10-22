package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class h0 extends lq2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g0 f131577a;

    public h0(g0 r100) {
        this.f131577a = r100;
    }

    @Override // lq2.b
    public final void b(Map r100, lq2.c r101) {
        Intrinsics.checkNotNullParameter(r100, "basePerformanceInfo");
        Intrinsics.checkNotNullParameter(r101, "monitor");
        this.f131577a.f131559b.setValue(Boolean.FALSE);
    }

    @Override // lq2.b
    public final boolean a(int r100, Map r101, lq2.c r102) {
        Intrinsics.checkNotNullParameter(r101, "basePerformanceInfo");
        Intrinsics.checkNotNullParameter(r102, "monitor");
        this.f131577a.f131559b.setValue(Boolean.TRUE);
        return false;
    }
}
