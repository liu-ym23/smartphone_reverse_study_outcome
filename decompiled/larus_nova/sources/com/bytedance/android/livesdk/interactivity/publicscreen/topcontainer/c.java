package com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.PriorityQueue;

/* JADX INFO: loaded from: classes9.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PSTopContainer f139705a;

    public c(PSTopContainer r100) {
        this.f139705a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        PSTopContainer.a r100 = (PSTopContainer.a) ((PriorityQueue) this.f139705a.f139680j.getValue()).poll();     // Catch: Throwable -> L6
        if (r100 == null) goto L9;
        this.f139705a.w(r100);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
