package com.bytedance.android.live.network.impl.interceptor;

/* JADX INFO: loaded from: classes46.dex */
public final class j implements t80.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ t80.a f83875a;

    public j() {
        this.f83875a = null;
    }

    @Override // t80.a
    public final void onVerifyResult(int r100) {
        t80.a r101 = this.f83875a;
        if (r101 == null) goto L6;
        r101.onVerifyResult(r100);
        return;
    }
}
