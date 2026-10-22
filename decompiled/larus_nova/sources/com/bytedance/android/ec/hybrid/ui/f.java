package com.bytedance.android.ec.hybrid.ui;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes44.dex */
public final class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ECMarqueeUIWidget f47701a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d f47702b;

    public f(ECMarqueeUIWidget r100, d r101) {
        this.f47701a = r100;
        this.f47702b = r101;
    }

    public final void a() {
        ECMarqueeUIWidget r100 = this.f47701a;
        ECMarqueeUIWidget.a(r100, r100.f47669a, this.f47702b.f47697e);
        ECMarqueeUIWidget r101 = this.f47701a;
        ECMarqueeUIWidget.a(r101, r101.f47670b, this.f47702b.f47697e);
        ECMarqueeUIWidget r102 = this.f47701a;
        ECMarqueeUIWidget.a(r102, r102.f47671c, this.f47702b.f47697e);
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
