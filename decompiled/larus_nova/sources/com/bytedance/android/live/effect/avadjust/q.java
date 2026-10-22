package com.bytedance.android.live.effect.avadjust;

import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes45.dex */
public final class q implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l.b f66890a;

    public q(l.b r100, Sticker r101) {
        this.f66890a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        l.b r100 = this.f66890a;     // Catch: Throwable -> L6
        if (r100 == null) goto L9;
        r100.onSuccess();     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
