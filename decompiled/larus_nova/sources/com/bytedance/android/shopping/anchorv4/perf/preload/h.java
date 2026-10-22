package com.bytedance.android.shopping.anchorv4.perf.preload;

import com.bytedance.android.shopping.anchorv4.dto.PackParsedDTO;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes12.dex */
public final class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PdpPreloadController.c f167321a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ PreloadDataDTO f167322b;

    public h(PdpPreloadController.c r100, PreloadDataDTO r101) {
        this.f167321a = r100;
        this.f167322b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Function1<? super PackParsedDTO, Unit> r100 = this.f167321a.f167290a.f167284b;     // Catch: Throwable -> L6
        if (r100 == null) goto L9;
        Unit r101 = r100.invoke(this.f167322b.getData());     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
