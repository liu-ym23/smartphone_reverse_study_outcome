package com.bytedance.android.livesdk.gift.vs.panel.viewholder;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes9.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ VSGiftDialogViewHolder f132514a;

    public b(VSGiftDialogViewHolder r100) {
        this.f132514a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        VSGiftDialogViewHolder r100 = this.f132514a;     // Catch: Throwable -> L4
        int r101 = VSGiftDialogViewHolder.E;     // Catch: Throwable -> L4
        r100.j4();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
