package com.bytedance.android.ec.hybrid.popup;

import com.larus.apm.impl.protector.RunnableProtector;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class l implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference<g> f47597a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final WeakReference<ECPopupManager> f47598b;

    @Override // java.lang.Runnable
    public final void run() {
        g r100 = this.f47597a.get();     // Catch: Throwable -> L13
        if (r100 != null) goto L8;
        ECPopupManager r101 = this.f47598b.get();     // Catch: Throwable -> L13
        if (r101 == null) goto L18;
        r101.j(true);     // Catch: Throwable -> L13
    L18:
        return;
    L8:
        if (r100.next() == true) goto L18;
        ECPopupManager r102 = this.f47598b.get();     // Catch: Throwable -> L13
        if (r102 == null) goto L18;
        r102.j(true);     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L21;
        throw th;
    }

    public l(g r100, ECPopupManager r101) {
        Intrinsics.checkNotNullParameter(r100, "group");
        Intrinsics.checkNotNullParameter(r101, "manager");
        this.f47597a = new WeakReference(r100);
        this.f47598b = new WeakReference(r101);
    }
}
