package com.bytedance.android.live.effect.avadjust;

import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes45.dex */
public final class o implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l.b f66887a;

    public o(l.b r100, Sticker r101) {
        this.f66887a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f66887a.onSuccess();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
