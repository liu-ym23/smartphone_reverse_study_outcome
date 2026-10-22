package com.bytedance.android.ec.opt.prerender;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes44.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PrerenderDialog f48093a;

    public a(PrerenderDialog r100) {
        this.f48093a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        PrerenderDialog r100 = this.f48093a;     // Catch: Throwable -> L7
        r100.f48073f = null;     // Catch: Throwable -> L7
        r100.f48071d = false;     // Catch: Throwable -> L7
        PrerenderDialog.b r101 = r100.f48080m;     // Catch: Throwable -> L7
        if (r101 == null) goto L5;
        r101.ue();     // Catch: Throwable -> L7
    L5:
        PrerenderDialog.J0(this.f48093a);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L11;
        return;
    L11:
        throw th;
    }
}
