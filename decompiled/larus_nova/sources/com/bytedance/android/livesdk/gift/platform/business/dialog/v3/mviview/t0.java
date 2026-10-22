package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes9.dex */
public final class t0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f127977a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ GiftMVITabView f127978b;

    public t0(int r100, GiftMVITabView r101) {
        this.f127977a = r100;
        this.f127978b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f127978b.x(this.f127977a);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
