package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class f0 extends com.bytedance.android.livesdk.gift.platform.core.model.c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function0 f128340a;

    public f0(Function0 r100) {
        this.f128340a = r100;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.model.r
    public final void b(com.bytedance.android.livesdk.gift.platform.core.model.t r100, com.bytedance.android.livesdk.gift.platform.core.model.y r101) {
        Intrinsics.checkNotNullParameter(r100, "info");
        Intrinsics.checkNotNullParameter(r101, "response");
        if ((r101 instanceof com.bytedance.android.livesdk.gift.platform.core.model.y.c.a) == false) goto L6;
        this.f128340a.invoke();
        return;
    }
}
