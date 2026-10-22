package com.bytedance.android.ec.core.arch.lifecycle;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayDeque;
import kotlin.coroutines.CoroutineContext;

/* JADX INFO: loaded from: classes43.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f43841a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CoroutineContext f43842b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Runnable f43843c;

    public a(b r100, CoroutineContext r101, Runnable r102) {
        this.f43841a = r100;
        this.f43842b = r101;
        this.f43843c = r102;
    }

    @Override // java.lang.Runnable
    public final void run() {
        b r100 = this.f43841a;     // Catch: Throwable -> L7
        Runnable r101 = this.f43843c;     // Catch: Throwable -> L7
        if (((ArrayDeque) r100.f43847d).offer(r101) == false) goto L6;
        r100.a();     // Catch: Throwable -> L7
        return;
    L6:
        throw new IllegalStateException("cannot enqueue any more runnables".toString());     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
