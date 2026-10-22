package com.bytedance.android.livesdk.widget.monitor;

import com.bytedance.android.live.core.log.ALogger;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Map;

/* JADX INFO: loaded from: classes11.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f161846a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f161847b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f161848c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Map f161849d;

    public b(a r100, String r101, String r102, Map r103) {
        this.f161846a = r100;
        this.f161847b = r101;
        this.f161848c = r102;
        this.f161849d = r103;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String r100 = this.f161847b;     // Catch: Throwable -> L4
        a r101 = this.f161846a;     // Catch: Throwable -> L4
        String r102 = this.f161848c;     // Catch: Throwable -> L4
        Map r103 = this.f161849d;     // Catch: Throwable -> L4
        r101.getClass();     // Catch: Throwable -> L4
        ALogger.i(r100, a.a(r100, r102, r103));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
