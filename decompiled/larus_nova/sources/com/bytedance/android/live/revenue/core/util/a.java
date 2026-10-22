package com.bytedance.android.live.revenue.core.util;

import java.util.concurrent.CancellationException;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;

/* JADX INFO: loaded from: classes47.dex */
public final class a implements Continuation<Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AsyncService f91034a;

    @Override // kotlin.coroutines.Continuation
    public CoroutineContext getContext() {
        return this.f91034a.f91030a;
    }

    public a(AsyncService r100) {
        this.f91034a = r100;
    }

    @Override // kotlin.coroutines.Continuation
    public final void resumeWith(Object r100) {
        Throwable r101 = Result.m9452exceptionOrNullimpl(r100);
        if (r101 != null) goto L5;
        return;
    L5:
        if ((r101 instanceof CancellationException) == true) goto L9;
        throw r101;
    }
}
