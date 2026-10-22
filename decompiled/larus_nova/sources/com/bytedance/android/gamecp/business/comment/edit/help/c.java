package com.bytedance.android.gamecp.business.comment.edit.help;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes44.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f52133a;

    public c(d r100) {
        this.f52133a = r100;
    }

    public final void a() {
        int[] r100 = new int[2];
        this.f52133a.f52137d.getLocationInWindow(r100);
        d r101 = this.f52133a;
        r101.f52135b = new e(r101.f52137d.getHeight(), r100[1] + this.f52133a.f52137d.getHeight());
        this.f52133a.f52138e.invoke().intValue();
        this.f52133a.f52134a = true;
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
