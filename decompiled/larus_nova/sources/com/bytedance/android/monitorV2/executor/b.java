package com.bytedance.android.monitorV2.executor;

import com.bytedance.android.monitorV2.util.f;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes12.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f163037a;

    public b(Function0<Unit> r100) {
        this.f163037a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f163037a.invoke();     // Catch: Throwable -> L4 Exception -> L6
    L13:
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L17;
        throw th;
    L17:
        return;
    L6:
        e = move-exception;
        f.b(e);     // Catch: Throwable -> L4
        goto L13
    }
}
