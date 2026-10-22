package com.bytedance.android.live.effect.sticker.presenter;

import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes45.dex */
public final class m0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ o.c f68347a;

    public m0(o.c r100, Sticker r101) {
        this.f68347a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        o.c r100 = this.f68347a;     // Catch: Throwable -> L6
        if (r100 == null) goto L9;
        r100.b();     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
