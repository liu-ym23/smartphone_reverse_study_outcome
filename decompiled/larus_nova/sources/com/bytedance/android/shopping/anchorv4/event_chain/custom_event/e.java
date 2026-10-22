package com.bytedance.android.shopping.anchorv4.event_chain.custom_event;

import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes12.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1 f166558a;

    public e(Function1 r100) {
        this.f166558a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Function1 r100 = this.f166558a;     // Catch: Throwable -> L4
        int r101 = com.bytedance.kmp.ec.yata.chain.event.b.f251281h;     // Catch: Throwable -> L4
        r100.invoke(com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
