package com.bytedance.android.livesdk.interactivity.publicscreen.ui;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class j implements com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.k.a<com.bytedance.android.livesdk.interactivity.api.entity.f<?>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l f140253a;

    public j(l r100) {
        this.f140253a = r100;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.k.a
    public final void a(com.bytedance.android.livesdk.interactivity.api.entity.f<?> r100, com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.j r101) {
        Intrinsics.checkNotNullParameter(r100, "message");
        Intrinsics.checkNotNullParameter(r101, "rendResult");
        this.f140253a.f140256b.setText(r101.f133515a);
    }
}
