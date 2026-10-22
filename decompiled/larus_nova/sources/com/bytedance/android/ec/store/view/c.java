package com.bytedance.android.ec.store.view;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes44.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ECScrollTagListView f48928a;

    public c(ECScrollTagListView r100) {
        this.f48928a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ECScrollTagListView r100 = this.f48928a;     // Catch: Throwable -> L4
        r100.f48725b = true;     // Catch: Throwable -> L4
        r100.a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
