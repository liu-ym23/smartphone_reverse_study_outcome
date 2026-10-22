package com.bytedance.android.shopping.anchorv4.voavhs.base.components;

import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes13.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function0 f167824a;

    public a(Function0 r100) {
        this.f167824a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Function0 r100 = this.f167824a;     // Catch: Throwable -> L6
        if (r100 == null) goto L9;
        Unit r101 = (Unit) r100.invoke();     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
