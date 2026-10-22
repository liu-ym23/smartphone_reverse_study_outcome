package com.bytedance.android.livesdk.interactivity.zdanmaku.binder;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class m implements com.bytedance.android.livesdk.interactivity.api.publicscreen.e, nf6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.android.livesdk.interactivity.api.publicscreen.e f141552a;

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.e
    public final long c() {
        return this.f141552a.c();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.e
    public final long getReceiveTime() {
        return this.f141552a.getReceiveTime();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.e
    public final boolean isSelfSendFake() {
        return this.f141552a.isSelfSendFake();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.e
    public final boolean isSendReview() {
        return this.f141552a.isSendReview();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.e
    public final String j() {
        return this.f141552a.j();
    }

    public m(com.bytedance.android.livesdk.interactivity.api.publicscreen.e r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        this.f141552a = r100;
    }
}
