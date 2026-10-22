package com.bytedance.android.ec.hybrid.card.impl;

import com.bytedance.android.anniex.ui.AnnieXLynxView;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes44.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AnnieXLynxView f46524a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ra.a f46525b;

    public a(AnnieXLynxView r100, ra.a r101) {
        this.f46524a = r100;
        this.f46525b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f46524a.L(this.f46525b);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
