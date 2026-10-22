package com.bytedance.apm6.consumer.slardar.send;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class e extends cv3.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ f f190734d;

    public final void a() {
        long r100 = System.currentTimeMillis();
        f r101 = this.f190734d;
        if ((r100 - r101.f190738d) < r101.f190737c) goto L12;
        r101.getClass();     // Catch: Throwable -> L6
        f.c(this.f190734d);     // Catch: Throwable -> L6
    L8:
        f r102 = this.f190734d;
        r102.f190738d = System.currentTimeMillis();
        return;
    L6:
        th = move-exception;
        List<String> r103 = mt3.a.f515607a;
        av3.b.c("APM-Slardar", "send", th);
        goto L8
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

    public e(f r100) {
        this.f190734d = r100;
        super(0, 30000);
    }
}
