package com.alipay.android.phone.mrpc.core;

import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/* JADX INFO: loaded from: classes28.dex */
public final class m extends FutureTask<u> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ q f25036a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ l f25037b;

    public m(l r100, Callable r101, q r102) {
        this.f25037b = r100;
        this.f25036a = r102;
        super(r101);
    }

    @Override // java.util.concurrent.FutureTask
    public final void done() {
        o r100 = this.f25036a.a();
        if (r100.f() != null) goto L33;
        super.done();
        return;
    L33:
        get();     // Catch: Throwable -> L16 CancellationException -> L19 ExecutionException -> L21 InterruptedException -> L30
        if (isCancelled() == false) goto L9;
    L10:
        r100.g();     // Catch: Throwable -> L16 CancellationException -> L19 ExecutionException -> L21 InterruptedException -> L30
        if (isCancelled() == true) goto L13;
    L14:
        cancel(false);     // Catch: Throwable -> L16 CancellationException -> L19 ExecutionException -> L21 InterruptedException -> L30
        return;
    L13:
        if (isDone() == false) goto L14;
        return;
    L9:
        if (r100.h() == true) goto L10;
        return;
    L30:
        e = move-exception;
        e.toString();
        return;
    L19:
        r100.g();
        return;
    L21:
        e = move-exception;
        if (e.getCause() != null) goto L25;
    L28:
        e.toString();
        return;
    L25:
        if ((e.getCause() instanceof HttpException) == false) goto L28;
        HttpException r101 = (HttpException) e.getCause();
        r101.getCode();
        r101.getMsg();
        return;
    L16:
        th = move-exception;
        throw new RuntimeException("An error occured while executing http request", th);
    }
}
