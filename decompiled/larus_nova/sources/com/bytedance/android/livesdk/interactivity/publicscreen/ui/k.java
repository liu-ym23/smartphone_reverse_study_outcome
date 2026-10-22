package com.bytedance.android.livesdk.interactivity.publicscreen.ui;

import com.bytedance.android.livesdk.interactivity.api.publicscreen.s;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class k implements com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.k.a<s> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l f140254a;

    public k(l r100) {
        this.f140254a = r100;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.k.a
    public final void a(s r100, com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.j r101) {
        Intrinsics.checkNotNullParameter(r100, "message");
        Intrinsics.checkNotNullParameter(r101, "rendResult");
        this.f140254a.f140256b.setText(r101.f133515a);
    }
}
