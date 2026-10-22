package com.bytedance.android.shopping.orderlist.common.utils;

import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes13.dex */
public final class j implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f179971a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function0 f179972b;

    public j(String r100, Function0 r101) {
        this.f179971a = r100;
        this.f179972b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        dm.a.b r100 = dm.a.f469202a;     // Catch: Exception -> L5 Throwable -> L8
        dm.a.a("order_common_" + this.f179971a).w((String) this.f179972b.invoke(), null);     // Catch: Exception -> L5 Throwable -> L8
    L13:
        return;
    L8:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L17;
        throw th;
    L17:
        return;
    L5:
        e = move-exception;
        ECExceptionMonitor.e(e);     // Catch: Throwable -> L8
        goto L13
    }
}
