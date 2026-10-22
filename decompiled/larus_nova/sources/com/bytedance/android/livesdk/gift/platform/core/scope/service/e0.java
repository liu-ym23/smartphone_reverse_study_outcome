package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class e0 implements y2, com.bytedance.android.scope.o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ur.a f131517a;

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.scope.service.y2
    public final cy0.e getScope() {
        return this.f131517a;
    }

    public e0(ur.a r100) {
        Intrinsics.checkNotNullParameter(r100, "scope");
        this.f131517a = r100;
    }
}
