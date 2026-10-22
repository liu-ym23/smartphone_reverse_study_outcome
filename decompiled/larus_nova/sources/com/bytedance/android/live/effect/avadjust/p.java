package com.bytedance.android.live.effect.avadjust;

import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes45.dex */
public final class p implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l f66888a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Sticker f66889b;

    public p(l r100, Sticker r101) {
        this.f66888a = r100;
        this.f66889b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f66888a.d(this.f66889b);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
