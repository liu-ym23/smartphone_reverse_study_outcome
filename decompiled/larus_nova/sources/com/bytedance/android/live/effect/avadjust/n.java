package com.bytedance.android.live.effect.avadjust;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.List;

/* JADX INFO: loaded from: classes45.dex */
public final class n implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ List f66885a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ l.c f66886b;

    public n(List r100, l.c r101) {
        this.f66885a = r100;
        this.f66886b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        List r100 = this.f66885a;     // Catch: Throwable -> L13
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L11;
        this.f66886b.onError();     // Catch: Throwable -> L13
        return;
    L11:
        this.f66886b.onSuccess(this.f66885a);     // Catch: Throwable -> L13
        return;
    L5:
        if (r100.isEmpty() == true) goto L8;
        r101 = false;
    L13:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L19;
        throw th;
    }
}
