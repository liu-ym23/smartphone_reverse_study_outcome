package com.bytedance.android.live.browser.jsbridge.newmethods;

/* JADX INFO: loaded from: classes45.dex */
public final class z3 implements o60.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a4 f63745a;

    public z3(a4 r100) {
        this.f63745a = r100;
    }

    @Override // o60.e
    public final void onPermissionDenied(String... r100) {
        this.f63745a.finishWithFailure();
    }

    @Override // o60.e
    public final void onPermissionGrant(String... r100) {
        this.f63745a.k();
    }
}
