package com.bytedance.android.ec.core.utils.font;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes43.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f45594a = null;

    static {
        f45594a = new d();
    }

    public d() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        ECFontHelper.f45592e.a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
