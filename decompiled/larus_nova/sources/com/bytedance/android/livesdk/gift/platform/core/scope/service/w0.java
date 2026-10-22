package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class w0 implements com.bytedance.android.scope.o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f131820a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final yz0.g f131821b;

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    public w0(yz0.g r100) {
        Intrinsics.checkNotNullParameter(r100, "roomDataService");
        this.f131821b = r100;
        this.f131820a = r100.getUser().getIdString() + com.bytedance.live.kmp.util.e.b();
    }
}
