package com.bytedance.android.live.browser.jsbridge.newmethods;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class ld implements zg1.q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ id f63549a;

    public ld(id r100) {
        this.f63549a = r100;
    }

    @Override // zg1.q
    public final void onResult(boolean r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "failMsg");
        if (r100 == false) goto L5;
        this.f63549a.finishWithSuccess();
        return;
    L5:
        this.f63549a.finishWithFailure();
    }
}
