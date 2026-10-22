package com.bytedance.android.ec.opt.prerender;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes44.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PrerenderDialog f48094a;

    public b(PrerenderDialog r100) {
        this.f48094a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        PrerenderDialog r100 = this.f48094a;     // Catch: Throwable -> L7
        r100.f48072e = null;     // Catch: Throwable -> L7
        r100.f48071d = false;     // Catch: Throwable -> L7
        PrerenderDialog.d r101 = r100.f48081n;     // Catch: Throwable -> L7
        if (r101 == null) goto L5;
        r101.P90();     // Catch: Throwable -> L7
    L5:
        PrerenderDialog.J0(this.f48094a);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L11;
        return;
    L11:
        throw th;
    }
}
