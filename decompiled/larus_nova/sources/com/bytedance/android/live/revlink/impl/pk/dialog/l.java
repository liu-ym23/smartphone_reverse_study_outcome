package com.bytedance.android.live.revlink.impl.pk.dialog;

import com.bytedance.android.live.core.utils.s1;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes47.dex */
public final class l implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ m f95980a;

    public l(m r100) {
        this.f95980a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        PkRandomMatchDialogV2.T90(this.f95980a.f95981a, s1.f(484.0f));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
